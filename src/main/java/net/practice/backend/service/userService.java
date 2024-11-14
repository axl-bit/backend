package net.practice.backend.service;

import java.util.List;

import net.practice.backend.dto.userDTO;

public interface userService {
    userDTO createUser(userDTO userDTO);
    userDTO updateUser(Long id, userDTO userDTO);
    void deleteUser(Long id);
    userDTO findUser(Long id);
    List<userDTO> findAllUser();
}
