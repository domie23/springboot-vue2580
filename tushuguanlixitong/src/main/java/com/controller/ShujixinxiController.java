
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 书籍信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shujixinxi")
public class ShujixinxiController {
    private static final Logger logger = LoggerFactory.getLogger(ShujixinxiController.class);

    @Autowired
    private ShujixinxiService shujixinxiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("用户".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        params.put("shujixinxiDeleteStart",1);params.put("shujixinxiDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = shujixinxiService.queryPage(params);

        //字典表数据转换
        List<ShujixinxiView> list =(List<ShujixinxiView>)page.getList();
        for(ShujixinxiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShujixinxiEntity shujixinxi = shujixinxiService.selectById(id);
        if(shujixinxi !=null){
            //entity转view
            ShujixinxiView view = new ShujixinxiView();
            BeanUtils.copyProperties( shujixinxi , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ShujixinxiEntity shujixinxi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shujixinxi:{}",this.getClass().getName(),shujixinxi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ShujixinxiEntity> queryWrapper = new EntityWrapper<ShujixinxiEntity>()
            .eq("shujixinxi_uuid_number", shujixinxi.getShujixinxiUuidNumber())
            .eq("shujixinxi_name", shujixinxi.getShujixinxiName())
            .eq("shujigoumai_types", shujixinxi.getShujigoumaiTypes())
            .eq("shujixinxi_kucun_number", shujixinxi.getShujixinxiKucunNumber())
            .eq("shujixinxi_zuozhe", shujixinxi.getShujixinxiZuozhe())
            .eq("shujixinxi_chubanshe", shujixinxi.getShujixinxiChubanshe())
            .eq("shujixinxi_delete", shujixinxi.getShujixinxiDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShujixinxiEntity shujixinxiEntity = shujixinxiService.selectOne(queryWrapper);
        if(shujixinxiEntity==null){
            shujixinxi.setShujixinxiDelete(1);
            shujixinxi.setCreateTime(new Date());
            shujixinxiService.insert(shujixinxi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShujixinxiEntity shujixinxi, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,shujixinxi:{}",this.getClass().getName(),shujixinxi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<ShujixinxiEntity> queryWrapper = new EntityWrapper<ShujixinxiEntity>()
            .notIn("id",shujixinxi.getId())
            .andNew()
            .eq("shujixinxi_uuid_number", shujixinxi.getShujixinxiUuidNumber())
            .eq("shujixinxi_name", shujixinxi.getShujixinxiName())
            .eq("shujigoumai_types", shujixinxi.getShujigoumaiTypes())
            .eq("shujixinxi_kucun_number", shujixinxi.getShujixinxiKucunNumber())
            .eq("shujixinxi_zuozhe", shujixinxi.getShujixinxiZuozhe())
            .eq("shujixinxi_chubanshe", shujixinxi.getShujixinxiChubanshe())
            .eq("shujixinxi_delete", shujixinxi.getShujixinxiDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShujixinxiEntity shujixinxiEntity = shujixinxiService.selectOne(queryWrapper);
        if("".equals(shujixinxi.getShujixinxiPhoto()) || "null".equals(shujixinxi.getShujixinxiPhoto())){
                shujixinxi.setShujixinxiPhoto(null);
        }
        if(shujixinxiEntity==null){
            shujixinxiService.updateById(shujixinxi);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        ArrayList<ShujixinxiEntity> list = new ArrayList<>();
        for(Integer id:ids){
            ShujixinxiEntity shujixinxiEntity = new ShujixinxiEntity();
            shujixinxiEntity.setId(id);
            shujixinxiEntity.setShujixinxiDelete(2);
            list.add(shujixinxiEntity);
        }
        if(list != null && list.size() >0){
            shujixinxiService.updateBatchById(list);
        }
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<ShujixinxiEntity> shujixinxiList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ShujixinxiEntity shujixinxiEntity = new ShujixinxiEntity();
//                            shujixinxiEntity.setShujixinxiUuidNumber(data.get(0));                    //书籍编号 要改的
//                            shujixinxiEntity.setShujixinxiName(data.get(0));                    //书籍名称 要改的
//                            shujixinxiEntity.setShujigoumaiTypes(Integer.valueOf(data.get(0)));   //书籍类型 要改的
//                            shujixinxiEntity.setShujixinxiPhoto("");//照片
//                            shujixinxiEntity.setShujixinxiKucunNumber(Integer.valueOf(data.get(0)));   //书籍库存 要改的
//                            shujixinxiEntity.setShujixinxiZuozhe(data.get(0));                    //书籍作者 要改的
//                            shujixinxiEntity.setShujixinxiChubanshe(data.get(0));                    //出版社 要改的
//                            shujixinxiEntity.setShujixinxiDelete(1);//逻辑删除字段
//                            shujixinxiEntity.setShujixinxiContent("");//照片
//                            shujixinxiEntity.setCreateTime(date);//时间
                            shujixinxiList.add(shujixinxiEntity);


                            //把要查询是否重复的字段放入map中
                                //书籍编号
                                if(seachFields.containsKey("shujixinxiUuidNumber")){
                                    List<String> shujixinxiUuidNumber = seachFields.get("shujixinxiUuidNumber");
                                    shujixinxiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> shujixinxiUuidNumber = new ArrayList<>();
                                    shujixinxiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("shujixinxiUuidNumber",shujixinxiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //书籍编号
                        List<ShujixinxiEntity> shujixinxiEntities_shujixinxiUuidNumber = shujixinxiService.selectList(new EntityWrapper<ShujixinxiEntity>().in("shujixinxi_uuid_number", seachFields.get("shujixinxiUuidNumber")).eq("shujixinxi_delete", 1));
                        if(shujixinxiEntities_shujixinxiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ShujixinxiEntity s:shujixinxiEntities_shujixinxiUuidNumber){
                                repeatFields.add(s.getShujixinxiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [书籍编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        shujixinxiService.insertBatch(shujixinxiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }





    /**
    * 前端列表
    */
    @IgnoreAuth
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("list方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));

        // 没有指定排序字段就默认id倒序
        if(StringUtil.isEmpty(String.valueOf(params.get("orderBy")))){
            params.put("orderBy","id");
        }
        PageUtils page = shujixinxiService.queryPage(params);

        //字典表数据转换
        List<ShujixinxiView> list =(List<ShujixinxiView>)page.getList();
        for(ShujixinxiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShujixinxiEntity shujixinxi = shujixinxiService.selectById(id);
            if(shujixinxi !=null){


                //entity转view
                ShujixinxiView view = new ShujixinxiView();
                BeanUtils.copyProperties( shujixinxi , view );//把实体数据重构到view中

                //修改对应字典表字段
                dictionaryService.dictionaryConvert(view, request);
                return R.ok().put("data", view);
            }else {
                return R.error(511,"查不到数据");
            }
    }


    /**
    * 前端保存
    */
    @RequestMapping("/add")
    public R add(@RequestBody ShujixinxiEntity shujixinxi, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,shujixinxi:{}",this.getClass().getName(),shujixinxi.toString());
        Wrapper<ShujixinxiEntity> queryWrapper = new EntityWrapper<ShujixinxiEntity>()
            .eq("shujixinxi_uuid_number", shujixinxi.getShujixinxiUuidNumber())
            .eq("shujixinxi_name", shujixinxi.getShujixinxiName())
            .eq("shujigoumai_types", shujixinxi.getShujigoumaiTypes())
            .eq("shujixinxi_kucun_number", shujixinxi.getShujixinxiKucunNumber())
            .eq("shujixinxi_zuozhe", shujixinxi.getShujixinxiZuozhe())
            .eq("shujixinxi_chubanshe", shujixinxi.getShujixinxiChubanshe())
            .eq("shujixinxi_delete", shujixinxi.getShujixinxiDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShujixinxiEntity shujixinxiEntity = shujixinxiService.selectOne(queryWrapper);
        if(shujixinxiEntity==null){
            shujixinxi.setShujixinxiDelete(1);
            shujixinxi.setCreateTime(new Date());
        shujixinxiService.insert(shujixinxi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
