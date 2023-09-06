package com.arthurbarbosa.jwt.backend.mappers;

import com.arthurbarbosa.jwt.backend.dtos.SignUpDTO;
import com.arthurbarbosa.jwt.backend.dtos.UserDTO;
import com.arthurbarbosa.jwt.backend.entities.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDTO toUserDTO(User user);


    @Mapping(target = "password", ignore = true)
    User signUpToUser(SignUpDTO signUpDto);

    UserDTO toUserDto(User user);
}
