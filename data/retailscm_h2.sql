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
	('RSCC000001','双链小超中国国运营中心','4000-800-0001','2021-01-23','https://www.doublechaintech.com/','四川省成都市天府新区双链大厦0001','双链集团0001','张喜来','中国中心正式成立，恭喜恭喜0001','1');

insert into catalog_data values
	('C000001','水果蔬菜','RSCC000001','10','10.02','1'),
	('C000002','肉禽蛋奶','RSCC000001','10','10.04','1');

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
	('P000001','啤酒','LTC000001','四川','可口可乐，销售百年的糖水，获得了全世界额青睐0001','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0001','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0001/400/200/grey/','2021-08-26 18:55:08','1'),
	('P000002','可乐','LTC000001','广东','可口可乐，销售百年的糖水，获得了全世界额青睐0002','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0002','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0002/400/200/grey/','2021-09-08 15:59:39','1'),
	('P000003','久久鸭','LTC000002','江苏','可口可乐，销售百年的糖水，获得了全世界额青睐0003','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0003','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0003/400/200/grey/','2021-08-28 01:17:33','1'),
	('P000004','啤酒','LTC000002','安徽','可口可乐，销售百年的糖水，获得了全世界额青睐0004','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0004','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0004/400/200/grey/','2021-08-23 15:26:23','1'),
	('P000005','可乐','LTC000003','日本','可口可乐，销售百年的糖水，获得了全世界额青睐0005','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0005','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0005/400/200/grey/','2021-08-21 02:36:40','1'),
	('P000006','久久鸭','LTC000003','法国','可口可乐，销售百年的糖水，获得了全世界额青睐0006','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0006','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0006/400/200/grey/','2021-09-03 06:52:21','1'),
	('P000007','啤酒','LTC000004','四川','可口可乐，销售百年的糖水，获得了全世界额青睐0007','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0007','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0007/400/200/grey/','2021-08-19 15:22:19','1'),
	('P000008','可乐','LTC000004','广东','可口可乐，销售百年的糖水，获得了全世界额青睐0008','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0008','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0008/400/200/grey/','2021-08-19 19:31:10','1'),
	('P000009','久久鸭','LTC000005','江苏','可口可乐，销售百年的糖水，获得了全世界额青睐0009','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0009','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0009/400/200/grey/','2021-08-28 14:36:56','1'),
	('P000010','啤酒','LTC000005','安徽','可口可乐，销售百年的糖水，获得了全世界额青睐0010','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0010','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0010/400/200/grey/','2021-08-28 05:38:36','1'),
	('P000011','可乐','LTC000006','日本','可口可乐，销售百年的糖水，获得了全世界额青睐0011','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0011','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0011/400/200/grey/','2021-08-21 22:14:00','1'),
	('P000012','久久鸭','LTC000006','法国','可口可乐，销售百年的糖水，获得了全世界额青睐0012','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0012','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0012/400/200/grey/','2021-09-01 04:52:43','1'),
	('P000013','啤酒','LTC000007','四川','可口可乐，销售百年的糖水，获得了全世界额青睐0013','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0013','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0013/400/200/grey/','2021-08-21 06:27:23','1'),
	('P000014','可乐','LTC000007','广东','可口可乐，销售百年的糖水，获得了全世界额青睐0014','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0014','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0014/400/200/grey/','2021-09-07 00:00:37','1'),
	('P000015','久久鸭','LTC000008','江苏','可口可乐，销售百年的糖水，获得了全世界额青睐0015','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0015','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0015/400/200/grey/','2021-08-26 22:18:13','1'),
	('P000016','啤酒','LTC000008','安徽','可口可乐，销售百年的糖水，获得了全世界额青睐0016','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0016','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0016/400/200/grey/','2021-08-31 13:10:50','1'),
	('P000017','可乐','LTC000009','日本','可口可乐，销售百年的糖水，获得了全世界额青睐0017','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0017','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0017/400/200/grey/','2021-08-19 23:16:59','1'),
	('P000018','久久鸭','LTC000009','法国','可口可乐，销售百年的糖水，获得了全世界额青睐0018','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0018','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0018/400/200/grey/','2021-09-01 07:41:17','1'),
	('P000019','啤酒','LTC000010','四川','可口可乐，销售百年的糖水，获得了全世界额青睐0019','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0019','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0019/400/200/grey/','2021-09-03 23:35:04','1'),
	('P000020','可乐','LTC000010','广东','可口可乐，销售百年的糖水，获得了全世界额青睐0020','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0020','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0020/400/200/grey/','2021-08-26 06:38:47','1'),
	('P000021','久久鸭','LTC000011','江苏','可口可乐，销售百年的糖水，获得了全世界额青睐0021','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0021','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0021/400/200/grey/','2021-08-22 07:49:54','1'),
	('P000022','啤酒','LTC000011','安徽','可口可乐，销售百年的糖水，获得了全世界额青睐0022','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0022','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0022/400/200/grey/','2021-09-06 16:20:38','1'),
	('P000023','可乐','LTC000012','日本','可口可乐，销售百年的糖水，获得了全世界额青睐0023','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0023','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0023/400/200/grey/','2021-08-19 07:29:36','1'),
	('P000024','久久鸭','LTC000012','法国','可口可乐，销售百年的糖水，获得了全世界额青睐0024','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0024','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0024/400/200/grey/','2021-08-25 01:38:33','1'),
	('P000025','啤酒','LTC000013','四川','可口可乐，销售百年的糖水，获得了全世界额青睐0025','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0025','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0025/400/200/grey/','2021-08-27 06:13:43','1'),
	('P000026','可乐','LTC000013','广东','可口可乐，销售百年的糖水，获得了全世界额青睐0026','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0026','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0026/400/200/grey/','2021-09-08 05:59:20','1'),
	('P000027','久久鸭','LTC000014','江苏','可口可乐，销售百年的糖水，获得了全世界额青睐0027','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0027','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0027/400/200/grey/','2021-09-05 03:26:42','1'),
	('P000028','啤酒','LTC000014','安徽','可口可乐，销售百年的糖水，获得了全世界额青睐0028','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0028','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0028/400/200/grey/','2021-09-03 00:23:46','1'),
	('P000029','可乐','LTC000015','日本','可口可乐，销售百年的糖水，获得了全世界额青睐0029','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0029','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0029/400/200/grey/','2021-09-08 16:01:29','1'),
	('P000030','久久鸭','LTC000015','法国','可口可乐，销售百年的糖水，获得了全世界额青睐0030','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0030','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0030/400/200/grey/','2021-08-24 12:26:15','1'),
	('P000031','啤酒','LTC000016','四川','可口可乐，销售百年的糖水，获得了全世界额青睐0031','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0031','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0031/400/200/grey/','2021-09-06 15:19:50','1'),
	('P000032','可乐','LTC000016','广东','可口可乐，销售百年的糖水，获得了全世界额青睐0032','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0032','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog0032/400/200/grey/','2021-08-19 08:10:47','1');

insert into sku_data values
	('S000001','可乐-大罐的0001','大','P000001','TM000000000010001','包装类型0001','包装数量等信息,包装数量等信息,包装数量等信息0001','1033.24','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0001/400/200/grey/','1'),
	('S000002','可乐-大罐的0002','中','P000001','TM000000000010002','包装类型0002','包装数量等信息,包装数量等信息,包装数量等信息0002','941.43','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0002/400/200/grey/','1'),
	('S000003','可乐-大罐的0003','小','P000002','TM000000000010003','包装类型0003','包装数量等信息,包装数量等信息,包装数量等信息0003','1198.23','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0003/400/200/grey/','1'),
	('S000004','可乐-大罐的0004','大','P000002','TM000000000010004','包装类型0004','包装数量等信息,包装数量等信息,包装数量等信息0004','1013.70','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0004/400/200/grey/','1'),
	('S000005','可乐-大罐的0005','中','P000003','TM000000000010005','包装类型0005','包装数量等信息,包装数量等信息,包装数量等信息0005','1193.74','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0005/400/200/grey/','1'),
	('S000006','可乐-大罐的0006','小','P000003','TM000000000010006','包装类型0006','包装数量等信息,包装数量等信息,包装数量等信息0006','1066.50','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0006/400/200/grey/','1'),
	('S000007','可乐-大罐的0007','大','P000004','TM000000000010007','包装类型0007','包装数量等信息,包装数量等信息,包装数量等信息0007','1252.87','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0007/400/200/grey/','1'),
	('S000008','可乐-大罐的0008','中','P000004','TM000000000010008','包装类型0008','包装数量等信息,包装数量等信息,包装数量等信息0008','1233.52','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0008/400/200/grey/','1'),
	('S000009','可乐-大罐的0009','小','P000005','TM000000000010009','包装类型0009','包装数量等信息,包装数量等信息,包装数量等信息0009','1197.47','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0009/400/200/grey/','1'),
	('S000010','可乐-大罐的0010','大','P000005','TM000000000010010','包装类型0010','包装数量等信息,包装数量等信息,包装数量等信息0010','1217.96','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0010/400/200/grey/','1'),
	('S000011','可乐-大罐的0011','中','P000006','TM000000000010011','包装类型0011','包装数量等信息,包装数量等信息,包装数量等信息0011','1084.49','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0011/400/200/grey/','1'),
	('S000012','可乐-大罐的0012','小','P000006','TM000000000010012','包装类型0012','包装数量等信息,包装数量等信息,包装数量等信息0012','1124.78','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0012/400/200/grey/','1'),
	('S000013','可乐-大罐的0013','大','P000007','TM000000000010013','包装类型0013','包装数量等信息,包装数量等信息,包装数量等信息0013','1074.24','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0013/400/200/grey/','1'),
	('S000014','可乐-大罐的0014','中','P000007','TM000000000010014','包装类型0014','包装数量等信息,包装数量等信息,包装数量等信息0014','942.42','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0014/400/200/grey/','1'),
	('S000015','可乐-大罐的0015','小','P000008','TM000000000010015','包装类型0015','包装数量等信息,包装数量等信息,包装数量等信息0015','1110.16','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0015/400/200/grey/','1'),
	('S000016','可乐-大罐的0016','大','P000008','TM000000000010016','包装类型0016','包装数量等信息,包装数量等信息,包装数量等信息0016','1172.06','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0016/400/200/grey/','1'),
	('S000017','可乐-大罐的0017','中','P000009','TM000000000010017','包装类型0017','包装数量等信息,包装数量等信息,包装数量等信息0017','1185.56','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0017/400/200/grey/','1'),
	('S000018','可乐-大罐的0018','小','P000009','TM000000000010018','包装类型0018','包装数量等信息,包装数量等信息,包装数量等信息0018','1320.95','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0018/400/200/grey/','1'),
	('S000019','可乐-大罐的0019','大','P000010','TM000000000010019','包装类型0019','包装数量等信息,包装数量等信息,包装数量等信息0019','1313.73','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0019/400/200/grey/','1'),
	('S000020','可乐-大罐的0020','中','P000010','TM000000000010020','包装类型0020','包装数量等信息,包装数量等信息,包装数量等信息0020','1248.64','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0020/400/200/grey/','1'),
	('S000021','可乐-大罐的0021','小','P000011','TM000000000010021','包装类型0021','包装数量等信息,包装数量等信息,包装数量等信息0021','1211.85','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0021/400/200/grey/','1'),
	('S000022','可乐-大罐的0022','大','P000011','TM000000000010022','包装类型0022','包装数量等信息,包装数量等信息,包装数量等信息0022','926.91','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0022/400/200/grey/','1'),
	('S000023','可乐-大罐的0023','中','P000012','TM000000000010023','包装类型0023','包装数量等信息,包装数量等信息,包装数量等信息0023','1024.88','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0023/400/200/grey/','1'),
	('S000024','可乐-大罐的0024','小','P000012','TM000000000010024','包装类型0024','包装数量等信息,包装数量等信息,包装数量等信息0024','960.92','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0024/400/200/grey/','1'),
	('S000025','可乐-大罐的0025','大','P000013','TM000000000010025','包装类型0025','包装数量等信息,包装数量等信息,包装数量等信息0025','961.64','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0025/400/200/grey/','1'),
	('S000026','可乐-大罐的0026','中','P000013','TM000000000010026','包装类型0026','包装数量等信息,包装数量等信息,包装数量等信息0026','1275.33','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0026/400/200/grey/','1'),
	('S000027','可乐-大罐的0027','小','P000014','TM000000000010027','包装类型0027','包装数量等信息,包装数量等信息,包装数量等信息0027','992.53','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0027/400/200/grey/','1'),
	('S000028','可乐-大罐的0028','大','P000014','TM000000000010028','包装类型0028','包装数量等信息,包装数量等信息,包装数量等信息0028','1134.14','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0028/400/200/grey/','1'),
	('S000029','可乐-大罐的0029','中','P000015','TM000000000010029','包装类型0029','包装数量等信息,包装数量等信息,包装数量等信息0029','958.00','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0029/400/200/grey/','1'),
	('S000030','可乐-大罐的0030','小','P000015','TM000000000010030','包装类型0030','包装数量等信息,包装数量等信息,包装数量等信息0030','1160.88','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0030/400/200/grey/','1'),
	('S000031','可乐-大罐的0031','大','P000016','TM000000000010031','包装类型0031','包装数量等信息,包装数量等信息,包装数量等信息0031','1048.60','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0031/400/200/grey/','1'),
	('S000032','可乐-大罐的0032','中','P000016','TM000000000010032','包装类型0032','包装数量等信息,包装数量等信息,包装数量等信息0032','1074.81','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0032/400/200/grey/','1'),
	('S000033','可乐-大罐的0033','小','P000017','TM000000000010033','包装类型0033','包装数量等信息,包装数量等信息,包装数量等信息0033','1298.52','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0033/400/200/grey/','1'),
	('S000034','可乐-大罐的0034','大','P000017','TM000000000010034','包装类型0034','包装数量等信息,包装数量等信息,包装数量等信息0034','1181.68','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0034/400/200/grey/','1'),
	('S000035','可乐-大罐的0035','中','P000018','TM000000000010035','包装类型0035','包装数量等信息,包装数量等信息,包装数量等信息0035','1112.38','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0035/400/200/grey/','1'),
	('S000036','可乐-大罐的0036','小','P000018','TM000000000010036','包装类型0036','包装数量等信息,包装数量等信息,包装数量等信息0036','1118.96','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0036/400/200/grey/','1'),
	('S000037','可乐-大罐的0037','大','P000019','TM000000000010037','包装类型0037','包装数量等信息,包装数量等信息,包装数量等信息0037','939.92','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0037/400/200/grey/','1'),
	('S000038','可乐-大罐的0038','中','P000019','TM000000000010038','包装类型0038','包装数量等信息,包装数量等信息,包装数量等信息0038','1291.28','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0038/400/200/grey/','1'),
	('S000039','可乐-大罐的0039','小','P000020','TM000000000010039','包装类型0039','包装数量等信息,包装数量等信息,包装数量等信息0039','1277.91','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0039/400/200/grey/','1'),
	('S000040','可乐-大罐的0040','大','P000020','TM000000000010040','包装类型0040','包装数量等信息,包装数量等信息,包装数量等信息0040','1140.21','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0040/400/200/grey/','1'),
	('S000041','可乐-大罐的0041','中','P000021','TM000000000010041','包装类型0041','包装数量等信息,包装数量等信息,包装数量等信息0041','1166.19','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0041/400/200/grey/','1'),
	('S000042','可乐-大罐的0042','小','P000021','TM000000000010042','包装类型0042','包装数量等信息,包装数量等信息,包装数量等信息0042','1109.56','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0042/400/200/grey/','1'),
	('S000043','可乐-大罐的0043','大','P000022','TM000000000010043','包装类型0043','包装数量等信息,包装数量等信息,包装数量等信息0043','1131.81','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0043/400/200/grey/','1'),
	('S000044','可乐-大罐的0044','中','P000022','TM000000000010044','包装类型0044','包装数量等信息,包装数量等信息,包装数量等信息0044','1036.63','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0044/400/200/grey/','1'),
	('S000045','可乐-大罐的0045','小','P000023','TM000000000010045','包装类型0045','包装数量等信息,包装数量等信息,包装数量等信息0045','1076.65','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0045/400/200/grey/','1'),
	('S000046','可乐-大罐的0046','大','P000023','TM000000000010046','包装类型0046','包装数量等信息,包装数量等信息,包装数量等信息0046','941.52','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0046/400/200/grey/','1'),
	('S000047','可乐-大罐的0047','中','P000024','TM000000000010047','包装类型0047','包装数量等信息,包装数量等信息,包装数量等信息0047','1006.30','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0047/400/200/grey/','1'),
	('S000048','可乐-大罐的0048','小','P000024','TM000000000010048','包装类型0048','包装数量等信息,包装数量等信息,包装数量等信息0048','1173.92','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0048/400/200/grey/','1'),
	('S000049','可乐-大罐的0049','大','P000025','TM000000000010049','包装类型0049','包装数量等信息,包装数量等信息,包装数量等信息0049','1013.46','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0049/400/200/grey/','1'),
	('S000050','可乐-大罐的0050','中','P000025','TM000000000010050','包装类型0050','包装数量等信息,包装数量等信息,包装数量等信息0050','1023.45','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0050/400/200/grey/','1'),
	('S000051','可乐-大罐的0051','小','P000026','TM000000000010051','包装类型0051','包装数量等信息,包装数量等信息,包装数量等信息0051','1037.08','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0051/400/200/grey/','1'),
	('S000052','可乐-大罐的0052','大','P000026','TM000000000010052','包装类型0052','包装数量等信息,包装数量等信息,包装数量等信息0052','1095.62','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0052/400/200/grey/','1'),
	('S000053','可乐-大罐的0053','中','P000027','TM000000000010053','包装类型0053','包装数量等信息,包装数量等信息,包装数量等信息0053','1097.38','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0053/400/200/grey/','1'),
	('S000054','可乐-大罐的0054','小','P000027','TM000000000010054','包装类型0054','包装数量等信息,包装数量等信息,包装数量等信息0054','1085.08','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0054/400/200/grey/','1'),
	('S000055','可乐-大罐的0055','大','P000028','TM000000000010055','包装类型0055','包装数量等信息,包装数量等信息,包装数量等信息0055','1092.70','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0055/400/200/grey/','1'),
	('S000056','可乐-大罐的0056','中','P000028','TM000000000010056','包装类型0056','包装数量等信息,包装数量等信息,包装数量等信息0056','1136.19','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0056/400/200/grey/','1'),
	('S000057','可乐-大罐的0057','小','P000029','TM000000000010057','包装类型0057','包装数量等信息,包装数量等信息,包装数量等信息0057','1265.43','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0057/400/200/grey/','1'),
	('S000058','可乐-大罐的0058','大','P000029','TM000000000010058','包装类型0058','包装数量等信息,包装数量等信息,包装数量等信息0058','1167.42','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0058/400/200/grey/','1'),
	('S000059','可乐-大罐的0059','中','P000030','TM000000000010059','包装类型0059','包装数量等信息,包装数量等信息,包装数量等信息0059','1256.33','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0059/400/200/grey/','1'),
	('S000060','可乐-大罐的0060','小','P000030','TM000000000010060','包装类型0060','包装数量等信息,包装数量等信息,包装数量等信息0060','1261.45','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0060/400/200/grey/','1'),
	('S000061','可乐-大罐的0061','大','P000031','TM000000000010061','包装类型0061','包装数量等信息,包装数量等信息,包装数量等信息0061','973.80','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0061/400/200/grey/','1'),
	('S000062','可乐-大罐的0062','中','P000031','TM000000000010062','包装类型0062','包装数量等信息,包装数量等信息,包装数量等信息0062','942.71','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0062/400/200/grey/','1'),
	('S000063','可乐-大罐的0063','小','P000032','TM000000000010063','包装类型0063','包装数量等信息,包装数量等信息,包装数量等信息0063','1276.52','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0063/400/200/grey/','1'),
	('S000064','可乐-大罐的0064','大','P000032','TM000000000010064','包装类型0064','包装数量等信息,包装数量等信息,包装数量等信息0064','1036.22','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco0064/400/200/grey/','1');

insert into retail_store_province_center_data values
	('RSPC000001','双链小超四川省运营中心','2020-01-27','RSCC000001','2021-08-22 14:37:04','1'),
	('RSPC000002','双链小超北京运营中心','2020-11-01','RSCC000001','2021-08-29 05:02:30','1');

insert into province_center_department_data values
	('PCD000001','供应链部','2021-06-06','RSPC000001','刘强','1'),
	('PCD000002','采购部','2019-08-13','RSPC000001','王德宏','1'),
	('PCD000003','管理部','2020-01-27','RSPC000002','刘强','1'),
	('PCD000004','财务部','2021-07-07','RSPC000002','王德宏','1');

insert into province_center_employee_data values
	('PCE000001','刘强','13999998888','wangdehong@yatang.cn','2019-08-06','PCD000001','RSPC000001','1'),
	('PCE000002','王德宏','13900000002','liuqiang@yatang.cn','2020-10-13','PCD000001','RSPC000001','1'),
	('PCE000003','刘强','13900000003','wangdehong@yatang.cn','2021-04-16','PCD000002','RSPC000001','1'),
	('PCE000004','王德宏','13900000004','liuqiang@yatang.cn','2021-02-14','PCD000002','RSPC000001','1'),
	('PCE000005','刘强','13900000005','wangdehong@yatang.cn','2019-05-02','PCD000003','RSPC000002','1'),
	('PCE000006','王德宏','13900000006','liuqiang@yatang.cn','2019-06-03','PCD000003','RSPC000002','1'),
	('PCE000007','刘强','13900000007','wangdehong@yatang.cn','2021-01-02','PCD000004','RSPC000002','1'),
	('PCE000008','王德宏','13900000008','liuqiang@yatang.cn','2021-02-15','PCD000004','RSPC000002','1');

insert into retail_store_city_service_center_data values
	('RSCSC000001','双链小超成都办事处','2020-09-01','RSPC000001','2021-09-08 22:32:44','1'),
	('RSCSC000002','双链小超绵阳办事处','2021-06-26','RSPC000001','2021-08-28 02:09:38','1'),
	('RSCSC000003','双链小超巴中办事处','2020-10-11','RSPC000002','2021-08-21 14:07:44','1'),
	('RSCSC000004','双链小超成都办事处','2020-12-30','RSPC000002','2021-08-21 12:31:12','1');

insert into city_partner_data values
	('CP000001','曾倩','13677778888','RSCSC000001','负责开拓市场，具有极强的开拓能力0001','2021-09-06 15:54:23','1'),
	('CP000002','黄风格','13900000002','RSCSC000001','负责开拓市场，具有极强的开拓能力0002','2021-08-22 08:07:34','1'),
	('CP000003','郭超','13900000003','RSCSC000002','负责开拓市场，具有极强的开拓能力0003','2021-09-07 23:10:19','1'),
	('CP000004','曾倩','13900000004','RSCSC000002','负责开拓市场，具有极强的开拓能力0004','2021-09-03 00:15:33','1'),
	('CP000005','黄风格','13900000005','RSCSC000003','负责开拓市场，具有极强的开拓能力0005','2021-09-01 01:36:45','1'),
	('CP000006','郭超','13900000006','RSCSC000003','负责开拓市场，具有极强的开拓能力0006','2021-08-30 18:56:10','1'),
	('CP000007','曾倩','13900000007','RSCSC000004','负责开拓市场，具有极强的开拓能力0007','2021-09-03 14:13:37','1'),
	('CP000008','黄风格','13900000008','RSCSC000004','负责开拓市场，具有极强的开拓能力0008','2021-09-01 04:43:22','1');

