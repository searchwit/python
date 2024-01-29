INSERT INTO CTR_REF_TRANSACTION_TYPE VALUES ('USDDP', 0, 1, 'USD DRAFT PURCHASE','NEGOTIABLE_INSTRUMENT_IN');

hex:676f6f6479656172323031394023  enc:e1f3a28659bb4d1c  dec:nnnnk
hex:676f6f6479656172323031394023  enc:3f2fab5a28fb432b031cb401f87c0ed8  dec:789

spring.datasource.url=jdbc:oracle:thin:@ofacdb_medium?TNS_ADMIN=/home/e06836/wallet/
spring.datasource.username=flink
spring.datasource.password=Chtian200644201
spring.datasource.driver-class-name=oracle.jdbc.OracleDriver

  select customer_id, customer_name from customers;
/home/e06836/bigdata/cust_01.txt;
false;
select txn_id,run_date, c.customer_id, ORIGINATOR_BANK_KEY, BENEFICIARY_KEY, c.customer_name, ORIGINATOR, BENEFICIARY_NAME
from transactions t
--join accounts a on t.account_id = a.account_id
join customers c on c.customer_id = t.PRIMARY_CUSTOMER_ID;

/home/e06836/bigdata/txn_01.txt;
false;
RUN_DATE


