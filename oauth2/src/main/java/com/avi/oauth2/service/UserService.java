package com.avi.oauth2.service;

import com.avi.oauth2.entity.User;
import com.avi.oauth2.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User registerOrUpdate(String provider, OidcUser oidcUser){
        String providersubject = oidcUser.getSubject();
        Optional<User> exeuser = userRepository.findByProviderAndProviderSubject(provider, providersubject);
        String name=oidcUser.getClaimAsString("name");
        String email=oidcUser.getClaimAsString("email");
        if(exeuser.isPresent()){
            User user = exeuser.get();
            user.setName(name);
            user.setName(email);

            return user;
        }else{
            User newuser = new User(name,email,provider,providersubject);
            User save = userRepository.save(newuser);

            return save;
        }
    }

    public Optional<User> findByProviderAndSubject(
            String provider,
            String subject) {

        return userRepository.findByProviderAndProviderSubject(
                provider, subject);
    }
}
