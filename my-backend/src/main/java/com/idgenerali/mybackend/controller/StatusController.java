package com.idgenerali.mybackend.controller;

import com.idgenerali.mybackend.model.RestResponse;
import com.idgenerali.mybackend.model.Status;
import com.idgenerali.mybackend.service.StatusService;
import com.idgenerali.mybackend.util.ApiUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;


@RestController
@RequestMapping(value = "/api/status")
public class StatusController {

    @Autowired
    private StatusService statusService;

    @GetMapping
    public String getStatus(){
        return "HALLO";
    }

    @GetMapping(value = "/list-status")
    public ResponseEntity<RestResponse<List<Status>>> getListStatus(){
        RestResponse restResponse = null;
        List<Status> statusList = statusService.listStatus();

        if (!statusList.isEmpty() && statusList != null){
            restResponse = RestResponse.builder()
                    .timestamp(new Date())
                    .status(ApiUtils.SUCCESS_STATUS)
                    .message(ApiUtils.MESSAGE_SUCCESS)
                    .data(statusList)
                    .build();
        }else{
            restResponse = RestResponse.builder()
                    .timestamp(new Date())
                    .status(ApiUtils.NOTFOUND_STATUS)
                    .message(ApiUtils.MESSAGE_FAILED)
                    .data(null)
                    .build();
        }

        return ResponseEntity.ok(restResponse);
    }

    @GetMapping(value = "/find-status/{type}/{param}")
    public ResponseEntity<RestResponse<Status>> findStatus(@PathVariable("type")String type,
                                                           @PathVariable("param")String param){

        RestResponse restResponse = null;
        Status status = null;

        if (type.equals("id")){
            status = statusService.statusById(Integer.valueOf(param));
            if (status != null){
                restResponse = RestResponse.builder()
                        .timestamp(new Date())
                        .message(ApiUtils.MESSAGE_SUCCESS)
                        .status(ApiUtils.SUCCESS_STATUS)
                        .data(status)
                        .build();
            }else{
                restResponse = RestResponse.builder()
                        .timestamp(new Date())
                        .message(ApiUtils.MESSAGE_FAILED)
                        .status(ApiUtils.NOTFOUND_STATUS)
                        .data(null)
                        .build();
            }
        }else if (type.equals("name")){

            status = statusService.statusByName(param);
            if (status != null){
                restResponse = RestResponse.builder()
                        .timestamp(new Date())
                        .message(ApiUtils.MESSAGE_SUCCESS)
                        .status(ApiUtils.SUCCESS_STATUS)
                        .data(status)
                        .build();
            }else{
                restResponse = RestResponse.builder()
                        .timestamp(new Date())
                        .message(ApiUtils.MESSAGE_FAILED)
                        .status(ApiUtils.NOTFOUND_STATUS)
                        .data(null)
                        .build();
            }

        }else {
            return null;
        }

        return ResponseEntity.ok(restResponse);
    }
}