insert into potential_customer_data values
	('PC000001','曾倩','13677778888','RSCSC000001','CP000001','负责开拓市场，具有极强的开拓能力0001','2021-09-05 11:42:30','1'),
	('PC000002','黄风格','13900000002','RSCSC000001','CP000001','负责开拓市场，具有极强的开拓能力0002','2021-08-28 16:16:11','1'),
	('PC000003','郭超','13900000003','RSCSC000001','CP000002','负责开拓市场，具有极强的开拓能力0003','2021-09-02 22:42:44','1'),
	('PC000004','曾倩','13900000004','RSCSC000001','CP000002','负责开拓市场，具有极强的开拓能力0004','2021-08-24 14:42:14','1'),
	('PC000005','黄风格','13900000005','RSCSC000002','CP000003','负责开拓市场，具有极强的开拓能力0005','2021-08-20 18:58:58','1'),
	('PC000006','郭超','13900000006','RSCSC000002','CP000003','负责开拓市场，具有极强的开拓能力0006','2021-08-29 03:14:38','1'),
	('PC000007','曾倩','13900000007','RSCSC000002','CP000004','负责开拓市场，具有极强的开拓能力0007','2021-08-21 07:03:07','1'),
	('PC000008','黄风格','13900000008','RSCSC000002','CP000004','负责开拓市场，具有极强的开拓能力0008','2021-09-06 23:33:43','1'),
	('PC000009','郭超','13900000009','RSCSC000003','CP000005','负责开拓市场，具有极强的开拓能力0009','2021-09-05 07:31:27','1'),
	('PC000010','曾倩','13900000010','RSCSC000003','CP000005','负责开拓市场，具有极强的开拓能力0010','2021-08-30 23:30:47','1'),
	('PC000011','黄风格','13900000011','RSCSC000003','CP000006','负责开拓市场，具有极强的开拓能力0011','2021-09-07 13:49:14','1'),
	('PC000012','郭超','13900000012','RSCSC000003','CP000006','负责开拓市场，具有极强的开拓能力0012','2021-09-04 15:45:00','1'),
	('PC000013','曾倩','13900000013','RSCSC000004','CP000007','负责开拓市场，具有极强的开拓能力0013','2021-08-24 17:58:34','1'),
	('PC000014','黄风格','13900000014','RSCSC000004','CP000007','负责开拓市场，具有极强的开拓能力0014','2021-08-25 19:18:36','1'),
	('PC000015','郭超','13900000015','RSCSC000004','CP000008','负责开拓市场，具有极强的开拓能力0015','2021-08-23 14:02:41','1'),
	('PC000016','曾倩','13900000016','RSCSC000004','CP000008','负责开拓市场，具有极强的开拓能力0016','2021-08-28 08:17:45','1');

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
	('PCC000001','和连载客户的联系记录0001','2020-12-24','电话','PC000001','CP000001','PCCP000001','转化希望很大0001','2021-09-01 03:53:48','1'),
	('PCC000002','和连载客户的联系记录0002','2021-06-13','短信','PC000001','CP000001','PCCP000001','转化希望很大0002','2021-08-28 13:28:27','1'),
	('PCC000003','和连载客户的联系记录0003','2019-06-18','登门拜访','PC000001','CP000001','PCCP000002','转化希望很大0003','2021-08-21 10:16:48','1'),
	('PCC000004','和连载客户的联系记录0004','2019-07-30','活动聊天','PC000001','CP000001','PCCP000002','转化希望很大0004','2021-09-07 05:31:30','1'),
	('PCC000005','和连载客户的联系记录0005','2020-07-03','电话','PC000002','CP000001','PCCP000003','转化希望很大0005','2021-08-24 16:19:35','1'),
	('PCC000006','和连载客户的联系记录0006','2020-10-12','短信','PC000002','CP000001','PCCP000003','转化希望很大0006','2021-08-28 09:36:49','1'),
	('PCC000007','和连载客户的联系记录0007','2020-01-16','登门拜访','PC000002','CP000001','PCCP000004','转化希望很大0007','2021-08-26 16:36:48','1'),
	('PCC000008','和连载客户的联系记录0008','2019-01-02','活动聊天','PC000002','CP000001','PCCP000004','转化希望很大0008','2021-08-31 14:05:31','1'),
	('PCC000009','和连载客户的联系记录0009','2021-09-05','电话','PC000003','CP000002','PCCP000005','转化希望很大0009','2021-08-24 04:41:04','1'),
	('PCC000010','和连载客户的联系记录0010','2019-07-09','短信','PC000003','CP000002','PCCP000005','转化希望很大0010','2021-09-04 13:30:54','1'),
	('PCC000011','和连载客户的联系记录0011','2018-12-16','登门拜访','PC000003','CP000002','PCCP000006','转化希望很大0011','2021-08-25 19:25:45','1'),
	('PCC000012','和连载客户的联系记录0012','2021-08-08','活动聊天','PC000003','CP000002','PCCP000006','转化希望很大0012','2021-08-28 14:59:03','1'),
	('PCC000013','和连载客户的联系记录0013','2021-03-18','电话','PC000004','CP000002','PCCP000007','转化希望很大0013','2021-09-03 07:17:02','1'),
	('PCC000014','和连载客户的联系记录0014','2019-12-18','短信','PC000004','CP000002','PCCP000007','转化希望很大0014','2021-08-22 21:49:29','1'),
	('PCC000015','和连载客户的联系记录0015','2021-04-07','登门拜访','PC000004','CP000002','PCCP000008','转化希望很大0015','2021-09-08 06:39:52','1'),
	('PCC000016','和连载客户的联系记录0016','2020-05-30','活动聊天','PC000004','CP000002','PCCP000008','转化希望很大0016','2021-09-04 18:22:35','1'),
	('PCC000017','和连载客户的联系记录0017','2019-02-27','电话','PC000005','CP000003','PCCP000009','转化希望很大0017','2021-08-22 19:39:11','1'),
	('PCC000018','和连载客户的联系记录0018','2020-03-11','短信','PC000005','CP000003','PCCP000009','转化希望很大0018','2021-08-29 02:34:04','1'),
	('PCC000019','和连载客户的联系记录0019','2021-09-01','登门拜访','PC000005','CP000003','PCCP000010','转化希望很大0019','2021-08-29 16:56:06','1'),
	('PCC000020','和连载客户的联系记录0020','2019-02-22','活动聊天','PC000005','CP000003','PCCP000010','转化希望很大0020','2021-08-21 16:57:15','1'),
	('PCC000021','和连载客户的联系记录0021','2019-05-31','电话','PC000006','CP000003','PCCP000011','转化希望很大0021','2021-09-08 09:14:40','1'),
	('PCC000022','和连载客户的联系记录0022','2020-10-26','短信','PC000006','CP000003','PCCP000011','转化希望很大0022','2021-09-04 19:39:08','1'),
	('PCC000023','和连载客户的联系记录0023','2019-08-01','登门拜访','PC000006','CP000003','PCCP000012','转化希望很大0023','2021-09-04 01:47:21','1'),
	('PCC000024','和连载客户的联系记录0024','2021-06-06','活动聊天','PC000006','CP000003','PCCP000012','转化希望很大0024','2021-09-04 02:51:34','1'),
	('PCC000025','和连载客户的联系记录0025','2019-07-04','电话','PC000007','CP000004','PCCP000013','转化希望很大0025','2021-09-09 06:27:24','1'),
	('PCC000026','和连载客户的联系记录0026','2019-04-07','短信','PC000007','CP000004','PCCP000013','转化希望很大0026','2021-08-22 16:26:35','1'),
	('PCC000027','和连载客户的联系记录0027','2021-06-03','登门拜访','PC000007','CP000004','PCCP000014','转化希望很大0027','2021-08-21 08:50:44','1'),
	('PCC000028','和连载客户的联系记录0028','2020-12-13','活动聊天','PC000007','CP000004','PCCP000014','转化希望很大0028','2021-09-08 10:36:06','1'),
	('PCC000029','和连载客户的联系记录0029','2020-11-03','电话','PC000008','CP000004','PCCP000015','转化希望很大0029','2021-08-20 22:57:41','1'),
	('PCC000030','和连载客户的联系记录0030','2020-09-23','短信','PC000008','CP000004','PCCP000015','转化希望很大0030','2021-08-30 02:50:25','1'),
	('PCC000031','和连载客户的联系记录0031','2021-01-28','登门拜访','PC000008','CP000004','PCCP000016','转化希望很大0031','2021-08-25 02:06:20','1'),
	('PCC000032','和连载客户的联系记录0032','2020-06-09','活动聊天','PC000008','CP000004','PCCP000016','转化希望很大0032','2021-08-31 03:40:01','1'),
	('PCC000033','和连载客户的联系记录0033','2019-05-21','电话','PC000009','CP000005','PCCP000017','转化希望很大0033','2021-09-02 08:31:25','1'),
	('PCC000034','和连载客户的联系记录0034','2020-09-13','短信','PC000009','CP000005','PCCP000017','转化希望很大0034','2021-08-21 14:30:37','1'),
	('PCC000035','和连载客户的联系记录0035','2019-06-04','登门拜访','PC000009','CP000005','PCCP000018','转化希望很大0035','2021-08-22 19:55:50','1'),
	('PCC000036','和连载客户的联系记录0036','2021-04-29','活动聊天','PC000009','CP000005','PCCP000018','转化希望很大0036','2021-08-27 21:58:37','1'),
	('PCC000037','和连载客户的联系记录0037','2021-05-19','电话','PC000010','CP000005','PCCP000019','转化希望很大0037','2021-08-20 06:30:28','1'),
	('PCC000038','和连载客户的联系记录0038','2019-08-02','短信','PC000010','CP000005','PCCP000019','转化希望很大0038','2021-08-21 13:54:11','1'),
	('PCC000039','和连载客户的联系记录0039','2021-06-03','登门拜访','PC000010','CP000005','PCCP000020','转化希望很大0039','2021-08-21 19:22:30','1'),
	('PCC000040','和连载客户的联系记录0040','2019-07-03','活动聊天','PC000010','CP000005','PCCP000020','转化希望很大0040','2021-08-22 03:31:41','1'),
	('PCC000041','和连载客户的联系记录0041','2021-08-30','电话','PC000011','CP000006','PCCP000021','转化希望很大0041','2021-09-09 10:03:41','1'),
	('PCC000042','和连载客户的联系记录0042','2019-11-30','短信','PC000011','CP000006','PCCP000021','转化希望很大0042','2021-08-24 22:06:04','1'),
	('PCC000043','和连载客户的联系记录0043','2019-02-15','登门拜访','PC000011','CP000006','PCCP000022','转化希望很大0043','2021-09-07 10:09:58','1'),
	('PCC000044','和连载客户的联系记录0044','2019-06-16','活动聊天','PC000011','CP000006','PCCP000022','转化希望很大0044','2021-08-22 22:33:29','1'),
	('PCC000045','和连载客户的联系记录0045','2020-08-10','电话','PC000012','CP000006','PCCP000023','转化希望很大0045','2021-09-08 04:21:46','1'),
	('PCC000046','和连载客户的联系记录0046','2020-03-02','短信','PC000012','CP000006','PCCP000023','转化希望很大0046','2021-09-02 16:20:16','1'),
	('PCC000047','和连载客户的联系记录0047','2020-08-07','登门拜访','PC000012','CP000006','PCCP000024','转化希望很大0047','2021-08-31 17:49:11','1'),
	('PCC000048','和连载客户的联系记录0048','2019-10-10','活动聊天','PC000012','CP000006','PCCP000024','转化希望很大0048','2021-08-30 01:10:43','1'),
	('PCC000049','和连载客户的联系记录0049','2018-10-07','电话','PC000013','CP000007','PCCP000025','转化希望很大0049','2021-09-03 00:31:40','1'),
	('PCC000050','和连载客户的联系记录0050','2020-02-21','短信','PC000013','CP000007','PCCP000025','转化希望很大0050','2021-09-03 15:25:41','1'),
	('PCC000051','和连载客户的联系记录0051','2020-09-02','登门拜访','PC000013','CP000007','PCCP000026','转化希望很大0051','2021-09-08 07:35:04','1'),
	('PCC000052','和连载客户的联系记录0052','2019-10-06','活动聊天','PC000013','CP000007','PCCP000026','转化希望很大0052','2021-08-30 00:24:44','1'),
	('PCC000053','和连载客户的联系记录0053','2018-10-23','电话','PC000014','CP000007','PCCP000027','转化希望很大0053','2021-09-03 00:33:52','1'),
	('PCC000054','和连载客户的联系记录0054','2020-06-11','短信','PC000014','CP000007','PCCP000027','转化希望很大0054','2021-08-21 11:33:03','1'),
	('PCC000055','和连载客户的联系记录0055','2019-12-10','登门拜访','PC000014','CP000007','PCCP000028','转化希望很大0055','2021-08-23 17:54:15','1'),
	('PCC000056','和连载客户的联系记录0056','2019-09-06','活动聊天','PC000014','CP000007','PCCP000028','转化希望很大0056','2021-08-22 09:34:46','1'),
	('PCC000057','和连载客户的联系记录0057','2020-03-23','电话','PC000015','CP000008','PCCP000029','转化希望很大0057','2021-08-25 21:45:56','1'),
	('PCC000058','和连载客户的联系记录0058','2020-07-06','短信','PC000015','CP000008','PCCP000029','转化希望很大0058','2021-09-08 08:37:17','1'),
	('PCC000059','和连载客户的联系记录0059','2019-06-12','登门拜访','PC000015','CP000008','PCCP000030','转化希望很大0059','2021-09-07 19:29:19','1'),
	('PCC000060','和连载客户的联系记录0060','2020-10-23','活动聊天','PC000015','CP000008','PCCP000030','转化希望很大0060','2021-08-23 19:34:17','1'),
	('PCC000061','和连载客户的联系记录0061','2019-12-20','电话','PC000016','CP000008','PCCP000031','转化希望很大0061','2021-09-04 20:19:49','1'),
	('PCC000062','和连载客户的联系记录0062','2020-04-06','短信','PC000016','CP000008','PCCP000031','转化希望很大0062','2021-09-07 04:30:04','1'),
	('PCC000063','和连载客户的联系记录0063','2021-01-09','登门拜访','PC000016','CP000008','PCCP000032','转化希望很大0063','2021-09-06 09:05:01','1'),
	('PCC000064','和连载客户的联系记录0064','2020-05-27','活动聊天','PC000016','CP000008','PCCP000032','转化希望很大0064','2021-08-24 22:33:05','1');

insert into city_event_data values
	('CE000001','小超见面会','13677778888','RSCSC000001','给大家讲解小超的发展蓝图0001','2021-09-04 06:07:05','1'),
	('CE000002','双链小超说明会','13900000002','RSCSC000001','给大家讲解小超的发展蓝图0002','2021-08-19 02:12:22','1'),
	('CE000003','小超见面会','13900000003','RSCSC000002','给大家讲解小超的发展蓝图0003','2021-08-22 16:46:36','1'),
	('CE000004','双链小超说明会','13900000004','RSCSC000002','给大家讲解小超的发展蓝图0004','2021-08-27 00:52:39','1'),
	('CE000005','小超见面会','13900000005','RSCSC000003','给大家讲解小超的发展蓝图0005','2021-08-22 02:50:31','1'),
	('CE000006','双链小超说明会','13900000006','RSCSC000003','给大家讲解小超的发展蓝图0006','2021-08-28 11:13:59','1'),
	('CE000007','小超见面会','13900000007','RSCSC000004','给大家讲解小超的发展蓝图0007','2021-09-05 23:27:03','1'),
	('CE000008','双链小超说明会','13900000008','RSCSC000004','给大家讲解小超的发展蓝图0008','2021-09-03 07:13:32','1');

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
	('RS000001','中和社区小超','028 876543210001','吕刚0001','RSCC000001','RSCSC000001','RSC000001','RSII000001','RSF000001','RSD000001','RSO000001','RSC000001','2021-03-18','42.11007711752147','130.5271184533378','啤酒饮料矿泉水，香肠瓜子方便面, 请让一让0001','2021-08-20 06:27:33','1'),
	('RS000002','华阳社区小超','028 876543210002','吕刚0002','RSCC000001','RSCSC000001','RSC000001','RSII000001','RSF000001','RSD000001','RSO000001','RSC000001','2018-12-04','40.80971748860305','129.67779779504434','啤酒饮料矿泉水，香肠瓜子方便面, 请让一让0002','2021-08-19 18:13:26','1'),
	('RS000003','大源社区小超','028 876543210003','吕刚0003','RSCC000001','RSCSC000002','RSC000001','RSII000001','RSF000001','RSD000001','RSO000001','RSC000001','2019-10-22','42.29954739117784','132.10816408981535','啤酒饮料矿泉水，香肠瓜子方便面, 请让一让0003','2021-09-06 22:31:38','1'),
	('RS000004','中和社区小超','028 876543210004','吕刚0004','RSCC000001','RSCSC000002','RSC000001','RSII000001','RSF000001','RSD000001','RSO000001','RSC000001','2019-02-27','40.90705165524547','130.62604198547692','啤酒饮料矿泉水，香肠瓜子方便面, 请让一让0004','2021-08-23 21:07:47','1'),
	('RS000005','华阳社区小超','028 876543210005','吕刚0005','RSCC000001','RSCSC000003','RSC000001','RSII000001','RSF000001','RSD000001','RSO000001','RSC000001','2020-03-20','42.67714454546017','131.85782352045746','啤酒饮料矿泉水，香肠瓜子方便面, 请让一让0005','2021-09-03 06:28:49','1'),
	('RS000006','大源社区小超','028 876543210006','吕刚0006','RSCC000001','RSCSC000003','RSC000001','RSII000001','RSF000001','RSD000001','RSO000001','RSC000001','2021-04-07','42.42862072366974','132.00302257381344','啤酒饮料矿泉水，香肠瓜子方便面, 请让一让0006','2021-09-03 02:54:06','1'),
	('RS000007','中和社区小超','028 876543210007','吕刚0007','RSCC000001','RSCSC000004','RSC000001','RSII000001','RSF000001','RSD000001','RSO000001','RSC000001','2020-08-18','40.21903747605448','131.0575864788026','啤酒饮料矿泉水，香肠瓜子方便面, 请让一让0007','2021-08-27 17:13:01','1'),
	('RS000008','华阳社区小超','028 876543210008','吕刚0008','RSCC000001','RSCSC000004','RSC000001','RSII000001','RSF000001','RSD000001','RSO000001','RSC000001','2019-02-03','41.752909411173455','129.96540595568172','啤酒饮料矿泉水，香肠瓜子方便面, 请让一让0008','2021-08-26 09:37:37','1');

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
	('CO000001','消费订单0001','RSM000001','RS000001','2021-09-05 02:45:27','1'),
	('CO000002','消费订单0002','RSM000001','RS000001','2021-08-21 17:54:18','1'),
	('CO000003','消费订单0003','RSM000001','RS000002','2021-08-31 04:05:40','1'),
	('CO000004','消费订单0004','RSM000001','RS000002','2021-09-01 15:59:40','1'),
	('CO000005','消费订单0005','RSM000001','RS000003','2021-08-25 14:58:59','1'),
	('CO000006','消费订单0006','RSM000001','RS000003','2021-08-20 20:33:02','1'),
	('CO000007','消费订单0007','RSM000001','RS000004','2021-09-03 07:15:53','1'),
	('CO000008','消费订单0008','RSM000001','RS000004','2021-09-05 17:20:45','1'),
	('CO000009','消费订单0009','RSM000002','RS000005','2021-09-03 09:24:38','1'),
	('CO000010','消费订单0010','RSM000002','RS000005','2021-08-28 13:09:09','1'),
	('CO000011','消费订单0011','RSM000002','RS000006','2021-08-19 19:49:43','1'),
	('CO000012','消费订单0012','RSM000002','RS000006','2021-09-02 10:12:21','1'),
	('CO000013','消费订单0013','RSM000002','RS000007','2021-08-20 09:55:26','1'),
	('CO000014','消费订单0014','RSM000002','RS000007','2021-08-26 19:16:00','1'),
	('CO000015','消费订单0015','RSM000002','RS000008','2021-09-06 05:17:51','1'),
	('CO000016','消费订单0016','RSM000002','RS000008','2021-09-02 08:41:21','1');

insert into consumer_order_line_item_data values
	('COLI000001','CO000001','SKU0001','大瓶可乐0001','5.67','951.45','7519.47','2021-08-27 14:54:47','1'),
	('COLI000002','CO000001','SKU0002','大瓶可乐0002','5.24','822.51','7506.61','2021-08-24 15:28:12','1'),
	('COLI000003','CO000002','SKU0003','大瓶可乐0003','4.28','904.88','7826.05','2021-09-09 04:46:49','1'),
	('COLI000004','CO000002','SKU0004','大瓶可乐0004','4.34','885.05','8082.17','2021-09-01 11:34:08','1'),
	('COLI000005','CO000003','SKU0005','大瓶可乐0005','4.90','764.06','9435.23','2021-09-05 14:02:51','1'),
	('COLI000006','CO000003','SKU0006','大瓶可乐0006','4.18','899.91','8675.93','2021-08-27 05:27:12','1'),
	('COLI000007','CO000004','SKU0007','大瓶可乐0007','4.19','773.66','9085.44','2021-08-19 11:10:53','1'),
	('COLI000008','CO000004','SKU0008','大瓶可乐0008','4.83','958.22','8664.49','2021-09-03 09:04:20','1'),
	('COLI000009','CO000005','SKU0009','大瓶可乐0009','5.93','912.66','9855.06','2021-08-29 16:38:54','1'),
	('COLI000010','CO000005','SKU0010','大瓶可乐0010','4.66','846.62','8449.54','2021-09-06 20:04:05','1'),
	('COLI000011','CO000006','SKU0011','大瓶可乐0011','5.54','799.91','7984.73','2021-09-09 02:50:59','1'),
	('COLI000012','CO000006','SKU0012','大瓶可乐0012','5.17','960.13','9551.93','2021-09-01 14:26:35','1'),
	('COLI000013','CO000007','SKU0013','大瓶可乐0013','5.56','897.97','8619.22','2021-08-21 07:27:22','1'),
	('COLI000014','CO000007','SKU0014','大瓶可乐0014','4.33','933.84','8158.54','2021-09-06 18:13:27','1'),
	('COLI000015','CO000008','SKU0015','大瓶可乐0015','4.47','762.56','9097.64','2021-08-25 14:47:12','1'),
	('COLI000016','CO000008','SKU0016','大瓶可乐0016','5.74','853.18','8875.61','2021-09-08 09:15:55','1'),
	('COLI000017','CO000009','SKU0017','大瓶可乐0017','4.60','809.94','7671.02','2021-08-31 23:16:10','1'),
	('COLI000018','CO000009','SKU0018','大瓶可乐0018','5.83','827.66','9692.70','2021-09-04 14:07:38','1'),
	('COLI000019','CO000010','SKU0019','大瓶可乐0019','5.90','799.36','7776.02','2021-08-22 01:13:40','1'),
	('COLI000020','CO000010','SKU0020','大瓶可乐0020','5.39','937.72','7410.99','2021-09-01 20:22:45','1'),
	('COLI000021','CO000011','SKU0021','大瓶可乐0021','5.37','752.97','8243.86','2021-08-19 06:13:43','1'),
	('COLI000022','CO000011','SKU0022','大瓶可乐0022','4.89','789.43','9039.97','2021-08-23 12:51:18','1'),
	('COLI000023','CO000012','SKU0023','大瓶可乐0023','5.45','960.40','8073.21','2021-08-24 13:02:12','1'),
	('COLI000024','CO000012','SKU0024','大瓶可乐0024','5.63','837.00','9916.28','2021-08-23 17:00:55','1'),
	('COLI000025','CO000013','SKU0025','大瓶可乐0025','5.68','940.24','8645.98','2021-08-29 12:12:54','1'),
	('COLI000026','CO000013','SKU0026','大瓶可乐0026','5.95','957.64','9548.78','2021-09-05 19:56:46','1'),
	('COLI000027','CO000014','SKU0027','大瓶可乐0027','5.03','755.80','7515.07','2021-08-29 21:36:36','1'),
	('COLI000028','CO000014','SKU0028','大瓶可乐0028','4.35','988.66','9443.53','2021-09-02 10:56:30','1'),
	('COLI000029','CO000015','SKU0029','大瓶可乐0029','4.43','807.26','7142.73','2021-09-02 17:09:55','1'),
	('COLI000030','CO000015','SKU0030','大瓶可乐0030','5.38','961.58','8412.89','2021-08-20 13:24:28','1'),
	('COLI000031','CO000016','SKU0031','大瓶可乐0031','5.59','947.57','7218.67','2021-08-19 21:42:04','1'),
	('COLI000032','CO000016','SKU0032','大瓶可乐0032','4.99','792.92','7122.30','2021-09-07 17:37:43','1');

