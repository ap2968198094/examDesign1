/*
SQLyog Ultimate v12.08 (64 bit)
MySQL - 8.0.17 : Database - exam_store
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`exam_store` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `exam_store`;

/*Table structure for table `commodity_category` */

DROP TABLE IF EXISTS `commodity_category`;

CREATE TABLE `commodity_category` (
  `category_id` int(10) NOT NULL AUTO_INCREMENT,
  `category_name` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`category_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `commodity_category` */

insert  into `commodity_category`(`category_id`,`category_name`) values (1,'手机'),(2,'零食'),(3,'家居'),(4,'护肤'),(5,'化妆品');

/*Table structure for table `commodity_info` */

DROP TABLE IF EXISTS `commodity_info`;

CREATE TABLE `commodity_info` (
  `commodity_id` int(11) NOT NULL AUTO_INCREMENT,
  `commodity_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品名称',
  `commodity_price` varchar(10) COLLATE utf8mb4_general_ci NOT NULL COMMENT '商品单价',
  `commodity_description` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '描述',
  `commodity_stock` int(11) NOT NULL COMMENT '库存',
  `commodity_icon` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '小图',
  `commodity_category` int(11) NOT NULL COMMENT '类目编号',
  PRIMARY KEY (`commodity_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品表';

/*Data for the table `commodity_info` */

insert  into `commodity_info`(`commodity_id`,`commodity_name`,`commodity_price`,`commodity_description`,`commodity_stock`,`commodity_icon`,`commodity_category`) values (1,'Honor 8A','1800.00','华为honor/荣耀 荣耀畅玩8A 全面屏手机荣耀play3畅玩8c 7x ',6,'image/phone1.jpg',1),(2,'Honor 9i','2800.00','honor/荣耀 荣耀9i 全网通4G华为智能手机全面屏8X 9X 10青春20i ',10,'image/phone2.jpg',1),(3,'Honor 20','2299.00','【8+256直降200元】华为HONOR 荣耀20手机正品全面屏超广角AI四摄 ',10,'image/Honor20.png',1),(4,'iPhone 8Plus','1850.00','【iPhone 8 Plus】Apple/苹果 iPhone 8 Plus 苹果国行iphone8x手机8代 ',10,'image/iPhone8Plus.jpg',1),(5,'iPhone 11','3200.00','Apple/苹果 iPhone 11 苹果Pro max国行正品手机双卡双待 ',10,'image/iPhone11.png',1),(6,'vivo X50','3498.00','【新品上市 预定享15重礼】vivo X50双模5G智能手机官方旗舰店官网正品vivoX50全新限量版',10,'image/vivoX50.jpg',1),(7,'每日坚果','139.00','良品铺子每日坚果750g混合小包装干果礼盒盒子零食大礼包30袋 ',10,'image/snack1.jpg',2),(8,'情话薄荷糖','9.90','情话牛轧糖果表白礼盒装结婚批发散装网红小零食带字花生牛扎喜糖',10,'image/snack2.jpg',2),(9,'德斯蒂巧克力','19.90','destine德斯蒂特拉伏勒榛子酱巧克力可可脂黑松露型零食品 ',10,'image/snack3.jpg',2),(10,'其妙肉松饼','29.80','其妙肉松饼早餐面包绿豆饼饼干零食充饥夜宵整箱小吃休闲食品糕点 ',10,'image/snack4.jpg',2),(11,'良品铺子猪肉铺','24.80','【良品铺子-猪肉脯200g】零食小吃麻辣肉干网红休闲食品小包装 ',10,'image/snack6.jpg',2),(12,'肉松饼','26.80','雪媚娘蛋黄酥糕点网红零食小吃休闲食品好吃的排行榜面包整箱5斤 ',10,'image/snack5.jpg',2),(13,'懒角落 储物架','29.90','懒角落 厨房滑轮锅盖架置物架塑料锅具收纳架调料架储物架',10,'image/live1.jpg',3),(14,'牙膏架','49.00','创意家居生活用品小百货女男宿舍好物家居用品学生初中高中百货店 ',10,'image/live2.jpg',3),(15,'厨房置物架','39.00','厨房置物架壁挂式收纳百货用具用品调味料挂架子厨具用品用具刀架 ',10,'image/live3.jpg',3),(16,'三角放锅架','24.50','瓷木一道 厨房三角放锅架置物架 落地角落碗碟锅盖收纳架灶台架子 ',10,'image/live4.jpg',3),(17,'冰块模具','5.90','家用自制冰箱冻冰块模具创意带盖冰格子制冰盒商用冰格速冻器神器 ',10,'image/live5.jpg',3),(18,'垃圾桶','4.50','垃圾分类垃圾桶垃圾篓家用压圈厨房卫生间客厅卧室垃圾筒纸篓包邮 ',10,'image/live6.jpg',3),(19,'欧莱雅抗皱套装','589.00','欧莱雅复颜抗皱紧致抗衰老水乳化妆品妈妈护肤品套装女士补水正品 ',10,'image/skincare1.jpg',4),(20,'谷雨保湿水乳','149.00','谷雨仙人掌沁润补水套装保湿锁水控油滋润水乳清爽护肤化妆品男女 ',10,'image/skincare2.jpg',4),(21,'HFP保湿套装','398.00','HFP补水保湿美白套装 夏季清爽型水乳控油护肤化妆品旗舰正品男女 ',10,'image/skincare3.jpg',4),(22,'AHC男士水乳保湿套装','198.00','AHC男士水乳套装面部护肤品化妆品控油补水清爽祛痘韩国旗舰正品 ',10,'image/skincare4.jpg',4),(23,'百雀羚套装','159.00','百雀羚水嫩倍现水乳护肤套装补水保湿化妆品护肤品官方旗舰店正品 ',10,'image/skincare5.jpg',4),(24,'极地之悦龙血树套装','269.00','moonseem极地之悦龙血树控油祛痘护肤套装水乳化妆品全套男女士 ',10,'image/skincare6.jpg',4),(25,'花西子三角眉笔','59.00','花西子极细三角眉笔/持久防水防汗初学者不容易脱色晕染超细网红 ',10,'image/cosmetic1.jpg',5),(26,'稚优泉散粉刷','39.90','稚优泉便携散粉刷一支装化妆刷可伸缩柔软蜜粉饼美妆刷收纳定妆女 ',10,'image/cosmetic2.jpg',5),(27,'Beauty today化妆刷','128.00','Beauty today化妆刷腮红刷散粉刷眼影刷修容粉底刷网红全套美妆刷 ',10,'image/cosmetic3.jpg',5),(28,'croxx银蚀孤品丝绒口红','139.00','【新品】croxx银蚀孤品丝绒口红哑光雾面唇膏女学生持久正红 ',10,'image/cosmetic4.jpg',5),(29,'阿玛尼权力粉底液','580.00','【618活动】Armani/阿玛尼权力粉底液持久不脱妆油皮遮瑕控油 ',10,'image/cosmetic5.jpg',5),(30,'colourpop眼影盘','258.00','colourpop眼影盘卡拉泡泡colorpop眼影珊瑚盘超火挚爱加州日落盘 ',10,'image/cosmetic6.jpg',5);

/*Table structure for table `commodity_order` */

DROP TABLE IF EXISTS `commodity_order`;

CREATE TABLE `commodity_order` (
  `order_id` int(10) NOT NULL AUTO_INCREMENT,
  `order_price` varchar(10) DEFAULT NULL,
  `order_status` varchar(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `user_id` int(10) DEFAULT NULL,
  PRIMARY KEY (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `commodity_order` */

insert  into `commodity_order`(`order_id`,`order_price`,`order_status`,`user_id`) values (1,'2800.0','N',NULL),(2,'2800.0','N',NULL),(3,'1800.0','Y',NULL),(4,'4600.0','Y',NULL),(5,'1800.0','Y',NULL),(6,'1800.0','Y',NULL),(7,'1800.0','Y',NULL),(8,'1800.0','Y',31),(9,'1800.0','Y',31),(10,'1800.0','Y',41);

/*Table structure for table `commodity_specs` */

DROP TABLE IF EXISTS `commodity_specs`;

CREATE TABLE `commodity_specs` (
  `specs_id` int(11) NOT NULL AUTO_INCREMENT,
  `commodity_id` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL,
  `specs_name` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '规格名称',
  `specs_stock` int(11) NOT NULL COMMENT '库存',
  `specs_price` varchar(10) COLLATE utf8mb4_general_ci NOT NULL COMMENT '单价',
  `specs_icon` varchar(512) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci DEFAULT NULL COMMENT '小图',
  PRIMARY KEY (`specs_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci COMMENT='商品规格表';

/*Data for the table `commodity_specs` */

insert  into `commodity_specs`(`specs_id`,`commodity_id`,`specs_name`,`specs_stock`,`specs_price`,`specs_icon`) values (1,'1','32GB',5,'2800.00','..');

/*Table structure for table `favorite` */

DROP TABLE IF EXISTS `favorite`;

CREATE TABLE `favorite` (
  `commodity_id` int(10) DEFAULT NULL,
  `user_id` int(10) DEFAULT NULL,
  `id` int(10) NOT NULL AUTO_INCREMENT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `favorite` */

insert  into `favorite`(`commodity_id`,`user_id`,`id`) values (1,31,5),(2,31,6);

/*Table structure for table `user` */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(100) NOT NULL,
  `password` varchar(32) NOT NULL,
  `name` varchar(100) DEFAULT NULL,
  `birthday` date DEFAULT NULL,
  `sex` char(1) DEFAULT NULL,
  `telephone` varchar(11) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `status` char(1) DEFAULT NULL,
  `code` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`uid`),
  UNIQUE KEY `AK_nq_username` (`username`),
  UNIQUE KEY `AK_nq_code` (`code`)
) ENGINE=InnoDB AUTO_INCREMENT=42 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

/*Data for the table `user` */

insert  into `user`(`uid`,`username`,`password`,`name`,`birthday`,`sex`,`telephone`,`email`,`status`,`code`) values (31,'zhangsan','12345678','王晓龙','2020-06-02','男','18773227890','2968198094@qq.com','Y','391dc36b3a1e426891629b99ca9c2fb5'),(41,'baby123456','12345678','1111','2020-06-10','男','18773227890','2968198094@qq.com','Y','12c8007cdd4d4717a1c4c255903f8592');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
