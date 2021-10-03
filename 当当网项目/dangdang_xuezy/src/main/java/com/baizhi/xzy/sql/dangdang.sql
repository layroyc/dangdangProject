//��̨����Ա��
create table u_manage(
    id number(5) primary key,
    username varchar2(20),
    password varchar2(20)
);


//ǰ̨�û���
create table q_users(
id varchar2(50) primary key,
email varchar2(50) not null,
usename varchar2(20),
password varchar2(20),
status varchar2(20), --״̬
CDK varchar2(20), --������
regdate Date, --ע��ʱ��
salt varchar2(50) --��
);

//��ַ��
create table q_address(
id varchar2(50),
zip varchar2(20),
name varchar2(20),
address varchar2(200),
telphone varchar2(20),
u_id varchar(50)
);

//��ϵ��
create table d_item  (
   id                   VARCHAR2(40)    not null, 
   book_name         VARCHAR2(40),--��Ʒ��
   discount_price       NUMBER(8, 2),  --��Ʒ�۸�
   count                NUMBER(8), --������Ʒ����
   priceTotal             NUMBER(8, 2), --С��
   book_id              VARCHAR2(40),--ͼ��id
   order_id             VARCHAR2(40), --����id
   constraint PK_D_ITEM primary key (id)
);

/*==============================================================*/
/* Table: d_order     ������                                          */
/*==============================================================*/
create table d_order  (
   id                   VARCHAR2(40)                    not null,
   order_number         VARCHAR2(30), --���
   order_times          DATE,         --����ʱ��
   total_price          NUMERIC(12, 2),--�ܼ�
   status               VARCHAR2(20),--״̬
   name                 VARCHAR2(20), --�ջ���
   address              VARCHAR2(20),--��ַ
   user_id              VARCHAR2(40),--�û�id
   addr_id              VARCHAR2(40),--��ַid
   constraint PK_D_ORDER primary key (id)
);
select id,zip,name,address,telphone,u_id from q_address where u_id='a042cd5d-08b0-4ae3-969f-bf15a070037b';

select * from q_users;
insert into q_address values(
'2','472500','����ghh','aaaaaaaa','17896541233','a042cd5d-08b0-4ae3-969f-bf15a070037b'
);

select * from q_address;

select * from m_category;
create sequence u_manage_seq start with 1;
insert into u_manage values(u_manage_seq.nextval,'xzy','666666');
select * from u_manage;

select m2.category,b.book_name
from m_book b  join m_category m2 on b.cate_id=m2.id;

	select m1.category,m2.category
		from (m_category m1 inner join m_category m2 on m1.id=m2.parent_id) 
		join m_book b on b.cate_id=m2.id
		where b.id='97be9e2f-3683-41d2-883f-2cd1cb306cfe'


select m1.category,m2.category,b.book_name
from (m_category m1 inner join m_category m2 on m1.id=m2.parent_id) join m_book b on b.cate_id=m2.id;

select *
		from m_book where cate_id='11'
select * from m_category;

select b.*
from m_category m left join m_book b
on m.id = b.cate_id
where m.parent_id='1' and m.id='8'

select b.* 
	    from (select * from m_book order by dbms_random.value) b
	    where rownum between 1 and 2
	    
select *
from m_book
where id='105'



select b.id,b.cate_id,b.book_name,b.page_number,b.word_number,b.original_price,b.cover,b.discount_price,b.repertory,b.author,b.edit_recommend,b.publish_company,b.publish_time,b.prospectus,b.edition,b.print_time,b.author_intro,b.print_number,b.isbn,b.catalog,b.book_size,b.paper_type,b.media_comment,b.pack_type,b.sales_volume
		from m_category c inner join m_book b
		on c.id = b.cate_id
		where c.parent_id='1'


select id,username,password from u_manage where username='xzy' and password='666666';
select * from u_manage;
commit;

select * from m_book sample(10) where rownum<3; 


select book_name from m_book sample block(10) where rownum<3; 
select id,cate_id,book_name,page_number,word_number,original_price,cover,discount_price,repertory,author,edit_recommend,publish_company,publish_time,prospectus,edition,print_time,author_intro,print_number,isbn,catalog,book_size,paper_type,media_comment,pack_type,sales_volume
		from m_book sample(99) where rownum<3;
		
		select id,cate_id,book_name,page_number,word_number,original_price,cover,discount_price,repertory,author,edit_recommend,publish_company,publish_time,prospectus,edition,print_time,author_intro,print_number,isbn,catalog,book_size,paper_type,media_comment,pack_type,sales_volume
		from m_book order by print_time desc
//��̨�������
create table m_category(
   id  VARCHAR2(40) primary key not null,
   category  VARCHAR2(30),  --�����
   levels   NUMBER(1),     --�ȼ�
   parent_id   VARCHAR2(40) --�����id
);

select id,cate_id,book_name,page_number,word_number,original_price,cover,discount_price,repertory,author,edit_recommend,publish_company,publish_time,prospectus,edition,print_time,author_intro,print_number,isbn,catalog,book_size,paper_type,media_comment,pack_type,sales_volume
		from m_book order by sales_volume desc

select m1.id as mid1,m1.category as mcategory1,m1.levels as mlevels1,m1.parent_id as parent_id1,
		       m2.id as mid2,m2.category as mcategory2,m2.levels as mlevels2,m2.parent_id as parent_id2
		from m_category m1 join m_category m2 on m1.id=m2.parent_id

