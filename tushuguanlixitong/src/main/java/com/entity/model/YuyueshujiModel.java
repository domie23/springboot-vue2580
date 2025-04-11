package com.entity.model;

import com.entity.YuyueshujiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 预约书籍
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class YuyueshujiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 书籍名称
     */
    private String yuyueshujiName;


    /**
     * 书籍作者
     */
    private String yuyueshujiZuozhe;


    /**
     * 出版社
     */
    private String yuyueshujiChubanshe;


    /**
     * 书籍类型
     */
    private Integer shujigoumaiTypes;


    /**
     * 用户
     */
    private Integer yonghuId;


    /**
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date yuyueshujiTime;


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
    public String getYuyueshujiName() {
        return yuyueshujiName;
    }


    /**
	 * 设置：书籍名称
	 */
    public void setYuyueshujiName(String yuyueshujiName) {
        this.yuyueshujiName = yuyueshujiName;
    }
    /**
	 * 获取：书籍作者
	 */
    public String getYuyueshujiZuozhe() {
        return yuyueshujiZuozhe;
    }


    /**
	 * 设置：书籍作者
	 */
    public void setYuyueshujiZuozhe(String yuyueshujiZuozhe) {
        this.yuyueshujiZuozhe = yuyueshujiZuozhe;
    }
    /**
	 * 获取：出版社
	 */
    public String getYuyueshujiChubanshe() {
        return yuyueshujiChubanshe;
    }


    /**
	 * 设置：出版社
	 */
    public void setYuyueshujiChubanshe(String yuyueshujiChubanshe) {
        this.yuyueshujiChubanshe = yuyueshujiChubanshe;
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
	 * 获取：预约时间
	 */
    public Date getYuyueshujiTime() {
        return yuyueshujiTime;
    }


    /**
	 * 设置：预约时间
	 */
    public void setYuyueshujiTime(Date yuyueshujiTime) {
        this.yuyueshujiTime = yuyueshujiTime;
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
