package com.stylefeng.guns.modular.system.model;

import java.io.Serializable;

import com.baomidou.mybatisplus.enums.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableName;

/**
 * <p>
 * 菜单摘要
 * </p>
 *
 * @author tuoxin123
 * @since 2018-04-09
 */
@TableName("bus_dish_menu")
public class DishMenu extends Model<DishMenu> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 饭店id
     */
    @TableField("restaurant_id")
    private Long restaurantId;
    /**
     * 饭店名称
     */
    private Long name;
    /**
     * 消费时间
     */
    @TableField("oeder_time")
    private Date oederTime;
    /**
     * 消费总额
     */
    private Float amount;
    /**
     * 是否有效
     */
    private Integer yn;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 修改人
     */
    @TableField("moidfied_user")
    private String moidfiedUser;
    /**
     * 创建时间
     */
    @TableField("created_time")
    private Date createdTime;
    /**
     * 修改时间
     */
    @TableField("modified_time")
    private Date modifiedTime;
    /**
     * 备注
     */
    private String remark;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRestaurantId() {
        return restaurantId;
    }

    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    public Long getName() {
        return name;
    }

    public void setName(Long name) {
        this.name = name;
    }

    public Date getOederTime() {
        return oederTime;
    }

    public void setOederTime(Date oederTime) {
        this.oederTime = oederTime;
    }

    public Float getAmount() {
        return amount;
    }

    public void setAmount(Float amount) {
        this.amount = amount;
    }

    public Integer getYn() {
        return yn;
    }

    public void setYn(Integer yn) {
        this.yn = yn;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMoidfiedUser() {
        return moidfiedUser;
    }

    public void setMoidfiedUser(String moidfiedUser) {
        this.moidfiedUser = moidfiedUser;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "DishMenu{" +
        "id=" + id +
        ", restaurantId=" + restaurantId +
        ", name=" + name +
        ", oederTime=" + oederTime +
        ", amount=" + amount +
        ", yn=" + yn +
        ", status=" + status +
        ", moidfiedUser=" + moidfiedUser +
        ", createdTime=" + createdTime +
        ", modifiedTime=" + modifiedTime +
        ", remark=" + remark +
        "}";
    }
}
