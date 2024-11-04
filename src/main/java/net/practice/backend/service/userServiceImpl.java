package net.practice.backend.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.practice.backend.dto.userDTO;
import net.practice.backend.entity.user;
import net.practice.backend.exception.resourceNotFoundException;
import net.practice.backend.mapper.userMapper;
import net.practice.backend.repository.userRepository;

@Service
public class userServiceImpl implements userService {

    @Autowired
    private userRepository repo;

    @Override
    public userDTO findUser(Long id) {
        user user = repo.findById(id).orElseThrow(
            ()->new resourceNotFoundException("usario no existe: " + id));
        return userMapper.mapToUserDTO(user);
    }

    @Override
    public userDTO createUser(userDTO userDTO) {

        user user = userMapper.mapToUser(userDTO);
        user saveUser = repo.save(user);

        return userMapper.mapToUserDTO(saveUser);
    }

    @Override
    public userDTO updateUser(Long id, userDTO userDTO) {
        
        user userNow = repo.findById(id).orElseThrow(
            ()->new resourceNotFoundException("usario no existe: " + id));

        userNow.setNombres(userDTO.getNombres());
        userNow.setApellidos(userDTO.getApellidos());
        userNow.setEmail(userDTO.getEmail());       
        
        user userUpdate = repo.save(userNow);

        return userMapper.mapToUserDTO(userUpdate);
    }

    @Override
    public void deleteUser(Long id) {
        user userNow = repo.findById(id).orElseThrow(
            ()->new resourceNotFoundException("usario no existe: " + id));

        repo.delete(userNow);
    }

    

    @Override
    public List<userDTO> findAllUser() {
        List<user> users = repo.findAll();
        return users.stream().map((user)-> userMapper.mapToUserDTO(user)).collect(Collectors.toList());
    }

}
