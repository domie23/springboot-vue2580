package com.dao;

import com.entity.ShujijieyueEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShujijieyueView;

/**
 * 书籍借阅记录 Dao 接口
 *
 * @author 
 */
public interface ShujijieyueDao extends BaseMapper<ShujijieyueEntity> {

   List<ShujijieyueView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
