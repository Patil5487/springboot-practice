package com.JWT.Security.demo.Service;

import com.JWT.Security.demo.Model.User;
import com.JWT.Security.demo.Repository.UserRepository;
import io.jsonwebtoken.Jwts;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.webmvc.autoconfigure.WebMvcProperties;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserDetailService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("User Not found"));
//
//        SimpleGrantedAuthority authority = new SimpleGrantedAuthority("ROLE_"+user.getRole());
//
//        return new org.springframework.security.core.userdetails.User(
//                user.getUsername(),
//                user.getPassword(),
//                Collections.singleton(authority)
//        );
//    }

//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
//
//        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("Role_" + user.getRole());
//
//        return new org.springframework.security.core.userdetails.User(
//                user.getUsername(),
//                user.getPassword(),
//                Collections.singleton(simpleGrantedAuthority));
//    }
//}


//        User user = userRepository.findByUsername(username).orElseThrow(() -> new UsernameNotFoundException("Username not found"));
//
//        SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority(
//                "Role" + user.getRole());
//
//        return new org.springframework.security.core.userdetails.User(
//                user.getUsername(),
//                user.getPassword(),
//                Collections.singleton(simpleGrantedAuthority));
//    }
//
//    }

@Override
public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    User user = userRepository.findByUsername(username).orElseThrow(()-> new UsernameNotFoundException("No user found with username: " + username));

    SimpleGrantedAuthority simpleGrantedAuthority = new SimpleGrantedAuthority("Role"+user.getRole());

    return new org.springframework.security.core.userdetails.User(
            user.getUsername(),
            user.getPassword(),
            Collections.singleton(simpleGrantedAuthority));


}
}


