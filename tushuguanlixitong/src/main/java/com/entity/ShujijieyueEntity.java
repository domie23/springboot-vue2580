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
 * 书籍借阅记录
 *
 * @author 
 * @email
 */
@TableName("shujijieyue")
public class ShujijieyueEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public ShujijieyueEntity() {

	}

	public ShujijieyueEntity(T t) {
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
     * 书籍
     */
    @TableField(value = "shujixinxi_id")

    private Integer shujixinxiId;


    /**
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 借阅状态
     */
    @TableField(value = "jieyue_types")

    private Integer jieyueTypes;


    /**
     * 借书时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "shujijieyuejie_time")

    private Date shujijieyuejieTime;


    /**
     * 还书时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "shujijieyuehuan_time")

    private Date shujijieyuehuanTime;


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
	 * 设置：书籍
	 */
    public Integer getShujixinxiId() {
        return shujixinxiId;
    }


    /**
	 * 获取：书籍
	 */

    public void setShujixinxiId(Integer shujixinxiId) {
        this.shujixinxiId = shujixinxiId;
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
	 * 设置：借阅状态
	 */
    public Integer getJieyueTypes() {
        return jieyueTypes;
    }


    /**
	 * 获取：借阅状态
	 */

    public void setJieyueTypes(Integer jieyueTypes) {
        this.jieyueTypes = jieyueTypes;
    }
    /**
	 * 设置：借书时间
	 */
    public Date getShujijieyuejieTime() {
        return shujijieyuejieTime;
    }


    /**
	 * 获取：借书时间
	 */

    public void setShujijieyuejieTime(Date shujijieyuejieTime) {
        this.shujijieyuejieTime = shujijieyuejieTime;
    }
    /**
	 * 设置：还书时间
	 */
    public Date getShujijieyuehuanTime() {
        return shujijieyuehuanTime;
    }


    /**
	 * 获取：还书时间
	 */

    public void setShujijieyuehuanTime(Date shujijieyuehuanTime) {
        this.shujijieyuehuanTime = shujijieyuehuanTime;
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
        return "Shujijieyue{" +
            "id=" + id +
            ", shujixinxiId=" + shujixinxiId +
            ", yonghuId=" + yonghuId +
            ", jieyueTypes=" + jieyueTypes +
            ", shujijieyuejieTime=" + shujijieyuejieTime +
            ", shujijieyuehuanTime=" + shujijieyuehuanTime +
            ", createTime=" + createTime +
        "}";
    }
}
