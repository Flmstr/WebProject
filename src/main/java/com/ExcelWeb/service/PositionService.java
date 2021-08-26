package com.ExcelWeb.service;

import com.ExcelWeb.dao.PositionDao;
import com.ExcelWeb.models.Position;

import java.util.List;

public class PositionService {
    private PositionDao positionDao = new PositionDao();

    public Position findPosition(int id){
        return positionDao.findById(id);
    }

    public void savePosition(Position position){
        positionDao.save(position);
    }

    public void savePosition(List<Position> PositionArray){
        for (Position position : PositionArray){
            positionDao.save(position);
        }
    }

    public void deletePosition(Position position){
        positionDao.delete(position);
    }

    public void updatePosition(Position position){
        positionDao.update(position);
    }

    public List<Position> findAllPosition(){
        return positionDao.findAll();
    }
}
