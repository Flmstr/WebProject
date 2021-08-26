package com.ExcelWeb.controllers;

//import com.sun.org.apache.xpath.internal.operations.Mod;

import com.ExcelWeb.dao.UsersDao;
import com.ExcelWeb.models.RecordArray;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ExcelWeb.models.Position;
import com.ExcelWeb.service.PositionService;
import com.ExcelWeb.service.RecordArrayService;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class InputDataController {

    @GetMapping("/checkinput")
    public String writingForm(Model model, @ModelAttribute RecordArrayService records, Authentication authentication) {
        records = new RecordArrayService();
        model.addAttribute("records", records);
        model.addAttribute("nameOfUser", new UsersDao().findByUserName(authentication.getName()).getIdmonth());

        return "index";
    }

    @PostMapping("/checkinput")
    public String writingSubmit(@ModelAttribute RecordArrayService records,Authentication authentication,  Model model) {
        //List<Record> allRecord = writing.getRecords();
        model.addAttribute("nameOfUser", new UsersDao().findByUserName(authentication.getName()).getIdmonth());
        List<RecordArray> recordArray = records.getRecords();
        PositionService positionService = new PositionService();
        List<Position> positionArrayList = new ArrayList<>();
        String month = new UsersDao().findByUserName(authentication.getName()).getIdmonth();

        for (RecordArray record : recordArray){
            if (!record.getNameObject().equals("")){
                Position position = new Position();

                position.setIdMonth(month);
//                position.setDateNow(new Date());
                position.setDate(recordArray.get(0).getDate());
                position.setCompany(recordArray.get(0).getCompany());
                position.setAddress(recordArray.get(0).getAddress());
                position.setNameObject(record.getNameObject());
                position.setQuantity(Double.parseDouble(record.getQuantity()));
                position.setPrice(Double.parseDouble(record.getPrice()));
                position.setSum(Double.parseDouble(record.getSum()));
                position.setDiscount(Double.parseDouble(record.getDiscount()));
                position.setEndSum(Double.parseDouble(record.getEndSum()));
                position.setTypeWork(record.getTypeWork());
                position.setComment(record.getComment());
                position.setName(recordArray.get(0).getName());
                positionArrayList.add(position);
            }
        }
        positionService.savePosition(positionArrayList);
        model.addAttribute("records", records);

        return "index";
    }

}

