package com.project.demo.controller;

import com.project.demo.entity.WarehousedVaccine;
import com.project.demo.service.WarehousedVaccineService;
import com.project.demo.controller.base.BaseController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.persistence.Query;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 *入库疫苗：(WarehousedVaccine)表控制层
 *
 */
@RestController
@RequestMapping("/warehoused_vaccine")
public class WarehousedVaccineController extends BaseController<WarehousedVaccine,WarehousedVaccineService> {

    /**
     *入库疫苗对象
     */
    @Autowired
    public WarehousedVaccineController(WarehousedVaccineService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        String sql = "SELECT MAX(warehoused_vaccine_id) AS max FROM "+"warehoused_vaccine";
        Query select = service.runCountSql(sql);
        Integer max = (Integer) select.getSingleResult();
        sql = "UPDATE `vaccine_information` INNER JOIN `warehoused_vaccine` ON vaccine_information.vaccine_number=warehoused_vaccine.vaccine_number SET vaccine_information.stock = vaccine_information.stock + warehoused_vaccine.receipt_quantity WHERE warehoused_vaccine.warehoused_vaccine_id="+max;
        select = service.runCountSql(sql);
        select.executeUpdate();
        return success(1);
    }

}
