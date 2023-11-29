package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashMap;

@Service
public class service {
    @Autowired
    repository repository;
    public String addEmploy(String name){
       return repository.addEmploy(name);
    }
    //update operation
    public String addEmployInformation(EmployDTO employDetail){
        return repository.addEmployInformation(employDetail);
    }
    //delete operation
    public String deleteEmploy(int id){
       return repository.deleteEmploy(id);
    }
    //read operation
    public HashMap<Integer,HashMap<String,String>> getDetails(){
       return repository.getDetails();
    }
}
