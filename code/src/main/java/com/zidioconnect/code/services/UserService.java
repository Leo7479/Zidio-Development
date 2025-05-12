package com.zidioconnect.code.services;

import com.zidioconnect.code.models.User;
import com.zidioconnect.code.repositories.IUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final IUserRepository IUserRepository;

    public UserService(IUserRepository IUserRepository) {
        this.IUserRepository = IUserRepository;
    }

    public User createUser(User user) {
        return IUserRepository.save(user);
    }

    public User getUserById(long id) {
        return IUserRepository.findById(id).orElse(null);
    }

    public User getUserByEmail(String email) {
        return IUserRepository.findByEmail(email);
    }
}
