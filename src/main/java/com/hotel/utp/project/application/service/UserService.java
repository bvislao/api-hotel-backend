package com.hotel.utp.project.application.service;

import com.hotel.utp.project.application.repository.IUserRepository;
import com.hotel.utp.project.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final IUserRepository userRepository;

    public void saveUser(User user) {
        userRepository.createUser(user);
    }

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }


}
