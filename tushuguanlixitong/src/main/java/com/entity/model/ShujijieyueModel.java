package com.entity.model;

import com.entity.ShujijieyueEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 书籍借阅记录
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShujijieyueModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 书籍
     */
    private Integer shujixinxiId;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 借阅状态
     */
    private Integer jieyueTypes;


    /**
     * 借书时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date shujijieyuejieTime;


    /**
     * 还书时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date shujijieyuehuanTime;


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
	 * 获取：书籍
	 */
    public Integer getShujixinxiId() {
        return shujixinxiId;
    }


    /**
	 * 设置：书籍
	 */
    public void setShujixinxiId(Integer shujixinxiId) {
        this.shujixinxiId = shujixinxiId;
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
	 * 获取：借阅状态
	 */
    public Integer getJieyueTypes() {
        return jieyueTypes;
    }


    /**
	 * 设置：借阅状态
	 */
    public void setJieyueTypes(Integer jieyueTypes) {
        this.jieyueTypes = jieyueTypes;
    }
    /**
	 * 获取：借书时间
	 */
    public Date getShujijieyuejieTime() {
        return shujijieyuejieTime;
    }


    /**
	 * 设置：借书时间
	 */
    public void setShujijieyuejieTime(Date shujijieyuejieTime) {
        this.shujijieyuejieTime = shujijieyuejieTime;
    }
    /**
	 * 获取：还书时间
	 */
    public Date getShujijieyuehuanTime() {
        return shujijieyuehuanTime;
    }


    /**
	 * 设置：还书时间
	 */
    public void setShujijieyuehuanTime(Date shujijieyuehuanTime) {
        this.shujijieyuehuanTime = shujijieyuehuanTime;
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