insert into consumer_order_shipping_group_data values
	('COSG000001','送货到刘强家0001','CO000001','548.28','1'),
	('COSG000002','送货到刘强家0002','CO000001','536.66','1'),
	('COSG000003','送货到刘强家0003','CO000002','506.19','1'),
	('COSG000004','送货到刘强家0004','CO000002','522.34','1'),
	('COSG000005','送货到刘强家0005','CO000003','586.13','1'),
	('COSG000006','送货到刘强家0006','CO000003','549.93','1'),
	('COSG000007','送货到刘强家0007','CO000004','532.73','1'),
	('COSG000008','送货到刘强家0008','CO000004','420.41','1'),
	('COSG000009','送货到刘强家0009','CO000005','484.17','1'),
	('COSG000010','送货到刘强家0010','CO000005','501.30','1'),
	('COSG000011','送货到刘强家0011','CO000006','591.51','1'),
	('COSG000012','送货到刘强家0012','CO000006','428.69','1'),
	('COSG000013','送货到刘强家0013','CO000007','451.10','1'),
	('COSG000014','送货到刘强家0014','CO000007','460.42','1'),
	('COSG000015','送货到刘强家0015','CO000008','534.96','1'),
	('COSG000016','送货到刘强家0016','CO000008','553.46','1'),
	('COSG000017','送货到刘强家0017','CO000009','441.39','1'),
	('COSG000018','送货到刘强家0018','CO000009','449.41','1'),
	('COSG000019','送货到刘强家0019','CO000010','494.70','1'),
	('COSG000020','送货到刘强家0020','CO000010','442.90','1'),
	('COSG000021','送货到刘强家0021','CO000011','532.16','1'),
	('COSG000022','送货到刘强家0022','CO000011','570.48','1'),
	('COSG000023','送货到刘强家0023','CO000012','520.60','1'),
	('COSG000024','送货到刘强家0024','CO000012','437.05','1'),
	('COSG000025','送货到刘强家0025','CO000013','428.75','1'),
	('COSG000026','送货到刘强家0026','CO000013','472.43','1'),
	('COSG000027','送货到刘强家0027','CO000014','598.85','1'),
	('COSG000028','送货到刘强家0028','CO000014','504.85','1'),
	('COSG000029','送货到刘强家0029','CO000015','568.94','1'),
	('COSG000030','送货到刘强家0030','CO000015','455.07','1'),
	('COSG000031','送货到刘强家0031','CO000016','591.07','1'),
	('COSG000032','送货到刘强家0032','CO000016','555.88','1');

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
	('COPA000001','端午促销0001','CO000001','420.07','供货商','1'),
	('COPA000002','端午促销0002','CO000001','477.47','小超老板','1'),
	('COPA000003','端午促销0003','CO000002','508.53','广告赞助','1'),
	('COPA000004','端午促销0004','CO000002','466.95','供货商','1'),
	('COPA000005','端午促销0005','CO000003','478.86','小超老板','1'),
	('COPA000006','端午促销0006','CO000003','548.38','广告赞助','1'),
	('COPA000007','端午促销0007','CO000004','490.31','供货商','1'),
	('COPA000008','端午促销0008','CO000004','592.62','小超老板','1'),
	('COPA000009','端午促销0009','CO000005','531.76','广告赞助','1'),
	('COPA000010','端午促销0010','CO000005','517.86','供货商','1'),
	('COPA000011','端午促销0011','CO000006','489.91','小超老板','1'),
	('COPA000012','端午促销0012','CO000006','574.89','广告赞助','1'),
	('COPA000013','端午促销0013','CO000007','472.89','供货商','1'),
	('COPA000014','端午促销0014','CO000007','575.73','小超老板','1'),
	('COPA000015','端午促销0015','CO000008','553.14','广告赞助','1'),
	('COPA000016','端午促销0016','CO000008','509.85','供货商','1'),
	('COPA000017','端午促销0017','CO000009','468.45','小超老板','1'),
	('COPA000018','端午促销0018','CO000009','496.42','广告赞助','1'),
	('COPA000019','端午促销0019','CO000010','449.93','供货商','1'),
	('COPA000020','端午促销0020','CO000010','569.42','小超老板','1'),
	('COPA000021','端午促销0021','CO000011','499.54','广告赞助','1'),
	('COPA000022','端午促销0022','CO000011','430.38','供货商','1'),
	('COPA000023','端午促销0023','CO000012','584.51','小超老板','1'),
	('COPA000024','端午促销0024','CO000012','552.12','广告赞助','1'),
	('COPA000025','端午促销0025','CO000013','550.70','供货商','1'),
	('COPA000026','端午促销0026','CO000013','469.91','小超老板','1'),
	('COPA000027','端午促销0027','CO000014','511.99','广告赞助','1'),
	('COPA000028','端午促销0028','CO000014','471.16','供货商','1'),
	('COPA000029','端午促销0029','CO000015','498.53','小超老板','1'),
	('COPA000030','端午促销0030','CO000015','471.42','广告赞助','1'),
	('COPA000031','端午促销0031','CO000016','434.96','供货商','1'),
	('COPA000032','端午促销0032','CO000016','597.77','小超老板','1');

insert into retail_store_member_coupon_data values
	('RSMC000001','优惠券0001','RSM000001','CP000010001','2021-09-02 23:39:18','1'),
	('RSMC000002','优惠券0002','RSM000001','CP000010002','2021-08-21 07:21:53','1'),
	('RSMC000003','优惠券0003','RSM000002','CP000010003','2021-08-25 18:46:05','1'),
	('RSMC000004','优惠券0004','RSM000002','CP000010004','2021-09-01 13:12:32','1');

insert into member_wishlist_data values
	('MW000001','每周购买清单','RSM000001','1'),
	('MW000002','每月购买清单','RSM000001','1'),
	('MW000003','每周购买清单','RSM000002','1'),
	('MW000004','每月购买清单','RSM000002','1');

insert into member_reward_point_data values
	('MRP000001','购买积分','19','RSM000001','1'),
	('MRP000002','每月购买清单','18','RSM000001','1'),
	('MRP000003','购买积分','20','RSM000002','1'),
	('MRP000004','每月购买清单','17','RSM000002','1');

insert into member_reward_point_redemption_data values
	('MRPR000001','积分换锅','19','RSM000001','1'),
	('MRPR000002','积分换刀','16','RSM000001','1'),
	('MRPR000003','积分换锅','15','RSM000002','1'),
	('MRPR000004','积分换刀','17','RSM000002','1');

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
	('RSMGC000001','礼品卡0001','RSM000001','CP000010001','208.67','1'),
	('RSMGC000002','礼品卡0002','RSM000001','CP000010002','182.96','1'),
	('RSMGC000003','礼品卡0003','RSM000002','CP000010003','187.43','1'),
	('RSMGC000004','礼品卡0004','RSM000002','CP000010004','189.85','1');

insert into retail_store_member_gift_card_consume_record_data values
	('RSMGCCR000001','2019-10-22','RSMGC000001','CO000001','GF000010001','15.28','1'),
	('RSMGCCR000002','2019-08-25','RSMGC000001','CO000001','GF000010002','18.22','1'),
	('RSMGCCR000003','2021-09-01','RSMGC000001','CO000002','GF000010003','18.05','1'),
	('RSMGCCR000004','2019-03-17','RSMGC000001','CO000002','GF000010004','17.72','1'),
	('RSMGCCR000005','2020-05-02','RSMGC000001','CO000003','GF000010005','18.06','1'),
	('RSMGCCR000006','2020-03-07','RSMGC000001','CO000003','GF000010006','17.16','1'),
	('RSMGCCR000007','2019-10-04','RSMGC000001','CO000004','GF000010007','15.25','1'),
	('RSMGCCR000008','2020-06-03','RSMGC000001','CO000004','GF000010008','17.84','1'),
	('RSMGCCR000009','2019-08-23','RSMGC000002','CO000005','GF000010009','18.89','1'),
	('RSMGCCR000010','2021-03-30','RSMGC000002','CO000005','GF000010010','19.09','1'),
	('RSMGCCR000011','2020-04-22','RSMGC000002','CO000006','GF000010011','19.61','1'),
	('RSMGCCR000012','2020-09-22','RSMGC000002','CO000006','GF000010012','20.65','1'),
	('RSMGCCR000013','2020-02-21','RSMGC000002','CO000007','GF000010013','16.68','1'),
	('RSMGCCR000014','2019-03-02','RSMGC000002','CO000007','GF000010014','18.32','1'),
	('RSMGCCR000015','2020-08-10','RSMGC000002','CO000008','GF000010015','19.84','1'),
	('RSMGCCR000016','2019-08-05','RSMGC000002','CO000008','GF000010016','19.32','1'),
	('RSMGCCR000017','2018-09-12','RSMGC000003','CO000009','GF000010017','16.27','1'),
	('RSMGCCR000018','2019-01-22','RSMGC000003','CO000009','GF000010018','17.74','1'),
	('RSMGCCR000019','2019-01-23','RSMGC000003','CO000010','GF000010019','19.31','1'),
	('RSMGCCR000020','2019-03-31','RSMGC000003','CO000010','GF000010020','17.02','1'),
	('RSMGCCR000021','2019-03-08','RSMGC000003','CO000011','GF000010021','16.25','1'),
	('RSMGCCR000022','2020-09-13','RSMGC000003','CO000011','GF000010022','19.98','1'),
	('RSMGCCR000023','2019-02-12','RSMGC000003','CO000012','GF000010023','17.69','1'),
	('RSMGCCR000024','2019-10-06','RSMGC000003','CO000012','GF000010024','16.98','1'),
	('RSMGCCR000025','2020-04-17','RSMGC000004','CO000013','GF000010025','19.02','1'),
	('RSMGCCR000026','2020-11-20','RSMGC000004','CO000013','GF000010026','19.70','1'),
	('RSMGCCR000027','2020-03-23','RSMGC000004','CO000014','GF000010027','19.88','1'),
	('RSMGCCR000028','2018-11-25','RSMGC000004','CO000014','GF000010028','16.41','1'),
	('RSMGCCR000029','2019-08-06','RSMGC000004','CO000015','GF000010029','20.82','1'),
	('RSMGCCR000030','2020-02-22','RSMGC000004','CO000015','GF000010030','19.44','1'),
	('RSMGCCR000031','2020-08-26','RSMGC000004','CO000016','GF000010031','19.86','1'),
	('RSMGCCR000032','2021-05-05','RSMGC000004','CO000016','GF000010032','16.27','1');

insert into goods_supplier_data values
	('GS000001','宝洁','洗护用品','RSCC000001','18677889999','啤酒饮料矿泉水，香肠瓜子方便面都提供0001','2021-09-07 18:41:14','1'),
	('GS000002','中粮','食品','RSCC000001','13900000002','啤酒饮料矿泉水，香肠瓜子方便面都提供0002','2021-08-21 21:52:34','1');

insert into supplier_product_data values
	('SP000001','黑人牙膏0001','最好的黑人牙膏，只卖3块喽0001','件','GS000001','1'),
	('SP000002','黑人牙膏0002','最好的黑人牙膏，只卖3块喽0002','公斤','GS000001','1'),
	('SP000003','黑人牙膏0003','最好的黑人牙膏，只卖3块喽0003','米','GS000002','1'),
	('SP000004','黑人牙膏0004','最好的黑人牙膏，只卖3块喽0004','件','GS000002','1');

insert into product_supply_duration_data values
	('PSD000001','100','现货','9306.54','SP000001','1'),
	('PSD000002','200','两天','9560.98','SP000001','1'),
	('PSD000003','500','三天','7041.75','SP000002','1'),
	('PSD000004','100','一周','9108.19','SP000002','1'),
	('PSD000005','200','现货','7798.88','SP000003','1'),
	('PSD000006','500','两天','9151.71','SP000003','1'),
	('PSD000007','100','三天','9362.25','SP000004','1'),
	('PSD000008','200','一周','8398.97','SP000004','1');

insert into supply_order_data values
	('SO000001','RSCC000001','GS000001','双链给供货商下的订单0001','2621585408.00','2021-08-30 18:44:52','1'),
	('SO000002','RSCC000001','GS000001','双链给供货商下的订单0002','2493862400.00','2021-08-30 03:51:03','1'),
	('SO000003','RSCC000001','GS000002','双链给供货商下的订单0003','2953979648.00','2021-08-27 20:35:55','1'),
	('SO000004','RSCC000001','GS000002','双链给供货商下的订单0004','2735787776.00','2021-08-24 14:14:11','1');

insert into supply_order_line_item_data values
	('SOLI000001','SO000001','SKU0001','大瓶可乐0001','5.14','7960','件','1'),
	('SOLI000002','SO000001','SKU0002','大瓶可乐0002','4.25','7367','公斤','1'),
	('SOLI000003','SO000002','SKU0003','大瓶可乐0003','5.46','7304','米','1'),
	('SOLI000004','SO000002','SKU0004','大瓶可乐0004','4.19','7858','件','1'),
	('SOLI000005','SO000003','SKU0005','大瓶可乐0005','5.34','7624','公斤','1'),
	('SOLI000006','SO000003','SKU0006','大瓶可乐0006','4.70','7469','米','1'),
	('SOLI000007','SO000004','SKU0007','大瓶可乐0007','5.26','8026','件','1'),
	('SOLI000008','SO000004','SKU0008','大瓶可乐0008','4.82','7695','公斤','1');

insert into supply_order_shipping_group_data values
	('SOSG000001','送货到双链成都2号仓0001','SO000001','5.58','1'),
	('SOSG000002','送货到双链成都2号仓0002','SO000001','5.62','1'),
	('SOSG000003','送货到双链成都2号仓0003','SO000002','4.67','1'),
	('SOSG000004','送货到双链成都2号仓0004','SO000002','5.82','1'),
	('SOSG000005','送货到双链成都2号仓0005','SO000003','5.71','1'),
	('SOSG000006','送货到双链成都2号仓0006','SO000003','5.56','1'),
	('SOSG000007','送货到双链成都2号仓0007','SO000004','5.25','1'),
	('SOSG000008','送货到双链成都2号仓0008','SO000004','4.75','1');

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
	('RSO000001','RS000001','RSCC000001','双链小超给双链供应链下的订单0001','2605183488.00','2021-09-03 07:16:10','1'),
	('RSO000002','RS000001','RSCC000001','双链小超给双链供应链下的订单0002','2427067648.00','2021-08-23 05:57:22','1'),
	('RSO000003','RS000002','RSCC000001','双链小超给双链供应链下的订单0003','2695141632.00','2021-08-31 11:13:50','1'),
	('RSO000004','RS000002','RSCC000001','双链小超给双链供应链下的订单0004','2526173952.00','2021-09-04 06:20:46','1'),
	('RSO000005','RS000003','RSCC000001','双链小超给双链供应链下的订单0005','2364147712.00','2021-09-04 01:17:24','1'),
	('RSO000006','RS000003','RSCC000001','双链小超给双链供应链下的订单0006','2267928832.00','2021-08-28 23:55:00','1'),
	('RSO000007','RS000004','RSCC000001','双链小超给双链供应链下的订单0007','2876006400.00','2021-08-21 19:04:15','1'),
	('RSO000008','RS000004','RSCC000001','双链小超给双链供应链下的订单0008','2932442112.00','2021-08-30 11:02:43','1'),
	('RSO000009','RS000005','RSCC000001','双链小超给双链供应链下的订单0009','2622226176.00','2021-09-02 17:47:13','1'),
	('RSO000010','RS000005','RSCC000001','双链小超给双链供应链下的订单0010','2406872576.00','2021-08-20 01:38:18','1'),
	('RSO000011','RS000006','RSCC000001','双链小超给双链供应链下的订单0011','2662462720.00','2021-08-26 12:44:28','1'),
	('RSO000012','RS000006','RSCC000001','双链小超给双链供应链下的订单0012','2759739904.00','2021-09-01 11:11:04','1'),
	('RSO000013','RS000007','RSCC000001','双链小超给双链供应链下的订单0013','2788828928.00','2021-08-21 13:42:15','1'),
	('RSO000014','RS000007','RSCC000001','双链小超给双链供应链下的订单0014','2636364032.00','2021-08-22 16:38:02','1'),
	('RSO000015','RS000008','RSCC000001','双链小超给双链供应链下的订单0015','2679173120.00','2021-09-08 08:44:24','1'),
	('RSO000016','RS000008','RSCC000001','双链小超给双链供应链下的订单0016','2742235136.00','2021-08-20 21:52:26','1');

insert into retail_store_order_line_item_data values
	('RSOLI000001','RSO000001','SKU0001','大瓶可乐0001','3.44','9788','件','1'),
	('RSOLI000002','RSO000001','SKU0002','大瓶可乐0002','3.56','7306','公斤','1'),
	('RSOLI000003','RSO000002','SKU0003','大瓶可乐0003','3.45','8435','米','1'),
	('RSOLI000004','RSO000002','SKU0004','大瓶可乐0004','3.80','9907','件','1'),
	('RSOLI000005','RSO000003','SKU0005','大瓶可乐0005','2.97','9390','公斤','1'),
	('RSOLI000006','RSO000003','SKU0006','大瓶可乐0006','3.41','7690','米','1'),
	('RSOLI000007','RSO000004','SKU0007','大瓶可乐0007','3.19','8511','件','1'),
	('RSOLI000008','RSO000004','SKU0008','大瓶可乐0008','3.75','7599','公斤','1'),
	('RSOLI000009','RSO000005','SKU0009','大瓶可乐0009','2.81','7235','米','1'),
	('RSOLI000010','RSO000005','SKU0010','大瓶可乐0010','3.00','8228','件','1'),
	('RSOLI000011','RSO000006','SKU0011','大瓶可乐0011','2.84','9068','公斤','1'),
	('RSOLI000012','RSO000006','SKU0012','大瓶可乐0012','3.87','9607','米','1'),
	('RSOLI000013','RSO000007','SKU0013','大瓶可乐0013','3.84','8051','件','1'),
	('RSOLI000014','RSO000007','SKU0014','大瓶可乐0014','2.85','7825','公斤','1'),
	('RSOLI000015','RSO000008','SKU0015','大瓶可乐0015','2.88','8824','米','1'),
	('RSOLI000016','RSO000008','SKU0016','大瓶可乐0016','3.27','7101','件','1'),
	('RSOLI000017','RSO000009','SKU0017','大瓶可乐0017','3.73','8307','公斤','1'),
	('RSOLI000018','RSO000009','SKU0018','大瓶可乐0018','3.43','7285','米','1'),
	('RSOLI000019','RSO000010','SKU0019','大瓶可乐0019','3.93','8672','件','1'),
	('RSOLI000020','RSO000010','SKU0020','大瓶可乐0020','3.63','7984','公斤','1'),
	('RSOLI000021','RSO000011','SKU0021','大瓶可乐0021','3.01','7246','米','1'),
	('RSOLI000022','RSO000011','SKU0022','大瓶可乐0022','3.39','8481','件','1'),
	('RSOLI000023','RSO000012','SKU0023','大瓶可乐0023','3.01','7233','公斤','1'),
	('RSOLI000024','RSO000012','SKU0024','大瓶可乐0024','3.84','9344','米','1'),
	('RSOLI000025','RSO000013','SKU0025','大瓶可乐0025','3.30','8621','件','1'),
	('RSOLI000026','RSO000013','SKU0026','大瓶可乐0026','3.46','8165','公斤','1'),
	('RSOLI000027','RSO000014','SKU0027','大瓶可乐0027','3.51','7485','米','1'),
	('RSOLI000028','RSO000014','SKU0028','大瓶可乐0028','3.45','9203','件','1'),
	('RSOLI000029','RSO000015','SKU0029','大瓶可乐0029','2.94','7940','公斤','1'),
	('RSOLI000030','RSO000015','SKU0030','大瓶可乐0030','3.42','8755','米','1'),
	('RSOLI000031','RSO000016','SKU0031','大瓶可乐0031','3.45','9374','件','1'),
	('RSOLI000032','RSO000016','SKU0032','大瓶可乐0032','2.81','9005','公斤','1');

insert into retail_store_order_shipping_group_data values
	('RSOSG000001','送货到双链中和社区店0001','RSO000001','4.61','1'),
	('RSOSG000002','送货到双链中和社区店0002','RSO000001','4.34','1'),
	('RSOSG000003','送货到双链中和社区店0003','RSO000002','4.88','1'),
	('RSOSG000004','送货到双链中和社区店0004','RSO000002','4.62','1'),
	('RSOSG000005','送货到双链中和社区店0005','RSO000003','5.27','1'),
	('RSOSG000006','送货到双链中和社区店0006','RSO000003','4.54','1'),
	('RSOSG000007','送货到双链中和社区店0007','RSO000004','4.57','1'),
	('RSOSG000008','送货到双链中和社区店0008','RSO000004','5.14','1'),
	('RSOSG000009','送货到双链中和社区店0009','RSO000005','5.75','1'),
	('RSOSG000010','送货到双链中和社区店0010','RSO000005','5.20','1'),
	('RSOSG000011','送货到双链中和社区店0011','RSO000006','5.22','1'),
	('RSOSG000012','送货到双链中和社区店0012','RSO000006','4.40','1'),
	('RSOSG000013','送货到双链中和社区店0013','RSO000007','5.15','1'),
	('RSOSG000014','送货到双链中和社区店0014','RSO000007','5.88','1'),
	('RSOSG000015','送货到双链中和社区店0015','RSO000008','5.79','1'),
	('RSOSG000016','送货到双链中和社区店0016','RSO000008','5.75','1'),
	('RSOSG000017','送货到双链中和社区店0017','RSO000009','4.42','1'),
	('RSOSG000018','送货到双链中和社区店0018','RSO000009','5.71','1'),
	('RSOSG000019','送货到双链中和社区店0019','RSO000010','5.30','1'),
	('RSOSG000020','送货到双链中和社区店0020','RSO000010','4.89','1'),
	('RSOSG000021','送货到双链中和社区店0021','RSO000011','4.46','1'),
	('RSOSG000022','送货到双链中和社区店0022','RSO000011','5.64','1'),
	('RSOSG000023','送货到双链中和社区店0023','RSO000012','4.46','1'),
	('RSOSG000024','送货到双链中和社区店0024','RSO000012','5.73','1'),
	('RSOSG000025','送货到双链中和社区店0025','RSO000013','5.25','1'),
	('RSOSG000026','送货到双链中和社区店0026','RSO000013','4.91','1'),
	('RSOSG000027','送货到双链中和社区店0027','RSO000014','4.58','1'),
	('RSOSG000028','送货到双链中和社区店0028','RSO000014','4.82','1'),
	('RSOSG000029','送货到双链中和社区店0029','RSO000015','5.75','1'),
	('RSOSG000030','送货到双链中和社区店0030','RSO000015','5.93','1'),
	('RSOSG000031','送货到双链中和社区店0031','RSO000016','4.29','1'),
	('RSOSG000032','送货到双链中和社区店0032','RSO000016','4.31','1');

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
	('W000001','成都龙泉驿飞鹤路20号0001','028 876543210001','187672平方米0001','RSCC000001','42.708251641039645','129.73736629311279','2021-09-02 22:40:31','1'),
	('W000002','成都龙泉驿飞鹤路20号0002','028 876543210002','187672平方米0002','RSCC000001','41.80980301056522','131.8608414459189','2021-09-09 06:23:37','1');

insert into storage_space_data values
	('SS000001','成都龙泉驿飞鹤路20号存货区0001','028 876543210001','1876平方米0001','W000001','42.63558059187822','130.89715317013344','2021-08-25 14:11:25','1'),
	('SS000002','成都龙泉驿飞鹤路20号存货区0002','028 876543210002','1876平方米0002','W000001','42.1680580386044','129.42580980513418','2021-08-26 02:02:54','1'),
	('SS000003','成都龙泉驿飞鹤路20号存货区0003','028 876543210003','1876平方米0003','W000002','41.77370325192755','129.8703492986095','2021-08-28 22:19:20','1'),
	('SS000004','成都龙泉驿飞鹤路20号存货区0004','028 876543210004','1876平方米0004','W000002','42.60061384795233','131.83955262292716','2021-09-06 23:04:14','1');

insert into smart_pallet_data values
	('SP000001','成都龙泉驿飞鹤路20号移动区域，比如过道，货运通道等0001','028 876543210001','1876平方米0001','40.26149059540695','130.63085976590577','W000001','2021-08-28 23:08:15','1'),
	('SP000002','成都龙泉驿飞鹤路20号移动区域，比如过道，货运通道等0002','028 876543210002','1876平方米0002','42.34657884909054','130.4407445728295','W000001','2021-09-03 10:42:48','1'),
	('SP000003','成都龙泉驿飞鹤路20号移动区域，比如过道，货运通道等0003','028 876543210003','1876平方米0003','41.11577694710499','131.1584649799691','W000002','2021-08-23 00:30:44','1'),
	('SP000004','成都龙泉驿飞鹤路20号移动区域，比如过道，货运通道等0004','028 876543210004','1876平方米0004','42.55206454162472','131.35057785974186','W000002','2021-08-21 02:57:37','1');

insert into goods_shelf_data values
	('GS000001','成都龙泉驿飞鹤路20号存货区货架0001','SS000001','SS000001','DS000001','2021-08-18 20:53:08','1'),
	('GS000002','成都龙泉驿飞鹤路20号存货区货架0002','SS000001','SS000001','DS000001','2021-08-23 21:33:28','1'),
	('GS000003','成都龙泉驿飞鹤路20号存货区货架0003','SS000002','SS000002','DS000002','2021-08-23 21:37:31','1'),
	('GS000004','成都龙泉驿飞鹤路20号存货区货架0004','SS000002','SS000002','DS000002','2021-08-26 00:21:15','1'),
	('GS000005','成都龙泉驿飞鹤路20号存货区货架0005','SS000003','SS000003','DS000003','2021-08-26 05:39:07','1'),
	('GS000006','成都龙泉驿飞鹤路20号存货区货架0006','SS000003','SS000003','DS000003','2021-08-24 03:43:19','1'),
	('GS000007','成都龙泉驿飞鹤路20号存货区货架0007','SS000004','SS000004','DS000004','2021-08-27 21:43:04','1'),
	('GS000008','成都龙泉驿飞鹤路20号存货区货架0008','SS000004','SS000004','DS000004','2021-08-22 17:14:03','1');

