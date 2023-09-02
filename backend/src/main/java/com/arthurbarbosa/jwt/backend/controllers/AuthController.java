package com.arthurbarbosa.jwt.backend.controllers;

import com.arthurbarbosa.jwt.backend.dtos.CredentialsDTO;
import com.arthurbarbosa.jwt.backend.dtos.UserDTO;
import com.arthurbarbosa.jwt.backend.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class AuthController {
    private final UserService userService;

    //    private final UserAuthenticationProvider userAuthenticationProvider;
    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(CredentialsDTO credentialsDTO) {
        UserDTO user = userService.login(credentialsDTO);
        return ResponseEntity.ok(user);
    }
}
