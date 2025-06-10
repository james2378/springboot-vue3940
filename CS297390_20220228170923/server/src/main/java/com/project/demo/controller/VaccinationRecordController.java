package com.project.demo.controller;

import com.project.demo.entity.VaccinationRecord;
import com.project.demo.service.VaccinationRecordService;
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
 *接种记录：(VaccinationRecord)表控制层
 *
 */
@RestController
@RequestMapping("/vaccination_record")
public class VaccinationRecordController extends BaseController<VaccinationRecord,VaccinationRecordService> {

    /**
     *接种记录对象
     */
    @Autowired
    public VaccinationRecordController(VaccinationRecordService service) {
        setService(service);
    }

    @PostMapping("/add")
    @Transactional
    public Map<String, Object> add(HttpServletRequest request) throws IOException {
        Map<String,Object> paramMap = service.readBody(request.getReader());
        this.addMap(paramMap);
        return success(1);
    }

}
