package com.entity.vo;

import com.entity.YuyueshujiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 预约书籍
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("yuyueshuji")
public class YuyueshujiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 书籍名称
     */

    @TableField(value = "yuyueshuji_name")
    private String yuyueshujiName;


    /**
     * 书籍作者
     */

    @TableField(value = "yuyueshuji_zuozhe")
    private String yuyueshujiZuozhe;


    /**
     * 出版社
     */

    @TableField(value = "yuyueshuji_chubanshe")
    private String yuyueshujiChubanshe;


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
     * 预约时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "yuyueshuji_time")
    private Date yuyueshujiTime;


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
    public String getYuyueshujiName() {
        return yuyueshujiName;
    }


    /**
	 * 获取：书籍名称
	 */

    public void setYuyueshujiName(String yuyueshujiName) {
        this.yuyueshujiName = yuyueshujiName;
    }
    /**
	 * 设置：书籍作者
	 */
    public String getYuyueshujiZuozhe() {
        return yuyueshujiZuozhe;
    }


    /**
	 * 获取：书籍作者
	 */

    public void setYuyueshujiZuozhe(String yuyueshujiZuozhe) {
        this.yuyueshujiZuozhe = yuyueshujiZuozhe;
    }
    /**
	 * 设置：出版社
	 */
    public String getYuyueshujiChubanshe() {
        return yuyueshujiChubanshe;
    }


    /**
	 * 获取：出版社
	 */

    public void setYuyueshujiChubanshe(String yuyueshujiChubanshe) {
        this.yuyueshujiChubanshe = yuyueshujiChubanshe;
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
	 * 设置：预约时间
	 */
    public Date getYuyueshujiTime() {
        return yuyueshujiTime;
    }


    /**
	 * 获取：预约时间
	 */

    public void setYuyueshujiTime(Date yuyueshujiTime) {
        this.yuyueshujiTime = yuyueshujiTime;
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
