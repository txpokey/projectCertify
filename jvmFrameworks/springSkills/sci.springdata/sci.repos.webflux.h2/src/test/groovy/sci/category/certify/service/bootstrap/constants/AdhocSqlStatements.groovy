package sci.category.certify.service.bootstrap.constants

class AdhocSqlStatements{

    final static String SELECT_COUNT_ALL_TABLES_FROM_META_TABLE = """
        SELECT count(*) as c FROM INFORMATION_SCHEMA.TABLES 
"""
    final static String SELECT_ALL_TABLES_FROM_META_TABLE = """
        SELECT * FROM INFORMATION_SCHEMA.TABLES
"""
   final static String SELECT_TABLES_AND_COUNTS_FROM_META_TABLE = """
    SELECT TABLE_NAME , ROW_COUNT_ESTIMATE   FROM INFORMATION_SCHEMA.TABLES
"""
   final static String CREATE_TABLE_USING_H2_CONSOLE_CODE_EXAMPLE = """
CREATE MEMORY TABLE "PUBLIC"."PRIMES_RX"(
    "ID" BIGINT NOT NULL,
    "PRIME" INTEGER,
    "SPECIES" VARCHAR(255),
    "TRUTH" BOOLEAN
)
"""
   final static String CREATE_TABLE_USING_H2_SPRING_DATA_LOG = """
 drop table IF EXISTS primes_rx cascade constraints ;
 drop sequence hibernate_sequence ;
 create sequence hibernate_sequence start with 1 increment by  1 ;
 create table primes_rx (id number(19,0) not null, prime number(10,0), species varchar2(255 char), truth number(1,0), primary key (id)) ;
"""
   final static String SET_AUTOCOMMIT = """
SET AUTOCOMMIT ON
"""
  final static String SHOW_TABLES = """
 show tables ;
"""



}