insert into goods_shelf_stock_count_data values
	('GSSC000001','每日盘点','2020-03-11','使用先进的rfid技术，没有任何错误0001','GS000001','1'),
	('GSSC000002','每周盘点','2020-10-04','使用先进的rfid技术，没有任何错误0002','GS000001','1'),
	('GSSC000003','每月盘点','2019-08-31','使用先进的rfid技术，没有任何错误0003','GS000002','1'),
	('GSSC000004','年终盘点','2020-06-23','使用先进的rfid技术，没有任何错误0004','GS000002','1'),
	('GSSC000005','每日盘点','2020-09-21','使用先进的rfid技术，没有任何错误0005','GS000003','1'),
	('GSSC000006','每周盘点','2020-06-15','使用先进的rfid技术，没有任何错误0006','GS000003','1'),
	('GSSC000007','每月盘点','2018-10-03','使用先进的rfid技术，没有任何错误0007','GS000004','1'),
	('GSSC000008','年终盘点','2020-03-18','使用先进的rfid技术，没有任何错误0008','GS000004','1'),
	('GSSC000009','每日盘点','2019-07-09','使用先进的rfid技术，没有任何错误0009','GS000005','1'),
	('GSSC000010','每周盘点','2020-12-20','使用先进的rfid技术，没有任何错误0010','GS000005','1'),
	('GSSC000011','每月盘点','2019-01-06','使用先进的rfid技术，没有任何错误0011','GS000006','1'),
	('GSSC000012','年终盘点','2021-06-05','使用先进的rfid技术，没有任何错误0012','GS000006','1'),
	('GSSC000013','每日盘点','2018-10-30','使用先进的rfid技术，没有任何错误0013','GS000007','1'),
	('GSSC000014','每周盘点','2020-11-03','使用先进的rfid技术，没有任何错误0014','GS000007','1'),
	('GSSC000015','每月盘点','2020-07-06','使用先进的rfid技术，没有任何错误0015','GS000008','1'),
	('GSSC000016','年终盘点','2018-10-30','使用先进的rfid技术，没有任何错误0016','GS000008','1');

insert into stock_count_issue_track_data values
	('SCIT000001','盘点差错0001','2019-06-21','发现错误已经修正完成0001','GSSC000001','1'),
	('SCIT000002','盘点差错0002','2021-02-21','发现错误已经修正完成0002','GSSC000001','1'),
	('SCIT000003','盘点差错0003','2020-09-12','发现错误已经修正完成0003','GSSC000002','1'),
	('SCIT000004','盘点差错0004','2020-05-19','发现错误已经修正完成0004','GSSC000002','1'),
	('SCIT000005','盘点差错0005','2020-02-12','发现错误已经修正完成0005','GSSC000003','1'),
	('SCIT000006','盘点差错0006','2020-02-20','发现错误已经修正完成0006','GSSC000003','1'),
	('SCIT000007','盘点差错0007','2019-10-16','发现错误已经修正完成0007','GSSC000004','1'),
	('SCIT000008','盘点差错0008','2019-03-07','发现错误已经修正完成0008','GSSC000004','1'),
	('SCIT000009','盘点差错0009','2019-01-07','发现错误已经修正完成0009','GSSC000005','1'),
	('SCIT000010','盘点差错0010','2020-12-28','发现错误已经修正完成0010','GSSC000005','1'),
	('SCIT000011','盘点差错0011','2020-03-27','发现错误已经修正完成0011','GSSC000006','1'),
	('SCIT000012','盘点差错0012','2020-07-06','发现错误已经修正完成0012','GSSC000006','1'),
	('SCIT000013','盘点差错0013','2021-03-20','发现错误已经修正完成0013','GSSC000007','1'),
	('SCIT000014','盘点差错0014','2020-01-14','发现错误已经修正完成0014','GSSC000007','1'),
	('SCIT000015','盘点差错0015','2020-09-29','发现错误已经修正完成0015','GSSC000008','1'),
	('SCIT000016','盘点差错0016','2020-07-06','发现错误已经修正完成0016','GSSC000008','1'),
	('SCIT000017','盘点差错0017','2021-03-20','发现错误已经修正完成0017','GSSC000009','1'),
	('SCIT000018','盘点差错0018','2018-10-28','发现错误已经修正完成0018','GSSC000009','1'),
	('SCIT000019','盘点差错0019','2020-01-12','发现错误已经修正完成0019','GSSC000010','1'),
	('SCIT000020','盘点差错0020','2019-08-30','发现错误已经修正完成0020','GSSC000010','1'),
	('SCIT000021','盘点差错0021','2021-03-28','发现错误已经修正完成0021','GSSC000011','1'),
	('SCIT000022','盘点差错0022','2021-04-30','发现错误已经修正完成0022','GSSC000011','1'),
	('SCIT000023','盘点差错0023','2020-03-09','发现错误已经修正完成0023','GSSC000012','1'),
	('SCIT000024','盘点差错0024','2020-03-31','发现错误已经修正完成0024','GSSC000012','1'),
	('SCIT000025','盘点差错0025','2020-03-03','发现错误已经修正完成0025','GSSC000013','1'),
	('SCIT000026','盘点差错0026','2019-11-07','发现错误已经修正完成0026','GSSC000013','1'),
	('SCIT000027','盘点差错0027','2020-03-22','发现错误已经修正完成0027','GSSC000014','1'),
	('SCIT000028','盘点差错0028','2020-05-18','发现错误已经修正完成0028','GSSC000014','1'),
	('SCIT000029','盘点差错0029','2020-06-06','发现错误已经修正完成0029','GSSC000015','1'),
	('SCIT000030','盘点差错0030','2019-08-04','发现错误已经修正完成0030','GSSC000015','1'),
	('SCIT000031','盘点差错0031','2019-11-13','发现错误已经修正完成0031','GSSC000016','1'),
	('SCIT000032','盘点差错0032','2020-04-30','发现错误已经修正完成0032','GSSC000016','1');

insert into goods_allocation_data values
	('GA000001','成都龙泉驿飞鹤路20号存货区货架20号货位0001','41.84349178535305','130.28359419421304','GS000001','1'),
	('GA000002','成都龙泉驿飞鹤路20号存货区货架20号货位0002','40.46388732028279','131.47257374555582','GS000001','1'),
	('GA000003','成都龙泉驿飞鹤路20号存货区货架20号货位0003','40.20312997778834','129.93192088234844','GS000002','1'),
	('GA000004','成都龙泉驿飞鹤路20号存货区货架20号货位0004','40.737864223026754','130.66981683029735','GS000002','1'),
	('GA000005','成都龙泉驿飞鹤路20号存货区货架20号货位0005','40.6744623932762','131.17184792983483','GS000003','1'),
	('GA000006','成都龙泉驿飞鹤路20号存货区货架20号货位0006','41.485903534290934','130.56775220349235','GS000003','1'),
	('GA000007','成都龙泉驿飞鹤路20号存货区货架20号货位0007','40.2911395063685','131.68344183046813','GS000004','1'),
	('GA000008','成都龙泉驿飞鹤路20号存货区货架20号货位0008','39.80205807561564','131.8944356343079','GS000004','1'),
	('GA000009','成都龙泉驿飞鹤路20号存货区货架20号货位0009','41.4341990136406','132.0376520745363','GS000005','1'),
	('GA000010','成都龙泉驿飞鹤路20号存货区货架20号货位0010','40.85334597744092','132.08961887766367','GS000005','1'),
	('GA000011','成都龙泉驿飞鹤路20号存货区货架20号货位0011','40.430340743232996','130.91082849053663','GS000006','1'),
	('GA000012','成都龙泉驿飞鹤路20号存货区货架20号货位0012','40.87965111977934','131.8528502423542','GS000006','1'),
	('GA000013','成都龙泉驿飞鹤路20号存货区货架20号货位0013','40.55146834179081','130.67593044953395','GS000007','1'),
	('GA000014','成都龙泉驿飞鹤路20号存货区货架20号货位0014','40.079861112134196','129.51356443645804','GS000007','1'),
	('GA000015','成都龙泉驿飞鹤路20号存货区货架20号货位0015','40.61761598258465','130.01468608935627','GS000008','1'),
	('GA000016','成都龙泉驿飞鹤路20号存货区货架20号货位0016','41.328059650766555','131.4958377526121','GS000008','1');

insert into goods_data values
	('G000001','可口可乐0001','RF991920001','件','10','2021-01-18','S000001','RS000001','GA000001','SP000001','SS000001','TT000001','RS000001','SO000001','RSO000001','1'),
	('G000002','可口可乐0002','RF991920002','箱','9','2019-03-29','S000001','RS000001','GA000001','SP000001','SS000001','TT000001','RS000001','SO000001','RSO000001','1'),
	('G000003','可口可乐0003','RF991920003','件','10','2021-03-22','S000002','RS000001','GA000001','SP000001','SS000001','TT000001','RS000001','SO000001','RSO000001','1'),
	('G000004','可口可乐0004','RF991920004','箱','10','2019-05-27','S000002','RS000001','GA000001','SP000001','SS000001','TT000001','RS000001','SO000001','RSO000001','1'),
	('G000005','可口可乐0005','RF991920005','件','8','2019-10-22','S000003','RS000001','GA000001','SP000001','SS000001','TT000001','RS000001','SO000001','RSO000001','1'),
	('G000006','可口可乐0006','RF991920006','箱','9','2019-01-21','S000004','RS000001','GA000001','SP000001','SS000001','TT000001','RS000001','SO000001','RSO000001','1'),
	('G000007','可口可乐0007','RF991920007','件','9','2021-05-16','S000004','RS000001','GA000001','SP000001','SS000001','TT000001','RS000001','SO000001','RSO000001','1'),
	('G000008','可口可乐0008','RF991920008','箱','8','2020-10-12','S000005','RS000001','GA000002','SP000001','SS000001','TT000002','RS000001','SO000001','RSO000002','1'),
	('G000009','可口可乐0009','RF991920009','件','10','2021-07-18','S000006','RS000001','GA000002','SP000001','SS000001','TT000002','RS000001','SO000001','RSO000002','1'),
	('G000010','可口可乐0010','RF991920010','箱','9','2020-10-03','S000006','RS000001','GA000002','SP000001','SS000001','TT000002','RS000001','SO000001','RSO000002','1'),
	('G000011','可口可乐0011','RF991920011','件','8','2020-12-30','S000007','RS000001','GA000002','SP000001','SS000001','TT000002','RS000001','SO000001','RSO000002','1'),
	('G000012','可口可乐0012','RF991920012','箱','9','2019-05-26','S000008','RS000001','GA000002','SP000001','SS000001','TT000002','RS000001','SO000001','RSO000002','1'),
	('G000013','可口可乐0013','RF991920013','件','9','2021-07-04','S000008','RS000001','GA000002','SP000001','SS000001','TT000002','RS000001','SO000001','RSO000002','1'),
	('G000014','可口可乐0014','RF991920014','箱','10','2021-01-11','S000009','RS000001','GA000003','SP000001','SS000001','TT000003','RS000002','SO000001','RSO000003','1'),
	('G000015','可口可乐0015','RF991920015','件','9','2021-03-26','S000009','RS000001','GA000003','SP000001','SS000001','TT000003','RS000002','SO000001','RSO000003','1'),
	('G000016','可口可乐0016','RF991920016','箱','10','2021-05-23','S000010','RS000001','GA000003','SP000001','SS000001','TT000003','RS000002','SO000001','RSO000003','1'),
	('G000017','可口可乐0017','RF991920017','件','10','2018-09-24','S000011','RS000001','GA000003','SP000001','SS000001','TT000003','RS000002','SO000001','RSO000003','1'),
	('G000018','可口可乐0018','RF991920018','箱','9','2019-02-01','S000011','RS000001','GA000003','SP000001','SS000001','TT000003','RS000002','SO000001','RSO000003','1'),
	('G000019','可口可乐0019','RF991920019','件','8','2019-07-05','S000012','RS000001','GA000003','SP000001','SS000001','TT000003','RS000002','SO000001','RSO000003','1'),
	('G000020','可口可乐0020','RF991920020','箱','10','2019-05-17','S000013','RS000001','GA000004','SP000001','SS000001','TT000004','RS000002','SO000001','RSO000004','1'),
	('G000021','可口可乐0021','RF991920021','件','9','2021-08-31','S000013','RS000001','GA000004','SP000001','SS000001','TT000004','RS000002','SO000001','RSO000004','1'),
	('G000022','可口可乐0022','RF991920022','箱','9','2020-06-20','S000014','RS000001','GA000004','SP000001','SS000001','TT000004','RS000002','SO000001','RSO000004','1'),
	('G000023','可口可乐0023','RF991920023','件','10','2018-11-12','S000015','RS000001','GA000004','SP000001','SS000001','TT000004','RS000002','SO000001','RSO000004','1'),
	('G000024','可口可乐0024','RF991920024','箱','8','2021-01-28','S000015','RS000001','GA000004','SP000001','SS000001','TT000004','RS000002','SO000001','RSO000004','1'),
	('G000025','可口可乐0025','RF991920025','件','8','2020-01-14','S000016','RS000001','GA000004','SP000001','SS000001','TT000004','RS000002','SO000001','RSO000004','1'),
	('G000026','可口可乐0026','RF991920026','箱','10','2019-04-04','S000017','RS000002','GA000005','SP000002','SS000002','TT000005','RS000003','SO000002','RSO000005','1'),
	('G000027','可口可乐0027','RF991920027','件','8','2020-07-14','S000017','RS000002','GA000005','SP000002','SS000002','TT000005','RS000003','SO000002','RSO000005','1'),
	('G000028','可口可乐0028','RF991920028','箱','9','2020-08-28','S000018','RS000002','GA000005','SP000002','SS000002','TT000005','RS000003','SO000002','RSO000005','1'),
	('G000029','可口可乐0029','RF991920029','件','9','2020-10-27','S000018','RS000002','GA000005','SP000002','SS000002','TT000005','RS000003','SO000002','RSO000005','1'),
	('G000030','可口可乐0030','RF991920030','箱','8','2019-12-29','S000019','RS000002','GA000005','SP000002','SS000002','TT000005','RS000003','SO000002','RSO000005','1'),
	('G000031','可口可乐0031','RF991920031','件','10','2021-08-13','S000020','RS000002','GA000005','SP000002','SS000002','TT000005','RS000003','SO000002','RSO000005','1'),
	('G000032','可口可乐0032','RF991920032','箱','8','2020-11-22','S000020','RS000002','GA000005','SP000002','SS000002','TT000005','RS000003','SO000002','RSO000005','1'),
	('G000033','可口可乐0033','RF991920033','件','8','2019-04-20','S000021','RS000002','GA000006','SP000002','SS000002','TT000006','RS000003','SO000002','RSO000006','1'),
	('G000034','可口可乐0034','RF991920034','箱','10','2020-09-13','S000022','RS000002','GA000006','SP000002','SS000002','TT000006','RS000003','SO000002','RSO000006','1'),
	('G000035','可口可乐0035','RF991920035','件','8','2019-07-19','S000022','RS000002','GA000006','SP000002','SS000002','TT000006','RS000003','SO000002','RSO000006','1'),
	('G000036','可口可乐0036','RF991920036','箱','9','2020-06-05','S000023','RS000002','GA000006','SP000002','SS000002','TT000006','RS000003','SO000002','RSO000006','1'),
	('G000037','可口可乐0037','RF991920037','件','8','2019-07-21','S000024','RS000002','GA000006','SP000002','SS000002','TT000006','RS000003','SO000002','RSO000006','1'),
	('G000038','可口可乐0038','RF991920038','箱','9','2019-11-01','S000024','RS000002','GA000006','SP000002','SS000002','TT000006','RS000003','SO000002','RSO000006','1'),
	('G000039','可口可乐0039','RF991920039','件','9','2019-09-30','S000025','RS000002','GA000007','SP000002','SS000002','TT000007','RS000004','SO000002','RSO000007','1'),
	('G000040','可口可乐0040','RF991920040','箱','8','2018-11-22','S000025','RS000002','GA000007','SP000002','SS000002','TT000007','RS000004','SO000002','RSO000007','1'),
	('G000041','可口可乐0041','RF991920041','件','9','2018-10-16','S000026','RS000002','GA000007','SP000002','SS000002','TT000007','RS000004','SO000002','RSO000007','1'),
	('G000042','可口可乐0042','RF991920042','箱','8','2020-12-01','S000027','RS000002','GA000007','SP000002','SS000002','TT000007','RS000004','SO000002','RSO000007','1'),
	('G000043','可口可乐0043','RF991920043','件','9','2019-08-11','S000027','RS000002','GA000007','SP000002','SS000002','TT000007','RS000004','SO000002','RSO000007','1'),
	('G000044','可口可乐0044','RF991920044','箱','10','2021-06-15','S000028','RS000002','GA000007','SP000002','SS000002','TT000007','RS000004','SO000002','RSO000007','1'),
	('G000045','可口可乐0045','RF991920045','件','10','2020-06-25','S000029','RS000002','GA000008','SP000002','SS000002','TT000008','RS000004','SO000002','RSO000008','1'),
	('G000046','可口可乐0046','RF991920046','箱','10','2021-05-28','S000029','RS000002','GA000008','SP000002','SS000002','TT000008','RS000004','SO000002','RSO000008','1'),
	('G000047','可口可乐0047','RF991920047','件','8','2020-09-21','S000030','RS000002','GA000008','SP000002','SS000002','TT000008','RS000004','SO000002','RSO000008','1'),
	('G000048','可口可乐0048','RF991920048','箱','8','2019-03-25','S000031','RS000002','GA000008','SP000002','SS000002','TT000008','RS000004','SO000002','RSO000008','1'),
	('G000049','可口可乐0049','RF991920049','件','9','2019-01-30','S000031','RS000002','GA000008','SP000002','SS000002','TT000008','RS000004','SO000002','RSO000008','1'),
	('G000050','可口可乐0050','RF991920050','箱','10','2020-11-01','S000032','RS000002','GA000008','SP000002','SS000002','TT000008','RS000004','SO000002','RSO000008','1'),
	('G000051','可口可乐0051','RF991920051','件','10','2019-12-28','S000033','RS000003','GA000009','SP000003','SS000003','TT000009','RS000005','SO000003','RSO000009','1'),
	('G000052','可口可乐0052','RF991920052','箱','8','2021-06-28','S000033','RS000003','GA000009','SP000003','SS000003','TT000009','RS000005','SO000003','RSO000009','1'),
	('G000053','可口可乐0053','RF991920053','件','10','2019-11-13','S000034','RS000003','GA000009','SP000003','SS000003','TT000009','RS000005','SO000003','RSO000009','1'),
	('G000054','可口可乐0054','RF991920054','箱','8','2021-05-23','S000034','RS000003','GA000009','SP000003','SS000003','TT000009','RS000005','SO000003','RSO000009','1'),
	('G000055','可口可乐0055','RF991920055','件','10','2021-01-04','S000035','RS000003','GA000009','SP000003','SS000003','TT000009','RS000005','SO000003','RSO000009','1'),
	('G000056','可口可乐0056','RF991920056','箱','8','2021-09-09','S000036','RS000003','GA000009','SP000003','SS000003','TT000009','RS000005','SO000003','RSO000009','1'),
	('G000057','可口可乐0057','RF991920057','件','8','2020-03-16','S000036','RS000003','GA000009','SP000003','SS000003','TT000009','RS000005','SO000003','RSO000009','1'),
	('G000058','可口可乐0058','RF991920058','箱','9','2021-06-20','S000037','RS000003','GA000010','SP000003','SS000003','TT000010','RS000005','SO000003','RSO000010','1'),
	('G000059','可口可乐0059','RF991920059','件','8','2020-12-15','S000038','RS000003','GA000010','SP000003','SS000003','TT000010','RS000005','SO000003','RSO000010','1'),
	('G000060','可口可乐0060','RF991920060','箱','9','2019-10-02','S000038','RS000003','GA000010','SP000003','SS000003','TT000010','RS000005','SO000003','RSO000010','1'),
	('G000061','可口可乐0061','RF991920061','件','9','2020-03-19','S000039','RS000003','GA000010','SP000003','SS000003','TT000010','RS000005','SO000003','RSO000010','1'),
	('G000062','可口可乐0062','RF991920062','箱','8','2018-10-22','S000040','RS000003','GA000010','SP000003','SS000003','TT000010','RS000005','SO000003','RSO000010','1'),
	('G000063','可口可乐0063','RF991920063','件','9','2018-09-29','S000040','RS000003','GA000010','SP000003','SS000003','TT000010','RS000005','SO000003','RSO000010','1'),
	('G000064','可口可乐0064','RF991920064','箱','8','2020-01-13','S000041','RS000003','GA000011','SP000003','SS000003','TT000011','RS000006','SO000003','RSO000011','1'),
	('G000065','可口可乐0065','RF991920065','件','8','2020-08-22','S000041','RS000003','GA000011','SP000003','SS000003','TT000011','RS000006','SO000003','RSO000011','1'),
	('G000066','可口可乐0066','RF991920066','箱','9','2019-04-20','S000042','RS000003','GA000011','SP000003','SS000003','TT000011','RS000006','SO000003','RSO000011','1'),
	('G000067','可口可乐0067','RF991920067','件','9','2019-03-31','S000043','RS000003','GA000011','SP000003','SS000003','TT000011','RS000006','SO000003','RSO000011','1'),
	('G000068','可口可乐0068','RF991920068','箱','9','2021-01-16','S000043','RS000003','GA000011','SP000003','SS000003','TT000011','RS000006','SO000003','RSO000011','1'),
	('G000069','可口可乐0069','RF991920069','件','9','2020-06-24','S000044','RS000003','GA000011','SP000003','SS000003','TT000011','RS000006','SO000003','RSO000011','1'),
	('G000070','可口可乐0070','RF991920070','箱','8','2021-07-27','S000045','RS000003','GA000012','SP000003','SS000003','TT000012','RS000006','SO000003','RSO000012','1'),
	('G000071','可口可乐0071','RF991920071','件','9','2020-11-12','S000045','RS000003','GA000012','SP000003','SS000003','TT000012','RS000006','SO000003','RSO000012','1'),
	('G000072','可口可乐0072','RF991920072','箱','10','2019-09-29','S000046','RS000003','GA000012','SP000003','SS000003','TT000012','RS000006','SO000003','RSO000012','1'),
	('G000073','可口可乐0073','RF991920073','件','9','2021-08-01','S000047','RS000003','GA000012','SP000003','SS000003','TT000012','RS000006','SO000003','RSO000012','1'),
	('G000074','可口可乐0074','RF991920074','箱','10','2019-11-26','S000047','RS000003','GA000012','SP000003','SS000003','TT000012','RS000006','SO000003','RSO000012','1'),
	('G000075','可口可乐0075','RF991920075','件','10','2019-09-18','S000048','RS000003','GA000012','SP000003','SS000003','TT000012','RS000006','SO000003','RSO000012','1'),
	('G000076','可口可乐0076','RF991920076','箱','8','2021-01-03','S000049','RS000004','GA000013','SP000004','SS000004','TT000013','RS000007','SO000004','RSO000013','1'),
	('G000077','可口可乐0077','RF991920077','件','9','2021-04-27','S000049','RS000004','GA000013','SP000004','SS000004','TT000013','RS000007','SO000004','RSO000013','1'),
	('G000078','可口可乐0078','RF991920078','箱','9','2021-01-30','S000050','RS000004','GA000013','SP000004','SS000004','TT000013','RS000007','SO000004','RSO000013','1'),
	('G000079','可口可乐0079','RF991920079','件','8','2019-03-10','S000050','RS000004','GA000013','SP000004','SS000004','TT000013','RS000007','SO000004','RSO000013','1'),
	('G000080','可口可乐0080','RF991920080','箱','10','2019-08-24','S000051','RS000004','GA000013','SP000004','SS000004','TT000013','RS000007','SO000004','RSO000013','1'),
	('G000081','可口可乐0081','RF991920081','件','8','2020-01-17','S000052','RS000004','GA000013','SP000004','SS000004','TT000013','RS000007','SO000004','RSO000013','1'),
	('G000082','可口可乐0082','RF991920082','箱','8','2020-04-29','S000052','RS000004','GA000013','SP000004','SS000004','TT000013','RS000007','SO000004','RSO000013','1'),
	('G000083','可口可乐0083','RF991920083','件','9','2019-09-11','S000053','RS000004','GA000014','SP000004','SS000004','TT000014','RS000007','SO000004','RSO000014','1'),
	('G000084','可口可乐0084','RF991920084','箱','8','2018-12-19','S000054','RS000004','GA000014','SP000004','SS000004','TT000014','RS000007','SO000004','RSO000014','1'),
	('G000085','可口可乐0085','RF991920085','件','10','2019-11-24','S000054','RS000004','GA000014','SP000004','SS000004','TT000014','RS000007','SO000004','RSO000014','1'),
	('G000086','可口可乐0086','RF991920086','箱','9','2020-04-08','S000055','RS000004','GA000014','SP000004','SS000004','TT000014','RS000007','SO000004','RSO000014','1'),
	('G000087','可口可乐0087','RF991920087','件','8','2020-11-16','S000056','RS000004','GA000014','SP000004','SS000004','TT000014','RS000007','SO000004','RSO000014','1'),
	('G000088','可口可乐0088','RF991920088','箱','10','2018-11-14','S000056','RS000004','GA000014','SP000004','SS000004','TT000014','RS000007','SO000004','RSO000014','1'),
	('G000089','可口可乐0089','RF991920089','件','9','2019-03-31','S000057','RS000004','GA000015','SP000004','SS000004','TT000015','RS000008','SO000004','RSO000015','1'),
	('G000090','可口可乐0090','RF991920090','箱','8','2018-09-19','S000057','RS000004','GA000015','SP000004','SS000004','TT000015','RS000008','SO000004','RSO000015','1'),
	('G000091','可口可乐0091','RF991920091','件','9','2021-07-02','S000058','RS000004','GA000015','SP000004','SS000004','TT000015','RS000008','SO000004','RSO000015','1'),
	('G000092','可口可乐0092','RF991920092','箱','9','2020-11-24','S000059','RS000004','GA000015','SP000004','SS000004','TT000015','RS000008','SO000004','RSO000015','1'),
	('G000093','可口可乐0093','RF991920093','件','10','2019-09-29','S000059','RS000004','GA000015','SP000004','SS000004','TT000015','RS000008','SO000004','RSO000015','1'),
	('G000094','可口可乐0094','RF991920094','箱','8','2020-08-24','S000060','RS000004','GA000015','SP000004','SS000004','TT000015','RS000008','SO000004','RSO000015','1'),
	('G000095','可口可乐0095','RF991920095','件','8','2020-11-25','S000061','RS000004','GA000016','SP000004','SS000004','TT000016','RS000008','SO000004','RSO000016','1'),
	('G000096','可口可乐0096','RF991920096','箱','10','2020-09-23','S000061','RS000004','GA000016','SP000004','SS000004','TT000016','RS000008','SO000004','RSO000016','1'),
	('G000097','可口可乐0097','RF991920097','件','10','2018-10-31','S000062','RS000004','GA000016','SP000004','SS000004','TT000016','RS000008','SO000004','RSO000016','1'),
	('G000098','可口可乐0098','RF991920098','箱','9','2019-09-03','S000063','RS000004','GA000016','SP000004','SS000004','TT000016','RS000008','SO000004','RSO000016','1'),
	('G000099','可口可乐0099','RF991920099','件','8','2020-08-27','S000063','RS000004','GA000016','SP000004','SS000004','TT000016','RS000008','SO000004','RSO000016','1'),
	('G000100','可口可乐0100','RF991920100','箱','8','2019-01-27','S000064','RS000004','GA000016','SP000004','SS000004','TT000016','RS000008','SO000004','RSO000016','1');

