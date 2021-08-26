package com.ExcelWeb.service;

import com.ExcelWeb.models.RecordArray;

import java.util.ArrayList;
import java.util.List;

public class RecordArrayService {
    private List<RecordArray> records = new ArrayList<>();

    public RecordArrayService(List<RecordArray> records) {
        this.records = records;
    }

    public RecordArrayService() {
        for (int i = 0; i<10; i++){
            addRecord(new RecordArray());
        }
    }


    public void addRecord(RecordArray record){
        this.records.add(record);
    }

    public List<RecordArray> getRecords() {
        return records;
    }

    public void setRecords(List<RecordArray> records) {
        this.records = records;
    }
}
