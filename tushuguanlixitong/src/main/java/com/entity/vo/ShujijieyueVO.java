package com.entity.vo;

import com.entity.ShujijieyueEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 书籍借阅记录
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("shujijieyue")
public class ShujijieyueVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "create_time")
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

}
