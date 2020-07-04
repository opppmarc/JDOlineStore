/*
Navicat MySQL Data Transfer

Source Server         : .
Source Server Version : 50621
Source Host           : localhost:3306
Source Database       : shop2

Target Server Type    : MYSQL
Target Server Version : 50621
File Encoding         : 65001

Date: 2018-01-15 16:26:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `cart`
-- ----------------------------
DROP TABLE IF EXISTS `cart`;
CREATE TABLE `cart` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT,
  `uid` bigint(11) NOT NULL COMMENT '用户id',
  `pid` bigint(200) DEFAULT NULL COMMENT '商品id',
  `img` varchar(500) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `num` bigint(20) DEFAULT NULL,
  `create_time` date DEFAULT NULL,
  `update_time` date DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=27 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cart
-- ----------------------------
INSERT INTO `cart` VALUES ('6', '1', '7', 'img/7.jpg', '118', '1', '2018-01-14', null);
INSERT INTO `cart` VALUES ('21', '1', '16', 'img/16.jpg', '45', '2', '2018-01-15', '2018-01-15');
INSERT INTO `cart` VALUES ('22', '1', '2', 'img/2.jpg', '30220', '3', '2018-01-15', '2018-01-15');
INSERT INTO `cart` VALUES ('23', '1', '4', 'img/4.jpg', '5', '2', '2018-01-15', '2018-01-15');
INSERT INTO `cart` VALUES ('24', '1', '3', 'img/3.jpg', '49', '6', '2018-01-15', '2018-01-15');

-- ----------------------------
-- Table structure for `category`
-- ----------------------------
DROP TABLE IF EXISTS `category`;
CREATE TABLE `category` (
  `cid` int(11) NOT NULL,
  `parent_id` int(11) DEFAULT NULL,
  `name` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of category
-- ----------------------------
INSERT INTO `category` VALUES ('111111', '11111111', '李');

-- ----------------------------
-- Table structure for `order`
-- ----------------------------
DROP TABLE IF EXISTS `order`;
CREATE TABLE `order` (
  `oid` int(11) NOT NULL,
  `uid` int(11) DEFAULT NULL,
  `payment` double(20,0) DEFAULT NULL,
  `post_fee` double(20,0) DEFAULT NULL,
  `status` varchar(50) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL,
  `update_time` datetime DEFAULT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order
-- ----------------------------

-- ----------------------------
-- Table structure for `order_detail`
-- ----------------------------
DROP TABLE IF EXISTS `order_detail`;
CREATE TABLE `order_detail` (
  `oid` int(11) NOT NULL,
  `pid` int(11) DEFAULT NULL,
  `num` int(11) DEFAULT NULL,
  `pname` varchar(200) DEFAULT NULL,
  `price` double(11,0) DEFAULT NULL,
  `img` varchar(200) DEFAULT NULL,
  `total_fee` double(11,0) DEFAULT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of order_detail
-- ----------------------------

-- ----------------------------
-- Table structure for `product`
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `cid` int(11) DEFAULT NULL,
  `name` varchar(200) DEFAULT NULL,
  `price` int(80) DEFAULT NULL,
  `pdesc` varchar(200) DEFAULT NULL,
  `stock` int(100) DEFAULT NULL,
  `img` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`pid`),
  KEY `cid` (`cid`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('2', null, '松下(panasonic) NR-W620TF-XM 双层冷冻 法式多门 -3度微冻保鲜 APP远程控制', '30220', '松下(panasonic) NR-W620TF-XM 双层冷冻 法式多门 -3度微冻保鲜 APP远程控制', '343', 'img/2.jpg');
INSERT INTO `product` VALUES ('3', null, '海信(Hisense) LED32EC300D 32英寸 高清蓝光 平板电视 金属背板 黑色', '49', '创维(Skyworth) 55M9 55英寸4K超清智能15核网络平板液晶电视 (黑色)', '456', 'img/3.jpg');
INSERT INTO `product` VALUES ('4', null, '海信(Hisense) LED32EC300D 32英寸 高清蓝光 平板电视 金属背板 黑色', '5', '海信(Hisense) LED32EC300D 32英寸 高清蓝光 平板电视 金属背板 黑色', '565', 'img/4.jpg');
INSERT INTO `product` VALUES ('5', null, '康佳（KONKA）A55U 55英寸 4K超高清 64位智能 安卓 LED液晶平板电视（黑色）', '21', '康佳（KONKA）A55U 55英寸 4K超高清 64位智能 安卓 LED液晶平板电视（黑色）', '345', 'img/5.jpg');
INSERT INTO `product` VALUES ('6', null, '小米电视4A（标准版） L65M5-AZ 65英寸 4K超高清 彩电 四核64位高性能处理器 黑', '55', '小米电视4A（标准版） L65M5-AZ 65英寸 4K超高清 彩电 四核64位高性能处理器 黑', '787', 'img/6.jpg');
INSERT INTO `product` VALUES ('7', null, '海尔(Haier) LE32A30G 32英寸 高清至臻画质 内置WiFi 智能电视（黑色）', '118', '海尔(Haier) LE32A30G 32英寸 高清至臻画质 内置WiFi 智能电视（黑色）', '543', 'img/7.jpg');
INSERT INTO `product` VALUES ('8', null, '长虹（CHANGHONG）43M1 43英寸蓝光节能LED平板液晶电视机（黑色）', '6000', '长虹（CHANGHONG）43M1 43英寸蓝光节能LED平板液晶电视机（黑色）', '343', 'img/8.jpg');
INSERT INTO `product` VALUES ('9', null, '海信(Hisense) LED43EC300D 43英寸 高清蓝光 平板电视 金属背板 黑色', '29000', '海信(Hisense) LED43EC300D 43英寸 高清蓝光 平板电视 金属背板 黑色', '295', 'img/9.jpg');
INSERT INTO `product` VALUES ('10', null, '创维(Skyworth) 42X5 42英寸 6核全高清 液晶电视 LED窄边 智能网络 银色', '199', 'POLO单肩斜挎包小包手提包包新款百搭时尚通勤包女韩版斜挎', '222', 'img/10.jpg');
INSERT INTO `product` VALUES ('11', null, '三洋(SANYO) 32CE5100 32英寸 高清 动态背光控制 LED电视（黑色）', '60', '冬季新品小清新宽松加厚刺绣针织衫荷叶袖半高领学生套头毛衣女', '343', 'img/11.jpg');
INSERT INTO `product` VALUES ('12', null, '乐视超级电视 超4 X43 Pro 4K超高清 43英寸 3GB+16GB 4K智能高清液晶网络电视(底座版)', '14800', '乐视超级电视 超4 X43 Pro 4K超高清 43英寸 3GB+16GB 4K智能高清液晶网络电视(底座版)', '456', 'img/12.jpg');
INSERT INTO `product` VALUES ('13', null, '乐视TV(LETV) 超4X55 乐视 超4-X55 55英寸4K高清网络超级智能平板电视 智能语音遥控(银灰色 挂架版)', '209', '韩版翻领复古收腰系带加厚中长款毛呢外套女气质单排扣毛呢大衣', '655', 'img/13.jpg');
INSERT INTO `product` VALUES ('14', null, '乐视超级电视（LETV）超4 X40M 40英寸 HDR 3GB+16GB 智能语音控制 高清液晶网络电视(底座版)', '129', '冬季新款韩版加厚大翻领开衩呢子大衣简约百搭显瘦中长款毛呢外套', '345', 'img/14.jpg');
INSERT INTO `product` VALUES ('15', null, '海信(hisense) LED55N72U 55英寸 炫彩4Kpro超高清 超薄平板电视 14核 VIDAA智能系统 宙斯银', '129', '2017冬季新款女装韩版可爱棉服学生短款面包棉服', '343', 'img/15.jpg');
INSERT INTO `product` VALUES ('16', null, '乐视彩电LETV X3-43', '45', '连帽卫衣女学生加绒加厚秋冬装新款韩版潮宽松外套原宿BF风上衣', '354', 'img/16.jpg');
INSERT INTO `product` VALUES ('17', null, 'TCL彩电D49A620U 49英寸 超高清4K 内置wifi 海量在线影视 14核安卓智能LED液晶电视', '161', 'TCL彩电D49A620U 49英寸 超高清4K 内置wifi 海量在线影视 14核安卓智能LED液晶电视', '235', 'img/17.jpg');
INSERT INTO `product` VALUES ('18', null, '创维(Skyworth) 42X6 42英寸 10核 智能 网络平板液晶电视', '188', '冬季新款韩版加厚宽松百搭大毛领金丝绒棉衣中长款棉袄棉服外套女', '766', 'img/18.jpg');
INSERT INTO `product` VALUES ('19', null, 'KKTV S55 55英寸4K超高清18核64位HDR平板液晶智能电视机 康佳出品', '139', '冬季新款韩版纯色宽松百搭小个子大毛领短款加厚羽绒棉服外套女', '545', 'img/19.jpg');
INSERT INTO `product` VALUES ('20', null, 'Amoi夏新液晶电视机LE-8842C超薄窄边框电视机39英寸全高清蓝光LED平板液晶客厅电视', '176', '加厚大毛领棉衣女中长款面包服连帽棉服外套女冬季过膝棉袄女保暖', '243', 'img/20.jpg');
INSERT INTO `product` VALUES ('21', null, '海信（Hisense）LED55M5000U 55英寸 4K超高清 HDR 智能平板电视（香槟金）', '79', '2017新款秋冬鹿皮绒中长款胸口压折吊带连衣裙女裙子', '678', 'img/21.jpg');
INSERT INTO `product` VALUES ('22', null, '海信（Hisense）LED55M5000U 55英寸 4K超高清 HDR 智能平板电视（香槟金）', '59', '现货现发 韩国东大门新款 水貂绒百搭a字半身裙', '233', 'img/22.jpg');
INSERT INTO `product` VALUES ('23', null, '夏普 (SHARP) LCD-60SU470A 60英寸 4K超高清HDR广色域智能网络LED语音液晶平板电视 客厅电视', '100', '春夏新款百搭宽松牛仔短裙拉链开叉中长裙', '121', 'img/23.jpg');
INSERT INTO `product` VALUES ('24', null, '创维（Skyworth）58H7 58英寸 无边框 25核人工智能4K超高清智能网络液晶电视（银色）', '69', '创维（Skyworth）58H7 58英寸 无边框 25核人工智能4K超高清智能网络液晶电视（银色）', '766', 'img/24.jpg');
INSERT INTO `product` VALUES ('25', null, 'TCL 49A950C 49英寸32核人工智能 HDR曲面超薄4K电视金属机身', '4', 'TCL 49A950C 49英寸32核人工智能 HDR曲面超薄4K电视金属机身', '343', 'img/25.jpg');
INSERT INTO `product` VALUES ('26', null, '创维彩电55G6A 4K超高清智能LED彩电网络WIFI液晶平板电视 浅金', '76', '创维彩电55G6A 4K超高清智能LED彩电网络WIFI液晶平板电视 浅金', '676', 'img/26.jpg');
INSERT INTO `product` VALUES ('27', null, 'TCL 55C2 55英寸 4K·HDR 哈曼卡顿音响 34核超高清安卓智能LED电视（黑）', '75', 'TCL 55C2 55英寸 4K·HDR 哈曼卡顿音响 34核超高清安卓智能LED电视（黑）', '454', 'img/27.jpg');
INSERT INTO `product` VALUES ('28', null, '康佳（KONKA）LED24E330C 24英寸高清窄边液晶平板电视 支持显示器(黑色 黑色)', '4', '康佳（KONKA）LED24E330C 24英寸高清窄边液晶平板电视 支持显示器(黑色 黑色)', '454', 'img/28.jpg');
INSERT INTO `product` VALUES ('29', null, '暴风TV 40X 40英寸高清智能网络电视机 人工智能语音超薄平板液晶电视wifi\r\n', '118', '暴风TV 40X 40英寸高清智能网络电视机 人工智能语音超薄平板液晶电视wifi\r\n暴风TV 40X 40英寸高清智能网络电视机 人工智能语音超薄平板液晶电视wifi\r\n暴风TV 40X 40英寸高清智能网络电视机 人工智能语音超薄平板液晶电视wifi\r\n', '232', 'img/29.jpg');
INSERT INTO `product` VALUES ('30', null, '长虹(CHANGHONG)彩电 39E8 39英寸高清 标准模式+儿童模式 平板电视（浅金）', '60', '长虹(CHANGHONG)彩电 39E8 39英寸高清 标准模式+儿童模式 平板电视（浅金）', '545', 'img/30.jpg');
INSERT INTO `product` VALUES ('31', null, '海尔统帅（Leader）KFR-50LW/16PAQ22ATU1 2匹智能速冷变频空调 二级能效 净化脏空气', '40', '海尔统帅（Leader）KFR-50LW/16PAQ22ATU1 2匹智能速冷变频空调 二级能效 净化脏空气', '454', 'img/31.jpg');
INSERT INTO `product` VALUES ('32', null, '美的（Midea）1.5匹 冷暖变频挂机 空调 适用面积（15-23m²）三级能效 电辅加热 KFR-35GW/WPAA3', '50', '美的（Midea）1.5匹 冷暖变频挂机 空调 适用面积（15-23m²）三级能效 电辅加热 KFR-35GW/WPAA3', '765', 'img/32.jpg');
INSERT INTO `product` VALUES ('33', null, '奥克斯（AUX）正1.5匹 变频 极速侠 冷暖 二级能效 WIFI智能 壁挂式空调 KFR-35GW/BpTYC2+2', '60', '奥克斯（AUX）正1.5匹 变频 极速侠 冷暖 二级能效 WIFI智能 壁挂式空调 KFR-35GW/BpTYC2+2', '454', 'img/33.jpg');
INSERT INTO `product` VALUES ('34', null, '海尔(Haier) 大1.5匹 冷暖定频挂机 空调 适用面积（16-25m²）PMV舒适系统 白 KFR-36GW/12HCA13', '35', '海尔(Haier) 大1.5匹 冷暖定频挂机 空调 适用面积（16-25m²）PMV舒适系统 白 KFR-36GW/12HCA13', '454', 'img/34.jpg');
INSERT INTO `product` VALUES ('35', null, '科龙(KELON) 大1匹 冷暖变频挂机 空调 适用面积（10-17m²）WIFI操控 三级能效 白 KFR-26GW/EFQSA3(1N05)', '60', '科龙(KELON) 大1匹 冷暖变频挂机 空调 适用面积（10-17m²）WIFI操控 三级能效 白 KFR-26GW/EFQSA3(1N05)', '565', 'img/35.jpg');
INSERT INTO `product` VALUES ('36', null, '格力（GREE）小1.5匹 定频 品圆冷暖 独立除湿 智能化霜 壁挂式空调 KFR-32GW/(32592)NhDa-3', '49', '格力（GREE）小1.5匹 定频 品圆冷暖 独立除湿 智能化霜 壁挂式空调 KFR-32GW/(32592)NhDa-3', '565', 'img/36.jpg');
INSERT INTO `product` VALUES ('37', null, '伊莱克斯(Electrolux) 大1P 变频 冷暖 壁挂式空调 EAW26VD12DA2', '30', '伊莱克斯(Electrolux) 大1P ', '343', 'img/37.jpg');
INSERT INTO `product` VALUES ('38', null, 'TCL KFRd-35GW/XD13BpA 1.5匹 变频 冷暖 壁挂式空调', '49', 'TCL KFRd-35GW/XD13BpA 1.5匹 变频 冷暖 壁挂式空调', '454', 'img/38.jpg');
INSERT INTO `product` VALUES ('39', null, '海尔(Haier) KFR-26GW/17AMA23AU1 大1匹 壁挂式 空调 变频 冷暖', '56', '海尔(Haier) KFR-26GW/17AMA23AU1 大1匹 壁挂式 空调 变频 冷暖', '344', 'img/39.jpg');
INSERT INTO `product` VALUES ('40', null, '格力(GREE) 小1.5匹 定频 品悦 冷暖电辅 壁挂式空调 KFR-32GW/(32592)NhAa-3(清爽白)', '68', '格力(GREE) 小1.5匹 定频 品悦 冷暖电辅 壁挂式空调 KFR-32GW/(32592)NhAa-3(清爽白)', '454', 'img/40.jpg');
INSERT INTO `product` VALUES ('41', null, '海尔(Haier) 3匹 冷暖变频圆柱式柜机 空调 适用面积（33-50m²）WIFI智能 二级能效 白 KFR-72LW/09UCP22AU1', '69', '海尔(Haier) 3匹 冷暖变频圆柱式柜机 空调 适用面积（33-50m²）WIFI智能 二级能效 白 KFR-72LW/09UCP22AU1', '456', 'img/41.jpg');
INSERT INTO `product` VALUES ('42', null, '美的(Midea) KFR-35GW/BP3DN8Y-IQ100(B1) 1.5匹 空调 冷暖 变频 一级能效 挂机', '78', '美的(Midea) KFR-35GW/BP3DN8Y-IQ100(B1) 1.5匹 空调 冷暖 变频 一级能效 挂机', '343', 'img/42.jpg');
INSERT INTO `product` VALUES ('43', null, '美的(Midea) KFR-35GW/BP3DN8Y-IQ100(B1) 1.5匹 空调 冷暖 变频 一级能效 挂机', '69', '美的(Midea) KFR-35GW/BP3DN8Y-IQ100(B1) 1.5匹 空调 冷暖 变频 一级能效 挂机', '656', 'img/43.jpg');
INSERT INTO `product` VALUES ('44', null, '格力(GREE) KFR-50LW/(505511)NhAaD-3(WIFI) 2匹 柜机 空调 定频 冷暖 银', '67', '格力(GREE) KFR-50LW/(505511)NhAaD-3(WIFI) 2匹 柜机 空调 定频 冷暖 银', '454', 'img/44.jpg');
INSERT INTO `product` VALUES ('45', null, '美的空调KFR-72QW/DY-B(E2)', '95', '美的空调KFR-72QW/DY-B(E2)', '454', 'img/45.jpg');
INSERT INTO `product` VALUES ('46', null, '格力(GREE) KFR-72LW/(72591)NhAd-2 3匹 柜机 空调 冷暖 定频 高亮白', '69', '格力(GREE) KFR-72LW/(72591)NhAd-2 3匹 柜机 空调 冷暖 定频 高亮白', '4554', 'img/46.jpg');
INSERT INTO `product` VALUES ('47', null, '海尔(Haier) KFR-50LW/12MAP22AU1 2匹 立柜式 空调 变频 冷暖 二级能效', '77', '海尔(Haier) KFR-50LW/12MAP22AU1 2匹 立柜式 空调 变频 冷暖 二级能效', '565', 'img/47.jpg');
INSERT INTO `product` VALUES ('48', null, '海尔(Haier) SKFR-72LW/11WDA13U1 3匹 立柜式 空调 定频 冷暖 智能WiFi控制 茉莉白', '69', '海尔(Haier) SKFR-72LW/11WDA13U1 3匹 立柜式 空调 定频 冷暖 智能WiFi控制 茉莉白', '454', 'img/48.jpg');
INSERT INTO `product` VALUES ('49', null, '格力空调KFR-50LW/(50579)FNCb-A3红', '96', '格力空调KFR-50LW/(50579)FNCb-A3红', '454', 'img/49.jpg');
INSERT INTO `product` VALUES ('50', null, '松下(Panasonic) 大1匹 单冷定频壁挂式 空调 二级能效 除PM2.5 独立除湿 PC10KJ2', '79', '松下(Panasonic) 大1匹 单冷定频壁挂式 空调 二级能效 除PM2.5 独立除湿 PC10KJ2', '454', 'img/50.jpg');
INSERT INTO `product` VALUES ('51', null, '海尔(Haier) BCD-458WDVMU1 458升 多门 冰箱 干湿分储五区保鲜 香槟金', '490', '海尔(Haier) BCD-458WDVMU1 458升 多门 冰箱 干湿分储五区保鲜 香槟金', '454', 'img/51.jpg');
INSERT INTO `product` VALUES ('52', null, '容声冰箱BCD-535WSS1HP钛空金', '10', '容声冰箱BCD-535WSS1HP钛空金', '988', 'img/52.jpg');
INSERT INTO `product` VALUES ('53', null, '海尔 (Haier) BCD-642WDVMU1 642升 对开门冰箱 风冷无霜 金', '139', '海尔 (Haier) BCD-642WDVMU1 642升 对开门冰箱 风冷无霜 金', '232', 'img/53.jpg');
INSERT INTO `product` VALUES ('54', null, '海尔（Haier）BCD-331WDGQ 331升 多门冰箱 风冷无霜 金色', '68', '海尔（Haier）BCD-331WDGQ 331升 多门冰箱 风冷无霜 金色', '565', 'img/54.jpg');
INSERT INTO `product` VALUES ('55', null, '西门子(siemens) KG28FA29EC 274升零度保鲜 三门冰箱(银色) 滤膜保湿 双动态冷却 LED内显', '128', '西门子(siemens) KG28FA29EC 274升零度保鲜 三门冰箱(银色) 滤膜保湿 双动态冷却 LED内显', '454', 'img/55.jpg');
INSERT INTO `product` VALUES ('56', null, '海尔(Haier) BCD-451WDIYU1 451升 对开门冰箱 智能除霜 银', '69', '海尔(Haier) BCD-451WDIYU1 451升 对开门冰箱 智能除霜 银', '69', 'img/56.jpg');
INSERT INTO `product` VALUES ('57', null, '海信冰箱BCD-536WTVBP琥珀金', '78', '海信冰箱BCD-536WTVBP琥珀金', '544', 'img/57.jpg');
INSERT INTO `product` VALUES ('58', null, '美的(Midea) BCD-536WKPZM 536升电脑风冷变频 对开门冰箱 智能WiFi控制 炫彩钢', '120', '美的(Midea) BCD-536WKPZM 536升电脑风冷变频 对开门冰箱 智能WiFi控制 炫彩钢', '3334', 'img/58.jpg');
INSERT INTO `product` VALUES ('59', null, '西门子(siemens) KG33NA2LEC 321升风冷无霜 双门冰箱(银色) 独特C型风冷技术 电脑控温', '224', '西门子(siemens) KG33NA2LEC 321升风冷无霜 双门冰箱(银色) 独特C型风冷技术 电脑控温', '343', 'img/59.jpg');
INSERT INTO `product` VALUES ('60', null, '创维冰箱BCD-450WGY 450升，风冷无霜对开冰箱', '125', '创维冰箱BCD-450WGY 450升，风冷无霜对开冰箱', '3343', 'img/60.jpg');
INSERT INTO `product` VALUES ('61', null, '美菱(MeiLing)BCD-568WPBD 568升 风冷无霜，变频压缩机，冷藏单独关闭(金色）对开门冰箱', '109', '美菱(MeiLing)BCD-568WPBD 568升 风冷无霜，变频压缩机，冷藏单独关闭(金色）对开门冰箱', '454', 'img/61.jpg');
INSERT INTO `product` VALUES ('62', null, '华日冰箱BCD-580WHDB', '10', '华日冰箱BCD-580WHDB', '232', 'img/62.jpg');
INSERT INTO `product` VALUES ('63', null, '博世(Bosch) KMF46A66TI 452升变频混冷无霜 十字对开门多门冰箱(玫瑰金) 零度维他保鲜 独立三循环', '79', '博世(Bosch) KMF46A66TI 452升变频混冷无霜 十字对开门多门冰箱(玫瑰金) 零度维他保鲜 独立三循环', '343', 'img/63.jpg');
INSERT INTO `product` VALUES ('64', null, '博世(Bosch) KMF46A66TI 452升变频混冷无霜 十字对开门多门冰箱(玫瑰金) 零度维他保鲜 独立三循环', '188', '博世(Bosch) KMF46A66TI 452升变频混冷无霜 十字对开门多门冰箱(玫瑰金) 零度维他保鲜 独立三循环', '453', 'img/64.jpg');
INSERT INTO `product` VALUES ('65', null, '海尔（Haier）BCD-625WDGEU1 625L 对开门冰箱 干湿分储 玫瑰金色', '89', '海尔（Haier）BCD-625WDGEU1 625L 对开门冰箱 干湿分储 玫瑰金色', '856', 'img/65.jpg');
INSERT INTO `product` VALUES ('66', null, '美的(Midea) BCD-532WGPZV 532升 多门 冰箱 温湿精控 精准变频 纤薄箱体 格调金', '118', '美的(Midea) BCD-532WGPZV 532升 多门 冰箱 温湿精控 精准变频 纤薄箱体 格调金', '544', 'img/66.jpg');
INSERT INTO `product` VALUES ('67', null, '美菱冰箱BCD-658WUP9B', '164', '美菱冰箱BCD-658WUP9B', '343', 'img/67.jpg');
INSERT INTO `product` VALUES ('68', null, '三星冰箱RF50K5920S8/SC 524升 变频风冷无霜 品式十字对开门冰箱（梦幻银）', '79', '三星冰箱RF50K5920S8/SC 524升 变频风冷无霜 品式十字对开门冰箱（梦幻银）', '565', 'img/68.jpg');
INSERT INTO `product` VALUES ('69', null, '美菱冰箱BCD-658WUP9B', '45', '美菱冰箱BCD-658WUP9B', '343', 'img/69.jpg');
INSERT INTO `product` VALUES ('70', null, '海尔洗衣机XQG80-B1226AG香槟金', '127', 'ILISYA柔色初学者小清新彩妆套装裸妆淡妆自然妆容轻松打造', '565', 'img/70.jpg');
INSERT INTO `product` VALUES ('71', null, '海尔(Haier) EG8012HB86W 8公斤变频滚筒洗衣机', '148', '海尔(Haier) EG8012HB86W 8公斤变频滚筒洗衣机', '343', 'img/71.jpg');
INSERT INTO `product` VALUES ('72', null, '西门子(siemens) WM12L2680W 7.5公斤 变频滚筒洗衣机(银色) 强力洗 变速节能', '78', '西门子(siemens) WM12L2680W 7.5公斤 变频滚筒洗衣机(银色) 强力洗 变速节能', '454', 'img/72.jpg');
INSERT INTO `product` VALUES ('73', null, '博世(Bosch) WAN201680W 8公斤 变频滚筒洗衣机(银色) 静音降噪 环保节能', '68', '博世(Bosch) WAN201680W 8公斤 变频滚筒洗衣机(银色) 静音降噪 环保节能', '343', 'img/73.jpg');
INSERT INTO `product` VALUES ('74', null, '西门子(siemens) WM12L2R08W 8公斤 变频滚筒洗衣机(白色) 全触控无旋钮操作 多样化个性洗', '60', '西门子(siemens) WM12L2R08W 8公斤 变频滚筒洗衣机(白色) 全触控无旋钮操作 多样化个性洗', '656', 'img/74.jpg');
INSERT INTO `product` VALUES ('75', null, '海尔(Haier) XQS100-BZ866 10公斤 波轮洗衣机 天沐双动力 钛灰银', '128', '海尔(Haier) XQS100-BZ866 10公斤 波轮洗衣机 天沐双动力 钛灰银', '878', 'img/75.jpg');
INSERT INTO `product` VALUES ('76', null, '小天鹅(LittleSwan) TB90-6288WDCLG 9公斤 变频波轮全自动洗衣机(金色) 智能水魔方 智能WIFI系统', '78', '小天鹅(LittleSwan) TB90-6288WDCLG 9公斤 变频波轮全自动洗衣机(金色) 智能水魔方 智能WIFI系统', '980', 'img/76.jpg');
INSERT INTO `product` VALUES ('77', null, '海尔（Haier）XQS75-BZ15288U1 7.5公斤变频双动力波轮（钛灰银）洗衣机', '69', '海尔（Haier）XQS75-BZ15288U1 7.5公斤变频双动力波轮（钛灰银）洗衣机', '454', 'img/77.jpg');
INSERT INTO `product` VALUES ('78', null, '美的(Midea) MG90-1405DQCG 9公斤 滚筒洗衣机 （金色） 恒温洗涤', '69', '美的(Midea) MG90-1405DQCG 9公斤 滚筒洗衣机 （金色） 恒温洗涤', '565', 'img/78.jpg');
INSERT INTO `product` VALUES ('79', null, '海信(Hisense) XQG100-UH1205FT 10公斤 滚筒 洗衣机 蒸汽烘干洗烘一体 钛晶灰', '168', '海信(Hisense) XQG100-UH1205FT 10公斤 滚筒 洗衣机 蒸汽烘干洗烘一体 钛晶灰', '500', 'img/79.jpg');
INSERT INTO `product` VALUES ('80', null, '三洋洗衣机DB80377BDE', '89', '三洋洗衣机DB80377BDE', '456', 'img/80.jpg');
INSERT INTO `product` VALUES ('81', null, '飞利浦空气净化器家用去除雾霾除菌除尘AC4076', '138', '加绒加厚卫衣三件套童装男童秋冬装套装2017新款中大儿童春秋', '343', 'img/81.jpg');
INSERT INTO `product` VALUES ('82', null, '飞利浦(Philips) AC3254 除甲醛 除PM2.5 净化器 触摸感应 灰', '108', '飞利浦(Philips) AC3254 除甲醛 除PM2.5 净化器 触摸感应 灰', '346', 'img/82.jpg');
INSERT INTO `product` VALUES ('83', null, '三星空气净化器KJ350G-K3000WU主卧室高效性价比优选，新国标认证颗粒物CCMP4等级甲醛CCMF3等级适用42平方米', '88', '儿童棉衣男童棉服儿童棉袄17年冬季加厚中小童婴幼儿宝宝加厚装', '323', 'img/83.jpg');
INSERT INTO `product` VALUES ('84', null, 'Fujitsu/富士通将军家用空气净化器除甲醛杀菌无耗材静音卧室用ACSQ180D-N 出厂时臭氧开关默认开启，可自行调节或关闭', '128', '童装男童冬装棉衣外套2017新棉袄中大童短款棉服加绒加厚儿童', '644', 'img/84.jpg');
INSERT INTO `product` VALUES ('85', null, '三星空气净化器 除雾霾增强型 KJ399F-K5580WW 新国标颗粒物CCM超10万mg PM2.5/10数值显示，适用47平方米', '60', '三星空气净化器 除雾霾增强型 KJ399F-K5580WW 新国标颗粒物CCM超10万mg PM2.5/10数值显示，适用47平方米', '457', 'img/85.jpg');
INSERT INTO `product` VALUES ('86', null, 'airpal空气净化器家用除甲醛二手烟杀菌便携式滤网新品雾霾AP380B\r\n醛霾双效 远超新国标', '33', 'airpal空气净化器家用除甲醛二手烟杀菌便携式滤网新品雾霾AP380B\r\n醛霾双效 远超新国标', '799', 'img/86.jpg');
INSERT INTO `product` VALUES ('87', null, '飞利浦(PHILIPS)空气净化器6000系列AC6608家用除雾霾除甲醛除过敏原\r\n', '99', '男童鞋子2017秋冬新款儿童运动鞋中大童休闲鞋保暖户外登山鞋', '676', 'img/87.jpg');
INSERT INTO `product` VALUES ('88', null, '富士通将军家用空气净化器除甲醛杀菌无耗材办公室用ACSQ360D-W空气净化器 出厂时臭氧开关默认开启，可自行调节或关闭\r\n', '158', '富士通将军家用空气净化器除甲醛杀菌无耗材办公室用ACSQ360D-W空气净化器 出厂时臭氧开关默认开启，可自行调节或关闭\r\n富士通将军家用空气净化器除甲醛杀菌无耗材办公室用ACSQ360D-W空气净化器 出厂时臭氧开关默认开启，可自行调节或关闭\r\n', '456', 'img/88.jpg');
INSERT INTO `product` VALUES ('89', null, '夏普 FU-GFM50-B 30平米 物理捕蚊 净化器 除雾霾PM2.5 黑', '40', '夏普 FU-GFM50-B 30平米 物理捕蚊 净化器 除雾霾PM2.5 黑', '459', 'img/89.jpg');
INSERT INTO `product` VALUES ('90', null, 'OOPO R9s降至2599', '89', 'OOPO R9s降至2599', '567', 'img/90.jpg');
INSERT INTO `product` VALUES ('91', null, '荣耀9新品预约', '180', '荣耀9新品预约', '567', 'img/91.jpg');
INSERT INTO `product` VALUES ('92', null, '魅蓝E2 32G仅1299', '1299', '魅蓝E2 32G仅1299', '65', 'img/92.jpg');
INSERT INTO `product` VALUES ('93', null, '小米Note2尊享版 立减200', '220', 'airpal爱宝乐空气净化器家用新房除甲醛雾霾卧室办公室优惠AP300', '4545', 'img/93.jpg');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `uid` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) DEFAULT NULL,
  `pwd` varchar(50) DEFAULT NULL,
  `question` varchar(50) DEFAULT NULL,
  `answer` varchar(50) DEFAULT NULL,
  `role` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('2', '1', '1', null, '1', '1');
INSERT INTO `user` VALUES ('3', '3', '3', '3', '3', '3');
INSERT INTO `user` VALUES ('10', '张三', '1234', '我是谁', '1', '顾客');
