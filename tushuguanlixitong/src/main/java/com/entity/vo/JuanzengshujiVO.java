package com.entity.vo;

import com.entity.JuanzengshujiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 捐赠书籍
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("juanzengshuji")
public class JuanzengshujiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

}
