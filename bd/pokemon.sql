CREATE TABLE TIPOS(
  ID_TIPO INT NOT NULL,
  NOM_TIPO VARCHAR(20) NOT NULL,
  CONSTRAINT TIPO_ID_TIPO_PK PRIMARY KEY (ID_TIPO)
);

INSERT INTO TIPOS VALUES (1,'AGUA');
INSERT INTO TIPOS VALUES (2,'BICHO');
INSERT INTO TIPOS VALUES (3,'DRAGON');
INSERT INTO TIPOS VALUES (4,'ELECTRICO');
INSERT INTO TIPOS VALUES (5,'FANTASMA');
INSERT INTO TIPOS VALUES (6,'FUEGO');
INSERT INTO TIPOS VALUES (7,'HIELO');
INSERT INTO TIPOS VALUES (8,'LUCHA');
INSERT INTO TIPOS VALUES (9,'NORMAL');
INSERT INTO TIPOS VALUES (10,'PLANTA');
INSERT INTO TIPOS VALUES (11,'PSIQUICO');
INSERT INTO TIPOS VALUES (12,'ROCA');
INSERT INTO TIPOS VALUES (13,'TIERRA');
INSERT INTO TIPOS VALUES (14,'VENENO');
INSERT INTO TIPOS VALUES (15,'VOLADOR');

commit;

CREATE TABLE POKEDEX(
	ID_POKEDEX INT NOT NULL,
    NOM_POKEMON VARCHAR(20) NOT NULL,
    TIPO1 INT NOT NULL,
    TIPO2 INT,
    CONSTRAINT POKEDEX_ID_POKEDEX_PK PRIMARY KEY (ID_POKEDEX),
    CONSTRAINT POKEDEX_TIPO1_FK FOREIGN KEY (TIPO1) REFERENCES TIPOS(ID_TIPO)
);

INSERT INTO POKEDEX VALUES(1,'Bulbasur',10, 14);
INSERT INTO POKEDEX VALUES(2,'Ivisaur',10, 14);
INSERT INTO POKEDEX VALUES(3,'Venusaur',10, 14);
INSERT INTO POKEDEX VALUES(4,'Charmander',6, null);
INSERT INTO POKEDEX VALUES(5,'Charmeleon',6, null);
INSERT INTO POKEDEX VALUES(6,'Charizard',6, 15);
INSERT INTO POKEDEX VALUES(7,'Squirtle',1, null);
INSERT INTO POKEDEX VALUES(8,'Wartortle',1, null);
INSERT INTO POKEDEX VALUES(9,'Blastoise', 1, null);
INSERT INTO POKEDEX VALUES(10,'Caterpie', 2, null);
INSERT INTO POKEDEX VALUES(11,'Metapod', 2, null);
INSERT INTO POKEDEX VALUES(12,'Butterfree', 2, 15);
INSERT INTO POKEDEX VALUES(13,'Weedle', 2, 14);
INSERT INTO POKEDEX VALUES(14,'Kakuna', 2, 14);
INSERT INTO POKEDEX VALUES(15,'Beedrill', 2, 14);
INSERT INTO POKEDEX VALUES(16,'Pidgey', 9, 15);
INSERT INTO POKEDEX VALUES(17,'Pidgeotto', 9, 15);
INSERT INTO POKEDEX VALUES(18,'Pidgeot', 9, 15);
INSERT INTO POKEDEX VALUES(19,'Rattata', 9, null);
INSERT INTO POKEDEX VALUES(20,'Raticate', 9, null);
commit;

CREATE TABLE ENTRENADORES(
    ID_ENTRENADOR INT NOT NULL,
    NOM_ENTRENADOR VARCHAR(20) NOT NULL,
    POKEDOLARES INT,
    CONSTRAINT ENTRENADOR_ID_ENTRENADOR_PK PRIMARY KEY (ID_ENTRENADOR)
);

CREATE TABLE OBJETOS(
    ID_OBJETO INT NOT NULL,
    NOM_OBJETO VARCHAR(30) NOT NULL,
    PRECIO INT NOT NULL,
    ATAQUE INT,
    DEFENSA INT,
    AT_ESPECIAL INT,
    DEF_ESPECIAL INT,
    ESTAMINA INT,
    VELOCIDAD INT,
    CONSTRAINT OBJETOS_ID_OBJETO_PK PRIMARY KEY (ID_OBJETO)
);

CREATE TABLE MOCHILAS(
    ID_ENTRENADOR INT NOT NULL,
    ID_OBJETO INT NOT NULL,
    CANT_OBJETOS INT,
    CONSTRAINT MOCHILAS_ID_ENTRENADOR_FK FOREIGN KEY (ID_ENTRENADOR) REFERENCES ENTRENADORES(ID_ENTRENADOR),
    CONSTRAINT MOCHILAS_ID_OBJETO_FK FOREIGN KEY (ID_OBJETO) REFERENCES OBJETOS(ID_OBJETO)
);

