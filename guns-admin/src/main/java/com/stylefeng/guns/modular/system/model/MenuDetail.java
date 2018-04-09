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
 * 菜单及评价信息
 * </p>
 *
 * @author tuoxin123
 * @since 2018-04-09
 */
@TableName("bus_menu_detail")
public class MenuDetail extends Model<MenuDetail> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 菜单id
     */
    @TableField("menu_id")
    private Long menuId;
    /**
     * 菜品id
     */
    @TableField("dish_id")
    private Long dishId;
    /**
     * 菜名
     */
    @TableField("dish_name")
    private String dishName;
    /**
     * 评分
     */
    private Date score;
    /**
     * 评分
     */
    private Date appraise;
    /**
     * 单价
     */
    private Float price;
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

    public Long getMenuId() {
        return menuId;
    }

    public void setMenuId(Long menuId) {
        this.menuId = menuId;
    }

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public Date getScore() {
        return score;
    }

    public void setScore(Date score) {
        this.score = score;
    }

    public Date getAppraise() {
        return appraise;
    }

    public void setAppraise(Date appraise) {
        this.appraise = appraise;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
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
        return "MenuDetail{" +
        "id=" + id +
        ", menuId=" + menuId +
        ", dishId=" + dishId +
        ", dishName=" + dishName +
        ", score=" + score +
        ", appraise=" + appraise +
        ", price=" + price +
        ", yn=" + yn +
        ", status=" + status +
        ", moidfiedUser=" + moidfiedUser +
        ", createdTime=" + createdTime +
        ", modifiedTime=" + modifiedTime +
        ", remark=" + remark +
        "}";
    }
}
