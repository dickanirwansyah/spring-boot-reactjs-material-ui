package com.idgenerali.mybackend.service;

import com.idgenerali.mybackend.exception.NotFoundException;
import com.idgenerali.mybackend.mapper.StatusMapper;
import com.idgenerali.mybackend.model.Status;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusService {

    private static final Logger LOGGER = LoggerFactory.getLogger(StatusService.class);

    @Autowired
    private StatusMapper statusMapper;

    public List<Status> listStatus(){
        LOGGER.info("####listStatus");
        return statusMapper.listStatus();
    }

    public Status statusById(int id){
        LOGGER.info("###statusById() : "+id);
        return statusMapper.findStatusById(id)
                .orElseThrow(() -> new NotFoundException("status id not found"));
    }

    public Status statusByName(String name){
        LOGGER.info("###statusByName() : "+name);
        return statusMapper.findStatusByName(name)
                .orElseThrow(() -> new NotFoundException("status name not found"));
    }
}
