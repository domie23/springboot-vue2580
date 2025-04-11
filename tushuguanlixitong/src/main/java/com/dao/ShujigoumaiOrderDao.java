package com.dao;

import com.entity.ShujigoumaiOrderEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShujigoumaiOrderView;

/**
 * 书籍订单 Dao 接口
 *
 * @author 
 */
public interface ShujigoumaiOrderDao extends BaseMapper<ShujigoumaiOrderEntity> {

   List<ShujigoumaiOrderView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
