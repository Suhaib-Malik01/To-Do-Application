package com.masai.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.masai.Bean.Customer;
import com.masai.Repository.CustomerRepository;



public class CustomerUserDetails implements UserDetailsService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        Optional<Customer> userOptional = customerRepository.findByEmail(username);

        if(userOptional.isPresent()){

            Customer user = userOptional.get();

            List<GrantedAuthority> authorities = new ArrayList<>();

            return new User(user.getEmail(), user.getPassword(), authorities);
        }

        throw new BadCredentialsException("User Details not found with this username: "+username);
           
    }

}
