package org.testatos1.service;


import org.testatos1.entity.User;
import org.testatos1.exception.UserNotFoundException;
import org.testatos1.exception.UserRegistrationException;

public interface UserService {
    User registerUser(User user) throws UserRegistrationException;
    User getUserByUsername(String username) throws UserNotFoundException;
    User getUserById(Long userId) throws UserNotFoundException;
}