package net.practice.backend.mapper;

import net.practice.backend.dto.userDTO;
import net.practice.backend.entity.user;

public class userMapper {

    public static userDTO mapToUserDTO(user user){
        return new userDTO(
            user.getId(),
            user.getNombres(),
            user.getApellidos(),
            user.getEmail()
        );
    }

    public static user mapToUser(userDTO userDTO){
        return new user(
            userDTO.getId(),
            userDTO.getNombres(),
            userDTO.getApellidos(),
            userDTO.getEmail()
        );
    }

}