insert into goods_movement_data values
	('GM000001','2021-09-08 21:38:05','仓库货位','仓库货位','192.168.20.10001','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050001','FTYUIOLJYT12312312312312asdfasd0001','42.27421673175602','131.32347556389786','G000001','1'),
	('GM000002','2021-09-03 15:31:25','卡车','卡车','192.168.20.10002','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050002','FTYUIOLJYT12312312312312asdfasd0002','40.035887949184946','130.45455341298216','G000002','1'),
	('GM000003','2021-08-25 23:56:32','小超','小超','192.168.20.10003','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050003','FTYUIOLJYT12312312312312asdfasd0003','41.01911062199388','129.69196586918883','G000003','1'),
	('GM000004','2021-08-23 17:33:10','仓库货位','仓库货位','192.168.20.10004','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050004','FTYUIOLJYT12312312312312asdfasd0004','40.28326111877898','129.46368677252036','G000004','1'),
	('GM000005','2021-08-30 04:39:20','卡车','卡车','192.168.20.10005','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050005','FTYUIOLJYT12312312312312asdfasd0005','40.34447520614649','130.9385626670058','G000005','1'),
	('GM000006','2021-08-18 22:13:37','小超','小超','192.168.20.10006','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050006','FTYUIOLJYT12312312312312asdfasd0006','42.34120375973252','131.43332706015127','G000006','1'),
	('GM000007','2021-08-24 11:38:06','仓库货位','仓库货位','192.168.20.10007','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050007','FTYUIOLJYT12312312312312asdfasd0007','40.42872876743024','131.26310740375425','G000007','1'),
	('GM000008','2021-08-27 02:20:22','卡车','卡车','192.168.20.10008','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050008','FTYUIOLJYT12312312312312asdfasd0008','41.85379890554213','130.26183768449275','G000008','1'),
	('GM000009','2021-08-22 16:00:59','小超','小超','192.168.20.10009','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050009','FTYUIOLJYT12312312312312asdfasd0009','39.85786796816277','129.47312475955903','G000009','1'),
	('GM000010','2021-08-24 05:57:13','仓库货位','仓库货位','192.168.20.10010','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050010','FTYUIOLJYT12312312312312asdfasd0010','42.66867627963926','131.66748051226807','G000010','1'),
	('GM000011','2021-09-09 01:53:54','卡车','卡车','192.168.20.10011','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050011','FTYUIOLJYT12312312312312asdfasd0011','41.55095503934715','129.671604691961','G000011','1'),
	('GM000012','2021-09-09 08:50:16','小超','小超','192.168.20.10012','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050012','FTYUIOLJYT12312312312312asdfasd0012','40.41838598143958','129.70321614061038','G000012','1'),
	('GM000013','2021-08-21 15:30:21','仓库货位','仓库货位','192.168.20.10013','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050013','FTYUIOLJYT12312312312312asdfasd0013','41.66653331979468','130.7742829397512','G000013','1'),
	('GM000014','2021-08-29 02:18:03','卡车','卡车','192.168.20.10014','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050014','FTYUIOLJYT12312312312312asdfasd0014','42.58155847103872','130.30909524412843','G000014','1'),
	('GM000015','2021-09-07 20:06:29','小超','小超','192.168.20.10015','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050015','FTYUIOLJYT12312312312312asdfasd0015','42.664056039618984','129.29268472053525','G000015','1'),
	('GM000016','2021-08-19 14:52:05','仓库货位','仓库货位','192.168.20.10016','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050016','FTYUIOLJYT12312312312312asdfasd0016','41.30183925890031','130.2395108193733','G000016','1'),
	('GM000017','2021-08-20 14:21:43','卡车','卡车','192.168.20.10017','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050017','FTYUIOLJYT12312312312312asdfasd0017','40.098339082609975','129.28424720261964','G000017','1'),
	('GM000018','2021-08-21 15:27:08','小超','小超','192.168.20.10018','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050018','FTYUIOLJYT12312312312312asdfasd0018','40.251034971343145','131.22064426235178','G000018','1'),
	('GM000019','2021-09-08 23:18:58','仓库货位','仓库货位','192.168.20.10019','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050019','FTYUIOLJYT12312312312312asdfasd0019','39.81434157183568','129.33033822276445','G000019','1'),
	('GM000020','2021-08-30 17:12:55','卡车','卡车','192.168.20.10020','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050020','FTYUIOLJYT12312312312312asdfasd0020','40.15881147364516','130.3753799560779','G000020','1'),
	('GM000021','2021-09-07 07:53:32','小超','小超','192.168.20.10021','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050021','FTYUIOLJYT12312312312312asdfasd0021','41.13169061247441','129.84033015006543','G000021','1'),
	('GM000022','2021-09-08 17:19:56','仓库货位','仓库货位','192.168.20.10022','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050022','FTYUIOLJYT12312312312312asdfasd0022','41.26241467899907','131.91499462304412','G000022','1'),
	('GM000023','2021-09-04 20:49:44','卡车','卡车','192.168.20.10023','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050023','FTYUIOLJYT12312312312312asdfasd0023','40.588894914000015','130.08160063175447','G000023','1'),
	('GM000024','2021-08-21 04:04:35','小超','小超','192.168.20.10024','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050024','FTYUIOLJYT12312312312312asdfasd0024','41.277140695243276','131.5333880323865','G000024','1'),
	('GM000025','2021-08-24 00:41:42','仓库货位','仓库货位','192.168.20.10025','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050025','FTYUIOLJYT12312312312312asdfasd0025','39.90983781077463','131.24105810568113','G000025','1'),
	('GM000026','2021-09-09 07:36:40','卡车','卡车','192.168.20.10026','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050026','FTYUIOLJYT12312312312312asdfasd0026','40.17568571933848','130.87296504912095','G000026','1'),
	('GM000027','2021-08-30 06:11:16','小超','小超','192.168.20.10027','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050027','FTYUIOLJYT12312312312312asdfasd0027','40.69174630770473','130.37630842769545','G000027','1'),
	('GM000028','2021-08-27 08:38:53','仓库货位','仓库货位','192.168.20.10028','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050028','FTYUIOLJYT12312312312312asdfasd0028','40.6692091697086','129.96210070097888','G000028','1'),
	('GM000029','2021-09-01 13:20:40','卡车','卡车','192.168.20.10029','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050029','FTYUIOLJYT12312312312312asdfasd0029','39.85435582897457','130.60978170680517','G000029','1'),
	('GM000030','2021-09-03 07:52:36','小超','小超','192.168.20.10030','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050030','FTYUIOLJYT12312312312312asdfasd0030','41.0852156766664','129.58112004719825','G000030','1'),
	('GM000031','2021-08-28 10:15:44','仓库货位','仓库货位','192.168.20.10031','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050031','FTYUIOLJYT12312312312312asdfasd0031','41.17251877868565','130.85605750071375','G000031','1'),
	('GM000032','2021-09-03 20:00:19','卡车','卡车','192.168.20.10032','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050032','FTYUIOLJYT12312312312312asdfasd0032','40.07060366375704','129.60375054092006','G000032','1'),
	('GM000033','2021-08-29 06:47:55','小超','小超','192.168.20.10033','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050033','FTYUIOLJYT12312312312312asdfasd0033','41.10524705675442','130.2033997685199','G000033','1'),
	('GM000034','2021-08-25 21:06:58','仓库货位','仓库货位','192.168.20.10034','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050034','FTYUIOLJYT12312312312312asdfasd0034','40.14896333219853','129.31900621575696','G000034','1'),
	('GM000035','2021-08-22 01:15:19','卡车','卡车','192.168.20.10035','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050035','FTYUIOLJYT12312312312312asdfasd0035','40.07747494201355','129.95042583033765','G000035','1'),
	('GM000036','2021-08-29 22:02:07','小超','小超','192.168.20.10036','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050036','FTYUIOLJYT12312312312312asdfasd0036','41.51908205480448','130.4775350527118','G000036','1'),
	('GM000037','2021-09-08 04:57:41','仓库货位','仓库货位','192.168.20.10037','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050037','FTYUIOLJYT12312312312312asdfasd0037','42.13913451278695','130.8362708455671','G000037','1'),
	('GM000038','2021-09-04 09:37:34','卡车','卡车','192.168.20.10038','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050038','FTYUIOLJYT12312312312312asdfasd0038','40.189406154288704','132.06780982703296','G000038','1'),
	('GM000039','2021-08-22 02:40:51','小超','小超','192.168.20.10039','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050039','FTYUIOLJYT12312312312312asdfasd0039','42.37003991438125','130.00910998616538','G000039','1'),
	('GM000040','2021-08-25 20:45:45','仓库货位','仓库货位','192.168.20.10040','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050040','FTYUIOLJYT12312312312312asdfasd0040','41.64681100839274','129.93050471670475','G000040','1'),
	('GM000041','2021-08-26 21:34:48','卡车','卡车','192.168.20.10041','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050041','FTYUIOLJYT12312312312312asdfasd0041','41.19729245297391','131.5180974418404','G000041','1'),
	('GM000042','2021-09-05 20:15:11','小超','小超','192.168.20.10042','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050042','FTYUIOLJYT12312312312312asdfasd0042','40.00647181979267','131.91143667362795','G000042','1'),
	('GM000043','2021-08-28 08:24:14','仓库货位','仓库货位','192.168.20.10043','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050043','FTYUIOLJYT12312312312312asdfasd0043','40.20127645555414','131.0554592116449','G000043','1'),
	('GM000044','2021-09-07 01:45:24','卡车','卡车','192.168.20.10044','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050044','FTYUIOLJYT12312312312312asdfasd0044','42.18505069235731','130.06015028601078','G000044','1'),
	('GM000045','2021-08-28 20:58:29','小超','小超','192.168.20.10045','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050045','FTYUIOLJYT12312312312312asdfasd0045','42.59178033533051','130.23953046840845','G000045','1'),
	('GM000046','2021-09-07 12:11:36','仓库货位','仓库货位','192.168.20.10046','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050046','FTYUIOLJYT12312312312312asdfasd0046','39.98710046295403','129.95629136393194','G000046','1'),
	('GM000047','2021-08-30 08:39:12','卡车','卡车','192.168.20.10047','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050047','FTYUIOLJYT12312312312312asdfasd0047','42.00043527390407','132.0399781989275','G000047','1'),
	('GM000048','2021-08-25 20:26:53','小超','小超','192.168.20.10048','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050048','FTYUIOLJYT12312312312312asdfasd0048','42.452923924143924','129.7211945728707','G000048','1'),
	('GM000049','2021-09-06 01:24:35','仓库货位','仓库货位','192.168.20.10049','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050049','FTYUIOLJYT12312312312312asdfasd0049','41.0507229012773','132.08044935617923','G000049','1'),
	('GM000050','2021-08-31 23:30:25','卡车','卡车','192.168.20.10050','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050050','FTYUIOLJYT12312312312312asdfasd0050','40.94664740551042','130.10755366980726','G000050','1'),
	('GM000051','2021-09-03 16:53:20','小超','小超','192.168.20.10051','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050051','FTYUIOLJYT12312312312312asdfasd0051','42.40160168967613','131.2917048225309','G000051','1'),
	('GM000052','2021-08-19 03:28:29','仓库货位','仓库货位','192.168.20.10052','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050052','FTYUIOLJYT12312312312312asdfasd0052','39.78061701199199','129.793743219861','G000052','1'),
	('GM000053','2021-08-24 18:46:02','卡车','卡车','192.168.20.10053','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050053','FTYUIOLJYT12312312312312asdfasd0053','40.01280024815663','130.96333754302006','G000053','1'),
	('GM000054','2021-08-29 23:11:21','小超','小超','192.168.20.10054','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050054','FTYUIOLJYT12312312312312asdfasd0054','39.89417427941815','130.00752615614434','G000054','1'),
	('GM000055','2021-09-02 00:34:42','仓库货位','仓库货位','192.168.20.10055','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050055','FTYUIOLJYT12312312312312asdfasd0055','42.724609509542226','130.09095551520736','G000055','1'),
	('GM000056','2021-08-22 04:39:45','卡车','卡车','192.168.20.10056','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050056','FTYUIOLJYT12312312312312asdfasd0056','39.902321721434085','130.81084806100603','G000056','1'),
	('GM000057','2021-08-29 22:39:12','小超','小超','192.168.20.10057','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050057','FTYUIOLJYT12312312312312asdfasd0057','42.18628587099765','129.42788220979085','G000057','1'),
	('GM000058','2021-08-27 22:30:19','仓库货位','仓库货位','192.168.20.10058','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050058','FTYUIOLJYT12312312312312asdfasd0058','42.57676130742702','131.0656467885152','G000058','1'),
	('GM000059','2021-08-30 16:28:01','卡车','卡车','192.168.20.10059','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050059','FTYUIOLJYT12312312312312asdfasd0059','40.586790271982416','129.91876613756918','G000059','1'),
	('GM000060','2021-08-22 06:54:07','小超','小超','192.168.20.10060','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050060','FTYUIOLJYT12312312312312asdfasd0060','40.345437671253265','129.62068370585004','G000060','1'),
	('GM000061','2021-08-28 06:40:24','仓库货位','仓库货位','192.168.20.10061','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050061','FTYUIOLJYT12312312312312asdfasd0061','40.74949510540279','130.76288766203862','G000061','1'),
	('GM000062','2021-09-02 05:32:34','卡车','卡车','192.168.20.10062','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050062','FTYUIOLJYT12312312312312asdfasd0062','40.22731019760426','129.79003812374236','G000062','1'),
	('GM000063','2021-08-21 08:01:57','小超','小超','192.168.20.10063','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050063','FTYUIOLJYT12312312312312asdfasd0063','42.23677526663802','131.97644333232108','G000063','1'),
	('GM000064','2021-09-02 20:36:09','仓库货位','仓库货位','192.168.20.10064','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050064','FTYUIOLJYT12312312312312asdfasd0064','42.74001632922886','130.49193779451235','G000064','1'),
	('GM000065','2021-09-03 02:37:09','卡车','卡车','192.168.20.10065','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050065','FTYUIOLJYT12312312312312asdfasd0065','40.28727798927065','129.697803867556','G000065','1'),
	('GM000066','2021-09-07 11:44:55','小超','小超','192.168.20.10066','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050066','FTYUIOLJYT12312312312312asdfasd0066','39.91589192541824','129.56698445377188','G000066','1'),
	('GM000067','2021-09-08 18:42:29','仓库货位','仓库货位','192.168.20.10067','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050067','FTYUIOLJYT12312312312312asdfasd0067','42.372465246315','131.01297603874852','G000067','1'),
	('GM000068','2021-08-21 18:13:19','卡车','卡车','192.168.20.10068','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050068','FTYUIOLJYT12312312312312asdfasd0068','41.776137882593176','130.96066305631888','G000068','1'),
	('GM000069','2021-08-25 21:04:52','小超','小超','192.168.20.10069','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050069','FTYUIOLJYT12312312312312asdfasd0069','41.93221585031571','129.62863268241662','G000069','1'),
	('GM000070','2021-08-25 03:24:21','仓库货位','仓库货位','192.168.20.10070','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050070','FTYUIOLJYT12312312312312asdfasd0070','42.286530376241934','130.62750388798187','G000070','1'),
	('GM000071','2021-09-05 19:30:38','卡车','卡车','192.168.20.10071','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050071','FTYUIOLJYT12312312312312asdfasd0071','40.53243273990875','131.34864354375668','G000071','1'),
	('GM000072','2021-09-04 05:44:02','小超','小超','192.168.20.10072','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050072','FTYUIOLJYT12312312312312asdfasd0072','40.24687337273314','130.76273771979498','G000072','1'),
	('GM000073','2021-08-18 17:44:41','仓库货位','仓库货位','192.168.20.10073','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050073','FTYUIOLJYT12312312312312asdfasd0073','40.20945276643789','132.03168329069373','G000073','1'),
	('GM000074','2021-08-22 12:10:45','卡车','卡车','192.168.20.10074','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050074','FTYUIOLJYT12312312312312asdfasd0074','41.249399345762015','131.1892044352419','G000074','1'),
	('GM000075','2021-08-25 02:21:12','小超','小超','192.168.20.10075','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050075','FTYUIOLJYT12312312312312asdfasd0075','40.63341781146393','130.23999234592907','G000075','1'),
	('GM000076','2021-08-18 21:03:52','仓库货位','仓库货位','192.168.20.10076','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050076','FTYUIOLJYT12312312312312asdfasd0076','40.230696831818854','131.3982296546945','G000076','1'),
	('GM000077','2021-08-27 19:45:24','卡车','卡车','192.168.20.10077','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050077','FTYUIOLJYT12312312312312asdfasd0077','42.77061791893981','129.30361205136538','G000077','1'),
	('GM000078','2021-08-28 12:59:37','小超','小超','192.168.20.10078','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050078','FTYUIOLJYT12312312312312asdfasd0078','41.39274486823644','131.66688830077513','G000078','1'),
	('GM000079','2021-08-29 12:07:22','仓库货位','仓库货位','192.168.20.10079','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050079','FTYUIOLJYT12312312312312asdfasd0079','39.86622982964198','130.39443961110908','G000079','1'),
	('GM000080','2021-08-30 12:50:37','卡车','卡车','192.168.20.10080','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050080','FTYUIOLJYT12312312312312asdfasd0080','40.989669973976596','132.23235753622387','G000080','1'),
	('GM000081','2021-09-08 00:50:27','小超','小超','192.168.20.10081','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050081','FTYUIOLJYT12312312312312asdfasd0081','40.54506677411892','130.75739054455389','G000081','1'),
	('GM000082','2021-08-29 11:49:45','仓库货位','仓库货位','192.168.20.10082','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050082','FTYUIOLJYT12312312312312asdfasd0082','41.47943177788271','129.40688933398613','G000082','1'),
	('GM000083','2021-09-04 15:11:48','卡车','卡车','192.168.20.10083','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050083','FTYUIOLJYT12312312312312asdfasd0083','41.958262840771575','130.51209757711575','G000083','1'),
	('GM000084','2021-09-08 20:43:59','小超','小超','192.168.20.10084','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050084','FTYUIOLJYT12312312312312asdfasd0084','40.5884365406245','130.5523918110925','G000084','1'),
	('GM000085','2021-08-27 20:54:57','仓库货位','仓库货位','192.168.20.10085','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050085','FTYUIOLJYT12312312312312asdfasd0085','39.83569429006825','129.90130852596738','G000085','1'),
	('GM000086','2021-09-05 06:06:22','卡车','卡车','192.168.20.10086','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050086','FTYUIOLJYT12312312312312asdfasd0086','42.39984940943614','129.61790544661875','G000086','1'),
	('GM000087','2021-08-23 10:13:36','小超','小超','192.168.20.10087','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050087','FTYUIOLJYT12312312312312asdfasd0087','40.76298362022917','132.20799823917957','G000087','1'),
	('GM000088','2021-09-08 00:39:52','仓库货位','仓库货位','192.168.20.10088','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050088','FTYUIOLJYT12312312312312asdfasd0088','40.57402175934828','130.67073484413368','G000088','1'),
	('GM000089','2021-08-22 13:01:12','卡车','卡车','192.168.20.10089','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050089','FTYUIOLJYT12312312312312asdfasd0089','41.54184471063714','129.43182692662216','G000089','1'),
	('GM000090','2021-09-05 03:00:04','小超','小超','192.168.20.10090','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050090','FTYUIOLJYT12312312312312asdfasd0090','42.36599645479605','132.04510812541838','G000090','1'),
	('GM000091','2021-08-21 11:33:32','仓库货位','仓库货位','192.168.20.10091','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050091','FTYUIOLJYT12312312312312asdfasd0091','40.24514707297499','130.54973495042967','G000091','1'),
	('GM000092','2021-08-22 15:22:36','卡车','卡车','192.168.20.10092','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050092','FTYUIOLJYT12312312312312asdfasd0092','40.29764442768198','130.9915702620334','G000092','1'),
	('GM000093','2021-08-20 10:33:43','小超','小超','192.168.20.10093','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050093','FTYUIOLJYT12312312312312asdfasd0093','41.00336820287493','131.58106052465013','G000093','1'),
	('GM000094','2021-09-09 02:16:36','仓库货位','仓库货位','192.168.20.10094','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050094','FTYUIOLJYT12312312312312asdfasd0094','40.95090216410713','131.46458633397341','G000094','1'),
	('GM000095','2021-08-31 08:33:41','卡车','卡车','192.168.20.10095','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050095','FTYUIOLJYT12312312312312asdfasd0095','41.195145032264634','129.73362224119614','G000095','1'),
	('GM000096','2021-08-19 21:52:20','小超','小超','192.168.20.10096','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050096','FTYUIOLJYT12312312312312asdfasd0096','42.60720969177048','131.94186782762668','G000096','1'),
	('GM000097','2021-08-25 02:55:31','仓库货位','仓库货位','192.168.20.10097','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050097','FTYUIOLJYT12312312312312asdfasd0097','40.9276454536898','131.57587678796568','G000097','1'),
	('GM000098','2021-08-23 23:37:22','卡车','卡车','192.168.20.10098','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050098','FTYUIOLJYT12312312312312asdfasd0098','40.80312561773888','132.26170565260318','G000098','1'),
	('GM000099','2021-08-22 04:37:34','小超','小超','192.168.20.10099','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050099','FTYUIOLJYT12312312312312asdfasd0099','40.426790132368616','130.116811309728','G000099','1'),
	('GM000100','2021-08-29 03:12:39','仓库货位','仓库货位','192.168.20.10100','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050100','FTYUIOLJYT12312312312312asdfasd0100','40.69286193500405','130.8071806232302','G000100','1');

