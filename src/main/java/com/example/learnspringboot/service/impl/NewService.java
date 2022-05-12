package com.example.learnspringboot.service.impl;

import com.example.learnspringboot.converter.NewConverter;
import com.example.learnspringboot.dto.NewDTO;
import com.example.learnspringboot.entity.CategoryEntity;
import com.example.learnspringboot.entity.NewEntity;
import com.example.learnspringboot.repository.CategoryRepository;
import com.example.learnspringboot.repository.NewRepository;
import com.example.learnspringboot.service.INewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class NewService implements INewService {
    @Autowired
    private NewRepository newRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private NewConverter newConverter;

    @Override
    public NewDTO save(NewDTO newDTO) {
        NewEntity newEntity = new NewEntity();
        if(newDTO.getId() != null){
            Optional<NewEntity> oldNewEntity = newRepository.findById(newDTO.getId());
            newEntity = newConverter.toEntity(newDTO, oldNewEntity.get());
        }else{
            newEntity = newConverter.toEntity(newDTO);
        }
        CategoryEntity categoryEntity = categoryRepository.findOneByCode(newDTO.getCategoryCode());
        newEntity.setCategory(categoryEntity);
        newEntity = newRepository.save(newEntity);
        return newConverter.toDTO(newEntity);
    }

    @Override
    public void delete(long[] ids) {
        for(long item : ids){
            newRepository.delete(newRepository.findById(item).get());
        }
    }

    @Override
    public List<NewDTO> findAll(Pageable pageable) {
        List<NewDTO> results = new ArrayList<>();
        List<NewEntity> entities = newRepository.findAll(pageable).getContent();
        for (NewEntity item : entities){
            NewDTO newDTO = newConverter.toDTO(item);
            results.add(newDTO);
        }
        return results;
    }

    @Override
    public List<NewDTO> findAll() {
        List<NewDTO> results = new ArrayList<>();
        List<NewEntity> entities = newRepository.findAll();
        for (NewEntity item : entities){
            NewDTO newDTO = newConverter.toDTO(item);
            results.add(newDTO);
        }
        return results;
    }

    @Override
    public int totalItem() {
        return (int) newRepository.count();
    }

}