CREATE TABLE MOVIMIENTOS(
    ID_MOVIMIENTO INT NOT NULL,
    NOM_MOVIMIENTO VARCHAR(50) NOT NULL,
    POTENCIA INT,
    TIPO INT,
    NUM_TURNO INT,
    ESTADO INT,
    ATAQUE INT,
    DEFENSA INT,
    AT_ESPECIAL INT,
    DEF_ESPECIAL INT,
    VELOCIDAD INT,
    VITALIDAD INT,
    TIPO_MOVIMIENTO INT,
    CATEGORIA_MOVIMIENTO INT,
    CONSTRAINT MOVIMIENTOS_ID_MOVIMIENTO_PK PRIMARY KEY (ID_MOVIMIENTO)
);

CREATE TABLE POKEMON(
    ID_POKEMON INT NOT NULL,
    ID_POKEDEX INT NOT NULL,
    ID_ENTRENADOR INT,
    MOTE VARCHAR(20),
    ATAQUE INT,
    AT_ESPECIAL INT,
    DEFENSA INT,
    DEF_ESPECIAL INT,
    ESTAMINA INT,
    FERTILIDAD INT,
    VITALIDAD INT,
    NIVEL INT,
    ID_MOVIMIENTO1 INT,
    ID_MOVIMIENTO2 INT,
    ID_MOVIMIENTO3 INT,
    ID_MOVIMIENTO4 INT,
    EXPERIENCIA INT,
    ID_OBJETO INT,
    SEXO INT,
    VELOCIDAD INT,
    CONSTRAINT POKEMON_ID_POKEMON_PK PRIMARY KEY (ID_POKEMON),
    CONSTRAINT POKEMON_ID_POKEDEX_FK FOREIGN KEY (ID_POKEDEX) REFERENCES POKEDEX(ID_POKEDEX),
    CONSTRAINT POKEMON_ID_ENTRENADOR_FK FOREIGN KEY (ID_ENTRENADOR) REFERENCES ENTRENADORES(ID_ENTRENADOR),
    CONSTRAINT POKEMON_ID_MOVIMIENTO1_FK FOREIGN KEY (ID_MOVIMIENTO1) REFERENCES MOVIMIENTOS(ID_MOVIMIENTO),
    CONSTRAINT POKEMON_ID_MOVIMIENTO2_FK FOREIGN KEY (ID_MOVIMIENTO2) REFERENCES MOVIMIENTOS(ID_MOVIMIENTO),
    CONSTRAINT POKEMON_ID_MOVIMIENTO3_FK FOREIGN KEY (ID_MOVIMIENTO3) REFERENCES MOVIMIENTOS(ID_MOVIMIENTO),
    CONSTRAINT POKEMON_ID_MOVIMIENTO4_FK FOREIGN KEY (ID_MOVIMIENTO4) REFERENCES MOVIMIENTOS(ID_MOVIMIENTO),
    CONSTRAINT POKEMON_ID_OBJETO_FK FOREIGN KEY (ID_OBJETO) REFERENCES OBJETOS(ID_OBJETO)
);


CREATE TABLE EQUIPOS(
    ID_EQUIPO INT NOT NULL,
    ID_ENTRENADOR INT,
    ID_POKEMON1 INT,
    ID_POKEMON2 INT,
    ID_POKEMON3 INT,
    ID_POKEMON4 INT,
    CONSTRAINT EQUIPOS_ID_EQUIPO_PK PRIMARY KEY (ID_EQUIPO),
    CONSTRAINT EQUIPOS_ID_ENTRENADOR_FK FOREIGN KEY (ID_ENTRENADOR) REFERENCES ENTRENADORES(ID_ENTRENADOR),
    CONSTRAINT EQUIPOS_ID_POKEMON1_FK FOREIGN KEY (ID_POKEMON1) REFERENCES POKEMON(ID_POKEMON),
    CONSTRAINT EQUIPOS_ID_POKEMON2_FK FOREIGN KEY (ID_POKEMON2) REFERENCES POKEMON(ID_POKEMON),
    CONSTRAINT EQUIPOS_ID_POKEMON3_FK FOREIGN KEY (ID_POKEMON3) REFERENCES POKEMON(ID_POKEMON),
    CONSTRAINT EQUIPOS_ID_POKEMON4_FK FOREIGN KEY (ID_POKEMON4) REFERENCES POKEMON(ID_POKEMON)
);

ALTER TABLE POKEMON
    ADD ID_EQUIPO INT;

ALTER TABLE POKEMON
ADD CONSTRAINT POKEMON_ID_EQUIPO_FK FOREIGN KEY (ID_EQUIPO) REFERENCES EQUIPOS(ID_EQUIPO);

 
CREATE TABLE POKEMON_MOVIENTO(
    ID_POKEMON INT NOT NULL,
    ID_MOVIMIENTO INT NOT NULL,
    CONSTRAINT ID_POKEMON_FK FOREIGN KEY (ID_POKEMON) REFERENCES POKEMON(ID_POKEMON),
    CONSTRAINT ID_MOVIMIENTO_FK FOREIGN KEY (ID_MOVIMIENTO) REFERENCES MOVIMIENTOS(ID_MOVIMIENTO)
 );
