create table DeliverInformation (
	--aaa      bbb  cc      dd       ee         123456
    --국가번호 도시 주문년  주문주차 주문자구분 주문번호
	DI_Number		char(16 byte)		not null enable,
	MS_Number
	BI_Number
	DD_Number
	PI_number
	);
select DI_Number din from DeliverInformation df;

create table MemberShip (
    --a         bb      cc      d    00000 
    --내외국인  가입년 가입주차 등급 무작위번호
	MS_Number		nchar(20 byte) 		not null enable,
	ID				nvarchar2(24 byte)  not null enable,
	Password		nvarchar2(32 byte)  not null enable,
	Name			nvarchar2(40 byte)  not null enable,
    --ResidentRegistrationNumber	
	RR_num          nchar(28 byte) 		not null enable,
	Mobile			nchar(26 byte) 		not null enable,
	Phone			nvarchar2(40 byte),
	Email			nvarchar2(50 byte),
	Address			nvarchar2(200 byte)	not null enable
);
alter table MemgerShip
    primary key (MS_Number);

create table ResidentRegistrationNumger (
    RR_num
    age
    sex


create table EmployeeID (
    --지역 지점 부서

create table EmployeeInfomation (
    

create table BookInformation (
    -- aaa      bb       ccc      d                   123.1     00
    -- 국가번호 발행년도 언어약어 지점층(지상G,지하B) KDC       기타분류
	BI_Number           nchar(42 byte)   not null primary key, 
	Title               nvarchar2(200 byte)  not null,
	author              nvarchar2(200 byte), 
	Issuer              nvarchar2(200 byte),
	Translation         nvarchar2(20 byte),
	Publisher           nvarchar2(20 byte),        
	Selling_Price       integer,
	Page                integer,
	Purchase_Price      integer,
	Inventory_Quantity  integer
);

create table Inventory_Quantity (
	Inventory_Quantity
	Inventory_Point
	Inventory_location

create table Selling_Price (
	Selling_Price
	Fixed_Price
	Discounted_Price

create table DeliveryDestination (
	DD_Number		char(16 byte)
	DT_Number		Number(1 byte)

create table DeliveryType (


alter table MemberShip
	add const\aint PK_MSNumger
	Primary Key (MS_Number);
