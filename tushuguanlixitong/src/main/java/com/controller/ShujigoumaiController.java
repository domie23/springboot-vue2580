
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
 * 书籍购买
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shujigoumai")
public class ShujigoumaiController {
    private static final Logger logger = LoggerFactory.getLogger(ShujigoumaiController.class);

    @Autowired
    private ShujigoumaiService shujigoumaiService;


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
        params.put("shujigoumaiDeleteStart",1);params.put("shujigoumaiDeleteEnd",1);
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = shujigoumaiService.queryPage(params);

        //字典表数据转换
        List<ShujigoumaiView> list =(List<ShujigoumaiView>)page.getList();
        for(ShujigoumaiView c:list){
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
        ShujigoumaiEntity shujigoumai = shujigoumaiService.selectById(id);
        if(shujigoumai !=null){
            //entity转view
            ShujigoumaiView view = new ShujigoumaiView();
            BeanUtils.copyProperties( shujigoumai , view );//把实体数据重构到view中

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
    public R save(@RequestBody ShujigoumaiEntity shujigoumai, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shujigoumai:{}",this.getClass().getName(),shujigoumai.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ShujigoumaiEntity> queryWrapper = new EntityWrapper<ShujigoumaiEntity>()
            .eq("shujigoumai_uuid_number", shujigoumai.getShujigoumaiUuidNumber())
            .eq("shujigoumai_name", shujigoumai.getShujigoumaiName())
            .eq("shujigoumai_types", shujigoumai.getShujigoumaiTypes())
            .eq("shujigoumai_kucun_number", shujigoumai.getShujigoumaiKucunNumber())
            .eq("shujigoumai_zuozhe", shujigoumai.getShujigoumaiZuozhe())
            .eq("shujigoumai_chubanshe", shujigoumai.getShujigoumaiChubanshe())
            .eq("shangxia_types", shujigoumai.getShangxiaTypes())
            .eq("shujigoumai_delete", shujigoumai.getShujigoumaiDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShujigoumaiEntity shujigoumaiEntity = shujigoumaiService.selectOne(queryWrapper);
        if(shujigoumaiEntity==null){
            shujigoumai.setShangxiaTypes(1);
            shujigoumai.setShujigoumaiDelete(1);
            shujigoumai.setCreateTime(new Date());
            shujigoumaiService.insert(shujigoumai);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShujigoumaiEntity shujigoumai, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,shujigoumai:{}",this.getClass().getName(),shujigoumai.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<ShujigoumaiEntity> queryWrapper = new EntityWrapper<ShujigoumaiEntity>()
            .notIn("id",shujigoumai.getId())
            .andNew()
            .eq("shujigoumai_uuid_number", shujigoumai.getShujigoumaiUuidNumber())
            .eq("shujigoumai_name", shujigoumai.getShujigoumaiName())
            .eq("shujigoumai_types", shujigoumai.getShujigoumaiTypes())
            .eq("shujigoumai_kucun_number", shujigoumai.getShujigoumaiKucunNumber())
            .eq("shujigoumai_zuozhe", shujigoumai.getShujigoumaiZuozhe())
            .eq("shujigoumai_chubanshe", shujigoumai.getShujigoumaiChubanshe())
            .eq("shangxia_types", shujigoumai.getShangxiaTypes())
            .eq("shujigoumai_delete", shujigoumai.getShujigoumaiDelete())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShujigoumaiEntity shujigoumaiEntity = shujigoumaiService.selectOne(queryWrapper);
        if("".equals(shujigoumai.getShujigoumaiPhoto()) || "null".equals(shujigoumai.getShujigoumaiPhoto())){
                shujigoumai.setShujigoumaiPhoto(null);
        }
        if(shujigoumaiEntity==null){
            shujigoumaiService.updateById(shujigoumai);//根据id更新
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
        ArrayList<ShujigoumaiEntity> list = new ArrayList<>();
        for(Integer id:ids){
            ShujigoumaiEntity shujigoumaiEntity = new ShujigoumaiEntity();
            shujigoumaiEntity.setId(id);
            shujigoumaiEntity.setShujigoumaiDelete(2);
            list.add(shujigoumaiEntity);
        }
        if(list != null && list.size() >0){
            shujigoumaiService.updateBatchById(list);
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
            List<ShujigoumaiEntity> shujigoumaiList = new ArrayList<>();//上传的东西
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
                            ShujigoumaiEntity shujigoumaiEntity = new ShujigoumaiEntity();
//                            shujigoumaiEntity.setShujigoumaiUuidNumber(data.get(0));                    //书籍编号 要改的
//                            shujigoumaiEntity.setShujigoumaiName(data.get(0));                    //书籍名称 要改的
//                            shujigoumaiEntity.setShujigoumaiTypes(Integer.valueOf(data.get(0)));   //书籍类型 要改的
//                            shujigoumaiEntity.setShujigoumaiPhoto("");//照片
//                            shujigoumaiEntity.setShujigoumaiKucunNumber(Integer.valueOf(data.get(0)));   //书籍库存 要改的
//                            shujigoumaiEntity.setShujigoumaiZuozhe(data.get(0));                    //书籍作者 要改的
//                            shujigoumaiEntity.setShujigoumaiChubanshe(data.get(0));                    //出版社 要改的
//                            shujigoumaiEntity.setShujigoumaiOldMoney(data.get(0));                    //书籍原价 要改的
//                            shujigoumaiEntity.setShujigoumaiNewMoney(data.get(0));                    //现价 要改的
//                            shujigoumaiEntity.setShangxiaTypes(Integer.valueOf(data.get(0)));   //是否上架 要改的
//                            shujigoumaiEntity.setShujigoumaiDelete(1);//逻辑删除字段
//                            shujigoumaiEntity.setShujigoumaiContent("");//照片
//                            shujigoumaiEntity.setCreateTime(date);//时间
                            shujigoumaiList.add(shujigoumaiEntity);


                            //把要查询是否重复的字段放入map中
                                //书籍编号
                                if(seachFields.containsKey("shujigoumaiUuidNumber")){
                                    List<String> shujigoumaiUuidNumber = seachFields.get("shujigoumaiUuidNumber");
                                    shujigoumaiUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> shujigoumaiUuidNumber = new ArrayList<>();
                                    shujigoumaiUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("shujigoumaiUuidNumber",shujigoumaiUuidNumber);
                                }
                        }

                        //查询是否重复
                         //书籍编号
                        List<ShujigoumaiEntity> shujigoumaiEntities_shujigoumaiUuidNumber = shujigoumaiService.selectList(new EntityWrapper<ShujigoumaiEntity>().in("shujigoumai_uuid_number", seachFields.get("shujigoumaiUuidNumber")).eq("shujigoumai_delete", 1));
                        if(shujigoumaiEntities_shujigoumaiUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ShujigoumaiEntity s:shujigoumaiEntities_shujigoumaiUuidNumber){
                                repeatFields.add(s.getShujigoumaiUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [书籍编号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        shujigoumaiService.insertBatch(shujigoumaiList);
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
        PageUtils page = shujigoumaiService.queryPage(params);

        //字典表数据转换
        List<ShujigoumaiView> list =(List<ShujigoumaiView>)page.getList();
        for(ShujigoumaiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShujigoumaiEntity shujigoumai = shujigoumaiService.selectById(id);
            if(shujigoumai !=null){


                //entity转view
                ShujigoumaiView view = new ShujigoumaiView();
                BeanUtils.copyProperties( shujigoumai , view );//把实体数据重构到view中

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
    public R add(@RequestBody ShujigoumaiEntity shujigoumai, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,shujigoumai:{}",this.getClass().getName(),shujigoumai.toString());
        Wrapper<ShujigoumaiEntity> queryWrapper = new EntityWrapper<ShujigoumaiEntity>()
            .eq("shujigoumai_uuid_number", shujigoumai.getShujigoumaiUuidNumber())
            .eq("shujigoumai_name", shujigoumai.getShujigoumaiName())
            .eq("shujigoumai_types", shujigoumai.getShujigoumaiTypes())
            .eq("shujigoumai_kucun_number", shujigoumai.getShujigoumaiKucunNumber())
            .eq("shujigoumai_zuozhe", shujigoumai.getShujigoumaiZuozhe())
            .eq("shujigoumai_chubanshe", shujigoumai.getShujigoumaiChubanshe())
            .eq("shangxia_types", shujigoumai.getShangxiaTypes())
            .eq("shujigoumai_delete", shujigoumai.getShujigoumaiDelete())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShujigoumaiEntity shujigoumaiEntity = shujigoumaiService.selectOne(queryWrapper);
        if(shujigoumaiEntity==null){
            shujigoumai.setShujigoumaiDelete(1);
            shujigoumai.setCreateTime(new Date());
        shujigoumaiService.insert(shujigoumai);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
