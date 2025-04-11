package com.dao;

import com.entity.ShujigoumaiCommentbackEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.ShujigoumaiCommentbackView;

/**
 * 书籍评价 Dao 接口
 *
 * @author 
 */
public interface ShujigoumaiCommentbackDao extends BaseMapper<ShujigoumaiCommentbackEntity> {

   List<ShujigoumaiCommentbackView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
