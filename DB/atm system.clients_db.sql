


-- CREATE TABLE cutomers_DB (
--     CardHolderName VARCHAR(255) NOT NULL,
--     status VARCHAR(255) NOT NULL,
-- 	balance FLOAT NOT NULL
-- );

-- Insert into cutomers_DB (CardHolderName,status,balance)
-- values ('nada yahya miusakjas', 'blocked', 200),('mohamed ali mousaaaa','RUNNING',2000),('ali mohamed ahmed mousa','RUNNING',1000);

Update cutomers_DB 
Set cardpan = "1268793246924856"
where CardHolderName = 'mohamed ali mousaaaa';

 Alter table cutomers_DB Alter cardpan varchar(255);
 
Select * from cutomers_DB;

