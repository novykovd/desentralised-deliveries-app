package com.example.delivery_router_project.controllers;

import com.example.delivery_router_project.entities.PackageEntity;
import com.example.delivery_router_project.services.DataService;
import com.example.delivery_router_project.services.GenericDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    DataService data;

    @GetMapping("/rest")
    @ResponseBody
    public GenericDTO home(Principal principal){
        Authentication authentication = (Authentication) principal;
        String username = authentication.getName();
        GenericDTO dto = new GenericDTO();
        data.callbackProcessorFunction(username, dto, data::getGraphOfCity, data::getMyPackages);
        return dto;
    }

}
