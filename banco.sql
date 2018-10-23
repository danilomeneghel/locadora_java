--------------------------------------------------------
--  Arquivo criado - Terça-feira-Outubro-23-2018   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table CLIENTE
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."CLIENTE" 
   (	"CODCLIENTE" NUMBER(*,0), 
	"NOME" VARCHAR2(30 BYTE), 
	"EMAIL" VARCHAR2(50 BYTE), 
	"TELEFONE" VARCHAR2(30 BYTE)
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into SYSTEM.CLIENTE
SET DEFINE OFF;
Insert into SYSTEM.CLIENTE (CODCLIENTE,NOME,EMAIL,TELEFONE) values ('14','Bruna Souza','bruna@souza.com','7777777');
Insert into SYSTEM.CLIENTE (CODCLIENTE,NOME,EMAIL,TELEFONE) values ('10','João da Silva','joao@silva.com','999999999');
Insert into SYSTEM.CLIENTE (CODCLIENTE,NOME,EMAIL,TELEFONE) values ('12','Ana Pereira','ana@pereira.com','88888888');
--------------------------------------------------------
--  DDL for Index SYS_C004007
--------------------------------------------------------

  CREATE UNIQUE INDEX "SYSTEM"."SYS_C004007" ON "SYSTEM"."CLIENTE" ("CODCLIENTE") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table CLIENTE
--------------------------------------------------------

  ALTER TABLE "SYSTEM"."CLIENTE" ADD PRIMARY KEY ("CODCLIENTE")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;

--------------------------------------------------------
--  Sequence for Table CLIENTE
--------------------------------------------------------

CREATE SEQUENCE  "SYSTEM"."CLIENTE_SEQ"  
MINVALUE 1 MAXVALUE 9999999999 
INCREMENT BY 1 
START WITH 16 
NOCACHE  NOORDER  
CYCLE ;