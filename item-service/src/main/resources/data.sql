insert into uom (name) values("gm");
insert into uom (name) values("kg");
insert into uom (name) values("liters");
insert into uom (name) values("packets");
insert into uom (name) values("unit");
insert into uom (name) values("cups");
insert into uom (name) values("ml");
insert into uom (name) values("small cups");
insert into uom (name) values("numbers");
insert into uom (name) values("roll");

insert into brand (name) values("maliban");
insert into brand (name) values("munchee");
insert into brand (name) values("uniliver");
insert into brand (name) values("elephant house");
insert into brand (name) values("Lion");
insert into brand (name) values("Ritzrery");
insert into brand (name) values("IOC");
insert into brand (name) values("Nokiya");
insert into brand (name) values("Dell");
insert into brand (name) values("Samsung");

insert into store_type  (name) values("fridge");
insert into store_type  (name) values("racks");
insert into store_type  (name) values("goni");
insert into store_type  (name) values("bags");
insert into store_type  (name) values("barrels");
insert into store_type  (name) values("cups");

insert into category (name) values("Pharmacy");
insert into category (name) values("Foods");
insert into category (name) values("Drinks");
insert into category (name) values("Cakes");
insert into category (name) values("Electronic");
insert into category (name) values("Oil");
insert into category (name) values("Vegitable");

insert into item_type (name,category_id) values("Ice cream",1);
insert into item_type (name,category_id) values("Biscute" , 1);
insert into item_type (name,category_id) values("Cool Drinks" ,1);
insert into item_type (name,category_id) values("Electrical items",1);
insert into item_type (name,category_id) values("Toys",1);



insert into batch (enter_date,expire_date,manufacture_date,quantity) values('2018-03-26 ' ,
'2018-03-26','2018-03-26',20);
insert into batch (enter_date,expire_date,manufacture_date,quantity) values('2018-03-26 ' ,
'2018-03-26','2018-03-26',20);
insert into batch (enter_date,expire_date,manufacture_date,quantity) values('2018-03-26 ' ,
'2018-03-26','2018-03-26',20);
insert into batch (enter_date,expire_date,manufacture_date,quantity) values('2018-03-26 ' ,
'2018-03-26','2018-03-26',20);
insert into batch (enter_date,expire_date,manufacture_date,quantity) values('2018-03-26 ' ,
'2018-03-26','2018-03-26',20);

insert into item (critical_level,discount,name,sales_price,unit_price,brand_id,item_type_id,store_type_id,uom_id
, max_order , re_oreder_lever ,batch_id)
values (25,20,"munchee cream ",250 ,200, 1,1,1,1,2,5,1);
insert into item (critical_level,discount,name,sales_price,unit_price,brand_id,item_type_id,store_type_id,uom_id
,max_order , re_oreder_lever,batch_id)
values (25,20,"munchee cracker",250 ,200, 1,1,1,1,25,5,1);
insert into item (critical_level,discount,name,sales_price,unit_price,brand_id,item_type_id,store_type_id,uom_id,
max_order , re_oreder_lever,batch_id)
values (25,20,"munchee chocolate",250 ,200, 1,1,1,1,5,6,1);
insert into item (critical_level,discount,name,sales_price,unit_price,brand_id,item_type_id,store_type_id,uom_id
,max_order , re_oreder_lever,batch_id)
values (25,20,"munchee chocolate smart",250 ,200, 1,1,1,1,8,9,1);
insert into item (critical_level,discount,name,sales_price,unit_price,brand_id,item_type_id,store_type_id,uom_id
,max_order , re_oreder_lever,batch_id)
values (25,20,"malibun cream cracker",250 ,200, 1,1,1,1,1,3,1);
insert into item (critical_level,discount,name,sales_price,unit_price,brand_id,item_type_id,store_type_id,uom_id
,max_order , re_oreder_lever,batch_id)
values (25,20,"malibun mari",250 ,200, 1,1,1,1,12,5,1);
insert into item (critical_level,discount,name,sales_price,unit_price,brand_id,item_type_id,store_type_id,uom_id,
max_order , re_oreder_lever,batch_id)
values (25,20,"gold mari",250 ,200, 1,1,1,1,5,2,1);
