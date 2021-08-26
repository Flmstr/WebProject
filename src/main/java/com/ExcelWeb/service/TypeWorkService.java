package com.ExcelWeb.service;

import com.ExcelWeb.dao.TypeWorkDao;
import com.ExcelWeb.models.TypeWork;

import java.util.List;

public class TypeWorkService {
    private TypeWorkDao typeWorkDao = new TypeWorkDao();

    public TypeWork findTypeWorkById(int id){
        return typeWorkDao.findById(id);
    }

    public void saveTypeWorkDao(TypeWork typeWork){
        typeWorkDao.save(typeWork);
    }

    public void deleteTypeWork(TypeWork typeWork){
        typeWorkDao.delete(typeWork);
    }

    public void updateTypeWork(TypeWork typeWork){
        typeWorkDao.update(typeWork);
    }

    public List<TypeWork> findAllTypeWork(){
        return typeWorkDao.findAll();
    }

    public List<TypeWork> findSample(String term){
        return typeWorkDao.findSample(term);
    }
}
