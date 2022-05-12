package com.example.learnspringboot.repository;

import com.example.learnspringboot.entity.NewEntity;
import org.springframework.data.jpa.repository.JpaRepository;


public interface NewRepository extends JpaRepository<NewEntity, Long> {

}
