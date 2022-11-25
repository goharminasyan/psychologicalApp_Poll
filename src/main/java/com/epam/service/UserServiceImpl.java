package com.epam.service;

import com.epam.model.User;
import com.epam.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;

@Service("userService")
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void create(User user) {
        userRepository.save(user);
    }

  @Override
  public User findById(long id) {
    return userRepository.findById(id);
  }

  @Override
    public User pollResultById(long id) {
        return userRepository.findById(id);
    }

    @Override
    public boolean existEmailAndPass(String email, String pass) {
        return userRepository.existsByEmailAndPassword(email, pass);
    }

    @Override
    public User getByEmailAndPass(String email, String pass) {
        return userRepository.findUserByEmailAndPassword(email, pass);
    }


}
