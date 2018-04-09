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
 * 饭店信息
 * </p>
 *
 * @author tuoxin123
 * @since 2018-04-09
 */
@TableName("bus_restaurant")
public class Restaurant extends Model<Restaurant> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 饭店名称
     */
    private Long name;
    /**
     * 饭店地址
     */
    private String address;
    /**
     * 店主
     */
    private String onwer;
    /**
     * 规模
     */
    private String scale;
    /**
     * 联系电话
     */
    private String phone;
    /**
     * 用户id
     */
    @TableField("user_id")
    private Long userId;
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

    public Long getName() {
        return name;
    }

    public void setName(Long name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOnwer() {
        return onwer;
    }

    public void setOnwer(String onwer) {
        this.onwer = onwer;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
        return "Restaurant{" +
        "id=" + id +
        ", name=" + name +
        ", address=" + address +
        ", onwer=" + onwer +
        ", scale=" + scale +
        ", phone=" + phone +
        ", userId=" + userId +
        ", yn=" + yn +
        ", status=" + status +
        ", moidfiedUser=" + moidfiedUser +
        ", createdTime=" + createdTime +
        ", modifiedTime=" + modifiedTime +
        ", remark=" + remark +
        "}";
    }
}
