package com.ExcelWeb.controllers.tables;

import com.ExcelWeb.models.Addresses;
import com.ExcelWeb.models.TypeWork;
import com.ExcelWeb.service.AddressesService;
import com.ExcelWeb.service.TypeWorkService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AddressRESTController {

    private AddressesService addressesService = new AddressesService();

    @RequestMapping(path="/api/addresses", method=RequestMethod.GET)
    public List<Addresses> getAllAddresses(){
        return addressesService.findAllAddresses();
    }

    @RequestMapping(value = "/api/addresses/DELETE/{id}", method = RequestMethod.GET)
    public Addresses deleteAddressesById(@PathVariable("id") int id){
        Addresses addresses = addressesService.findById(id);
        addressesService.deleteAddresses(addresses);
        return addresses;
    }

    @RequestMapping(value = "/api/addresses/POST/{id}", method = RequestMethod.GET)
    public Addresses postAddressesById(@PathVariable("id") int id,
                                       @RequestParam(name = "shortaddress") String shortaddress,
                                       @RequestParam(name = "chairman") String chairman,
                                       @RequestParam(name = "fulladdress") String fulladdress,
                                       @RequestParam(name = "requisites") String requisites,
                                       @RequestParam(name = "organization") String organization){
        Addresses addresses = addressesService.findById(id);
        addresses.setChairman(chairman);
        addresses.setOrganization(organization);
        addresses.setShortaddress(shortaddress);
        addresses.setFulladdress(fulladdress);
        addresses.setRequisites(requisites);
        addressesService.updateAddresses(addresses);
        return addresses;
    }

    @RequestMapping(value = "/api/addresses/PUT", method = RequestMethod.GET)
    public Addresses putAddressesById(@RequestParam(name = "shortaddress") String shortaddress,
                                      @RequestParam(name = "chairman") String chairman,
                                      @RequestParam(name = "fulladdress") String fulladdress,
                                      @RequestParam(name = "requisites") String requisites,
                                      @RequestParam(name = "organization") String organization){
        Addresses addresses = new Addresses();
        addresses.setChairman(chairman);
        addresses.setOrganization(organization);
        addresses.setShortaddress(shortaddress);
        addresses.setFulladdress(fulladdress);
        addresses.setRequisites(requisites);
        addressesService.saveAddressesDao(addresses);
        return addresses;
    }



}