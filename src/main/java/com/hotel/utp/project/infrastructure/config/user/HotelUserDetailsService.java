package com.hotel.utp.project.infrastructure.config.user;

import com.hotel.utp.project.application.repository.IUserRepository;
import com.hotel.utp.project.domain.User;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class HotelUserDetailsService implements UserDetailsService {
    private final IUserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByDocumentNumber(username);
        if(user == null){
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
        return HotelUserDetails.buildUserDetails(user);
    }
}
