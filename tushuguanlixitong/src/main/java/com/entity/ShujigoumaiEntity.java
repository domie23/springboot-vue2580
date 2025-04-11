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
 * 书籍购买
 *
 * @author 
 * @email
 */
@TableName("shujigoumai")
public class ShujigoumaiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShujigoumaiEntity() {

	}

	public ShujigoumaiEntity(T t) {
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
     * 书籍编号
     */
    @TableField(value = "shujigoumai_uuid_number")

    private String shujigoumaiUuidNumber;


    /**
     * 书籍名称
     */
    @TableField(value = "shujigoumai_name")

    private String shujigoumaiName;


    /**
     * 书籍类型
     */
    @TableField(value = "shujigoumai_types")

    private Integer shujigoumaiTypes;


    /**
     * 书籍照片
     */
    @TableField(value = "shujigoumai_photo")

    private String shujigoumaiPhoto;


    /**
     * 书籍库存
     */
    @TableField(value = "shujigoumai_kucun_number")

    private Integer shujigoumaiKucunNumber;


    /**
     * 书籍作者
     */
    @TableField(value = "shujigoumai_zuozhe")

    private String shujigoumaiZuozhe;


    /**
     * 出版社
     */
    @TableField(value = "shujigoumai_chubanshe")

    private String shujigoumaiChubanshe;


    /**
     * 书籍原价
     */
    @TableField(value = "shujigoumai_old_money")

    private Double shujigoumaiOldMoney;


    /**
     * 现价
     */
    @TableField(value = "shujigoumai_new_money")

    private Double shujigoumaiNewMoney;


    /**
     * 是否上架
     */
    @TableField(value = "shangxia_types")

    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    @TableField(value = "shujigoumai_delete")

    private Integer shujigoumaiDelete;


    /**
     * 书籍简介
     */
    @TableField(value = "shujigoumai_content")

    private String shujigoumaiContent;


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
	 * 设置：书籍编号
	 */
    public String getShujigoumaiUuidNumber() {
        return shujigoumaiUuidNumber;
    }


    /**
	 * 获取：书籍编号
	 */

    public void setShujigoumaiUuidNumber(String shujigoumaiUuidNumber) {
        this.shujigoumaiUuidNumber = shujigoumaiUuidNumber;
    }
    /**
	 * 设置：书籍名称
	 */
    public String getShujigoumaiName() {
        return shujigoumaiName;
    }


    /**
	 * 获取：书籍名称
	 */

    public void setShujigoumaiName(String shujigoumaiName) {
        this.shujigoumaiName = shujigoumaiName;
    }
    /**
	 * 设置：书籍类型
	 */
    public Integer getShujigoumaiTypes() {
        return shujigoumaiTypes;
    }


    /**
	 * 获取：书籍类型
	 */

    public void setShujigoumaiTypes(Integer shujigoumaiTypes) {
        this.shujigoumaiTypes = shujigoumaiTypes;
    }
    /**
	 * 设置：书籍照片
	 */
    public String getShujigoumaiPhoto() {
        return shujigoumaiPhoto;
    }


    /**
	 * 获取：书籍照片
	 */

    public void setShujigoumaiPhoto(String shujigoumaiPhoto) {
        this.shujigoumaiPhoto = shujigoumaiPhoto;
    }
    /**
	 * 设置：书籍库存
	 */
    public Integer getShujigoumaiKucunNumber() {
        return shujigoumaiKucunNumber;
    }


    /**
	 * 获取：书籍库存
	 */

    public void setShujigoumaiKucunNumber(Integer shujigoumaiKucunNumber) {
        this.shujigoumaiKucunNumber = shujigoumaiKucunNumber;
    }
    /**
	 * 设置：书籍作者
	 */
    public String getShujigoumaiZuozhe() {
        return shujigoumaiZuozhe;
    }


    /**
	 * 获取：书籍作者
	 */

    public void setShujigoumaiZuozhe(String shujigoumaiZuozhe) {
        this.shujigoumaiZuozhe = shujigoumaiZuozhe;
    }
    /**
	 * 设置：出版社
	 */
    public String getShujigoumaiChubanshe() {
        return shujigoumaiChubanshe;
    }


    /**
	 * 获取：出版社
	 */

    public void setShujigoumaiChubanshe(String shujigoumaiChubanshe) {
        this.shujigoumaiChubanshe = shujigoumaiChubanshe;
    }
    /**
	 * 设置：书籍原价
	 */
    public Double getShujigoumaiOldMoney() {
        return shujigoumaiOldMoney;
    }


    /**
	 * 获取：书籍原价
	 */

    public void setShujigoumaiOldMoney(Double shujigoumaiOldMoney) {
        this.shujigoumaiOldMoney = shujigoumaiOldMoney;
    }
    /**
	 * 设置：现价
	 */
    public Double getShujigoumaiNewMoney() {
        return shujigoumaiNewMoney;
    }


    /**
	 * 获取：现价
	 */

    public void setShujigoumaiNewMoney(Double shujigoumaiNewMoney) {
        this.shujigoumaiNewMoney = shujigoumaiNewMoney;
    }
    /**
	 * 设置：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 获取：是否上架
	 */

    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getShujigoumaiDelete() {
        return shujigoumaiDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setShujigoumaiDelete(Integer shujigoumaiDelete) {
        this.shujigoumaiDelete = shujigoumaiDelete;
    }
    /**
	 * 设置：书籍简介
	 */
    public String getShujigoumaiContent() {
        return shujigoumaiContent;
    }


    /**
	 * 获取：书籍简介
	 */

    public void setShujigoumaiContent(String shujigoumaiContent) {
        this.shujigoumaiContent = shujigoumaiContent;
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
        return "Shujigoumai{" +
            "id=" + id +
            ", shujigoumaiUuidNumber=" + shujigoumaiUuidNumber +
            ", shujigoumaiName=" + shujigoumaiName +
            ", shujigoumaiTypes=" + shujigoumaiTypes +
            ", shujigoumaiPhoto=" + shujigoumaiPhoto +
            ", shujigoumaiKucunNumber=" + shujigoumaiKucunNumber +
            ", shujigoumaiZuozhe=" + shujigoumaiZuozhe +
            ", shujigoumaiChubanshe=" + shujigoumaiChubanshe +
            ", shujigoumaiOldMoney=" + shujigoumaiOldMoney +
            ", shujigoumaiNewMoney=" + shujigoumaiNewMoney +
            ", shangxiaTypes=" + shangxiaTypes +
            ", shujigoumaiDelete=" + shujigoumaiDelete +
            ", shujigoumaiContent=" + shujigoumaiContent +
            ", createTime=" + createTime +
        "}";
    }
}
