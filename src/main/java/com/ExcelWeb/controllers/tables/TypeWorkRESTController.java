package com.ExcelWeb.controllers.tables;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ExcelWeb.models.*;
import com.ExcelWeb.service.*;

@RestController
public class TypeWorkRESTController {


    private TypeWorkService typeWorkService = new TypeWorkService();

    @RequestMapping(path="/api/typework", method=RequestMethod.GET)
    public List<TypeWork> getAllTypeWorks(){
        return typeWorkService.findAllTypeWork();
    }

    @RequestMapping(value = "/api/typework/DELETE/{id}", method = RequestMethod.GET)
    public TypeWork deleteTypeWorkById(@PathVariable("id") int id){
        TypeWork typeWork = typeWorkService.findTypeWorkById(id);
        typeWorkService.deleteTypeWork(typeWork);
        return typeWork;
    }

    @RequestMapping(value = "/api/typework/POST/{id}", method = RequestMethod.GET)
    public TypeWork postTypeWorkById(@PathVariable("id") int id, @RequestParam(name = "name") String name){
        TypeWork typeWork = typeWorkService.findTypeWorkById(id);
        typeWork.setName(name);
        typeWorkService.updateTypeWork(typeWork);
        return typeWork;
    }

    @RequestMapping(value = "/api/typework/PUT", method = RequestMethod.GET)
    public TypeWork putTypeWorkById(@RequestParam(name = "name") String name){
        TypeWork typeWork = new TypeWork();
        typeWork.setName(name);
        typeWorkService.saveTypeWorkDao(typeWork);
        return typeWork;
    }

    //Адреса






}