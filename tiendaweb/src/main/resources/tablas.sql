CREATE DATABASE ProyectoTienda;
USE proyectotienda;

CREATE TABLE Videojuegos(
                            titulo VARCHAR(60),
                            IDvideojuego VARCHAR(20),
                            Urlimg VARCHAR(255),
                            genero VARCHAR(20),
                            PRIMARY KEY (IDvideojuego)

);
CREATE TABLE Tienda(
                       NombreTienda VARCHAR(60),
                       IDTienda VARCHAR(20),
                       PRIMARY KEY (IDTIENDA)
);
CREATE TABLE RelacionTV(
                           IDTienda VARCHAR(20),
                           IDvideojuego VARCHAR(20),
                           UrlTV VARCHAR(255),
                           DiaFinOferta DATE,
                           precioNormal FLOAT,
                           precioOferta FLOAT,
                           FOREIGN KEY (IDtienda) REFERENCES tienda(IDTIENDA),
                           FOREIGN KEY (IDvideojuego) REFERENCES videojuegos(IDvideojuego)
);

INSERT INTO videojuegos
VALUES ( "The Legend of Zelda","1","Zelda.img","Aventura");
INSERT INTO videojuegos
VALUES ( "Mario Galaxy","2","Mario.img","Aventura");
INSERT INTO videojuegos
VALUES ( "Pokemon","3","Pokemon.img","RPG");
INSERT INTO videojuegos
VALUES ( "Sonic","4","Sonic.img","Aventuras");
INSERT INTO videojuegos
VALUES ( "CS","5","CS.img","MOBA");
INSERT INTO videojuegos(titulo, IDvideojuego)
VALUES ( "Mortal Kombat","6","Combate");

INSERT INTO videojuegos
VALUES ( "Crash Nitro Fueled","7","CNF.img","Carreras");
INSERT INTO videojuegos
VALUES ( "Crash Team Racing","8","CTR.img","Carreras");
INSERT INTO videojuegos
VALUES ( "Bang Dream","9","Bandori.img","Musical");
INSERT INTO videojuegos
VALUES ( "Guitar Hero I","10","GH.img","Musical");
INSERT INTO videojuegos
VALUES ( "Guitar Hero II","11","GH2.img","Musical");
INSERT INTO videojuegos
VALUES ( "Guitar Hero III: Legends of Rock","12","GH3.img","Musical");
INSERT INTO videojuegos
VALUES ( "Crash Nitro Kart","13","CNK.img","");
INSERT INTO videojuegos
VALUES ( "Call of Duty","14","COD.img","Accion");
INSERT INTO videojuegos
VALUES ( "Call of Duty 2","15","COD2.img","Accion");
INSERT INTO videojuegos
VALUES ( "Call of Duty 3","16","COD3.img","Accion");
INSERT INTO videojuegos
VALUES ( "Call of Duty: Modern Warfare","17","CODMW.img","Accion");
INSERT INTO videojuegos
VALUES ( "Call of Duty: Black Ops 1","18","CODBO1.img","Accion");
INSERT INTO videojuegos
VALUES ( "Call of Duty: Black Ops 2","19","CODBO2.img","Accion");
INSERT INTO videojuegos
VALUES ( "Call of Duty: Black Ops 3","20","CODBO3.img","Accion");
INSERT INTO videojuegos
VALUES ( "Mario Kart","21","MarioK.img","Carreras");
INSERT INTO videojuegos
VALUES ( "Twisted Metal 8","22","TwistedM.img","Carreras");
INSERT INTO videojuegos
VALUES ( "Monopoly","23","Monopoly.img","Familiar");
INSERT INTO videojuegos
VALUES ( "Super Smash Bros","24","SuperSmashB.img","Combate");
INSERT INTO videojuegos
VALUES ( "PlayStation: All Stars","25","PSAllStars.img","Combate");
INSERT INTO videojuegos
VALUES ( "Valorant","26","Valorant.img","Disparos");
INSERT INTO videojuegos
VALUES ( "Half Life","27","HL.img","Disparos");
INSERT INTO videojuegos
VALUES ( "Paladins","28","Paladins.img","Disparos");
INSERT INTO videojuegos
VALUES ( "Dota 2","29","Dota2.img","MOBA");
INSERT INTO videojuegos
VALUES ( "League of Legends","30","MarioK.img","Carreras");
INSERT INTO tienda
VALUES ("Steam","111");
INSERT INTO tienda
VALUES ("GOG","222");
INSERT INTO tienda
VALUES ("Epic Games","333");

INSERT INTO relaciontv
VALUES ("222","2","Mario.com","2020-10-10",25.50,20.20);
INSERT INTO relaciontv
VALUES ("111","2","Mario.steam","2020-11-11",27.50,22.20);
INSERT INTO relaciontv
VALUES ("111","3","Pokemon.steam","2020-02-02",22.40,21.50);
INSERT INTO relaciontv
VALUES ("111","5","CS.steam","2020-07-02",21.40,19.50);
COMMIT;
UPDATE videojuegos SET genero = "Carreras" WHERE idvideojuego ="13";
CREATE TABLE usuario(
                        nombres VARCHAR(20),
                        apellidos VARCHAR(20),
                        username VARCHAR(15) PRIMARY KEY,
                        contrasenia VARCHAR(15)
);
INSERT INTO usuario VALUES ('Kevin', 'Rosado', 'krosados', '030602');
INSERT INTO usuario VALUES ('Giro', 'Pinto', 'gpintol', '260201');
INSERT INTO usuario VALUES ('Jack', 'Mendoza', 'jmendozap', '190601');
INSERT INTO usuario VALUES ('Carlos', 'Merino', 'cmerinos', '150801');
COMMIT;
