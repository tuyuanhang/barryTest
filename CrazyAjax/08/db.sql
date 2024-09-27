drop database if exists tips;
create database tips;
use tips;

create table brand_inf
(b_id integer auto_increment,
 b_name varchar(255) not null unique,
 primary key(b_id)
);

create table model_inf
(m_id integer auto_increment,
 m_name varchar(255) not null unique,
 m_desc text,
 b_id integer,
 primary key(m_id),
 foreign key(b_id) references brand_inf(b_id)
);

insert into brand_inf(b_name) values('IBM');
insert into brand_inf(b_name) values('DELL');
insert into brand_inf(b_name) values('SONY');
insert into brand_inf(b_name) values('TOSHIBA');
insert into brand_inf(b_name) values('SAMSUNG');

#IBM
insert into model_inf(m_name , m_desc , b_id)
values('T60 2007DT2' , '������:Intel Core Duo(Yonah) T2600(2.16G)<br />�ڴ�����:1024M<br />Ӳ������:100G<br />��������:����,DVD��RW<br />��Ļ�ߴ�:14.1��<br />��ʾ������:SXGA+<br />��ʾоƬ:����,ATI Mobility Radeon X1400<br />����:Լ2.32Kg<br />����ϵͳ:Windows XP Professional' , 1);
insert into model_inf(m_name , m_desc , b_id)
values('T60p 20079EC' , '������:Intel Core Duo(Yonah) T2700(2.33G)<br />�ڴ�����:1024M<br />Ӳ������:100G<br />��������:����,Rambo<br />��Ļ�ߴ�:15.1��<br />��ʾ������:UXGA+<br />��ʾоƬ:����,ATI Mobility FireGL V5200<br />����:Լ2.81Kg<br />����ϵͳ:Windows XP Professional' , 1);
insert into model_inf(m_name , m_desc , b_id)
values('T60p 200783C ' , '������:Intel Core Duo(Yonah) T2600(2.16G)<br />�ڴ�����:1024M<br />Ӳ������:100G<br />��������:����,Rambo<br />��Ļ�ߴ�:14.1��<br />��ʾ������:SXGA+<br />��ʾоƬ:����,ATI Mobility FireGL V5200<br />����:Լ2.49Kg<br />����ϵͳ:Windows XP Professional' , 1);
#DELL
insert into model_inf(m_name , m_desc , b_id)
values('���� Inspiron 9400(N511010)' , '������:Intel Core2 Duo(Merom) T5600(1.83G)<br />�ڴ�����:1024M<br />Ӳ������:120G<br />��������:����,DVD��RW<br />��Ļ�ߴ�:17��<br />��ʾ������:WXGA+<br />��ʾоƬ:����,ATI Mobility Radeon X1400<br />����:Լ3.49Kg<br />����ϵͳ:Windows XP Home' , 2);
insert into model_inf(m_name , m_desc , b_id)
values('���� Inspiron 9400(N511009)' , '������:Intel Core2 Duo(Merom) T5600(1.83G)<br />�ڴ�����:1024M<br />Ӳ������:120G<br />��������:����,Combo<br />��Ļ�ߴ�:17��<br />��ʾ������:WXGA+<br />��ʾоƬ:����Intel GMA950оƬ<br />����:Լ3.49Kg<br />����ϵͳ:Windows XP Home' , 2);
insert into model_inf(m_name , m_desc , b_id)
values('���� XPS M1710(N511014)' , '������:Intel Core2 Duo(Merom) T7200(2.0G)<br />�ڴ�����:1024M<br />Ӳ������:120G<br />��������:����,DVD��RW<br />��Ļ�ߴ�:17��<br />��ʾ������:UXGA+<br />��ʾоƬ:����,nVidia Geforce Go7900GTX<br />����:Լ4.0Kg<br />����ϵͳ:Windows XP Home' , 2);
#SONY
insert into model_inf(m_name , m_desc , b_id)
values('���� VGN-UX18C' , '������:Intel Core Solo(Yonah) U1400(1.2G)<br />�ڴ�����:512M<br />Ӳ������:����16G<br />��������:�޹���<br />��Ļ�ߴ�:4.5��<br />��ʾ������:WSVGA<br />��ʾоƬ:����Intel GMA950оƬ<br />����:Լ0.480Kg<br />����ϵͳ:Windows XP Home' , 3);
insert into model_inf(m_name , m_desc , b_id)
values('���� VGN-AR18CP' , '������:Intel Core Duo(Yonah) T2600(2.16G)<br />�ڴ�����:2048M<br />Ӳ������:160G<br />��������:����,�����¼����<br />��Ļ�ߴ�:17��<br />��ʾ������:WUXGA<br />��ʾоƬ:����,nVidia Geforce Go7600GT<br />����:Լ3.8Kg<br />����ϵͳ:Windows XP Professional' , 3);
insert into model_inf(m_name , m_desc , b_id)
values('���� VGN-UX17C' , '������:Intel Celeron M 423(1.06G)<br />�ڴ�����:512M<br />Ӳ������:30G<br />��������:�޹���<br />��Ļ�ߴ�:4.5��<br />��ʾ������:WSVGA<br />��ʾоƬ:����Intel GMA950оƬ<br />����:Լ0.517Kg<br />����ϵͳ:Windows XP Home' , 3);
#TOSHIBA
insert into model_inf(m_name , m_desc , b_id)
values('��֥ Qosmio F30 PQF30Q-01U012' , '������:Intel Core Duo(Yonah) T2400(1.83G)<br />�ڴ�����:512M<br />Ӳ������:100G<br />��������:����,DVD-SuperMulti<br />��Ļ�ߴ�:15.4��<br />��ʾ������:WXGA<br />��ʾоƬ:����nVidia Geforce Go7600<br />����ģ��:���õ��ӵ�г��<br />����:Լ4.3Kg<br />����ϵͳ:Windows XP Media Center' , 4);
insert into model_inf(m_name , m_desc , b_id)
values('��֥ Qosmio E10 PQE10Q-009008' , '������:Intel Pentium M(Dothan) 735(1.7G)<br />�ڴ�����:512M<br />Ӳ������:60G<br />��������:DVD-SuperMulit<br />��Ļ�ߴ�:15��<br />��ʾ������:XGA<br />��ʾоƬ:����,nVidia Geforce 5200Go<br />����:Լ3.7Kg' , 4);
insert into model_inf(m_name , m_desc , b_id)
values('��֥ Qosmio E10 PQE10Q-015008' , '������:Intel pentium M(Dothan) 745(1.8G)<br />�ڴ�����:768M<br />Ӳ������:80G<br />��������:DVD��RW<br />��Ļ�ߴ�:15��<br />��ʾ������:XGA<br />��ʾоƬ:����,nVidia Geforce 5200Go<br />����ģ��:���õ���ģ��<br />����:Լ3.7Kg' , 4);
#SAMSUNG
insert into model_inf(m_name , m_desc , b_id)
values('���� X11-CV0F' , '������:Intel Core2 Duo(Merom) T5600(1.83G)<br />�ڴ�����:512M<br />Ӳ������:100G<br />��������:����,DVD-SuperMulti<br />��Ļ�ߴ�:14��<br />��ʾ������:WXGA<br />��ʾоƬ:����,nVidia Geforce Go7400<br />����:Լ2.2Kg<br />����ϵͳ:Windows XP Home' , 5);
insert into model_inf(m_name , m_desc , b_id)
values('���� X11-CV0B' , '������:Intel Core2 Duo(Merom) T7200(2.0G)<br />�ڴ�����:1024M<br />Ӳ������:100G<br />��������:����,DVD-SuperMulti<br />��Ļ�ߴ�:14��<br />��ʾ������:WXGA<br />��ʾоƬ:����,nVidia Geforce Go7400<br />����:Լ2.2Kg<br />����ϵͳ:Windows XP Home' , 5);
insert into model_inf(m_name , m_desc , b_id)
values('���� X11-CV0G' , '������:Intel Core2 Duo(Merom) T5500(1.66G)<br />�ڴ�����:512M<br />Ӳ������:100G<br />��������:����,DVD-SuperMulti<br />��Ļ�ߴ�:14��<br />��ʾ������:WXGA<br />��ʾоƬ:����,nVidia Geforce Go7400<br />����:Լ2.2Kg<br />����ϵͳ:Windows XP Home' , 5);
