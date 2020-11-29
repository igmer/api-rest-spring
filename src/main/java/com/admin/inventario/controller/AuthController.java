package com.admin.inventario.controller;

import com.admin.inventario.dto.JwtDto;
import com.admin.inventario.dto.LoginUser;
import com.admin.inventario.dto.Message;
import com.admin.inventario.dto.NewUser;
import com.admin.inventario.enums.RolName;
import com.admin.inventario.jwt.JwtProvider;
import com.admin.inventario.models.Rol;
import com.admin.inventario.models.User;
import com.admin.inventario.service.RolService;
import com.admin.inventario.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashSet;
import java.util.Set;

@RestController
@RequestMapping("/auth")
@CrossOrigin
public class AuthController {

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	UserService userService;

	@Autowired
	RolService rolService;

	@Autowired
	JwtProvider jwtProvider;
	@PreAuthorize("hasRole('ADMIN')")
	@PostMapping("/nuevo")
	public ResponseEntity<?> nuevo(@Valid @RequestBody NewUser newUser, BindingResult bindingResult) {
		try {

			if (bindingResult.hasErrors())
				return new ResponseEntity(new Message("invalid request, please check all fields"), HttpStatus.BAD_REQUEST);
			if (userService.existsByNombreUsuario(newUser.getUsername()))
				return new ResponseEntity(new Message("username already exist"), HttpStatus.BAD_REQUEST);
			if (userService.existsByEmail(newUser.getEmail()))
				return new ResponseEntity(new Message("email already exist"), HttpStatus.BAD_REQUEST);
			User user = new User(newUser.getName(), newUser.getUsername(), newUser.getEmail(),
					passwordEncoder.encode(newUser.getPassword()));
			Set<Rol> roles = new HashSet<>();
			System.out.print(RolName.ROLE_ADMIN);
			System.out.println();
			System.out.println(rolService.getByRolName(RolName.ROLE_USER).get());
			
			if (rolService.getByRolName(RolName.ROLE_USER).isPresent()) {
				roles.add(rolService.getByRolName(RolName.ROLE_USER).get());

			}

			if (newUser.getRoles().contains("admin"))
				if(rolService.getByRolName(RolName.ROLE_ADMIN).isPresent()) {
					roles.add(rolService.getByRolName(RolName.ROLE_ADMIN).get());					
				}
				
			user.setRoles(roles);
			userService.save(user);
			return new ResponseEntity(new Message("User saved successful"), HttpStatus.CREATED);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity(new Message("error" + e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping("/login")
	public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult) {
		if (bindingResult.hasErrors())
			return new ResponseEntity(new Message("invalid request, please check the fields"), HttpStatus.BAD_REQUEST);
		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginUser.getNombreUsuario(), loginUser.getPassword()));
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtProvider.generateToken(authentication);
		UserDetails userDetails = (UserDetails) authentication.getPrincipal();
		JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());
		return new ResponseEntity(jwtDto, HttpStatus.OK);
	}
}
