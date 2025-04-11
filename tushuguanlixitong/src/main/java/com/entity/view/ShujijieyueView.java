package com.entity.view;

import com.entity.ShujijieyueEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 书籍借阅记录
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("shujijieyue")
public class ShujijieyueView extends ShujijieyueEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 借阅状态的值
		*/
		private String jieyueValue;



		//级联表 shujixinxi
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
				* 书籍类型的值
				*/
				private String shujigoumaiValue;
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

	public ShujijieyueView() {

	}

	public ShujijieyueView(ShujijieyueEntity shujijieyueEntity) {
		try {
			BeanUtils.copyProperties(this, shujijieyueEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 借阅状态的值
			*/
			public String getJieyueValue() {
				return jieyueValue;
			}
			/**
			* 设置： 借阅状态的值
			*/
			public void setJieyueValue(String jieyueValue) {
				this.jieyueValue = jieyueValue;
			}




























				//级联表的get和set shujixinxi
					/**
					* 获取： 书籍编号
					*/
					public String getShujixinxiUuidNumber() {
						return shujixinxiUuidNumber;
					}
					/**
					* 设置： 书籍编号
					*/
					public void setShujixinxiUuidNumber(String shujixinxiUuidNumber) {
						this.shujixinxiUuidNumber = shujixinxiUuidNumber;
					}
					/**
					* 获取： 书籍名称
					*/
					public String getShujixinxiName() {
						return shujixinxiName;
					}
					/**
					* 设置： 书籍名称
					*/
					public void setShujixinxiName(String shujixinxiName) {
						this.shujixinxiName = shujixinxiName;
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
					public String getShujixinxiPhoto() {
						return shujixinxiPhoto;
					}
					/**
					* 设置： 书籍照片
					*/
					public void setShujixinxiPhoto(String shujixinxiPhoto) {
						this.shujixinxiPhoto = shujixinxiPhoto;
					}
					/**
					* 获取： 书籍库存
					*/
					public Integer getShujixinxiKucunNumber() {
						return shujixinxiKucunNumber;
					}
					/**
					* 设置： 书籍库存
					*/
					public void setShujixinxiKucunNumber(Integer shujixinxiKucunNumber) {
						this.shujixinxiKucunNumber = shujixinxiKucunNumber;
					}
					/**
					* 获取： 书籍作者
					*/
					public String getShujixinxiZuozhe() {
						return shujixinxiZuozhe;
					}
					/**
					* 设置： 书籍作者
					*/
					public void setShujixinxiZuozhe(String shujixinxiZuozhe) {
						this.shujixinxiZuozhe = shujixinxiZuozhe;
					}
					/**
					* 获取： 出版社
					*/
					public String getShujixinxiChubanshe() {
						return shujixinxiChubanshe;
					}
					/**
					* 设置： 出版社
					*/
					public void setShujixinxiChubanshe(String shujixinxiChubanshe) {
						this.shujixinxiChubanshe = shujixinxiChubanshe;
					}
					/**
					* 获取： 逻辑删除
					*/
					public Integer getShujixinxiDelete() {
						return shujixinxiDelete;
					}
					/**
					* 设置： 逻辑删除
					*/
					public void setShujixinxiDelete(Integer shujixinxiDelete) {
						this.shujixinxiDelete = shujixinxiDelete;
					}
					/**
					* 获取： 书籍简介
					*/
					public String getShujixinxiContent() {
						return shujixinxiContent;
					}
					/**
					* 设置： 书籍简介
					*/
					public void setShujixinxiContent(String shujixinxiContent) {
						this.shujixinxiContent = shujixinxiContent;
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
