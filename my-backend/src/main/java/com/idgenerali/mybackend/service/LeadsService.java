package com.idgenerali.mybackend.service;

import com.idgenerali.mybackend.exception.NotFoundException;
import com.idgenerali.mybackend.mapper.LeadsMapper;
import com.idgenerali.mybackend.model.Leads;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LeadsService {

    @Autowired
    private LeadsMapper leadsMapper;

    public List<Leads> leadsList(){
        return leadsMapper.listLeads();
    }

    public boolean insert(Leads leads){
        return leadsMapper.insertLeads(leads);
    }

    public boolean update(Leads leads){
        return leadsMapper.updateLeads(leads);
    }

    public boolean delete(int id){
        return leadsMapper.deleteLeads(id);
    }

    public List<Leads> leadsLisActive(){
        return leadsMapper.listLeadsByActive();
    }

    public List<Leads> leadsListNotActive(){
        return leadsMapper.listLeadsByNotActive();
    }

    public Leads findLeadsByEmail(String email){
        return leadsMapper.findLeadsByEmail(email)
                .orElseThrow(() -> new NotFoundException("email not found"));
    }
}
