package com.entity.view;

import com.entity.ShujigoumaiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 书籍购买
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("shujigoumai")
public class ShujigoumaiView extends ShujigoumaiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 书籍类型的值
		*/
		private String shujigoumaiValue;
		/**
		* 是否上架的值
		*/
		private String shangxiaValue;



	public ShujigoumaiView() {

	}

	public ShujigoumaiView(ShujigoumaiEntity shujigoumaiEntity) {
		try {
			BeanUtils.copyProperties(this, shujigoumaiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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














}
