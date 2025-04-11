package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 书籍订单
 *
 * @author 
 * @email
 */
@TableName("shujigoumai_order")
public class ShujigoumaiOrderEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShujigoumaiOrderEntity() {

	}

	public ShujigoumaiOrderEntity(T t) {
		try {
			BeanUtils.copyProperties(this, t);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Integer id;


    /**
     * 订单号
     */
    @TableField(value = "shujigoumai_order_uuid_number")

    private String shujigoumaiOrderUuidNumber;


    /**
     * 书籍
     */
    @TableField(value = "shujigoumai_id")

    private Integer shujigoumaiId;


    /**
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 地址
     */
    @TableField(value = "address_id")

    private Integer addressId;


    /**
     * 购买的数量
     */
    @TableField(value = "buy_number")

    private Integer buyNumber;


    /**
     * 实付价格
     */
    @TableField(value = "shujigoumai_order_true_price")

    private Double shujigoumaiOrderTruePrice;


    /**
     * 订单类型
     */
    @TableField(value = "shujigoumai_order_types")

    private Integer shujigoumaiOrderTypes;


    /**
     * 支付类型
     */
    @TableField(value = "shujigoumai_order_payment_types")

    private Integer shujigoumaiOrderPaymentTypes;


    /**
     * 订单创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "insert_time",fill = FieldFill.INSERT)

    private Date insertTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "create_time",fill = FieldFill.INSERT)

    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：订单号
	 */
    public String getShujigoumaiOrderUuidNumber() {
        return shujigoumaiOrderUuidNumber;
    }


    /**
	 * 获取：订单号
	 */

    public void setShujigoumaiOrderUuidNumber(String shujigoumaiOrderUuidNumber) {
        this.shujigoumaiOrderUuidNumber = shujigoumaiOrderUuidNumber;
    }
    /**
	 * 设置：书籍
	 */
    public Integer getShujigoumaiId() {
        return shujigoumaiId;
    }


    /**
	 * 获取：书籍
	 */

    public void setShujigoumaiId(Integer shujigoumaiId) {
        this.shujigoumaiId = shujigoumaiId;
    }
    /**
	 * 设置：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 获取：用户
	 */

    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 设置：地址
	 */
    public Integer getAddressId() {
        return addressId;
    }


    /**
	 * 获取：地址
	 */

    public void setAddressId(Integer addressId) {
        this.addressId = addressId;
    }
    /**
	 * 设置：购买的数量
	 */
    public Integer getBuyNumber() {
        return buyNumber;
    }


    /**
	 * 获取：购买的数量
	 */

    public void setBuyNumber(Integer buyNumber) {
        this.buyNumber = buyNumber;
    }
    /**
	 * 设置：实付价格
	 */
    public Double getShujigoumaiOrderTruePrice() {
        return shujigoumaiOrderTruePrice;
    }


    /**
	 * 获取：实付价格
	 */

    public void setShujigoumaiOrderTruePrice(Double shujigoumaiOrderTruePrice) {
        this.shujigoumaiOrderTruePrice = shujigoumaiOrderTruePrice;
    }
    /**
	 * 设置：订单类型
	 */
    public Integer getShujigoumaiOrderTypes() {
        return shujigoumaiOrderTypes;
    }


    /**
	 * 获取：订单类型
	 */

    public void setShujigoumaiOrderTypes(Integer shujigoumaiOrderTypes) {
        this.shujigoumaiOrderTypes = shujigoumaiOrderTypes;
    }
    /**
	 * 设置：支付类型
	 */
    public Integer getShujigoumaiOrderPaymentTypes() {
        return shujigoumaiOrderPaymentTypes;
    }


    /**
	 * 获取：支付类型
	 */

    public void setShujigoumaiOrderPaymentTypes(Integer shujigoumaiOrderPaymentTypes) {
        this.shujigoumaiOrderPaymentTypes = shujigoumaiOrderPaymentTypes;
    }
    /**
	 * 设置：订单创建时间
	 */
    public Date getInsertTime() {
        return insertTime;
    }


    /**
	 * 获取：订单创建时间
	 */

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
    /**
	 * 设置：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "ShujigoumaiOrder{" +
            "id=" + id +
            ", shujigoumaiOrderUuidNumber=" + shujigoumaiOrderUuidNumber +
            ", shujigoumaiId=" + shujigoumaiId +
            ", yonghuId=" + yonghuId +
            ", addressId=" + addressId +
            ", buyNumber=" + buyNumber +
            ", shujigoumaiOrderTruePrice=" + shujigoumaiOrderTruePrice +
            ", shujigoumaiOrderTypes=" + shujigoumaiOrderTypes +
            ", shujigoumaiOrderPaymentTypes=" + shujigoumaiOrderPaymentTypes +
            ", insertTime=" + insertTime +
            ", createTime=" + createTime +
        "}";
    }
}
