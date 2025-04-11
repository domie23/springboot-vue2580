package com.dao;

import com.entity.YuyueshujiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.YuyueshujiView;

/**
 * 预约书籍 Dao 接口
 *
 * @author 
 */
public interface YuyueshujiDao extends BaseMapper<YuyueshujiEntity> {

   List<YuyueshujiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
