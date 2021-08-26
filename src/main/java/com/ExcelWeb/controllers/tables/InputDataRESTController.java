package com.ExcelWeb.controllers.tables;

import com.ExcelWeb.models.Position;
import com.ExcelWeb.service.PositionService;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class InputDataRESTController {

    private PositionService positionService = new PositionService();

    @RequestMapping(path="/api/inputdata", method=RequestMethod.GET)
    public List<Position> getAllPosition(){
        return positionService.findAllPosition();
    }

    @RequestMapping(value = "/api/inputdata/DELETE/{id}", method = RequestMethod.GET)
    public Position deletePositionById(@PathVariable("id") int id){
        Position position = positionService.findPosition(id);
        positionService.deletePosition(position);
        return position;
    }

    @RequestMapping(value = "/api/inputdata/POST/{id}", method = RequestMethod.GET)
    public Position postPositionById(@PathVariable("id") int id,
                                     @RequestParam(name = "idMonth") String idMonth,
                                     //@RequestParam(name = "date") Date date,
                                     @RequestParam(name = "company") String company,
                                     @RequestParam(name = "address") String address,
                                     @RequestParam(name = "nameObject") String nameObject,
                                     @RequestParam(name = "quantity") Double quantity,
                                     @RequestParam(name = "price") Double price,
                                     @RequestParam(name = "sum") Double sum,
                                     @RequestParam(name = "discount") Double discount,
                                     @RequestParam(name = "endSum") Double endSum,
                                     @RequestParam(name = "typeWork") String typeWork,
                                     @RequestParam(name = "comment") String comment){
        Position position = positionService.findPosition(id);
        position.setIdMonth(idMonth);
        position.setDateNow(new Date());
        //position.setDate(date);
        position.setCompany(company);
        position.setAddress(address);
        position.setNameObject(nameObject);
        position.setQuantity(quantity);
        position.setPrice(price);
        position.setSum(sum);
        position.setDiscount(discount);
        position.setEndSum(endSum);
        position.setTypeWork(typeWork);
        position.setComment(comment);
        positionService.updatePosition(position);
        return position;
    }

    @RequestMapping(value = "/api/inputdata/PUT", method = RequestMethod.GET)
    public Position putPositionById(@RequestParam(name = "idMonth") String idMonth,
                                    @RequestParam(name = "Date") Date date,
                                    @RequestParam(name = "company") String company,
                                    @RequestParam(name = "address") String address,
                                    @RequestParam(name = "nameObject") String nameObject,
                                    @RequestParam(name = "quantity") Double quantity,
                                    @RequestParam(name = "price") Double price,
                                    @RequestParam(name = "sum") Double sum,
                                    @RequestParam(name = "discount") Double discount,
                                    @RequestParam(name = "endSum") Double endSum,
                                    @RequestParam(name = "typeWork") String typeWork,
                                    @RequestParam(name = "comment") String comment){
        Position position = new Position();
        position.setIdMonth(idMonth);
        position.setDate(date);
        position.setCompany(company);
        position.setAddress(address);
        position.setNameObject(nameObject);
        position.setQuantity(quantity);
        position.setPrice(price);
        position.setSum(sum);
        position.setDiscount(discount);
        position.setEndSum(endSum);
        position.setTypeWork(typeWork);
        position.setComment(comment);
        positionService.savePosition(position);
        return position;
    }




}