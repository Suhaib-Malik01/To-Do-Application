package com.masai.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.masai.Bean.Task;

public interface TaskRepository extends JpaRepository<Task,Integer> {
    
}
