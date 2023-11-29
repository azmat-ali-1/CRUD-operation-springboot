package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;

@Controller
public class controller {
    @Autowired
    service service;
    //create operation
    @PostMapping("/addEmploy/{name}")
    public ResponseEntity<String> addEmploy(@PathVariable("name") String name){
        return new ResponseEntity<>(service.addEmploy(name),HttpStatus.CREATED);
    }
    //update operation
    @PutMapping("/updateDetails")
    public ResponseEntity<String> addEmployInformation(@RequestBody(required = true) EmployDTO employDetail){
       return new ResponseEntity<>(service.addEmployInformation(employDetail),HttpStatus.CREATED);
    }
    //delete operation
    @DeleteMapping("/delete")
    public ResponseEntity<String> deleteEmploy(@RequestParam("id") int id){
        return new ResponseEntity<>(service.deleteEmploy(id),HttpStatus.ACCEPTED);
    }
    //read operation
    @GetMapping("/getDetails")
    public ResponseEntity<HashMap> getDetails(){
        return new ResponseEntity<>(service.getDetails(),HttpStatus.ACCEPTED);
    }

}
