import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'

     import users from '@/views/modules/users/list'
    import address from '@/views/modules/address/list'
    import cart from '@/views/modules/cart/list'
    import dictionary from '@/views/modules/dictionary/list'
    import juanzengshuji from '@/views/modules/juanzengshuji/list'
    import shujigoumai from '@/views/modules/shujigoumai/list'
    import shujigoumaiCommentback from '@/views/modules/shujigoumaiCommentback/list'
    import shujigoumaiOrder from '@/views/modules/shujigoumaiOrder/list'
    import shujijieyue from '@/views/modules/shujijieyue/list'
    import shujixinxi from '@/views/modules/shujixinxi/list'
    import yonghu from '@/views/modules/yonghu/list'
    import yuyueshuji from '@/views/modules/yuyueshuji/list'
    import config from '@/views/modules/config/list'
    import dictionaryIsdefault from '@/views/modules/dictionaryIsdefault/list'
    import dictionaryJieyue from '@/views/modules/dictionaryJieyue/list'
    import dictionaryNews from '@/views/modules/dictionaryNews/list'
    import dictionarySex from '@/views/modules/dictionarySex/list'
    import dictionaryShangxia from '@/views/modules/dictionaryShangxia/list'
    import dictionaryShujigoumai from '@/views/modules/dictionaryShujigoumai/list'
    import dictionaryShujigoumaiOrder from '@/views/modules/dictionaryShujigoumaiOrder/list'
    import dictionaryShujigoumaiOrderPayment from '@/views/modules/dictionaryShujigoumaiOrderPayment/list'





//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: '首页',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: '首页',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: '修改密码',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: '个人信息',
      component: center,
      meta: {icon:'', title:'center'}
    } ,{
        path: '/users',
        name: '管理信息',
        component: users
      }
    ,{
        path: '/dictionaryIsdefault',
        name: '是否默认地址',
        component: dictionaryIsdefault
    }
    ,{
        path: '/dictionaryJieyue',
        name: '借阅状态',
        component: dictionaryJieyue
    }
    ,{
        path: '/dictionaryNews',
        name: '新闻类型名称',
        component: dictionaryNews
    }
    ,{
        path: '/dictionarySex',
        name: '性别类型名称',
        component: dictionarySex
    }
    ,{
        path: '/dictionaryShangxia',
        name: '上下架',
        component: dictionaryShangxia
    }
    ,{
        path: '/dictionaryShujigoumai',
        name: '书籍类型',
        component: dictionaryShujigoumai
    }
    ,{
        path: '/dictionaryShujigoumaiOrder',
        name: '订单类型名称',
        component: dictionaryShujigoumaiOrder
    }
    ,{
        path: '/dictionaryShujigoumaiOrderPayment',
        name: '支付方式',
        component: dictionaryShujigoumaiOrderPayment
    }
    ,{
        path: '/config',
        name: '轮播图',
        component: config
    }


    ,{
        path: '/address',
        name: '收货地址',
        component: address
      }
    ,{
        path: '/cart',
        name: '购物车',
        component: cart
      }
    ,{
        path: '/dictionary',
        name: '字典表',
        component: dictionary
      }
    ,{
        path: '/juanzengshuji',
        name: '捐赠书籍',
        component: juanzengshuji
      }
    ,{
        path: '/shujigoumai',
        name: '书籍购买',
        component: shujigoumai
      }
    ,{
        path: '/shujigoumaiCommentback',
        name: '书籍评价',
        component: shujigoumaiCommentback
      }
    ,{
        path: '/shujigoumaiOrder',
        name: '书籍订单',
        component: shujigoumaiOrder
      }
    ,{
        path: '/shujijieyue',
        name: '书籍借阅记录',
        component: shujijieyue
      }
    ,{
        path: '/shujixinxi',
        name: '书籍信息',
        component: shujixinxi
      }
    ,{
        path: '/yonghu',
        name: '用户',
        component: yonghu
      }
    ,{
        path: '/yuyueshuji',
        name: '预约书籍',
        component: yuyueshuji
      }


    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: '首页',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})

export default router;
