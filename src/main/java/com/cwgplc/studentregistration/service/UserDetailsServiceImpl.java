package com.cwgplc.studentregistration.service;

import com.cwgplc.studentregistration.entity.MyUserDetails;
import com.cwgplc.studentregistration.entity.UserEntity;
import com.cwgplc.studentregistration.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("userDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username   ) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.getUserByUsername(username);

        if (userEntity == null) {
            throw new UsernameNotFoundException("Could not find user");
        }

        return new MyUserDetails(userEntity);
    }

    public UserEntity getUserByUserName(String username   ) throws UsernameNotFoundException {
        UserEntity userEntity = userRepository.getUserByUsername(username);

        if (userEntity == null) {
            throw new UsernameNotFoundException("Could not find user");
        }
        return userEntity;
    }
}
