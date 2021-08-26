package com.ExcelWeb.service;

import com.ExcelWeb.dao.EmployeesNameDao;
import com.ExcelWeb.models.EmployeesName;

import java.util.List;

public class EmployeesNameService {
    private EmployeesNameDao employeesNameDao = new EmployeesNameDao();

    public EmployeesName findById(int id){
        return employeesNameDao.findById(id);
    }

    public void saveEmployeesNameDao(EmployeesName employeesName){
        employeesNameDao.save(employeesName);
    }

    public void deleteEmployeesName(EmployeesName employeesName){
        employeesNameDao.delete(employeesName);
    }

    public void updateEmployeesName(EmployeesName employeesName){
        employeesNameDao.update(employeesName);
    }

    public List<EmployeesName> findAllEmployeesName(){
        return employeesNameDao.findAll();
    }

    public List<EmployeesName> findSample(String term){
        return employeesNameDao.findSample(term);
    }
}
