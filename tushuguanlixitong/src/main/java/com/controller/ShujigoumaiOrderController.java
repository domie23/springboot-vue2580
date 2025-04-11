
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
 * 书籍订单
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/shujigoumaiOrder")
public class ShujigoumaiOrderController {
    private static final Logger logger = LoggerFactory.getLogger(ShujigoumaiOrderController.class);

    @Autowired
    private ShujigoumaiOrderService shujigoumaiOrderService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private AddressService addressService;
    @Autowired
    private ShujigoumaiService shujigoumaiService;
    @Autowired
    private YonghuService yonghuService;
@Autowired
private CartService cartService;
@Autowired
private ShujigoumaiCommentbackService shujigoumaiCommentbackService;



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
        PageUtils page = shujigoumaiOrderService.queryPage(params);

        //字典表数据转换
        List<ShujigoumaiOrderView> list =(List<ShujigoumaiOrderView>)page.getList();
        for(ShujigoumaiOrderView c:list){
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
        ShujigoumaiOrderEntity shujigoumaiOrder = shujigoumaiOrderService.selectById(id);
        if(shujigoumaiOrder !=null){
            //entity转view
            ShujigoumaiOrderView view = new ShujigoumaiOrderView();
            BeanUtils.copyProperties( shujigoumaiOrder , view );//把实体数据重构到view中

                //级联表
                AddressEntity address = addressService.selectById(shujigoumaiOrder.getAddressId());
                if(address != null){
                    BeanUtils.copyProperties( address , view ,new String[]{ "id", "createTime", "insertTime", "updateTime", "yonghuId"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setAddressId(address.getId());
                    view.setAddressYonghuId(address.getYonghuId());
                }
                //级联表
                ShujigoumaiEntity shujigoumai = shujigoumaiService.selectById(shujigoumaiOrder.getShujigoumaiId());
                if(shujigoumai != null){
                    BeanUtils.copyProperties( shujigoumai , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShujigoumaiId(shujigoumai.getId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(shujigoumaiOrder.getYonghuId());
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
    public R save(@RequestBody ShujigoumaiOrderEntity shujigoumaiOrder, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,shujigoumaiOrder:{}",this.getClass().getName(),shujigoumaiOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("用户".equals(role))
            shujigoumaiOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        shujigoumaiOrder.setInsertTime(new Date());
        shujigoumaiOrder.setCreateTime(new Date());
        shujigoumaiOrderService.insert(shujigoumaiOrder);
        return R.ok();
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ShujigoumaiOrderEntity shujigoumaiOrder, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,shujigoumaiOrder:{}",this.getClass().getName(),shujigoumaiOrder.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("用户".equals(role))
//            shujigoumaiOrder.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<ShujigoumaiOrderEntity> queryWrapper = new EntityWrapper<ShujigoumaiOrderEntity>()
            .eq("id",0)
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ShujigoumaiOrderEntity shujigoumaiOrderEntity = shujigoumaiOrderService.selectOne(queryWrapper);
        if(shujigoumaiOrderEntity==null){
            shujigoumaiOrderService.updateById(shujigoumaiOrder);//根据id更新
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
        shujigoumaiOrderService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<ShujigoumaiOrderEntity> shujigoumaiOrderList = new ArrayList<>();//上传的东西
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
                            ShujigoumaiOrderEntity shujigoumaiOrderEntity = new ShujigoumaiOrderEntity();
//                            shujigoumaiOrderEntity.setShujigoumaiOrderUuidNumber(data.get(0));                    //订单号 要改的
//                            shujigoumaiOrderEntity.setShujigoumaiId(Integer.valueOf(data.get(0)));   //书籍 要改的
//                            shujigoumaiOrderEntity.setYonghuId(Integer.valueOf(data.get(0)));   //用户 要改的
//                            shujigoumaiOrderEntity.setAddressId(Integer.valueOf(data.get(0)));   //地址 要改的
//                            shujigoumaiOrderEntity.setBuyNumber(Integer.valueOf(data.get(0)));   //购买的数量 要改的
//                            shujigoumaiOrderEntity.setShujigoumaiOrderTruePrice(data.get(0));                    //实付价格 要改的
//                            shujigoumaiOrderEntity.setShujigoumaiOrderTypes(Integer.valueOf(data.get(0)));   //订单类型 要改的
//                            shujigoumaiOrderEntity.setShujigoumaiOrderPaymentTypes(Integer.valueOf(data.get(0)));   //支付类型 要改的
//                            shujigoumaiOrderEntity.setInsertTime(date);//时间
//                            shujigoumaiOrderEntity.setCreateTime(date);//时间
                            shujigoumaiOrderList.add(shujigoumaiOrderEntity);


                            //把要查询是否重复的字段放入map中
                                //订单号
                                if(seachFields.containsKey("shujigoumaiOrderUuidNumber")){
                                    List<String> shujigoumaiOrderUuidNumber = seachFields.get("shujigoumaiOrderUuidNumber");
                                    shujigoumaiOrderUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> shujigoumaiOrderUuidNumber = new ArrayList<>();
                                    shujigoumaiOrderUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("shujigoumaiOrderUuidNumber",shujigoumaiOrderUuidNumber);
                                }
                        }

                        //查询是否重复
                         //订单号
                        List<ShujigoumaiOrderEntity> shujigoumaiOrderEntities_shujigoumaiOrderUuidNumber = shujigoumaiOrderService.selectList(new EntityWrapper<ShujigoumaiOrderEntity>().in("shujigoumai_order_uuid_number", seachFields.get("shujigoumaiOrderUuidNumber")));
                        if(shujigoumaiOrderEntities_shujigoumaiOrderUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ShujigoumaiOrderEntity s:shujigoumaiOrderEntities_shujigoumaiOrderUuidNumber){
                                repeatFields.add(s.getShujigoumaiOrderUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [订单号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        shujigoumaiOrderService.insertBatch(shujigoumaiOrderList);
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
        PageUtils page = shujigoumaiOrderService.queryPage(params);

        //字典表数据转换
        List<ShujigoumaiOrderView> list =(List<ShujigoumaiOrderView>)page.getList();
        for(ShujigoumaiOrderView c:list)
            dictionaryService.dictionaryConvert(c, request); //修改对应字典表字段
        return R.ok().put("data", page);
    }

    /**
    * 前端详情
    */
    @RequestMapping("/detail/{id}")
    public R detail(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("detail方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ShujigoumaiOrderEntity shujigoumaiOrder = shujigoumaiOrderService.selectById(id);
            if(shujigoumaiOrder !=null){


                //entity转view
                ShujigoumaiOrderView view = new ShujigoumaiOrderView();
                BeanUtils.copyProperties( shujigoumaiOrder , view );//把实体数据重构到view中

                //级联表
                    AddressEntity address = addressService.selectById(shujigoumaiOrder.getAddressId());
                if(address != null){
                    BeanUtils.copyProperties( address , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setAddressId(address.getId());
                }
                //级联表
                    ShujigoumaiEntity shujigoumai = shujigoumaiService.selectById(shujigoumaiOrder.getShujigoumaiId());
                if(shujigoumai != null){
                    BeanUtils.copyProperties( shujigoumai , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setShujigoumaiId(shujigoumai.getId());
                }
                //级联表
                    YonghuEntity yonghu = yonghuService.selectById(shujigoumaiOrder.getYonghuId());
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
    public R add(@RequestBody ShujigoumaiOrderEntity shujigoumaiOrder, HttpServletRequest request){
        logger.debug("add方法:,,Controller:{},,shujigoumaiOrder:{}",this.getClass().getName(),shujigoumaiOrder.toString());
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if("用户".equals(role)){
            ShujigoumaiEntity shujigoumaiEntity = shujigoumaiService.selectById(shujigoumaiOrder.getShujigoumaiId());
            if(shujigoumaiEntity == null){
                return R.error(511,"查不到该物品");
            }
            // Double shujigoumaiNewMoney = shujigoumaiEntity.getShujigoumaiNewMoney();

            if(false){
            }
            else if((shujigoumaiEntity.getShujigoumaiKucunNumber() -shujigoumaiOrder.getBuyNumber())<0){
                return R.error(511,"购买数量不能大于库存数量");
            }
            else if(shujigoumaiEntity.getShujigoumaiNewMoney() == null){
                return R.error(511,"物品价格不能为空");
            }

            //计算所获得积分
            Double buyJifen =0.0;
            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");
            double balance = yonghuEntity.getNewMoney() - shujigoumaiEntity.getShujigoumaiNewMoney()*shujigoumaiOrder.getBuyNumber();//余额
            if(balance<0)
                return R.error(511,"余额不够支付");
            shujigoumaiOrder.setShujigoumaiOrderTypes(2); //设置订单状态为已支付
            shujigoumaiOrder.setShujigoumaiOrderTruePrice(shujigoumaiEntity.getShujigoumaiNewMoney()*shujigoumaiOrder.getBuyNumber()); //设置实付价格
            shujigoumaiOrder.setYonghuId(userId); //设置订单支付人id
            shujigoumaiOrder.setShujigoumaiOrderPaymentTypes(1);
            shujigoumaiOrder.setInsertTime(new Date());
            shujigoumaiOrder.setCreateTime(new Date());
                shujigoumaiEntity.setShujigoumaiKucunNumber( shujigoumaiEntity.getShujigoumaiKucunNumber() -shujigoumaiOrder.getBuyNumber());
                shujigoumaiService.updateById(shujigoumaiEntity);
                shujigoumaiOrderService.insert(shujigoumaiOrder);//新增订单
            yonghuEntity.setNewMoney(balance);//设置金额
            yonghuService.updateById(yonghuEntity);
            return R.ok();
        }else{
            return R.error(511,"您没有权限支付订单");
        }
    }
    /**
     * 添加订单
     */
    @RequestMapping("/order")
    public R add(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("order方法:,,Controller:{},,params:{}",this.getClass().getName(),params.toString());
        String shujigoumaiOrderUuidNumber = String.valueOf(new Date().getTime());

        //获取当前登录用户的id
        Integer userId = (Integer) request.getSession().getAttribute("userId");
        Integer addressId = Integer.valueOf(String.valueOf(params.get("addressId")));

        Integer shujigoumaiOrderPaymentTypes = Integer.valueOf(String.valueOf(params.get("shujigoumaiOrderPaymentTypes")));//支付类型

        String data = String.valueOf(params.get("shujigoumais"));
        JSONArray jsonArray = JSON.parseArray(data);
        List<Map> shujigoumais = JSON.parseObject(jsonArray.toString(), List.class);

        //获取当前登录用户的个人信息
        YonghuEntity yonghuEntity = yonghuService.selectById(userId);

        //当前订单表
        List<ShujigoumaiOrderEntity> shujigoumaiOrderList = new ArrayList<>();
        //商品表
        List<ShujigoumaiEntity> shujigoumaiList = new ArrayList<>();
        //购物车ids
        List<Integer> cartIds = new ArrayList<>();

        BigDecimal zhekou = new BigDecimal(1.0);

        //循环取出需要的数据
        for (Map<String, Object> map : shujigoumais) {
           //取值
            Integer shujigoumaiId = Integer.valueOf(String.valueOf(map.get("shujigoumaiId")));//商品id
            Integer buyNumber = Integer.valueOf(String.valueOf(map.get("buyNumber")));//购买数量
            ShujigoumaiEntity shujigoumaiEntity = shujigoumaiService.selectById(shujigoumaiId);//购买的商品
            String id = String.valueOf(map.get("id"));
            if(StringUtil.isNotEmpty(id))
                cartIds.add(Integer.valueOf(id));

            //判断商品的库存是否足够
            if(shujigoumaiEntity.getShujigoumaiKucunNumber() < buyNumber){
                //商品库存不足直接返回
                return R.error(shujigoumaiEntity.getShujigoumaiName()+"的库存不足");
            }else{
                //商品库存充足就减库存
                shujigoumaiEntity.setShujigoumaiKucunNumber(shujigoumaiEntity.getShujigoumaiKucunNumber() - buyNumber);
            }

            //订单信息表增加数据
            ShujigoumaiOrderEntity shujigoumaiOrderEntity = new ShujigoumaiOrderEntity<>();

            //赋值订单信息
            shujigoumaiOrderEntity.setShujigoumaiOrderUuidNumber(shujigoumaiOrderUuidNumber);//订单号
            shujigoumaiOrderEntity.setShujigoumaiId(shujigoumaiId);//书籍
            shujigoumaiOrderEntity.setYonghuId(userId);//用户
            shujigoumaiOrderEntity.setAddressId(addressId);//地址
            shujigoumaiOrderEntity.setBuyNumber(buyNumber);//购买的数量 ？？？？？？
            shujigoumaiOrderEntity.setShujigoumaiOrderTypes(2);//订单类型
            shujigoumaiOrderEntity.setShujigoumaiOrderPaymentTypes(shujigoumaiOrderPaymentTypes);//支付类型
            shujigoumaiOrderEntity.setInsertTime(new Date());//订单创建时间
            shujigoumaiOrderEntity.setCreateTime(new Date());//创建时间

            //判断是什么支付方式 1代表余额 2代表积分
            if(shujigoumaiOrderPaymentTypes == 1){//余额支付
                //计算金额
                Double money = new BigDecimal(shujigoumaiEntity.getShujigoumaiNewMoney()).multiply(new BigDecimal(buyNumber)).multiply(zhekou).doubleValue();

                if(yonghuEntity.getNewMoney() - money <0 ){
                    return R.error("余额不足,请充值！！！");
                }else{
                    //计算所获得积分
                    Double buyJifen =0.0;
                    yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() - money); //设置金额


                    shujigoumaiOrderEntity.setShujigoumaiOrderTruePrice(money);

                }
            }
            shujigoumaiOrderList.add(shujigoumaiOrderEntity);
            shujigoumaiList.add(shujigoumaiEntity);

        }
        shujigoumaiOrderService.insertBatch(shujigoumaiOrderList);
        shujigoumaiService.updateBatchById(shujigoumaiList);
        yonghuService.updateById(yonghuEntity);
        if(cartIds != null && cartIds.size()>0)
            cartService.deleteBatchIds(cartIds);
        return R.ok();
    }






    /**
    * 退款
    */
    @RequestMapping("/refund")
    public R refund(Integer id, HttpServletRequest request){
        logger.debug("refund方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));

        if("用户".equals(role)){
            ShujigoumaiOrderEntity shujigoumaiOrder = shujigoumaiOrderService.selectById(id);
            Integer buyNumber = shujigoumaiOrder.getBuyNumber();
            Integer shujigoumaiOrderPaymentTypes = shujigoumaiOrder.getShujigoumaiOrderPaymentTypes();
            Integer shujigoumaiId = shujigoumaiOrder.getShujigoumaiId();
            if(shujigoumaiId == null)
                return R.error(511,"查不到该物品");
            ShujigoumaiEntity shujigoumaiEntity = shujigoumaiService.selectById(shujigoumaiId);
            if(shujigoumaiEntity == null)
                return R.error(511,"查不到该物品");
            Double shujigoumaiNewMoney = shujigoumaiEntity.getShujigoumaiNewMoney();
            if(shujigoumaiNewMoney == null)
                return R.error(511,"物品价格不能为空");

            Integer userId = (Integer) request.getSession().getAttribute("userId");
            YonghuEntity yonghuEntity = yonghuService.selectById(userId);
            if(yonghuEntity == null)
                return R.error(511,"用户不能为空");
            if(yonghuEntity.getNewMoney() == null)
                return R.error(511,"用户金额不能为空");

            Double zhekou = 1.0;


            //判断是什么支付方式 1代表余额 2代表积分
            if(shujigoumaiOrderPaymentTypes == 1){//余额支付
                //计算金额
                Double money = shujigoumaiEntity.getShujigoumaiNewMoney() * buyNumber  * zhekou;
                //计算所获得积分
                Double buyJifen = 0.0;
                yonghuEntity.setNewMoney(yonghuEntity.getNewMoney() + money); //设置金额


            }

            shujigoumaiEntity.setShujigoumaiKucunNumber(shujigoumaiEntity.getShujigoumaiKucunNumber() + buyNumber);



            shujigoumaiOrder.setShujigoumaiOrderTypes(1);//设置订单状态为退款
            shujigoumaiOrderService.updateById(shujigoumaiOrder);//根据id更新
            yonghuService.updateById(yonghuEntity);//更新用户信息
            shujigoumaiService.updateById(shujigoumaiEntity);//更新订单中物品的信息
            return R.ok();
        }else{
            return R.error(511,"您没有权限退款");
        }
    }


    /**
     * 发货
     */
    @RequestMapping("/deliver")
    public R deliver(Integer id){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        ShujigoumaiOrderEntity  shujigoumaiOrderEntity = new  ShujigoumaiOrderEntity();;
        shujigoumaiOrderEntity.setId(id);
        shujigoumaiOrderEntity.setShujigoumaiOrderTypes(3);
        boolean b =  shujigoumaiOrderService.updateById( shujigoumaiOrderEntity);
        if(!b){
            return R.error("发货出错");
        }
        return R.ok();
    }









    /**
     * 收货
     */
    @RequestMapping("/receiving")
    public R receiving(Integer id){
        logger.debug("refund:,,Controller:{},,ids:{}",this.getClass().getName(),id.toString());
        ShujigoumaiOrderEntity  shujigoumaiOrderEntity = new  ShujigoumaiOrderEntity();
        shujigoumaiOrderEntity.setId(id);
        shujigoumaiOrderEntity.setShujigoumaiOrderTypes(4);
        boolean b =  shujigoumaiOrderService.updateById( shujigoumaiOrderEntity);
        if(!b){
            return R.error("收货出错");
        }
        return R.ok();
    }



    /**
    * 评价
    */
    @RequestMapping("/commentback")
    public R commentback(Integer id, String commentbackText,HttpServletRequest request){
        logger.debug("commentback方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if("用户".equals(role)){
            ShujigoumaiOrderEntity shujigoumaiOrder = shujigoumaiOrderService.selectById(id);
        if(shujigoumaiOrder == null)
            return R.error(511,"查不到该订单");
        if(shujigoumaiOrder.getShujigoumaiOrderTypes() != 4)
            return R.error(511,"您不能评价");
        Integer shujigoumaiId = shujigoumaiOrder.getShujigoumaiId();
        if(shujigoumaiId == null)
            return R.error(511,"查不到该物品");

        ShujigoumaiCommentbackEntity shujigoumaiCommentbackEntity = new ShujigoumaiCommentbackEntity();
            shujigoumaiCommentbackEntity.setId(id);
            shujigoumaiCommentbackEntity.setShujigoumaiId(shujigoumaiId);
            shujigoumaiCommentbackEntity.setYonghuId((Integer) request.getSession().getAttribute("userId"));
            shujigoumaiCommentbackEntity.setShujigoumaiCommentbackText(commentbackText);
            shujigoumaiCommentbackEntity.setReplyText(null);
            shujigoumaiCommentbackEntity.setInsertTime(new Date());
            shujigoumaiCommentbackEntity.setUpdateTime(null);
            shujigoumaiCommentbackEntity.setCreateTime(new Date());
            shujigoumaiCommentbackService.insert(shujigoumaiCommentbackEntity);

            shujigoumaiOrder.setShujigoumaiOrderTypes(5);//设置订单状态为已评价
            shujigoumaiOrderService.updateById(shujigoumaiOrder);//根据id更新
            return R.ok();
        }else{
            return R.error(511,"您没有权限评价");
        }
    }












}
