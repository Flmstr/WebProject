package com.ExcelWeb.controllers;


import com.ExcelWeb.models.*;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import com.ExcelWeb.service.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Controller
public class QueryController {

    @GetMapping(value = "/query/EmployeesNames", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<String> queryEmployeesNames(@RequestParam(name="term", defaultValue="") String term, Model model) {
        //model.addAttribute("name", name);
        List<String> name = new ArrayList<>();
        EmployeesNameService employeesNameService = new EmployeesNameService();
        List<EmployeesName> employeesNames = employeesNameService.findSample(term);

//        for (int i = 0; i<10; i++){
//                name.add(employeesNames.get(i).getName().trim());
//        }
        for (EmployeesName employeesName : employeesNames){
            name.add(employeesName.getName().trim());
        }

        return name;
    }

    @GetMapping(value = "/query/TypeWork", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<String> queryTypeWork(@RequestParam(name="term", defaultValue="") String term, Model model) {
        List<String> name = new ArrayList<>();
        TypeWorkService typeWorkService = new TypeWorkService();
        List<TypeWork> typeWorks = typeWorkService.findSample(term);

        for (TypeWork typeWork : typeWorks){
            name.add(typeWork.getName().trim());
        }

        return name;
    }

    @GetMapping(value = "/query/Organization", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<String> queryOrganization(@RequestParam(name="term", defaultValue="") String term, Model model) {
        List<String> name = new ArrayList<>();
        AddressesService addressesService = new AddressesService();
        List<Addresses> addresses = addressesService.findSampleUnique(term);

        for (Addresses address : addresses){
            name.add(address.getOrganization().trim());
        }

        Set<String> set = new HashSet<>(name);
        name.clear();
        name.addAll(set);

        return name;
    }

    @GetMapping(value = "/query/Address", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<String> queryAddress(@RequestParam(name="term", defaultValue="") String term, @RequestParam(name = "company", defaultValue = "") String company, Model model) {
        List<String> name = new ArrayList<>();
        AddressesService addressesService = new AddressesService();
        List<Addresses> addresses = addressesService.findSample(term,company);

        for (Addresses address : addresses){
            name.add(address.getShortaddress().trim());
        }

        return name;
    }

}