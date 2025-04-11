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
 * 书籍信息
 *
 * @author 
 * @email
 */
@TableName("shujixinxi")
public class ShujixinxiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShujixinxiEntity() {

	}

	public ShujixinxiEntity(T t) {
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
    @TableField(value = "shujixinxi_uuid_number")

    private String shujixinxiUuidNumber;


    /**
     * 书籍名称
     */
    @TableField(value = "shujixinxi_name")

    private String shujixinxiName;


    /**
     * 书籍类型
     */
    @TableField(value = "shujigoumai_types")

    private Integer shujigoumaiTypes;


    /**
     * 书籍照片
     */
    @TableField(value = "shujixinxi_photo")

    private String shujixinxiPhoto;


    /**
     * 书籍库存
     */
    @TableField(value = "shujixinxi_kucun_number")

    private Integer shujixinxiKucunNumber;


    /**
     * 书籍作者
     */
    @TableField(value = "shujixinxi_zuozhe")

    private String shujixinxiZuozhe;


    /**
     * 出版社
     */
    @TableField(value = "shujixinxi_chubanshe")

    private String shujixinxiChubanshe;


    /**
     * 逻辑删除
     */
    @TableField(value = "shujixinxi_delete")

    private Integer shujixinxiDelete;


    /**
     * 书籍简介
     */
    @TableField(value = "shujixinxi_content")

    private String shujixinxiContent;


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
    public String getShujixinxiUuidNumber() {
        return shujixinxiUuidNumber;
    }


    /**
	 * 获取：书籍编号
	 */

    public void setShujixinxiUuidNumber(String shujixinxiUuidNumber) {
        this.shujixinxiUuidNumber = shujixinxiUuidNumber;
    }
    /**
	 * 设置：书籍名称
	 */
    public String getShujixinxiName() {
        return shujixinxiName;
    }


    /**
	 * 获取：书籍名称
	 */

    public void setShujixinxiName(String shujixinxiName) {
        this.shujixinxiName = shujixinxiName;
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
    public String getShujixinxiPhoto() {
        return shujixinxiPhoto;
    }


    /**
	 * 获取：书籍照片
	 */

    public void setShujixinxiPhoto(String shujixinxiPhoto) {
        this.shujixinxiPhoto = shujixinxiPhoto;
    }
    /**
	 * 设置：书籍库存
	 */
    public Integer getShujixinxiKucunNumber() {
        return shujixinxiKucunNumber;
    }


    /**
	 * 获取：书籍库存
	 */

    public void setShujixinxiKucunNumber(Integer shujixinxiKucunNumber) {
        this.shujixinxiKucunNumber = shujixinxiKucunNumber;
    }
    /**
	 * 设置：书籍作者
	 */
    public String getShujixinxiZuozhe() {
        return shujixinxiZuozhe;
    }


    /**
	 * 获取：书籍作者
	 */

    public void setShujixinxiZuozhe(String shujixinxiZuozhe) {
        this.shujixinxiZuozhe = shujixinxiZuozhe;
    }
    /**
	 * 设置：出版社
	 */
    public String getShujixinxiChubanshe() {
        return shujixinxiChubanshe;
    }


    /**
	 * 获取：出版社
	 */

    public void setShujixinxiChubanshe(String shujixinxiChubanshe) {
        this.shujixinxiChubanshe = shujixinxiChubanshe;
    }
    /**
	 * 设置：逻辑删除
	 */
    public Integer getShujixinxiDelete() {
        return shujixinxiDelete;
    }


    /**
	 * 获取：逻辑删除
	 */

    public void setShujixinxiDelete(Integer shujixinxiDelete) {
        this.shujixinxiDelete = shujixinxiDelete;
    }
    /**
	 * 设置：书籍简介
	 */
    public String getShujixinxiContent() {
        return shujixinxiContent;
    }


    /**
	 * 获取：书籍简介
	 */

    public void setShujixinxiContent(String shujixinxiContent) {
        this.shujixinxiContent = shujixinxiContent;
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
        return "Shujixinxi{" +
            "id=" + id +
            ", shujixinxiUuidNumber=" + shujixinxiUuidNumber +
            ", shujixinxiName=" + shujixinxiName +
            ", shujigoumaiTypes=" + shujigoumaiTypes +
            ", shujixinxiPhoto=" + shujixinxiPhoto +
            ", shujixinxiKucunNumber=" + shujixinxiKucunNumber +
            ", shujixinxiZuozhe=" + shujixinxiZuozhe +
            ", shujixinxiChubanshe=" + shujixinxiChubanshe +
            ", shujixinxiDelete=" + shujixinxiDelete +
            ", shujixinxiContent=" + shujixinxiContent +
            ", createTime=" + createTime +
        "}";
    }
}