select * from m_category;
create sequence m_category_seq start with 1;
drop sequence m_category_seq;

insert into m_category values('1','С˵',1,'null');
insert into m_category values('2','����',1,'null');
insert into m_category values('3','����',1,'null');
insert into m_category values('4','����',1,'null');
insert into m_category values('5','��ѧ',1,'null');
insert into m_category values('6','Ӣ��',1,'null');

insert into m_category values('7','����С˵',2,'1');
insert into m_category values('8','����С˵',2,'1');
insert into m_category values('9','��ԽС˵',2,'1');
insert into m_category values('10','����С˵',2,'1');
insert into m_category values('11','У԰С˵',2,'1');

insert into m_category values('12','���μ�',2,'2');
insert into m_category values('13','ˮ䰴�',2,'2');
insert into m_category values('14','��¥��',2,'2');
insert into m_category values('15','��������',2,'2');

insert into m_category values('16','����ƪ',2,'3');
insert into m_category values('17','�٤ƪ',2,'3');
insert into m_category values('18','������Ӿ�˽�һ��',2,'3');

insert into m_category values('19','������ʮ����',2,'4');

insert into m_category values('20','����',2,'5');
insert into m_category values('21','����',2,'5');
insert into m_category values('22','����߿�����ģ����ѧ',2,'5');

insert into m_category values('23','ר�Ŀ���',2,'6');
insert into m_category values('24','ר�˿���',2,'6');
commit;
select category from m_category where parent_id ='null'

delete from m_category where id='f6a4663b-9c75-41e8-9584-9ccd36821f0b';

select category from m_category where parent_id='1';

//��̨����ͼ��� m_book
drop table m_book;
create table m_book (
   id                   VARCHAR2(40)                      not null,
   cate_id               VARCHAR2(40),  --���id
   book_name            VARCHAR2(50),   --ͼ����
   page_number          NUMBER(10),     --ҳ��
   word_number          NUMBER(10),     --����
   original_price       NUMBER(10,2),   --ԭ��
   cover                VARCHAR2(255),  --���� ͼƬ
   discount_price       NUMBER(10,2),   --�ۿۼ�
   repertory            NUMBER(10),     --���
   author               VARCHAR2(255),  --����
   edit_recommend       VARCHAR2(255),  --�༭�Ƽ�
   publish_company      VARCHAR2(255),  --������
   publish_time         Date,           --����ʱ��
   prospectus           VARCHAR2(255),  --���ݼ��
   edition              VARCHAR2(100),  --���
   print_time           Date,           --ӡˢʱ�䣨�ϼ�ʱ�䣩
   author_intro         VARCHAR2(255),  --���߼��
   print_number         VARCHAR2(100),   --ӡˢ����
   isbn                 NUMBER(10),     --ISBN
   catalog              VARCHAR2(255),  --����Ŀ¼
   book_size            VARCHAR2(50),   --����
   paper_type           VARCHAR2(50),   --ֽ��
   media_comment        VARCHAR2(255),  --ý������
   pack_type            VARCHAR2(50),   --��װ
   sales_volume         NUMBER(10),    --����
   constraint PK_BOOK primary key (id)
);

select * from m_book;
insert into m_book values('101','1','Ѧ�ɰ��Դ�','200','30000',50.21,'xzy.jpg',25.0,666,'������','�����ɰ���������������',
'���ϴ�ѧ������',to_date('2018-08-15', 'yyyy-mm-dd'),'���ݼ�࣡����','23',to_date('2018-08-15', 'yyyy-mm-dd'),'���߼�飡��',
'55',1111111111,'����Ŀ¼','����','ֽ��','ý������','��װ',33333);
select id,cate_id,book_name,page_number,word_number,original_price,cover,discount_price,repertory,author,edit_recommend,publish_company,publish_time,prospectus,edition,print_time,author_intro,print_number,isbn,catalog,book_size,paper_type,media_comment,pack_type,sales_volume 
		from m_book;
commit;

select m1.id as mid1,m1.category as mcategory1,m1.levels as mlevels1,m1.parent_id as parent_id1,
		       m2.id as mid2,m2.category as mcategory2,m2.levels as mlevels2,m2.parent_id as parent_id2
		from m_category m1 join m_category m2 on m1.id = m2.parent_id
		where m1.id='1'


select id,cate_id,book_name,page_number,word_number,original_price,cover,discount_price,repertory,author,edit_recommend,publish_company,publish_time,prospectus,edition,print_time,author_intro,print_number,isbn,catalog,book_size,paper_type,media_comment,pack_type,sales_volume
		from m_book  where sales_volume != 0	order by sales_volume desc;
select category from m_category where levels =2
		select m1.id as mid1,m1.category as mcategory1,m2.category as
		mcategory2,m1.levels as mlevels
		from m_category m1 join m_category m2 on m1.id=m2.parent_id
		
				select m1.id as mid1,m1.category as mcategory1,m1.levels as mlevels1,m1.parent_id as parent_id1,
		       m2.id as mid2,m2.category as mcategory2,m2.levels as mlevels2,m2.parent_id as parent_id2
		from m_category m1 join m_category m2 on m1.id=m2.parent_id