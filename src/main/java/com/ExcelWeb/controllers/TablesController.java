package com.ExcelWeb.controllers;

//import com.sun.org.apache.xpath.internal.operations.Mod;

import com.ExcelWeb.dao.UsersDao;
import com.ExcelWeb.models.Position;
import com.ExcelWeb.models.RecordArray;
import com.ExcelWeb.service.PositionService;
import com.ExcelWeb.service.RecordArrayService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class TablesController {

    @GetMapping("/typework")
    public String typeWork(Model model, Authentication authentication) {
        model.addAttribute("nameOfUser", new UsersDao().findByUserName(authentication.getName()).getIdmonth());
        return "tables/typework";
    }

    @GetMapping("/address")
    public String address(Model model, Authentication authentication) {
        model.addAttribute("nameOfUser", new UsersDao().findByUserName(authentication.getName()).getIdmonth());
        return "tables/address";
    }

    @GetMapping("/inputdata")
    public String inputData(Model model, Authentication authentication) {
        model.addAttribute("nameOfUser", new UsersDao().findByUserName(authentication.getName()).getIdmonth());
        return "tables/inputdata";
    }

    @GetMapping("/names")
    public String names(Model model, Authentication authentication) {
        model.addAttribute("nameOfUser", new UsersDao().findByUserName(authentication.getName()).getIdmonth());
        return "tables/names";
    }

    @GetMapping("/")
    public String test(Model model, Authentication authentication) {
        return "index";
    }
}