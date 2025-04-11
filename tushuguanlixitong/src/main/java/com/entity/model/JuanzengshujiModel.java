package com.entity.model;

import com.entity.JuanzengshujiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 捐赠书籍
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class JuanzengshujiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 书籍名称
     */
    private String juanzengshujiName;


    /**
     * 书籍作者
     */
    private String juanzengshujiZuozhe;


    /**
     * 出版社
     */
    private String juanzengshujiChubanshe;


    /**
     * 书籍类型
     */
    private Integer shujigoumaiTypes;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 捐赠时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date juanzengshujiTime;


    /**
     * 创建时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date createTime;


    /**
	 * 获取：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 设置：主键
	 */
    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 获取：书籍名称
	 */
    public String getJuanzengshujiName() {
        return juanzengshujiName;
    }


    /**
	 * 设置：书籍名称
	 */
    public void setJuanzengshujiName(String juanzengshujiName) {
        this.juanzengshujiName = juanzengshujiName;
    }
    /**
	 * 获取：书籍作者
	 */
    public String getJuanzengshujiZuozhe() {
        return juanzengshujiZuozhe;
    }


    /**
	 * 设置：书籍作者
	 */
    public void setJuanzengshujiZuozhe(String juanzengshujiZuozhe) {
        this.juanzengshujiZuozhe = juanzengshujiZuozhe;
    }
    /**
	 * 获取：出版社
	 */
    public String getJuanzengshujiChubanshe() {
        return juanzengshujiChubanshe;
    }


    /**
	 * 设置：出版社
	 */
    public void setJuanzengshujiChubanshe(String juanzengshujiChubanshe) {
        this.juanzengshujiChubanshe = juanzengshujiChubanshe;
    }
    /**
	 * 获取：书籍类型
	 */
    public Integer getShujigoumaiTypes() {
        return shujigoumaiTypes;
    }


    /**
	 * 设置：书籍类型
	 */
    public void setShujigoumaiTypes(Integer shujigoumaiTypes) {
        this.shujigoumaiTypes = shujigoumaiTypes;
    }
    /**
	 * 获取：用户
	 */
    public Integer getYonghuId() {
        return yonghuId;
    }


    /**
	 * 设置：用户
	 */
    public void setYonghuId(Integer yonghuId) {
        this.yonghuId = yonghuId;
    }
    /**
	 * 获取：捐赠时间
	 */
    public Date getJuanzengshujiTime() {
        return juanzengshujiTime;
    }


    /**
	 * 设置：捐赠时间
	 */
    public void setJuanzengshujiTime(Date juanzengshujiTime) {
        this.juanzengshujiTime = juanzengshujiTime;
    }
    /**
	 * 获取：创建时间
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
