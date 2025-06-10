package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *出库疫苗：(VaccineDelivery)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "VaccineDelivery")
public class VaccineDelivery implements Serializable {

    //VaccineDelivery编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vaccine_delivery_id")
    private Integer vaccine_delivery_id;
   // 疫苗编号
   @Basic
    private String vaccine_number;
   // 疫苗类型
   @Basic
    private String vaccine_type;
   // 疫苗名称
   @Basic
    private String vaccine_name;
   // 出库时间
   @Basic
    private String delivery_time;
   // 出库数量
   @Basic
    private Integer outbound_quantity;
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
