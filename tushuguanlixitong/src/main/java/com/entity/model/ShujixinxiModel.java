package com.entity.model;

import com.entity.ShujixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 书籍信息
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShujixinxiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 书籍编号
     */
    private String shujixinxiUuidNumber;


    /**
     * 书籍名称
     */
    private String shujixinxiName;


    /**
     * 书籍类型
     */
    private Integer shujigoumaiTypes;


    /**
     * 书籍照片
     */
    private String shujixinxiPhoto;


    /**
     * 书籍库存
     */
    private Integer shujixinxiKucunNumber;


    /**
     * 书籍作者
     */
    private String shujixinxiZuozhe;


    /**
     * 出版社
     */
    private String shujixinxiChubanshe;


    /**
     * 逻辑删除
     */
    private Integer shujixinxiDelete;


    /**
     * 书籍简介
     */
    private String shujixinxiContent;


    /**
     * 创建时间  show1 show2 photoShow
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
	 * 获取：书籍编号
	 */
    public String getShujixinxiUuidNumber() {
        return shujixinxiUuidNumber;
    }


    /**
	 * 设置：书籍编号
	 */
    public void setShujixinxiUuidNumber(String shujixinxiUuidNumber) {
        this.shujixinxiUuidNumber = shujixinxiUuidNumber;
    }
    /**
	 * 获取：书籍名称
	 */
    public String getShujixinxiName() {
        return shujixinxiName;
    }


    /**
	 * 设置：书籍名称
	 */
    public void setShujixinxiName(String shujixinxiName) {
        this.shujixinxiName = shujixinxiName;
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
	 * 获取：书籍照片
	 */
    public String getShujixinxiPhoto() {
        return shujixinxiPhoto;
    }


    /**
	 * 设置：书籍照片
	 */
    public void setShujixinxiPhoto(String shujixinxiPhoto) {
        this.shujixinxiPhoto = shujixinxiPhoto;
    }
    /**
	 * 获取：书籍库存
	 */
    public Integer getShujixinxiKucunNumber() {
        return shujixinxiKucunNumber;
    }


    /**
	 * 设置：书籍库存
	 */
    public void setShujixinxiKucunNumber(Integer shujixinxiKucunNumber) {
        this.shujixinxiKucunNumber = shujixinxiKucunNumber;
    }
    /**
	 * 获取：书籍作者
	 */
    public String getShujixinxiZuozhe() {
        return shujixinxiZuozhe;
    }


    /**
	 * 设置：书籍作者
	 */
    public void setShujixinxiZuozhe(String shujixinxiZuozhe) {
        this.shujixinxiZuozhe = shujixinxiZuozhe;
    }
    /**
	 * 获取：出版社
	 */
    public String getShujixinxiChubanshe() {
        return shujixinxiChubanshe;
    }


    /**
	 * 设置：出版社
	 */
    public void setShujixinxiChubanshe(String shujixinxiChubanshe) {
        this.shujixinxiChubanshe = shujixinxiChubanshe;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getShujixinxiDelete() {
        return shujixinxiDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setShujixinxiDelete(Integer shujixinxiDelete) {
        this.shujixinxiDelete = shujixinxiDelete;
    }
    /**
	 * 获取：书籍简介
	 */
    public String getShujixinxiContent() {
        return shujixinxiContent;
    }


    /**
	 * 设置：书籍简介
	 */
    public void setShujixinxiContent(String shujixinxiContent) {
        this.shujixinxiContent = shujixinxiContent;
    }
    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    }
