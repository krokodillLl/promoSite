package com.krokodillLl.promoSite.services;

import com.krokodillLl.promoSite.domain.Role;
import com.krokodillLl.promoSite.domain.User;
import com.krokodillLl.promoSite.repos.IUSerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    private PasswordEncoder passwordEncoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
    @Autowired
    private IUSerRepo userRepo;

    @Override
    public UserDetails loadUserByUsername(final String email) throws UsernameNotFoundException {
        return userRepo.findUserByEmail(email);
    }

    public boolean addUser(final User user) {
        List<User> userFromDb = userRepo.findAll();

//        user.setRoles(Collections.singleton(Role.ADMIN));

        if (!userFromDb.isEmpty()) {
            return false;
        }

        user.setActive(true);

        user.setRoles(Collections.singleton(Role.ADMIN));
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        userRepo.save(user);

        return true;
    }
}
