package com.ExcelWeb.controllers.tables;

import com.ExcelWeb.models.EmployeesName;
import com.ExcelWeb.service.EmployeesNameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NamesRESTController {

    private EmployeesNameService employeesNameService = new EmployeesNameService();

    @RequestMapping(path="/api/names", method=RequestMethod.GET)
    public List<EmployeesName> getAllEmployeesName(){
        return employeesNameService.findAllEmployeesName();
    }

    @RequestMapping(value = "/api/names/DELETE/{id}", method = RequestMethod.GET)
    public EmployeesName deleteEmployeesNameById(@PathVariable("id") int id){
        EmployeesName employeesName = employeesNameService.findById(id);
        employeesNameService.deleteEmployeesName(employeesName);
        return employeesName;
    }

    @RequestMapping(value = "/api/names/POST/{id}", method = RequestMethod.GET)
    public EmployeesName postEmployeesNameById(@PathVariable("id") int id, @RequestParam(name = "name") String name){
        EmployeesName employeesName = employeesNameService.findById(id);
        employeesName.setName(name);
        employeesNameService.updateEmployeesName(employeesName);
        return employeesName;
    }

    @RequestMapping(value = "/api/names/PUT", method = RequestMethod.GET)
    public EmployeesName putEmployeesNameById(@RequestParam(name = "name") String name){
        EmployeesName employeesName = new EmployeesName();
        employeesName.setName(name);

        employeesNameService.saveEmployeesNameDao(employeesName);
        return employeesName;
    }



}