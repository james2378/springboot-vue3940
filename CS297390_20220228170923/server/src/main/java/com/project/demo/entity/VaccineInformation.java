package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *疫苗信息：(VaccineInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "VaccineInformation")
public class VaccineInformation implements Serializable {

    //VaccineInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vaccine_information_id")
    private Integer vaccine_information_id;
   // 疫苗编号
   @Basic
    private String vaccine_number;
   // 疫苗类型
   @Basic
    private String vaccine_type;
   // 疫苗名称
   @Basic
    private String vaccine_name;
   // 适合人群
   @Basic
    private String suitable_for_people;
   // 疫苗出产地
   @Basic
    private String vaccine_producing_area;
   // 图片
   @Basic
    private String picture;
   // 库存
   @Basic
    private Integer stock;
   // 疫苗简介
   @Basic
    private String vaccine_introduction;
   // 副作用
   @Basic
    private String side_effect;
    // 点击数
    @Basic
    private Integer hits;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
