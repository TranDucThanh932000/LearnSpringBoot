package com.example.learnspringboot.converter;

import com.example.learnspringboot.dto.NewDTO;
import com.example.learnspringboot.entity.NewEntity;
import org.springframework.stereotype.Component;

@Component
public class NewConverter {
    public NewEntity toEntity(NewDTO newDTO){
        NewEntity entity = new NewEntity();
        entity.setTitle(newDTO.getTitle());
        entity.setContent(newDTO.getContent());
        entity.setShortDescription(newDTO.getShortDescription());
        entity.setThumbnail(newDTO.getThumbnail());
        return entity;
    }

    public NewEntity toEntity(NewDTO newDTO, NewEntity entity){
        entity.setTitle(newDTO.getTitle());
        entity.setContent(newDTO.getContent());
        entity.setShortDescription(newDTO.getShortDescription());
        entity.setThumbnail(newDTO.getThumbnail());
        return entity;
    }

    public NewDTO toDTO(NewEntity entity){
        NewDTO newDTO = new NewDTO();
        if(entity.getId() != null){
            newDTO.setId(entity.getId());
        }
        newDTO.setTitle(entity.getTitle());
        newDTO.setContent(entity.getContent());
        newDTO.setShortDescription(entity.getShortDescription());
        newDTO.setThumbnail(entity.getThumbnail());
        newDTO.setCategoryCode(entity.getCategory().getCode());

        newDTO.setCreatedDate(entity.getCreatedDate());
        newDTO.setCreatedBy(entity.getCreatedBy());
        newDTO.setModifiedBy(entity.getModifiedBy());
        newDTO.setModifiedDate(entity.getModifiedDate());
        return newDTO;
    }
}
