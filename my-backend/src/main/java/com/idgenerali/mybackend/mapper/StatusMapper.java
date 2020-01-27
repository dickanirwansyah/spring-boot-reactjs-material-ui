package com.idgenerali.mybackend.mapper;

import com.idgenerali.mybackend.model.Status;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface StatusMapper {
    List<Status> listStatus();
    Optional<Status> findStatusById(@Param("id")int id);
    Optional<Status> findStatusByName(@Param("name")String name);
}
