package com.idgenerali.mybackend.mapper;

import com.idgenerali.mybackend.model.Leads;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Optional;

@Mapper
public interface LeadsMapper {
    List<Leads> listLeads();
    Optional<Leads> findLeadsByEmail(@Param("email")String email);
    List<Leads> listLeadsByActive();
    List<Leads> listLeadsByNotActive();
    boolean insertLeads(@Param("leads")Leads leads);
    boolean updateLeads(@Param("leads")Leads leads);
    boolean deleteLeads(@Param("id")Integer id);
}
