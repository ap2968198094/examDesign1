# prjectdesign

#### 介绍
    本项目是web课程设计题目，目的为构建一个尽量完整的购物系统网站，整体采用前后端分离
 的构建模式，后端使用springboot框架为主体框架，前端用html，使用到了layui等ui框架
#### 软件架构
软件架构说明  
本项目使用技术：  

整体使用maven项目，通过pom.xml导入依赖  

    1.springboot框架  
    
    2.Spring JPA  
    
    3.mysql数据库  
    
    4.lombok插件  
    
    5.发送邮件mail工具类 
 
前端使用  

    1.layui框架  
    2.bootstrap框架  
    3.jq框架  
    4.异步请求  


#### 安装教程

1.导入maven依赖  

2.idea需要装lombok插件以及yml配置格式插件  

3.导入sql中的数据库文件

#### 使用说明

1.修改applicaton.yml的数据库配置  

2.启动application启动类

#### 已完成功能
1.注册功能：  

    1.设置失焦事件判断输入是否合法  
    
    2.通过controller请求动态验证码  
    
    3.通过邮件工具类发送邮件，并点击地址进行激活，设置激活码和激活状态
    
2.登录功能：

    1.通过controller请求动态验证码
    
    2.非空验证
    
    3.数据传到后端进行查找并验证激活状态 同时将user设置到session中
    
3.退出功能

    1.点击退出按钮，异步请求后端，删除session中的user，并跳转到登录页面
    
4.展示头部类别功能
    
    1.从数据库查找分类信息传递给前端
    
    2.前端设置列表的html内容
    
    3.同时点击的时候进入分页列表，并传递类别的id
    
5.分类数据分页展示功能

    1.根据传过来的类别id以及当前页数进行查询商品信息，返回商品总条数，总页数，每页的数据
    
    2.对总页数设置访问地址，点哪一页则传递哪一页为当前页给后端来查询数据
    
    3.对返回来的商品信息进行展示，并设置点击详情链接，点击同时将商品id传递过去

6.详情页展示
    
    1.根据传过来的商品id进行异步请求查找该id的所有信息进行展示
    
    2.可以设置多张图片，鼠标点击则更换显示大图
    
7.判断是否登陆
    
    1.在点击加入购物车时，请求后端对session中的user进行查找，如果没有，则跳转登录页面，如果有则继续加入购物车功能
    
8.加入购物车

    1.点击加入购物车，异步请求后端将商品id传递过去，在后端根据id进行查找，并将其添加到list集合中，设置到session中
    
    2.若session中没有该条属性，则新建list，放进session中
    
    3.若session中有该条属性，则拿出list，对其进行添加，再重新放入session中     
    
9.展示购物车信息

    1.在购物车页面进行异步请求，拿到session中的购物车list并返回，然后在页面遍历展示list中的商品信息      
    
10.结算
    
    1.结算旁边显示总金额，点击结算跳转到后端对订单进行保存，设置支付状态为“N”
    
    2.清除数据库的购物车session     
    
    3.支付成功后跳转到后台将支付状态改为“Y”
    
11.搜索

    1.根据头部输入框输入的信息进行搜索，查找包含信息的商品信息返回并展示
    
12.收藏

    1.点击收藏按钮，加入用户的收藏列表，然后刷新页面进行异步请求，如果已经收藏，修改按钮的样式，不可点且为灰色
    
13.跳转后台
    
    1.点击左上角logo，可以跳转至商品后台，会根据登录的用户判断其是否有访问权限，如果没有就返回首页

14.后台商品管理

    1.进入后台管理页面显示所有商品信息并分页，可以实现删除功能，但是因为导入数据麻烦没有实现，可以
    切换每页显示多少条数据
    
    2.所有商品下面有分类商品展示，同样功能
    
    3.有订单管理页面。
      
     
    


