
CREATE SEQUENCE seq_empresa
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

ALTER TABLE seq_empresa
  OWNER TO postgres;


CREATE TABLE tb_empresa
(
  id bigint NOT NULL,
  cnpj character varying(14) NOT NULL,
  data_atualizacao timestamp without time zone,
  data_criacao timestamp without time zone,
  codigo_empresa character varying(20) NOT NULL,
  CONSTRAINT tb_empresa_pkey PRIMARY KEY (id),
  CONSTRAINT uk_gamqi2pvmfim8800oc5jw05up UNIQUE (cnpj)
)
  WITH (
  OIDS=FALSE
       );
ALTER TABLE tb_empresa
  OWNER TO postgres;


CREATE SEQUENCE seq_funcionario
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

ALTER TABLE seq_funcionario
  OWNER TO postgres;


CREATE TABLE tb_funcionario
(
  id bigint NOT NULL,
  cpf character varying(11) NOT NULL,
  data_atualizacao timestamp without time zone,
  data_criacao timestamp without time zone,
  email character varying(50) NOT NULL,
  nome character varying(20) NOT NULL,
  qtd_horas_almoco real,
  qtd_horas_trabalhadas_dia real,
  senha character varying(20) NOT NULL,
  valor_hora numeric(19,2),
  codigo_empresa bigint,
  codigo_perfil bigint,
  CONSTRAINT tb_funcionario_pkey PRIMARY KEY (id),
  CONSTRAINT fk2xq0m8o5iitd0vatpbgw8dks FOREIGN KEY (codigo_perfil)
    REFERENCES tb_perfil (id) MATCH SIMPLE
    ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT fktpu8hc8ebjiv4db5ved88r7ck FOREIGN KEY (codigo_empresa)
    REFERENCES tb_empresa (id) MATCH SIMPLE
    ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT uk_h483q8xwbxkhk56ceeww2pvhw UNIQUE (cpf)
)
  WITH (
  OIDS=FALSE
       );
ALTER TABLE tb_funcionario
  OWNER TO postgres;


CREATE SEQUENCE seq_lancamento
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

ALTER TABLE seq_lancamento
  OWNER TO postgres;


CREATE TABLE tb_lancamento
(
  id bigint NOT NULL,
  data_atualizacao timestamp without time zone,
  data_criacao timestamp without time zone NOT NULL,
  data_lancamento timestamp without time zone NOT NULL,
  descricao_lancamento character varying(50) NOT NULL,
  localizacao character varying(255),
  tipo_lancamento character varying(255) NOT NULL,
  codigo_funcionario bigint,
  CONSTRAINT tb_lancamento_pkey PRIMARY KEY (id),
  CONSTRAINT fk80wrqv1iqnp264p6950mug3ti FOREIGN KEY (codigo_funcionario)
    REFERENCES tb_funcionario (id) MATCH SIMPLE
    ON UPDATE NO ACTION ON DELETE NO ACTION
)
  WITH (
  OIDS=FALSE
       );
ALTER TABLE tb_lancamento
  OWNER TO postgres;

CREATE SEQUENCE seq_perfil
INCREMENT 1
MINVALUE 1
MAXVALUE 9223372036854775807
START 1
CACHE 1;

ALTER TABLE seq_perfil
  OWNER TO postgres;


CREATE TABLE tb_perfil
(
  id bigint NOT NULL,
  descricao character varying(50) NOT NULL,
  nome character varying(20) NOT NULL,
  CONSTRAINT tb_perfil_pkey PRIMARY KEY (id),
  CONSTRAINT uk_du8iy2qhngwad364yceiu66vj UNIQUE (nome)
)
  WITH (
  OIDS=FALSE
       );
ALTER TABLE tb_perfil
  OWNER TO postgres;
