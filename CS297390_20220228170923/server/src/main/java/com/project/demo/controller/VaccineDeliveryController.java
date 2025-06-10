package com.project.demo.controller;

import com.project.demo.entity.VaccineDelivery;
import com.project.demo.service.VaccineDeliveryService;
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
 *出库疫苗：(VaccineDelivery)表控制层
 *
 */
@RestController
@RequestMapping("/vaccine_delivery")
public class VaccineDeliveryController extends BaseController<VaccineDelivery,VaccineDeliveryService> {

    /**
     *出库疫苗对象
     */
    @Autowired
    public VaccineDeliveryController(VaccineDeliveryService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        String sql = "SELECT MAX(vaccine_delivery_id) AS max FROM "+"vaccine_delivery";
        Query select = service.runCountSql(sql);
        Integer max = (Integer) select.getSingleResult();
        sql = "UPDATE `vaccine_information` INNER JOIN `vaccine_delivery` ON vaccine_information.vaccine_number=vaccine_delivery.vaccine_number SET vaccine_information.stock = vaccine_information.stock - vaccine_delivery.outbound_quantity WHERE vaccine_delivery.vaccine_delivery_id="+max;
        select = service.runCountSql(sql);
        select.executeUpdate();
        return success(1);
    }

}
