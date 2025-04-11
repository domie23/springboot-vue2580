package com.entity.model;

import com.entity.ShujigoumaiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 书籍购买
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 */
public class ShujigoumaiModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Integer id;


    /**
     * 书籍编号
     */
    private String shujigoumaiUuidNumber;


    /**
     * 书籍名称
     */
    private String shujigoumaiName;


    /**
     * 书籍类型
     */
    private Integer shujigoumaiTypes;


    /**
     * 书籍照片
     */
    private String shujigoumaiPhoto;


    /**
     * 书籍库存
     */
    private Integer shujigoumaiKucunNumber;


    /**
     * 书籍作者
     */
    private String shujigoumaiZuozhe;


    /**
     * 出版社
     */
    private String shujigoumaiChubanshe;


    /**
     * 书籍原价
     */
    private Double shujigoumaiOldMoney;


    /**
     * 现价
     */
    private Double shujigoumaiNewMoney;


    /**
     * 是否上架
     */
    private Integer shangxiaTypes;


    /**
     * 逻辑删除
     */
    private Integer shujigoumaiDelete;


    /**
     * 书籍简介
     */
    private String shujigoumaiContent;


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
    public String getShujigoumaiUuidNumber() {
        return shujigoumaiUuidNumber;
    }


    /**
	 * 设置：书籍编号
	 */
    public void setShujigoumaiUuidNumber(String shujigoumaiUuidNumber) {
        this.shujigoumaiUuidNumber = shujigoumaiUuidNumber;
    }
    /**
	 * 获取：书籍名称
	 */
    public String getShujigoumaiName() {
        return shujigoumaiName;
    }


    /**
	 * 设置：书籍名称
	 */
    public void setShujigoumaiName(String shujigoumaiName) {
        this.shujigoumaiName = shujigoumaiName;
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
    public String getShujigoumaiPhoto() {
        return shujigoumaiPhoto;
    }


    /**
	 * 设置：书籍照片
	 */
    public void setShujigoumaiPhoto(String shujigoumaiPhoto) {
        this.shujigoumaiPhoto = shujigoumaiPhoto;
    }
    /**
	 * 获取：书籍库存
	 */
    public Integer getShujigoumaiKucunNumber() {
        return shujigoumaiKucunNumber;
    }


    /**
	 * 设置：书籍库存
	 */
    public void setShujigoumaiKucunNumber(Integer shujigoumaiKucunNumber) {
        this.shujigoumaiKucunNumber = shujigoumaiKucunNumber;
    }
    /**
	 * 获取：书籍作者
	 */
    public String getShujigoumaiZuozhe() {
        return shujigoumaiZuozhe;
    }


    /**
	 * 设置：书籍作者
	 */
    public void setShujigoumaiZuozhe(String shujigoumaiZuozhe) {
        this.shujigoumaiZuozhe = shujigoumaiZuozhe;
    }
    /**
	 * 获取：出版社
	 */
    public String getShujigoumaiChubanshe() {
        return shujigoumaiChubanshe;
    }


    /**
	 * 设置：出版社
	 */
    public void setShujigoumaiChubanshe(String shujigoumaiChubanshe) {
        this.shujigoumaiChubanshe = shujigoumaiChubanshe;
    }
    /**
	 * 获取：书籍原价
	 */
    public Double getShujigoumaiOldMoney() {
        return shujigoumaiOldMoney;
    }


    /**
	 * 设置：书籍原价
	 */
    public void setShujigoumaiOldMoney(Double shujigoumaiOldMoney) {
        this.shujigoumaiOldMoney = shujigoumaiOldMoney;
    }
    /**
	 * 获取：现价
	 */
    public Double getShujigoumaiNewMoney() {
        return shujigoumaiNewMoney;
    }


    /**
	 * 设置：现价
	 */
    public void setShujigoumaiNewMoney(Double shujigoumaiNewMoney) {
        this.shujigoumaiNewMoney = shujigoumaiNewMoney;
    }
    /**
	 * 获取：是否上架
	 */
    public Integer getShangxiaTypes() {
        return shangxiaTypes;
    }


    /**
	 * 设置：是否上架
	 */
    public void setShangxiaTypes(Integer shangxiaTypes) {
        this.shangxiaTypes = shangxiaTypes;
    }
    /**
	 * 获取：逻辑删除
	 */
    public Integer getShujigoumaiDelete() {
        return shujigoumaiDelete;
    }


    /**
	 * 设置：逻辑删除
	 */
    public void setShujigoumaiDelete(Integer shujigoumaiDelete) {
        this.shujigoumaiDelete = shujigoumaiDelete;
    }
    /**
	 * 获取：书籍简介
	 */
    public String getShujigoumaiContent() {
        return shujigoumaiContent;
    }


    /**
	 * 设置：书籍简介
	 */
    public void setShujigoumaiContent(String shujigoumaiContent) {
        this.shujigoumaiContent = shujigoumaiContent;
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
