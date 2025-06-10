package com.project.demo.entity;

import java.sql.Date;
import java.sql.Timestamp;
import com.project.demo.entity.base.BaseEntity;
import java.io.Serializable;
import lombok.*;
import javax.persistence.*;


/**
 *预约计划：(ReservationPlan)表实体类
 *
 */
@Setter
@Getter
@Entity(name = "ReservationPlan")
public class ReservationPlan implements Serializable {

    //ReservationPlan编号
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reservation_plan_id")
    private Integer reservation_plan_id;
   // 疫苗编号
   @Basic
    private String vaccine_number;
   // 疫苗类型
   @Basic
    private String vaccine_type;
   // 疫苗名称
   @Basic
    private String vaccine_name;
   // 接种时间
   @Basic
    private String inoculation_time;
   // 接种地点
   @Basic
    private String vaccination_site;
   // 疫苗批次
   @Basic
    private String vaccine_batch;
   // 图片
   @Basic
    private String picture;
   // 注意事项
   @Basic
    private String matters_needing_attention;
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
