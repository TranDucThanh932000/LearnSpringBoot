package com.example.learnspringboot.service;

import com.example.learnspringboot.dto.NewDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface INewService {
    NewDTO save(NewDTO newDTO);
    void delete(long[] ids);
    List<NewDTO> findAll(Pageable pageable);
    List<NewDTO> findAll();
    int totalItem();
}
