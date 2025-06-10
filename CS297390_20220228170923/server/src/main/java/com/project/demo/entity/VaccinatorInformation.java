package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *接种者信息：(VaccinatorInformation)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "VaccinatorInformation")
public class VaccinatorInformation implements Serializable {

    //VaccinatorInformation编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vaccinator_information_id")
    private Integer vaccinator_information_id;
   // 编号
   @Basic
    private String number;
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
   // 用户账号
   @Basic
    private Integer user_account;

    // 更新时间
    @Basic
    private Timestamp update_time;

    // 创建时间
    @Basic
    private Timestamp create_time;

}
