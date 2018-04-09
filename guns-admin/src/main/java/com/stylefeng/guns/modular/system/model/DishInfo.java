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
 * 菜品信息
 * </p>
 *
 * @author tuoxin123
 * @since 2018-04-09
 */
@TableName("bus_dish_info")
public class DishInfo extends Model<DishInfo> {

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
     * 菜名
     */
    @TableField("dish_name")
    private String dishName;
    /**
     * 种类
     */
    private String type;
    /**
     * 菜品图片
     */
    private String picture;
    /**
     * 口味
     */
    private String tasty;
    /**
     * 单价
     */
    private Float price;
    /**
     * 平均得分
     */
    @TableField("average_score")
    private Float averageScore;
    /**
     * 评价次数
     */
    @TableField("score_times")
    private Long scoreTimes;
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

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public String getTasty() {
        return tasty;
    }

    public void setTasty(String tasty) {
        this.tasty = tasty;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Float getAverageScore() {
        return averageScore;
    }

    public void setAverageScore(Float averageScore) {
        this.averageScore = averageScore;
    }

    public Long getScoreTimes() {
        return scoreTimes;
    }

    public void setScoreTimes(Long scoreTimes) {
        this.scoreTimes = scoreTimes;
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
        return "DishInfo{" +
        "id=" + id +
        ", restaurantId=" + restaurantId +
        ", dishName=" + dishName +
        ", type=" + type +
        ", picture=" + picture +
        ", tasty=" + tasty +
        ", price=" + price +
        ", averageScore=" + averageScore +
        ", scoreTimes=" + scoreTimes +
        ", yn=" + yn +
        ", status=" + status +
        ", moidfiedUser=" + moidfiedUser +
        ", createdTime=" + createdTime +
        ", modifiedTime=" + modifiedTime +
        ", remark=" + remark +
        "}";
    }
}
