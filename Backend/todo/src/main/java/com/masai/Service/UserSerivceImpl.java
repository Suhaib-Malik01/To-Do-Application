package com.masai.Service;

import org.springframework.beans.factory.annotation.Autowired;


import com.masai.Bean.Customer;
import com.masai.Repository.CustomerRepository;

public class UserSerivceImpl implements UserService{

    @Autowired
    private CustomerRepository userRepository;

    @Override
    public Customer register(Customer user) {
        
        return userRepository.save(user);
    }
    

    
}
