package com.hotel.utp.project.infrastructure.config;

import org.springframework.data.domain.AuditorAware;

import java.util.Optional;

public class AuditorAwareImpl implements AuditorAware<String> {
    @Override
    public Optional<String> getCurrentAuditor() {
        return Optional.of("SYSTEM");
        /*UserAuthenticationToken authentication = (UserAuthenticationToken) SecurityContextHolder.getContext().getAuthentication();

        if(authentication == null || !authentication.isAuthenticated()){
            return Optional.empty();
        }
        return Optional.of(getUserEmail(authentication.getUserInfo().email()));*/
    }


}
