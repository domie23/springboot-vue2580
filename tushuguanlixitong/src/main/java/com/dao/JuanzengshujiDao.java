package com.dao;

import com.entity.JuanzengshujiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JuanzengshujiView;

/**
 * 捐赠书籍 Dao 接口
 *
 * @author 
 */
public interface JuanzengshujiDao extends BaseMapper<JuanzengshujiEntity> {

   List<JuanzengshujiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
