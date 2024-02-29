DROP TABLE IF EXISTS dictionary;
CREATE TABLE dictionary AS SELECT * FROM CSVREAD('classpath:testdata/results.csv')