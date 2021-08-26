package com.ExcelWeb.service;

import com.ExcelWeb.dao.AddressesDao;
import com.ExcelWeb.models.Addresses;

import java.util.List;

public class AddressesService {
    private AddressesDao addressesDao = new AddressesDao();

    public Addresses findById(int id){
        return addressesDao.findById(id);
    }

    public void saveAddressesDao(Addresses addresses){
        addressesDao.save(addresses);
    }

    public void deleteAddresses(Addresses addresses){
        addressesDao.delete(addresses);
    }

    public void updateAddresses(Addresses addresses){
        addressesDao.update(addresses);
    }

    public List<Addresses> findAllAddresses(){
        return addressesDao.findAll();
    }

    public List<Addresses> findSampleUnique(String term){
        return addressesDao.findSampleUnique(term);
    }

    public List<Addresses> findSample(String term, String company){
        return addressesDao.findSample(term, company);
    }
}
