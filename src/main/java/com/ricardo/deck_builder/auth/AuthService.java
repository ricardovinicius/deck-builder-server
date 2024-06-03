package com.ricardo.deck_builder.auth;

import com.ricardo.deck_builder.user.User;
import com.ricardo.deck_builder.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;


@Service
public class AuthService implements UserDetailsService {
    @Autowired
    UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByLogin(username);
    }

    public User register(RegisterDTO data) {
        if (this.userRepository.findByLogin(data.login()) != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "User already exists with this login");
        }

        String encryptedPassword = new BCryptPasswordEncoder().encode(data.password());
        User newUser = new User(data.login(), encryptedPassword, data.roles());

        return this.userRepository.save(newUser);
    }
}
