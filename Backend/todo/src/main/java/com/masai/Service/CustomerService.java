package com.masai.Service;

import java.util.List;

import com.masai.Bean.Customer;
import com.masai.Bean.Task;
import com.masai.Exception.UserException;

public interface CustomerService {

    public Customer register(Customer user);

    public List<Task> getCustomerTask() throws UserException;
    
}
