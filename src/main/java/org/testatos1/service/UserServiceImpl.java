package org.testatos1.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.testatos1.entity.User;
import org.testatos1.exception.UserNotFoundException;
import org.testatos1.exception.UserRegistrationException;
import org.testatos1.repository.UserRepository;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User registerUser(User user) throws UserRegistrationException {
        // Validate user age and residence country
        LocalDate currentDate = LocalDate.now();
        int age = Period.between(user.getBirthdate(), currentDate).getYears();

        if (age < 18 || !user.getCountryOfResidence().equalsIgnoreCase("France")) {
            throw new UserRegistrationException("Only adult French residents are allowed to create an account.");
        }

        return userRepository.save(user);
    }

    @Override
    public User getUserByUsername(String username) throws UserNotFoundException {
        Optional<User> optionalUser = userRepository.findByUserName(username);
        return optionalUser.orElseThrow(() -> new UserNotFoundException("User not found with username: " + username));
    }

    @Override
    public User getUserById(Long userId) throws UserNotFoundException {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + userId));
    }
}
