ALTER TABLE TB_MOTORISTA
    ADD CONSTRAINT chk_unique_cpf UNIQUE (cpf);

ALTER TABLE TB_TRANSPORTADORA
    ADD CONSTRAINT chk_unique_cnpj UNIQUE (cnpj);

ALTER TABLE TB_VEICULO
    ADD CONSTRAINT chk_unique_chassi UNIQUE (chassi);

ALTER TABLE TB_DEALER
    ADD CONSTRAINT chk_unique_cod_dealer UNIQUE (codigo_dealer);

ALTER TABLE TB_FILIAL
    ADD CONSTRAINT chk_unique_cod_filial UNIQUE (codigoFilial);


