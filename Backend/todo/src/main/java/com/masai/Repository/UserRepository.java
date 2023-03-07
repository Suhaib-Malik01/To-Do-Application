package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Bean.User;

public interface UserRepository extends JpaRepository<User,Integer>{
    
}