insert into supplier_space_data values
	('SS000001','成都龙泉驿飞鹤路20号供货商独立管理区0001','028 876543210001','1876平方米0001','W000001','39.90615428418811','129.9821977371128','2021-09-07 10:31:47','1'),
	('SS000002','成都龙泉驿飞鹤路20号供货商独立管理区0002','028 876543210002','1876平方米0002','W000001','41.052751523857815','129.99468175191944','2021-09-01 16:24:54','1'),
	('SS000003','成都龙泉驿飞鹤路20号供货商独立管理区0003','028 876543210003','1876平方米0003','W000002','40.06395316926125','130.28675721421158','2021-08-30 15:59:55','1'),
	('SS000004','成都龙泉驿飞鹤路20号供货商独立管理区0004','028 876543210004','1876平方米0004','W000002','41.83101514246309','131.3247077140058','2021-08-22 12:40:57','1');

insert into receiving_space_data values
	('RS000001','成都龙泉驿飞鹤路20号仓库卸货区0001','028 876543210001','每个收货区可以供一辆车卸货0001','1876平方米0001','W000001','42.52985757643368','129.43838018314779','2021-08-28 22:00:28','1'),
	('RS000002','成都龙泉驿飞鹤路20号仓库卸货区0002','028 876543210002','每个收货区可以供一辆车卸货0002','1876平方米0002','W000001','40.22244430240222','131.5214388424926','2021-08-23 19:26:21','1'),
	('RS000003','成都龙泉驿飞鹤路20号仓库卸货区0003','028 876543210003','每个收货区可以供一辆车卸货0003','1876平方米0003','W000002','42.191049927686535','129.559910961534','2021-08-27 04:56:18','1'),
	('RS000004','成都龙泉驿飞鹤路20号仓库卸货区0004','028 876543210004','每个收货区可以供一辆车卸货0004','1876平方米0004','W000002','40.04690835549797','131.1106395411097','2021-09-09 01:15:38','1');

insert into shipping_space_data values
	('SS000001','成都龙泉驿飞鹤路20号装货区0001','028 876543210001','1876平方米0001','W000001','41.28817238399216','131.62035258439258','每个收货区可以供一辆车装货0001','2021-09-06 21:43:32','1'),
	('SS000002','成都龙泉驿飞鹤路20号装货区0002','028 876543210002','1876平方米0002','W000001','42.20780895467778','130.3515367913616','每个收货区可以供一辆车装货0002','2021-09-03 00:31:57','1'),
	('SS000003','成都龙泉驿飞鹤路20号装货区0003','028 876543210003','1876平方米0003','W000002','39.79139177301299','130.17656959191729','每个收货区可以供一辆车装货0003','2021-09-03 21:44:14','1'),
	('SS000004','成都龙泉驿飞鹤路20号装货区0004','028 876543210004','1876平方米0004','W000002','40.27259550870281','130.60682313954024','每个收货区可以供一辆车装货0004','2021-08-22 19:25:07','1');

insert into damage_space_data values
	('DS000001','成都龙泉驿飞鹤路20号仓库损坏货物堆放区0001','028 876543210001','1876平方米0001','42.33428686346861','130.11934322101203','W000001','2021-09-06 08:19:26','1'),
	('DS000002','成都龙泉驿飞鹤路20号仓库损坏货物堆放区0002','028 876543210002','1876平方米0002','42.535087066525804','130.88101324430568','W000001','2021-08-27 09:42:24','1'),
	('DS000003','成都龙泉驿飞鹤路20号仓库损坏货物堆放区0003','028 876543210003','1876平方米0003','40.506633765183096','131.78669971296006','W000002','2021-08-24 23:55:00','1'),
	('DS000004','成都龙泉驿飞鹤路20号仓库损坏货物堆放区0004','028 876543210004','1876平方米0004','42.38225555041556','131.40517010302244','W000002','2021-09-02 02:21:32','1');

insert into warehouse_asset_data values
	('WA000001','叉车','备用件存放区设备库房0001','W000001','2021-09-01 22:14:57','1'),
	('WA000002','托盘','备用件存放区设备库房0002','W000001','2021-09-02 22:06:15','1'),
	('WA000003','传送带备件','备用件存放区设备库房0003','W000002','2021-08-19 11:44:19','1'),
	('WA000004','叉车','备用件存放区设备库房0004','W000002','2021-08-23 09:53:19','1');

insert into transport_fleet_data values
	('TF000001','双链先锋号车队0001','028 876543210001','RSCC000001','2021-08-18 19:30:46','1'),
	('TF000002','双链先锋号车队0002','028 876543210002','RSCC000001','2021-09-08 01:32:14','1');

insert into transport_truck_data values
	('TT000001','运货卡车0001','川AK50001','028 876543210001','VL91980001','EN001020001','2020-11-07','100万公里0001','红色','TF000001','1'),
	('TT000002','运货卡车0002','川AK50002','028 876543210002','VL91980002','EN001020002','2021-04-09','100万公里0002','蓝色','TF000001','1'),
	('TT000003','运货卡车0003','川AK50003','028 876543210003','VL91980003','EN001020003','2019-12-01','100万公里0003','白色','TF000002','1'),
	('TT000004','运货卡车0004','川AK50004','028 876543210004','VL91980004','EN001020004','2018-12-20','100万公里0004','灰色','TF000002','1');

insert into truck_driver_data values
	('TD000001','运货卡车司机0001','5109 9887 7330001','18777778888','TF000001','1'),
	('TD000002','运货卡车司机0002','5109 9887 7330002','13900000002','TF000001','1'),
	('TD000003','运货卡车司机0003','5109 9887 7330003','13900000003','TF000002','1'),
	('TD000004','运货卡车司机0004','5109 9887 7330004','13900000004','TF000002','1');

insert into transport_task_data values
	('TT000001','货运记录0001','双链二号仓0001','2018-09-17','RS000001','TD000001','TT000001','TF000001','39.96263363024058','131.22769096943017','1'),
	('TT000002','货运记录0002','双链二号仓0002','2019-01-26','RS000001','TD000001','TT000001','TF000001','40.51965489746002','131.89345928489905','1'),
	('TT000003','货运记录0003','双链二号仓0003','2021-01-06','RS000002','TD000001','TT000001','TF000001','41.96621851376537','129.42250943566063','1'),
	('TT000004','货运记录0004','双链二号仓0004','2021-04-10','RS000002','TD000001','TT000001','TF000001','40.04889023558327','131.3108623507476','1'),
	('TT000005','货运记录0005','双链二号仓0005','2021-01-23','RS000003','TD000002','TT000002','TF000001','40.08992587636513','129.48779109214703','1'),
	('TT000006','货运记录0006','双链二号仓0006','2019-01-23','RS000003','TD000002','TT000002','TF000001','41.667118381444375','131.11650929963','1'),
	('TT000007','货运记录0007','双链二号仓0007','2020-12-06','RS000004','TD000002','TT000002','TF000001','40.94142693339583','130.5507547095785','1'),
	('TT000008','货运记录0008','双链二号仓0008','2019-07-28','RS000004','TD000002','TT000002','TF000001','41.8954623954975','131.99222573032648','1'),
	('TT000009','货运记录0009','双链二号仓0009','2021-06-28','RS000005','TD000003','TT000003','TF000002','40.22615959685614','130.6805857823691','1'),
	('TT000010','货运记录0010','双链二号仓0010','2019-09-28','RS000005','TD000003','TT000003','TF000002','40.41462955329517','129.4019555821743','1'),
	('TT000011','货运记录0011','双链二号仓0011','2021-01-18','RS000006','TD000003','TT000003','TF000002','42.48590994833143','130.62926218144315','1'),
	('TT000012','货运记录0012','双链二号仓0012','2020-09-09','RS000006','TD000003','TT000003','TF000002','40.84924601648766','131.90502217525915','1'),
	('TT000013','货运记录0013','双链二号仓0013','2019-07-28','RS000007','TD000004','TT000004','TF000002','42.259638818387906','131.0087243333579','1'),
	('TT000014','货运记录0014','双链二号仓0014','2020-05-17','RS000007','TD000004','TT000004','TF000002','40.759661633445724','130.2829900113532','1'),
	('TT000015','货运记录0015','双链二号仓0015','2019-04-05','RS000008','TD000004','TT000004','TF000002','40.58727498894554','131.13425830332082','1'),
	('TT000016','货运记录0016','双链二号仓0016','2021-08-13','RS000008','TD000004','TT000004','TF000002','40.103675588795866','129.4105944308101','1');

insert into transport_task_track_data values
	('TTT000001','2018-10-04','30.202740151133447','104.09155467290508','TT000001','1'),
	('TTT000002','2019-10-21','31.501220205783152','104.1871783989328','TT000001','1'),
	('TTT000003','2019-12-12','31.541786226500204','103.59403393680505','TT000002','1'),
	('TTT000004','2021-08-19','30.64681637526968','103.33983264941645','TT000002','1'),
	('TTT000005','2020-07-19','32.196794957435834','103.8372868932417','TT000003','1'),
	('TTT000006','2020-06-12','31.73634338795747','104.970375738684','TT000003','1'),
	('TTT000007','2019-01-30','30.55983207672553','105.02136086783013','TT000004','1'),
	('TTT000008','2019-05-24','30.252008152380764','104.42075039065884','TT000004','1'),
	('TTT000009','2019-03-11','32.131373608535185','103.38762439216802','TT000005','1'),
	('TTT000010','2020-04-20','30.852054516481907','105.52165182310686','TT000005','1'),
	('TTT000011','2019-05-20','32.40261940125653','104.2552439211626','TT000006','1'),
	('TTT000012','2021-03-29','32.82744146472723','104.95024343662236','TT000006','1'),
	('TTT000013','2019-12-13','31.060649710264215','104.5890772670087','TT000007','1'),
	('TTT000014','2020-09-08','31.028207675970815','104.20862681250775','TT000007','1'),
	('TTT000015','2021-05-05','32.73618975177703','104.27511014845207','TT000008','1'),
	('TTT000016','2021-03-27','31.61618071971567','104.21722340491516','TT000008','1'),
	('TTT000017','2020-12-20','32.53223866597891','105.55498255601684','TT000009','1'),
	('TTT000018','2020-08-28','30.832198205185648','104.48774108204591','TT000009','1'),
	('TTT000019','2018-09-20','30.0246952958323','105.98847196028403','TT000010','1'),
	('TTT000020','2019-11-21','32.881805148368215','104.44256817521011','TT000010','1'),
	('TTT000021','2019-05-16','30.41396351572929','104.93355851656614','TT000011','1'),
	('TTT000022','2020-10-13','31.3393791589503','105.2505946735711','TT000011','1'),
	('TTT000023','2021-06-17','31.958055345533054','105.8725272110375','TT000012','1'),
	('TTT000024','2020-06-14','31.645832691087662','103.45106862368925','TT000012','1'),
	('TTT000025','2018-11-24','30.239761776983702','103.68724874976746','TT000013','1'),
	('TTT000026','2021-07-27','31.78159778979058','104.61273814946833','TT000013','1'),
	('TTT000027','2019-10-11','30.048000019963677','105.36821496321821','TT000014','1'),
	('TTT000028','2019-07-17','31.189791278443586','104.12891988299745','TT000014','1'),
	('TTT000029','2020-02-04','30.599544317290878','106.00411547831293','TT000015','1'),
	('TTT000030','2018-09-25','30.112678767721313','103.36210669418756','TT000015','1'),
	('TTT000031','2019-02-23','30.233230303956738','104.56887171527345','TT000016','1'),
	('TTT000032','2019-10-25','30.49933637594022','105.43424294396654','TT000016','1');

insert into account_set_data values
	('AS000001','账套2017','2017年','2019-04-12','企业会计制度','RMB','人民币','招商银行','3326 5805 0548 850001','RSCC000001','RS000001','GS000001','2021-08-25 18:47:53','1'),
	('AS000002','账套2018','2018年','2019-08-08','小企业会计制度','USD','美元','工商银行','3326 5805 0548 850002','RSCC000001','RS000001','GS000001','2021-09-08 07:27:10','1'),
	('AS000003','账套2019','2019年','2020-02-01','合伙制会计制度','RMB','人民币','招商银行','3326 5805 0548 850003','RSCC000001','RS000002','GS000001','2021-08-30 20:53:56','1'),
	('AS000004','账套2017','2017年','2019-08-30','企业会计制度','USD','美元','工商银行','3326 5805 0548 850004','RSCC000001','RS000002','GS000001','2021-08-21 16:38:20','1'),
	('AS000005','账套2018','2018年','2020-09-17','小企业会计制度','RMB','人民币','招商银行','3326 5805 0548 850005','RSCC000001','RS000003','GS000001','2021-08-19 20:22:28','1'),
	('AS000006','账套2019','2019年','2020-08-11','合伙制会计制度','USD','美元','工商银行','3326 5805 0548 850006','RSCC000001','RS000003','GS000001','2021-08-31 22:38:45','1'),
	('AS000007','账套2017','2017年','2019-01-21','企业会计制度','RMB','人民币','招商银行','3326 5805 0548 850007','RSCC000001','RS000004','GS000001','2021-08-24 13:16:34','1'),
	('AS000008','账套2018','2018年','2021-03-02','小企业会计制度','USD','美元','工商银行','3326 5805 0548 850008','RSCC000001','RS000004','GS000001','2021-09-08 17:52:21','1'),
	('AS000009','账套2019','2019年','2021-05-01','合伙制会计制度','RMB','人民币','招商银行','3326 5805 0548 850009','RSCC000001','RS000005','GS000002','2021-09-04 00:56:13','1'),
	('AS000010','账套2017','2017年','2019-12-09','企业会计制度','USD','美元','工商银行','3326 5805 0548 850010','RSCC000001','RS000005','GS000002','2021-09-01 17:51:38','1'),
	('AS000011','账套2018','2018年','2019-04-22','小企业会计制度','RMB','人民币','招商银行','3326 5805 0548 850011','RSCC000001','RS000006','GS000002','2021-09-09 04:15:17','1'),
	('AS000012','账套2019','2019年','2019-10-21','合伙制会计制度','USD','美元','工商银行','3326 5805 0548 850012','RSCC000001','RS000006','GS000002','2021-08-23 15:36:50','1'),
	('AS000013','账套2017','2017年','2020-05-25','企业会计制度','RMB','人民币','招商银行','3326 5805 0548 850013','RSCC000001','RS000007','GS000002','2021-08-28 19:47:12','1'),
	('AS000014','账套2018','2018年','2021-07-14','小企业会计制度','USD','美元','工商银行','3326 5805 0548 850014','RSCC000001','RS000007','GS000002','2021-09-04 06:33:19','1'),
	('AS000015','账套2019','2019年','2020-06-27','合伙制会计制度','RMB','人民币','招商银行','3326 5805 0548 850015','RSCC000001','RS000008','GS000002','2021-08-20 02:55:35','1'),
	('AS000016','账套2017','2017年','2019-05-11','企业会计制度','USD','美元','工商银行','3326 5805 0548 850016','RSCC000001','RS000008','GS000002','2021-09-02 03:12:18','1');

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
	('AP000001','2017年1月','2018-11-13','2021-07-27','AS000001','1'),
	('AP000002','2017年2月','2021-09-04','2021-01-15','AS000001','1'),
	('AP000003','2017年3月','2020-05-20','2019-05-02','AS000002','1'),
	('AP000004','2017年4月','2020-07-15','2019-10-05','AS000002','1'),
	('AP000005','2017年5月','2021-05-18','2019-03-11','AS000003','1'),
	('AP000006','2017年6月','2018-12-05','2019-11-25','AS000003','1'),
	('AP000007','2017年7月','2020-06-26','2019-10-18','AS000004','1'),
	('AP000008','2017年8月','2021-04-16','2019-05-08','AS000004','1'),
	('AP000009','2017年9月','2018-12-13','2020-08-20','AS000005','1'),
	('AP000010','2017年10月','2019-02-04','2018-12-17','AS000005','1'),
	('AP000011','2017年11月','2020-07-05','2019-12-17','AS000006','1'),
	('AP000012','2017年12月','2019-06-06','2019-08-10','AS000006','1'),
	('AP000013','2017年1月','2019-04-25','2021-05-09','AS000007','1'),
	('AP000014','2017年2月','2019-03-09','2021-06-01','AS000007','1'),
	('AP000015','2017年3月','2019-10-17','2019-01-29','AS000008','1'),
	('AP000016','2017年4月','2021-04-13','2019-08-23','AS000008','1'),
	('AP000017','2017年5月','2018-09-23','2020-04-03','AS000009','1'),
	('AP000018','2017年6月','2020-12-15','2019-01-08','AS000009','1'),
	('AP000019','2017年7月','2020-02-07','2021-09-03','AS000010','1'),
	('AP000020','2017年8月','2019-01-15','2021-03-23','AS000010','1'),
	('AP000021','2017年9月','2019-08-31','2021-05-08','AS000011','1'),
	('AP000022','2017年10月','2020-07-25','2020-10-17','AS000011','1'),
	('AP000023','2017年11月','2019-04-19','2019-02-07','AS000012','1'),
	('AP000024','2017年12月','2019-12-22','2019-01-26','AS000012','1'),
	('AP000025','2017年1月','2019-09-15','2020-03-10','AS000013','1'),
	('AP000026','2017年2月','2020-06-07','2019-12-14','AS000013','1'),
	('AP000027','2017年3月','2018-12-05','2019-09-20','AS000014','1'),
	('AP000028','2017年4月','2019-09-22','2019-11-15','AS000014','1'),
	('AP000029','2017年5月','2020-07-28','2019-08-14','AS000015','1'),
	('AP000030','2017年6月','2020-05-08','2021-01-09','AS000015','1'),
	('AP000031','2017年7月','2021-08-24','2021-02-12','AS000016','1'),
	('AP000032','2017年8月','2019-05-09','2018-12-31','AS000016','1');

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
	('AD000001','记账凭证0001','2020-02-01','AP000001','ADT000001','1'),
	('AD000002','记账凭证0002','2021-04-17','AP000001','ADT000001','1'),
	('AD000003','记账凭证0003','2020-06-01','AP000002','ADT000002','1'),
	('AD000004','记账凭证0004','2019-01-03','AP000002','ADT000002','1'),
	('AD000005','记账凭证0005','2019-02-02','AP000003','ADT000003','1'),
	('AD000006','记账凭证0006','2019-08-27','AP000003','ADT000003','1'),
	('AD000007','记账凭证0007','2018-10-11','AP000004','ADT000004','1'),
	('AD000008','记账凭证0008','2020-06-10','AP000004','ADT000004','1'),
	('AD000009','记账凭证0009','2019-07-08','AP000005','ADT000005','1'),
	('AD000010','记账凭证0010','2020-12-14','AP000005','ADT000005','1'),
	('AD000011','记账凭证0011','2021-04-10','AP000006','ADT000006','1'),
	('AD000012','记账凭证0012','2020-12-29','AP000006','ADT000006','1'),
	('AD000013','记账凭证0013','2019-07-07','AP000007','ADT000007','1'),
	('AD000014','记账凭证0014','2021-03-09','AP000007','ADT000007','1'),
	('AD000015','记账凭证0015','2018-11-20','AP000008','ADT000008','1'),
	('AD000016','记账凭证0016','2021-07-03','AP000008','ADT000008','1'),
	('AD000017','记账凭证0017','2019-08-09','AP000009','ADT000009','1'),
	('AD000018','记账凭证0018','2021-05-06','AP000009','ADT000009','1'),
	('AD000019','记账凭证0019','2019-11-14','AP000010','ADT000010','1'),
	('AD000020','记账凭证0020','2018-09-11','AP000010','ADT000010','1'),
	('AD000021','记账凭证0021','2021-06-06','AP000011','ADT000011','1'),
	('AD000022','记账凭证0022','2020-10-28','AP000011','ADT000011','1'),
	('AD000023','记账凭证0023','2020-05-26','AP000012','ADT000012','1'),
	('AD000024','记账凭证0024','2019-04-29','AP000012','ADT000012','1'),
	('AD000025','记账凭证0025','2021-03-21','AP000013','ADT000013','1'),
	('AD000026','记账凭证0026','2020-05-09','AP000013','ADT000013','1'),
	('AD000027','记账凭证0027','2020-08-06','AP000014','ADT000014','1'),
	('AD000028','记账凭证0028','2021-09-06','AP000014','ADT000014','1'),
	('AD000029','记账凭证0029','2020-01-01','AP000015','ADT000015','1'),
	('AD000030','记账凭证0030','2019-01-23','AP000015','ADT000015','1'),
	('AD000031','记账凭证0031','2020-03-28','AP000016','ADT000016','1'),
	('AD000032','记账凭证0032','2019-02-20','AP000016','ADT000016','1'),
	('AD000033','记账凭证0033','2020-05-31','AP000017','ADT000017','1'),
	('AD000034','记账凭证0034','2019-09-26','AP000017','ADT000017','1'),
	('AD000035','记账凭证0035','2019-08-01','AP000018','ADT000018','1'),
	('AD000036','记账凭证0036','2019-05-09','AP000018','ADT000018','1'),
	('AD000037','记账凭证0037','2019-11-08','AP000019','ADT000019','1'),
	('AD000038','记账凭证0038','2019-07-27','AP000019','ADT000019','1'),
	('AD000039','记账凭证0039','2019-01-16','AP000020','ADT000020','1'),
	('AD000040','记账凭证0040','2018-12-21','AP000020','ADT000020','1'),
	('AD000041','记账凭证0041','2021-05-16','AP000021','ADT000021','1'),
	('AD000042','记账凭证0042','2019-06-14','AP000021','ADT000021','1'),
	('AD000043','记账凭证0043','2019-06-20','AP000022','ADT000022','1'),
	('AD000044','记账凭证0044','2018-12-07','AP000022','ADT000022','1'),
	('AD000045','记账凭证0045','2019-09-23','AP000023','ADT000023','1'),
	('AD000046','记账凭证0046','2020-08-04','AP000023','ADT000023','1'),
	('AD000047','记账凭证0047','2021-01-22','AP000024','ADT000024','1'),
	('AD000048','记账凭证0048','2021-02-14','AP000024','ADT000024','1'),
	('AD000049','记账凭证0049','2019-06-28','AP000025','ADT000025','1'),
	('AD000050','记账凭证0050','2020-07-17','AP000025','ADT000025','1'),
	('AD000051','记账凭证0051','2018-12-11','AP000026','ADT000026','1'),
	('AD000052','记账凭证0052','2019-12-26','AP000026','ADT000026','1'),
	('AD000053','记账凭证0053','2019-01-03','AP000027','ADT000027','1'),
	('AD000054','记账凭证0054','2021-09-03','AP000027','ADT000027','1'),
	('AD000055','记账凭证0055','2020-07-17','AP000028','ADT000028','1'),
	('AD000056','记账凭证0056','2019-08-16','AP000028','ADT000028','1'),
	('AD000057','记账凭证0057','2021-08-05','AP000029','ADT000029','1'),
	('AD000058','记账凭证0058','2021-01-26','AP000029','ADT000029','1'),
	('AD000059','记账凭证0059','2020-12-08','AP000030','ADT000030','1'),
	('AD000060','记账凭证0060','2020-04-14','AP000030','ADT000030','1'),
	('AD000061','记账凭证0061','2019-01-16','AP000031','ADT000031','1'),
	('AD000062','记账凭证0062','2020-02-19','AP000031','ADT000031','1'),
	('AD000063','记账凭证0063','2020-05-21','AP000032','ADT000032','1'),
	('AD000064','记账凭证0064','2021-07-07','AP000032','ADT000032','1');

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
	('ADL000001','收到存款0001','AS99990001','借','756235.19','AD000001','AS000001','1'),
	('ADL000002','收到存款0002','AS99990002','贷','812807.50','AD000001','AS000001','1'),
	('ADL000003','收到存款0003','AS99990003','借','846993.44','AD000002','AS000001','1'),
	('ADL000004','收到存款0004','AS99990004','贷','863835.81','AD000002','AS000001','1'),
	('ADL000005','收到存款0005','AS99990005','借','869282.12','AD000003','AS000002','1'),
	('ADL000006','收到存款0006','AS99990006','贷','801259.06','AD000004','AS000002','1'),
	('ADL000007','收到存款0007','AS99990007','借','697816.38','AD000004','AS000002','1'),
	('ADL000008','收到存款0008','AS99990008','贷','887107.69','AD000005','AS000003','1'),
	('ADL000009','收到存款0009','AS99990009','借','839765.31','AD000006','AS000003','1'),
	('ADL000010','收到存款0010','AS99990010','贷','716676.50','AD000006','AS000003','1'),
	('ADL000011','收到存款0011','AS99990011','借','736958.06','AD000007','AS000004','1'),
	('ADL000012','收到存款0012','AS99990012','贷','725498.25','AD000008','AS000004','1'),
	('ADL000013','收到存款0013','AS99990013','借','870760.06','AD000008','AS000004','1'),
	('ADL000014','收到存款0014','AS99990014','贷','719831.44','AD000009','AS000005','1'),
	('ADL000015','收到存款0015','AS99990015','借','946651.25','AD000009','AS000005','1'),
	('ADL000016','收到存款0016','AS99990016','贷','982982.62','AD000010','AS000005','1'),
	('ADL000017','收到存款0017','AS99990017','借','907839.75','AD000011','AS000006','1'),
	('ADL000018','收到存款0018','AS99990018','贷','941659.31','AD000011','AS000006','1'),
	('ADL000019','收到存款0019','AS99990019','借','830448.44','AD000012','AS000006','1'),
	('ADL000020','收到存款0020','AS99990020','贷','864302.25','AD000013','AS000007','1'),
	('ADL000021','收到存款0021','AS99990021','借','865503.94','AD000013','AS000007','1'),
	('ADL000022','收到存款0022','AS99990022','贷','773189.12','AD000014','AS000007','1'),
	('ADL000023','收到存款0023','AS99990023','借','731431.56','AD000015','AS000008','1'),
	('ADL000024','收到存款0024','AS99990024','贷','807026.12','AD000015','AS000008','1'),
	('ADL000025','收到存款0025','AS99990025','借','935031.81','AD000016','AS000008','1'),
	('ADL000026','收到存款0026','AS99990026','贷','909335.75','AD000017','AS000009','1'),
	('ADL000027','收到存款0027','AS99990027','借','884324.12','AD000017','AS000009','1'),
	('ADL000028','收到存款0028','AS99990028','贷','731820.25','AD000018','AS000009','1'),
	('ADL000029','收到存款0029','AS99990029','借','776040.56','AD000018','AS000009','1'),
	('ADL000030','收到存款0030','AS99990030','贷','816939.31','AD000019','AS000010','1'),
	('ADL000031','收到存款0031','AS99990031','借','849067.56','AD000020','AS000010','1'),
	('ADL000032','收到存款0032','AS99990032','贷','941101.88','AD000020','AS000010','1'),
	('ADL000033','收到存款0033','AS99990033','借','808880.31','AD000021','AS000011','1'),
	('ADL000034','收到存款0034','AS99990034','贷','820609.25','AD000022','AS000011','1'),
	('ADL000035','收到存款0035','AS99990035','借','838342.75','AD000022','AS000011','1'),
	('ADL000036','收到存款0036','AS99990036','贷','783542.69','AD000023','AS000012','1'),
	('ADL000037','收到存款0037','AS99990037','借','878842.19','AD000024','AS000012','1'),
	('ADL000038','收到存款0038','AS99990038','贷','722741.44','AD000024','AS000012','1'),
	('ADL000039','收到存款0039','AS99990039','借','818993.25','AD000025','AS000013','1'),
	('ADL000040','收到存款0040','AS99990040','贷','720738.44','AD000025','AS000013','1'),
	('ADL000041','收到存款0041','AS99990041','借','929830.81','AD000026','AS000013','1'),
	('ADL000042','收到存款0042','AS99990042','贷','782241.00','AD000027','AS000014','1'),
	('ADL000043','收到存款0043','AS99990043','借','941644.44','AD000027','AS000014','1'),
	('ADL000044','收到存款0044','AS99990044','贷','981811.38','AD000028','AS000014','1'),
	('ADL000045','收到存款0045','AS99990045','借','879742.88','AD000029','AS000015','1'),
	('ADL000046','收到存款0046','AS99990046','贷','776656.06','AD000029','AS000015','1'),
	('ADL000047','收到存款0047','AS99990047','借','830823.19','AD000030','AS000015','1'),
	('ADL000048','收到存款0048','AS99990048','贷','862942.31','AD000031','AS000016','1'),
	('ADL000049','收到存款0049','AS99990049','借','822446.00','AD000031','AS000016','1'),
	('ADL000050','收到存款0050','AS99990050','贷','901460.62','AD000032','AS000016','1'),
	('ADL000051','收到存款0051','AS99990051','借','772317.44','AD000033','AS000017','1'),
	('ADL000052','收到存款0052','AS99990052','贷','719761.38','AD000033','AS000017','1'),
	('ADL000053','收到存款0053','AS99990053','借','781142.00','AD000034','AS000017','1'),
	('ADL000054','收到存款0054','AS99990054','贷','886682.94','AD000034','AS000017','1'),
	('ADL000055','收到存款0055','AS99990055','借','829581.25','AD000035','AS000018','1'),
	('ADL000056','收到存款0056','AS99990056','贷','932874.31','AD000036','AS000018','1'),
	('ADL000057','收到存款0057','AS99990057','借','703912.81','AD000036','AS000018','1'),
	('ADL000058','收到存款0058','AS99990058','贷','905531.12','AD000037','AS000019','1'),
	('ADL000059','收到存款0059','AS99990059','借','816386.81','AD000038','AS000019','1'),
	('ADL000060','收到存款0060','AS99990060','贷','855955.88','AD000038','AS000019','1'),
	('ADL000061','收到存款0061','AS99990061','借','883098.56','AD000039','AS000020','1'),
	('ADL000062','收到存款0062','AS99990062','贷','828502.75','AD000040','AS000020','1'),
	('ADL000063','收到存款0063','AS99990063','借','812858.62','AD000040','AS000020','1'),
	('ADL000064','收到存款0064','AS99990064','贷','759026.50','AD000041','AS000021','1'),
	('ADL000065','收到存款0065','AS99990065','借','792580.62','AD000041','AS000021','1'),
	('ADL000066','收到存款0066','AS99990066','贷','736344.62','AD000042','AS000021','1'),
	('ADL000067','收到存款0067','AS99990067','借','702754.75','AD000043','AS000022','1'),
	('ADL000068','收到存款0068','AS99990068','贷','760015.88','AD000043','AS000022','1'),
	('ADL000069','收到存款0069','AS99990069','借','856882.44','AD000044','AS000022','1'),
	('ADL000070','收到存款0070','AS99990070','贷','716869.81','AD000045','AS000023','1'),
	('ADL000071','收到存款0071','AS99990071','借','702044.56','AD000045','AS000023','1'),
	('ADL000072','收到存款0072','AS99990072','贷','885647.94','AD000046','AS000023','1'),
	('ADL000073','收到存款0073','AS99990073','借','780282.44','AD000047','AS000024','1'),
	('ADL000074','收到存款0074','AS99990074','贷','825296.94','AD000047','AS000024','1'),
	('ADL000075','收到存款0075','AS99990075','借','876187.75','AD000048','AS000024','1'),
	('ADL000076','收到存款0076','AS99990076','贷','702928.56','AD000049','AS000025','1'),
	('ADL000077','收到存款0077','AS99990077','借','722748.06','AD000049','AS000025','1'),
	('ADL000078','收到存款0078','AS99990078','贷','815917.88','AD000050','AS000025','1'),
	('ADL000079','收到存款0079','AS99990079','借','746233.00','AD000050','AS000025','1'),
	('ADL000080','收到存款0080','AS99990080','贷','934580.69','AD000051','AS000026','1'),
	('ADL000081','收到存款0081','AS99990081','借','927787.69','AD000052','AS000026','1'),
	('ADL000082','收到存款0082','AS99990082','贷','976240.25','AD000052','AS000026','1'),
	('ADL000083','收到存款0083','AS99990083','借','766294.75','AD000053','AS000027','1'),
	('ADL000084','收到存款0084','AS99990084','贷','860273.62','AD000054','AS000027','1'),
	('ADL000085','收到存款0085','AS99990085','借','851481.81','AD000054','AS000027','1'),
	('ADL000086','收到存款0086','AS99990086','贷','914410.31','AD000055','AS000028','1'),
	('ADL000087','收到存款0087','AS99990087','借','969319.25','AD000056','AS000028','1'),
	('ADL000088','收到存款0088','AS99990088','贷','905990.44','AD000056','AS000028','1'),
	('ADL000089','收到存款0089','AS99990089','借','827261.88','AD000057','AS000029','1'),
	('ADL000090','收到存款0090','AS99990090','贷','864468.75','AD000057','AS000029','1'),
	('ADL000091','收到存款0091','AS99990091','借','976438.12','AD000058','AS000029','1'),
	('ADL000092','收到存款0092','AS99990092','贷','882176.62','AD000059','AS000030','1'),
	('ADL000093','收到存款0093','AS99990093','借','705734.25','AD000059','AS000030','1'),
	('ADL000094','收到存款0094','AS99990094','贷','901472.81','AD000060','AS000030','1'),
	('ADL000095','收到存款0095','AS99990095','借','767257.56','AD000061','AS000031','1'),
	('ADL000096','收到存款0096','AS99990096','贷','877662.69','AD000061','AS000031','1'),
	('ADL000097','收到存款0097','AS99990097','借','703574.69','AD000062','AS000031','1'),
	('ADL000098','收到存款0098','AS99990098','贷','931168.31','AD000063','AS000032','1'),
	('ADL000099','收到存款0099','AS99990099','借','918459.38','AD000063','AS000032','1'),
	('ADL000100','收到存款0100','AS99990100','贷','942226.75','AD000064','AS000032','1');

