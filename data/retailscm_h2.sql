-- BUILD WITH MODEL TIME 700101T0800


CREATE ALIAS DATE AS $$
import java.net.*;
import java.util.Date;
import java.text.SimpleDateFormat;
@CODE
Date date(Date date) throws Exception {
    SimpleDateFormat formatter = new SimpleDateFormat( "dd/MM/yyyy");
    return formatter.parse(formatter.format(date));
    
}
$$;







drop table  if exists retail_store_country_center_data;
create table retail_store_country_center_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(44)                              comment '名称',
	service_number                	varchar(36)                              comment '服务号码',
	founded                       	date                                     comment '成立',
	web_site                      	varchar(128)                             comment '网站',
	address                       	varchar(56)                              comment '地址',
	operated_by                   	varchar(16)                              comment '由',
	legal_representative          	varchar(12)                              comment '法定代表人',
	description                   	varchar(52)                              comment '描述',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists catalog_data;
create table catalog_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(201)                             comment '名称',
	owner                         	varchar(48)                              comment '业主',
	sub_count                     	int                                      comment '子数',
	amount                        	numeric(6,2)                             comment '金额',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists level_one_category_data;
create table level_one_category_data (
	id                            	varchar(48)          not null            comment 'ID',
	catalog                       	varchar(48)                              comment '目录',
	name                          	varchar(16)                              comment '名称',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists level_two_category_data;
create table level_two_category_data (
	id                            	varchar(48)          not null            comment 'ID',
	parent_category               	varchar(48)                              comment '父类',
	name                          	varchar(16)                              comment '名称',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists level_three_category_data;
create table level_three_category_data (
	id                            	varchar(48)          not null            comment 'ID',
	parent_category               	varchar(48)                              comment '父类',
	name                          	varchar(16)                              comment '名称',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists product_data;
create table product_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(12)                              comment '名称',
	parent_category               	varchar(48)                              comment '父类',
	origin                        	varchar(8)                               comment '产地',
	remark                        	varchar(88)                              comment '备注',
	brand                         	varchar(92)                              comment '品牌',
	picture                       	varchar(512)                             comment '图片',
	last_update_time              	datetime                                 comment '更新于',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists sku_data;
create table sku_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(24)                              comment '名称',
	size                          	varchar(4)                               comment '大小',
	product                       	varchar(48)                              comment '产品',
	barcode                       	varchar(52)                              comment '条码',
	package_type                  	varchar(16)                              comment '包装类型',
	net_content                   	varchar(92)                              comment '净含量',
	price                         	numeric(8,2)                             comment '价格',
	picture                       	varchar(512)                             comment '图片',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists retail_store_province_center_data;
create table retail_store_province_center_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(44)                              comment '名称',
	founded                       	date                                     comment '成立',
	country                       	varchar(48)                              comment '国',
	last_update_time              	datetime                                 comment '更新于',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists province_center_department_data;
create table province_center_department_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(20)                              comment '名称',
	founded                       	date                                     comment '成立',
	province_center               	varchar(48)                              comment '省中心',
	manager                       	varchar(12)                              comment '经理',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists province_center_employee_data;
create table province_center_employee_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(12)                              comment '名称',
	mobile                        	varchar(44)                              comment '手机',
	email                         	varchar(256)                             comment '电子邮件',
	founded                       	date                                     comment '成立',
	department                    	varchar(48)                              comment '部门',
	province_center               	varchar(48)                              comment '省中心',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists retail_store_city_service_center_data;
create table retail_store_city_service_center_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(36)                              comment '名称',
	founded                       	date                                     comment '成立',
	belongs_to                    	varchar(48)                              comment '属于',
	last_update_time              	datetime                                 comment '更新于',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists city_partner_data;
create table city_partner_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(12)                              comment '名称',
	mobile                        	varchar(44)                              comment '手机',
	city_service_center           	varchar(48)                              comment '城市服务中心',
	description                   	varchar(64)                              comment '描述',
	last_update_time              	datetime                                 comment '更新于',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists potential_customer_data;
create table potential_customer_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(12)                              comment '名称',
	mobile                        	varchar(44)                              comment '手机',
	city_service_center           	varchar(48)                              comment '城市服务中心',
	city_partner                  	varchar(48)                              comment '城市合伙人',
	description                   	varchar(64)                              comment '描述',
	last_update_time              	datetime                                 comment '更新于',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists potential_customer_contact_person_data;
create table potential_customer_contact_person_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(12)                              comment '名称',
	mobile                        	varchar(44)                              comment '手机',
	potential_customer            	varchar(48)                              comment '潜在的客户',
	description                   	varchar(96)                              comment '描述',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists potential_customer_contact_data;
create table potential_customer_contact_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(40)                              comment '名称',
	contact_date                  	date                                     comment '接触日期',
	contact_method                	varchar(16)                              comment '接触法',
	potential_customer            	varchar(48)                              comment '潜在的客户',
	city_partner                  	varchar(48)                              comment '城市合伙人',
	contact_to                    	varchar(48)                              comment '接触',
	description                   	varchar(24)                              comment '描述',
	last_update_time              	datetime                                 comment '更新于',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists city_event_data;
create table city_event_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(28)                              comment '名称',
	mobile                        	varchar(44)                              comment '手机',
	city_service_center           	varchar(48)                              comment '城市服务中心',
	description                   	varchar(48)                              comment '描述',
	last_update_time              	datetime                                 comment '更新于',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists event_attendance_data;
create table event_attendance_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(36)                              comment '名称',
	potential_customer            	varchar(48)                              comment '潜在的客户',
	city_event                    	varchar(48)                              comment '城市活动',
	description                   	varchar(36)                              comment '描述',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists retail_store_data;
create table retail_store_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(24)                              comment '名称',
	telephone                     	varchar(48)                              comment '电话',
	owner                         	varchar(8)                               comment '业主',
	retail_store_country_center   	varchar(48)                              comment '双链小超全国运营中心',
	city_service_center           	varchar(48)                              comment '城市服务中心',
	creation                      	varchar(48)                              comment '创建',
	investment_invitation         	varchar(48)                              comment '招商',
	franchising                   	varchar(48)                              comment '加盟',
	decoration                    	varchar(48)                              comment '装修',
	opening                       	varchar(48)                              comment '开业',
	closing                       	varchar(48)                              comment '关闭',
	founded                       	date                                     comment '成立',
	latitude                      	numeric(9,6)                             comment '纬度',
	longitude                     	numeric(10,6)                            comment '经度',
	description                   	varchar(84)                              comment '描述',
	last_update_time              	datetime                                 comment '更新于',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists retail_store_creation_data;
create table retail_store_creation_data (
	id                            	varchar(48)          not null            comment 'ID',
	comment                       	varchar(20)                              comment '评论',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists retail_store_investment_invitation_data;
create table retail_store_investment_invitation_data (
	id                            	varchar(48)          not null            comment 'ID',
	comment                       	varchar(24)                              comment '评论',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists retail_store_franchising_data;
create table retail_store_franchising_data (
	id                            	varchar(48)          not null            comment 'ID',
	comment                       	varchar(16)                              comment '评论',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists retail_store_decoration_data;
create table retail_store_decoration_data (
	id                            	varchar(48)          not null            comment 'ID',
	comment                       	varchar(8)                               comment '评论',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists retail_store_opening_data;
create table retail_store_opening_data (
	id                            	varchar(48)          not null            comment 'ID',
	comment                       	varchar(8)                               comment '评论',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists retail_store_closing_data;
create table retail_store_closing_data (
	id                            	varchar(48)          not null            comment 'ID',
	comment                       	varchar(8)                               comment '评论',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists retail_store_member_data;
create table retail_store_member_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(12)                              comment '名称',
	mobile_phone                  	varchar(44)                              comment '移动电话',
	owner                         	varchar(48)                              comment '业主',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists consumer_order_data;
create table consumer_order_data (
	id                            	varchar(48)          not null            comment 'ID',
	title                         	varchar(16)                              comment '头衔',
	consumer                      	varchar(48)                              comment '消费者',
	store                         	varchar(48)                              comment '商场',
	last_update_time              	datetime                                 comment '更新于',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists consumer_order_line_item_data;
create table consumer_order_line_item_data (
	id                            	varchar(48)          not null            comment 'ID',
	biz_order                     	varchar(48)                              comment '订单',
	sku_id                        	varchar(12)                              comment '产品ID',
	sku_name                      	varchar(16)                              comment '产品名称',
	price                         	numeric(5,2)                             comment '价格',
	quantity                      	numeric(7,2)                             comment '数量',
	amount                        	numeric(8,2)                             comment '金额',
	last_update_time              	datetime                                 comment '更新于',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists consumer_order_shipping_group_data;
create table consumer_order_shipping_group_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(24)                              comment '名称',
	biz_order                     	varchar(48)                              comment '订单',
	amount                        	numeric(7,2)                             comment '金额',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists consumer_order_payment_group_data;
create table consumer_order_payment_group_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(16)                              comment '名称',
	biz_order                     	varchar(48)                              comment '订单',
	card_number                   	varchar(68)                              comment '卡号码',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists consumer_order_price_adjustment_data;
create table consumer_order_price_adjustment_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(16)                              comment '名称',
	biz_order                     	varchar(48)                              comment '订单',
	amount                        	numeric(7,2)                             comment '金额',
	provider                      	varchar(16)                              comment '供应商',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists retail_store_member_coupon_data;
create table retail_store_member_coupon_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(12)                              comment '名称',
	owner                         	varchar(48)                              comment '业主',
	number                        	varchar(28)                              comment '数',
	last_update_time              	datetime                                 comment '更新于',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists member_wishlist_data;
create table member_wishlist_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(24)                              comment '名称',
	owner                         	varchar(48)                              comment '业主',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists member_reward_point_data;
create table member_reward_point_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(24)                              comment '名称',
	point                         	int                                      comment '点',
	owner                         	varchar(48)                              comment '业主',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists member_reward_point_redemption_data;
create table member_reward_point_redemption_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(16)                              comment '名称',
	point                         	int                                      comment '点',
	owner                         	varchar(48)                              comment '业主',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists member_wishlist_product_data;
create table member_wishlist_product_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(20)                              comment '名称',
	owner                         	varchar(48)                              comment '业主',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists retail_store_member_address_data;
create table retail_store_member_address_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(24)                              comment '名称',
	owner                         	varchar(48)                              comment '业主',
	mobile_phone                  	varchar(44)                              comment '移动电话',
	address                       	varchar(56)                              comment '地址',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists retail_store_member_gift_card_data;
create table retail_store_member_gift_card_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(12)                              comment '名称',
	owner                         	varchar(48)                              comment '业主',
	number                        	varchar(28)                              comment '数',
	remain                        	numeric(7,2)                             comment '保持',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists retail_store_member_gift_card_consume_record_data;
create table retail_store_member_gift_card_consume_record_data (
	id                            	varchar(48)          not null            comment 'ID',
	occure_time                   	date                                     comment '发生时间',
	owner                         	varchar(48)                              comment '业主',
	biz_order                     	varchar(48)                              comment '订单',
	number                        	varchar(28)                              comment '数',
	amount                        	numeric(6,2)                             comment '金额',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists goods_supplier_data;
create table goods_supplier_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(12)                              comment '名称',
	supply_product                	varchar(16)                              comment '供应产品',
	belong_to                     	varchar(48)                              comment '属于',
	contact_number                	varchar(44)                              comment '联系电话',
	description                   	varchar(72)                              comment '描述',
	last_update_time              	datetime                                 comment '更新于',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists supplier_product_data;
create table supplier_product_data (
	id                            	varchar(48)          not null            comment 'ID',
	product_name                  	varchar(16)                              comment '品名',
	product_description           	varchar(52)                              comment '产品描述',
	product_unit                  	varchar(8)                               comment '产品单元',
	supplier                      	varchar(48)                              comment '供应商',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists product_supply_duration_data;
create table product_supply_duration_data (
	id                            	varchar(48)          not null            comment 'ID',
	quantity                      	int                                      comment '数量',
	duration                      	varchar(8)                               comment '持续时间',
	price                         	numeric(8,2)                             comment '价格',
	product                       	varchar(48)                              comment '产品',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists supply_order_data;
create table supply_order_data (
	id                            	varchar(48)          not null            comment 'ID',
	buyer                         	varchar(48)                              comment '买方',
	seller                        	varchar(48)                              comment '卖方',
	title                         	varchar(40)                              comment '头衔',
	total_amount                  	numeric(14,2)                            comment '总金额',
	last_update_time              	datetime                                 comment '更新于',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists supply_order_line_item_data;
create table supply_order_line_item_data (
	id                            	varchar(48)          not null            comment 'ID',
	biz_order                     	varchar(48)                              comment '订单',
	sku_id                        	varchar(12)                              comment '产品ID',
	sku_name                      	varchar(16)                              comment '产品名称',
	amount                        	numeric(5,2)                             comment '金额',
	quantity                      	int                                      comment '数量',
	unit_of_measurement           	varchar(8)                               comment '测量单位',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists supply_order_shipping_group_data;
create table supply_order_shipping_group_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(40)                              comment '名称',
	biz_order                     	varchar(48)                              comment '订单',
	amount                        	numeric(5,2)                             comment '金额',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists supply_order_payment_group_data;
create table supply_order_payment_group_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(16)                              comment '名称',
	biz_order                     	varchar(48)                              comment '订单',
	card_number                   	varchar(68)                              comment '卡号码',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists retail_store_order_data;
create table retail_store_order_data (
	id                            	varchar(48)          not null            comment 'ID',
	buyer                         	varchar(48)                              comment '买方',
	seller                        	varchar(48)                              comment '卖方',
	title                         	varchar(56)                              comment '头衔',
	total_amount                  	numeric(14,2)                            comment '总金额',
	last_update_time              	datetime                                 comment '更新于',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists retail_store_order_line_item_data;
create table retail_store_order_line_item_data (
	id                            	varchar(48)          not null            comment 'ID',
	biz_order                     	varchar(48)                              comment '订单',
	sku_id                        	varchar(12)                              comment '产品ID',
	sku_name                      	varchar(16)                              comment '产品名称',
	amount                        	numeric(5,2)                             comment '金额',
	quantity                      	int                                      comment '数量',
	unit_of_measurement           	varchar(8)                               comment '测量单位',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists retail_store_order_shipping_group_data;
create table retail_store_order_shipping_group_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(40)                              comment '名称',
	biz_order                     	varchar(48)                              comment '订单',
	amount                        	numeric(5,2)                             comment '金额',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists retail_store_order_payment_group_data;
create table retail_store_order_payment_group_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(16)                              comment '名称',
	biz_order                     	varchar(48)                              comment '订单',
	card_number                   	varchar(68)                              comment '卡号码',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists warehouse_data;
create table warehouse_data (
	id                            	varchar(48)          not null            comment 'ID',
	location                      	varchar(44)                              comment '位置',
	contact_number                	varchar(48)                              comment '联系电话',
	total_area                    	varchar(36)                              comment '总面积',
	owner                         	varchar(48)                              comment '业主',
	latitude                      	numeric(9,6)                             comment '纬度',
	longitude                     	numeric(10,6)                            comment '经度',
	last_update_time              	datetime                                 comment '更新于',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists storage_space_data;
create table storage_space_data (
	id                            	varchar(48)          not null            comment 'ID',
	location                      	varchar(56)                              comment '位置',
	contact_number                	varchar(48)                              comment '联系电话',
	total_area                    	varchar(28)                              comment '总面积',
	warehouse                     	varchar(48)                              comment '仓库',
	latitude                      	numeric(9,6)                             comment '纬度',
	longitude                     	numeric(10,6)                            comment '经度',
	last_update_time              	datetime                                 comment '更新于',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists smart_pallet_data;
create table smart_pallet_data (
	id                            	varchar(48)          not null            comment 'ID',
	location                      	varchar(104)                             comment '位置',
	contact_number                	varchar(48)                              comment '联系电话',
	total_area                    	varchar(28)                              comment '总面积',
	latitude                      	numeric(9,6)                             comment '纬度',
	longitude                     	numeric(10,6)                            comment '经度',
	warehouse                     	varchar(48)                              comment '仓库',
	last_update_time              	datetime                                 comment '更新于',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists goods_shelf_data;
create table goods_shelf_data (
	id                            	varchar(48)          not null            comment 'ID',
	location                      	varchar(64)                              comment '位置',
	storage_space                 	varchar(48)                              comment '存货区',
	supplier_space                	varchar(48)                              comment '供应商的空间',
	damage_space                  	varchar(48)                              comment '残次货物存放区',
	last_update_time              	datetime                                 comment '更新于',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists goods_shelf_stock_count_data;
create table goods_shelf_stock_count_data (
	id                            	varchar(48)          not null            comment 'ID',
	title                         	varchar(16)                              comment '头衔',
	count_time                    	date                                     comment '计数时间',
	summary                       	varchar(72)                              comment '概览',
	shelf                         	varchar(48)                              comment '架',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists stock_count_issue_track_data;
create table stock_count_issue_track_data (
	id                            	varchar(48)          not null            comment 'ID',
	title                         	varchar(16)                              comment '头衔',
	count_time                    	date                                     comment '计数时间',
	summary                       	varchar(40)                              comment '概览',
	stock_count                   	varchar(48)                              comment '盘点',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists goods_allocation_data;
create table goods_allocation_data (
	id                            	varchar(48)          not null            comment 'ID',
	location                      	varchar(84)                              comment '位置',
	latitude                      	numeric(9,6)                             comment '纬度',
	longitude                     	numeric(10,6)                            comment '经度',
	goods_shelf                   	varchar(48)                              comment '货架',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists goods_data;
create table goods_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(16)                              comment '名称',
	rfid                          	varchar(28)                              comment 'RFID',
	uom                           	varchar(4)                               comment '计量单位',
	max_package                   	int                                      comment '最大包装',
	expire_time                   	date                                     comment '到期时间',
	sku                           	varchar(48)                              comment 'SKU',
	receiving_space               	varchar(48)                              comment '收货区',
	goods_allocation              	varchar(48)                              comment '货位',
	smart_pallet                  	varchar(48)                              comment '智能托盘',
	shipping_space                	varchar(48)                              comment '发货区',
	transport_task                	varchar(48)                              comment '运输任务',
	retail_store                  	varchar(48)                              comment '双链小超',
	biz_order                     	varchar(48)                              comment '订单',
	retail_store_order            	varchar(48)                              comment '生超的订单',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists goods_movement_data;
create table goods_movement_data (
	id                            	varchar(48)          not null            comment 'ID',
	move_time                     	datetime                                 comment '移动时间',
	facility                      	varchar(16)                              comment '设施',
	facility_id                   	varchar(16)                              comment '设备ID',
	from_ip                       	varchar(48)                              comment '从IP',
	user_agent                    	varchar(444)                             comment '用户代理',
	session_id                    	varchar(124)                             comment '会话ID',
	latitude                      	numeric(9,6)                             comment '纬度',
	longitude                     	numeric(10,6)                            comment '经度',
	goods                         	varchar(48)                              comment '货物',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists supplier_space_data;
create table supplier_space_data (
	id                            	varchar(48)          not null            comment 'ID',
	location                      	varchar(76)                              comment '位置',
	contact_number                	varchar(48)                              comment '联系电话',
	total_area                    	varchar(28)                              comment '总面积',
	warehouse                     	varchar(48)                              comment '仓库',
	latitude                      	numeric(9,6)                             comment '纬度',
	longitude                     	numeric(10,6)                            comment '经度',
	last_update_time              	datetime                                 comment '更新于',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists receiving_space_data;
create table receiving_space_data (
	id                            	varchar(48)          not null            comment 'ID',
	location                      	varchar(64)                              comment '位置',
	contact_number                	varchar(48)                              comment '联系电话',
	description                   	varchar(52)                              comment '描述',
	total_area                    	varchar(28)                              comment '总面积',
	warehouse                     	varchar(48)                              comment '仓库',
	latitude                      	numeric(9,6)                             comment '纬度',
	longitude                     	numeric(10,6)                            comment '经度',
	last_update_time              	datetime                                 comment '更新于',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists shipping_space_data;
create table shipping_space_data (
	id                            	varchar(48)          not null            comment 'ID',
	location                      	varchar(56)                              comment '位置',
	contact_number                	varchar(48)                              comment '联系电话',
	total_area                    	varchar(28)                              comment '总面积',
	warehouse                     	varchar(48)                              comment '仓库',
	latitude                      	numeric(9,6)                             comment '纬度',
	longitude                     	numeric(10,6)                            comment '经度',
	description                   	varchar(52)                              comment '描述',
	last_update_time              	datetime                                 comment '更新于',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists damage_space_data;
create table damage_space_data (
	id                            	varchar(48)          not null            comment 'ID',
	location                      	varchar(80)                              comment '位置',
	contact_number                	varchar(48)                              comment '联系电话',
	total_area                    	varchar(28)                              comment '总面积',
	latitude                      	numeric(9,6)                             comment '纬度',
	longitude                     	numeric(10,6)                            comment '经度',
	warehouse                     	varchar(48)                              comment '仓库',
	last_update_time              	datetime                                 comment '更新于',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists warehouse_asset_data;
create table warehouse_asset_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(20)                              comment '名称',
	position                      	varchar(40)                              comment '位置',
	owner                         	varchar(48)                              comment '业主',
	last_update_time              	datetime                                 comment '更新于',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists transport_fleet_data;
create table transport_fleet_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(28)                              comment '名称',
	contact_number                	varchar(48)                              comment '联系电话',
	owner                         	varchar(48)                              comment '业主',
	last_update_time              	datetime                                 comment '更新于',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists transport_truck_data;
create table transport_truck_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(16)                              comment '名称',
	plate_number                  	varchar(16)                              comment '车牌号码',
	contact_number                	varchar(48)                              comment '联系电话',
	vehicle_license_number        	varchar(24)                              comment '汽车牌照号码',
	engine_number                 	varchar(28)                              comment '发动机号',
	make_date                     	date                                     comment '制造日期',
	mileage                       	varchar(24)                              comment '里程',
	body_color                    	varchar(8)                               comment '车身颜色',
	owner                         	varchar(48)                              comment '业主',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists truck_driver_data;
create table truck_driver_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(24)                              comment '名称',
	driver_license_number         	varchar(52)                              comment '驾驶执照号码',
	contact_number                	varchar(44)                              comment '联系电话',
	belongs_to                    	varchar(48)                              comment '属于',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists transport_task_data;
create table transport_task_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(16)                              comment '名称',
	start                         	varchar(20)                              comment '开始',
	begin_time                    	date                                     comment '开始时间',
	end                           	varchar(48)                              comment '结束',
	driver                        	varchar(48)                              comment '司机',
	truck                         	varchar(48)                              comment '卡车',
	belongs_to                    	varchar(48)                              comment '属于',
	latitude                      	numeric(9,6)                             comment '纬度',
	longitude                     	numeric(10,6)                            comment '经度',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists transport_task_track_data;
create table transport_task_track_data (
	id                            	varchar(48)          not null            comment 'ID',
	track_time                    	date                                     comment '跟踪时间',
	latitude                      	numeric(9,6)                             comment '纬度',
	longitude                     	numeric(10,6)                            comment '经度',
	movement                      	varchar(48)                              comment '运动',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists account_set_data;
create table account_set_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(24)                              comment '名称',
	year_set                      	varchar(20)                              comment '年组',
	effective_date                	date                                     comment '生效日期',
	accounting_system             	varchar(28)                              comment '会计制度',
	domestic_currency_code        	varchar(12)                              comment '本币代码',
	domestic_currency_name        	varchar(12)                              comment '本币名称',
	opening_bank                  	varchar(16)                              comment '开户银行',
	account_number                	varchar(68)                              comment '帐户号码',
	country_center                	varchar(48)                              comment '全国运营中心',
	retail_store                  	varchar(48)                              comment '双链小超',
	goods_supplier                	varchar(48)                              comment '产品供应商',
	last_update_time              	datetime                                 comment '更新于',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists accounting_subject_data;
create table accounting_subject_data (
	id                            	varchar(48)          not null            comment 'ID',
	accounting_subject_code       	varchar(24)                              comment '会计科目代码',
	accounting_subject_name       	varchar(16)                              comment '会计科目名称',
	accounting_subject_class_code 	int                                      comment '会计科目类别代码',
	accounting_subject_class_name 	varchar(24)                              comment '会计科目类别名称',
	account_set                   	varchar(48)                              comment '账套',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists accounting_period_data;
create table accounting_period_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(32)                              comment '名称',
	start_date                    	date                                     comment '开始日期',
	end_date                      	date                                     comment '结束日期',
	account_set                   	varchar(48)                              comment '账套',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists accounting_document_type_data;
create table accounting_document_type_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(16)                              comment '名称',
	description                   	varchar(280)                             comment '描述',
	accounting_period             	varchar(48)                              comment '会计期间',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists accounting_document_data;
create table accounting_document_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(16)                              comment '名称',
	accounting_document_date      	date                                     comment '会计凭证日期',
	accounting_period             	varchar(48)                              comment '会计期间',
	document_type                 	varchar(48)                              comment '文档类型',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists original_voucher_data;
create table original_voucher_data (
	id                            	varchar(48)          not null            comment 'ID',
	title                         	varchar(28)                              comment '头衔',
	made_by                       	varchar(12)                              comment '由',
	received_by                   	varchar(12)                              comment '受',
	voucher_type                  	varchar(16)                              comment '凭证类型',
	voucher_image                 	varchar(512)                             comment '凭证图像',
	belongs_to                    	varchar(48)                              comment '属于',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists accounting_document_line_data;
create table accounting_document_line_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(16)                              comment '名称',
	code                          	varchar(24)                              comment '代码',
	direct                        	varchar(4)                               comment '直接',
	amount                        	numeric(10,2)                            comment '金额',
	belongs_to                    	varchar(48)                              comment '属于',
	accounting_subject            	varchar(48)                              comment '会计科目',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists level_one_department_data;
create table level_one_department_data (
	id                            	varchar(48)          not null            comment 'ID',
	belongs_to                    	varchar(48)                              comment '属于',
	name                          	varchar(20)                              comment '名称',
	description                   	varchar(72)                              comment '描述',
	manager                       	varchar(12)                              comment '经理',
	founded                       	date                                     comment '成立',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists level_two_department_data;
create table level_two_department_data (
	id                            	varchar(48)          not null            comment 'ID',
	belongs_to                    	varchar(48)                              comment '属于',
	name                          	varchar(40)                              comment '名称',
	description                   	varchar(72)                              comment '描述',
	founded                       	date                                     comment '成立',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists level_three_department_data;
create table level_three_department_data (
	id                            	varchar(48)          not null            comment 'ID',
	belongs_to                    	varchar(48)                              comment '属于',
	name                          	varchar(52)                              comment '名称',
	description                   	varchar(72)                              comment '描述',
	founded                       	date                                     comment '成立',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists skill_type_data;
create table skill_type_data (
	id                            	varchar(48)          not null            comment 'ID',
	code                          	varchar(20)                              comment '代码',
	company                       	varchar(48)                              comment '公司',
	description                   	varchar(24)                              comment '描述',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists responsibility_type_data;
create table responsibility_type_data (
	id                            	varchar(48)          not null            comment 'ID',
	code                          	varchar(20)                              comment '代码',
	company                       	varchar(48)                              comment '公司',
	base_description              	varchar(16)                              comment '基本描述',
	detail_description            	varchar(116)                             comment '详细描述',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists termination_reason_data;
create table termination_reason_data (
	id                            	varchar(48)          not null            comment 'ID',
	code                          	varchar(28)                              comment '代码',
	company                       	varchar(48)                              comment '公司',
	description                   	varchar(36)                              comment '描述',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists termination_type_data;
create table termination_type_data (
	id                            	varchar(48)          not null            comment 'ID',
	code                          	varchar(28)                              comment '代码',
	company                       	varchar(48)                              comment '公司',
	base_description              	varchar(16)                              comment '基本描述',
	detail_description            	varchar(248)                             comment '详细描述',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists occupation_type_data;
create table occupation_type_data (
	id                            	varchar(48)          not null            comment 'ID',
	code                          	varchar(24)                              comment '代码',
	company                       	varchar(48)                              comment '公司',
	description                   	varchar(28)                              comment '描述',
	detail_description            	varchar(244)                             comment '详细描述',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists leave_type_data;
create table leave_type_data (
	id                            	varchar(48)          not null            comment 'ID',
	code                          	varchar(24)                              comment '代码',
	company                       	varchar(48)                              comment '公司',
	description                   	varchar(16)                              comment '描述',
	detail_description            	varchar(244)                             comment '详细描述',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists salary_grade_data;
create table salary_grade_data (
	id                            	varchar(48)          not null            comment 'ID',
	code                          	varchar(24)                              comment '代码',
	company                       	varchar(48)                              comment '公司',
	name                          	varchar(16)                              comment '名称',
	detail_description            	varchar(244)                             comment '详细描述',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists interview_type_data;
create table interview_type_data (
	id                            	varchar(48)          not null            comment 'ID',
	code                          	varchar(32)                              comment '代码',
	company                       	varchar(48)                              comment '公司',
	description                   	varchar(24)                              comment '描述',
	detail_description            	varchar(244)                             comment '详细描述',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists training_course_type_data;
create table training_course_type_data (
	id                            	varchar(48)          not null            comment 'ID',
	code                          	varchar(16)                              comment '代码',
	company                       	varchar(48)                              comment '公司',
	name                          	varchar(16)                              comment '名称',
	description                   	varchar(64)                              comment '描述',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists public_holiday_data;
create table public_holiday_data (
	id                            	varchar(48)          not null            comment 'ID',
	code                          	varchar(16)                              comment '代码',
	company                       	varchar(48)                              comment '公司',
	name                          	varchar(12)                              comment '名称',
	description                   	varchar(40)                              comment '描述',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists termination_data;
create table termination_data (
	id                            	varchar(48)          not null            comment 'ID',
	reason                        	varchar(48)                              comment '原因',
	type                          	varchar(48)                              comment '类型',
	comment                       	varchar(16)                              comment '评论',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists view_data;
create table view_data (
	id                            	varchar(48)          not null            comment 'ID',
	who                           	varchar(12)                              comment '谁',
	assessment                    	varchar(40)                              comment '评估',
	interview_time                	date                                     comment '面试时间',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists employee_data;
create table employee_data (
	id                            	varchar(48)          not null            comment 'ID',
	company                       	varchar(48)                              comment '公司',
	title                         	varchar(12)                              comment '头衔',
	department                    	varchar(48)                              comment '部门',
	family_name                   	varchar(4)                               comment '姓',
	given_name                    	varchar(8)                               comment '名',
	email                         	varchar(256)                             comment '电子邮件',
	city                          	varchar(8)                               comment '城市',
	address                       	varchar(28)                              comment '地址',
	cell_phone                    	varchar(44)                              comment '手机',
	occupation                    	varchar(48)                              comment '职业',
	responsible_for               	varchar(48)                              comment '负责',
	current_salary_grade          	varchar(48)                              comment '目前工资等级',
	salary_account                	varchar(60)                              comment '工资账户',
	last_update_time              	datetime                                 comment '更新于',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists instructor_data;
create table instructor_data (
	id                            	varchar(48)          not null            comment 'ID',
	title                         	varchar(16)                              comment '头衔',
	family_name                   	varchar(4)                               comment '姓',
	given_name                    	varchar(8)                               comment '名',
	cell_phone                    	varchar(44)                              comment '手机',
	email                         	varchar(256)                             comment '电子邮件',
	company                       	varchar(48)                              comment '公司',
	introduction                  	varchar(60)                              comment '介绍',
	last_update_time              	datetime                                 comment '更新于',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists company_training_data;
create table company_training_data (
	id                            	varchar(48)          not null            comment 'ID',
	title                         	varchar(16)                              comment '头衔',
	company                       	varchar(48)                              comment '公司',
	instructor                    	varchar(48)                              comment '讲师',
	training_course_type          	varchar(48)                              comment '培训课程类型',
	time_start                    	date                                     comment '时间开始',
	duration_hours                	int                                      comment '持续时间',
	last_update_time              	datetime                                 comment '更新于',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists scoring_data;
create table scoring_data (
	id                            	varchar(48)          not null            comment 'ID',
	scored_by                     	varchar(12)                              comment '由谁打分',
	score                         	int                                      comment '分数',
	comment                       	varchar(36)                              comment '评论',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists employee_company_training_data;
create table employee_company_training_data (
	id                            	varchar(48)          not null            comment 'ID',
	employee                      	varchar(48)                              comment '员工',
	training                      	varchar(48)                              comment '训练',
	scoring                       	varchar(48)                              comment '评分',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists employee_skill_data;
create table employee_skill_data (
	id                            	varchar(48)          not null            comment 'ID',
	employee                      	varchar(48)                              comment '员工',
	skill_type                    	varchar(48)                              comment '技能类型',
	description                   	varchar(28)                              comment '描述',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists employee_performance_data;
create table employee_performance_data (
	id                            	varchar(48)          not null            comment 'ID',
	employee                      	varchar(48)                              comment '员工',
	performance_comment           	varchar(28)                              comment '绩效评价',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists employee_work_experience_data;
create table employee_work_experience_data (
	id                            	varchar(48)          not null            comment 'ID',
	employee                      	varchar(48)                              comment '员工',
	start                         	date                                     comment '开始',
	end                           	date                                     comment '结束',
	company                       	varchar(32)                              comment '公司',
	description                   	varchar(84)                              comment '描述',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists employee_leave_data;
create table employee_leave_data (
	id                            	varchar(48)          not null            comment 'ID',
	who                           	varchar(48)                              comment '谁',
	type                          	varchar(48)                              comment '类型',
	leave_duration_hour           	int                                      comment '请假时长',
	remark                        	varchar(44)                              comment '备注',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists employee_interview_data;
create table employee_interview_data (
	id                            	varchar(48)          not null            comment 'ID',
	employee                      	varchar(48)                              comment '员工',
	interview_type                	varchar(48)                              comment '面试类型',
	remark                        	varchar(40)                              comment '备注',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists employee_attendance_data;
create table employee_attendance_data (
	id                            	varchar(48)          not null            comment 'ID',
	employee                      	varchar(48)                              comment '员工',
	enter_time                    	date                                     comment '进入时间',
	leave_time                    	date                                     comment '离开的时候',
	duration_hours                	int                                      comment '持续时间',
	remark                        	varchar(28)                              comment '备注',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists employee_qualifier_data;
create table employee_qualifier_data (
	id                            	varchar(48)          not null            comment 'ID',
	employee                      	varchar(48)                              comment '员工',
	qualified_time                	date                                     comment '合格的时间',
	type                          	varchar(20)                              comment '类型',
	level                         	varchar(8)                               comment '水平',
	remark                        	varchar(36)                              comment '备注',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists employee_education_data;
create table employee_education_data (
	id                            	varchar(48)          not null            comment 'ID',
	employee                      	varchar(48)                              comment '员工',
	complete_time                 	date                                     comment '完成时间',
	type                          	varchar(16)                              comment '类型',
	remark                        	varchar(36)                              comment '备注',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists employee_award_data;
create table employee_award_data (
	id                            	varchar(48)          not null            comment 'ID',
	employee                      	varchar(48)                              comment '员工',
	complete_time                 	date                                     comment '完成时间',
	type                          	varchar(20)                              comment '类型',
	remark                        	varchar(36)                              comment '备注',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists employee_salary_sheet_data;
create table employee_salary_sheet_data (
	id                            	varchar(48)          not null            comment 'ID',
	employee                      	varchar(48)                              comment '员工',
	current_salary_grade          	varchar(48)                              comment '目前工资等级',
	base_salary                   	numeric(8,2)                             comment '基本工资',
	bonus                         	numeric(8,2)                             comment '奖金',
	reward                        	numeric(8,2)                             comment '奖励',
	personal_tax                  	numeric(7,2)                             comment '个人所得税',
	social_security               	numeric(8,2)                             comment '社会保险',
	housing_found                 	numeric(8,2)                             comment '住房公积金',
	job_insurance                 	numeric(5,2)                             comment '失业保险',
	paying_off                    	varchar(48)                              comment '工资支付',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists paying_off_data;
create table paying_off_data (
	id                            	varchar(48)          not null            comment 'ID',
	who                           	varchar(8)                               comment '谁',
	paid_for                      	varchar(48)                              comment '支付',
	paid_time                     	date                                     comment '支付时间',
	amount                        	numeric(8,2)                             comment '金额',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists mobile_app_data;
create table mobile_app_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(20)                              comment '名称',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists page_data;
create table page_data (
	id                            	varchar(48)          not null            comment 'ID',
	page_title                    	varchar(10)                              comment '页面标题',
	link_to_url                   	varchar(512)                             comment '链接网址',
	page_type                     	varchar(48)                              comment '页面类型',
	display_order                 	int                                      comment '顺序',
	mobile_app                    	varchar(48)                              comment '手机应用程序',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists page_type_data;
create table page_type_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(40)                              comment '名称',
	code                          	varchar(40)                              comment '代码',
	mobile_app                    	varchar(48)                              comment '手机应用程序',
	footer_tab                    	tinyint                                  comment '页脚选项卡',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists slide_data;
create table slide_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(40)                              comment '名称',
	display_order                 	int                                      comment '顺序',
	image_url                     	varchar(512)                             comment '图片链接',
	video_url                     	varchar(512)                             comment '视频网址',
	link_to_url                   	varchar(512)                             comment '链接网址',
	page                          	varchar(48)                              comment '页面',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists ui_action_data;
create table ui_action_data (
	id                            	varchar(48)          not null            comment 'ID',
	code                          	varchar(40)                              comment '代码',
	icon                          	varchar(512)                             comment '图标',
	title                         	varchar(40)                              comment '头衔',
	display_order                 	int                                      comment '顺序',
	brief                         	varchar(200)                             comment '短暂的',
	image_url                     	varchar(512)                             comment '图片链接',
	link_to_url                   	varchar(512)                             comment '链接网址',
	extra_data                    	longtext                                 comment '额外的数据',
	page                          	varchar(48)                              comment '页面',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists section_data;
create table section_data (
	id                            	varchar(48)          not null            comment 'ID',
	title                         	varchar(40)                              comment '头衔',
	brief                         	varchar(200)                             comment '短暂的',
	icon                          	varchar(512)                             comment '图标',
	display_order                 	int                                      comment '顺序',
	view_group                    	varchar(40)                              comment '视图组',
	link_to_url                   	varchar(512)                             comment '链接网址',
	page                          	varchar(48)                              comment '页面',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists user_domain_data;
create table user_domain_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(16)                              comment '名称',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists user_allow_list_data;
create table user_allow_list_data (
	id                            	varchar(48)          not null            comment 'ID',
	user_identity                 	varchar(40)                              comment '用户标识',
	user_special_functions        	varchar(200)                             comment '用户特权',
	domain                        	varchar(48)                              comment '域',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists sec_user_data;
create table sec_user_data (
	id                            	varchar(48)          not null            comment 'ID',
	login                         	varchar(256)                             comment '登录名',
	mobile                        	varchar(11)                              comment '手机',
	email                         	varchar(256)                             comment '邮箱',
	pwd                           	varchar(64)                              comment '密码',
	weixin_openid                 	varchar(128)                             comment '微信openId',
	weixin_appid                  	varchar(128)                             comment '微信应用ID',
	access_token                  	varchar(128)                             comment '访问令牌',
	verification_code             	int                                      comment '验证码',
	verification_code_expire      	datetime                                 comment '验证码有效期',
	last_login_time               	datetime                                 comment '最后登录时间',
	domain                        	varchar(48)                              comment '域',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists user_app_data;
create table user_app_data (
	id                            	varchar(48)          not null            comment 'ID',
	title                         	varchar(300)                             comment '标题',
	sec_user                      	varchar(48)                              comment '系统用户',
	app_icon                      	varchar(20)                              comment '图标',
	full_access                   	tinyint                                  comment '完全访问',
	permission                    	varchar(20)                              comment '权限',
	app_type                      	varchar(100)                             comment '对象类型',
	app_id                        	varchar(100)                             comment '对象ID',
	ctx_type                      	varchar(100)                             comment '上下文类型',
	ctx_id                        	varchar(100)                             comment '上下文类型',
	location                      	varchar(200)                             comment '位置',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists quick_link_data;
create table quick_link_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(200)                             comment '名称',
	icon                          	varchar(200)                             comment '图标',
	image_path                    	varchar(512)                             comment '图片路径',
	link_target                   	varchar(200)                             comment '链接的目标',
	create_time                   	datetime                                 comment '创建于',
	app                           	varchar(48)                              comment '应用程序',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists list_access_data;
create table list_access_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(200)                             comment '名称',
	internal_name                 	varchar(200)                             comment '内部名称',
	read_permission               	tinyint                                  comment '可读',
	create_permission             	tinyint                                  comment '可创建',
	delete_permission             	tinyint                                  comment '可删除',
	update_permission             	tinyint                                  comment '可更新',
	execution_permission          	tinyint                                  comment '可执行',
	app                           	varchar(48)                              comment '应用',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists login_history_data;
create table login_history_data (
	id                            	varchar(48)          not null            comment 'ID',
	login_time                    	datetime                                 comment '登录时间',
	from_ip                       	varchar(44)                              comment '来自IP',
	description                   	varchar(16)                              comment '描述',
	sec_user                      	varchar(48)                              comment '系统用户',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists candidate_container_data;
create table candidate_container_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(28)                              comment '名称',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists candidate_element_data;
create table candidate_element_data (
	id                            	varchar(48)          not null            comment 'ID',
	name                          	varchar(200)                             comment '标题',
	type                          	varchar(200)                             comment '类型',
	image                         	varchar(512)                             comment '图像',
	container                     	varchar(48)                              comment '容器',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists wechat_workapp_identity_data;
create table wechat_workapp_identity_data (
	id                            	varchar(48)          not null            comment 'ID',
	corp_id                       	varchar(100)                             comment '公司',
	user_id                       	varchar(100)                             comment '用户',
	sec_user                      	varchar(48)                              comment '系统用户',
	create_time                   	datetime                                 comment '创建时间',
	last_login_time               	datetime                                 comment '最后登录时间',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists wechat_miniapp_identity_data;
create table wechat_miniapp_identity_data (
	id                            	varchar(48)          not null            comment 'ID',
	open_id                       	varchar(128)                             comment 'openId',
	app_id                        	varchar(128)                             comment '应用ID',
	union_id                      	varchar(128)                             comment 'UnionID',
	sec_user                      	varchar(48)                              comment '系统用户',
	create_time                   	datetime                                 comment '创建时间',
	last_login_time               	datetime                                 comment '最后登录时间',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists key_pair_identity_data;
create table key_pair_identity_data (
	id                            	varchar(48)          not null            comment 'ID',
	public_key                    	longtext                                 comment '公钥',
	key_type                      	varchar(48)                              comment '秘钥类型',
	sec_user                      	varchar(48)                              comment '系统用户',
	create_time                   	datetime                                 comment '创建时间',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists public_key_type_data;
create table public_key_type_data (
	id                            	varchar(48)          not null            comment 'ID',
	key_alg                       	varchar(10)                              comment '加密算法',
	sign_alg                      	varchar(50)                              comment '签名算法',
	domain                        	varchar(48)                              comment '域',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance

drop table  if exists tree_node_data;
create table tree_node_data (
	id                            	varchar(48)          not null            comment 'ID',
	node_id                       	varchar(40)                              comment '节点ID',
	node_type                     	varchar(32)                              comment '节点类型',
	left_value                    	int                                      comment '左值',
	right_value                   	int                                      comment '右值',
	version                       	int                                      comment '版本'
	
) ;
-- primary key will be created later for better import performance




insert into retail_store_country_center_data values
	('RSCC000001','双链小超中国国运营中心','4000-800-0001','2020-12-11','https://www.doublechaintech.com/','四川省成都市天府新区双链大厦0001','双链集团0001','张喜来','中国中心正式成立，恭喜恭喜0001','1');

insert into catalog_data values
	('C000001','水果蔬菜','RSCC000001','8','7.77','1'),
	('C000002','肉禽蛋奶','RSCC000001','10','8.14','1');

insert into level_one_category_data values
	('LOC000001','C000001','水果蔬菜','1'),
	('LOC000002','C000001','肉禽蛋奶','1'),
	('LOC000003','C000002','冷热速食','1'),
	('LOC000004','C000002','休闲食品','1');

insert into level_two_category_data values
	('LTC000001','LOC000001','水果蔬菜','1'),
	('LTC000002','LOC000001','肉禽蛋奶','1'),
	('LTC000003','LOC000002','冷热速食','1'),
	('LTC000004','LOC000002','休闲食品','1'),
	('LTC000005','LOC000003','酒水饮料','1'),
	('LTC000006','LOC000003','粮油调味','1'),
	('LTC000007','LOC000004','清洁日化','1'),
	('LTC000008','LOC000004','家居用品','1');

insert into level_three_category_data values
	('LTC000001','LTC000001','水果蔬菜','1'),
	('LTC000002','LTC000001','肉禽蛋奶','1'),
	('LTC000003','LTC000002','冷热速食','1'),
	('LTC000004','LTC000002','休闲食品','1'),
	('LTC000005','LTC000003','酒水饮料','1'),
	('LTC000006','LTC000003','粮油调味','1'),
	('LTC000007','LTC000004','清洁日化','1'),
	('LTC000008','LTC000004','家居用品','1'),
	('LTC000009','LTC000005','鲜花蛋糕','1'),
	('LTC000010','LTC000005','医药健康','1'),
	('LTC000011','LTC000006','水果蔬菜','1'),
	('LTC000012','LTC000006','肉禽蛋奶','1'),
	('LTC000013','LTC000007','冷热速食','1'),
	('LTC000014','LTC000007','休闲食品','1'),
	('LTC000015','LTC000008','酒水饮料','1'),
	('LTC000016','LTC000008','粮油调味','1');

insert into product_data values
	('P000001','啤酒','LTC000001','四川','可口可乐，销售百年的糖水，获得了全世界额青睐0001','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0001','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0001/400/200/grey/','2021-08-31 04:31:24','1'),
	('P000002','可乐','LTC000001','广东','可口可乐，销售百年的糖水，获得了全世界额青睐0002','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0002','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0002/400/200/grey/','2021-08-29 08:05:30','1'),
	('P000003','久久鸭','LTC000002','江苏','可口可乐，销售百年的糖水，获得了全世界额青睐0003','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0003','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0003/400/200/grey/','2021-09-02 18:51:03','1'),
	('P000004','啤酒','LTC000002','安徽','可口可乐，销售百年的糖水，获得了全世界额青睐0004','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0004','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0004/400/200/grey/','2021-08-30 10:12:48','1'),
	('P000005','可乐','LTC000003','日本','可口可乐，销售百年的糖水，获得了全世界额青睐0005','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0005','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0005/400/200/grey/','2021-08-21 01:23:28','1'),
	('P000006','久久鸭','LTC000003','法国','可口可乐，销售百年的糖水，获得了全世界额青睐0006','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0006','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0006/400/200/grey/','2021-09-06 02:06:35','1'),
	('P000007','啤酒','LTC000004','四川','可口可乐，销售百年的糖水，获得了全世界额青睐0007','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0007','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0007/400/200/grey/','2021-09-02 07:18:31','1'),
	('P000008','可乐','LTC000004','广东','可口可乐，销售百年的糖水，获得了全世界额青睐0008','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0008','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0008/400/200/grey/','2021-08-31 15:44:51','1'),
	('P000009','久久鸭','LTC000005','江苏','可口可乐，销售百年的糖水，获得了全世界额青睐0009','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0009','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0009/400/200/grey/','2021-09-06 15:29:32','1'),
	('P000010','啤酒','LTC000005','安徽','可口可乐，销售百年的糖水，获得了全世界额青睐0010','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0010','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0010/400/200/grey/','2021-09-09 07:58:52','1'),
	('P000011','可乐','LTC000006','日本','可口可乐，销售百年的糖水，获得了全世界额青睐0011','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0011','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0011/400/200/grey/','2021-08-24 14:33:47','1'),
	('P000012','久久鸭','LTC000006','法国','可口可乐，销售百年的糖水，获得了全世界额青睐0012','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0012','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0012/400/200/grey/','2021-08-27 22:53:57','1'),
	('P000013','啤酒','LTC000007','四川','可口可乐，销售百年的糖水，获得了全世界额青睐0013','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0013','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0013/400/200/grey/','2021-08-31 21:39:31','1'),
	('P000014','可乐','LTC000007','广东','可口可乐，销售百年的糖水，获得了全世界额青睐0014','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0014','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0014/400/200/grey/','2021-09-05 03:02:07','1'),
	('P000015','久久鸭','LTC000008','江苏','可口可乐，销售百年的糖水，获得了全世界额青睐0015','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0015','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0015/400/200/grey/','2021-08-25 05:45:39','1'),
	('P000016','啤酒','LTC000008','安徽','可口可乐，销售百年的糖水，获得了全世界额青睐0016','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0016','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0016/400/200/grey/','2021-09-02 17:49:13','1'),
	('P000017','可乐','LTC000009','日本','可口可乐，销售百年的糖水，获得了全世界额青睐0017','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0017','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0017/400/200/grey/','2021-09-05 08:00:42','1'),
	('P000018','久久鸭','LTC000009','法国','可口可乐，销售百年的糖水，获得了全世界额青睐0018','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0018','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0018/400/200/grey/','2021-08-24 04:07:26','1'),
	('P000019','啤酒','LTC000010','四川','可口可乐，销售百年的糖水，获得了全世界额青睐0019','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0019','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0019/400/200/grey/','2021-09-08 12:23:08','1'),
	('P000020','可乐','LTC000010','广东','可口可乐，销售百年的糖水，获得了全世界额青睐0020','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0020','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0020/400/200/grey/','2021-09-08 22:20:58','1'),
	('P000021','久久鸭','LTC000011','江苏','可口可乐，销售百年的糖水，获得了全世界额青睐0021','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0021','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0021/400/200/grey/','2021-08-28 09:36:39','1'),
	('P000022','啤酒','LTC000011','安徽','可口可乐，销售百年的糖水，获得了全世界额青睐0022','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0022','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0022/400/200/grey/','2021-09-06 12:13:29','1'),
	('P000023','可乐','LTC000012','日本','可口可乐，销售百年的糖水，获得了全世界额青睐0023','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0023','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0023/400/200/grey/','2021-08-21 11:05:27','1'),
	('P000024','久久鸭','LTC000012','法国','可口可乐，销售百年的糖水，获得了全世界额青睐0024','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0024','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0024/400/200/grey/','2021-08-25 04:57:51','1'),
	('P000025','啤酒','LTC000013','四川','可口可乐，销售百年的糖水，获得了全世界额青睐0025','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0025','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0025/400/200/grey/','2021-08-24 02:17:32','1'),
	('P000026','可乐','LTC000013','广东','可口可乐，销售百年的糖水，获得了全世界额青睐0026','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0026','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0026/400/200/grey/','2021-09-06 20:19:50','1'),
	('P000027','久久鸭','LTC000014','江苏','可口可乐，销售百年的糖水，获得了全世界额青睐0027','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0027','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0027/400/200/grey/','2021-08-28 22:51:33','1'),
	('P000028','啤酒','LTC000014','安徽','可口可乐，销售百年的糖水，获得了全世界额青睐0028','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0028','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0028/400/200/grey/','2021-08-24 15:35:38','1'),
	('P000029','可乐','LTC000015','日本','可口可乐，销售百年的糖水，获得了全世界额青睐0029','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0029','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0029/400/200/grey/','2021-08-21 17:02:52','1'),
	('P000030','久久鸭','LTC000015','法国','可口可乐，销售百年的糖水，获得了全世界额青睐0030','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0030','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0030/400/200/grey/','2021-08-21 09:52:17','1'),
	('P000031','啤酒','LTC000016','四川','可口可乐，销售百年的糖水，获得了全世界额青睐0031','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0031','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0031/400/200/grey/','2021-09-04 02:29:52','1'),
	('P000032','可乐','LTC000016','广东','可口可乐，销售百年的糖水，获得了全世界额青睐0032','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0032','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0032/400/200/grey/','2021-09-06 02:15:19','1');

insert into sku_data values
	('S000001','可乐-大罐的0001','大','P000001','TM000000000010001','包装类型0001','包装数量等信息,包装数量等信息,包装数量等信息0001','1215.32','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0001/400/200/grey/','1'),
	('S000002','可乐-大罐的0002','中','P000001','TM000000000010002','包装类型0002','包装数量等信息,包装数量等信息,包装数量等信息0002','1075.91','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0002/400/200/grey/','1'),
	('S000003','可乐-大罐的0003','小','P000002','TM000000000010003','包装类型0003','包装数量等信息,包装数量等信息,包装数量等信息0003','1131.22','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0003/400/200/grey/','1'),
	('S000004','可乐-大罐的0004','大','P000002','TM000000000010004','包装类型0004','包装数量等信息,包装数量等信息,包装数量等信息0004','1057.77','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0004/400/200/grey/','1'),
	('S000005','可乐-大罐的0005','中','P000003','TM000000000010005','包装类型0005','包装数量等信息,包装数量等信息,包装数量等信息0005','1109.07','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0005/400/200/grey/','1'),
	('S000006','可乐-大罐的0006','小','P000003','TM000000000010006','包装类型0006','包装数量等信息,包装数量等信息,包装数量等信息0006','1184.32','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0006/400/200/grey/','1'),
	('S000007','可乐-大罐的0007','大','P000004','TM000000000010007','包装类型0007','包装数量等信息,包装数量等信息,包装数量等信息0007','929.02','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0007/400/200/grey/','1'),
	('S000008','可乐-大罐的0008','中','P000004','TM000000000010008','包装类型0008','包装数量等信息,包装数量等信息,包装数量等信息0008','1167.89','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0008/400/200/grey/','1'),
	('S000009','可乐-大罐的0009','小','P000005','TM000000000010009','包装类型0009','包装数量等信息,包装数量等信息,包装数量等信息0009','1170.69','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0009/400/200/grey/','1'),
	('S000010','可乐-大罐的0010','大','P000005','TM000000000010010','包装类型0010','包装数量等信息,包装数量等信息,包装数量等信息0010','1065.86','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0010/400/200/grey/','1'),
	('S000011','可乐-大罐的0011','中','P000006','TM000000000010011','包装类型0011','包装数量等信息,包装数量等信息,包装数量等信息0011','1081.19','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0011/400/200/grey/','1'),
	('S000012','可乐-大罐的0012','小','P000006','TM000000000010012','包装类型0012','包装数量等信息,包装数量等信息,包装数量等信息0012','1065.07','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0012/400/200/grey/','1'),
	('S000013','可乐-大罐的0013','大','P000007','TM000000000010013','包装类型0013','包装数量等信息,包装数量等信息,包装数量等信息0013','1300.40','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0013/400/200/grey/','1'),
	('S000014','可乐-大罐的0014','中','P000007','TM000000000010014','包装类型0014','包装数量等信息,包装数量等信息,包装数量等信息0014','1203.98','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0014/400/200/grey/','1'),
	('S000015','可乐-大罐的0015','小','P000008','TM000000000010015','包装类型0015','包装数量等信息,包装数量等信息,包装数量等信息0015','956.30','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0015/400/200/grey/','1'),
	('S000016','可乐-大罐的0016','大','P000008','TM000000000010016','包装类型0016','包装数量等信息,包装数量等信息,包装数量等信息0016','1118.67','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0016/400/200/grey/','1'),
	('S000017','可乐-大罐的0017','中','P000009','TM000000000010017','包装类型0017','包装数量等信息,包装数量等信息,包装数量等信息0017','937.21','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0017/400/200/grey/','1'),
	('S000018','可乐-大罐的0018','小','P000009','TM000000000010018','包装类型0018','包装数量等信息,包装数量等信息,包装数量等信息0018','1151.42','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0018/400/200/grey/','1'),
	('S000019','可乐-大罐的0019','大','P000010','TM000000000010019','包装类型0019','包装数量等信息,包装数量等信息,包装数量等信息0019','936.01','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0019/400/200/grey/','1'),
	('S000020','可乐-大罐的0020','中','P000010','TM000000000010020','包装类型0020','包装数量等信息,包装数量等信息,包装数量等信息0020','1102.93','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0020/400/200/grey/','1'),
	('S000021','可乐-大罐的0021','小','P000011','TM000000000010021','包装类型0021','包装数量等信息,包装数量等信息,包装数量等信息0021','1076.77','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0021/400/200/grey/','1'),
	('S000022','可乐-大罐的0022','大','P000011','TM000000000010022','包装类型0022','包装数量等信息,包装数量等信息,包装数量等信息0022','1309.76','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0022/400/200/grey/','1'),
	('S000023','可乐-大罐的0023','中','P000012','TM000000000010023','包装类型0023','包装数量等信息,包装数量等信息,包装数量等信息0023','1308.67','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0023/400/200/grey/','1'),
	('S000024','可乐-大罐的0024','小','P000012','TM000000000010024','包装类型0024','包装数量等信息,包装数量等信息,包装数量等信息0024','1110.67','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0024/400/200/grey/','1'),
	('S000025','可乐-大罐的0025','大','P000013','TM000000000010025','包装类型0025','包装数量等信息,包装数量等信息,包装数量等信息0025','956.17','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0025/400/200/grey/','1'),
	('S000026','可乐-大罐的0026','中','P000013','TM000000000010026','包装类型0026','包装数量等信息,包装数量等信息,包装数量等信息0026','1187.86','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0026/400/200/grey/','1'),
	('S000027','可乐-大罐的0027','小','P000014','TM000000000010027','包装类型0027','包装数量等信息,包装数量等信息,包装数量等信息0027','1119.43','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0027/400/200/grey/','1'),
	('S000028','可乐-大罐的0028','大','P000014','TM000000000010028','包装类型0028','包装数量等信息,包装数量等信息,包装数量等信息0028','1015.40','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0028/400/200/grey/','1'),
	('S000029','可乐-大罐的0029','中','P000015','TM000000000010029','包装类型0029','包装数量等信息,包装数量等信息,包装数量等信息0029','968.05','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0029/400/200/grey/','1'),
	('S000030','可乐-大罐的0030','小','P000015','TM000000000010030','包装类型0030','包装数量等信息,包装数量等信息,包装数量等信息0030','1053.98','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0030/400/200/grey/','1'),
	('S000031','可乐-大罐的0031','大','P000016','TM000000000010031','包装类型0031','包装数量等信息,包装数量等信息,包装数量等信息0031','1156.36','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0031/400/200/grey/','1'),
	('S000032','可乐-大罐的0032','中','P000016','TM000000000010032','包装类型0032','包装数量等信息,包装数量等信息,包装数量等信息0032','1089.21','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0032/400/200/grey/','1'),
	('S000033','可乐-大罐的0033','小','P000017','TM000000000010033','包装类型0033','包装数量等信息,包装数量等信息,包装数量等信息0033','1092.20','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0033/400/200/grey/','1'),
	('S000034','可乐-大罐的0034','大','P000017','TM000000000010034','包装类型0034','包装数量等信息,包装数量等信息,包装数量等信息0034','1320.26','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0034/400/200/grey/','1'),
	('S000035','可乐-大罐的0035','中','P000018','TM000000000010035','包装类型0035','包装数量等信息,包装数量等信息,包装数量等信息0035','1135.19','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0035/400/200/grey/','1'),
	('S000036','可乐-大罐的0036','小','P000018','TM000000000010036','包装类型0036','包装数量等信息,包装数量等信息,包装数量等信息0036','1121.17','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0036/400/200/grey/','1'),
	('S000037','可乐-大罐的0037','大','P000019','TM000000000010037','包装类型0037','包装数量等信息,包装数量等信息,包装数量等信息0037','1099.38','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0037/400/200/grey/','1'),
	('S000038','可乐-大罐的0038','中','P000019','TM000000000010038','包装类型0038','包装数量等信息,包装数量等信息,包装数量等信息0038','1111.64','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0038/400/200/grey/','1'),
	('S000039','可乐-大罐的0039','小','P000020','TM000000000010039','包装类型0039','包装数量等信息,包装数量等信息,包装数量等信息0039','1306.55','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0039/400/200/grey/','1'),
	('S000040','可乐-大罐的0040','大','P000020','TM000000000010040','包装类型0040','包装数量等信息,包装数量等信息,包装数量等信息0040','1272.22','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0040/400/200/grey/','1'),
	('S000041','可乐-大罐的0041','中','P000021','TM000000000010041','包装类型0041','包装数量等信息,包装数量等信息,包装数量等信息0041','1072.92','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0041/400/200/grey/','1'),
	('S000042','可乐-大罐的0042','小','P000021','TM000000000010042','包装类型0042','包装数量等信息,包装数量等信息,包装数量等信息0042','1246.96','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0042/400/200/grey/','1'),
	('S000043','可乐-大罐的0043','大','P000022','TM000000000010043','包装类型0043','包装数量等信息,包装数量等信息,包装数量等信息0043','1292.33','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0043/400/200/grey/','1'),
	('S000044','可乐-大罐的0044','中','P000022','TM000000000010044','包装类型0044','包装数量等信息,包装数量等信息,包装数量等信息0044','1126.70','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0044/400/200/grey/','1'),
	('S000045','可乐-大罐的0045','小','P000023','TM000000000010045','包装类型0045','包装数量等信息,包装数量等信息,包装数量等信息0045','962.25','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0045/400/200/grey/','1'),
	('S000046','可乐-大罐的0046','大','P000023','TM000000000010046','包装类型0046','包装数量等信息,包装数量等信息,包装数量等信息0046','1021.39','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0046/400/200/grey/','1'),
	('S000047','可乐-大罐的0047','中','P000024','TM000000000010047','包装类型0047','包装数量等信息,包装数量等信息,包装数量等信息0047','1055.02','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0047/400/200/grey/','1'),
	('S000048','可乐-大罐的0048','小','P000024','TM000000000010048','包装类型0048','包装数量等信息,包装数量等信息,包装数量等信息0048','954.30','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0048/400/200/grey/','1'),
	('S000049','可乐-大罐的0049','大','P000025','TM000000000010049','包装类型0049','包装数量等信息,包装数量等信息,包装数量等信息0049','1165.09','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0049/400/200/grey/','1'),
	('S000050','可乐-大罐的0050','中','P000025','TM000000000010050','包装类型0050','包装数量等信息,包装数量等信息,包装数量等信息0050','1085.56','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0050/400/200/grey/','1'),
	('S000051','可乐-大罐的0051','小','P000026','TM000000000010051','包装类型0051','包装数量等信息,包装数量等信息,包装数量等信息0051','1287.69','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0051/400/200/grey/','1'),
	('S000052','可乐-大罐的0052','大','P000026','TM000000000010052','包装类型0052','包装数量等信息,包装数量等信息,包装数量等信息0052','1303.59','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0052/400/200/grey/','1'),
	('S000053','可乐-大罐的0053','中','P000027','TM000000000010053','包装类型0053','包装数量等信息,包装数量等信息,包装数量等信息0053','1018.66','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0053/400/200/grey/','1'),
	('S000054','可乐-大罐的0054','小','P000027','TM000000000010054','包装类型0054','包装数量等信息,包装数量等信息,包装数量等信息0054','1012.84','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0054/400/200/grey/','1'),
	('S000055','可乐-大罐的0055','大','P000028','TM000000000010055','包装类型0055','包装数量等信息,包装数量等信息,包装数量等信息0055','972.43','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0055/400/200/grey/','1'),
	('S000056','可乐-大罐的0056','中','P000028','TM000000000010056','包装类型0056','包装数量等信息,包装数量等信息,包装数量等信息0056','1103.48','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0056/400/200/grey/','1'),
	('S000057','可乐-大罐的0057','小','P000029','TM000000000010057','包装类型0057','包装数量等信息,包装数量等信息,包装数量等信息0057','1193.87','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0057/400/200/grey/','1'),
	('S000058','可乐-大罐的0058','大','P000029','TM000000000010058','包装类型0058','包装数量等信息,包装数量等信息,包装数量等信息0058','1141.63','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0058/400/200/grey/','1'),
	('S000059','可乐-大罐的0059','中','P000030','TM000000000010059','包装类型0059','包装数量等信息,包装数量等信息,包装数量等信息0059','1170.73','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0059/400/200/grey/','1'),
	('S000060','可乐-大罐的0060','小','P000030','TM000000000010060','包装类型0060','包装数量等信息,包装数量等信息,包装数量等信息0060','1320.00','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0060/400/200/grey/','1'),
	('S000061','可乐-大罐的0061','大','P000031','TM000000000010061','包装类型0061','包装数量等信息,包装数量等信息,包装数量等信息0061','1217.77','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0061/400/200/grey/','1'),
	('S000062','可乐-大罐的0062','中','P000031','TM000000000010062','包装类型0062','包装数量等信息,包装数量等信息,包装数量等信息0062','1001.96','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0062/400/200/grey/','1'),
	('S000063','可乐-大罐的0063','小','P000032','TM000000000010063','包装类型0063','包装数量等信息,包装数量等信息,包装数量等信息0063','1022.36','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0063/400/200/grey/','1'),
	('S000064','可乐-大罐的0064','大','P000032','TM000000000010064','包装类型0064','包装数量等信息,包装数量等信息,包装数量等信息0064','1128.03','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0064/400/200/grey/','1');

insert into retail_store_province_center_data values
	('RSPC000001','双链小超四川省运营中心','2020-08-01','RSCC000001','2021-09-09 02:41:07','1'),
	('RSPC000002','双链小超北京运营中心','2021-03-30','RSCC000001','2021-08-29 14:45:32','1');

insert into province_center_department_data values
	('PCD000001','供应链部','2021-08-22','RSPC000001','刘强','1'),
	('PCD000002','采购部','2019-04-01','RSPC000001','王德宏','1'),
	('PCD000003','管理部','2019-10-27','RSPC000002','刘强','1'),
	('PCD000004','财务部','2020-02-19','RSPC000002','王德宏','1');

insert into province_center_employee_data values
	('PCE000001','刘强','13999998888','wangdehong@yatang.cn','2019-12-23','PCD000001','RSPC000001','1'),
	('PCE000002','王德宏','13900000002','liuqiang@yatang.cn','2020-06-13','PCD000001','RSPC000001','1'),
	('PCE000003','刘强','13900000003','wangdehong@yatang.cn','2019-04-17','PCD000002','RSPC000001','1'),
	('PCE000004','王德宏','13900000004','liuqiang@yatang.cn','2019-06-30','PCD000002','RSPC000001','1'),
	('PCE000005','刘强','13900000005','wangdehong@yatang.cn','2019-12-15','PCD000003','RSPC000002','1'),
	('PCE000006','王德宏','13900000006','liuqiang@yatang.cn','2020-01-17','PCD000003','RSPC000002','1'),
	('PCE000007','刘强','13900000007','wangdehong@yatang.cn','2019-03-24','PCD000004','RSPC000002','1'),
	('PCE000008','王德宏','13900000008','liuqiang@yatang.cn','2020-11-19','PCD000004','RSPC000002','1');

insert into retail_store_city_service_center_data values
	('RSCSC000001','双链小超成都办事处','2021-03-28','RSPC000001','2021-09-03 04:02:57','1'),
	('RSCSC000002','双链小超绵阳办事处','2020-04-11','RSPC000001','2021-08-21 14:38:07','1'),
	('RSCSC000003','双链小超巴中办事处','2021-07-06','RSPC000002','2021-08-27 08:54:26','1'),
	('RSCSC000004','双链小超成都办事处','2020-11-14','RSPC000002','2021-08-21 02:39:22','1');

insert into city_partner_data values
	('CP000001','曾倩','13677778888','RSCSC000001','负责开拓市场，具有极强的开拓能力0001','2021-09-08 10:54:15','1'),
	('CP000002','黄风格','13900000002','RSCSC000001','负责开拓市场，具有极强的开拓能力0002','2021-09-01 20:07:34','1'),
	('CP000003','郭超','13900000003','RSCSC000002','负责开拓市场，具有极强的开拓能力0003','2021-09-04 07:54:59','1'),
	('CP000004','曾倩','13900000004','RSCSC000002','负责开拓市场，具有极强的开拓能力0004','2021-09-08 07:06:05','1'),
	('CP000005','黄风格','13900000005','RSCSC000003','负责开拓市场，具有极强的开拓能力0005','2021-08-31 23:47:17','1'),
	('CP000006','郭超','13900000006','RSCSC000003','负责开拓市场，具有极强的开拓能力0006','2021-08-22 01:07:16','1'),
	('CP000007','曾倩','13900000007','RSCSC000004','负责开拓市场，具有极强的开拓能力0007','2021-08-31 23:25:58','1'),
	('CP000008','黄风格','13900000008','RSCSC000004','负责开拓市场，具有极强的开拓能力0008','2021-08-22 22:04:54','1');

insert into potential_customer_data values
	('PC000001','曾倩','13677778888','RSCSC000001','CP000001','负责开拓市场，具有极强的开拓能力0001','2021-08-21 06:48:01','1'),
	('PC000002','黄风格','13900000002','RSCSC000001','CP000001','负责开拓市场，具有极强的开拓能力0002','2021-08-26 10:26:43','1'),
	('PC000003','郭超','13900000003','RSCSC000001','CP000002','负责开拓市场，具有极强的开拓能力0003','2021-09-08 18:31:26','1'),
	('PC000004','曾倩','13900000004','RSCSC000001','CP000002','负责开拓市场，具有极强的开拓能力0004','2021-08-31 17:50:39','1'),
	('PC000005','黄风格','13900000005','RSCSC000002','CP000003','负责开拓市场，具有极强的开拓能力0005','2021-08-24 11:03:56','1'),
	('PC000006','郭超','13900000006','RSCSC000002','CP000003','负责开拓市场，具有极强的开拓能力0006','2021-09-06 12:16:11','1'),
	('PC000007','曾倩','13900000007','RSCSC000002','CP000004','负责开拓市场，具有极强的开拓能力0007','2021-08-20 19:35:56','1'),
	('PC000008','黄风格','13900000008','RSCSC000002','CP000004','负责开拓市场，具有极强的开拓能力0008','2021-08-29 03:45:35','1'),
	('PC000009','郭超','13900000009','RSCSC000003','CP000005','负责开拓市场，具有极强的开拓能力0009','2021-08-20 16:53:59','1'),
	('PC000010','曾倩','13900000010','RSCSC000003','CP000005','负责开拓市场，具有极强的开拓能力0010','2021-08-21 15:06:59','1'),
	('PC000011','黄风格','13900000011','RSCSC000003','CP000006','负责开拓市场，具有极强的开拓能力0011','2021-09-08 22:23:35','1'),
	('PC000012','郭超','13900000012','RSCSC000003','CP000006','负责开拓市场，具有极强的开拓能力0012','2021-08-20 08:04:33','1'),
	('PC000013','曾倩','13900000013','RSCSC000004','CP000007','负责开拓市场，具有极强的开拓能力0013','2021-08-30 11:41:18','1'),
	('PC000014','黄风格','13900000014','RSCSC000004','CP000007','负责开拓市场，具有极强的开拓能力0014','2021-09-03 05:50:42','1'),
	('PC000015','郭超','13900000015','RSCSC000004','CP000008','负责开拓市场，具有极强的开拓能力0015','2021-09-01 14:10:34','1'),
	('PC000016','曾倩','13900000016','RSCSC000004','CP000008','负责开拓市场，具有极强的开拓能力0016','2021-08-28 01:30:23','1');

insert into potential_customer_contact_person_data values
	('PCCP000001','赵先生0001','13677778888','PC000001','这人在决策中战友较大的权重，密切观察中.....0001','1'),
	('PCCP000002','赵先生0002','13900000002','PC000001','这人在决策中战友较大的权重，密切观察中.....0002','1'),
	('PCCP000003','赵先生0003','13900000003','PC000002','这人在决策中战友较大的权重，密切观察中.....0003','1'),
	('PCCP000004','赵先生0004','13900000004','PC000002','这人在决策中战友较大的权重，密切观察中.....0004','1'),
	('PCCP000005','赵先生0005','13900000005','PC000003','这人在决策中战友较大的权重，密切观察中.....0005','1'),
	('PCCP000006','赵先生0006','13900000006','PC000003','这人在决策中战友较大的权重，密切观察中.....0006','1'),
	('PCCP000007','赵先生0007','13900000007','PC000004','这人在决策中战友较大的权重，密切观察中.....0007','1'),
	('PCCP000008','赵先生0008','13900000008','PC000004','这人在决策中战友较大的权重，密切观察中.....0008','1'),
	('PCCP000009','赵先生0009','13900000009','PC000005','这人在决策中战友较大的权重，密切观察中.....0009','1'),
	('PCCP000010','赵先生0010','13900000010','PC000005','这人在决策中战友较大的权重，密切观察中.....0010','1'),
	('PCCP000011','赵先生0011','13900000011','PC000006','这人在决策中战友较大的权重，密切观察中.....0011','1'),
	('PCCP000012','赵先生0012','13900000012','PC000006','这人在决策中战友较大的权重，密切观察中.....0012','1'),
	('PCCP000013','赵先生0013','13900000013','PC000007','这人在决策中战友较大的权重，密切观察中.....0013','1'),
	('PCCP000014','赵先生0014','13900000014','PC000007','这人在决策中战友较大的权重，密切观察中.....0014','1'),
	('PCCP000015','赵先生0015','13900000015','PC000008','这人在决策中战友较大的权重，密切观察中.....0015','1'),
	('PCCP000016','赵先生0016','13900000016','PC000008','这人在决策中战友较大的权重，密切观察中.....0016','1'),
	('PCCP000017','赵先生0017','13900000017','PC000009','这人在决策中战友较大的权重，密切观察中.....0017','1'),
	('PCCP000018','赵先生0018','13900000018','PC000009','这人在决策中战友较大的权重，密切观察中.....0018','1'),
	('PCCP000019','赵先生0019','13900000019','PC000010','这人在决策中战友较大的权重，密切观察中.....0019','1'),
	('PCCP000020','赵先生0020','13900000020','PC000010','这人在决策中战友较大的权重，密切观察中.....0020','1'),
	('PCCP000021','赵先生0021','13900000021','PC000011','这人在决策中战友较大的权重，密切观察中.....0021','1'),
	('PCCP000022','赵先生0022','13900000022','PC000011','这人在决策中战友较大的权重，密切观察中.....0022','1'),
	('PCCP000023','赵先生0023','13900000023','PC000012','这人在决策中战友较大的权重，密切观察中.....0023','1'),
	('PCCP000024','赵先生0024','13900000024','PC000012','这人在决策中战友较大的权重，密切观察中.....0024','1'),
	('PCCP000025','赵先生0025','13900000025','PC000013','这人在决策中战友较大的权重，密切观察中.....0025','1'),
	('PCCP000026','赵先生0026','13900000026','PC000013','这人在决策中战友较大的权重，密切观察中.....0026','1'),
	('PCCP000027','赵先生0027','13900000027','PC000014','这人在决策中战友较大的权重，密切观察中.....0027','1'),
	('PCCP000028','赵先生0028','13900000028','PC000014','这人在决策中战友较大的权重，密切观察中.....0028','1'),
	('PCCP000029','赵先生0029','13900000029','PC000015','这人在决策中战友较大的权重，密切观察中.....0029','1'),
	('PCCP000030','赵先生0030','13900000030','PC000015','这人在决策中战友较大的权重，密切观察中.....0030','1'),
	('PCCP000031','赵先生0031','13900000031','PC000016','这人在决策中战友较大的权重，密切观察中.....0031','1'),
	('PCCP000032','赵先生0032','13900000032','PC000016','这人在决策中战友较大的权重，密切观察中.....0032','1');

insert into potential_customer_contact_data values
	('PCC000001','和连载客户的联系记录0001','2021-05-22','电话','PC000001','CP000001','PCCP000001','转化希望很大0001','2021-09-10 18:30:44','1'),
	('PCC000002','和连载客户的联系记录0002','2021-07-30','短信','PC000001','CP000001','PCCP000001','转化希望很大0002','2021-09-08 17:47:46','1'),
	('PCC000003','和连载客户的联系记录0003','2021-02-04','登门拜访','PC000001','CP000001','PCCP000002','转化希望很大0003','2021-08-27 09:26:30','1'),
	('PCC000004','和连载客户的联系记录0004','2019-11-13','活动聊天','PC000001','CP000001','PCCP000002','转化希望很大0004','2021-08-21 15:35:06','1'),
	('PCC000005','和连载客户的联系记录0005','2020-10-22','电话','PC000002','CP000001','PCCP000003','转化希望很大0005','2021-08-28 19:54:13','1'),
	('PCC000006','和连载客户的联系记录0006','2019-06-16','短信','PC000002','CP000001','PCCP000003','转化希望很大0006','2021-09-03 22:13:16','1'),
	('PCC000007','和连载客户的联系记录0007','2020-06-15','登门拜访','PC000002','CP000001','PCCP000004','转化希望很大0007','2021-09-10 07:22:26','1'),
	('PCC000008','和连载客户的联系记录0008','2021-02-11','活动聊天','PC000002','CP000001','PCCP000004','转化希望很大0008','2021-08-30 02:24:07','1'),
	('PCC000009','和连载客户的联系记录0009','2019-11-15','电话','PC000003','CP000002','PCCP000005','转化希望很大0009','2021-09-03 21:03:26','1'),
	('PCC000010','和连载客户的联系记录0010','2020-02-06','短信','PC000003','CP000002','PCCP000005','转化希望很大0010','2021-09-04 20:18:13','1'),
	('PCC000011','和连载客户的联系记录0011','2018-09-22','登门拜访','PC000003','CP000002','PCCP000006','转化希望很大0011','2021-08-24 23:10:32','1'),
	('PCC000012','和连载客户的联系记录0012','2021-05-26','活动聊天','PC000003','CP000002','PCCP000006','转化希望很大0012','2021-09-01 05:08:08','1'),
	('PCC000013','和连载客户的联系记录0013','2019-08-21','电话','PC000004','CP000002','PCCP000007','转化希望很大0013','2021-08-30 19:17:15','1'),
	('PCC000014','和连载客户的联系记录0014','2021-02-27','短信','PC000004','CP000002','PCCP000007','转化希望很大0014','2021-08-20 23:41:02','1'),
	('PCC000015','和连载客户的联系记录0015','2019-03-30','登门拜访','PC000004','CP000002','PCCP000008','转化希望很大0015','2021-09-02 07:22:31','1'),
	('PCC000016','和连载客户的联系记录0016','2020-10-17','活动聊天','PC000004','CP000002','PCCP000008','转化希望很大0016','2021-09-02 06:08:41','1'),
	('PCC000017','和连载客户的联系记录0017','2021-05-27','电话','PC000005','CP000003','PCCP000009','转化希望很大0017','2021-08-23 05:02:56','1'),
	('PCC000018','和连载客户的联系记录0018','2020-04-27','短信','PC000005','CP000003','PCCP000009','转化希望很大0018','2021-08-25 05:00:49','1'),
	('PCC000019','和连载客户的联系记录0019','2021-08-30','登门拜访','PC000005','CP000003','PCCP000010','转化希望很大0019','2021-08-21 06:55:55','1'),
	('PCC000020','和连载客户的联系记录0020','2019-12-26','活动聊天','PC000005','CP000003','PCCP000010','转化希望很大0020','2021-09-09 22:59:35','1'),
	('PCC000021','和连载客户的联系记录0021','2019-06-19','电话','PC000006','CP000003','PCCP000011','转化希望很大0021','2021-09-06 03:21:54','1'),
	('PCC000022','和连载客户的联系记录0022','2021-03-04','短信','PC000006','CP000003','PCCP000011','转化希望很大0022','2021-08-23 12:47:29','1'),
	('PCC000023','和连载客户的联系记录0023','2021-06-16','登门拜访','PC000006','CP000003','PCCP000012','转化希望很大0023','2021-08-26 12:07:32','1'),
	('PCC000024','和连载客户的联系记录0024','2020-03-26','活动聊天','PC000006','CP000003','PCCP000012','转化希望很大0024','2021-08-20 14:07:55','1'),
	('PCC000025','和连载客户的联系记录0025','2020-08-05','电话','PC000007','CP000004','PCCP000013','转化希望很大0025','2021-08-31 10:34:45','1'),
	('PCC000026','和连载客户的联系记录0026','2020-07-01','短信','PC000007','CP000004','PCCP000013','转化希望很大0026','2021-08-25 20:51:13','1'),
	('PCC000027','和连载客户的联系记录0027','2020-05-24','登门拜访','PC000007','CP000004','PCCP000014','转化希望很大0027','2021-09-01 11:17:41','1'),
	('PCC000028','和连载客户的联系记录0028','2019-06-22','活动聊天','PC000007','CP000004','PCCP000014','转化希望很大0028','2021-09-05 21:16:53','1'),
	('PCC000029','和连载客户的联系记录0029','2019-03-10','电话','PC000008','CP000004','PCCP000015','转化希望很大0029','2021-09-07 01:19:23','1'),
	('PCC000030','和连载客户的联系记录0030','2020-10-16','短信','PC000008','CP000004','PCCP000015','转化希望很大0030','2021-09-03 18:27:21','1'),
	('PCC000031','和连载客户的联系记录0031','2020-08-31','登门拜访','PC000008','CP000004','PCCP000016','转化希望很大0031','2021-09-05 12:48:19','1'),
	('PCC000032','和连载客户的联系记录0032','2020-02-01','活动聊天','PC000008','CP000004','PCCP000016','转化希望很大0032','2021-08-29 14:57:08','1'),
	('PCC000033','和连载客户的联系记录0033','2019-06-27','电话','PC000009','CP000005','PCCP000017','转化希望很大0033','2021-09-02 14:23:19','1'),
	('PCC000034','和连载客户的联系记录0034','2019-06-12','短信','PC000009','CP000005','PCCP000017','转化希望很大0034','2021-08-27 11:05:37','1'),
	('PCC000035','和连载客户的联系记录0035','2021-02-04','登门拜访','PC000009','CP000005','PCCP000018','转化希望很大0035','2021-09-10 13:51:03','1'),
	('PCC000036','和连载客户的联系记录0036','2019-10-20','活动聊天','PC000009','CP000005','PCCP000018','转化希望很大0036','2021-09-01 20:08:42','1'),
	('PCC000037','和连载客户的联系记录0037','2020-04-25','电话','PC000010','CP000005','PCCP000019','转化希望很大0037','2021-08-20 15:59:51','1'),
	('PCC000038','和连载客户的联系记录0038','2019-11-08','短信','PC000010','CP000005','PCCP000019','转化希望很大0038','2021-09-10 07:11:39','1'),
	('PCC000039','和连载客户的联系记录0039','2019-08-17','登门拜访','PC000010','CP000005','PCCP000020','转化希望很大0039','2021-08-24 15:03:47','1'),
	('PCC000040','和连载客户的联系记录0040','2020-10-20','活动聊天','PC000010','CP000005','PCCP000020','转化希望很大0040','2021-09-01 16:16:22','1'),
	('PCC000041','和连载客户的联系记录0041','2019-04-22','电话','PC000011','CP000006','PCCP000021','转化希望很大0041','2021-09-04 06:21:30','1'),
	('PCC000042','和连载客户的联系记录0042','2020-06-27','短信','PC000011','CP000006','PCCP000021','转化希望很大0042','2021-08-31 02:49:33','1'),
	('PCC000043','和连载客户的联系记录0043','2020-12-31','登门拜访','PC000011','CP000006','PCCP000022','转化希望很大0043','2021-08-28 13:44:10','1'),
	('PCC000044','和连载客户的联系记录0044','2020-11-29','活动聊天','PC000011','CP000006','PCCP000022','转化希望很大0044','2021-08-21 23:56:33','1'),
	('PCC000045','和连载客户的联系记录0045','2019-06-13','电话','PC000012','CP000006','PCCP000023','转化希望很大0045','2021-08-21 06:47:54','1'),
	('PCC000046','和连载客户的联系记录0046','2019-08-11','短信','PC000012','CP000006','PCCP000023','转化希望很大0046','2021-08-26 14:21:53','1'),
	('PCC000047','和连载客户的联系记录0047','2019-05-04','登门拜访','PC000012','CP000006','PCCP000024','转化希望很大0047','2021-08-24 23:02:37','1'),
	('PCC000048','和连载客户的联系记录0048','2020-06-22','活动聊天','PC000012','CP000006','PCCP000024','转化希望很大0048','2021-08-27 01:02:27','1'),
	('PCC000049','和连载客户的联系记录0049','2021-07-17','电话','PC000013','CP000007','PCCP000025','转化希望很大0049','2021-08-22 00:58:03','1'),
	('PCC000050','和连载客户的联系记录0050','2020-03-04','短信','PC000013','CP000007','PCCP000025','转化希望很大0050','2021-08-28 04:27:23','1'),
	('PCC000051','和连载客户的联系记录0051','2019-01-06','登门拜访','PC000013','CP000007','PCCP000026','转化希望很大0051','2021-09-02 12:50:48','1'),
	('PCC000052','和连载客户的联系记录0052','2019-05-05','活动聊天','PC000013','CP000007','PCCP000026','转化希望很大0052','2021-09-09 05:09:31','1'),
	('PCC000053','和连载客户的联系记录0053','2019-11-02','电话','PC000014','CP000007','PCCP000027','转化希望很大0053','2021-08-27 13:23:54','1'),
	('PCC000054','和连载客户的联系记录0054','2020-02-27','短信','PC000014','CP000007','PCCP000027','转化希望很大0054','2021-08-27 06:49:04','1'),
	('PCC000055','和连载客户的联系记录0055','2020-01-23','登门拜访','PC000014','CP000007','PCCP000028','转化希望很大0055','2021-08-26 00:40:54','1'),
	('PCC000056','和连载客户的联系记录0056','2021-01-09','活动聊天','PC000014','CP000007','PCCP000028','转化希望很大0056','2021-09-08 08:24:09','1'),
	('PCC000057','和连载客户的联系记录0057','2018-11-23','电话','PC000015','CP000008','PCCP000029','转化希望很大0057','2021-08-26 04:06:59','1'),
	('PCC000058','和连载客户的联系记录0058','2019-04-11','短信','PC000015','CP000008','PCCP000029','转化希望很大0058','2021-09-07 06:00:56','1'),
	('PCC000059','和连载客户的联系记录0059','2020-12-31','登门拜访','PC000015','CP000008','PCCP000030','转化希望很大0059','2021-08-23 04:54:55','1'),
	('PCC000060','和连载客户的联系记录0060','2019-12-13','活动聊天','PC000015','CP000008','PCCP000030','转化希望很大0060','2021-09-07 12:25:41','1'),
	('PCC000061','和连载客户的联系记录0061','2021-07-22','电话','PC000016','CP000008','PCCP000031','转化希望很大0061','2021-08-26 03:47:25','1'),
	('PCC000062','和连载客户的联系记录0062','2019-11-22','短信','PC000016','CP000008','PCCP000031','转化希望很大0062','2021-09-04 03:45:51','1'),
	('PCC000063','和连载客户的联系记录0063','2020-10-13','登门拜访','PC000016','CP000008','PCCP000032','转化希望很大0063','2021-09-02 03:27:45','1'),
	('PCC000064','和连载客户的联系记录0064','2020-05-12','活动聊天','PC000016','CP000008','PCCP000032','转化希望很大0064','2021-09-02 04:32:10','1');

insert into city_event_data values
	('CE000001','小超见面会','13677778888','RSCSC000001','给大家讲解小超的发展蓝图0001','2021-08-25 19:14:18','1'),
	('CE000002','双链小超说明会','13900000002','RSCSC000001','给大家讲解小超的发展蓝图0002','2021-09-06 13:18:51','1'),
	('CE000003','小超见面会','13900000003','RSCSC000002','给大家讲解小超的发展蓝图0003','2021-09-09 18:58:16','1'),
	('CE000004','双链小超说明会','13900000004','RSCSC000002','给大家讲解小超的发展蓝图0004','2021-08-20 06:41:00','1'),
	('CE000005','小超见面会','13900000005','RSCSC000003','给大家讲解小超的发展蓝图0005','2021-08-31 17:25:24','1'),
	('CE000006','双链小超说明会','13900000006','RSCSC000003','给大家讲解小超的发展蓝图0006','2021-08-31 16:51:14','1'),
	('CE000007','小超见面会','13900000007','RSCSC000004','给大家讲解小超的发展蓝图0007','2021-08-24 12:08:48','1'),
	('CE000008','双链小超说明会','13900000008','RSCSC000004','给大家讲解小超的发展蓝图0008','2021-09-05 15:04:39','1');

insert into event_attendance_data values
	('EA000001','小超见面会参加信息0001','PC000001','CE000001','体会不错，考虑加盟0001','1'),
	('EA000002','小超见面会参加信息0002','PC000001','CE000001','体会不错，考虑加盟0002','1'),
	('EA000003','小超见面会参加信息0003','PC000002','CE000001','体会不错，考虑加盟0003','1'),
	('EA000004','小超见面会参加信息0004','PC000002','CE000001','体会不错，考虑加盟0004','1'),
	('EA000005','小超见面会参加信息0005','PC000003','CE000002','体会不错，考虑加盟0005','1'),
	('EA000006','小超见面会参加信息0006','PC000003','CE000002','体会不错，考虑加盟0006','1'),
	('EA000007','小超见面会参加信息0007','PC000004','CE000002','体会不错，考虑加盟0007','1'),
	('EA000008','小超见面会参加信息0008','PC000004','CE000002','体会不错，考虑加盟0008','1'),
	('EA000009','小超见面会参加信息0009','PC000005','CE000003','体会不错，考虑加盟0009','1'),
	('EA000010','小超见面会参加信息0010','PC000005','CE000003','体会不错，考虑加盟0010','1'),
	('EA000011','小超见面会参加信息0011','PC000006','CE000003','体会不错，考虑加盟0011','1'),
	('EA000012','小超见面会参加信息0012','PC000006','CE000003','体会不错，考虑加盟0012','1'),
	('EA000013','小超见面会参加信息0013','PC000007','CE000004','体会不错，考虑加盟0013','1'),
	('EA000014','小超见面会参加信息0014','PC000007','CE000004','体会不错，考虑加盟0014','1'),
	('EA000015','小超见面会参加信息0015','PC000008','CE000004','体会不错，考虑加盟0015','1'),
	('EA000016','小超见面会参加信息0016','PC000008','CE000004','体会不错，考虑加盟0016','1'),
	('EA000017','小超见面会参加信息0017','PC000009','CE000005','体会不错，考虑加盟0017','1'),
	('EA000018','小超见面会参加信息0018','PC000009','CE000005','体会不错，考虑加盟0018','1'),
	('EA000019','小超见面会参加信息0019','PC000010','CE000005','体会不错，考虑加盟0019','1'),
	('EA000020','小超见面会参加信息0020','PC000010','CE000005','体会不错，考虑加盟0020','1'),
	('EA000021','小超见面会参加信息0021','PC000011','CE000006','体会不错，考虑加盟0021','1'),
	('EA000022','小超见面会参加信息0022','PC000011','CE000006','体会不错，考虑加盟0022','1'),
	('EA000023','小超见面会参加信息0023','PC000012','CE000006','体会不错，考虑加盟0023','1'),
	('EA000024','小超见面会参加信息0024','PC000012','CE000006','体会不错，考虑加盟0024','1'),
	('EA000025','小超见面会参加信息0025','PC000013','CE000007','体会不错，考虑加盟0025','1'),
	('EA000026','小超见面会参加信息0026','PC000013','CE000007','体会不错，考虑加盟0026','1'),
	('EA000027','小超见面会参加信息0027','PC000014','CE000007','体会不错，考虑加盟0027','1'),
	('EA000028','小超见面会参加信息0028','PC000014','CE000007','体会不错，考虑加盟0028','1'),
	('EA000029','小超见面会参加信息0029','PC000015','CE000008','体会不错，考虑加盟0029','1'),
	('EA000030','小超见面会参加信息0030','PC000015','CE000008','体会不错，考虑加盟0030','1'),
	('EA000031','小超见面会参加信息0031','PC000016','CE000008','体会不错，考虑加盟0031','1'),
	('EA000032','小超见面会参加信息0032','PC000016','CE000008','体会不错，考虑加盟0032','1');

insert into retail_store_data values
	('RS000001','中和社区小超','028 876543210001','吕刚0001','RSCC000001','RSCSC000001','RSC000001','RSII000001','RSF000001','RSD000001','RSO000001','RSC000001','2018-09-28','41.39246041156659','132.04862339470074','啤酒饮料矿泉水，香肠瓜子方便面, 请让一让0001','2021-09-09 15:27:23','1'),
	('RS000002','华阳社区小超','028 876543210002','吕刚0002','RSCC000001','RSCSC000001','RSC000001','RSII000001','RSF000001','RSD000001','RSO000001','RSC000001','2021-09-02','42.29393172816174','129.4689950893811','啤酒饮料矿泉水，香肠瓜子方便面, 请让一让0002','2021-09-06 12:36:01','1'),
	('RS000003','大源社区小超','028 876543210003','吕刚0003','RSCC000001','RSCSC000002','RSC000001','RSII000001','RSF000001','RSD000001','RSO000001','RSC000001','2019-02-01','41.55528201734571','129.40595824469614','啤酒饮料矿泉水，香肠瓜子方便面, 请让一让0003','2021-09-09 03:31:43','1'),
	('RS000004','中和社区小超','028 876543210004','吕刚0004','RSCC000001','RSCSC000002','RSC000001','RSII000001','RSF000001','RSD000001','RSO000001','RSC000001','2021-01-14','42.376788132585894','129.8905263381243','啤酒饮料矿泉水，香肠瓜子方便面, 请让一让0004','2021-08-20 22:59:01','1'),
	('RS000005','华阳社区小超','028 876543210005','吕刚0005','RSCC000001','RSCSC000003','RSC000001','RSII000001','RSF000001','RSD000001','RSO000001','RSC000001','2020-06-05','39.8291349086611','129.39766702833433','啤酒饮料矿泉水，香肠瓜子方便面, 请让一让0005','2021-08-31 12:05:15','1'),
	('RS000006','大源社区小超','028 876543210006','吕刚0006','RSCC000001','RSCSC000003','RSC000001','RSII000001','RSF000001','RSD000001','RSO000001','RSC000001','2018-12-21','42.474942058293976','131.52806222220386','啤酒饮料矿泉水，香肠瓜子方便面, 请让一让0006','2021-08-25 01:24:00','1'),
	('RS000007','中和社区小超','028 876543210007','吕刚0007','RSCC000001','RSCSC000004','RSC000001','RSII000001','RSF000001','RSD000001','RSO000001','RSC000001','2021-05-14','40.39203887582838','131.34749742586365','啤酒饮料矿泉水，香肠瓜子方便面, 请让一让0007','2021-08-26 14:39:58','1'),
	('RS000008','华阳社区小超','028 876543210008','吕刚0008','RSCC000001','RSCSC000004','RSC000001','RSII000001','RSF000001','RSD000001','RSO000001','RSC000001','2021-06-09','41.88043856374909','131.78570707813105','啤酒饮料矿泉水，香肠瓜子方便面, 请让一让0008','2021-09-05 00:32:37','1');

insert into retail_store_creation_data values
	('RSC000001','已经建好了0001','1');

insert into retail_store_investment_invitation_data values
	('RSII000001','欢迎前来咨询0001','1');

insert into retail_store_franchising_data values
	('RSF000001','谢谢加盟0001','1');

insert into retail_store_decoration_data values
	('RSD000001','装修0001','1');

insert into retail_store_opening_data values
	('RSO000001','装修0001','1');

insert into retail_store_closing_data values
	('RSC000001','关闭0001','1');

insert into retail_store_member_data values
	('RSM000001','李亚青0001','18099887766','RSCC000001','1'),
	('RSM000002','李亚青0002','13900000002','RSCC000001','1');

insert into consumer_order_data values
	('CO000001','消费订单0001','RSM000001','RS000001','2021-09-09 06:33:09','1'),
	('CO000002','消费订单0002','RSM000001','RS000001','2021-09-10 10:38:55','1'),
	('CO000003','消费订单0003','RSM000001','RS000002','2021-09-03 05:45:43','1'),
	('CO000004','消费订单0004','RSM000001','RS000002','2021-08-23 10:30:22','1'),
	('CO000005','消费订单0005','RSM000001','RS000003','2021-09-04 20:54:07','1'),
	('CO000006','消费订单0006','RSM000001','RS000003','2021-09-03 01:57:02','1'),
	('CO000007','消费订单0007','RSM000001','RS000004','2021-09-03 02:46:10','1'),
	('CO000008','消费订单0008','RSM000001','RS000004','2021-09-02 06:46:00','1'),
	('CO000009','消费订单0009','RSM000002','RS000005','2021-09-08 09:45:18','1'),
	('CO000010','消费订单0010','RSM000002','RS000005','2021-08-29 15:02:23','1'),
	('CO000011','消费订单0011','RSM000002','RS000006','2021-08-29 17:08:23','1'),
	('CO000012','消费订单0012','RSM000002','RS000006','2021-08-24 13:13:42','1'),
	('CO000013','消费订单0013','RSM000002','RS000007','2021-08-23 00:25:38','1'),
	('CO000014','消费订单0014','RSM000002','RS000007','2021-08-21 15:56:04','1'),
	('CO000015','消费订单0015','RSM000002','RS000008','2021-08-30 05:34:56','1'),
	('CO000016','消费订单0016','RSM000002','RS000008','2021-08-20 07:57:54','1');

insert into consumer_order_line_item_data values
	('COLI000001','CO000001','SKU0001','大瓶可乐0001','4.52','758.39','9631.55','2021-08-24 01:32:39','1'),
	('COLI000002','CO000001','SKU0002','大瓶可乐0002','5.25','753.45','7124.65','2021-09-04 11:39:13','1'),
	('COLI000003','CO000002','SKU0003','大瓶可乐0003','5.77','739.53','8539.75','2021-09-05 15:45:11','1'),
	('COLI000004','CO000002','SKU0004','大瓶可乐0004','4.34','994.82','9776.23','2021-09-01 19:04:10','1'),
	('COLI000005','CO000003','SKU0005','大瓶可乐0005','4.29','742.87','7153.94','2021-08-28 19:09:51','1'),
	('COLI000006','CO000003','SKU0006','大瓶可乐0006','5.72','778.30','8721.71','2021-09-01 13:20:54','1'),
	('COLI000007','CO000004','SKU0007','大瓶可乐0007','5.39','789.25','9041.55','2021-09-02 21:23:07','1'),
	('COLI000008','CO000004','SKU0008','大瓶可乐0008','4.89','993.17','7214.44','2021-08-26 12:00:38','1'),
	('COLI000009','CO000005','SKU0009','大瓶可乐0009','5.21','980.96','9547.76','2021-09-06 16:37:04','1'),
	('COLI000010','CO000005','SKU0010','大瓶可乐0010','4.62','920.83','9929.36','2021-08-26 02:59:58','1'),
	('COLI000011','CO000006','SKU0011','大瓶可乐0011','5.30','807.50','8669.44','2021-09-05 04:41:51','1'),
	('COLI000012','CO000006','SKU0012','大瓶可乐0012','4.21','955.24','7299.10','2021-09-03 22:06:41','1'),
	('COLI000013','CO000007','SKU0013','大瓶可乐0013','5.03','823.77','7573.19','2021-09-07 11:37:30','1'),
	('COLI000014','CO000007','SKU0014','大瓶可乐0014','5.81','834.98','8714.92','2021-09-06 07:27:36','1'),
	('COLI000015','CO000008','SKU0015','大瓶可乐0015','5.89','985.39','8761.41','2021-09-02 11:19:23','1'),
	('COLI000016','CO000008','SKU0016','大瓶可乐0016','4.40','984.30','7721.36','2021-09-05 21:12:47','1'),
	('COLI000017','CO000009','SKU0017','大瓶可乐0017','5.52','950.94','9140.30','2021-09-01 12:09:50','1'),
	('COLI000018','CO000009','SKU0018','大瓶可乐0018','4.61','985.18','7583.57','2021-08-28 17:02:42','1'),
	('COLI000019','CO000010','SKU0019','大瓶可乐0019','5.87','985.80','7493.66','2021-08-20 14:24:21','1'),
	('COLI000020','CO000010','SKU0020','大瓶可乐0020','4.95','827.98','9856.03','2021-09-05 20:44:33','1'),
	('COLI000021','CO000011','SKU0021','大瓶可乐0021','5.25','827.49','8116.35','2021-08-26 19:16:47','1'),
	('COLI000022','CO000011','SKU0022','大瓶可乐0022','4.44','912.62','8831.87','2021-08-25 06:48:25','1'),
	('COLI000023','CO000012','SKU0023','大瓶可乐0023','4.75','997.18','7611.57','2021-08-26 01:04:00','1'),
	('COLI000024','CO000012','SKU0024','大瓶可乐0024','5.14','897.83','7001.38','2021-08-21 03:41:35','1'),
	('COLI000025','CO000013','SKU0025','大瓶可乐0025','5.30','767.17','8105.47','2021-08-25 07:18:27','1'),
	('COLI000026','CO000013','SKU0026','大瓶可乐0026','5.70','720.59','8898.84','2021-08-28 23:43:27','1'),
	('COLI000027','CO000014','SKU0027','大瓶可乐0027','5.15','719.08','9383.37','2021-09-04 11:41:01','1'),
	('COLI000028','CO000014','SKU0028','大瓶可乐0028','5.11','733.01','9966.54','2021-09-10 17:55:26','1'),
	('COLI000029','CO000015','SKU0029','大瓶可乐0029','5.28','952.54','9701.23','2021-08-30 00:18:42','1'),
	('COLI000030','CO000015','SKU0030','大瓶可乐0030','5.39','829.05','8314.71','2021-08-22 19:24:27','1'),
	('COLI000031','CO000016','SKU0031','大瓶可乐0031','5.01','929.21','8276.43','2021-09-09 10:47:24','1'),
	('COLI000032','CO000016','SKU0032','大瓶可乐0032','4.76','758.16','9506.62','2021-08-22 19:10:17','1');

insert into consumer_order_shipping_group_data values
	('COSG000001','送货到刘强家0001','CO000001','495.74','1'),
	('COSG000002','送货到刘强家0002','CO000001','516.99','1'),
	('COSG000003','送货到刘强家0003','CO000002','462.70','1'),
	('COSG000004','送货到刘强家0004','CO000002','424.55','1'),
	('COSG000005','送货到刘强家0005','CO000003','489.75','1'),
	('COSG000006','送货到刘强家0006','CO000003','448.95','1'),
	('COSG000007','送货到刘强家0007','CO000004','524.83','1'),
	('COSG000008','送货到刘强家0008','CO000004','506.07','1'),
	('COSG000009','送货到刘强家0009','CO000005','580.39','1'),
	('COSG000010','送货到刘强家0010','CO000005','529.33','1'),
	('COSG000011','送货到刘强家0011','CO000006','471.37','1'),
	('COSG000012','送货到刘强家0012','CO000006','551.93','1'),
	('COSG000013','送货到刘强家0013','CO000007','490.94','1'),
	('COSG000014','送货到刘强家0014','CO000007','531.18','1'),
	('COSG000015','送货到刘强家0015','CO000008','546.32','1'),
	('COSG000016','送货到刘强家0016','CO000008','572.00','1'),
	('COSG000017','送货到刘强家0017','CO000009','521.58','1'),
	('COSG000018','送货到刘强家0018','CO000009','450.81','1'),
	('COSG000019','送货到刘强家0019','CO000010','531.43','1'),
	('COSG000020','送货到刘强家0020','CO000010','565.53','1'),
	('COSG000021','送货到刘强家0021','CO000011','507.91','1'),
	('COSG000022','送货到刘强家0022','CO000011','552.95','1'),
	('COSG000023','送货到刘强家0023','CO000012','458.77','1'),
	('COSG000024','送货到刘强家0024','CO000012','518.53','1'),
	('COSG000025','送货到刘强家0025','CO000013','513.09','1'),
	('COSG000026','送货到刘强家0026','CO000013','594.10','1'),
	('COSG000027','送货到刘强家0027','CO000014','444.46','1'),
	('COSG000028','送货到刘强家0028','CO000014','450.13','1'),
	('COSG000029','送货到刘强家0029','CO000015','429.19','1'),
	('COSG000030','送货到刘强家0030','CO000015','546.06','1'),
	('COSG000031','送货到刘强家0031','CO000016','576.35','1'),
	('COSG000032','送货到刘强家0032','CO000016','555.92','1');

insert into consumer_order_payment_group_data values
	('COPG000001','信用卡','CO000001','4111 1111 1111 - 0001','1'),
	('COPG000002','支付宝','CO000001','4111 1111 1111 - 0002','1'),
	('COPG000003','微信支付','CO000002','4111 1111 1111 - 0003','1'),
	('COPG000004','信用卡','CO000002','4111 1111 1111 - 0004','1'),
	('COPG000005','支付宝','CO000003','4111 1111 1111 - 0005','1'),
	('COPG000006','微信支付','CO000003','4111 1111 1111 - 0006','1'),
	('COPG000007','信用卡','CO000004','4111 1111 1111 - 0007','1'),
	('COPG000008','支付宝','CO000004','4111 1111 1111 - 0008','1'),
	('COPG000009','微信支付','CO000005','4111 1111 1111 - 0009','1'),
	('COPG000010','信用卡','CO000005','4111 1111 1111 - 0010','1'),
	('COPG000011','支付宝','CO000006','4111 1111 1111 - 0011','1'),
	('COPG000012','微信支付','CO000006','4111 1111 1111 - 0012','1'),
	('COPG000013','信用卡','CO000007','4111 1111 1111 - 0013','1'),
	('COPG000014','支付宝','CO000007','4111 1111 1111 - 0014','1'),
	('COPG000015','微信支付','CO000008','4111 1111 1111 - 0015','1'),
	('COPG000016','信用卡','CO000008','4111 1111 1111 - 0016','1'),
	('COPG000017','支付宝','CO000009','4111 1111 1111 - 0017','1'),
	('COPG000018','微信支付','CO000009','4111 1111 1111 - 0018','1'),
	('COPG000019','信用卡','CO000010','4111 1111 1111 - 0019','1'),
	('COPG000020','支付宝','CO000010','4111 1111 1111 - 0020','1'),
	('COPG000021','微信支付','CO000011','4111 1111 1111 - 0021','1'),
	('COPG000022','信用卡','CO000011','4111 1111 1111 - 0022','1'),
	('COPG000023','支付宝','CO000012','4111 1111 1111 - 0023','1'),
	('COPG000024','微信支付','CO000012','4111 1111 1111 - 0024','1'),
	('COPG000025','信用卡','CO000013','4111 1111 1111 - 0025','1'),
	('COPG000026','支付宝','CO000013','4111 1111 1111 - 0026','1'),
	('COPG000027','微信支付','CO000014','4111 1111 1111 - 0027','1'),
	('COPG000028','信用卡','CO000014','4111 1111 1111 - 0028','1'),
	('COPG000029','支付宝','CO000015','4111 1111 1111 - 0029','1'),
	('COPG000030','微信支付','CO000015','4111 1111 1111 - 0030','1'),
	('COPG000031','信用卡','CO000016','4111 1111 1111 - 0031','1'),
	('COPG000032','支付宝','CO000016','4111 1111 1111 - 0032','1');

insert into consumer_order_price_adjustment_data values
	('COPA000001','端午促销0001','CO000001','583.18','供货商','1'),
	('COPA000002','端午促销0002','CO000001','508.38','小超老板','1'),
	('COPA000003','端午促销0003','CO000002','506.47','广告赞助','1'),
	('COPA000004','端午促销0004','CO000002','539.80','供货商','1'),
	('COPA000005','端午促销0005','CO000003','434.46','小超老板','1'),
	('COPA000006','端午促销0006','CO000003','532.46','广告赞助','1'),
	('COPA000007','端午促销0007','CO000004','599.07','供货商','1'),
	('COPA000008','端午促销0008','CO000004','424.84','小超老板','1'),
	('COPA000009','端午促销0009','CO000005','554.07','广告赞助','1'),
	('COPA000010','端午促销0010','CO000005','440.66','供货商','1'),
	('COPA000011','端午促销0011','CO000006','466.82','小超老板','1'),
	('COPA000012','端午促销0012','CO000006','430.99','广告赞助','1'),
	('COPA000013','端午促销0013','CO000007','450.89','供货商','1'),
	('COPA000014','端午促销0014','CO000007','451.20','小超老板','1'),
	('COPA000015','端午促销0015','CO000008','431.30','广告赞助','1'),
	('COPA000016','端午促销0016','CO000008','560.33','供货商','1'),
	('COPA000017','端午促销0017','CO000009','597.48','小超老板','1'),
	('COPA000018','端午促销0018','CO000009','474.32','广告赞助','1'),
	('COPA000019','端午促销0019','CO000010','509.55','供货商','1'),
	('COPA000020','端午促销0020','CO000010','541.59','小超老板','1'),
	('COPA000021','端午促销0021','CO000011','546.86','广告赞助','1'),
	('COPA000022','端午促销0022','CO000011','486.22','供货商','1'),
	('COPA000023','端午促销0023','CO000012','455.89','小超老板','1'),
	('COPA000024','端午促销0024','CO000012','452.15','广告赞助','1'),
	('COPA000025','端午促销0025','CO000013','582.53','供货商','1'),
	('COPA000026','端午促销0026','CO000013','575.67','小超老板','1'),
	('COPA000027','端午促销0027','CO000014','597.25','广告赞助','1'),
	('COPA000028','端午促销0028','CO000014','580.66','供货商','1'),
	('COPA000029','端午促销0029','CO000015','526.92','小超老板','1'),
	('COPA000030','端午促销0030','CO000015','593.18','广告赞助','1'),
	('COPA000031','端午促销0031','CO000016','551.73','供货商','1'),
	('COPA000032','端午促销0032','CO000016','593.69','小超老板','1');

insert into retail_store_member_coupon_data values
	('RSMC000001','优惠券0001','RSM000001','CP000010001','2021-08-31 03:42:57','1'),
	('RSMC000002','优惠券0002','RSM000001','CP000010002','2021-08-20 13:54:46','1'),
	('RSMC000003','优惠券0003','RSM000002','CP000010003','2021-08-20 18:21:29','1'),
	('RSMC000004','优惠券0004','RSM000002','CP000010004','2021-09-02 11:51:58','1');

insert into member_wishlist_data values
	('MW000001','每周购买清单','RSM000001','1'),
	('MW000002','每月购买清单','RSM000001','1'),
	('MW000003','每周购买清单','RSM000002','1'),
	('MW000004','每月购买清单','RSM000002','1');

insert into member_reward_point_data values
	('MRP000001','购买积分','19','RSM000001','1'),
	('MRP000002','每月购买清单','17','RSM000001','1'),
	('MRP000003','购买积分','18','RSM000002','1'),
	('MRP000004','每月购买清单','17','RSM000002','1');

insert into member_reward_point_redemption_data values
	('MRPR000001','积分换锅','17','RSM000001','1'),
	('MRPR000002','积分换刀','16','RSM000001','1'),
	('MRPR000003','积分换锅','16','RSM000002','1'),
	('MRPR000004','积分换刀','19','RSM000002','1');

insert into member_wishlist_product_data values
	('MWP000001','农夫山泉','MW000001','1'),
	('MWP000002','利箭口香糖','MW000001','1'),
	('MWP000003','农夫山泉','MW000002','1'),
	('MWP000004','利箭口香糖','MW000002','1'),
	('MWP000005','农夫山泉','MW000003','1'),
	('MWP000006','利箭口香糖','MW000003','1'),
	('MWP000007','农夫山泉','MW000004','1'),
	('MWP000008','利箭口香糖','MW000004','1');

insert into retail_store_member_address_data values
	('RSMA000001','家里','RSM000001','18099887766','四川省成都市科学城北路33号0001','1'),
	('RSMA000002','办公室','RSM000001','13900000002','四川省成都市科学城北路33号0002','1'),
	('RSMA000003','出差临时地址','RSM000002','13900000003','四川省成都市科学城北路33号0003','1'),
	('RSMA000004','家里','RSM000002','13900000004','四川省成都市科学城北路33号0004','1');

insert into retail_store_member_gift_card_data values
	('RSMGC000001','礼品卡0001','RSM000001','CP000010001','201.20','1'),
	('RSMGC000002','礼品卡0002','RSM000001','CP000010002','178.57','1'),
	('RSMGC000003','礼品卡0003','RSM000002','CP000010003','199.16','1'),
	('RSMGC000004','礼品卡0004','RSM000002','CP000010004','207.74','1');

insert into retail_store_member_gift_card_consume_record_data values
	('RSMGCCR000001','2020-09-03','RSMGC000001','CO000001','GF000010001','19.65','1'),
	('RSMGCCR000002','2018-10-14','RSMGC000001','CO000001','GF000010002','17.74','1'),
	('RSMGCCR000003','2019-11-19','RSMGC000001','CO000002','GF000010003','16.51','1'),
	('RSMGCCR000004','2021-03-01','RSMGC000001','CO000002','GF000010004','17.53','1'),
	('RSMGCCR000005','2018-11-24','RSMGC000001','CO000003','GF000010005','16.34','1'),
	('RSMGCCR000006','2018-12-15','RSMGC000001','CO000003','GF000010006','20.72','1'),
	('RSMGCCR000007','2020-08-12','RSMGC000001','CO000004','GF000010007','19.17','1'),
	('RSMGCCR000008','2021-02-18','RSMGC000001','CO000004','GF000010008','15.16','1'),
	('RSMGCCR000009','2018-10-12','RSMGC000002','CO000005','GF000010009','19.10','1'),
	('RSMGCCR000010','2018-10-29','RSMGC000002','CO000005','GF000010010','18.52','1'),
	('RSMGCCR000011','2018-10-02','RSMGC000002','CO000006','GF000010011','15.69','1'),
	('RSMGCCR000012','2020-06-10','RSMGC000002','CO000006','GF000010012','20.28','1'),
	('RSMGCCR000013','2020-06-17','RSMGC000002','CO000007','GF000010013','18.11','1'),
	('RSMGCCR000014','2019-07-06','RSMGC000002','CO000007','GF000010014','19.28','1'),
	('RSMGCCR000015','2019-10-20','RSMGC000002','CO000008','GF000010015','16.28','1'),
	('RSMGCCR000016','2020-12-24','RSMGC000002','CO000008','GF000010016','16.97','1'),
	('RSMGCCR000017','2021-03-02','RSMGC000003','CO000009','GF000010017','20.23','1'),
	('RSMGCCR000018','2021-08-15','RSMGC000003','CO000009','GF000010018','18.30','1'),
	('RSMGCCR000019','2020-07-26','RSMGC000003','CO000010','GF000010019','15.25','1'),
	('RSMGCCR000020','2019-10-07','RSMGC000003','CO000010','GF000010020','14.89','1'),
	('RSMGCCR000021','2021-03-11','RSMGC000003','CO000011','GF000010021','16.11','1'),
	('RSMGCCR000022','2020-05-26','RSMGC000003','CO000011','GF000010022','17.63','1'),
	('RSMGCCR000023','2021-01-07','RSMGC000003','CO000012','GF000010023','19.06','1'),
	('RSMGCCR000024','2020-03-20','RSMGC000003','CO000012','GF000010024','16.17','1'),
	('RSMGCCR000025','2021-04-21','RSMGC000004','CO000013','GF000010025','18.83','1'),
	('RSMGCCR000026','2019-10-28','RSMGC000004','CO000013','GF000010026','19.32','1'),
	('RSMGCCR000027','2019-08-10','RSMGC000004','CO000014','GF000010027','19.00','1'),
	('RSMGCCR000028','2018-12-24','RSMGC000004','CO000014','GF000010028','15.60','1'),
	('RSMGCCR000029','2019-01-29','RSMGC000004','CO000015','GF000010029','19.20','1'),
	('RSMGCCR000030','2020-03-14','RSMGC000004','CO000015','GF000010030','15.28','1'),
	('RSMGCCR000031','2019-06-26','RSMGC000004','CO000016','GF000010031','20.81','1'),
	('RSMGCCR000032','2020-08-19','RSMGC000004','CO000016','GF000010032','15.30','1');

insert into goods_supplier_data values
	('GS000001','宝洁','洗护用品','RSCC000001','18677889999','啤酒饮料矿泉水，香肠瓜子方便面都提供0001','2021-09-09 17:19:23','1'),
	('GS000002','中粮','食品','RSCC000001','13900000002','啤酒饮料矿泉水，香肠瓜子方便面都提供0002','2021-09-03 22:55:09','1');

insert into supplier_product_data values
	('SP000001','黑人牙膏0001','最好的黑人牙膏，只卖3块喽0001','件','GS000001','1'),
	('SP000002','黑人牙膏0002','最好的黑人牙膏，只卖3块喽0002','公斤','GS000001','1'),
	('SP000003','黑人牙膏0003','最好的黑人牙膏，只卖3块喽0003','米','GS000002','1'),
	('SP000004','黑人牙膏0004','最好的黑人牙膏，只卖3块喽0004','件','GS000002','1');

insert into product_supply_duration_data values
	('PSD000001','100','现货','7125.10','SP000001','1'),
	('PSD000002','200','两天','9581.33','SP000001','1'),
	('PSD000003','500','三天','8900.52','SP000002','1'),
	('PSD000004','100','一周','7287.46','SP000002','1'),
	('PSD000005','200','现货','9224.70','SP000003','1'),
	('PSD000006','500','两天','9993.14','SP000003','1'),
	('PSD000007','100','三天','8556.89','SP000004','1'),
	('PSD000008','200','一周','8666.37','SP000004','1');

insert into supply_order_data values
	('SO000001','RSCC000001','GS000001','双链给供货商下的订单0001','2677915648.00','2021-09-07 00:01:46','1'),
	('SO000002','RSCC000001','GS000001','双链给供货商下的订单0002','2308019968.00','2021-08-31 03:20:11','1'),
	('SO000003','RSCC000001','GS000002','双链给供货商下的订单0003','2577176832.00','2021-09-04 07:32:16','1'),
	('SO000004','RSCC000001','GS000002','双链给供货商下的订单0004','2975128320.00','2021-09-05 23:42:46','1');

insert into supply_order_line_item_data values
	('SOLI000001','SO000001','SKU0001','大瓶可乐0001','4.57','7131','件','1'),
	('SOLI000002','SO000001','SKU0002','大瓶可乐0002','5.26','9235','公斤','1'),
	('SOLI000003','SO000002','SKU0003','大瓶可乐0003','5.39','9389','米','1'),
	('SOLI000004','SO000002','SKU0004','大瓶可乐0004','4.79','7899','件','1'),
	('SOLI000005','SO000003','SKU0005','大瓶可乐0005','4.82','9774','公斤','1'),
	('SOLI000006','SO000003','SKU0006','大瓶可乐0006','5.96','9289','米','1'),
	('SOLI000007','SO000004','SKU0007','大瓶可乐0007','5.90','7972','件','1'),
	('SOLI000008','SO000004','SKU0008','大瓶可乐0008','4.52','9524','公斤','1');

insert into supply_order_shipping_group_data values
	('SOSG000001','送货到双链成都2号仓0001','SO000001','4.88','1'),
	('SOSG000002','送货到双链成都2号仓0002','SO000001','4.50','1'),
	('SOSG000003','送货到双链成都2号仓0003','SO000002','5.40','1'),
	('SOSG000004','送货到双链成都2号仓0004','SO000002','4.66','1'),
	('SOSG000005','送货到双链成都2号仓0005','SO000003','5.88','1'),
	('SOSG000006','送货到双链成都2号仓0006','SO000003','4.20','1'),
	('SOSG000007','送货到双链成都2号仓0007','SO000004','4.39','1'),
	('SOSG000008','送货到双链成都2号仓0008','SO000004','4.21','1');

insert into supply_order_payment_group_data values
	('SOPG000001','付款办法0001','SO000001','4111 1111 1111 - 0001','1'),
	('SOPG000002','付款办法0002','SO000001','4111 1111 1111 - 0002','1'),
	('SOPG000003','付款办法0003','SO000002','4111 1111 1111 - 0003','1'),
	('SOPG000004','付款办法0004','SO000002','4111 1111 1111 - 0004','1'),
	('SOPG000005','付款办法0005','SO000003','4111 1111 1111 - 0005','1'),
	('SOPG000006','付款办法0006','SO000003','4111 1111 1111 - 0006','1'),
	('SOPG000007','付款办法0007','SO000004','4111 1111 1111 - 0007','1'),
	('SOPG000008','付款办法0008','SO000004','4111 1111 1111 - 0008','1');

insert into retail_store_order_data values
	('RSO000001','RS000001','RSCC000001','双链小超给双链供应链下的订单0001','2119792000.00','2021-08-30 18:26:05','1'),
	('RSO000002','RS000001','RSCC000001','双链小超给双链供应链下的订单0002','2133446528.00','2021-09-09 10:47:38','1'),
	('RSO000003','RS000002','RSCC000001','双链小超给双链供应链下的订单0003','2701961472.00','2021-08-27 10:54:42','1'),
	('RSO000004','RS000002','RSCC000001','双链小超给双链供应链下的订单0004','2817712896.00','2021-09-08 22:09:45','1'),
	('RSO000005','RS000003','RSCC000001','双链小超给双链供应链下的订单0005','2137230848.00','2021-09-01 15:27:11','1'),
	('RSO000006','RS000003','RSCC000001','双链小超给双链供应链下的订单0006','2139341696.00','2021-09-07 02:43:04','1'),
	('RSO000007','RS000004','RSCC000001','双链小超给双链供应链下的订单0007','2870716160.00','2021-08-28 21:49:32','1'),
	('RSO000008','RS000004','RSCC000001','双链小超给双链供应链下的订单0008','2406651136.00','2021-08-23 06:36:08','1'),
	('RSO000009','RS000005','RSCC000001','双链小超给双链供应链下的订单0009','2200730624.00','2021-09-08 13:56:28','1'),
	('RSO000010','RS000005','RSCC000001','双链小超给双链供应链下的订单0010','2901279744.00','2021-08-30 23:57:23','1'),
	('RSO000011','RS000006','RSCC000001','双链小超给双链供应链下的订单0011','2193538304.00','2021-08-24 18:37:28','1'),
	('RSO000012','RS000006','RSCC000001','双链小超给双链供应链下的订单0012','2919656192.00','2021-08-30 10:48:18','1'),
	('RSO000013','RS000007','RSCC000001','双链小超给双链供应链下的订单0013','2761602816.00','2021-09-03 23:04:00','1'),
	('RSO000014','RS000007','RSCC000001','双链小超给双链供应链下的订单0014','2539726336.00','2021-08-24 14:07:13','1'),
	('RSO000015','RS000008','RSCC000001','双链小超给双链供应链下的订单0015','2518963200.00','2021-09-06 07:33:11','1'),
	('RSO000016','RS000008','RSCC000001','双链小超给双链供应链下的订单0016','2879838976.00','2021-09-04 21:01:59','1');

insert into retail_store_order_line_item_data values
	('RSOLI000001','RSO000001','SKU0001','大瓶可乐0001','3.90','7963','件','1'),
	('RSOLI000002','RSO000001','SKU0002','大瓶可乐0002','2.92','7303','公斤','1'),
	('RSOLI000003','RSO000002','SKU0003','大瓶可乐0003','3.24','9630','米','1'),
	('RSOLI000004','RSO000002','SKU0004','大瓶可乐0004','3.95','9775','件','1'),
	('RSOLI000005','RSO000003','SKU0005','大瓶可乐0005','2.99','9421','公斤','1'),
	('RSOLI000006','RSO000003','SKU0006','大瓶可乐0006','3.20','9620','米','1'),
	('RSOLI000007','RSO000004','SKU0007','大瓶可乐0007','3.75','9291','件','1'),
	('RSOLI000008','RSO000004','SKU0008','大瓶可乐0008','3.14','8053','公斤','1'),
	('RSOLI000009','RSO000005','SKU0009','大瓶可乐0009','3.40','8061','米','1'),
	('RSOLI000010','RSO000005','SKU0010','大瓶可乐0010','2.92','8283','件','1'),
	('RSOLI000011','RSO000006','SKU0011','大瓶可乐0011','2.83','9081','公斤','1'),
	('RSOLI000012','RSO000006','SKU0012','大瓶可乐0012','3.72','9202','米','1'),
	('RSOLI000013','RSO000007','SKU0013','大瓶可乐0013','3.00','9767','件','1'),
	('RSOLI000014','RSO000007','SKU0014','大瓶可乐0014','3.40','8487','公斤','1'),
	('RSOLI000015','RSO000008','SKU0015','大瓶可乐0015','3.36','9831','米','1'),
	('RSOLI000016','RSO000008','SKU0016','大瓶可乐0016','3.84','9014','件','1'),
	('RSOLI000017','RSO000009','SKU0017','大瓶可乐0017','3.91','8336','公斤','1'),
	('RSOLI000018','RSO000009','SKU0018','大瓶可乐0018','3.62','7190','米','1'),
	('RSOLI000019','RSO000010','SKU0019','大瓶可乐0019','3.55','7157','件','1'),
	('RSOLI000020','RSO000010','SKU0020','大瓶可乐0020','3.41','9376','公斤','1'),
	('RSOLI000021','RSO000011','SKU0021','大瓶可乐0021','3.90','8267','米','1'),
	('RSOLI000022','RSO000011','SKU0022','大瓶可乐0022','3.93','8877','件','1'),
	('RSOLI000023','RSO000012','SKU0023','大瓶可乐0023','3.68','7335','公斤','1'),
	('RSOLI000024','RSO000012','SKU0024','大瓶可乐0024','3.09','8053','米','1'),
	('RSOLI000025','RSO000013','SKU0025','大瓶可乐0025','3.88','7476','件','1'),
	('RSOLI000026','RSO000013','SKU0026','大瓶可乐0026','3.84','9014','公斤','1'),
	('RSOLI000027','RSO000014','SKU0027','大瓶可乐0027','3.93','8646','米','1'),
	('RSOLI000028','RSO000014','SKU0028','大瓶可乐0028','3.47','9991','件','1'),
	('RSOLI000029','RSO000015','SKU0029','大瓶可乐0029','2.87','7096','公斤','1'),
	('RSOLI000030','RSO000015','SKU0030','大瓶可乐0030','3.01','9916','米','1'),
	('RSOLI000031','RSO000016','SKU0031','大瓶可乐0031','2.84','7483','件','1'),
	('RSOLI000032','RSO000016','SKU0032','大瓶可乐0032','3.43','8993','公斤','1');

insert into retail_store_order_shipping_group_data values
	('RSOSG000001','送货到双链中和社区店0001','RSO000001','5.62','1'),
	('RSOSG000002','送货到双链中和社区店0002','RSO000001','5.85','1'),
	('RSOSG000003','送货到双链中和社区店0003','RSO000002','5.10','1'),
	('RSOSG000004','送货到双链中和社区店0004','RSO000002','5.99','1'),
	('RSOSG000005','送货到双链中和社区店0005','RSO000003','5.99','1'),
	('RSOSG000006','送货到双链中和社区店0006','RSO000003','5.84','1'),
	('RSOSG000007','送货到双链中和社区店0007','RSO000004','4.83','1'),
	('RSOSG000008','送货到双链中和社区店0008','RSO000004','4.70','1'),
	('RSOSG000009','送货到双链中和社区店0009','RSO000005','4.36','1'),
	('RSOSG000010','送货到双链中和社区店0010','RSO000005','5.45','1'),
	('RSOSG000011','送货到双链中和社区店0011','RSO000006','4.80','1'),
	('RSOSG000012','送货到双链中和社区店0012','RSO000006','5.17','1'),
	('RSOSG000013','送货到双链中和社区店0013','RSO000007','5.98','1'),
	('RSOSG000014','送货到双链中和社区店0014','RSO000007','5.58','1'),
	('RSOSG000015','送货到双链中和社区店0015','RSO000008','4.88','1'),
	('RSOSG000016','送货到双链中和社区店0016','RSO000008','5.58','1'),
	('RSOSG000017','送货到双链中和社区店0017','RSO000009','5.41','1'),
	('RSOSG000018','送货到双链中和社区店0018','RSO000009','4.89','1'),
	('RSOSG000019','送货到双链中和社区店0019','RSO000010','4.20','1'),
	('RSOSG000020','送货到双链中和社区店0020','RSO000010','4.84','1'),
	('RSOSG000021','送货到双链中和社区店0021','RSO000011','5.11','1'),
	('RSOSG000022','送货到双链中和社区店0022','RSO000011','5.17','1'),
	('RSOSG000023','送货到双链中和社区店0023','RSO000012','5.75','1'),
	('RSOSG000024','送货到双链中和社区店0024','RSO000012','5.04','1'),
	('RSOSG000025','送货到双链中和社区店0025','RSO000013','5.25','1'),
	('RSOSG000026','送货到双链中和社区店0026','RSO000013','4.92','1'),
	('RSOSG000027','送货到双链中和社区店0027','RSO000014','4.45','1'),
	('RSOSG000028','送货到双链中和社区店0028','RSO000014','4.97','1'),
	('RSOSG000029','送货到双链中和社区店0029','RSO000015','5.55','1'),
	('RSOSG000030','送货到双链中和社区店0030','RSO000015','5.23','1'),
	('RSOSG000031','送货到双链中和社区店0031','RSO000016','4.78','1'),
	('RSOSG000032','送货到双链中和社区店0032','RSO000016','4.27','1');

insert into retail_store_order_payment_group_data values
	('RSOPG000001','付款办法0001','RSO000001','4111 1111 1111 - 0001','1'),
	('RSOPG000002','付款办法0002','RSO000001','4111 1111 1111 - 0002','1'),
	('RSOPG000003','付款办法0003','RSO000002','4111 1111 1111 - 0003','1'),
	('RSOPG000004','付款办法0004','RSO000002','4111 1111 1111 - 0004','1'),
	('RSOPG000005','付款办法0005','RSO000003','4111 1111 1111 - 0005','1'),
	('RSOPG000006','付款办法0006','RSO000003','4111 1111 1111 - 0006','1'),
	('RSOPG000007','付款办法0007','RSO000004','4111 1111 1111 - 0007','1'),
	('RSOPG000008','付款办法0008','RSO000004','4111 1111 1111 - 0008','1'),
	('RSOPG000009','付款办法0009','RSO000005','4111 1111 1111 - 0009','1'),
	('RSOPG000010','付款办法0010','RSO000005','4111 1111 1111 - 0010','1'),
	('RSOPG000011','付款办法0011','RSO000006','4111 1111 1111 - 0011','1'),
	('RSOPG000012','付款办法0012','RSO000006','4111 1111 1111 - 0012','1'),
	('RSOPG000013','付款办法0013','RSO000007','4111 1111 1111 - 0013','1'),
	('RSOPG000014','付款办法0014','RSO000007','4111 1111 1111 - 0014','1'),
	('RSOPG000015','付款办法0015','RSO000008','4111 1111 1111 - 0015','1'),
	('RSOPG000016','付款办法0016','RSO000008','4111 1111 1111 - 0016','1'),
	('RSOPG000017','付款办法0017','RSO000009','4111 1111 1111 - 0017','1'),
	('RSOPG000018','付款办法0018','RSO000009','4111 1111 1111 - 0018','1'),
	('RSOPG000019','付款办法0019','RSO000010','4111 1111 1111 - 0019','1'),
	('RSOPG000020','付款办法0020','RSO000010','4111 1111 1111 - 0020','1'),
	('RSOPG000021','付款办法0021','RSO000011','4111 1111 1111 - 0021','1'),
	('RSOPG000022','付款办法0022','RSO000011','4111 1111 1111 - 0022','1'),
	('RSOPG000023','付款办法0023','RSO000012','4111 1111 1111 - 0023','1'),
	('RSOPG000024','付款办法0024','RSO000012','4111 1111 1111 - 0024','1'),
	('RSOPG000025','付款办法0025','RSO000013','4111 1111 1111 - 0025','1'),
	('RSOPG000026','付款办法0026','RSO000013','4111 1111 1111 - 0026','1'),
	('RSOPG000027','付款办法0027','RSO000014','4111 1111 1111 - 0027','1'),
	('RSOPG000028','付款办法0028','RSO000014','4111 1111 1111 - 0028','1'),
	('RSOPG000029','付款办法0029','RSO000015','4111 1111 1111 - 0029','1'),
	('RSOPG000030','付款办法0030','RSO000015','4111 1111 1111 - 0030','1'),
	('RSOPG000031','付款办法0031','RSO000016','4111 1111 1111 - 0031','1'),
	('RSOPG000032','付款办法0032','RSO000016','4111 1111 1111 - 0032','1');

insert into warehouse_data values
	('W000001','成都龙泉驿飞鹤路20号0001','028 876543210001','187672平方米0001','RSCC000001','42.19793081232463','132.13711090711413','2021-09-08 06:17:11','1'),
	('W000002','成都龙泉驿飞鹤路20号0002','028 876543210002','187672平方米0002','RSCC000001','42.43539147013738','130.83465146311167','2021-08-26 11:52:47','1');

insert into storage_space_data values
	('SS000001','成都龙泉驿飞鹤路20号存货区0001','028 876543210001','1876平方米0001','W000001','41.79844321498717','130.916887508878','2021-08-23 23:47:58','1'),
	('SS000002','成都龙泉驿飞鹤路20号存货区0002','028 876543210002','1876平方米0002','W000001','42.76226918306165','130.631962358778','2021-09-03 07:47:35','1'),
	('SS000003','成都龙泉驿飞鹤路20号存货区0003','028 876543210003','1876平方米0003','W000002','42.72707523564266','129.9419828267251','2021-09-07 19:33:35','1'),
	('SS000004','成都龙泉驿飞鹤路20号存货区0004','028 876543210004','1876平方米0004','W000002','41.222629620833395','131.5317405805992','2021-08-26 16:56:59','1');

insert into smart_pallet_data values
	('SP000001','成都龙泉驿飞鹤路20号移动区域，比如过道，货运通道等0001','028 876543210001','1876平方米0001','40.76272881074425','130.46603089477492','W000001','2021-09-10 13:44:02','1'),
	('SP000002','成都龙泉驿飞鹤路20号移动区域，比如过道，货运通道等0002','028 876543210002','1876平方米0002','40.2119055796515','130.79920766864254','W000001','2021-09-05 03:58:23','1'),
	('SP000003','成都龙泉驿飞鹤路20号移动区域，比如过道，货运通道等0003','028 876543210003','1876平方米0003','42.57090212148474','130.40714670371867','W000002','2021-09-05 14:19:34','1'),
	('SP000004','成都龙泉驿飞鹤路20号移动区域，比如过道，货运通道等0004','028 876543210004','1876平方米0004','41.74389742678266','131.7011811205818','W000002','2021-08-28 04:05:16','1');

insert into goods_shelf_data values
	('GS000001','成都龙泉驿飞鹤路20号存货区货架0001','SS000001','SS000001','DS000001','2021-08-31 23:31:06','1'),
	('GS000002','成都龙泉驿飞鹤路20号存货区货架0002','SS000001','SS000001','DS000001','2021-08-21 14:58:41','1'),
	('GS000003','成都龙泉驿飞鹤路20号存货区货架0003','SS000002','SS000002','DS000002','2021-09-02 14:34:16','1'),
	('GS000004','成都龙泉驿飞鹤路20号存货区货架0004','SS000002','SS000002','DS000002','2021-09-08 06:38:22','1'),
	('GS000005','成都龙泉驿飞鹤路20号存货区货架0005','SS000003','SS000003','DS000003','2021-09-05 04:45:03','1'),
	('GS000006','成都龙泉驿飞鹤路20号存货区货架0006','SS000003','SS000003','DS000003','2021-09-08 20:15:37','1'),
	('GS000007','成都龙泉驿飞鹤路20号存货区货架0007','SS000004','SS000004','DS000004','2021-09-06 07:40:51','1'),
	('GS000008','成都龙泉驿飞鹤路20号存货区货架0008','SS000004','SS000004','DS000004','2021-08-25 06:48:55','1');

insert into goods_shelf_stock_count_data values
	('GSSC000001','每日盘点','2021-07-10','使用先进的rfid技术，没有任何错误0001','GS000001','1'),
	('GSSC000002','每周盘点','2020-04-27','使用先进的rfid技术，没有任何错误0002','GS000001','1'),
	('GSSC000003','每月盘点','2020-06-28','使用先进的rfid技术，没有任何错误0003','GS000002','1'),
	('GSSC000004','年终盘点','2021-06-09','使用先进的rfid技术，没有任何错误0004','GS000002','1'),
	('GSSC000005','每日盘点','2019-07-26','使用先进的rfid技术，没有任何错误0005','GS000003','1'),
	('GSSC000006','每周盘点','2020-08-23','使用先进的rfid技术，没有任何错误0006','GS000003','1'),
	('GSSC000007','每月盘点','2020-10-07','使用先进的rfid技术，没有任何错误0007','GS000004','1'),
	('GSSC000008','年终盘点','2020-08-07','使用先进的rfid技术，没有任何错误0008','GS000004','1'),
	('GSSC000009','每日盘点','2020-09-16','使用先进的rfid技术，没有任何错误0009','GS000005','1'),
	('GSSC000010','每周盘点','2019-03-12','使用先进的rfid技术，没有任何错误0010','GS000005','1'),
	('GSSC000011','每月盘点','2021-02-26','使用先进的rfid技术，没有任何错误0011','GS000006','1'),
	('GSSC000012','年终盘点','2019-09-28','使用先进的rfid技术，没有任何错误0012','GS000006','1'),
	('GSSC000013','每日盘点','2021-06-01','使用先进的rfid技术，没有任何错误0013','GS000007','1'),
	('GSSC000014','每周盘点','2021-03-13','使用先进的rfid技术，没有任何错误0014','GS000007','1'),
	('GSSC000015','每月盘点','2020-04-20','使用先进的rfid技术，没有任何错误0015','GS000008','1'),
	('GSSC000016','年终盘点','2019-11-28','使用先进的rfid技术，没有任何错误0016','GS000008','1');

insert into stock_count_issue_track_data values
	('SCIT000001','盘点差错0001','2019-06-29','发现错误已经修正完成0001','GSSC000001','1'),
	('SCIT000002','盘点差错0002','2020-05-27','发现错误已经修正完成0002','GSSC000001','1'),
	('SCIT000003','盘点差错0003','2021-04-11','发现错误已经修正完成0003','GSSC000002','1'),
	('SCIT000004','盘点差错0004','2018-12-27','发现错误已经修正完成0004','GSSC000002','1'),
	('SCIT000005','盘点差错0005','2020-08-09','发现错误已经修正完成0005','GSSC000003','1'),
	('SCIT000006','盘点差错0006','2019-03-17','发现错误已经修正完成0006','GSSC000003','1'),
	('SCIT000007','盘点差错0007','2021-04-29','发现错误已经修正完成0007','GSSC000004','1'),
	('SCIT000008','盘点差错0008','2021-05-28','发现错误已经修正完成0008','GSSC000004','1'),
	('SCIT000009','盘点差错0009','2021-01-10','发现错误已经修正完成0009','GSSC000005','1'),
	('SCIT000010','盘点差错0010','2020-05-17','发现错误已经修正完成0010','GSSC000005','1'),
	('SCIT000011','盘点差错0011','2020-08-31','发现错误已经修正完成0011','GSSC000006','1'),
	('SCIT000012','盘点差错0012','2018-10-17','发现错误已经修正完成0012','GSSC000006','1'),
	('SCIT000013','盘点差错0013','2019-08-12','发现错误已经修正完成0013','GSSC000007','1'),
	('SCIT000014','盘点差错0014','2021-04-07','发现错误已经修正完成0014','GSSC000007','1'),
	('SCIT000015','盘点差错0015','2019-06-09','发现错误已经修正完成0015','GSSC000008','1'),
	('SCIT000016','盘点差错0016','2018-12-22','发现错误已经修正完成0016','GSSC000008','1'),
	('SCIT000017','盘点差错0017','2020-04-30','发现错误已经修正完成0017','GSSC000009','1'),
	('SCIT000018','盘点差错0018','2018-10-01','发现错误已经修正完成0018','GSSC000009','1'),
	('SCIT000019','盘点差错0019','2019-06-12','发现错误已经修正完成0019','GSSC000010','1'),
	('SCIT000020','盘点差错0020','2020-11-06','发现错误已经修正完成0020','GSSC000010','1'),
	('SCIT000021','盘点差错0021','2021-05-31','发现错误已经修正完成0021','GSSC000011','1'),
	('SCIT000022','盘点差错0022','2020-12-07','发现错误已经修正完成0022','GSSC000011','1'),
	('SCIT000023','盘点差错0023','2018-12-31','发现错误已经修正完成0023','GSSC000012','1'),
	('SCIT000024','盘点差错0024','2021-08-25','发现错误已经修正完成0024','GSSC000012','1'),
	('SCIT000025','盘点差错0025','2019-04-26','发现错误已经修正完成0025','GSSC000013','1'),
	('SCIT000026','盘点差错0026','2020-07-16','发现错误已经修正完成0026','GSSC000013','1'),
	('SCIT000027','盘点差错0027','2019-08-03','发现错误已经修正完成0027','GSSC000014','1'),
	('SCIT000028','盘点差错0028','2019-08-31','发现错误已经修正完成0028','GSSC000014','1'),
	('SCIT000029','盘点差错0029','2019-05-09','发现错误已经修正完成0029','GSSC000015','1'),
	('SCIT000030','盘点差错0030','2018-12-07','发现错误已经修正完成0030','GSSC000015','1'),
	('SCIT000031','盘点差错0031','2020-10-11','发现错误已经修正完成0031','GSSC000016','1'),
	('SCIT000032','盘点差错0032','2019-12-16','发现错误已经修正完成0032','GSSC000016','1');

insert into goods_allocation_data values
	('GA000001','成都龙泉驿飞鹤路20号存货区货架20号货位0001','42.15725352861892','129.81332864578897','GS000001','1'),
	('GA000002','成都龙泉驿飞鹤路20号存货区货架20号货位0002','41.2148056012888','130.1939330129571','GS000001','1'),
	('GA000003','成都龙泉驿飞鹤路20号存货区货架20号货位0003','40.07056454193455','129.97292294376643','GS000002','1'),
	('GA000004','成都龙泉驿飞鹤路20号存货区货架20号货位0004','41.523470976663106','130.45066230263222','GS000002','1'),
	('GA000005','成都龙泉驿飞鹤路20号存货区货架20号货位0005','42.36583013256539','131.52402871984978','GS000003','1'),
	('GA000006','成都龙泉驿飞鹤路20号存货区货架20号货位0006','40.05237588129418','131.5644163813242','GS000003','1'),
	('GA000007','成都龙泉驿飞鹤路20号存货区货架20号货位0007','39.91484658247577','129.74100702787584','GS000004','1'),
	('GA000008','成都龙泉驿飞鹤路20号存货区货架20号货位0008','41.92367299538627','130.55338194244015','GS000004','1'),
	('GA000009','成都龙泉驿飞鹤路20号存货区货架20号货位0009','42.749136810611084','131.1106143206906','GS000005','1'),
	('GA000010','成都龙泉驿飞鹤路20号存货区货架20号货位0010','41.09917890555835','130.83710514745184','GS000005','1'),
	('GA000011','成都龙泉驿飞鹤路20号存货区货架20号货位0011','42.73550014349604','130.48512989076588','GS000006','1'),
	('GA000012','成都龙泉驿飞鹤路20号存货区货架20号货位0012','40.77867107865849','131.5112425092007','GS000006','1'),
	('GA000013','成都龙泉驿飞鹤路20号存货区货架20号货位0013','40.10098021262327','131.93361841114256','GS000007','1'),
	('GA000014','成都龙泉驿飞鹤路20号存货区货架20号货位0014','42.32642114025026','130.36974839887807','GS000007','1'),
	('GA000015','成都龙泉驿飞鹤路20号存货区货架20号货位0015','40.87362591291925','132.18265354941744','GS000008','1'),
	('GA000016','成都龙泉驿飞鹤路20号存货区货架20号货位0016','40.11216230115786','129.89736700634475','GS000008','1');

insert into goods_data values
	('G000001','可口可乐0001','RF991920001','件','9','2020-01-20','S000001','RS000001','GA000001','SP000001','SS000001','TT000001','RS000001','SO000001','RSO000001','1'),
	('G000002','可口可乐0002','RF991920002','箱','9','2018-09-15','S000001','RS000001','GA000001','SP000001','SS000001','TT000001','RS000001','SO000001','RSO000001','1'),
	('G000003','可口可乐0003','RF991920003','件','8','2019-08-27','S000002','RS000001','GA000001','SP000001','SS000001','TT000001','RS000001','SO000001','RSO000001','1'),
	('G000004','可口可乐0004','RF991920004','箱','10','2019-06-20','S000002','RS000001','GA000001','SP000001','SS000001','TT000001','RS000001','SO000001','RSO000001','1'),
	('G000005','可口可乐0005','RF991920005','件','10','2019-06-30','S000003','RS000001','GA000001','SP000001','SS000001','TT000001','RS000001','SO000001','RSO000001','1'),
	('G000006','可口可乐0006','RF991920006','箱','9','2020-07-26','S000004','RS000001','GA000001','SP000001','SS000001','TT000001','RS000001','SO000001','RSO000001','1'),
	('G000007','可口可乐0007','RF991920007','件','10','2019-08-23','S000004','RS000001','GA000001','SP000001','SS000001','TT000001','RS000001','SO000001','RSO000001','1'),
	('G000008','可口可乐0008','RF991920008','箱','9','2019-11-01','S000005','RS000001','GA000002','SP000001','SS000001','TT000002','RS000001','SO000001','RSO000002','1'),
	('G000009','可口可乐0009','RF991920009','件','10','2019-10-26','S000006','RS000001','GA000002','SP000001','SS000001','TT000002','RS000001','SO000001','RSO000002','1'),
	('G000010','可口可乐0010','RF991920010','箱','8','2019-03-31','S000006','RS000001','GA000002','SP000001','SS000001','TT000002','RS000001','SO000001','RSO000002','1'),
	('G000011','可口可乐0011','RF991920011','件','9','2021-07-28','S000007','RS000001','GA000002','SP000001','SS000001','TT000002','RS000001','SO000001','RSO000002','1'),
	('G000012','可口可乐0012','RF991920012','箱','9','2021-01-25','S000008','RS000001','GA000002','SP000001','SS000001','TT000002','RS000001','SO000001','RSO000002','1'),
	('G000013','可口可乐0013','RF991920013','件','10','2019-03-15','S000008','RS000001','GA000002','SP000001','SS000001','TT000002','RS000001','SO000001','RSO000002','1'),
	('G000014','可口可乐0014','RF991920014','箱','8','2020-12-07','S000009','RS000001','GA000003','SP000001','SS000001','TT000003','RS000002','SO000001','RSO000003','1'),
	('G000015','可口可乐0015','RF991920015','件','10','2019-01-10','S000009','RS000001','GA000003','SP000001','SS000001','TT000003','RS000002','SO000001','RSO000003','1'),
	('G000016','可口可乐0016','RF991920016','箱','10','2019-10-16','S000010','RS000001','GA000003','SP000001','SS000001','TT000003','RS000002','SO000001','RSO000003','1'),
	('G000017','可口可乐0017','RF991920017','件','10','2020-10-07','S000011','RS000001','GA000003','SP000001','SS000001','TT000003','RS000002','SO000001','RSO000003','1'),
	('G000018','可口可乐0018','RF991920018','箱','10','2020-05-02','S000011','RS000001','GA000003','SP000001','SS000001','TT000003','RS000002','SO000001','RSO000003','1'),
	('G000019','可口可乐0019','RF991920019','件','9','2020-08-02','S000012','RS000001','GA000003','SP000001','SS000001','TT000003','RS000002','SO000001','RSO000003','1'),
	('G000020','可口可乐0020','RF991920020','箱','10','2018-09-22','S000013','RS000001','GA000004','SP000001','SS000001','TT000004','RS000002','SO000001','RSO000004','1'),
	('G000021','可口可乐0021','RF991920021','件','8','2018-10-11','S000013','RS000001','GA000004','SP000001','SS000001','TT000004','RS000002','SO000001','RSO000004','1'),
	('G000022','可口可乐0022','RF991920022','箱','9','2020-06-03','S000014','RS000001','GA000004','SP000001','SS000001','TT000004','RS000002','SO000001','RSO000004','1'),
	('G000023','可口可乐0023','RF991920023','件','8','2020-07-15','S000015','RS000001','GA000004','SP000001','SS000001','TT000004','RS000002','SO000001','RSO000004','1'),
	('G000024','可口可乐0024','RF991920024','箱','10','2018-10-03','S000015','RS000001','GA000004','SP000001','SS000001','TT000004','RS000002','SO000001','RSO000004','1'),
	('G000025','可口可乐0025','RF991920025','件','9','2019-01-03','S000016','RS000001','GA000004','SP000001','SS000001','TT000004','RS000002','SO000001','RSO000004','1'),
	('G000026','可口可乐0026','RF991920026','箱','10','2021-04-05','S000017','RS000002','GA000005','SP000002','SS000002','TT000005','RS000003','SO000002','RSO000005','1'),
	('G000027','可口可乐0027','RF991920027','件','9','2020-08-07','S000017','RS000002','GA000005','SP000002','SS000002','TT000005','RS000003','SO000002','RSO000005','1'),
	('G000028','可口可乐0028','RF991920028','箱','9','2018-12-31','S000018','RS000002','GA000005','SP000002','SS000002','TT000005','RS000003','SO000002','RSO000005','1'),
	('G000029','可口可乐0029','RF991920029','件','8','2019-12-27','S000018','RS000002','GA000005','SP000002','SS000002','TT000005','RS000003','SO000002','RSO000005','1'),
	('G000030','可口可乐0030','RF991920030','箱','8','2020-11-24','S000019','RS000002','GA000005','SP000002','SS000002','TT000005','RS000003','SO000002','RSO000005','1'),
	('G000031','可口可乐0031','RF991920031','件','8','2019-03-30','S000020','RS000002','GA000005','SP000002','SS000002','TT000005','RS000003','SO000002','RSO000005','1'),
	('G000032','可口可乐0032','RF991920032','箱','9','2018-12-18','S000020','RS000002','GA000005','SP000002','SS000002','TT000005','RS000003','SO000002','RSO000005','1'),
	('G000033','可口可乐0033','RF991920033','件','9','2020-06-19','S000021','RS000002','GA000006','SP000002','SS000002','TT000006','RS000003','SO000002','RSO000006','1'),
	('G000034','可口可乐0034','RF991920034','箱','10','2021-03-08','S000022','RS000002','GA000006','SP000002','SS000002','TT000006','RS000003','SO000002','RSO000006','1'),
	('G000035','可口可乐0035','RF991920035','件','8','2020-11-07','S000022','RS000002','GA000006','SP000002','SS000002','TT000006','RS000003','SO000002','RSO000006','1'),
	('G000036','可口可乐0036','RF991920036','箱','8','2020-06-12','S000023','RS000002','GA000006','SP000002','SS000002','TT000006','RS000003','SO000002','RSO000006','1'),
	('G000037','可口可乐0037','RF991920037','件','10','2020-04-13','S000024','RS000002','GA000006','SP000002','SS000002','TT000006','RS000003','SO000002','RSO000006','1'),
	('G000038','可口可乐0038','RF991920038','箱','10','2020-02-09','S000024','RS000002','GA000006','SP000002','SS000002','TT000006','RS000003','SO000002','RSO000006','1'),
	('G000039','可口可乐0039','RF991920039','件','10','2018-10-12','S000025','RS000002','GA000007','SP000002','SS000002','TT000007','RS000004','SO000002','RSO000007','1'),
	('G000040','可口可乐0040','RF991920040','箱','9','2021-08-31','S000025','RS000002','GA000007','SP000002','SS000002','TT000007','RS000004','SO000002','RSO000007','1'),
	('G000041','可口可乐0041','RF991920041','件','9','2021-07-12','S000026','RS000002','GA000007','SP000002','SS000002','TT000007','RS000004','SO000002','RSO000007','1'),
	('G000042','可口可乐0042','RF991920042','箱','8','2021-01-09','S000027','RS000002','GA000007','SP000002','SS000002','TT000007','RS000004','SO000002','RSO000007','1'),
	('G000043','可口可乐0043','RF991920043','件','9','2021-01-14','S000027','RS000002','GA000007','SP000002','SS000002','TT000007','RS000004','SO000002','RSO000007','1'),
	('G000044','可口可乐0044','RF991920044','箱','8','2020-10-23','S000028','RS000002','GA000007','SP000002','SS000002','TT000007','RS000004','SO000002','RSO000007','1'),
	('G000045','可口可乐0045','RF991920045','件','9','2019-09-06','S000029','RS000002','GA000008','SP000002','SS000002','TT000008','RS000004','SO000002','RSO000008','1'),
	('G000046','可口可乐0046','RF991920046','箱','8','2020-10-21','S000029','RS000002','GA000008','SP000002','SS000002','TT000008','RS000004','SO000002','RSO000008','1'),
	('G000047','可口可乐0047','RF991920047','件','9','2020-03-17','S000030','RS000002','GA000008','SP000002','SS000002','TT000008','RS000004','SO000002','RSO000008','1'),
	('G000048','可口可乐0048','RF991920048','箱','10','2020-01-05','S000031','RS000002','GA000008','SP000002','SS000002','TT000008','RS000004','SO000002','RSO000008','1'),
	('G000049','可口可乐0049','RF991920049','件','10','2020-01-21','S000031','RS000002','GA000008','SP000002','SS000002','TT000008','RS000004','SO000002','RSO000008','1'),
	('G000050','可口可乐0050','RF991920050','箱','8','2020-10-11','S000032','RS000002','GA000008','SP000002','SS000002','TT000008','RS000004','SO000002','RSO000008','1'),
	('G000051','可口可乐0051','RF991920051','件','8','2019-10-09','S000033','RS000003','GA000009','SP000003','SS000003','TT000009','RS000005','SO000003','RSO000009','1'),
	('G000052','可口可乐0052','RF991920052','箱','9','2021-06-03','S000033','RS000003','GA000009','SP000003','SS000003','TT000009','RS000005','SO000003','RSO000009','1'),
	('G000053','可口可乐0053','RF991920053','件','9','2019-10-28','S000034','RS000003','GA000009','SP000003','SS000003','TT000009','RS000005','SO000003','RSO000009','1'),
	('G000054','可口可乐0054','RF991920054','箱','8','2021-01-24','S000034','RS000003','GA000009','SP000003','SS000003','TT000009','RS000005','SO000003','RSO000009','1'),
	('G000055','可口可乐0055','RF991920055','件','8','2019-12-12','S000035','RS000003','GA000009','SP000003','SS000003','TT000009','RS000005','SO000003','RSO000009','1'),
	('G000056','可口可乐0056','RF991920056','箱','9','2019-11-18','S000036','RS000003','GA000009','SP000003','SS000003','TT000009','RS000005','SO000003','RSO000009','1'),
	('G000057','可口可乐0057','RF991920057','件','8','2019-05-15','S000036','RS000003','GA000009','SP000003','SS000003','TT000009','RS000005','SO000003','RSO000009','1'),
	('G000058','可口可乐0058','RF991920058','箱','9','2019-08-20','S000037','RS000003','GA000010','SP000003','SS000003','TT000010','RS000005','SO000003','RSO000010','1'),
	('G000059','可口可乐0059','RF991920059','件','9','2019-10-26','S000038','RS000003','GA000010','SP000003','SS000003','TT000010','RS000005','SO000003','RSO000010','1'),
	('G000060','可口可乐0060','RF991920060','箱','8','2021-05-14','S000038','RS000003','GA000010','SP000003','SS000003','TT000010','RS000005','SO000003','RSO000010','1'),
	('G000061','可口可乐0061','RF991920061','件','10','2019-10-05','S000039','RS000003','GA000010','SP000003','SS000003','TT000010','RS000005','SO000003','RSO000010','1'),
	('G000062','可口可乐0062','RF991920062','箱','10','2020-02-26','S000040','RS000003','GA000010','SP000003','SS000003','TT000010','RS000005','SO000003','RSO000010','1'),
	('G000063','可口可乐0063','RF991920063','件','8','2021-03-19','S000040','RS000003','GA000010','SP000003','SS000003','TT000010','RS000005','SO000003','RSO000010','1'),
	('G000064','可口可乐0064','RF991920064','箱','10','2021-03-28','S000041','RS000003','GA000011','SP000003','SS000003','TT000011','RS000006','SO000003','RSO000011','1'),
	('G000065','可口可乐0065','RF991920065','件','9','2020-08-28','S000041','RS000003','GA000011','SP000003','SS000003','TT000011','RS000006','SO000003','RSO000011','1'),
	('G000066','可口可乐0066','RF991920066','箱','10','2020-07-06','S000042','RS000003','GA000011','SP000003','SS000003','TT000011','RS000006','SO000003','RSO000011','1'),
	('G000067','可口可乐0067','RF991920067','件','10','2020-09-09','S000043','RS000003','GA000011','SP000003','SS000003','TT000011','RS000006','SO000003','RSO000011','1'),
	('G000068','可口可乐0068','RF991920068','箱','8','2020-11-28','S000043','RS000003','GA000011','SP000003','SS000003','TT000011','RS000006','SO000003','RSO000011','1'),
	('G000069','可口可乐0069','RF991920069','件','10','2018-11-09','S000044','RS000003','GA000011','SP000003','SS000003','TT000011','RS000006','SO000003','RSO000011','1'),
	('G000070','可口可乐0070','RF991920070','箱','8','2020-07-24','S000045','RS000003','GA000012','SP000003','SS000003','TT000012','RS000006','SO000003','RSO000012','1'),
	('G000071','可口可乐0071','RF991920071','件','8','2021-08-02','S000045','RS000003','GA000012','SP000003','SS000003','TT000012','RS000006','SO000003','RSO000012','1'),
	('G000072','可口可乐0072','RF991920072','箱','9','2021-07-02','S000046','RS000003','GA000012','SP000003','SS000003','TT000012','RS000006','SO000003','RSO000012','1'),
	('G000073','可口可乐0073','RF991920073','件','8','2020-04-28','S000047','RS000003','GA000012','SP000003','SS000003','TT000012','RS000006','SO000003','RSO000012','1'),
	('G000074','可口可乐0074','RF991920074','箱','9','2019-06-16','S000047','RS000003','GA000012','SP000003','SS000003','TT000012','RS000006','SO000003','RSO000012','1'),
	('G000075','可口可乐0075','RF991920075','件','8','2020-12-27','S000048','RS000003','GA000012','SP000003','SS000003','TT000012','RS000006','SO000003','RSO000012','1'),
	('G000076','可口可乐0076','RF991920076','箱','10','2020-08-20','S000049','RS000004','GA000013','SP000004','SS000004','TT000013','RS000007','SO000004','RSO000013','1'),
	('G000077','可口可乐0077','RF991920077','件','10','2019-06-09','S000049','RS000004','GA000013','SP000004','SS000004','TT000013','RS000007','SO000004','RSO000013','1'),
	('G000078','可口可乐0078','RF991920078','箱','10','2021-08-22','S000050','RS000004','GA000013','SP000004','SS000004','TT000013','RS000007','SO000004','RSO000013','1'),
	('G000079','可口可乐0079','RF991920079','件','9','2020-01-26','S000050','RS000004','GA000013','SP000004','SS000004','TT000013','RS000007','SO000004','RSO000013','1'),
	('G000080','可口可乐0080','RF991920080','箱','10','2021-05-09','S000051','RS000004','GA000013','SP000004','SS000004','TT000013','RS000007','SO000004','RSO000013','1'),
	('G000081','可口可乐0081','RF991920081','件','10','2019-10-05','S000052','RS000004','GA000013','SP000004','SS000004','TT000013','RS000007','SO000004','RSO000013','1'),
	('G000082','可口可乐0082','RF991920082','箱','10','2020-05-21','S000052','RS000004','GA000013','SP000004','SS000004','TT000013','RS000007','SO000004','RSO000013','1'),
	('G000083','可口可乐0083','RF991920083','件','10','2020-02-11','S000053','RS000004','GA000014','SP000004','SS000004','TT000014','RS000007','SO000004','RSO000014','1'),
	('G000084','可口可乐0084','RF991920084','箱','8','2020-11-12','S000054','RS000004','GA000014','SP000004','SS000004','TT000014','RS000007','SO000004','RSO000014','1'),
	('G000085','可口可乐0085','RF991920085','件','10','2021-07-30','S000054','RS000004','GA000014','SP000004','SS000004','TT000014','RS000007','SO000004','RSO000014','1'),
	('G000086','可口可乐0086','RF991920086','箱','10','2021-05-16','S000055','RS000004','GA000014','SP000004','SS000004','TT000014','RS000007','SO000004','RSO000014','1'),
	('G000087','可口可乐0087','RF991920087','件','9','2021-04-03','S000056','RS000004','GA000014','SP000004','SS000004','TT000014','RS000007','SO000004','RSO000014','1'),
	('G000088','可口可乐0088','RF991920088','箱','10','2019-08-09','S000056','RS000004','GA000014','SP000004','SS000004','TT000014','RS000007','SO000004','RSO000014','1'),
	('G000089','可口可乐0089','RF991920089','件','8','2019-01-18','S000057','RS000004','GA000015','SP000004','SS000004','TT000015','RS000008','SO000004','RSO000015','1'),
	('G000090','可口可乐0090','RF991920090','箱','10','2019-10-03','S000057','RS000004','GA000015','SP000004','SS000004','TT000015','RS000008','SO000004','RSO000015','1'),
	('G000091','可口可乐0091','RF991920091','件','10','2020-09-19','S000058','RS000004','GA000015','SP000004','SS000004','TT000015','RS000008','SO000004','RSO000015','1'),
	('G000092','可口可乐0092','RF991920092','箱','10','2019-10-19','S000059','RS000004','GA000015','SP000004','SS000004','TT000015','RS000008','SO000004','RSO000015','1'),
	('G000093','可口可乐0093','RF991920093','件','8','2020-08-09','S000059','RS000004','GA000015','SP000004','SS000004','TT000015','RS000008','SO000004','RSO000015','1'),
	('G000094','可口可乐0094','RF991920094','箱','8','2018-09-27','S000060','RS000004','GA000015','SP000004','SS000004','TT000015','RS000008','SO000004','RSO000015','1'),
	('G000095','可口可乐0095','RF991920095','件','10','2020-01-11','S000061','RS000004','GA000016','SP000004','SS000004','TT000016','RS000008','SO000004','RSO000016','1'),
	('G000096','可口可乐0096','RF991920096','箱','8','2019-07-07','S000061','RS000004','GA000016','SP000004','SS000004','TT000016','RS000008','SO000004','RSO000016','1'),
	('G000097','可口可乐0097','RF991920097','件','10','2020-02-11','S000062','RS000004','GA000016','SP000004','SS000004','TT000016','RS000008','SO000004','RSO000016','1'),
	('G000098','可口可乐0098','RF991920098','箱','10','2019-07-13','S000063','RS000004','GA000016','SP000004','SS000004','TT000016','RS000008','SO000004','RSO000016','1'),
	('G000099','可口可乐0099','RF991920099','件','9','2021-07-19','S000063','RS000004','GA000016','SP000004','SS000004','TT000016','RS000008','SO000004','RSO000016','1'),
	('G000100','可口可乐0100','RF991920100','箱','9','2020-11-27','S000064','RS000004','GA000016','SP000004','SS000004','TT000016','RS000008','SO000004','RSO000016','1');

insert into goods_movement_data values
	('GM000001','2021-08-26 10:15:35','仓库货位','仓库货位','192.168.20.10001','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050001','FTYUIOLJYT12312312312312asdfasd0001','41.84582607743772','132.23450145048557','G000001','1'),
	('GM000002','2021-09-07 11:06:51','卡车','卡车','192.168.20.10002','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050002','FTYUIOLJYT12312312312312asdfasd0002','40.62834059742796','129.9034854332745','G000002','1'),
	('GM000003','2021-09-05 02:30:34','小超','小超','192.168.20.10003','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050003','FTYUIOLJYT12312312312312asdfasd0003','42.21087848376194','131.59127225518432','G000003','1'),
	('GM000004','2021-08-27 23:11:24','仓库货位','仓库货位','192.168.20.10004','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050004','FTYUIOLJYT12312312312312asdfasd0004','41.60774383648584','129.66416684587173','G000004','1'),
	('GM000005','2021-08-24 06:21:05','卡车','卡车','192.168.20.10005','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050005','FTYUIOLJYT12312312312312asdfasd0005','41.10014090025813','132.12122015484516','G000005','1'),
	('GM000006','2021-09-06 09:52:40','小超','小超','192.168.20.10006','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050006','FTYUIOLJYT12312312312312asdfasd0006','40.70025809955704','132.1436002011672','G000006','1'),
	('GM000007','2021-08-30 13:41:13','仓库货位','仓库货位','192.168.20.10007','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050007','FTYUIOLJYT12312312312312asdfasd0007','41.08457819701661','131.8807283834157','G000007','1'),
	('GM000008','2021-08-25 12:46:28','卡车','卡车','192.168.20.10008','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050008','FTYUIOLJYT12312312312312asdfasd0008','40.57172595325495','129.6893683010007','G000008','1'),
	('GM000009','2021-08-22 05:18:37','小超','小超','192.168.20.10009','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050009','FTYUIOLJYT12312312312312asdfasd0009','42.46028468707122','129.36641872964455','G000009','1'),
	('GM000010','2021-09-01 16:46:55','仓库货位','仓库货位','192.168.20.10010','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050010','FTYUIOLJYT12312312312312asdfasd0010','40.315611972697425','130.71950237794198','G000010','1'),
	('GM000011','2021-09-03 17:47:46','卡车','卡车','192.168.20.10011','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050011','FTYUIOLJYT12312312312312asdfasd0011','41.13591946500947','130.6065547101384','G000011','1'),
	('GM000012','2021-08-31 21:58:34','小超','小超','192.168.20.10012','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050012','FTYUIOLJYT12312312312312asdfasd0012','40.08168585001908','131.62988544748208','G000012','1'),
	('GM000013','2021-09-04 01:27:56','仓库货位','仓库货位','192.168.20.10013','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050013','FTYUIOLJYT12312312312312asdfasd0013','40.61634092732336','130.27940334387026','G000013','1'),
	('GM000014','2021-08-26 04:20:54','卡车','卡车','192.168.20.10014','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050014','FTYUIOLJYT12312312312312asdfasd0014','40.61294631900503','131.568949681778','G000014','1'),
	('GM000015','2021-09-09 01:24:27','小超','小超','192.168.20.10015','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050015','FTYUIOLJYT12312312312312asdfasd0015','42.494615776010626','131.8060404266878','G000015','1'),
	('GM000016','2021-08-31 05:52:54','仓库货位','仓库货位','192.168.20.10016','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050016','FTYUIOLJYT12312312312312asdfasd0016','40.59901432994156','130.0102531256129','G000016','1'),
	('GM000017','2021-08-27 02:00:13','卡车','卡车','192.168.20.10017','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050017','FTYUIOLJYT12312312312312asdfasd0017','41.540599678454136','129.9625864943576','G000017','1'),
	('GM000018','2021-08-30 12:41:38','小超','小超','192.168.20.10018','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050018','FTYUIOLJYT12312312312312asdfasd0018','40.10801165148252','130.89445916837596','G000018','1'),
	('GM000019','2021-08-20 12:20:55','仓库货位','仓库货位','192.168.20.10019','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050019','FTYUIOLJYT12312312312312asdfasd0019','41.39621852794177','130.5062261033012','G000019','1'),
	('GM000020','2021-09-09 13:39:58','卡车','卡车','192.168.20.10020','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050020','FTYUIOLJYT12312312312312asdfasd0020','42.11635231747368','129.61510697127','G000020','1'),
	('GM000021','2021-08-31 07:10:43','小超','小超','192.168.20.10021','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050021','FTYUIOLJYT12312312312312asdfasd0021','42.10913369596441','131.75024808470502','G000021','1'),
	('GM000022','2021-08-23 12:04:12','仓库货位','仓库货位','192.168.20.10022','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050022','FTYUIOLJYT12312312312312asdfasd0022','39.94093515899068','130.3098142978063','G000022','1'),
	('GM000023','2021-08-30 07:23:36','卡车','卡车','192.168.20.10023','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050023','FTYUIOLJYT12312312312312asdfasd0023','39.88948543788293','129.7985170888003','G000023','1'),
	('GM000024','2021-09-07 22:04:35','小超','小超','192.168.20.10024','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050024','FTYUIOLJYT12312312312312asdfasd0024','40.76808407679587','129.8907779929636','G000024','1'),
	('GM000025','2021-09-02 23:58:49','仓库货位','仓库货位','192.168.20.10025','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050025','FTYUIOLJYT12312312312312asdfasd0025','42.51883801811535','131.55514776040366','G000025','1'),
	('GM000026','2021-08-22 02:47:53','卡车','卡车','192.168.20.10026','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050026','FTYUIOLJYT12312312312312asdfasd0026','41.74851228935488','129.93434689736972','G000026','1'),
	('GM000027','2021-08-22 19:16:15','小超','小超','192.168.20.10027','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050027','FTYUIOLJYT12312312312312asdfasd0027','39.81438596951396','131.15972572510464','G000027','1'),
	('GM000028','2021-08-25 19:32:38','仓库货位','仓库货位','192.168.20.10028','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050028','FTYUIOLJYT12312312312312asdfasd0028','40.02098355165233','130.45587248595518','G000028','1'),
	('GM000029','2021-08-30 11:20:55','卡车','卡车','192.168.20.10029','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050029','FTYUIOLJYT12312312312312asdfasd0029','40.32112851260463','130.61435205601558','G000029','1'),
	('GM000030','2021-08-24 17:21:45','小超','小超','192.168.20.10030','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050030','FTYUIOLJYT12312312312312asdfasd0030','41.4757366571245','129.55795062440592','G000030','1'),
	('GM000031','2021-08-30 19:49:17','仓库货位','仓库货位','192.168.20.10031','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050031','FTYUIOLJYT12312312312312asdfasd0031','40.41442063942349','132.22135405874016','G000031','1'),
	('GM000032','2021-08-25 11:19:08','卡车','卡车','192.168.20.10032','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050032','FTYUIOLJYT12312312312312asdfasd0032','41.96176873410614','131.87064734711151','G000032','1'),
	('GM000033','2021-08-20 01:35:07','小超','小超','192.168.20.10033','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050033','FTYUIOLJYT12312312312312asdfasd0033','41.01752274108614','131.6481007203036','G000033','1'),
	('GM000034','2021-08-24 06:36:58','仓库货位','仓库货位','192.168.20.10034','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050034','FTYUIOLJYT12312312312312asdfasd0034','40.572522171782154','129.34255444851803','G000034','1'),
	('GM000035','2021-08-23 07:46:56','卡车','卡车','192.168.20.10035','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050035','FTYUIOLJYT12312312312312asdfasd0035','40.02408168983532','130.78951754439288','G000035','1'),
	('GM000036','2021-09-08 14:23:01','小超','小超','192.168.20.10036','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050036','FTYUIOLJYT12312312312312asdfasd0036','41.65827830739019','131.61089075574804','G000036','1'),
	('GM000037','2021-08-23 04:22:27','仓库货位','仓库货位','192.168.20.10037','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050037','FTYUIOLJYT12312312312312asdfasd0037','41.94259526412771','129.8742476006403','G000037','1'),
	('GM000038','2021-08-22 08:36:42','卡车','卡车','192.168.20.10038','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050038','FTYUIOLJYT12312312312312asdfasd0038','40.55965602986186','131.5248081011423','G000038','1'),
	('GM000039','2021-09-02 19:19:13','小超','小超','192.168.20.10039','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050039','FTYUIOLJYT12312312312312asdfasd0039','40.50567950219368','129.92474239181496','G000039','1'),
	('GM000040','2021-09-02 12:16:03','仓库货位','仓库货位','192.168.20.10040','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050040','FTYUIOLJYT12312312312312asdfasd0040','41.937197480277234','131.14416488401537','G000040','1'),
	('GM000041','2021-08-23 19:07:48','卡车','卡车','192.168.20.10041','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050041','FTYUIOLJYT12312312312312asdfasd0041','42.59632676260627','130.65577255469623','G000041','1'),
	('GM000042','2021-08-22 07:19:27','小超','小超','192.168.20.10042','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050042','FTYUIOLJYT12312312312312asdfasd0042','40.89235829087049','131.24000544301666','G000042','1'),
	('GM000043','2021-08-26 16:38:39','仓库货位','仓库货位','192.168.20.10043','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050043','FTYUIOLJYT12312312312312asdfasd0043','41.49940808466779','130.30395825217548','G000043','1'),
	('GM000044','2021-09-08 09:48:19','卡车','卡车','192.168.20.10044','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050044','FTYUIOLJYT12312312312312asdfasd0044','40.19371927642244','131.11466803736002','G000044','1'),
	('GM000045','2021-09-01 04:42:28','小超','小超','192.168.20.10045','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050045','FTYUIOLJYT12312312312312asdfasd0045','42.680637473583005','131.8000715682902','G000045','1'),
	('GM000046','2021-08-22 05:26:20','仓库货位','仓库货位','192.168.20.10046','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050046','FTYUIOLJYT12312312312312asdfasd0046','40.40040954113112','131.89879430993244','G000046','1'),
	('GM000047','2021-08-27 18:48:30','卡车','卡车','192.168.20.10047','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050047','FTYUIOLJYT12312312312312asdfasd0047','41.09642131477243','130.90634269739024','G000047','1'),
	('GM000048','2021-08-26 12:47:34','小超','小超','192.168.20.10048','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050048','FTYUIOLJYT12312312312312asdfasd0048','41.02723914987836','129.9076196840721','G000048','1'),
	('GM000049','2021-09-10 08:21:47','仓库货位','仓库货位','192.168.20.10049','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050049','FTYUIOLJYT12312312312312asdfasd0049','41.84392004063061','130.6761930851169','G000049','1'),
	('GM000050','2021-08-21 09:16:24','卡车','卡车','192.168.20.10050','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050050','FTYUIOLJYT12312312312312asdfasd0050','42.34064232875747','130.5159963245804','G000050','1'),
	('GM000051','2021-08-23 19:10:53','小超','小超','192.168.20.10051','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050051','FTYUIOLJYT12312312312312asdfasd0051','40.24684020532237','129.2902595569629','G000051','1'),
	('GM000052','2021-08-28 18:10:02','仓库货位','仓库货位','192.168.20.10052','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050052','FTYUIOLJYT12312312312312asdfasd0052','40.582142700492454','130.28497157246417','G000052','1'),
	('GM000053','2021-08-27 16:42:50','卡车','卡车','192.168.20.10053','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050053','FTYUIOLJYT12312312312312asdfasd0053','42.542659461872745','131.36990043562275','G000053','1'),
	('GM000054','2021-09-08 17:57:52','小超','小超','192.168.20.10054','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050054','FTYUIOLJYT12312312312312asdfasd0054','40.26068164537098','130.01488105943108','G000054','1'),
	('GM000055','2021-09-10 10:47:30','仓库货位','仓库货位','192.168.20.10055','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050055','FTYUIOLJYT12312312312312asdfasd0055','40.073009796105424','129.36036955201888','G000055','1'),
	('GM000056','2021-08-26 05:35:52','卡车','卡车','192.168.20.10056','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050056','FTYUIOLJYT12312312312312asdfasd0056','42.46395483918917','129.36139699505588','G000056','1'),
	('GM000057','2021-08-31 01:52:13','小超','小超','192.168.20.10057','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050057','FTYUIOLJYT12312312312312asdfasd0057','42.4907522281419','132.05639929937675','G000057','1'),
	('GM000058','2021-08-21 07:18:16','仓库货位','仓库货位','192.168.20.10058','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050058','FTYUIOLJYT12312312312312asdfasd0058','42.4421512801389','131.8105160842198','G000058','1'),
	('GM000059','2021-09-03 17:52:09','卡车','卡车','192.168.20.10059','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050059','FTYUIOLJYT12312312312312asdfasd0059','42.272972980820185','131.56207786673986','G000059','1'),
	('GM000060','2021-09-06 15:59:34','小超','小超','192.168.20.10060','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050060','FTYUIOLJYT12312312312312asdfasd0060','41.998582586280264','129.92290725778918','G000060','1'),
	('GM000061','2021-08-23 16:41:36','仓库货位','仓库货位','192.168.20.10061','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050061','FTYUIOLJYT12312312312312asdfasd0061','39.88490935768338','131.63678250043395','G000061','1'),
	('GM000062','2021-09-04 06:36:26','卡车','卡车','192.168.20.10062','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050062','FTYUIOLJYT12312312312312asdfasd0062','40.667152383089324','129.9123332137033','G000062','1'),
	('GM000063','2021-08-25 17:23:09','小超','小超','192.168.20.10063','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050063','FTYUIOLJYT12312312312312asdfasd0063','40.97002551321384','129.88481838453532','G000063','1'),
	('GM000064','2021-08-26 19:14:54','仓库货位','仓库货位','192.168.20.10064','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050064','FTYUIOLJYT12312312312312asdfasd0064','41.40609173417913','131.9800939297108','G000064','1'),
	('GM000065','2021-09-05 14:43:42','卡车','卡车','192.168.20.10065','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050065','FTYUIOLJYT12312312312312asdfasd0065','39.9685514455326','130.45670290950295','G000065','1'),
	('GM000066','2021-09-09 07:59:53','小超','小超','192.168.20.10066','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050066','FTYUIOLJYT12312312312312asdfasd0066','41.43365450229208','130.37882943419424','G000066','1'),
	('GM000067','2021-08-29 09:03:43','仓库货位','仓库货位','192.168.20.10067','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050067','FTYUIOLJYT12312312312312asdfasd0067','40.6913684376046','130.90626119574893','G000067','1'),
	('GM000068','2021-08-21 01:19:29','卡车','卡车','192.168.20.10068','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050068','FTYUIOLJYT12312312312312asdfasd0068','41.17042126860453','130.4938938637511','G000068','1'),
	('GM000069','2021-08-29 02:17:36','小超','小超','192.168.20.10069','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050069','FTYUIOLJYT12312312312312asdfasd0069','41.526878859732946','131.6044980638196','G000069','1'),
	('GM000070','2021-09-06 11:04:16','仓库货位','仓库货位','192.168.20.10070','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050070','FTYUIOLJYT12312312312312asdfasd0070','41.53352606293477','130.2063410072049','G000070','1'),
	('GM000071','2021-08-20 22:32:21','卡车','卡车','192.168.20.10071','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050071','FTYUIOLJYT12312312312312asdfasd0071','42.64226753311416','130.36636548153916','G000071','1'),
	('GM000072','2021-09-09 14:42:18','小超','小超','192.168.20.10072','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050072','FTYUIOLJYT12312312312312asdfasd0072','42.5026480801184','130.41392178393787','G000072','1'),
	('GM000073','2021-08-27 23:43:49','仓库货位','仓库货位','192.168.20.10073','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050073','FTYUIOLJYT12312312312312asdfasd0073','41.59232044034357','129.87095065468415','G000073','1'),
	('GM000074','2021-09-03 21:36:30','卡车','卡车','192.168.20.10074','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050074','FTYUIOLJYT12312312312312asdfasd0074','42.10126715929118','131.63910399993662','G000074','1'),
	('GM000075','2021-09-01 14:37:40','小超','小超','192.168.20.10075','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050075','FTYUIOLJYT12312312312312asdfasd0075','40.081782868133274','129.42328520179478','G000075','1'),
	('GM000076','2021-08-21 06:00:38','仓库货位','仓库货位','192.168.20.10076','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050076','FTYUIOLJYT12312312312312asdfasd0076','41.31787705134683','129.52781426145458','G000076','1'),
	('GM000077','2021-09-05 00:43:49','卡车','卡车','192.168.20.10077','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050077','FTYUIOLJYT12312312312312asdfasd0077','39.98234160535528','130.94407843592492','G000077','1'),
	('GM000078','2021-08-30 06:57:58','小超','小超','192.168.20.10078','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050078','FTYUIOLJYT12312312312312asdfasd0078','39.84209272248308','131.44933811918676','G000078','1'),
	('GM000079','2021-09-01 02:07:37','仓库货位','仓库货位','192.168.20.10079','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050079','FTYUIOLJYT12312312312312asdfasd0079','41.4020263222261','129.81247271164062','G000079','1'),
	('GM000080','2021-08-22 00:03:24','卡车','卡车','192.168.20.10080','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050080','FTYUIOLJYT12312312312312asdfasd0080','41.574541503072005','132.13467678210029','G000080','1'),
	('GM000081','2021-08-29 11:18:22','小超','小超','192.168.20.10081','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050081','FTYUIOLJYT12312312312312asdfasd0081','41.29061212807888','130.8098104703067','G000081','1'),
	('GM000082','2021-08-27 00:25:49','仓库货位','仓库货位','192.168.20.10082','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050082','FTYUIOLJYT12312312312312asdfasd0082','41.15485213935021','131.953863674544','G000082','1'),
	('GM000083','2021-08-26 09:28:11','卡车','卡车','192.168.20.10083','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050083','FTYUIOLJYT12312312312312asdfasd0083','41.46505525195944','130.6059091980694','G000083','1'),
	('GM000084','2021-08-26 12:06:30','小超','小超','192.168.20.10084','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050084','FTYUIOLJYT12312312312312asdfasd0084','40.15986087371713','131.22662511254654','G000084','1'),
	('GM000085','2021-09-05 12:14:29','仓库货位','仓库货位','192.168.20.10085','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050085','FTYUIOLJYT12312312312312asdfasd0085','41.60781062480994','130.63311608729373','G000085','1'),
	('GM000086','2021-09-07 22:18:19','卡车','卡车','192.168.20.10086','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050086','FTYUIOLJYT12312312312312asdfasd0086','40.27835360289543','130.40778524371655','G000086','1'),
	('GM000087','2021-08-26 02:59:19','小超','小超','192.168.20.10087','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050087','FTYUIOLJYT12312312312312asdfasd0087','41.859908666023976','132.1502281309815','G000087','1'),
	('GM000088','2021-09-03 12:21:02','仓库货位','仓库货位','192.168.20.10088','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050088','FTYUIOLJYT12312312312312asdfasd0088','42.74641192122833','131.68955905548876','G000088','1'),
	('GM000089','2021-09-04 02:15:49','卡车','卡车','192.168.20.10089','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050089','FTYUIOLJYT12312312312312asdfasd0089','40.55986432852113','131.60411321317466','G000089','1'),
	('GM000090','2021-09-03 05:56:31','小超','小超','192.168.20.10090','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050090','FTYUIOLJYT12312312312312asdfasd0090','42.40900204366616','130.94604859287048','G000090','1'),
	('GM000091','2021-09-01 05:17:52','仓库货位','仓库货位','192.168.20.10091','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050091','FTYUIOLJYT12312312312312asdfasd0091','40.00693945108147','131.05058397815353','G000091','1'),
	('GM000092','2021-09-04 23:24:57','卡车','卡车','192.168.20.10092','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050092','FTYUIOLJYT12312312312312asdfasd0092','40.19223288777153','130.01770639817488','G000092','1'),
	('GM000093','2021-08-20 01:23:27','小超','小超','192.168.20.10093','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050093','FTYUIOLJYT12312312312312asdfasd0093','41.21919635535906','130.34989631204937','G000093','1'),
	('GM000094','2021-08-22 20:43:53','仓库货位','仓库货位','192.168.20.10094','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050094','FTYUIOLJYT12312312312312asdfasd0094','41.96324161556056','131.43020176371007','G000094','1'),
	('GM000095','2021-09-01 17:22:50','卡车','卡车','192.168.20.10095','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050095','FTYUIOLJYT12312312312312asdfasd0095','40.45749668926386','129.76145333079774','G000095','1'),
	('GM000096','2021-08-25 01:13:07','小超','小超','192.168.20.10096','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050096','FTYUIOLJYT12312312312312asdfasd0096','42.110588998787726','132.17612284511324','G000096','1'),
	('GM000097','2021-08-28 16:03:57','仓库货位','仓库货位','192.168.20.10097','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050097','FTYUIOLJYT12312312312312asdfasd0097','40.06857674179853','130.53528170054213','G000097','1'),
	('GM000098','2021-09-06 12:52:28','卡车','卡车','192.168.20.10098','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050098','FTYUIOLJYT12312312312312asdfasd0098','41.790131336392854','129.40046344513303','G000098','1'),
	('GM000099','2021-09-09 17:37:45','小超','小超','192.168.20.10099','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050099','FTYUIOLJYT12312312312312asdfasd0099','40.31415940445818','129.44614218643613','G000099','1'),
	('GM000100','2021-09-05 19:19:03','仓库货位','仓库货位','192.168.20.10100','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050100','FTYUIOLJYT12312312312312asdfasd0100','41.19548953134479','129.54123190625964','G000100','1');

insert into supplier_space_data values
	('SS000001','成都龙泉驿飞鹤路20号供货商独立管理区0001','028 876543210001','1876平方米0001','W000001','39.79167689972394','129.97421692384574','2021-08-26 16:43:22','1'),
	('SS000002','成都龙泉驿飞鹤路20号供货商独立管理区0002','028 876543210002','1876平方米0002','W000001','40.12423134554379','129.67423877348546','2021-08-31 06:43:16','1'),
	('SS000003','成都龙泉驿飞鹤路20号供货商独立管理区0003','028 876543210003','1876平方米0003','W000002','41.002087645141835','131.92689060960302','2021-09-10 19:15:06','1'),
	('SS000004','成都龙泉驿飞鹤路20号供货商独立管理区0004','028 876543210004','1876平方米0004','W000002','42.6874664253538','131.25202754848135','2021-08-20 02:33:43','1');

insert into receiving_space_data values
	('RS000001','成都龙泉驿飞鹤路20号仓库卸货区0001','028 876543210001','每个收货区可以供一辆车卸货0001','1876平方米0001','W000001','42.02751441138343','130.58387964335196','2021-09-10 15:05:38','1'),
	('RS000002','成都龙泉驿飞鹤路20号仓库卸货区0002','028 876543210002','每个收货区可以供一辆车卸货0002','1876平方米0002','W000001','41.24772514416544','129.43598117053963','2021-08-29 05:31:10','1'),
	('RS000003','成都龙泉驿飞鹤路20号仓库卸货区0003','028 876543210003','每个收货区可以供一辆车卸货0003','1876平方米0003','W000002','41.16002280045394','130.43274093870428','2021-08-26 21:57:54','1'),
	('RS000004','成都龙泉驿飞鹤路20号仓库卸货区0004','028 876543210004','每个收货区可以供一辆车卸货0004','1876平方米0004','W000002','39.85841535499389','131.17568410572423','2021-08-27 11:11:58','1');

insert into shipping_space_data values
	('SS000001','成都龙泉驿飞鹤路20号装货区0001','028 876543210001','1876平方米0001','W000001','42.628606790535606','129.59072152361475','每个收货区可以供一辆车装货0001','2021-08-26 05:06:25','1'),
	('SS000002','成都龙泉驿飞鹤路20号装货区0002','028 876543210002','1876平方米0002','W000001','40.46245963408066','130.21930082793875','每个收货区可以供一辆车装货0002','2021-08-25 00:26:42','1'),
	('SS000003','成都龙泉驿飞鹤路20号装货区0003','028 876543210003','1876平方米0003','W000002','42.182129968262764','131.18479840017935','每个收货区可以供一辆车装货0003','2021-08-24 07:11:46','1'),
	('SS000004','成都龙泉驿飞鹤路20号装货区0004','028 876543210004','1876平方米0004','W000002','40.46040576860413','131.23562023194884','每个收货区可以供一辆车装货0004','2021-09-02 12:40:06','1');

insert into damage_space_data values
	('DS000001','成都龙泉驿飞鹤路20号仓库损坏货物堆放区0001','028 876543210001','1876平方米0001','41.934941411045614','132.16565709618413','W000001','2021-08-22 18:16:36','1'),
	('DS000002','成都龙泉驿飞鹤路20号仓库损坏货物堆放区0002','028 876543210002','1876平方米0002','40.491420844625466','129.4264469123699','W000001','2021-08-27 10:43:59','1'),
	('DS000003','成都龙泉驿飞鹤路20号仓库损坏货物堆放区0003','028 876543210003','1876平方米0003','41.79857107256','131.93127903988355','W000002','2021-09-09 10:28:24','1'),
	('DS000004','成都龙泉驿飞鹤路20号仓库损坏货物堆放区0004','028 876543210004','1876平方米0004','42.51538062054004','130.21498994466089','W000002','2021-09-01 17:10:42','1');

insert into warehouse_asset_data values
	('WA000001','叉车','备用件存放区设备库房0001','W000001','2021-08-31 21:07:27','1'),
	('WA000002','托盘','备用件存放区设备库房0002','W000001','2021-09-02 14:57:57','1'),
	('WA000003','传送带备件','备用件存放区设备库房0003','W000002','2021-08-25 18:01:35','1'),
	('WA000004','叉车','备用件存放区设备库房0004','W000002','2021-08-28 23:21:13','1');

insert into transport_fleet_data values
	('TF000001','双链先锋号车队0001','028 876543210001','RSCC000001','2021-08-23 19:34:10','1'),
	('TF000002','双链先锋号车队0002','028 876543210002','RSCC000001','2021-09-04 20:32:33','1');

insert into transport_truck_data values
	('TT000001','运货卡车0001','川AK50001','028 876543210001','VL91980001','EN001020001','2019-01-05','100万公里0001','红色','TF000001','1'),
	('TT000002','运货卡车0002','川AK50002','028 876543210002','VL91980002','EN001020002','2019-10-10','100万公里0002','蓝色','TF000001','1'),
	('TT000003','运货卡车0003','川AK50003','028 876543210003','VL91980003','EN001020003','2019-08-08','100万公里0003','白色','TF000002','1'),
	('TT000004','运货卡车0004','川AK50004','028 876543210004','VL91980004','EN001020004','2020-02-28','100万公里0004','灰色','TF000002','1');

insert into truck_driver_data values
	('TD000001','运货卡车司机0001','5109 9887 7330001','18777778888','TF000001','1'),
	('TD000002','运货卡车司机0002','5109 9887 7330002','13900000002','TF000001','1'),
	('TD000003','运货卡车司机0003','5109 9887 7330003','13900000003','TF000002','1'),
	('TD000004','运货卡车司机0004','5109 9887 7330004','13900000004','TF000002','1');

insert into transport_task_data values
	('TT000001','货运记录0001','双链二号仓0001','2021-04-05','RS000001','TD000001','TT000001','TF000001','41.95370766651679','131.01834640672388','1'),
	('TT000002','货运记录0002','双链二号仓0002','2021-03-05','RS000001','TD000001','TT000001','TF000001','39.826910082744924','129.53080434211515','1'),
	('TT000003','货运记录0003','双链二号仓0003','2021-04-15','RS000002','TD000001','TT000001','TF000001','41.21573840538421','131.57025022775142','1'),
	('TT000004','货运记录0004','双链二号仓0004','2020-01-21','RS000002','TD000001','TT000001','TF000001','41.594940299457086','130.4900306636511','1'),
	('TT000005','货运记录0005','双链二号仓0005','2020-04-23','RS000003','TD000002','TT000002','TF000001','39.81884268553283','131.7341889920525','1'),
	('TT000006','货运记录0006','双链二号仓0006','2020-07-17','RS000003','TD000002','TT000002','TF000001','42.15777669012947','130.07605865468446','1'),
	('TT000007','货运记录0007','双链二号仓0007','2020-01-23','RS000004','TD000002','TT000002','TF000001','41.123541573008936','132.19789355728784','1'),
	('TT000008','货运记录0008','双链二号仓0008','2021-05-13','RS000004','TD000002','TT000002','TF000001','39.902608274559505','131.02376388528484','1'),
	('TT000009','货运记录0009','双链二号仓0009','2020-08-07','RS000005','TD000003','TT000003','TF000002','42.67178983116581','130.9355559740011','1'),
	('TT000010','货运记录0010','双链二号仓0010','2021-01-26','RS000005','TD000003','TT000003','TF000002','40.404157654999715','130.73799819858834','1'),
	('TT000011','货运记录0011','双链二号仓0011','2020-10-29','RS000006','TD000003','TT000003','TF000002','41.20246116115418','129.70797730098826','1'),
	('TT000012','货运记录0012','双链二号仓0012','2019-05-09','RS000006','TD000003','TT000003','TF000002','40.802615357822425','130.86209254405753','1'),
	('TT000013','货运记录0013','双链二号仓0013','2018-09-15','RS000007','TD000004','TT000004','TF000002','39.808527644872015','129.33457204016045','1'),
	('TT000014','货运记录0014','双链二号仓0014','2018-09-23','RS000007','TD000004','TT000004','TF000002','41.63511769221769','131.445162375425','1'),
	('TT000015','货运记录0015','双链二号仓0015','2021-06-12','RS000008','TD000004','TT000004','TF000002','40.739108756727006','131.19865867010813','1'),
	('TT000016','货运记录0016','双链二号仓0016','2020-11-12','RS000008','TD000004','TT000004','TF000002','41.85293679856992','130.43963711950522','1');

insert into transport_task_track_data values
	('TTT000001','2020-06-09','32.07649428137508','103.98367504005259','TT000001','1'),
	('TTT000002','2019-11-30','29.967399789782636','104.43608424561612','TT000001','1'),
	('TTT000003','2020-11-03','30.56575556834146','105.3693799697297','TT000002','1'),
	('TTT000004','2019-02-26','30.65200705798033','104.23112255439317','TT000002','1'),
	('TTT000005','2020-02-26','32.02235949270986','105.94956663641818','TT000003','1'),
	('TTT000006','2019-04-06','30.41130458781891','105.88967819101318','TT000003','1'),
	('TTT000007','2019-03-06','32.77287691231357','103.31508489730642','TT000004','1'),
	('TTT000008','2021-02-24','31.21067993940394','104.38658706924524','TT000004','1'),
	('TTT000009','2020-10-01','29.926080071975356','103.62277188564012','TT000005','1'),
	('TTT000010','2020-02-18','32.37135490316223','103.24715222619457','TT000005','1'),
	('TTT000011','2020-10-18','31.900098487293977','103.94867377897141','TT000006','1'),
	('TTT000012','2019-11-14','31.61540238883915','105.14095549671264','TT000006','1'),
	('TTT000013','2020-03-31','31.668564551384126','103.90510761713199','TT000007','1'),
	('TTT000014','2020-12-08','32.464646265150506','103.47824289407086','TT000007','1'),
	('TTT000015','2019-12-19','32.75941137940506','105.73100888343038','TT000008','1'),
	('TTT000016','2019-07-21','30.199702685572984','103.19169363336682','TT000008','1'),
	('TTT000017','2020-06-03','32.4692404353931','105.03342060102213','TT000009','1'),
	('TTT000018','2020-01-05','32.791566783941455','103.2559444989403','TT000009','1'),
	('TTT000019','2021-08-07','31.836618781969467','105.73196834331647','TT000010','1'),
	('TTT000020','2021-01-05','29.990999909989835','104.15275767442208','TT000010','1'),
	('TTT000021','2020-09-19','31.156125165253318','105.25550793007947','TT000011','1'),
	('TTT000022','2021-05-22','31.552687517432197','105.40676790539808','TT000011','1'),
	('TTT000023','2019-03-11','31.046406352954904','103.8317224847182','TT000012','1'),
	('TTT000024','2021-06-24','32.53698570203833','103.2990415648236','TT000012','1'),
	('TTT000025','2021-02-13','30.22301267888129','103.17031281208236','TT000013','1'),
	('TTT000026','2019-11-05','30.380449894070075','103.29505775624295','TT000013','1'),
	('TTT000027','2019-11-27','30.911568787359105','103.29571206529867','TT000014','1'),
	('TTT000028','2019-05-02','31.76877851574952','104.31014547040793','TT000014','1'),
	('TTT000029','2019-04-04','32.58823546564777','103.7662390280218','TT000015','1'),
	('TTT000030','2021-06-15','32.046935272531435','103.46695979796759','TT000015','1'),
	('TTT000031','2019-09-25','32.099892676315555','103.50668405000508','TT000016','1'),
	('TTT000032','2021-06-06','32.42883520180562','104.09247348230348','TT000016','1');

insert into account_set_data values
	('AS000001','账套2017','2017年','2020-03-11','企业会计制度','RMB','人民币','招商银行','3326 5805 0548 850001','RSCC000001','RS000001','GS000001','2021-09-03 13:34:44','1'),
	('AS000002','账套2018','2018年','2020-03-29','小企业会计制度','USD','美元','工商银行','3326 5805 0548 850002','RSCC000001','RS000001','GS000001','2021-09-07 15:52:45','1'),
	('AS000003','账套2019','2019年','2020-04-29','合伙制会计制度','RMB','人民币','招商银行','3326 5805 0548 850003','RSCC000001','RS000002','GS000001','2021-08-30 08:04:15','1'),
	('AS000004','账套2017','2017年','2020-03-08','企业会计制度','USD','美元','工商银行','3326 5805 0548 850004','RSCC000001','RS000002','GS000001','2021-08-27 03:54:08','1'),
	('AS000005','账套2018','2018年','2021-07-06','小企业会计制度','RMB','人民币','招商银行','3326 5805 0548 850005','RSCC000001','RS000003','GS000001','2021-09-05 20:06:12','1'),
	('AS000006','账套2019','2019年','2019-10-15','合伙制会计制度','USD','美元','工商银行','3326 5805 0548 850006','RSCC000001','RS000003','GS000001','2021-08-23 15:15:59','1'),
	('AS000007','账套2017','2017年','2020-11-17','企业会计制度','RMB','人民币','招商银行','3326 5805 0548 850007','RSCC000001','RS000004','GS000001','2021-09-07 21:27:55','1'),
	('AS000008','账套2018','2018年','2019-07-20','小企业会计制度','USD','美元','工商银行','3326 5805 0548 850008','RSCC000001','RS000004','GS000001','2021-08-27 19:21:53','1'),
	('AS000009','账套2019','2019年','2021-07-21','合伙制会计制度','RMB','人民币','招商银行','3326 5805 0548 850009','RSCC000001','RS000005','GS000002','2021-08-20 17:41:53','1'),
	('AS000010','账套2017','2017年','2020-08-25','企业会计制度','USD','美元','工商银行','3326 5805 0548 850010','RSCC000001','RS000005','GS000002','2021-09-08 10:27:53','1'),
	('AS000011','账套2018','2018年','2020-04-04','小企业会计制度','RMB','人民币','招商银行','3326 5805 0548 850011','RSCC000001','RS000006','GS000002','2021-08-20 12:02:38','1'),
	('AS000012','账套2019','2019年','2019-09-17','合伙制会计制度','USD','美元','工商银行','3326 5805 0548 850012','RSCC000001','RS000006','GS000002','2021-08-21 16:31:11','1'),
	('AS000013','账套2017','2017年','2021-02-23','企业会计制度','RMB','人民币','招商银行','3326 5805 0548 850013','RSCC000001','RS000007','GS000002','2021-09-03 15:35:58','1'),
	('AS000014','账套2018','2018年','2019-12-22','小企业会计制度','USD','美元','工商银行','3326 5805 0548 850014','RSCC000001','RS000007','GS000002','2021-09-04 05:11:23','1'),
	('AS000015','账套2019','2019年','2021-01-04','合伙制会计制度','RMB','人民币','招商银行','3326 5805 0548 850015','RSCC000001','RS000008','GS000002','2021-08-27 08:14:48','1'),
	('AS000016','账套2017','2017年','2019-02-02','企业会计制度','USD','美元','工商银行','3326 5805 0548 850016','RSCC000001','RS000008','GS000002','2021-08-30 18:26:37','1');

insert into accounting_subject_data values
	('AS000001','AS99990001','银行存款0001','1','资产类','AS000001','1'),
	('AS000002','AS99990002','银行存款0002','2','负债类','AS000001','1'),
	('AS000003','AS99990003','银行存款0003','3','共同类','AS000002','1'),
	('AS000004','AS99990004','银行存款0004','4','所有者权益类','AS000002','1'),
	('AS000005','AS99990005','银行存款0005','5','成本类','AS000003','1'),
	('AS000006','AS99990006','银行存款0006','6','损益类','AS000003','1'),
	('AS000007','AS99990007','银行存款0007','1','资产类','AS000004','1'),
	('AS000008','AS99990008','银行存款0008','2','负债类','AS000004','1'),
	('AS000009','AS99990009','银行存款0009','3','共同类','AS000005','1'),
	('AS000010','AS99990010','银行存款0010','4','所有者权益类','AS000005','1'),
	('AS000011','AS99990011','银行存款0011','5','成本类','AS000006','1'),
	('AS000012','AS99990012','银行存款0012','6','损益类','AS000006','1'),
	('AS000013','AS99990013','银行存款0013','1','资产类','AS000007','1'),
	('AS000014','AS99990014','银行存款0014','2','负债类','AS000007','1'),
	('AS000015','AS99990015','银行存款0015','3','共同类','AS000008','1'),
	('AS000016','AS99990016','银行存款0016','4','所有者权益类','AS000008','1'),
	('AS000017','AS99990017','银行存款0017','5','成本类','AS000009','1'),
	('AS000018','AS99990018','银行存款0018','6','损益类','AS000009','1'),
	('AS000019','AS99990019','银行存款0019','1','资产类','AS000010','1'),
	('AS000020','AS99990020','银行存款0020','2','负债类','AS000010','1'),
	('AS000021','AS99990021','银行存款0021','3','共同类','AS000011','1'),
	('AS000022','AS99990022','银行存款0022','4','所有者权益类','AS000011','1'),
	('AS000023','AS99990023','银行存款0023','5','成本类','AS000012','1'),
	('AS000024','AS99990024','银行存款0024','6','损益类','AS000012','1'),
	('AS000025','AS99990025','银行存款0025','1','资产类','AS000013','1'),
	('AS000026','AS99990026','银行存款0026','2','负债类','AS000013','1'),
	('AS000027','AS99990027','银行存款0027','3','共同类','AS000014','1'),
	('AS000028','AS99990028','银行存款0028','4','所有者权益类','AS000014','1'),
	('AS000029','AS99990029','银行存款0029','5','成本类','AS000015','1'),
	('AS000030','AS99990030','银行存款0030','6','损益类','AS000015','1'),
	('AS000031','AS99990031','银行存款0031','1','资产类','AS000016','1'),
	('AS000032','AS99990032','银行存款0032','2','负债类','AS000016','1');

insert into accounting_period_data values
	('AP000001','2017年1月','2021-06-25','2020-05-23','AS000001','1'),
	('AP000002','2017年2月','2020-10-24','2021-04-20','AS000001','1'),
	('AP000003','2017年3月','2020-05-26','2018-11-24','AS000002','1'),
	('AP000004','2017年4月','2019-08-07','2021-05-29','AS000002','1'),
	('AP000005','2017年5月','2018-11-27','2021-01-31','AS000003','1'),
	('AP000006','2017年6月','2019-01-09','2021-08-21','AS000003','1'),
	('AP000007','2017年7月','2020-04-19','2019-08-22','AS000004','1'),
	('AP000008','2017年8月','2020-08-23','2019-12-24','AS000004','1'),
	('AP000009','2017年9月','2019-02-11','2018-12-04','AS000005','1'),
	('AP000010','2017年10月','2020-10-13','2020-03-05','AS000005','1'),
	('AP000011','2017年11月','2021-02-06','2020-07-29','AS000006','1'),
	('AP000012','2017年12月','2019-04-23','2018-09-28','AS000006','1'),
	('AP000013','2017年1月','2020-05-20','2021-03-28','AS000007','1'),
	('AP000014','2017年2月','2020-04-26','2020-11-13','AS000007','1'),
	('AP000015','2017年3月','2020-02-01','2020-06-19','AS000008','1'),
	('AP000016','2017年4月','2020-03-06','2019-01-09','AS000008','1'),
	('AP000017','2017年5月','2021-03-07','2018-10-16','AS000009','1'),
	('AP000018','2017年6月','2021-02-12','2018-11-20','AS000009','1'),
	('AP000019','2017年7月','2020-07-17','2018-10-22','AS000010','1'),
	('AP000020','2017年8月','2019-12-30','2019-11-29','AS000010','1'),
	('AP000021','2017年9月','2021-04-04','2020-09-13','AS000011','1'),
	('AP000022','2017年10月','2019-09-25','2020-01-04','AS000011','1'),
	('AP000023','2017年11月','2019-08-13','2020-11-26','AS000012','1'),
	('AP000024','2017年12月','2020-01-11','2019-10-18','AS000012','1'),
	('AP000025','2017年1月','2019-03-05','2021-06-26','AS000013','1'),
	('AP000026','2017年2月','2018-12-07','2019-10-11','AS000013','1'),
	('AP000027','2017年3月','2021-08-04','2020-09-13','AS000014','1'),
	('AP000028','2017年4月','2020-11-26','2019-12-21','AS000014','1'),
	('AP000029','2017年5月','2018-10-14','2019-06-08','AS000015','1'),
	('AP000030','2017年6月','2020-10-19','2018-12-14','AS000015','1'),
	('AP000031','2017年7月','2019-03-23','2019-06-16','AS000016','1'),
	('AP000032','2017年8月','2021-04-22','2018-11-08','AS000016','1');

insert into accounting_document_type_data values
	('ADT000001','记账凭证','又称记账凭单，是会计人员根据审核无误的原始凭证按照经济业务事项的内容加以分类，并据以确定会计分录后所填制的会计凭证。它是登记账簿的直接依据。0001','AS000001','1'),
	('ADT000002','收款凭证','又称记账凭单，是会计人员根据审核无误的原始凭证按照经济业务事项的内容加以分类，并据以确定会计分录后所填制的会计凭证。它是登记账簿的直接依据。0002','AS000001','1'),
	('ADT000003','付款凭证','又称记账凭单，是会计人员根据审核无误的原始凭证按照经济业务事项的内容加以分类，并据以确定会计分录后所填制的会计凭证。它是登记账簿的直接依据。0003','AS000002','1'),
	('ADT000004','记账凭证','又称记账凭单，是会计人员根据审核无误的原始凭证按照经济业务事项的内容加以分类，并据以确定会计分录后所填制的会计凭证。它是登记账簿的直接依据。0004','AS000002','1'),
	('ADT000005','收款凭证','又称记账凭单，是会计人员根据审核无误的原始凭证按照经济业务事项的内容加以分类，并据以确定会计分录后所填制的会计凭证。它是登记账簿的直接依据。0005','AS000003','1'),
	('ADT000006','付款凭证','又称记账凭单，是会计人员根据审核无误的原始凭证按照经济业务事项的内容加以分类，并据以确定会计分录后所填制的会计凭证。它是登记账簿的直接依据。0006','AS000003','1'),
	('ADT000007','记账凭证','又称记账凭单，是会计人员根据审核无误的原始凭证按照经济业务事项的内容加以分类，并据以确定会计分录后所填制的会计凭证。它是登记账簿的直接依据。0007','AS000004','1'),
	('ADT000008','收款凭证','又称记账凭单，是会计人员根据审核无误的原始凭证按照经济业务事项的内容加以分类，并据以确定会计分录后所填制的会计凭证。它是登记账簿的直接依据。0008','AS000004','1'),
	('ADT000009','付款凭证','又称记账凭单，是会计人员根据审核无误的原始凭证按照经济业务事项的内容加以分类，并据以确定会计分录后所填制的会计凭证。它是登记账簿的直接依据。0009','AS000005','1'),
	('ADT000010','记账凭证','又称记账凭单，是会计人员根据审核无误的原始凭证按照经济业务事项的内容加以分类，并据以确定会计分录后所填制的会计凭证。它是登记账簿的直接依据。0010','AS000005','1'),
	('ADT000011','收款凭证','又称记账凭单，是会计人员根据审核无误的原始凭证按照经济业务事项的内容加以分类，并据以确定会计分录后所填制的会计凭证。它是登记账簿的直接依据。0011','AS000006','1'),
	('ADT000012','付款凭证','又称记账凭单，是会计人员根据审核无误的原始凭证按照经济业务事项的内容加以分类，并据以确定会计分录后所填制的会计凭证。它是登记账簿的直接依据。0012','AS000006','1'),
	('ADT000013','记账凭证','又称记账凭单，是会计人员根据审核无误的原始凭证按照经济业务事项的内容加以分类，并据以确定会计分录后所填制的会计凭证。它是登记账簿的直接依据。0013','AS000007','1'),
	('ADT000014','收款凭证','又称记账凭单，是会计人员根据审核无误的原始凭证按照经济业务事项的内容加以分类，并据以确定会计分录后所填制的会计凭证。它是登记账簿的直接依据。0014','AS000007','1'),
	('ADT000015','付款凭证','又称记账凭单，是会计人员根据审核无误的原始凭证按照经济业务事项的内容加以分类，并据以确定会计分录后所填制的会计凭证。它是登记账簿的直接依据。0015','AS000008','1'),
	('ADT000016','记账凭证','又称记账凭单，是会计人员根据审核无误的原始凭证按照经济业务事项的内容加以分类，并据以确定会计分录后所填制的会计凭证。它是登记账簿的直接依据。0016','AS000008','1'),
	('ADT000017','收款凭证','又称记账凭单，是会计人员根据审核无误的原始凭证按照经济业务事项的内容加以分类，并据以确定会计分录后所填制的会计凭证。它是登记账簿的直接依据。0017','AS000009','1'),
	('ADT000018','付款凭证','又称记账凭单，是会计人员根据审核无误的原始凭证按照经济业务事项的内容加以分类，并据以确定会计分录后所填制的会计凭证。它是登记账簿的直接依据。0018','AS000009','1'),
	('ADT000019','记账凭证','又称记账凭单，是会计人员根据审核无误的原始凭证按照经济业务事项的内容加以分类，并据以确定会计分录后所填制的会计凭证。它是登记账簿的直接依据。0019','AS000010','1'),
	('ADT000020','收款凭证','又称记账凭单，是会计人员根据审核无误的原始凭证按照经济业务事项的内容加以分类，并据以确定会计分录后所填制的会计凭证。它是登记账簿的直接依据。0020','AS000010','1'),
	('ADT000021','付款凭证','又称记账凭单，是会计人员根据审核无误的原始凭证按照经济业务事项的内容加以分类，并据以确定会计分录后所填制的会计凭证。它是登记账簿的直接依据。0021','AS000011','1'),
	('ADT000022','记账凭证','又称记账凭单，是会计人员根据审核无误的原始凭证按照经济业务事项的内容加以分类，并据以确定会计分录后所填制的会计凭证。它是登记账簿的直接依据。0022','AS000011','1'),
	('ADT000023','收款凭证','又称记账凭单，是会计人员根据审核无误的原始凭证按照经济业务事项的内容加以分类，并据以确定会计分录后所填制的会计凭证。它是登记账簿的直接依据。0023','AS000012','1'),
	('ADT000024','付款凭证','又称记账凭单，是会计人员根据审核无误的原始凭证按照经济业务事项的内容加以分类，并据以确定会计分录后所填制的会计凭证。它是登记账簿的直接依据。0024','AS000012','1'),
	('ADT000025','记账凭证','又称记账凭单，是会计人员根据审核无误的原始凭证按照经济业务事项的内容加以分类，并据以确定会计分录后所填制的会计凭证。它是登记账簿的直接依据。0025','AS000013','1'),
	('ADT000026','收款凭证','又称记账凭单，是会计人员根据审核无误的原始凭证按照经济业务事项的内容加以分类，并据以确定会计分录后所填制的会计凭证。它是登记账簿的直接依据。0026','AS000013','1'),
	('ADT000027','付款凭证','又称记账凭单，是会计人员根据审核无误的原始凭证按照经济业务事项的内容加以分类，并据以确定会计分录后所填制的会计凭证。它是登记账簿的直接依据。0027','AS000014','1'),
	('ADT000028','记账凭证','又称记账凭单，是会计人员根据审核无误的原始凭证按照经济业务事项的内容加以分类，并据以确定会计分录后所填制的会计凭证。它是登记账簿的直接依据。0028','AS000014','1'),
	('ADT000029','收款凭证','又称记账凭单，是会计人员根据审核无误的原始凭证按照经济业务事项的内容加以分类，并据以确定会计分录后所填制的会计凭证。它是登记账簿的直接依据。0029','AS000015','1'),
	('ADT000030','付款凭证','又称记账凭单，是会计人员根据审核无误的原始凭证按照经济业务事项的内容加以分类，并据以确定会计分录后所填制的会计凭证。它是登记账簿的直接依据。0030','AS000015','1'),
	('ADT000031','记账凭证','又称记账凭单，是会计人员根据审核无误的原始凭证按照经济业务事项的内容加以分类，并据以确定会计分录后所填制的会计凭证。它是登记账簿的直接依据。0031','AS000016','1'),
	('ADT000032','收款凭证','又称记账凭单，是会计人员根据审核无误的原始凭证按照经济业务事项的内容加以分类，并据以确定会计分录后所填制的会计凭证。它是登记账簿的直接依据。0032','AS000016','1');

insert into accounting_document_data values
	('AD000001','记账凭证0001','2019-02-12','AP000001','ADT000001','1'),
	('AD000002','记账凭证0002','2020-04-22','AP000001','ADT000001','1'),
	('AD000003','记账凭证0003','2020-01-24','AP000002','ADT000002','1'),
	('AD000004','记账凭证0004','2020-10-09','AP000002','ADT000002','1'),
	('AD000005','记账凭证0005','2021-03-06','AP000003','ADT000003','1'),
	('AD000006','记账凭证0006','2019-02-13','AP000003','ADT000003','1'),
	('AD000007','记账凭证0007','2018-09-14','AP000004','ADT000004','1'),
	('AD000008','记账凭证0008','2019-01-17','AP000004','ADT000004','1'),
	('AD000009','记账凭证0009','2019-09-28','AP000005','ADT000005','1'),
	('AD000010','记账凭证0010','2021-01-20','AP000005','ADT000005','1'),
	('AD000011','记账凭证0011','2018-09-23','AP000006','ADT000006','1'),
	('AD000012','记账凭证0012','2019-02-11','AP000006','ADT000006','1'),
	('AD000013','记账凭证0013','2018-10-17','AP000007','ADT000007','1'),
	('AD000014','记账凭证0014','2020-01-06','AP000007','ADT000007','1'),
	('AD000015','记账凭证0015','2020-01-27','AP000008','ADT000008','1'),
	('AD000016','记账凭证0016','2019-04-22','AP000008','ADT000008','1'),
	('AD000017','记账凭证0017','2020-07-06','AP000009','ADT000009','1'),
	('AD000018','记账凭证0018','2020-01-09','AP000009','ADT000009','1'),
	('AD000019','记账凭证0019','2020-10-22','AP000010','ADT000010','1'),
	('AD000020','记账凭证0020','2020-06-08','AP000010','ADT000010','1'),
	('AD000021','记账凭证0021','2019-09-14','AP000011','ADT000011','1'),
	('AD000022','记账凭证0022','2020-02-15','AP000011','ADT000011','1'),
	('AD000023','记账凭证0023','2020-04-21','AP000012','ADT000012','1'),
	('AD000024','记账凭证0024','2021-03-08','AP000012','ADT000012','1'),
	('AD000025','记账凭证0025','2019-04-14','AP000013','ADT000013','1'),
	('AD000026','记账凭证0026','2019-11-07','AP000013','ADT000013','1'),
	('AD000027','记账凭证0027','2020-09-28','AP000014','ADT000014','1'),
	('AD000028','记账凭证0028','2020-04-04','AP000014','ADT000014','1'),
	('AD000029','记账凭证0029','2018-12-26','AP000015','ADT000015','1'),
	('AD000030','记账凭证0030','2020-02-08','AP000015','ADT000015','1'),
	('AD000031','记账凭证0031','2020-09-03','AP000016','ADT000016','1'),
	('AD000032','记账凭证0032','2020-11-13','AP000016','ADT000016','1'),
	('AD000033','记账凭证0033','2020-12-21','AP000017','ADT000017','1'),
	('AD000034','记账凭证0034','2020-01-23','AP000017','ADT000017','1'),
	('AD000035','记账凭证0035','2020-10-04','AP000018','ADT000018','1'),
	('AD000036','记账凭证0036','2020-06-10','AP000018','ADT000018','1'),
	('AD000037','记账凭证0037','2018-12-21','AP000019','ADT000019','1'),
	('AD000038','记账凭证0038','2020-11-08','AP000019','ADT000019','1'),
	('AD000039','记账凭证0039','2019-08-23','AP000020','ADT000020','1'),
	('AD000040','记账凭证0040','2020-06-30','AP000020','ADT000020','1'),
	('AD000041','记账凭证0041','2021-02-25','AP000021','ADT000021','1'),
	('AD000042','记账凭证0042','2021-01-03','AP000021','ADT000021','1'),
	('AD000043','记账凭证0043','2020-04-16','AP000022','ADT000022','1'),
	('AD000044','记账凭证0044','2021-07-11','AP000022','ADT000022','1'),
	('AD000045','记账凭证0045','2020-10-02','AP000023','ADT000023','1'),
	('AD000046','记账凭证0046','2019-03-25','AP000023','ADT000023','1'),
	('AD000047','记账凭证0047','2019-10-30','AP000024','ADT000024','1'),
	('AD000048','记账凭证0048','2018-12-25','AP000024','ADT000024','1'),
	('AD000049','记账凭证0049','2020-12-07','AP000025','ADT000025','1'),
	('AD000050','记账凭证0050','2019-09-10','AP000025','ADT000025','1'),
	('AD000051','记账凭证0051','2020-03-24','AP000026','ADT000026','1'),
	('AD000052','记账凭证0052','2020-12-30','AP000026','ADT000026','1'),
	('AD000053','记账凭证0053','2019-02-28','AP000027','ADT000027','1'),
	('AD000054','记账凭证0054','2020-03-26','AP000027','ADT000027','1'),
	('AD000055','记账凭证0055','2020-12-02','AP000028','ADT000028','1'),
	('AD000056','记账凭证0056','2021-02-08','AP000028','ADT000028','1'),
	('AD000057','记账凭证0057','2019-11-07','AP000029','ADT000029','1'),
	('AD000058','记账凭证0058','2020-08-10','AP000029','ADT000029','1'),
	('AD000059','记账凭证0059','2019-07-26','AP000030','ADT000030','1'),
	('AD000060','记账凭证0060','2019-02-11','AP000030','ADT000030','1'),
	('AD000061','记账凭证0061','2021-08-18','AP000031','ADT000031','1'),
	('AD000062','记账凭证0062','2018-10-26','AP000031','ADT000031','1'),
	('AD000063','记账凭证0063','2019-11-27','AP000032','ADT000032','1'),
	('AD000064','记账凭证0064','2020-06-17','AP000032','ADT000032','1');

insert into original_voucher_data values
	('OV000001','这是手写的发票0001','李亚青0001','本公司0001','原始凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0001/400/200/grey/','AD000001','1'),
	('OV000002','这是手写的发票0002','李亚青0002','本公司0002','发票','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0002/400/200/grey/','AD000001','1'),
	('OV000003','这是手写的发票0003','李亚青0003','本公司0003','出库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0003/400/200/grey/','AD000002','1'),
	('OV000004','这是手写的发票0004','李亚青0004','本公司0004','入库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0004/400/200/grey/','AD000002','1'),
	('OV000005','这是手写的发票0005','李亚青0005','本公司0005','存款回执','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0005/400/200/grey/','AD000003','1'),
	('OV000006','这是手写的发票0006','李亚青0006','本公司0006','验收证明','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0006/400/200/grey/','AD000004','1'),
	('OV000007','这是手写的发票0007','李亚青0007','本公司0007','借款凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0007/400/200/grey/','AD000004','1'),
	('OV000008','这是手写的发票0008','李亚青0008','本公司0008','原始凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0008/400/200/grey/','AD000005','1'),
	('OV000009','这是手写的发票0009','李亚青0009','本公司0009','发票','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0009/400/200/grey/','AD000006','1'),
	('OV000010','这是手写的发票0010','李亚青0010','本公司0010','出库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0010/400/200/grey/','AD000006','1'),
	('OV000011','这是手写的发票0011','李亚青0011','本公司0011','入库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0011/400/200/grey/','AD000007','1'),
	('OV000012','这是手写的发票0012','李亚青0012','本公司0012','存款回执','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0012/400/200/grey/','AD000008','1'),
	('OV000013','这是手写的发票0013','李亚青0013','本公司0013','验收证明','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0013/400/200/grey/','AD000008','1'),
	('OV000014','这是手写的发票0014','李亚青0014','本公司0014','借款凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0014/400/200/grey/','AD000009','1'),
	('OV000015','这是手写的发票0015','李亚青0015','本公司0015','原始凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0015/400/200/grey/','AD000009','1'),
	('OV000016','这是手写的发票0016','李亚青0016','本公司0016','发票','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0016/400/200/grey/','AD000010','1'),
	('OV000017','这是手写的发票0017','李亚青0017','本公司0017','出库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0017/400/200/grey/','AD000011','1'),
	('OV000018','这是手写的发票0018','李亚青0018','本公司0018','入库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0018/400/200/grey/','AD000011','1'),
	('OV000019','这是手写的发票0019','李亚青0019','本公司0019','存款回执','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0019/400/200/grey/','AD000012','1'),
	('OV000020','这是手写的发票0020','李亚青0020','本公司0020','验收证明','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0020/400/200/grey/','AD000013','1'),
	('OV000021','这是手写的发票0021','李亚青0021','本公司0021','借款凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0021/400/200/grey/','AD000013','1'),
	('OV000022','这是手写的发票0022','李亚青0022','本公司0022','原始凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0022/400/200/grey/','AD000014','1'),
	('OV000023','这是手写的发票0023','李亚青0023','本公司0023','发票','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0023/400/200/grey/','AD000015','1'),
	('OV000024','这是手写的发票0024','李亚青0024','本公司0024','出库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0024/400/200/grey/','AD000015','1'),
	('OV000025','这是手写的发票0025','李亚青0025','本公司0025','入库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0025/400/200/grey/','AD000016','1'),
	('OV000026','这是手写的发票0026','李亚青0026','本公司0026','存款回执','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0026/400/200/grey/','AD000017','1'),
	('OV000027','这是手写的发票0027','李亚青0027','本公司0027','验收证明','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0027/400/200/grey/','AD000017','1'),
	('OV000028','这是手写的发票0028','李亚青0028','本公司0028','借款凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0028/400/200/grey/','AD000018','1'),
	('OV000029','这是手写的发票0029','李亚青0029','本公司0029','原始凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0029/400/200/grey/','AD000018','1'),
	('OV000030','这是手写的发票0030','李亚青0030','本公司0030','发票','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0030/400/200/grey/','AD000019','1'),
	('OV000031','这是手写的发票0031','李亚青0031','本公司0031','出库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0031/400/200/grey/','AD000020','1'),
	('OV000032','这是手写的发票0032','李亚青0032','本公司0032','入库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0032/400/200/grey/','AD000020','1'),
	('OV000033','这是手写的发票0033','李亚青0033','本公司0033','存款回执','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0033/400/200/grey/','AD000021','1'),
	('OV000034','这是手写的发票0034','李亚青0034','本公司0034','验收证明','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0034/400/200/grey/','AD000022','1'),
	('OV000035','这是手写的发票0035','李亚青0035','本公司0035','借款凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0035/400/200/grey/','AD000022','1'),
	('OV000036','这是手写的发票0036','李亚青0036','本公司0036','原始凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0036/400/200/grey/','AD000023','1'),
	('OV000037','这是手写的发票0037','李亚青0037','本公司0037','发票','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0037/400/200/grey/','AD000024','1'),
	('OV000038','这是手写的发票0038','李亚青0038','本公司0038','出库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0038/400/200/grey/','AD000024','1'),
	('OV000039','这是手写的发票0039','李亚青0039','本公司0039','入库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0039/400/200/grey/','AD000025','1'),
	('OV000040','这是手写的发票0040','李亚青0040','本公司0040','存款回执','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0040/400/200/grey/','AD000025','1'),
	('OV000041','这是手写的发票0041','李亚青0041','本公司0041','验收证明','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0041/400/200/grey/','AD000026','1'),
	('OV000042','这是手写的发票0042','李亚青0042','本公司0042','借款凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0042/400/200/grey/','AD000027','1'),
	('OV000043','这是手写的发票0043','李亚青0043','本公司0043','原始凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0043/400/200/grey/','AD000027','1'),
	('OV000044','这是手写的发票0044','李亚青0044','本公司0044','发票','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0044/400/200/grey/','AD000028','1'),
	('OV000045','这是手写的发票0045','李亚青0045','本公司0045','出库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0045/400/200/grey/','AD000029','1'),
	('OV000046','这是手写的发票0046','李亚青0046','本公司0046','入库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0046/400/200/grey/','AD000029','1'),
	('OV000047','这是手写的发票0047','李亚青0047','本公司0047','存款回执','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0047/400/200/grey/','AD000030','1'),
	('OV000048','这是手写的发票0048','李亚青0048','本公司0048','验收证明','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0048/400/200/grey/','AD000031','1'),
	('OV000049','这是手写的发票0049','李亚青0049','本公司0049','借款凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0049/400/200/grey/','AD000031','1'),
	('OV000050','这是手写的发票0050','李亚青0050','本公司0050','原始凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0050/400/200/grey/','AD000032','1'),
	('OV000051','这是手写的发票0051','李亚青0051','本公司0051','发票','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0051/400/200/grey/','AD000033','1'),
	('OV000052','这是手写的发票0052','李亚青0052','本公司0052','出库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0052/400/200/grey/','AD000033','1'),
	('OV000053','这是手写的发票0053','李亚青0053','本公司0053','入库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0053/400/200/grey/','AD000034','1'),
	('OV000054','这是手写的发票0054','李亚青0054','本公司0054','存款回执','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0054/400/200/grey/','AD000034','1'),
	('OV000055','这是手写的发票0055','李亚青0055','本公司0055','验收证明','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0055/400/200/grey/','AD000035','1'),
	('OV000056','这是手写的发票0056','李亚青0056','本公司0056','借款凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0056/400/200/grey/','AD000036','1'),
	('OV000057','这是手写的发票0057','李亚青0057','本公司0057','原始凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0057/400/200/grey/','AD000036','1'),
	('OV000058','这是手写的发票0058','李亚青0058','本公司0058','发票','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0058/400/200/grey/','AD000037','1'),
	('OV000059','这是手写的发票0059','李亚青0059','本公司0059','出库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0059/400/200/grey/','AD000038','1'),
	('OV000060','这是手写的发票0060','李亚青0060','本公司0060','入库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0060/400/200/grey/','AD000038','1'),
	('OV000061','这是手写的发票0061','李亚青0061','本公司0061','存款回执','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0061/400/200/grey/','AD000039','1'),
	('OV000062','这是手写的发票0062','李亚青0062','本公司0062','验收证明','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0062/400/200/grey/','AD000040','1'),
	('OV000063','这是手写的发票0063','李亚青0063','本公司0063','借款凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0063/400/200/grey/','AD000040','1'),
	('OV000064','这是手写的发票0064','李亚青0064','本公司0064','原始凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0064/400/200/grey/','AD000041','1'),
	('OV000065','这是手写的发票0065','李亚青0065','本公司0065','发票','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0065/400/200/grey/','AD000041','1'),
	('OV000066','这是手写的发票0066','李亚青0066','本公司0066','出库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0066/400/200/grey/','AD000042','1'),
	('OV000067','这是手写的发票0067','李亚青0067','本公司0067','入库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0067/400/200/grey/','AD000043','1'),
	('OV000068','这是手写的发票0068','李亚青0068','本公司0068','存款回执','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0068/400/200/grey/','AD000043','1'),
	('OV000069','这是手写的发票0069','李亚青0069','本公司0069','验收证明','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0069/400/200/grey/','AD000044','1'),
	('OV000070','这是手写的发票0070','李亚青0070','本公司0070','借款凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0070/400/200/grey/','AD000045','1'),
	('OV000071','这是手写的发票0071','李亚青0071','本公司0071','原始凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0071/400/200/grey/','AD000045','1'),
	('OV000072','这是手写的发票0072','李亚青0072','本公司0072','发票','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0072/400/200/grey/','AD000046','1'),
	('OV000073','这是手写的发票0073','李亚青0073','本公司0073','出库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0073/400/200/grey/','AD000047','1'),
	('OV000074','这是手写的发票0074','李亚青0074','本公司0074','入库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0074/400/200/grey/','AD000047','1'),
	('OV000075','这是手写的发票0075','李亚青0075','本公司0075','存款回执','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0075/400/200/grey/','AD000048','1'),
	('OV000076','这是手写的发票0076','李亚青0076','本公司0076','验收证明','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0076/400/200/grey/','AD000049','1'),
	('OV000077','这是手写的发票0077','李亚青0077','本公司0077','借款凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0077/400/200/grey/','AD000049','1'),
	('OV000078','这是手写的发票0078','李亚青0078','本公司0078','原始凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0078/400/200/grey/','AD000050','1'),
	('OV000079','这是手写的发票0079','李亚青0079','本公司0079','发票','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0079/400/200/grey/','AD000050','1'),
	('OV000080','这是手写的发票0080','李亚青0080','本公司0080','出库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0080/400/200/grey/','AD000051','1'),
	('OV000081','这是手写的发票0081','李亚青0081','本公司0081','入库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0081/400/200/grey/','AD000052','1'),
	('OV000082','这是手写的发票0082','李亚青0082','本公司0082','存款回执','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0082/400/200/grey/','AD000052','1'),
	('OV000083','这是手写的发票0083','李亚青0083','本公司0083','验收证明','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0083/400/200/grey/','AD000053','1'),
	('OV000084','这是手写的发票0084','李亚青0084','本公司0084','借款凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0084/400/200/grey/','AD000054','1'),
	('OV000085','这是手写的发票0085','李亚青0085','本公司0085','原始凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0085/400/200/grey/','AD000054','1'),
	('OV000086','这是手写的发票0086','李亚青0086','本公司0086','发票','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0086/400/200/grey/','AD000055','1'),
	('OV000087','这是手写的发票0087','李亚青0087','本公司0087','出库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0087/400/200/grey/','AD000056','1'),
	('OV000088','这是手写的发票0088','李亚青0088','本公司0088','入库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0088/400/200/grey/','AD000056','1'),
	('OV000089','这是手写的发票0089','李亚青0089','本公司0089','存款回执','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0089/400/200/grey/','AD000057','1'),
	('OV000090','这是手写的发票0090','李亚青0090','本公司0090','验收证明','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0090/400/200/grey/','AD000057','1'),
	('OV000091','这是手写的发票0091','李亚青0091','本公司0091','借款凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0091/400/200/grey/','AD000058','1'),
	('OV000092','这是手写的发票0092','李亚青0092','本公司0092','原始凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0092/400/200/grey/','AD000059','1'),
	('OV000093','这是手写的发票0093','李亚青0093','本公司0093','发票','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0093/400/200/grey/','AD000059','1'),
	('OV000094','这是手写的发票0094','李亚青0094','本公司0094','出库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0094/400/200/grey/','AD000060','1'),
	('OV000095','这是手写的发票0095','李亚青0095','本公司0095','入库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0095/400/200/grey/','AD000061','1'),
	('OV000096','这是手写的发票0096','李亚青0096','本公司0096','存款回执','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0096/400/200/grey/','AD000061','1'),
	('OV000097','这是手写的发票0097','李亚青0097','本公司0097','验收证明','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0097/400/200/grey/','AD000062','1'),
	('OV000098','这是手写的发票0098','李亚青0098','本公司0098','借款凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0098/400/200/grey/','AD000063','1'),
	('OV000099','这是手写的发票0099','李亚青0099','本公司0099','原始凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0099/400/200/grey/','AD000063','1'),
	('OV000100','这是手写的发票0100','李亚青0100','本公司0100','发票','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing0100/400/200/grey/','AD000064','1');

insert into accounting_document_line_data values
	('ADL000001','收到存款0001','AS99990001','借','752993.00','AD000001','AS000001','1'),
	('ADL000002','收到存款0002','AS99990002','贷','891988.12','AD000001','AS000001','1'),
	('ADL000003','收到存款0003','AS99990003','借','982584.38','AD000002','AS000001','1'),
	('ADL000004','收到存款0004','AS99990004','贷','888074.81','AD000002','AS000001','1'),
	('ADL000005','收到存款0005','AS99990005','借','928615.81','AD000003','AS000002','1'),
	('ADL000006','收到存款0006','AS99990006','贷','953417.50','AD000004','AS000002','1'),
	('ADL000007','收到存款0007','AS99990007','借','878644.62','AD000004','AS000002','1'),
	('ADL000008','收到存款0008','AS99990008','贷','819456.19','AD000005','AS000003','1'),
	('ADL000009','收到存款0009','AS99990009','借','746684.00','AD000006','AS000003','1'),
	('ADL000010','收到存款0010','AS99990010','贷','974219.12','AD000006','AS000003','1'),
	('ADL000011','收到存款0011','AS99990011','借','773991.25','AD000007','AS000004','1'),
	('ADL000012','收到存款0012','AS99990012','贷','842397.38','AD000008','AS000004','1'),
	('ADL000013','收到存款0013','AS99990013','借','930373.81','AD000008','AS000004','1'),
	('ADL000014','收到存款0014','AS99990014','贷','726665.44','AD000009','AS000005','1'),
	('ADL000015','收到存款0015','AS99990015','借','965916.00','AD000009','AS000005','1'),
	('ADL000016','收到存款0016','AS99990016','贷','836438.69','AD000010','AS000005','1'),
	('ADL000017','收到存款0017','AS99990017','借','869331.06','AD000011','AS000006','1'),
	('ADL000018','收到存款0018','AS99990018','贷','963124.88','AD000011','AS000006','1'),
	('ADL000019','收到存款0019','AS99990019','借','935391.00','AD000012','AS000006','1'),
	('ADL000020','收到存款0020','AS99990020','贷','723215.38','AD000013','AS000007','1'),
	('ADL000021','收到存款0021','AS99990021','借','877815.44','AD000013','AS000007','1'),
	('ADL000022','收到存款0022','AS99990022','贷','863312.44','AD000014','AS000007','1'),
	('ADL000023','收到存款0023','AS99990023','借','945583.44','AD000015','AS000008','1'),
	('ADL000024','收到存款0024','AS99990024','贷','846307.00','AD000015','AS000008','1'),
	('ADL000025','收到存款0025','AS99990025','借','706382.50','AD000016','AS000008','1'),
	('ADL000026','收到存款0026','AS99990026','贷','859039.81','AD000017','AS000009','1'),
	('ADL000027','收到存款0027','AS99990027','借','727194.44','AD000017','AS000009','1'),
	('ADL000028','收到存款0028','AS99990028','贷','821427.44','AD000018','AS000009','1'),
	('ADL000029','收到存款0029','AS99990029','借','771551.81','AD000018','AS000009','1'),
	('ADL000030','收到存款0030','AS99990030','贷','757673.06','AD000019','AS000010','1'),
	('ADL000031','收到存款0031','AS99990031','借','780082.75','AD000020','AS000010','1'),
	('ADL000032','收到存款0032','AS99990032','贷','697482.75','AD000020','AS000010','1'),
	('ADL000033','收到存款0033','AS99990033','借','968159.06','AD000021','AS000011','1'),
	('ADL000034','收到存款0034','AS99990034','贷','879089.75','AD000022','AS000011','1'),
	('ADL000035','收到存款0035','AS99990035','借','754088.44','AD000022','AS000011','1'),
	('ADL000036','收到存款0036','AS99990036','贷','742478.56','AD000023','AS000012','1'),
	('ADL000037','收到存款0037','AS99990037','借','906299.38','AD000024','AS000012','1'),
	('ADL000038','收到存款0038','AS99990038','贷','881533.44','AD000024','AS000012','1'),
	('ADL000039','收到存款0039','AS99990039','借','811177.44','AD000025','AS000013','1'),
	('ADL000040','收到存款0040','AS99990040','贷','984168.81','AD000025','AS000013','1'),
	('ADL000041','收到存款0041','AS99990041','借','844010.25','AD000026','AS000013','1'),
	('ADL000042','收到存款0042','AS99990042','贷','789047.19','AD000027','AS000014','1'),
	('ADL000043','收到存款0043','AS99990043','借','711754.31','AD000027','AS000014','1'),
	('ADL000044','收到存款0044','AS99990044','贷','692674.38','AD000028','AS000014','1'),
	('ADL000045','收到存款0045','AS99990045','借','788735.44','AD000029','AS000015','1'),
	('ADL000046','收到存款0046','AS99990046','贷','793968.69','AD000029','AS000015','1'),
	('ADL000047','收到存款0047','AS99990047','借','934033.25','AD000030','AS000015','1'),
	('ADL000048','收到存款0048','AS99990048','贷','786681.38','AD000031','AS000016','1'),
	('ADL000049','收到存款0049','AS99990049','借','962968.81','AD000031','AS000016','1'),
	('ADL000050','收到存款0050','AS99990050','贷','959597.38','AD000032','AS000016','1'),
	('ADL000051','收到存款0051','AS99990051','借','960522.50','AD000033','AS000017','1'),
	('ADL000052','收到存款0052','AS99990052','贷','871958.50','AD000033','AS000017','1'),
	('ADL000053','收到存款0053','AS99990053','借','784301.06','AD000034','AS000017','1'),
	('ADL000054','收到存款0054','AS99990054','贷','889567.12','AD000034','AS000017','1'),
	('ADL000055','收到存款0055','AS99990055','借','822681.94','AD000035','AS000018','1'),
	('ADL000056','收到存款0056','AS99990056','贷','901351.06','AD000036','AS000018','1'),
	('ADL000057','收到存款0057','AS99990057','借','920147.44','AD000036','AS000018','1'),
	('ADL000058','收到存款0058','AS99990058','贷','773603.06','AD000037','AS000019','1'),
	('ADL000059','收到存款0059','AS99990059','借','946815.88','AD000038','AS000019','1'),
	('ADL000060','收到存款0060','AS99990060','贷','886884.12','AD000038','AS000019','1'),
	('ADL000061','收到存款0061','AS99990061','借','904763.06','AD000039','AS000020','1'),
	('ADL000062','收到存款0062','AS99990062','贷','952279.75','AD000040','AS000020','1'),
	('ADL000063','收到存款0063','AS99990063','借','867248.00','AD000040','AS000020','1'),
	('ADL000064','收到存款0064','AS99990064','贷','935036.31','AD000041','AS000021','1'),
	('ADL000065','收到存款0065','AS99990065','借','728888.00','AD000041','AS000021','1'),
	('ADL000066','收到存款0066','AS99990066','贷','916088.06','AD000042','AS000021','1'),
	('ADL000067','收到存款0067','AS99990067','借','772276.56','AD000043','AS000022','1'),
	('ADL000068','收到存款0068','AS99990068','贷','726588.12','AD000043','AS000022','1'),
	('ADL000069','收到存款0069','AS99990069','借','866531.69','AD000044','AS000022','1'),
	('ADL000070','收到存款0070','AS99990070','贷','970940.12','AD000045','AS000023','1'),
	('ADL000071','收到存款0071','AS99990071','借','738481.56','AD000045','AS000023','1'),
	('ADL000072','收到存款0072','AS99990072','贷','820483.75','AD000046','AS000023','1'),
	('ADL000073','收到存款0073','AS99990073','借','944307.81','AD000047','AS000024','1'),
	('ADL000074','收到存款0074','AS99990074','贷','870820.50','AD000047','AS000024','1'),
	('ADL000075','收到存款0075','AS99990075','借','860228.31','AD000048','AS000024','1'),
	('ADL000076','收到存款0076','AS99990076','贷','912791.00','AD000049','AS000025','1'),
	('ADL000077','收到存款0077','AS99990077','借','727730.00','AD000049','AS000025','1'),
	('ADL000078','收到存款0078','AS99990078','贷','696163.38','AD000050','AS000025','1'),
	('ADL000079','收到存款0079','AS99990079','借','729631.50','AD000050','AS000025','1'),
	('ADL000080','收到存款0080','AS99990080','贷','913977.12','AD000051','AS000026','1'),
	('ADL000081','收到存款0081','AS99990081','借','877515.69','AD000052','AS000026','1'),
	('ADL000082','收到存款0082','AS99990082','贷','974231.81','AD000052','AS000026','1'),
	('ADL000083','收到存款0083','AS99990083','借','826447.06','AD000053','AS000027','1'),
	('ADL000084','收到存款0084','AS99990084','贷','844354.75','AD000054','AS000027','1'),
	('ADL000085','收到存款0085','AS99990085','借','744351.62','AD000054','AS000027','1'),
	('ADL000086','收到存款0086','AS99990086','贷','872393.69','AD000055','AS000028','1'),
	('ADL000087','收到存款0087','AS99990087','借','862402.94','AD000056','AS000028','1'),
	('ADL000088','收到存款0088','AS99990088','贷','697297.88','AD000056','AS000028','1'),
	('ADL000089','收到存款0089','AS99990089','借','773832.56','AD000057','AS000029','1'),
	('ADL000090','收到存款0090','AS99990090','贷','795658.56','AD000057','AS000029','1'),
	('ADL000091','收到存款0091','AS99990091','借','960936.44','AD000058','AS000029','1'),
	('ADL000092','收到存款0092','AS99990092','贷','810989.62','AD000059','AS000030','1'),
	('ADL000093','收到存款0093','AS99990093','借','792086.12','AD000059','AS000030','1'),
	('ADL000094','收到存款0094','AS99990094','贷','696009.50','AD000060','AS000030','1'),
	('ADL000095','收到存款0095','AS99990095','借','978233.00','AD000061','AS000031','1'),
	('ADL000096','收到存款0096','AS99990096','贷','779650.75','AD000061','AS000031','1'),
	('ADL000097','收到存款0097','AS99990097','借','697675.25','AD000062','AS000031','1'),
	('ADL000098','收到存款0098','AS99990098','贷','969106.31','AD000063','AS000032','1'),
	('ADL000099','收到存款0099','AS99990099','借','751066.75','AD000063','AS000032','1'),
	('ADL000100','收到存款0100','AS99990100','贷','910243.50','AD000064','AS000032','1');

insert into level_one_department_data values
	('LOD000001','RSCC000001','供应链部','主要执行集团信息系统建设，维护，规划0001','刘强','2020-06-22','1'),
	('LOD000002','RSCC000001','采购部','主要执行集团信息系统建设，维护，规划0002','王德宏','2020-06-22','1');

insert into level_two_department_data values
	('LTD000001','LOD000001','信息系统部大数据部门0001','主要执行集团信息系统建设，维护，规划0001','2020-07-12','1'),
	('LTD000002','LOD000001','信息系统部大数据部门0002','主要执行集团信息系统建设，维护，规划0002','2019-01-28','1'),
	('LTD000003','LOD000002','信息系统部大数据部门0003','主要执行集团信息系统建设，维护，规划0003','2019-01-01','1'),
	('LTD000004','LOD000002','信息系统部大数据部门0004','主要执行集团信息系统建设，维护，规划0004','2018-09-18','1');

insert into level_three_department_data values
	('LTD000001','LTD000001','信息系统部大数据清洗组','主要执行集团信息系统建设，维护，规划0001','2018-11-26','1'),
	('LTD000002','LTD000001','信息系统部大数据运算组','主要执行集团信息系统建设，维护，规划0002','2021-07-06','1'),
	('LTD000003','LTD000002','信息系统部大数据解决方案组','主要执行集团信息系统建设，维护，规划0003','2021-07-22','1'),
	('LTD000004','LTD000002','信息系统部大数据清洗组','主要执行集团信息系统建设，维护，规划0004','2019-05-30','1'),
	('LTD000005','LTD000003','信息系统部大数据运算组','主要执行集团信息系统建设，维护，规划0005','2021-06-14','1'),
	('LTD000006','LTD000003','信息系统部大数据解决方案组','主要执行集团信息系统建设，维护，规划0006','2019-06-13','1'),
	('LTD000007','LTD000004','信息系统部大数据清洗组','主要执行集团信息系统建设，维护，规划0007','2020-04-25','1'),
	('LTD000008','LTD000004','信息系统部大数据运算组','主要执行集团信息系统建设，维护，规划0008','2020-05-07','1');

insert into skill_type_data values
	('ST000001','S00000001','RSCC000001','JAVA编程','1'),
	('ST000002','S00000002','RSCC000001','大数据','1');

insert into responsibility_type_data values
	('RT000001','S00000001','RSCC000001','合规管理','负责集团及其他分公司信息系统有效运作，并使集团在技术上领先0001','1'),
	('RT000002','S00000002','RSCC000001','财务管理','负责集团及其他分公司信息系统有效运作，并使集团在技术上领先0002','1');

insert into termination_reason_data values
	('TR000001','ETR00000001','RSCC000001','业务发展，公司转型','1'),
	('TR000002','ETR00000002','RSCC000001','战略调整','1');

insert into termination_type_data values
	('TT000001','ETT00000001','RSCC000001','合同解除','这个终止原因的描述是这样的.................................................0001','1'),
	('TT000002','ETT00000002','RSCC000001','辞职','这个终止原因的描述是这样的.................................................0002','1');

insert into occupation_type_data values
	('OT000001','OT00000001','RSCC000001','需求分析员','故事还得从遥远的古代开始.................................................0001','1'),
	('OT000002','OT00000002','RSCC000001','软件工程师','故事还得从遥远的古代开始.................................................0002','1');

insert into leave_type_data values
	('LT000001','LT00000001','RSCC000001','带薪年假','故事还得从遥远的古代开始.................................................0001','1'),
	('LT000002','LT00000002','RSCC000001','病假','故事还得从遥远的古代开始.................................................0002','1');

insert into salary_grade_data values
	('SG000001','SG00000001','RSCC000001','一级薪资','故事还得从遥远的古代开始.................................................0001','1'),
	('SG000002','SG00000002','RSCC000001','二级薪资','故事还得从遥远的古代开始.................................................0002','1');

insert into interview_type_data values
	('IT000001','INTRVW000001','RSCC000001','特别情况面试','故事还得从遥远的古代开始.................................................0001','1'),
	('IT000002','INTRVW000002','RSCC000001','离职面试','故事还得从遥远的古代开始.................................................0002','1');

insert into training_course_type_data values
	('TCT000001','TC000001','RSCC000001','入职培训','培训是提升个人和企业竞争力的法宝0001','1'),
	('TCT000002','TC000002','RSCC000001','售前培训','培训是提升个人和企业竞争力的法宝0002','1');

insert into public_holiday_data values
	('PH000001','PH000001','RSCC000001','元旦节','节日快乐，万事如意！0001','1'),
	('PH000002','PH000002','RSCC000001','春节','节日快乐，万事如意！0002','1');

insert into termination_data values
	('T000001','TR000001','TT000001','员工离职0001','1'),
	('T000002','TR000001','TT000001','员工离职0002','1'),
	('T000003','TR000002','TT000002','员工离职0003','1'),
	('T000004','TR000002','TT000002','员工离职0004','1');

insert into view_data values
	('V000001','面试官0001','小伙子不错，值得培养0001','2019-04-12','1');

insert into employee_data values
	('E000001','RSCC000001','程序员0001','LTD000001','张','文强','share@163.com','北京','学院路234号0001','18677778888','OT000001','RT000001','SG000001','6226 7788 9908 0001','2021-09-06 02:02:33','1'),
	('E000002','RSCC000001','程序员0002','LTD000001','王','大伟','2@qq.com','天津','学院路234号0002','13900000002','OT000001','RT000001','SG000001','6226 7788 9908 0002','2021-08-21 09:57:20','1'),
	('E000003','RSCC000001','程序员0003','LTD000002','李','字章','3@qq.com','成都','学院路234号0003','13900000003','OT000001','RT000001','SG000001','6226 7788 9908 0003','2021-09-01 03:41:31','1'),
	('E000004','RSCC000001','程序员0004','LTD000002','贺','文强','4@qq.com','上海','学院路234号0004','13900000004','OT000001','RT000001','SG000001','6226 7788 9908 0004','2021-09-03 21:08:03','1'),
	('E000005','RSCC000001','程序员0005','LTD000003','张','大伟','5@qq.com','深圳','学院路234号0005','13900000005','OT000001','RT000001','SG000001','6226 7788 9908 0005','2021-09-07 00:24:30','1'),
	('E000006','RSCC000001','程序员0006','LTD000003','王','字章','6@qq.com','广州','学院路234号0006','13900000006','OT000001','RT000001','SG000001','6226 7788 9908 0006','2021-08-31 20:11:17','1'),
	('E000007','RSCC000001','程序员0007','LTD000004','李','文强','7@qq.com','西安','学院路234号0007','13900000007','OT000001','RT000001','SG000001','6226 7788 9908 0007','2021-08-31 09:10:43','1'),
	('E000008','RSCC000001','程序员0008','LTD000004','贺','大伟','8@qq.com','北京','学院路234号0008','13900000008','OT000001','RT000001','SG000001','6226 7788 9908 0008','2021-08-28 05:04:16','1'),
	('E000009','RSCC000001','程序员0009','LTD000005','张','字章','9@qq.com','天津','学院路234号0009','13900000009','OT000002','RT000002','SG000002','6226 7788 9908 0009','2021-09-09 08:11:34','1'),
	('E000010','RSCC000001','程序员0010','LTD000005','王','文强','10@qq.com','成都','学院路234号0010','13900000010','OT000002','RT000002','SG000002','6226 7788 9908 0010','2021-08-27 20:03:43','1'),
	('E000011','RSCC000001','程序员0011','LTD000006','李','大伟','11@qq.com','上海','学院路234号0011','13900000011','OT000002','RT000002','SG000002','6226 7788 9908 0011','2021-09-07 22:43:24','1'),
	('E000012','RSCC000001','程序员0012','LTD000006','贺','字章','12@qq.com','深圳','学院路234号0012','13900000012','OT000002','RT000002','SG000002','6226 7788 9908 0012','2021-08-29 14:11:21','1'),
	('E000013','RSCC000001','程序员0013','LTD000007','张','文强','13@qq.com','广州','学院路234号0013','13900000013','OT000002','RT000002','SG000002','6226 7788 9908 0013','2021-09-08 02:46:54','1'),
	('E000014','RSCC000001','程序员0014','LTD000007','王','大伟','14@qq.com','西安','学院路234号0014','13900000014','OT000002','RT000002','SG000002','6226 7788 9908 0014','2021-09-08 05:57:02','1'),
	('E000015','RSCC000001','程序员0015','LTD000008','李','字章','15@qq.com','北京','学院路234号0015','13900000015','OT000002','RT000002','SG000002','6226 7788 9908 0015','2021-09-03 11:36:00','1'),
	('E000016','RSCC000001','程序员0016','LTD000008','贺','文强','16@qq.com','天津','学院路234号0016','13900000016','OT000002','RT000002','SG000002','6226 7788 9908 0016','2021-08-26 03:30:20','1');

insert into instructor_data values
	('I000001','高级讲师0001','张','文强','18699990000','instructor@gmail.com','RSCC000001','这是一个长长长长长长长长的介绍0001','2021-09-08 08:49:57','1'),
	('I000002','高级讲师0002','王','大伟','13900000002','2@qq.com','RSCC000001','这是一个长长长长长长长长的介绍0002','2021-09-07 16:46:29','1');

insert into company_training_data values
	('CT000001','入职培训0001','RSCC000001','I000001','TCT000001','2020-03-29','3','2021-09-04 22:27:10','1'),
	('CT000002','入职培训0002','RSCC000001','I000001','TCT000001','2020-10-08','3','2021-08-23 06:16:58','1'),
	('CT000003','入职培训0003','RSCC000001','I000002','TCT000002','2019-01-16','3','2021-08-28 06:43:48','1'),
	('CT000004','入职培训0004','RSCC000001','I000002','TCT000002','2021-09-07','3','2021-08-29 06:28:31','1');

insert into scoring_data values
	('S000001','王志文0001','100','这个题做的真不错啊0001','1');

insert into employee_company_training_data values
	('ECT000001','E000001','CT000001','S000001','1'),
	('ECT000002','E000001','CT000001','S000001','1'),
	('ECT000003','E000002','CT000001','S000001','1'),
	('ECT000004','E000002','CT000001','S000001','1'),
	('ECT000005','E000003','CT000001','S000001','1'),
	('ECT000006','E000003','CT000001','S000001','1'),
	('ECT000007','E000004','CT000001','S000001','1'),
	('ECT000008','E000004','CT000001','S000001','1'),
	('ECT000009','E000005','CT000002','S000001','1'),
	('ECT000010','E000005','CT000002','S000001','1'),
	('ECT000011','E000006','CT000002','S000001','1'),
	('ECT000012','E000006','CT000002','S000001','1'),
	('ECT000013','E000007','CT000002','S000001','1'),
	('ECT000014','E000007','CT000002','S000001','1'),
	('ECT000015','E000008','CT000002','S000001','1'),
	('ECT000016','E000008','CT000002','S000001','1'),
	('ECT000017','E000009','CT000003','S000001','1'),
	('ECT000018','E000009','CT000003','S000001','1'),
	('ECT000019','E000010','CT000003','S000001','1'),
	('ECT000020','E000010','CT000003','S000001','1'),
	('ECT000021','E000011','CT000003','S000001','1'),
	('ECT000022','E000011','CT000003','S000001','1'),
	('ECT000023','E000012','CT000003','S000001','1'),
	('ECT000024','E000012','CT000003','S000001','1'),
	('ECT000025','E000013','CT000004','S000001','1'),
	('ECT000026','E000013','CT000004','S000001','1'),
	('ECT000027','E000014','CT000004','S000001','1'),
	('ECT000028','E000014','CT000004','S000001','1'),
	('ECT000029','E000015','CT000004','S000001','1'),
	('ECT000030','E000015','CT000004','S000001','1'),
	('ECT000031','E000016','CT000004','S000001','1'),
	('ECT000032','E000016','CT000004','S000001','1');

insert into employee_skill_data values
	('ES000001','E000001','ST000001','高手高手高高手0001','1'),
	('ES000002','E000001','ST000001','高手高手高高手0002','1'),
	('ES000003','E000002','ST000001','高手高手高高手0003','1'),
	('ES000004','E000002','ST000001','高手高手高高手0004','1'),
	('ES000005','E000003','ST000001','高手高手高高手0005','1'),
	('ES000006','E000003','ST000001','高手高手高高手0006','1'),
	('ES000007','E000004','ST000001','高手高手高高手0007','1'),
	('ES000008','E000004','ST000001','高手高手高高手0008','1'),
	('ES000009','E000005','ST000001','高手高手高高手0009','1'),
	('ES000010','E000005','ST000001','高手高手高高手0010','1'),
	('ES000011','E000006','ST000001','高手高手高高手0011','1'),
	('ES000012','E000006','ST000001','高手高手高高手0012','1'),
	('ES000013','E000007','ST000001','高手高手高高手0013','1'),
	('ES000014','E000007','ST000001','高手高手高高手0014','1'),
	('ES000015','E000008','ST000001','高手高手高高手0015','1'),
	('ES000016','E000008','ST000001','高手高手高高手0016','1'),
	('ES000017','E000009','ST000002','高手高手高高手0017','1'),
	('ES000018','E000009','ST000002','高手高手高高手0018','1'),
	('ES000019','E000010','ST000002','高手高手高高手0019','1'),
	('ES000020','E000010','ST000002','高手高手高高手0020','1'),
	('ES000021','E000011','ST000002','高手高手高高手0021','1'),
	('ES000022','E000011','ST000002','高手高手高高手0022','1'),
	('ES000023','E000012','ST000002','高手高手高高手0023','1'),
	('ES000024','E000012','ST000002','高手高手高高手0024','1'),
	('ES000025','E000013','ST000002','高手高手高高手0025','1'),
	('ES000026','E000013','ST000002','高手高手高高手0026','1'),
	('ES000027','E000014','ST000002','高手高手高高手0027','1'),
	('ES000028','E000014','ST000002','高手高手高高手0028','1'),
	('ES000029','E000015','ST000002','高手高手高高手0029','1'),
	('ES000030','E000015','ST000002','高手高手高高手0030','1'),
	('ES000031','E000016','ST000002','高手高手高高手0031','1'),
	('ES000032','E000016','ST000002','高手高手高高手0032','1');

insert into employee_performance_data values
	('EP000001','E000001','绩效大大的不错0001','1'),
	('EP000002','E000001','绩效大大的不错0002','1'),
	('EP000003','E000002','绩效大大的不错0003','1'),
	('EP000004','E000002','绩效大大的不错0004','1'),
	('EP000005','E000003','绩效大大的不错0005','1'),
	('EP000006','E000003','绩效大大的不错0006','1'),
	('EP000007','E000004','绩效大大的不错0007','1'),
	('EP000008','E000004','绩效大大的不错0008','1'),
	('EP000009','E000005','绩效大大的不错0009','1'),
	('EP000010','E000005','绩效大大的不错0010','1'),
	('EP000011','E000006','绩效大大的不错0011','1'),
	('EP000012','E000006','绩效大大的不错0012','1'),
	('EP000013','E000007','绩效大大的不错0013','1'),
	('EP000014','E000007','绩效大大的不错0014','1'),
	('EP000015','E000008','绩效大大的不错0015','1'),
	('EP000016','E000008','绩效大大的不错0016','1'),
	('EP000017','E000009','绩效大大的不错0017','1'),
	('EP000018','E000009','绩效大大的不错0018','1'),
	('EP000019','E000010','绩效大大的不错0019','1'),
	('EP000020','E000010','绩效大大的不错0020','1'),
	('EP000021','E000011','绩效大大的不错0021','1'),
	('EP000022','E000011','绩效大大的不错0022','1'),
	('EP000023','E000012','绩效大大的不错0023','1'),
	('EP000024','E000012','绩效大大的不错0024','1'),
	('EP000025','E000013','绩效大大的不错0025','1'),
	('EP000026','E000013','绩效大大的不错0026','1'),
	('EP000027','E000014','绩效大大的不错0027','1'),
	('EP000028','E000014','绩效大大的不错0028','1'),
	('EP000029','E000015','绩效大大的不错0029','1'),
	('EP000030','E000015','绩效大大的不错0030','1'),
	('EP000031','E000016','绩效大大的不错0031','1'),
	('EP000032','E000016','绩效大大的不错0032','1');

insert into employee_work_experience_data values
	('EWE000001','E000001','2020-12-30','2019-01-22','丝芙兰化妆品公司0001','在此期间取得非常好的绩效，赢得了客户的信赖0001','1'),
	('EWE000002','E000001','2018-11-21','2020-08-28','丝芙兰化妆品公司0002','在此期间取得非常好的绩效，赢得了客户的信赖0002','1'),
	('EWE000003','E000002','2021-05-03','2019-02-27','丝芙兰化妆品公司0003','在此期间取得非常好的绩效，赢得了客户的信赖0003','1'),
	('EWE000004','E000002','2019-01-08','2018-09-23','丝芙兰化妆品公司0004','在此期间取得非常好的绩效，赢得了客户的信赖0004','1'),
	('EWE000005','E000003','2021-01-01','2020-06-03','丝芙兰化妆品公司0005','在此期间取得非常好的绩效，赢得了客户的信赖0005','1'),
	('EWE000006','E000003','2021-06-20','2019-04-28','丝芙兰化妆品公司0006','在此期间取得非常好的绩效，赢得了客户的信赖0006','1'),
	('EWE000007','E000004','2020-12-21','2020-08-06','丝芙兰化妆品公司0007','在此期间取得非常好的绩效，赢得了客户的信赖0007','1'),
	('EWE000008','E000004','2019-08-19','2019-01-01','丝芙兰化妆品公司0008','在此期间取得非常好的绩效，赢得了客户的信赖0008','1'),
	('EWE000009','E000005','2019-01-05','2019-07-19','丝芙兰化妆品公司0009','在此期间取得非常好的绩效，赢得了客户的信赖0009','1'),
	('EWE000010','E000005','2020-10-30','2019-05-30','丝芙兰化妆品公司0010','在此期间取得非常好的绩效，赢得了客户的信赖0010','1'),
	('EWE000011','E000006','2019-04-24','2020-10-01','丝芙兰化妆品公司0011','在此期间取得非常好的绩效，赢得了客户的信赖0011','1'),
	('EWE000012','E000006','2020-08-13','2021-03-17','丝芙兰化妆品公司0012','在此期间取得非常好的绩效，赢得了客户的信赖0012','1'),
	('EWE000013','E000007','2020-07-14','2018-10-17','丝芙兰化妆品公司0013','在此期间取得非常好的绩效，赢得了客户的信赖0013','1'),
	('EWE000014','E000007','2019-05-30','2021-08-18','丝芙兰化妆品公司0014','在此期间取得非常好的绩效，赢得了客户的信赖0014','1'),
	('EWE000015','E000008','2019-05-31','2021-02-23','丝芙兰化妆品公司0015','在此期间取得非常好的绩效，赢得了客户的信赖0015','1'),
	('EWE000016','E000008','2020-06-22','2021-04-25','丝芙兰化妆品公司0016','在此期间取得非常好的绩效，赢得了客户的信赖0016','1'),
	('EWE000017','E000009','2018-10-17','2020-08-23','丝芙兰化妆品公司0017','在此期间取得非常好的绩效，赢得了客户的信赖0017','1'),
	('EWE000018','E000009','2021-03-21','2020-08-28','丝芙兰化妆品公司0018','在此期间取得非常好的绩效，赢得了客户的信赖0018','1'),
	('EWE000019','E000010','2020-04-27','2018-12-11','丝芙兰化妆品公司0019','在此期间取得非常好的绩效，赢得了客户的信赖0019','1'),
	('EWE000020','E000010','2018-12-05','2020-06-18','丝芙兰化妆品公司0020','在此期间取得非常好的绩效，赢得了客户的信赖0020','1'),
	('EWE000021','E000011','2021-07-12','2021-01-31','丝芙兰化妆品公司0021','在此期间取得非常好的绩效，赢得了客户的信赖0021','1'),
	('EWE000022','E000011','2021-02-07','2021-09-03','丝芙兰化妆品公司0022','在此期间取得非常好的绩效，赢得了客户的信赖0022','1'),
	('EWE000023','E000012','2020-05-26','2020-06-15','丝芙兰化妆品公司0023','在此期间取得非常好的绩效，赢得了客户的信赖0023','1'),
	('EWE000024','E000012','2021-08-30','2019-12-24','丝芙兰化妆品公司0024','在此期间取得非常好的绩效，赢得了客户的信赖0024','1'),
	('EWE000025','E000013','2019-12-15','2019-08-19','丝芙兰化妆品公司0025','在此期间取得非常好的绩效，赢得了客户的信赖0025','1'),
	('EWE000026','E000013','2021-01-16','2021-07-03','丝芙兰化妆品公司0026','在此期间取得非常好的绩效，赢得了客户的信赖0026','1'),
	('EWE000027','E000014','2021-08-23','2021-06-18','丝芙兰化妆品公司0027','在此期间取得非常好的绩效，赢得了客户的信赖0027','1'),
	('EWE000028','E000014','2020-07-01','2019-04-09','丝芙兰化妆品公司0028','在此期间取得非常好的绩效，赢得了客户的信赖0028','1'),
	('EWE000029','E000015','2019-11-08','2019-02-14','丝芙兰化妆品公司0029','在此期间取得非常好的绩效，赢得了客户的信赖0029','1'),
	('EWE000030','E000015','2020-07-27','2019-11-30','丝芙兰化妆品公司0030','在此期间取得非常好的绩效，赢得了客户的信赖0030','1'),
	('EWE000031','E000016','2018-10-16','2019-04-05','丝芙兰化妆品公司0031','在此期间取得非常好的绩效，赢得了客户的信赖0031','1'),
	('EWE000032','E000016','2020-09-22','2021-02-07','丝芙兰化妆品公司0032','在此期间取得非常好的绩效，赢得了客户的信赖0032','1');

insert into employee_leave_data values
	('EL000001','E000001','LT000001','6','请年假，出去耍！！！！0001','1'),
	('EL000002','E000001','LT000001','8','请年假，出去耍！！！！0002','1'),
	('EL000003','E000002','LT000001','8','请年假，出去耍！！！！0003','1'),
	('EL000004','E000002','LT000001','8','请年假，出去耍！！！！0004','1'),
	('EL000005','E000003','LT000001','7','请年假，出去耍！！！！0005','1'),
	('EL000006','E000003','LT000001','7','请年假，出去耍！！！！0006','1'),
	('EL000007','E000004','LT000001','7','请年假，出去耍！！！！0007','1'),
	('EL000008','E000004','LT000001','8','请年假，出去耍！！！！0008','1'),
	('EL000009','E000005','LT000001','7','请年假，出去耍！！！！0009','1'),
	('EL000010','E000005','LT000001','7','请年假，出去耍！！！！0010','1'),
	('EL000011','E000006','LT000001','7','请年假，出去耍！！！！0011','1'),
	('EL000012','E000006','LT000001','7','请年假，出去耍！！！！0012','1'),
	('EL000013','E000007','LT000001','8','请年假，出去耍！！！！0013','1'),
	('EL000014','E000007','LT000001','8','请年假，出去耍！！！！0014','1'),
	('EL000015','E000008','LT000001','7','请年假，出去耍！！！！0015','1'),
	('EL000016','E000008','LT000001','7','请年假，出去耍！！！！0016','1'),
	('EL000017','E000009','LT000002','7','请年假，出去耍！！！！0017','1'),
	('EL000018','E000009','LT000002','8','请年假，出去耍！！！！0018','1'),
	('EL000019','E000010','LT000002','7','请年假，出去耍！！！！0019','1'),
	('EL000020','E000010','LT000002','7','请年假，出去耍！！！！0020','1'),
	('EL000021','E000011','LT000002','8','请年假，出去耍！！！！0021','1'),
	('EL000022','E000011','LT000002','7','请年假，出去耍！！！！0022','1'),
	('EL000023','E000012','LT000002','6','请年假，出去耍！！！！0023','1'),
	('EL000024','E000012','LT000002','8','请年假，出去耍！！！！0024','1'),
	('EL000025','E000013','LT000002','8','请年假，出去耍！！！！0025','1'),
	('EL000026','E000013','LT000002','8','请年假，出去耍！！！！0026','1'),
	('EL000027','E000014','LT000002','7','请年假，出去耍！！！！0027','1'),
	('EL000028','E000014','LT000002','8','请年假，出去耍！！！！0028','1'),
	('EL000029','E000015','LT000002','8','请年假，出去耍！！！！0029','1'),
	('EL000030','E000015','LT000002','8','请年假，出去耍！！！！0030','1'),
	('EL000031','E000016','LT000002','8','请年假，出去耍！！！！0031','1'),
	('EL000032','E000016','LT000002','7','请年假，出去耍！！！！0032','1');

insert into employee_interview_data values
	('EI000001','E000001','IT000001','结果不错，面试通过！0001','1'),
	('EI000002','E000001','IT000001','结果不错，面试通过！0002','1'),
	('EI000003','E000002','IT000001','结果不错，面试通过！0003','1'),
	('EI000004','E000002','IT000001','结果不错，面试通过！0004','1'),
	('EI000005','E000003','IT000001','结果不错，面试通过！0005','1'),
	('EI000006','E000003','IT000001','结果不错，面试通过！0006','1'),
	('EI000007','E000004','IT000001','结果不错，面试通过！0007','1'),
	('EI000008','E000004','IT000001','结果不错，面试通过！0008','1'),
	('EI000009','E000005','IT000001','结果不错，面试通过！0009','1'),
	('EI000010','E000005','IT000001','结果不错，面试通过！0010','1'),
	('EI000011','E000006','IT000001','结果不错，面试通过！0011','1'),
	('EI000012','E000006','IT000001','结果不错，面试通过！0012','1'),
	('EI000013','E000007','IT000001','结果不错，面试通过！0013','1'),
	('EI000014','E000007','IT000001','结果不错，面试通过！0014','1'),
	('EI000015','E000008','IT000001','结果不错，面试通过！0015','1'),
	('EI000016','E000008','IT000001','结果不错，面试通过！0016','1'),
	('EI000017','E000009','IT000002','结果不错，面试通过！0017','1'),
	('EI000018','E000009','IT000002','结果不错，面试通过！0018','1'),
	('EI000019','E000010','IT000002','结果不错，面试通过！0019','1'),
	('EI000020','E000010','IT000002','结果不错，面试通过！0020','1'),
	('EI000021','E000011','IT000002','结果不错，面试通过！0021','1'),
	('EI000022','E000011','IT000002','结果不错，面试通过！0022','1'),
	('EI000023','E000012','IT000002','结果不错，面试通过！0023','1'),
	('EI000024','E000012','IT000002','结果不错，面试通过！0024','1'),
	('EI000025','E000013','IT000002','结果不错，面试通过！0025','1'),
	('EI000026','E000013','IT000002','结果不错，面试通过！0026','1'),
	('EI000027','E000014','IT000002','结果不错，面试通过！0027','1'),
	('EI000028','E000014','IT000002','结果不错，面试通过！0028','1'),
	('EI000029','E000015','IT000002','结果不错，面试通过！0029','1'),
	('EI000030','E000015','IT000002','结果不错，面试通过！0030','1'),
	('EI000031','E000016','IT000002','结果不错，面试通过！0031','1'),
	('EI000032','E000016','IT000002','结果不错，面试通过！0032','1');

insert into employee_attendance_data values
	('EA000001','E000001','2019-10-15','2021-01-10','7','今天状态不错啊0001','1'),
	('EA000002','E000001','2020-05-03','2019-03-08','8','今天状态不错啊0002','1'),
	('EA000003','E000002','2020-04-03','2019-12-25','8','今天状态不错啊0003','1'),
	('EA000004','E000002','2019-11-13','2020-09-23','6','今天状态不错啊0004','1'),
	('EA000005','E000003','2018-10-26','2018-09-13','8','今天状态不错啊0005','1'),
	('EA000006','E000003','2019-06-10','2020-05-14','8','今天状态不错啊0006','1'),
	('EA000007','E000004','2019-12-27','2018-12-11','7','今天状态不错啊0007','1'),
	('EA000008','E000004','2019-02-11','2018-10-01','8','今天状态不错啊0008','1'),
	('EA000009','E000005','2021-01-13','2020-10-15','8','今天状态不错啊0009','1'),
	('EA000010','E000005','2020-03-13','2020-08-30','7','今天状态不错啊0010','1'),
	('EA000011','E000006','2020-07-14','2020-07-15','8','今天状态不错啊0011','1'),
	('EA000012','E000006','2020-06-15','2020-12-02','8','今天状态不错啊0012','1'),
	('EA000013','E000007','2021-02-27','2019-05-22','7','今天状态不错啊0013','1'),
	('EA000014','E000007','2019-06-04','2020-11-19','7','今天状态不错啊0014','1'),
	('EA000015','E000008','2019-05-31','2021-03-03','8','今天状态不错啊0015','1'),
	('EA000016','E000008','2018-12-18','2019-12-20','8','今天状态不错啊0016','1'),
	('EA000017','E000009','2020-06-23','2021-02-15','8','今天状态不错啊0017','1'),
	('EA000018','E000009','2020-03-14','2019-01-16','8','今天状态不错啊0018','1'),
	('EA000019','E000010','2018-11-26','2021-06-27','8','今天状态不错啊0019','1'),
	('EA000020','E000010','2021-03-12','2021-01-16','7','今天状态不错啊0020','1'),
	('EA000021','E000011','2019-06-20','2021-06-21','8','今天状态不错啊0021','1'),
	('EA000022','E000011','2020-08-20','2019-01-21','6','今天状态不错啊0022','1'),
	('EA000023','E000012','2021-08-10','2018-10-08','7','今天状态不错啊0023','1'),
	('EA000024','E000012','2020-11-21','2020-09-01','6','今天状态不错啊0024','1'),
	('EA000025','E000013','2021-05-31','2020-08-12','7','今天状态不错啊0025','1'),
	('EA000026','E000013','2019-12-22','2021-07-07','7','今天状态不错啊0026','1'),
	('EA000027','E000014','2020-04-04','2019-01-27','7','今天状态不错啊0027','1'),
	('EA000028','E000014','2020-09-10','2019-04-14','7','今天状态不错啊0028','1'),
	('EA000029','E000015','2020-09-13','2019-12-23','8','今天状态不错啊0029','1'),
	('EA000030','E000015','2020-11-25','2021-01-21','8','今天状态不错啊0030','1'),
	('EA000031','E000016','2021-08-07','2020-07-28','8','今天状态不错啊0031','1'),
	('EA000032','E000016','2019-06-27','2019-06-17','7','今天状态不错啊0032','1');

insert into employee_qualifier_data values
	('EQ000001','E000001','2018-10-20','认证药剂师','高级','考试成绩当年第一名0001','1'),
	('EQ000002','E000001','2020-10-01','认证架构师','中级','考试成绩当年第一名0002','1'),
	('EQ000003','E000002','2020-11-06','认证会计师','初级','考试成绩当年第一名0003','1'),
	('EQ000004','E000002','2020-07-15','认证经济师','高级','考试成绩当年第一名0004','1'),
	('EQ000005','E000003','2021-01-14','OCP','中级','考试成绩当年第一名0005','1'),
	('EQ000006','E000003','2021-07-16','CCNA','初级','考试成绩当年第一名0006','1'),
	('EQ000007','E000004','2020-09-26','CCNP','高级','考试成绩当年第一名0007','1'),
	('EQ000008','E000004','2020-01-08','认证药剂师','中级','考试成绩当年第一名0008','1'),
	('EQ000009','E000005','2019-08-14','认证架构师','初级','考试成绩当年第一名0009','1'),
	('EQ000010','E000005','2020-11-26','认证会计师','高级','考试成绩当年第一名0010','1'),
	('EQ000011','E000006','2020-02-29','认证经济师','中级','考试成绩当年第一名0011','1'),
	('EQ000012','E000006','2019-09-20','OCP','初级','考试成绩当年第一名0012','1'),
	('EQ000013','E000007','2020-03-06','CCNA','高级','考试成绩当年第一名0013','1'),
	('EQ000014','E000007','2021-03-18','CCNP','中级','考试成绩当年第一名0014','1'),
	('EQ000015','E000008','2019-05-28','认证药剂师','初级','考试成绩当年第一名0015','1'),
	('EQ000016','E000008','2019-08-15','认证架构师','高级','考试成绩当年第一名0016','1'),
	('EQ000017','E000009','2021-08-19','认证会计师','中级','考试成绩当年第一名0017','1'),
	('EQ000018','E000009','2021-08-25','认证经济师','初级','考试成绩当年第一名0018','1'),
	('EQ000019','E000010','2021-06-21','OCP','高级','考试成绩当年第一名0019','1'),
	('EQ000020','E000010','2019-12-13','CCNA','中级','考试成绩当年第一名0020','1'),
	('EQ000021','E000011','2020-09-20','CCNP','初级','考试成绩当年第一名0021','1'),
	('EQ000022','E000011','2021-03-15','认证药剂师','高级','考试成绩当年第一名0022','1'),
	('EQ000023','E000012','2018-10-23','认证架构师','中级','考试成绩当年第一名0023','1'),
	('EQ000024','E000012','2019-04-18','认证会计师','初级','考试成绩当年第一名0024','1'),
	('EQ000025','E000013','2020-09-12','认证经济师','高级','考试成绩当年第一名0025','1'),
	('EQ000026','E000013','2021-05-09','OCP','中级','考试成绩当年第一名0026','1'),
	('EQ000027','E000014','2018-11-01','CCNA','初级','考试成绩当年第一名0027','1'),
	('EQ000028','E000014','2019-06-21','CCNP','高级','考试成绩当年第一名0028','1'),
	('EQ000029','E000015','2019-05-12','认证药剂师','中级','考试成绩当年第一名0029','1'),
	('EQ000030','E000015','2019-01-26','认证架构师','初级','考试成绩当年第一名0030','1'),
	('EQ000031','E000016','2020-07-13','认证会计师','高级','考试成绩当年第一名0031','1'),
	('EQ000032','E000016','2020-02-02','认证经济师','中级','考试成绩当年第一名0032','1');

insert into employee_education_data values
	('EE000001','E000001','2018-11-28','小学','考试成绩当年第一名0001','1'),
	('EE000002','E000001','2021-01-24','初中','考试成绩当年第一名0002','1'),
	('EE000003','E000002','2018-12-28','高中','考试成绩当年第一名0003','1'),
	('EE000004','E000002','2019-02-13','大学','考试成绩当年第一名0004','1'),
	('EE000005','E000003','2020-11-05','硕士','考试成绩当年第一名0005','1'),
	('EE000006','E000003','2020-01-02','博士','考试成绩当年第一名0006','1'),
	('EE000007','E000004','2020-04-11','职业教育','考试成绩当年第一名0007','1'),
	('EE000008','E000004','2020-08-14','小学','考试成绩当年第一名0008','1'),
	('EE000009','E000005','2019-05-13','初中','考试成绩当年第一名0009','1'),
	('EE000010','E000005','2021-03-24','高中','考试成绩当年第一名0010','1'),
	('EE000011','E000006','2019-09-14','大学','考试成绩当年第一名0011','1'),
	('EE000012','E000006','2020-06-01','硕士','考试成绩当年第一名0012','1'),
	('EE000013','E000007','2021-03-24','博士','考试成绩当年第一名0013','1'),
	('EE000014','E000007','2018-10-10','职业教育','考试成绩当年第一名0014','1'),
	('EE000015','E000008','2018-12-09','小学','考试成绩当年第一名0015','1'),
	('EE000016','E000008','2020-12-06','初中','考试成绩当年第一名0016','1'),
	('EE000017','E000009','2021-06-10','高中','考试成绩当年第一名0017','1'),
	('EE000018','E000009','2020-08-24','大学','考试成绩当年第一名0018','1'),
	('EE000019','E000010','2021-01-20','硕士','考试成绩当年第一名0019','1'),
	('EE000020','E000010','2020-05-19','博士','考试成绩当年第一名0020','1'),
	('EE000021','E000011','2020-06-04','职业教育','考试成绩当年第一名0021','1'),
	('EE000022','E000011','2021-01-18','小学','考试成绩当年第一名0022','1'),
	('EE000023','E000012','2020-11-28','初中','考试成绩当年第一名0023','1'),
	('EE000024','E000012','2019-05-29','高中','考试成绩当年第一名0024','1'),
	('EE000025','E000013','2019-08-24','大学','考试成绩当年第一名0025','1'),
	('EE000026','E000013','2020-12-01','硕士','考试成绩当年第一名0026','1'),
	('EE000027','E000014','2019-10-14','博士','考试成绩当年第一名0027','1'),
	('EE000028','E000014','2020-08-31','职业教育','考试成绩当年第一名0028','1'),
	('EE000029','E000015','2021-01-21','小学','考试成绩当年第一名0029','1'),
	('EE000030','E000015','2019-02-26','初中','考试成绩当年第一名0030','1'),
	('EE000031','E000016','2019-08-05','高中','考试成绩当年第一名0031','1'),
	('EE000032','E000016','2019-03-18','大学','考试成绩当年第一名0032','1');

insert into employee_award_data values
	('EA000001','E000001','2018-11-01','明星员工','考试成绩当年第一名0001','1'),
	('EA000002','E000001','2019-03-17','销售之星','考试成绩当年第一名0002','1'),
	('EA000003','E000002','2021-04-22','技术之星','考试成绩当年第一名0003','1'),
	('EA000004','E000002','2021-05-07','管理之星','考试成绩当年第一名0004','1'),
	('EA000005','E000003','2019-03-24','终身成就奖','考试成绩当年第一名0005','1'),
	('EA000006','E000003','2021-01-04','明星员工','考试成绩当年第一名0006','1'),
	('EA000007','E000004','2021-08-10','销售之星','考试成绩当年第一名0007','1'),
	('EA000008','E000004','2019-06-15','技术之星','考试成绩当年第一名0008','1'),
	('EA000009','E000005','2019-06-03','管理之星','考试成绩当年第一名0009','1'),
	('EA000010','E000005','2021-01-04','终身成就奖','考试成绩当年第一名0010','1'),
	('EA000011','E000006','2021-01-09','明星员工','考试成绩当年第一名0011','1'),
	('EA000012','E000006','2021-06-19','销售之星','考试成绩当年第一名0012','1'),
	('EA000013','E000007','2020-09-04','技术之星','考试成绩当年第一名0013','1'),
	('EA000014','E000007','2018-11-06','管理之星','考试成绩当年第一名0014','1'),
	('EA000015','E000008','2021-03-17','终身成就奖','考试成绩当年第一名0015','1'),
	('EA000016','E000008','2021-01-23','明星员工','考试成绩当年第一名0016','1'),
	('EA000017','E000009','2019-10-21','销售之星','考试成绩当年第一名0017','1'),
	('EA000018','E000009','2021-05-08','技术之星','考试成绩当年第一名0018','1'),
	('EA000019','E000010','2021-01-28','管理之星','考试成绩当年第一名0019','1'),
	('EA000020','E000010','2019-02-27','终身成就奖','考试成绩当年第一名0020','1'),
	('EA000021','E000011','2020-07-17','明星员工','考试成绩当年第一名0021','1'),
	('EA000022','E000011','2018-11-19','销售之星','考试成绩当年第一名0022','1'),
	('EA000023','E000012','2019-11-29','技术之星','考试成绩当年第一名0023','1'),
	('EA000024','E000012','2021-01-27','管理之星','考试成绩当年第一名0024','1'),
	('EA000025','E000013','2021-02-12','终身成就奖','考试成绩当年第一名0025','1'),
	('EA000026','E000013','2020-06-22','明星员工','考试成绩当年第一名0026','1'),
	('EA000027','E000014','2020-07-31','销售之星','考试成绩当年第一名0027','1'),
	('EA000028','E000014','2019-12-11','技术之星','考试成绩当年第一名0028','1'),
	('EA000029','E000015','2020-07-22','管理之星','考试成绩当年第一名0029','1'),
	('EA000030','E000015','2020-01-23','终身成就奖','考试成绩当年第一名0030','1'),
	('EA000031','E000016','2019-04-07','明星员工','考试成绩当年第一名0031','1'),
	('EA000032','E000016','2020-10-12','销售之星','考试成绩当年第一名0032','1');

insert into employee_salary_sheet_data values
	('ESS000001','E000001','SG000001','2570.03','764.54','858.75','643.47','903.60','1112.62','7.37','PO000001','1'),
	('ESS000002','E000001','SG000001','2610.23','993.19','823.17','779.79','906.06','1048.47','8.73','PO000001','1'),
	('ESS000003','E000001','SG000001','2710.01','733.53','901.24','561.48','976.41','1001.05','6.68','PO000002','1'),
	('ESS000004','E000001','SG000001','2937.36','818.03','724.96','700.26','915.39','1079.76','6.75','PO000002','1'),
	('ESS000005','E000002','SG000001','2982.98','912.93','913.98','684.24','841.00','863.49','8.09','PO000003','1'),
	('ESS000006','E000002','SG000001','2814.87','726.10','960.27','589.63','950.40','1108.05','8.13','PO000003','1'),
	('ESS000007','E000002','SG000001','2817.68','994.60','966.39','639.02','975.07','1004.42','7.51','PO000004','1'),
	('ESS000008','E000002','SG000001','2804.60','915.16','814.62','730.27','955.90','1147.75','8.65','PO000004','1'),
	('ESS000009','E000003','SG000001','2886.48','859.32','773.49','739.47','770.44','856.97','7.96','PO000005','1'),
	('ESS000010','E000003','SG000001','2138.07','774.31','977.65','734.18','1003.19','1063.29','7.84','PO000005','1'),
	('ESS000011','E000003','SG000001','2294.50','806.22','933.89','638.96','969.87','1212.56','7.92','PO000006','1'),
	('ESS000012','E000003','SG000001','2600.26','957.05','749.74','686.58','1046.00','945.16','7.27','PO000006','1'),
	('ESS000013','E000004','SG000001','2538.77','729.37','873.79','605.78','836.61','1080.83','7.91','PO000007','1'),
	('ESS000014','E000004','SG000001','2108.59','819.22','944.64','613.38','878.95','1137.24','8.33','PO000007','1'),
	('ESS000015','E000004','SG000001','2546.93','863.33','715.23','625.39','960.28','1001.75','6.93','PO000008','1'),
	('ESS000016','E000004','SG000001','2581.36','836.17','954.92','579.07','802.94','1023.70','7.79','PO000008','1'),
	('ESS000017','E000005','SG000001','2278.12','980.72','719.87','708.70','965.17','1065.94','8.47','PO000009','1'),
	('ESS000018','E000005','SG000001','2702.03','986.22','880.56','645.42','1013.29','1059.12','8.45','PO000009','1'),
	('ESS000019','E000005','SG000001','2397.30','948.14','966.50','693.23','911.33','1063.19','8.64','PO000010','1'),
	('ESS000020','E000005','SG000001','2133.57','731.23','811.37','675.84','808.28','1164.21','8.24','PO000010','1'),
	('ESS000021','E000006','SG000001','2566.22','893.25','983.84','609.65','777.99','1006.51','7.53','PO000011','1'),
	('ESS000022','E000006','SG000001','2144.73','989.09','827.26','663.39','789.83','942.71','7.20','PO000011','1'),
	('ESS000023','E000006','SG000001','2864.51','908.57','842.94','643.55','971.71','1025.03','7.53','PO000012','1'),
	('ESS000024','E000006','SG000001','2997.17','830.33','789.53','567.22','998.84','1014.13','7.71','PO000012','1'),
	('ESS000025','E000007','SG000001','2273.78','975.20','872.08','712.29','982.35','1095.06','7.00','PO000013','1'),
	('ESS000026','E000007','SG000001','2978.90','722.20','760.23','639.48','788.25','868.97','8.54','PO000013','1'),
	('ESS000027','E000007','SG000001','2280.14','980.62','775.96','664.60','920.73','872.37','8.20','PO000014','1'),
	('ESS000028','E000007','SG000001','2460.57','704.20','707.52','737.04','1070.59','951.17','8.23','PO000014','1'),
	('ESS000029','E000008','SG000001','2149.13','886.44','849.63','765.08','792.57','1160.35','7.36','PO000015','1'),
	('ESS000030','E000008','SG000001','2309.08','716.47','947.93','713.44','1035.60','1130.62','7.94','PO000015','1'),
	('ESS000031','E000008','SG000001','2875.09','768.03','778.45','564.23','1016.32','870.25','7.32','PO000016','1'),
	('ESS000032','E000008','SG000001','2615.42','905.69','890.71','603.41','901.44','1154.24','7.00','PO000016','1'),
	('ESS000033','E000009','SG000002','2539.37','853.61','914.87','648.52','791.12','923.27','8.53','PO000017','1'),
	('ESS000034','E000009','SG000002','2731.70','825.02','897.28','684.40','935.98','941.19','7.03','PO000017','1'),
	('ESS000035','E000009','SG000002','2920.00','776.20','841.63','558.31','827.08','1067.46','7.23','PO000018','1'),
	('ESS000036','E000009','SG000002','2853.00','793.57','844.82','598.25','1023.86','1174.94','6.29','PO000018','1'),
	('ESS000037','E000010','SG000002','2478.95','969.63','848.99','765.63','797.40','937.25','7.95','PO000019','1'),
	('ESS000038','E000010','SG000002','2817.82','825.69','998.56','738.69','889.57','962.20','8.13','PO000019','1'),
	('ESS000039','E000010','SG000002','2619.55','775.75','813.04','697.90','1038.24','1102.09','6.51','PO000020','1'),
	('ESS000040','E000010','SG000002','2812.23','924.81','892.90','658.40','964.22','893.59','8.01','PO000020','1'),
	('ESS000041','E000011','SG000002','2720.82','836.44','914.14','616.44','1059.89','1154.01','7.26','PO000021','1'),
	('ESS000042','E000011','SG000002','2882.52','820.39','804.29','712.29','824.15','871.96','8.70','PO000021','1'),
	('ESS000043','E000011','SG000002','2939.90','849.23','844.99','599.18','969.13','913.08','8.84','PO000022','1'),
	('ESS000044','E000011','SG000002','2357.11','724.08','757.62','588.01','1005.24','1016.28','7.08','PO000022','1'),
	('ESS000045','E000012','SG000002','2561.14','822.25','847.27','788.94','797.61','892.30','7.75','PO000023','1'),
	('ESS000046','E000012','SG000002','2424.71','976.06','846.50','561.26','814.40','954.81','7.54','PO000023','1'),
	('ESS000047','E000012','SG000002','2595.80','847.00','873.77','763.87','806.46','885.06','6.94','PO000024','1'),
	('ESS000048','E000012','SG000002','2271.89','929.74','901.70','598.02','915.06','891.83','7.51','PO000024','1'),
	('ESS000049','E000013','SG000002','2600.61','863.71','791.74','664.02','861.39','976.31','8.75','PO000025','1'),
	('ESS000050','E000013','SG000002','2264.54','889.29','911.36','670.92','979.14','1023.26','7.63','PO000025','1'),
	('ESS000051','E000013','SG000002','2335.97','849.10','933.29','729.62','952.46','1052.64','6.94','PO000026','1'),
	('ESS000052','E000013','SG000002','2311.94','823.60','764.65','764.27','989.70','1105.90','8.06','PO000026','1'),
	('ESS000053','E000014','SG000002','2792.57','950.38','824.61','610.11','953.28','1086.28','6.86','PO000027','1'),
	('ESS000054','E000014','SG000002','2238.14','765.13','753.89','731.38','970.27','1067.76','6.30','PO000027','1'),
	('ESS000055','E000014','SG000002','2942.33','897.22','821.39','642.98','820.51','1063.77','7.08','PO000028','1'),
	('ESS000056','E000014','SG000002','2540.04','786.13','858.79','699.72','826.47','985.74','8.08','PO000028','1'),
	('ESS000057','E000015','SG000002','2751.00','981.63','876.23','776.85','796.53','1178.84','8.87','PO000029','1'),
	('ESS000058','E000015','SG000002','2433.53','980.93','744.17','620.79','1057.33','1099.20','6.80','PO000029','1'),
	('ESS000059','E000015','SG000002','2402.45','724.92','924.30','689.38','897.68','880.25','8.60','PO000030','1'),
	('ESS000060','E000015','SG000002','2608.43','870.76','806.42','651.21','841.87','1031.70','7.87','PO000030','1'),
	('ESS000061','E000016','SG000002','2730.21','886.39','899.26','630.42','894.91','887.56','6.87','PO000031','1'),
	('ESS000062','E000016','SG000002','2165.62','858.72','792.78','605.82','796.38','957.99','6.69','PO000031','1'),
	('ESS000063','E000016','SG000002','2723.82','775.56','862.84','673.92','970.78','1079.44','8.62','PO000032','1'),
	('ESS000064','E000016','SG000002','2319.91','868.15','719.02','605.31','1061.17','1064.94','7.92','PO000032','1');

insert into paying_off_data values
	('PO000001','出纳0001','E000001','2021-03-21','4926.11','1'),
	('PO000002','出纳0002','E000001','2020-06-09','3800.76','1'),
	('PO000003','出纳0003','E000002','2020-06-06','3730.12','1'),
	('PO000004','出纳0004','E000002','2019-03-01','5038.28','1'),
	('PO000005','出纳0005','E000003','2020-10-01','3694.18','1'),
	('PO000006','出纳0006','E000003','2019-11-28','4685.41','1'),
	('PO000007','出纳0007','E000004','2018-11-10','4631.46','1'),
	('PO000008','出纳0008','E000004','2019-12-04','4464.32','1'),
	('PO000009','出纳0009','E000005','2019-02-22','4394.18','1'),
	('PO000010','出纳0010','E000005','2019-02-25','4762.32','1'),
	('PO000011','出纳0011','E000006','2019-01-03','3680.12','1'),
	('PO000012','出纳0012','E000006','2019-05-30','4868.18','1'),
	('PO000013','出纳0013','E000007','2019-03-01','5109.30','1'),
	('PO000014','出纳0014','E000007','2020-04-24','4740.84','1'),
	('PO000015','出纳0015','E000008','2020-03-16','3817.55','1'),
	('PO000016','出纳0016','E000008','2020-02-21','3784.07','1'),
	('PO000017','出纳0017','E000009','2019-09-24','4834.45','1'),
	('PO000018','出纳0018','E000009','2021-02-25','4141.15','1'),
	('PO000019','出纳0019','E000010','2020-10-26','5121.02','1'),
	('PO000020','出纳0020','E000010','2020-04-11','3732.45','1'),
	('PO000021','出纳0021','E000011','2020-07-24','4217.78','1'),
	('PO000022','出纳0022','E000011','2021-04-01','4801.72','1'),
	('PO000023','出纳0023','E000012','2019-10-05','4087.20','1'),
	('PO000024','出纳0024','E000012','2020-10-16','4128.04','1'),
	('PO000025','出纳0025','E000013','2020-11-01','5178.35','1'),
	('PO000026','出纳0026','E000013','2019-05-24','4807.26','1'),
	('PO000027','出纳0027','E000014','2021-04-16','4534.17','1'),
	('PO000028','出纳0028','E000014','2021-08-23','5117.17','1'),
	('PO000029','出纳0029','E000015','2020-11-24','4618.95','1'),
	('PO000030','出纳0030','E000015','2021-03-30','4991.84','1'),
	('PO000031','出纳0031','E000016','2021-02-09','4585.49','1'),
	('PO000032','出纳0032','E000016','2018-10-27','3773.11','1');

insert into mobile_app_data values
	('MA000001','移动端配置0001','1');

insert into page_data values
	('P000001','首页0001','首页0001','home','1','MA000001','1'),
	('P000002','首页0002','首页0002','me','2','MA000001','1'),
	('P000003','首页0003','首页0003','listof-page','3','MA000001','1'),
	('P000004','首页0004','首页0004','service-center','1','MA000001','1');

insert into page_type_data values
	('home','首页','home','MA000001','1','1'),
	('me','我的','me','MA000001','1','1'),
	('generic-page','Generic Page','generic-page','MA000001','1','1'),
	('listof-page','Listof Page','listof-page','MA000001','1','1'),
	('service-center','功能大厅','service-center','MA000001','1','1'),
	('simple','普通','simple','MA000001','1','1');

insert into slide_data values
	('S000001','首页Focus的内容0001','1','https://nice-router.oss-cn-chengdu.aliyuncs.com/slide_1.jpg','https://nice-router.oss-cn-chengdu.aliyuncs.com/slide_1.jpg','','P000001','1'),
	('S000002','首页Focus的内容0002','2','https://nice-router.oss-cn-chengdu.aliyuncs.com/slide_2.jpg','https://nice-router.oss-cn-chengdu.aliyuncs.com/slide_2.jpg','/section/article/','P000001','1'),
	('S000003','首页Focus的内容0003','3','https://nice-router.oss-cn-chengdu.aliyuncs.com/slide_3.jpg','https://nice-router.oss-cn-chengdu.aliyuncs.com/slide_3.jpg','','P000002','1'),
	('S000004','首页Focus的内容0004','1','https://nice-router.oss-cn-chengdu.aliyuncs.com/slide_1.jpg','https://nice-router.oss-cn-chengdu.aliyuncs.com/slide_1.jpg','/section/article/','P000002','1'),
	('S000005','首页Focus的内容0005','2','https://nice-router.oss-cn-chengdu.aliyuncs.com/slide_2.jpg','https://nice-router.oss-cn-chengdu.aliyuncs.com/slide_2.jpg','','P000003','1'),
	('S000006','首页Focus的内容0006','3','https://nice-router.oss-cn-chengdu.aliyuncs.com/slide_3.jpg','https://nice-router.oss-cn-chengdu.aliyuncs.com/slide_3.jpg','/section/article/','P000003','1'),
	('S000007','首页Focus的内容0007','1','https://nice-router.oss-cn-chengdu.aliyuncs.com/slide_1.jpg','https://nice-router.oss-cn-chengdu.aliyuncs.com/slide_1.jpg','','P000004','1'),
	('S000008','首页Focus的内容0008','2','https://nice-router.oss-cn-chengdu.aliyuncs.com/slide_2.jpg','https://nice-router.oss-cn-chengdu.aliyuncs.com/slide_2.jpg','/section/article/','P000004','1');

insert into ui_action_data values
	('UA000001','submit','icon_edit','提交','1','Submit','https://nice-router.oss-cn-chengdu.aliyuncs.com/slide_1.jpg','wxappService/section/article/0001','长文本例子\n','P000001','1'),
	('UA000002','share','icon_share','分享','2','Share','https://nice-router.oss-cn-chengdu.aliyuncs.com/slide_2.jpg','wxappService/section/article/0002','长文本例子\n','P000001','1'),
	('UA000003','view','icon_eye','查看','3','View','https://nice-router.oss-cn-chengdu.aliyuncs.com/slide_3.jpg','wxappService/section/article/0003','长文本例子\n','P000002','1'),
	('UA000004','more','icon_more','更多','1','View More','https://nice-router.oss-cn-chengdu.aliyuncs.com/slide_1.jpg','wxappService/section/article/0004','长文本例子\n','P000002','1'),
	('UA000005','submit','icon_edit','提交','2','Submit','https://nice-router.oss-cn-chengdu.aliyuncs.com/slide_2.jpg','wxappService/section/article/0005','长文本例子\n','P000003','1'),
	('UA000006','share','icon_share','分享','3','Share','https://nice-router.oss-cn-chengdu.aliyuncs.com/slide_3.jpg','wxappService/section/article/0006','长文本例子\n','P000003','1'),
	('UA000007','view','icon_eye','查看','1','View','https://nice-router.oss-cn-chengdu.aliyuncs.com/slide_1.jpg','wxappService/section/article/0007','长文本例子\n','P000004','1'),
	('UA000008','more','icon_more','更多','2','View More','https://nice-router.oss-cn-chengdu.aliyuncs.com/slide_2.jpg','wxappService/section/article/0008','长文本例子\n','P000004','1');

insert into section_data values
	('S000001','文章','Article','https://demo.doublechaintech.com/demodata/imageManager/genImage/icon0001/400/200/grey/','1','icon_edit','wxappService/section/article/0001','P000001','1'),
	('S000002','作品','Artwork','https://demo.doublechaintech.com/demodata/imageManager/genImage/icon0002/400/200/grey/','2','icon_share','wxappService/section/article/0002','P000001','1'),
	('S000003','文章','Article','https://demo.doublechaintech.com/demodata/imageManager/genImage/icon0003/400/200/grey/','3','icon_eye','wxappService/section/article/0003','P000002','1'),
	('S000004','作品','Artwork','https://demo.doublechaintech.com/demodata/imageManager/genImage/icon0004/400/200/grey/','1','icon_more','wxappService/section/article/0004','P000002','1'),
	('S000005','文章','Article','https://demo.doublechaintech.com/demodata/imageManager/genImage/icon0005/400/200/grey/','2','icon_edit','wxappService/section/article/0005','P000003','1'),
	('S000006','作品','Artwork','https://demo.doublechaintech.com/demodata/imageManager/genImage/icon0006/400/200/grey/','3','icon_share','wxappService/section/article/0006','P000003','1'),
	('S000007','文章','Article','https://demo.doublechaintech.com/demodata/imageManager/genImage/icon0007/400/200/grey/','1','icon_eye','wxappService/section/article/0007','P000004','1'),
	('S000008','作品','Artwork','https://demo.doublechaintech.com/demodata/imageManager/genImage/icon0008/400/200/grey/','2','icon_more','wxappService/section/article/0008','P000004','1');








insert into candidate_container_data values
	('CC000001','我只是一个容器0001','1');

insert into candidate_element_data values
	('CE000001','搜索到的匹配字段0001','类型描述0001','https://demo.doublechaintech.com/demodata/imageManager/genImage/10001/400/200/grey/','CC000001','1'),
	('CE000002','搜索到的匹配字段0002','类型描述0002','https://demo.doublechaintech.com/demodata/imageManager/genImage/10002/400/200/grey/','CC000001','1');





insert into tree_node_data values
	('TN000001','node0000010001','nodetype0001','1','8','1');





alter table retail_store_country_center_data add constraint pk4id_of_retail_store_country_center_data primary key (id);

alter table catalog_data add constraint pk4id_of_catalog_data primary key (id);
alter table catalog_data add constraint 
	fk4owner_of_catalog_data foreign key (owner) references retail_store_country_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table level_one_category_data add constraint pk4id_of_level_one_category_data primary key (id);
alter table level_one_category_data add constraint 
	fk4catalog_of_level_one_category_data foreign key (catalog) references catalog_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table level_two_category_data add constraint pk4id_of_level_two_category_data primary key (id);
alter table level_two_category_data add constraint 
	fk4parent_category_of_level_two_category_data foreign key (parent_category) references level_one_category_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table level_three_category_data add constraint pk4id_of_level_three_category_data primary key (id);
alter table level_three_category_data add constraint 
	fk4parent_category_of_level_three_category_data foreign key (parent_category) references level_two_category_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table product_data add constraint pk4id_of_product_data primary key (id);
alter table product_data add constraint 
	fk4parent_category_of_product_data foreign key (parent_category) references level_three_category_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table sku_data add constraint pk4id_of_sku_data primary key (id);
alter table sku_data add constraint 
	fk4product_of_sku_data foreign key (product) references product_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table retail_store_province_center_data add constraint pk4id_of_retail_store_province_center_data primary key (id);
alter table retail_store_province_center_data add constraint 
	fk4country_of_retail_store_province_center_data foreign key (country) references retail_store_country_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table province_center_department_data add constraint pk4id_of_province_center_department_data primary key (id);
alter table province_center_department_data add constraint 
	fk4province_center_of_province_center_department_data foreign key (province_center) references retail_store_province_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table province_center_employee_data add constraint pk4id_of_province_center_employee_data primary key (id);
alter table province_center_employee_data add constraint 
	fk4department_of_province_center_employee_data foreign key (department) references province_center_department_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table province_center_employee_data add constraint 
	fk4province_center_of_province_center_employee_data foreign key (province_center) references retail_store_province_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table retail_store_city_service_center_data add constraint pk4id_of_retail_store_city_service_center_data primary key (id);
alter table retail_store_city_service_center_data add constraint 
	fk4belongs_to_of_retail_store_city_service_center_data foreign key (belongs_to) references retail_store_province_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table city_partner_data add constraint pk4id_of_city_partner_data primary key (id);
alter table city_partner_data add constraint 
	fk4city_service_center_of_city_partner_data foreign key (city_service_center) references retail_store_city_service_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table potential_customer_data add constraint pk4id_of_potential_customer_data primary key (id);
alter table potential_customer_data add constraint 
	fk4city_service_center_of_potential_customer_data foreign key (city_service_center) references retail_store_city_service_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table potential_customer_data add constraint 
	fk4city_partner_of_potential_customer_data foreign key (city_partner) references city_partner_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table potential_customer_contact_person_data add constraint pk4id_of_potential_customer_contact_person_data primary key (id);
alter table potential_customer_contact_person_data add constraint 
	fk4potential_customer_of_potential_customer_contact_person_data foreign key (potential_customer) references potential_customer_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table potential_customer_contact_data add constraint pk4id_of_potential_customer_contact_data primary key (id);
alter table potential_customer_contact_data add constraint 
	fk4potential_customer_of_potential_customer_contact_data foreign key (potential_customer) references potential_customer_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table potential_customer_contact_data add constraint 
	fk4city_partner_of_potential_customer_contact_data foreign key (city_partner) references city_partner_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table potential_customer_contact_data add constraint 
	fk4contact_to_of_potential_customer_contact_data foreign key (contact_to) references potential_customer_contact_person_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table city_event_data add constraint pk4id_of_city_event_data primary key (id);
alter table city_event_data add constraint 
	fk4city_service_center_of_city_event_data foreign key (city_service_center) references retail_store_city_service_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table event_attendance_data add constraint pk4id_of_event_attendance_data primary key (id);
alter table event_attendance_data add constraint 
	fk4potential_customer_of_event_attendance_data foreign key (potential_customer) references potential_customer_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table event_attendance_data add constraint 
	fk4city_event_of_event_attendance_data foreign key (city_event) references city_event_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table retail_store_data add constraint pk4id_of_retail_store_data primary key (id);
alter table retail_store_data add constraint 
	fk4retail_store_country_center_of_retail_store_data foreign key (retail_store_country_center) references retail_store_country_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table retail_store_data add constraint 
	fk4city_service_center_of_retail_store_data foreign key (city_service_center) references retail_store_city_service_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table retail_store_data add constraint 
	fk4creation_of_retail_store_data foreign key (creation) references retail_store_creation_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table retail_store_data add constraint 
	fk4investment_invitation_of_retail_store_data foreign key (investment_invitation) references retail_store_investment_invitation_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table retail_store_data add constraint 
	fk4franchising_of_retail_store_data foreign key (franchising) references retail_store_franchising_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table retail_store_data add constraint 
	fk4decoration_of_retail_store_data foreign key (decoration) references retail_store_decoration_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table retail_store_data add constraint 
	fk4opening_of_retail_store_data foreign key (opening) references retail_store_opening_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table retail_store_data add constraint 
	fk4closing_of_retail_store_data foreign key (closing) references retail_store_closing_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table retail_store_creation_data add constraint pk4id_of_retail_store_creation_data primary key (id);

alter table retail_store_investment_invitation_data add constraint pk4id_of_retail_store_investment_invitation_data primary key (id);

alter table retail_store_franchising_data add constraint pk4id_of_retail_store_franchising_data primary key (id);

alter table retail_store_decoration_data add constraint pk4id_of_retail_store_decoration_data primary key (id);

alter table retail_store_opening_data add constraint pk4id_of_retail_store_opening_data primary key (id);

alter table retail_store_closing_data add constraint pk4id_of_retail_store_closing_data primary key (id);

alter table retail_store_member_data add constraint pk4id_of_retail_store_member_data primary key (id);
alter table retail_store_member_data add constraint 
	fk4owner_of_retail_store_member_data foreign key (owner) references retail_store_country_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table consumer_order_data add constraint pk4id_of_consumer_order_data primary key (id);
alter table consumer_order_data add constraint 
	fk4consumer_of_consumer_order_data foreign key (consumer) references retail_store_member_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table consumer_order_data add constraint 
	fk4store_of_consumer_order_data foreign key (store) references retail_store_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table consumer_order_line_item_data add constraint pk4id_of_consumer_order_line_item_data primary key (id);
alter table consumer_order_line_item_data add constraint 
	fk4biz_order_of_consumer_order_line_item_data foreign key (biz_order) references consumer_order_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table consumer_order_shipping_group_data add constraint pk4id_of_consumer_order_shipping_group_data primary key (id);
alter table consumer_order_shipping_group_data add constraint 
	fk4biz_order_of_consumer_order_shipping_group_data foreign key (biz_order) references consumer_order_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table consumer_order_payment_group_data add constraint pk4id_of_consumer_order_payment_group_data primary key (id);
alter table consumer_order_payment_group_data add constraint 
	fk4biz_order_of_consumer_order_payment_group_data foreign key (biz_order) references consumer_order_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table consumer_order_price_adjustment_data add constraint pk4id_of_consumer_order_price_adjustment_data primary key (id);
alter table consumer_order_price_adjustment_data add constraint 
	fk4biz_order_of_consumer_order_price_adjustment_data foreign key (biz_order) references consumer_order_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table retail_store_member_coupon_data add constraint pk4id_of_retail_store_member_coupon_data primary key (id);
alter table retail_store_member_coupon_data add constraint 
	fk4owner_of_retail_store_member_coupon_data foreign key (owner) references retail_store_member_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table member_wishlist_data add constraint pk4id_of_member_wishlist_data primary key (id);
alter table member_wishlist_data add constraint 
	fk4owner_of_member_wishlist_data foreign key (owner) references retail_store_member_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table member_reward_point_data add constraint pk4id_of_member_reward_point_data primary key (id);
alter table member_reward_point_data add constraint 
	fk4owner_of_member_reward_point_data foreign key (owner) references retail_store_member_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table member_reward_point_redemption_data add constraint pk4id_of_member_reward_point_redemption_data primary key (id);
alter table member_reward_point_redemption_data add constraint 
	fk4owner_of_member_reward_point_redemption_data foreign key (owner) references retail_store_member_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table member_wishlist_product_data add constraint pk4id_of_member_wishlist_product_data primary key (id);
alter table member_wishlist_product_data add constraint 
	fk4owner_of_member_wishlist_product_data foreign key (owner) references member_wishlist_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table retail_store_member_address_data add constraint pk4id_of_retail_store_member_address_data primary key (id);
alter table retail_store_member_address_data add constraint 
	fk4owner_of_retail_store_member_address_data foreign key (owner) references retail_store_member_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table retail_store_member_gift_card_data add constraint pk4id_of_retail_store_member_gift_card_data primary key (id);
alter table retail_store_member_gift_card_data add constraint 
	fk4owner_of_retail_store_member_gift_card_data foreign key (owner) references retail_store_member_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table retail_store_member_gift_card_consume_record_data add constraint pk4id_of_retail_store_member_gift_card_consume_record_data primary key (id);
alter table retail_store_member_gift_card_consume_record_data add constraint 
	fk4owner_of_retail_store_member_gift_card_consume_record_data foreign key (owner) references retail_store_member_gift_card_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table retail_store_member_gift_card_consume_record_data add constraint 
	fk4biz_order_of_000005 foreign key (biz_order) references consumer_order_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table goods_supplier_data add constraint pk4id_of_goods_supplier_data primary key (id);
alter table goods_supplier_data add constraint 
	fk4belong_to_of_goods_supplier_data foreign key (belong_to) references retail_store_country_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table supplier_product_data add constraint pk4id_of_supplier_product_data primary key (id);
alter table supplier_product_data add constraint 
	fk4supplier_of_supplier_product_data foreign key (supplier) references goods_supplier_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table product_supply_duration_data add constraint pk4id_of_product_supply_duration_data primary key (id);
alter table product_supply_duration_data add constraint 
	fk4product_of_product_supply_duration_data foreign key (product) references supplier_product_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table supply_order_data add constraint pk4id_of_supply_order_data primary key (id);
alter table supply_order_data add constraint 
	fk4buyer_of_supply_order_data foreign key (buyer) references retail_store_country_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table supply_order_data add constraint 
	fk4seller_of_supply_order_data foreign key (seller) references goods_supplier_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table supply_order_line_item_data add constraint pk4id_of_supply_order_line_item_data primary key (id);
alter table supply_order_line_item_data add constraint 
	fk4biz_order_of_supply_order_line_item_data foreign key (biz_order) references supply_order_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table supply_order_shipping_group_data add constraint pk4id_of_supply_order_shipping_group_data primary key (id);
alter table supply_order_shipping_group_data add constraint 
	fk4biz_order_of_supply_order_shipping_group_data foreign key (biz_order) references supply_order_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table supply_order_payment_group_data add constraint pk4id_of_supply_order_payment_group_data primary key (id);
alter table supply_order_payment_group_data add constraint 
	fk4biz_order_of_supply_order_payment_group_data foreign key (biz_order) references supply_order_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table retail_store_order_data add constraint pk4id_of_retail_store_order_data primary key (id);
alter table retail_store_order_data add constraint 
	fk4buyer_of_retail_store_order_data foreign key (buyer) references retail_store_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table retail_store_order_data add constraint 
	fk4seller_of_retail_store_order_data foreign key (seller) references retail_store_country_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table retail_store_order_line_item_data add constraint pk4id_of_retail_store_order_line_item_data primary key (id);
alter table retail_store_order_line_item_data add constraint 
	fk4biz_order_of_retail_store_order_line_item_data foreign key (biz_order) references retail_store_order_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table retail_store_order_shipping_group_data add constraint pk4id_of_retail_store_order_shipping_group_data primary key (id);
alter table retail_store_order_shipping_group_data add constraint 
	fk4biz_order_of_retail_store_order_shipping_group_data foreign key (biz_order) references retail_store_order_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table retail_store_order_payment_group_data add constraint pk4id_of_retail_store_order_payment_group_data primary key (id);
alter table retail_store_order_payment_group_data add constraint 
	fk4biz_order_of_retail_store_order_payment_group_data foreign key (biz_order) references retail_store_order_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table warehouse_data add constraint pk4id_of_warehouse_data primary key (id);
alter table warehouse_data add constraint 
	fk4owner_of_warehouse_data foreign key (owner) references retail_store_country_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table storage_space_data add constraint pk4id_of_storage_space_data primary key (id);
alter table storage_space_data add constraint 
	fk4warehouse_of_storage_space_data foreign key (warehouse) references warehouse_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table smart_pallet_data add constraint pk4id_of_smart_pallet_data primary key (id);
alter table smart_pallet_data add constraint 
	fk4warehouse_of_smart_pallet_data foreign key (warehouse) references warehouse_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table goods_shelf_data add constraint pk4id_of_goods_shelf_data primary key (id);
alter table goods_shelf_data add constraint 
	fk4storage_space_of_goods_shelf_data foreign key (storage_space) references storage_space_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table goods_shelf_data add constraint 
	fk4supplier_space_of_goods_shelf_data foreign key (supplier_space) references supplier_space_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table goods_shelf_data add constraint 
	fk4damage_space_of_goods_shelf_data foreign key (damage_space) references damage_space_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table goods_shelf_stock_count_data add constraint pk4id_of_goods_shelf_stock_count_data primary key (id);
alter table goods_shelf_stock_count_data add constraint 
	fk4shelf_of_goods_shelf_stock_count_data foreign key (shelf) references goods_shelf_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table stock_count_issue_track_data add constraint pk4id_of_stock_count_issue_track_data primary key (id);
alter table stock_count_issue_track_data add constraint 
	fk4stock_count_of_stock_count_issue_track_data foreign key (stock_count) references goods_shelf_stock_count_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table goods_allocation_data add constraint pk4id_of_goods_allocation_data primary key (id);
alter table goods_allocation_data add constraint 
	fk4goods_shelf_of_goods_allocation_data foreign key (goods_shelf) references goods_shelf_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table goods_data add constraint pk4id_of_goods_data primary key (id);
alter table goods_data add constraint 
	fk4sku_of_goods_data foreign key (sku) references sku_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table goods_data add constraint 
	fk4receiving_space_of_goods_data foreign key (receiving_space) references receiving_space_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table goods_data add constraint 
	fk4goods_allocation_of_goods_data foreign key (goods_allocation) references goods_allocation_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table goods_data add constraint 
	fk4smart_pallet_of_goods_data foreign key (smart_pallet) references smart_pallet_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table goods_data add constraint 
	fk4shipping_space_of_goods_data foreign key (shipping_space) references shipping_space_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table goods_data add constraint 
	fk4transport_task_of_goods_data foreign key (transport_task) references transport_task_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table goods_data add constraint 
	fk4retail_store_of_goods_data foreign key (retail_store) references retail_store_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table goods_data add constraint 
	fk4biz_order_of_goods_data foreign key (biz_order) references supply_order_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table goods_data add constraint 
	fk4retail_store_order_of_goods_data foreign key (retail_store_order) references retail_store_order_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table goods_movement_data add constraint pk4id_of_goods_movement_data primary key (id);
alter table goods_movement_data add constraint 
	fk4goods_of_goods_movement_data foreign key (goods) references goods_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table supplier_space_data add constraint pk4id_of_supplier_space_data primary key (id);
alter table supplier_space_data add constraint 
	fk4warehouse_of_supplier_space_data foreign key (warehouse) references warehouse_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table receiving_space_data add constraint pk4id_of_receiving_space_data primary key (id);
alter table receiving_space_data add constraint 
	fk4warehouse_of_receiving_space_data foreign key (warehouse) references warehouse_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table shipping_space_data add constraint pk4id_of_shipping_space_data primary key (id);
alter table shipping_space_data add constraint 
	fk4warehouse_of_shipping_space_data foreign key (warehouse) references warehouse_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table damage_space_data add constraint pk4id_of_damage_space_data primary key (id);
alter table damage_space_data add constraint 
	fk4warehouse_of_damage_space_data foreign key (warehouse) references warehouse_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table warehouse_asset_data add constraint pk4id_of_warehouse_asset_data primary key (id);
alter table warehouse_asset_data add constraint 
	fk4owner_of_warehouse_asset_data foreign key (owner) references warehouse_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table transport_fleet_data add constraint pk4id_of_transport_fleet_data primary key (id);
alter table transport_fleet_data add constraint 
	fk4owner_of_transport_fleet_data foreign key (owner) references retail_store_country_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table transport_truck_data add constraint pk4id_of_transport_truck_data primary key (id);
alter table transport_truck_data add constraint 
	fk4owner_of_transport_truck_data foreign key (owner) references transport_fleet_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table truck_driver_data add constraint pk4id_of_truck_driver_data primary key (id);
alter table truck_driver_data add constraint 
	fk4belongs_to_of_truck_driver_data foreign key (belongs_to) references transport_fleet_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table transport_task_data add constraint pk4id_of_transport_task_data primary key (id);
alter table transport_task_data add constraint 
	fk4end_of_transport_task_data foreign key (end) references retail_store_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table transport_task_data add constraint 
	fk4driver_of_transport_task_data foreign key (driver) references truck_driver_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table transport_task_data add constraint 
	fk4truck_of_transport_task_data foreign key (truck) references transport_truck_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table transport_task_data add constraint 
	fk4belongs_to_of_transport_task_data foreign key (belongs_to) references transport_fleet_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table transport_task_track_data add constraint pk4id_of_transport_task_track_data primary key (id);
alter table transport_task_track_data add constraint 
	fk4movement_of_transport_task_track_data foreign key (movement) references transport_task_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table account_set_data add constraint pk4id_of_account_set_data primary key (id);
alter table account_set_data add constraint 
	fk4country_center_of_account_set_data foreign key (country_center) references retail_store_country_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table account_set_data add constraint 
	fk4retail_store_of_account_set_data foreign key (retail_store) references retail_store_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table account_set_data add constraint 
	fk4goods_supplier_of_account_set_data foreign key (goods_supplier) references goods_supplier_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table accounting_subject_data add constraint pk4id_of_accounting_subject_data primary key (id);
alter table accounting_subject_data add constraint 
	fk4account_set_of_accounting_subject_data foreign key (account_set) references account_set_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table accounting_period_data add constraint pk4id_of_accounting_period_data primary key (id);
alter table accounting_period_data add constraint 
	fk4account_set_of_accounting_period_data foreign key (account_set) references account_set_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table accounting_document_type_data add constraint pk4id_of_accounting_document_type_data primary key (id);
alter table accounting_document_type_data add constraint 
	fk4accounting_period_of_accounting_document_type_data foreign key (accounting_period) references account_set_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table accounting_document_data add constraint pk4id_of_accounting_document_data primary key (id);
alter table accounting_document_data add constraint 
	fk4accounting_period_of_accounting_document_data foreign key (accounting_period) references accounting_period_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table accounting_document_data add constraint 
	fk4document_type_of_accounting_document_data foreign key (document_type) references accounting_document_type_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table original_voucher_data add constraint pk4id_of_original_voucher_data primary key (id);
alter table original_voucher_data add constraint 
	fk4belongs_to_of_original_voucher_data foreign key (belongs_to) references accounting_document_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table accounting_document_line_data add constraint pk4id_of_accounting_document_line_data primary key (id);
alter table accounting_document_line_data add constraint 
	fk4belongs_to_of_accounting_document_line_data foreign key (belongs_to) references accounting_document_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table accounting_document_line_data add constraint 
	fk4accounting_subject_of_accounting_document_line_data foreign key (accounting_subject) references accounting_subject_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table level_one_department_data add constraint pk4id_of_level_one_department_data primary key (id);
alter table level_one_department_data add constraint 
	fk4belongs_to_of_level_one_department_data foreign key (belongs_to) references retail_store_country_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table level_two_department_data add constraint pk4id_of_level_two_department_data primary key (id);
alter table level_two_department_data add constraint 
	fk4belongs_to_of_level_two_department_data foreign key (belongs_to) references level_one_department_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table level_three_department_data add constraint pk4id_of_level_three_department_data primary key (id);
alter table level_three_department_data add constraint 
	fk4belongs_to_of_level_three_department_data foreign key (belongs_to) references level_two_department_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table skill_type_data add constraint pk4id_of_skill_type_data primary key (id);
alter table skill_type_data add constraint 
	fk4company_of_skill_type_data foreign key (company) references retail_store_country_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table responsibility_type_data add constraint pk4id_of_responsibility_type_data primary key (id);
alter table responsibility_type_data add constraint 
	fk4company_of_responsibility_type_data foreign key (company) references retail_store_country_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table termination_reason_data add constraint pk4id_of_termination_reason_data primary key (id);
alter table termination_reason_data add constraint 
	fk4company_of_termination_reason_data foreign key (company) references retail_store_country_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table termination_type_data add constraint pk4id_of_termination_type_data primary key (id);
alter table termination_type_data add constraint 
	fk4company_of_termination_type_data foreign key (company) references retail_store_country_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table occupation_type_data add constraint pk4id_of_occupation_type_data primary key (id);
alter table occupation_type_data add constraint 
	fk4company_of_occupation_type_data foreign key (company) references retail_store_country_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table leave_type_data add constraint pk4id_of_leave_type_data primary key (id);
alter table leave_type_data add constraint 
	fk4company_of_leave_type_data foreign key (company) references retail_store_country_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table salary_grade_data add constraint pk4id_of_salary_grade_data primary key (id);
alter table salary_grade_data add constraint 
	fk4company_of_salary_grade_data foreign key (company) references retail_store_country_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table interview_type_data add constraint pk4id_of_interview_type_data primary key (id);
alter table interview_type_data add constraint 
	fk4company_of_interview_type_data foreign key (company) references retail_store_country_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table training_course_type_data add constraint pk4id_of_training_course_type_data primary key (id);
alter table training_course_type_data add constraint 
	fk4company_of_training_course_type_data foreign key (company) references retail_store_country_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table public_holiday_data add constraint pk4id_of_public_holiday_data primary key (id);
alter table public_holiday_data add constraint 
	fk4company_of_public_holiday_data foreign key (company) references retail_store_country_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table termination_data add constraint pk4id_of_termination_data primary key (id);
alter table termination_data add constraint 
	fk4reason_of_termination_data foreign key (reason) references termination_reason_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table termination_data add constraint 
	fk4type_of_termination_data foreign key (type) references termination_type_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table view_data add constraint pk4id_of_view_data primary key (id);

alter table employee_data add constraint pk4id_of_employee_data primary key (id);
alter table employee_data add constraint 
	fk4company_of_employee_data foreign key (company) references retail_store_country_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table employee_data add constraint 
	fk4department_of_employee_data foreign key (department) references level_three_department_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table employee_data add constraint 
	fk4occupation_of_employee_data foreign key (occupation) references occupation_type_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table employee_data add constraint 
	fk4responsible_for_of_employee_data foreign key (responsible_for) references responsibility_type_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table employee_data add constraint 
	fk4current_salary_grade_of_employee_data foreign key (current_salary_grade) references salary_grade_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table instructor_data add constraint pk4id_of_instructor_data primary key (id);
alter table instructor_data add constraint 
	fk4company_of_instructor_data foreign key (company) references retail_store_country_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table company_training_data add constraint pk4id_of_company_training_data primary key (id);
alter table company_training_data add constraint 
	fk4company_of_company_training_data foreign key (company) references retail_store_country_center_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table company_training_data add constraint 
	fk4instructor_of_company_training_data foreign key (instructor) references instructor_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table company_training_data add constraint 
	fk4training_course_type_of_company_training_data foreign key (training_course_type) references training_course_type_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table scoring_data add constraint pk4id_of_scoring_data primary key (id);

alter table employee_company_training_data add constraint pk4id_of_employee_company_training_data primary key (id);
alter table employee_company_training_data add constraint 
	fk4employee_of_employee_company_training_data foreign key (employee) references employee_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table employee_company_training_data add constraint 
	fk4training_of_employee_company_training_data foreign key (training) references company_training_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table employee_company_training_data add constraint 
	fk4scoring_of_employee_company_training_data foreign key (scoring) references scoring_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table employee_skill_data add constraint pk4id_of_employee_skill_data primary key (id);
alter table employee_skill_data add constraint 
	fk4employee_of_employee_skill_data foreign key (employee) references employee_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table employee_skill_data add constraint 
	fk4skill_type_of_employee_skill_data foreign key (skill_type) references skill_type_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table employee_performance_data add constraint pk4id_of_employee_performance_data primary key (id);
alter table employee_performance_data add constraint 
	fk4employee_of_employee_performance_data foreign key (employee) references employee_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table employee_work_experience_data add constraint pk4id_of_employee_work_experience_data primary key (id);
alter table employee_work_experience_data add constraint 
	fk4employee_of_employee_work_experience_data foreign key (employee) references employee_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table employee_leave_data add constraint pk4id_of_employee_leave_data primary key (id);
alter table employee_leave_data add constraint 
	fk4who_of_employee_leave_data foreign key (who) references employee_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table employee_leave_data add constraint 
	fk4type_of_employee_leave_data foreign key (type) references leave_type_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table employee_interview_data add constraint pk4id_of_employee_interview_data primary key (id);
alter table employee_interview_data add constraint 
	fk4employee_of_employee_interview_data foreign key (employee) references employee_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table employee_interview_data add constraint 
	fk4interview_type_of_employee_interview_data foreign key (interview_type) references interview_type_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table employee_attendance_data add constraint pk4id_of_employee_attendance_data primary key (id);
alter table employee_attendance_data add constraint 
	fk4employee_of_employee_attendance_data foreign key (employee) references employee_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table employee_qualifier_data add constraint pk4id_of_employee_qualifier_data primary key (id);
alter table employee_qualifier_data add constraint 
	fk4employee_of_employee_qualifier_data foreign key (employee) references employee_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table employee_education_data add constraint pk4id_of_employee_education_data primary key (id);
alter table employee_education_data add constraint 
	fk4employee_of_employee_education_data foreign key (employee) references employee_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table employee_award_data add constraint pk4id_of_employee_award_data primary key (id);
alter table employee_award_data add constraint 
	fk4employee_of_employee_award_data foreign key (employee) references employee_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table employee_salary_sheet_data add constraint pk4id_of_employee_salary_sheet_data primary key (id);
alter table employee_salary_sheet_data add constraint 
	fk4employee_of_employee_salary_sheet_data foreign key (employee) references employee_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table employee_salary_sheet_data add constraint 
	fk4current_salary_grade_of_employee_salary_sheet_data foreign key (current_salary_grade) references salary_grade_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table employee_salary_sheet_data add constraint 
	fk4paying_off_of_employee_salary_sheet_data foreign key (paying_off) references paying_off_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table paying_off_data add constraint pk4id_of_paying_off_data primary key (id);
alter table paying_off_data add constraint 
	fk4paid_for_of_paying_off_data foreign key (paid_for) references employee_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table mobile_app_data add constraint pk4id_of_mobile_app_data primary key (id);

alter table page_data add constraint pk4id_of_page_data primary key (id);
alter table page_data add constraint 
	fk4page_type_of_page_data foreign key (page_type) references page_type_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table page_data add constraint 
	fk4mobile_app_of_page_data foreign key (mobile_app) references mobile_app_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table page_type_data add constraint pk4id_of_page_type_data primary key (id);
alter table page_type_data add constraint 
	fk4mobile_app_of_page_type_data foreign key (mobile_app) references mobile_app_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table slide_data add constraint pk4id_of_slide_data primary key (id);
alter table slide_data add constraint 
	fk4page_of_slide_data foreign key (page) references page_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table ui_action_data add constraint pk4id_of_ui_action_data primary key (id);
alter table ui_action_data add constraint 
	fk4page_of_ui_action_data foreign key (page) references page_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table section_data add constraint pk4id_of_section_data primary key (id);
alter table section_data add constraint 
	fk4page_of_section_data foreign key (page) references page_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table user_domain_data add constraint pk4id_of_user_domain_data primary key (id);

alter table user_allow_list_data add constraint pk4id_of_user_allow_list_data primary key (id);
alter table user_allow_list_data add constraint 
	fk4domain_of_user_allow_list_data foreign key (domain) references user_domain_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table sec_user_data add constraint pk4id_of_sec_user_data primary key (id);
alter table sec_user_data add constraint 
	fk4domain_of_sec_user_data foreign key (domain) references user_domain_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table user_app_data add constraint pk4id_of_user_app_data primary key (id);
alter table user_app_data add constraint 
	fk4sec_user_of_user_app_data foreign key (sec_user) references sec_user_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table quick_link_data add constraint pk4id_of_quick_link_data primary key (id);
alter table quick_link_data add constraint 
	fk4app_of_quick_link_data foreign key (app) references user_app_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table list_access_data add constraint pk4id_of_list_access_data primary key (id);
alter table list_access_data add constraint 
	fk4app_of_list_access_data foreign key (app) references user_app_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table login_history_data add constraint pk4id_of_login_history_data primary key (id);
alter table login_history_data add constraint 
	fk4sec_user_of_login_history_data foreign key (sec_user) references sec_user_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table candidate_container_data add constraint pk4id_of_candidate_container_data primary key (id);

alter table candidate_element_data add constraint pk4id_of_candidate_element_data primary key (id);
alter table candidate_element_data add constraint 
	fk4container_of_candidate_element_data foreign key (container) references candidate_container_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table wechat_workapp_identity_data add constraint pk4id_of_wechat_workapp_identity_data primary key (id);
alter table wechat_workapp_identity_data add constraint 
	fk4sec_user_of_wechat_workapp_identity_data foreign key (sec_user) references sec_user_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table wechat_miniapp_identity_data add constraint pk4id_of_wechat_miniapp_identity_data primary key (id);
alter table wechat_miniapp_identity_data add constraint 
	fk4sec_user_of_wechat_miniapp_identity_data foreign key (sec_user) references sec_user_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table key_pair_identity_data add constraint pk4id_of_key_pair_identity_data primary key (id);
alter table key_pair_identity_data add constraint 
	fk4key_type_of_key_pair_identity_data foreign key (key_type) references public_key_type_data(id) ON DELETE CASCADE ON UPDATE CASCADE;
alter table key_pair_identity_data add constraint 
	fk4sec_user_of_key_pair_identity_data foreign key (sec_user) references sec_user_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table public_key_type_data add constraint pk4id_of_public_key_type_data primary key (id);
alter table public_key_type_data add constraint 
	fk4domain_of_public_key_type_data foreign key (domain) references user_domain_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

alter table tree_node_data add constraint pk4id_of_tree_node_data primary key (id);
-- create extra index for time, number and mobile phone
create unique index idx4id_ver_of_retail_store_country_center on retail_store_country_center_data (id, version);
create  index idx4founded_of_retail_store_country_center on retail_store_country_center_data (founded);

create unique index idx4id_ver_of_catalog on catalog_data (id, version);
create  index idx4sub_count_of_catalog on catalog_data (sub_count);
create  index idx4amount_of_catalog on catalog_data (amount);

create unique index idx4id_ver_of_level_one_category on level_one_category_data (id, version);

create unique index idx4id_ver_of_level_two_category on level_two_category_data (id, version);

create unique index idx4id_ver_of_level_three_category on level_three_category_data (id, version);

create unique index idx4id_ver_of_product on product_data (id, version);
create  index idx4last_update_time_of_product on product_data (last_update_time);

create unique index idx4id_ver_of_sku on sku_data (id, version);
create  index idx4price_of_sku on sku_data (price);

create unique index idx4id_ver_of_retail_store_province_center on retail_store_province_center_data (id, version);
create  index idx4founded_of_retail_store_province_center on retail_store_province_center_data (founded);
create  index idx4last_update_time_of_retail_store_province_center on retail_store_province_center_data (last_update_time);

create unique index idx4id_ver_of_province_center_department on province_center_department_data (id, version);
create  index idx4founded_of_province_center_department on province_center_department_data (founded);

create unique index idx4id_ver_of_province_center_employee on province_center_employee_data (id, version);
create  index idx4mobile_of_province_center_employee on province_center_employee_data (mobile);
create  index idx4founded_of_province_center_employee on province_center_employee_data (founded);

create unique index idx4id_ver_of_retail_store_city_service_center on retail_store_city_service_center_data (id, version);
create  index idx4founded_of_retail_store_city_service_center on retail_store_city_service_center_data (founded);
create  index idx4last_update_time_of_retail_store_city_service_center on retail_store_city_service_center_data (last_update_time);

create unique index idx4id_ver_of_city_partner on city_partner_data (id, version);
create  index idx4mobile_of_city_partner on city_partner_data (mobile);
create  index idx4last_update_time_of_city_partner on city_partner_data (last_update_time);

create unique index idx4id_ver_of_potential_customer on potential_customer_data (id, version);
create  index idx4mobile_of_potential_customer on potential_customer_data (mobile);
create  index idx4last_update_time_of_potential_customer on potential_customer_data (last_update_time);

create unique index idx4id_ver_of_potential_customer_contact_person on potential_customer_contact_person_data (id, version);
create  index idx4mobile_of_potential_customer_contact_person on potential_customer_contact_person_data (mobile);

create unique index idx4id_ver_of_potential_customer_contact on potential_customer_contact_data (id, version);
create  index idx4contact_date_of_potential_customer_contact on potential_customer_contact_data (contact_date);
create  index idx4last_update_time_of_potential_customer_contact on potential_customer_contact_data (last_update_time);

create unique index idx4id_ver_of_city_event on city_event_data (id, version);
create  index idx4mobile_of_city_event on city_event_data (mobile);
create  index idx4last_update_time_of_city_event on city_event_data (last_update_time);

create unique index idx4id_ver_of_event_attendance on event_attendance_data (id, version);

create unique index idx4id_ver_of_retail_store on retail_store_data (id, version);
create  index idx4founded_of_retail_store on retail_store_data (founded);
create  index idx4latitude_of_retail_store on retail_store_data (latitude);
create  index idx4longitude_of_retail_store on retail_store_data (longitude);
create  index idx4last_update_time_of_retail_store on retail_store_data (last_update_time);

create unique index idx4id_ver_of_retail_store_creation on retail_store_creation_data (id, version);

create unique index idx4id_ver_of_retail_store_investment_invitation on retail_store_investment_invitation_data (id, version);

create unique index idx4id_ver_of_retail_store_franchising on retail_store_franchising_data (id, version);

create unique index idx4id_ver_of_retail_store_decoration on retail_store_decoration_data (id, version);

create unique index idx4id_ver_of_retail_store_opening on retail_store_opening_data (id, version);

create unique index idx4id_ver_of_retail_store_closing on retail_store_closing_data (id, version);

create unique index idx4id_ver_of_retail_store_member on retail_store_member_data (id, version);
create  index idx4mobile_phone_of_retail_store_member on retail_store_member_data (mobile_phone);

create unique index idx4id_ver_of_consumer_order on consumer_order_data (id, version);
create  index idx4last_update_time_of_consumer_order on consumer_order_data (last_update_time);

create unique index idx4id_ver_of_consumer_order_line_item on consumer_order_line_item_data (id, version);
create  index idx4sku_id_of_consumer_order_line_item on consumer_order_line_item_data (sku_id);
create  index idx4price_of_consumer_order_line_item on consumer_order_line_item_data (price);
create  index idx4quantity_of_consumer_order_line_item on consumer_order_line_item_data (quantity);
create  index idx4amount_of_consumer_order_line_item on consumer_order_line_item_data (amount);
create  index idx4last_update_time_of_consumer_order_line_item on consumer_order_line_item_data (last_update_time);

create unique index idx4id_ver_of_consumer_order_shipping_group on consumer_order_shipping_group_data (id, version);
create  index idx4amount_of_consumer_order_shipping_group on consumer_order_shipping_group_data (amount);

create unique index idx4id_ver_of_consumer_order_payment_group on consumer_order_payment_group_data (id, version);

create unique index idx4id_ver_of_consumer_order_price_adjustment on consumer_order_price_adjustment_data (id, version);
create  index idx4amount_of_consumer_order_price_adjustment on consumer_order_price_adjustment_data (amount);

create unique index idx4id_ver_of_retail_store_member_coupon on retail_store_member_coupon_data (id, version);
create  index idx4last_update_time_of_retail_store_member_coupon on retail_store_member_coupon_data (last_update_time);

create unique index idx4id_ver_of_member_wishlist on member_wishlist_data (id, version);

create unique index idx4id_ver_of_member_reward_point on member_reward_point_data (id, version);
create  index idx4point_of_member_reward_point on member_reward_point_data (point);

create unique index idx4id_ver_of_member_reward_point_redemption on member_reward_point_redemption_data (id, version);
create  index idx4point_of_member_reward_point_redemption on member_reward_point_redemption_data (point);

create unique index idx4id_ver_of_member_wishlist_product on member_wishlist_product_data (id, version);

create unique index idx4id_ver_of_retail_store_member_address on retail_store_member_address_data (id, version);
create  index idx4mobile_phone_of_retail_store_member_address on retail_store_member_address_data (mobile_phone);

create unique index idx4id_ver_of_retail_store_member_gift_card on retail_store_member_gift_card_data (id, version);
create  index idx4remain_of_retail_store_member_gift_card on retail_store_member_gift_card_data (remain);

create unique index idx4id_ver_of_retail_store_member_gift_card_consume_record on retail_store_member_gift_card_consume_record_data (id, version);
create  index idx9416669638778441 on retail_store_member_gift_card_consume_record_data (occure_time);
create  index idx4amount_of_retail_store_member_gift_card_consume_record on retail_store_member_gift_card_consume_record_data (amount);

create unique index idx4id_ver_of_goods_supplier on goods_supplier_data (id, version);
create  index idx4contact_number_of_goods_supplier on goods_supplier_data (contact_number);
create  index idx4last_update_time_of_goods_supplier on goods_supplier_data (last_update_time);

create unique index idx4id_ver_of_supplier_product on supplier_product_data (id, version);

create unique index idx4id_ver_of_product_supply_duration on product_supply_duration_data (id, version);
create  index idx4quantity_of_product_supply_duration on product_supply_duration_data (quantity);
create  index idx4price_of_product_supply_duration on product_supply_duration_data (price);

create unique index idx4id_ver_of_supply_order on supply_order_data (id, version);
create  index idx4total_amount_of_supply_order on supply_order_data (total_amount);
create  index idx4last_update_time_of_supply_order on supply_order_data (last_update_time);

create unique index idx4id_ver_of_supply_order_line_item on supply_order_line_item_data (id, version);
create  index idx4sku_id_of_supply_order_line_item on supply_order_line_item_data (sku_id);
create  index idx4amount_of_supply_order_line_item on supply_order_line_item_data (amount);
create  index idx4quantity_of_supply_order_line_item on supply_order_line_item_data (quantity);

create unique index idx4id_ver_of_supply_order_shipping_group on supply_order_shipping_group_data (id, version);
create  index idx4amount_of_supply_order_shipping_group on supply_order_shipping_group_data (amount);

create unique index idx4id_ver_of_supply_order_payment_group on supply_order_payment_group_data (id, version);

create unique index idx4id_ver_of_retail_store_order on retail_store_order_data (id, version);
create  index idx4total_amount_of_retail_store_order on retail_store_order_data (total_amount);
create  index idx4last_update_time_of_retail_store_order on retail_store_order_data (last_update_time);

create unique index idx4id_ver_of_retail_store_order_line_item on retail_store_order_line_item_data (id, version);
create  index idx4sku_id_of_retail_store_order_line_item on retail_store_order_line_item_data (sku_id);
create  index idx4amount_of_retail_store_order_line_item on retail_store_order_line_item_data (amount);
create  index idx4quantity_of_retail_store_order_line_item on retail_store_order_line_item_data (quantity);

create unique index idx4id_ver_of_retail_store_order_shipping_group on retail_store_order_shipping_group_data (id, version);
create  index idx4amount_of_retail_store_order_shipping_group on retail_store_order_shipping_group_data (amount);

create unique index idx4id_ver_of_retail_store_order_payment_group on retail_store_order_payment_group_data (id, version);

create unique index idx4id_ver_of_warehouse on warehouse_data (id, version);
create  index idx4latitude_of_warehouse on warehouse_data (latitude);
create  index idx4longitude_of_warehouse on warehouse_data (longitude);
create  index idx4last_update_time_of_warehouse on warehouse_data (last_update_time);

create unique index idx4id_ver_of_storage_space on storage_space_data (id, version);
create  index idx4latitude_of_storage_space on storage_space_data (latitude);
create  index idx4longitude_of_storage_space on storage_space_data (longitude);
create  index idx4last_update_time_of_storage_space on storage_space_data (last_update_time);

create unique index idx4id_ver_of_smart_pallet on smart_pallet_data (id, version);
create  index idx4latitude_of_smart_pallet on smart_pallet_data (latitude);
create  index idx4longitude_of_smart_pallet on smart_pallet_data (longitude);
create  index idx4last_update_time_of_smart_pallet on smart_pallet_data (last_update_time);

create unique index idx4id_ver_of_goods_shelf on goods_shelf_data (id, version);
create  index idx4last_update_time_of_goods_shelf on goods_shelf_data (last_update_time);

create unique index idx4id_ver_of_goods_shelf_stock_count on goods_shelf_stock_count_data (id, version);
create  index idx4count_time_of_goods_shelf_stock_count on goods_shelf_stock_count_data (count_time);

create unique index idx4id_ver_of_stock_count_issue_track on stock_count_issue_track_data (id, version);
create  index idx4count_time_of_stock_count_issue_track on stock_count_issue_track_data (count_time);

create unique index idx4id_ver_of_goods_allocation on goods_allocation_data (id, version);
create  index idx4latitude_of_goods_allocation on goods_allocation_data (latitude);
create  index idx4longitude_of_goods_allocation on goods_allocation_data (longitude);

create unique index idx4id_ver_of_goods on goods_data (id, version);
create  index idx4max_package_of_goods on goods_data (max_package);
create  index idx4expire_time_of_goods on goods_data (expire_time);

create unique index idx4id_ver_of_goods_movement on goods_movement_data (id, version);
create  index idx4move_time_of_goods_movement on goods_movement_data (move_time);
create  index idx4facility_id_of_goods_movement on goods_movement_data (facility_id);
create  index idx4session_id_of_goods_movement on goods_movement_data (session_id);
create  index idx4latitude_of_goods_movement on goods_movement_data (latitude);
create  index idx4longitude_of_goods_movement on goods_movement_data (longitude);

create unique index idx4id_ver_of_supplier_space on supplier_space_data (id, version);
create  index idx4latitude_of_supplier_space on supplier_space_data (latitude);
create  index idx4longitude_of_supplier_space on supplier_space_data (longitude);
create  index idx4last_update_time_of_supplier_space on supplier_space_data (last_update_time);

create unique index idx4id_ver_of_receiving_space on receiving_space_data (id, version);
create  index idx4latitude_of_receiving_space on receiving_space_data (latitude);
create  index idx4longitude_of_receiving_space on receiving_space_data (longitude);
create  index idx4last_update_time_of_receiving_space on receiving_space_data (last_update_time);

create unique index idx4id_ver_of_shipping_space on shipping_space_data (id, version);
create  index idx4latitude_of_shipping_space on shipping_space_data (latitude);
create  index idx4longitude_of_shipping_space on shipping_space_data (longitude);
create  index idx4last_update_time_of_shipping_space on shipping_space_data (last_update_time);

create unique index idx4id_ver_of_damage_space on damage_space_data (id, version);
create  index idx4latitude_of_damage_space on damage_space_data (latitude);
create  index idx4longitude_of_damage_space on damage_space_data (longitude);
create  index idx4last_update_time_of_damage_space on damage_space_data (last_update_time);

create unique index idx4id_ver_of_warehouse_asset on warehouse_asset_data (id, version);
create  index idx4last_update_time_of_warehouse_asset on warehouse_asset_data (last_update_time);

create unique index idx4id_ver_of_transport_fleet on transport_fleet_data (id, version);
create  index idx4last_update_time_of_transport_fleet on transport_fleet_data (last_update_time);

create unique index idx4id_ver_of_transport_truck on transport_truck_data (id, version);
create  index idx4make_date_of_transport_truck on transport_truck_data (make_date);

create unique index idx4id_ver_of_truck_driver on truck_driver_data (id, version);
create  index idx4contact_number_of_truck_driver on truck_driver_data (contact_number);

create unique index idx4id_ver_of_transport_task on transport_task_data (id, version);
create  index idx4begin_time_of_transport_task on transport_task_data (begin_time);
create  index idx4latitude_of_transport_task on transport_task_data (latitude);
create  index idx4longitude_of_transport_task on transport_task_data (longitude);

create unique index idx4id_ver_of_transport_task_track on transport_task_track_data (id, version);
create  index idx4track_time_of_transport_task_track on transport_task_track_data (track_time);
create  index idx4latitude_of_transport_task_track on transport_task_track_data (latitude);
create  index idx4longitude_of_transport_task_track on transport_task_track_data (longitude);

create unique index idx4id_ver_of_account_set on account_set_data (id, version);
create  index idx4effective_date_of_account_set on account_set_data (effective_date);
create  index idx4last_update_time_of_account_set on account_set_data (last_update_time);

create unique index idx4id_ver_of_accounting_subject on accounting_subject_data (id, version);
create  index idx4accounting_subject_class_code_of_accounting_subject on accounting_subject_data (accounting_subject_class_code);

create unique index idx4id_ver_of_accounting_period on accounting_period_data (id, version);
create  index idx4start_date_of_accounting_period on accounting_period_data (start_date);
create  index idx4end_date_of_accounting_period on accounting_period_data (end_date);

create unique index idx4id_ver_of_accounting_document_type on accounting_document_type_data (id, version);

create unique index idx4id_ver_of_accounting_document on accounting_document_data (id, version);
create  index idx4accounting_document_date_of_accounting_document on accounting_document_data (accounting_document_date);

create unique index idx4id_ver_of_original_voucher on original_voucher_data (id, version);

create unique index idx4id_ver_of_accounting_document_line on accounting_document_line_data (id, version);
create  index idx4amount_of_accounting_document_line on accounting_document_line_data (amount);

create unique index idx4id_ver_of_level_one_department on level_one_department_data (id, version);
create  index idx4founded_of_level_one_department on level_one_department_data (founded);

create unique index idx4id_ver_of_level_two_department on level_two_department_data (id, version);
create  index idx4founded_of_level_two_department on level_two_department_data (founded);

create unique index idx4id_ver_of_level_three_department on level_three_department_data (id, version);
create  index idx4founded_of_level_three_department on level_three_department_data (founded);

create unique index idx4id_ver_of_skill_type on skill_type_data (id, version);

create unique index idx4id_ver_of_responsibility_type on responsibility_type_data (id, version);

create unique index idx4id_ver_of_termination_reason on termination_reason_data (id, version);

create unique index idx4id_ver_of_termination_type on termination_type_data (id, version);

create unique index idx4id_ver_of_occupation_type on occupation_type_data (id, version);

create unique index idx4id_ver_of_leave_type on leave_type_data (id, version);

create unique index idx4id_ver_of_salary_grade on salary_grade_data (id, version);

create unique index idx4id_ver_of_interview_type on interview_type_data (id, version);

create unique index idx4id_ver_of_training_course_type on training_course_type_data (id, version);

create unique index idx4id_ver_of_public_holiday on public_holiday_data (id, version);

create unique index idx4id_ver_of_termination on termination_data (id, version);

create unique index idx4id_ver_of_view on view_data (id, version);
create  index idx4interview_time_of_view on view_data (interview_time);

create unique index idx4id_ver_of_employee on employee_data (id, version);
create  index idx4cell_phone_of_employee on employee_data (cell_phone);
create  index idx4last_update_time_of_employee on employee_data (last_update_time);

create unique index idx4id_ver_of_instructor on instructor_data (id, version);
create  index idx4cell_phone_of_instructor on instructor_data (cell_phone);
create  index idx4last_update_time_of_instructor on instructor_data (last_update_time);

create unique index idx4id_ver_of_company_training on company_training_data (id, version);
create  index idx4time_start_of_company_training on company_training_data (time_start);
create  index idx4duration_hours_of_company_training on company_training_data (duration_hours);
create  index idx4last_update_time_of_company_training on company_training_data (last_update_time);

create unique index idx4id_ver_of_scoring on scoring_data (id, version);
create  index idx4score_of_scoring on scoring_data (score);

create unique index idx4id_ver_of_employee_company_training on employee_company_training_data (id, version);

create unique index idx4id_ver_of_employee_skill on employee_skill_data (id, version);

create unique index idx4id_ver_of_employee_performance on employee_performance_data (id, version);

create unique index idx4id_ver_of_employee_work_experience on employee_work_experience_data (id, version);
create  index idx4start_of_employee_work_experience on employee_work_experience_data (start);
create  index idx4end_of_employee_work_experience on employee_work_experience_data (end);

create unique index idx4id_ver_of_employee_leave on employee_leave_data (id, version);
create  index idx4leave_duration_hour_of_employee_leave on employee_leave_data (leave_duration_hour);

create unique index idx4id_ver_of_employee_interview on employee_interview_data (id, version);

create unique index idx4id_ver_of_employee_attendance on employee_attendance_data (id, version);
create  index idx4enter_time_of_employee_attendance on employee_attendance_data (enter_time);
create  index idx4leave_time_of_employee_attendance on employee_attendance_data (leave_time);
create  index idx4duration_hours_of_employee_attendance on employee_attendance_data (duration_hours);

create unique index idx4id_ver_of_employee_qualifier on employee_qualifier_data (id, version);
create  index idx4qualified_time_of_employee_qualifier on employee_qualifier_data (qualified_time);

create unique index idx4id_ver_of_employee_education on employee_education_data (id, version);
create  index idx4complete_time_of_employee_education on employee_education_data (complete_time);

create unique index idx4id_ver_of_employee_award on employee_award_data (id, version);
create  index idx4complete_time_of_employee_award on employee_award_data (complete_time);

create unique index idx4id_ver_of_employee_salary_sheet on employee_salary_sheet_data (id, version);
create  index idx4base_salary_of_employee_salary_sheet on employee_salary_sheet_data (base_salary);
create  index idx4bonus_of_employee_salary_sheet on employee_salary_sheet_data (bonus);
create  index idx4reward_of_employee_salary_sheet on employee_salary_sheet_data (reward);
create  index idx4personal_tax_of_employee_salary_sheet on employee_salary_sheet_data (personal_tax);
create  index idx4social_security_of_employee_salary_sheet on employee_salary_sheet_data (social_security);
create  index idx4housing_found_of_employee_salary_sheet on employee_salary_sheet_data (housing_found);
create  index idx4job_insurance_of_employee_salary_sheet on employee_salary_sheet_data (job_insurance);

create unique index idx4id_ver_of_paying_off on paying_off_data (id, version);
create  index idx4paid_time_of_paying_off on paying_off_data (paid_time);
create  index idx4amount_of_paying_off on paying_off_data (amount);

create unique index idx4id_ver_of_mobile_app on mobile_app_data (id, version);

create unique index idx4id_ver_of_page on page_data (id, version);
create  index idx4display_order_of_page on page_data (display_order);

create unique index idx4id_ver_of_page_type on page_type_data (id, version);
create unique index idx4code_of_page_type on page_type_data (code);

create unique index idx4id_ver_of_slide on slide_data (id, version);
create  index idx4display_order_of_slide on slide_data (display_order);

create unique index idx4id_ver_of_ui_action on ui_action_data (id, version);
create  index idx4display_order_of_ui_action on ui_action_data (display_order);

create unique index idx4id_ver_of_section on section_data (id, version);
create  index idx4display_order_of_section on section_data (display_order);

create unique index idx4id_ver_of_user_domain on user_domain_data (id, version);

create unique index idx4id_ver_of_user_allow_list on user_allow_list_data (id, version);
create  index idx4user_identity_of_user_allow_list on user_allow_list_data (user_identity);

create unique index idx4id_ver_of_sec_user on sec_user_data (id, version);
create unique index idx4login_of_sec_user on sec_user_data (login);
create unique index idx4email_of_sec_user on sec_user_data (email);
create unique index idx4mobile_of_sec_user on sec_user_data (mobile);
create  index idx4verification_code_of_sec_user on sec_user_data (verification_code);
create  index idx4verification_code_expire_of_sec_user on sec_user_data (verification_code_expire);
create  index idx4last_login_time_of_sec_user on sec_user_data (last_login_time);

create unique index idx4id_ver_of_user_app on user_app_data (id, version);
create  index idx4app_id_of_user_app on user_app_data (app_id);
create  index idx4ctx_id_of_user_app on user_app_data (ctx_id);

create unique index idx4id_ver_of_quick_link on quick_link_data (id, version);
create  index idx4create_time_of_quick_link on quick_link_data (create_time);

create unique index idx4id_ver_of_list_access on list_access_data (id, version);

create unique index idx4id_ver_of_login_history on login_history_data (id, version);
create  index idx4login_time_of_login_history on login_history_data (login_time);

create unique index idx4id_ver_of_candidate_container on candidate_container_data (id, version);

create unique index idx4id_ver_of_candidate_element on candidate_element_data (id, version);

create unique index idx4id_ver_of_wechat_workapp_identity on wechat_workapp_identity_data (id, version);
create  index idx4corp_id_of_wechat_workapp_identity on wechat_workapp_identity_data (corp_id);
create  index idx4user_id_of_wechat_workapp_identity on wechat_workapp_identity_data (user_id);
create  index idx4create_time_of_wechat_workapp_identity on wechat_workapp_identity_data (create_time);
create  index idx4last_login_time_of_wechat_workapp_identity on wechat_workapp_identity_data (last_login_time);

create unique index idx4id_ver_of_wechat_miniapp_identity on wechat_miniapp_identity_data (id, version);
create  index idx4open_id_of_wechat_miniapp_identity on wechat_miniapp_identity_data (open_id);
create  index idx4app_id_of_wechat_miniapp_identity on wechat_miniapp_identity_data (app_id);
create  index idx4union_id_of_wechat_miniapp_identity on wechat_miniapp_identity_data (union_id);
create  index idx4create_time_of_wechat_miniapp_identity on wechat_miniapp_identity_data (create_time);
create  index idx4last_login_time_of_wechat_miniapp_identity on wechat_miniapp_identity_data (last_login_time);

create unique index idx4id_ver_of_key_pair_identity on key_pair_identity_data (id, version);
create  index idx4create_time_of_key_pair_identity on key_pair_identity_data (create_time);

create unique index idx4id_ver_of_public_key_type on public_key_type_data (id, version);

create unique index idx4id_ver_of_tree_node on tree_node_data (id, version);
create  index idx4node_id_of_tree_node on tree_node_data (node_id);
create  index idx4left_value_of_tree_node on tree_node_data (left_value);
create  index idx4right_value_of_tree_node on tree_node_data (right_value);






delete from key_pair_identity_data;
delete from list_access_data ;
delete from user_app_data ;
delete from login_history_data ;
delete from sec_user_data ;
delete from user_domain_data ;
delete from wechat_miniapp_identity_data;
delete from wechat_workapp_identity_data;

insert into user_domain_data values ('UD000001','用户区域','1');



insert into sec_user_data values('SU000001','User000001','13900000001','1000001@qq.com','24327F1C00D22210298A18D0DB9AA6C4C22DEAC4BEAE7C02E616442CA7764246', 'weixin_openid_000001', 'weixin_appid_000001', 'jwt_token_000001' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',1);
insert into user_app_data values('UA000001','双链小超中国国运营中心','SU000001','apartment',1,'MXWR','RetailStoreCountryCenter','RSCC000001','RetailStoreCountryCenter','RSCC000001','/link/to/app','1');
insert into user_app_data values('UA000002','我的账户','SU000001','lock',1,'MXWR','SecUser','SU000001','SecUser','SU000001','/link/to/app','1');
insert into user_app_data values('UA000003','用户管理','SU000001','team',1,'MXWR','UserDomain','UD000001', 'UserDomain','UD000001','/link/to/app','1');

/* ------------------------------ generate users for all target od marked as user4all ------------------------------------------ */


-- no change request type found

select mobile as `可用于登录的账号`, 'admin123' as `密码` from sec_user_data;

/*
| 角色        | 用户名           | 密码         |
| ------------- |:-------------:|:-------------------:|


*/



/* start with data patch */
/* The sql file is not found from: /home/philip/resin-3.1.12/webapps/sky/data-patch/retailscm.sql */











