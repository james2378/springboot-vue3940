package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *入库疫苗：(WarehousedVaccine)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "WarehousedVaccine")
public class WarehousedVaccine implements Serializable {

    //WarehousedVaccine编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "warehoused_vaccine_id")
    private Integer warehoused_vaccine_id;
   // 疫苗编号
   @Basic
    private String vaccine_number;
   // 疫苗类型
   @Basic
    private String vaccine_type;
   // 疫苗名称
   @Basic
    private String vaccine_name;
   // 入库时间
   @Basic
    private String warehousing_time;
   // 入库数量
   @Basic
    private Integer receipt_quantity;
   // 操作人
   @Basic
    private String operator;
   // 联系电话
   @Basic
    private String contact_number;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
