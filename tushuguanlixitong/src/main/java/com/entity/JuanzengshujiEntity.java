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
 * 捐赠书籍
 *
 * @author 
 * @email
 */
@TableName("juanzengshuji")
public class JuanzengshujiEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


	public JuanzengshujiEntity() {

	}

	public JuanzengshujiEntity(T t) {
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
     * 书籍名称
     */
    @TableField(value = "juanzengshuji_name")

    private String juanzengshujiName;


    /**
     * 书籍作者
     */
    @TableField(value = "juanzengshuji_zuozhe")

    private String juanzengshujiZuozhe;


    /**
     * 出版社
     */
    @TableField(value = "juanzengshuji_chubanshe")

    private String juanzengshujiChubanshe;


    /**
     * 书籍类型
     */
    @TableField(value = "shujigoumai_types")

    private Integer shujigoumaiTypes;


    /**
     * 用户
     */
    @TableField(value = "yonghu_id")

    private Integer yonghuId;


    /**
     * 捐赠时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "juanzengshuji_time")

    private Date juanzengshujiTime;


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
	 * 设置：书籍名称
	 */
    public String getJuanzengshujiName() {
        return juanzengshujiName;
    }


    /**
	 * 获取：书籍名称
	 */

    public void setJuanzengshujiName(String juanzengshujiName) {
        this.juanzengshujiName = juanzengshujiName;
    }
    /**
	 * 设置：书籍作者
	 */
    public String getJuanzengshujiZuozhe() {
        return juanzengshujiZuozhe;
    }


    /**
	 * 获取：书籍作者
	 */

    public void setJuanzengshujiZuozhe(String juanzengshujiZuozhe) {
        this.juanzengshujiZuozhe = juanzengshujiZuozhe;
    }
    /**
	 * 设置：出版社
	 */
    public String getJuanzengshujiChubanshe() {
        return juanzengshujiChubanshe;
    }


    /**
	 * 获取：出版社
	 */

    public void setJuanzengshujiChubanshe(String juanzengshujiChubanshe) {
        this.juanzengshujiChubanshe = juanzengshujiChubanshe;
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
	 * 设置：捐赠时间
	 */
    public Date getJuanzengshujiTime() {
        return juanzengshujiTime;
    }


    /**
	 * 获取：捐赠时间
	 */

    public void setJuanzengshujiTime(Date juanzengshujiTime) {
        this.juanzengshujiTime = juanzengshujiTime;
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
        return "Juanzengshuji{" +
            "id=" + id +
            ", juanzengshujiName=" + juanzengshujiName +
            ", juanzengshujiZuozhe=" + juanzengshujiZuozhe +
            ", juanzengshujiChubanshe=" + juanzengshujiChubanshe +
            ", shujigoumaiTypes=" + shujigoumaiTypes +
            ", yonghuId=" + yonghuId +
            ", juanzengshujiTime=" + juanzengshujiTime +
            ", createTime=" + createTime +
        "}";
    }
}
