package com.masai.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.masai.Bean.Customer;
import com.masai.Repository.CustomerRepository;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping("/register")
    public ResponseEntity<Customer> registerUser(@RequestBody Customer customer){

        customer.setPassword(passwordEncoder.encode(customer.getPassword()));

        return new ResponseEntity<>(customerRepository.save(customer), HttpStatus.ACCEPTED);
    }
    

    @GetMapping("/signIn")
	public ResponseEntity<Customer> getLoggedInCustomerDetailsHandler(Authentication auth){
		
		 Customer customer= customerRepository.findByEmail(auth.getName()).orElseThrow(() -> new BadCredentialsException("Invalid Username or password"));
		
		 return new ResponseEntity<>(customer, HttpStatus.ACCEPTED);
		
		
	}
    
}
