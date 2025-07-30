/*
 Navicat Premium Dump SQL

 Source Server         : localhost_Mysql
 Source Server Type    : MySQL
 Source Server Version : 80034 (8.0.34)
 Source Host           : localhost:3306
 Source Schema         : hometown

 Target Server Type    : MySQL
 Target Server Version : 80034 (8.0.34)
 File Encoding         : 65001

 Date: 25/05/2025 16:28:59
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员用户名',
  `password` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '管理员密码',
  `role` enum('super_admin','content_admin','user_admin') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'content_admin' COMMENT '角色',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '管理员表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of admin
-- ----------------------------
INSERT INTO `admin` VALUES (1, 'admin', '123456', 'super_admin', '2025-05-18 09:14:21', '2025-05-18 09:14:54');

-- ----------------------------
-- Table structure for cuisine
-- ----------------------------
DROP TABLE IF EXISTS `cuisine`;
CREATE TABLE `cuisine`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '美食名称',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '美食描述',
  `ingredients` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '主要食材',
  `cooking_method` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '烹饪方法',
  `origin_location` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '发源地',
  `recommended_restaurant` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '推荐餐厅',
  `main_image_id` bigint UNSIGNED NULL DEFAULT NULL COMMENT '主图ID',
  `create_by` bigint UNSIGNED NOT NULL COMMENT '创建人ID',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `create_by`(`create_by` ASC) USING BTREE,
  INDEX `main_image_id`(`main_image_id` ASC) USING BTREE,
  CONSTRAINT `cuisine_ibfk_1` FOREIGN KEY (`create_by`) REFERENCES `admin` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `cuisine_ibfk_2` FOREIGN KEY (`main_image_id`) REFERENCES `resource` (`id`) ON DELETE SET NULL ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 11 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '美食表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cuisine
-- ----------------------------
INSERT INTO `cuisine` VALUES (1, '南江黄羊头汤', '肉嫩，杂软，盐鲜适口，回味久长', '羊头、带皮黄羊肉，羊杂（肝、肚、肠、心、舌、肺）羊骨高汤', NULL, '四川省南江县', '四川省南江县', 6, 1, '2025-05-19 10:25:36', '2025-05-19 10:25:36');
INSERT INTO `cuisine` VALUES (2, '小炒黑猪肉', '麻辣鲜香，增加食欲，帮且消化', '黑猪肉，青尖椒', NULL, '四川省南江县', '四川省南江县', 7, 1, '2025-05-19 10:25:36', '2025-05-19 10:25:36');
INSERT INTO `cuisine` VALUES (3, '乡村砣子肉', '肉肥而不腻、入口即烂、香气四溢、回味无穷', '猪五花肉', NULL, '四川省南江县', '四川省南江县', 8, 1, '2025-05-19 10:25:36', '2025-05-20 00:00:00');
INSERT INTO `cuisine` VALUES (4, '南江铁罐锅巴饭', '铁罐锅巴饭饭香柔嫩，非常入味，吃后让人流连忘返。清香扑鼻，勾人食欲', '大米，土豆，腊肉', NULL, '四川省南江县', '四川省南江县', 9, 1, '2025-05-19 10:25:36', '2025-05-20 00:00:00');
INSERT INTO `cuisine` VALUES (5, '正直长酥肉', '麻而不辣，嫩脆可口，香而不腻', '猪肉，芡粉，鸡蛋', NULL, '四川省南江县正直', '四川省南江县正直', 10, 1, '2025-05-19 10:25:36', '2025-05-19 10:25:36');
INSERT INTO `cuisine` VALUES (6, '凉拌生态黑鸡', '鸡肉蛋白质含量较高，且易被人体吸收入利用，有增强体力，强壮身体的作用', '黑鸡肉', NULL, '四川省南江县', '四川省南江县', 11, 1, '2025-05-19 10:25:36', '2025-05-19 10:25:36');
INSERT INTO `cuisine` VALUES (7, '天麻槐树黑鸡蛋', '黑鸡蛋清富含蛋白质和人体必需的8种氨基酸和少量醋酸，可以增强皮肤的润滑作用', '黑鸡蛋，盐，温水，油，葱花', NULL, '四川省南江县', '四川省南江县', 12, 1, '2025-05-19 10:25:36', '2025-05-19 10:25:36');
INSERT INTO `cuisine` VALUES (8, '南江过水鱼', '色泽金黄,鱼皮酥香,肉质细嫩', '花鲢，凉面', NULL, '四川省南江县', '四川省南江县', 13, 1, '2025-05-19 10:25:36', '2025-05-19 10:25:36');

-- ----------------------------
-- Table structure for cuisine_collection
-- ----------------------------
DROP TABLE IF EXISTS `cuisine_collection`;
CREATE TABLE `cuisine_collection`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `cuisine_id` bigint UNSIGNED NOT NULL COMMENT '美食id',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '美食名称',
  `user_id` bigint UNSIGNED NOT NULL COMMENT '用户id',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id` ASC) USING BTREE,
  INDEX `cuisine_id`(`cuisine_id` ASC) USING BTREE,
  CONSTRAINT `cuisine_collection_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `cuisine_collection_ibfk_2` FOREIGN KEY (`cuisine_id`) REFERENCES `cuisine` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '美食收藏表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cuisine_collection
-- ----------------------------
INSERT INTO `cuisine_collection` VALUES (1, 3, '乡村砣子肉', 3, '2025-05-25 00:00:00', '2025-05-25 00:00:00');

-- ----------------------------
-- Table structure for cultural_feature
-- ----------------------------
DROP TABLE IF EXISTS `cultural_feature`;
CREATE TABLE `cultural_feature`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文化特色名称',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文化特色描述',
  `history` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL COMMENT '历史渊源',
  `related_holiday` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '相关节日',
  `main_image_id` bigint UNSIGNED NULL DEFAULT NULL COMMENT '图片id',
  `create_by` bigint UNSIGNED NOT NULL COMMENT '创建人ID',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `create_by`(`create_by` ASC) USING BTREE,
  INDEX `main_image_id`(`main_image_id` ASC) USING BTREE,
  CONSTRAINT `cultural_feature_ibfk_1` FOREIGN KEY (`create_by`) REFERENCES `admin` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `cultural_feature_ibfk_2` FOREIGN KEY (`main_image_id`) REFERENCES `resource` (`id`) ON DELETE SET NULL ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 21 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '文化特色表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of cultural_feature
-- ----------------------------
INSERT INTO `cultural_feature` VALUES (1, '巴山背二歌', '是巴中市辖区内的一种山歌，随着巴山人从事长途背运的生产劳动方式产生，历史可追溯到秦汉以前，是首批国家级非遗保护名录项目', '悠久历史,源远流长', NULL, 14, 1, '2025-05-19 10:41:30', '2025-05-20 21:07:57');
INSERT INTO `cultural_feature` VALUES (2, '玉湖赛龙舟', '玉湖赛龙舟的场地位于南江县醉美玉湖旅游景区，这里的玉堂水库是南江县境内现有最大的水库，湖面宽阔，水质清澈，周围群山环绕，绿树成荫，风景如画，为龙舟赛提供了绝佳的自然环境', '历史悠久，源远流长', NULL, 15, 1, '2025-05-19 10:41:30', '2025-05-20 10:13:09');
INSERT INTO `cultural_feature` VALUES (17, '关帝庙遗址', '距今已有 多年历史，历经多次重建、扩建和修复，现存建筑多为清康熙年间重新修建，是中国现存始建最早、规模最大、建制最高且保存最完整的关帝庙，见证了关公文化的传承与发展', '因庙内塑有“关羽”神像，因此得名', NULL, NULL, 1, '2025-05-21 00:00:00', '2025-05-21 00:00:00');
INSERT INTO `cultural_feature` VALUES (18, '南江吴氏宗祠', '整体呈四合院布局，东西横宽 24 米，南北纵长 60 米，占地面积 1440 平方米。建筑屋基均为青石条码砌，门厅面阔五间，进深两间，二楼为戏楼。左右厢房形制相同，院内有石板天井，天井登五级踏道入正厅，布局规整，层次分明。', '建于清嘉庆九年（1804 年），由门厅、左右厢房、正厅组成四合院布局', NULL, NULL, 1, '2025-05-21 00:00:00', '2025-05-21 00:00:00');
INSERT INTO `cultural_feature` VALUES (19, '白坪马氏祠堂', '占地 10 余亩，呈四合院格局，前半部分是全部为木质结构的祠堂，包括戏楼、厢房等，中间是条石铺设的天井；后半部分为祖坟，由牌坊、墓室组成。', '马家先祖魏氏带着 5 个儿子来到四川南江县马家沟定居，魏氏死后埋葬于白坪乡。', NULL, NULL, 1, '2025-05-21 00:00:00', '2025-05-21 00:00:00');
INSERT INTO `cultural_feature` VALUES (20, '石王庙', '它体现了当地百姓对神灵的信仰和对美好生活的期盼，反映了民间的祈福文化。庙旁独特的奇石景观，为其增添了自然神秘的色彩，与宗教信仰相结合，形成了具有地方特色的文化景观。虽然庙宇已毁，但它在当地百姓心中仍有一定的文化影响力，承载着人们对过去生活和信仰的记忆。', '位于双田村 1 社大石垭，始建于清朝末年', NULL, NULL, 1, '2025-05-21 00:00:00', '2025-05-21 00:00:00');

-- ----------------------------
-- Table structure for culture_collection
-- ----------------------------
DROP TABLE IF EXISTS `culture_collection`;
CREATE TABLE `culture_collection`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `culture_id` bigint UNSIGNED NOT NULL COMMENT '文化特色id',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文化名称',
  `user_id` bigint UNSIGNED NOT NULL COMMENT '用户id',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id` ASC) USING BTREE,
  INDEX `culture_id`(`culture_id` ASC) USING BTREE,
  CONSTRAINT `culture_collection_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `culture_collection_ibfk_2` FOREIGN KEY (`culture_id`) REFERENCES `cultural_feature` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '文化收藏表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of culture_collection
-- ----------------------------
INSERT INTO `culture_collection` VALUES (1, 1, '巴山背二歌', 3, '2025-05-25 00:00:00', '2025-05-25 00:00:00');
INSERT INTO `culture_collection` VALUES (2, 17, '关帝庙遗址', 3, '2025-05-25 00:00:00', '2025-05-25 00:00:00');
INSERT INTO `culture_collection` VALUES (3, 19, '白坪马氏祠堂', 3, '2025-05-25 00:00:00', '2025-05-25 00:00:00');
INSERT INTO `culture_collection` VALUES (4, 2, '玉湖赛龙舟', 3, '2025-05-25 00:00:00', '2025-05-25 00:00:00');

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `file_name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文件名',
  `file_path` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文件路径',
  `file_type` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文件类型',
  `upload_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '上传时间',
  `upload_by` bigint UNSIGNED NOT NULL COMMENT '上传人ID',
  `resource_type` enum('image','video','audio','document') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'image' COMMENT '资源类型',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `upload_by`(`upload_by` ASC) USING BTREE,
  CONSTRAINT `resource_ibfk_1` FOREIGN KEY (`upload_by`) REFERENCES `admin` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 16 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '资源表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of resource
-- ----------------------------
INSERT INTO `resource` VALUES (1, '光雾山', 'static/images/scenic/光雾山.jpg', '图片', '2025-05-19 09:35:08', 1, 'image');
INSERT INTO `resource` VALUES (2, '米仓山', 'static/images/scenic/米仓山.jpg', '图片', '2025-05-19 09:35:08', 1, 'image');
INSERT INTO `resource` VALUES (3, '光雾山小巫峡', 'static/images/scenic/光雾山小巫峡.jpg', '图片', '2025-05-19 09:35:08', 1, 'image');
INSERT INTO `resource` VALUES (4, '十八月潭', 'static/images/scenic/十八月潭.jpg', '图片', '2025-05-19 09:35:08', 1, 'image');
INSERT INTO `resource` VALUES (5, '米仓古道', 'static/images/scenic/米仓古道.jpg', '图片', '2025-05-19 09:35:08', 1, 'image');
INSERT INTO `resource` VALUES (6, '南江黄羊头汤', 'static/images/food/南江黄羊头汤.jpg', '图片', '2025-05-19 10:07:28', 1, 'image');
INSERT INTO `resource` VALUES (7, '小炒黑猪肉', 'static/images/food/小炒黑猪肉.jpg', '图片', '2025-05-19 10:07:28', 1, 'image');
INSERT INTO `resource` VALUES (8, '乡村砣子肉', 'static/images/food/乡村砣子肉.jpg', '图片', '2025-05-19 10:07:28', 1, 'image');
INSERT INTO `resource` VALUES (9, '南江铁罐锅巴饭', 'static/images/food/南江铁罐锅巴饭.jpg', '图片', '2025-05-19 10:07:28', 1, 'image');
INSERT INTO `resource` VALUES (10, '正直长酥肉', 'static/images/food/正直长酥肉.jpg', '图片', '2025-05-19 10:07:28', 1, 'image');
INSERT INTO `resource` VALUES (11, '凉拌生态黑鸡', 'static/images/food/凉拌生态黑鸡.jpg', '图片', '2025-05-19 10:07:28', 1, 'image');
INSERT INTO `resource` VALUES (12, '天麻槐树黑鸡蛋', 'static/images/food/天麻槐树黑鸡蛋.jpg', '图片', '2025-05-19 10:07:28', 1, 'image');
INSERT INTO `resource` VALUES (13, '南江过水鱼', 'static/images/food/南江过水鱼.jpg', '图片', '2025-05-19 10:07:28', 1, 'image');
INSERT INTO `resource` VALUES (14, '巴山背二歌', 'static/images/culture/巴山背二歌.jpg', '图片', '2025-05-19 10:36:16', 1, 'image');
INSERT INTO `resource` VALUES (15, '玉湖赛龙舟', 'static/images/culture/玉湖龙舟赛.jpg', '图片', '2025-05-19 10:36:16', 1, 'image');

-- ----------------------------
-- Table structure for scenic_collection
-- ----------------------------
DROP TABLE IF EXISTS `scenic_collection`;
CREATE TABLE `scenic_collection`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT COMMENT 'id',
  `scenic_id` bigint UNSIGNED NOT NULL COMMENT '景点id',
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '景点名称',
  `user_id` bigint UNSIGNED NOT NULL COMMENT '用户id',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `user_id`(`user_id` ASC) USING BTREE,
  INDEX `scenic_id`(`scenic_id` ASC) USING BTREE,
  CONSTRAINT `scenic_collection_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `scenic_collection_ibfk_2` FOREIGN KEY (`scenic_id`) REFERENCES `scenic_spot` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 2 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '景点收藏表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of scenic_collection
-- ----------------------------
INSERT INTO `scenic_collection` VALUES (1, 2, '米仓山', 3, '2025-05-25 00:00:00', '2025-05-25 00:00:00');

-- ----------------------------
-- Table structure for scenic_cultural_relation
-- ----------------------------
DROP TABLE IF EXISTS `scenic_cultural_relation`;
CREATE TABLE `scenic_cultural_relation`  (
  `scenic_id` bigint UNSIGNED NOT NULL COMMENT '景点ID',
  `cultural_id` bigint UNSIGNED NOT NULL COMMENT '文化特色ID',
  PRIMARY KEY (`scenic_id`, `cultural_id`) USING BTREE,
  INDEX `cultural_id`(`cultural_id` ASC) USING BTREE,
  CONSTRAINT `scenic_cultural_relation_ibfk_1` FOREIGN KEY (`scenic_id`) REFERENCES `scenic_spot` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT,
  CONSTRAINT `scenic_cultural_relation_ibfk_2` FOREIGN KEY (`cultural_id`) REFERENCES `cultural_feature` (`id`) ON DELETE CASCADE ON UPDATE RESTRICT
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '景点与文化特色关联表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of scenic_cultural_relation
-- ----------------------------

-- ----------------------------
-- Table structure for scenic_spot
-- ----------------------------
DROP TABLE IF EXISTS `scenic_spot`;
CREATE TABLE `scenic_spot`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '景点名称',
  `description` text CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '景点描述',
  `location` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '地理位置',
  `opening_hours` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '开放时间',
  `ticket_price` decimal(10, 2) NULL DEFAULT 0.00 COMMENT '门票价格',
  `rating` decimal(3, 1) NULL DEFAULT 0.0 COMMENT '评分',
  `view_count` int UNSIGNED NULL DEFAULT 0 COMMENT '浏览量',
  `main_image_id` bigint UNSIGNED NULL DEFAULT NULL COMMENT '图片id',
  `create_by` bigint UNSIGNED NOT NULL COMMENT '创建人ID',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  INDEX `create_by`(`create_by` ASC) USING BTREE,
  INDEX `main_image_id`(`main_image_id` ASC) USING BTREE,
  CONSTRAINT `scenic_spot_ibfk_1` FOREIGN KEY (`create_by`) REFERENCES `admin` (`id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `scenic_spot_ibfk_2` FOREIGN KEY (`main_image_id`) REFERENCES `resource` (`id`) ON DELETE SET NULL ON UPDATE RESTRICT
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '景点表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of scenic_spot
-- ----------------------------
INSERT INTO `scenic_spot` VALUES (1, '光雾山', '溜娃宝藏地', '四川省巴中市南江县光雾山镇G244', '04/01-11/30 08:00-18:00开放;12/01-03/31 08:00-17:00开放', 75.00, 4.8, 3000, 1, 1, '2025-05-19 09:54:21', '2025-05-19 09:54:21');
INSERT INTO `scenic_spot` VALUES (2, '米仓山', '古朴原始的风韵犹存', '四川省巴中市南江县铁炉坝村', '全年 08:30-18:00开放;全年 08:30-17:00开放', 85.00, 4.4, 2500, 2, 1, '2025-05-19 09:54:21', '2025-05-20 20:57:56');
INSERT INTO `scenic_spot` VALUES (3, '光雾山小巫峡', '造型独特，自然风光', '四川省巴中市南江县赶场镇', '全年 08:00-18:00开放', 110.00, 4.2, 1000, 3, 1, '2025-05-19 09:54:21', '2025-05-20 00:00:00');
INSERT INTO `scenic_spot` VALUES (4, '十八月潭', '自然风光，美不胜收', '四川省巴中市南江县光雾山十八月潭景区', '全年 08:30-17:30开放', 49.01, 4.7, 2000, 4, 1, '2025-05-19 09:54:21', '2025-05-20 00:00:00');
INSERT INTO `scenic_spot` VALUES (5, '米仓古道', '历史建筑，感受历史气息', '四川省巴中市南江县光雾山景区背沟口景点旁', '全年 全天开放', 0.00, 3.7, 1000, 5, 1, '2025-05-19 09:54:21', '2025-05-20 00:00:00');
INSERT INTO `scenic_spot` VALUES (7, '光雾山大坝滑雪场', '体验户外滑雪', ' 四川省巴中市南江县光雾山大坝景区', NULL, 0.00, 3.0, NULL, NULL, 1, '2025-05-21 00:00:00', '2025-05-21 00:00:00');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` bigint UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户名',
  `phone` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '手机号',
  `password` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '用户密码',
  `avatar_url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NULL DEFAULT NULL COMMENT '头像URL',
  `user_status` tinyint UNSIGNED NULL DEFAULT 1 COMMENT '用户状态：1-正常，2-封禁，3-注销',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `username`(`username` ASC) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_0900_ai_ci COMMENT = '用户表' ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES (1, 'toms', '17828935462', '123456', NULL, 2, '2025-05-18 00:00:00', '2025-05-20 00:00:00');
INSERT INTO `user` VALUES (3, 'wine', '12828935467', '123456', NULL, 1, '2025-05-18 17:33:21', '2025-05-18 17:33:21');
INSERT INTO `user` VALUES (4, 'dans', '17828935460', '123wer', NULL, 1, '2025-05-18 17:38:11', '2025-05-18 17:38:11');
INSERT INTO `user` VALUES (6, 'taobao', '12228935464', '1234567', NULL, 1, '2025-05-21 13:57:56', '2025-05-21 22:22:06');

SET FOREIGN_KEY_CHECKS = 1;
