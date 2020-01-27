package com.idgenerali.mybackend.controller;

import com.idgenerali.mybackend.model.Leads;
import com.idgenerali.mybackend.model.RestResponse;
import com.idgenerali.mybackend.service.LeadsService;
import com.idgenerali.mybackend.util.ApiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = {"*"})
@RestController
@RequestMapping(value = "/api/leads")
public class LeadsController {

    @Autowired
    private LeadsService leadsService;

    @PostMapping(value = "/action/{type}")
    public ResponseEntity<RestResponse<Boolean>> action(@PathVariable(value = "type") String type,
                                                      @RequestBody Leads leads){

        RestResponse restResponse = null;
        boolean save = false;

        if (type.equals("save")){

            save = leadsService.insert(leads);

            if (save == true){
                restResponse = RestResponse.builder()
                        .timestamp(new Date())
                        .status(ApiUtils.SUCCESS_STATUS)
                        .message(ApiUtils.MESSAGE_SUCCESS)
                        .data(save)
                        .build();
            }else{
                restResponse = RestResponse.builder()
                        .status(ApiUtils.BADREQUEST_STATUS)
                        .message(ApiUtils.MESSAGE_FAILED)
                        .data(false)
                        .build();
            }

        }else if (type.equals("update")){

            save = leadsService.update(leads);

            if (save == true){
                restResponse = RestResponse.builder()
                        .timestamp(new Date())
                        .status(ApiUtils.SUCCESS_STATUS)
                        .message(ApiUtils.MESSAGE_SUCCESS)
                        .data(save)
                        .build();
            }else {
                restResponse = RestResponse.builder()
                        .timestamp(new Date())
                        .status(ApiUtils.BADREQUEST_STATUS)
                        .message(ApiUtils.MESSAGE_FAILED)
                        .data(false)
                        .build();
            }
        }else {
            return null;
        }

        return ResponseEntity.ok(restResponse);
    }

    @GetMapping(value = "/list-leads/{type}")
    public ResponseEntity<RestResponse<Leads>> listLeads(@PathVariable("type")String type){


        RestResponse restResponse = null;
        List<Leads> leads = null;

        if (type.equals("list-all")){

            leads = leadsService.leadsList();

            if (!leads.isEmpty() || leads != null){
                restResponse = RestResponse.builder()
                        .timestamp(new Date())
                        .message(ApiUtils.MESSAGE_SUCCESS)
                        .status(ApiUtils.SUCCESS_STATUS)
                        .data(leads)
                        .build();
            }else{
                restResponse = RestResponse.builder()
                        .timestamp(new Date())
                        .message(ApiUtils.MESSAGE_FAILED)
                        .status(ApiUtils.NOTFOUND_STATUS)
                        .data(leads)
                        .build();
            }

        }else if (type.equals("list-active")){

            leads = leadsService.leadsLisActive();

            if (!leads.isEmpty() || leads != null){
                restResponse = RestResponse.builder()
                        .timestamp(new Date())
                        .message(ApiUtils.MESSAGE_SUCCESS)
                        .status(ApiUtils.SUCCESS_STATUS)
                        .data(leads)
                        .build();
            }else {
                restResponse = RestResponse.builder()
                        .timestamp(new Date())
                        .message(ApiUtils.MESSAGE_FAILED)
                        .status(ApiUtils.NOTFOUND_STATUS)
                        .data(leads)
                        .build();
            }

        }else if (type.equals("list-notactive")){

            leads = leadsService.leadsListNotActive();

            if (!leads.isEmpty() || leads != null){
                restResponse = RestResponse.builder()
                        .timestamp(new Date())
                        .message(ApiUtils.MESSAGE_SUCCESS)
                        .status(ApiUtils.SUCCESS_STATUS)
                        .data(leads)
                        .build();
            }else{
                restResponse = RestResponse.builder()
                        .timestamp(new Date())
                        .message(ApiUtils.MESSAGE_SUCCESS)
                        .status(ApiUtils.SUCCESS_STATUS)
                        .data(leads)
                        .build();
            }

        }else{
            return null;
        }

        return ResponseEntity.ok(restResponse);
    }

    @PostMapping(value = "/delete")
    public ResponseEntity<RestResponse<Boolean>> delete(@RequestParam(value = "id")int id){

        RestResponse restResponse = null;
        boolean deleted = leadsService.delete(id);
        if (deleted == true){
            restResponse = RestResponse.builder()
                    .timestamp(new Date())
                    .message(ApiUtils.MESSAGE_SUCCESS)
                    .status(ApiUtils.SUCCESS_STATUS)
                    .data(deleted)
                    .build();
        }else{
            restResponse = RestResponse.builder()
                    .timestamp(new Date())
                    .message(ApiUtils.MESSAGE_FAILED)
                    .status(ApiUtils.NOTFOUND_STATUS)
                    .data(false)
                    .build();
        }

        return ResponseEntity.ok(restResponse);
    }
}
