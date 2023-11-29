package com.example.demo;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.HashMap;
@Repository
@Component
public class repository {
    HashMap<Integer,String> map = new HashMap<>();
    HashMap<Integer,HashMap<String,String>> details = new HashMap<>();
    //add operation
    public String addEmploy(String name){
        int id = map.size()+1;
        map.put(id,name);
        HashMap<String ,String> employDetails = new HashMap<>();
        employDetails.put("id",String.valueOf(id));
        employDetails.put("name",name);
        details.put(id,employDetails);
        return name+" added successfully";
    }
    //update operation
    public String addEmployInformation(EmployDTO employDetail){
        //retrive data from data base
        if(details.size()==0){
            return "Employ not present";
        }
        HashMap<String ,String> d =details.get(employDetail.id);
        System.out.println(employDetail.id+" "+ employDetail.name);
        if(d==null){
            return "Employ not present";
        }
        //details updated successfully
        d.put("name",employDetail.name);
        d.put("department",employDetail.department);
        d.put("income",employDetail.income);
        d.put("Time",String.valueOf(new Date()));
        //update the databases
        details.put(employDetail.id,d);
        return "Updated successfully";
    }
    //delete operation
    public String deleteEmploy(int id){
        if(map.containsKey(id)){
            String name = map.get(id);
            map.remove(id);
            details.remove(id);
            return id+" : "+name+ "Successfully deleted";
        }
      return id+": not present";
    }
    //read operation
    public HashMap<Integer,HashMap<String,String>> getDetails(){
        if(details.size()==0){
            return null;
        }
        return details;
    }
}
