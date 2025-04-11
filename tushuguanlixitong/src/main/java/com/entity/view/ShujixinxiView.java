package com.entity.view;

import com.entity.ShujixinxiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 书籍信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("shujixinxi")
public class ShujixinxiView extends ShujixinxiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 书籍类型的值
		*/
		private String shujigoumaiValue;



	public ShujixinxiView() {

	}

	public ShujixinxiView(ShujixinxiEntity shujixinxiEntity) {
		try {
			BeanUtils.copyProperties(this, shujixinxiEntity);
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














}
