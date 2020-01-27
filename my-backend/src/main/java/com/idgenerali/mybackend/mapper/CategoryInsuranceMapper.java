package com.idgenerali.mybackend.mapper;

import com.idgenerali.mybackend.model.CategoryInsurance;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface CategoryInsuranceMapper {

    List<CategoryInsurance> listCategoryInsurance();
    boolean insertCategory(@Param("categoryInsurance")CategoryInsurance categoryInsurance);
    boolean updateCategory(@Param("categoryInsurance")CategoryInsurance categoryInsurance);
    Optional<CategoryInsurance> findCategoryById(@Param("id")int id);
    Optional<CategoryInsurance> findCategoryByName(@Param("name")String name);
}
