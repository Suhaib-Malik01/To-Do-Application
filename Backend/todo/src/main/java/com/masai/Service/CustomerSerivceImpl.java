package com.masai.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.masai.Bean.Customer;
import com.masai.Bean.Task;
import com.masai.Exception.UserException;
import com.masai.Repository.CustomerRepository;

@Service
public class CustomerSerivceImpl implements CustomerService{

    @Autowired
    private CustomerRepository customerRepository;

    

    @Override
    public Customer register(Customer user) {
        
        return customerRepository.save(user);
    }

    @Override
    public List<Task> getCustomerTask() throws UserException {
        
        String email = null;
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null) {
            email = authentication.getPrincipal().toString();
        }else{
            throw new UserException("The User is not Logged in");
        }
        
        Customer customer = customerRepository.findByEmail(email).orElseThrow(() -> new UserException("Login Expired"));

        return customer.getTasks();
        
    }
    

    

    
}
