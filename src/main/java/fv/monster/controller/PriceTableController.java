package fv.monster.controller;

import fv.monster.model.PriceTable;
import fv.monster.service.PriceTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class PriceTableController {

    @Autowired
    PriceTableService priceTableService;

    @RequestMapping(value = "/pricetable", method = RequestMethod.GET)
    public PriceTable getPriceTable() {
        return priceTableService.getPriceTable();
    }

    @RequestMapping(value = "/admin/pricetable", method = RequestMethod.POST)
    public PriceTable setPriceTable(@RequestBody PriceTable priceTable) {
        return priceTableService.updatePriceTable(priceTable);
    }
}
