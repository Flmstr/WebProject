package com.ExcelWeb.controllers;

//import com.sun.org.apache.xpath.internal.operations.Mod;

import com.ExcelWeb.dao.UsersDao;
import com.ExcelWeb.models.Users;
import com.ExcelWeb.service.RecordArrayService;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MonthsController {

    @GetMapping("/months")
    public String writingForm(Model model,@ModelAttribute String currentMonth,  Authentication authentication) {
        UsersDao usersDao = new UsersDao();

        model.addAttribute("currentMonth", new String());
        model.addAttribute("nameOfUser", usersDao.findByUserName(authentication.getName()).getIdmonth());

        return "months";
    }

    @PostMapping("/months")
    public String writingSubmit(@RequestParam(name = "currentMonth") String currentMonth, Authentication authentication,Model model) {
        model.addAttribute("nameOfUser", new UsersDao().findByUserName(authentication.getName()).getIdmonth());
        UsersDao usersDao = new UsersDao();
        Users user = usersDao.findByUserName(authentication.getName());
        user.setIdmonth(currentMonth);
        usersDao.update(user);

        return "months";
    }

    private List<String> getMonths(){
        List<String> months = new ArrayList<>();
        months.add("Апрель 2020");
        months.add("Май 2020");
        months.add("Июнь 2020");
        months.add("Июль 2020");
        months.add("Август 2020");
        months.add("Сентябрь 2020");
        months.add("Октябрь 2020");
        months.add("Ноябрь 2020");
        months.add("Декабрь 2020");
        months.add("Январь 2020");
        return months;
    }

}