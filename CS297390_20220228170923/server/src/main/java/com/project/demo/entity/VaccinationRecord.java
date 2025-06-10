package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *接种记录：(VaccinationRecord)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "VaccinationRecord")
public class VaccinationRecord implements Serializable {

    //VaccinationRecord编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vaccination_record_id")
    private Integer vaccination_record_id;
   // 疫苗编号
   @Basic
    private String vaccine_number;
   // 疫苗类型
   @Basic
    private String vaccine_type;
   // 疫苗名称
   @Basic
    private String vaccine_name;
   // 疫苗批次
   @Basic
    private String vaccine_batch;
   // 接种者姓名
   @Basic
    private String name_of_vaccinator;
   // 性别
   @Basic
    private String gender;
   // 年龄
   @Basic
    private String age;
   // 关系
   @Basic
    private String relationship;
   // 预约人
   @Basic
    private Integer appointment_person;
   // 接种时间
   @Basic
    private String inoculation_time;
   // 接种地点
   @Basic
    private String vaccination_site;
   // 留观时间
   @Basic
    private String observation_time;
   // 接种情况
   @Basic
    private String vaccination_status;
   // 禁忌症
   @Basic
    private String contraindication;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