insert into level_one_department_data values
	('LOD000001','RSCC000001','供应链部','主要执行集团信息系统建设，维护，规划0001','刘强','2021-07-03','1'),
	('LOD000002','RSCC000001','采购部','主要执行集团信息系统建设，维护，规划0002','王德宏','2020-03-13','1');

insert into level_two_department_data values
	('LTD000001','LOD000001','信息系统部大数据部门0001','主要执行集团信息系统建设，维护，规划0001','2019-11-04','1'),
	('LTD000002','LOD000001','信息系统部大数据部门0002','主要执行集团信息系统建设，维护，规划0002','2021-05-31','1'),
	('LTD000003','LOD000002','信息系统部大数据部门0003','主要执行集团信息系统建设，维护，规划0003','2020-01-25','1'),
	('LTD000004','LOD000002','信息系统部大数据部门0004','主要执行集团信息系统建设，维护，规划0004','2019-08-24','1');

insert into level_three_department_data values
	('LTD000001','LTD000001','信息系统部大数据清洗组','主要执行集团信息系统建设，维护，规划0001','2021-01-30','1'),
	('LTD000002','LTD000001','信息系统部大数据运算组','主要执行集团信息系统建设，维护，规划0002','2019-02-05','1'),
	('LTD000003','LTD000002','信息系统部大数据解决方案组','主要执行集团信息系统建设，维护，规划0003','2019-09-20','1'),
	('LTD000004','LTD000002','信息系统部大数据清洗组','主要执行集团信息系统建设，维护，规划0004','2020-03-20','1'),
	('LTD000005','LTD000003','信息系统部大数据运算组','主要执行集团信息系统建设，维护，规划0005','2019-02-08','1'),
	('LTD000006','LTD000003','信息系统部大数据解决方案组','主要执行集团信息系统建设，维护，规划0006','2020-11-08','1'),
	('LTD000007','LTD000004','信息系统部大数据清洗组','主要执行集团信息系统建设，维护，规划0007','2018-10-25','1'),
	('LTD000008','LTD000004','信息系统部大数据运算组','主要执行集团信息系统建设，维护，规划0008','2021-03-08','1');

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
	('V000001','面试官0001','小伙子不错，值得培养0001','2018-09-20','1');

insert into employee_data values
	('E000001','RSCC000001','程序员0001','LTD000001','张','文强','share@163.com','北京','学院路234号0001','18677778888','OT000001','RT000001','SG000001','6226 7788 9908 0001','2021-09-04 09:41:44','1'),
	('E000002','RSCC000001','程序员0002','LTD000001','王','大伟','2@qq.com','天津','学院路234号0002','13900000002','OT000001','RT000001','SG000001','6226 7788 9908 0002','2021-09-02 14:28:14','1'),
	('E000003','RSCC000001','程序员0003','LTD000002','李','字章','3@qq.com','成都','学院路234号0003','13900000003','OT000001','RT000001','SG000001','6226 7788 9908 0003','2021-08-21 21:37:59','1'),
	('E000004','RSCC000001','程序员0004','LTD000002','贺','文强','4@qq.com','上海','学院路234号0004','13900000004','OT000001','RT000001','SG000001','6226 7788 9908 0004','2021-09-04 12:11:15','1'),
	('E000005','RSCC000001','程序员0005','LTD000003','张','大伟','5@qq.com','深圳','学院路234号0005','13900000005','OT000001','RT000001','SG000001','6226 7788 9908 0005','2021-08-31 08:07:37','1'),
	('E000006','RSCC000001','程序员0006','LTD000003','王','字章','6@qq.com','广州','学院路234号0006','13900000006','OT000001','RT000001','SG000001','6226 7788 9908 0006','2021-09-02 05:23:55','1'),
	('E000007','RSCC000001','程序员0007','LTD000004','李','文强','7@qq.com','西安','学院路234号0007','13900000007','OT000001','RT000001','SG000001','6226 7788 9908 0007','2021-08-19 12:55:43','1'),
	('E000008','RSCC000001','程序员0008','LTD000004','贺','大伟','8@qq.com','北京','学院路234号0008','13900000008','OT000001','RT000001','SG000001','6226 7788 9908 0008','2021-09-06 15:34:20','1'),
	('E000009','RSCC000001','程序员0009','LTD000005','张','字章','9@qq.com','天津','学院路234号0009','13900000009','OT000002','RT000002','SG000002','6226 7788 9908 0009','2021-08-24 08:32:12','1'),
	('E000010','RSCC000001','程序员0010','LTD000005','王','文强','10@qq.com','成都','学院路234号0010','13900000010','OT000002','RT000002','SG000002','6226 7788 9908 0010','2021-09-06 14:19:30','1'),
	('E000011','RSCC000001','程序员0011','LTD000006','李','大伟','11@qq.com','上海','学院路234号0011','13900000011','OT000002','RT000002','SG000002','6226 7788 9908 0011','2021-08-23 11:59:55','1'),
	('E000012','RSCC000001','程序员0012','LTD000006','贺','字章','12@qq.com','深圳','学院路234号0012','13900000012','OT000002','RT000002','SG000002','6226 7788 9908 0012','2021-09-02 05:35:50','1'),
	('E000013','RSCC000001','程序员0013','LTD000007','张','文强','13@qq.com','广州','学院路234号0013','13900000013','OT000002','RT000002','SG000002','6226 7788 9908 0013','2021-09-04 13:22:13','1'),
	('E000014','RSCC000001','程序员0014','LTD000007','王','大伟','14@qq.com','西安','学院路234号0014','13900000014','OT000002','RT000002','SG000002','6226 7788 9908 0014','2021-08-28 10:57:56','1'),
	('E000015','RSCC000001','程序员0015','LTD000008','李','字章','15@qq.com','北京','学院路234号0015','13900000015','OT000002','RT000002','SG000002','6226 7788 9908 0015','2021-08-25 08:37:32','1'),
	('E000016','RSCC000001','程序员0016','LTD000008','贺','文强','16@qq.com','天津','学院路234号0016','13900000016','OT000002','RT000002','SG000002','6226 7788 9908 0016','2021-08-27 02:47:54','1');

insert into instructor_data values
	('I000001','高级讲师0001','张','文强','18699990000','instructor@gmail.com','RSCC000001','这是一个长长长长长长长长的介绍0001','2021-08-26 08:30:13','1'),
	('I000002','高级讲师0002','王','大伟','13900000002','2@qq.com','RSCC000001','这是一个长长长长长长长长的介绍0002','2021-09-04 06:40:10','1');

insert into company_training_data values
	('CT000001','入职培训0001','RSCC000001','I000001','TCT000001','2019-11-12','3','2021-08-26 18:31:54','1'),
	('CT000002','入职培训0002','RSCC000001','I000001','TCT000001','2021-08-14','3','2021-08-28 20:40:18','1'),
	('CT000003','入职培训0003','RSCC000001','I000002','TCT000002','2020-02-12','3','2021-08-23 13:01:33','1'),
	('CT000004','入职培训0004','RSCC000001','I000002','TCT000002','2021-09-07','3','2021-09-05 10:02:24','1');

insert into scoring_data values
	('S000001','王志文0001','73','这个题做的真不错啊0001','1');

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
	('EWE000001','E000001','2020-11-29','2020-12-27','丝芙兰化妆品公司0001','在此期间取得非常好的绩效，赢得了客户的信赖0001','1'),
	('EWE000002','E000001','2021-04-30','2020-07-13','丝芙兰化妆品公司0002','在此期间取得非常好的绩效，赢得了客户的信赖0002','1'),
	('EWE000003','E000002','2020-11-22','2020-12-28','丝芙兰化妆品公司0003','在此期间取得非常好的绩效，赢得了客户的信赖0003','1'),
	('EWE000004','E000002','2020-04-02','2018-09-16','丝芙兰化妆品公司0004','在此期间取得非常好的绩效，赢得了客户的信赖0004','1'),
	('EWE000005','E000003','2018-10-04','2020-05-29','丝芙兰化妆品公司0005','在此期间取得非常好的绩效，赢得了客户的信赖0005','1'),
	('EWE000006','E000003','2020-12-21','2018-10-23','丝芙兰化妆品公司0006','在此期间取得非常好的绩效，赢得了客户的信赖0006','1'),
	('EWE000007','E000004','2020-10-29','2021-03-15','丝芙兰化妆品公司0007','在此期间取得非常好的绩效，赢得了客户的信赖0007','1'),
	('EWE000008','E000004','2021-01-10','2021-05-25','丝芙兰化妆品公司0008','在此期间取得非常好的绩效，赢得了客户的信赖0008','1'),
	('EWE000009','E000005','2019-06-23','2019-10-10','丝芙兰化妆品公司0009','在此期间取得非常好的绩效，赢得了客户的信赖0009','1'),
	('EWE000010','E000005','2019-01-16','2020-01-16','丝芙兰化妆品公司0010','在此期间取得非常好的绩效，赢得了客户的信赖0010','1'),
	('EWE000011','E000006','2020-12-17','2019-06-09','丝芙兰化妆品公司0011','在此期间取得非常好的绩效，赢得了客户的信赖0011','1'),
	('EWE000012','E000006','2020-01-06','2019-03-15','丝芙兰化妆品公司0012','在此期间取得非常好的绩效，赢得了客户的信赖0012','1'),
	('EWE000013','E000007','2019-02-16','2019-06-03','丝芙兰化妆品公司0013','在此期间取得非常好的绩效，赢得了客户的信赖0013','1'),
	('EWE000014','E000007','2020-12-06','2020-11-01','丝芙兰化妆品公司0014','在此期间取得非常好的绩效，赢得了客户的信赖0014','1'),
	('EWE000015','E000008','2020-06-29','2020-10-25','丝芙兰化妆品公司0015','在此期间取得非常好的绩效，赢得了客户的信赖0015','1'),
	('EWE000016','E000008','2020-06-24','2018-10-13','丝芙兰化妆品公司0016','在此期间取得非常好的绩效，赢得了客户的信赖0016','1'),
	('EWE000017','E000009','2020-12-03','2020-03-29','丝芙兰化妆品公司0017','在此期间取得非常好的绩效，赢得了客户的信赖0017','1'),
	('EWE000018','E000009','2019-12-19','2021-06-08','丝芙兰化妆品公司0018','在此期间取得非常好的绩效，赢得了客户的信赖0018','1'),
	('EWE000019','E000010','2021-07-22','2019-07-08','丝芙兰化妆品公司0019','在此期间取得非常好的绩效，赢得了客户的信赖0019','1'),
	('EWE000020','E000010','2021-08-28','2020-08-24','丝芙兰化妆品公司0020','在此期间取得非常好的绩效，赢得了客户的信赖0020','1'),
	('EWE000021','E000011','2021-03-21','2021-05-30','丝芙兰化妆品公司0021','在此期间取得非常好的绩效，赢得了客户的信赖0021','1'),
	('EWE000022','E000011','2020-12-11','2021-07-02','丝芙兰化妆品公司0022','在此期间取得非常好的绩效，赢得了客户的信赖0022','1'),
	('EWE000023','E000012','2021-03-02','2020-06-13','丝芙兰化妆品公司0023','在此期间取得非常好的绩效，赢得了客户的信赖0023','1'),
	('EWE000024','E000012','2019-10-11','2021-08-29','丝芙兰化妆品公司0024','在此期间取得非常好的绩效，赢得了客户的信赖0024','1'),
	('EWE000025','E000013','2021-04-03','2019-12-29','丝芙兰化妆品公司0025','在此期间取得非常好的绩效，赢得了客户的信赖0025','1'),
	('EWE000026','E000013','2020-01-10','2019-01-26','丝芙兰化妆品公司0026','在此期间取得非常好的绩效，赢得了客户的信赖0026','1'),
	('EWE000027','E000014','2020-05-16','2019-03-02','丝芙兰化妆品公司0027','在此期间取得非常好的绩效，赢得了客户的信赖0027','1'),
	('EWE000028','E000014','2020-05-09','2020-03-07','丝芙兰化妆品公司0028','在此期间取得非常好的绩效，赢得了客户的信赖0028','1'),
	('EWE000029','E000015','2020-01-26','2018-12-07','丝芙兰化妆品公司0029','在此期间取得非常好的绩效，赢得了客户的信赖0029','1'),
	('EWE000030','E000015','2020-04-11','2021-08-14','丝芙兰化妆品公司0030','在此期间取得非常好的绩效，赢得了客户的信赖0030','1'),
	('EWE000031','E000016','2019-12-27','2020-04-12','丝芙兰化妆品公司0031','在此期间取得非常好的绩效，赢得了客户的信赖0031','1'),
	('EWE000032','E000016','2020-01-22','2019-09-28','丝芙兰化妆品公司0032','在此期间取得非常好的绩效，赢得了客户的信赖0032','1');

