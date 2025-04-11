
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
 * 捐赠书籍
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/juanzengshuji")
public class JuanzengshujiController {
    private static final Logger logger = LoggerFactory.getLogger(JuanzengshujiController.class);

    @Autowired
    private JuanzengshujiService juanzengshujiService;


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
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = juanzengshujiService.queryPage(params);

        //字典表数据转换
        List<JuanzengshujiView> list =(List<JuanzengshujiView>)page.getList();
        for(JuanzengshujiView c:list){
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
        JuanzengshujiEntity juanzengshuji = juanzengshujiService.selectById(id);
        if(juanzengshuji !=null){
            //entity转view
            JuanzengshujiView view = new JuanzengshujiView();
            BeanUtils.copyProperties( juanzengshuji , view );//把实体数据重构到view中

                //级联表
                YonghuEntity yonghu = yonghuService.selectById(juanzengshuji.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
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
    public R save(@RequestBody JuanzengshujiEntity juanzengshuji, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,juanzengshuji:{}",this.getClass().getName(),juanzengshuji.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            juanzengshuji.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<JuanzengshujiEntity> queryWrapper = new EntityWrapper<JuanzengshujiEntity>()
            .eq("juanzengshuji_name", juanzengshuji.getJuanzengshujiName())
            .eq("juanzengshuji_zuozhe", juanzengshuji.getJuanzengshujiZuozhe())
            .eq("juanzengshuji_chubanshe", juanzengshuji.getJuanzengshujiChubanshe())
            .eq("shujigoumai_types", juanzengshuji.getShujigoumaiTypes())
            .eq("yonghu_id", juanzengshuji.getYonghuId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JuanzengshujiEntity juanzengshujiEntity = juanzengshujiService.selectOne(queryWrapper);
        if(juanzengshujiEntity==null){
            juanzengshuji.setCreateTime(new Date());
            juanzengshujiService.insert(juanzengshuji);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JuanzengshujiEntity juanzengshuji, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,juanzengshuji:{}",this.getClass().getName(),juanzengshuji.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            juanzengshuji.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<JuanzengshujiEntity> queryWrapper = new EntityWrapper<JuanzengshujiEntity>()
            .notIn("id",juanzengshuji.getId())
            .andNew()
            .eq("juanzengshuji_name", juanzengshuji.getJuanzengshujiName())
            .eq("juanzengshuji_zuozhe", juanzengshuji.getJuanzengshujiZuozhe())
            .eq("juanzengshuji_chubanshe", juanzengshuji.getJuanzengshujiChubanshe())
            .eq("shujigoumai_types", juanzengshuji.getShujigoumaiTypes())
            .eq("yonghu_id", juanzengshuji.getYonghuId())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JuanzengshujiEntity juanzengshujiEntity = juanzengshujiService.selectOne(queryWrapper);
        if(juanzengshujiEntity==null){
            juanzengshujiService.updateById(juanzengshuji);//根据id更新
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
        juanzengshujiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<JuanzengshujiEntity> juanzengshujiList = new ArrayList<>();//上传的东西
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
                            JuanzengshujiEntity juanzengshujiEntity = new JuanzengshujiEntity();
//                            juanzengshujiEntity.setJuanzengshujiName(data.get(0));                    //书籍名称 要改的
//                            juanzengshujiEntity.setJuanzengshujiZuozhe(data.get(0));                    //书籍作者 要改的
//                            juanzengshujiEntity.setJuanzengshujiChubanshe(data.get(0));                    //出版社 要改的
//                            juanzengshujiEntity.setShujigoumaiTypes(Integer.valueOf(data.get(0)));   //书籍类型 要改的
//                            juanzengshujiEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            juanzengshujiEntity.setJuanzengshujiTime(new Date(data.get(0)));          //捐赠时间 要改的
//                            juanzengshujiEntity.setCreateTime(date);//时间
                            juanzengshujiList.add(juanzengshujiEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        juanzengshujiService.insertBatch(juanzengshujiList);
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
        PageUtils page = juanzengshujiService.queryPage(params);

        //字典表数据转换
        List<JuanzengshujiView> list =(List<JuanzengshujiView>)page.getList();
        for(JuanzengshujiView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        JuanzengshujiEntity juanzengshuji = juanzengshujiService.selectById(id);
            if(juanzengshuji !=null){


                //entity转view
                JuanzengshujiView view = new JuanzengshujiView();
                BeanUtils.copyProperties( juanzengshuji , view );//把实体数据重构到view中

                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(juanzengshuji.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
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
    public R add(@RequestBody JuanzengshujiEntity juanzengshuji, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,juanzengshuji:{}",this.getClass().getName(),juanzengshuji.toString());
        Wrapper<JuanzengshujiEntity> queryWrapper = new EntityWrapper<JuanzengshujiEntity>()
            .eq("juanzengshuji_name", juanzengshuji.getJuanzengshujiName())
            .eq("juanzengshuji_zuozhe", juanzengshuji.getJuanzengshujiZuozhe())
            .eq("juanzengshuji_chubanshe", juanzengshuji.getJuanzengshujiChubanshe())
            .eq("shujigoumai_types", juanzengshuji.getShujigoumaiTypes())
            .eq("yonghu_id", juanzengshuji.getYonghuId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JuanzengshujiEntity juanzengshujiEntity = juanzengshujiService.selectOne(queryWrapper);
        if(juanzengshujiEntity==null){
            juanzengshuji.setCreateTime(new Date());
        juanzengshujiService.insert(juanzengshuji);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


}
