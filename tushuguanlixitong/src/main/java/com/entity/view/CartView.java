package com.entity.view;

import com.entity.CartEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 购物车
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("cart")
public class CartView extends CartEntity implements Serializable {
    private static final long serialVersionUID = 1L;




		//级联表 shujigoumai
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
				* 书籍类型的值
				*/
				private String shujigoumaiValue;
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
				* 是否上架的值
				*/
				private String shangxiaValue;
			/**
			* 逻辑删除
			*/
			private Integer shujigoumaiDelete;
			/**
			* 书籍简介
			*/
			private String shujigoumaiContent;

		//级联表 yonghu
			/**
			* 用户姓名
			*/
			private String yonghuName;
			/**
			* 头像
			*/
			private String yonghuPhoto;
			/**
			* 用户手机号
			*/
			private String yonghuPhone;
			/**
			* 用户身份证号
			*/
			private String yonghuIdNumber;
			/**
			* 邮箱
			*/
			private String yonghuEmail;
			/**
			* 余额
			*/
			private Double newMoney;
			/**
			* 假删
			*/
			private Integer yonghuDelete;

	public CartView() {

	}

	public CartView(CartEntity cartEntity) {
		try {
			BeanUtils.copyProperties(this, cartEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}




















				//级联表的get和set shujigoumai
					/**
					* 获取： 书籍编号
					*/
					public String getShujigoumaiUuidNumber() {
						return shujigoumaiUuidNumber;
					}
					/**
					* 设置： 书籍编号
					*/
					public void setShujigoumaiUuidNumber(String shujigoumaiUuidNumber) {
						this.shujigoumaiUuidNumber = shujigoumaiUuidNumber;
					}
					/**
					* 获取： 书籍名称
					*/
					public String getShujigoumaiName() {
						return shujigoumaiName;
					}
					/**
					* 设置： 书籍名称
					*/
					public void setShujigoumaiName(String shujigoumaiName) {
						this.shujigoumaiName = shujigoumaiName;
					}
					/**
					* 获取： 书籍类型
					*/
					public Integer getShujigoumaiTypes() {
						return shujigoumaiTypes;
					}
					/**
					* 设置： 书籍类型
					*/
					public void setShujigoumaiTypes(Integer shujigoumaiTypes) {
						this.shujigoumaiTypes = shujigoumaiTypes;
					}


						/**
						* 获取： 书籍类型的值
						*/
						public String getShujigoumaiValue() {
							return shujigoumaiValue;
						}
						/**
						* 设置： 书籍类型的值
						*/
						public void setShujigoumaiValue(String shujigoumaiValue) {
							this.shujigoumaiValue = shujigoumaiValue;
						}
					/**
					* 获取： 书籍照片
					*/
					public String getShujigoumaiPhoto() {
						return shujigoumaiPhoto;
					}
					/**
					* 设置： 书籍照片
					*/
					public void setShujigoumaiPhoto(String shujigoumaiPhoto) {
						this.shujigoumaiPhoto = shujigoumaiPhoto;
					}
					/**
					* 获取： 书籍库存
					*/
					public Integer getShujigoumaiKucunNumber() {
						return shujigoumaiKucunNumber;
					}
					/**
					* 设置： 书籍库存
					*/
					public void setShujigoumaiKucunNumber(Integer shujigoumaiKucunNumber) {
						this.shujigoumaiKucunNumber = shujigoumaiKucunNumber;
					}
					/**
					* 获取： 书籍作者
					*/
					public String getShujigoumaiZuozhe() {
						return shujigoumaiZuozhe;
					}
					/**
					* 设置： 书籍作者
					*/
					public void setShujigoumaiZuozhe(String shujigoumaiZuozhe) {
						this.shujigoumaiZuozhe = shujigoumaiZuozhe;
					}
					/**
					* 获取： 出版社
					*/
					public String getShujigoumaiChubanshe() {
						return shujigoumaiChubanshe;
					}
					/**
					* 设置： 出版社
					*/
					public void setShujigoumaiChubanshe(String shujigoumaiChubanshe) {
						this.shujigoumaiChubanshe = shujigoumaiChubanshe;
					}
					/**
					* 获取： 书籍原价
					*/
					public Double getShujigoumaiOldMoney() {
						return shujigoumaiOldMoney;
					}
					/**
					* 设置： 书籍原价
					*/
					public void setShujigoumaiOldMoney(Double shujigoumaiOldMoney) {
						this.shujigoumaiOldMoney = shujigoumaiOldMoney;
					}
					/**
					* 获取： 现价
					*/
					public Double getShujigoumaiNewMoney() {
						return shujigoumaiNewMoney;
					}
					/**
					* 设置： 现价
					*/
					public void setShujigoumaiNewMoney(Double shujigoumaiNewMoney) {
						this.shujigoumaiNewMoney = shujigoumaiNewMoney;
					}
					/**
					* 获取： 是否上架
					*/
					public Integer getShangxiaTypes() {
						return shangxiaTypes;
					}
					/**
					* 设置： 是否上架
					*/
					public void setShangxiaTypes(Integer shangxiaTypes) {
						this.shangxiaTypes = shangxiaTypes;
					}


						/**
						* 获取： 是否上架的值
						*/
						public String getShangxiaValue() {
							return shangxiaValue;
						}
						/**
						* 设置： 是否上架的值
						*/
						public void setShangxiaValue(String shangxiaValue) {
							this.shangxiaValue = shangxiaValue;
						}
					/**
					* 获取： 逻辑删除
					*/
					public Integer getShujigoumaiDelete() {
						return shujigoumaiDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setShujigoumaiDelete(Integer shujigoumaiDelete) {
						this.shujigoumaiDelete = shujigoumaiDelete;
					}
					/**
					* 获取： 书籍简介
					*/
					public String getShujigoumaiContent() {
						return shujigoumaiContent;
					}
					/**
					* 设置： 书籍简介
					*/
					public void setShujigoumaiContent(String shujigoumaiContent) {
						this.shujigoumaiContent = shujigoumaiContent;
					}














				//级联表的get和set yonghu
					/**
					* 获取： 用户姓名
					*/
					public String getYonghuName() {
						return yonghuName;
					}
					/**
					* 设置： 用户姓名
					*/
					public void setYonghuName(String yonghuName) {
						this.yonghuName = yonghuName;
					}
					/**
					* 获取： 头像
					*/
					public String getYonghuPhoto() {
						return yonghuPhoto;
					}
					/**
					* 设置： 头像
					*/
					public void setYonghuPhoto(String yonghuPhoto) {
						this.yonghuPhoto = yonghuPhoto;
					}
					/**
					* 获取： 用户手机号
					*/
					public String getYonghuPhone() {
						return yonghuPhone;
					}
					/**
					* 设置： 用户手机号
					*/
					public void setYonghuPhone(String yonghuPhone) {
						this.yonghuPhone = yonghuPhone;
					}
					/**
					* 获取： 用户身份证号
					*/
					public String getYonghuIdNumber() {
						return yonghuIdNumber;
					}
					/**
					* 设置： 用户身份证号
					*/
					public void setYonghuIdNumber(String yonghuIdNumber) {
						this.yonghuIdNumber = yonghuIdNumber;
					}
					/**
					* 获取： 邮箱
					*/
					public String getYonghuEmail() {
						return yonghuEmail;
					}
					/**
					* 设置： 邮箱
					*/
					public void setYonghuEmail(String yonghuEmail) {
						this.yonghuEmail = yonghuEmail;
					}
					/**
					* 获取： 余额
					*/
					public Double getNewMoney() {
						return newMoney;
					}
					/**
					* 设置： 余额
					*/
					public void setNewMoney(Double newMoney) {
						this.newMoney = newMoney;
					}
					/**
					* 获取： 假删
					*/
					public Integer getYonghuDelete() {
						return yonghuDelete;
					}
					/**
					* 设置： 假删
					*/
					public void setYonghuDelete(Integer yonghuDelete) {
						this.yonghuDelete = yonghuDelete;
					}







}