insert into employee_leave_data values
	('EL000001','E000001','LT000001','8','请年假，出去耍！！！！0001','1'),
	('EL000002','E000001','LT000001','7','请年假，出去耍！！！！0002','1'),
	('EL000003','E000002','LT000001','8','请年假，出去耍！！！！0003','1'),
	('EL000004','E000002','LT000001','8','请年假，出去耍！！！！0004','1'),
	('EL000005','E000003','LT000001','7','请年假，出去耍！！！！0005','1'),
	('EL000006','E000003','LT000001','8','请年假，出去耍！！！！0006','1'),
	('EL000007','E000004','LT000001','8','请年假，出去耍！！！！0007','1'),
	('EL000008','E000004','LT000001','8','请年假，出去耍！！！！0008','1'),
	('EL000009','E000005','LT000001','6','请年假，出去耍！！！！0009','1'),
	('EL000010','E000005','LT000001','7','请年假，出去耍！！！！0010','1'),
	('EL000011','E000006','LT000001','7','请年假，出去耍！！！！0011','1'),
	('EL000012','E000006','LT000001','6','请年假，出去耍！！！！0012','1'),
	('EL000013','E000007','LT000001','7','请年假，出去耍！！！！0013','1'),
	('EL000014','E000007','LT000001','7','请年假，出去耍！！！！0014','1'),
	('EL000015','E000008','LT000001','7','请年假，出去耍！！！！0015','1'),
	('EL000016','E000008','LT000001','7','请年假，出去耍！！！！0016','1'),
	('EL000017','E000009','LT000002','6','请年假，出去耍！！！！0017','1'),
	('EL000018','E000009','LT000002','8','请年假，出去耍！！！！0018','1'),
	('EL000019','E000010','LT000002','7','请年假，出去耍！！！！0019','1'),
	('EL000020','E000010','LT000002','8','请年假，出去耍！！！！0020','1'),
	('EL000021','E000011','LT000002','6','请年假，出去耍！！！！0021','1'),
	('EL000022','E000011','LT000002','7','请年假，出去耍！！！！0022','1'),
	('EL000023','E000012','LT000002','7','请年假，出去耍！！！！0023','1'),
	('EL000024','E000012','LT000002','7','请年假，出去耍！！！！0024','1'),
	('EL000025','E000013','LT000002','8','请年假，出去耍！！！！0025','1'),
	('EL000026','E000013','LT000002','8','请年假，出去耍！！！！0026','1'),
	('EL000027','E000014','LT000002','7','请年假，出去耍！！！！0027','1'),
	('EL000028','E000014','LT000002','8','请年假，出去耍！！！！0028','1'),
	('EL000029','E000015','LT000002','8','请年假，出去耍！！！！0029','1'),
	('EL000030','E000015','LT000002','7','请年假，出去耍！！！！0030','1'),
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
	('EA000001','E000001','2020-12-19','2019-03-13','8','今天状态不错啊0001','1'),
	('EA000002','E000001','2019-08-16','2019-10-09','8','今天状态不错啊0002','1'),
	('EA000003','E000002','2021-03-14','2019-11-30','7','今天状态不错啊0003','1'),
	('EA000004','E000002','2019-12-28','2019-05-14','7','今天状态不错啊0004','1'),
	('EA000005','E000003','2020-01-11','2019-06-17','7','今天状态不错啊0005','1'),
	('EA000006','E000003','2020-10-11','2021-05-02','8','今天状态不错啊0006','1'),
	('EA000007','E000004','2019-09-23','2020-01-23','7','今天状态不错啊0007','1'),
	('EA000008','E000004','2019-09-04','2021-08-02','7','今天状态不错啊0008','1'),
	('EA000009','E000005','2020-10-11','2020-04-13','7','今天状态不错啊0009','1'),
	('EA000010','E000005','2019-03-16','2019-10-24','7','今天状态不错啊0010','1'),
	('EA000011','E000006','2019-08-15','2020-05-26','8','今天状态不错啊0011','1'),
	('EA000012','E000006','2021-06-18','2019-12-26','8','今天状态不错啊0012','1'),
	('EA000013','E000007','2021-06-15','2021-02-22','6','今天状态不错啊0013','1'),
	('EA000014','E000007','2021-07-09','2018-10-01','8','今天状态不错啊0014','1'),
	('EA000015','E000008','2021-02-28','2018-10-05','6','今天状态不错啊0015','1'),
	('EA000016','E000008','2019-07-08','2020-11-20','6','今天状态不错啊0016','1'),
	('EA000017','E000009','2021-03-17','2021-08-18','6','今天状态不错啊0017','1'),
	('EA000018','E000009','2020-01-16','2020-03-25','7','今天状态不错啊0018','1'),
	('EA000019','E000010','2019-11-14','2018-10-15','8','今天状态不错啊0019','1'),
	('EA000020','E000010','2019-10-14','2020-12-20','7','今天状态不错啊0020','1'),
	('EA000021','E000011','2020-07-05','2020-03-14','7','今天状态不错啊0021','1'),
	('EA000022','E000011','2020-08-01','2020-04-06','8','今天状态不错啊0022','1'),
	('EA000023','E000012','2019-10-25','2020-05-28','7','今天状态不错啊0023','1'),
	('EA000024','E000012','2019-11-17','2019-07-04','7','今天状态不错啊0024','1'),
	('EA000025','E000013','2021-03-15','2021-06-01','7','今天状态不错啊0025','1'),
	('EA000026','E000013','2020-01-17','2021-05-22','8','今天状态不错啊0026','1'),
	('EA000027','E000014','2020-10-12','2019-11-17','8','今天状态不错啊0027','1'),
	('EA000028','E000014','2021-07-18','2019-05-02','8','今天状态不错啊0028','1'),
	('EA000029','E000015','2019-03-16','2019-07-17','8','今天状态不错啊0029','1'),
	('EA000030','E000015','2019-03-30','2019-03-10','7','今天状态不错啊0030','1'),
	('EA000031','E000016','2018-09-22','2020-11-25','8','今天状态不错啊0031','1'),
	('EA000032','E000016','2018-11-10','2020-03-28','7','今天状态不错啊0032','1');

insert into employee_qualifier_data values
	('EQ000001','E000001','2021-01-20','认证药剂师','高级','考试成绩当年第一名0001','1'),
	('EQ000002','E000001','2020-05-11','认证架构师','中级','考试成绩当年第一名0002','1'),
	('EQ000003','E000002','2018-09-15','认证会计师','初级','考试成绩当年第一名0003','1'),
	('EQ000004','E000002','2021-02-27','认证经济师','高级','考试成绩当年第一名0004','1'),
	('EQ000005','E000003','2020-10-31','OCP','中级','考试成绩当年第一名0005','1'),
	('EQ000006','E000003','2020-07-02','CCNA','初级','考试成绩当年第一名0006','1'),
	('EQ000007','E000004','2019-07-19','CCNP','高级','考试成绩当年第一名0007','1'),
	('EQ000008','E000004','2021-08-24','认证药剂师','中级','考试成绩当年第一名0008','1'),
	('EQ000009','E000005','2020-04-25','认证架构师','初级','考试成绩当年第一名0009','1'),
	('EQ000010','E000005','2019-08-08','认证会计师','高级','考试成绩当年第一名0010','1'),
	('EQ000011','E000006','2018-11-25','认证经济师','中级','考试成绩当年第一名0011','1'),
	('EQ000012','E000006','2019-09-23','OCP','初级','考试成绩当年第一名0012','1'),
	('EQ000013','E000007','2020-02-26','CCNA','高级','考试成绩当年第一名0013','1'),
	('EQ000014','E000007','2020-08-17','CCNP','中级','考试成绩当年第一名0014','1'),
	('EQ000015','E000008','2021-08-28','认证药剂师','初级','考试成绩当年第一名0015','1'),
	('EQ000016','E000008','2020-07-28','认证架构师','高级','考试成绩当年第一名0016','1'),
	('EQ000017','E000009','2020-02-09','认证会计师','中级','考试成绩当年第一名0017','1'),
	('EQ000018','E000009','2020-07-26','认证经济师','初级','考试成绩当年第一名0018','1'),
	('EQ000019','E000010','2020-08-13','OCP','高级','考试成绩当年第一名0019','1'),
	('EQ000020','E000010','2019-01-09','CCNA','中级','考试成绩当年第一名0020','1'),
	('EQ000021','E000011','2020-12-27','CCNP','初级','考试成绩当年第一名0021','1'),
	('EQ000022','E000011','2020-04-24','认证药剂师','高级','考试成绩当年第一名0022','1'),
	('EQ000023','E000012','2018-12-24','认证架构师','中级','考试成绩当年第一名0023','1'),
	('EQ000024','E000012','2020-07-04','认证会计师','初级','考试成绩当年第一名0024','1'),
	('EQ000025','E000013','2020-06-01','认证经济师','高级','考试成绩当年第一名0025','1'),
	('EQ000026','E000013','2019-09-23','OCP','中级','考试成绩当年第一名0026','1'),
	('EQ000027','E000014','2021-01-17','CCNA','初级','考试成绩当年第一名0027','1'),
	('EQ000028','E000014','2018-11-26','CCNP','高级','考试成绩当年第一名0028','1'),
	('EQ000029','E000015','2020-08-01','认证药剂师','中级','考试成绩当年第一名0029','1'),
	('EQ000030','E000015','2020-12-21','认证架构师','初级','考试成绩当年第一名0030','1'),
	('EQ000031','E000016','2018-11-17','认证会计师','高级','考试成绩当年第一名0031','1'),
	('EQ000032','E000016','2021-04-01','认证经济师','中级','考试成绩当年第一名0032','1');

insert into employee_education_data values
	('EE000001','E000001','2021-02-23','小学','考试成绩当年第一名0001','1'),
	('EE000002','E000001','2019-02-15','初中','考试成绩当年第一名0002','1'),
	('EE000003','E000002','2020-03-14','高中','考试成绩当年第一名0003','1'),
	('EE000004','E000002','2021-05-28','大学','考试成绩当年第一名0004','1'),
	('EE000005','E000003','2021-08-27','硕士','考试成绩当年第一名0005','1'),
	('EE000006','E000003','2021-01-10','博士','考试成绩当年第一名0006','1'),
	('EE000007','E000004','2020-09-18','职业教育','考试成绩当年第一名0007','1'),
	('EE000008','E000004','2020-05-16','小学','考试成绩当年第一名0008','1'),
	('EE000009','E000005','2019-09-14','初中','考试成绩当年第一名0009','1'),
	('EE000010','E000005','2019-09-04','高中','考试成绩当年第一名0010','1'),
	('EE000011','E000006','2019-06-15','大学','考试成绩当年第一名0011','1'),
	('EE000012','E000006','2020-08-02','硕士','考试成绩当年第一名0012','1'),
	('EE000013','E000007','2019-04-24','博士','考试成绩当年第一名0013','1'),
	('EE000014','E000007','2020-10-09','职业教育','考试成绩当年第一名0014','1'),
	('EE000015','E000008','2019-07-18','小学','考试成绩当年第一名0015','1'),
	('EE000016','E000008','2020-08-10','初中','考试成绩当年第一名0016','1'),
	('EE000017','E000009','2020-09-02','高中','考试成绩当年第一名0017','1'),
	('EE000018','E000009','2019-12-26','大学','考试成绩当年第一名0018','1'),
	('EE000019','E000010','2021-04-15','硕士','考试成绩当年第一名0019','1'),
	('EE000020','E000010','2021-09-02','博士','考试成绩当年第一名0020','1'),
	('EE000021','E000011','2021-08-30','职业教育','考试成绩当年第一名0021','1'),
	('EE000022','E000011','2019-01-16','小学','考试成绩当年第一名0022','1'),
	('EE000023','E000012','2021-01-04','初中','考试成绩当年第一名0023','1'),
	('EE000024','E000012','2021-01-06','高中','考试成绩当年第一名0024','1'),
	('EE000025','E000013','2019-03-01','大学','考试成绩当年第一名0025','1'),
	('EE000026','E000013','2021-04-03','硕士','考试成绩当年第一名0026','1'),
	('EE000027','E000014','2019-09-02','博士','考试成绩当年第一名0027','1'),
	('EE000028','E000014','2020-06-30','职业教育','考试成绩当年第一名0028','1'),
	('EE000029','E000015','2019-05-15','小学','考试成绩当年第一名0029','1'),
	('EE000030','E000015','2019-02-18','初中','考试成绩当年第一名0030','1'),
	('EE000031','E000016','2019-09-15','高中','考试成绩当年第一名0031','1'),
	('EE000032','E000016','2020-11-05','大学','考试成绩当年第一名0032','1');

insert into employee_award_data values
	('EA000001','E000001','2018-11-04','明星员工','考试成绩当年第一名0001','1'),
	('EA000002','E000001','2021-06-25','销售之星','考试成绩当年第一名0002','1'),
	('EA000003','E000002','2019-02-01','技术之星','考试成绩当年第一名0003','1'),
	('EA000004','E000002','2018-12-03','管理之星','考试成绩当年第一名0004','1'),
	('EA000005','E000003','2021-03-11','终身成就奖','考试成绩当年第一名0005','1'),
	('EA000006','E000003','2020-02-02','明星员工','考试成绩当年第一名0006','1'),
	('EA000007','E000004','2019-11-22','销售之星','考试成绩当年第一名0007','1'),
	('EA000008','E000004','2020-08-25','技术之星','考试成绩当年第一名0008','1'),
	('EA000009','E000005','2020-09-17','管理之星','考试成绩当年第一名0009','1'),
	('EA000010','E000005','2019-01-26','终身成就奖','考试成绩当年第一名0010','1'),
	('EA000011','E000006','2019-03-18','明星员工','考试成绩当年第一名0011','1'),
	('EA000012','E000006','2020-09-19','销售之星','考试成绩当年第一名0012','1'),
	('EA000013','E000007','2021-05-31','技术之星','考试成绩当年第一名0013','1'),
	('EA000014','E000007','2021-04-14','管理之星','考试成绩当年第一名0014','1'),
	('EA000015','E000008','2019-06-23','终身成就奖','考试成绩当年第一名0015','1'),
	('EA000016','E000008','2020-12-20','明星员工','考试成绩当年第一名0016','1'),
	('EA000017','E000009','2021-04-13','销售之星','考试成绩当年第一名0017','1'),
	('EA000018','E000009','2019-07-13','技术之星','考试成绩当年第一名0018','1'),
	('EA000019','E000010','2019-09-29','管理之星','考试成绩当年第一名0019','1'),
	('EA000020','E000010','2019-02-10','终身成就奖','考试成绩当年第一名0020','1'),
	('EA000021','E000011','2020-08-06','明星员工','考试成绩当年第一名0021','1'),
	('EA000022','E000011','2020-12-08','销售之星','考试成绩当年第一名0022','1'),
	('EA000023','E000012','2019-08-09','技术之星','考试成绩当年第一名0023','1'),
	('EA000024','E000012','2019-10-04','管理之星','考试成绩当年第一名0024','1'),
	('EA000025','E000013','2020-07-10','终身成就奖','考试成绩当年第一名0025','1'),
	('EA000026','E000013','2018-11-29','明星员工','考试成绩当年第一名0026','1'),
	('EA000027','E000014','2019-11-10','销售之星','考试成绩当年第一名0027','1'),
	('EA000028','E000014','2020-12-23','技术之星','考试成绩当年第一名0028','1'),
	('EA000029','E000015','2021-01-22','管理之星','考试成绩当年第一名0029','1'),
	('EA000030','E000015','2019-12-14','终身成就奖','考试成绩当年第一名0030','1'),
	('EA000031','E000016','2021-03-11','明星员工','考试成绩当年第一名0031','1'),
	('EA000032','E000016','2019-04-05','销售之星','考试成绩当年第一名0032','1');

insert into employee_salary_sheet_data values
	('ESS000001','E000001','SG000001','2650.01','957.90','836.71','579.03','835.33','1152.12','6.50','PO000001','1'),
	('ESS000002','E000001','SG000001','2287.75','761.23','846.04','753.14','962.17','969.23','7.18','PO000001','1'),
	('ESS000003','E000001','SG000001','2423.37','710.14','880.88','720.27','989.92','916.85','7.91','PO000002','1'),
	('ESS000004','E000001','SG000001','2535.59','975.05','758.84','573.35','826.40','856.82','8.61','PO000002','1'),
	('ESS000005','E000002','SG000001','2955.58','947.72','904.49','598.32','1030.52','1014.89','7.91','PO000003','1'),
	('ESS000006','E000002','SG000001','2726.08','723.92','848.37','663.18','1075.59','1024.15','7.12','PO000003','1'),
	('ESS000007','E000002','SG000001','2601.13','770.97','966.09','622.28','945.58','1065.53','8.20','PO000004','1'),
	('ESS000008','E000002','SG000001','2221.82','993.43','927.83','621.10','936.29','886.86','8.27','PO000004','1'),
	('ESS000009','E000003','SG000001','2282.58','963.87','866.19','725.07','933.44','1090.67','6.88','PO000005','1'),
	('ESS000010','E000003','SG000001','2917.89','821.32','942.28','558.60','794.41','1101.02','8.24','PO000005','1'),
	('ESS000011','E000003','SG000001','2631.67','806.40','880.75','785.91','869.66','1143.27','7.17','PO000006','1'),
	('ESS000012','E000003','SG000001','2456.76','804.07','908.10','561.30','841.39','1213.02','7.93','PO000006','1'),
	('ESS000013','E000004','SG000001','2615.62','799.55','892.16','676.48','991.76','977.75','7.40','PO000007','1'),
	('ESS000014','E000004','SG000001','2659.32','843.86','849.99','689.03','819.65','923.42','8.72','PO000007','1'),
	('ESS000015','E000004','SG000001','2405.39','798.17','940.63','780.03','1036.22','1066.58','6.75','PO000008','1'),
	('ESS000016','E000004','SG000001','2501.23','999.10','768.13','705.26','950.58','946.71','6.78','PO000008','1'),
	('ESS000017','E000005','SG000001','2326.96','743.31','981.41','744.48','812.61','1199.82','8.01','PO000009','1'),
	('ESS000018','E000005','SG000001','2491.42','720.83','780.89','750.61','987.07','983.21','8.47','PO000009','1'),
	('ESS000019','E000005','SG000001','2600.75','713.11','976.21','697.70','834.93','1020.53','6.65','PO000010','1'),
	('ESS000020','E000005','SG000001','2816.39','857.09','970.63','630.59','1073.48','881.42','8.74','PO000010','1'),
	('ESS000021','E000006','SG000001','2133.67','952.19','997.08','700.18','838.13','1008.16','6.53','PO000011','1'),
	('ESS000022','E000006','SG000001','2735.62','729.92','949.17','572.64','1050.69','1034.69','8.45','PO000011','1'),
	('ESS000023','E000006','SG000001','2143.07','758.96','928.51','642.69','1013.95','1144.36','7.51','PO000012','1'),
	('ESS000024','E000006','SG000001','2106.78','831.87','776.39','762.27','910.50','1156.86','7.99','PO000012','1'),
	('ESS000025','E000007','SG000001','2742.44','985.50','718.91','629.12','808.79','967.64','7.18','PO000013','1'),
	('ESS000026','E000007','SG000001','2554.91','710.84','943.35','677.81','996.13','917.41','7.31','PO000013','1'),
	('ESS000027','E000007','SG000001','2483.04','845.69','727.84','622.23','998.20','1199.42','8.29','PO000014','1'),
	('ESS000028','E000007','SG000001','2129.53','786.58','839.00','694.83','836.42','992.34','6.38','PO000014','1'),
	('ESS000029','E000008','SG000001','2867.28','713.22','911.38','726.59','1032.70','1067.12','6.24','PO000015','1'),
	('ESS000030','E000008','SG000001','2127.65','750.23','788.16','707.66','1050.46','999.10','6.64','PO000015','1'),
	('ESS000031','E000008','SG000001','2522.09','973.47','781.18','571.76','990.15','998.64','7.43','PO000016','1'),
	('ESS000032','E000008','SG000001','2438.98','782.71','890.05','735.59','1058.23','1182.36','7.90','PO000016','1'),
	('ESS000033','E000009','SG000002','2356.87','750.85','903.38','582.12','1077.27','1012.90','6.60','PO000017','1'),
	('ESS000034','E000009','SG000002','2746.67','794.06','732.99','685.69','862.28','1050.70','7.96','PO000017','1'),
	('ESS000035','E000009','SG000002','2834.09','966.26','790.34','753.16','1078.63','941.71','6.44','PO000018','1'),
	('ESS000036','E000009','SG000002','2121.63','846.25','870.57','702.52','976.13','1140.11','7.80','PO000018','1'),
	('ESS000037','E000010','SG000002','2134.19','856.51','796.13','710.92','851.26','1124.12','6.50','PO000019','1'),
	('ESS000038','E000010','SG000002','2774.79','906.53','741.80','754.68','810.67','1153.16','8.15','PO000019','1'),
	('ESS000039','E000010','SG000002','2819.04','866.12','891.42','703.82','948.27','1172.90','8.41','PO000020','1'),
	('ESS000040','E000010','SG000002','2101.02','868.48','915.03','614.65','1074.66','1032.68','7.25','PO000020','1'),
	('ESS000041','E000011','SG000002','2933.84','758.33','956.19','771.26','882.43','1037.60','8.33','PO000021','1'),
	('ESS000042','E000011','SG000002','2795.64','927.22','747.57','771.78','880.58','881.85','7.55','PO000021','1'),
	('ESS000043','E000011','SG000002','2777.57','994.94','945.32','737.04','1091.42','960.73','8.35','PO000022','1'),
	('ESS000044','E000011','SG000002','2557.95','956.52','843.24','655.02','979.89','1036.71','8.73','PO000022','1'),
	('ESS000045','E000012','SG000002','2420.49','757.66','714.35','724.46','963.65','1080.98','8.53','PO000023','1'),
	('ESS000046','E000012','SG000002','2497.14','984.73','768.00','565.56','1081.18','1035.37','7.71','PO000023','1'),
	('ESS000047','E000012','SG000002','2113.07','979.87','921.48','630.53','896.45','1020.74','8.37','PO000024','1'),
	('ESS000048','E000012','SG000002','2818.46','926.92','761.03','734.06','792.49','1094.55','6.45','PO000024','1'),
	('ESS000049','E000013','SG000002','2185.62','778.69','977.11','570.73','988.71','904.10','6.33','PO000025','1'),
	('ESS000050','E000013','SG000002','2814.82','701.65','761.09','701.07','956.03','1084.03','8.49','PO000025','1'),
	('ESS000051','E000013','SG000002','2252.30','824.91','700.54','556.55','1086.54','1124.44','6.68','PO000026','1'),
	('ESS000052','E000013','SG000002','2408.96','937.44','712.36','766.45','917.56','1009.60','7.40','PO000026','1'),
	('ESS000053','E000014','SG000002','2947.85','907.80','963.02','715.44','862.84','1026.29','7.31','PO000027','1'),
	('ESS000054','E000014','SG000002','2641.57','875.74','927.38','596.79','1075.33','1170.21','6.95','PO000027','1'),
	('ESS000055','E000014','SG000002','2824.60','893.53','777.04','731.84','841.05','882.81','6.24','PO000028','1'),
	('ESS000056','E000014','SG000002','2465.54','874.04','765.27','682.28','938.04','995.57','8.00','PO000028','1'),
	('ESS000057','E000015','SG000002','2328.54','983.83','907.05','655.88','959.15','968.74','7.58','PO000029','1'),
	('ESS000058','E000015','SG000002','2581.93','842.59','740.30','776.02','1095.59','1195.95','7.30','PO000029','1'),
	('ESS000059','E000015','SG000002','2255.40','947.17','970.69','571.66','881.57','962.64','7.05','PO000030','1'),
	('ESS000060','E000015','SG000002','2812.91','855.29','849.61','647.86','815.25','1018.44','6.48','PO000030','1'),
	('ESS000061','E000016','SG000002','2333.88','967.04','825.33','649.74','895.29','1025.01','7.22','PO000031','1'),
	('ESS000062','E000016','SG000002','2488.98','819.25','708.92','619.71','1017.95','1085.41','7.49','PO000031','1'),
	('ESS000063','E000016','SG000002','2710.20','961.56','954.60','573.23','989.65','1143.70','7.73','PO000032','1'),
	('ESS000064','E000016','SG000002','2497.87','782.80','797.81','786.06','916.74','1146.28','8.39','PO000032','1');

insert into paying_off_data values
	('PO000001','出纳0001','E000001','2018-11-09','4317.00','1'),
	('PO000002','出纳0002','E000001','2021-08-17','5203.54','1'),
	('PO000003','出纳0003','E000002','2020-06-06','4330.93','1'),
	('PO000004','出纳0004','E000002','2020-10-01','5180.14','1'),
	('PO000005','出纳0005','E000003','2018-10-10','3892.05','1'),
	('PO000006','出纳0006','E000003','2019-06-21','3674.71','1'),
	('PO000007','出纳0007','E000004','2020-11-30','4566.14','1'),
	('PO000008','出纳0008','E000004','2021-06-15','4260.36','1'),
	('PO000009','出纳0009','E000005','2020-11-24','4863.75','1'),
	('PO000010','出纳0010','E000005','2019-10-09','3935.14','1'),
	('PO000011','出纳0011','E000006','2019-11-13','4477.60','1'),
	('PO000012','出纳0012','E000006','2019-02-24','4541.60','1'),
	('PO000013','出纳0013','E000007','2020-11-15','4139.70','1'),
	('PO000014','出纳0014','E000007','2019-11-24','4496.29','1'),
	('PO000015','出纳0015','E000008','2021-07-06','4415.79','1'),
	('PO000016','出纳0016','E000008','2018-10-17','4085.05','1'),
	('PO000017','出纳0017','E000009','2018-12-18','4372.84','1'),
	('PO000018','出纳0018','E000009','2019-10-15','4925.20','1'),
	('PO000019','出纳0019','E000010','2019-03-18','4303.56','1'),
	('PO000020','出纳0020','E000010','2019-10-01','3777.52','1'),
	('PO000021','出纳0021','E000011','2019-09-04','5200.47','1'),
	('PO000022','出纳0022','E000011','2019-11-20','3754.40','1'),
	('PO000023','出纳0023','E000012','2020-07-18','4349.07','1'),
	('PO000024','出纳0024','E000012','2020-11-16','4353.39','1'),
	('PO000025','出纳0025','E000013','2020-07-02','4987.62','1'),
	('PO000026','出纳0026','E000013','2019-01-08','5051.92','1'),
	('PO000027','出纳0027','E000014','2021-08-01','3832.88','1'),
	('PO000028','出纳0028','E000014','2019-01-22','3711.49','1'),
	('PO000029','出纳0029','E000015','2020-03-27','4963.61','1'),
	('PO000030','出纳0030','E000015','2019-08-11','3893.92','1'),
	('PO000031','出纳0031','E000016','2019-07-22','4550.23','1'),
	('PO000032','出纳0032','E000016','2019-05-08','4535.81','1');

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
	fk4biz_order_of_000002 foreign key (biz_order) references consumer_order_data(id) ON DELETE CASCADE ON UPDATE CASCADE;

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
create  index idx9306172130351879 on retail_store_member_gift_card_consume_record_data (occure_time);
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











