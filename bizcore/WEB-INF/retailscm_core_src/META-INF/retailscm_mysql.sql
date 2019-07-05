

-- BUILD WITH MODEL TIME 190613T1817
drop database  if exists retailscm;
create database retailscm;
-- alter  database retailscm  character set = utf8mb4  collate = utf8mb4_unicode_ci; -- 支持表情符号
use retailscm;

drop table  if exists retail_store_country_center_data;
create table retail_store_country_center_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(44)                              comment 'Name',
	service_number                	varchar(36)                              comment 'Service Number',
	founded                       	date                                     comment 'Founded',
	web_site                      	varchar(128)                             comment 'Web Site',
	address                       	varchar(56)                              comment 'Address',
	operated_by                   	varchar(16)                              comment 'Operated By',
	legal_representative          	varchar(12)                              comment 'Legal Representative',
	description                   	varchar(52)                              comment 'Description',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Retail Store Country Center";

drop table  if exists catalog_data;
create table catalog_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(16)                              comment 'Name',
	owner                         	varchar(48)                              comment 'Owner',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Catalog";

drop table  if exists level_one_category_data;
create table level_one_category_data (
	id                            	varchar(48)          not null            comment 'Id',
	catalog                       	varchar(48)                              comment 'Catalog',
	name                          	varchar(16)                              comment 'Name',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Level One Category";

drop table  if exists level_two_category_data;
create table level_two_category_data (
	id                            	varchar(48)          not null            comment 'Id',
	parent_category               	varchar(48)                              comment 'Parent Category',
	name                          	varchar(16)                              comment 'Name',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Level Two Category";

drop table  if exists level_three_category_data;
create table level_three_category_data (
	id                            	varchar(48)          not null            comment 'Id',
	parent_category               	varchar(48)                              comment 'Parent Category',
	name                          	varchar(16)                              comment 'Name',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Level Three Category";

drop table  if exists product_data;
create table product_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(12)                              comment 'Name',
	parent_category               	varchar(48)                              comment 'Parent Category',
	origin                        	varchar(8)                               comment 'Origin',
	remark                        	varchar(88)                              comment 'Remark',
	brand                         	varchar(92)                              comment 'Brand',
	picture                       	varchar(512) CHARACTER SET ascii COLLATE ascii_general_ci                     comment 'Picture',
	last_update_time              	datetime                                 comment 'Last Update Time',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Product";

drop table  if exists sku_data;
create table sku_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(24)                              comment 'Name',
	size                          	varchar(4)                               comment 'Size',
	product                       	varchar(48)                              comment 'Product',
	barcode                       	varchar(52)                              comment 'Barcode',
	package_type                  	varchar(16)                              comment 'Package Type',
	net_content                   	varchar(92)                              comment 'Net Content',
	price                         	numeric(8,2)                             comment 'Price',
	picture                       	varchar(512) CHARACTER SET ascii COLLATE ascii_general_ci                     comment 'Picture',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Sku";

drop table  if exists retail_store_province_center_data;
create table retail_store_province_center_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(44)                              comment 'Name',
	founded                       	date                                     comment 'Founded',
	country                       	varchar(48)                              comment 'Country',
	last_update_time              	datetime                                 comment 'Last Update Time',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Retail Store Province Center";

drop table  if exists province_center_department_data;
create table province_center_department_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(20)                              comment 'Name',
	founded                       	date                                     comment 'Founded',
	province_center               	varchar(48)                              comment 'Province Center',
	manager                       	varchar(12)                              comment 'Manager',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Province Center Department";

drop table  if exists province_center_employee_data;
create table province_center_employee_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(12)                              comment 'Name',
	mobile                        	varchar(44)                              comment 'Mobile',
	email                         	varchar(256)                             comment 'Email',
	founded                       	date                                     comment 'Founded',
	department                    	varchar(48)                              comment 'Department',
	province_center               	varchar(48)                              comment 'Province Center',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Province Center Employee";

drop table  if exists retail_store_city_service_center_data;
create table retail_store_city_service_center_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(36)                              comment 'Name',
	founded                       	date                                     comment 'Founded',
	belongs_to                    	varchar(48)                              comment 'Belongs To',
	last_update_time              	datetime                                 comment 'Last Update Time',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Retail Store City Service Center";

drop table  if exists city_partner_data;
create table city_partner_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(12)                              comment 'Name',
	mobile                        	varchar(44)                              comment 'Mobile',
	city_service_center           	varchar(48)                              comment 'City Service Center',
	description                   	varchar(64)                              comment 'Description',
	last_update_time              	datetime                                 comment 'Last Update Time',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "City Partner";

drop table  if exists potential_customer_data;
create table potential_customer_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(12)                              comment 'Name',
	mobile                        	varchar(44)                              comment 'Mobile',
	city_service_center           	varchar(48)                              comment 'City Service Center',
	city_partner                  	varchar(48)                              comment 'City Partner',
	description                   	varchar(64)                              comment 'Description',
	last_update_time              	datetime                                 comment 'Last Update Time',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Potential Customer";

drop table  if exists potential_customer_contact_person_data;
create table potential_customer_contact_person_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(12)                              comment 'Name',
	mobile                        	varchar(44)                              comment 'Mobile',
	potential_customer            	varchar(48)                              comment 'Potential Customer',
	description                   	varchar(96)                              comment 'Description',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Potential Customer Contact Person";

drop table  if exists potential_customer_contact_data;
create table potential_customer_contact_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(40)                              comment 'Name',
	contact_date                  	date                                     comment 'Contact Date',
	contact_method                	varchar(16)                              comment 'Contact Method',
	potential_customer            	varchar(48)                              comment 'Potential Customer',
	city_partner                  	varchar(48)                              comment 'City Partner',
	contact_to                    	varchar(48)                              comment 'Contact To',
	description                   	varchar(24)                              comment 'Description',
	last_update_time              	datetime                                 comment 'Last Update Time',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Potential Customer Contact";

drop table  if exists city_event_data;
create table city_event_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(28)                              comment 'Name',
	mobile                        	varchar(44)                              comment 'Mobile',
	city_service_center           	varchar(48)                              comment 'City Service Center',
	description                   	varchar(48)                              comment 'Description',
	last_update_time              	datetime                                 comment 'Last Update Time',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "City Event";

drop table  if exists event_attendance_data;
create table event_attendance_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(36)                              comment 'Name',
	potential_customer            	varchar(48)                              comment 'Potential Customer',
	city_event                    	varchar(48)                              comment 'City Event',
	description                   	varchar(36)                              comment 'Description',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Event Attendance";

drop table  if exists retail_store_data;
create table retail_store_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(24)                              comment 'Name',
	telephone                     	varchar(44)                              comment 'Telephone',
	owner                         	varchar(8)                               comment 'Owner',
	retail_store_country_center   	varchar(48)                              comment 'Retail Store Country Center',
	city_service_center           	varchar(48)                              comment 'City Service Center',
	creation                      	varchar(48)                              comment 'Creation',
	investment_invitation         	varchar(48)                              comment 'Investment Invitation',
	franchising                   	varchar(48)                              comment 'Franchising',
	decoration                    	varchar(48)                              comment 'Decoration',
	opening                       	varchar(48)                              comment 'Opening',
	closing                       	varchar(48)                              comment 'Closing',
	founded                       	date                                     comment 'Founded',
	latitude                      	numeric(9,6)                             comment 'Latitude',
	longitude                     	numeric(10,6)                            comment 'Longitude',
	description                   	varchar(84)                              comment 'Description',
	last_update_time              	datetime                                 comment 'Last Update Time',
	current_status                	varchar(72)                              comment 'Current Status',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Retail Store";

drop table  if exists retail_store_creation_data;
create table retail_store_creation_data (
	id                            	varchar(48)          not null            comment 'Id',
	comment                       	varchar(20)                              comment 'Comment',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Retail Store Creation";

drop table  if exists retail_store_investment_invitation_data;
create table retail_store_investment_invitation_data (
	id                            	varchar(48)          not null            comment 'Id',
	comment                       	varchar(24)                              comment 'Comment',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Retail Store Investment Invitation";

drop table  if exists retail_store_franchising_data;
create table retail_store_franchising_data (
	id                            	varchar(48)          not null            comment 'Id',
	comment                       	varchar(16)                              comment 'Comment',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Retail Store Franchising";

drop table  if exists retail_store_decoration_data;
create table retail_store_decoration_data (
	id                            	varchar(48)          not null            comment 'Id',
	comment                       	varchar(8)                               comment 'Comment',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Retail Store Decoration";

drop table  if exists retail_store_opening_data;
create table retail_store_opening_data (
	id                            	varchar(48)          not null            comment 'Id',
	comment                       	varchar(8)                               comment 'Comment',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Retail Store Opening";

drop table  if exists retail_store_closing_data;
create table retail_store_closing_data (
	id                            	varchar(48)          not null            comment 'Id',
	comment                       	varchar(8)                               comment 'Comment',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Retail Store Closing";

drop table  if exists retail_store_member_data;
create table retail_store_member_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(12)                              comment 'Name',
	mobile_phone                  	varchar(44)                              comment 'Mobile Phone',
	owner                         	varchar(48)                              comment 'Owner',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Retail Store Member";

drop table  if exists consumer_order_data;
create table consumer_order_data (
	id                            	varchar(48)          not null            comment 'Id',
	title                         	varchar(16)                              comment 'Title',
	consumer                      	varchar(48)                              comment 'Consumer',
	confirmation                  	varchar(48)                              comment 'Confirmation',
	approval                      	varchar(48)                              comment 'Approval',
	processing                    	varchar(48)                              comment 'Processing',
	shipment                      	varchar(48)                              comment 'Shipment',
	delivery                      	varchar(48)                              comment 'Delivery',
	store                         	varchar(48)                              comment 'Store',
	last_update_time              	datetime                                 comment 'Last Update Time',
	current_status                	varchar(36)                              comment 'Current Status',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Consumer Order";

drop table  if exists consumer_order_confirmation_data;
create table consumer_order_confirmation_data (
	id                            	varchar(48)          not null            comment 'Id',
	who                           	varchar(12)                              comment 'Who',
	confirm_time                  	date                                     comment 'Confirm Time',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Consumer Order Confirmation";

drop table  if exists consumer_order_approval_data;
create table consumer_order_approval_data (
	id                            	varchar(48)          not null            comment 'Id',
	who                           	varchar(12)                              comment 'Who',
	approve_time                  	date                                     comment 'Approve Time',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Consumer Order Approval";

drop table  if exists consumer_order_processing_data;
create table consumer_order_processing_data (
	id                            	varchar(48)          not null            comment 'Id',
	who                           	varchar(12)                              comment 'Who',
	process_time                  	date                                     comment 'Process Time',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Consumer Order Processing";

drop table  if exists consumer_order_shipment_data;
create table consumer_order_shipment_data (
	id                            	varchar(48)          not null            comment 'Id',
	who                           	varchar(12)                              comment 'Who',
	ship_time                     	date                                     comment 'Ship Time',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Consumer Order Shipment";

drop table  if exists consumer_order_delivery_data;
create table consumer_order_delivery_data (
	id                            	varchar(48)          not null            comment 'Id',
	who                           	varchar(12)                              comment 'Who',
	delivery_time                 	date                                     comment 'Delivery Time',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Consumer Order Delivery";

drop table  if exists consumer_order_line_item_data;
create table consumer_order_line_item_data (
	id                            	varchar(48)          not null            comment 'Id',
	biz_order                     	varchar(48)                              comment 'Biz Order',
	sku_id                        	varchar(12)                              comment 'Sku Id',
	sku_name                      	varchar(16)                              comment 'Sku Name',
	price                         	numeric(5,2)                             comment 'Price',
	quantity                      	numeric(7,2)                             comment 'Quantity',
	amount                        	numeric(8,2)                             comment 'Amount',
	last_update_time              	datetime                                 comment 'Last Update Time',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Consumer Order Line Item";

drop table  if exists consumer_order_shipping_group_data;
create table consumer_order_shipping_group_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(24)                              comment 'Name',
	biz_order                     	varchar(48)                              comment 'Biz Order',
	amount                        	numeric(7,2)                             comment 'Amount',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Consumer Order Shipping Group";

drop table  if exists consumer_order_payment_group_data;
create table consumer_order_payment_group_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(16)                              comment 'Name',
	biz_order                     	varchar(48)                              comment 'Biz Order',
	card_number                   	varchar(68)                              comment 'Card Number',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Consumer Order Payment Group";

drop table  if exists consumer_order_price_adjustment_data;
create table consumer_order_price_adjustment_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(16)                              comment 'Name',
	biz_order                     	varchar(48)                              comment 'Biz Order',
	amount                        	numeric(7,2)                             comment 'Amount',
	provider                      	varchar(16)                              comment 'Provider',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Consumer Order Price Adjustment";

drop table  if exists retail_store_member_coupon_data;
create table retail_store_member_coupon_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(12)                              comment 'Name',
	owner                         	varchar(48)                              comment 'Owner',
	number                        	varchar(28)                              comment 'Number',
	last_update_time              	datetime                                 comment 'Last Update Time',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Retail Store Member Coupon";

drop table  if exists member_wishlist_data;
create table member_wishlist_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(24)                              comment 'Name',
	owner                         	varchar(48)                              comment 'Owner',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Member Wishlist";

drop table  if exists member_reward_point_data;
create table member_reward_point_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(24)                              comment 'Name',
	point                         	int                                      comment 'Point',
	owner                         	varchar(48)                              comment 'Owner',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Member Reward Point";

drop table  if exists member_reward_point_redemption_data;
create table member_reward_point_redemption_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(16)                              comment 'Name',
	point                         	int                                      comment 'Point',
	owner                         	varchar(48)                              comment 'Owner',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Member Reward Point Redemption";

drop table  if exists member_wishlist_product_data;
create table member_wishlist_product_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(20)                              comment 'Name',
	owner                         	varchar(48)                              comment 'Owner',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Member Wishlist Product";

drop table  if exists retail_store_member_address_data;
create table retail_store_member_address_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(24)                              comment 'Name',
	owner                         	varchar(48)                              comment 'Owner',
	mobile_phone                  	varchar(44)                              comment 'Mobile Phone',
	address                       	varchar(56)                              comment 'Address',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Retail Store Member Address";

drop table  if exists retail_store_member_gift_card_data;
create table retail_store_member_gift_card_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(12)                              comment 'Name',
	owner                         	varchar(48)                              comment 'Owner',
	number                        	varchar(28)                              comment 'Number',
	remain                        	numeric(7,2)                             comment 'Remain',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Retail Store Member Gift Card";

drop table  if exists retail_store_member_gift_card_consume_record_data;
create table retail_store_member_gift_card_consume_record_data (
	id                            	varchar(48)          not null            comment 'Id',
	occure_time                   	date                                     comment 'Occure Time',
	owner                         	varchar(48)                              comment 'Owner',
	biz_order                     	varchar(48)                              comment 'Biz Order',
	number                        	varchar(28)                              comment 'Number',
	amount                        	numeric(6,2)                             comment 'Amount',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Retail Store Member Gift Card Consume Record";

drop table  if exists goods_supplier_data;
create table goods_supplier_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(12)                              comment 'Name',
	supply_product                	varchar(16)                              comment 'Supply Product',
	belong_to                     	varchar(48)                              comment 'Belong To',
	contact_number                	varchar(44)                              comment 'Contact Number',
	description                   	varchar(72)                              comment 'Description',
	last_update_time              	datetime                                 comment 'Last Update Time',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Goods Supplier";

drop table  if exists supplier_product_data;
create table supplier_product_data (
	id                            	varchar(48)          not null            comment 'Id',
	product_name                  	varchar(16)                              comment 'Product Name',
	product_description           	varchar(52)                              comment 'Product Description',
	product_unit                  	varchar(8)                               comment 'Product Unit',
	supplier                      	varchar(48)                              comment 'Supplier',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Supplier Product";

drop table  if exists product_supply_duration_data;
create table product_supply_duration_data (
	id                            	varchar(48)          not null            comment 'Id',
	quantity                      	int                                      comment 'Quantity',
	duration                      	varchar(8)                               comment 'Duration',
	price                         	numeric(8,2)                             comment 'Price',
	product                       	varchar(48)                              comment 'Product',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Product Supply Duration";

drop table  if exists supply_order_data;
create table supply_order_data (
	id                            	varchar(48)          not null            comment 'Id',
	buyer                         	varchar(48)                              comment 'Buyer',
	seller                        	varchar(48)                              comment 'Seller',
	title                         	varchar(40)                              comment 'Title',
	total_amount                  	numeric(14,2)                            comment 'Total Amount',
	confirmation                  	varchar(48)                              comment 'Confirmation',
	approval                      	varchar(48)                              comment 'Approval',
	processing                    	varchar(48)                              comment 'Processing',
	picking                       	varchar(48)                              comment 'Picking',
	shipment                      	varchar(48)                              comment 'Shipment',
	delivery                      	varchar(48)                              comment 'Delivery',
	last_update_time              	datetime                                 comment 'Last Update Time',
	current_status                	varchar(36)                              comment 'Current Status',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Supply Order";

drop table  if exists supply_order_confirmation_data;
create table supply_order_confirmation_data (
	id                            	varchar(48)          not null            comment 'Id',
	who                           	varchar(12)                              comment 'Who',
	confirm_time                  	date                                     comment 'Confirm Time',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Supply Order Confirmation";

drop table  if exists supply_order_approval_data;
create table supply_order_approval_data (
	id                            	varchar(48)          not null            comment 'Id',
	who                           	varchar(12)                              comment 'Who',
	approve_time                  	date                                     comment 'Approve Time',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Supply Order Approval";

drop table  if exists supply_order_processing_data;
create table supply_order_processing_data (
	id                            	varchar(48)          not null            comment 'Id',
	who                           	varchar(12)                              comment 'Who',
	process_time                  	date                                     comment 'Process Time',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Supply Order Processing";

drop table  if exists supply_order_picking_data;
create table supply_order_picking_data (
	id                            	varchar(48)          not null            comment 'Id',
	who                           	varchar(12)                              comment 'Who',
	process_time                  	date                                     comment 'Process Time',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Supply Order Picking";

drop table  if exists supply_order_shipment_data;
create table supply_order_shipment_data (
	id                            	varchar(48)          not null            comment 'Id',
	who                           	varchar(12)                              comment 'Who',
	ship_time                     	date                                     comment 'Ship Time',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Supply Order Shipment";

drop table  if exists supply_order_delivery_data;
create table supply_order_delivery_data (
	id                            	varchar(48)          not null            comment 'Id',
	who                           	varchar(12)                              comment 'Who',
	delivery_time                 	date                                     comment 'Delivery Time',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Supply Order Delivery";

drop table  if exists supply_order_line_item_data;
create table supply_order_line_item_data (
	id                            	varchar(48)          not null            comment 'Id',
	biz_order                     	varchar(48)                              comment 'Biz Order',
	sku_id                        	varchar(12)                              comment 'Sku Id',
	sku_name                      	varchar(16)                              comment 'Sku Name',
	amount                        	numeric(5,2)                             comment 'Amount',
	quantity                      	int                                      comment 'Quantity',
	unit_of_measurement           	varchar(8)                               comment 'Unit Of Measurement',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Supply Order Line Item";

drop table  if exists supply_order_shipping_group_data;
create table supply_order_shipping_group_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(40)                              comment 'Name',
	biz_order                     	varchar(48)                              comment 'Biz Order',
	amount                        	numeric(5,2)                             comment 'Amount',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Supply Order Shipping Group";

drop table  if exists supply_order_payment_group_data;
create table supply_order_payment_group_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(16)                              comment 'Name',
	biz_order                     	varchar(48)                              comment 'Biz Order',
	card_number                   	varchar(68)                              comment 'Card Number',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Supply Order Payment Group";

drop table  if exists retail_store_order_data;
create table retail_store_order_data (
	id                            	varchar(48)          not null            comment 'Id',
	buyer                         	varchar(48)                              comment 'Buyer',
	seller                        	varchar(48)                              comment 'Seller',
	title                         	varchar(56)                              comment 'Title',
	total_amount                  	numeric(14,2)                            comment 'Total Amount',
	confirmation                  	varchar(48)                              comment 'Confirmation',
	approval                      	varchar(48)                              comment 'Approval',
	processing                    	varchar(48)                              comment 'Processing',
	picking                       	varchar(48)                              comment 'Picking',
	shipment                      	varchar(48)                              comment 'Shipment',
	delivery                      	varchar(48)                              comment 'Delivery',
	last_update_time              	datetime                                 comment 'Last Update Time',
	current_status                	varchar(36)                              comment 'Current Status',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Retail Store Order";

drop table  if exists retail_store_order_confirmation_data;
create table retail_store_order_confirmation_data (
	id                            	varchar(48)          not null            comment 'Id',
	who                           	varchar(12)                              comment 'Who',
	confirm_time                  	date                                     comment 'Confirm Time',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Retail Store Order Confirmation";

drop table  if exists retail_store_order_approval_data;
create table retail_store_order_approval_data (
	id                            	varchar(48)          not null            comment 'Id',
	who                           	varchar(12)                              comment 'Who',
	approve_time                  	date                                     comment 'Approve Time',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Retail Store Order Approval";

drop table  if exists retail_store_order_processing_data;
create table retail_store_order_processing_data (
	id                            	varchar(48)          not null            comment 'Id',
	who                           	varchar(12)                              comment 'Who',
	process_time                  	date                                     comment 'Process Time',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Retail Store Order Processing";

drop table  if exists retail_store_order_picking_data;
create table retail_store_order_picking_data (
	id                            	varchar(48)          not null            comment 'Id',
	who                           	varchar(12)                              comment 'Who',
	process_time                  	date                                     comment 'Process Time',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Retail Store Order Picking";

drop table  if exists retail_store_order_shipment_data;
create table retail_store_order_shipment_data (
	id                            	varchar(48)          not null            comment 'Id',
	who                           	varchar(12)                              comment 'Who',
	ship_time                     	date                                     comment 'Ship Time',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Retail Store Order Shipment";

drop table  if exists retail_store_order_delivery_data;
create table retail_store_order_delivery_data (
	id                            	varchar(48)          not null            comment 'Id',
	who                           	varchar(12)                              comment 'Who',
	delivery_time                 	date                                     comment 'Delivery Time',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Retail Store Order Delivery";

drop table  if exists retail_store_order_line_item_data;
create table retail_store_order_line_item_data (
	id                            	varchar(48)          not null            comment 'Id',
	biz_order                     	varchar(48)                              comment 'Biz Order',
	sku_id                        	varchar(12)                              comment 'Sku Id',
	sku_name                      	varchar(16)                              comment 'Sku Name',
	amount                        	numeric(5,2)                             comment 'Amount',
	quantity                      	int                                      comment 'Quantity',
	unit_of_measurement           	varchar(8)                               comment 'Unit Of Measurement',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Retail Store Order Line Item";

drop table  if exists retail_store_order_shipping_group_data;
create table retail_store_order_shipping_group_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(40)                              comment 'Name',
	biz_order                     	varchar(48)                              comment 'Biz Order',
	amount                        	numeric(5,2)                             comment 'Amount',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Retail Store Order Shipping Group";

drop table  if exists retail_store_order_payment_group_data;
create table retail_store_order_payment_group_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(16)                              comment 'Name',
	biz_order                     	varchar(48)                              comment 'Biz Order',
	card_number                   	varchar(68)                              comment 'Card Number',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Retail Store Order Payment Group";

drop table  if exists warehouse_data;
create table warehouse_data (
	id                            	varchar(48)          not null            comment 'Id',
	location                      	varchar(44)                              comment 'Location',
	contact_number                	varchar(44)                              comment 'Contact Number',
	total_area                    	varchar(36)                              comment 'Total Area',
	owner                         	varchar(48)                              comment 'Owner',
	latitude                      	numeric(9,6)                             comment 'Latitude',
	longitude                     	numeric(10,6)                            comment 'Longitude',
	last_update_time              	datetime                                 comment 'Last Update Time',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Warehouse";

drop table  if exists storage_space_data;
create table storage_space_data (
	id                            	varchar(48)          not null            comment 'Id',
	location                      	varchar(56)                              comment 'Location',
	contact_number                	varchar(44)                              comment 'Contact Number',
	total_area                    	varchar(28)                              comment 'Total Area',
	warehouse                     	varchar(48)                              comment 'Warehouse',
	latitude                      	numeric(9,6)                             comment 'Latitude',
	longitude                     	numeric(10,6)                            comment 'Longitude',
	last_update_time              	datetime                                 comment 'Last Update Time',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Storage Space";

drop table  if exists smart_pallet_data;
create table smart_pallet_data (
	id                            	varchar(48)          not null            comment 'Id',
	location                      	varchar(104)                             comment 'Location',
	contact_number                	varchar(44)                              comment 'Contact Number',
	total_area                    	varchar(28)                              comment 'Total Area',
	latitude                      	numeric(9,6)                             comment 'Latitude',
	longitude                     	numeric(10,6)                            comment 'Longitude',
	warehouse                     	varchar(48)                              comment 'Warehouse',
	last_update_time              	datetime                                 comment 'Last Update Time',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Smart Pallet";

drop table  if exists goods_shelf_data;
create table goods_shelf_data (
	id                            	varchar(48)          not null            comment 'Id',
	location                      	varchar(64)                              comment 'Location',
	storage_space                 	varchar(48)                              comment 'Storage Space',
	supplier_space                	varchar(48)                              comment 'Supplier Space',
	damage_space                  	varchar(48)                              comment 'Damage Space',
	last_update_time              	datetime                                 comment 'Last Update Time',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Goods Shelf";

drop table  if exists goods_shelf_stock_count_data;
create table goods_shelf_stock_count_data (
	id                            	varchar(48)          not null            comment 'Id',
	title                         	varchar(16)                              comment 'Title',
	count_time                    	date                                     comment 'Count Time',
	summary                       	varchar(72)                              comment 'Summary',
	shelf                         	varchar(48)                              comment 'Shelf',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Goods Shelf Stock Count";

drop table  if exists stock_count_issue_track_data;
create table stock_count_issue_track_data (
	id                            	varchar(48)          not null            comment 'Id',
	title                         	varchar(16)                              comment 'Title',
	count_time                    	date                                     comment 'Count Time',
	summary                       	varchar(40)                              comment 'Summary',
	stock_count                   	varchar(48)                              comment 'Stock Count',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Stock Count Issue Track";

drop table  if exists goods_allocation_data;
create table goods_allocation_data (
	id                            	varchar(48)          not null            comment 'Id',
	location                      	varchar(84)                              comment 'Location',
	latitude                      	numeric(9,6)                             comment 'Latitude',
	longitude                     	numeric(10,6)                            comment 'Longitude',
	goods_shelf                   	varchar(48)                              comment 'Goods Shelf',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Goods Allocation";

drop table  if exists goods_data;
create table goods_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(16)                              comment 'Name',
	rfid                          	varchar(28)                              comment 'Rfid',
	uom                           	varchar(4)                               comment 'Uom',
	max_package                   	int                                      comment 'Max Package',
	expire_time                   	date                                     comment 'Expire Time',
	sku                           	varchar(48)                              comment 'Sku',
	receiving_space               	varchar(48)                              comment 'Receiving Space',
	goods_allocation              	varchar(48)                              comment 'Goods Allocation',
	smart_pallet                  	varchar(48)                              comment 'Smart Pallet',
	shipping_space                	varchar(48)                              comment 'Shipping Space',
	transport_task                	varchar(48)                              comment 'Transport Task',
	retail_store                  	varchar(48)                              comment 'Retail Store',
	biz_order                     	varchar(48)                              comment 'Biz Order',
	retail_store_order            	varchar(48)                              comment 'Retail Store Order',
	packaging                     	varchar(48)                              comment 'Packaging',
	current_status                	varchar(24)                              comment 'Current Status',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Goods";

drop table  if exists goods_packaging_data;
create table goods_packaging_data (
	id                            	varchar(48)          not null            comment 'Id',
	package_name                  	varchar(12)                              comment 'Package Name',
	rfid                          	varchar(28)                              comment 'Rfid',
	package_time                  	date                                     comment 'Package Time',
	description                   	varchar(36)                              comment 'Description',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Goods Packaging";

drop table  if exists goods_movement_data;
create table goods_movement_data (
	id                            	varchar(48)          not null            comment 'Id',
	move_time                     	datetime                                 comment 'Move Time',
	facility                      	varchar(16)                              comment 'Facility',
	facility_id                   	varchar(16)                              comment 'Facility Id',
	from_ip                       	varchar(48)                              comment 'From Ip',
	user_agent                    	varchar(444)                             comment 'User Agent',
	session_id                    	varchar(80)                              comment 'Session Id',
	latitude                      	numeric(9,6)                             comment 'Latitude',
	longitude                     	numeric(10,6)                            comment 'Longitude',
	goods                         	varchar(48)                              comment 'Goods',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Goods Movement";

drop table  if exists supplier_space_data;
create table supplier_space_data (
	id                            	varchar(48)          not null            comment 'Id',
	location                      	varchar(76)                              comment 'Location',
	contact_number                	varchar(44)                              comment 'Contact Number',
	total_area                    	varchar(28)                              comment 'Total Area',
	warehouse                     	varchar(48)                              comment 'Warehouse',
	latitude                      	numeric(9,6)                             comment 'Latitude',
	longitude                     	numeric(10,6)                            comment 'Longitude',
	last_update_time              	datetime                                 comment 'Last Update Time',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Supplier Space";

drop table  if exists receiving_space_data;
create table receiving_space_data (
	id                            	varchar(48)          not null            comment 'Id',
	location                      	varchar(64)                              comment 'Location',
	contact_number                	varchar(44)                              comment 'Contact Number',
	description                   	varchar(52)                              comment 'Description',
	total_area                    	varchar(28)                              comment 'Total Area',
	warehouse                     	varchar(48)                              comment 'Warehouse',
	latitude                      	numeric(9,6)                             comment 'Latitude',
	longitude                     	numeric(10,6)                            comment 'Longitude',
	last_update_time              	datetime                                 comment 'Last Update Time',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Receiving Space";

drop table  if exists shipping_space_data;
create table shipping_space_data (
	id                            	varchar(48)          not null            comment 'Id',
	location                      	varchar(56)                              comment 'Location',
	contact_number                	varchar(44)                              comment 'Contact Number',
	total_area                    	varchar(28)                              comment 'Total Area',
	warehouse                     	varchar(48)                              comment 'Warehouse',
	latitude                      	numeric(9,6)                             comment 'Latitude',
	longitude                     	numeric(10,6)                            comment 'Longitude',
	description                   	varchar(52)                              comment 'Description',
	last_update_time              	datetime                                 comment 'Last Update Time',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Shipping Space";

drop table  if exists damage_space_data;
create table damage_space_data (
	id                            	varchar(48)          not null            comment 'Id',
	location                      	varchar(80)                              comment 'Location',
	contact_number                	varchar(44)                              comment 'Contact Number',
	total_area                    	varchar(28)                              comment 'Total Area',
	latitude                      	numeric(9,6)                             comment 'Latitude',
	longitude                     	numeric(10,6)                            comment 'Longitude',
	warehouse                     	varchar(48)                              comment 'Warehouse',
	last_update_time              	datetime                                 comment 'Last Update Time',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Damage Space";

drop table  if exists warehouse_asset_data;
create table warehouse_asset_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(20)                              comment 'Name',
	position                      	varchar(40)                              comment 'Position',
	owner                         	varchar(48)                              comment 'Owner',
	last_update_time              	datetime                                 comment 'Last Update Time',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Warehouse Asset";

drop table  if exists transport_fleet_data;
create table transport_fleet_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(28)                              comment 'Name',
	contact_number                	varchar(44)                              comment 'Contact Number',
	owner                         	varchar(48)                              comment 'Owner',
	last_update_time              	datetime                                 comment 'Last Update Time',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Transport Fleet";

drop table  if exists transport_truck_data;
create table transport_truck_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(16)                              comment 'Name',
	plate_number                  	varchar(16)                              comment 'Plate Number',
	contact_number                	varchar(44)                              comment 'Contact Number',
	vehicle_license_number        	varchar(24)                              comment 'Vehicle License Number',
	engine_number                 	varchar(28)                              comment 'Engine Number',
	make_date                     	date                                     comment 'Make Date',
	mileage                       	varchar(24)                              comment 'Mileage',
	body_color                    	varchar(8)                               comment 'Body Color',
	owner                         	varchar(48)                              comment 'Owner',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Transport Truck";

drop table  if exists truck_driver_data;
create table truck_driver_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(24)                              comment 'Name',
	driver_license_number         	varchar(44)                              comment 'Driver License Number',
	contact_number                	varchar(44)                              comment 'Contact Number',
	belongs_to                    	varchar(48)                              comment 'Belongs To',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Truck Driver";

drop table  if exists transport_task_data;
create table transport_task_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(16)                              comment 'Name',
	start                         	varchar(20)                              comment 'Start',
	begin_time                    	date                                     comment 'Begin Time',
	end                           	varchar(48)                              comment 'End',
	driver                        	varchar(48)                              comment 'Driver',
	truck                         	varchar(48)                              comment 'Truck',
	belongs_to                    	varchar(48)                              comment 'Belongs To',
	latitude                      	numeric(9,6)                             comment 'Latitude',
	longitude                     	numeric(10,6)                            comment 'Longitude',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Transport Task";

drop table  if exists transport_task_track_data;
create table transport_task_track_data (
	id                            	varchar(48)          not null            comment 'Id',
	track_time                    	date                                     comment 'Track Time',
	latitude                      	numeric(9,6)                             comment 'Latitude',
	longitude                     	numeric(10,6)                            comment 'Longitude',
	movement                      	varchar(48)                              comment 'Movement',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Transport Task Track";

drop table  if exists account_set_data;
create table account_set_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(24)                              comment 'Name',
	year_set                      	varchar(20)                              comment 'Year Set',
	effective_date                	date                                     comment 'Effective Date',
	accounting_system             	varchar(28)                              comment 'Accounting System',
	domestic_currency_code        	varchar(12)                              comment 'Domestic Currency Code',
	domestic_currency_name        	varchar(12)                              comment 'Domestic Currency Name',
	opening_bank                  	varchar(16)                              comment 'Opening Bank',
	account_number                	varchar(56)                              comment 'Account Number',
	country_center                	varchar(48)                              comment 'Country Center',
	retail_store                  	varchar(48)                              comment 'Retail Store',
	goods_supplier                	varchar(48)                              comment 'Goods Supplier',
	last_update_time              	datetime                                 comment 'Last Update Time',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Account Set";

drop table  if exists accounting_subject_data;
create table accounting_subject_data (
	id                            	varchar(48)          not null            comment 'Id',
	accounting_subject_code       	varchar(24)                              comment 'Accounting Subject Code',
	accounting_subject_name       	varchar(16)                              comment 'Accounting Subject Name',
	accounting_subject_class_code 	int                                      comment 'Accounting Subject Class Code',
	accounting_subject_class_name 	varchar(24)                              comment 'Accounting Subject Class Name',
	account_set                   	varchar(48)                              comment 'Account Set',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Accounting Subject";

drop table  if exists accounting_period_data;
create table accounting_period_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(32)                              comment 'Name',
	start_date                    	date                                     comment 'Start Date',
	end_date                      	date                                     comment 'End Date',
	account_set                   	varchar(48)                              comment 'Account Set',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Accounting Period";

drop table  if exists accounting_document_type_data;
create table accounting_document_type_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(16)                              comment 'Name',
	description                   	varchar(280)                             comment 'Description',
	accounting_period             	varchar(48)                              comment 'Accounting Period',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Accounting Document Type";

drop table  if exists accounting_document_data;
create table accounting_document_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(16)                              comment 'Name',
	accounting_document_date      	date                                     comment 'Accounting Document Date',
	accounting_period             	varchar(48)                              comment 'Accounting Period',
	document_type                 	varchar(48)                              comment 'Document Type',
	creation                      	varchar(48)                              comment 'Creation',
	confirmation                  	varchar(48)                              comment 'Confirmation',
	auditing                      	varchar(48)                              comment 'Auditing',
	posting                       	varchar(48)                              comment 'Posting',
	current_status                	varchar(36)                              comment 'Current Status',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Accounting Document";

drop table  if exists accounting_document_creation_data;
create table accounting_document_creation_data (
	id                            	varchar(48)          not null            comment 'Id',
	who                           	varchar(16)                              comment 'Who',
	comments                      	varchar(16)                              comment 'Comments',
	make_date                     	date                                     comment 'Make Date',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Accounting Document Creation";

drop table  if exists accounting_document_confirmation_data;
create table accounting_document_confirmation_data (
	id                            	varchar(48)          not null            comment 'Id',
	who                           	varchar(16)                              comment 'Who',
	comments                      	varchar(16)                              comment 'Comments',
	make_date                     	date                                     comment 'Make Date',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Accounting Document Confirmation";

drop table  if exists accounting_document_auditing_data;
create table accounting_document_auditing_data (
	id                            	varchar(48)          not null            comment 'Id',
	who                           	varchar(16)                              comment 'Who',
	comments                      	varchar(60)                              comment 'Comments',
	make_date                     	date                                     comment 'Make Date',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Accounting Document Auditing";

drop table  if exists accounting_document_posting_data;
create table accounting_document_posting_data (
	id                            	varchar(48)          not null            comment 'Id',
	who                           	varchar(16)                              comment 'Who',
	comments                      	varchar(60)                              comment 'Comments',
	make_date                     	date                                     comment 'Make Date',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Accounting Document Posting";

drop table  if exists original_voucher_data;
create table original_voucher_data (
	id                            	varchar(48)          not null            comment 'Id',
	title                         	varchar(28)                              comment 'Title',
	made_by                       	varchar(12)                              comment 'Made By',
	received_by                   	varchar(12)                              comment 'Received By',
	voucher_type                  	varchar(16)                              comment 'Voucher Type',
	voucher_image                 	varchar(512) CHARACTER SET ascii COLLATE ascii_general_ci                     comment 'Voucher Image',
	belongs_to                    	varchar(48)                              comment 'Belongs To',
	creation                      	varchar(48)                              comment 'Creation',
	confirmation                  	varchar(48)                              comment 'Confirmation',
	auditing                      	varchar(48)                              comment 'Auditing',
	current_status                	varchar(36)                              comment 'Current Status',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Original Voucher";

drop table  if exists original_voucher_creation_data;
create table original_voucher_creation_data (
	id                            	varchar(48)          not null            comment 'Id',
	who                           	varchar(16)                              comment 'Who',
	comments                      	varchar(16)                              comment 'Comments',
	make_date                     	date                                     comment 'Make Date',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Original Voucher Creation";

drop table  if exists original_voucher_confirmation_data;
create table original_voucher_confirmation_data (
	id                            	varchar(48)          not null            comment 'Id',
	who                           	varchar(16)                              comment 'Who',
	comments                      	varchar(16)                              comment 'Comments',
	make_date                     	date                                     comment 'Make Date',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Original Voucher Confirmation";

drop table  if exists original_voucher_auditing_data;
create table original_voucher_auditing_data (
	id                            	varchar(48)          not null            comment 'Id',
	who                           	varchar(16)                              comment 'Who',
	comments                      	varchar(60)                              comment 'Comments',
	make_date                     	date                                     comment 'Make Date',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Original Voucher Auditing";

drop table  if exists accounting_document_line_data;
create table accounting_document_line_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(16)                              comment 'Name',
	code                          	varchar(24)                              comment 'Code',
	direct                        	varchar(4)                               comment 'Direct',
	amount                        	numeric(10,2)                            comment 'Amount',
	belongs_to                    	varchar(48)                              comment 'Belongs To',
	accounting_subject            	varchar(48)                              comment 'Accounting Subject',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Accounting Document Line";

drop table  if exists level_one_department_data;
create table level_one_department_data (
	id                            	varchar(48)          not null            comment 'Id',
	belongs_to                    	varchar(48)                              comment 'Belongs To',
	name                          	varchar(20)                              comment 'Name',
	description                   	varchar(72)                              comment 'Description',
	manager                       	varchar(12)                              comment 'Manager',
	founded                       	date                                     comment 'Founded',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Level One Department";

drop table  if exists level_two_department_data;
create table level_two_department_data (
	id                            	varchar(48)          not null            comment 'Id',
	belongs_to                    	varchar(48)                              comment 'Belongs To',
	name                          	varchar(40)                              comment 'Name',
	description                   	varchar(72)                              comment 'Description',
	founded                       	date                                     comment 'Founded',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Level Two Department";

drop table  if exists level_three_department_data;
create table level_three_department_data (
	id                            	varchar(48)          not null            comment 'Id',
	belongs_to                    	varchar(48)                              comment 'Belongs To',
	name                          	varchar(52)                              comment 'Name',
	description                   	varchar(72)                              comment 'Description',
	founded                       	date                                     comment 'Founded',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Level Three Department";

drop table  if exists skill_type_data;
create table skill_type_data (
	id                            	varchar(48)          not null            comment 'Id',
	code                          	varchar(20)                              comment 'Code',
	company                       	varchar(48)                              comment 'Company',
	description                   	varchar(24)                              comment 'Description',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Skill Type";

drop table  if exists responsibility_type_data;
create table responsibility_type_data (
	id                            	varchar(48)          not null            comment 'Id',
	code                          	varchar(20)                              comment 'Code',
	company                       	varchar(48)                              comment 'Company',
	base_description              	varchar(16)                              comment 'Base Description',
	detail_description            	varchar(116)                             comment 'Detail Description',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Responsibility Type";

drop table  if exists termination_reason_data;
create table termination_reason_data (
	id                            	varchar(48)          not null            comment 'Id',
	code                          	varchar(28)                              comment 'Code',
	company                       	varchar(48)                              comment 'Company',
	description                   	varchar(36)                              comment 'Description',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Termination Reason";

drop table  if exists termination_type_data;
create table termination_type_data (
	id                            	varchar(48)          not null            comment 'Id',
	code                          	varchar(28)                              comment 'Code',
	company                       	varchar(48)                              comment 'Company',
	base_description              	varchar(16)                              comment 'Base Description',
	detail_description            	varchar(248)                             comment 'Detail Description',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Termination Type";

drop table  if exists occupation_type_data;
create table occupation_type_data (
	id                            	varchar(48)          not null            comment 'Id',
	code                          	varchar(24)                              comment 'Code',
	company                       	varchar(48)                              comment 'Company',
	description                   	varchar(28)                              comment 'Description',
	detail_description            	varchar(244)                             comment 'Detail Description',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Occupation Type";

drop table  if exists leave_type_data;
create table leave_type_data (
	id                            	varchar(48)          not null            comment 'Id',
	code                          	varchar(24)                              comment 'Code',
	company                       	varchar(48)                              comment 'Company',
	description                   	varchar(16)                              comment 'Description',
	detail_description            	varchar(244)                             comment 'Detail Description',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Leave Type";

drop table  if exists salary_grade_data;
create table salary_grade_data (
	id                            	varchar(48)          not null            comment 'Id',
	code                          	varchar(24)                              comment 'Code',
	company                       	varchar(48)                              comment 'Company',
	name                          	varchar(16)                              comment 'Name',
	detail_description            	varchar(244)                             comment 'Detail Description',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Salary Grade";

drop table  if exists interview_type_data;
create table interview_type_data (
	id                            	varchar(48)          not null            comment 'Id',
	code                          	varchar(32)                              comment 'Code',
	company                       	varchar(48)                              comment 'Company',
	description                   	varchar(24)                              comment 'Description',
	detail_description            	varchar(244)                             comment 'Detail Description',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Interview Type";

drop table  if exists training_course_type_data;
create table training_course_type_data (
	id                            	varchar(48)          not null            comment 'Id',
	code                          	varchar(16)                              comment 'Code',
	company                       	varchar(48)                              comment 'Company',
	name                          	varchar(16)                              comment 'Name',
	description                   	varchar(64)                              comment 'Description',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Training Course Type";

drop table  if exists public_holiday_data;
create table public_holiday_data (
	id                            	varchar(48)          not null            comment 'Id',
	code                          	varchar(16)                              comment 'Code',
	company                       	varchar(48)                              comment 'Company',
	name                          	varchar(12)                              comment 'Name',
	description                   	varchar(40)                              comment 'Description',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Public Holiday";

drop table  if exists termination_data;
create table termination_data (
	id                            	varchar(48)          not null            comment 'Id',
	reason                        	varchar(48)                              comment 'Reason',
	type                          	varchar(48)                              comment 'Type',
	comment                       	varchar(16)                              comment 'Comment',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Termination";

drop table  if exists view_data;
create table view_data (
	id                            	varchar(48)          not null            comment 'Id',
	who                           	varchar(12)                              comment 'Who',
	assessment                    	varchar(40)                              comment 'Assessment',
	interview_time                	date                                     comment 'Interview Time',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "View";

drop table  if exists employee_data;
create table employee_data (
	id                            	varchar(48)          not null            comment 'Id',
	company                       	varchar(48)                              comment 'Company',
	title                         	varchar(12)                              comment 'Title',
	department                    	varchar(48)                              comment 'Department',
	family_name                   	varchar(4)                               comment 'Family Name',
	given_name                    	varchar(8)                               comment 'Given Name',
	email                         	varchar(256)                             comment 'Email',
	city                          	varchar(8)                               comment 'City',
	address                       	varchar(28)                              comment 'Address',
	cell_phone                    	varchar(44)                              comment 'Cell Phone',
	occupation                    	varchar(48)                              comment 'Occupation',
	responsible_for               	varchar(48)                              comment 'Responsible For',
	current_salary_grade          	varchar(48)                              comment 'Current Salary Grade',
	salary_account                	varchar(60)                              comment 'Salary Account',
	job_application               	varchar(48)                              comment 'Job Application',
	profession_interview          	varchar(48)                              comment 'Profession Interview',
	hr_interview                  	varchar(48)                              comment 'Hr Interview',
	offer_approval                	varchar(48)                              comment 'Offer Approval',
	offer_acceptance              	varchar(48)                              comment 'Offer Acceptance',
	employee_boarding             	varchar(48)                              comment 'Employee Boarding',
	termination                   	varchar(48)                              comment 'Termination',
	last_update_time              	datetime                                 comment 'Last Update Time',
	current_status                	varchar(88)                              comment 'Current Status',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Employee";

drop table  if exists job_application_data;
create table job_application_data (
	id                            	varchar(48)          not null            comment 'Id',
	application_time              	date                                     comment 'Application Time',
	who                           	varchar(20)                              comment 'Who',
	comments                      	varchar(124)                             comment 'Comments',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Job Application";

drop table  if exists profession_interview_data;
create table profession_interview_data (
	id                            	varchar(48)          not null            comment 'Id',
	who                           	varchar(12)                              comment 'Who',
	interview_time                	date                                     comment 'Interview Time',
	comments                      	varchar(60)                              comment 'Comments',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Profession Interview";

drop table  if exists hr_interview_data;
create table hr_interview_data (
	id                            	varchar(48)          not null            comment 'Id',
	who                           	varchar(20)                              comment 'Who',
	interview_time                	date                                     comment 'Interview Time',
	comments                      	varchar(52)                              comment 'Comments',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Hr Interview";

drop table  if exists offer_approval_data;
create table offer_approval_data (
	id                            	varchar(48)          not null            comment 'Id',
	who                           	varchar(12)                              comment 'Who',
	approve_time                  	date                                     comment 'Approve Time',
	comments                      	varchar(40)                              comment 'Comments',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Offer Approval";

drop table  if exists offer_acceptance_data;
create table offer_acceptance_data (
	id                            	varchar(48)          not null            comment 'Id',
	who                           	varchar(12)                              comment 'Who',
	accept_time                   	date                                     comment 'Accept Time',
	comments                      	varchar(40)                              comment 'Comments',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Offer Acceptance";

drop table  if exists employee_boarding_data;
create table employee_boarding_data (
	id                            	varchar(48)          not null            comment 'Id',
	who                           	varchar(20)                              comment 'Who',
	employ_time                   	date                                     comment 'Employ Time',
	comments                      	varchar(44)                              comment 'Comments',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Employee Boarding";

drop table  if exists instructor_data;
create table instructor_data (
	id                            	varchar(48)          not null            comment 'Id',
	title                         	varchar(16)                              comment 'Title',
	family_name                   	varchar(4)                               comment 'Family Name',
	given_name                    	varchar(8)                               comment 'Given Name',
	cell_phone                    	varchar(44)                              comment 'Cell Phone',
	email                         	varchar(256)                             comment 'Email',
	company                       	varchar(48)                              comment 'Company',
	introduction                  	varchar(60)                              comment 'Introduction',
	last_update_time              	datetime                                 comment 'Last Update Time',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Instructor";

drop table  if exists company_training_data;
create table company_training_data (
	id                            	varchar(48)          not null            comment 'Id',
	title                         	varchar(16)                              comment 'Title',
	company                       	varchar(48)                              comment 'Company',
	instructor                    	varchar(48)                              comment 'Instructor',
	training_course_type          	varchar(48)                              comment 'Training Course Type',
	time_start                    	date                                     comment 'Time Start',
	duration_hours                	int                                      comment 'Duration Hours',
	last_update_time              	datetime                                 comment 'Last Update Time',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Company Training";

drop table  if exists scoring_data;
create table scoring_data (
	id                            	varchar(48)          not null            comment 'Id',
	scored_by                     	varchar(12)                              comment 'Scored By',
	score                         	int                                      comment 'Score',
	comment                       	varchar(36)                              comment 'Comment',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Scoring";

drop table  if exists employee_company_training_data;
create table employee_company_training_data (
	id                            	varchar(48)          not null            comment 'Id',
	employee                      	varchar(48)                              comment 'Employee',
	training                      	varchar(48)                              comment 'Training',
	scoring                       	varchar(48)                              comment 'Scoring',
	current_status                	varchar(24)                              comment 'Current Status',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Employee Company Training";

drop table  if exists employee_skill_data;
create table employee_skill_data (
	id                            	varchar(48)          not null            comment 'Id',
	employee                      	varchar(48)                              comment 'Employee',
	skill_type                    	varchar(48)                              comment 'Skill Type',
	description                   	varchar(28)                              comment 'Description',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Employee Skill";

drop table  if exists employee_performance_data;
create table employee_performance_data (
	id                            	varchar(48)          not null            comment 'Id',
	employee                      	varchar(48)                              comment 'Employee',
	performance_comment           	varchar(28)                              comment 'Performance Comment',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Employee Performance";

drop table  if exists employee_work_experience_data;
create table employee_work_experience_data (
	id                            	varchar(48)          not null            comment 'Id',
	employee                      	varchar(48)                              comment 'Employee',
	start                         	date                                     comment 'Start',
	end                           	date                                     comment 'End',
	company                       	varchar(32)                              comment 'Company',
	description                   	varchar(84)                              comment 'Description',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Employee Work Experience";

drop table  if exists employee_leave_data;
create table employee_leave_data (
	id                            	varchar(48)          not null            comment 'Id',
	who                           	varchar(48)                              comment 'Who',
	type                          	varchar(48)                              comment 'Type',
	leave_duration_hour           	int                                      comment 'Leave Duration Hour',
	remark                        	varchar(44)                              comment 'Remark',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Employee Leave";

drop table  if exists employee_interview_data;
create table employee_interview_data (
	id                            	varchar(48)          not null            comment 'Id',
	employee                      	varchar(48)                              comment 'Employee',
	interview_type                	varchar(48)                              comment 'Interview Type',
	remark                        	varchar(40)                              comment 'Remark',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Employee Interview";

drop table  if exists employee_attendance_data;
create table employee_attendance_data (
	id                            	varchar(48)          not null            comment 'Id',
	employee                      	varchar(48)                              comment 'Employee',
	enter_time                    	date                                     comment 'Enter Time',
	leave_time                    	date                                     comment 'Leave Time',
	duration_hours                	int                                      comment 'Duration Hours',
	remark                        	varchar(28)                              comment 'Remark',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Employee Attendance";

drop table  if exists employee_qualifier_data;
create table employee_qualifier_data (
	id                            	varchar(48)          not null            comment 'Id',
	employee                      	varchar(48)                              comment 'Employee',
	qualified_time                	date                                     comment 'Qualified Time',
	type                          	varchar(20)                              comment 'Type',
	level                         	varchar(8)                               comment 'Level',
	remark                        	varchar(36)                              comment 'Remark',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Employee Qualifier";

drop table  if exists employee_education_data;
create table employee_education_data (
	id                            	varchar(48)          not null            comment 'Id',
	employee                      	varchar(48)                              comment 'Employee',
	complete_time                 	date                                     comment 'Complete Time',
	type                          	varchar(16)                              comment 'Type',
	remark                        	varchar(36)                              comment 'Remark',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Employee Education";

drop table  if exists employee_award_data;
create table employee_award_data (
	id                            	varchar(48)          not null            comment 'Id',
	employee                      	varchar(48)                              comment 'Employee',
	complete_time                 	date                                     comment 'Complete Time',
	type                          	varchar(20)                              comment 'Type',
	remark                        	varchar(36)                              comment 'Remark',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Employee Award";

drop table  if exists employee_salary_sheet_data;
create table employee_salary_sheet_data (
	id                            	varchar(48)          not null            comment 'Id',
	employee                      	varchar(48)                              comment 'Employee',
	current_salary_grade          	varchar(48)                              comment 'Current Salary Grade',
	base_salary                   	numeric(8,2)                             comment 'Base Salary',
	bonus                         	numeric(8,2)                             comment 'Bonus',
	reward                        	numeric(8,2)                             comment 'Reward',
	personal_tax                  	numeric(7,2)                             comment 'Personal Tax',
	social_security               	numeric(8,2)                             comment 'Social Security',
	housing_found                 	numeric(8,2)                             comment 'Housing Found',
	job_insurance                 	numeric(5,2)                             comment 'Job Insurance',
	paying_off                    	varchar(48)                              comment 'Paying Off',
	current_status                	varchar(32)                              comment 'Current Status',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Employee Salary Sheet";

drop table  if exists paying_off_data;
create table paying_off_data (
	id                            	varchar(48)          not null            comment 'Id',
	who                           	varchar(8)                               comment 'Who',
	paid_for                      	varchar(48)                              comment 'Paid For',
	paid_time                     	date                                     comment 'Paid Time',
	amount                        	numeric(8,2)                             comment 'Amount',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Paying Off";

drop table  if exists user_domain_data;
create table user_domain_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(16)                              comment 'Name',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "User Domain";

drop table  if exists user_white_list_data;
create table user_white_list_data (
	id                            	varchar(48)          not null            comment 'Id',
	user_identity                 	varchar(40)                              comment 'User Identity',
	user_special_functions        	varchar(200)                             comment 'User Special Functions',
	domain                        	varchar(48)                              comment 'Domain',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "User White List";

drop table  if exists sec_user_data;
create table sec_user_data (
	id                            	varchar(48)          not null            comment 'Id',
	login                         	varchar(20)                              comment 'Login',
	mobile                        	varchar(11)                              comment 'Mobile',
	email                         	varchar(76)                              comment 'Email',
	pwd                           	varchar(64)                              comment 'Pwd',
	weixin_openid                 	varchar(128)                             comment 'Weixin Openid',
	weixin_appid                  	varchar(128)                             comment 'Weixin Appid',
	access_token                  	varchar(128)                             comment 'Access Token',
	verification_code             	int                                      comment 'Verification Code',
	verification_code_expire      	datetime                                 comment 'Verification Code Expire',
	last_login_time               	datetime                                 comment 'Last Login Time',
	domain                        	varchar(48)                              comment 'Domain',
	blocking                      	varchar(48)                              comment 'Blocking',
	current_status                	varchar(28)                              comment 'Current Status',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Sec User";

drop table  if exists sec_user_blocking_data;
create table sec_user_blocking_data (
	id                            	varchar(48)          not null            comment 'Id',
	who                           	varchar(52)                              comment 'Who',
	block_time                    	datetime                                 comment 'Block Time',
	comments                      	varchar(96)                              comment 'Comments',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Sec User Blocking";

drop table  if exists user_app_data;
create table user_app_data (
	id                            	varchar(48)          not null            comment 'Id',
	title                         	varchar(300)                             comment 'Title',
	sec_user                      	varchar(48)                              comment 'Sec User',
	app_icon                      	varchar(36)                              comment 'App Icon',
	full_access                   	tinyint                                  comment 'Full Access',
	permission                    	varchar(16)                              comment 'Permission',
	object_type                   	varchar(100)                             comment 'Object Type',
	object_id                     	varchar(40)                              comment 'Object Id',
	location                      	varchar(48)                              comment 'Location',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "User App";

drop table  if exists list_access_data;
create table list_access_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(200)                             comment 'Name',
	internal_name                 	varchar(200)                             comment 'Internal Name',
	read_permission               	tinyint                                  comment 'Read Permission',
	create_permission             	tinyint                                  comment 'Create Permission',
	delete_permission             	tinyint                                  comment 'Delete Permission',
	update_permission             	tinyint                                  comment 'Update Permission',
	execution_permission          	tinyint                                  comment 'Execution Permission',
	app                           	varchar(48)                              comment 'App',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "List Access";

drop table  if exists object_access_data;
create table object_access_data (
	id                            	varchar(48)          not null            comment 'Id',
	name                          	varchar(28)                              comment 'Name',
	object_type                   	varchar(112)                             comment 'Object Type',
	list1                         	varchar(80)                              comment 'List1',
	list2                         	varchar(80)                              comment 'List2',
	list3                         	varchar(80)                              comment 'List3',
	list4                         	varchar(80)                              comment 'List4',
	list5                         	varchar(80)                              comment 'List5',
	list6                         	varchar(80)                              comment 'List6',
	list7                         	varchar(80)                              comment 'List7',
	list8                         	varchar(80)                              comment 'List8',
	list9                         	varchar(80)                              comment 'List9',
	app                           	varchar(48)                              comment 'App',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Object Access";

drop table  if exists login_history_data;
create table login_history_data (
	id                            	varchar(48)          not null            comment 'Id',
	login_time                    	datetime                                 comment 'Login Time',
	from_ip                       	varchar(44)                              comment 'From Ip',
	description                   	varchar(16)                              comment 'Description',
	sec_user                      	varchar(48)                              comment 'Sec User',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Login History";

drop table  if exists generic_form_data;
create table generic_form_data (
	id                            	varchar(48)          not null            comment 'Id',
	title                         	varchar(20)                              comment 'Title',
	description                   	varchar(48)                              comment 'Description',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Generic Form";

drop table  if exists form_message_data;
create table form_message_data (
	id                            	varchar(48)          not null            comment 'Id',
	title                         	varchar(24)                              comment 'Title',
	form                          	varchar(48)                              comment 'Form',
	level                         	varchar(28)                              comment 'Level',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Form Message";

drop table  if exists form_field_message_data;
create table form_field_message_data (
	id                            	varchar(48)          not null            comment 'Id',
	title                         	varchar(16)                              comment 'Title',
	parameter_name                	varchar(16)                              comment 'Parameter Name',
	form                          	varchar(48)                              comment 'Form',
	level                         	varchar(28)                              comment 'Level',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Form Field Message";

drop table  if exists form_field_data;
create table form_field_data (
	id                            	varchar(48)          not null            comment 'Id',
	label                         	varchar(12)                              comment 'Label',
	locale_key                    	varchar(44)                              comment 'Locale Key',
	parameter_name                	varchar(16)                              comment 'Parameter Name',
	type                          	varchar(36)                              comment 'Type',
	form                          	varchar(48)                              comment 'Form',
	placeholder                   	varchar(48)                              comment 'Placeholder',
	default_value                 	varchar(12)                              comment 'Default Value',
	description                   	varchar(48)                              comment 'Description',
	field_group                   	varchar(16)                              comment 'Field Group',
	minimum_value                 	varchar(60)                              comment 'Minimum Value',
	maximum_value                 	varchar(72)                              comment 'Maximum Value',
	required                      	tinyint                                  comment 'Required',
	disabled                      	tinyint                                  comment 'Disabled',
	custom_rendering              	tinyint                                  comment 'Custom Rendering',
	candidate_values              	varchar(12)                              comment 'Candidate Values',
	suggest_values                	varchar(12)                              comment 'Suggest Values',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Form Field";

drop table  if exists form_action_data;
create table form_action_data (
	id                            	varchar(48)          not null            comment 'Id',
	label                         	varchar(8)                               comment 'Label',
	locale_key                    	varchar(16)                              comment 'Locale Key',
	action_key                    	varchar(24)                              comment 'Action Key',
	level                         	varchar(28)                              comment 'Level',
	url                           	varchar(168)                             comment 'Url',
	form                          	varchar(48)                              comment 'Form',
	version                       	int                                      comment 'Version',
	primary key(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE = utf8mb4_unicode_ci COMMENT = "Form Action";




insert into retail_store_country_center_data values
	('RSCC000001','双链小超中国国运营中心','4000-800-','2019-01-14','https://www.doublechaintech.com/','四川省成都市天府新区双链大厦','双链集团','张喜来','中国中心正式成立，恭喜恭喜','1'),
	('RSCC000002','双链小超美国国运营中心','4000-800-0002','2018-10-15','https://www.doublechaintech.com/','四川省成都市天府新区双链大厦0002','双链集团0002','张喜来','中国中心正式成立，恭喜恭喜0002','1'),
	('RSCC000003','双链小超日本国运营中心','4000-800-0003','2019-05-09','https://www.doublechaintech.com/','四川省成都市天府新区双链大厦0003','双链集团0003','张喜来','中国中心正式成立，恭喜恭喜0003','1'),
	('RSCC000004','双链小超泰国国运营中心','4000-800-0004','2018-07-26','https://www.doublechaintech.com/','四川省成都市天府新区双链大厦0004','双链集团0004','张喜来','中国中心正式成立，恭喜恭喜0004','1');

insert into catalog_data values
	('C000001','水果蔬菜','RSCC000001','1'),
	('C000002','肉禽蛋奶','RSCC000001','1'),
	('C000003','冷热速食','RSCC000001','1'),
	('C000004','休闲食品','RSCC000002','1'),
	('C000005','酒水饮料','RSCC000002','1'),
	('C000006','粮油调味','RSCC000003','1'),
	('C000007','清洁日化','RSCC000003','1'),
	('C000008','家居用品','RSCC000003','1'),
	('C000009','鲜花蛋糕','RSCC000004','1'),
	('C000010','医药健康','RSCC000004','1');

insert into level_one_category_data values
	('LOC000001','C000001','水果蔬菜','1'),
	('LOC000002','C000002','肉禽蛋奶','1'),
	('LOC000003','C000003','冷热速食','1'),
	('LOC000004','C000004','休闲食品','1'),
	('LOC000005','C000005','酒水饮料','1'),
	('LOC000006','C000006','粮油调味','1'),
	('LOC000007','C000007','清洁日化','1'),
	('LOC000008','C000008','家居用品','1'),
	('LOC000009','C000009','鲜花蛋糕','1'),
	('LOC000010','C000010','医药健康','1');

insert into level_two_category_data values
	('LTC000001','LOC000001','水果蔬菜','1'),
	('LTC000002','LOC000002','肉禽蛋奶','1'),
	('LTC000003','LOC000003','冷热速食','1'),
	('LTC000004','LOC000004','休闲食品','1'),
	('LTC000005','LOC000005','酒水饮料','1'),
	('LTC000006','LOC000006','粮油调味','1'),
	('LTC000007','LOC000007','清洁日化','1'),
	('LTC000008','LOC000008','家居用品','1'),
	('LTC000009','LOC000009','鲜花蛋糕','1'),
	('LTC000010','LOC000010','医药健康','1');

insert into level_three_category_data values
	('LTC000001','LTC000001','水果蔬菜','1'),
	('LTC000002','LTC000001','肉禽蛋奶','1'),
	('LTC000003','LTC000002','冷热速食','1'),
	('LTC000004','LTC000002','休闲食品','1'),
	('LTC000005','LTC000003','酒水饮料','1'),
	('LTC000006','LTC000004','粮油调味','1'),
	('LTC000007','LTC000004','清洁日化','1'),
	('LTC000008','LTC000005','家居用品','1'),
	('LTC000009','LTC000006','鲜花蛋糕','1'),
	('LTC000010','LTC000006','医药健康','1'),
	('LTC000011','LTC000007','水果蔬菜','1'),
	('LTC000012','LTC000007','肉禽蛋奶','1'),
	('LTC000013','LTC000008','冷热速食','1'),
	('LTC000014','LTC000009','休闲食品','1'),
	('LTC000015','LTC000009','酒水饮料','1'),
	('LTC000016','LTC000010','粮油调味','1');

insert into product_data values
	('P000001','啤酒','LTC000001','四川','可口可乐，销售百年的糖水，获得了全世界额青睐','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog00/400/200/grey/','2019-07-02 11:43:29','1'),
	('P000002','可乐','LTC000001','广东','可口可乐，销售百年的糖水，获得了全世界额青睐0002','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0002','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog00/400/200/grey/','2019-06-21 20:54:25','1'),
	('P000003','久久鸭','LTC000002','江苏','可口可乐，销售百年的糖水，获得了全世界额青睐0003','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0003','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog00/400/200/grey/','2019-07-03 01:06:51','1'),
	('P000004','啤酒','LTC000002','安徽','可口可乐，销售百年的糖水，获得了全世界额青睐0004','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0004','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog00/400/200/grey/','2019-06-30 15:09:07','1'),
	('P000005','可乐','LTC000003','日本','可口可乐，销售百年的糖水，获得了全世界额青睐0005','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0005','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog00/400/200/grey/','2019-06-18 07:19:26','1'),
	('P000006','久久鸭','LTC000003','法国','可口可乐，销售百年的糖水，获得了全世界额青睐0006','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0006','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog00/400/200/grey/','2019-06-20 10:47:44','1'),
	('P000007','啤酒','LTC000004','四川','可口可乐，销售百年的糖水，获得了全世界额青睐0007','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0007','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog00/400/200/grey/','2019-06-19 02:25:06','1'),
	('P000008','可乐','LTC000004','广东','可口可乐，销售百年的糖水，获得了全世界额青睐0008','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0008','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog00/400/200/grey/','2019-06-17 22:17:32','1'),
	('P000009','久久鸭','LTC000005','江苏','可口可乐，销售百年的糖水，获得了全世界额青睐0009','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0009','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog00/400/200/grey/','2019-06-21 02:27:19','1'),
	('P000010','啤酒','LTC000005','安徽','可口可乐，销售百年的糖水，获得了全世界额青睐0010','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0010','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog00/400/200/grey/','2019-07-02 03:37:32','1'),
	('P000011','可乐','LTC000006','日本','可口可乐，销售百年的糖水，获得了全世界额青睐0011','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0011','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog00/400/200/grey/','2019-06-28 04:43:10','1'),
	('P000012','久久鸭','LTC000006','法国','可口可乐，销售百年的糖水，获得了全世界额青睐0012','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0012','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog00/400/200/grey/','2019-06-17 22:08:09','1'),
	('P000013','啤酒','LTC000007','四川','可口可乐，销售百年的糖水，获得了全世界额青睐0013','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0013','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog00/400/200/grey/','2019-06-23 06:07:33','1'),
	('P000014','可乐','LTC000007','广东','可口可乐，销售百年的糖水，获得了全世界额青睐0014','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0014','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog00/400/200/grey/','2019-06-15 21:37:16','1'),
	('P000015','久久鸭','LTC000008','江苏','可口可乐，销售百年的糖水，获得了全世界额青睐0015','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0015','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog00/400/200/grey/','2019-06-29 00:31:19','1'),
	('P000016','啤酒','LTC000008','安徽','可口可乐，销售百年的糖水，获得了全世界额青睐0016','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0016','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog00/400/200/grey/','2019-06-24 01:54:21','1'),
	('P000017','可乐','LTC000009','日本','可口可乐，销售百年的糖水，获得了全世界额青睐0017','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0017','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog00/400/200/grey/','2019-06-22 02:28:08','1'),
	('P000018','久久鸭','LTC000009','法国','可口可乐，销售百年的糖水，获得了全世界额青睐0018','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0018','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog00/400/200/grey/','2019-06-18 12:52:52','1'),
	('P000019','啤酒','LTC000010','四川','可口可乐，销售百年的糖水，获得了全世界额青睐0019','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0019','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog00/400/200/grey/','2019-06-20 00:22:09','1'),
	('P000020','可乐','LTC000010','广东','可口可乐，销售百年的糖水，获得了全世界额青睐0020','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0020','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog00/400/200/grey/','2019-06-22 06:33:18','1'),
	('P000021','久久鸭','LTC000011','江苏','可口可乐，销售百年的糖水，获得了全世界额青睐0021','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0021','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog00/400/200/grey/','2019-06-17 15:51:19','1'),
	('P000022','啤酒','LTC000011','安徽','可口可乐，销售百年的糖水，获得了全世界额青睐0022','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0022','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog00/400/200/grey/','2019-07-02 01:06:55','1'),
	('P000023','可乐','LTC000012','日本','可口可乐，销售百年的糖水，获得了全世界额青睐0023','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0023','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog00/400/200/grey/','2019-06-22 06:45:06','1'),
	('P000024','久久鸭','LTC000012','法国','可口可乐，销售百年的糖水，获得了全世界额青睐0024','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0024','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog00/400/200/grey/','2019-06-18 06:33:34','1'),
	('P000025','啤酒','LTC000013','四川','可口可乐，销售百年的糖水，获得了全世界额青睐0025','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0025','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog00/400/200/grey/','2019-06-25 16:25:07','1'),
	('P000026','可乐','LTC000013','广东','可口可乐，销售百年的糖水，获得了全世界额青睐0026','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0026','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog00/400/200/grey/','2019-06-23 22:45:05','1'),
	('P000027','久久鸭','LTC000014','江苏','可口可乐，销售百年的糖水，获得了全世界额青睐0027','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0027','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog00/400/200/grey/','2019-06-14 19:29:45','1'),
	('P000028','啤酒','LTC000014','安徽','可口可乐，销售百年的糖水，获得了全世界额青睐0028','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0028','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog00/400/200/grey/','2019-06-20 01:57:40','1'),
	('P000029','可乐','LTC000015','日本','可口可乐，销售百年的糖水，获得了全世界额青睐0029','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0029','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog00/400/200/grey/','2019-06-24 06:22:04','1'),
	('P000030','久久鸭','LTC000015','法国','可口可乐，销售百年的糖水，获得了全世界额青睐0030','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0030','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog00/400/200/grey/','2019-06-25 09:45:30','1'),
	('P000031','啤酒','LTC000016','四川','可口可乐，销售百年的糖水，获得了全世界额青睐0031','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0031','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog00/400/200/grey/','2019-06-26 05:17:23','1'),
	('P000032','可乐','LTC000016','广东','可口可乐，销售百年的糖水，获得了全世界额青睐0032','品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品牌品0032','https://demo.doublechaintech.com/demodata/imageManager/genImage/this is a looooooooooog00/400/200/grey/','2019-06-22 10:18:49','1');

insert into sku_data values
	('S000001','可乐-大罐的','大','P000001','TM00000000001','包装类型','包装数量等信息,包装数量等信息,包装数量等信息','1305.50','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000002','可乐-大罐的0002','中','P000001','TM000000000010002','包装类型0002','包装数量等信息,包装数量等信息,包装数量等信息0002','1153.10','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000003','可乐-大罐的0003','小','P000002','TM000000000010003','包装类型0003','包装数量等信息,包装数量等信息,包装数量等信息0003','1282.57','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000004','可乐-大罐的0004','大','P000002','TM000000000010004','包装类型0004','包装数量等信息,包装数量等信息,包装数量等信息0004','1106.00','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000005','可乐-大罐的0005','中','P000003','TM000000000010005','包装类型0005','包装数量等信息,包装数量等信息,包装数量等信息0005','965.78','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000006','可乐-大罐的0006','小','P000003','TM000000000010006','包装类型0006','包装数量等信息,包装数量等信息,包装数量等信息0006','1009.88','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000007','可乐-大罐的0007','大','P000004','TM000000000010007','包装类型0007','包装数量等信息,包装数量等信息,包装数量等信息0007','1063.70','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000008','可乐-大罐的0008','中','P000004','TM000000000010008','包装类型0008','包装数量等信息,包装数量等信息,包装数量等信息0008','990.71','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000009','可乐-大罐的0009','小','P000005','TM000000000010009','包装类型0009','包装数量等信息,包装数量等信息,包装数量等信息0009','1218.16','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000010','可乐-大罐的0010','大','P000005','TM000000000010010','包装类型0010','包装数量等信息,包装数量等信息,包装数量等信息0010','935.91','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000011','可乐-大罐的0011','中','P000006','TM000000000010011','包装类型0011','包装数量等信息,包装数量等信息,包装数量等信息0011','1042.85','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000012','可乐-大罐的0012','小','P000006','TM000000000010012','包装类型0012','包装数量等信息,包装数量等信息,包装数量等信息0012','1296.21','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000013','可乐-大罐的0013','大','P000007','TM000000000010013','包装类型0013','包装数量等信息,包装数量等信息,包装数量等信息0013','1229.59','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000014','可乐-大罐的0014','中','P000007','TM000000000010014','包装类型0014','包装数量等信息,包装数量等信息,包装数量等信息0014','1299.05','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000015','可乐-大罐的0015','小','P000008','TM000000000010015','包装类型0015','包装数量等信息,包装数量等信息,包装数量等信息0015','1147.87','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000016','可乐-大罐的0016','大','P000008','TM000000000010016','包装类型0016','包装数量等信息,包装数量等信息,包装数量等信息0016','1140.09','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000017','可乐-大罐的0017','中','P000009','TM000000000010017','包装类型0017','包装数量等信息,包装数量等信息,包装数量等信息0017','967.62','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000018','可乐-大罐的0018','小','P000009','TM000000000010018','包装类型0018','包装数量等信息,包装数量等信息,包装数量等信息0018','1212.61','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000019','可乐-大罐的0019','大','P000010','TM000000000010019','包装类型0019','包装数量等信息,包装数量等信息,包装数量等信息0019','1314.78','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000020','可乐-大罐的0020','中','P000010','TM000000000010020','包装类型0020','包装数量等信息,包装数量等信息,包装数量等信息0020','1297.46','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000021','可乐-大罐的0021','小','P000011','TM000000000010021','包装类型0021','包装数量等信息,包装数量等信息,包装数量等信息0021','1230.65','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000022','可乐-大罐的0022','大','P000011','TM000000000010022','包装类型0022','包装数量等信息,包装数量等信息,包装数量等信息0022','1319.18','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000023','可乐-大罐的0023','中','P000012','TM000000000010023','包装类型0023','包装数量等信息,包装数量等信息,包装数量等信息0023','1110.41','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000024','可乐-大罐的0024','小','P000012','TM000000000010024','包装类型0024','包装数量等信息,包装数量等信息,包装数量等信息0024','1049.43','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000025','可乐-大罐的0025','大','P000013','TM000000000010025','包装类型0025','包装数量等信息,包装数量等信息,包装数量等信息0025','1164.40','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000026','可乐-大罐的0026','中','P000013','TM000000000010026','包装类型0026','包装数量等信息,包装数量等信息,包装数量等信息0026','1092.68','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000027','可乐-大罐的0027','小','P000014','TM000000000010027','包装类型0027','包装数量等信息,包装数量等信息,包装数量等信息0027','1037.26','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000028','可乐-大罐的0028','大','P000014','TM000000000010028','包装类型0028','包装数量等信息,包装数量等信息,包装数量等信息0028','1296.31','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000029','可乐-大罐的0029','中','P000015','TM000000000010029','包装类型0029','包装数量等信息,包装数量等信息,包装数量等信息0029','1278.21','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000030','可乐-大罐的0030','小','P000015','TM000000000010030','包装类型0030','包装数量等信息,包装数量等信息,包装数量等信息0030','1158.63','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000031','可乐-大罐的0031','大','P000016','TM000000000010031','包装类型0031','包装数量等信息,包装数量等信息,包装数量等信息0031','1188.10','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000032','可乐-大罐的0032','中','P000016','TM000000000010032','包装类型0032','包装数量等信息,包装数量等信息,包装数量等信息0032','1189.66','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000033','可乐-大罐的0033','小','P000017','TM000000000010033','包装类型0033','包装数量等信息,包装数量等信息,包装数量等信息0033','1060.56','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000034','可乐-大罐的0034','大','P000017','TM000000000010034','包装类型0034','包装数量等信息,包装数量等信息,包装数量等信息0034','938.43','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000035','可乐-大罐的0035','中','P000018','TM000000000010035','包装类型0035','包装数量等信息,包装数量等信息,包装数量等信息0035','993.59','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000036','可乐-大罐的0036','小','P000018','TM000000000010036','包装类型0036','包装数量等信息,包装数量等信息,包装数量等信息0036','1139.96','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000037','可乐-大罐的0037','大','P000019','TM000000000010037','包装类型0037','包装数量等信息,包装数量等信息,包装数量等信息0037','968.32','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000038','可乐-大罐的0038','中','P000019','TM000000000010038','包装类型0038','包装数量等信息,包装数量等信息,包装数量等信息0038','1217.79','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000039','可乐-大罐的0039','小','P000020','TM000000000010039','包装类型0039','包装数量等信息,包装数量等信息,包装数量等信息0039','1250.59','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000040','可乐-大罐的0040','大','P000020','TM000000000010040','包装类型0040','包装数量等信息,包装数量等信息,包装数量等信息0040','1022.55','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000041','可乐-大罐的0041','中','P000021','TM000000000010041','包装类型0041','包装数量等信息,包装数量等信息,包装数量等信息0041','1014.74','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000042','可乐-大罐的0042','小','P000021','TM000000000010042','包装类型0042','包装数量等信息,包装数量等信息,包装数量等信息0042','1019.86','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000043','可乐-大罐的0043','大','P000022','TM000000000010043','包装类型0043','包装数量等信息,包装数量等信息,包装数量等信息0043','1194.01','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000044','可乐-大罐的0044','中','P000022','TM000000000010044','包装类型0044','包装数量等信息,包装数量等信息,包装数量等信息0044','1233.50','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000045','可乐-大罐的0045','小','P000023','TM000000000010045','包装类型0045','包装数量等信息,包装数量等信息,包装数量等信息0045','1089.99','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000046','可乐-大罐的0046','大','P000023','TM000000000010046','包装类型0046','包装数量等信息,包装数量等信息,包装数量等信息0046','1006.30','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000047','可乐-大罐的0047','中','P000024','TM000000000010047','包装类型0047','包装数量等信息,包装数量等信息,包装数量等信息0047','1240.28','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000048','可乐-大罐的0048','小','P000024','TM000000000010048','包装类型0048','包装数量等信息,包装数量等信息,包装数量等信息0048','1303.98','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000049','可乐-大罐的0049','大','P000025','TM000000000010049','包装类型0049','包装数量等信息,包装数量等信息,包装数量等信息0049','1094.22','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000050','可乐-大罐的0050','中','P000025','TM000000000010050','包装类型0050','包装数量等信息,包装数量等信息,包装数量等信息0050','1018.37','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000051','可乐-大罐的0051','小','P000026','TM000000000010051','包装类型0051','包装数量等信息,包装数量等信息,包装数量等信息0051','1075.54','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000052','可乐-大罐的0052','大','P000026','TM000000000010052','包装类型0052','包装数量等信息,包装数量等信息,包装数量等信息0052','1249.08','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000053','可乐-大罐的0053','中','P000027','TM000000000010053','包装类型0053','包装数量等信息,包装数量等信息,包装数量等信息0053','929.49','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000054','可乐-大罐的0054','小','P000027','TM000000000010054','包装类型0054','包装数量等信息,包装数量等信息,包装数量等信息0054','996.65','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000055','可乐-大罐的0055','大','P000028','TM000000000010055','包装类型0055','包装数量等信息,包装数量等信息,包装数量等信息0055','1196.97','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000056','可乐-大罐的0056','中','P000028','TM000000000010056','包装类型0056','包装数量等信息,包装数量等信息,包装数量等信息0056','1034.84','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000057','可乐-大罐的0057','小','P000029','TM000000000010057','包装类型0057','包装数量等信息,包装数量等信息,包装数量等信息0057','1060.22','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000058','可乐-大罐的0058','大','P000029','TM000000000010058','包装类型0058','包装数量等信息,包装数量等信息,包装数量等信息0058','998.11','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000059','可乐-大罐的0059','中','P000030','TM000000000010059','包装类型0059','包装数量等信息,包装数量等信息,包装数量等信息0059','1190.25','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000060','可乐-大罐的0060','小','P000030','TM000000000010060','包装类型0060','包装数量等信息,包装数量等信息,包装数量等信息0060','1211.14','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000061','可乐-大罐的0061','大','P000031','TM000000000010061','包装类型0061','包装数量等信息,包装数量等信息,包装数量等信息0061','933.18','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000062','可乐-大罐的0062','中','P000031','TM000000000010062','包装类型0062','包装数量等信息,包装数量等信息,包装数量等信息0062','957.33','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000063','可乐-大罐的0063','小','P000032','TM000000000010063','包装类型0063','包装数量等信息,包装数量等信息,包装数量等信息0063','1076.53','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1'),
	('S000064','可乐-大罐的0064','大','P000032','TM000000000010064','包装类型0064','包装数量等信息,包装数量等信息,包装数量等信息0064','1116.93','https://demo.doublechaintech.com/demodata/imageManager/genImage/coco00/400/200/grey/','1');

insert into retail_store_province_center_data values
	('RSPC000001','双链小超四川省运营中心','2019-06-28','RSCC000001','2019-06-19 23:35:01','1'),
	('RSPC000002','双链小超北京运营中心','2019-01-27','RSCC000003','2019-06-25 16:04:30','1');

insert into province_center_department_data values
	('PCD000001','供应链部','2017-11-28','RSPC000001','刘强','1'),
	('PCD000002','采购部','2017-07-06','RSPC000001','王德宏','1'),
	('PCD000003','管理部','2016-12-04','RSPC000001','刘强','1'),
	('PCD000004','财务部','2016-12-15','RSPC000001','王德宏','1'),
	('PCD000005','法务部','2017-06-14','RSPC000002','刘强','1'),
	('PCD000006','市场部','2018-12-20','RSPC000002','王德宏','1'),
	('PCD000007','人力资源部','2018-07-01','RSPC000002','刘强','1');

insert into province_center_employee_data values
	('PCE000001','刘强','13999998888','wangdehong@yatang.cn','2017-01-19','PCD000001','RSPC000001','1'),
	('PCE000002','王德宏','13900000002','liuqiang@yatang.cn','2017-10-01','PCD000001','RSPC000001','1'),
	('PCE000003','刘强','13900000003','wangdehong@yatang.cn','2018-04-12','PCD000002','RSPC000001','1'),
	('PCE000004','王德宏','13900000004','liuqiang@yatang.cn','2018-08-24','PCD000003','RSPC000001','1'),
	('PCE000005','刘强','13900000005','wangdehong@yatang.cn','2017-03-13','PCD000004','RSPC000002','1'),
	('PCE000006','王德宏','13900000006','liuqiang@yatang.cn','2019-05-04','PCD000005','RSPC000002','1'),
	('PCE000007','刘强','13900000007','wangdehong@yatang.cn','2017-10-22','PCD000006','RSPC000002','1'),
	('PCE000008','王德宏','13900000008','liuqiang@yatang.cn','2017-09-18','PCD000007','RSPC000002','1');

insert into retail_store_city_service_center_data values
	('RSCSC000001','双链小超成都办事处','2019-02-07','RSPC000001','2019-06-25 20:16:44','1'),
	('RSCSC000002','双链小超绵阳办事处','2017-02-16','RSPC000001','2019-06-20 06:23:09','1'),
	('RSCSC000003','双链小超巴中办事处','2018-07-02','RSPC000002','2019-06-28 13:06:55','1'),
	('RSCSC000004','双链小超成都办事处','2017-02-16','RSPC000002','2019-06-14 23:42:10','1');

insert into city_partner_data values
	('CP000001','曾倩','13677778888','RSCSC000001','负责开拓市场，具有极强的开拓能力','2019-06-26 16:18:29','1'),
	('CP000002','黄风格','13900000002','RSCSC000001','负责开拓市场，具有极强的开拓能力0002','2019-06-13 17:26:21','1'),
	('CP000003','郭超','13900000003','RSCSC000002','负责开拓市场，具有极强的开拓能力0003','2019-06-13 03:34:36','1'),
	('CP000004','曾倩','13900000004','RSCSC000002','负责开拓市场，具有极强的开拓能力0004','2019-06-23 09:46:01','1'),
	('CP000005','黄风格','13900000005','RSCSC000003','负责开拓市场，具有极强的开拓能力0005','2019-06-16 07:08:08','1'),
	('CP000006','郭超','13900000006','RSCSC000003','负责开拓市场，具有极强的开拓能力0006','2019-06-16 20:15:18','1'),
	('CP000007','曾倩','13900000007','RSCSC000004','负责开拓市场，具有极强的开拓能力0007','2019-06-22 23:12:03','1'),
	('CP000008','黄风格','13900000008','RSCSC000004','负责开拓市场，具有极强的开拓能力0008','2019-06-16 18:44:42','1');

insert into potential_customer_data values
	('PC000001','曾倩','13677778888','RSCSC000001','CP000001','负责开拓市场，具有极强的开拓能力','2019-06-19 16:53:04','1'),
	('PC000002','黄风格','13900000002','RSCSC000001','CP000001','负责开拓市场，具有极强的开拓能力0002','2019-06-16 14:27:52','1'),
	('PC000003','郭超','13900000003','RSCSC000001','CP000002','负责开拓市场，具有极强的开拓能力0003','2019-06-12 13:08:56','1'),
	('PC000004','曾倩','13900000004','RSCSC000001','CP000002','负责开拓市场，具有极强的开拓能力0004','2019-07-02 04:27:35','1'),
	('PC000005','黄风格','13900000005','RSCSC000002','CP000003','负责开拓市场，具有极强的开拓能力0005','2019-06-30 07:19:12','1'),
	('PC000006','郭超','13900000006','RSCSC000002','CP000003','负责开拓市场，具有极强的开拓能力0006','2019-06-15 20:57:05','1'),
	('PC000007','曾倩','13900000007','RSCSC000002','CP000004','负责开拓市场，具有极强的开拓能力0007','2019-06-23 19:40:25','1'),
	('PC000008','黄风格','13900000008','RSCSC000002','CP000004','负责开拓市场，具有极强的开拓能力0008','2019-07-03 17:27:19','1'),
	('PC000009','郭超','13900000009','RSCSC000003','CP000005','负责开拓市场，具有极强的开拓能力0009','2019-06-22 17:10:55','1'),
	('PC000010','曾倩','13900000010','RSCSC000003','CP000005','负责开拓市场，具有极强的开拓能力0010','2019-06-18 14:04:08','1'),
	('PC000011','黄风格','13900000011','RSCSC000003','CP000006','负责开拓市场，具有极强的开拓能力0011','2019-06-23 01:36:15','1'),
	('PC000012','郭超','13900000012','RSCSC000003','CP000006','负责开拓市场，具有极强的开拓能力0012','2019-06-15 03:51:37','1'),
	('PC000013','曾倩','13900000013','RSCSC000004','CP000007','负责开拓市场，具有极强的开拓能力0013','2019-06-26 19:14:08','1'),
	('PC000014','黄风格','13900000014','RSCSC000004','CP000007','负责开拓市场，具有极强的开拓能力0014','2019-06-19 19:11:33','1'),
	('PC000015','郭超','13900000015','RSCSC000004','CP000008','负责开拓市场，具有极强的开拓能力0015','2019-06-25 05:59:54','1'),
	('PC000016','曾倩','13900000016','RSCSC000004','CP000008','负责开拓市场，具有极强的开拓能力0016','2019-07-02 10:46:04','1');

insert into potential_customer_contact_person_data values
	('PCCP000001','赵先生','13677778888','PC000001','这人在决策中战友较大的权重，密切观察中.....','1'),
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
	('PCC000001','和连载客户的联系记录','2019-01-15','电话','PC000001','CP000001','PCCP000001','转化希望很大','2019-06-28 14:57:56','1'),
	('PCC000002','和连载客户的联系记录0002','2017-08-06','短信','PC000001','CP000001','PCCP000001','转化希望很大0002','2019-07-01 09:00:28','1'),
	('PCC000003','和连载客户的联系记录0003','2019-05-03','登门拜访','PC000001','CP000001','PCCP000002','转化希望很大0003','2019-06-30 11:01:37','1'),
	('PCC000004','和连载客户的联系记录0004','2018-11-03','活动聊天','PC000001','CP000001','PCCP000002','转化希望很大0004','2019-07-02 17:47:01','1'),
	('PCC000005','和连载客户的联系记录0005','2016-07-21','电话','PC000002','CP000001','PCCP000003','转化希望很大0005','2019-06-16 10:01:21','1'),
	('PCC000006','和连载客户的联系记录0006','2018-05-05','短信','PC000002','CP000001','PCCP000003','转化希望很大0006','2019-06-24 23:03:06','1'),
	('PCC000007','和连载客户的联系记录0007','2017-10-29','登门拜访','PC000002','CP000001','PCCP000004','转化希望很大0007','2019-06-19 06:07:00','1'),
	('PCC000008','和连载客户的联系记录0008','2017-11-19','活动聊天','PC000002','CP000001','PCCP000004','转化希望很大0008','2019-06-17 19:33:51','1'),
	('PCC000009','和连载客户的联系记录0009','2018-05-07','电话','PC000003','CP000002','PCCP000005','转化希望很大0009','2019-06-22 07:28:59','1'),
	('PCC000010','和连载客户的联系记录0010','2016-07-12','短信','PC000003','CP000002','PCCP000005','转化希望很大0010','2019-06-14 10:21:25','1'),
	('PCC000011','和连载客户的联系记录0011','2018-09-22','登门拜访','PC000003','CP000002','PCCP000006','转化希望很大0011','2019-06-23 00:31:01','1'),
	('PCC000012','和连载客户的联系记录0012','2016-10-07','活动聊天','PC000003','CP000002','PCCP000006','转化希望很大0012','2019-06-30 04:45:16','1'),
	('PCC000013','和连载客户的联系记录0013','2018-01-03','电话','PC000004','CP000002','PCCP000007','转化希望很大0013','2019-07-04 00:25:30','1'),
	('PCC000014','和连载客户的联系记录0014','2017-01-12','短信','PC000004','CP000002','PCCP000007','转化希望很大0014','2019-06-19 01:52:30','1'),
	('PCC000015','和连载客户的联系记录0015','2018-10-27','登门拜访','PC000004','CP000002','PCCP000008','转化希望很大0015','2019-06-13 06:45:38','1'),
	('PCC000016','和连载客户的联系记录0016','2018-10-08','活动聊天','PC000004','CP000002','PCCP000008','转化希望很大0016','2019-06-17 10:21:34','1'),
	('PCC000017','和连载客户的联系记录0017','2019-05-09','电话','PC000005','CP000003','PCCP000009','转化希望很大0017','2019-06-16 22:38:18','1'),
	('PCC000018','和连载客户的联系记录0018','2017-02-23','短信','PC000005','CP000003','PCCP000009','转化希望很大0018','2019-07-03 22:12:29','1'),
	('PCC000019','和连载客户的联系记录0019','2018-12-16','登门拜访','PC000005','CP000003','PCCP000010','转化希望很大0019','2019-06-15 23:31:22','1'),
	('PCC000020','和连载客户的联系记录0020','2018-12-07','活动聊天','PC000005','CP000003','PCCP000010','转化希望很大0020','2019-06-26 11:36:08','1'),
	('PCC000021','和连载客户的联系记录0021','2017-09-20','电话','PC000006','CP000003','PCCP000011','转化希望很大0021','2019-06-30 10:53:55','1'),
	('PCC000022','和连载客户的联系记录0022','2017-12-13','短信','PC000006','CP000003','PCCP000011','转化希望很大0022','2019-06-19 19:35:40','1'),
	('PCC000023','和连载客户的联系记录0023','2018-07-26','登门拜访','PC000006','CP000003','PCCP000012','转化希望很大0023','2019-06-22 13:44:51','1'),
	('PCC000024','和连载客户的联系记录0024','2017-04-23','活动聊天','PC000006','CP000003','PCCP000012','转化希望很大0024','2019-06-15 08:35:44','1'),
	('PCC000025','和连载客户的联系记录0025','2018-02-25','电话','PC000007','CP000004','PCCP000013','转化希望很大0025','2019-06-17 11:24:50','1'),
	('PCC000026','和连载客户的联系记录0026','2017-08-17','短信','PC000007','CP000004','PCCP000013','转化希望很大0026','2019-07-03 22:38:48','1'),
	('PCC000027','和连载客户的联系记录0027','2019-04-21','登门拜访','PC000007','CP000004','PCCP000014','转化希望很大0027','2019-06-27 05:06:41','1'),
	('PCC000028','和连载客户的联系记录0028','2019-05-25','活动聊天','PC000007','CP000004','PCCP000014','转化希望很大0028','2019-06-23 04:09:06','1'),
	('PCC000029','和连载客户的联系记录0029','2018-07-28','电话','PC000008','CP000004','PCCP000015','转化希望很大0029','2019-06-21 00:25:37','1'),
	('PCC000030','和连载客户的联系记录0030','2016-12-04','短信','PC000008','CP000004','PCCP000015','转化希望很大0030','2019-06-18 10:15:54','1'),
	('PCC000031','和连载客户的联系记录0031','2017-03-09','登门拜访','PC000008','CP000004','PCCP000016','转化希望很大0031','2019-06-26 13:18:20','1'),
	('PCC000032','和连载客户的联系记录0032','2018-05-08','活动聊天','PC000008','CP000004','PCCP000016','转化希望很大0032','2019-06-21 22:27:28','1'),
	('PCC000033','和连载客户的联系记录0033','2018-09-04','电话','PC000009','CP000005','PCCP000017','转化希望很大0033','2019-07-01 18:44:40','1'),
	('PCC000034','和连载客户的联系记录0034','2016-09-16','短信','PC000009','CP000005','PCCP000017','转化希望很大0034','2019-06-18 07:45:31','1'),
	('PCC000035','和连载客户的联系记录0035','2017-05-14','登门拜访','PC000009','CP000005','PCCP000018','转化希望很大0035','2019-06-21 06:24:33','1'),
	('PCC000036','和连载客户的联系记录0036','2017-04-20','活动聊天','PC000009','CP000005','PCCP000018','转化希望很大0036','2019-06-27 00:56:54','1'),
	('PCC000037','和连载客户的联系记录0037','2017-01-22','电话','PC000010','CP000005','PCCP000019','转化希望很大0037','2019-07-04 06:34:34','1'),
	('PCC000038','和连载客户的联系记录0038','2018-04-16','短信','PC000010','CP000005','PCCP000019','转化希望很大0038','2019-06-29 02:24:02','1'),
	('PCC000039','和连载客户的联系记录0039','2019-06-03','登门拜访','PC000010','CP000005','PCCP000020','转化希望很大0039','2019-06-20 00:50:20','1'),
	('PCC000040','和连载客户的联系记录0040','2018-10-31','活动聊天','PC000010','CP000005','PCCP000020','转化希望很大0040','2019-06-19 15:54:07','1'),
	('PCC000041','和连载客户的联系记录0041','2016-10-28','电话','PC000011','CP000006','PCCP000021','转化希望很大0041','2019-06-14 01:15:45','1'),
	('PCC000042','和连载客户的联系记录0042','2017-01-10','短信','PC000011','CP000006','PCCP000021','转化希望很大0042','2019-06-15 00:38:47','1'),
	('PCC000043','和连载客户的联系记录0043','2017-10-19','登门拜访','PC000011','CP000006','PCCP000022','转化希望很大0043','2019-06-30 09:08:51','1'),
	('PCC000044','和连载客户的联系记录0044','2017-06-19','活动聊天','PC000011','CP000006','PCCP000022','转化希望很大0044','2019-06-28 03:17:14','1'),
	('PCC000045','和连载客户的联系记录0045','2018-09-17','电话','PC000012','CP000006','PCCP000023','转化希望很大0045','2019-06-22 15:51:53','1'),
	('PCC000046','和连载客户的联系记录0046','2019-05-01','短信','PC000012','CP000006','PCCP000023','转化希望很大0046','2019-07-02 03:50:32','1'),
	('PCC000047','和连载客户的联系记录0047','2017-10-22','登门拜访','PC000012','CP000006','PCCP000024','转化希望很大0047','2019-06-26 03:21:03','1'),
	('PCC000048','和连载客户的联系记录0048','2016-09-13','活动聊天','PC000012','CP000006','PCCP000024','转化希望很大0048','2019-06-20 00:35:23','1'),
	('PCC000049','和连载客户的联系记录0049','2017-06-27','电话','PC000013','CP000007','PCCP000025','转化希望很大0049','2019-06-30 00:47:56','1'),
	('PCC000050','和连载客户的联系记录0050','2018-01-26','短信','PC000013','CP000007','PCCP000025','转化希望很大0050','2019-06-22 19:27:06','1'),
	('PCC000051','和连载客户的联系记录0051','2017-04-18','登门拜访','PC000013','CP000007','PCCP000026','转化希望很大0051','2019-06-18 06:27:48','1'),
	('PCC000052','和连载客户的联系记录0052','2017-12-19','活动聊天','PC000013','CP000007','PCCP000026','转化希望很大0052','2019-06-28 14:44:54','1'),
	('PCC000053','和连载客户的联系记录0053','2018-02-14','电话','PC000014','CP000007','PCCP000027','转化希望很大0053','2019-06-22 06:53:27','1'),
	('PCC000054','和连载客户的联系记录0054','2018-02-02','短信','PC000014','CP000007','PCCP000027','转化希望很大0054','2019-06-14 13:01:51','1'),
	('PCC000055','和连载客户的联系记录0055','2018-11-15','登门拜访','PC000014','CP000007','PCCP000028','转化希望很大0055','2019-07-02 16:19:06','1'),
	('PCC000056','和连载客户的联系记录0056','2016-07-11','活动聊天','PC000014','CP000007','PCCP000028','转化希望很大0056','2019-06-23 05:31:24','1'),
	('PCC000057','和连载客户的联系记录0057','2016-12-31','电话','PC000015','CP000008','PCCP000029','转化希望很大0057','2019-06-19 22:01:54','1'),
	('PCC000058','和连载客户的联系记录0058','2018-03-19','短信','PC000015','CP000008','PCCP000029','转化希望很大0058','2019-06-16 19:58:40','1'),
	('PCC000059','和连载客户的联系记录0059','2018-05-17','登门拜访','PC000015','CP000008','PCCP000030','转化希望很大0059','2019-06-23 05:09:02','1'),
	('PCC000060','和连载客户的联系记录0060','2019-03-11','活动聊天','PC000015','CP000008','PCCP000030','转化希望很大0060','2019-06-23 17:02:02','1'),
	('PCC000061','和连载客户的联系记录0061','2017-03-11','电话','PC000016','CP000008','PCCP000031','转化希望很大0061','2019-06-25 09:00:31','1'),
	('PCC000062','和连载客户的联系记录0062','2019-01-14','短信','PC000016','CP000008','PCCP000031','转化希望很大0062','2019-06-30 21:05:01','1'),
	('PCC000063','和连载客户的联系记录0063','2017-11-19','登门拜访','PC000016','CP000008','PCCP000032','转化希望很大0063','2019-06-16 05:01:20','1'),
	('PCC000064','和连载客户的联系记录0064','2018-05-18','活动聊天','PC000016','CP000008','PCCP000032','转化希望很大0064','2019-06-23 04:47:01','1');

insert into city_event_data values
	('CE000001','小超见面会','13677778888','RSCSC000001','给大家讲解小超的发展蓝图','2019-06-27 06:16:25','1'),
	('CE000002','双链小超说明会','13900000002','RSCSC000001','给大家讲解小超的发展蓝图0002','2019-06-23 23:29:36','1'),
	('CE000003','小超见面会','13900000003','RSCSC000002','给大家讲解小超的发展蓝图0003','2019-06-26 04:24:54','1'),
	('CE000004','双链小超说明会','13900000004','RSCSC000002','给大家讲解小超的发展蓝图0004','2019-06-24 03:43:05','1'),
	('CE000005','小超见面会','13900000005','RSCSC000003','给大家讲解小超的发展蓝图0005','2019-07-04 07:21:42','1'),
	('CE000006','双链小超说明会','13900000006','RSCSC000003','给大家讲解小超的发展蓝图0006','2019-06-22 00:33:59','1'),
	('CE000007','小超见面会','13900000007','RSCSC000004','给大家讲解小超的发展蓝图0007','2019-06-15 07:08:12','1'),
	('CE000008','双链小超说明会','13900000008','RSCSC000004','给大家讲解小超的发展蓝图0008','2019-07-03 11:18:31','1');

insert into event_attendance_data values
	('EA000001','小超见面会参加信息','PC000001','CE000001','体会不错，考虑加盟','1'),
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
	('RS000001','中和社区小超','02887654321','吕刚','RSCC000001','RSCSC000001',NULL,NULL,NULL,NULL,NULL,NULL,'2017-01-03','40.019385102072135','129.85867774382103','啤酒饮料矿泉水，香肠瓜子方便面, 请让一让','2019-07-03 08:16:18','CREATED','1'),
	('RS000002','华阳社区小超','028876543210002','吕刚0002','RSCC000001','RSCSC000001',NULL,NULL,NULL,NULL,NULL,NULL,'2016-08-28','40.924453882325366','131.17451415413242','啤酒饮料矿泉水，香肠瓜子方便面, 请让一让0002','2019-06-24 22:58:24','INVESTMENT_INVITED','1'),
	('RS000003','大源社区小超','028876543210003','吕刚0003','RSCC000002','RSCSC000002',NULL,NULL,NULL,NULL,NULL,NULL,'2018-10-26','41.862799317693195','129.5486621184936','啤酒饮料矿泉水，香肠瓜子方便面, 请让一让0003','2019-06-17 06:53:10','FRANCHISED','1'),
	('RS000004','中和社区小超','028876543210004','吕刚0004','RSCC000002','RSCSC000002',NULL,NULL,NULL,NULL,NULL,NULL,'2018-11-14','42.0994561080911','129.43115826862734','啤酒饮料矿泉水，香肠瓜子方便面, 请让一让0004','2019-06-20 23:02:35','DECORATED','1'),
	('RS000005','华阳社区小超','028876543210005','吕刚0005','RSCC000003','RSCSC000003',NULL,NULL,NULL,NULL,NULL,NULL,'2017-11-29','40.102173243024694','131.2424851325184','啤酒饮料矿泉水，香肠瓜子方便面, 请让一让0005','2019-06-28 17:42:07','OPENNED','1'),
	('RS000006','大源社区小超','028876543210006','吕刚0006','RSCC000003','RSCSC000003',NULL,NULL,NULL,NULL,NULL,NULL,'2016-11-16','40.605955947848116','129.43961556413467','啤酒饮料矿泉水，香肠瓜子方便面, 请让一让0006','2019-06-19 16:21:43','CLOSED','1'),
	('RS000007','中和社区小超','028876543210007','吕刚0007','RSCC000004','RSCSC000004',NULL,NULL,NULL,NULL,NULL,NULL,'2018-12-19','42.04815469314002','130.09059702155204','啤酒饮料矿泉水，香肠瓜子方便面, 请让一让0007','2019-06-30 22:02:53','CREATED','1'),
	('RS000008','华阳社区小超','028876543210008','吕刚0008','RSCC000004','RSCSC000004',NULL,NULL,NULL,NULL,NULL,NULL,'2018-09-22','41.9261945412515','130.2868699676205','啤酒饮料矿泉水，香肠瓜子方便面, 请让一让0008','2019-06-14 11:33:41','INVESTMENT_INVITED','1');

insert into retail_store_creation_data values
	('RSC000001','已经建好了','1');

insert into retail_store_investment_invitation_data values
	('RSII000001','欢迎前来咨询','1');

insert into retail_store_franchising_data values
	('RSF000001','谢谢加盟','1');

insert into retail_store_decoration_data values
	('RSD000001','装修','1');

insert into retail_store_opening_data values
	('RSO000001','装修','1');

insert into retail_store_closing_data values
	('RSC000001','关闭','1');

insert into retail_store_member_data values
	('RSM000001','李亚青','18099887766','RSCC000001','1'),
	('RSM000002','李亚青0002','13900000002','RSCC000003','1');

insert into consumer_order_data values
	('CO000001','消费订单','RSM000001',NULL,NULL,NULL,NULL,NULL,'RS000001','2019-06-17 19:35:22','CONFIRMED','1'),
	('CO000002','消费订单0002','RSM000001',NULL,NULL,NULL,NULL,NULL,'RS000001','2019-06-26 15:44:57','APPROVED','1'),
	('CO000003','消费订单0003','RSM000001',NULL,NULL,NULL,NULL,NULL,'RS000002','2019-06-30 11:47:51','PROCESSED','1'),
	('CO000004','消费订单0004','RSM000001',NULL,NULL,NULL,NULL,NULL,'RS000002','2019-06-26 05:00:13','SHIPPED','1'),
	('CO000005','消费订单0005','RSM000001',NULL,NULL,NULL,NULL,NULL,'RS000003','2019-06-19 15:18:06','DELIVERED','1'),
	('CO000006','消费订单0006','RSM000001',NULL,NULL,NULL,NULL,NULL,'RS000003','2019-06-20 13:13:04','CONFIRMED','1'),
	('CO000007','消费订单0007','RSM000001',NULL,NULL,NULL,NULL,NULL,'RS000004','2019-06-28 11:55:43','APPROVED','1'),
	('CO000008','消费订单0008','RSM000001',NULL,NULL,NULL,NULL,NULL,'RS000004','2019-06-15 22:55:59','PROCESSED','1'),
	('CO000009','消费订单0009','RSM000002',NULL,NULL,NULL,NULL,NULL,'RS000005','2019-06-26 22:57:28','SHIPPED','1'),
	('CO000010','消费订单0010','RSM000002',NULL,NULL,NULL,NULL,NULL,'RS000005','2019-07-01 08:58:12','DELIVERED','1'),
	('CO000011','消费订单0011','RSM000002',NULL,NULL,NULL,NULL,NULL,'RS000006','2019-06-16 09:03:15','CONFIRMED','1'),
	('CO000012','消费订单0012','RSM000002',NULL,NULL,NULL,NULL,NULL,'RS000006','2019-06-30 23:57:38','APPROVED','1'),
	('CO000013','消费订单0013','RSM000002',NULL,NULL,NULL,NULL,NULL,'RS000007','2019-07-02 02:55:54','PROCESSED','1'),
	('CO000014','消费订单0014','RSM000002',NULL,NULL,NULL,NULL,NULL,'RS000007','2019-06-24 11:42:44','SHIPPED','1'),
	('CO000015','消费订单0015','RSM000002',NULL,NULL,NULL,NULL,NULL,'RS000008','2019-06-14 15:41:33','DELIVERED','1'),
	('CO000016','消费订单0016','RSM000002',NULL,NULL,NULL,NULL,NULL,'RS000008','2019-06-28 16:41:21','CONFIRMED','1');

insert into consumer_order_confirmation_data values
	('COC000001','确认者','2018-02-26','1');

insert into consumer_order_approval_data values
	('COA000001','批准者','2016-12-18','1');

insert into consumer_order_processing_data values
	('COP000001','处理者','2018-12-20','1');

insert into consumer_order_shipment_data values
	('COS000001','运货者','2018-07-23','1');

insert into consumer_order_delivery_data values
	('COD000001','送货者','2017-08-03','1');

insert into consumer_order_line_item_data values
	('COLI000001','CO000001','SKU','大瓶可乐','5.81','927.56','7789.58','2019-06-26 01:48:35','1'),
	('COLI000002','CO000001','SKU0002','大瓶可乐0002','5.57','735.32','7758.35','2019-06-27 16:16:28','1'),
	('COLI000003','CO000002','SKU0003','大瓶可乐0003','5.20','935.22','9723.54','2019-06-25 20:14:48','1'),
	('COLI000004','CO000002','SKU0004','大瓶可乐0004','4.80','953.95','8025.12','2019-06-19 12:01:17','1'),
	('COLI000005','CO000003','SKU0005','大瓶可乐0005','5.23','770.07','9710.77','2019-06-12 19:23:23','1'),
	('COLI000006','CO000003','SKU0006','大瓶可乐0006','4.91','718.27','9849.42','2019-06-26 18:11:10','1'),
	('COLI000007','CO000004','SKU0007','大瓶可乐0007','4.21','749.70','8398.75','2019-06-27 12:44:26','1'),
	('COLI000008','CO000004','SKU0008','大瓶可乐0008','4.76','770.44','7351.38','2019-06-30 19:28:35','1'),
	('COLI000009','CO000005','SKU0009','大瓶可乐0009','5.13','906.83','7788.04','2019-06-25 13:00:53','1'),
	('COLI000010','CO000005','SKU0010','大瓶可乐0010','4.56','914.36','9025.14','2019-06-15 17:29:36','1'),
	('COLI000011','CO000006','SKU0011','大瓶可乐0011','5.86','854.94','7260.32','2019-06-17 19:58:20','1'),
	('COLI000012','CO000006','SKU0012','大瓶可乐0012','4.94','716.52','7991.53','2019-06-25 23:47:49','1'),
	('COLI000013','CO000007','SKU0013','大瓶可乐0013','4.76','738.18','9013.47','2019-06-23 05:12:26','1'),
	('COLI000014','CO000007','SKU0014','大瓶可乐0014','4.30','934.50','9979.87','2019-06-29 23:07:38','1'),
	('COLI000015','CO000008','SKU0015','大瓶可乐0015','5.34','883.35','9360.77','2019-06-29 18:20:20','1'),
	('COLI000016','CO000008','SKU0016','大瓶可乐0016','4.60','853.00','8121.25','2019-06-29 22:32:01','1'),
	('COLI000017','CO000009','SKU0017','大瓶可乐0017','4.43','996.35','8601.15','2019-06-14 15:15:59','1'),
	('COLI000018','CO000009','SKU0018','大瓶可乐0018','4.55','732.69','8885.07','2019-07-02 20:45:54','1'),
	('COLI000019','CO000010','SKU0019','大瓶可乐0019','5.68','870.91','8417.61','2019-07-03 09:20:05','1'),
	('COLI000020','CO000010','SKU0020','大瓶可乐0020','5.50','801.83','8741.04','2019-06-26 22:04:33','1'),
	('COLI000021','CO000011','SKU0021','大瓶可乐0021','4.37','901.88','7010.78','2019-06-22 22:28:00','1'),
	('COLI000022','CO000011','SKU0022','大瓶可乐0022','4.70','745.74','9378.64','2019-06-26 23:35:52','1'),
	('COLI000023','CO000012','SKU0023','大瓶可乐0023','5.93','920.92','7424.75','2019-06-19 01:30:55','1'),
	('COLI000024','CO000012','SKU0024','大瓶可乐0024','5.61','874.30','8565.97','2019-06-16 15:14:03','1'),
	('COLI000025','CO000013','SKU0025','大瓶可乐0025','5.35','897.03','8772.03','2019-06-27 13:17:11','1'),
	('COLI000026','CO000013','SKU0026','大瓶可乐0026','4.67','972.44','7980.16','2019-06-13 23:13:39','1'),
	('COLI000027','CO000014','SKU0027','大瓶可乐0027','5.08','969.54','9314.83','2019-06-19 20:41:20','1'),
	('COLI000028','CO000014','SKU0028','大瓶可乐0028','4.84','863.74','9591.27','2019-07-04 02:21:11','1'),
	('COLI000029','CO000015','SKU0029','大瓶可乐0029','4.90','906.11','7609.68','2019-06-26 01:03:42','1'),
	('COLI000030','CO000015','SKU0030','大瓶可乐0030','5.48','942.26','7431.82','2019-07-03 07:29:37','1'),
	('COLI000031','CO000016','SKU0031','大瓶可乐0031','4.61','803.38','8172.25','2019-06-18 10:20:05','1'),
	('COLI000032','CO000016','SKU0032','大瓶可乐0032','5.49','852.61','7833.75','2019-06-12 21:08:52','1');

insert into consumer_order_shipping_group_data values
	('COSG000001','送货到刘强家','CO000001','598.27','1'),
	('COSG000002','送货到刘强家0002','CO000001','523.65','1'),
	('COSG000003','送货到刘强家0003','CO000002','442.17','1'),
	('COSG000004','送货到刘强家0004','CO000002','459.72','1'),
	('COSG000005','送货到刘强家0005','CO000003','591.47','1'),
	('COSG000006','送货到刘强家0006','CO000003','434.03','1'),
	('COSG000007','送货到刘强家0007','CO000004','507.90','1'),
	('COSG000008','送货到刘强家0008','CO000004','472.61','1'),
	('COSG000009','送货到刘强家0009','CO000005','520.76','1'),
	('COSG000010','送货到刘强家0010','CO000005','467.42','1'),
	('COSG000011','送货到刘强家0011','CO000006','569.81','1'),
	('COSG000012','送货到刘强家0012','CO000006','424.32','1'),
	('COSG000013','送货到刘强家0013','CO000007','494.71','1'),
	('COSG000014','送货到刘强家0014','CO000007','530.44','1'),
	('COSG000015','送货到刘强家0015','CO000008','584.92','1'),
	('COSG000016','送货到刘强家0016','CO000008','470.68','1'),
	('COSG000017','送货到刘强家0017','CO000009','498.59','1'),
	('COSG000018','送货到刘强家0018','CO000009','434.55','1'),
	('COSG000019','送货到刘强家0019','CO000010','494.72','1'),
	('COSG000020','送货到刘强家0020','CO000010','496.44','1'),
	('COSG000021','送货到刘强家0021','CO000011','513.82','1'),
	('COSG000022','送货到刘强家0022','CO000011','432.19','1'),
	('COSG000023','送货到刘强家0023','CO000012','509.62','1'),
	('COSG000024','送货到刘强家0024','CO000012','456.07','1'),
	('COSG000025','送货到刘强家0025','CO000013','561.13','1'),
	('COSG000026','送货到刘强家0026','CO000013','596.74','1'),
	('COSG000027','送货到刘强家0027','CO000014','541.13','1'),
	('COSG000028','送货到刘强家0028','CO000014','476.24','1'),
	('COSG000029','送货到刘强家0029','CO000015','456.76','1'),
	('COSG000030','送货到刘强家0030','CO000015','508.81','1'),
	('COSG000031','送货到刘强家0031','CO000016','589.41','1'),
	('COSG000032','送货到刘强家0032','CO000016','428.64','1');

insert into consumer_order_payment_group_data values
	('COPG000001','信用卡','CO000001','4111 1111 1111 - ','1'),
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
	('COPA000001','端午促销','CO000001','507.89','供货商','1'),
	('COPA000002','端午促销0002','CO000001','487.58','小超老板','1'),
	('COPA000003','端午促销0003','CO000002','468.36','广告赞助','1'),
	('COPA000004','端午促销0004','CO000002','503.06','供货商','1'),
	('COPA000005','端午促销0005','CO000003','540.04','小超老板','1'),
	('COPA000006','端午促销0006','CO000003','426.51','广告赞助','1'),
	('COPA000007','端午促销0007','CO000004','523.88','供货商','1'),
	('COPA000008','端午促销0008','CO000004','545.51','小超老板','1'),
	('COPA000009','端午促销0009','CO000005','484.90','广告赞助','1'),
	('COPA000010','端午促销0010','CO000005','517.76','供货商','1'),
	('COPA000011','端午促销0011','CO000006','573.85','小超老板','1'),
	('COPA000012','端午促销0012','CO000006','436.33','广告赞助','1'),
	('COPA000013','端午促销0013','CO000007','562.06','供货商','1'),
	('COPA000014','端午促销0014','CO000007','438.96','小超老板','1'),
	('COPA000015','端午促销0015','CO000008','530.73','广告赞助','1'),
	('COPA000016','端午促销0016','CO000008','546.75','供货商','1'),
	('COPA000017','端午促销0017','CO000009','502.88','小超老板','1'),
	('COPA000018','端午促销0018','CO000009','529.74','广告赞助','1'),
	('COPA000019','端午促销0019','CO000010','559.44','供货商','1'),
	('COPA000020','端午促销0020','CO000010','591.40','小超老板','1'),
	('COPA000021','端午促销0021','CO000011','428.26','广告赞助','1'),
	('COPA000022','端午促销0022','CO000011','583.49','供货商','1'),
	('COPA000023','端午促销0023','CO000012','434.17','小超老板','1'),
	('COPA000024','端午促销0024','CO000012','586.27','广告赞助','1'),
	('COPA000025','端午促销0025','CO000013','465.82','供货商','1'),
	('COPA000026','端午促销0026','CO000013','442.37','小超老板','1'),
	('COPA000027','端午促销0027','CO000014','508.19','广告赞助','1'),
	('COPA000028','端午促销0028','CO000014','589.74','供货商','1'),
	('COPA000029','端午促销0029','CO000015','514.09','小超老板','1'),
	('COPA000030','端午促销0030','CO000015','470.44','广告赞助','1'),
	('COPA000031','端午促销0031','CO000016','500.80','供货商','1'),
	('COPA000032','端午促销0032','CO000016','564.82','小超老板','1');

insert into retail_store_member_coupon_data values
	('RSMC000001','优惠券','RSM000001','CP00001','2019-07-02 18:16:46','1'),
	('RSMC000002','优惠券0002','RSM000001','CP000010002','2019-07-03 02:39:43','1'),
	('RSMC000003','优惠券0003','RSM000002','CP000010003','2019-06-20 12:49:02','1'),
	('RSMC000004','优惠券0004','RSM000002','CP000010004','2019-06-12 19:39:13','1');

insert into member_wishlist_data values
	('MW000001','每周购买清单','RSM000001','1'),
	('MW000002','每月购买清单','RSM000001','1'),
	('MW000003','每周购买清单','RSM000002','1'),
	('MW000004','每月购买清单','RSM000002','1');

insert into member_reward_point_data values
	('MRP000001','购买积分','17','RSM000001','1'),
	('MRP000002','每月购买清单','17','RSM000001','1'),
	('MRP000003','购买积分','19','RSM000002','1'),
	('MRP000004','每月购买清单','20','RSM000002','1');

insert into member_reward_point_redemption_data values
	('MRPR000001','积分换锅','15','RSM000001','1'),
	('MRPR000002','积分换刀','19','RSM000001','1'),
	('MRPR000003','积分换锅','17','RSM000002','1'),
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
	('RSMA000001','家里','RSM000001','18099887766','四川省成都市科学城北路33号','1'),
	('RSMA000002','办公室','RSM000001','13900000002','四川省成都市科学城北路33号0002','1'),
	('RSMA000003','出差临时地址','RSM000002','13900000003','四川省成都市科学城北路33号0003','1'),
	('RSMA000004','家里','RSM000002','13900000004','四川省成都市科学城北路33号0004','1');

insert into retail_store_member_gift_card_data values
	('RSMGC000001','礼品卡','RSM000001','CP00001','201.40','1'),
	('RSMGC000002','礼品卡0002','RSM000001','CP000010002','181.09','1'),
	('RSMGC000003','礼品卡0003','RSM000002','CP000010003','208.09','1'),
	('RSMGC000004','礼品卡0004','RSM000002','CP000010004','184.71','1');

insert into retail_store_member_gift_card_consume_record_data values
	('RSMGCCR000001','2017-02-05','RSMGC000001','CO000001','GF00001','17.03','1'),
	('RSMGCCR000002','2018-08-04','RSMGC000001','CO000001','GF000010002','20.78','1'),
	('RSMGCCR000003','2018-03-21','RSMGC000001','CO000002','GF000010003','18.95','1'),
	('RSMGCCR000004','2017-04-05','RSMGC000001','CO000002','GF000010004','15.21','1'),
	('RSMGCCR000005','2017-09-13','RSMGC000001','CO000003','GF000010005','15.41','1'),
	('RSMGCCR000006','2017-11-18','RSMGC000001','CO000003','GF000010006','19.56','1'),
	('RSMGCCR000007','2017-10-04','RSMGC000001','CO000004','GF000010007','16.67','1'),
	('RSMGCCR000008','2018-12-20','RSMGC000001','CO000004','GF000010008','17.31','1'),
	('RSMGCCR000009','2018-12-18','RSMGC000002','CO000005','GF000010009','17.12','1'),
	('RSMGCCR000010','2019-04-16','RSMGC000002','CO000005','GF000010010','17.65','1'),
	('RSMGCCR000011','2016-09-14','RSMGC000002','CO000006','GF000010011','15.03','1'),
	('RSMGCCR000012','2017-01-22','RSMGC000002','CO000006','GF000010012','18.39','1'),
	('RSMGCCR000013','2017-07-06','RSMGC000002','CO000007','GF000010013','15.11','1'),
	('RSMGCCR000014','2016-12-11','RSMGC000002','CO000007','GF000010014','17.94','1'),
	('RSMGCCR000015','2018-01-19','RSMGC000002','CO000008','GF000010015','15.70','1'),
	('RSMGCCR000016','2018-01-11','RSMGC000002','CO000008','GF000010016','17.99','1'),
	('RSMGCCR000017','2017-07-19','RSMGC000003','CO000009','GF000010017','15.05','1'),
	('RSMGCCR000018','2017-10-24','RSMGC000003','CO000009','GF000010018','18.78','1'),
	('RSMGCCR000019','2017-02-07','RSMGC000003','CO000010','GF000010019','18.21','1'),
	('RSMGCCR000020','2017-08-19','RSMGC000003','CO000010','GF000010020','17.62','1'),
	('RSMGCCR000021','2017-02-14','RSMGC000003','CO000011','GF000010021','20.01','1'),
	('RSMGCCR000022','2018-07-30','RSMGC000003','CO000011','GF000010022','18.03','1'),
	('RSMGCCR000023','2019-05-01','RSMGC000003','CO000012','GF000010023','18.76','1'),
	('RSMGCCR000024','2017-12-29','RSMGC000003','CO000012','GF000010024','14.98','1'),
	('RSMGCCR000025','2018-05-05','RSMGC000004','CO000013','GF000010025','20.83','1'),
	('RSMGCCR000026','2018-12-02','RSMGC000004','CO000013','GF000010026','18.83','1'),
	('RSMGCCR000027','2018-10-03','RSMGC000004','CO000014','GF000010027','18.10','1'),
	('RSMGCCR000028','2018-08-19','RSMGC000004','CO000014','GF000010028','18.71','1'),
	('RSMGCCR000029','2018-11-03','RSMGC000004','CO000015','GF000010029','20.73','1'),
	('RSMGCCR000030','2018-05-14','RSMGC000004','CO000015','GF000010030','20.96','1'),
	('RSMGCCR000031','2017-08-02','RSMGC000004','CO000016','GF000010031','16.19','1'),
	('RSMGCCR000032','2018-10-12','RSMGC000004','CO000016','GF000010032','16.86','1');

insert into goods_supplier_data values
	('GS000001','宝洁','洗护用品','RSCC000001','18677889999','啤酒饮料矿泉水，香肠瓜子方便面都提供','2019-06-21 07:07:02','1'),
	('GS000002','中粮','食品','RSCC000002','13900000002','啤酒饮料矿泉水，香肠瓜子方便面都提供0002','2019-06-13 16:47:42','1'),
	('GS000003','福临门','植物油','RSCC000003','13900000003','啤酒饮料矿泉水，香肠瓜子方便面都提供0003','2019-07-03 12:09:18','1');

insert into supplier_product_data values
	('SP000001','黑人牙膏','最好的黑人牙膏，只卖3块喽','件','GS000001','1'),
	('SP000002','黑人牙膏0002','最好的黑人牙膏，只卖3块喽0002','公斤','GS000001','1'),
	('SP000003','黑人牙膏0003','最好的黑人牙膏，只卖3块喽0003','米','GS000002','1'),
	('SP000004','黑人牙膏0004','最好的黑人牙膏，只卖3块喽0004','件','GS000003','1');

insert into product_supply_duration_data values
	('PSD000001','100','现货','8785.89','SP000001','1'),
	('PSD000002','200','两天','7912.21','SP000001','1'),
	('PSD000003','500','三天','9404.83','SP000002','1'),
	('PSD000004','100','一周','8336.13','SP000002','1'),
	('PSD000005','200','现货','9217.63','SP000003','1'),
	('PSD000006','500','两天','7876.96','SP000003','1'),
	('PSD000007','100','三天','7602.22','SP000004','1'),
	('PSD000008','200','一周','8186.03','SP000004','1');

insert into supply_order_data values
	('SO000001','RSCC000001','GS000001','双链给供货商下的订单','2266789376.00',NULL,NULL,NULL,NULL,NULL,NULL,'2019-06-26 19:47:45','CONFIRMED','1'),
	('SO000002','RSCC000002','GS000001','双链给供货商下的订单0002','2626497024.00',NULL,NULL,NULL,NULL,NULL,NULL,'2019-07-02 07:51:12','APPROVED','1'),
	('SO000003','RSCC000003','GS000002','双链给供货商下的订单0003','2321223168.00',NULL,NULL,NULL,NULL,NULL,NULL,'2019-06-15 13:31:55','PROCESSED','1'),
	('SO000004','RSCC000004','GS000003','双链给供货商下的订单0004','2281976832.00',NULL,NULL,NULL,NULL,NULL,NULL,'2019-06-20 00:48:43','PICKED','1');

insert into supply_order_confirmation_data values
	('SOC000001','确认者','2018-01-13','1');

insert into supply_order_approval_data values
	('SOA000001','批准者','2019-01-26','1');

insert into supply_order_processing_data values
	('SOP000001','处理者','2019-03-06','1');

insert into supply_order_picking_data values
	('SOP000001','处理者','2019-04-10','1');

insert into supply_order_shipment_data values
	('SOS000001','运货者','2017-03-14','1');

insert into supply_order_delivery_data values
	('SOD000001','送货者','2017-10-04','1');

insert into supply_order_line_item_data values
	('SOLI000001','SO000001','SKU','大瓶可乐','5.85','8906','件','1'),
	('SOLI000002','SO000001','SKU0002','大瓶可乐0002','5.55','9049','公斤','1'),
	('SOLI000003','SO000002','SKU0003','大瓶可乐0003','4.32','8164','米','1'),
	('SOLI000004','SO000002','SKU0004','大瓶可乐0004','5.88','9760','件','1'),
	('SOLI000005','SO000003','SKU0005','大瓶可乐0005','5.36','7935','公斤','1'),
	('SOLI000006','SO000003','SKU0006','大瓶可乐0006','5.61','9552','米','1'),
	('SOLI000007','SO000004','SKU0007','大瓶可乐0007','5.39','9057','件','1'),
	('SOLI000008','SO000004','SKU0008','大瓶可乐0008','4.46','7840','公斤','1');

insert into supply_order_shipping_group_data values
	('SOSG000001','送货到双链成都2号仓','SO000001','4.63','1'),
	('SOSG000002','送货到双链成都2号仓0002','SO000001','5.27','1'),
	('SOSG000003','送货到双链成都2号仓0003','SO000002','4.88','1'),
	('SOSG000004','送货到双链成都2号仓0004','SO000002','4.68','1'),
	('SOSG000005','送货到双链成都2号仓0005','SO000003','4.39','1'),
	('SOSG000006','送货到双链成都2号仓0006','SO000003','5.95','1'),
	('SOSG000007','送货到双链成都2号仓0007','SO000004','4.38','1'),
	('SOSG000008','送货到双链成都2号仓0008','SO000004','5.09','1');

insert into supply_order_payment_group_data values
	('SOPG000001','付款办法','SO000001','4111 1111 1111 - ','1'),
	('SOPG000002','付款办法0002','SO000001','4111 1111 1111 - 0002','1'),
	('SOPG000003','付款办法0003','SO000002','4111 1111 1111 - 0003','1'),
	('SOPG000004','付款办法0004','SO000002','4111 1111 1111 - 0004','1'),
	('SOPG000005','付款办法0005','SO000003','4111 1111 1111 - 0005','1'),
	('SOPG000006','付款办法0006','SO000003','4111 1111 1111 - 0006','1'),
	('SOPG000007','付款办法0007','SO000004','4111 1111 1111 - 0007','1'),
	('SOPG000008','付款办法0008','SO000004','4111 1111 1111 - 0008','1');

insert into retail_store_order_data values
	('RSO000001','RS000001','RSCC000001','双链小超给双链供应链下的订单','2831292928.00',NULL,NULL,NULL,NULL,NULL,NULL,'2019-06-30 15:44:39','CONFIRMED','1'),
	('RSO000002','RS000001','RSCC000001','双链小超给双链供应链下的订单0002','2956621568.00',NULL,NULL,NULL,NULL,NULL,NULL,'2019-06-12 15:37:05','APPROVED','1'),
	('RSO000003','RS000002','RSCC000001','双链小超给双链供应链下的订单0003','2170100224.00',NULL,NULL,NULL,NULL,NULL,NULL,'2019-06-29 07:13:32','PROCESSED','1'),
	('RSO000004','RS000002','RSCC000001','双链小超给双链供应链下的订单0004','2736423936.00',NULL,NULL,NULL,NULL,NULL,NULL,'2019-06-27 22:48:46','PICKED','1'),
	('RSO000005','RS000003','RSCC000002','双链小超给双链供应链下的订单0005','2447000576.00',NULL,NULL,NULL,NULL,NULL,NULL,'2019-06-13 00:11:38','SHIPPED','1'),
	('RSO000006','RS000003','RSCC000002','双链小超给双链供应链下的订单0006','2104860032.00',NULL,NULL,NULL,NULL,NULL,NULL,'2019-06-30 03:27:18','DELIVERED','1'),
	('RSO000007','RS000004','RSCC000002','双链小超给双链供应链下的订单0007','2608093696.00',NULL,NULL,NULL,NULL,NULL,NULL,'2019-06-24 15:14:46','CONFIRMED','1'),
	('RSO000008','RS000004','RSCC000002','双链小超给双链供应链下的订单0008','2580782848.00',NULL,NULL,NULL,NULL,NULL,NULL,'2019-06-20 23:18:39','APPROVED','1'),
	('RSO000009','RS000005','RSCC000003','双链小超给双链供应链下的订单0009','2696515328.00',NULL,NULL,NULL,NULL,NULL,NULL,'2019-06-14 07:14:42','PROCESSED','1'),
	('RSO000010','RS000005','RSCC000003','双链小超给双链供应链下的订单0010','2452233984.00',NULL,NULL,NULL,NULL,NULL,NULL,'2019-06-20 17:28:41','PICKED','1'),
	('RSO000011','RS000006','RSCC000003','双链小超给双链供应链下的订单0011','2269822720.00',NULL,NULL,NULL,NULL,NULL,NULL,'2019-06-25 03:37:53','SHIPPED','1'),
	('RSO000012','RS000006','RSCC000003','双链小超给双链供应链下的订单0012','2993489152.00',NULL,NULL,NULL,NULL,NULL,NULL,'2019-06-20 12:34:25','DELIVERED','1'),
	('RSO000013','RS000007','RSCC000004','双链小超给双链供应链下的订单0013','2225057536.00',NULL,NULL,NULL,NULL,NULL,NULL,'2019-06-17 13:34:44','CONFIRMED','1'),
	('RSO000014','RS000007','RSCC000004','双链小超给双链供应链下的订单0014','2632554752.00',NULL,NULL,NULL,NULL,NULL,NULL,'2019-06-23 11:16:30','APPROVED','1'),
	('RSO000015','RS000008','RSCC000004','双链小超给双链供应链下的订单0015','2114271360.00',NULL,NULL,NULL,NULL,NULL,NULL,'2019-06-27 05:28:51','PROCESSED','1'),
	('RSO000016','RS000008','RSCC000004','双链小超给双链供应链下的订单0016','2208488192.00',NULL,NULL,NULL,NULL,NULL,NULL,'2019-06-15 16:17:21','PICKED','1');

insert into retail_store_order_confirmation_data values
	('RSOC000001','确认者','2018-08-16','1');

insert into retail_store_order_approval_data values
	('RSOA000001','批准者','2018-08-25','1');

insert into retail_store_order_processing_data values
	('RSOP000001','处理者','2017-06-19','1');

insert into retail_store_order_picking_data values
	('RSOP000001','处理者','2019-03-05','1');

insert into retail_store_order_shipment_data values
	('RSOS000001','运货者','2017-12-11','1');

insert into retail_store_order_delivery_data values
	('RSOD000001','送货者','2017-03-19','1');

insert into retail_store_order_line_item_data values
	('RSOLI000001','RSO000001','SKU','大瓶可乐','3.48','8507','件','1'),
	('RSOLI000002','RSO000001','SKU0002','大瓶可乐0002','3.30','7390','公斤','1'),
	('RSOLI000003','RSO000002','SKU0003','大瓶可乐0003','3.34','7765','米','1'),
	('RSOLI000004','RSO000002','SKU0004','大瓶可乐0004','2.94','9704','件','1'),
	('RSOLI000005','RSO000003','SKU0005','大瓶可乐0005','3.16','7602','公斤','1'),
	('RSOLI000006','RSO000003','SKU0006','大瓶可乐0006','3.37','7119','米','1'),
	('RSOLI000007','RSO000004','SKU0007','大瓶可乐0007','2.91','8049','件','1'),
	('RSOLI000008','RSO000004','SKU0008','大瓶可乐0008','3.46','9877','公斤','1'),
	('RSOLI000009','RSO000005','SKU0009','大瓶可乐0009','3.70','8978','米','1'),
	('RSOLI000010','RSO000005','SKU0010','大瓶可乐0010','3.81','8095','件','1'),
	('RSOLI000011','RSO000006','SKU0011','大瓶可乐0011','2.85','9347','公斤','1'),
	('RSOLI000012','RSO000006','SKU0012','大瓶可乐0012','3.77','7115','米','1'),
	('RSOLI000013','RSO000007','SKU0013','大瓶可乐0013','3.81','9382','件','1'),
	('RSOLI000014','RSO000007','SKU0014','大瓶可乐0014','2.78','9692','公斤','1'),
	('RSOLI000015','RSO000008','SKU0015','大瓶可乐0015','3.17','9608','米','1'),
	('RSOLI000016','RSO000008','SKU0016','大瓶可乐0016','3.51','7306','件','1'),
	('RSOLI000017','RSO000009','SKU0017','大瓶可乐0017','2.85','8592','公斤','1'),
	('RSOLI000018','RSO000009','SKU0018','大瓶可乐0018','3.38','8893','米','1'),
	('RSOLI000019','RSO000010','SKU0019','大瓶可乐0019','3.14','8486','件','1'),
	('RSOLI000020','RSO000010','SKU0020','大瓶可乐0020','3.45','8866','公斤','1'),
	('RSOLI000021','RSO000011','SKU0021','大瓶可乐0021','2.86','7734','米','1'),
	('RSOLI000022','RSO000011','SKU0022','大瓶可乐0022','3.73','9604','件','1'),
	('RSOLI000023','RSO000012','SKU0023','大瓶可乐0023','3.42','7835','公斤','1'),
	('RSOLI000024','RSO000012','SKU0024','大瓶可乐0024','3.34','7524','米','1'),
	('RSOLI000025','RSO000013','SKU0025','大瓶可乐0025','3.02','8649','件','1'),
	('RSOLI000026','RSO000013','SKU0026','大瓶可乐0026','3.52','9422','公斤','1'),
	('RSOLI000027','RSO000014','SKU0027','大瓶可乐0027','3.31','9555','米','1'),
	('RSOLI000028','RSO000014','SKU0028','大瓶可乐0028','3.32','7024','件','1'),
	('RSOLI000029','RSO000015','SKU0029','大瓶可乐0029','3.19','9715','公斤','1'),
	('RSOLI000030','RSO000015','SKU0030','大瓶可乐0030','2.83','8606','米','1'),
	('RSOLI000031','RSO000016','SKU0031','大瓶可乐0031','3.57','8795','件','1'),
	('RSOLI000032','RSO000016','SKU0032','大瓶可乐0032','3.65','8078','公斤','1');

insert into retail_store_order_shipping_group_data values
	('RSOSG000001','送货到双链中和社区店','RSO000001','4.31','1'),
	('RSOSG000002','送货到双链中和社区店0002','RSO000001','4.65','1'),
	('RSOSG000003','送货到双链中和社区店0003','RSO000002','5.34','1'),
	('RSOSG000004','送货到双链中和社区店0004','RSO000002','4.29','1'),
	('RSOSG000005','送货到双链中和社区店0005','RSO000003','5.18','1'),
	('RSOSG000006','送货到双链中和社区店0006','RSO000003','5.87','1'),
	('RSOSG000007','送货到双链中和社区店0007','RSO000004','5.08','1'),
	('RSOSG000008','送货到双链中和社区店0008','RSO000004','4.29','1'),
	('RSOSG000009','送货到双链中和社区店0009','RSO000005','4.78','1'),
	('RSOSG000010','送货到双链中和社区店0010','RSO000005','5.37','1'),
	('RSOSG000011','送货到双链中和社区店0011','RSO000006','4.27','1'),
	('RSOSG000012','送货到双链中和社区店0012','RSO000006','5.58','1'),
	('RSOSG000013','送货到双链中和社区店0013','RSO000007','4.38','1'),
	('RSOSG000014','送货到双链中和社区店0014','RSO000007','5.93','1'),
	('RSOSG000015','送货到双链中和社区店0015','RSO000008','5.90','1'),
	('RSOSG000016','送货到双链中和社区店0016','RSO000008','5.37','1'),
	('RSOSG000017','送货到双链中和社区店0017','RSO000009','5.77','1'),
	('RSOSG000018','送货到双链中和社区店0018','RSO000009','5.32','1'),
	('RSOSG000019','送货到双链中和社区店0019','RSO000010','4.26','1'),
	('RSOSG000020','送货到双链中和社区店0020','RSO000010','5.20','1'),
	('RSOSG000021','送货到双链中和社区店0021','RSO000011','4.69','1'),
	('RSOSG000022','送货到双链中和社区店0022','RSO000011','4.45','1'),
	('RSOSG000023','送货到双链中和社区店0023','RSO000012','5.24','1'),
	('RSOSG000024','送货到双链中和社区店0024','RSO000012','4.56','1'),
	('RSOSG000025','送货到双链中和社区店0025','RSO000013','4.50','1'),
	('RSOSG000026','送货到双链中和社区店0026','RSO000013','5.40','1'),
	('RSOSG000027','送货到双链中和社区店0027','RSO000014','5.77','1'),
	('RSOSG000028','送货到双链中和社区店0028','RSO000014','4.87','1'),
	('RSOSG000029','送货到双链中和社区店0029','RSO000015','4.99','1'),
	('RSOSG000030','送货到双链中和社区店0030','RSO000015','4.56','1'),
	('RSOSG000031','送货到双链中和社区店0031','RSO000016','4.70','1'),
	('RSOSG000032','送货到双链中和社区店0032','RSO000016','4.76','1');

insert into retail_store_order_payment_group_data values
	('RSOPG000001','付款办法','RSO000001','4111 1111 1111 - ','1'),
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
	('W000001','成都龙泉驿飞鹤路20号','02887654321','187672平方米','RSCC000001','41.407882138498856','131.72055031545864','2019-06-22 20:42:12','1'),
	('W000002','成都龙泉驿飞鹤路20号0002','028876543210002','187672平方米0002','RSCC000003','39.877312267211956','130.80682894188368','2019-06-22 18:04:44','1');

insert into storage_space_data values
	('SS000001','成都龙泉驿飞鹤路20号存货区','02887654321','1876平方米','W000001','40.6610061349055','131.84460186685516','2019-06-24 00:49:29','1'),
	('SS000002','成都龙泉驿飞鹤路20号存货区0002','028876543210002','1876平方米0002','W000001','40.632674465075304','132.17205969102184','2019-06-30 12:29:49','1'),
	('SS000003','成都龙泉驿飞鹤路20号存货区0003','028876543210003','1876平方米0003','W000002','40.416419713100986','129.96817414534175','2019-07-01 01:20:37','1'),
	('SS000004','成都龙泉驿飞鹤路20号存货区0004','028876543210004','1876平方米0004','W000002','41.096339987661864','130.0499936632279','2019-06-27 15:49:56','1');

insert into smart_pallet_data values
	('SP000001','成都龙泉驿飞鹤路20号移动区域，比如过道，货运通道等','02887654321','1876平方米','42.48445761547001','129.36144308438256','W000001','2019-07-02 12:06:13','1'),
	('SP000002','成都龙泉驿飞鹤路20号移动区域，比如过道，货运通道等0002','028876543210002','1876平方米0002','42.0714091066305','129.71559587404565','W000001','2019-06-24 00:41:39','1'),
	('SP000003','成都龙泉驿飞鹤路20号移动区域，比如过道，货运通道等0003','028876543210003','1876平方米0003','41.53227197867995','131.13099865328292','W000002','2019-06-18 19:44:08','1'),
	('SP000004','成都龙泉驿飞鹤路20号移动区域，比如过道，货运通道等0004','028876543210004','1876平方米0004','42.70337592517614','132.24654811256949','W000002','2019-06-22 05:32:23','1');

insert into goods_shelf_data values
	('GS000001','成都龙泉驿飞鹤路20号存货区货架','SS000001','SS000001','DS000001','2019-06-27 20:38:04','1'),
	('GS000002','成都龙泉驿飞鹤路20号存货区货架0002','SS000001','SS000001','DS000001','2019-07-01 03:00:09','1'),
	('GS000003','成都龙泉驿飞鹤路20号存货区货架0003','SS000002','SS000002','DS000002','2019-06-27 13:30:47','1'),
	('GS000004','成都龙泉驿飞鹤路20号存货区货架0004','SS000002','SS000002','DS000002','2019-06-27 05:29:43','1'),
	('GS000005','成都龙泉驿飞鹤路20号存货区货架0005','SS000003','SS000003','DS000003','2019-06-26 07:46:19','1'),
	('GS000006','成都龙泉驿飞鹤路20号存货区货架0006','SS000003','SS000003','DS000003','2019-06-20 14:33:33','1'),
	('GS000007','成都龙泉驿飞鹤路20号存货区货架0007','SS000004','SS000004','DS000004','2019-06-20 01:19:15','1'),
	('GS000008','成都龙泉驿飞鹤路20号存货区货架0008','SS000004','SS000004','DS000004','2019-06-22 19:22:00','1');

insert into goods_shelf_stock_count_data values
	('GSSC000001','每日盘点','2019-01-11','使用先进的rfid技术，没有任何错误','GS000001','1'),
	('GSSC000002','每周盘点','2019-06-21','使用先进的rfid技术，没有任何错误0002','GS000001','1'),
	('GSSC000003','每月盘点','2018-02-16','使用先进的rfid技术，没有任何错误0003','GS000002','1'),
	('GSSC000004','年终盘点','2016-11-14','使用先进的rfid技术，没有任何错误0004','GS000002','1'),
	('GSSC000005','每日盘点','2019-01-09','使用先进的rfid技术，没有任何错误0005','GS000003','1'),
	('GSSC000006','每周盘点','2018-10-11','使用先进的rfid技术，没有任何错误0006','GS000003','1'),
	('GSSC000007','每月盘点','2017-08-17','使用先进的rfid技术，没有任何错误0007','GS000004','1'),
	('GSSC000008','年终盘点','2019-03-15','使用先进的rfid技术，没有任何错误0008','GS000004','1'),
	('GSSC000009','每日盘点','2016-12-25','使用先进的rfid技术，没有任何错误0009','GS000005','1'),
	('GSSC000010','每周盘点','2018-11-01','使用先进的rfid技术，没有任何错误0010','GS000005','1'),
	('GSSC000011','每月盘点','2018-09-11','使用先进的rfid技术，没有任何错误0011','GS000006','1'),
	('GSSC000012','年终盘点','2016-12-25','使用先进的rfid技术，没有任何错误0012','GS000006','1'),
	('GSSC000013','每日盘点','2016-12-31','使用先进的rfid技术，没有任何错误0013','GS000007','1'),
	('GSSC000014','每周盘点','2016-12-27','使用先进的rfid技术，没有任何错误0014','GS000007','1'),
	('GSSC000015','每月盘点','2018-06-02','使用先进的rfid技术，没有任何错误0015','GS000008','1'),
	('GSSC000016','年终盘点','2019-05-27','使用先进的rfid技术，没有任何错误0016','GS000008','1');

insert into stock_count_issue_track_data values
	('SCIT000001','盘点差错','2017-04-11','发现错误已经修正完成','GSSC000001','1'),
	('SCIT000002','盘点差错0002','2019-04-10','发现错误已经修正完成0002','GSSC000001','1'),
	('SCIT000003','盘点差错0003','2018-08-26','发现错误已经修正完成0003','GSSC000002','1'),
	('SCIT000004','盘点差错0004','2017-02-26','发现错误已经修正完成0004','GSSC000002','1'),
	('SCIT000005','盘点差错0005','2017-08-16','发现错误已经修正完成0005','GSSC000003','1'),
	('SCIT000006','盘点差错0006','2019-06-11','发现错误已经修正完成0006','GSSC000003','1'),
	('SCIT000007','盘点差错0007','2017-08-01','发现错误已经修正完成0007','GSSC000004','1'),
	('SCIT000008','盘点差错0008','2017-08-24','发现错误已经修正完成0008','GSSC000004','1'),
	('SCIT000009','盘点差错0009','2017-02-14','发现错误已经修正完成0009','GSSC000005','1'),
	('SCIT000010','盘点差错0010','2016-08-23','发现错误已经修正完成0010','GSSC000005','1'),
	('SCIT000011','盘点差错0011','2019-06-18','发现错误已经修正完成0011','GSSC000006','1'),
	('SCIT000012','盘点差错0012','2017-02-22','发现错误已经修正完成0012','GSSC000006','1'),
	('SCIT000013','盘点差错0013','2018-04-28','发现错误已经修正完成0013','GSSC000007','1'),
	('SCIT000014','盘点差错0014','2018-01-27','发现错误已经修正完成0014','GSSC000007','1'),
	('SCIT000015','盘点差错0015','2017-07-23','发现错误已经修正完成0015','GSSC000008','1'),
	('SCIT000016','盘点差错0016','2018-01-05','发现错误已经修正完成0016','GSSC000008','1'),
	('SCIT000017','盘点差错0017','2017-03-10','发现错误已经修正完成0017','GSSC000009','1'),
	('SCIT000018','盘点差错0018','2018-05-01','发现错误已经修正完成0018','GSSC000009','1'),
	('SCIT000019','盘点差错0019','2018-07-11','发现错误已经修正完成0019','GSSC000010','1'),
	('SCIT000020','盘点差错0020','2018-08-10','发现错误已经修正完成0020','GSSC000010','1'),
	('SCIT000021','盘点差错0021','2018-04-23','发现错误已经修正完成0021','GSSC000011','1'),
	('SCIT000022','盘点差错0022','2018-11-03','发现错误已经修正完成0022','GSSC000011','1'),
	('SCIT000023','盘点差错0023','2016-09-13','发现错误已经修正完成0023','GSSC000012','1'),
	('SCIT000024','盘点差错0024','2018-03-01','发现错误已经修正完成0024','GSSC000012','1'),
	('SCIT000025','盘点差错0025','2017-11-04','发现错误已经修正完成0025','GSSC000013','1'),
	('SCIT000026','盘点差错0026','2017-11-24','发现错误已经修正完成0026','GSSC000013','1'),
	('SCIT000027','盘点差错0027','2018-02-28','发现错误已经修正完成0027','GSSC000014','1'),
	('SCIT000028','盘点差错0028','2017-03-18','发现错误已经修正完成0028','GSSC000014','1'),
	('SCIT000029','盘点差错0029','2017-03-23','发现错误已经修正完成0029','GSSC000015','1'),
	('SCIT000030','盘点差错0030','2017-03-14','发现错误已经修正完成0030','GSSC000015','1'),
	('SCIT000031','盘点差错0031','2018-11-29','发现错误已经修正完成0031','GSSC000016','1'),
	('SCIT000032','盘点差错0032','2017-04-23','发现错误已经修正完成0032','GSSC000016','1');

insert into goods_allocation_data values
	('GA000001','成都龙泉驿飞鹤路20号存货区货架20号货位','42.058205211731526','132.25507476599532','GS000001','1'),
	('GA000002','成都龙泉驿飞鹤路20号存货区货架20号货位0002','41.32030306729516','130.7422877013042','GS000001','1'),
	('GA000003','成都龙泉驿飞鹤路20号存货区货架20号货位0003','41.489774297087905','131.88274834038728','GS000002','1'),
	('GA000004','成都龙泉驿飞鹤路20号存货区货架20号货位0004','40.72726321869433','131.27526632200062','GS000002','1'),
	('GA000005','成都龙泉驿飞鹤路20号存货区货架20号货位0005','40.25769205881079','129.42858067391137','GS000003','1'),
	('GA000006','成都龙泉驿飞鹤路20号存货区货架20号货位0006','42.57794960673502','131.97264595883632','GS000003','1'),
	('GA000007','成都龙泉驿飞鹤路20号存货区货架20号货位0007','42.20734355523081','131.36562103138468','GS000004','1'),
	('GA000008','成都龙泉驿飞鹤路20号存货区货架20号货位0008','40.768503718509514','131.78512644735804','GS000004','1'),
	('GA000009','成都龙泉驿飞鹤路20号存货区货架20号货位0009','39.92450466123252','129.87305960429958','GS000005','1'),
	('GA000010','成都龙泉驿飞鹤路20号存货区货架20号货位0010','41.32832478847569','131.8913903988821','GS000005','1'),
	('GA000011','成都龙泉驿飞鹤路20号存货区货架20号货位0011','42.617880518256555','130.36358516148692','GS000006','1'),
	('GA000012','成都龙泉驿飞鹤路20号存货区货架20号货位0012','41.89011890557505','131.94117176243276','GS000006','1'),
	('GA000013','成都龙泉驿飞鹤路20号存货区货架20号货位0013','40.95928076219677','132.11290255146426','GS000007','1'),
	('GA000014','成都龙泉驿飞鹤路20号存货区货架20号货位0014','41.41755753792302','131.82728832965353','GS000007','1'),
	('GA000015','成都龙泉驿飞鹤路20号存货区货架20号货位0015','42.612968672007675','131.5371571578051','GS000008','1'),
	('GA000016','成都龙泉驿飞鹤路20号存货区货架20号货位0016','40.60323417926034','130.80338037624963','GS000008','1');

insert into goods_data values
	('G000001','可口可乐','RF99192','件','8','2019-05-26','S000001','RS000001','GA000001','SP000001','SS000001','TT000001','RS000001','SO000001','RSO000001',NULL,'PACKED','1'),
	('G000002','可口可乐0002','RF991920002','箱','9','2018-10-18','S000001','RS000001','GA000001','SP000001','SS000001','TT000001','RS000001','SO000001','RSO000001',NULL,'PACKED0002','1'),
	('G000003','可口可乐0003','RF991920003','件','8','2018-06-12','S000002','RS000001','GA000001','SP000001','SS000001','TT000001','RS000001','SO000001','RSO000001',NULL,'PACKED0003','1'),
	('G000004','可口可乐0004','RF991920004','箱','9','2018-10-12','S000002','RS000001','GA000001','SP000001','SS000001','TT000001','RS000001','SO000001','RSO000001',NULL,'PACKED0004','1'),
	('G000005','可口可乐0005','RF991920005','件','9','2018-01-16','S000003','RS000001','GA000001','SP000001','SS000001','TT000001','RS000001','SO000001','RSO000001',NULL,'PACKED0005','1'),
	('G000006','可口可乐0006','RF991920006','箱','10','2018-06-08','S000003','RS000001','GA000001','SP000001','SS000001','TT000001','RS000001','SO000001','RSO000001',NULL,'PACKED0006','1'),
	('G000007','可口可乐0007','RF991920007','件','10','2018-10-17','S000004','RS000001','GA000001','SP000001','SS000001','TT000001','RS000001','SO000001','RSO000001',NULL,'PACKED0007','1'),
	('G000008','可口可乐0008','RF991920008','箱','10','2016-07-23','S000004','RS000001','GA000001','SP000001','SS000001','TT000001','RS000001','SO000001','RSO000001',NULL,'PACKED0008','1'),
	('G000009','可口可乐0009','RF991920009','件','10','2018-02-05','S000005','RS000001','GA000002','SP000001','SS000001','TT000002','RS000001','SO000001','RSO000002',NULL,'PACKED0009','1'),
	('G000010','可口可乐0010','RF991920010','箱','10','2017-11-20','S000005','RS000001','GA000002','SP000001','SS000001','TT000002','RS000001','SO000001','RSO000002',NULL,'PACKED0010','1'),
	('G000011','可口可乐0011','RF991920011','件','8','2019-01-06','S000006','RS000001','GA000002','SP000001','SS000001','TT000002','RS000001','SO000001','RSO000002',NULL,'PACKED0011','1'),
	('G000012','可口可乐0012','RF991920012','箱','8','2017-04-29','S000006','RS000001','GA000002','SP000001','SS000001','TT000002','RS000001','SO000001','RSO000002',NULL,'PACKED0012','1'),
	('G000013','可口可乐0013','RF991920013','件','10','2016-11-27','S000007','RS000001','GA000002','SP000001','SS000001','TT000002','RS000001','SO000001','RSO000002',NULL,'PACKED0013','1'),
	('G000014','可口可乐0014','RF991920014','箱','8','2017-10-28','S000007','RS000001','GA000002','SP000001','SS000001','TT000002','RS000001','SO000001','RSO000002',NULL,'PACKED0014','1'),
	('G000015','可口可乐0015','RF991920015','件','9','2018-02-03','S000008','RS000001','GA000002','SP000001','SS000001','TT000002','RS000001','SO000001','RSO000002',NULL,'PACKED0015','1'),
	('G000016','可口可乐0016','RF991920016','箱','8','2016-11-04','S000008','RS000001','GA000002','SP000001','SS000001','TT000002','RS000001','SO000001','RSO000002',NULL,'PACKED0016','1'),
	('G000017','可口可乐0017','RF991920017','件','10','2017-12-05','S000009','RS000001','GA000003','SP000001','SS000001','TT000003','RS000002','SO000001','RSO000003',NULL,'PACKED0017','1'),
	('G000018','可口可乐0018','RF991920018','箱','10','2017-09-25','S000009','RS000001','GA000003','SP000001','SS000001','TT000003','RS000002','SO000001','RSO000003',NULL,'PACKED0018','1'),
	('G000019','可口可乐0019','RF991920019','件','8','2017-05-23','S000010','RS000001','GA000003','SP000001','SS000001','TT000003','RS000002','SO000001','RSO000003',NULL,'PACKED0019','1'),
	('G000020','可口可乐0020','RF991920020','箱','9','2016-11-06','S000010','RS000001','GA000003','SP000001','SS000001','TT000003','RS000002','SO000001','RSO000003',NULL,'PACKED0020','1'),
	('G000021','可口可乐0021','RF991920021','件','8','2017-02-08','S000011','RS000001','GA000003','SP000001','SS000001','TT000003','RS000002','SO000001','RSO000003',NULL,'PACKED0021','1'),
	('G000022','可口可乐0022','RF991920022','箱','8','2019-05-24','S000011','RS000001','GA000003','SP000001','SS000001','TT000003','RS000002','SO000001','RSO000003',NULL,'PACKED0022','1'),
	('G000023','可口可乐0023','RF991920023','件','9','2018-02-23','S000012','RS000001','GA000003','SP000001','SS000001','TT000003','RS000002','SO000001','RSO000003',NULL,'PACKED0023','1'),
	('G000024','可口可乐0024','RF991920024','箱','8','2018-02-15','S000012','RS000001','GA000003','SP000001','SS000001','TT000003','RS000002','SO000001','RSO000003',NULL,'PACKED0024','1'),
	('G000025','可口可乐0025','RF991920025','件','9','2019-06-06','S000013','RS000001','GA000004','SP000001','SS000001','TT000004','RS000002','SO000001','RSO000004',NULL,'PACKED0025','1'),
	('G000026','可口可乐0026','RF991920026','箱','10','2017-11-28','S000013','RS000001','GA000004','SP000001','SS000001','TT000004','RS000002','SO000001','RSO000004',NULL,'PACKED0026','1'),
	('G000027','可口可乐0027','RF991920027','件','8','2018-08-25','S000014','RS000001','GA000004','SP000001','SS000001','TT000004','RS000002','SO000001','RSO000004',NULL,'PACKED0027','1'),
	('G000028','可口可乐0028','RF991920028','箱','10','2017-12-14','S000014','RS000001','GA000004','SP000001','SS000001','TT000004','RS000002','SO000001','RSO000004',NULL,'PACKED0028','1'),
	('G000029','可口可乐0029','RF991920029','件','10','2018-11-13','S000015','RS000001','GA000004','SP000001','SS000001','TT000004','RS000002','SO000001','RSO000004',NULL,'PACKED0029','1'),
	('G000030','可口可乐0030','RF991920030','箱','8','2017-02-12','S000015','RS000001','GA000004','SP000001','SS000001','TT000004','RS000002','SO000001','RSO000004',NULL,'PACKED0030','1'),
	('G000031','可口可乐0031','RF991920031','件','8','2016-08-26','S000016','RS000001','GA000004','SP000001','SS000001','TT000004','RS000002','SO000001','RSO000004',NULL,'PACKED0031','1'),
	('G000032','可口可乐0032','RF991920032','箱','8','2019-02-25','S000016','RS000001','GA000004','SP000001','SS000001','TT000004','RS000002','SO000001','RSO000004',NULL,'PACKED0032','1'),
	('G000033','可口可乐0033','RF991920033','件','9','2016-07-31','S000017','RS000002','GA000005','SP000002','SS000002','TT000005','RS000003','SO000002','RSO000005',NULL,'PACKED0033','1'),
	('G000034','可口可乐0034','RF991920034','箱','10','2017-01-14','S000017','RS000002','GA000005','SP000002','SS000002','TT000005','RS000003','SO000002','RSO000005',NULL,'PACKED0034','1'),
	('G000035','可口可乐0035','RF991920035','件','10','2017-04-21','S000018','RS000002','GA000005','SP000002','SS000002','TT000005','RS000003','SO000002','RSO000005',NULL,'PACKED0035','1'),
	('G000036','可口可乐0036','RF991920036','箱','10','2016-09-27','S000018','RS000002','GA000005','SP000002','SS000002','TT000005','RS000003','SO000002','RSO000005',NULL,'PACKED0036','1'),
	('G000037','可口可乐0037','RF991920037','件','10','2018-01-28','S000019','RS000002','GA000005','SP000002','SS000002','TT000005','RS000003','SO000002','RSO000005',NULL,'PACKED0037','1'),
	('G000038','可口可乐0038','RF991920038','箱','10','2017-08-24','S000019','RS000002','GA000005','SP000002','SS000002','TT000005','RS000003','SO000002','RSO000005',NULL,'PACKED0038','1'),
	('G000039','可口可乐0039','RF991920039','件','10','2017-08-22','S000020','RS000002','GA000005','SP000002','SS000002','TT000005','RS000003','SO000002','RSO000005',NULL,'PACKED0039','1'),
	('G000040','可口可乐0040','RF991920040','箱','9','2018-11-13','S000020','RS000002','GA000005','SP000002','SS000002','TT000005','RS000003','SO000002','RSO000005',NULL,'PACKED0040','1'),
	('G000041','可口可乐0041','RF991920041','件','9','2016-10-03','S000021','RS000002','GA000006','SP000002','SS000002','TT000006','RS000003','SO000002','RSO000006',NULL,'PACKED0041','1'),
	('G000042','可口可乐0042','RF991920042','箱','10','2018-02-15','S000021','RS000002','GA000006','SP000002','SS000002','TT000006','RS000003','SO000002','RSO000006',NULL,'PACKED0042','1'),
	('G000043','可口可乐0043','RF991920043','件','8','2017-06-13','S000022','RS000002','GA000006','SP000002','SS000002','TT000006','RS000003','SO000002','RSO000006',NULL,'PACKED0043','1'),
	('G000044','可口可乐0044','RF991920044','箱','8','2018-08-10','S000022','RS000002','GA000006','SP000002','SS000002','TT000006','RS000003','SO000002','RSO000006',NULL,'PACKED0044','1'),
	('G000045','可口可乐0045','RF991920045','件','10','2016-12-19','S000023','RS000002','GA000006','SP000002','SS000002','TT000006','RS000003','SO000002','RSO000006',NULL,'PACKED0045','1'),
	('G000046','可口可乐0046','RF991920046','箱','10','2018-06-13','S000023','RS000002','GA000006','SP000002','SS000002','TT000006','RS000003','SO000002','RSO000006',NULL,'PACKED0046','1'),
	('G000047','可口可乐0047','RF991920047','件','10','2017-01-09','S000024','RS000002','GA000006','SP000002','SS000002','TT000006','RS000003','SO000002','RSO000006',NULL,'PACKED0047','1'),
	('G000048','可口可乐0048','RF991920048','箱','8','2016-09-21','S000024','RS000002','GA000006','SP000002','SS000002','TT000006','RS000003','SO000002','RSO000006',NULL,'PACKED0048','1'),
	('G000049','可口可乐0049','RF991920049','件','8','2018-07-10','S000025','RS000002','GA000007','SP000002','SS000002','TT000007','RS000004','SO000002','RSO000007',NULL,'PACKED0049','1'),
	('G000050','可口可乐0050','RF991920050','箱','9','2018-11-16','S000025','RS000002','GA000007','SP000002','SS000002','TT000007','RS000004','SO000002','RSO000007',NULL,'PACKED0050','1'),
	('G000051','可口可乐0051','RF991920051','件','9','2017-02-11','S000026','RS000002','GA000007','SP000002','SS000002','TT000007','RS000004','SO000002','RSO000007',NULL,'PACKED0051','1'),
	('G000052','可口可乐0052','RF991920052','箱','10','2019-06-19','S000026','RS000002','GA000007','SP000002','SS000002','TT000007','RS000004','SO000002','RSO000007',NULL,'PACKED0052','1'),
	('G000053','可口可乐0053','RF991920053','件','9','2017-05-14','S000027','RS000002','GA000007','SP000002','SS000002','TT000007','RS000004','SO000002','RSO000007',NULL,'PACKED0053','1'),
	('G000054','可口可乐0054','RF991920054','箱','10','2016-09-21','S000027','RS000002','GA000007','SP000002','SS000002','TT000007','RS000004','SO000002','RSO000007',NULL,'PACKED0054','1'),
	('G000055','可口可乐0055','RF991920055','件','10','2019-02-14','S000028','RS000002','GA000007','SP000002','SS000002','TT000007','RS000004','SO000002','RSO000007',NULL,'PACKED0055','1'),
	('G000056','可口可乐0056','RF991920056','箱','10','2017-02-16','S000028','RS000002','GA000007','SP000002','SS000002','TT000007','RS000004','SO000002','RSO000007',NULL,'PACKED0056','1'),
	('G000057','可口可乐0057','RF991920057','件','8','2017-09-24','S000029','RS000002','GA000008','SP000002','SS000002','TT000008','RS000004','SO000002','RSO000008',NULL,'PACKED0057','1'),
	('G000058','可口可乐0058','RF991920058','箱','9','2018-07-19','S000029','RS000002','GA000008','SP000002','SS000002','TT000008','RS000004','SO000002','RSO000008',NULL,'PACKED0058','1'),
	('G000059','可口可乐0059','RF991920059','件','9','2018-04-24','S000030','RS000002','GA000008','SP000002','SS000002','TT000008','RS000004','SO000002','RSO000008',NULL,'PACKED0059','1'),
	('G000060','可口可乐0060','RF991920060','箱','8','2018-10-17','S000030','RS000002','GA000008','SP000002','SS000002','TT000008','RS000004','SO000002','RSO000008',NULL,'PACKED0060','1'),
	('G000061','可口可乐0061','RF991920061','件','9','2019-01-16','S000031','RS000002','GA000008','SP000002','SS000002','TT000008','RS000004','SO000002','RSO000008',NULL,'PACKED0061','1'),
	('G000062','可口可乐0062','RF991920062','箱','9','2017-07-19','S000031','RS000002','GA000008','SP000002','SS000002','TT000008','RS000004','SO000002','RSO000008',NULL,'PACKED0062','1'),
	('G000063','可口可乐0063','RF991920063','件','8','2016-08-11','S000032','RS000002','GA000008','SP000002','SS000002','TT000008','RS000004','SO000002','RSO000008',NULL,'PACKED0063','1'),
	('G000064','可口可乐0064','RF991920064','箱','8','2018-07-21','S000032','RS000002','GA000008','SP000002','SS000002','TT000008','RS000004','SO000002','RSO000008',NULL,'PACKED0064','1'),
	('G000065','可口可乐0065','RF991920065','件','9','2019-06-11','S000033','RS000003','GA000009','SP000003','SS000003','TT000009','RS000005','SO000003','RSO000009',NULL,'PACKED0065','1'),
	('G000066','可口可乐0066','RF991920066','箱','9','2018-10-25','S000033','RS000003','GA000009','SP000003','SS000003','TT000009','RS000005','SO000003','RSO000009',NULL,'PACKED0066','1'),
	('G000067','可口可乐0067','RF991920067','件','9','2019-04-08','S000034','RS000003','GA000009','SP000003','SS000003','TT000009','RS000005','SO000003','RSO000009',NULL,'PACKED0067','1'),
	('G000068','可口可乐0068','RF991920068','箱','10','2018-02-19','S000034','RS000003','GA000009','SP000003','SS000003','TT000009','RS000005','SO000003','RSO000009',NULL,'PACKED0068','1'),
	('G000069','可口可乐0069','RF991920069','件','10','2018-08-06','S000035','RS000003','GA000009','SP000003','SS000003','TT000009','RS000005','SO000003','RSO000009',NULL,'PACKED0069','1'),
	('G000070','可口可乐0070','RF991920070','箱','8','2018-10-25','S000035','RS000003','GA000009','SP000003','SS000003','TT000009','RS000005','SO000003','RSO000009',NULL,'PACKED0070','1'),
	('G000071','可口可乐0071','RF991920071','件','10','2019-06-06','S000036','RS000003','GA000009','SP000003','SS000003','TT000009','RS000005','SO000003','RSO000009',NULL,'PACKED0071','1'),
	('G000072','可口可乐0072','RF991920072','箱','10','2018-09-26','S000036','RS000003','GA000009','SP000003','SS000003','TT000009','RS000005','SO000003','RSO000009',NULL,'PACKED0072','1'),
	('G000073','可口可乐0073','RF991920073','件','10','2018-03-18','S000037','RS000003','GA000010','SP000003','SS000003','TT000010','RS000005','SO000003','RSO000010',NULL,'PACKED0073','1'),
	('G000074','可口可乐0074','RF991920074','箱','10','2017-02-18','S000037','RS000003','GA000010','SP000003','SS000003','TT000010','RS000005','SO000003','RSO000010',NULL,'PACKED0074','1'),
	('G000075','可口可乐0075','RF991920075','件','9','2017-05-24','S000038','RS000003','GA000010','SP000003','SS000003','TT000010','RS000005','SO000003','RSO000010',NULL,'PACKED0075','1'),
	('G000076','可口可乐0076','RF991920076','箱','8','2018-06-10','S000038','RS000003','GA000010','SP000003','SS000003','TT000010','RS000005','SO000003','RSO000010',NULL,'PACKED0076','1'),
	('G000077','可口可乐0077','RF991920077','件','8','2019-06-13','S000039','RS000003','GA000010','SP000003','SS000003','TT000010','RS000005','SO000003','RSO000010',NULL,'PACKED0077','1'),
	('G000078','可口可乐0078','RF991920078','箱','8','2019-06-04','S000039','RS000003','GA000010','SP000003','SS000003','TT000010','RS000005','SO000003','RSO000010',NULL,'PACKED0078','1'),
	('G000079','可口可乐0079','RF991920079','件','8','2017-02-22','S000040','RS000003','GA000010','SP000003','SS000003','TT000010','RS000005','SO000003','RSO000010',NULL,'PACKED0079','1'),
	('G000080','可口可乐0080','RF991920080','箱','8','2016-07-24','S000040','RS000003','GA000010','SP000003','SS000003','TT000010','RS000005','SO000003','RSO000010',NULL,'PACKED0080','1'),
	('G000081','可口可乐0081','RF991920081','件','8','2017-02-15','S000041','RS000003','GA000011','SP000003','SS000003','TT000011','RS000006','SO000003','RSO000011',NULL,'PACKED0081','1'),
	('G000082','可口可乐0082','RF991920082','箱','10','2018-02-11','S000041','RS000003','GA000011','SP000003','SS000003','TT000011','RS000006','SO000003','RSO000011',NULL,'PACKED0082','1'),
	('G000083','可口可乐0083','RF991920083','件','8','2018-05-27','S000042','RS000003','GA000011','SP000003','SS000003','TT000011','RS000006','SO000003','RSO000011',NULL,'PACKED0083','1'),
	('G000084','可口可乐0084','RF991920084','箱','9','2017-10-23','S000042','RS000003','GA000011','SP000003','SS000003','TT000011','RS000006','SO000003','RSO000011',NULL,'PACKED0084','1'),
	('G000085','可口可乐0085','RF991920085','件','10','2018-05-20','S000043','RS000003','GA000011','SP000003','SS000003','TT000011','RS000006','SO000003','RSO000011',NULL,'PACKED0085','1'),
	('G000086','可口可乐0086','RF991920086','箱','8','2019-03-22','S000043','RS000003','GA000011','SP000003','SS000003','TT000011','RS000006','SO000003','RSO000011',NULL,'PACKED0086','1'),
	('G000087','可口可乐0087','RF991920087','件','10','2017-04-03','S000044','RS000003','GA000011','SP000003','SS000003','TT000011','RS000006','SO000003','RSO000011',NULL,'PACKED0087','1'),
	('G000088','可口可乐0088','RF991920088','箱','10','2018-01-19','S000044','RS000003','GA000011','SP000003','SS000003','TT000011','RS000006','SO000003','RSO000011',NULL,'PACKED0088','1'),
	('G000089','可口可乐0089','RF991920089','件','10','2018-03-28','S000045','RS000003','GA000012','SP000003','SS000003','TT000012','RS000006','SO000003','RSO000012',NULL,'PACKED0089','1'),
	('G000090','可口可乐0090','RF991920090','箱','9','2019-06-05','S000045','RS000003','GA000012','SP000003','SS000003','TT000012','RS000006','SO000003','RSO000012',NULL,'PACKED0090','1'),
	('G000091','可口可乐0091','RF991920091','件','10','2017-03-04','S000046','RS000003','GA000012','SP000003','SS000003','TT000012','RS000006','SO000003','RSO000012',NULL,'PACKED0091','1'),
	('G000092','可口可乐0092','RF991920092','箱','10','2017-02-17','S000046','RS000003','GA000012','SP000003','SS000003','TT000012','RS000006','SO000003','RSO000012',NULL,'PACKED0092','1'),
	('G000093','可口可乐0093','RF991920093','件','10','2018-03-09','S000047','RS000003','GA000012','SP000003','SS000003','TT000012','RS000006','SO000003','RSO000012',NULL,'PACKED0093','1'),
	('G000094','可口可乐0094','RF991920094','箱','8','2018-03-19','S000047','RS000003','GA000012','SP000003','SS000003','TT000012','RS000006','SO000003','RSO000012',NULL,'PACKED0094','1'),
	('G000095','可口可乐0095','RF991920095','件','8','2016-12-08','S000048','RS000003','GA000012','SP000003','SS000003','TT000012','RS000006','SO000003','RSO000012',NULL,'PACKED0095','1'),
	('G000096','可口可乐0096','RF991920096','箱','9','2017-12-31','S000048','RS000003','GA000012','SP000003','SS000003','TT000012','RS000006','SO000003','RSO000012',NULL,'PACKED0096','1'),
	('G000097','可口可乐0097','RF991920097','件','10','2018-10-13','S000049','RS000004','GA000013','SP000004','SS000004','TT000013','RS000007','SO000004','RSO000013',NULL,'PACKED0097','1'),
	('G000098','可口可乐0098','RF991920098','箱','9','2018-09-15','S000049','RS000004','GA000013','SP000004','SS000004','TT000013','RS000007','SO000004','RSO000013',NULL,'PACKED0098','1'),
	('G000099','可口可乐0099','RF991920099','件','8','2017-10-11','S000050','RS000004','GA000013','SP000004','SS000004','TT000013','RS000007','SO000004','RSO000013',NULL,'PACKED0099','1'),
	('G000100','可口可乐0100','RF991920100','箱','10','2017-02-04','S000050','RS000004','GA000013','SP000004','SS000004','TT000013','RS000007','SO000004','RSO000013',NULL,'PACKED0100','1'),
	('G000101','可口可乐0101','RF991920101','件','9','2016-11-05','S000051','RS000004','GA000013','SP000004','SS000004','TT000013','RS000007','SO000004','RSO000013',NULL,'PACKED0101','1'),
	('G000102','可口可乐0102','RF991920102','箱','8','2016-07-19','S000051','RS000004','GA000013','SP000004','SS000004','TT000013','RS000007','SO000004','RSO000013',NULL,'PACKED0102','1'),
	('G000103','可口可乐0103','RF991920103','件','9','2017-10-06','S000052','RS000004','GA000013','SP000004','SS000004','TT000013','RS000007','SO000004','RSO000013',NULL,'PACKED0103','1'),
	('G000104','可口可乐0104','RF991920104','箱','10','2018-10-02','S000052','RS000004','GA000013','SP000004','SS000004','TT000013','RS000007','SO000004','RSO000013',NULL,'PACKED0104','1'),
	('G000105','可口可乐0105','RF991920105','件','8','2017-09-25','S000053','RS000004','GA000014','SP000004','SS000004','TT000014','RS000007','SO000004','RSO000014',NULL,'PACKED0105','1'),
	('G000106','可口可乐0106','RF991920106','箱','9','2018-12-14','S000053','RS000004','GA000014','SP000004','SS000004','TT000014','RS000007','SO000004','RSO000014',NULL,'PACKED0106','1'),
	('G000107','可口可乐0107','RF991920107','件','10','2019-03-29','S000054','RS000004','GA000014','SP000004','SS000004','TT000014','RS000007','SO000004','RSO000014',NULL,'PACKED0107','1'),
	('G000108','可口可乐0108','RF991920108','箱','8','2017-02-03','S000054','RS000004','GA000014','SP000004','SS000004','TT000014','RS000007','SO000004','RSO000014',NULL,'PACKED0108','1'),
	('G000109','可口可乐0109','RF991920109','件','8','2016-10-28','S000055','RS000004','GA000014','SP000004','SS000004','TT000014','RS000007','SO000004','RSO000014',NULL,'PACKED0109','1'),
	('G000110','可口可乐0110','RF991920110','箱','10','2016-09-25','S000055','RS000004','GA000014','SP000004','SS000004','TT000014','RS000007','SO000004','RSO000014',NULL,'PACKED0110','1'),
	('G000111','可口可乐0111','RF991920111','件','10','2018-11-09','S000056','RS000004','GA000014','SP000004','SS000004','TT000014','RS000007','SO000004','RSO000014',NULL,'PACKED0111','1'),
	('G000112','可口可乐0112','RF991920112','箱','9','2018-08-13','S000056','RS000004','GA000014','SP000004','SS000004','TT000014','RS000007','SO000004','RSO000014',NULL,'PACKED0112','1'),
	('G000113','可口可乐0113','RF991920113','件','8','2019-03-02','S000057','RS000004','GA000015','SP000004','SS000004','TT000015','RS000008','SO000004','RSO000015',NULL,'PACKED0113','1'),
	('G000114','可口可乐0114','RF991920114','箱','8','2018-12-23','S000057','RS000004','GA000015','SP000004','SS000004','TT000015','RS000008','SO000004','RSO000015',NULL,'PACKED0114','1'),
	('G000115','可口可乐0115','RF991920115','件','8','2019-06-20','S000058','RS000004','GA000015','SP000004','SS000004','TT000015','RS000008','SO000004','RSO000015',NULL,'PACKED0115','1'),
	('G000116','可口可乐0116','RF991920116','箱','9','2017-07-06','S000058','RS000004','GA000015','SP000004','SS000004','TT000015','RS000008','SO000004','RSO000015',NULL,'PACKED0116','1'),
	('G000117','可口可乐0117','RF991920117','件','10','2016-11-28','S000059','RS000004','GA000015','SP000004','SS000004','TT000015','RS000008','SO000004','RSO000015',NULL,'PACKED0117','1'),
	('G000118','可口可乐0118','RF991920118','箱','9','2017-08-27','S000059','RS000004','GA000015','SP000004','SS000004','TT000015','RS000008','SO000004','RSO000015',NULL,'PACKED0118','1'),
	('G000119','可口可乐0119','RF991920119','件','8','2016-12-23','S000060','RS000004','GA000015','SP000004','SS000004','TT000015','RS000008','SO000004','RSO000015',NULL,'PACKED0119','1'),
	('G000120','可口可乐0120','RF991920120','箱','8','2019-05-23','S000060','RS000004','GA000015','SP000004','SS000004','TT000015','RS000008','SO000004','RSO000015',NULL,'PACKED0120','1'),
	('G000121','可口可乐0121','RF991920121','件','10','2018-12-23','S000061','RS000004','GA000016','SP000004','SS000004','TT000016','RS000008','SO000004','RSO000016',NULL,'PACKED0121','1'),
	('G000122','可口可乐0122','RF991920122','箱','10','2017-05-02','S000061','RS000004','GA000016','SP000004','SS000004','TT000016','RS000008','SO000004','RSO000016',NULL,'PACKED0122','1'),
	('G000123','可口可乐0123','RF991920123','件','10','2017-11-19','S000062','RS000004','GA000016','SP000004','SS000004','TT000016','RS000008','SO000004','RSO000016',NULL,'PACKED0123','1'),
	('G000124','可口可乐0124','RF991920124','箱','8','2017-11-30','S000062','RS000004','GA000016','SP000004','SS000004','TT000016','RS000008','SO000004','RSO000016',NULL,'PACKED0124','1'),
	('G000125','可口可乐0125','RF991920125','件','9','2018-02-20','S000063','RS000004','GA000016','SP000004','SS000004','TT000016','RS000008','SO000004','RSO000016',NULL,'PACKED0125','1'),
	('G000126','可口可乐0126','RF991920126','箱','9','2016-10-23','S000063','RS000004','GA000016','SP000004','SS000004','TT000016','RS000008','SO000004','RSO000016',NULL,'PACKED0126','1'),
	('G000127','可口可乐0127','RF991920127','件','9','2018-02-04','S000064','RS000004','GA000016','SP000004','SS000004','TT000016','RS000008','SO000004','RSO000016',NULL,'PACKED0127','1'),
	('G000128','可口可乐0128','RF991920128','箱','8','2018-07-29','S000064','RS000004','GA000016','SP000004','SS000004','TT000016','RS000008','SO000004','RSO000016',NULL,'PACKED0128','1');

insert into goods_packaging_data values
	('GP000001','王煜东','RF99192','2016-10-05','打包完成，准备起运','1');

insert into goods_movement_data values
	('GM000001','2019-06-26 06:30:25','仓库货位','仓库货位','192.168.20.1','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B405','FTYUIOLJYT^*(PLKJYT)','42.152160725583826','132.0400508155114','G000001','1'),
	('GM000002','2019-06-24 17:57:11','卡车','卡车','192.168.20.10002','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050002','FTYUIOLJYT^*(PLKJYT)0002','41.55695266532047','130.26717620035708','G000001','1'),
	('GM000003','2019-06-27 18:37:30','小超','小超','192.168.20.10003','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050003','FTYUIOLJYT^*(PLKJYT)0003','42.43242205283204','131.0701065071996','G000002','1'),
	('GM000004','2019-06-21 21:15:48','仓库货位','仓库货位','192.168.20.10004','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050004','FTYUIOLJYT^*(PLKJYT)0004','42.62545214991753','131.0834955652188','G000002','1'),
	('GM000005','2019-06-15 05:42:26','卡车','卡车','192.168.20.10005','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050005','FTYUIOLJYT^*(PLKJYT)0005','40.34283281101244','130.43256365268573','G000003','1'),
	('GM000006','2019-07-01 05:27:45','小超','小超','192.168.20.10006','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050006','FTYUIOLJYT^*(PLKJYT)0006','41.080830341853066','131.39882694946525','G000003','1'),
	('GM000007','2019-06-24 21:31:52','仓库货位','仓库货位','192.168.20.10007','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050007','FTYUIOLJYT^*(PLKJYT)0007','40.292683665331765','131.13695288209374','G000004','1'),
	('GM000008','2019-06-15 08:16:12','卡车','卡车','192.168.20.10008','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050008','FTYUIOLJYT^*(PLKJYT)0008','41.30296434954278','129.94442047320877','G000004','1'),
	('GM000009','2019-06-19 21:26:19','小超','小超','192.168.20.10009','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050009','FTYUIOLJYT^*(PLKJYT)0009','41.39162530232265','132.12563557469997','G000005','1'),
	('GM000010','2019-06-16 17:28:58','仓库货位','仓库货位','192.168.20.10010','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050010','FTYUIOLJYT^*(PLKJYT)0010','40.91682772349619','131.5741468912377','G000005','1'),
	('GM000011','2019-06-24 08:26:02','卡车','卡车','192.168.20.10011','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050011','FTYUIOLJYT^*(PLKJYT)0011','42.00494490315236','129.27764330181517','G000006','1'),
	('GM000012','2019-06-22 23:58:44','小超','小超','192.168.20.10012','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050012','FTYUIOLJYT^*(PLKJYT)0012','42.42628967532328','129.98566127041317','G000006','1'),
	('GM000013','2019-06-19 14:09:57','仓库货位','仓库货位','192.168.20.10013','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050013','FTYUIOLJYT^*(PLKJYT)0013','40.894511307481906','129.5031509706995','G000007','1'),
	('GM000014','2019-06-15 02:48:50','卡车','卡车','192.168.20.10014','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050014','FTYUIOLJYT^*(PLKJYT)0014','41.62612620138098','131.40842075289012','G000007','1'),
	('GM000015','2019-06-22 10:56:20','小超','小超','192.168.20.10015','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050015','FTYUIOLJYT^*(PLKJYT)0015','40.454440750706','130.04845244970167','G000008','1'),
	('GM000016','2019-06-30 08:25:57','仓库货位','仓库货位','192.168.20.10016','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050016','FTYUIOLJYT^*(PLKJYT)0016','41.743049919186475','129.65628815471263','G000008','1'),
	('GM000017','2019-06-13 06:31:40','卡车','卡车','192.168.20.10017','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050017','FTYUIOLJYT^*(PLKJYT)0017','41.78672052515119','131.56961371444328','G000009','1'),
	('GM000018','2019-06-21 06:04:03','小超','小超','192.168.20.10018','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050018','FTYUIOLJYT^*(PLKJYT)0018','40.28294194108329','130.2415022861041','G000009','1'),
	('GM000019','2019-06-15 19:53:28','仓库货位','仓库货位','192.168.20.10019','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050019','FTYUIOLJYT^*(PLKJYT)0019','40.41956465275643','131.86929209900256','G000010','1'),
	('GM000020','2019-06-16 15:14:48','卡车','卡车','192.168.20.10020','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050020','FTYUIOLJYT^*(PLKJYT)0020','42.46339949886702','130.88478228475194','G000010','1'),
	('GM000021','2019-06-20 05:42:45','小超','小超','192.168.20.10021','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050021','FTYUIOLJYT^*(PLKJYT)0021','40.02496891745002','129.78003006410498','G000011','1'),
	('GM000022','2019-06-26 04:58:04','仓库货位','仓库货位','192.168.20.10022','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050022','FTYUIOLJYT^*(PLKJYT)0022','41.164555059525895','130.25179271974113','G000011','1'),
	('GM000023','2019-06-26 11:56:56','卡车','卡车','192.168.20.10023','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050023','FTYUIOLJYT^*(PLKJYT)0023','41.607207497228245','130.88876654877748','G000012','1'),
	('GM000024','2019-07-01 21:50:13','小超','小超','192.168.20.10024','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050024','FTYUIOLJYT^*(PLKJYT)0024','40.07887796446048','130.50832702226512','G000012','1'),
	('GM000025','2019-06-12 14:31:41','仓库货位','仓库货位','192.168.20.10025','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050025','FTYUIOLJYT^*(PLKJYT)0025','40.516929727032384','131.76711016652905','G000013','1'),
	('GM000026','2019-06-18 13:47:42','卡车','卡车','192.168.20.10026','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050026','FTYUIOLJYT^*(PLKJYT)0026','40.73994756598632','130.36515870021347','G000013','1'),
	('GM000027','2019-06-28 13:35:54','小超','小超','192.168.20.10027','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050027','FTYUIOLJYT^*(PLKJYT)0027','42.39274999625367','129.75144528587376','G000014','1'),
	('GM000028','2019-06-28 22:20:16','仓库货位','仓库货位','192.168.20.10028','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050028','FTYUIOLJYT^*(PLKJYT)0028','40.68423300658404','132.11900201409554','G000014','1'),
	('GM000029','2019-06-23 07:39:01','卡车','卡车','192.168.20.10029','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050029','FTYUIOLJYT^*(PLKJYT)0029','41.481081020268604','131.02319176286295','G000015','1'),
	('GM000030','2019-06-17 10:21:25','小超','小超','192.168.20.10030','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050030','FTYUIOLJYT^*(PLKJYT)0030','39.98759998087917','130.3694657564419','G000015','1'),
	('GM000031','2019-06-27 22:04:47','仓库货位','仓库货位','192.168.20.10031','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050031','FTYUIOLJYT^*(PLKJYT)0031','40.863372131573854','129.70512676957748','G000016','1'),
	('GM000032','2019-07-01 09:18:18','卡车','卡车','192.168.20.10032','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050032','FTYUIOLJYT^*(PLKJYT)0032','40.924070971565335','131.0749591804455','G000016','1'),
	('GM000033','2019-06-25 11:34:04','小超','小超','192.168.20.10033','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050033','FTYUIOLJYT^*(PLKJYT)0033','40.19643372210062','131.6128448646083','G000017','1'),
	('GM000034','2019-06-30 13:36:23','仓库货位','仓库货位','192.168.20.10034','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050034','FTYUIOLJYT^*(PLKJYT)0034','41.63842301679565','130.51551850728256','G000017','1'),
	('GM000035','2019-06-19 20:09:38','卡车','卡车','192.168.20.10035','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050035','FTYUIOLJYT^*(PLKJYT)0035','41.80533501242162','129.3950488542315','G000018','1'),
	('GM000036','2019-06-22 15:09:50','小超','小超','192.168.20.10036','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050036','FTYUIOLJYT^*(PLKJYT)0036','42.39224622580672','131.06039817976205','G000018','1'),
	('GM000037','2019-06-27 10:15:21','仓库货位','仓库货位','192.168.20.10037','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050037','FTYUIOLJYT^*(PLKJYT)0037','42.159260487701026','129.54191990934834','G000019','1'),
	('GM000038','2019-06-23 02:25:26','卡车','卡车','192.168.20.10038','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050038','FTYUIOLJYT^*(PLKJYT)0038','42.53648260717272','131.03656817745843','G000019','1'),
	('GM000039','2019-06-26 18:39:16','小超','小超','192.168.20.10039','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050039','FTYUIOLJYT^*(PLKJYT)0039','40.099133772775296','130.63242822149553','G000020','1'),
	('GM000040','2019-06-21 04:54:06','仓库货位','仓库货位','192.168.20.10040','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050040','FTYUIOLJYT^*(PLKJYT)0040','41.549205404428974','129.99515474333515','G000020','1'),
	('GM000041','2019-06-19 17:12:00','卡车','卡车','192.168.20.10041','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050041','FTYUIOLJYT^*(PLKJYT)0041','42.002811832484035','130.48985711944064','G000021','1'),
	('GM000042','2019-07-02 18:22:17','小超','小超','192.168.20.10042','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050042','FTYUIOLJYT^*(PLKJYT)0042','39.93810509234445','131.45116287561586','G000021','1'),
	('GM000043','2019-06-16 11:23:56','仓库货位','仓库货位','192.168.20.10043','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050043','FTYUIOLJYT^*(PLKJYT)0043','40.59090942245306','129.3963943297471','G000022','1'),
	('GM000044','2019-07-02 05:20:05','卡车','卡车','192.168.20.10044','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050044','FTYUIOLJYT^*(PLKJYT)0044','40.99105691323095','131.29295495840523','G000022','1'),
	('GM000045','2019-07-03 01:39:16','小超','小超','192.168.20.10045','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050045','FTYUIOLJYT^*(PLKJYT)0045','42.156125872712565','131.2243792843435','G000023','1'),
	('GM000046','2019-06-19 02:46:44','仓库货位','仓库货位','192.168.20.10046','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050046','FTYUIOLJYT^*(PLKJYT)0046','41.2291294826847','131.22798518761633','G000023','1'),
	('GM000047','2019-06-14 23:18:45','卡车','卡车','192.168.20.10047','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050047','FTYUIOLJYT^*(PLKJYT)0047','40.894254307006','130.33131006289545','G000024','1'),
	('GM000048','2019-06-14 20:57:40','小超','小超','192.168.20.10048','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050048','FTYUIOLJYT^*(PLKJYT)0048','40.203941592530505','131.44688182800317','G000024','1'),
	('GM000049','2019-06-13 22:33:19','仓库货位','仓库货位','192.168.20.10049','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050049','FTYUIOLJYT^*(PLKJYT)0049','42.11940260500253','130.16124539848204','G000025','1'),
	('GM000050','2019-06-30 22:09:23','卡车','卡车','192.168.20.10050','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050050','FTYUIOLJYT^*(PLKJYT)0050','41.23050340242691','129.3864381993456','G000025','1'),
	('GM000051','2019-06-13 12:19:35','小超','小超','192.168.20.10051','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050051','FTYUIOLJYT^*(PLKJYT)0051','41.74353299273832','131.0356524269566','G000026','1'),
	('GM000052','2019-06-21 12:23:44','仓库货位','仓库货位','192.168.20.10052','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050052','FTYUIOLJYT^*(PLKJYT)0052','40.7683349614044','129.68134273382495','G000026','1'),
	('GM000053','2019-06-15 15:19:39','卡车','卡车','192.168.20.10053','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050053','FTYUIOLJYT^*(PLKJYT)0053','41.41603172573309','130.2065463211866','G000027','1'),
	('GM000054','2019-06-30 06:50:09','小超','小超','192.168.20.10054','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050054','FTYUIOLJYT^*(PLKJYT)0054','41.98409884376411','131.88310718723696','G000027','1'),
	('GM000055','2019-06-16 19:14:10','仓库货位','仓库货位','192.168.20.10055','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050055','FTYUIOLJYT^*(PLKJYT)0055','40.468086840305126','129.50405648866482','G000028','1'),
	('GM000056','2019-06-24 04:36:32','卡车','卡车','192.168.20.10056','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050056','FTYUIOLJYT^*(PLKJYT)0056','42.34021458359168','130.9518179092888','G000028','1'),
	('GM000057','2019-06-30 13:18:19','小超','小超','192.168.20.10057','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050057','FTYUIOLJYT^*(PLKJYT)0057','41.74523098445099','132.22507887838333','G000029','1'),
	('GM000058','2019-06-19 16:19:04','仓库货位','仓库货位','192.168.20.10058','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050058','FTYUIOLJYT^*(PLKJYT)0058','40.66355340780441','130.19184347764303','G000029','1'),
	('GM000059','2019-07-02 20:14:30','卡车','卡车','192.168.20.10059','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050059','FTYUIOLJYT^*(PLKJYT)0059','41.886179812330425','130.18080463380088','G000030','1'),
	('GM000060','2019-06-14 21:31:57','小超','小超','192.168.20.10060','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050060','FTYUIOLJYT^*(PLKJYT)0060','42.62958364332047','130.8969126157807','G000030','1'),
	('GM000061','2019-07-03 06:39:32','仓库货位','仓库货位','192.168.20.10061','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050061','FTYUIOLJYT^*(PLKJYT)0061','42.60436814596569','131.21564003276333','G000031','1'),
	('GM000062','2019-06-29 21:28:19','卡车','卡车','192.168.20.10062','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050062','FTYUIOLJYT^*(PLKJYT)0062','42.03912366269219','131.32408209148383','G000031','1'),
	('GM000063','2019-06-20 15:33:08','小超','小超','192.168.20.10063','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050063','FTYUIOLJYT^*(PLKJYT)0063','42.428287068475676','131.21097315545612','G000032','1'),
	('GM000064','2019-06-23 18:58:05','仓库货位','仓库货位','192.168.20.10064','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050064','FTYUIOLJYT^*(PLKJYT)0064','40.02164373227667','129.45172869071095','G000032','1'),
	('GM000065','2019-06-19 10:44:45','卡车','卡车','192.168.20.10065','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050065','FTYUIOLJYT^*(PLKJYT)0065','42.676407022620566','131.54263598785454','G000033','1'),
	('GM000066','2019-06-28 05:39:21','小超','小超','192.168.20.10066','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050066','FTYUIOLJYT^*(PLKJYT)0066','40.74096424528485','130.6561235813554','G000033','1'),
	('GM000067','2019-06-24 11:54:04','仓库货位','仓库货位','192.168.20.10067','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050067','FTYUIOLJYT^*(PLKJYT)0067','40.59131872285788','131.63462898531344','G000034','1'),
	('GM000068','2019-06-29 13:13:26','卡车','卡车','192.168.20.10068','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050068','FTYUIOLJYT^*(PLKJYT)0068','40.441966499064876','129.71731114861976','G000034','1'),
	('GM000069','2019-07-03 05:31:57','小超','小超','192.168.20.10069','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050069','FTYUIOLJYT^*(PLKJYT)0069','41.5855359265311','129.37320786029466','G000035','1'),
	('GM000070','2019-06-14 08:26:05','仓库货位','仓库货位','192.168.20.10070','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050070','FTYUIOLJYT^*(PLKJYT)0070','42.41192875893072','129.33147667601764','G000035','1'),
	('GM000071','2019-06-12 19:57:59','卡车','卡车','192.168.20.10071','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050071','FTYUIOLJYT^*(PLKJYT)0071','39.89861445100596','131.45989631563702','G000036','1'),
	('GM000072','2019-06-24 10:25:55','小超','小超','192.168.20.10072','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050072','FTYUIOLJYT^*(PLKJYT)0072','42.554316974374196','131.34792070221502','G000036','1'),
	('GM000073','2019-06-19 14:54:31','仓库货位','仓库货位','192.168.20.10073','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050073','FTYUIOLJYT^*(PLKJYT)0073','40.21290326974695','130.80012735999512','G000037','1'),
	('GM000074','2019-06-25 09:15:44','卡车','卡车','192.168.20.10074','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050074','FTYUIOLJYT^*(PLKJYT)0074','41.71891770365028','130.68897568228067','G000037','1'),
	('GM000075','2019-06-21 11:55:46','小超','小超','192.168.20.10075','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050075','FTYUIOLJYT^*(PLKJYT)0075','42.39503627923314','131.77239652075394','G000038','1'),
	('GM000076','2019-06-20 10:19:52','仓库货位','仓库货位','192.168.20.10076','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050076','FTYUIOLJYT^*(PLKJYT)0076','40.39833754066083','131.16612220832772','G000038','1'),
	('GM000077','2019-06-20 19:23:13','卡车','卡车','192.168.20.10077','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050077','FTYUIOLJYT^*(PLKJYT)0077','41.63450267993765','129.99302429329234','G000039','1'),
	('GM000078','2019-06-27 23:50:20','小超','小超','192.168.20.10078','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050078','FTYUIOLJYT^*(PLKJYT)0078','40.100975778670076','132.13125434151786','G000039','1'),
	('GM000079','2019-06-23 13:41:16','仓库货位','仓库货位','192.168.20.10079','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050079','FTYUIOLJYT^*(PLKJYT)0079','40.34222861182536','129.2914902881163','G000040','1'),
	('GM000080','2019-07-01 13:11:19','卡车','卡车','192.168.20.10080','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050080','FTYUIOLJYT^*(PLKJYT)0080','42.124105210669775','130.94517375723575','G000040','1'),
	('GM000081','2019-06-21 01:48:52','小超','小超','192.168.20.10081','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050081','FTYUIOLJYT^*(PLKJYT)0081','40.894616888663634','130.1140586127107','G000041','1'),
	('GM000082','2019-07-01 03:41:56','仓库货位','仓库货位','192.168.20.10082','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050082','FTYUIOLJYT^*(PLKJYT)0082','40.072774682680055','130.09327456684488','G000041','1'),
	('GM000083','2019-06-22 22:13:41','卡车','卡车','192.168.20.10083','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050083','FTYUIOLJYT^*(PLKJYT)0083','40.19610840716306','130.0679340355906','G000042','1'),
	('GM000084','2019-07-03 05:54:12','小超','小超','192.168.20.10084','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050084','FTYUIOLJYT^*(PLKJYT)0084','41.56162969081858','129.30894166727558','G000042','1'),
	('GM000085','2019-07-04 02:56:27','仓库货位','仓库货位','192.168.20.10085','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050085','FTYUIOLJYT^*(PLKJYT)0085','41.260847353198315','129.65895734961384','G000043','1'),
	('GM000086','2019-06-28 03:29:01','卡车','卡车','192.168.20.10086','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050086','FTYUIOLJYT^*(PLKJYT)0086','41.87379428041031','130.29697500207243','G000043','1'),
	('GM000087','2019-06-12 19:42:35','小超','小超','192.168.20.10087','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050087','FTYUIOLJYT^*(PLKJYT)0087','40.14688783139264','130.33298997827325','G000044','1'),
	('GM000088','2019-06-21 07:10:54','仓库货位','仓库货位','192.168.20.10088','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050088','FTYUIOLJYT^*(PLKJYT)0088','41.975664560473106','131.49155968095099','G000044','1'),
	('GM000089','2019-06-24 01:34:12','卡车','卡车','192.168.20.10089','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050089','FTYUIOLJYT^*(PLKJYT)0089','40.32062272192753','130.34038977281992','G000045','1'),
	('GM000090','2019-06-21 05:32:15','小超','小超','192.168.20.10090','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050090','FTYUIOLJYT^*(PLKJYT)0090','41.25644480814082','130.28572350589704','G000045','1'),
	('GM000091','2019-06-27 00:20:16','仓库货位','仓库货位','192.168.20.10091','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050091','FTYUIOLJYT^*(PLKJYT)0091','41.48142724756793','131.85571022612683','G000046','1'),
	('GM000092','2019-06-21 15:59:24','卡车','卡车','192.168.20.10092','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050092','FTYUIOLJYT^*(PLKJYT)0092','42.49975901997652','131.27229198173353','G000046','1'),
	('GM000093','2019-06-30 06:11:35','小超','小超','192.168.20.10093','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050093','FTYUIOLJYT^*(PLKJYT)0093','42.274198228511914','130.61795949093957','G000047','1'),
	('GM000094','2019-07-03 11:07:30','仓库货位','仓库货位','192.168.20.10094','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050094','FTYUIOLJYT^*(PLKJYT)0094','40.240554850903486','130.3211227689101','G000047','1'),
	('GM000095','2019-06-20 14:05:56','卡车','卡车','192.168.20.10095','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050095','FTYUIOLJYT^*(PLKJYT)0095','40.78845552231431','130.54304436573022','G000048','1'),
	('GM000096','2019-06-28 05:53:30','小超','小超','192.168.20.10096','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050096','FTYUIOLJYT^*(PLKJYT)0096','41.41828112669747','130.75555364337174','G000048','1'),
	('GM000097','2019-07-01 19:25:37','仓库货位','仓库货位','192.168.20.10097','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050097','FTYUIOLJYT^*(PLKJYT)0097','41.0555230616223','129.49764696363695','G000049','1'),
	('GM000098','2019-06-26 04:53:50','卡车','卡车','192.168.20.10098','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050098','FTYUIOLJYT^*(PLKJYT)0098','42.72707618319103','132.09483620122117','G000049','1'),
	('GM000099','2019-06-28 09:19:16','小超','小超','192.168.20.10099','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050099','FTYUIOLJYT^*(PLKJYT)0099','40.56918888452885','129.42660045819528','G000050','1'),
	('GM000100','2019-06-16 18:44:11','仓库货位','仓库货位','192.168.20.10100','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050100','FTYUIOLJYT^*(PLKJYT)0100','40.67119976439491','130.8017816332244','G000050','1'),
	('GM000101','2019-06-12 23:42:49','卡车','卡车','192.168.20.10101','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050101','FTYUIOLJYT^*(PLKJYT)0101','41.46997170707149','132.27333964957754','G000051','1'),
	('GM000102','2019-06-18 14:14:18','小超','小超','192.168.20.10102','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050102','FTYUIOLJYT^*(PLKJYT)0102','39.96053933759506','129.35946930259544','G000051','1'),
	('GM000103','2019-06-26 05:21:21','仓库货位','仓库货位','192.168.20.10103','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050103','FTYUIOLJYT^*(PLKJYT)0103','40.13912103890128','130.620317202809','G000052','1'),
	('GM000104','2019-06-27 23:19:14','卡车','卡车','192.168.20.10104','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050104','FTYUIOLJYT^*(PLKJYT)0104','40.69371560777311','130.83184417386707','G000052','1'),
	('GM000105','2019-06-24 19:42:13','小超','小超','192.168.20.10105','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050105','FTYUIOLJYT^*(PLKJYT)0105','41.376801670859656','131.46414341750287','G000053','1'),
	('GM000106','2019-06-22 17:48:58','仓库货位','仓库货位','192.168.20.10106','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050106','FTYUIOLJYT^*(PLKJYT)0106','39.957721060829876','130.51515703927362','G000053','1'),
	('GM000107','2019-06-18 01:07:01','卡车','卡车','192.168.20.10107','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050107','FTYUIOLJYT^*(PLKJYT)0107','41.811248737442746','130.304987682398','G000054','1'),
	('GM000108','2019-06-28 08:27:17','小超','小超','192.168.20.10108','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050108','FTYUIOLJYT^*(PLKJYT)0108','39.97138748852364','131.4259170481742','G000054','1'),
	('GM000109','2019-06-14 22:49:41','仓库货位','仓库货位','192.168.20.10109','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050109','FTYUIOLJYT^*(PLKJYT)0109','42.06431735189635','131.31347184668303','G000055','1'),
	('GM000110','2019-07-01 00:48:17','卡车','卡车','192.168.20.10110','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050110','FTYUIOLJYT^*(PLKJYT)0110','41.17916602179048','130.4023772758151','G000055','1'),
	('GM000111','2019-06-17 23:06:22','小超','小超','192.168.20.10111','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050111','FTYUIOLJYT^*(PLKJYT)0111','41.236741182247926','130.2985014906117','G000056','1'),
	('GM000112','2019-06-26 05:46:04','仓库货位','仓库货位','192.168.20.10112','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050112','FTYUIOLJYT^*(PLKJYT)0112','42.49120385115456','131.6172479001961','G000056','1'),
	('GM000113','2019-06-14 07:05:13','卡车','卡车','192.168.20.10113','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050113','FTYUIOLJYT^*(PLKJYT)0113','40.3670868008554','129.85946536599607','G000057','1'),
	('GM000114','2019-06-29 15:53:17','小超','小超','192.168.20.10114','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050114','FTYUIOLJYT^*(PLKJYT)0114','39.91063417196941','132.04662492687618','G000057','1'),
	('GM000115','2019-06-30 02:43:55','仓库货位','仓库货位','192.168.20.10115','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050115','FTYUIOLJYT^*(PLKJYT)0115','41.44605073868776','131.3048545261505','G000058','1'),
	('GM000116','2019-06-26 11:08:59','卡车','卡车','192.168.20.10116','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050116','FTYUIOLJYT^*(PLKJYT)0116','40.60010566497773','131.0419722622085','G000058','1'),
	('GM000117','2019-06-12 13:18:34','小超','小超','192.168.20.10117','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050117','FTYUIOLJYT^*(PLKJYT)0117','40.75717570493997','129.76109759188856','G000059','1'),
	('GM000118','2019-06-26 02:03:28','仓库货位','仓库货位','192.168.20.10118','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050118','FTYUIOLJYT^*(PLKJYT)0118','42.043224885740074','130.8769512610824','G000059','1'),
	('GM000119','2019-06-12 20:46:52','卡车','卡车','192.168.20.10119','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050119','FTYUIOLJYT^*(PLKJYT)0119','40.58170855007597','130.5004036402906','G000060','1'),
	('GM000120','2019-06-27 02:58:39','小超','小超','192.168.20.10120','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050120','FTYUIOLJYT^*(PLKJYT)0120','42.644768917916394','131.1481360050675','G000060','1'),
	('GM000121','2019-06-14 16:00:56','仓库货位','仓库货位','192.168.20.10121','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050121','FTYUIOLJYT^*(PLKJYT)0121','42.60523005969664','129.77037935520505','G000061','1'),
	('GM000122','2019-06-16 23:47:58','卡车','卡车','192.168.20.10122','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050122','FTYUIOLJYT^*(PLKJYT)0122','40.193859113779894','130.99798773820763','G000061','1'),
	('GM000123','2019-06-22 02:49:29','小超','小超','192.168.20.10123','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050123','FTYUIOLJYT^*(PLKJYT)0123','41.54353651868491','129.71252352621386','G000062','1'),
	('GM000124','2019-06-29 03:23:09','仓库货位','仓库货位','192.168.20.10124','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050124','FTYUIOLJYT^*(PLKJYT)0124','40.160012923583466','130.4903231265377','G000062','1'),
	('GM000125','2019-07-02 13:23:05','卡车','卡车','192.168.20.10125','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050125','FTYUIOLJYT^*(PLKJYT)0125','40.05235527079153','129.97837729856244','G000063','1'),
	('GM000126','2019-06-16 05:31:14','小超','小超','192.168.20.10126','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050126','FTYUIOLJYT^*(PLKJYT)0126','40.39197952381912','129.43394234068313','G000063','1'),
	('GM000127','2019-06-13 17:56:46','仓库货位','仓库货位','192.168.20.10127','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050127','FTYUIOLJYT^*(PLKJYT)0127','39.77775311527919','130.07375372998516','G000064','1'),
	('GM000128','2019-06-17 22:14:45','卡车','卡车','192.168.20.10128','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050128','FTYUIOLJYT^*(PLKJYT)0128','42.29800198254314','129.7407776609878','G000064','1'),
	('GM000129','2019-06-21 19:51:46','小超','小超','192.168.20.10129','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050129','FTYUIOLJYT^*(PLKJYT)0129','40.460108268313284','129.73131705288372','G000065','1'),
	('GM000130','2019-06-30 00:24:09','仓库货位','仓库货位','192.168.20.10130','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050130','FTYUIOLJYT^*(PLKJYT)0130','40.87375982345993','131.8831732960246','G000065','1'),
	('GM000131','2019-06-16 02:02:44','卡车','卡车','192.168.20.10131','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050131','FTYUIOLJYT^*(PLKJYT)0131','41.23344047378952','131.69370153780207','G000066','1'),
	('GM000132','2019-06-20 09:22:40','小超','小超','192.168.20.10132','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050132','FTYUIOLJYT^*(PLKJYT)0132','42.646466041662975','130.43365219449777','G000066','1'),
	('GM000133','2019-06-13 23:04:01','仓库货位','仓库货位','192.168.20.10133','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050133','FTYUIOLJYT^*(PLKJYT)0133','40.21353484694735','129.4128474353047','G000067','1'),
	('GM000134','2019-06-19 20:28:19','卡车','卡车','192.168.20.10134','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050134','FTYUIOLJYT^*(PLKJYT)0134','41.87179221445238','130.42331180858775','G000067','1'),
	('GM000135','2019-06-26 12:56:21','小超','小超','192.168.20.10135','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050135','FTYUIOLJYT^*(PLKJYT)0135','41.08308257891429','131.58139818967402','G000068','1'),
	('GM000136','2019-06-26 14:04:06','仓库货位','仓库货位','192.168.20.10136','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050136','FTYUIOLJYT^*(PLKJYT)0136','42.571467212724684','129.62600754817745','G000068','1'),
	('GM000137','2019-06-23 06:13:09','卡车','卡车','192.168.20.10137','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050137','FTYUIOLJYT^*(PLKJYT)0137','42.741052678726874','131.11959434074126','G000069','1'),
	('GM000138','2019-06-15 23:09:29','小超','小超','192.168.20.10138','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050138','FTYUIOLJYT^*(PLKJYT)0138','42.66615341379934','131.78952291062583','G000069','1'),
	('GM000139','2019-06-13 10:41:08','仓库货位','仓库货位','192.168.20.10139','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050139','FTYUIOLJYT^*(PLKJYT)0139','41.1583778106162','130.7724845463412','G000070','1'),
	('GM000140','2019-06-19 21:47:32','卡车','卡车','192.168.20.10140','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050140','FTYUIOLJYT^*(PLKJYT)0140','42.73879630699986','129.6074299457508','G000070','1'),
	('GM000141','2019-06-23 14:25:11','小超','小超','192.168.20.10141','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050141','FTYUIOLJYT^*(PLKJYT)0141','40.98509712358314','131.61944054779664','G000071','1'),
	('GM000142','2019-06-22 10:10:29','仓库货位','仓库货位','192.168.20.10142','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050142','FTYUIOLJYT^*(PLKJYT)0142','40.57192814416651','129.31236117807472','G000071','1'),
	('GM000143','2019-06-26 02:16:32','卡车','卡车','192.168.20.10143','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050143','FTYUIOLJYT^*(PLKJYT)0143','42.18826928973368','129.36853103384743','G000072','1'),
	('GM000144','2019-06-28 00:30:55','小超','小超','192.168.20.10144','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050144','FTYUIOLJYT^*(PLKJYT)0144','40.51788775209734','131.51962340922003','G000072','1'),
	('GM000145','2019-06-28 00:47:33','仓库货位','仓库货位','192.168.20.10145','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050145','FTYUIOLJYT^*(PLKJYT)0145','42.20881383002868','131.87552019989397','G000073','1'),
	('GM000146','2019-06-29 01:34:53','卡车','卡车','192.168.20.10146','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050146','FTYUIOLJYT^*(PLKJYT)0146','39.9786996746022','130.34679409239493','G000073','1'),
	('GM000147','2019-07-04 09:24:13','小超','小超','192.168.20.10147','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050147','FTYUIOLJYT^*(PLKJYT)0147','40.84313106225137','131.97997938735338','G000074','1'),
	('GM000148','2019-06-17 22:20:37','仓库货位','仓库货位','192.168.20.10148','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050148','FTYUIOLJYT^*(PLKJYT)0148','40.55319399037752','132.2580799390753','G000074','1'),
	('GM000149','2019-06-27 17:22:01','卡车','卡车','192.168.20.10149','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050149','FTYUIOLJYT^*(PLKJYT)0149','41.95670047041109','130.84372230116253','G000075','1'),
	('GM000150','2019-06-15 09:23:57','小超','小超','192.168.20.10150','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050150','FTYUIOLJYT^*(PLKJYT)0150','41.02919496514349','132.05033437888028','G000075','1'),
	('GM000151','2019-06-26 17:52:48','仓库货位','仓库货位','192.168.20.10151','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050151','FTYUIOLJYT^*(PLKJYT)0151','40.287288046659654','131.8796195048615','G000076','1'),
	('GM000152','2019-06-28 20:55:02','卡车','卡车','192.168.20.10152','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050152','FTYUIOLJYT^*(PLKJYT)0152','39.90026864364571','130.3199190688427','G000076','1'),
	('GM000153','2019-06-22 11:25:43','小超','小超','192.168.20.10153','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050153','FTYUIOLJYT^*(PLKJYT)0153','40.20096626069797','131.207551981565','G000077','1'),
	('GM000154','2019-06-27 21:31:39','仓库货位','仓库货位','192.168.20.10154','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050154','FTYUIOLJYT^*(PLKJYT)0154','42.027204656276744','130.6758387520085','G000077','1'),
	('GM000155','2019-06-24 15:22:42','卡车','卡车','192.168.20.10155','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050155','FTYUIOLJYT^*(PLKJYT)0155','42.42154138764605','130.0201979970459','G000078','1'),
	('GM000156','2019-06-19 20:03:57','小超','小超','192.168.20.10156','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050156','FTYUIOLJYT^*(PLKJYT)0156','40.76735867089151','131.33523254542177','G000078','1'),
	('GM000157','2019-06-25 23:51:15','仓库货位','仓库货位','192.168.20.10157','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050157','FTYUIOLJYT^*(PLKJYT)0157','40.20049436416601','130.20150381689874','G000079','1'),
	('GM000158','2019-06-30 05:58:34','卡车','卡车','192.168.20.10158','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050158','FTYUIOLJYT^*(PLKJYT)0158','41.199074012934446','130.13339821768002','G000079','1'),
	('GM000159','2019-06-25 03:48:16','小超','小超','192.168.20.10159','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050159','FTYUIOLJYT^*(PLKJYT)0159','41.25811259864747','129.94768169974273','G000080','1'),
	('GM000160','2019-06-30 10:26:51','仓库货位','仓库货位','192.168.20.10160','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050160','FTYUIOLJYT^*(PLKJYT)0160','40.07811316850528','130.87376121942634','G000080','1'),
	('GM000161','2019-06-25 14:21:57','卡车','卡车','192.168.20.10161','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050161','FTYUIOLJYT^*(PLKJYT)0161','40.37566173269197','130.69265375570154','G000081','1'),
	('GM000162','2019-06-17 09:32:51','小超','小超','192.168.20.10162','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050162','FTYUIOLJYT^*(PLKJYT)0162','41.998494064342815','131.44586249831607','G000081','1'),
	('GM000163','2019-06-13 02:03:25','仓库货位','仓库货位','192.168.20.10163','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050163','FTYUIOLJYT^*(PLKJYT)0163','41.91241160250622','130.55088152609255','G000082','1'),
	('GM000164','2019-07-04 10:08:57','卡车','卡车','192.168.20.10164','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050164','FTYUIOLJYT^*(PLKJYT)0164','41.777070441500264','130.75447478510867','G000082','1'),
	('GM000165','2019-06-23 22:58:20','小超','小超','192.168.20.10165','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050165','FTYUIOLJYT^*(PLKJYT)0165','42.55988539665613','131.23998481798472','G000083','1'),
	('GM000166','2019-06-24 23:43:07','仓库货位','仓库货位','192.168.20.10166','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050166','FTYUIOLJYT^*(PLKJYT)0166','40.74099979039042','130.87390741040122','G000083','1'),
	('GM000167','2019-06-26 13:29:38','卡车','卡车','192.168.20.10167','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050167','FTYUIOLJYT^*(PLKJYT)0167','40.51927665590366','130.52857045633067','G000084','1'),
	('GM000168','2019-06-13 02:34:56','小超','小超','192.168.20.10168','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050168','FTYUIOLJYT^*(PLKJYT)0168','42.03688814730803','130.5026139030773','G000084','1'),
	('GM000169','2019-06-29 15:25:51','仓库货位','仓库货位','192.168.20.10169','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050169','FTYUIOLJYT^*(PLKJYT)0169','41.327634403607505','129.93201256380806','G000085','1'),
	('GM000170','2019-06-23 05:09:16','卡车','卡车','192.168.20.10170','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050170','FTYUIOLJYT^*(PLKJYT)0170','40.982512517707214','131.91917226440012','G000085','1'),
	('GM000171','2019-07-03 08:03:05','小超','小超','192.168.20.10171','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050171','FTYUIOLJYT^*(PLKJYT)0171','40.98582629184849','130.4269089780627','G000086','1'),
	('GM000172','2019-06-20 12:25:17','仓库货位','仓库货位','192.168.20.10172','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050172','FTYUIOLJYT^*(PLKJYT)0172','42.29483895570445','129.79700183725552','G000086','1'),
	('GM000173','2019-06-26 06:15:10','卡车','卡车','192.168.20.10173','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050173','FTYUIOLJYT^*(PLKJYT)0173','41.718759741606235','129.41558324107746','G000087','1'),
	('GM000174','2019-07-03 03:26:15','小超','小超','192.168.20.10174','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050174','FTYUIOLJYT^*(PLKJYT)0174','40.715443396268675','130.12786090837164','G000087','1'),
	('GM000175','2019-06-20 10:27:18','仓库货位','仓库货位','192.168.20.10175','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050175','FTYUIOLJYT^*(PLKJYT)0175','41.878804701159986','130.10292167502413','G000088','1'),
	('GM000176','2019-06-25 09:01:33','卡车','卡车','192.168.20.10176','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050176','FTYUIOLJYT^*(PLKJYT)0176','42.34589559523234','129.72991825325056','G000088','1'),
	('GM000177','2019-07-02 16:41:08','小超','小超','192.168.20.10177','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050177','FTYUIOLJYT^*(PLKJYT)0177','40.580366937621875','130.67227125797018','G000089','1'),
	('GM000178','2019-06-26 14:37:44','仓库货位','仓库货位','192.168.20.10178','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050178','FTYUIOLJYT^*(PLKJYT)0178','42.14630500295464','130.61231744713965','G000089','1'),
	('GM000179','2019-06-28 09:20:43','卡车','卡车','192.168.20.10179','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050179','FTYUIOLJYT^*(PLKJYT)0179','40.91129561726227','129.50394839788933','G000090','1'),
	('GM000180','2019-06-30 23:57:47','小超','小超','192.168.20.10180','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050180','FTYUIOLJYT^*(PLKJYT)0180','42.55078648275823','131.46257669479644','G000090','1'),
	('GM000181','2019-06-19 09:44:41','仓库货位','仓库货位','192.168.20.10181','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050181','FTYUIOLJYT^*(PLKJYT)0181','40.930068193214005','129.77360859519175','G000091','1'),
	('GM000182','2019-06-27 11:47:44','卡车','卡车','192.168.20.10182','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050182','FTYUIOLJYT^*(PLKJYT)0182','40.5404563034055','131.48445491038225','G000091','1'),
	('GM000183','2019-06-18 04:11:21','小超','小超','192.168.20.10183','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050183','FTYUIOLJYT^*(PLKJYT)0183','40.44192035957115','130.71842195551577','G000092','1'),
	('GM000184','2019-06-27 22:05:04','仓库货位','仓库货位','192.168.20.10184','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050184','FTYUIOLJYT^*(PLKJYT)0184','40.57970616614109','131.40123363957954','G000092','1'),
	('GM000185','2019-06-25 08:50:07','卡车','卡车','192.168.20.10185','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050185','FTYUIOLJYT^*(PLKJYT)0185','42.20832172912046','131.05243125480106','G000093','1'),
	('GM000186','2019-06-15 12:59:59','小超','小超','192.168.20.10186','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050186','FTYUIOLJYT^*(PLKJYT)0186','42.37253758333303','131.952531768434','G000093','1'),
	('GM000187','2019-06-28 21:10:08','仓库货位','仓库货位','192.168.20.10187','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050187','FTYUIOLJYT^*(PLKJYT)0187','41.12912948779903','130.35000569651424','G000094','1'),
	('GM000188','2019-07-02 07:44:12','卡车','卡车','192.168.20.10188','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050188','FTYUIOLJYT^*(PLKJYT)0188','42.00592065825332','129.34220400255754','G000094','1'),
	('GM000189','2019-06-27 18:52:50','小超','小超','192.168.20.10189','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050189','FTYUIOLJYT^*(PLKJYT)0189','42.03268083928959','131.8649347928225','G000095','1'),
	('GM000190','2019-06-29 01:31:36','仓库货位','仓库货位','192.168.20.10190','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050190','FTYUIOLJYT^*(PLKJYT)0190','41.805331081335616','130.67163975205594','G000095','1'),
	('GM000191','2019-06-29 19:03:05','卡车','卡车','192.168.20.10191','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050191','FTYUIOLJYT^*(PLKJYT)0191','40.393937995916176','131.39505254013852','G000096','1'),
	('GM000192','2019-06-24 19:52:24','小超','小超','192.168.20.10192','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050192','FTYUIOLJYT^*(PLKJYT)0192','41.488310905250984','131.13854614722516','G000096','1'),
	('GM000193','2019-06-18 01:06:22','仓库货位','仓库货位','192.168.20.10193','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050193','FTYUIOLJYT^*(PLKJYT)0193','40.09314446393112','131.38658399804328','G000097','1'),
	('GM000194','2019-06-28 07:26:16','卡车','卡车','192.168.20.10194','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050194','FTYUIOLJYT^*(PLKJYT)0194','40.335211973596756','131.05838146809307','G000097','1'),
	('GM000195','2019-06-24 19:18:18','小超','小超','192.168.20.10195','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050195','FTYUIOLJYT^*(PLKJYT)0195','41.6364477911083','130.9625275501284','G000098','1'),
	('GM000196','2019-06-21 21:42:56','仓库货位','仓库货位','192.168.20.10196','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050196','FTYUIOLJYT^*(PLKJYT)0196','42.23795432682502','130.32692488701744','G000098','1'),
	('GM000197','2019-06-25 15:08:33','卡车','卡车','192.168.20.10197','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050197','FTYUIOLJYT^*(PLKJYT)0197','41.13541616314659','129.68482819064175','G000099','1'),
	('GM000198','2019-07-03 23:33:33','小超','小超','192.168.20.10198','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050198','FTYUIOLJYT^*(PLKJYT)0198','42.28903499886237','131.68158617635905','G000099','1'),
	('GM000199','2019-06-15 12:17:29','仓库货位','仓库货位','192.168.20.10199','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050199','FTYUIOLJYT^*(PLKJYT)0199','41.224742682517736','130.3659654490366','G000100','1'),
	('GM000200','2019-07-03 22:08:21','卡车','卡车','192.168.20.10200','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050200','FTYUIOLJYT^*(PLKJYT)0200','39.95114730451065','129.82015082497162','G000100','1'),
	('GM000201','2019-06-25 10:54:06','小超','小超','192.168.20.10201','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050201','FTYUIOLJYT^*(PLKJYT)0201','42.56774662841254','131.64262564320077','G000101','1'),
	('GM000202','2019-06-27 19:29:26','仓库货位','仓库货位','192.168.20.10202','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050202','FTYUIOLJYT^*(PLKJYT)0202','41.735231955808096','131.52352634364698','G000101','1'),
	('GM000203','2019-06-29 04:22:49','卡车','卡车','192.168.20.10203','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050203','FTYUIOLJYT^*(PLKJYT)0203','40.12923261613362','131.3387147341948','G000102','1'),
	('GM000204','2019-06-19 23:35:57','小超','小超','192.168.20.10204','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050204','FTYUIOLJYT^*(PLKJYT)0204','40.40982715799259','130.2191381223303','G000102','1'),
	('GM000205','2019-06-18 13:20:17','仓库货位','仓库货位','192.168.20.10205','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050205','FTYUIOLJYT^*(PLKJYT)0205','41.09715264294286','131.16908864443857','G000103','1'),
	('GM000206','2019-06-15 00:34:25','卡车','卡车','192.168.20.10206','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050206','FTYUIOLJYT^*(PLKJYT)0206','40.28107281088634','129.8699675731503','G000103','1'),
	('GM000207','2019-06-28 17:44:11','小超','小超','192.168.20.10207','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050207','FTYUIOLJYT^*(PLKJYT)0207','40.71126708993418','129.37664832939802','G000104','1'),
	('GM000208','2019-06-23 01:29:14','仓库货位','仓库货位','192.168.20.10208','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050208','FTYUIOLJYT^*(PLKJYT)0208','40.50015642599979','130.52751387925107','G000104','1'),
	('GM000209','2019-06-18 09:21:01','卡车','卡车','192.168.20.10209','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050209','FTYUIOLJYT^*(PLKJYT)0209','39.95217157616302','131.52711234977411','G000105','1'),
	('GM000210','2019-06-19 08:35:58','小超','小超','192.168.20.10210','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050210','FTYUIOLJYT^*(PLKJYT)0210','40.16847676135025','131.8324996717643','G000105','1'),
	('GM000211','2019-06-27 08:54:21','仓库货位','仓库货位','192.168.20.10211','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050211','FTYUIOLJYT^*(PLKJYT)0211','42.59183001918264','130.49670253183723','G000106','1'),
	('GM000212','2019-06-21 18:23:41','卡车','卡车','192.168.20.10212','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050212','FTYUIOLJYT^*(PLKJYT)0212','41.48108703538032','131.06285504472785','G000106','1'),
	('GM000213','2019-06-22 14:29:35','小超','小超','192.168.20.10213','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050213','FTYUIOLJYT^*(PLKJYT)0213','42.68192735206666','130.53265768375698','G000107','1'),
	('GM000214','2019-06-19 09:20:03','仓库货位','仓库货位','192.168.20.10214','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050214','FTYUIOLJYT^*(PLKJYT)0214','40.05243473205173','130.03296447391457','G000107','1'),
	('GM000215','2019-06-27 20:34:39','卡车','卡车','192.168.20.10215','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050215','FTYUIOLJYT^*(PLKJYT)0215','40.72436908038215','132.01503392631363','G000108','1'),
	('GM000216','2019-07-02 08:35:28','小超','小超','192.168.20.10216','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050216','FTYUIOLJYT^*(PLKJYT)0216','40.94702693106462','131.1505212259726','G000108','1'),
	('GM000217','2019-07-03 03:02:49','仓库货位','仓库货位','192.168.20.10217','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050217','FTYUIOLJYT^*(PLKJYT)0217','42.23515288601215','129.8364115214879','G000109','1'),
	('GM000218','2019-06-20 03:31:40','卡车','卡车','192.168.20.10218','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050218','FTYUIOLJYT^*(PLKJYT)0218','39.849038254313704','130.78741381710452','G000109','1'),
	('GM000219','2019-06-14 19:01:21','小超','小超','192.168.20.10219','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050219','FTYUIOLJYT^*(PLKJYT)0219','40.77530639296652','130.29526379447177','G000110','1'),
	('GM000220','2019-06-23 01:09:14','仓库货位','仓库货位','192.168.20.10220','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050220','FTYUIOLJYT^*(PLKJYT)0220','40.07228587797986','130.75929309049332','G000110','1'),
	('GM000221','2019-06-24 12:22:26','卡车','卡车','192.168.20.10221','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050221','FTYUIOLJYT^*(PLKJYT)0221','40.0179289810659','129.48585234850793','G000111','1'),
	('GM000222','2019-06-17 07:19:31','小超','小超','192.168.20.10222','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050222','FTYUIOLJYT^*(PLKJYT)0222','41.07428677323605','130.21589724137647','G000111','1'),
	('GM000223','2019-06-22 06:30:56','仓库货位','仓库货位','192.168.20.10223','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050223','FTYUIOLJYT^*(PLKJYT)0223','42.67651831007535','131.7952108986647','G000112','1'),
	('GM000224','2019-06-28 19:46:32','卡车','卡车','192.168.20.10224','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050224','FTYUIOLJYT^*(PLKJYT)0224','42.39978217700487','130.59251924206157','G000112','1'),
	('GM000225','2019-06-21 06:54:22','小超','小超','192.168.20.10225','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050225','FTYUIOLJYT^*(PLKJYT)0225','41.905268570530055','129.48430613421428','G000113','1'),
	('GM000226','2019-06-19 14:08:14','仓库货位','仓库货位','192.168.20.10226','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050226','FTYUIOLJYT^*(PLKJYT)0226','40.16027746619216','131.07449691509342','G000113','1'),
	('GM000227','2019-06-24 19:54:53','卡车','卡车','192.168.20.10227','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050227','FTYUIOLJYT^*(PLKJYT)0227','42.756065761077345','130.14969091428458','G000114','1'),
	('GM000228','2019-06-18 22:32:46','小超','小超','192.168.20.10228','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050228','FTYUIOLJYT^*(PLKJYT)0228','40.642547111389135','130.2842155707888','G000114','1'),
	('GM000229','2019-07-04 08:38:44','仓库货位','仓库货位','192.168.20.10229','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050229','FTYUIOLJYT^*(PLKJYT)0229','40.73929110346906','130.11337863654813','G000115','1'),
	('GM000230','2019-06-15 17:01:31','卡车','卡车','192.168.20.10230','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050230','FTYUIOLJYT^*(PLKJYT)0230','42.332058214096705','131.7573938436375','G000115','1'),
	('GM000231','2019-06-19 03:55:53','小超','小超','192.168.20.10231','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050231','FTYUIOLJYT^*(PLKJYT)0231','41.17669649215555','131.4673917758452','G000116','1'),
	('GM000232','2019-06-30 22:45:07','仓库货位','仓库货位','192.168.20.10232','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050232','FTYUIOLJYT^*(PLKJYT)0232','40.70386713544907','131.2665545532684','G000116','1'),
	('GM000233','2019-06-13 22:25:43','卡车','卡车','192.168.20.10233','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050233','FTYUIOLJYT^*(PLKJYT)0233','42.68559984636497','131.36620769314743','G000117','1'),
	('GM000234','2019-07-01 08:08:49','小超','小超','192.168.20.10234','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050234','FTYUIOLJYT^*(PLKJYT)0234','40.756357875843484','129.84936772501945','G000117','1'),
	('GM000235','2019-07-02 03:38:50','仓库货位','仓库货位','192.168.20.10235','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050235','FTYUIOLJYT^*(PLKJYT)0235','42.51613518091381','130.49151409692382','G000118','1'),
	('GM000236','2019-07-04 03:33:13','卡车','卡车','192.168.20.10236','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050236','FTYUIOLJYT^*(PLKJYT)0236','41.390461034662216','129.573422893806','G000118','1'),
	('GM000237','2019-06-18 15:04:37','小超','小超','192.168.20.10237','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050237','FTYUIOLJYT^*(PLKJYT)0237','41.93959205546341','130.95128290333625','G000119','1'),
	('GM000238','2019-06-14 23:45:32','仓库货位','仓库货位','192.168.20.10238','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050238','FTYUIOLJYT^*(PLKJYT)0238','39.83258394649354','131.82299809373828','G000119','1'),
	('GM000239','2019-07-01 06:43:50','卡车','卡车','192.168.20.10239','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050239','FTYUIOLJYT^*(PLKJYT)0239','40.208918531165715','130.77679439874228','G000120','1'),
	('GM000240','2019-06-16 20:29:43','小超','小超','192.168.20.10240','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050240','FTYUIOLJYT^*(PLKJYT)0240','42.09289086955024','130.3242187672073','G000120','1'),
	('GM000241','2019-06-18 10:17:51','仓库货位','仓库货位','192.168.20.10241','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050241','FTYUIOLJYT^*(PLKJYT)0241','40.675798584437324','130.97013408721492','G000121','1'),
	('GM000242','2019-06-14 20:54:31','卡车','卡车','192.168.20.10242','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050242','FTYUIOLJYT^*(PLKJYT)0242','42.686910515265225','130.9699541964025','G000121','1'),
	('GM000243','2019-06-16 10:23:18','小超','小超','192.168.20.10243','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050243','FTYUIOLJYT^*(PLKJYT)0243','40.236523348178245','130.56971029411133','G000122','1'),
	('GM000244','2019-06-29 16:58:29','仓库货位','仓库货位','192.168.20.10244','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050244','FTYUIOLJYT^*(PLKJYT)0244','40.03846353491773','131.8928021546172','G000122','1'),
	('GM000245','2019-07-02 23:00:07','卡车','卡车','192.168.20.10245','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050245','FTYUIOLJYT^*(PLKJYT)0245','40.815967408241406','131.54699594496978','G000123','1'),
	('GM000246','2019-06-27 08:51:15','小超','小超','192.168.20.10246','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050246','FTYUIOLJYT^*(PLKJYT)0246','41.15195679727708','130.43212526664192','G000123','1'),
	('GM000247','2019-06-17 08:08:00','仓库货位','仓库货位','192.168.20.10247','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050247','FTYUIOLJYT^*(PLKJYT)0247','41.900780812418624','131.64409360190484','G000124','1'),
	('GM000248','2019-07-03 02:14:31','卡车','卡车','192.168.20.10248','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050248','FTYUIOLJYT^*(PLKJYT)0248','41.58418103356599','131.8085040270593','G000124','1'),
	('GM000249','2019-06-13 18:24:26','小超','小超','192.168.20.10249','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050249','FTYUIOLJYT^*(PLKJYT)0249','40.155471547804055','129.39460951395776','G000125','1'),
	('GM000250','2019-06-19 07:13:54','仓库货位','仓库货位','192.168.20.10250','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050250','FTYUIOLJYT^*(PLKJYT)0250','42.76748773634664','130.25596277797743','G000125','1'),
	('GM000251','2019-06-16 23:46:39','卡车','卡车','192.168.20.10251','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050251','FTYUIOLJYT^*(PLKJYT)0251','42.74505938478975','130.94106105625974','G000126','1'),
	('GM000252','2019-06-18 08:00:52','小超','小超','192.168.20.10252','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050252','FTYUIOLJYT^*(PLKJYT)0252','42.410855401168654','132.25934090669347','G000126','1'),
	('GM000253','2019-06-25 01:14:43','仓库货位','仓库货位','192.168.20.10253','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050253','FTYUIOLJYT^*(PLKJYT)0253','42.63274155944316','130.5376270551818','G000127','1'),
	('GM000254','2019-06-30 13:38:44','卡车','卡车','192.168.20.10254','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050254','FTYUIOLJYT^*(PLKJYT)0254','40.6217468723575','130.73227125685','G000127','1'),
	('GM000255','2019-06-26 07:51:36','小超','小超','192.168.20.10255','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050255','FTYUIOLJYT^*(PLKJYT)0255','42.69844213612687','129.4900982509781','G000128','1'),
	('GM000256','2019-06-28 16:23:48','仓库货位','仓库货位','192.168.20.10256','Mozilla/5.0 (iPad; U; CPU OS 3_2_1 like Mac OS X; en-us) AppleWebKit/531.21.10 (KHTML, like Gecko) Mobile/7B4050256','FTYUIOLJYT^*(PLKJYT)0256','41.40430669074892','131.67207665835696','G000128','1');

insert into supplier_space_data values
	('SS000001','成都龙泉驿飞鹤路20号供货商独立管理区','02887654321','1876平方米','W000001','40.98785968322656','129.54955600460795','2019-07-03 18:42:19','1'),
	('SS000002','成都龙泉驿飞鹤路20号供货商独立管理区0002','028876543210002','1876平方米0002','W000001','42.3957177057052','129.66523199319616','2019-06-24 10:28:40','1'),
	('SS000003','成都龙泉驿飞鹤路20号供货商独立管理区0003','028876543210003','1876平方米0003','W000002','40.026421619391336','129.80688781975755','2019-06-23 07:03:39','1'),
	('SS000004','成都龙泉驿飞鹤路20号供货商独立管理区0004','028876543210004','1876平方米0004','W000002','41.52104628689766','129.96238789068673','2019-07-04 02:44:31','1');

insert into receiving_space_data values
	('RS000001','成都龙泉驿飞鹤路20号仓库卸货区','02887654321','每个收货区可以供一辆车卸货','1876平方米','W000001','42.45638596975411','130.8802548024853','2019-06-18 01:40:44','1'),
	('RS000002','成都龙泉驿飞鹤路20号仓库卸货区0002','028876543210002','每个收货区可以供一辆车卸货0002','1876平方米0002','W000001','40.8794849268933','129.99801367874457','2019-06-18 00:24:11','1'),
	('RS000003','成都龙泉驿飞鹤路20号仓库卸货区0003','028876543210003','每个收货区可以供一辆车卸货0003','1876平方米0003','W000002','42.72265450179951','132.01121409373744','2019-07-03 17:35:47','1'),
	('RS000004','成都龙泉驿飞鹤路20号仓库卸货区0004','028876543210004','每个收货区可以供一辆车卸货0004','1876平方米0004','W000002','40.46785200887059','129.9764957566489','2019-06-20 09:52:03','1');

insert into shipping_space_data values
	('SS000001','成都龙泉驿飞鹤路20号装货区','02887654321','1876平方米','W000001','40.09316386480306','131.32897439924253','每个收货区可以供一辆车装货','2019-06-26 03:40:20','1'),
	('SS000002','成都龙泉驿飞鹤路20号装货区0002','028876543210002','1876平方米0002','W000001','41.43215319065849','131.44179560348806','每个收货区可以供一辆车装货0002','2019-06-17 08:53:51','1'),
	('SS000003','成都龙泉驿飞鹤路20号装货区0003','028876543210003','1876平方米0003','W000002','41.862603994485895','130.21840645428696','每个收货区可以供一辆车装货0003','2019-06-29 17:08:51','1'),
	('SS000004','成都龙泉驿飞鹤路20号装货区0004','028876543210004','1876平方米0004','W000002','40.625037946805165','130.68695065942546','每个收货区可以供一辆车装货0004','2019-06-26 00:36:23','1');

insert into damage_space_data values
	('DS000001','成都龙泉驿飞鹤路20号仓库损坏货物堆放区','02887654321','1876平方米','39.88223704782205','131.77717188611405','W000001','2019-06-16 14:12:46','1'),
	('DS000002','成都龙泉驿飞鹤路20号仓库损坏货物堆放区0002','028876543210002','1876平方米0002','41.65811031401269','131.73014741827313','W000001','2019-06-16 07:54:53','1'),
	('DS000003','成都龙泉驿飞鹤路20号仓库损坏货物堆放区0003','028876543210003','1876平方米0003','40.37033758453748','129.6615474268688','W000002','2019-06-30 21:55:11','1'),
	('DS000004','成都龙泉驿飞鹤路20号仓库损坏货物堆放区0004','028876543210004','1876平方米0004','40.46519700546511','130.27448289436657','W000002','2019-06-13 01:21:49','1');

insert into warehouse_asset_data values
	('WA000001','叉车','备用件存放区设备库房','W000001','2019-06-28 19:27:38','1'),
	('WA000002','托盘','备用件存放区设备库房0002','W000001','2019-06-16 09:26:45','1'),
	('WA000003','传送带备件','备用件存放区设备库房0003','W000002','2019-06-25 06:44:37','1'),
	('WA000004','叉车','备用件存放区设备库房0004','W000002','2019-06-25 10:44:46','1');

insert into transport_fleet_data values
	('TF000001','双链先锋号车队','02887654321','RSCC000001','2019-06-14 00:37:39','1'),
	('TF000002','双链先锋号车队0002','028876543210002','RSCC000003','2019-06-27 10:11:38','1');

insert into transport_truck_data values
	('TT000001','运货卡车','川AK5','02887654321','VL9198','EN00102','2016-07-11','100万公里','红色','TF000001','1'),
	('TT000002','运货卡车0002','川AK50002','028876543210002','VL91980002','EN001020002','2018-01-29','100万公里0002','蓝色','TF000001','1'),
	('TT000003','运货卡车0003','川AK50003','028876543210003','VL91980003','EN001020003','2018-02-02','100万公里0003','白色','TF000002','1'),
	('TT000004','运货卡车0004','川AK50004','028876543210004','VL91980004','EN001020004','2018-07-06','100万公里0004','灰色','TF000002','1');

insert into truck_driver_data values
	('TD000001','运货卡车司机','51099887733','18777778888','TF000001','1'),
	('TD000002','运货卡车司机0002','510998877330002','13900000002','TF000001','1'),
	('TD000003','运货卡车司机0003','510998877330003','13900000003','TF000002','1'),
	('TD000004','运货卡车司机0004','510998877330004','13900000004','TF000002','1');

insert into transport_task_data values
	('TT000001','货运记录','双链二号仓','2019-04-02','RS000001','TD000001','TT000001','TF000001','41.99044376021846','131.794470249106','1'),
	('TT000002','货运记录0002','双链二号仓0002','2016-09-05','RS000001','TD000001','TT000001','TF000001','42.26930654919607','130.23839592468454','1'),
	('TT000003','货运记录0003','双链二号仓0003','2017-05-12','RS000002','TD000001','TT000001','TF000001','41.250328786508874','130.97241964721755','1'),
	('TT000004','货运记录0004','双链二号仓0004','2016-11-21','RS000002','TD000001','TT000001','TF000001','42.73586103935682','131.5620271137707','1'),
	('TT000005','货运记录0005','双链二号仓0005','2018-10-05','RS000003','TD000002','TT000002','TF000001','42.46957893705098','130.6290282459641','1'),
	('TT000006','货运记录0006','双链二号仓0006','2017-05-07','RS000003','TD000002','TT000002','TF000001','41.29194591415394','132.08726030015887','1'),
	('TT000007','货运记录0007','双链二号仓0007','2017-04-19','RS000004','TD000002','TT000002','TF000001','41.59305630026314','130.85110129095744','1'),
	('TT000008','货运记录0008','双链二号仓0008','2019-05-11','RS000004','TD000002','TT000002','TF000001','42.58721469503832','131.79516364032585','1'),
	('TT000009','货运记录0009','双链二号仓0009','2018-12-05','RS000005','TD000003','TT000003','TF000002','41.90511814358525','131.85300903170233','1'),
	('TT000010','货运记录0010','双链二号仓0010','2017-09-10','RS000005','TD000003','TT000003','TF000002','40.71964903457517','132.09904950890723','1'),
	('TT000011','货运记录0011','双链二号仓0011','2019-04-30','RS000006','TD000003','TT000003','TF000002','41.12275140159094','130.5926585686865','1'),
	('TT000012','货运记录0012','双链二号仓0012','2019-05-29','RS000006','TD000003','TT000003','TF000002','39.850959491994914','130.00315783549618','1'),
	('TT000013','货运记录0013','双链二号仓0013','2018-11-15','RS000007','TD000004','TT000004','TF000002','40.75151790372554','130.55873351685133','1'),
	('TT000014','货运记录0014','双链二号仓0014','2017-02-24','RS000007','TD000004','TT000004','TF000002','42.32261458287227','131.9659954073646','1'),
	('TT000015','货运记录0015','双链二号仓0015','2019-04-30','RS000008','TD000004','TT000004','TF000002','42.242493495702384','130.48809785433866','1'),
	('TT000016','货运记录0016','双链二号仓0016','2018-11-15','RS000008','TD000004','TT000004','TF000002','41.21468592546945','131.9006889774905','1');

insert into transport_task_track_data values
	('TTT000001','2016-12-11','31.52462520920045','103.6220541437482','TT000001','1'),
	('TTT000002','2016-10-24','32.17911882311717','103.31901853730885','TT000001','1'),
	('TTT000003','2019-06-10','31.87817456896358','105.89465220430152','TT000002','1'),
	('TTT000004','2016-12-24','30.701098593441856','104.03667890547904','TT000002','1'),
	('TTT000005','2017-01-02','30.29321786534314','104.26739200821699','TT000003','1'),
	('TTT000006','2016-09-12','32.8554995345532','105.49575630939515','TT000003','1'),
	('TTT000007','2017-10-23','30.16896539635279','105.93980446724677','TT000004','1'),
	('TTT000008','2019-01-01','31.477975629296083','105.44781581558028','TT000004','1'),
	('TTT000009','2017-12-31','30.162933133570668','104.0403512254794','TT000005','1'),
	('TTT000010','2017-01-28','32.646621109960066','104.1822717004721','TT000005','1'),
	('TTT000011','2018-07-14','32.75724185518561','104.47689756317627','TT000006','1'),
	('TTT000012','2019-04-09','30.38536337441528','103.43394273208366','TT000006','1'),
	('TTT000013','2017-03-08','32.697592622080386','104.24918100401287','TT000007','1'),
	('TTT000014','2018-05-25','30.80595887824515','104.69845168573414','TT000007','1'),
	('TTT000015','2017-03-13','31.21819274158176','104.6011597707402','TT000008','1'),
	('TTT000016','2018-10-25','31.942639407154356','103.4924101115497','TT000008','1'),
	('TTT000017','2017-02-09','32.74549036630376','105.97975960544295','TT000009','1'),
	('TTT000018','2016-08-11','32.1310632729697','103.71707335116481','TT000009','1'),
	('TTT000019','2019-01-24','31.2075169229853','104.21900359280046','TT000010','1'),
	('TTT000020','2016-12-08','30.425326622344848','103.48408447590455','TT000010','1'),
	('TTT000021','2018-11-30','30.823113918967078','105.398669579096','TT000011','1'),
	('TTT000022','2017-01-13','30.619129018066943','103.54297246600775','TT000011','1'),
	('TTT000023','2018-09-28','32.606143224255774','103.41397673977202','TT000012','1'),
	('TTT000024','2018-08-21','30.841128698851115','104.955788849414','TT000012','1'),
	('TTT000025','2018-04-24','32.4843713685954','103.43245857840843','TT000013','1'),
	('TTT000026','2017-10-15','32.59706187621367','103.92883575908178','TT000013','1'),
	('TTT000027','2018-12-13','31.732137482390037','105.86689168207741','TT000014','1'),
	('TTT000028','2018-06-18','31.714951672271404','105.40965983499149','TT000014','1'),
	('TTT000029','2018-02-12','32.07184166778526','103.53527424595428','TT000015','1'),
	('TTT000030','2018-09-18','30.862939515629165','105.25479624829413','TT000015','1'),
	('TTT000031','2018-11-03','31.67402674399453','103.85238206736186','TT000016','1'),
	('TTT000032','2018-07-04','32.61580271874982','105.67619162824172','TT000016','1');

insert into account_set_data values
	('AS000001','账套2017','2017年','2017-02-02','企业会计制度','RMB','人民币','招商银行','33265805054885','RSCC000001','RS000001','GS000001','2019-06-28 17:42:31','1'),
	('AS000002','账套2018','2018年','2019-02-22','小企业会计制度','USD','美元','工商银行','332658050548850002','RSCC000001','RS000001','GS000001','2019-07-01 15:34:19','1'),
	('AS000003','账套2019','2019年','2017-10-08','合伙制会计制度','RMB','人民币','招商银行','332658050548850003','RSCC000001','RS000002','GS000001','2019-06-21 17:08:53','1'),
	('AS000004','账套2017','2017年','2017-02-11','企业会计制度','USD','美元','工商银行','332658050548850004','RSCC000001','RS000002','GS000001','2019-06-29 05:46:07','1'),
	('AS000005','账套2018','2018年','2017-05-13','小企业会计制度','RMB','人民币','招商银行','332658050548850005','RSCC000002','RS000003','GS000001','2019-06-26 20:11:49','1'),
	('AS000006','账套2019','2019年','2017-02-21','合伙制会计制度','USD','美元','工商银行','332658050548850006','RSCC000002','RS000003','GS000001','2019-06-19 06:20:32','1'),
	('AS000007','账套2017','2017年','2018-05-24','企业会计制度','RMB','人民币','招商银行','332658050548850007','RSCC000002','RS000004','GS000002','2019-06-23 17:25:53','1'),
	('AS000008','账套2018','2018年','2018-04-08','小企业会计制度','USD','美元','工商银行','332658050548850008','RSCC000002','RS000004','GS000002','2019-07-02 10:23:36','1'),
	('AS000009','账套2019','2019年','2018-05-09','合伙制会计制度','RMB','人民币','招商银行','332658050548850009','RSCC000003','RS000005','GS000002','2019-06-16 22:19:02','1'),
	('AS000010','账套2017','2017年','2017-02-12','企业会计制度','USD','美元','工商银行','332658050548850010','RSCC000003','RS000005','GS000002','2019-06-23 07:30:38','1'),
	('AS000011','账套2018','2018年','2018-05-22','小企业会计制度','RMB','人民币','招商银行','332658050548850011','RSCC000003','RS000006','GS000002','2019-07-03 22:52:16','1'),
	('AS000012','账套2019','2019年','2017-02-24','合伙制会计制度','USD','美元','工商银行','332658050548850012','RSCC000003','RS000006','GS000003','2019-06-15 18:53:22','1'),
	('AS000013','账套2017','2017年','2018-12-08','企业会计制度','RMB','人民币','招商银行','332658050548850013','RSCC000004','RS000007','GS000003','2019-06-28 06:02:01','1'),
	('AS000014','账套2018','2018年','2017-04-11','小企业会计制度','USD','美元','工商银行','332658050548850014','RSCC000004','RS000007','GS000003','2019-06-16 05:50:43','1'),
	('AS000015','账套2019','2019年','2016-12-13','合伙制会计制度','RMB','人民币','招商银行','332658050548850015','RSCC000004','RS000008','GS000003','2019-06-27 19:14:22','1'),
	('AS000016','账套2017','2017年','2017-12-16','企业会计制度','USD','美元','工商银行','332658050548850016','RSCC000004','RS000008','GS000003','2019-06-13 15:10:23','1');

insert into accounting_subject_data values
	('AS000001','AS9999','银行存款','1','资产类','AS000001','1'),
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
	('AP000001','2017年1月','2018-03-08','2017-11-06','AS000001','1'),
	('AP000002','2017年2月','2018-09-23','2019-06-10','AS000001','1'),
	('AP000003','2017年3月','2017-06-13','2017-08-04','AS000002','1'),
	('AP000004','2017年4月','2018-02-23','2017-06-01','AS000002','1'),
	('AP000005','2017年5月','2017-05-06','2016-11-14','AS000003','1'),
	('AP000006','2017年6月','2018-09-08','2017-12-30','AS000003','1'),
	('AP000007','2017年7月','2019-01-31','2019-03-20','AS000004','1'),
	('AP000008','2017年8月','2017-12-01','2016-12-06','AS000004','1'),
	('AP000009','2017年9月','2017-03-30','2018-09-28','AS000005','1'),
	('AP000010','2017年10月','2017-06-04','2018-03-25','AS000005','1'),
	('AP000011','2017年11月','2018-03-11','2017-10-25','AS000006','1'),
	('AP000012','2017年12月','2019-06-26','2019-03-10','AS000006','1'),
	('AP000013','2017年1月','2018-09-22','2018-10-27','AS000007','1'),
	('AP000014','2017年2月','2018-04-18','2017-02-08','AS000007','1'),
	('AP000015','2017年3月','2018-02-27','2016-08-04','AS000008','1'),
	('AP000016','2017年4月','2016-11-02','2016-09-03','AS000008','1'),
	('AP000017','2017年5月','2019-06-26','2016-11-04','AS000009','1'),
	('AP000018','2017年6月','2018-11-04','2017-10-13','AS000009','1'),
	('AP000019','2017年7月','2017-09-11','2019-02-09','AS000010','1'),
	('AP000020','2017年8月','2019-05-28','2017-12-27','AS000010','1'),
	('AP000021','2017年9月','2019-05-24','2018-07-16','AS000011','1'),
	('AP000022','2017年10月','2018-10-19','2016-10-06','AS000011','1'),
	('AP000023','2017年11月','2016-12-08','2018-06-25','AS000012','1'),
	('AP000024','2017年12月','2018-10-13','2018-07-20','AS000012','1'),
	('AP000025','2017年1月','2017-03-07','2017-08-21','AS000013','1'),
	('AP000026','2017年2月','2017-07-08','2017-06-19','AS000013','1'),
	('AP000027','2017年3月','2018-08-05','2017-05-13','AS000014','1'),
	('AP000028','2017年4月','2018-06-10','2016-09-26','AS000014','1'),
	('AP000029','2017年5月','2018-01-25','2018-11-09','AS000015','1'),
	('AP000030','2017年6月','2019-02-20','2016-12-18','AS000015','1'),
	('AP000031','2017年7月','2017-03-01','2016-10-02','AS000016','1'),
	('AP000032','2017年8月','2019-02-04','2016-08-10','AS000016','1');

insert into accounting_document_type_data values
	('ADT000001','记账凭证','又称记账凭单，是会计人员根据审核无误的原始凭证按照经济业务事项的内容加以分类，并据以确定会计分录后所填制的会计凭证。它是登记账簿的直接依据。','AS000001','1'),
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
	('AD000001','记账凭证','2018-09-21','AP000001','ADT000001',NULL,NULL,NULL,NULL,'CREATED','1'),
	('AD000002','记账凭证0002','2019-03-12','AP000001','ADT000001',NULL,NULL,NULL,NULL,'CONFIRMED','1'),
	('AD000003','记账凭证0003','2016-07-09','AP000002','ADT000002',NULL,NULL,NULL,NULL,'AUDITED','1'),
	('AD000004','记账凭证0004','2018-06-10','AP000002','ADT000002',NULL,NULL,NULL,NULL,'POSTED','1'),
	('AD000005','记账凭证0005','2017-11-26','AP000003','ADT000003',NULL,NULL,NULL,NULL,'CREATED','1'),
	('AD000006','记账凭证0006','2017-04-15','AP000003','ADT000003',NULL,NULL,NULL,NULL,'CONFIRMED','1'),
	('AD000007','记账凭证0007','2018-02-23','AP000004','ADT000004',NULL,NULL,NULL,NULL,'AUDITED','1'),
	('AD000008','记账凭证0008','2019-02-10','AP000004','ADT000004',NULL,NULL,NULL,NULL,'POSTED','1'),
	('AD000009','记账凭证0009','2017-08-13','AP000005','ADT000005',NULL,NULL,NULL,NULL,'CREATED','1'),
	('AD000010','记账凭证0010','2018-08-06','AP000005','ADT000005',NULL,NULL,NULL,NULL,'CONFIRMED','1'),
	('AD000011','记账凭证0011','2018-09-18','AP000006','ADT000006',NULL,NULL,NULL,NULL,'AUDITED','1'),
	('AD000012','记账凭证0012','2017-07-17','AP000006','ADT000006',NULL,NULL,NULL,NULL,'POSTED','1'),
	('AD000013','记账凭证0013','2017-01-17','AP000007','ADT000007',NULL,NULL,NULL,NULL,'CREATED','1'),
	('AD000014','记账凭证0014','2017-06-24','AP000007','ADT000007',NULL,NULL,NULL,NULL,'CONFIRMED','1'),
	('AD000015','记账凭证0015','2019-05-10','AP000008','ADT000008',NULL,NULL,NULL,NULL,'AUDITED','1'),
	('AD000016','记账凭证0016','2019-05-25','AP000008','ADT000008',NULL,NULL,NULL,NULL,'POSTED','1'),
	('AD000017','记账凭证0017','2018-09-02','AP000009','ADT000009',NULL,NULL,NULL,NULL,'CREATED','1'),
	('AD000018','记账凭证0018','2017-10-23','AP000009','ADT000009',NULL,NULL,NULL,NULL,'CONFIRMED','1'),
	('AD000019','记账凭证0019','2016-07-30','AP000010','ADT000010',NULL,NULL,NULL,NULL,'AUDITED','1'),
	('AD000020','记账凭证0020','2016-09-26','AP000010','ADT000010',NULL,NULL,NULL,NULL,'POSTED','1'),
	('AD000021','记账凭证0021','2016-07-08','AP000011','ADT000011',NULL,NULL,NULL,NULL,'CREATED','1'),
	('AD000022','记账凭证0022','2018-02-10','AP000011','ADT000011',NULL,NULL,NULL,NULL,'CONFIRMED','1'),
	('AD000023','记账凭证0023','2016-09-06','AP000012','ADT000012',NULL,NULL,NULL,NULL,'AUDITED','1'),
	('AD000024','记账凭证0024','2016-08-12','AP000012','ADT000012',NULL,NULL,NULL,NULL,'POSTED','1'),
	('AD000025','记账凭证0025','2017-10-14','AP000013','ADT000013',NULL,NULL,NULL,NULL,'CREATED','1'),
	('AD000026','记账凭证0026','2019-01-12','AP000013','ADT000013',NULL,NULL,NULL,NULL,'CONFIRMED','1'),
	('AD000027','记账凭证0027','2018-09-30','AP000014','ADT000014',NULL,NULL,NULL,NULL,'AUDITED','1'),
	('AD000028','记账凭证0028','2017-05-15','AP000014','ADT000014',NULL,NULL,NULL,NULL,'POSTED','1'),
	('AD000029','记账凭证0029','2018-02-06','AP000015','ADT000015',NULL,NULL,NULL,NULL,'CREATED','1'),
	('AD000030','记账凭证0030','2018-09-10','AP000015','ADT000015',NULL,NULL,NULL,NULL,'CONFIRMED','1'),
	('AD000031','记账凭证0031','2018-12-10','AP000016','ADT000016',NULL,NULL,NULL,NULL,'AUDITED','1'),
	('AD000032','记账凭证0032','2019-05-15','AP000016','ADT000016',NULL,NULL,NULL,NULL,'POSTED','1'),
	('AD000033','记账凭证0033','2016-07-30','AP000017','ADT000017',NULL,NULL,NULL,NULL,'CREATED','1'),
	('AD000034','记账凭证0034','2018-08-16','AP000017','ADT000017',NULL,NULL,NULL,NULL,'CONFIRMED','1'),
	('AD000035','记账凭证0035','2018-02-04','AP000018','ADT000018',NULL,NULL,NULL,NULL,'AUDITED','1'),
	('AD000036','记账凭证0036','2017-12-16','AP000018','ADT000018',NULL,NULL,NULL,NULL,'POSTED','1'),
	('AD000037','记账凭证0037','2017-10-22','AP000019','ADT000019',NULL,NULL,NULL,NULL,'CREATED','1'),
	('AD000038','记账凭证0038','2016-09-21','AP000019','ADT000019',NULL,NULL,NULL,NULL,'CONFIRMED','1'),
	('AD000039','记账凭证0039','2017-09-15','AP000020','ADT000020',NULL,NULL,NULL,NULL,'AUDITED','1'),
	('AD000040','记账凭证0040','2018-09-06','AP000020','ADT000020',NULL,NULL,NULL,NULL,'POSTED','1'),
	('AD000041','记账凭证0041','2018-06-25','AP000021','ADT000021',NULL,NULL,NULL,NULL,'CREATED','1'),
	('AD000042','记账凭证0042','2018-01-16','AP000021','ADT000021',NULL,NULL,NULL,NULL,'CONFIRMED','1'),
	('AD000043','记账凭证0043','2019-05-17','AP000022','ADT000022',NULL,NULL,NULL,NULL,'AUDITED','1'),
	('AD000044','记账凭证0044','2017-12-26','AP000022','ADT000022',NULL,NULL,NULL,NULL,'POSTED','1'),
	('AD000045','记账凭证0045','2018-11-28','AP000023','ADT000023',NULL,NULL,NULL,NULL,'CREATED','1'),
	('AD000046','记账凭证0046','2018-03-17','AP000023','ADT000023',NULL,NULL,NULL,NULL,'CONFIRMED','1'),
	('AD000047','记账凭证0047','2017-08-20','AP000024','ADT000024',NULL,NULL,NULL,NULL,'AUDITED','1'),
	('AD000048','记账凭证0048','2018-02-07','AP000024','ADT000024',NULL,NULL,NULL,NULL,'POSTED','1'),
	('AD000049','记账凭证0049','2017-01-19','AP000025','ADT000025',NULL,NULL,NULL,NULL,'CREATED','1'),
	('AD000050','记账凭证0050','2016-09-18','AP000025','ADT000025',NULL,NULL,NULL,NULL,'CONFIRMED','1'),
	('AD000051','记账凭证0051','2016-09-05','AP000026','ADT000026',NULL,NULL,NULL,NULL,'AUDITED','1'),
	('AD000052','记账凭证0052','2018-03-09','AP000026','ADT000026',NULL,NULL,NULL,NULL,'POSTED','1'),
	('AD000053','记账凭证0053','2016-11-21','AP000027','ADT000027',NULL,NULL,NULL,NULL,'CREATED','1'),
	('AD000054','记账凭证0054','2017-08-02','AP000027','ADT000027',NULL,NULL,NULL,NULL,'CONFIRMED','1'),
	('AD000055','记账凭证0055','2018-02-04','AP000028','ADT000028',NULL,NULL,NULL,NULL,'AUDITED','1'),
	('AD000056','记账凭证0056','2019-05-18','AP000028','ADT000028',NULL,NULL,NULL,NULL,'POSTED','1'),
	('AD000057','记账凭证0057','2017-01-11','AP000029','ADT000029',NULL,NULL,NULL,NULL,'CREATED','1'),
	('AD000058','记账凭证0058','2017-07-10','AP000029','ADT000029',NULL,NULL,NULL,NULL,'CONFIRMED','1'),
	('AD000059','记账凭证0059','2016-12-09','AP000030','ADT000030',NULL,NULL,NULL,NULL,'AUDITED','1'),
	('AD000060','记账凭证0060','2018-02-13','AP000030','ADT000030',NULL,NULL,NULL,NULL,'POSTED','1'),
	('AD000061','记账凭证0061','2018-04-05','AP000031','ADT000031',NULL,NULL,NULL,NULL,'CREATED','1'),
	('AD000062','记账凭证0062','2017-01-26','AP000031','ADT000031',NULL,NULL,NULL,NULL,'CONFIRMED','1'),
	('AD000063','记账凭证0063','2018-10-28','AP000032','ADT000032',NULL,NULL,NULL,NULL,'AUDITED','1'),
	('AD000064','记账凭证0064','2018-10-15','AP000032','ADT000032',NULL,NULL,NULL,NULL,'POSTED','1');

insert into accounting_document_creation_data values
	('ADC000001','财务会计','确认提交','2018-08-12','1');

insert into accounting_document_confirmation_data values
	('ADC000001','财务会计','确认通过','2019-03-04','1');

insert into accounting_document_auditing_data values
	('ADA000001','财务会计','审核通过，要都审核过了才通过哦','2017-07-26','1');

insert into accounting_document_posting_data values
	('ADP000001','财务会计','审核通过，要都审核过了才通过哦','2018-07-07','1');

insert into original_voucher_data values
	('OV000001','这是手写的发票','李亚青','本公司','原始凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000001',NULL,NULL,NULL,'CREATED','1'),
	('OV000002','这是手写的发票0002','李亚青0002','本公司0002','发票','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000001',NULL,NULL,NULL,'CONFIRMED','1'),
	('OV000003','这是手写的发票0003','李亚青0003','本公司0003','出库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000002',NULL,NULL,NULL,'AUDITED','1'),
	('OV000004','这是手写的发票0004','李亚青0004','本公司0004','入库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000002',NULL,NULL,NULL,'CREATED','1'),
	('OV000005','这是手写的发票0005','李亚青0005','本公司0005','存款回执','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000003',NULL,NULL,NULL,'CONFIRMED','1'),
	('OV000006','这是手写的发票0006','李亚青0006','本公司0006','验收证明','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000003',NULL,NULL,NULL,'AUDITED','1'),
	('OV000007','这是手写的发票0007','李亚青0007','本公司0007','借款凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000004',NULL,NULL,NULL,'CREATED','1'),
	('OV000008','这是手写的发票0008','李亚青0008','本公司0008','原始凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000004',NULL,NULL,NULL,'CONFIRMED','1'),
	('OV000009','这是手写的发票0009','李亚青0009','本公司0009','发票','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000005',NULL,NULL,NULL,'AUDITED','1'),
	('OV000010','这是手写的发票0010','李亚青0010','本公司0010','出库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000005',NULL,NULL,NULL,'CREATED','1'),
	('OV000011','这是手写的发票0011','李亚青0011','本公司0011','入库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000006',NULL,NULL,NULL,'CONFIRMED','1'),
	('OV000012','这是手写的发票0012','李亚青0012','本公司0012','存款回执','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000006',NULL,NULL,NULL,'AUDITED','1'),
	('OV000013','这是手写的发票0013','李亚青0013','本公司0013','验收证明','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000007',NULL,NULL,NULL,'CREATED','1'),
	('OV000014','这是手写的发票0014','李亚青0014','本公司0014','借款凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000007',NULL,NULL,NULL,'CONFIRMED','1'),
	('OV000015','这是手写的发票0015','李亚青0015','本公司0015','原始凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000008',NULL,NULL,NULL,'AUDITED','1'),
	('OV000016','这是手写的发票0016','李亚青0016','本公司0016','发票','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000008',NULL,NULL,NULL,'CREATED','1'),
	('OV000017','这是手写的发票0017','李亚青0017','本公司0017','出库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000009',NULL,NULL,NULL,'CONFIRMED','1'),
	('OV000018','这是手写的发票0018','李亚青0018','本公司0018','入库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000009',NULL,NULL,NULL,'AUDITED','1'),
	('OV000019','这是手写的发票0019','李亚青0019','本公司0019','存款回执','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000010',NULL,NULL,NULL,'CREATED','1'),
	('OV000020','这是手写的发票0020','李亚青0020','本公司0020','验收证明','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000010',NULL,NULL,NULL,'CONFIRMED','1'),
	('OV000021','这是手写的发票0021','李亚青0021','本公司0021','借款凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000011',NULL,NULL,NULL,'AUDITED','1'),
	('OV000022','这是手写的发票0022','李亚青0022','本公司0022','原始凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000011',NULL,NULL,NULL,'CREATED','1'),
	('OV000023','这是手写的发票0023','李亚青0023','本公司0023','发票','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000012',NULL,NULL,NULL,'CONFIRMED','1'),
	('OV000024','这是手写的发票0024','李亚青0024','本公司0024','出库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000012',NULL,NULL,NULL,'AUDITED','1'),
	('OV000025','这是手写的发票0025','李亚青0025','本公司0025','入库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000013',NULL,NULL,NULL,'CREATED','1'),
	('OV000026','这是手写的发票0026','李亚青0026','本公司0026','存款回执','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000013',NULL,NULL,NULL,'CONFIRMED','1'),
	('OV000027','这是手写的发票0027','李亚青0027','本公司0027','验收证明','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000014',NULL,NULL,NULL,'AUDITED','1'),
	('OV000028','这是手写的发票0028','李亚青0028','本公司0028','借款凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000014',NULL,NULL,NULL,'CREATED','1'),
	('OV000029','这是手写的发票0029','李亚青0029','本公司0029','原始凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000015',NULL,NULL,NULL,'CONFIRMED','1'),
	('OV000030','这是手写的发票0030','李亚青0030','本公司0030','发票','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000015',NULL,NULL,NULL,'AUDITED','1'),
	('OV000031','这是手写的发票0031','李亚青0031','本公司0031','出库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000016',NULL,NULL,NULL,'CREATED','1'),
	('OV000032','这是手写的发票0032','李亚青0032','本公司0032','入库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000016',NULL,NULL,NULL,'CONFIRMED','1'),
	('OV000033','这是手写的发票0033','李亚青0033','本公司0033','存款回执','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000017',NULL,NULL,NULL,'AUDITED','1'),
	('OV000034','这是手写的发票0034','李亚青0034','本公司0034','验收证明','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000017',NULL,NULL,NULL,'CREATED','1'),
	('OV000035','这是手写的发票0035','李亚青0035','本公司0035','借款凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000018',NULL,NULL,NULL,'CONFIRMED','1'),
	('OV000036','这是手写的发票0036','李亚青0036','本公司0036','原始凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000018',NULL,NULL,NULL,'AUDITED','1'),
	('OV000037','这是手写的发票0037','李亚青0037','本公司0037','发票','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000019',NULL,NULL,NULL,'CREATED','1'),
	('OV000038','这是手写的发票0038','李亚青0038','本公司0038','出库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000019',NULL,NULL,NULL,'CONFIRMED','1'),
	('OV000039','这是手写的发票0039','李亚青0039','本公司0039','入库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000020',NULL,NULL,NULL,'AUDITED','1'),
	('OV000040','这是手写的发票0040','李亚青0040','本公司0040','存款回执','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000020',NULL,NULL,NULL,'CREATED','1'),
	('OV000041','这是手写的发票0041','李亚青0041','本公司0041','验收证明','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000021',NULL,NULL,NULL,'CONFIRMED','1'),
	('OV000042','这是手写的发票0042','李亚青0042','本公司0042','借款凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000021',NULL,NULL,NULL,'AUDITED','1'),
	('OV000043','这是手写的发票0043','李亚青0043','本公司0043','原始凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000022',NULL,NULL,NULL,'CREATED','1'),
	('OV000044','这是手写的发票0044','李亚青0044','本公司0044','发票','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000022',NULL,NULL,NULL,'CONFIRMED','1'),
	('OV000045','这是手写的发票0045','李亚青0045','本公司0045','出库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000023',NULL,NULL,NULL,'AUDITED','1'),
	('OV000046','这是手写的发票0046','李亚青0046','本公司0046','入库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000023',NULL,NULL,NULL,'CREATED','1'),
	('OV000047','这是手写的发票0047','李亚青0047','本公司0047','存款回执','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000024',NULL,NULL,NULL,'CONFIRMED','1'),
	('OV000048','这是手写的发票0048','李亚青0048','本公司0048','验收证明','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000024',NULL,NULL,NULL,'AUDITED','1'),
	('OV000049','这是手写的发票0049','李亚青0049','本公司0049','借款凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000025',NULL,NULL,NULL,'CREATED','1'),
	('OV000050','这是手写的发票0050','李亚青0050','本公司0050','原始凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000025',NULL,NULL,NULL,'CONFIRMED','1'),
	('OV000051','这是手写的发票0051','李亚青0051','本公司0051','发票','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000026',NULL,NULL,NULL,'AUDITED','1'),
	('OV000052','这是手写的发票0052','李亚青0052','本公司0052','出库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000026',NULL,NULL,NULL,'CREATED','1'),
	('OV000053','这是手写的发票0053','李亚青0053','本公司0053','入库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000027',NULL,NULL,NULL,'CONFIRMED','1'),
	('OV000054','这是手写的发票0054','李亚青0054','本公司0054','存款回执','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000027',NULL,NULL,NULL,'AUDITED','1'),
	('OV000055','这是手写的发票0055','李亚青0055','本公司0055','验收证明','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000028',NULL,NULL,NULL,'CREATED','1'),
	('OV000056','这是手写的发票0056','李亚青0056','本公司0056','借款凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000028',NULL,NULL,NULL,'CONFIRMED','1'),
	('OV000057','这是手写的发票0057','李亚青0057','本公司0057','原始凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000029',NULL,NULL,NULL,'AUDITED','1'),
	('OV000058','这是手写的发票0058','李亚青0058','本公司0058','发票','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000029',NULL,NULL,NULL,'CREATED','1'),
	('OV000059','这是手写的发票0059','李亚青0059','本公司0059','出库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000030',NULL,NULL,NULL,'CONFIRMED','1'),
	('OV000060','这是手写的发票0060','李亚青0060','本公司0060','入库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000030',NULL,NULL,NULL,'AUDITED','1'),
	('OV000061','这是手写的发票0061','李亚青0061','本公司0061','存款回执','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000031',NULL,NULL,NULL,'CREATED','1'),
	('OV000062','这是手写的发票0062','李亚青0062','本公司0062','验收证明','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000031',NULL,NULL,NULL,'CONFIRMED','1'),
	('OV000063','这是手写的发票0063','李亚青0063','本公司0063','借款凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000032',NULL,NULL,NULL,'AUDITED','1'),
	('OV000064','这是手写的发票0064','李亚青0064','本公司0064','原始凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000032',NULL,NULL,NULL,'CREATED','1'),
	('OV000065','这是手写的发票0065','李亚青0065','本公司0065','发票','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000033',NULL,NULL,NULL,'CONFIRMED','1'),
	('OV000066','这是手写的发票0066','李亚青0066','本公司0066','出库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000033',NULL,NULL,NULL,'AUDITED','1'),
	('OV000067','这是手写的发票0067','李亚青0067','本公司0067','入库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000034',NULL,NULL,NULL,'CREATED','1'),
	('OV000068','这是手写的发票0068','李亚青0068','本公司0068','存款回执','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000034',NULL,NULL,NULL,'CONFIRMED','1'),
	('OV000069','这是手写的发票0069','李亚青0069','本公司0069','验收证明','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000035',NULL,NULL,NULL,'AUDITED','1'),
	('OV000070','这是手写的发票0070','李亚青0070','本公司0070','借款凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000035',NULL,NULL,NULL,'CREATED','1'),
	('OV000071','这是手写的发票0071','李亚青0071','本公司0071','原始凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000036',NULL,NULL,NULL,'CONFIRMED','1'),
	('OV000072','这是手写的发票0072','李亚青0072','本公司0072','发票','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000036',NULL,NULL,NULL,'AUDITED','1'),
	('OV000073','这是手写的发票0073','李亚青0073','本公司0073','出库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000037',NULL,NULL,NULL,'CREATED','1'),
	('OV000074','这是手写的发票0074','李亚青0074','本公司0074','入库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000037',NULL,NULL,NULL,'CONFIRMED','1'),
	('OV000075','这是手写的发票0075','李亚青0075','本公司0075','存款回执','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000038',NULL,NULL,NULL,'AUDITED','1'),
	('OV000076','这是手写的发票0076','李亚青0076','本公司0076','验收证明','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000038',NULL,NULL,NULL,'CREATED','1'),
	('OV000077','这是手写的发票0077','李亚青0077','本公司0077','借款凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000039',NULL,NULL,NULL,'CONFIRMED','1'),
	('OV000078','这是手写的发票0078','李亚青0078','本公司0078','原始凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000039',NULL,NULL,NULL,'AUDITED','1'),
	('OV000079','这是手写的发票0079','李亚青0079','本公司0079','发票','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000040',NULL,NULL,NULL,'CREATED','1'),
	('OV000080','这是手写的发票0080','李亚青0080','本公司0080','出库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000040',NULL,NULL,NULL,'CONFIRMED','1'),
	('OV000081','这是手写的发票0081','李亚青0081','本公司0081','入库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000041',NULL,NULL,NULL,'AUDITED','1'),
	('OV000082','这是手写的发票0082','李亚青0082','本公司0082','存款回执','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000041',NULL,NULL,NULL,'CREATED','1'),
	('OV000083','这是手写的发票0083','李亚青0083','本公司0083','验收证明','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000042',NULL,NULL,NULL,'CONFIRMED','1'),
	('OV000084','这是手写的发票0084','李亚青0084','本公司0084','借款凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000042',NULL,NULL,NULL,'AUDITED','1'),
	('OV000085','这是手写的发票0085','李亚青0085','本公司0085','原始凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000043',NULL,NULL,NULL,'CREATED','1'),
	('OV000086','这是手写的发票0086','李亚青0086','本公司0086','发票','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000043',NULL,NULL,NULL,'CONFIRMED','1'),
	('OV000087','这是手写的发票0087','李亚青0087','本公司0087','出库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000044',NULL,NULL,NULL,'AUDITED','1'),
	('OV000088','这是手写的发票0088','李亚青0088','本公司0088','入库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000044',NULL,NULL,NULL,'CREATED','1'),
	('OV000089','这是手写的发票0089','李亚青0089','本公司0089','存款回执','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000045',NULL,NULL,NULL,'CONFIRMED','1'),
	('OV000090','这是手写的发票0090','李亚青0090','本公司0090','验收证明','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000045',NULL,NULL,NULL,'AUDITED','1'),
	('OV000091','这是手写的发票0091','李亚青0091','本公司0091','借款凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000046',NULL,NULL,NULL,'CREATED','1'),
	('OV000092','这是手写的发票0092','李亚青0092','本公司0092','原始凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000046',NULL,NULL,NULL,'CONFIRMED','1'),
	('OV000093','这是手写的发票0093','李亚青0093','本公司0093','发票','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000047',NULL,NULL,NULL,'AUDITED','1'),
	('OV000094','这是手写的发票0094','李亚青0094','本公司0094','出库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000047',NULL,NULL,NULL,'CREATED','1'),
	('OV000095','这是手写的发票0095','李亚青0095','本公司0095','入库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000048',NULL,NULL,NULL,'CONFIRMED','1'),
	('OV000096','这是手写的发票0096','李亚青0096','本公司0096','存款回执','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000048',NULL,NULL,NULL,'AUDITED','1'),
	('OV000097','这是手写的发票0097','李亚青0097','本公司0097','验收证明','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000049',NULL,NULL,NULL,'CREATED','1'),
	('OV000098','这是手写的发票0098','李亚青0098','本公司0098','借款凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000049',NULL,NULL,NULL,'CONFIRMED','1'),
	('OV000099','这是手写的发票0099','李亚青0099','本公司0099','原始凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000050',NULL,NULL,NULL,'AUDITED','1'),
	('OV000100','这是手写的发票0100','李亚青0100','本公司0100','发票','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000050',NULL,NULL,NULL,'CREATED','1'),
	('OV000101','这是手写的发票0101','李亚青0101','本公司0101','出库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000051',NULL,NULL,NULL,'CONFIRMED','1'),
	('OV000102','这是手写的发票0102','李亚青0102','本公司0102','入库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000051',NULL,NULL,NULL,'AUDITED','1'),
	('OV000103','这是手写的发票0103','李亚青0103','本公司0103','存款回执','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000052',NULL,NULL,NULL,'CREATED','1'),
	('OV000104','这是手写的发票0104','李亚青0104','本公司0104','验收证明','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000052',NULL,NULL,NULL,'CONFIRMED','1'),
	('OV000105','这是手写的发票0105','李亚青0105','本公司0105','借款凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000053',NULL,NULL,NULL,'AUDITED','1'),
	('OV000106','这是手写的发票0106','李亚青0106','本公司0106','原始凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000053',NULL,NULL,NULL,'CREATED','1'),
	('OV000107','这是手写的发票0107','李亚青0107','本公司0107','发票','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000054',NULL,NULL,NULL,'CONFIRMED','1'),
	('OV000108','这是手写的发票0108','李亚青0108','本公司0108','出库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000054',NULL,NULL,NULL,'AUDITED','1'),
	('OV000109','这是手写的发票0109','李亚青0109','本公司0109','入库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000055',NULL,NULL,NULL,'CREATED','1'),
	('OV000110','这是手写的发票0110','李亚青0110','本公司0110','存款回执','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000055',NULL,NULL,NULL,'CONFIRMED','1'),
	('OV000111','这是手写的发票0111','李亚青0111','本公司0111','验收证明','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000056',NULL,NULL,NULL,'AUDITED','1'),
	('OV000112','这是手写的发票0112','李亚青0112','本公司0112','借款凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000056',NULL,NULL,NULL,'CREATED','1'),
	('OV000113','这是手写的发票0113','李亚青0113','本公司0113','原始凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000057',NULL,NULL,NULL,'CONFIRMED','1'),
	('OV000114','这是手写的发票0114','李亚青0114','本公司0114','发票','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000057',NULL,NULL,NULL,'AUDITED','1'),
	('OV000115','这是手写的发票0115','李亚青0115','本公司0115','出库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000058',NULL,NULL,NULL,'CREATED','1'),
	('OV000116','这是手写的发票0116','李亚青0116','本公司0116','入库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000058',NULL,NULL,NULL,'CONFIRMED','1'),
	('OV000117','这是手写的发票0117','李亚青0117','本公司0117','存款回执','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000059',NULL,NULL,NULL,'AUDITED','1'),
	('OV000118','这是手写的发票0118','李亚青0118','本公司0118','验收证明','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000059',NULL,NULL,NULL,'CREATED','1'),
	('OV000119','这是手写的发票0119','李亚青0119','本公司0119','借款凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000060',NULL,NULL,NULL,'CONFIRMED','1'),
	('OV000120','这是手写的发票0120','李亚青0120','本公司0120','原始凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000060',NULL,NULL,NULL,'AUDITED','1'),
	('OV000121','这是手写的发票0121','李亚青0121','本公司0121','发票','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000061',NULL,NULL,NULL,'CREATED','1'),
	('OV000122','这是手写的发票0122','李亚青0122','本公司0122','出库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000061',NULL,NULL,NULL,'CONFIRMED','1'),
	('OV000123','这是手写的发票0123','李亚青0123','本公司0123','入库单','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000062',NULL,NULL,NULL,'AUDITED','1'),
	('OV000124','这是手写的发票0124','李亚青0124','本公司0124','存款回执','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000062',NULL,NULL,NULL,'CREATED','1'),
	('OV000125','这是手写的发票0125','李亚青0125','本公司0125','验收证明','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000063',NULL,NULL,NULL,'CONFIRMED','1'),
	('OV000126','这是手写的发票0126','李亚青0126','本公司0126','借款凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000063',NULL,NULL,NULL,'AUDITED','1'),
	('OV000127','这是手写的发票0127','李亚青0127','本公司0127','原始凭证','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000064',NULL,NULL,NULL,'CREATED','1'),
	('OV000128','这是手写的发票0128','李亚青0128','本公司0128','发票','https://demo.doublechaintech.com/demodata/imageManager/genImage/goodthing00/400/200/grey/','AD000064',NULL,NULL,NULL,'CONFIRMED','1');

insert into original_voucher_creation_data values
	('OVC000001','财务会计','确认提交','2018-01-04','1');

insert into original_voucher_confirmation_data values
	('OVC000001','财务会计','确认通过','2018-01-24','1');

insert into original_voucher_auditing_data values
	('OVA000001','财务会计','审核通过，要都审核过了才通过哦','2017-12-24','1');

insert into accounting_document_line_data values
	('ADL000001','收到存款','AS9999','借','735258.00','AD000001','AS000001','1'),
	('ADL000002','收到存款0002','AS99990002','贷','746642.56','AD000001','AS000001','1'),
	('ADL000003','收到存款0003','AS99990003','借','790612.19','AD000002','AS000001','1'),
	('ADL000004','收到存款0004','AS99990004','贷','844544.25','AD000002','AS000001','1'),
	('ADL000005','收到存款0005','AS99990005','借','776951.31','AD000003','AS000002','1'),
	('ADL000006','收到存款0006','AS99990006','贷','925494.12','AD000003','AS000002','1'),
	('ADL000007','收到存款0007','AS99990007','借','929217.75','AD000004','AS000002','1'),
	('ADL000008','收到存款0008','AS99990008','贷','962421.75','AD000004','AS000002','1'),
	('ADL000009','收到存款0009','AS99990009','借','888243.38','AD000005','AS000003','1'),
	('ADL000010','收到存款0010','AS99990010','贷','960500.12','AD000005','AS000003','1'),
	('ADL000011','收到存款0011','AS99990011','借','972597.06','AD000006','AS000003','1'),
	('ADL000012','收到存款0012','AS99990012','贷','986388.19','AD000006','AS000003','1'),
	('ADL000013','收到存款0013','AS99990013','借','861343.38','AD000007','AS000004','1'),
	('ADL000014','收到存款0014','AS99990014','贷','785162.19','AD000007','AS000004','1'),
	('ADL000015','收到存款0015','AS99990015','借','783098.94','AD000008','AS000004','1'),
	('ADL000016','收到存款0016','AS99990016','贷','779232.19','AD000008','AS000004','1'),
	('ADL000017','收到存款0017','AS99990017','借','770675.19','AD000009','AS000005','1'),
	('ADL000018','收到存款0018','AS99990018','贷','762482.31','AD000009','AS000005','1'),
	('ADL000019','收到存款0019','AS99990019','借','885675.00','AD000010','AS000005','1'),
	('ADL000020','收到存款0020','AS99990020','贷','905063.00','AD000010','AS000005','1'),
	('ADL000021','收到存款0021','AS99990021','借','794530.69','AD000011','AS000006','1'),
	('ADL000022','收到存款0022','AS99990022','贷','820525.50','AD000011','AS000006','1'),
	('ADL000023','收到存款0023','AS99990023','借','931782.19','AD000012','AS000006','1'),
	('ADL000024','收到存款0024','AS99990024','贷','894323.56','AD000012','AS000006','1'),
	('ADL000025','收到存款0025','AS99990025','借','751850.00','AD000013','AS000007','1'),
	('ADL000026','收到存款0026','AS99990026','贷','940882.69','AD000013','AS000007','1'),
	('ADL000027','收到存款0027','AS99990027','借','940078.19','AD000014','AS000007','1'),
	('ADL000028','收到存款0028','AS99990028','贷','867798.38','AD000014','AS000007','1'),
	('ADL000029','收到存款0029','AS99990029','借','839115.06','AD000015','AS000008','1'),
	('ADL000030','收到存款0030','AS99990030','贷','813098.88','AD000015','AS000008','1'),
	('ADL000031','收到存款0031','AS99990031','借','924261.56','AD000016','AS000008','1'),
	('ADL000032','收到存款0032','AS99990032','贷','779790.06','AD000016','AS000008','1'),
	('ADL000033','收到存款0033','AS99990033','借','830486.75','AD000017','AS000009','1'),
	('ADL000034','收到存款0034','AS99990034','贷','803007.94','AD000017','AS000009','1'),
	('ADL000035','收到存款0035','AS99990035','借','863215.38','AD000018','AS000009','1'),
	('ADL000036','收到存款0036','AS99990036','贷','915430.19','AD000018','AS000009','1'),
	('ADL000037','收到存款0037','AS99990037','借','862290.06','AD000019','AS000010','1'),
	('ADL000038','收到存款0038','AS99990038','贷','841960.00','AD000019','AS000010','1'),
	('ADL000039','收到存款0039','AS99990039','借','847110.81','AD000020','AS000010','1'),
	('ADL000040','收到存款0040','AS99990040','贷','692913.19','AD000020','AS000010','1'),
	('ADL000041','收到存款0041','AS99990041','借','902119.94','AD000021','AS000011','1'),
	('ADL000042','收到存款0042','AS99990042','贷','979270.50','AD000021','AS000011','1'),
	('ADL000043','收到存款0043','AS99990043','借','734407.56','AD000022','AS000011','1'),
	('ADL000044','收到存款0044','AS99990044','贷','842366.38','AD000022','AS000011','1'),
	('ADL000045','收到存款0045','AS99990045','借','952051.62','AD000023','AS000012','1'),
	('ADL000046','收到存款0046','AS99990046','贷','742137.12','AD000023','AS000012','1'),
	('ADL000047','收到存款0047','AS99990047','借','965713.06','AD000024','AS000012','1'),
	('ADL000048','收到存款0048','AS99990048','贷','753732.38','AD000024','AS000012','1'),
	('ADL000049','收到存款0049','AS99990049','借','963446.50','AD000025','AS000013','1'),
	('ADL000050','收到存款0050','AS99990050','贷','822219.81','AD000025','AS000013','1'),
	('ADL000051','收到存款0051','AS99990051','借','915384.56','AD000026','AS000013','1'),
	('ADL000052','收到存款0052','AS99990052','贷','729152.44','AD000026','AS000013','1'),
	('ADL000053','收到存款0053','AS99990053','借','810649.06','AD000027','AS000014','1'),
	('ADL000054','收到存款0054','AS99990054','贷','875697.56','AD000027','AS000014','1'),
	('ADL000055','收到存款0055','AS99990055','借','872694.88','AD000028','AS000014','1'),
	('ADL000056','收到存款0056','AS99990056','贷','978014.81','AD000028','AS000014','1'),
	('ADL000057','收到存款0057','AS99990057','借','844452.31','AD000029','AS000015','1'),
	('ADL000058','收到存款0058','AS99990058','贷','850108.38','AD000029','AS000015','1'),
	('ADL000059','收到存款0059','AS99990059','借','745561.56','AD000030','AS000015','1'),
	('ADL000060','收到存款0060','AS99990060','贷','737519.44','AD000030','AS000015','1'),
	('ADL000061','收到存款0061','AS99990061','借','743131.81','AD000031','AS000016','1'),
	('ADL000062','收到存款0062','AS99990062','贷','978076.44','AD000031','AS000016','1'),
	('ADL000063','收到存款0063','AS99990063','借','942875.50','AD000032','AS000016','1'),
	('ADL000064','收到存款0064','AS99990064','贷','938414.19','AD000032','AS000016','1'),
	('ADL000065','收到存款0065','AS99990065','借','765389.44','AD000033','AS000017','1'),
	('ADL000066','收到存款0066','AS99990066','贷','728931.19','AD000033','AS000017','1'),
	('ADL000067','收到存款0067','AS99990067','借','841480.62','AD000034','AS000017','1'),
	('ADL000068','收到存款0068','AS99990068','贷','880782.12','AD000034','AS000017','1'),
	('ADL000069','收到存款0069','AS99990069','借','753156.38','AD000035','AS000018','1'),
	('ADL000070','收到存款0070','AS99990070','贷','889718.25','AD000035','AS000018','1'),
	('ADL000071','收到存款0071','AS99990071','借','807917.69','AD000036','AS000018','1'),
	('ADL000072','收到存款0072','AS99990072','贷','916548.06','AD000036','AS000018','1'),
	('ADL000073','收到存款0073','AS99990073','借','974107.50','AD000037','AS000019','1'),
	('ADL000074','收到存款0074','AS99990074','贷','720259.06','AD000037','AS000019','1'),
	('ADL000075','收到存款0075','AS99990075','借','709129.19','AD000038','AS000019','1'),
	('ADL000076','收到存款0076','AS99990076','贷','814794.00','AD000038','AS000019','1'),
	('ADL000077','收到存款0077','AS99990077','借','712278.50','AD000039','AS000020','1'),
	('ADL000078','收到存款0078','AS99990078','贷','974155.69','AD000039','AS000020','1'),
	('ADL000079','收到存款0079','AS99990079','借','765744.81','AD000040','AS000020','1'),
	('ADL000080','收到存款0080','AS99990080','贷','696508.44','AD000040','AS000020','1'),
	('ADL000081','收到存款0081','AS99990081','借','722224.81','AD000041','AS000021','1'),
	('ADL000082','收到存款0082','AS99990082','贷','798034.56','AD000041','AS000021','1'),
	('ADL000083','收到存款0083','AS99990083','借','811229.19','AD000042','AS000021','1'),
	('ADL000084','收到存款0084','AS99990084','贷','807433.81','AD000042','AS000021','1'),
	('ADL000085','收到存款0085','AS99990085','借','933910.00','AD000043','AS000022','1'),
	('ADL000086','收到存款0086','AS99990086','贷','839676.00','AD000043','AS000022','1'),
	('ADL000087','收到存款0087','AS99990087','借','986279.44','AD000044','AS000022','1'),
	('ADL000088','收到存款0088','AS99990088','贷','978287.94','AD000044','AS000022','1'),
	('ADL000089','收到存款0089','AS99990089','借','918781.06','AD000045','AS000023','1'),
	('ADL000090','收到存款0090','AS99990090','贷','762205.38','AD000045','AS000023','1'),
	('ADL000091','收到存款0091','AS99990091','借','946576.44','AD000046','AS000023','1'),
	('ADL000092','收到存款0092','AS99990092','贷','816076.69','AD000046','AS000023','1'),
	('ADL000093','收到存款0093','AS99990093','借','925243.31','AD000047','AS000024','1'),
	('ADL000094','收到存款0094','AS99990094','贷','842313.25','AD000047','AS000024','1'),
	('ADL000095','收到存款0095','AS99990095','借','719338.25','AD000048','AS000024','1'),
	('ADL000096','收到存款0096','AS99990096','贷','742621.00','AD000048','AS000024','1'),
	('ADL000097','收到存款0097','AS99990097','借','779120.44','AD000049','AS000025','1'),
	('ADL000098','收到存款0098','AS99990098','贷','745286.00','AD000049','AS000025','1'),
	('ADL000099','收到存款0099','AS99990099','借','967771.12','AD000050','AS000025','1'),
	('ADL000100','收到存款0100','AS99990100','贷','759825.69','AD000050','AS000025','1'),
	('ADL000101','收到存款0101','AS99990101','借','841244.81','AD000051','AS000026','1'),
	('ADL000102','收到存款0102','AS99990102','贷','981348.88','AD000051','AS000026','1'),
	('ADL000103','收到存款0103','AS99990103','借','823282.75','AD000052','AS000026','1'),
	('ADL000104','收到存款0104','AS99990104','贷','738644.50','AD000052','AS000026','1'),
	('ADL000105','收到存款0105','AS99990105','借','967952.12','AD000053','AS000027','1'),
	('ADL000106','收到存款0106','AS99990106','贷','840277.94','AD000053','AS000027','1'),
	('ADL000107','收到存款0107','AS99990107','借','887341.50','AD000054','AS000027','1'),
	('ADL000108','收到存款0108','AS99990108','贷','844754.44','AD000054','AS000027','1'),
	('ADL000109','收到存款0109','AS99990109','借','891743.75','AD000055','AS000028','1'),
	('ADL000110','收到存款0110','AS99990110','贷','923211.69','AD000055','AS000028','1'),
	('ADL000111','收到存款0111','AS99990111','借','692571.06','AD000056','AS000028','1'),
	('ADL000112','收到存款0112','AS99990112','贷','936217.75','AD000056','AS000028','1'),
	('ADL000113','收到存款0113','AS99990113','借','735323.88','AD000057','AS000029','1'),
	('ADL000114','收到存款0114','AS99990114','贷','878099.31','AD000057','AS000029','1'),
	('ADL000115','收到存款0115','AS99990115','借','908940.69','AD000058','AS000029','1'),
	('ADL000116','收到存款0116','AS99990116','贷','726231.50','AD000058','AS000029','1'),
	('ADL000117','收到存款0117','AS99990117','借','703441.62','AD000059','AS000030','1'),
	('ADL000118','收到存款0118','AS99990118','贷','957883.88','AD000059','AS000030','1'),
	('ADL000119','收到存款0119','AS99990119','借','766377.25','AD000060','AS000030','1'),
	('ADL000120','收到存款0120','AS99990120','贷','778982.12','AD000060','AS000030','1'),
	('ADL000121','收到存款0121','AS99990121','借','802608.00','AD000061','AS000031','1'),
	('ADL000122','收到存款0122','AS99990122','贷','715016.31','AD000061','AS000031','1'),
	('ADL000123','收到存款0123','AS99990123','借','955895.88','AD000062','AS000031','1'),
	('ADL000124','收到存款0124','AS99990124','贷','966021.56','AD000062','AS000031','1'),
	('ADL000125','收到存款0125','AS99990125','借','861221.19','AD000063','AS000032','1'),
	('ADL000126','收到存款0126','AS99990126','贷','947087.62','AD000063','AS000032','1'),
	('ADL000127','收到存款0127','AS99990127','借','954577.69','AD000064','AS000032','1'),
	('ADL000128','收到存款0128','AS99990128','贷','910952.88','AD000064','AS000032','1');

insert into level_one_department_data values
	('LOD000001','RSCC000001','供应链部','主要执行集团信息系统建设，维护，规划','刘强','2018-02-02','1'),
	('LOD000002','RSCC000001','采购部','主要执行集团信息系统建设，维护，规划0002','王德宏','2019-03-13','1'),
	('LOD000003','RSCC000002','管理部','主要执行集团信息系统建设，维护，规划0003','刘强','2016-08-23','1'),
	('LOD000004','RSCC000002','财务部','主要执行集团信息系统建设，维护，规划0004','王德宏','2016-09-17','1'),
	('LOD000005','RSCC000003','信息技术部','主要执行集团信息系统建设，维护，规划0005','刘强','2018-10-02','1'),
	('LOD000006','RSCC000003','法务部','主要执行集团信息系统建设，维护，规划0006','王德宏','2018-08-24','1'),
	('LOD000007','RSCC000004','市场部','主要执行集团信息系统建设，维护，规划0007','刘强','2016-09-11','1'),
	('LOD000008','RSCC000004','人力资源部','主要执行集团信息系统建设，维护，规划0008','王德宏','2018-03-17','1');

insert into level_two_department_data values
	('LTD000001','LOD000001','信息系统部大数据部门','主要执行集团信息系统建设，维护，规划','2019-03-30','1'),
	('LTD000002','LOD000003','信息系统部大数据部门0002','主要执行集团信息系统建设，维护，规划0002','2017-04-07','1'),
	('LTD000003','LOD000005','信息系统部大数据部门0003','主要执行集团信息系统建设，维护，规划0003','2017-11-28','1'),
	('LTD000004','LOD000007','信息系统部大数据部门0004','主要执行集团信息系统建设，维护，规划0004','2017-10-17','1');

insert into level_three_department_data values
	('LTD000001','LTD000001','信息系统部大数据清洗组','主要执行集团信息系统建设，维护，规划','2018-02-22','1'),
	('LTD000002','LTD000001','信息系统部大数据运算组','主要执行集团信息系统建设，维护，规划0002','2019-04-14','1'),
	('LTD000003','LTD000002','信息系统部大数据解决方案组','主要执行集团信息系统建设，维护，规划0003','2018-09-23','1'),
	('LTD000004','LTD000002','信息系统部大数据清洗组','主要执行集团信息系统建设，维护，规划0004','2019-03-19','1'),
	('LTD000005','LTD000003','信息系统部大数据运算组','主要执行集团信息系统建设，维护，规划0005','2017-05-11','1'),
	('LTD000006','LTD000003','信息系统部大数据解决方案组','主要执行集团信息系统建设，维护，规划0006','2017-04-02','1'),
	('LTD000007','LTD000004','信息系统部大数据清洗组','主要执行集团信息系统建设，维护，规划0007','2018-12-11','1'),
	('LTD000008','LTD000004','信息系统部大数据运算组','主要执行集团信息系统建设，维护，规划0008','2018-10-29','1');

insert into skill_type_data values
	('ST000001','S0000','RSCC000001','JAVA编程','1'),
	('ST000002','S00000002','RSCC000003','大数据','1');

insert into responsibility_type_data values
	('RT000001','S0000','RSCC000001','合规管理','负责集团及其他分公司信息系统有效运作，并使集团在技术上领先','1'),
	('RT000002','S00000002','RSCC000003','财务管理','负责集团及其他分公司信息系统有效运作，并使集团在技术上领先0002','1');

insert into termination_reason_data values
	('TR000001','ETR0000','RSCC000001','业务发展，公司转型','1'),
	('TR000002','ETR00000002','RSCC000003','战略调整','1');

insert into termination_type_data values
	('TT000001','ETT0000','RSCC000001','合同解除','这个终止原因的描述是这样的.................................................','1'),
	('TT000002','ETT00000002','RSCC000003','辞职','这个终止原因的描述是这样的.................................................0002','1');

insert into occupation_type_data values
	('OT000001','OT0000','RSCC000001','需求分析员','故事还得从遥远的古代开始.................................................','1'),
	('OT000002','OT00000002','RSCC000003','软件工程师','故事还得从遥远的古代开始.................................................0002','1');

insert into leave_type_data values
	('LT000001','LT0000','RSCC000001','带薪年假','故事还得从遥远的古代开始.................................................','1'),
	('LT000002','LT00000002','RSCC000003','病假','故事还得从遥远的古代开始.................................................0002','1');

insert into salary_grade_data values
	('SG000001','SG0000','RSCC000001','一级薪资','故事还得从遥远的古代开始.................................................','1'),
	('SG000002','SG00000002','RSCC000003','二级薪资','故事还得从遥远的古代开始.................................................0002','1');

insert into interview_type_data values
	('IT000001','INTRVW00','RSCC000001','特别情况面试','故事还得从遥远的古代开始.................................................','1'),
	('IT000002','INTRVW000002','RSCC000003','离职面试','故事还得从遥远的古代开始.................................................0002','1');

insert into training_course_type_data values
	('TCT000001','TC00','RSCC000001','入职培训','培训是提升个人和企业竞争力的法宝','1'),
	('TCT000002','TC000002','RSCC000003','售前培训','培训是提升个人和企业竞争力的法宝0002','1');

insert into public_holiday_data values
	('PH000001','PH00','RSCC000001','元旦节','节日快乐，万事如意！','1'),
	('PH000002','PH000002','RSCC000003','春节','节日快乐，万事如意！0002','1');

insert into termination_data values
	('T000001','TR000001','TT000001','员工离职','1'),
	('T000002','TR000001','TT000001','员工离职0002','1'),
	('T000003','TR000002','TT000002','员工离职0003','1'),
	('T000004','TR000002','TT000002','员工离职0004','1');

insert into view_data values
	('V000001','面试官','小伙子不错，值得培养','2017-08-11','1');

insert into employee_data values
	('E000001','RSCC000001','程序员','LTD000001','张','文强','share@163.com','北京','学院路234号','18677778888','OT000001','RT000001','SG000001','6226 7788 9908 ',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2019-06-21 19:48:22','JOB_APPLIED','1'),
	('E000002','RSCC000001','程序员0002','LTD000001','王','大伟','2@qq.com','天津','学院路234号0002','13900000002','OT000001','RT000001','SG000001','6226 7788 9908 0002',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2019-07-03 13:40:59','PASSED_WITH_PROFESSION','1'),
	('E000003','RSCC000001','程序员0003','LTD000002','李','字章','3@qq.com','成都','学院路234号0003','13900000003','OT000001','RT000001','SG000001','6226 7788 9908 0003',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2019-06-28 14:56:31','PASSED_BY_HR','1'),
	('E000004','RSCC000001','程序员0004','LTD000002','贺','文强','4@qq.com','上海','学院路234号0004','13900000004','OT000001','RT000001','SG000001','6226 7788 9908 0004',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2019-06-30 18:51:49','OFFER_APPROVED','1'),
	('E000005','RSCC000002','程序员0005','LTD000003','张','大伟','5@qq.com','深圳','学院路234号0005','13900000005','OT000001','RT000001','SG000001','6226 7788 9908 0005',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2019-06-22 07:07:05','OFFER_ACCEPTED','1'),
	('E000006','RSCC000002','程序员0006','LTD000003','王','字章','6@qq.com','广州','学院路234号0006','13900000006','OT000001','RT000001','SG000001','6226 7788 9908 0006',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2019-06-19 20:57:41','EMPLOYEE_BOARDED','1'),
	('E000007','RSCC000002','程序员0007','LTD000004','李','文强','7@qq.com','西安','学院路234号0007','13900000007','OT000001','RT000001','SG000001','6226 7788 9908 0007',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2019-06-20 23:37:51','TERMINATED','1'),
	('E000008','RSCC000002','程序员0008','LTD000004','贺','大伟','8@qq.com','北京','学院路234号0008','13900000008','OT000001','RT000001','SG000001','6226 7788 9908 0008',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2019-06-15 13:42:01','JOB_APPLIED','1'),
	('E000009','RSCC000003','程序员0009','LTD000005','张','字章','9@qq.com','天津','学院路234号0009','13900000009','OT000002','RT000002','SG000002','6226 7788 9908 0009',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2019-06-14 16:55:18','PASSED_WITH_PROFESSION','1'),
	('E000010','RSCC000003','程序员0010','LTD000005','王','文强','10@qq.com','成都','学院路234号0010','13900000010','OT000002','RT000002','SG000002','6226 7788 9908 0010',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2019-06-16 19:38:13','PASSED_BY_HR','1'),
	('E000011','RSCC000003','程序员0011','LTD000006','李','大伟','11@qq.com','上海','学院路234号0011','13900000011','OT000002','RT000002','SG000002','6226 7788 9908 0011',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2019-06-29 01:27:15','OFFER_APPROVED','1'),
	('E000012','RSCC000003','程序员0012','LTD000006','贺','字章','12@qq.com','深圳','学院路234号0012','13900000012','OT000002','RT000002','SG000002','6226 7788 9908 0012',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2019-06-18 10:06:08','OFFER_ACCEPTED','1'),
	('E000013','RSCC000004','程序员0013','LTD000007','张','文强','13@qq.com','广州','学院路234号0013','13900000013','OT000002','RT000002','SG000002','6226 7788 9908 0013',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2019-06-27 10:15:58','EMPLOYEE_BOARDED','1'),
	('E000014','RSCC000004','程序员0014','LTD000007','王','大伟','14@qq.com','西安','学院路234号0014','13900000014','OT000002','RT000002','SG000002','6226 7788 9908 0014',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2019-06-24 04:19:30','TERMINATED','1'),
	('E000015','RSCC000004','程序员0015','LTD000008','李','字章','15@qq.com','北京','学院路234号0015','13900000015','OT000002','RT000002','SG000002','6226 7788 9908 0015',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2019-06-25 23:51:21','JOB_APPLIED','1'),
	('E000016','RSCC000004','程序员0016','LTD000008','贺','文强','16@qq.com','天津','学院路234号0016','13900000016','OT000002','RT000002','SG000002','6226 7788 9908 0016',NULL,NULL,NULL,NULL,NULL,NULL,NULL,'2019-06-24 16:54:06','PASSED_WITH_PROFESSION','1');

insert into job_application_data values
	('JA000001','2019-02-23','申请者本人','我觉得我符合职位要求，请给我一个机会为公司发展做出贡献，谢谢！','1');

insert into profession_interview_data values
	('PI000001','技术部','2019-04-13','能力各方面表现不错，进入下一轮','1');

insert into hr_interview_data values
	('HI000001','人力资源部','2016-09-20','软技能，责任感，气质不错啊','1');

insert into offer_approval_data values
	('OA000001','总经理','2018-11-03','该员工发展潜力不错，','1');

insert into offer_acceptance_data values
	('OA000001','申请者','2017-04-20','谢谢，我一个月内上班','1');

insert into employee_boarding_data values
	('EB000001','人力资源部','2017-01-06','欢迎加入植物医生大家庭','1');

insert into instructor_data values
	('I000001','高级讲师','张','文强','18699990000','instructor@gmail.com','RSCC000001','这是一个长长长长长长长长的介绍','2019-07-01 08:13:30','1'),
	('I000002','高级讲师0002','王','大伟','13900000002','2@qq.com','RSCC000003','这是一个长长长长长长长长的介绍0002','2019-06-21 14:57:14','1');

insert into company_training_data values
	('CT000001','入职培训','RSCC000001','I000001','TCT000001','2019-06-30','3','2019-06-24 01:46:27','1'),
	('CT000002','入职培训0002','RSCC000002','I000001','TCT000001','2017-04-30','3','2019-06-14 12:36:26','1'),
	('CT000003','入职培训0003','RSCC000003','I000002','TCT000002','2017-04-15','3','2019-06-20 20:16:15','1'),
	('CT000004','入职培训0004','RSCC000004','I000002','TCT000002','2016-08-06','3','2019-06-18 19:20:15','1');

insert into scoring_data values
	('S000001','王志文','82','这个题做的真不错啊','1');

insert into employee_company_training_data values
	('ECT000001','E000001','CT000001',NULL,'SCORED','1'),
	('ECT000002','E000001','CT000001',NULL,'SCORED0002','1'),
	('ECT000003','E000002','CT000001',NULL,'SCORED0003','1'),
	('ECT000004','E000002','CT000001',NULL,'SCORED0004','1'),
	('ECT000005','E000003','CT000001',NULL,'SCORED0005','1'),
	('ECT000006','E000003','CT000001',NULL,'SCORED0006','1'),
	('ECT000007','E000004','CT000001',NULL,'SCORED0007','1'),
	('ECT000008','E000004','CT000001',NULL,'SCORED0008','1'),
	('ECT000009','E000005','CT000002',NULL,'SCORED0009','1'),
	('ECT000010','E000005','CT000002',NULL,'SCORED0010','1'),
	('ECT000011','E000006','CT000002',NULL,'SCORED0011','1'),
	('ECT000012','E000006','CT000002',NULL,'SCORED0012','1'),
	('ECT000013','E000007','CT000002',NULL,'SCORED0013','1'),
	('ECT000014','E000007','CT000002',NULL,'SCORED0014','1'),
	('ECT000015','E000008','CT000002',NULL,'SCORED0015','1'),
	('ECT000016','E000008','CT000002',NULL,'SCORED0016','1'),
	('ECT000017','E000009','CT000003',NULL,'SCORED0017','1'),
	('ECT000018','E000009','CT000003',NULL,'SCORED0018','1'),
	('ECT000019','E000010','CT000003',NULL,'SCORED0019','1'),
	('ECT000020','E000010','CT000003',NULL,'SCORED0020','1'),
	('ECT000021','E000011','CT000003',NULL,'SCORED0021','1'),
	('ECT000022','E000011','CT000003',NULL,'SCORED0022','1'),
	('ECT000023','E000012','CT000003',NULL,'SCORED0023','1'),
	('ECT000024','E000012','CT000003',NULL,'SCORED0024','1'),
	('ECT000025','E000013','CT000004',NULL,'SCORED0025','1'),
	('ECT000026','E000013','CT000004',NULL,'SCORED0026','1'),
	('ECT000027','E000014','CT000004',NULL,'SCORED0027','1'),
	('ECT000028','E000014','CT000004',NULL,'SCORED0028','1'),
	('ECT000029','E000015','CT000004',NULL,'SCORED0029','1'),
	('ECT000030','E000015','CT000004',NULL,'SCORED0030','1'),
	('ECT000031','E000016','CT000004',NULL,'SCORED0031','1'),
	('ECT000032','E000016','CT000004',NULL,'SCORED0032','1');

insert into employee_skill_data values
	('ES000001','E000001','ST000001','高手高手高高手','1'),
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
	('EP000001','E000001','绩效大大的不错','1'),
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
	('EWE000001','E000001','2017-03-23','2017-10-30','丝芙兰化妆品公司','在此期间取得非常好的绩效，赢得了客户的信赖','1'),
	('EWE000002','E000001','2019-01-21','2016-11-05','丝芙兰化妆品公司0002','在此期间取得非常好的绩效，赢得了客户的信赖0002','1'),
	('EWE000003','E000002','2017-06-13','2018-05-11','丝芙兰化妆品公司0003','在此期间取得非常好的绩效，赢得了客户的信赖0003','1'),
	('EWE000004','E000002','2016-12-09','2016-10-22','丝芙兰化妆品公司0004','在此期间取得非常好的绩效，赢得了客户的信赖0004','1'),
	('EWE000005','E000003','2018-05-04','2019-03-05','丝芙兰化妆品公司0005','在此期间取得非常好的绩效，赢得了客户的信赖0005','1'),
	('EWE000006','E000003','2017-03-29','2016-10-19','丝芙兰化妆品公司0006','在此期间取得非常好的绩效，赢得了客户的信赖0006','1'),
	('EWE000007','E000004','2018-02-16','2017-05-18','丝芙兰化妆品公司0007','在此期间取得非常好的绩效，赢得了客户的信赖0007','1'),
	('EWE000008','E000004','2017-06-14','2018-04-07','丝芙兰化妆品公司0008','在此期间取得非常好的绩效，赢得了客户的信赖0008','1'),
	('EWE000009','E000005','2016-09-08','2019-01-05','丝芙兰化妆品公司0009','在此期间取得非常好的绩效，赢得了客户的信赖0009','1'),
	('EWE000010','E000005','2017-10-20','2017-06-25','丝芙兰化妆品公司0010','在此期间取得非常好的绩效，赢得了客户的信赖0010','1'),
	('EWE000011','E000006','2019-03-29','2018-08-13','丝芙兰化妆品公司0011','在此期间取得非常好的绩效，赢得了客户的信赖0011','1'),
	('EWE000012','E000006','2016-08-11','2018-12-26','丝芙兰化妆品公司0012','在此期间取得非常好的绩效，赢得了客户的信赖0012','1'),
	('EWE000013','E000007','2016-12-17','2018-08-31','丝芙兰化妆品公司0013','在此期间取得非常好的绩效，赢得了客户的信赖0013','1'),
	('EWE000014','E000007','2018-12-31','2017-10-29','丝芙兰化妆品公司0014','在此期间取得非常好的绩效，赢得了客户的信赖0014','1'),
	('EWE000015','E000008','2016-09-02','2019-01-05','丝芙兰化妆品公司0015','在此期间取得非常好的绩效，赢得了客户的信赖0015','1'),
	('EWE000016','E000008','2018-05-02','2019-02-04','丝芙兰化妆品公司0016','在此期间取得非常好的绩效，赢得了客户的信赖0016','1'),
	('EWE000017','E000009','2018-01-09','2018-04-21','丝芙兰化妆品公司0017','在此期间取得非常好的绩效，赢得了客户的信赖0017','1'),
	('EWE000018','E000009','2016-11-24','2017-12-21','丝芙兰化妆品公司0018','在此期间取得非常好的绩效，赢得了客户的信赖0018','1'),
	('EWE000019','E000010','2018-05-02','2018-10-21','丝芙兰化妆品公司0019','在此期间取得非常好的绩效，赢得了客户的信赖0019','1'),
	('EWE000020','E000010','2016-07-17','2019-03-21','丝芙兰化妆品公司0020','在此期间取得非常好的绩效，赢得了客户的信赖0020','1'),
	('EWE000021','E000011','2017-07-01','2016-10-14','丝芙兰化妆品公司0021','在此期间取得非常好的绩效，赢得了客户的信赖0021','1'),
	('EWE000022','E000011','2017-03-03','2016-07-21','丝芙兰化妆品公司0022','在此期间取得非常好的绩效，赢得了客户的信赖0022','1'),
	('EWE000023','E000012','2018-07-18','2016-09-08','丝芙兰化妆品公司0023','在此期间取得非常好的绩效，赢得了客户的信赖0023','1'),
	('EWE000024','E000012','2018-06-29','2018-09-20','丝芙兰化妆品公司0024','在此期间取得非常好的绩效，赢得了客户的信赖0024','1'),
	('EWE000025','E000013','2016-09-14','2018-08-17','丝芙兰化妆品公司0025','在此期间取得非常好的绩效，赢得了客户的信赖0025','1'),
	('EWE000026','E000013','2016-10-15','2019-04-10','丝芙兰化妆品公司0026','在此期间取得非常好的绩效，赢得了客户的信赖0026','1'),
	('EWE000027','E000014','2017-03-14','2016-09-10','丝芙兰化妆品公司0027','在此期间取得非常好的绩效，赢得了客户的信赖0027','1'),
	('EWE000028','E000014','2018-01-09','2017-02-09','丝芙兰化妆品公司0028','在此期间取得非常好的绩效，赢得了客户的信赖0028','1'),
	('EWE000029','E000015','2017-07-28','2018-06-04','丝芙兰化妆品公司0029','在此期间取得非常好的绩效，赢得了客户的信赖0029','1'),
	('EWE000030','E000015','2019-05-16','2018-09-28','丝芙兰化妆品公司0030','在此期间取得非常好的绩效，赢得了客户的信赖0030','1'),
	('EWE000031','E000016','2018-09-22','2017-06-05','丝芙兰化妆品公司0031','在此期间取得非常好的绩效，赢得了客户的信赖0031','1'),
	('EWE000032','E000016','2018-11-08','2017-12-25','丝芙兰化妆品公司0032','在此期间取得非常好的绩效，赢得了客户的信赖0032','1');

insert into employee_leave_data values
	('EL000001','E000001','LT000001','7','请年假，出去耍！！！！','1'),
	('EL000002','E000001','LT000001','7','请年假，出去耍！！！！0002','1'),
	('EL000003','E000002','LT000001','8','请年假，出去耍！！！！0003','1'),
	('EL000004','E000002','LT000001','8','请年假，出去耍！！！！0004','1'),
	('EL000005','E000003','LT000001','7','请年假，出去耍！！！！0005','1'),
	('EL000006','E000003','LT000001','7','请年假，出去耍！！！！0006','1'),
	('EL000007','E000004','LT000001','8','请年假，出去耍！！！！0007','1'),
	('EL000008','E000004','LT000001','8','请年假，出去耍！！！！0008','1'),
	('EL000009','E000005','LT000001','6','请年假，出去耍！！！！0009','1'),
	('EL000010','E000005','LT000001','6','请年假，出去耍！！！！0010','1'),
	('EL000011','E000006','LT000001','6','请年假，出去耍！！！！0011','1'),
	('EL000012','E000006','LT000001','7','请年假，出去耍！！！！0012','1'),
	('EL000013','E000007','LT000001','7','请年假，出去耍！！！！0013','1'),
	('EL000014','E000007','LT000001','8','请年假，出去耍！！！！0014','1'),
	('EL000015','E000008','LT000001','7','请年假，出去耍！！！！0015','1'),
	('EL000016','E000008','LT000001','7','请年假，出去耍！！！！0016','1'),
	('EL000017','E000009','LT000002','8','请年假，出去耍！！！！0017','1'),
	('EL000018','E000009','LT000002','8','请年假，出去耍！！！！0018','1'),
	('EL000019','E000010','LT000002','7','请年假，出去耍！！！！0019','1'),
	('EL000020','E000010','LT000002','8','请年假，出去耍！！！！0020','1'),
	('EL000021','E000011','LT000002','7','请年假，出去耍！！！！0021','1'),
	('EL000022','E000011','LT000002','8','请年假，出去耍！！！！0022','1'),
	('EL000023','E000012','LT000002','8','请年假，出去耍！！！！0023','1'),
	('EL000024','E000012','LT000002','7','请年假，出去耍！！！！0024','1'),
	('EL000025','E000013','LT000002','7','请年假，出去耍！！！！0025','1'),
	('EL000026','E000013','LT000002','7','请年假，出去耍！！！！0026','1'),
	('EL000027','E000014','LT000002','6','请年假，出去耍！！！！0027','1'),
	('EL000028','E000014','LT000002','7','请年假，出去耍！！！！0028','1'),
	('EL000029','E000015','LT000002','7','请年假，出去耍！！！！0029','1'),
	('EL000030','E000015','LT000002','7','请年假，出去耍！！！！0030','1'),
	('EL000031','E000016','LT000002','7','请年假，出去耍！！！！0031','1'),
	('EL000032','E000016','LT000002','7','请年假，出去耍！！！！0032','1');

insert into employee_interview_data values
	('EI000001','E000001','IT000001','结果不错，面试通过！','1'),
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
	('EA000001','E000001','2018-02-01','2018-09-19','6','今天状态不错啊','1'),
	('EA000002','E000001','2018-06-16','2017-01-31','7','今天状态不错啊0002','1'),
	('EA000003','E000002','2016-08-09','2017-03-27','7','今天状态不错啊0003','1'),
	('EA000004','E000002','2016-08-22','2017-10-07','7','今天状态不错啊0004','1'),
	('EA000005','E000003','2019-04-27','2018-07-29','6','今天状态不错啊0005','1'),
	('EA000006','E000003','2019-01-27','2019-02-10','7','今天状态不错啊0006','1'),
	('EA000007','E000004','2016-09-17','2018-05-08','8','今天状态不错啊0007','1'),
	('EA000008','E000004','2018-07-06','2017-09-14','8','今天状态不错啊0008','1'),
	('EA000009','E000005','2018-08-08','2018-01-04','8','今天状态不错啊0009','1'),
	('EA000010','E000005','2017-10-30','2016-12-27','8','今天状态不错啊0010','1'),
	('EA000011','E000006','2017-01-27','2018-10-17','8','今天状态不错啊0011','1'),
	('EA000012','E000006','2019-03-07','2016-12-11','7','今天状态不错啊0012','1'),
	('EA000013','E000007','2016-09-30','2016-08-19','6','今天状态不错啊0013','1'),
	('EA000014','E000007','2016-07-07','2017-07-22','7','今天状态不错啊0014','1'),
	('EA000015','E000008','2017-04-16','2017-12-07','8','今天状态不错啊0015','1'),
	('EA000016','E000008','2019-05-22','2017-07-08','7','今天状态不错啊0016','1'),
	('EA000017','E000009','2018-07-31','2017-08-18','6','今天状态不错啊0017','1'),
	('EA000018','E000009','2017-06-04','2016-10-28','6','今天状态不错啊0018','1'),
	('EA000019','E000010','2017-07-16','2019-05-04','7','今天状态不错啊0019','1'),
	('EA000020','E000010','2016-08-17','2016-07-04','8','今天状态不错啊0020','1'),
	('EA000021','E000011','2016-08-02','2019-02-19','8','今天状态不错啊0021','1'),
	('EA000022','E000011','2017-10-26','2017-09-15','8','今天状态不错啊0022','1'),
	('EA000023','E000012','2018-04-07','2017-04-09','7','今天状态不错啊0023','1'),
	('EA000024','E000012','2017-11-06','2017-04-15','8','今天状态不错啊0024','1'),
	('EA000025','E000013','2018-01-01','2016-10-22','6','今天状态不错啊0025','1'),
	('EA000026','E000013','2019-07-01','2019-02-06','7','今天状态不错啊0026','1'),
	('EA000027','E000014','2018-12-24','2019-01-21','7','今天状态不错啊0027','1'),
	('EA000028','E000014','2017-03-29','2018-03-19','8','今天状态不错啊0028','1'),
	('EA000029','E000015','2017-02-04','2017-01-13','8','今天状态不错啊0029','1'),
	('EA000030','E000015','2018-12-05','2018-11-01','7','今天状态不错啊0030','1'),
	('EA000031','E000016','2018-01-10','2017-01-18','8','今天状态不错啊0031','1'),
	('EA000032','E000016','2017-03-29','2019-02-01','7','今天状态不错啊0032','1');

insert into employee_qualifier_data values
	('EQ000001','E000001','2019-03-14','认证药剂师','高级','考试成绩当年第一名','1'),
	('EQ000002','E000001','2017-07-20','认证架构师','中级','考试成绩当年第一名0002','1'),
	('EQ000003','E000002','2019-02-20','认证会计师','初级','考试成绩当年第一名0003','1'),
	('EQ000004','E000002','2016-10-27','认证经济师','高级','考试成绩当年第一名0004','1'),
	('EQ000005','E000003','2018-03-29','OCP','中级','考试成绩当年第一名0005','1'),
	('EQ000006','E000003','2017-01-29','CCNA','初级','考试成绩当年第一名0006','1'),
	('EQ000007','E000004','2019-05-16','CCNP','高级','考试成绩当年第一名0007','1'),
	('EQ000008','E000004','2018-02-25','认证药剂师','中级','考试成绩当年第一名0008','1'),
	('EQ000009','E000005','2018-03-27','认证架构师','初级','考试成绩当年第一名0009','1'),
	('EQ000010','E000005','2018-11-23','认证会计师','高级','考试成绩当年第一名0010','1'),
	('EQ000011','E000006','2017-10-22','认证经济师','中级','考试成绩当年第一名0011','1'),
	('EQ000012','E000006','2019-03-11','OCP','初级','考试成绩当年第一名0012','1'),
	('EQ000013','E000007','2018-04-29','CCNA','高级','考试成绩当年第一名0013','1'),
	('EQ000014','E000007','2017-06-05','CCNP','中级','考试成绩当年第一名0014','1'),
	('EQ000015','E000008','2017-08-12','认证药剂师','初级','考试成绩当年第一名0015','1'),
	('EQ000016','E000008','2018-04-25','认证架构师','高级','考试成绩当年第一名0016','1'),
	('EQ000017','E000009','2017-02-04','认证会计师','中级','考试成绩当年第一名0017','1'),
	('EQ000018','E000009','2018-11-08','认证经济师','初级','考试成绩当年第一名0018','1'),
	('EQ000019','E000010','2017-11-07','OCP','高级','考试成绩当年第一名0019','1'),
	('EQ000020','E000010','2018-12-23','CCNA','中级','考试成绩当年第一名0020','1'),
	('EQ000021','E000011','2016-08-03','CCNP','初级','考试成绩当年第一名0021','1'),
	('EQ000022','E000011','2017-09-15','认证药剂师','高级','考试成绩当年第一名0022','1'),
	('EQ000023','E000012','2019-03-29','认证架构师','中级','考试成绩当年第一名0023','1'),
	('EQ000024','E000012','2017-08-04','认证会计师','初级','考试成绩当年第一名0024','1'),
	('EQ000025','E000013','2017-07-03','认证经济师','高级','考试成绩当年第一名0025','1'),
	('EQ000026','E000013','2017-10-10','OCP','中级','考试成绩当年第一名0026','1'),
	('EQ000027','E000014','2017-10-31','CCNA','初级','考试成绩当年第一名0027','1'),
	('EQ000028','E000014','2019-05-05','CCNP','高级','考试成绩当年第一名0028','1'),
	('EQ000029','E000015','2017-07-05','认证药剂师','中级','考试成绩当年第一名0029','1'),
	('EQ000030','E000015','2017-11-02','认证架构师','初级','考试成绩当年第一名0030','1'),
	('EQ000031','E000016','2017-01-17','认证会计师','高级','考试成绩当年第一名0031','1'),
	('EQ000032','E000016','2016-12-16','认证经济师','中级','考试成绩当年第一名0032','1');

insert into employee_education_data values
	('EE000001','E000001','2017-05-23','小学','考试成绩当年第一名','1'),
	('EE000002','E000001','2017-01-17','初中','考试成绩当年第一名0002','1'),
	('EE000003','E000002','2017-02-03','高中','考试成绩当年第一名0003','1'),
	('EE000004','E000002','2017-10-27','大学','考试成绩当年第一名0004','1'),
	('EE000005','E000003','2018-11-11','硕士','考试成绩当年第一名0005','1'),
	('EE000006','E000003','2018-11-05','博士','考试成绩当年第一名0006','1'),
	('EE000007','E000004','2019-06-19','职业教育','考试成绩当年第一名0007','1'),
	('EE000008','E000004','2017-01-10','小学','考试成绩当年第一名0008','1'),
	('EE000009','E000005','2017-11-16','初中','考试成绩当年第一名0009','1'),
	('EE000010','E000005','2019-06-02','高中','考试成绩当年第一名0010','1'),
	('EE000011','E000006','2018-12-20','大学','考试成绩当年第一名0011','1'),
	('EE000012','E000006','2016-12-05','硕士','考试成绩当年第一名0012','1'),
	('EE000013','E000007','2018-08-09','博士','考试成绩当年第一名0013','1'),
	('EE000014','E000007','2018-04-15','职业教育','考试成绩当年第一名0014','1'),
	('EE000015','E000008','2016-09-11','小学','考试成绩当年第一名0015','1'),
	('EE000016','E000008','2016-08-16','初中','考试成绩当年第一名0016','1'),
	('EE000017','E000009','2017-05-12','高中','考试成绩当年第一名0017','1'),
	('EE000018','E000009','2016-07-11','大学','考试成绩当年第一名0018','1'),
	('EE000019','E000010','2019-02-24','硕士','考试成绩当年第一名0019','1'),
	('EE000020','E000010','2018-07-31','博士','考试成绩当年第一名0020','1'),
	('EE000021','E000011','2017-05-11','职业教育','考试成绩当年第一名0021','1'),
	('EE000022','E000011','2018-06-01','小学','考试成绩当年第一名0022','1'),
	('EE000023','E000012','2017-01-04','初中','考试成绩当年第一名0023','1'),
	('EE000024','E000012','2017-01-15','高中','考试成绩当年第一名0024','1'),
	('EE000025','E000013','2017-05-24','大学','考试成绩当年第一名0025','1'),
	('EE000026','E000013','2017-11-05','硕士','考试成绩当年第一名0026','1'),
	('EE000027','E000014','2018-12-17','博士','考试成绩当年第一名0027','1'),
	('EE000028','E000014','2019-04-28','职业教育','考试成绩当年第一名0028','1'),
	('EE000029','E000015','2017-06-15','小学','考试成绩当年第一名0029','1'),
	('EE000030','E000015','2017-10-02','初中','考试成绩当年第一名0030','1'),
	('EE000031','E000016','2019-05-24','高中','考试成绩当年第一名0031','1'),
	('EE000032','E000016','2019-05-23','大学','考试成绩当年第一名0032','1');

insert into employee_award_data values
	('EA000001','E000001','2017-07-21','明星员工','考试成绩当年第一名','1'),
	('EA000002','E000001','2017-03-26','销售之星','考试成绩当年第一名0002','1'),
	('EA000003','E000002','2017-02-05','技术之星','考试成绩当年第一名0003','1'),
	('EA000004','E000002','2018-01-16','管理之星','考试成绩当年第一名0004','1'),
	('EA000005','E000003','2017-03-15','终身成就奖','考试成绩当年第一名0005','1'),
	('EA000006','E000003','2017-06-19','明星员工','考试成绩当年第一名0006','1'),
	('EA000007','E000004','2017-06-04','销售之星','考试成绩当年第一名0007','1'),
	('EA000008','E000004','2018-02-08','技术之星','考试成绩当年第一名0008','1'),
	('EA000009','E000005','2019-06-22','管理之星','考试成绩当年第一名0009','1'),
	('EA000010','E000005','2018-09-13','终身成就奖','考试成绩当年第一名0010','1'),
	('EA000011','E000006','2018-01-20','明星员工','考试成绩当年第一名0011','1'),
	('EA000012','E000006','2018-09-21','销售之星','考试成绩当年第一名0012','1'),
	('EA000013','E000007','2017-11-07','技术之星','考试成绩当年第一名0013','1'),
	('EA000014','E000007','2017-09-29','管理之星','考试成绩当年第一名0014','1'),
	('EA000015','E000008','2018-12-29','终身成就奖','考试成绩当年第一名0015','1'),
	('EA000016','E000008','2018-06-17','明星员工','考试成绩当年第一名0016','1'),
	('EA000017','E000009','2018-10-22','销售之星','考试成绩当年第一名0017','1'),
	('EA000018','E000009','2019-02-14','技术之星','考试成绩当年第一名0018','1'),
	('EA000019','E000010','2018-03-28','管理之星','考试成绩当年第一名0019','1'),
	('EA000020','E000010','2017-05-27','终身成就奖','考试成绩当年第一名0020','1'),
	('EA000021','E000011','2019-06-21','明星员工','考试成绩当年第一名0021','1'),
	('EA000022','E000011','2019-02-05','销售之星','考试成绩当年第一名0022','1'),
	('EA000023','E000012','2019-04-14','技术之星','考试成绩当年第一名0023','1'),
	('EA000024','E000012','2016-09-24','管理之星','考试成绩当年第一名0024','1'),
	('EA000025','E000013','2018-09-21','终身成就奖','考试成绩当年第一名0025','1'),
	('EA000026','E000013','2017-01-08','明星员工','考试成绩当年第一名0026','1'),
	('EA000027','E000014','2018-08-06','销售之星','考试成绩当年第一名0027','1'),
	('EA000028','E000014','2017-05-14','技术之星','考试成绩当年第一名0028','1'),
	('EA000029','E000015','2018-08-18','管理之星','考试成绩当年第一名0029','1'),
	('EA000030','E000015','2017-03-16','终身成就奖','考试成绩当年第一名0030','1'),
	('EA000031','E000016','2018-02-22','明星员工','考试成绩当年第一名0031','1'),
	('EA000032','E000016','2017-05-03','销售之星','考试成绩当年第一名0032','1');

insert into employee_salary_sheet_data values
	('ESS000001','E000001','SG000001','2479.20','791.58','931.78','653.68','863.07','1191.36','7.82',NULL,'PAID_OFF','1'),
	('ESS000002','E000001','SG000001','2528.49','701.04','781.98','751.89','863.23','932.15','7.09',NULL,'PAID_OFF0002','1'),
	('ESS000003','E000001','SG000001','2584.58','820.86','877.04','568.23','809.67','1009.43','6.64',NULL,'PAID_OFF0003','1'),
	('ESS000004','E000001','SG000001','2450.58','717.65','788.30','780.78','1035.70','1192.62','6.94',NULL,'PAID_OFF0004','1'),
	('ESS000005','E000002','SG000001','2315.17','743.58','997.51','706.63','784.69','1137.70','6.82',NULL,'PAID_OFF0005','1'),
	('ESS000006','E000002','SG000001','2911.08','926.33','896.29','792.76','1012.15','1028.34','6.22',NULL,'PAID_OFF0006','1'),
	('ESS000007','E000002','SG000001','2390.42','888.36','899.00','761.44','793.51','1048.51','7.22',NULL,'PAID_OFF0007','1'),
	('ESS000008','E000002','SG000001','2725.21','897.13','896.65','598.08','803.60','1061.56','7.82',NULL,'PAID_OFF0008','1'),
	('ESS000009','E000003','SG000001','2714.37','991.68','981.84','557.89','851.23','1172.68','7.30',NULL,'PAID_OFF0009','1'),
	('ESS000010','E000003','SG000001','2636.57','746.75','964.72','754.73','1064.70','954.98','7.74',NULL,'PAID_OFF0010','1'),
	('ESS000011','E000003','SG000001','2903.88','980.22','889.64','774.22','963.29','945.48','7.19',NULL,'PAID_OFF0011','1'),
	('ESS000012','E000003','SG000001','2498.21','724.14','895.95','667.91','861.73','1017.08','6.72',NULL,'PAID_OFF0012','1'),
	('ESS000013','E000004','SG000001','2980.04','866.98','930.03','736.16','787.84','1105.82','8.37',NULL,'PAID_OFF0013','1'),
	('ESS000014','E000004','SG000001','2652.59','880.39','973.14','701.47','883.37','1154.27','7.61',NULL,'PAID_OFF0014','1'),
	('ESS000015','E000004','SG000001','2530.18','712.20','707.46','782.26','1037.90','994.27','6.84',NULL,'PAID_OFF0015','1'),
	('ESS000016','E000004','SG000001','2681.37','765.28','871.96','621.93','1072.17','988.34','8.85',NULL,'PAID_OFF0016','1'),
	('ESS000017','E000005','SG000001','2781.07','981.16','925.43','688.45','848.34','1186.81','8.67',NULL,'PAID_OFF0017','1'),
	('ESS000018','E000005','SG000001','2633.55','837.23','898.98','756.42','864.57','1040.84','7.85',NULL,'PAID_OFF0018','1'),
	('ESS000019','E000005','SG000001','2800.26','745.92','716.30','594.63','773.65','1139.56','6.51',NULL,'PAID_OFF0019','1'),
	('ESS000020','E000005','SG000001','2222.78','794.00','850.80','683.66','883.04','871.02','7.71',NULL,'PAID_OFF0020','1'),
	('ESS000021','E000006','SG000001','2202.62','740.85','741.82','665.88','937.89','871.00','7.36',NULL,'PAID_OFF0021','1'),
	('ESS000022','E000006','SG000001','2135.20','725.78','834.81','725.89','846.08','1209.99','7.03',NULL,'PAID_OFF0022','1'),
	('ESS000023','E000006','SG000001','2433.97','895.53','746.32','762.89','808.60','922.60','6.78',NULL,'PAID_OFF0023','1'),
	('ESS000024','E000006','SG000001','2184.03','954.58','733.43','564.80','991.69','949.52','6.70',NULL,'PAID_OFF0024','1'),
	('ESS000025','E000007','SG000001','2177.48','962.15','723.83','654.44','860.04','877.95','8.29',NULL,'PAID_OFF0025','1'),
	('ESS000026','E000007','SG000001','2988.96','886.59','783.05','622.81','867.65','1038.38','8.16',NULL,'PAID_OFF0026','1'),
	('ESS000027','E000007','SG000001','2486.43','786.62','984.35','715.38','950.67','994.92','7.81',NULL,'PAID_OFF0027','1'),
	('ESS000028','E000007','SG000001','2249.43','849.63','869.86','786.38','887.54','944.23','6.86',NULL,'PAID_OFF0028','1'),
	('ESS000029','E000008','SG000001','2133.09','780.63','941.02','733.79','827.10','1112.43','7.00',NULL,'PAID_OFF0029','1'),
	('ESS000030','E000008','SG000001','2204.20','876.55','883.38','611.26','898.99','1051.07','7.51',NULL,'PAID_OFF0030','1'),
	('ESS000031','E000008','SG000001','2339.95','957.82','833.20','627.14','1036.00','1140.92','7.42',NULL,'PAID_OFF0031','1'),
	('ESS000032','E000008','SG000001','2353.41','1000.00','868.76','631.72','859.56','1135.63','6.95',NULL,'PAID_OFF0032','1'),
	('ESS000033','E000009','SG000002','2271.20','845.27','796.17','754.15','786.90','1027.84','6.75',NULL,'PAID_OFF0033','1'),
	('ESS000034','E000009','SG000002','2826.63','736.37','855.46','569.87','986.10','1143.70','7.02',NULL,'PAID_OFF0034','1'),
	('ESS000035','E000009','SG000002','2325.19','752.91','970.15','616.05','898.94','969.32','8.36',NULL,'PAID_OFF0035','1'),
	('ESS000036','E000009','SG000002','2366.88','913.51','927.47','631.91','972.87','919.18','8.50',NULL,'PAID_OFF0036','1'),
	('ESS000037','E000010','SG000002','2630.46','931.65','937.83','725.36','917.17','1203.68','8.62',NULL,'PAID_OFF0037','1'),
	('ESS000038','E000010','SG000002','2206.00','865.72','720.98','622.36','1013.21','954.66','8.00',NULL,'PAID_OFF0038','1'),
	('ESS000039','E000010','SG000002','2477.76','719.23','907.16','697.16','871.45','1217.96','6.36',NULL,'PAID_OFF0039','1'),
	('ESS000040','E000010','SG000002','2317.31','821.86','764.96','560.66','1008.90','1045.37','8.26',NULL,'PAID_OFF0040','1'),
	('ESS000041','E000011','SG000002','2170.23','821.00','829.78','640.50','947.78','964.13','7.15',NULL,'PAID_OFF0041','1'),
	('ESS000042','E000011','SG000002','2163.82','807.84','809.17','561.83','994.43','876.21','7.05',NULL,'PAID_OFF0042','1'),
	('ESS000043','E000011','SG000002','2763.49','702.79','915.67','623.10','781.30','915.84','6.79',NULL,'PAID_OFF0043','1'),
	('ESS000044','E000011','SG000002','2128.61','801.17','948.28','597.06','855.86','936.58','8.46',NULL,'PAID_OFF0044','1'),
	('ESS000045','E000012','SG000002','2554.54','859.18','769.50','785.71','945.09','1093.15','8.70',NULL,'PAID_OFF0045','1'),
	('ESS000046','E000012','SG000002','2312.43','707.23','849.43','709.64','905.82','1095.75','7.44',NULL,'PAID_OFF0046','1'),
	('ESS000047','E000012','SG000002','2334.82','717.89','819.59','745.13','810.39','935.24','8.45',NULL,'PAID_OFF0047','1'),
	('ESS000048','E000012','SG000002','2256.96','983.17','719.37','568.50','794.53','917.58','6.34',NULL,'PAID_OFF0048','1'),
	('ESS000049','E000013','SG000002','2307.85','737.29','718.84','693.15','1027.15','1003.52','7.29',NULL,'PAID_OFF0049','1'),
	('ESS000050','E000013','SG000002','2170.13','749.18','814.32','607.64','806.37','933.31','8.39',NULL,'PAID_OFF0050','1'),
	('ESS000051','E000013','SG000002','2713.84','862.62','988.59','740.32','1011.32','876.34','8.29',NULL,'PAID_OFF0051','1'),
	('ESS000052','E000013','SG000002','2266.07','889.28','956.55','676.51','928.38','871.09','7.37',NULL,'PAID_OFF0052','1'),
	('ESS000053','E000014','SG000002','2262.52','923.64','917.58','568.31','987.85','939.37','7.32',NULL,'PAID_OFF0053','1'),
	('ESS000054','E000014','SG000002','2235.35','820.40','794.24','733.92','773.82','950.70','6.77',NULL,'PAID_OFF0054','1'),
	('ESS000055','E000014','SG000002','2632.72','756.95','974.23','780.59','867.55','1077.49','7.26',NULL,'PAID_OFF0055','1'),
	('ESS000056','E000014','SG000002','2232.18','980.16','938.55','679.82','966.02','1078.24','8.54',NULL,'PAID_OFF0056','1'),
	('ESS000057','E000015','SG000002','2216.39','722.49','791.30','672.24','779.33','1217.33','8.84',NULL,'PAID_OFF0057','1'),
	('ESS000058','E000015','SG000002','2830.75','944.75','962.79','715.43','949.20','1080.25','8.45',NULL,'PAID_OFF0058','1'),
	('ESS000059','E000015','SG000002','2602.25','793.52','928.10','687.64','836.60','912.07','8.07',NULL,'PAID_OFF0059','1'),
	('ESS000060','E000015','SG000002','2192.30','706.54','826.73','754.88','1058.80','956.94','7.70',NULL,'PAID_OFF0060','1'),
	('ESS000061','E000016','SG000002','2672.70','941.89','940.84','779.74','885.86','1116.82','8.30',NULL,'PAID_OFF0061','1'),
	('ESS000062','E000016','SG000002','2803.78','846.53','929.62','717.59','782.14','910.75','7.22',NULL,'PAID_OFF0062','1'),
	('ESS000063','E000016','SG000002','2620.15','914.21','920.50','601.13','1035.97','968.13','8.64',NULL,'PAID_OFF0063','1'),
	('ESS000064','E000016','SG000002','2752.10','977.19','932.84','721.57','1094.84','1096.08','7.84',NULL,'PAID_OFF0064','1');

insert into paying_off_data values
	('PO000001','出纳','E000001','2019-05-16','4789.43','1'),
	('PO000002','出纳0002','E000001','2018-05-29','4182.20','1'),
	('PO000003','出纳0003','E000002','2019-05-03','3945.15','1'),
	('PO000004','出纳0004','E000002','2018-04-15','4482.31','1'),
	('PO000005','出纳0005','E000003','2017-09-24','5085.47','1'),
	('PO000006','出纳0006','E000003','2018-07-14','4693.16','1'),
	('PO000007','出纳0007','E000004','2017-08-28','5161.24','1'),
	('PO000008','出纳0008','E000004','2017-04-02','3961.90','1'),
	('PO000009','出纳0009','E000005','2019-01-27','5024.71','1'),
	('PO000010','出纳0010','E000005','2018-05-22','3704.44','1'),
	('PO000011','出纳0011','E000006','2018-06-25','3743.48','1'),
	('PO000012','出纳0012','E000006','2019-04-18','3683.56','1'),
	('PO000013','出纳0013','E000007','2017-08-29','4640.28','1'),
	('PO000014','出纳0014','E000007','2016-08-18','4155.51','1'),
	('PO000015','出纳0015','E000008','2018-09-23','4498.55','1'),
	('PO000016','出纳0016','E000008','2017-10-14','4312.08','1'),
	('PO000017','出纳0017','E000009','2018-04-15','4613.70','1'),
	('PO000018','出纳0018','E000009','2019-04-19','3919.10','1'),
	('PO000019','出纳0019','E000010','2017-05-21','4205.86','1'),
	('PO000020','出纳0020','E000010','2017-02-15','4644.03','1'),
	('PO000021','出纳0021','E000011','2018-08-30','4635.33','1'),
	('PO000022','出纳0022','E000011','2019-04-17','4551.89','1'),
	('PO000023','出纳0023','E000012','2019-03-17','5159.79','1'),
	('PO000024','出纳0024','E000012','2017-11-24','4003.19','1'),
	('PO000025','出纳0025','E000013','2019-06-27','5105.59','1'),
	('PO000026','出纳0026','E000013','2017-04-19','4382.69','1'),
	('PO000027','出纳0027','E000014','2019-01-21','3816.35','1'),
	('PO000028','出纳0028','E000014','2019-01-09','4960.49','1'),
	('PO000029','出纳0029','E000015','2017-10-15','4188.21','1'),
	('PO000030','出纳0030','E000015','2018-12-06','4679.54','1'),
	('PO000031','出纳0031','E000016','2018-11-02','4344.36','1'),
	('PO000032','出纳0032','E000016','2017-01-12','4177.58','1');

insert into user_domain_data values
	('UD000001','用户区域','1');

insert into user_white_list_data values
	('UWL000001','clariones','tester;ios-spokesperson','UD000001','1'),
	('UWL000002','13808188512','tester;ios-spokesperson0002','UD000001','1');

insert into sec_user_data values
	('SU000001','login','13900000001','','C183EC89F92A462CF45B95504792EC4625E847C90536EEFE512D1C9DB8602E95','wx123456789abcdefghijklmn','wxapp12098410239840','jwt_token_12345678','0','2019-06-22 12:26:05','2019-07-02 18:46:19','UD000001',NULL,'BLOCKED','1'),
	('SU000002','login0002','13900000002','suddy_chang@163.com','AC2F95628244C6975EB2C36942EA879ED93D93F5895EF3157733E4629FA86B92','wx123456789abcdefghijklmn0002','wxapp120984102398400002','jwt_token_123456780002','9999999','2019-06-27 22:14:41','2019-06-30 04:04:52','UD000001',NULL,'BLOCKED0002','1');

insert into sec_user_blocking_data values
	('SUB000001','currentUser()','2019-06-28 15:23:11','这个用户多次发送违反社区的帖子，现在把他给屏蔽了','1');

insert into user_app_data values
	('UA000001','审车平台','SU000001','users','1','MXWR','CarInspectionPlatform','CIP000001','/link/to/app','1'),
	('UA000002','账户管理','SU000001','bank','1','MXWR','UserDomain','UD000001','/link/to/app0002','1'),
	('UA000003','接车公司','SU000001','wechat','1','MXWR','CarReceivingServiceCompany','CRSC000001','/link/to/app0003','1'),
	('UA000004','审车公司','SU000002','bar-chart','1','MXWR','CarInspectionServiceCompany','CISC000001','/link/to/app0004','1'),
	('UA000005','维修公司','SU000002','user','1','MXWR','CarRepairingServiceCompany','CRSC000001','/link/to/app0005','1'),
	('UA000006','顾客','SU000002','users','1','MXWR','CustomerInfo','CI000001','/link/to/app0006','1');

insert into list_access_data values
	('LA000001','列表','levelOneCategoryList','1','1','1','1','1','UA000001','1'),
	('LA000002','列表0002','levelOneCategoryList0002','1','1','1','1','1','UA000001','1'),
	('LA000003','列表0003','levelOneCategoryList0003','1','1','1','1','1','UA000002','1'),
	('LA000004','列表0004','levelOneCategoryList0004','1','1','1','1','1','UA000003','1'),
	('LA000005','列表0005','levelOneCategoryList0005','1','1','1','1','1','UA000004','1'),
	('LA000006','列表0006','levelOneCategoryList0006','1','1','1','1','1','UA000004','1'),
	('LA000007','列表0007','levelOneCategoryList0007','1','1','1','1','1','UA000005','1'),
	('LA000008','列表0008','levelOneCategoryList0008','1','1','1','1','1','UA000006','1');

insert into object_access_data values
	('OA000001','控制访问列表1','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000001','1'),
	('OA000002','控制访问列表10002','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000001','1'),
	('OA000003','控制访问列表10003','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000002','1'),
	('OA000004','控制访问列表10004','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000003','1'),
	('OA000005','控制访问列表10005','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000004','1'),
	('OA000006','控制访问列表10006','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000004','1'),
	('OA000007','控制访问列表10007','FranchiseeStoreCountryCenter','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','catalogList','UA000005','1'),
	('OA000008','控制访问列表10008','AccountSet','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','levelOneCategoryList','UA000006','1');

insert into login_history_data values
	('LH000001','2019-06-20 21:58:05','192.168.1.1','登陆成功','SU000001','1'),
	('LH000002','2019-07-03 07:40:19','192.168.1.2','登陆成功0002','SU000001','1'),
	('LH000003','2019-06-26 10:20:56','192.168.1.1','登陆成功0003','SU000002','1'),
	('LH000004','2019-06-15 18:01:57','192.168.1.2','登陆成功0004','SU000002','1');

insert into generic_form_data values
	('GF000001','登记输入单','姓名就是你身份证上的名字','1');

insert into form_message_data values
	('FM000001','字段组合错误','GF000001','success','1'),
	('FM000002','字段组合错误0002','GF000001','info','1');

insert into form_field_message_data values
	('FFM000001','输入错误','name','GF000001','success','1'),
	('FFM000002','输入错误0002','name0002','GF000001','info','1');

insert into form_field_data values
	('FF000001','姓名','name','name','text','GF000001','姓名就是你身份证上的名字','李一一','姓名就是你身份证上的名字','基础信息','maybe any value','a value expression','1','1','1','','','1'),
	('FF000002','年龄','age','name0002','longtext','GF000001','姓名就是你身份证上的名字0002','李一一0002','姓名就是你身份证上的名字0002','扩展信息','maybe any value0002','a value expression0002','1','1','1','','','1'),
	('FF000003','出生地','birth_place','name0003','date','GF000001','姓名就是你身份证上的名字0003','李一一0003','姓名就是你身份证上的名字0003','基础信息','maybe any value0003','a value expression0003','1','1','1','','','1'),
	('FF000004','国籍','country','name0004','date_time','GF000001','姓名就是你身份证上的名字0004','李一一0004','姓名就是你身份证上的名字0004','扩展信息','maybe any value0004','a value expression0004','1','1','1','男,女','男,女','1');

insert into form_action_data values
	('FA000001','功能','name','save','default','genericFormManager/name/name0002/name0003/','GF000001','1'),
	('FA000002','功能0002','name0002','update','warning','genericFormManager/name/name0002/name0003/0002','GF000001','1');



/*
Mysql innodb's foreign key has index automatically

*/

create unique index idx_retail_store_country_center_version on retail_store_country_center_data(id, version);

create unique index idx_catalog_version on catalog_data(id, version);

alter table catalog_data add constraint catalog4owner_fk
	foreign key(owner) references retail_store_country_center_data(id) on delete cascade on update cascade;
create unique index idx_level_one_category_version on level_one_category_data(id, version);

alter table level_one_category_data add constraint level_one_category4catalog_fk
	foreign key(catalog) references catalog_data(id) on delete cascade on update cascade;
create unique index idx_level_two_category_version on level_two_category_data(id, version);

alter table level_two_category_data add constraint level_two_category4parent_category_fk
	foreign key(parent_category) references level_one_category_data(id) on delete cascade on update cascade;
create unique index idx_level_three_category_version on level_three_category_data(id, version);

alter table level_three_category_data add constraint level_three_category4parent_category_fk
	foreign key(parent_category) references level_two_category_data(id) on delete cascade on update cascade;
create unique index idx_product_version on product_data(id, version);

alter table product_data add constraint product4parent_category_fk
	foreign key(parent_category) references level_three_category_data(id) on delete cascade on update cascade;
create unique index idx_sku_version on sku_data(id, version);

alter table sku_data add constraint sku4product_fk
	foreign key(product) references product_data(id) on delete cascade on update cascade;
create unique index idx_retail_store_province_center_version on retail_store_province_center_data(id, version);

alter table retail_store_province_center_data add constraint retail_store_province_center4country_fk
	foreign key(country) references retail_store_country_center_data(id) on delete cascade on update cascade;
create unique index idx_province_center_department_version on province_center_department_data(id, version);

alter table province_center_department_data add constraint province_center_department4province_center_fk
	foreign key(province_center) references retail_store_province_center_data(id) on delete cascade on update cascade;
create unique index idx_province_center_employee_version on province_center_employee_data(id, version);

alter table province_center_employee_data add constraint province_center_employee4department_fk
	foreign key(department) references province_center_department_data(id) on delete cascade on update cascade;
alter table province_center_employee_data add constraint province_center_employee4province_center_fk
	foreign key(province_center) references retail_store_province_center_data(id) on delete cascade on update cascade;
create unique index idx_retail_store_city_service_center_version on retail_store_city_service_center_data(id, version);

alter table retail_store_city_service_center_data add constraint retail_store_city_service_center4belongs_to_fk
	foreign key(belongs_to) references retail_store_province_center_data(id) on delete cascade on update cascade;
create unique index idx_city_partner_version on city_partner_data(id, version);

alter table city_partner_data add constraint city_partner4city_service_center_fk
	foreign key(city_service_center) references retail_store_city_service_center_data(id) on delete cascade on update cascade;
create unique index idx_potential_customer_version on potential_customer_data(id, version);

alter table potential_customer_data add constraint potential_customer4city_service_center_fk
	foreign key(city_service_center) references retail_store_city_service_center_data(id) on delete cascade on update cascade;
alter table potential_customer_data add constraint potential_customer4city_partner_fk
	foreign key(city_partner) references city_partner_data(id) on delete cascade on update cascade;
create unique index idx_potential_customer_contact_person_version on potential_customer_contact_person_data(id, version);

alter table potential_customer_contact_person_data add constraint potential_customer_contact_person4potential_customer_fk
	foreign key(potential_customer) references potential_customer_data(id) on delete cascade on update cascade;
create unique index idx_potential_customer_contact_version on potential_customer_contact_data(id, version);

alter table potential_customer_contact_data add constraint potential_customer_contact4potential_customer_fk
	foreign key(potential_customer) references potential_customer_data(id) on delete cascade on update cascade;
alter table potential_customer_contact_data add constraint potential_customer_contact4city_partner_fk
	foreign key(city_partner) references city_partner_data(id) on delete cascade on update cascade;
alter table potential_customer_contact_data add constraint potential_customer_contact4contact_to_fk
	foreign key(contact_to) references potential_customer_contact_person_data(id) on delete cascade on update cascade;
create unique index idx_city_event_version on city_event_data(id, version);

alter table city_event_data add constraint city_event4city_service_center_fk
	foreign key(city_service_center) references retail_store_city_service_center_data(id) on delete cascade on update cascade;
create unique index idx_event_attendance_version on event_attendance_data(id, version);

alter table event_attendance_data add constraint event_attendance4potential_customer_fk
	foreign key(potential_customer) references potential_customer_data(id) on delete cascade on update cascade;
alter table event_attendance_data add constraint event_attendance4city_event_fk
	foreign key(city_event) references city_event_data(id) on delete cascade on update cascade;
create unique index idx_retail_store_version on retail_store_data(id, version);

alter table retail_store_data add constraint retail_store4retail_store_country_center_fk
	foreign key(retail_store_country_center) references retail_store_country_center_data(id) on delete cascade on update cascade;
alter table retail_store_data add constraint retail_store4city_service_center_fk
	foreign key(city_service_center) references retail_store_city_service_center_data(id) on delete cascade on update cascade;
alter table retail_store_data add constraint retail_store4creation_fk
	foreign key(creation) references retail_store_creation_data(id) on delete cascade on update cascade;
alter table retail_store_data add constraint retail_store4investment_invitation_fk
	foreign key(investment_invitation) references retail_store_investment_invitation_data(id) on delete cascade on update cascade;
alter table retail_store_data add constraint retail_store4franchising_fk
	foreign key(franchising) references retail_store_franchising_data(id) on delete cascade on update cascade;
alter table retail_store_data add constraint retail_store4decoration_fk
	foreign key(decoration) references retail_store_decoration_data(id) on delete cascade on update cascade;
alter table retail_store_data add constraint retail_store4opening_fk
	foreign key(opening) references retail_store_opening_data(id) on delete cascade on update cascade;
alter table retail_store_data add constraint retail_store4closing_fk
	foreign key(closing) references retail_store_closing_data(id) on delete cascade on update cascade;
create unique index idx_retail_store_creation_version on retail_store_creation_data(id, version);

create unique index idx_retail_store_investment_invitation_version on retail_store_investment_invitation_data(id, version);

create unique index idx_retail_store_franchising_version on retail_store_franchising_data(id, version);

create unique index idx_retail_store_decoration_version on retail_store_decoration_data(id, version);

create unique index idx_retail_store_opening_version on retail_store_opening_data(id, version);

create unique index idx_retail_store_closing_version on retail_store_closing_data(id, version);

create unique index idx_retail_store_member_version on retail_store_member_data(id, version);

alter table retail_store_member_data add constraint retail_store_member4owner_fk
	foreign key(owner) references retail_store_country_center_data(id) on delete cascade on update cascade;
create unique index idx_consumer_order_version on consumer_order_data(id, version);

alter table consumer_order_data add constraint consumer_order4consumer_fk
	foreign key(consumer) references retail_store_member_data(id) on delete cascade on update cascade;
alter table consumer_order_data add constraint consumer_order4confirmation_fk
	foreign key(confirmation) references supply_order_confirmation_data(id) on delete cascade on update cascade;
alter table consumer_order_data add constraint consumer_order4approval_fk
	foreign key(approval) references supply_order_approval_data(id) on delete cascade on update cascade;
alter table consumer_order_data add constraint consumer_order4processing_fk
	foreign key(processing) references supply_order_processing_data(id) on delete cascade on update cascade;
alter table consumer_order_data add constraint consumer_order4shipment_fk
	foreign key(shipment) references supply_order_shipment_data(id) on delete cascade on update cascade;
alter table consumer_order_data add constraint consumer_order4delivery_fk
	foreign key(delivery) references supply_order_delivery_data(id) on delete cascade on update cascade;
alter table consumer_order_data add constraint consumer_order4store_fk
	foreign key(store) references retail_store_data(id) on delete cascade on update cascade;
create unique index idx_consumer_order_confirmation_version on consumer_order_confirmation_data(id, version);

create unique index idx_consumer_order_approval_version on consumer_order_approval_data(id, version);

create unique index idx_consumer_order_processing_version on consumer_order_processing_data(id, version);

create unique index idx_consumer_order_shipment_version on consumer_order_shipment_data(id, version);

create unique index idx_consumer_order_delivery_version on consumer_order_delivery_data(id, version);

create unique index idx_consumer_order_line_item_version on consumer_order_line_item_data(id, version);

alter table consumer_order_line_item_data add constraint consumer_order_line_item4biz_order_fk
	foreign key(biz_order) references consumer_order_data(id) on delete cascade on update cascade;
create unique index idx_consumer_order_shipping_group_version on consumer_order_shipping_group_data(id, version);

alter table consumer_order_shipping_group_data add constraint consumer_order_shipping_group4biz_order_fk
	foreign key(biz_order) references consumer_order_data(id) on delete cascade on update cascade;
create unique index idx_consumer_order_payment_group_version on consumer_order_payment_group_data(id, version);

alter table consumer_order_payment_group_data add constraint consumer_order_payment_group4biz_order_fk
	foreign key(biz_order) references consumer_order_data(id) on delete cascade on update cascade;
create unique index idx_consumer_order_price_adjustment_version on consumer_order_price_adjustment_data(id, version);

alter table consumer_order_price_adjustment_data add constraint consumer_order_price_adjustment4biz_order_fk
	foreign key(biz_order) references consumer_order_data(id) on delete cascade on update cascade;
create unique index idx_retail_store_member_coupon_version on retail_store_member_coupon_data(id, version);

alter table retail_store_member_coupon_data add constraint retail_store_member_coupon4owner_fk
	foreign key(owner) references retail_store_member_data(id) on delete cascade on update cascade;
create unique index idx_member_wishlist_version on member_wishlist_data(id, version);

alter table member_wishlist_data add constraint member_wishlist4owner_fk
	foreign key(owner) references retail_store_member_data(id) on delete cascade on update cascade;
create unique index idx_member_reward_point_version on member_reward_point_data(id, version);

alter table member_reward_point_data add constraint member_reward_point4owner_fk
	foreign key(owner) references retail_store_member_data(id) on delete cascade on update cascade;
create unique index idx_member_reward_point_redemption_version on member_reward_point_redemption_data(id, version);

alter table member_reward_point_redemption_data add constraint member_reward_point_redemption4owner_fk
	foreign key(owner) references retail_store_member_data(id) on delete cascade on update cascade;
create unique index idx_member_wishlist_product_version on member_wishlist_product_data(id, version);

alter table member_wishlist_product_data add constraint member_wishlist_product4owner_fk
	foreign key(owner) references member_wishlist_data(id) on delete cascade on update cascade;
create unique index idx_retail_store_member_address_version on retail_store_member_address_data(id, version);

alter table retail_store_member_address_data add constraint retail_store_member_address4owner_fk
	foreign key(owner) references retail_store_member_data(id) on delete cascade on update cascade;
create unique index idx_retail_store_member_gift_card_version on retail_store_member_gift_card_data(id, version);

alter table retail_store_member_gift_card_data add constraint retail_store_member_gift_card4owner_fk
	foreign key(owner) references retail_store_member_data(id) on delete cascade on update cascade;
create unique index idx_retail_store_member_gift_card_consume_record_version on retail_store_member_gift_card_consume_record_data(id, version);

alter table retail_store_member_gift_card_consume_record_data add constraint retail_store_member_gift_card_consume_record4owner_fk
	foreign key(owner) references retail_store_member_gift_card_data(id) on delete cascade on update cascade;
alter table retail_store_member_gift_card_consume_record_data add constraint retail_store_member_gift_card_consume_record4biz_order_fk
	foreign key(biz_order) references consumer_order_data(id) on delete cascade on update cascade;
create unique index idx_goods_supplier_version on goods_supplier_data(id, version);

alter table goods_supplier_data add constraint goods_supplier4belong_to_fk
	foreign key(belong_to) references retail_store_country_center_data(id) on delete cascade on update cascade;
create unique index idx_supplier_product_version on supplier_product_data(id, version);

alter table supplier_product_data add constraint supplier_product4supplier_fk
	foreign key(supplier) references goods_supplier_data(id) on delete cascade on update cascade;
create unique index idx_product_supply_duration_version on product_supply_duration_data(id, version);

alter table product_supply_duration_data add constraint product_supply_duration4product_fk
	foreign key(product) references supplier_product_data(id) on delete cascade on update cascade;
create unique index idx_supply_order_version on supply_order_data(id, version);

alter table supply_order_data add constraint supply_order4buyer_fk
	foreign key(buyer) references retail_store_country_center_data(id) on delete cascade on update cascade;
alter table supply_order_data add constraint supply_order4seller_fk
	foreign key(seller) references goods_supplier_data(id) on delete cascade on update cascade;
alter table supply_order_data add constraint supply_order4confirmation_fk
	foreign key(confirmation) references supply_order_confirmation_data(id) on delete cascade on update cascade;
alter table supply_order_data add constraint supply_order4approval_fk
	foreign key(approval) references supply_order_approval_data(id) on delete cascade on update cascade;
alter table supply_order_data add constraint supply_order4processing_fk
	foreign key(processing) references supply_order_processing_data(id) on delete cascade on update cascade;
alter table supply_order_data add constraint supply_order4picking_fk
	foreign key(picking) references supply_order_picking_data(id) on delete cascade on update cascade;
alter table supply_order_data add constraint supply_order4shipment_fk
	foreign key(shipment) references supply_order_shipment_data(id) on delete cascade on update cascade;
alter table supply_order_data add constraint supply_order4delivery_fk
	foreign key(delivery) references supply_order_delivery_data(id) on delete cascade on update cascade;
create unique index idx_supply_order_confirmation_version on supply_order_confirmation_data(id, version);

create unique index idx_supply_order_approval_version on supply_order_approval_data(id, version);

create unique index idx_supply_order_processing_version on supply_order_processing_data(id, version);

create unique index idx_supply_order_picking_version on supply_order_picking_data(id, version);

create unique index idx_supply_order_shipment_version on supply_order_shipment_data(id, version);

create unique index idx_supply_order_delivery_version on supply_order_delivery_data(id, version);

create unique index idx_supply_order_line_item_version on supply_order_line_item_data(id, version);

alter table supply_order_line_item_data add constraint supply_order_line_item4biz_order_fk
	foreign key(biz_order) references supply_order_data(id) on delete cascade on update cascade;
create unique index idx_supply_order_shipping_group_version on supply_order_shipping_group_data(id, version);

alter table supply_order_shipping_group_data add constraint supply_order_shipping_group4biz_order_fk
	foreign key(biz_order) references supply_order_data(id) on delete cascade on update cascade;
create unique index idx_supply_order_payment_group_version on supply_order_payment_group_data(id, version);

alter table supply_order_payment_group_data add constraint supply_order_payment_group4biz_order_fk
	foreign key(biz_order) references supply_order_data(id) on delete cascade on update cascade;
create unique index idx_retail_store_order_version on retail_store_order_data(id, version);

alter table retail_store_order_data add constraint retail_store_order4buyer_fk
	foreign key(buyer) references retail_store_data(id) on delete cascade on update cascade;
alter table retail_store_order_data add constraint retail_store_order4seller_fk
	foreign key(seller) references retail_store_country_center_data(id) on delete cascade on update cascade;
alter table retail_store_order_data add constraint retail_store_order4confirmation_fk
	foreign key(confirmation) references retail_store_order_confirmation_data(id) on delete cascade on update cascade;
alter table retail_store_order_data add constraint retail_store_order4approval_fk
	foreign key(approval) references retail_store_order_approval_data(id) on delete cascade on update cascade;
alter table retail_store_order_data add constraint retail_store_order4processing_fk
	foreign key(processing) references retail_store_order_processing_data(id) on delete cascade on update cascade;
alter table retail_store_order_data add constraint retail_store_order4picking_fk
	foreign key(picking) references retail_store_order_picking_data(id) on delete cascade on update cascade;
alter table retail_store_order_data add constraint retail_store_order4shipment_fk
	foreign key(shipment) references retail_store_order_shipment_data(id) on delete cascade on update cascade;
alter table retail_store_order_data add constraint retail_store_order4delivery_fk
	foreign key(delivery) references retail_store_order_delivery_data(id) on delete cascade on update cascade;
create unique index idx_retail_store_order_confirmation_version on retail_store_order_confirmation_data(id, version);

create unique index idx_retail_store_order_approval_version on retail_store_order_approval_data(id, version);

create unique index idx_retail_store_order_processing_version on retail_store_order_processing_data(id, version);

create unique index idx_retail_store_order_picking_version on retail_store_order_picking_data(id, version);

create unique index idx_retail_store_order_shipment_version on retail_store_order_shipment_data(id, version);

create unique index idx_retail_store_order_delivery_version on retail_store_order_delivery_data(id, version);

create unique index idx_retail_store_order_line_item_version on retail_store_order_line_item_data(id, version);

alter table retail_store_order_line_item_data add constraint retail_store_order_line_item4biz_order_fk
	foreign key(biz_order) references retail_store_order_data(id) on delete cascade on update cascade;
create unique index idx_retail_store_order_shipping_group_version on retail_store_order_shipping_group_data(id, version);

alter table retail_store_order_shipping_group_data add constraint retail_store_order_shipping_group4biz_order_fk
	foreign key(biz_order) references retail_store_order_data(id) on delete cascade on update cascade;
create unique index idx_retail_store_order_payment_group_version on retail_store_order_payment_group_data(id, version);

alter table retail_store_order_payment_group_data add constraint retail_store_order_payment_group4biz_order_fk
	foreign key(biz_order) references retail_store_order_data(id) on delete cascade on update cascade;
create unique index idx_warehouse_version on warehouse_data(id, version);

alter table warehouse_data add constraint warehouse4owner_fk
	foreign key(owner) references retail_store_country_center_data(id) on delete cascade on update cascade;
create unique index idx_storage_space_version on storage_space_data(id, version);

alter table storage_space_data add constraint storage_space4warehouse_fk
	foreign key(warehouse) references warehouse_data(id) on delete cascade on update cascade;
create unique index idx_smart_pallet_version on smart_pallet_data(id, version);

alter table smart_pallet_data add constraint smart_pallet4warehouse_fk
	foreign key(warehouse) references warehouse_data(id) on delete cascade on update cascade;
create unique index idx_goods_shelf_version on goods_shelf_data(id, version);

alter table goods_shelf_data add constraint goods_shelf4storage_space_fk
	foreign key(storage_space) references storage_space_data(id) on delete cascade on update cascade;
alter table goods_shelf_data add constraint goods_shelf4supplier_space_fk
	foreign key(supplier_space) references supplier_space_data(id) on delete cascade on update cascade;
alter table goods_shelf_data add constraint goods_shelf4damage_space_fk
	foreign key(damage_space) references damage_space_data(id) on delete cascade on update cascade;
create unique index idx_goods_shelf_stock_count_version on goods_shelf_stock_count_data(id, version);

alter table goods_shelf_stock_count_data add constraint goods_shelf_stock_count4shelf_fk
	foreign key(shelf) references goods_shelf_data(id) on delete cascade on update cascade;
create unique index idx_stock_count_issue_track_version on stock_count_issue_track_data(id, version);

alter table stock_count_issue_track_data add constraint stock_count_issue_track4stock_count_fk
	foreign key(stock_count) references goods_shelf_stock_count_data(id) on delete cascade on update cascade;
create unique index idx_goods_allocation_version on goods_allocation_data(id, version);

alter table goods_allocation_data add constraint goods_allocation4goods_shelf_fk
	foreign key(goods_shelf) references goods_shelf_data(id) on delete cascade on update cascade;
create unique index idx_goods_version on goods_data(id, version);

alter table goods_data add constraint goods4sku_fk
	foreign key(sku) references sku_data(id) on delete cascade on update cascade;
alter table goods_data add constraint goods4receiving_space_fk
	foreign key(receiving_space) references receiving_space_data(id) on delete cascade on update cascade;
alter table goods_data add constraint goods4goods_allocation_fk
	foreign key(goods_allocation) references goods_allocation_data(id) on delete cascade on update cascade;
alter table goods_data add constraint goods4smart_pallet_fk
	foreign key(smart_pallet) references smart_pallet_data(id) on delete cascade on update cascade;
alter table goods_data add constraint goods4shipping_space_fk
	foreign key(shipping_space) references shipping_space_data(id) on delete cascade on update cascade;
alter table goods_data add constraint goods4transport_task_fk
	foreign key(transport_task) references transport_task_data(id) on delete cascade on update cascade;
alter table goods_data add constraint goods4retail_store_fk
	foreign key(retail_store) references retail_store_data(id) on delete cascade on update cascade;
alter table goods_data add constraint goods4biz_order_fk
	foreign key(biz_order) references supply_order_data(id) on delete cascade on update cascade;
alter table goods_data add constraint goods4retail_store_order_fk
	foreign key(retail_store_order) references retail_store_order_data(id) on delete cascade on update cascade;
alter table goods_data add constraint goods4packaging_fk
	foreign key(packaging) references goods_packaging_data(id) on delete cascade on update cascade;
create unique index idx_goods_packaging_version on goods_packaging_data(id, version);

create unique index idx_goods_movement_version on goods_movement_data(id, version);

alter table goods_movement_data add constraint goods_movement4goods_fk
	foreign key(goods) references goods_data(id) on delete cascade on update cascade;
create unique index idx_supplier_space_version on supplier_space_data(id, version);

alter table supplier_space_data add constraint supplier_space4warehouse_fk
	foreign key(warehouse) references warehouse_data(id) on delete cascade on update cascade;
create unique index idx_receiving_space_version on receiving_space_data(id, version);

alter table receiving_space_data add constraint receiving_space4warehouse_fk
	foreign key(warehouse) references warehouse_data(id) on delete cascade on update cascade;
create unique index idx_shipping_space_version on shipping_space_data(id, version);

alter table shipping_space_data add constraint shipping_space4warehouse_fk
	foreign key(warehouse) references warehouse_data(id) on delete cascade on update cascade;
create unique index idx_damage_space_version on damage_space_data(id, version);

alter table damage_space_data add constraint damage_space4warehouse_fk
	foreign key(warehouse) references warehouse_data(id) on delete cascade on update cascade;
create unique index idx_warehouse_asset_version on warehouse_asset_data(id, version);

alter table warehouse_asset_data add constraint warehouse_asset4owner_fk
	foreign key(owner) references warehouse_data(id) on delete cascade on update cascade;
create unique index idx_transport_fleet_version on transport_fleet_data(id, version);

alter table transport_fleet_data add constraint transport_fleet4owner_fk
	foreign key(owner) references retail_store_country_center_data(id) on delete cascade on update cascade;
create unique index idx_transport_truck_version on transport_truck_data(id, version);

alter table transport_truck_data add constraint transport_truck4owner_fk
	foreign key(owner) references transport_fleet_data(id) on delete cascade on update cascade;
create unique index idx_truck_driver_version on truck_driver_data(id, version);

alter table truck_driver_data add constraint truck_driver4belongs_to_fk
	foreign key(belongs_to) references transport_fleet_data(id) on delete cascade on update cascade;
create unique index idx_transport_task_version on transport_task_data(id, version);

alter table transport_task_data add constraint transport_task4end_fk
	foreign key(end) references retail_store_data(id) on delete cascade on update cascade;
alter table transport_task_data add constraint transport_task4driver_fk
	foreign key(driver) references truck_driver_data(id) on delete cascade on update cascade;
alter table transport_task_data add constraint transport_task4truck_fk
	foreign key(truck) references transport_truck_data(id) on delete cascade on update cascade;
alter table transport_task_data add constraint transport_task4belongs_to_fk
	foreign key(belongs_to) references transport_fleet_data(id) on delete cascade on update cascade;
create unique index idx_transport_task_track_version on transport_task_track_data(id, version);

alter table transport_task_track_data add constraint transport_task_track4movement_fk
	foreign key(movement) references transport_task_data(id) on delete cascade on update cascade;
create unique index idx_account_set_version on account_set_data(id, version);

alter table account_set_data add constraint account_set4country_center_fk
	foreign key(country_center) references retail_store_country_center_data(id) on delete cascade on update cascade;
alter table account_set_data add constraint account_set4retail_store_fk
	foreign key(retail_store) references retail_store_data(id) on delete cascade on update cascade;
alter table account_set_data add constraint account_set4goods_supplier_fk
	foreign key(goods_supplier) references goods_supplier_data(id) on delete cascade on update cascade;
create unique index idx_accounting_subject_version on accounting_subject_data(id, version);

alter table accounting_subject_data add constraint accounting_subject4account_set_fk
	foreign key(account_set) references account_set_data(id) on delete cascade on update cascade;
create unique index idx_accounting_period_version on accounting_period_data(id, version);

alter table accounting_period_data add constraint accounting_period4account_set_fk
	foreign key(account_set) references account_set_data(id) on delete cascade on update cascade;
create unique index idx_accounting_document_type_version on accounting_document_type_data(id, version);

alter table accounting_document_type_data add constraint accounting_document_type4accounting_period_fk
	foreign key(accounting_period) references account_set_data(id) on delete cascade on update cascade;
create unique index idx_accounting_document_version on accounting_document_data(id, version);

alter table accounting_document_data add constraint accounting_document4accounting_period_fk
	foreign key(accounting_period) references accounting_period_data(id) on delete cascade on update cascade;
alter table accounting_document_data add constraint accounting_document4document_type_fk
	foreign key(document_type) references accounting_document_type_data(id) on delete cascade on update cascade;
alter table accounting_document_data add constraint accounting_document4creation_fk
	foreign key(creation) references accounting_document_creation_data(id) on delete cascade on update cascade;
alter table accounting_document_data add constraint accounting_document4confirmation_fk
	foreign key(confirmation) references accounting_document_confirmation_data(id) on delete cascade on update cascade;
alter table accounting_document_data add constraint accounting_document4auditing_fk
	foreign key(auditing) references accounting_document_auditing_data(id) on delete cascade on update cascade;
alter table accounting_document_data add constraint accounting_document4posting_fk
	foreign key(posting) references accounting_document_posting_data(id) on delete cascade on update cascade;
create unique index idx_accounting_document_creation_version on accounting_document_creation_data(id, version);

create unique index idx_accounting_document_confirmation_version on accounting_document_confirmation_data(id, version);

create unique index idx_accounting_document_auditing_version on accounting_document_auditing_data(id, version);

create unique index idx_accounting_document_posting_version on accounting_document_posting_data(id, version);

create unique index idx_original_voucher_version on original_voucher_data(id, version);

alter table original_voucher_data add constraint original_voucher4belongs_to_fk
	foreign key(belongs_to) references accounting_document_data(id) on delete cascade on update cascade;
alter table original_voucher_data add constraint original_voucher4creation_fk
	foreign key(creation) references original_voucher_creation_data(id) on delete cascade on update cascade;
alter table original_voucher_data add constraint original_voucher4confirmation_fk
	foreign key(confirmation) references original_voucher_confirmation_data(id) on delete cascade on update cascade;
alter table original_voucher_data add constraint original_voucher4auditing_fk
	foreign key(auditing) references original_voucher_auditing_data(id) on delete cascade on update cascade;
create unique index idx_original_voucher_creation_version on original_voucher_creation_data(id, version);

create unique index idx_original_voucher_confirmation_version on original_voucher_confirmation_data(id, version);

create unique index idx_original_voucher_auditing_version on original_voucher_auditing_data(id, version);

create unique index idx_accounting_document_line_version on accounting_document_line_data(id, version);

alter table accounting_document_line_data add constraint accounting_document_line4belongs_to_fk
	foreign key(belongs_to) references accounting_document_data(id) on delete cascade on update cascade;
alter table accounting_document_line_data add constraint accounting_document_line4accounting_subject_fk
	foreign key(accounting_subject) references accounting_subject_data(id) on delete cascade on update cascade;
create unique index idx_level_one_department_version on level_one_department_data(id, version);

alter table level_one_department_data add constraint level_one_department4belongs_to_fk
	foreign key(belongs_to) references retail_store_country_center_data(id) on delete cascade on update cascade;
create unique index idx_level_two_department_version on level_two_department_data(id, version);

alter table level_two_department_data add constraint level_two_department4belongs_to_fk
	foreign key(belongs_to) references level_one_department_data(id) on delete cascade on update cascade;
create unique index idx_level_three_department_version on level_three_department_data(id, version);

alter table level_three_department_data add constraint level_three_department4belongs_to_fk
	foreign key(belongs_to) references level_two_department_data(id) on delete cascade on update cascade;
create unique index idx_skill_type_version on skill_type_data(id, version);

alter table skill_type_data add constraint skill_type4company_fk
	foreign key(company) references retail_store_country_center_data(id) on delete cascade on update cascade;
create unique index idx_responsibility_type_version on responsibility_type_data(id, version);

alter table responsibility_type_data add constraint responsibility_type4company_fk
	foreign key(company) references retail_store_country_center_data(id) on delete cascade on update cascade;
create unique index idx_termination_reason_version on termination_reason_data(id, version);

alter table termination_reason_data add constraint termination_reason4company_fk
	foreign key(company) references retail_store_country_center_data(id) on delete cascade on update cascade;
create unique index idx_termination_type_version on termination_type_data(id, version);

alter table termination_type_data add constraint termination_type4company_fk
	foreign key(company) references retail_store_country_center_data(id) on delete cascade on update cascade;
create unique index idx_occupation_type_version on occupation_type_data(id, version);

alter table occupation_type_data add constraint occupation_type4company_fk
	foreign key(company) references retail_store_country_center_data(id) on delete cascade on update cascade;
create unique index idx_leave_type_version on leave_type_data(id, version);

alter table leave_type_data add constraint leave_type4company_fk
	foreign key(company) references retail_store_country_center_data(id) on delete cascade on update cascade;
create unique index idx_salary_grade_version on salary_grade_data(id, version);

alter table salary_grade_data add constraint salary_grade4company_fk
	foreign key(company) references retail_store_country_center_data(id) on delete cascade on update cascade;
create unique index idx_interview_type_version on interview_type_data(id, version);

alter table interview_type_data add constraint interview_type4company_fk
	foreign key(company) references retail_store_country_center_data(id) on delete cascade on update cascade;
create unique index idx_training_course_type_version on training_course_type_data(id, version);

alter table training_course_type_data add constraint training_course_type4company_fk
	foreign key(company) references retail_store_country_center_data(id) on delete cascade on update cascade;
create unique index idx_public_holiday_version on public_holiday_data(id, version);

alter table public_holiday_data add constraint public_holiday4company_fk
	foreign key(company) references retail_store_country_center_data(id) on delete cascade on update cascade;
create unique index idx_termination_version on termination_data(id, version);

alter table termination_data add constraint termination4reason_fk
	foreign key(reason) references termination_reason_data(id) on delete cascade on update cascade;
alter table termination_data add constraint termination4type_fk
	foreign key(type) references termination_type_data(id) on delete cascade on update cascade;
create unique index idx_view_version on view_data(id, version);

create unique index idx_employee_version on employee_data(id, version);

alter table employee_data add constraint employee4company_fk
	foreign key(company) references retail_store_country_center_data(id) on delete cascade on update cascade;
alter table employee_data add constraint employee4department_fk
	foreign key(department) references level_three_department_data(id) on delete cascade on update cascade;
alter table employee_data add constraint employee4occupation_fk
	foreign key(occupation) references occupation_type_data(id) on delete cascade on update cascade;
alter table employee_data add constraint employee4responsible_for_fk
	foreign key(responsible_for) references responsibility_type_data(id) on delete cascade on update cascade;
alter table employee_data add constraint employee4current_salary_grade_fk
	foreign key(current_salary_grade) references salary_grade_data(id) on delete cascade on update cascade;
alter table employee_data add constraint employee4job_application_fk
	foreign key(job_application) references job_application_data(id) on delete cascade on update cascade;
alter table employee_data add constraint employee4profession_interview_fk
	foreign key(profession_interview) references profession_interview_data(id) on delete cascade on update cascade;
alter table employee_data add constraint employee4hr_interview_fk
	foreign key(hr_interview) references hr_interview_data(id) on delete cascade on update cascade;
alter table employee_data add constraint employee4offer_approval_fk
	foreign key(offer_approval) references offer_approval_data(id) on delete cascade on update cascade;
alter table employee_data add constraint employee4offer_acceptance_fk
	foreign key(offer_acceptance) references offer_acceptance_data(id) on delete cascade on update cascade;
alter table employee_data add constraint employee4employee_boarding_fk
	foreign key(employee_boarding) references employee_boarding_data(id) on delete cascade on update cascade;
alter table employee_data add constraint employee4termination_fk
	foreign key(termination) references termination_data(id) on delete cascade on update cascade;
create unique index idx_job_application_version on job_application_data(id, version);

create unique index idx_profession_interview_version on profession_interview_data(id, version);

create unique index idx_hr_interview_version on hr_interview_data(id, version);

create unique index idx_offer_approval_version on offer_approval_data(id, version);

create unique index idx_offer_acceptance_version on offer_acceptance_data(id, version);

create unique index idx_employee_boarding_version on employee_boarding_data(id, version);

create unique index idx_instructor_version on instructor_data(id, version);

alter table instructor_data add constraint instructor4company_fk
	foreign key(company) references retail_store_country_center_data(id) on delete cascade on update cascade;
create unique index idx_company_training_version on company_training_data(id, version);

alter table company_training_data add constraint company_training4company_fk
	foreign key(company) references retail_store_country_center_data(id) on delete cascade on update cascade;
alter table company_training_data add constraint company_training4instructor_fk
	foreign key(instructor) references instructor_data(id) on delete cascade on update cascade;
alter table company_training_data add constraint company_training4training_course_type_fk
	foreign key(training_course_type) references training_course_type_data(id) on delete cascade on update cascade;
create unique index idx_scoring_version on scoring_data(id, version);

create unique index idx_employee_company_training_version on employee_company_training_data(id, version);

alter table employee_company_training_data add constraint employee_company_training4employee_fk
	foreign key(employee) references employee_data(id) on delete cascade on update cascade;
alter table employee_company_training_data add constraint employee_company_training4training_fk
	foreign key(training) references company_training_data(id) on delete cascade on update cascade;
alter table employee_company_training_data add constraint employee_company_training4scoring_fk
	foreign key(scoring) references scoring_data(id) on delete cascade on update cascade;
create unique index idx_employee_skill_version on employee_skill_data(id, version);

alter table employee_skill_data add constraint employee_skill4employee_fk
	foreign key(employee) references employee_data(id) on delete cascade on update cascade;
alter table employee_skill_data add constraint employee_skill4skill_type_fk
	foreign key(skill_type) references skill_type_data(id) on delete cascade on update cascade;
create unique index idx_employee_performance_version on employee_performance_data(id, version);

alter table employee_performance_data add constraint employee_performance4employee_fk
	foreign key(employee) references employee_data(id) on delete cascade on update cascade;
create unique index idx_employee_work_experience_version on employee_work_experience_data(id, version);

alter table employee_work_experience_data add constraint employee_work_experience4employee_fk
	foreign key(employee) references employee_data(id) on delete cascade on update cascade;
create unique index idx_employee_leave_version on employee_leave_data(id, version);

alter table employee_leave_data add constraint employee_leave4who_fk
	foreign key(who) references employee_data(id) on delete cascade on update cascade;
alter table employee_leave_data add constraint employee_leave4type_fk
	foreign key(type) references leave_type_data(id) on delete cascade on update cascade;
create unique index idx_employee_interview_version on employee_interview_data(id, version);

alter table employee_interview_data add constraint employee_interview4employee_fk
	foreign key(employee) references employee_data(id) on delete cascade on update cascade;
alter table employee_interview_data add constraint employee_interview4interview_type_fk
	foreign key(interview_type) references interview_type_data(id) on delete cascade on update cascade;
create unique index idx_employee_attendance_version on employee_attendance_data(id, version);

alter table employee_attendance_data add constraint employee_attendance4employee_fk
	foreign key(employee) references employee_data(id) on delete cascade on update cascade;
create unique index idx_employee_qualifier_version on employee_qualifier_data(id, version);

alter table employee_qualifier_data add constraint employee_qualifier4employee_fk
	foreign key(employee) references employee_data(id) on delete cascade on update cascade;
create unique index idx_employee_education_version on employee_education_data(id, version);

alter table employee_education_data add constraint employee_education4employee_fk
	foreign key(employee) references employee_data(id) on delete cascade on update cascade;
create unique index idx_employee_award_version on employee_award_data(id, version);

alter table employee_award_data add constraint employee_award4employee_fk
	foreign key(employee) references employee_data(id) on delete cascade on update cascade;
create unique index idx_employee_salary_sheet_version on employee_salary_sheet_data(id, version);

alter table employee_salary_sheet_data add constraint employee_salary_sheet4employee_fk
	foreign key(employee) references employee_data(id) on delete cascade on update cascade;
alter table employee_salary_sheet_data add constraint employee_salary_sheet4current_salary_grade_fk
	foreign key(current_salary_grade) references salary_grade_data(id) on delete cascade on update cascade;
alter table employee_salary_sheet_data add constraint employee_salary_sheet4paying_off_fk
	foreign key(paying_off) references paying_off_data(id) on delete cascade on update cascade;
create unique index idx_paying_off_version on paying_off_data(id, version);

alter table paying_off_data add constraint paying_off4paid_for_fk
	foreign key(paid_for) references employee_data(id) on delete cascade on update cascade;
create unique index idx_user_domain_version on user_domain_data(id, version);

create unique index idx_user_white_list_version on user_white_list_data(id, version);

alter table user_white_list_data add constraint user_white_list4domain_fk
	foreign key(domain) references user_domain_data(id) on delete cascade on update cascade;
create unique index idx_sec_user_version on sec_user_data(id, version);

alter table sec_user_data add constraint sec_user4domain_fk
	foreign key(domain) references user_domain_data(id) on delete cascade on update cascade;
alter table sec_user_data add constraint sec_user4blocking_fk
	foreign key(blocking) references sec_user_blocking_data(id) on delete cascade on update cascade;
create unique index idx_sec_user_blocking_version on sec_user_blocking_data(id, version);

create unique index idx_user_app_version on user_app_data(id, version);

alter table user_app_data add constraint user_app4sec_user_fk
	foreign key(sec_user) references sec_user_data(id) on delete cascade on update cascade;
create unique index idx_list_access_version on list_access_data(id, version);

alter table list_access_data add constraint list_access4app_fk
	foreign key(app) references user_app_data(id) on delete cascade on update cascade;
create unique index idx_object_access_version on object_access_data(id, version);

alter table object_access_data add constraint object_access4app_fk
	foreign key(app) references user_app_data(id) on delete cascade on update cascade;
create unique index idx_login_history_version on login_history_data(id, version);

alter table login_history_data add constraint login_history4sec_user_fk
	foreign key(sec_user) references sec_user_data(id) on delete cascade on update cascade;
create unique index idx_generic_form_version on generic_form_data(id, version);

create unique index idx_form_message_version on form_message_data(id, version);

alter table form_message_data add constraint form_message4form_fk
	foreign key(form) references generic_form_data(id) on delete cascade on update cascade;
create unique index idx_form_field_message_version on form_field_message_data(id, version);

alter table form_field_message_data add constraint form_field_message4form_fk
	foreign key(form) references generic_form_data(id) on delete cascade on update cascade;
create unique index idx_form_field_version on form_field_data(id, version);

alter table form_field_data add constraint form_field4form_fk
	foreign key(form) references generic_form_data(id) on delete cascade on update cascade;
create unique index idx_form_action_version on form_action_data(id, version);

alter table form_action_data add constraint form_action4form_fk
	foreign key(form) references generic_form_data(id) on delete cascade on update cascade;
-- create extra index for time, number and mobile phone

create index retail_store_country_center4founded_idx on retail_store_country_center_data(founded);
create index retail_store_country_center4version_idx on retail_store_country_center_data(version);
create index catalog4version_idx on catalog_data(version);
create index level_one_category4version_idx on level_one_category_data(version);
create index level_two_category4version_idx on level_two_category_data(version);
create index level_three_category4version_idx on level_three_category_data(version);
create index product4last_update_time_idx on product_data(last_update_time);
create index product4version_idx on product_data(version);
create index sku4price_idx on sku_data(price);
create index sku4version_idx on sku_data(version);
create index retail_store_province_center4founded_idx on retail_store_province_center_data(founded);
create index retail_store_province_center4last_update_time_idx on retail_store_province_center_data(last_update_time);
create index retail_store_province_center4version_idx on retail_store_province_center_data(version);
create index province_center_department4founded_idx on province_center_department_data(founded);
create index province_center_department4version_idx on province_center_department_data(version);
create index province_center_employee4mobile_idx on province_center_employee_data(mobile);
create index province_center_employee4founded_idx on province_center_employee_data(founded);
create index province_center_employee4version_idx on province_center_employee_data(version);
create index retail_store_city_service_center4founded_idx on retail_store_city_service_center_data(founded);
create index retail_store_city_service_center4last_update_time_idx on retail_store_city_service_center_data(last_update_time);
create index retail_store_city_service_center4version_idx on retail_store_city_service_center_data(version);
create index city_partner4mobile_idx on city_partner_data(mobile);
create index city_partner4last_update_time_idx on city_partner_data(last_update_time);
create index city_partner4version_idx on city_partner_data(version);
create index potential_customer4mobile_idx on potential_customer_data(mobile);
create index potential_customer4last_update_time_idx on potential_customer_data(last_update_time);
create index potential_customer4version_idx on potential_customer_data(version);
create index potential_customer_contact_person4mobile_idx on potential_customer_contact_person_data(mobile);
create index potential_customer_contact_person4version_idx on potential_customer_contact_person_data(version);
create index potential_customer_contact4contact_date_idx on potential_customer_contact_data(contact_date);
create index potential_customer_contact4last_update_time_idx on potential_customer_contact_data(last_update_time);
create index potential_customer_contact4version_idx on potential_customer_contact_data(version);
create index city_event4mobile_idx on city_event_data(mobile);
create index city_event4last_update_time_idx on city_event_data(last_update_time);
create index city_event4version_idx on city_event_data(version);
create index event_attendance4version_idx on event_attendance_data(version);
create index retail_store4founded_idx on retail_store_data(founded);
create index retail_store4latitude_idx on retail_store_data(latitude);
create index retail_store4longitude_idx on retail_store_data(longitude);
create index retail_store4last_update_time_idx on retail_store_data(last_update_time);
create index retail_store4version_idx on retail_store_data(version);
create index retail_store_creation4version_idx on retail_store_creation_data(version);
create index retail_store_investment_invitation4version_idx on retail_store_investment_invitation_data(version);
create index retail_store_franchising4version_idx on retail_store_franchising_data(version);
create index retail_store_decoration4version_idx on retail_store_decoration_data(version);
create index retail_store_opening4version_idx on retail_store_opening_data(version);
create index retail_store_closing4version_idx on retail_store_closing_data(version);
create index retail_store_member4mobile_phone_idx on retail_store_member_data(mobile_phone);
create index retail_store_member4version_idx on retail_store_member_data(version);
create index consumer_order4last_update_time_idx on consumer_order_data(last_update_time);
create index consumer_order4version_idx on consumer_order_data(version);
create index consumer_order_confirmation4confirm_time_idx on consumer_order_confirmation_data(confirm_time);
create index consumer_order_confirmation4version_idx on consumer_order_confirmation_data(version);
create index consumer_order_approval4approve_time_idx on consumer_order_approval_data(approve_time);
create index consumer_order_approval4version_idx on consumer_order_approval_data(version);
create index consumer_order_processing4process_time_idx on consumer_order_processing_data(process_time);
create index consumer_order_processing4version_idx on consumer_order_processing_data(version);
create index consumer_order_shipment4ship_time_idx on consumer_order_shipment_data(ship_time);
create index consumer_order_shipment4version_idx on consumer_order_shipment_data(version);
create index consumer_order_delivery4delivery_time_idx on consumer_order_delivery_data(delivery_time);
create index consumer_order_delivery4version_idx on consumer_order_delivery_data(version);
create index consumer_order_line_item4sku_id_idx on consumer_order_line_item_data(sku_id);
create index consumer_order_line_item4price_idx on consumer_order_line_item_data(price);
create index consumer_order_line_item4quantity_idx on consumer_order_line_item_data(quantity);
create index consumer_order_line_item4amount_idx on consumer_order_line_item_data(amount);
create index consumer_order_line_item4last_update_time_idx on consumer_order_line_item_data(last_update_time);
create index consumer_order_line_item4version_idx on consumer_order_line_item_data(version);
create index consumer_order_shipping_group4amount_idx on consumer_order_shipping_group_data(amount);
create index consumer_order_shipping_group4version_idx on consumer_order_shipping_group_data(version);
create index consumer_order_payment_group4version_idx on consumer_order_payment_group_data(version);
create index consumer_order_price_adjustment4amount_idx on consumer_order_price_adjustment_data(amount);
create index consumer_order_price_adjustment4version_idx on consumer_order_price_adjustment_data(version);
create index retail_store_member_coupon4last_update_time_idx on retail_store_member_coupon_data(last_update_time);
create index retail_store_member_coupon4version_idx on retail_store_member_coupon_data(version);
create index member_wishlist4version_idx on member_wishlist_data(version);
create index member_reward_point4point_idx on member_reward_point_data(point);
create index member_reward_point4version_idx on member_reward_point_data(version);
create index member_reward_point_redemption4point_idx on member_reward_point_redemption_data(point);
create index member_reward_point_redemption4version_idx on member_reward_point_redemption_data(version);
create index member_wishlist_product4version_idx on member_wishlist_product_data(version);
create index retail_store_member_address4mobile_phone_idx on retail_store_member_address_data(mobile_phone);
create index retail_store_member_address4version_idx on retail_store_member_address_data(version);
create index retail_store_member_gift_card4remain_idx on retail_store_member_gift_card_data(remain);
create index retail_store_member_gift_card4version_idx on retail_store_member_gift_card_data(version);
create index retail_store_member_gift_card_consume_record4occure_time_idx on retail_store_member_gift_card_consume_record_data(occure_time);
create index retail_store_member_gift_card_consume_record4amount_idx on retail_store_member_gift_card_consume_record_data(amount);
create index retail_store_member_gift_card_consume_record4version_idx on retail_store_member_gift_card_consume_record_data(version);
create index goods_supplier4contact_number_idx on goods_supplier_data(contact_number);
create index goods_supplier4last_update_time_idx on goods_supplier_data(last_update_time);
create index goods_supplier4version_idx on goods_supplier_data(version);
create index supplier_product4version_idx on supplier_product_data(version);
create index product_supply_duration4quantity_idx on product_supply_duration_data(quantity);
create index product_supply_duration4price_idx on product_supply_duration_data(price);
create index product_supply_duration4version_idx on product_supply_duration_data(version);
create index supply_order4total_amount_idx on supply_order_data(total_amount);
create index supply_order4last_update_time_idx on supply_order_data(last_update_time);
create index supply_order4version_idx on supply_order_data(version);
create index supply_order_confirmation4confirm_time_idx on supply_order_confirmation_data(confirm_time);
create index supply_order_confirmation4version_idx on supply_order_confirmation_data(version);
create index supply_order_approval4approve_time_idx on supply_order_approval_data(approve_time);
create index supply_order_approval4version_idx on supply_order_approval_data(version);
create index supply_order_processing4process_time_idx on supply_order_processing_data(process_time);
create index supply_order_processing4version_idx on supply_order_processing_data(version);
create index supply_order_picking4process_time_idx on supply_order_picking_data(process_time);
create index supply_order_picking4version_idx on supply_order_picking_data(version);
create index supply_order_shipment4ship_time_idx on supply_order_shipment_data(ship_time);
create index supply_order_shipment4version_idx on supply_order_shipment_data(version);
create index supply_order_delivery4delivery_time_idx on supply_order_delivery_data(delivery_time);
create index supply_order_delivery4version_idx on supply_order_delivery_data(version);
create index supply_order_line_item4sku_id_idx on supply_order_line_item_data(sku_id);
create index supply_order_line_item4amount_idx on supply_order_line_item_data(amount);
create index supply_order_line_item4quantity_idx on supply_order_line_item_data(quantity);
create index supply_order_line_item4version_idx on supply_order_line_item_data(version);
create index supply_order_shipping_group4amount_idx on supply_order_shipping_group_data(amount);
create index supply_order_shipping_group4version_idx on supply_order_shipping_group_data(version);
create index supply_order_payment_group4version_idx on supply_order_payment_group_data(version);
create index retail_store_order4total_amount_idx on retail_store_order_data(total_amount);
create index retail_store_order4last_update_time_idx on retail_store_order_data(last_update_time);
create index retail_store_order4version_idx on retail_store_order_data(version);
create index retail_store_order_confirmation4confirm_time_idx on retail_store_order_confirmation_data(confirm_time);
create index retail_store_order_confirmation4version_idx on retail_store_order_confirmation_data(version);
create index retail_store_order_approval4approve_time_idx on retail_store_order_approval_data(approve_time);
create index retail_store_order_approval4version_idx on retail_store_order_approval_data(version);
create index retail_store_order_processing4process_time_idx on retail_store_order_processing_data(process_time);
create index retail_store_order_processing4version_idx on retail_store_order_processing_data(version);
create index retail_store_order_picking4process_time_idx on retail_store_order_picking_data(process_time);
create index retail_store_order_picking4version_idx on retail_store_order_picking_data(version);
create index retail_store_order_shipment4ship_time_idx on retail_store_order_shipment_data(ship_time);
create index retail_store_order_shipment4version_idx on retail_store_order_shipment_data(version);
create index retail_store_order_delivery4delivery_time_idx on retail_store_order_delivery_data(delivery_time);
create index retail_store_order_delivery4version_idx on retail_store_order_delivery_data(version);
create index retail_store_order_line_item4sku_id_idx on retail_store_order_line_item_data(sku_id);
create index retail_store_order_line_item4amount_idx on retail_store_order_line_item_data(amount);
create index retail_store_order_line_item4quantity_idx on retail_store_order_line_item_data(quantity);
create index retail_store_order_line_item4version_idx on retail_store_order_line_item_data(version);
create index retail_store_order_shipping_group4amount_idx on retail_store_order_shipping_group_data(amount);
create index retail_store_order_shipping_group4version_idx on retail_store_order_shipping_group_data(version);
create index retail_store_order_payment_group4version_idx on retail_store_order_payment_group_data(version);
create index warehouse4latitude_idx on warehouse_data(latitude);
create index warehouse4longitude_idx on warehouse_data(longitude);
create index warehouse4last_update_time_idx on warehouse_data(last_update_time);
create index warehouse4version_idx on warehouse_data(version);
create index storage_space4latitude_idx on storage_space_data(latitude);
create index storage_space4longitude_idx on storage_space_data(longitude);
create index storage_space4last_update_time_idx on storage_space_data(last_update_time);
create index storage_space4version_idx on storage_space_data(version);
create index smart_pallet4latitude_idx on smart_pallet_data(latitude);
create index smart_pallet4longitude_idx on smart_pallet_data(longitude);
create index smart_pallet4last_update_time_idx on smart_pallet_data(last_update_time);
create index smart_pallet4version_idx on smart_pallet_data(version);
create index goods_shelf4last_update_time_idx on goods_shelf_data(last_update_time);
create index goods_shelf4version_idx on goods_shelf_data(version);
create index goods_shelf_stock_count4count_time_idx on goods_shelf_stock_count_data(count_time);
create index goods_shelf_stock_count4version_idx on goods_shelf_stock_count_data(version);
create index stock_count_issue_track4count_time_idx on stock_count_issue_track_data(count_time);
create index stock_count_issue_track4version_idx on stock_count_issue_track_data(version);
create index goods_allocation4latitude_idx on goods_allocation_data(latitude);
create index goods_allocation4longitude_idx on goods_allocation_data(longitude);
create index goods_allocation4version_idx on goods_allocation_data(version);
create index goods4max_package_idx on goods_data(max_package);
create index goods4expire_time_idx on goods_data(expire_time);
create index goods4version_idx on goods_data(version);
create index goods_packaging4package_time_idx on goods_packaging_data(package_time);
create index goods_packaging4version_idx on goods_packaging_data(version);
create index goods_movement4move_time_idx on goods_movement_data(move_time);
create index goods_movement4facility_id_idx on goods_movement_data(facility_id);
create index goods_movement4session_id_idx on goods_movement_data(session_id);
create index goods_movement4latitude_idx on goods_movement_data(latitude);
create index goods_movement4longitude_idx on goods_movement_data(longitude);
create index goods_movement4version_idx on goods_movement_data(version);
create index supplier_space4latitude_idx on supplier_space_data(latitude);
create index supplier_space4longitude_idx on supplier_space_data(longitude);
create index supplier_space4last_update_time_idx on supplier_space_data(last_update_time);
create index supplier_space4version_idx on supplier_space_data(version);
create index receiving_space4latitude_idx on receiving_space_data(latitude);
create index receiving_space4longitude_idx on receiving_space_data(longitude);
create index receiving_space4last_update_time_idx on receiving_space_data(last_update_time);
create index receiving_space4version_idx on receiving_space_data(version);
create index shipping_space4latitude_idx on shipping_space_data(latitude);
create index shipping_space4longitude_idx on shipping_space_data(longitude);
create index shipping_space4last_update_time_idx on shipping_space_data(last_update_time);
create index shipping_space4version_idx on shipping_space_data(version);
create index damage_space4latitude_idx on damage_space_data(latitude);
create index damage_space4longitude_idx on damage_space_data(longitude);
create index damage_space4last_update_time_idx on damage_space_data(last_update_time);
create index damage_space4version_idx on damage_space_data(version);
create index warehouse_asset4last_update_time_idx on warehouse_asset_data(last_update_time);
create index warehouse_asset4version_idx on warehouse_asset_data(version);
create index transport_fleet4last_update_time_idx on transport_fleet_data(last_update_time);
create index transport_fleet4version_idx on transport_fleet_data(version);
create index transport_truck4make_date_idx on transport_truck_data(make_date);
create index transport_truck4version_idx on transport_truck_data(version);
create index truck_driver4contact_number_idx on truck_driver_data(contact_number);
create index truck_driver4version_idx on truck_driver_data(version);
create index transport_task4begin_time_idx on transport_task_data(begin_time);
create index transport_task4latitude_idx on transport_task_data(latitude);
create index transport_task4longitude_idx on transport_task_data(longitude);
create index transport_task4version_idx on transport_task_data(version);
create index transport_task_track4track_time_idx on transport_task_track_data(track_time);
create index transport_task_track4latitude_idx on transport_task_track_data(latitude);
create index transport_task_track4longitude_idx on transport_task_track_data(longitude);
create index transport_task_track4version_idx on transport_task_track_data(version);
create index account_set4effective_date_idx on account_set_data(effective_date);
create index account_set4last_update_time_idx on account_set_data(last_update_time);
create index account_set4version_idx on account_set_data(version);
create index accounting_subject4accounting_subject_class_code_idx on accounting_subject_data(accounting_subject_class_code);
create index accounting_subject4version_idx on accounting_subject_data(version);
create index accounting_period4start_date_idx on accounting_period_data(start_date);
create index accounting_period4end_date_idx on accounting_period_data(end_date);
create index accounting_period4version_idx on accounting_period_data(version);
create index accounting_document_type4version_idx on accounting_document_type_data(version);
create index accounting_document4accounting_document_date_idx on accounting_document_data(accounting_document_date);
create index accounting_document4version_idx on accounting_document_data(version);
create index accounting_document_creation4make_date_idx on accounting_document_creation_data(make_date);
create index accounting_document_creation4version_idx on accounting_document_creation_data(version);
create index accounting_document_confirmation4make_date_idx on accounting_document_confirmation_data(make_date);
create index accounting_document_confirmation4version_idx on accounting_document_confirmation_data(version);
create index accounting_document_auditing4make_date_idx on accounting_document_auditing_data(make_date);
create index accounting_document_auditing4version_idx on accounting_document_auditing_data(version);
create index accounting_document_posting4make_date_idx on accounting_document_posting_data(make_date);
create index accounting_document_posting4version_idx on accounting_document_posting_data(version);
create index original_voucher4version_idx on original_voucher_data(version);
create index original_voucher_creation4make_date_idx on original_voucher_creation_data(make_date);
create index original_voucher_creation4version_idx on original_voucher_creation_data(version);
create index original_voucher_confirmation4make_date_idx on original_voucher_confirmation_data(make_date);
create index original_voucher_confirmation4version_idx on original_voucher_confirmation_data(version);
create index original_voucher_auditing4make_date_idx on original_voucher_auditing_data(make_date);
create index original_voucher_auditing4version_idx on original_voucher_auditing_data(version);
create index accounting_document_line4amount_idx on accounting_document_line_data(amount);
create index accounting_document_line4version_idx on accounting_document_line_data(version);
create index level_one_department4founded_idx on level_one_department_data(founded);
create index level_one_department4version_idx on level_one_department_data(version);
create index level_two_department4founded_idx on level_two_department_data(founded);
create index level_two_department4version_idx on level_two_department_data(version);
create index level_three_department4founded_idx on level_three_department_data(founded);
create index level_three_department4version_idx on level_three_department_data(version);
create index skill_type4version_idx on skill_type_data(version);
create index responsibility_type4version_idx on responsibility_type_data(version);
create index termination_reason4version_idx on termination_reason_data(version);
create index termination_type4version_idx on termination_type_data(version);
create index occupation_type4version_idx on occupation_type_data(version);
create index leave_type4version_idx on leave_type_data(version);
create index salary_grade4version_idx on salary_grade_data(version);
create index interview_type4version_idx on interview_type_data(version);
create index training_course_type4version_idx on training_course_type_data(version);
create index public_holiday4version_idx on public_holiday_data(version);
create index termination4version_idx on termination_data(version);
create index view4interview_time_idx on view_data(interview_time);
create index view4version_idx on view_data(version);
create index employee4cell_phone_idx on employee_data(cell_phone);
create index employee4last_update_time_idx on employee_data(last_update_time);
create index employee4version_idx on employee_data(version);
create index job_application4application_time_idx on job_application_data(application_time);
create index job_application4version_idx on job_application_data(version);
create index profession_interview4interview_time_idx on profession_interview_data(interview_time);
create index profession_interview4version_idx on profession_interview_data(version);
create index hr_interview4interview_time_idx on hr_interview_data(interview_time);
create index hr_interview4version_idx on hr_interview_data(version);
create index offer_approval4approve_time_idx on offer_approval_data(approve_time);
create index offer_approval4version_idx on offer_approval_data(version);
create index offer_acceptance4accept_time_idx on offer_acceptance_data(accept_time);
create index offer_acceptance4version_idx on offer_acceptance_data(version);
create index employee_boarding4employ_time_idx on employee_boarding_data(employ_time);
create index employee_boarding4version_idx on employee_boarding_data(version);
create index instructor4cell_phone_idx on instructor_data(cell_phone);
create index instructor4last_update_time_idx on instructor_data(last_update_time);
create index instructor4version_idx on instructor_data(version);
create index company_training4time_start_idx on company_training_data(time_start);
create index company_training4duration_hours_idx on company_training_data(duration_hours);
create index company_training4last_update_time_idx on company_training_data(last_update_time);
create index company_training4version_idx on company_training_data(version);
create index scoring4score_idx on scoring_data(score);
create index scoring4version_idx on scoring_data(version);
create index employee_company_training4version_idx on employee_company_training_data(version);
create index employee_skill4version_idx on employee_skill_data(version);
create index employee_performance4version_idx on employee_performance_data(version);
create index employee_work_experience4start_idx on employee_work_experience_data(start);
create index employee_work_experience4end_idx on employee_work_experience_data(end);
create index employee_work_experience4version_idx on employee_work_experience_data(version);
create index employee_leave4leave_duration_hour_idx on employee_leave_data(leave_duration_hour);
create index employee_leave4version_idx on employee_leave_data(version);
create index employee_interview4version_idx on employee_interview_data(version);
create index employee_attendance4enter_time_idx on employee_attendance_data(enter_time);
create index employee_attendance4leave_time_idx on employee_attendance_data(leave_time);
create index employee_attendance4duration_hours_idx on employee_attendance_data(duration_hours);
create index employee_attendance4version_idx on employee_attendance_data(version);
create index employee_qualifier4qualified_time_idx on employee_qualifier_data(qualified_time);
create index employee_qualifier4version_idx on employee_qualifier_data(version);
create index employee_education4complete_time_idx on employee_education_data(complete_time);
create index employee_education4version_idx on employee_education_data(version);
create index employee_award4complete_time_idx on employee_award_data(complete_time);
create index employee_award4version_idx on employee_award_data(version);
create index employee_salary_sheet4base_salary_idx on employee_salary_sheet_data(base_salary);
create index employee_salary_sheet4bonus_idx on employee_salary_sheet_data(bonus);
create index employee_salary_sheet4reward_idx on employee_salary_sheet_data(reward);
create index employee_salary_sheet4personal_tax_idx on employee_salary_sheet_data(personal_tax);
create index employee_salary_sheet4social_security_idx on employee_salary_sheet_data(social_security);
create index employee_salary_sheet4housing_found_idx on employee_salary_sheet_data(housing_found);
create index employee_salary_sheet4job_insurance_idx on employee_salary_sheet_data(job_insurance);
create index employee_salary_sheet4version_idx on employee_salary_sheet_data(version);
create index paying_off4paid_time_idx on paying_off_data(paid_time);
create index paying_off4amount_idx on paying_off_data(amount);
create index paying_off4version_idx on paying_off_data(version);
create index user_domain4version_idx on user_domain_data(version);
create index user_white_list4version_idx on user_white_list_data(version);
create index sec_user4mobile_idx on sec_user_data(mobile);
create index sec_user4verification_code_idx on sec_user_data(verification_code);
create index sec_user4verification_code_expire_idx on sec_user_data(verification_code_expire);
create index sec_user4last_login_time_idx on sec_user_data(last_login_time);
create index sec_user4version_idx on sec_user_data(version);
create index sec_user_blocking4block_time_idx on sec_user_blocking_data(block_time);
create index sec_user_blocking4version_idx on sec_user_blocking_data(version);
create index user_app4object_id_idx on user_app_data(object_id);
create index user_app4version_idx on user_app_data(version);
create index list_access4version_idx on list_access_data(version);
create index object_access4version_idx on object_access_data(version);
create index login_history4login_time_idx on login_history_data(login_time);
create index login_history4version_idx on login_history_data(version);
create index generic_form4version_idx on generic_form_data(version);
create index form_message4version_idx on form_message_data(version);
create index form_field_message4version_idx on form_field_message_data(version);
create index form_field4version_idx on form_field_data(version);
create index form_action4version_idx on form_action_data(version);











delete from list_access_data ;
delete from object_access_data ;
delete from user_app_data ;
delete from login_history_data ;
delete from sec_user_data ;
delete from user_domain_data ;
insert into user_domain_data values ('UD000001','用户区域','1');



insert into sec_user_data values('SU000001','User000001','13900000001','1000001@qq.com','24327F1C00D22210298A18D0DB9AA6C4C22DEAC4BEAE7C02E616442CA7764246', 'weixin_openid_000001', 'weixin_appid_000001', 'jwt_token_000001' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000001','Retail Store Country Center','SU000001','store',1,'MXWR','RetailStoreCountryCenter','RSCC000001','/link/to/app','1');
insert into user_app_data values('UA000002','我的账户','SU000001','lock',1,'MXWR','SecUser','SU000001','/link/to/app','1');
insert into sec_user_data values('SU000002','User000002','13900000002','1000002@qq.com','BB5210DAE99659C7164D7DBCFC51FB2D167D0DA372D58EF26A9F8533EEA2967C', 'weixin_openid_000002', 'weixin_appid_000002', 'jwt_token_000002' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000003','Retail Store Province Center','SU000002','store',1,'MXWR','RetailStoreProvinceCenter','RSPC000001','/link/to/app','1');
insert into user_app_data values('UA000004','我的账户','SU000002','lock',1,'MXWR','SecUser','SU000002','/link/to/app','1');
insert into sec_user_data values('SU000003','User000003','13900000003','1000003@qq.com','9D4104DF2774FDEAAE074CA35B052D8F664F4F99064C7BEAB0B589C2605C4EDA', 'weixin_openid_000003', 'weixin_appid_000003', 'jwt_token_000003' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000005','Retail Store City Service Center','SU000003','city',1,'MXWR','RetailStoreCityServiceCenter','RSCSC000001','/link/to/app','1');
insert into user_app_data values('UA000006','我的账户','SU000003','lock',1,'MXWR','SecUser','SU000003','/link/to/app','1');
insert into sec_user_data values('SU000004','User000004','13900000004','1000004@qq.com','9B223EBD008D7B544A3A640739EBE47459D3A4C5296DDA00F594FAF60FE88B28', 'weixin_openid_000004', 'weixin_appid_000004', 'jwt_token_000004' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000007','City Partner','SU000004','city',1,'MXWR','CityPartner','CP000001','/link/to/app','1');
insert into user_app_data values('UA000008','我的账户','SU000004','lock',1,'MXWR','SecUser','SU000004','/link/to/app','1');
insert into sec_user_data values('SU000005','User000005','13900000005','1000005@qq.com','AE5F93F319636A96963C06D035B97F004D18E61D80129EFEA331784A6E21DC5C', 'weixin_openid_000005', 'weixin_appid_000005', 'jwt_token_000005' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000009','Potential Customer','SU000005','om',1,'MXWR','PotentialCustomer','PC000001','/link/to/app','1');
insert into user_app_data values('UA000010','我的账户','SU000005','lock',1,'MXWR','SecUser','SU000005','/link/to/app','1');
insert into sec_user_data values('SU000006','User000006','13900000006','1000006@qq.com','5FBBDBEAD9F84D599E8819CEEA167854CDA0FFD8D297D17D12E4619CE76F3B55', 'weixin_openid_000006', 'weixin_appid_000006', 'jwt_token_000006' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000011','Retail Store','SU000006','store',1,'MXWR','RetailStore','RS000001','/link/to/app','1');
insert into user_app_data values('UA000012','我的账户','SU000006','lock',1,'MXWR','SecUser','SU000006','/link/to/app','1');
insert into sec_user_data values('SU000007','User000007','13900000007','1000007@qq.com','A9652F0D7C1ACCB421BAF55EB3E7286AFA8F591897F1AE4CEB6A76402CCBE803', 'weixin_openid_000007', 'weixin_appid_000007', 'jwt_token_000007' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000013','Retail Store Member','SU000007','store',1,'MXWR','RetailStoreMember','RSM000001','/link/to/app','1');
insert into user_app_data values('UA000014','我的账户','SU000007','lock',1,'MXWR','SecUser','SU000007','/link/to/app','1');
insert into sec_user_data values('SU000008','User000008','13900000008','1000008@qq.com','A4B83C2652CD6BECE5C7909576555B313078D7EE50AA028F26B8F0245C191B4B', 'weixin_openid_000008', 'weixin_appid_000008', 'jwt_token_000008' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000015','Consumer Order','SU000008','first-order',1,'MXWR','ConsumerOrder','CO000001','/link/to/app','1');
insert into user_app_data values('UA000016','我的账户','SU000008','lock',1,'MXWR','SecUser','SU000008','/link/to/app','1');
insert into sec_user_data values('SU000009','User000009','13900000009','1000009@qq.com','88F8AB5F153081C5AB21F5E5354B4EB14286EFB43CEA588ED1C73FE2B46B35C1', 'weixin_openid_000009', 'weixin_appid_000009', 'jwt_token_000009' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000017','Goods Supplier','SU000009','apper',1,'MXWR','GoodsSupplier','GS000001','/link/to/app','1');
insert into user_app_data values('UA000018','我的账户','SU000009','lock',1,'MXWR','SecUser','SU000009','/link/to/app','1');
insert into sec_user_data values('SU000010','User000010','13900000010','1000010@qq.com','EF8232ABB97CC3858F271527A1AA1452A33715A3AC48312A44B0940D5C948600', 'weixin_openid_000010', 'weixin_appid_000010', 'jwt_token_000010' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000019','Supply Order','SU000010','first-order',1,'MXWR','SupplyOrder','SO000001','/link/to/app','1');
insert into user_app_data values('UA000020','我的账户','SU000010','lock',1,'MXWR','SecUser','SU000010','/link/to/app','1');
insert into sec_user_data values('SU000011','User000011','13900000011','1000011@qq.com','FE7AF5D4F030CD575C117A73124FC39AB41528DFFC41D2CFBC1130E755694243', 'weixin_openid_000011', 'weixin_appid_000011', 'jwt_token_000011' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000021','Retail Store Order','SU000011','store',1,'MXWR','RetailStoreOrder','RSO000001','/link/to/app','1');
insert into user_app_data values('UA000022','我的账户','SU000011','lock',1,'MXWR','SecUser','SU000011','/link/to/app','1');
insert into sec_user_data values('SU000012','User000012','13900000012','1000012@qq.com','999DD89E35807C62458F2D191D4F55548B49245EEC6E186FE9497EC867C40088', 'weixin_openid_000012', 'weixin_appid_000012', 'jwt_token_000012' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000023','Warehouse','SU000012','warehouse',1,'MXWR','Warehouse','W000001','/link/to/app','1');
insert into user_app_data values('UA000024','我的账户','SU000012','lock',1,'MXWR','SecUser','SU000012','/link/to/app','1');
insert into sec_user_data values('SU000013','User000013','13900000013','1000013@qq.com','0AE92E17166CBB59341836C218E92EF083058CC4E3108C5FD2FB904650013A69', 'weixin_openid_000013', 'weixin_appid_000013', 'jwt_token_000013' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000025','Goods Shelf','SU000013','asterisk',1,'MXWR','GoodsShelf','GS000001','/link/to/app','1');
insert into user_app_data values('UA000026','我的账户','SU000013','lock',1,'MXWR','SecUser','SU000013','/link/to/app','1');
insert into sec_user_data values('SU000014','User000014','13900000014','1000014@qq.com','E79E64241204EB0FCE03C4BA0E315F21ECDB11D22264BE7B1AAD41D04D77A6D0', 'weixin_openid_000014', 'weixin_appid_000014', 'jwt_token_000014' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000027','Transport Fleet','SU000014','backspace',1,'MXWR','TransportFleet','TF000001','/link/to/app','1');
insert into user_app_data values('UA000028','我的账户','SU000014','lock',1,'MXWR','SecUser','SU000014','/link/to/app','1');
insert into sec_user_data values('SU000015','User000015','13900000015','1000015@qq.com','1D858671B95062DAFE1D989C089188CC4EFDF3D5C45D8F24DD20BF3E352A3D9B', 'weixin_openid_000015', 'weixin_appid_000015', 'jwt_token_000015' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000029','Transport Task','SU000015','tasks',1,'MXWR','TransportTask','TT000001','/link/to/app','1');
insert into user_app_data values('UA000030','我的账户','SU000015','lock',1,'MXWR','SecUser','SU000015','/link/to/app','1');
insert into sec_user_data values('SU000016','User000016','13900000016','1000016@qq.com','14B1F5E667F8B6697C8A2952C3619D9AD82F846E5B32FD9F258918786B3ED519', 'weixin_openid_000016', 'weixin_appid_000016', 'jwt_token_000016' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000031','Account Set','SU000016','headset',1,'MXWR','AccountSet','AS000001','/link/to/app','1');
insert into user_app_data values('UA000032','我的账户','SU000016','lock',1,'MXWR','SecUser','SU000016','/link/to/app','1');
insert into sec_user_data values('SU000017','User000017','13900000017','1000017@qq.com','1A803C7096681FC2AA7C55C46A6A99D8089481B96997774EA5B1C785C8035010', 'weixin_openid_000017', 'weixin_appid_000017', 'jwt_token_000017' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000033','Accounting Document','SU000017','basketball-ball',1,'MXWR','AccountingDocument','AD000001','/link/to/app','1');
insert into user_app_data values('UA000034','我的账户','SU000017','lock',1,'MXWR','SecUser','SU000017','/link/to/app','1');
insert into sec_user_data values('SU000018','User000018','13900000018','1000018@qq.com','FA485AC06A6BD6BBF7AC9F253FCC516227CB232598792232277A70386FD892ED', 'weixin_openid_000018', 'weixin_appid_000018', 'jwt_token_000018' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000035','Salary Grade','SU000018','ad',1,'MXWR','SalaryGrade','SG000001','/link/to/app','1');
insert into user_app_data values('UA000036','我的账户','SU000018','lock',1,'MXWR','SecUser','SU000018','/link/to/app','1');
insert into sec_user_data values('SU000019','User000019','13900000019','1000019@qq.com','A5D9532EB6FC76A7D06764C14F751A4AFBC7C5BC49C215272A2EE42BBEA1A502', 'weixin_openid_000019', 'weixin_appid_000019', 'jwt_token_000019' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000037','View','SU000019','street-view',1,'MXWR','View','V000001','/link/to/app','1');
insert into user_app_data values('UA000038','我的账户','SU000019','lock',1,'MXWR','SecUser','SU000019','/link/to/app','1');
insert into sec_user_data values('SU000020','User000020','13900000020','1000020@qq.com','7CB0B35123A314B427FC1459C4083AA314D8F9E2505BB9187594B223BE5623A0', 'weixin_openid_000020', 'weixin_appid_000020', 'jwt_token_000020' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000039','Employee','SU000020','blackberry',1,'MXWR','Employee','E000001','/link/to/app','1');
insert into user_app_data values('UA000040','我的账户','SU000020','lock',1,'MXWR','SecUser','SU000020','/link/to/app','1');
insert into sec_user_data values('SU000021','User000021','13900000021','1000021@qq.com','C21B3A395B3E337A4D06491AEC7B485523BB4E5790DE925000FECEC237F939F2', 'weixin_openid_000021', 'weixin_appid_000021', 'jwt_token_000021' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000041','User Domain','SU000021','user',1,'MXWR','UserDomain','UD000001','/link/to/app','1');
insert into user_app_data values('UA000042','我的账户','SU000021','lock',1,'MXWR','SecUser','SU000021','/link/to/app','1');
insert into sec_user_data values('SU000022','User000022','13900000022','1000022@qq.com','D6C0743E4B79BE93E8BDB4D0B55054EC3532F6B1AF8F69EDD542F0D22DD228C9', 'weixin_openid_000022', 'weixin_appid_000022', 'jwt_token_000022' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000043','Sec User','SU000022','user',1,'MXWR','SecUser','SU000001','/link/to/app','1');
insert into user_app_data values('UA000044','我的账户','SU000022','lock',1,'MXWR','SecUser','SU000022','/link/to/app','1');
insert into sec_user_data values('SU000023','User000023','13900000023','1000023@qq.com','D5405F91AA444B65AE234F0AA39FF8A43A2F0CF28F238479A0AC08D9C292629E', 'weixin_openid_000023', 'weixin_appid_000023', 'jwt_token_000023' ,'9292993','2019-09-09 09:09:09','2019-09-09 09:09:09','UD000001',NULL,'INIT',1);
insert into user_app_data values('UA000045','User App','SU000023','user',1,'MXWR','UserApp','UA000001','/link/to/app','1');
insert into user_app_data values('UA000046','我的账户','SU000023','lock',1,'MXWR','SecUser','SU000023','/link/to/app','1');

/* ------------------------------------------------------------------------ */




/*
| 角色        | 用户名           | 密码         |
| ------------- |:-------------:|:-------------------:|
|Retail Store Country Center|13900000001|DoubleChain!y1|
|Retail Store Province Center|13900000002|DoubleChain!y1|
|Retail Store City Service Center|13900000003|DoubleChain!y1|
|City Partner|13900000004|DoubleChain!y1|
|Potential Customer|13900000005|DoubleChain!y1|
|Retail Store|13900000006|DoubleChain!y1|
|Retail Store Member|13900000007|DoubleChain!y1|
|Consumer Order|13900000008|DoubleChain!y1|
|Goods Supplier|13900000009|DoubleChain!y1|
|Supply Order|13900000010|DoubleChain!y1|
|Retail Store Order|13900000011|DoubleChain!y1|
|Warehouse|13900000012|DoubleChain!y1|
|Goods Shelf|13900000013|DoubleChain!y1|
|Transport Fleet|13900000014|DoubleChain!y1|
|Transport Task|13900000015|DoubleChain!y1|
|Account Set|13900000016|DoubleChain!y1|
|Accounting Document|13900000017|DoubleChain!y1|
|Salary Grade|13900000018|DoubleChain!y1|
|View|13900000019|DoubleChain!y1|
|Employee|13900000020|DoubleChain!y1|
|User Domain|13900000021|DoubleChain!y1|
|Sec User|13900000022|DoubleChain!y1|
|User App|13900000023|DoubleChain!y1|


*/



/* start with data patch */
/* The sql file is not found from: /Users/Philip/githome/web-code-generator/sky/data-patch/retailscm.sql */


/*

+----------+---------------------------------+---------------------+--------+
| Charset  | Description                     | Default collation   | Maxlen |
+----------+---------------------------------+---------------------+--------+
| gb2312   | GB2312 Simplified Chinese       | gb2312_chinese_ci   |      2 |
| gbk      | GBK Simplified Chinese          | gbk_chinese_ci      |      2 |
| utf8mb4  | UTF-8 Unicode                   | utf8mb4_general_ci  |      4 |
| utf32    | UTF-32 Unicode                  | utf32_general_ci    |      4 |
| gb18030  | China National Standard GB18030 | gb18030_chinese_ci  |      4 |
+----------+---------------------------------+---------------------+--------+

*/

