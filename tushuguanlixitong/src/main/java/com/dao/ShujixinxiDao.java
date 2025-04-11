package com.dao;

import com.entity.ShujixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShujixinxiView;

/**
 * 书籍信息 Dao 接口
 *
 * @author 
 */
public interface ShujixinxiDao extends BaseMapper<ShujixinxiEntity> {

   List<ShujixinxiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
