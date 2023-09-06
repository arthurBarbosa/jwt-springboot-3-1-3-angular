package com.arthurbarbosa.jwt.backend.service;

import com.arthurbarbosa.jwt.backend.config.PasswordConfig;
import com.arthurbarbosa.jwt.backend.dtos.CredentialsDTO;
import com.arthurbarbosa.jwt.backend.dtos.SignUpDTO;
import com.arthurbarbosa.jwt.backend.dtos.UserDTO;
import com.arthurbarbosa.jwt.backend.entities.User;
import com.arthurbarbosa.jwt.backend.exceptions.AppException;
import com.arthurbarbosa.jwt.backend.mappers.UserMapper;
import com.arthurbarbosa.jwt.backend.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.nio.CharBuffer;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final PasswordConfig passwordEncoder;

    public UserDTO login(CredentialsDTO credentialsDTO) {
        User user = userRepository.findByLogin(credentialsDTO.login())
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        if (passwordEncoder.passwordEncoder().matches(CharBuffer.wrap(credentialsDTO.password()), user.getPassword())) {
            return userMapper.toUserDTO(user);
        }
        throw new AppException("Invalid password", HttpStatus.BAD_REQUEST);

    }

    public UserDTO findByLogin(String login) {
        User user = userRepository.findByLogin(login)
                .orElseThrow(() -> new AppException("Unknown user", HttpStatus.NOT_FOUND));
        return userMapper.toUserDTO(user);
    }

    public UserDTO register(SignUpDTO userDto) {
        Optional<User> optionalUser = userRepository.findByLogin(userDto.login());

        if (optionalUser.isPresent()) {
            throw new AppException("Login already exists", HttpStatus.BAD_REQUEST);
        }

        User user = userMapper.signUpToUser(userDto);
        user.setPassword(passwordEncoder.passwordEncoder().encode(CharBuffer.wrap(userDto.password())));

        User savedUser = userRepository.save(user);

        return userMapper.toUserDto(savedUser);

    }
}
