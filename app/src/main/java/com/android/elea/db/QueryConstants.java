package com.android.elea.db;

/**
 * Created by Borja on 02/06/2015.
 */
public class QueryConstants {
/*
D:\>cd android-sdk

D:\android-sdk>cd platform-tools

D:\android-sdk\platform-tools>adb devices
List of devices attached
emulator-5554   device


D:\android-sdk\platform-tools>adb -s emulator-5554 shell
root@generic_x86:/ # sqlite3 /data/data/com.android.elea/databases/myDB
 */

    public static String CREATE_DB = "CREATE TABLE country (\n" +
            "\tID integer NOT NULL,\n" +
            "\tNAME varchar(45) NOT NULL,\n" +
            "\tAVAILABLE integer NOT NULL,\n" +
            "\tPRIMARY KEY (ID)\n" +
            ");\n" +
            "CREATE TABLE favorites (\n" +
            "\tID integer NOT NULL,\n" +
            "\tUSER_ID integer,\n" +
            "\tJOB_ID integer,\n" +
            "\tPRIMARY KEY (ID)\n" +
            ");\n" +
            "CREATE TABLE job (\n" +
            "\tID integer NOT NULL,\n" +
            "\tUSER_ID integer NOT NULL,\n" +
            "\tTITLE varchar(100),\n" +
            "\tDESCRIPTION varchar(4000),\n" +
            "\tCOUNTRY_ID integer,\n" +
            "\tTOWN_ID integer,\n" +
            "\tPROVINCE_ID integer,\n" +
            "\tIS_OFFER integer NOT NULL,\n" +
            "\tIS_ACTIVE integer,\n" +
            "\tPAYMENT_MODE varchar(1),\n" +
            "\tAMOUNT integer,\n" +
            "\tPRIMARY KEY (ID)\n" +
            ");\n" +
            "CREATE TABLE province (\n" +
            "\tID integer NOT NULL,\n" +
            "\tNAME varchar(45) NOT NULL,\n" +
            "\tCOUNTRY_ID integer NOT NULL,\n" +
            "\tPRIMARY KEY (ID)\n" +
            ");\n" +
            "CREATE TABLE town (\n" +
            "\tID integer NOT NULL,\n" +
            "\tNAME varchar(100) NOT NULL,\n" +
            "\tPROVINCE_ID integer NOT NULL,\n" +
            "\tDC integer NOT NULL,\n" +
            "\tCOD_MUNUCIPIO integer NOT NULL,\n" +
            "\tPRIMARY KEY (ID)\n" +
            ");\n" +
            "CREATE TABLE user (\n" +
            "\tID integer NOT NULL,\n" +
            "\t\"KEY\" varchar(100),\n" +
            "\tEMAIL varchar(150),\n" +
            "\tMAIL_NOTIF_ACTIVE integer,\n" +
            "\tDEVICE_NOTIF_ACTIVE integer,\n" +
            "\tDEVICE_ID varchar(100),\n" +
            "\tPRIMARY KEY (ID)\n" +
            ");\n" +
            "ALTER TABLE favorites\n" +
            "\tADD FOREIGN KEY (USER_ID) \n" +
            "\tREFERENCES user (ID);\n" +
            "\n" +
            "ALTER TABLE favorites\n" +
            "\tADD FOREIGN KEY (JOB_ID) \n" +
            "\tREFERENCES job (ID);\n" +
            "\n" +
            "\n" +
            "ALTER TABLE job\n" +
            "\tADD FOREIGN KEY (PROVINCE_ID) \n" +
            "\tREFERENCES province (ID);\n" +
            "\n" +
            "ALTER TABLE job\n" +
            "\tADD FOREIGN KEY (COUNTRY_ID) \n" +
            "\tREFERENCES country (ID);\n" +
            "\n" +
            "ALTER TABLE job\n" +
            "\tADD FOREIGN KEY (USER_ID) \n" +
            "\tREFERENCES user (ID);\n" +
            "\n" +
            "ALTER TABLE job\n" +
            "\tADD FOREIGN KEY (TOWN_ID) \n" +
            "\tREFERENCES town (ID);\n" +
            "\n" +
            "\n" +
            "ALTER TABLE province\n" +
            "\tADD FOREIGN KEY (COUNTRY_ID) \n" +
            "\tREFERENCES country (ID);\n" +
            "\n" +
            "\n" +
            "ALTER TABLE town\n" +
            "\tADD FOREIGN KEY (PROVINCE_ID) \n" +
            "\tREFERENCES province (ID);";

    /*
    public static String INSERTS_DB = "INSERT INTO country(ID, NAME, AVAILABLE) VALUES (0, 'España', 1);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (1, 'Araba/Álava', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (2, 'Albacete', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (3, 'Alicante/Alacant', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (4, 'Almería', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (5, 'Ávila', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (6, 'Badajoz', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (7, 'Balears, Illes', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (8, 'Barcelona', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (9, 'Burgos', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (10, 'Cáceres', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (11, 'Cádiz', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (12, 'Castellón/Castelló', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (13, 'Ciudad Real', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (14, 'Córdoba', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (15, 'Coruña, A', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (16, 'Cuenca', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (17, 'Girona', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (18, 'Granada', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (19, 'Guadalajara', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (20, 'Gipuzkoa', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (21, 'Huelva', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (22, 'Huesca', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (23, 'Jaén', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (24, 'León', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (25, 'Lleida', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (26, 'Rioja, La', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (27, 'Lugo', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (28, 'Madrid', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (29, 'Málaga', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (30, 'Murcia', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (31, 'Navarra', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (32, 'Ourense', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (33, 'Asturias', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (34, 'Palencia', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (35, 'Palmas, Las', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (36, 'Pontevedra', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (37, 'Salamanca', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (38, 'Santa Cruz de Tenerife', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (39, 'Cantabria', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (40, 'Segovia', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (41, 'Sevilla', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (42, 'Soria', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (43, 'Tarragona', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (44, 'Teruel', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (45, 'Toledo', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (46, 'Valencia/València', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (47, 'Valladolid', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (48, 'Bizkaia', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (49, 'Zamora', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (50, 'Zaragoza', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (51, 'Ceuta', 0);\n" +
            "INSERT INTO province(ID, NAME, COUNTRY_ID) VALUES (52, 'Melilla', 0);\n";

    public static String INSERTS_DB_1 = "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1, 'Alegría-Dulantzi', 1, 4, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2, 'Abengibre', 2, 9, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3, 'Adsubia', 3, 5, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4, 'Abla', 4, 0, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5, 'Adanero', 5, 3, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6, 'Acedera', 6, 6, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7, 'Alaró', 7, 2, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8, 'Abrera', 8, 8, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (9, 'Abajas', 9, 1, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (10, 'Abadía', 10, 5, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (11, 'Alcalá de los Gazules', 11, 2, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (12, 'Atzeneta del Maestrat', 12, 7, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (13, 'Abenójar', 13, 3, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (14, 'Adamuz', 14, 8, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (15, 'Abegondo', 15, 1, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (16, 'Abia de la Obispalía', 16, 4, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (17, 'Agullana', 17, 0, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (18, 'Agrón', 18, 6, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (19, 'Abánades', 19, 9, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (20, 'Abaltzisketa', 20, 3, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (21, 'Alájar', 21, 0, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (22, 'Abiego', 22, 5, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (23, 'Albanchez de Mágina', 23, 1, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (24, 'Acebedo', 24, 6, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (25, 'Abella de la Conca', 25, 9, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (26, 'Ábalos', 26, 2, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (27, 'Abadín', 27, 8, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (28, 'Acebeda, La', 28, 4, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (29, 'Alameda', 29, 7, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (30, 'Abanilla', 30, 1, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (31, 'Abáigar', 31, 8, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (32, 'Allariz', 32, 3, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (33, 'Allande', 33, 9, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (34, 'Abarca de Campos', 34, 4, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (35, 'Agaete', 35, 7, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (36, 'Arbo', 36, 0, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (37, 'Abusejo', 37, 6, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (38, 'Adeje', 38, 2, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (39, 'Alfoz de Lloredo', 39, 5, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (40, 'Abades', 40, 9, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (41, 'Aguadulce', 41, 6, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (42, 'Abejar', 42, 1, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (43, 'Aiguamúrcia', 43, 7, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (44, 'Ababuj', 44, 2, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (45, 'Ajofrín', 45, 5, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (46, 'Ademuz', 46, 8, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (47, 'Adalia', 47, 4, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (48, 'Abadiño', 48, 0, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (49, 'Abanto', 50, 6, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (50, 'Ceuta', 51, 3, 1);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (51, 'Melilla', 52, 8, 1);\n";
    public static String INSERTS_DB_2 =        "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (52, 'Amurrio', 1, 9, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (53, 'Alatoz', 2, 4, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (54, 'Agost', 3, 0, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (55, 'Abrucena', 4, 5, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (56, 'Adrada, La', 5, 8, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (57, 'Aceuchal', 6, 1, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (58, 'Alaior', 7, 7, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (59, 'Aguilar de Segarra', 8, 3, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (60, 'Abertura', 10, 0, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (61, 'Alcalá del Valle', 11, 7, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (62, 'Aín', 12, 2, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (63, 'Agudo', 13, 8, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (64, 'Aguilar de la Frontera', 14, 3, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (65, 'Ames', 15, 6, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (66, 'Acebrón, El', 16, 9, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (67, 'Aiguaviva', 17, 5, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (68, 'Alamedilla', 18, 1, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (69, 'Ablanque', 19, 4, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (70, 'Aduna', 20, 8, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (71, 'Aljaraque', 21, 5, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (72, 'Abizanda', 22, 0, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (73, 'Alcalá la Real', 23, 6, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (74, 'Algadefe', 24, 1, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (75, 'Àger', 25, 4, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (76, 'Agoncillo', 26, 7, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (77, 'Alfoz', 27, 3, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (78, 'Ajalvir', 28, 9, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (79, 'Alcaucín', 29, 2, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (80, 'Abarán', 30, 6, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (81, 'Abárzuza/Abartzuza', 31, 3, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (82, 'Amoeiro', 32, 8, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (83, 'Aller', 33, 4, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (84, 'Agüimes', 35, 2, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (85, 'Barro', 36, 5, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (86, 'Agallas', 37, 1, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (87, 'Agulo', 38, 7, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (88, 'Ampuero', 39, 0, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (89, 'Adrada de Pirón', 40, 4, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (90, 'Alanís', 41, 1, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (91, 'Albinyana', 43, 2, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (92, 'Abejuela', 44, 7, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (93, 'Alameda de la Sagra', 45, 0, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (94, 'Ador', 46, 3, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (95, 'Aguasal', 47, 9, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (96, 'Abanto y Ciérvana-Abanto Zierbena', 48, 5, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (97, 'Abezames', 49, 8, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (98, 'Acered', 50, 1, 2);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (99, 'Aramaio', 1, 5, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (100, 'Albacete', 2, 0, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (101, 'Agres', 3, 6, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (102, 'Adra', 4, 1, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (103, 'Ahillones', 6, 7, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (104, 'Alcúdia', 7, 3, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (105, 'Alella', 8, 9, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (106, 'Adrada de Haza', 9, 2, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (107, 'Acebo', 10, 6, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (108, 'Algar', 11, 3, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (109, 'Albocàsser', 12, 8, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (110, 'Alamillo', 13, 4, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (111, 'Alcaracejos', 14, 9, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (112, 'Aranga', 15, 2, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (113, 'Alarcón', 16, 5, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (114, 'Albanyà', 17, 1, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (115, 'Albolote', 18, 7, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (116, 'Adobes', 19, 0, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (117, 'Aizarnazabal', 20, 4, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (118, 'Almendro, El', 21, 1, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (119, 'Adahuesca', 22, 6, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (120, 'Alcaudete', 23, 2, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (121, 'Alija del Infantado', 24, 7, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (122, 'Agramunt', 25, 0, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (123, 'Aguilar del Río Alhama', 26, 3, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (124, 'Antas de Ulla', 27, 9, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (125, 'Alameda del Valle', 28, 5, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (126, 'Alfarnate', 29, 8, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (127, 'Águilas', 30, 2, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (128, 'Abaurregaina/Abaurrea Alta', 31, 9, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (129, 'Arnoia, A', 32, 4, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (130, 'Amieva', 33, 0, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (131, 'Abia de las Torres', 34, 5, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (132, 'Antigua', 35, 8, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (133, 'Baiona', 36, 1, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (134, 'Ahigal de los Aceiteros', 37, 7, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (135, 'Alajeró', 38, 3, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (136, 'Anievas', 39, 6, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (137, 'Adrados', 40, 0, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (138, 'Albaida del Aljarafe', 41, 7, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (139, 'Adradas', 42, 2, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (140, 'Albiol, L''', 43, 8, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (141, 'Aguatón', 44, 3, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (142, 'Albarreal de Tajo', 45, 6, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (143, 'Atzeneta d''Albaida', 46, 9, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (144, 'Aguilar de Campos', 47, 5, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (145, 'Amorebieta-Etxano', 48, 1, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (146, 'Alcañices', 49, 4, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (147, 'Agón', 50, 7, 3);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (148, 'Artziniega', 1, 0, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (149, 'Albatana', 2, 5, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (150, 'Aigües', 3, 1, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (151, 'Albánchez', 4, 6, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (152, 'Alange', 6, 2, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (153, 'Algaida', 7, 8, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (154, 'Alpens', 8, 4, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (155, 'Acehúche', 10, 1, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (156, 'Algeciras', 11, 8, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (157, 'Alcalà de Xivert', 12, 3, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (158, 'Albaladejo', 13, 9, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (159, 'Almedinilla', 14, 4, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (160, 'Ares', 15, 7, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (161, 'Albaladejo del Cuende', 16, 0, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (162, 'Albons', 17, 6, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (163, 'Albondón', 18, 2, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (164, 'Alaminos', 19, 5, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (165, 'Albiztur', 20, 9, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (166, 'Almonaster la Real', 21, 6, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (167, 'Agüero', 22, 1, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (168, 'Aldeaquemada', 23, 7, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (169, 'Almanza', 24, 2, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (170, 'Alamús, Els', 25, 5, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (171, 'Ajamil de Cameros', 26, 8, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (172, 'Baleira', 27, 4, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (173, 'Álamo, El', 28, 0, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (174, 'Alfarnatejo', 29, 3, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (175, 'Albudeite', 30, 7, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (176, 'Abaurrepea/Abaurrea Baja', 31, 4, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (177, 'Avión', 32, 9, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (178, 'Avilés', 33, 5, 4);\n" ;
    public static String INSERTS_DB_3 =     "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (179, 'Aguilar de Campoo', 34, 0, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (180, 'Arrecife', 35, 3, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (181, 'Bueu', 36, 6, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (182, 'Ahigal de Villarino', 37, 2, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (183, 'Arafo', 38, 8, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (184, 'Arenas de Iguña', 39, 1, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (185, 'Aguilafuente', 40, 5, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (186, 'Alcalá de Guadaíra', 41, 2, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (187, 'Ágreda', 42, 7, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (188, 'Alcanar', 43, 3, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (189, 'Aguaviva', 44, 8, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (190, 'Alcabón', 45, 1, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (191, 'Agullent', 46, 4, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (192, 'Alaejos', 47, 0, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (193, 'Amoroto', 48, 6, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (194, 'Alcubilla de Nogales', 49, 9, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (195, 'Aguarón', 50, 2, 4);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (196, 'Alborea', 2, 8, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (197, 'Albatera', 3, 4, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (198, 'Alboloduy', 4, 9, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (199, 'Albornos', 5, 2, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (200, 'Albuera, La', 6, 5, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (201, 'Andratx', 7, 1, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (202, 'Ametlla del Vallès, L''', 8, 7, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (203, 'Aceituna', 10, 4, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (204, 'Algodonales', 11, 1, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (205, 'Alcora, l''', 12, 6, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (206, 'Alcázar de San Juan', 13, 2, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (207, 'Almodóvar del Río', 14, 7, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (208, 'Arteixo', 15, 0, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (209, 'Albalate de las Nogueras', 16, 3, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (210, 'Far d''Empordà, El', 17, 9, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (211, 'Albuñán', 18, 5, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (212, 'Alarilla', 19, 8, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (213, 'Alegia', 20, 2, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (214, 'Almonte', 21, 9, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (215, 'Andújar', 23, 0, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (216, 'Antigua, La', 24, 5, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (217, 'Alàs i Cerc', 25, 8, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (218, 'Albelda de Iregua', 26, 1, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (219, 'Barreiros', 27, 7, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (220, 'Alcalá de Henares', 28, 3, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (221, 'Algarrobo', 29, 6, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (222, 'Alcantarilla', 30, 0, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (223, 'Aberin', 31, 7, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (224, 'Baltar', 32, 2, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (225, 'Belmonte de Miranda', 33, 8, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (226, 'Alar del Rey', 34, 3, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (227, 'Artenara', 35, 6, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (228, 'Caldas de Reis', 36, 9, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (229, 'Alameda de Gardón, La', 37, 5, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (230, 'Arico', 38, 1, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (231, 'Argoños', 39, 4, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (232, 'Alconada de Maderuelo', 40, 8, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (233, 'Alcalá del Río', 41, 5, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (234, 'Alcover', 43, 6, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (235, 'Aguilar del Alfambra', 44, 1, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (236, 'Alcañizo', 45, 4, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (237, 'Alaquàs', 46, 7, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (238, 'Alcazarén', 47, 3, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (239, 'Arakaldo', 48, 9, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (240, 'Alfaraz de Sayago', 49, 2, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (241, 'Aguilón', 50, 5, 5);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (242, 'Armiñón', 1, 6, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (243, 'Alcadozo', 2, 1, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (244, 'Alcalalí', 3, 7, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (245, 'Albox', 4, 2, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (246, 'Alburquerque', 6, 8, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (247, 'Artà', 7, 4, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (248, 'Arenys de Mar', 8, 0, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (249, 'Aguas Cándidas', 9, 3, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (250, 'Ahigal', 10, 7, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (251, 'Arcos de la Frontera', 11, 4, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (252, 'Alcudia de Veo', 12, 9, 6);\n" ;
    public static String INSERTS_DB_4 =  "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (253, 'Alcoba', 13, 5, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (254, 'Añora', 14, 0, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (255, 'Arzúa', 15, 3, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (256, 'Albendea', 16, 6, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (257, 'Alp', 17, 2, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (258, 'Albuñol', 18, 8, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (259, 'Albalate de Zorita', 19, 1, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (260, 'Alkiza', 20, 5, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (261, 'Alosno', 21, 2, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (262, 'Aisa', 22, 7, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (263, 'Arjona', 23, 3, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (264, 'Ardón', 24, 8, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (265, 'Albagés, L''', 25, 1, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (266, 'Alberite', 26, 4, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (267, 'Becerreá', 27, 0, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (268, 'Alcobendas', 28, 6, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (269, 'Algatocín', 29, 9, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (270, 'Aledo', 30, 3, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (271, 'Ablitas', 31, 0, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (272, 'Bande', 32, 5, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (273, 'Bimenes', 33, 1, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (274, 'Alba de Cerrato', 34, 6, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (275, 'Arucas', 35, 9, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (276, 'Cambados', 36, 2, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (277, 'Alamedilla, La', 37, 8, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (278, 'Arona', 38, 4, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (279, 'Arnuero', 39, 7, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (280, 'Aldealcorvo', 40, 1, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (281, 'Alcolea del Río', 41, 8, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (282, 'Alconaba', 42, 3, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (283, 'Aldover', 43, 9, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (284, 'Alacón', 44, 4, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (285, 'Alcaudete de la Jara', 45, 7, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (286, 'Albaida', 46, 0, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (287, 'Aldea de San Miguel', 47, 6, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (288, 'Arantzazu', 48, 2, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (289, 'Algodre', 49, 5, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (290, 'Ainzón', 50, 8, 6);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (291, 'Alcalá del Júcar', 2, 7, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (292, 'Alcocer de Planes', 3, 3, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (293, 'Alcolea', 4, 8, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (294, 'Aldeanueva de Santa Cruz', 5, 1, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (295, 'Alconchel', 6, 4, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (296, 'Banyalbufar', 7, 0, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (297, 'Arenys de Munt', 8, 6, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (298, 'Aguilar de Bureba', 9, 9, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (299, 'Albalá', 10, 3, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (300, 'Barbate', 11, 0, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (301, 'Alfondeguilla', 12, 5, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (302, 'Alcolea de Calatrava', 13, 1, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (303, 'Baena', 14, 6, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (304, 'Baña, A', 15, 9, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (305, 'Alberca de Záncara, La', 16, 2, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (306, 'Amer', 17, 8, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (307, 'Albuñuelas', 18, 4, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (308, 'Albares', 19, 7, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (309, 'Altzo', 20, 1, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (310, 'Aracena', 21, 8, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (311, 'Albalate de Cinca', 22, 3, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (312, 'Arjonilla', 23, 9, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (313, 'Arganza', 24, 4, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (314, 'Albatàrrec', 25, 7, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (315, 'Alcanadre', 26, 0, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (316, 'Begonte', 27, 6, 7);\n" ;
    public static String INSERTS_DB_5 =  "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (317, 'Alcorcón', 28, 2, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (318, 'Alhaurín de la Torre', 29, 5, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (319, 'Alguazas', 30, 9, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (320, 'Adiós', 31, 6, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (321, 'Baños de Molgas', 32, 1, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (322, 'Boal', 33, 7, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (323, 'Betancuria', 35, 5, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (324, 'Campo Lameiro', 36, 8, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (325, 'Alaraz', 37, 4, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (326, 'Barlovento', 38, 0, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (327, 'Arredondo', 39, 3, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (328, 'Aldealengua de Pedraza', 40, 7, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (329, 'Algaba, La', 41, 4, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (330, 'Alcubilla de Avellaneda', 42, 9, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (331, 'Aleixar, L''', 43, 5, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (332, 'Alba', 44, 0, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (333, 'Alcolea de Tajo', 45, 3, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (334, 'Albal', 46, 6, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (335, 'Aldeamayor de San Martín', 47, 2, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (336, 'Munitibar-Arbatzegi Gerrikaitz', 48, 8, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (337, 'Almaraz de Duero', 49, 1, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (338, 'Aladrén', 50, 4, 7);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (339, 'Arrazua-Ubarrundia', 1, 8, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (340, 'Alcaraz', 2, 3, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (341, 'Alcoleja', 3, 9, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (342, 'Alcóntar', 4, 4, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (343, 'Aldeaseca', 5, 7, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (344, 'Alconera', 6, 0, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (345, 'Binissalem', 7, 6, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (346, 'Argençola', 8, 2, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (347, 'Alcántara', 10, 9, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (348, 'Barrios, Los', 11, 6, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (349, 'Algimia de Almonacid', 12, 1, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (350, 'Alcubillas', 13, 7, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (351, 'Belalcázar', 14, 2, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (352, 'Bergondo', 15, 5, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (353, 'Alcalá de la Vega', 16, 8, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (354, 'Anglès', 17, 4, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (355, 'Albendiego', 19, 3, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (356, 'Amezketa', 20, 7, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (357, 'Aroche', 21, 4, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (358, 'Albalatillo', 22, 9, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (359, 'Arquillos', 23, 5, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (360, 'Astorga', 24, 0, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (361, 'Albesa', 25, 3, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (362, 'Aldeanueva de Ebro', 26, 6, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (363, 'Bóveda', 27, 2, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (364, 'Aldea del Fresno', 28, 8, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (365, 'Alhaurín el Grande', 29, 1, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (366, 'Alhama de Murcia', 30, 5, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (367, 'Aguilar de Codés', 31, 2, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (368, 'Barbadás', 32, 7, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (369, 'Cabrales', 33, 3, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (370, 'Firgas', 35, 1, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (371, 'Cangas', 36, 4, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (372, 'Alba de Tormes', 37, 0, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (373, 'Breña Alta', 38, 6, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (374, 'Astillero, El', 39, 9, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (375, 'Aldealengua de Santa María', 40, 3, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (376, 'Algámitas', 41, 0, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (377, 'Alcubilla de las Peñas', 42, 5, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (378, 'Alfara de Carles', 43, 1, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (379, 'Albalate del Arzobispo', 44, 6, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (380, 'Aldea en Cabo', 45, 9, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (381, 'Albalat de la Ribera', 46, 2, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (382, 'Almenara de Adaja', 47, 8, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (383, 'Artzentales', 48, 4, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (384, 'Almeida de Sayago', 49, 7, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (385, 'Alagón', 50, 0, 8);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (386, 'Asparrena', 1, 1, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (387, 'Almansa', 2, 6, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (388, 'Alcoy/Alcoi', 3, 2, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (389, 'Alcudia de Monteagud', 4, 7, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (390, 'Aljucén', 6, 3, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (391, 'Búger', 7, 9, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (392, 'Argentona', 8, 5, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (393, 'Albillos', 9, 8, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (394, 'Alcollarín', 10, 2, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (395, 'Benaocaz', 11, 9, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (396, 'Almazora/Almassora', 12, 4, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (397, 'Aldea del Rey', 13, 0, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (398, 'Belmez', 14, 5, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (399, 'Betanzos', 15, 8, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (400, 'Alcantud', 16, 1, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (401, 'Arbúcies', 17, 7, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (402, 'Alcocer', 19, 6, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (403, 'Andoain', 20, 0, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (404, 'Arroyomolinos de León', 21, 7, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (405, 'Albelda', 22, 2, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (406, 'Baeza', 23, 8, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (407, 'Balboa', 24, 3, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (408, 'Albi, L''', 25, 6, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (409, 'Alesanco', 26, 9, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (410, 'Carballedo', 27, 5, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (411, 'Algete', 28, 1, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (412, 'Almáchar', 29, 4, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (413, 'Archena', 30, 8, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (414, 'Aibar/Oibar', 31, 5, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (415, 'Barco de Valdeorras, O', 32, 0, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (416, 'Cabranes', 33, 6, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (417, 'Amayuelas de Arriba', 34, 1, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (418, 'Gáldar', 35, 4, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (419, 'Cañiza, A', 36, 7, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (420, 'Alba de Yeltes', 37, 3, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (421, 'Breña Baja', 38, 9, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (422, 'Bárcena de Cicero', 39, 2, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (423, 'Aldeanueva de la Serrezuela', 40, 6, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (424, 'Almadén de la Plata', 41, 3, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (425, 'Aldealafuente', 42, 8, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (426, 'Alforja', 43, 4, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (427, 'Albarracín', 44, 9, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (428, 'Aldeanueva de Barbarroya', 45, 2, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (429, 'Albalat dels Sorells', 46, 5, 9);\n" ;
    public static String INSERTS_DB_6 =
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (430, 'Amusquillo', 47, 1, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (431, 'Arrankudiaga', 48, 7, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (432, 'Andavías', 49, 0, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (433, 'Alarba', 50, 3, 9);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (434, 'Ayala/Aiara', 1, 5, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (435, 'Alpera', 2, 0, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (436, 'Alfafara', 3, 6, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (437, 'Alhabia', 4, 1, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (438, 'Aldehuela, La', 5, 4, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (439, 'Almendral', 6, 7, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (440, 'Bunyola', 7, 3, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (441, 'Artés', 8, 9, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (442, 'Alcocero de Mola', 9, 2, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (443, 'Alcuéscar', 10, 6, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (444, 'Bornos', 11, 3, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (445, 'Almedíjar', 12, 8, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (446, 'Alhambra', 13, 4, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (447, 'Benamejí', 14, 9, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (448, 'Boimorto', 15, 2, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (449, 'Alcázar del Rey', 16, 5, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (450, 'Argelaguer', 17, 1, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (451, 'Aldeire', 18, 7, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (452, 'Alcolea de las Peñas', 19, 0, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (453, 'Anoeta', 20, 4, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (454, 'Ayamonte', 21, 1, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (455, 'Bailén', 23, 2, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (456, 'Bañeza, La', 24, 7, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (457, 'Alcanó', 25, 0, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (458, 'Alesón', 26, 3, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (459, 'Castro de Rei', 27, 9, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (460, 'Alpedrete', 28, 5, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (461, 'Almargen', 29, 8, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (462, 'Beniel', 30, 2, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (463, 'Altsasu/Alsasua', 31, 9, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (464, 'Beade', 32, 4, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (465, 'Candamo', 33, 0, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (466, 'Ampudia', 34, 5, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (467, 'Haría', 35, 8, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (468, 'Catoira', 36, 1, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (469, 'Alberca, La', 37, 7, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (470, 'Buenavista del Norte', 38, 3, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (471, 'Bárcena de Pie de Concha', 39, 6, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (472, 'Aldeanueva del Codonal', 40, 0, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (473, 'Almensilla', 41, 7, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (474, 'Aldealices', 42, 2, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (475, 'Alió', 43, 8, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (476, 'Albentosa', 44, 3, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (477, 'Aldeanueva de San Bartolomé', 45, 6, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (478, 'Albalat dels Tarongers', 46, 9, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (479, 'Arroyo de la Encomienda', 47, 5, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (480, 'Arrieta', 48, 1, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (481, 'Arcenillas', 49, 4, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (482, 'Alberite de San Juan', 50, 7, 10);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (483, 'Baños de Ebro/Mañueta', 1, 2, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (484, 'Ayna', 2, 7, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (485, 'Alfàs del Pi, l''', 3, 3, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (486, 'Alhama de Almería', 4, 8, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (487, 'Almendralejo', 6, 4, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (488, 'Calvià', 7, 0, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (489, 'Avià', 8, 6, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (490, 'Alfoz de Bricia', 9, 9, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (491, 'Aldeacentenera', 10, 3, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (492, 'Bosque, El', 11, 0, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (493, 'Almenara', 12, 5, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (494, 'Almadén', 13, 1, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (495, 'Blázquez, Los', 14, 6, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (496, 'Boiro', 15, 9, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (497, 'Alcohujate', 16, 2, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (498, 'Armentera, L''', 17, 8, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (499, 'Alfacar', 18, 4, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (500, 'Alcolea del Pinar', 19, 7, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (501, 'Antzuola', 20, 1, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (502, 'Beas', 21, 8, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (503, 'Albero Alto', 22, 3, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (504, 'Baños de la Encina', 23, 9, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (505, 'Barjas', 24, 4, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (506, 'Alcarràs', 25, 7, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (507, 'Alfaro', 26, 0, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (508, 'Castroverde', 27, 6, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (509, 'Ambite', 28, 2, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (510, 'Almogía', 29, 5, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (511, 'Blanca', 30, 9, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (512, 'Allín/Allin', 31, 6, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (513, 'Beariz', 32, 1, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (514, 'Cangas del Narcea', 33, 7, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (515, 'Amusco', 34, 2, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (516, 'Ingenio', 35, 5, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (517, 'Cerdedo', 36, 8, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (518, 'Alberguería de Argañán, La', 37, 4, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (519, 'Candelaria', 38, 0, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (520, 'Bareyo', 39, 3, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (521, 'Arahal', 41, 4, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (522, 'Aldealpozo', 42, 9, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (523, 'Almoster', 43, 5, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (524, 'Alcaine', 44, 0, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (525, 'Almendral de la Cañada', 45, 3, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (526, 'Alberic', 46, 6, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (527, 'Ataquines', 47, 2, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (528, 'Arrigorriaga', 48, 8, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (529, 'Arcos de la Polvorosa', 49, 1, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (530, 'Albeta', 50, 4, 11);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (531, 'Balazote', 2, 2, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (532, 'Algorfa', 3, 8, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (533, 'Alicún', 4, 3, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (534, 'Amavida', 5, 6, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (535, 'Arroyo de San Serván', 6, 9, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (536, 'Campanet', 7, 5, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (537, 'Avinyó', 8, 1, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (538, 'Alfoz de Santa Gadea', 9, 4, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (539, 'Aldea del Cano', 10, 8, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (540, 'Cádiz', 11, 5, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (541, 'Altura', 12, 0, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (542, 'Almadenejos', 13, 6, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (543, 'Bujalance', 14, 1, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (544, 'Boqueixón', 15, 4, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (545, 'Alconchel de la Estrella', 16, 7, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (546, 'Avinyonet de Puigventós', 17, 3, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (547, 'Algarinejo', 18, 9, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (548, 'Arama', 20, 6, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (549, 'Berrocal', 21, 3, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (550, 'Albero Bajo', 22, 8, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (551, 'Beas de Segura', 23, 4, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (552, 'Barrios de Luna, Los', 24, 9, 12);\n" ;
    public static String INSERTS_DB_7 =
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (553, 'Alcoletge', 25, 2, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (554, 'Almarza de Cameros', 26, 5, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (555, 'Cervantes', 27, 1, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (556, 'Anchuelo', 28, 7, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (557, 'Álora', 29, 0, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (558, 'Bullas', 30, 4, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (559, 'Allo', 31, 1, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (560, 'Blancos, Os', 32, 6, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (561, 'Cangas de Onís', 33, 2, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (562, 'Antigüedad', 34, 7, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (563, 'Mogán', 35, 0, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (564, 'Cotobade', 36, 3, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (565, 'Alconada', 37, 9, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (566, 'Fasnia', 38, 5, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (567, 'Cabezón de la Sal', 39, 8, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (568, 'Aldea Real', 40, 2, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (569, 'Aznalcázar', 41, 9, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (570, 'Aldealseñor', 42, 4, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (571, 'Altafulla', 43, 0, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (572, 'Alcalá de la Selva', 44, 5, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (573, 'Almonacid de Toledo', 45, 8, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (574, 'Alborache', 46, 1, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (575, 'Bahabón', 47, 7, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (576, 'Bakio', 48, 3, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (577, 'Argañín', 49, 6, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (578, 'Alborge', 50, 9, 12);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (579, 'Barrundia', 1, 3, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (580, 'Balsa de Ves', 2, 8, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (581, 'Algueña', 3, 4, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (582, 'Almería', 4, 9, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (583, 'Arenal, El', 5, 2, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (584, 'Atalaya', 6, 5, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (585, 'Campos', 7, 1, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (586, 'Avinyonet del Penedès', 8, 7, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (587, 'Altable', 9, 0, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (588, 'Aldea del Obispo, La', 10, 4, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (589, 'Castellar de la Frontera', 11, 1, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (590, 'Arañuel', 12, 6, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (591, 'Almagro', 13, 2, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (592, 'Cabra', 14, 7, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (593, 'Brión', 15, 0, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (594, 'Algarra', 16, 3, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (595, 'Begur', 17, 9, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (596, 'Alhama de Granada', 18, 5, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (597, 'Alcoroches', 19, 8, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (598, 'Aretxabaleta', 20, 2, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (599, 'Bollullos Par del Condado', 21, 9, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (600, 'Alberuela de Tubo', 22, 4, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (601, 'Alfarràs', 25, 8, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (602, 'Anguciana', 26, 1, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (603, 'Cervo', 27, 7, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (604, 'Aranjuez', 28, 3, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (605, 'Alozaina', 29, 6, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (606, 'Calasparra', 30, 0, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (607, 'Améscoa Baja', 31, 7, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (608, 'Boborás', 32, 2, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (609, 'Caravia', 33, 8, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (610, 'Moya', 35, 6, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (611, 'Covelo', 36, 9, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (612, 'Aldeacipreste', 37, 5, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (613, 'Frontera', 38, 1, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (614, 'Cabezón de Liébana', 39, 4, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (615, 'Aldeasoña', 40, 8, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (616, 'Aznalcóllar', 41, 5, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (617, 'Aldehuela de Periáñez', 42, 0, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (618, 'Ametlla de Mar, L''', 43, 6, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (619, 'Alcañiz', 44, 1, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (620, 'Almorox', 45, 4, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (621, 'Alboraya', 46, 7, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (622, 'Barcial de la Loma', 47, 3, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (623, 'Barakaldo', 48, 9, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (624, 'Argujillo', 49, 2, 13);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (625, 'Alcalá de Ebro', 50, 5, 13);\n";
    public static String INSERTS_DB__8 =    "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (626, 'Berantevilla', 1, 8, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (627, 'Ballestero, El', 2, 3, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (628, 'Alicante/Alacant', 3, 9, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (629, 'Almócita', 4, 4, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (630, 'Arenas de San Pedro', 5, 7, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (631, 'Azuaga', 6, 0, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (632, 'Capdepera', 7, 6, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (633, 'Aiguafreda', 8, 2, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (634, 'Altos, Los', 9, 5, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (635, 'Aldeanueva de la Vera', 10, 9, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (636, 'Conil de la Frontera', 11, 6, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (637, 'Ares del Maestrat', 12, 1, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (638, 'Almedina', 13, 7, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (639, 'Cañete de las Torres', 14, 2, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (640, 'Cabana de Bergantiños', 15, 5, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (641, 'Aliaguilla', 16, 8, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (642, 'Vajol, La', 17, 4, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (643, 'Alhendín', 18, 0, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (644, 'Asteasu', 20, 7, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (645, 'Bonares', 21, 4, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (646, 'Alcalá de Gurrea', 22, 9, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (647, 'Begíjar', 23, 5, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (648, 'Bembibre', 24, 0, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (649, 'Alfés', 25, 3, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (650, 'Anguiano', 26, 6, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (651, 'Corgo, O', 27, 2, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (652, 'Arganda del Rey', 28, 8, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (653, 'Alpandeire', 29, 1, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (654, 'Campos del Río', 30, 5, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (655, 'Ancín/Antzin', 31, 2, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (656, 'Bola, A', 32, 7, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (657, 'Carreño', 33, 3, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (658, 'Oliva, La', 35, 1, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (659, 'Crecente', 36, 4, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (660, 'Aldeadávila de la Ribera', 37, 0, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (661, 'Fuencaliente de la Palma', 38, 6, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (662, 'Cabuérniga', 39, 9, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (663, 'Aldehorno', 40, 3, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (664, 'Badolatosa', 41, 0, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (665, 'Aldehuelas, Las', 42, 5, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (666, 'Amposta', 43, 1, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (667, 'Alcorisa', 44, 6, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (668, 'Añover de Tajo', 45, 9, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (669, 'Albuixech', 46, 2, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (670, 'Barruelo del Valle', 47, 8, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (671, 'Barrika', 48, 4, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (672, 'Arquillinos', 49, 7, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (673, 'Alcalá de Moncayo', 50, 0, 14);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (674, 'Barrax', 2, 6, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (675, 'Almoradí', 3, 2, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (676, 'Alsodux', 4, 7, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (677, 'Arevalillo', 5, 0, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (678, 'Badajoz', 6, 3, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (679, 'Ciutadella de Menorca', 7, 9, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (680, 'Badalona', 8, 5, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (681, 'Aldeanueva del Camino', 10, 2, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (682, 'Chiclana de la Frontera', 11, 9, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (683, 'Argelita', 12, 4, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (684, 'Almodóvar del Campo', 13, 0, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (685, 'Carcabuey', 14, 5, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (686, 'Cabanas', 15, 8, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (687, 'Almarcha, La', 16, 1, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (688, 'Banyoles', 17, 7, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (689, 'Alicún de Ortega', 18, 3, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (690, 'Aldeanueva de Guadalajara', 19, 6, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (691, 'Ataun', 20, 0, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (692, 'Cabezas Rubias', 21, 7, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (693, 'Alcalá del Obispo', 22, 2, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (694, 'Bélmez de la Moraleda', 23, 8, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (695, 'Benavides', 24, 3, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (696, 'Algerri', 25, 6, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (697, 'Arenzana de Abajo', 26, 9, 15);\n" ;
    public static String INSERTS_DB_9 =
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (698, 'Cospeito', 27, 5, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (699, 'Arroyomolinos', 28, 1, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (700, 'Antequera', 29, 4, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (701, 'Caravaca de la Cruz', 30, 8, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (702, 'Andosilla', 31, 5, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (703, 'Bolo, O', 32, 0, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (704, 'Caso', 33, 6, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (705, 'Arconada', 34, 1, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (706, 'Pájara', 35, 4, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (707, 'Cuntis', 36, 7, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (708, 'Aldea del Obispo', 37, 3, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (709, 'Garachico', 38, 9, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (710, 'Camaleño', 39, 2, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (711, 'Aldehuela del Codonal', 40, 6, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (712, 'Benacazón', 41, 3, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (713, 'Alentisque', 42, 8, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (714, 'Arbolí', 43, 4, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (715, 'Arcicóllar', 45, 2, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (716, 'Alcàsser', 46, 5, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (717, 'Becilla de Valderaduey', 47, 1, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (718, 'Basauri', 48, 7, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (719, 'Arrabalde', 49, 0, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (720, 'Alconchel de Ariza', 50, 3, 15);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (721, 'Bernedo', 1, 4, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (722, 'Bienservida', 2, 9, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (723, 'Almudaina', 3, 5, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (724, 'Antas', 4, 0, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (725, 'Arévalo', 5, 3, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (726, 'Barcarrota', 6, 6, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (727, 'Consell', 7, 2, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (728, 'Bagà', 8, 8, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (729, 'Ameyugo', 9, 1, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (730, 'Aldehuela de Jerte', 10, 5, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (731, 'Chipiona', 11, 2, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (732, 'Artana', 12, 7, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (733, 'Almuradiel', 13, 3, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (734, 'Cardeña', 14, 8, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (735, 'Camariñas', 15, 1, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (736, 'Almendros', 16, 4, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (737, 'Bàscara', 17, 0, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (738, 'Almegíjar', 18, 6, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (739, 'Algar de Mesa', 19, 9, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (740, 'Aia', 20, 3, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (741, 'Cala', 21, 0, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (742, 'Alcampell', 22, 5, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (743, 'Benatae', 23, 1, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (744, 'Benuza', 24, 6, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (745, 'Alguaire', 25, 9, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (746, 'Arenzana de Arriba', 26, 2, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (747, 'Chantada', 27, 8, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (748, 'Atazar, El', 28, 4, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (749, 'Árchez', 29, 7, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (750, 'Cartagena', 30, 1, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (751, 'Ansoáin/Antsoain', 31, 8, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (752, 'Calvos de Randín', 32, 3, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (753, 'Castrillón', 33, 9, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (754, 'Palmas de Gran Canaria, Las', 35, 7, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (755, 'Dozón', 36, 0, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (756, 'Aldealengua', 37, 6, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (757, 'Garafía', 38, 2, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (758, 'Camargo', 39, 5, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (759, 'Aldeonte', 40, 9, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (760, 'Bollullos de la Mitación', 41, 6, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (761, 'Aliud', 42, 1, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (762, 'Arboç, L''', 43, 7, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (763, 'Alfambra', 44, 2, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (764, 'Argés', 45, 5, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (765, 'Alcàntera de Xúquer', 46, 8, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (766, 'Benafarces', 47, 4, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (767, 'Berango', 48, 0, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (768, 'Aspariegos', 49, 3, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (769, 'Aldehuela de Liestos', 50, 6, 16);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (770, 'Campezo/Kanpezu', 1, 0, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (771, 'Bogarra', 2, 5, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (772, 'Alqueria d''Asnar, l''', 3, 1, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (773, 'Arboleas', 4, 6, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (774, 'Aveinte', 5, 9, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (775, 'Baterno', 6, 2, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (776, 'Costitx', 7, 8, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (777, 'Balenyà', 8, 4, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (778, 'Anguix', 9, 7, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (779, 'Alía', 10, 1, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (780, 'Espera', 11, 8, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (781, 'Ayódar', 12, 3, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (782, 'Anchuras', 13, 9, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (783, 'Carlota, La', 14, 4, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (784, 'Cambre', 15, 7, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (785, 'Almodóvar del Pinar', 16, 0, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (786, 'Almuñécar', 18, 2, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (787, 'Algora', 19, 5, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (788, 'Azkoitia', 20, 9, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (789, 'Calañas', 21, 6, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (790, 'Alcolea de Cinca', 22, 1, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (791, 'Cabra del Santo Cristo', 23, 7, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (792, 'Bercianos del Páramo', 24, 2, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (793, 'Alins', 25, 5, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (794, 'Arnedillo', 26, 8, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (795, 'Folgoso do Courel', 27, 4, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (796, 'Batres', 28, 0, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (797, 'Archidona', 29, 3, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (798, 'Cehegín', 30, 7, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (799, 'Anue', 31, 4, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (800, 'Carballeda de Valdeorras', 32, 9, 17);\n" ;
    public static String INSERTS_DB_10 =
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (801, 'Castropol', 33, 5, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (802, 'Astudillo', 34, 0, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (803, 'Puerto del Rosario', 35, 3, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (804, 'Estrada, A', 36, 6, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (805, 'Aldeanueva de Figueroa', 37, 2, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (806, 'Granadilla de Abona', 38, 8, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (807, 'Campoo de Yuso', 39, 1, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (808, 'Anaya', 40, 5, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (809, 'Bormujos', 41, 2, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (810, 'Almajano', 42, 7, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (811, 'Argentera, L''', 43, 3, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (812, 'Aliaga', 44, 8, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (813, 'Azután', 45, 1, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (814, 'Alzira', 46, 4, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (815, 'Bercero', 47, 0, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (816, 'Bermeo', 48, 6, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (817, 'Asturianos', 49, 9, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (818, 'Alfajarín', 50, 2, 17);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (819, 'Zigoitia', 1, 6, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (820, 'Bonete', 2, 1, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (821, 'Altea', 3, 7, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (822, 'Armuña de Almanzora', 4, 2, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (823, 'Avellaneda', 5, 5, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (824, 'Benquerencia de la Serena', 6, 8, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (825, 'Deyá', 7, 4, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (826, 'Balsareny', 8, 0, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (827, 'Aranda de Duero', 9, 3, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (828, 'Aliseda', 10, 7, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (829, 'Gastor, El', 11, 4, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (830, 'Azuébar', 12, 9, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (831, 'Arenas de San Juan', 13, 5, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (832, 'Carpio, El', 14, 0, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (833, 'Capela, A', 15, 3, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (834, 'Almonacid del Marquesado', 16, 6, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (835, 'Bellcaire d''Empordà', 17, 2, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (836, 'Alquife', 18, 8, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (837, 'Alhóndiga', 19, 1, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (838, 'Azpeitia', 20, 5, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (839, 'Campillo, El', 21, 2, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (840, 'Alcubierre', 22, 7, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (841, 'Cambil', 23, 3, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (842, 'Bercianos del Real Camino', 24, 8, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (843, 'Arnedo', 26, 4, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (844, 'Fonsagrada, A', 27, 0, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (845, 'Becerril de la Sierra', 28, 6, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (846, 'Ardales', 29, 9, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (847, 'Ceutí', 30, 3, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (848, 'Añorbe', 31, 0, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (849, 'Carballeda de Avia', 32, 5, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (850, 'Coaña', 33, 1, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (851, 'Autilla del Pino', 34, 6, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (852, 'San Bartolomé', 35, 9, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (853, 'Forcarei', 36, 2, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (854, 'Aldeanueva de la Sierra', 37, 8, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (855, 'Guancha, La', 38, 4, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (856, 'Cartes', 39, 7, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (857, 'Añe', 40, 1, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (858, 'Brenes', 41, 8, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (859, 'Almaluez', 42, 3, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (860, 'Arnes', 43, 9, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (861, 'Almohaja', 44, 4, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (862, 'Barcience', 45, 7, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (863, 'Alcublas', 46, 0, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (864, 'Berceruelo', 47, 6, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (865, 'Berriatua', 48, 2, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (866, 'Ayoó de Vidriales', 49, 5, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (867, 'Alfamén', 50, 8, 18);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (868, 'Kripan', 1, 9, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (869, 'Bonillo, El', 2, 4, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (870, 'Aspe', 3, 0, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (871, 'Bacares', 4, 5, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (872, 'Ávila', 5, 8, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (873, 'Berlanga', 6, 1, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (874, 'Escorca', 7, 7, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (875, 'Barcelona', 8, 3, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (876, 'Arandilla', 9, 6, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (877, 'Almaraz', 10, 0, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (878, 'Grazalema', 11, 7, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (879, 'Argamasilla de Alba', 13, 8, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (880, 'Castro del Río', 14, 3, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (881, 'Carballo', 15, 6, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (882, 'Altarejos', 16, 9, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (883, 'Besalú', 17, 5, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (884, 'Alique', 19, 4, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (885, 'Beasain', 20, 8, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (886, 'Campofrío', 21, 5, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (887, 'Alerre', 22, 0, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (888, 'Campillo de Arenas', 23, 6, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (889, 'Berlanga del Bierzo', 24, 1, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (890, 'Almacelles', 25, 4, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (891, 'Arrúbal', 26, 7, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (892, 'Foz', 27, 3, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (893, 'Belmonte de Tajo', 28, 9, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (894, 'Arenas', 29, 2, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (895, 'Cieza', 30, 6, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (896, 'Aoiz/Agoitz', 31, 3, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (897, 'Carballiño, O', 32, 8, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (898, 'Colunga', 33, 4, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (899, 'Autillo de Campos', 34, 9, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (900, 'San Bartolomé de Tirajana', 35, 2, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (901, 'Fornelos de Montes', 36, 5, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (902, 'Aldearrodrigo', 37, 1, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (903, 'Guía de Isora', 38, 7, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (904, 'Castañeda', 39, 0, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (905, 'Arahuetes', 40, 4, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (906, 'Burguillos', 41, 1, 19);\n" ;
    public static String INSERTS_DB_11 =
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (907, 'Almarza', 42, 6, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (908, 'Ascó', 43, 2, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (909, 'Alobras', 44, 7, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (910, 'Bargas', 45, 0, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (911, 'Alcúdia, l''', 46, 3, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (912, 'Berrueces', 47, 9, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (913, 'Berriz', 48, 5, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (914, 'Barcial del Barco', 49, 8, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (915, 'Alforque', 50, 1, 19);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (916, 'Kuartango', 1, 3, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (917, 'Carcelén', 2, 8, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (918, 'Balones', 3, 4, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (919, 'Bayárcal', 4, 9, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (920, 'Bienvenida', 6, 5, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (921, 'Esporles', 7, 1, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (922, 'Begues', 8, 7, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (923, 'Arauzo de Miel', 9, 0, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (924, 'Almoharín', 10, 4, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (925, 'Jerez de la Frontera', 11, 1, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (926, 'Barracas', 12, 6, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (927, 'Argamasilla de Calatrava', 13, 2, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (928, 'Conquista', 14, 7, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (929, 'Carnota', 15, 0, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (930, 'Arandilla del Arroyo', 16, 3, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (931, 'Bescanó', 17, 9, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (932, 'Arenas del Rey', 18, 5, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (933, 'Almadrones', 19, 8, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (934, 'Beizama', 20, 2, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (935, 'Cañaveral de León', 21, 9, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (936, 'Alfántega', 22, 4, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (937, 'Canena', 23, 0, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (938, 'Boca de Huérgano', 24, 5, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (939, 'Almatret', 25, 8, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (940, 'Ausejo', 26, 1, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (941, 'Friol', 27, 7, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (942, 'Berzosa del Lozoya', 28, 3, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (943, 'Arriate', 29, 6, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (944, 'Fortuna', 30, 0, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (945, 'Araitz', 31, 7, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (946, 'Cartelle', 32, 2, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (947, 'Corvera de Asturias', 33, 8, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (948, 'Ayuela', 34, 3, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (949, 'Aldea de San Nicolás, La', 35, 6, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (950, 'Agolada', 36, 9, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (951, 'Aldearrubia', 37, 5, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (952, 'Güímar', 38, 1, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (953, 'Castro-Urdiales', 39, 4, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (954, 'Arcones', 40, 8, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (955, 'Cabezas de San Juan, Las', 41, 5, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (956, 'Almazán', 42, 0, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (957, 'Banyeres del Penedès', 43, 6, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (958, 'Alpeñés', 44, 1, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (959, 'Belvís de la Jara', 45, 4, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (960, 'Alcúdia de Crespins, l''', 46, 7, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (961, 'Bobadilla del Campo', 47, 3, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (962, 'Bilbao', 48, 9, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (963, 'Belver de los Montes', 49, 2, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (964, 'Alhama de Aragón', 50, 5, 20);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (965, 'Elburgo/Burgelu', 1, 0, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (966, 'Casas de Juan Núñez', 2, 5, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (967, 'Banyeres de Mariola', 3, 1, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (968, 'Bayarque', 4, 6, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (969, 'Barco de Ávila, El', 5, 9, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (970, 'Bodonal de la Sierra', 6, 2, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (971, 'Estellencs', 7, 8, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (972, 'Bellprat', 8, 4, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (973, 'Arauzo de Salce', 9, 7, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (974, 'Arroyo de la Luz', 10, 1, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (975, 'Jimena de la Frontera', 11, 8, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (976, 'Betxí', 12, 3, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (977, 'Arroba de los Montes', 13, 9, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (978, 'Córdoba', 14, 4, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (979, 'Carral', 15, 7, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (980, 'Beuda', 17, 6, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (981, 'Armilla', 18, 2, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (982, 'Almoguera', 19, 5, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (983, 'Belauntza', 20, 9, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (984, 'Cartaya', 21, 6, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (985, 'Almudévar', 22, 1, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (986, 'Carboneros', 23, 7, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (987, 'Boñar', 24, 2, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (988, 'Almenar', 25, 5, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (989, 'Autol', 26, 8, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (990, 'Xermade', 27, 4, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (991, 'Berrueco, El', 28, 0, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (992, 'Atajate', 29, 3, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (993, 'Fuente Álamo de Murcia', 30, 7, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (994, 'Aranarache/Aranaratxe', 31, 4, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (995, 'Castrelo do Val', 32, 9, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (996, 'Cudillero', 33, 5, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (997, 'Santa Brígida', 35, 3, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (998, 'Gondomar', 36, 6, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (999, 'Aldeaseca de Alba', 37, 2, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1000, 'Hermigua', 38, 8, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1001, 'Cieza', 39, 1, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1002, 'Arevalillo de Cega', 40, 5, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1003, 'Camas', 41, 2, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1004, 'Almazul', 42, 7, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1005, 'Barberà de la Conca', 43, 3, 21);\n" ;
    public static String INSERTS_DB_12 =
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1006, 'Allepuz', 44, 8, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1007, 'Borox', 45, 1, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1008, 'Aldaia', 46, 4, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1009, 'Bocigas', 47, 0, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1010, 'Busturia', 48, 6, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1011, 'Benavente', 49, 9, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1012, 'Almochuel', 50, 2, 21);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1013, 'Elciego', 1, 5, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1014, 'Casas de Lázaro', 2, 0, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1015, 'Benasau', 3, 6, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1016, 'Bédar', 4, 1, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1017, 'Barraco, El', 5, 4, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1018, 'Burguillos del Cerro', 6, 7, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1019, 'Felanitx', 7, 3, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1020, 'Berga', 8, 9, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1021, 'Arauzo de Torre', 9, 2, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1022, 'Arroyomolinos de la Vera', 10, 6, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1023, 'Línea de la Concepción, La', 11, 3, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1024, 'Bejís', 12, 8, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1025, 'Ballesteros de Calatrava', 13, 4, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1026, 'Doña Mencía', 14, 9, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1027, 'Cedeira', 15, 2, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1028, 'Arcos de la Sierra', 16, 5, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1029, 'Bisbal d''Empordà, La', 17, 1, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1030, 'Atarfe', 18, 7, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1031, 'Almonacid de Zorita', 19, 0, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1032, 'Berastegi', 20, 4, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1033, 'Castaño del Robledo', 21, 1, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1034, 'Almunia de San Juan', 22, 6, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1035, 'Borrenes', 24, 7, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1036, 'Alòs de Balaguer', 25, 0, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1037, 'Azofra', 26, 3, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1038, 'Guitiriz', 27, 9, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1039, 'Boadilla del Monte', 28, 5, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1040, 'Benadalid', 29, 8, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1041, 'Jumilla', 30, 2, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1042, 'Arantza', 31, 9, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1043, 'Castrelo de Miño', 32, 4, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1044, 'Degaña', 33, 0, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1045, 'Baltanás', 34, 5, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1046, 'Santa Lucía de Tirajana', 35, 8, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1047, 'Grove, O', 36, 1, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1048, 'Aldeaseca de la Frontera', 37, 7, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1049, 'Icod de los Vinos', 38, 3, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1050, 'Cillorigo de Liébana', 39, 6, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1051, 'Armuña', 40, 0, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1052, 'Campana, La', 41, 7, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1053, 'Almenar de Soria', 42, 2, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1054, 'Batea', 43, 8, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1055, 'Alloza', 44, 3, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1056, 'Buenaventura', 45, 6, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1057, 'Alfafar', 46, 9, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1058, 'Bocos de Duero', 47, 5, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1059, 'Karrantza Harana/Valle de Carranza', 48, 1, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1060, 'Benegiles', 49, 4, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1061, 'Almolda, La', 50, 7, 22);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1062, 'Elvillar/Bilar', 1, 1, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1063, 'Casas de Ves', 2, 6, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1064, 'Beneixama', 3, 2, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1065, 'Beires', 4, 7, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1066, 'Barromán', 5, 0, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1067, 'Cabeza del Buey', 6, 3, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1068, 'Ferreries', 7, 9, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1069, 'Bigues i Riells', 8, 5, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1070, 'Arcos', 9, 8, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1071, 'Arroyomolinos', 10, 2, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1072, 'Medina-Sidonia', 11, 9, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1073, 'Bolaños de Calatrava', 13, 0, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1074, 'Dos Torres', 14, 5, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1075, 'Cee', 15, 8, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1076, 'Chillarón de Cuenca', 16, 1, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1077, 'Blanes', 17, 7, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1078, 'Baza', 18, 3, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1079, 'Alocén', 19, 6, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1080, 'Berrobi', 20, 0, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1081, 'Cerro de Andévalo, El', 21, 7, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1082, 'Almuniente', 22, 2, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1083, 'Brazuelo', 24, 3, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1084, 'Alpicat', 25, 6, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1085, 'Badarán', 26, 9, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1086, 'Guntín', 27, 5, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1087, 'Boalo, El', 28, 1, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1088, 'Benahavís', 29, 4, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1089, 'Librilla', 30, 8, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1090, 'Aranguren', 31, 5, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1091, 'Castro Caldelas', 32, 0, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1092, 'Franco, El', 33, 6, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1093, 'Venta de Baños', 34, 1, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1094, 'Santa María de Guía de Gran Canaria', 35, 4, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1095, 'Guarda, A', 36, 7, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1096, 'Aldeatejada', 37, 3, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1097, 'San Cristóbal de La Laguna', 38, 9, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1098, 'Colindres', 39, 2, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1099, 'Cantillana', 41, 3, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1100, 'Alpanseque', 42, 8, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1101, 'Bellmunt del Priorat', 43, 4, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1102, 'Allueva', 44, 9, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1103, 'Burguillos de Toledo', 45, 2, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1104, 'Alfauir', 46, 5, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1105, 'Boecillo', 47, 1, 23);\n" ;
    public static String INSERTS_DB_13 =
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1106, 'Artea', 48, 7, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1107, 'Bermillo de Sayago', 49, 0, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1108, 'Almonacid de la Cuba', 50, 3, 23);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1109, 'Casas-Ibáñez', 2, 1, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1110, 'Benejúzar', 3, 7, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1111, 'Benahadux', 4, 2, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1112, 'Becedas', 5, 5, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1113, 'Cabeza la Vaca', 6, 8, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1114, 'Formentera', 7, 4, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1115, 'Borredà', 8, 0, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1116, 'Arenillas de Riopisuerga', 9, 3, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1117, 'Baños de Montemayor', 10, 7, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1118, 'Olvera', 11, 4, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1119, 'Benafer', 12, 9, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1120, 'Brazatortas', 13, 5, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1121, 'Encinas Reales', 14, 0, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1122, 'Cerceda', 15, 3, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1123, 'Arguisuelas', 16, 6, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1124, 'Bolvir', 17, 2, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1125, 'Beas de Granada', 18, 8, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1126, 'Alovera', 19, 1, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1127, 'Bidegoian', 20, 5, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1128, 'Corteconcepción', 21, 2, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1129, 'Alquézar', 22, 7, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1130, 'Carolina, La', 23, 3, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1131, 'Burgo Ranero, El', 24, 8, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1132, 'Alt Àneu', 25, 1, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1133, 'Bañares', 26, 4, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1134, 'Incio, O', 27, 0, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1135, 'Braojos', 28, 6, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1136, 'Benalauría', 29, 9, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1137, 'Lorca', 30, 3, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1138, 'Arano', 31, 0, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1139, 'Celanova', 32, 5, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1140, 'Gijón', 33, 1, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1141, 'Baquerín de Campos', 34, 6, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1142, 'Teguise', 35, 9, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1143, 'Lalín', 36, 2, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1144, 'Aldeavieja de Tormes', 37, 8, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1145, 'Llanos de Aridane, Los', 38, 4, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1146, 'Comillas', 39, 7, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1147, 'Ayllón', 40, 1, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1148, 'Carmona', 41, 8, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1149, 'Arancón', 42, 3, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1150, 'Bellvei', 43, 9, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1151, 'Anadón', 44, 4, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1152, 'Burujón', 45, 7, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1153, 'Alfara de la Baronia', 46, 0, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1154, 'Bolaños de Campos', 47, 6, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1155, 'Zeanuri', 48, 2, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1156, 'Bóveda de Toro, La', 49, 5, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1157, 'Almonacid de la Sierra', 50, 8, 24);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1158, 'Caudete', 2, 4, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1159, 'Benferri', 3, 0, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1160, 'Becedillas', 5, 8, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1161, 'Calamonte', 6, 1, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1162, 'Fornalutx', 7, 7, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1163, 'Bruc, El', 8, 3, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1164, 'Arija', 9, 6, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1165, 'Barrado', 10, 0, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1166, 'Paterna de Rivera', 11, 7, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1167, 'Benafigos', 12, 2, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1168, 'Cabezarados', 13, 8, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1169, 'Espejo', 14, 3, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1170, 'Cerdido', 15, 6, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1171, 'Arrancacepas', 16, 9, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1172, 'Bordils', 17, 5, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1173, 'Beas de Guadix', 18, 1, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1174, 'Zegama', 20, 8, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1175, 'Cortegana', 21, 5, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1176, 'Altorricón', 22, 0, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1177, 'Castellar', 23, 6, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1178, 'Burón', 24, 1, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1179, 'Naut Aran', 25, 4, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1180, 'Baños de Rioja', 26, 7, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1181, 'Xove', 27, 3, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1182, 'Brea de Tajo', 28, 9, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1183, 'Benalmádena', 29, 2, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1184, 'Lorquí', 30, 6, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1185, 'Arakil', 31, 3, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1186, 'Cenlle', 32, 8, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1187, 'Gozón', 33, 4, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1188, 'Bárcena de Campos', 34, 9, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1189, 'Tejeda', 35, 2, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1190, 'Lama, A', 36, 5, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1191, 'Aldehuela de la Bóveda', 37, 1, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1192, 'Matanza de Acentejo, La', 38, 7, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1193, 'Corrales de Buelna, Los', 39, 0, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1194, 'Barbolla', 40, 4, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1195, 'Carrión de los Céspedes', 41, 1, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1196, 'Arcos de Jalón', 42, 6, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1197, 'Benifallet', 43, 2, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1198, 'Andorra', 44, 7, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1199, 'Cabañas de la Sagra', 45, 0, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1200, 'Alfara del Patriarca', 46, 3, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1201, 'Brahojos de Medina', 47, 9, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1202, 'Zeberio', 48, 5, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1203, 'Bretó', 49, 8, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1204, 'Almunia de Doña Godina, La', 50, 1, 25);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1205, 'Cenizate', 2, 7, 26);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1206, 'Beniarbeig', 3, 3, 26);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1207, 'Benitagla', 4, 8, 26);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1208, 'Bercial de Zapardiel', 5, 1, 26);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1209, 'Calera de León', 6, 4, 26);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1210, 'Eivissa', 7, 0, 26);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1211, 'Brull, El', 8, 6, 26);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1212, 'Arlanzón', 9, 9, 26);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1213, 'Belvís de Monroy', 10, 3, 26);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1214, 'Prado del Rey', 11, 0, 26);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1215, 'Benasal', 12, 5, 26);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1216, 'Cabezarrubias del Puerto', 13, 1, 26);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1217, 'Espiel', 14, 6, 26);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1218, 'Cesuras', 15, 9, 26);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1219, 'Atalaya del Cañavate', 16, 2, 26);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1220, 'Borrassà', 17, 8, 26);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1221, 'Zerain', 20, 1, 26);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1222, 'Cortelazor', 21, 8, 26);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1223, 'Castillo de Locubín', 23, 9, 26);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1224, 'Bustillo del Páramo', 24, 4, 26);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1225, 'Baños de Río Tobía', 26, 0, 26);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1226, 'Láncara', 27, 6, 26);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1227, 'Brunete', 28, 2, 26);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1228, 'Benamargosa', 29, 5, 26);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1229, 'Mazarrón', 30, 9, 26);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1230, 'Aras', 31, 6, 26);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1231, 'Coles', 32, 1, 26);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1232, 'Grado', 33, 7, 26);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1233, 'Telde', 35, 5, 26);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1234, 'Marín', 36, 8, 26);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1235, 'Aldehuela de Yeltes', 37, 4, 26);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1236, 'Orotava, La', 38, 0, 26);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1237, 'Corvera de Toranzo', 39, 3, 26);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1238, 'Basardilla', 40, 7, 26);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1239, 'Casariche', 41, 4, 26);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1240, 'Arenillas', 42, 9, 26);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1241, 'Benissanet', 43, 5, 26);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1242, 'Arcos de las Salinas', 44, 0, 26);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1243, 'Cabañas de Yepes', 45, 3, 26);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1244, 'Alfarp', 46, 6, 26);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1245, 'Bustillo de Chaves', 47, 2, 26);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1246, 'Dima', 48, 8, 26);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1247, 'Bretocino', 49, 1, 26);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1248, 'Alpartir', 50, 4, 26);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1249, 'Iruraiz-Gauna', 1, 8, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1250, 'Corral-Rubio', 2, 3, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1251, 'Beniardá', 3, 9, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1252, 'Benizalón', 4, 4, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1253, 'Berlanas, Las', 5, 7, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1254, 'Calzadilla de los Barros', 6, 0, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1255, 'Inca', 7, 6, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1256, 'Cabanyes, Les', 8, 2, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1257, 'Arraya de Oca', 9, 5, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1258, 'Benquerencia', 10, 9, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1259, 'Puerto de Santa María, El', 11, 6, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1260, 'Benicarló', 12, 1, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1261, 'Calzada de Calatrava', 13, 7, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1262, 'Fernán-Núñez', 14, 2, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1263, 'Coirós', 15, 5, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1264, 'Barajas de Melo', 16, 8, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1265, 'Breda', 17, 4, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1266, 'Benalúa', 18, 0, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1267, 'Alustante', 19, 3, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1268, 'Zestoa', 20, 7, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1269, 'Cumbres de Enmedio', 21, 4, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1270, 'Angüés', 22, 9, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1271, 'Cazalilla', 23, 5, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1272, 'Cabañas Raras', 24, 0, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1273, 'Anglesola', 25, 3, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1274, 'Berceo', 26, 6, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1275, 'Lourenzá', 27, 2, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1276, 'Buitrago del Lozoya', 28, 8, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1277, 'Benamocarra', 29, 1, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1278, 'Molina de Segura', 30, 5, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1279, 'Arbizu', 31, 2, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1280, 'Cortegada', 32, 7, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1281, 'Grandas de Salime', 33, 3, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1282, 'Barruelo de Santullán', 34, 8, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1283, 'Teror', 35, 1, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1284, 'Meaño', 36, 4, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1285, 'Almenara de Tormes', 37, 0, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1286, 'Paso, El', 38, 6, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1287, 'Campoo de Enmedio', 39, 9, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1288, 'Castilblanco de los Arroyos', 41, 0, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1289, 'Arévalo de la Sierra', 42, 5, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1290, 'Bisbal de Falset, La', 43, 1, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1291, 'Arens de Lledó', 44, 6, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1292, 'Cabezamesada', 45, 9, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1293, 'Alfarrasí', 46, 2, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1294, 'Cabezón de Pisuerga', 47, 8, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1295, 'Durango', 48, 4, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1296, 'Brime de Sog', 49, 7, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1297, 'Ambel', 50, 0, 27);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1298, 'Labastida/Bastida', 1, 4, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1299, 'Cotillas', 2, 9, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1300, 'Beniarrés', 3, 5, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1301, 'Bentarique', 4, 0, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1302, 'Campanario', 6, 6, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1303, 'Lloret de Vistalegre', 7, 2, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1304, 'Cabrera d''Anoia', 8, 8, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1305, 'Berrocalejo', 10, 5, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1306, 'Puerto Real', 11, 2, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1307, 'Benicasim/Benicàssim', 12, 7, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1308, 'Campo de Criptana', 13, 3, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1309, 'Fuente la Lancha', 14, 8, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1310, 'Corcubión', 15, 1, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1311, 'Brunyola', 17, 0, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1312, 'Benalúa de las Villas', 18, 6, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1313, 'Zizurkil', 20, 3, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1314, 'Cumbres de San Bartolomé', 21, 0, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1315, 'Ansó', 22, 5, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1316, 'Cazorla', 23, 1, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1317, 'Cabreros del Río', 24, 6, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1318, 'Bergasa', 26, 2, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1319, 'Lugo', 27, 8, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1320, 'Bustarviejo', 28, 4, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1321, 'Benaoján', 29, 7, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1322, 'Moratalla', 30, 1, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1323, 'Arce/Artzi', 31, 8, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1324, 'Cualedro', 32, 3, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1325, 'Ibias', 33, 9, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1326, 'Báscones de Ojeda', 34, 4, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1327, 'Tías', 35, 7, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1328, 'Meis', 36, 0, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1329, 'Almendra', 37, 6, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1330, 'Puerto de la Cruz', 38, 2, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1331, 'Entrambasaguas', 39, 5, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1332, 'Bercial', 40, 9, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1333, 'Castilleja de Guzmán', 41, 6, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1334, 'Ausejo de la Sierra', 42, 1, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1335, 'Bisbal del Penedès, La', 43, 7, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1336, 'Argente', 44, 2, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1337, 'Calera y Chozas', 45, 5, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1338, 'Algar de Palancia', 46, 8, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1339, 'Cabezón de Valderaduey', 47, 4, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1340, 'Ea', 48, 0, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1341, 'Brime de Urz', 49, 3, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1342, 'Anento', 50, 6, 28);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1343, 'Chinchilla de Monte-Aragón', 2, 2, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1344, 'Benigembla', 3, 8, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1345, 'Berja', 4, 3, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1346, 'Bernuy-Zapardiel', 5, 6, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1347, 'Campillo de Llerena', 6, 9, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1348, 'Lloseta', 7, 5, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1349, 'Cabrera de Mar', 8, 1, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1350, 'Atapuerca', 9, 4, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1351, 'Berzocana', 10, 8, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1352, 'Puerto Serrano', 11, 5, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1353, 'Benlloch', 12, 0, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1354, 'Cañada de Calatrava', 13, 6, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1355, 'Fuente Obejuna', 14, 1, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1356, 'Coristanco', 15, 4, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1357, 'Barchín del Hoyo', 16, 7, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1358, 'Boadella i les Escaules', 17, 3, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1359, 'Benamaurel', 18, 9, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1360, 'Deba', 20, 6, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1361, 'Cumbres Mayores', 21, 3, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1362, 'Antillón', 22, 8, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1363, 'Chiclana de Segura', 23, 4, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1364, 'Cabrillanes', 24, 9, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1365, 'Arbeca', 25, 2, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1366, 'Bergasillas Bajera', 26, 5, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1367, 'Meira', 27, 1, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1368, 'Cabanillas de la Sierra', 28, 7, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1369, 'Benarrabá', 29, 0, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1370, 'Mula', 30, 4, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1371, 'Arcos, Los', 31, 1, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1372, 'Chandrexa de Queixa', 32, 6, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1373, 'Illano', 33, 2, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1374, 'Becerril de Campos', 34, 7, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1375, 'Tinajo', 35, 0, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1376, 'Moaña', 36, 3, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1377, 'Anaya de Alba', 37, 9, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1378, 'Puntagorda', 38, 5, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1379, 'Escalante', 39, 8, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1380, 'Bercimuel', 40, 2, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1381, 'Castilleja de la Cuesta', 41, 9, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1382, 'Baraona', 42, 4, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1383, 'Blancafort', 43, 0, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1384, 'Ariño', 44, 5, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1385, 'Caleruela', 45, 8, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1386, 'Algemesí', 46, 1, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1387, 'Cabreros del Monte', 47, 7, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1388, 'Etxebarri', 48, 3, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1389, 'Burganes de Valverde', 49, 6, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1390, 'Aniñón', 50, 9, 29);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1391, 'Lagrán', 1, 1, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1392, 'Elche de la Sierra', 2, 6, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1393, 'Benidoleig', 3, 2, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1394, 'Canjáyar', 4, 7, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1395, 'Berrocalejo de Aragona', 5, 0, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1396, 'Capilla', 6, 3, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1397, 'Llubí', 7, 9, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1398, 'Cabrils', 8, 5, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1399, 'Ausines, Los', 9, 8, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1400, 'Bohonal de Ibor', 10, 2, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1401, 'Rota', 11, 9, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1402, 'Caracuel de Calatrava', 13, 0, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1403, 'Fuente Palmera', 14, 5, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1404, 'Coruña, A', 15, 8, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1405, 'Bascuñana de San Pedro', 16, 1, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1406, 'Cabanes', 17, 7, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1407, 'Bérchules', 18, 3, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1408, 'Eibar', 20, 0, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1409, 'Chucena', 21, 7, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1410, 'Chilluévar', 23, 8, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1411, 'Cacabelos', 24, 3, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1412, 'Pont de Bar, El', 25, 6, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1413, 'Bezares', 26, 9, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1414, 'Mondoñedo', 27, 5, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1415, 'Cabrera, La', 28, 1, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1416, 'Borge, El', 29, 4, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1417, 'Murcia', 30, 8, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1418, 'Arellano', 31, 5, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1419, 'Entrimo', 32, 0, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1420, 'Illas', 33, 6, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1421, 'Tuineje', 35, 4, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1422, 'Mondariz', 36, 7, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1423, 'Añover de Tormes', 37, 3, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1424, 'Puntallana', 38, 9, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1425, 'Guriezo', 39, 2, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1426, 'Bernardos', 40, 6, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1427, 'Castilleja del Campo', 41, 3, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1428, 'Barca', 42, 8, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1429, 'Bonastre', 43, 4, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1430, 'Calzada de Oropesa', 45, 2, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1431, 'Algimia de Alfara', 46, 5, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1432, 'Campaspero', 47, 1, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1433, 'Etxebarria', 48, 7, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1434, 'Bustillo del Oro', 49, 0, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1435, 'Añón de Moncayo', 50, 3, 30);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1436, 'Laguardia', 1, 8, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1437, 'Férez', 2, 3, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1438, 'Benidorm', 3, 9, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1439, 'Cantoria', 4, 4, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1440, 'Carmonita', 6, 0, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1441, 'Llucmajor', 7, 6, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1442, 'Calaf', 8, 2, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1443, 'Botija', 10, 9, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1444, 'San Fernando', 11, 6, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1445, 'Borriol', 12, 1, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1446, 'Carrión de Calatrava', 13, 7, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1447, 'Fuente-Tójar', 14, 2, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1448, 'Culleredo', 15, 5, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1449, 'Beamud', 16, 8, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1450, 'Cabanelles', 17, 4, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1451, 'Angón', 19, 3, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1452, 'Elduain', 20, 7, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1453, 'Encinasola', 21, 4, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1454, 'Escañuela', 23, 5, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1455, 'Calzada del Coto', 24, 0, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1456, 'Arres', 25, 3, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1457, 'Bobadilla', 26, 6, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1458, 'Monforte de Lemos', 27, 2, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1459, 'Cadalso de los Vidrios', 28, 8, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1460, 'Burgo, El', 29, 1, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1461, 'Ojós', 30, 5, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1462, 'Areso', 31, 2, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1463, 'Esgos', 32, 7, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1464, 'Langreo', 33, 3, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1465, 'Belmonte de Campos', 34, 8, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1466, 'Valsequillo de Gran Canaria', 35, 1, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1467, 'Mondariz-Balneario', 36, 4, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1468, 'Arabayona de Mógica', 37, 0, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1469, 'Realejos, Los', 38, 6, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1470, 'Hazas de Cesto', 39, 9, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1471, 'Bernuy de Porreros', 40, 3, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1472, 'Castillo de las Guardas, El', 41, 0, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1473, 'Barcones', 42, 5, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1474, 'Borges del Camp, Les', 43, 1, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1475, 'Azaila', 44, 6, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1476, 'Camarena', 45, 9, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1477, 'Alginet', 46, 2, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1478, 'Campillo, El', 47, 8, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1479, 'Elantxobe', 48, 4, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1480, 'Cabañas de Sayago', 49, 7, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1481, 'Aranda de Moncayo', 50, 0, 31);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1482, 'Lanciego/Lantziego', 1, 3, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1483, 'Fuensanta', 2, 8, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1484, 'Benifallim', 3, 4, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1485, 'Carboneras', 4, 9, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1486, 'Carrascalejo, El', 6, 5, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1487, 'Maó', 7, 1, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1488, 'Caldes d''Estrac', 8, 7, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1489, 'Avellanosa de Muñó', 9, 0, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1490, 'Brozas', 10, 4, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1491, 'Sanlúcar de Barrameda', 11, 1, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1492, 'Borriana/Burriana', 12, 6, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1493, 'Carrizosa', 13, 2, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1494, 'Granjuela, La', 14, 7, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1495, 'Curtis', 15, 0, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1496, 'Belinchón', 16, 3, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1497, 'Cadaqués', 17, 9, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1498, 'Bubión', 18, 5, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1499, 'Anguita', 19, 8, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1500, 'Elgoibar', 20, 2, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1501, 'Escacena del Campo', 21, 9, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1502, 'Aragüés del Puerto', 22, 4, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1503, 'Espelúy', 23, 0, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1504, 'Campazas', 24, 5, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1505, 'Arsèguel', 25, 8, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1506, 'Brieva de Cameros', 26, 1, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1507, 'Monterroso', 27, 7, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1508, 'Camarma de Esteruelas', 28, 3, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1509, 'Campillos', 29, 6, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1510, 'Pliego', 30, 0, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1511, 'Arguedas', 31, 7, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1512, 'Xinzo de Limia', 32, 2, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1513, 'Laviana', 33, 8, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1514, 'Berzosilla', 34, 3, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1515, 'Valleseco', 35, 6, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1516, 'Moraña', 36, 9, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1517, 'Arapiles', 37, 5, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1518, 'Rosario, El', 38, 1, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1519, 'Hermandad de Campoo de Suso', 39, 4, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1520, 'Boceguillas', 40, 8, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1521, 'Cazalla de la Sierra', 41, 5, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1522, 'Bayubas de Abajo', 42, 0, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1523, 'Bot', 43, 6, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1524, 'Bádenas', 44, 1, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1525, 'Camarenilla', 45, 4, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1526, 'Almàssera', 46, 7, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1527, 'Camporredondo', 47, 3, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1528, 'Elorrio', 48, 9, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1529, 'Calzadilla de Tera', 49, 2, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1530, 'Arándiga', 50, 5, 32);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1531, 'Lapuebla de Labarca', 1, 9, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1532, 'Fuente-Álamo', 2, 4, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1533, 'Benifato', 3, 0, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1534, 'Castro de Filabres', 4, 5, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1535, 'Blascomillán', 5, 8, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1536, 'Casas de Don Pedro', 6, 1, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1537, 'Manacor', 7, 7, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1538, 'Caldes de Montbui', 8, 3, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1539, 'Bahabón de Esgueva', 9, 6, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1540, 'Cabañas del Castillo', 10, 0, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1541, 'San Roque', 11, 7, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1542, 'Cabanes', 12, 2, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1543, 'Castellar de Santiago', 13, 8, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1544, 'Guadalcázar', 14, 3, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1545, 'Dodro', 15, 6, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1546, 'Belmonte', 16, 9, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1547, 'Caldes de Malavella', 17, 5, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1548, 'Busquístar', 18, 1, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1549, 'Anquela del Ducado', 19, 4, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1550, 'Elgeta', 20, 8, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1551, 'Fuenteheridos', 21, 5, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1552, 'Frailes', 23, 6, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1553, 'Campo de Villavidel', 24, 1, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1554, 'Artesa de Lleida', 25, 4, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1555, 'Briñas', 26, 7, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1556, 'Muras', 27, 3, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1557, 'Campo Real', 28, 9, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1558, 'Canillas de Aceituno', 29, 2, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1559, 'Puerto Lumbreras', 30, 6, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1560, 'Aria', 31, 3, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1561, 'Gomesende', 32, 8, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1562, 'Lena', 33, 4, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1563, 'Boada de Campos', 34, 9, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1564, 'Vega de San Mateo', 35, 2, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1565, 'Mos', 36, 5, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1566, 'Arcediano', 37, 1, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1567, 'San Andrés y Sauces', 38, 7, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1568, 'Herrerías', 39, 0, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1569, 'Brieva', 40, 4, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1570, 'Constantina', 41, 1, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1571, 'Bayubas de Arriba', 42, 6, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1572, 'Botarell', 43, 2, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1573, 'Báguena', 44, 7, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1574, 'Campillo de la Jara, El', 45, 0, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1575, 'Almiserà', 46, 3, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1576, 'Canalejas de Peñafiel', 47, 9, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1577, 'Ereño', 48, 5, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1578, 'Camarzana de Tera', 49, 8, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1579, 'Ardisa', 50, 1, 33);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1580, 'Leza', 1, 4, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1581, 'Fuentealbilla', 2, 9, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1582, 'Benijófar', 3, 5, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1583, 'Cóbdar', 4, 0, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1584, 'Blasconuño de Matacabras', 5, 3, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1585, 'Casas de Reina', 6, 6, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1586, 'Mancor de la Vall', 7, 2, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1587, 'Calders', 8, 8, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1588, 'Balbases, Los', 9, 1, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1589, 'Cabezabellosa', 10, 5, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1590, 'Setenil de las Bodegas', 11, 2, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1591, 'Càlig', 12, 7, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1592, 'Ciudad Real', 13, 3, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1593, 'Guijo, El', 14, 8, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1594, 'Dumbría', 15, 1, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1595, 'Belmontejo', 16, 4, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1596, 'Calonge', 17, 0, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1597, 'Cacín', 18, 6, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1598, 'Anquela del Pedregal', 19, 9, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1599, 'Eskoriatza', 20, 3, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1600, 'Galaroza', 21, 0, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1601, 'Fuensanta de Martos', 23, 1, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1602, 'Camponaraya', 24, 6, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1603, 'Artesa de Segre', 25, 9, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1604, 'Briones', 26, 2, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1605, 'Navia de Suarna', 27, 8, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1606, 'Canencia', 28, 4, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1607, 'Canillas de Albaida', 29, 7, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1608, 'Ricote', 30, 1, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1609, 'Aribe', 31, 8, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1610, 'Gudiña, A', 32, 3, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1611, 'Valdés', 33, 9, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1612, 'Boadilla del Camino', 34, 4, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1613, 'Yaiza', 35, 7, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1614, 'Neves, As', 36, 0, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1615, 'Arco, El', 37, 6, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1616, 'San Juan de la Rambla', 38, 2, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1617, 'Lamasón', 39, 5, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1618, 'Caballar', 40, 9, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1619, 'Coria del Río', 41, 6, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1620, 'Beratón', 42, 1, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1621, 'Bràfim', 43, 7, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1622, 'Bañón', 44, 2, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1623, 'Camuñas', 45, 5, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1624, 'Almoines', 46, 8, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1625, 'Canillas de Esgueva', 47, 4, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1626, 'Ermua', 48, 0, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1627, 'Cañizal', 49, 3, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1628, 'Ariza', 50, 6, 34);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1629, 'Gineta, La', 2, 2, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1630, 'Benilloba', 3, 8, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1631, 'Cuevas del Almanzora', 4, 3, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1632, 'Blascosancho', 5, 6, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1633, 'Castilblanco', 6, 9, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1634, 'Maria de la Salut', 7, 5, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1635, 'Calella', 8, 1, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1636, 'Baños de Valdearados', 9, 4, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1637, 'Cabezuela del Valle', 10, 8, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1638, 'Tarifa', 11, 5, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1639, 'Corral de Calatrava', 13, 6, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1640, 'Hinojosa del Duque', 14, 1, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1641, 'Fene', 15, 4, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1642, 'Beteta', 16, 7, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1643, 'Camós', 17, 3, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1644, 'Cádiar', 18, 9, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1645, 'Ezkio-Itsaso', 20, 6, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1646, 'Gibraleón', 21, 3, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1647, 'Arén', 22, 8, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1648, 'Fuerte del Rey', 23, 4, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1649, 'Sentiu de Sió, La', 25, 2, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1650, 'Cabezón de Cameros', 26, 5, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1651, 'Negueira de Muñiz', 27, 1, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1652, 'Carabaña', 28, 7, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1653, 'Cañete la Real', 29, 0, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1654, 'San Javier', 30, 4, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1655, 'Armañanzas', 31, 1, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1656, 'Irixo, O', 32, 6, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1657, 'Llanera', 33, 2, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1658, 'Boadilla de Rioseco', 34, 7, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1659, 'Nigrán', 36, 3, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1660, 'Armenteros', 37, 9, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1661, 'San Miguel de Abona', 38, 5, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1662, 'Laredo', 39, 8, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1663, 'Cabañas de Polendos', 40, 2, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1664, 'Coripe', 41, 9, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1665, 'Berlanga de Duero', 42, 4, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1666, 'Cabacés', 43, 0, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1667, 'Barrachina', 44, 5, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1668, 'Cardiel de los Montes', 45, 8, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1669, 'Almussafes', 46, 1, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1670, 'Carpio', 47, 7, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1671, 'Fruiz', 48, 3, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1672, 'Cañizo', 49, 6, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1673, 'Artieda', 50, 9, 35);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1674, 'Laudio/Llodio', 1, 0, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1675, 'Golosalvo', 2, 5, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1676, 'Benillup', 3, 1, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1677, 'Chercos', 4, 6, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1678, 'Bohodón, El', 5, 9, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1679, 'Castuera', 6, 2, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1680, 'Marratxí', 7, 8, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1681, 'Calonge de Segarra', 8, 4, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1682, 'Bañuelos de Bureba', 9, 7, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1683, 'Cabrero', 10, 1, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1684, 'Torre Alháquime', 11, 8, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1685, 'Canet lo Roig', 12, 3, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1686, 'Cortijos, Los', 13, 9, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1687, 'Hornachuelos', 14, 4, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1688, 'Ferrol', 15, 7, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1689, 'Boniches', 16, 0, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1690, 'Campdevànol', 17, 6, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1691, 'Cájar', 18, 2, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1692, 'Aranzueque', 19, 5, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1693, 'Hondarribia', 20, 9, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1694, 'Granada de Río-Tinto, La', 21, 6, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1695, 'Argavieso', 22, 1, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1696, 'Candín', 24, 2, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1697, 'Aspa', 25, 5, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1698, 'Calahorra', 26, 8, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1699, 'Casarrubuelos', 28, 0, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1700, 'Carratraca', 29, 3, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1701, 'San Pedro del Pinatar', 30, 7, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1702, 'Arróniz', 31, 4, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1703, 'Xunqueira de Ambía', 32, 9, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1704, 'Llanes', 33, 5, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1705, 'Brañosera', 34, 0, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1706, 'Oia', 36, 6, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1707, 'San Miguel del Robledo', 37, 2, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1708, 'San Sebastián de la Gomera', 38, 8, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1709, 'Liendo', 39, 1, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1710, 'Cabezuela', 40, 5, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1711, 'Coronil, El', 41, 2, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1712, 'Blacos', 42, 7, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1713, 'Cabra del Camp', 43, 3, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1714, 'Bea', 44, 8, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1715, 'Carmena', 45, 1, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1716, 'Alpuente', 46, 4, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1717, 'Casasola de Arión', 47, 0, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1718, 'Galdakao', 48, 6, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1719, 'Carbajales de Alba', 49, 9, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1720, 'Asín', 50, 2, 36);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1721, 'Arraia-Maeztu', 1, 6, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1722, 'Hellín', 2, 1, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1723, 'Benimantell', 3, 7, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1724, 'Chirivel', 4, 2, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1725, 'Bohoyo', 5, 5, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1726, 'Codosera, La', 6, 8, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1727, 'Mercadal, Es', 7, 4, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1728, 'Calldetenes', 8, 0, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1729, 'Barbadillo de Herreros', 9, 3, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1730, 'Cáceres', 10, 7, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1731, 'Trebujena', 11, 4, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1732, 'Castell de Cabres', 12, 9, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1733, 'Cózar', 13, 5, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1734, 'Iznájar', 14, 0, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1735, 'Fisterra', 15, 3, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1736, 'Campelles', 17, 2, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1737, 'Calicasas', 18, 8, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1738, 'Arbancón', 19, 1, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1739, 'Gaintza', 20, 5, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1740, 'Granado, El', 21, 2, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1741, 'Arguis', 22, 7, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1742, 'Génave', 23, 3, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1743, 'Cármenes', 24, 8, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1744, 'Avellanes i Santa Linya, Les', 25, 1, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1745, 'Camprovín', 26, 4, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1746, 'Nogais, As', 27, 0, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1747, 'Cenicientos', 28, 6, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1748, 'Cartajima', 29, 9, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1749, 'Torre-Pacheco', 30, 3, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1750, 'Arruazu', 31, 0, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1751, 'Xunqueira de Espadanedo', 32, 5, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1752, 'Mieres', 33, 1, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1753, 'Buenavista de Valdavia', 34, 6, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1754, 'Pazos de Borbén', 36, 2, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1755, 'Atalaya, La', 37, 8, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1756, 'Santa Cruz de la Palma', 38, 4, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1757, 'Liérganes', 39, 7, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1758, 'Calabazas de Fuentidueña', 40, 1, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1759, 'Corrales, Los', 41, 8, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1760, 'Bliecos', 42, 3, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1761, 'Calafell', 43, 9, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1762, 'Beceite', 44, 4, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1763, 'Carpio de Tajo, El', 45, 7, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1764, 'Alqueria de la Comtessa, l''', 46, 0, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1765, 'Castrejón de Trabancos', 47, 6, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1766, 'Galdames', 48, 2, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1767, 'Carbellino', 49, 5, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1768, 'Atea', 50, 8, 37);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1769, 'Herrera, La', 2, 7, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1770, 'Benimarfull', 3, 3, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1771, 'Dalías', 4, 8, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1772, 'Bonilla de la Sierra', 5, 1, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1773, 'Cordobilla de Lácara', 6, 4, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1774, 'Montuïri', 7, 0, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1775, 'Callús', 8, 6, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1776, 'Barbadillo del Mercado', 9, 9, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1777, 'Cachorrilla', 10, 3, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1778, 'Ubrique', 11, 0, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1779, 'Castellfort', 12, 5, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1780, 'Chillón', 13, 1, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1781, 'Lucena', 14, 6, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1782, 'Frades', 15, 9, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1783, 'Buciegas', 16, 2, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1784, 'Campllong', 17, 8, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1785, 'Campotéjar', 18, 4, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1786, 'Arbeteta', 19, 7, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1787, 'Gabiria', 20, 1, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1788, 'Higuera de la Sierra', 21, 8, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1789, 'Guardia de Jaén, La', 23, 9, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1790, 'Carracedelo', 24, 4, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1791, 'Aitona', 25, 7, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1792, 'Canales de la Sierra', 26, 0, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1793, 'Ourol', 27, 6, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1794, 'Cercedilla', 28, 2, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1795, 'Cártama', 29, 5, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1796, 'Torres de Cotillas, Las', 30, 9, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1797, 'Artajona', 31, 6, 38);\n";
    public static String INSERTS_DB_6 =  "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1798, 'Larouco', 32, 1, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1799, 'Morcín', 33, 7, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1800, 'Bustillo de la Vega', 34, 2, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1801, 'Pontevedra', 36, 8, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1802, 'Babilafuente', 37, 4, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1803, 'Santa Cruz de Tenerife', 38, 0, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1804, 'Limpias', 39, 3, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1805, 'Dos Hermanas', 41, 4, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1806, 'Borjabad', 42, 9, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1807, 'Cambrils', 43, 5, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1808, 'Belmonte de San José', 44, 0, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1809, 'Carranque', 45, 3, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1810, 'Andilla', 46, 6, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1811, 'Castrillo de Duero', 47, 2, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1812, 'Gamiz-Fika', 48, 8, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1813, 'Casaseca de Campeán', 49, 1, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1814, 'Ateca', 50, 4, 38);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1815, 'Moreda de Álava/Moreda Araba', 1, 5, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1816, 'Higueruela', 2, 0, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1817, 'Benimassot', 3, 6, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1818, 'Brabos', 5, 4, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1819, 'Coronada, La', 6, 7, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1820, 'Muro', 7, 3, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1821, 'Campins', 8, 9, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1822, 'Barbadillo del Pez', 9, 2, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1823, 'Cadalso', 10, 6, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1824, 'Vejer de la Frontera', 11, 3, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1825, 'Castellnovo', 12, 8, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1826, 'Daimiel', 13, 4, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1827, 'Luque', 14, 9, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1828, 'Irixoa', 15, 2, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1829, 'Buenache de Alarcón', 16, 5, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1830, 'Camprodon', 17, 1, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1831, 'Caniles', 18, 7, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1832, 'Argecilla', 19, 0, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1833, 'Getaria', 20, 4, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1834, 'Hinojales', 21, 1, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1835, 'Ayerbe', 22, 6, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1836, 'Guarromán', 23, 2, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1837, 'Carrizo', 24, 7, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1838, 'Baix Pallars', 25, 0, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1839, 'Canillas de Río Tuerto', 26, 3, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1840, 'Outeiro de Rei', 27, 9, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1841, 'Cervera de Buitrago', 28, 5, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1842, 'Casabermeja', 29, 8, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1843, 'Totana', 30, 2, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1844, 'Artazu', 31, 9, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1845, 'Laza', 32, 4, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1846, 'Muros de Nalón', 33, 0, 39);\n";
    public static String INSERTS_DB__52 =    "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1847, 'Bustillo del Páramo de Carrión', 34, 5, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1848, 'Porriño, O', 36, 1, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1849, 'Bañobárez', 37, 7, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1850, 'Santa Úrsula', 38, 3, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1851, 'Luena', 39, 6, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1852, 'Campo de San Pedro', 40, 0, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1853, 'Écija', 41, 7, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1854, 'Borobia', 42, 2, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1855, 'Capafonts', 43, 8, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1856, 'Bello', 44, 3, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1857, 'Carriches', 45, 6, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1858, 'Anna', 46, 9, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1859, 'Castrillo-Tejeriego', 47, 5, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1860, 'Garai', 48, 1, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1861, 'Casaseca de las Chanas', 49, 4, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1862, 'Azuara', 50, 7, 39);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1863, 'Hoya-Gonzalo', 2, 4, 40);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1864, 'Benimeli', 3, 0, 40);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1865, 'Bularros', 5, 8, 40);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1866, 'Corte de Peleas', 6, 1, 40);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1867, 'Palma', 7, 7, 40);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1868, 'Canet de Mar', 8, 3, 40);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1869, 'Calzadilla', 10, 0, 40);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1870, 'Villaluenga del Rosario', 11, 7, 40);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1871, 'Castellón de la Plana/Castelló de la Plana', 12, 2, 40);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1872, 'Fernán Caballero', 13, 8, 40);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1873, 'Montalbán de Córdoba', 14, 3, 40);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1874, 'Laxe', 15, 6, 40);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1875, 'Buenache de la Sierra', 16, 9, 40);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1876, 'Canet d''Adri', 17, 5, 40);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1877, 'Cáñar', 18, 1, 40);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1878, 'Armallones', 19, 4, 40);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1879, 'Hernani', 20, 8, 40);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1880, 'Hinojos', 21, 5, 40);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1881, 'Azanuy-Alins', 22, 0, 40);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1882, 'Lahiguera', 23, 6, 40);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1883, 'Carrocera', 24, 1, 40);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1884, 'Balaguer', 25, 4, 40);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1885, 'Cañas', 26, 7, 40);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1886, 'Palas de Rei', 27, 3, 40);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1887, 'Ciempozuelos', 28, 9, 40);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1888, 'Casarabonela', 29, 2, 40);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1889, 'Ulea', 30, 6, 40);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1890, 'Atez', 31, 3, 40);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1891, 'Leiro', 32, 8, 40);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1892, 'Nava', 33, 4, 40);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1893, 'Portas', 36, 5, 40);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1894, 'Barbadillo', 37, 1, 40);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1895, 'Santiago del Teide', 38, 7, 40);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1896, 'Marina de Cudeyo', 39, 0, 40);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1897, 'Cantalejo', 40, 4, 40);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1898, 'Espartinas', 41, 1, 40);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1899, 'Capçanes', 43, 2, 40);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1900, 'Berge', 44, 7, 40);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1901, 'Casar de Escalona, El', 45, 0, 40);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1902, 'Antella', 46, 3, 40);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1903, 'Castrobol', 47, 9, 40);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1904, 'Gatika', 48, 5, 40);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1905, 'Castrillo de la Guareña', 49, 8, 40);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1906, 'Badules', 50, 1, 40);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1907, 'Navaridas', 1, 6, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1908, 'Jorquera', 2, 1, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1909, 'Benissa', 3, 7, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1910, 'Enix', 4, 2, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1911, 'Burgohondo', 5, 5, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1912, 'Cristina', 6, 8, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1913, 'Petra', 7, 4, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1914, 'Canovelles', 8, 0, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1915, 'Barrio de Muñó', 9, 3, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1916, 'Caminomorisco', 10, 7, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1917, 'Villamartín', 11, 4, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1918, 'Castillo de Villamalefa', 12, 9, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1919, 'Fontanarejo', 13, 5, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1920, 'Montemayor', 14, 0, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1921, 'Laracha, A', 15, 3, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1922, 'Buendía', 16, 6, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1923, 'Cantallops', 17, 2, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1924, 'Armuña de Tajuña', 19, 1, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1925, 'Hernialde', 20, 5, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1926, 'Huelva', 21, 2, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1927, 'Azara', 22, 7, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1928, 'Higuera de Calatrava', 23, 3, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1929, 'Carucedo', 24, 8, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1930, 'Barbens', 25, 1, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1931, 'Cárdenas', 26, 4, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1932, 'Pantón', 27, 0, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1933, 'Cobeña', 28, 6, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1934, 'Casares', 29, 9, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1935, 'Unión, La', 30, 3, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1936, 'Ayegui/Aiegi', 31, 0, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1937, 'Lobeira', 32, 5, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1938, 'Navia', 33, 1, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1939, 'Calahorra de Boedo', 34, 6, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1940, 'Poio', 36, 2, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1941, 'Barbalos', 37, 8, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1942, 'Sauzal, El', 38, 4, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1943, 'Mazcuerras', 39, 7, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1944, 'Cantimpalos', 40, 1, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1945, 'Estepa', 41, 8, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1946, 'Buberos', 42, 3, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1947, 'Caseres', 43, 9, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1948, 'Bezas', 44, 4, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1949, 'Casarrubios del Monte', 45, 7, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1950, 'Aras de los Olmos', 46, 0, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1951, 'Castrodeza', 47, 6, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1952, 'Gautegiz Arteaga', 48, 2, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1953, 'Castrogonzalo', 49, 5, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1954, 'Bagüés', 50, 8, 41);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1955, 'Okondo', 1, 1, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1956, 'Letur', 2, 6, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1957, 'Benitachell/Poble Nou de Benitatxell, el', 3, 2, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1958, 'Cabezas de Alambre', 5, 0, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1959, 'Cheles', 6, 3, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1960, 'Pollença', 7, 9, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1961, 'Cànoves i Samalús', 8, 5, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1962, 'Campillo de Deleitosa', 10, 2, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1963, 'Zahara', 11, 9, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1964, 'Catí', 12, 4, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1965, 'Fuencaliente', 13, 0, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1966, 'Montilla', 14, 5, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1967, 'Lousame', 15, 8, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1968, 'Campillo de Altobuey', 16, 1, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1969, 'Capmany', 17, 7, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1970, 'Capileira', 18, 3, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1971, 'Arroyo de las Fraguas', 19, 6, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1972, 'Ibarra', 20, 0, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1973, 'Isla Cristina', 21, 7, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1974, 'Azlor', 22, 2, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1975, 'Hinojares', 23, 8, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1976, 'Castilfalé', 24, 3, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1977, 'Baronia de Rialb, La', 25, 6, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1978, 'Casalarreina', 26, 9, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1979, 'Paradela', 27, 5, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1980, 'Colmenar del Arroyo', 28, 1, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1981, 'Coín', 29, 4, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1982, 'Villanueva del Río Segura', 30, 8, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1983, 'Azagra', 31, 5, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1984, 'Lobios', 32, 0, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1985, 'Noreña', 33, 6, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1986, 'Calzada de los Molinos', 34, 1, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1987, 'Ponteareas', 36, 7, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1988, 'Barceo', 37, 3, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1989, 'Silos, Los', 38, 9, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1990, 'Medio Cudeyo', 39, 2, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1991, 'Fuentes de Andalucía', 41, 3, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1992, 'Buitrago', 42, 8, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1993, 'Castellvell del Camp', 43, 4, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1994, 'Blancas', 44, 9, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1995, 'Casasbuenas', 45, 2, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1996, 'Aielo de Malferit', 46, 5, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1997, 'Castromembibre', 47, 1, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1998, 'Gordexola', 48, 7, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (1999, 'Castronuevo', 49, 0, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2000, 'Balconchán', 50, 3, 42);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2001, 'Oyón-Oion', 1, 7, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2002, 'Lezuza', 2, 2, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2003, 'Biar', 3, 8, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2004, 'Felix', 4, 3, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2005, 'Cabezas del Pozo', 5, 6, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2006, 'Don Álvaro', 6, 9, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2007, 'Porreres', 7, 5, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2008, 'Canyelles', 8, 1, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2009, 'Barrios de Bureba, Los', 9, 4, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2010, 'Campo Lugar', 10, 8, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2011, 'Caudiel', 12, 0, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2012, 'Fuenllana', 13, 6, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2013, 'Montoro', 14, 1, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2014, 'Malpica de Bergantiños', 15, 4, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2015, 'Campillos-Paravientos', 16, 7, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2016, 'Queralbs', 17, 3, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2017, 'Carataunas', 18, 9, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2018, 'Atanzón', 19, 2, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2019, 'Idiazabal', 20, 6, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2020, 'Jabugo', 21, 3, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2021, 'Baélls', 22, 8, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2022, 'Hornos', 23, 4, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2023, 'Castrillo de Cabrera', 24, 9, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2024, 'Vall de Boí, La', 25, 2, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2025, 'Castañares de Rioja', 26, 5, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2026, 'Páramo, O', 27, 1, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2027, 'Colmenar de Oreja', 28, 7, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2028, 'Colmenar', 29, 0, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2029, 'Yecla', 30, 4, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2030, 'Azuelo', 31, 1, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2031, 'Maceda', 32, 6, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2032, 'Onís', 33, 2, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2033, 'Ponte Caldelas', 36, 3, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2034, 'Tacoronte', 38, 5, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2035, 'Meruelo', 39, 8, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2036, 'Carbonero el Mayor', 40, 2, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2037, 'Garrobo, El', 41, 9, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2038, 'Burgo de Osma-Ciudad de Osma', 42, 4, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2039, 'Catllar, El', 43, 0, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2040, 'Blesa', 44, 5, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2041, 'Castillo de Bayuela', 45, 8, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2042, 'Aielo de Rugat', 46, 1, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2043, 'Castromonte', 47, 7, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2044, 'Gorliz', 48, 3, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2045, 'Castroverde de Campos', 49, 6, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2046, 'Bárboles', 50, 9, 43);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2047, 'Peñacerrada-Urizaharra', 1, 2, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2048, 'Liétor', 2, 7, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2049, 'Bigastro', 3, 3, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2050, 'Fines', 4, 8, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2051, 'Cabezas del Villar', 5, 1, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2052, 'Don Benito', 6, 4, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2053, 'Pobla, Sa', 7, 0, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2054, 'Capellades', 8, 6, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2055, 'Barrios de Colina', 9, 9, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2056, 'Cañamero', 10, 3, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2057, 'Cervera del Maestre', 12, 5, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2058, 'Fuente el Fresno', 13, 1, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2059, 'Monturque', 14, 6, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2060, 'Mañón', 15, 9, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2061, 'Campillos-Sierra', 16, 2, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2062, 'Cassà de la Selva', 17, 8, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2063, 'Cástaras', 18, 4, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2064, 'Atienza', 19, 7, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2065, 'Ikaztegieta', 20, 1, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2066, 'Lepe', 21, 8, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2067, 'Bailo', 22, 3, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2068, 'Huelma', 23, 9, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2069, 'Castrillo de la Valduerna', 24, 4, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2070, 'Bassella', 25, 7, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2071, 'Castroviejo', 26, 0, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2072, 'Pastoriza, A', 27, 6, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2073, 'Colmenarejo', 28, 2, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2074, 'Comares', 29, 5, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2075, 'Bakaiku', 31, 6, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2076, 'Manzaneda', 32, 1, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2077, 'Oviedo', 33, 7, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2078, 'Pontecesures', 36, 8, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2079, 'Barruecopardo', 37, 4, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2080, 'Tanque, El', 38, 0, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2081, 'Miengo', 39, 3, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2082, 'Carrascal del Río', 40, 7, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2083, 'Gelves', 41, 4, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2084, 'Cabrejas del Campo', 42, 9, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2085, 'Sénia, La', 43, 5, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2086, 'Bordón', 44, 0, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2087, 'Ayora', 46, 6, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2088, 'Castronuevo de Esgueva', 47, 2, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2089, 'Getxo', 48, 8, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2090, 'Cazurra', 49, 1, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2091, 'Bardallur', 50, 4, 44);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2092, 'Madrigueras', 2, 0, 45);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2093, 'Bolulla', 3, 6, 45);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2094, 'Fiñana', 4, 1, 45);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2095, 'Cabizuela', 5, 4, 45);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2096, 'Entrín Bajo', 6, 7, 45);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2097, 'Puigpunyent', 7, 3, 45);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2098, 'Capolat', 8, 9, 45);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2099, 'Basconcillos del Tozo', 9, 2, 45);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2100, 'Cañaveral', 10, 6, 45);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2101, 'Cinctorres', 12, 8, 45);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2102, 'Granátula de Calatrava', 13, 4, 45);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2103, 'Moriles', 14, 9, 45);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2104, 'Mazaricos', 15, 2, 45);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2105, 'Canalejas del Arroyo', 16, 5, 45);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2106, 'Castilléjar', 18, 7, 45);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2107, 'Auñón', 19, 0, 45);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2108, 'Irun', 20, 4, 45);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2109, 'Linares de la Sierra', 21, 1, 45);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2110, 'Baldellou', 22, 6, 45);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2111, 'Huesa', 23, 2, 45);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2112, 'Bausen', 25, 0, 45);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2113, 'Cellorigo', 26, 3, 45);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2114, 'Pedrafita do Cebreiro', 27, 9, 45);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2115, 'Colmenar Viejo', 28, 5, 45);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2116, 'Cómpeta', 29, 8, 45);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2117, 'Barásoain', 31, 9, 45);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2118, 'Maside', 32, 4, 45);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2119, 'Parres', 33, 0, 45);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2120, 'Capillas', 34, 5, 45);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2121, 'Redondela', 36, 1, 45);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2122, 'Bastida, La', 37, 7, 45);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2123, 'Tazacorte', 38, 3, 45);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2124, 'Miera', 39, 6, 45);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2125, 'Casla', 40, 0, 45);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2126, 'Gerena', 41, 7, 45);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2127, 'Cabrejas del Pinar', 42, 2, 45);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2128, 'Colldejou', 43, 8, 45);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2129, 'Bronchales', 44, 3, 45);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2130, 'Cazalegas', 45, 6, 45);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2131, 'Barxeta', 46, 9, 45);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2132, 'Castronuño', 47, 5, 45);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2133, 'Güeñes', 48, 1, 45);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2134, 'Belchite', 50, 7, 45);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2135, 'Erriberagoitia/Ribera Alta', 1, 8, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2136, 'Mahora', 2, 3, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2137, 'Busot', 3, 9, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2138, 'Fondón', 4, 4, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2139, 'Canales', 5, 7, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2140, 'Esparragalejo', 6, 0, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2141, 'Sant Antoni de Portmany', 7, 6, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2142, 'Cardedeu', 8, 2, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2143, 'Bascuñana', 9, 5, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2144, 'Carbajo', 10, 9, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2145, 'Cirat', 12, 1, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2146, 'Guadalmez', 13, 7, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2147, 'Nueva Carteya', 14, 2, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2148, 'Melide', 15, 5, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2149, 'Cañada del Hoyo', 16, 8, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2150, 'Castellfollit de la Roca', 17, 4, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2151, 'Castril', 18, 0, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2152, 'Azuqueca de Henares', 19, 3, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2153, 'Irura', 20, 7, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2154, 'Lucena del Puerto', 21, 4, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2155, 'Ballobar', 22, 9, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2156, 'Ibros', 23, 5, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2157, 'Castrocalbón', 24, 0, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2158, 'Belianes', 25, 3, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2159, 'Cenicero', 26, 6, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2160, 'Pol', 27, 2, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2161, 'Collado Mediano', 28, 8, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2162, 'Cortes de la Frontera', 29, 1, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2163, 'Barbarin', 31, 2, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2164, 'Melón', 32, 7, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2165, 'Peñamellera Alta', 33, 3, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2166, 'Cardeñosa de Volpejera', 34, 8, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2167, 'Ribadumia', 36, 4, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2168, 'Béjar', 37, 0, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2169, 'Tegueste', 38, 6, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2170, 'Molledo', 39, 9, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2171, 'Castillejo de Mesleón', 40, 3, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2172, 'Gilena', 41, 0, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2173, 'Calatañazor', 42, 5, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2174, 'Conesa', 43, 1, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2175, 'Bueña', 44, 6, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2176, 'Cebolla', 45, 9, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2177, 'Barx', 46, 2, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2178, 'Castroponce', 47, 8, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2179, 'Gernika-Lumo', 48, 4, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2180, 'Cerecinos de Campos', 49, 7, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2181, 'Belmonte de Gracián', 50, 0, 46);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2182, 'Ribera Baja/Erribera Beitia', 1, 4, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2183, 'Masegoso', 2, 9, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2184, 'Calp', 3, 5, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2185, 'Gádor', 4, 0, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2186, 'Candeleda', 5, 3, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2187, 'Esparragosa de la Serena', 6, 6, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2188, 'Sencelles', 7, 2, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2189, 'Cardona', 8, 8, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2190, 'Belbimbre', 9, 1, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2191, 'Carcaboso', 10, 5, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2192, 'Herencia', 13, 3, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2193, 'Obejo', 14, 8, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2194, 'Mesía', 15, 1, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2195, 'Cañada Juncosa', 16, 4, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2196, 'Castelló d''Empúries', 17, 0, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2197, 'Cenes de la Vega', 18, 6, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2198, 'Baides', 19, 9, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2199, 'Itsasondo', 20, 3, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2200, 'Manzanilla', 21, 0, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2201, 'Banastás', 22, 5, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2202, 'Iruela, La', 23, 1, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2203, 'Castrocontrigo', 24, 6, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2204, 'Bellcaire d''Urgell', 25, 9, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2205, 'Cervera del Río Alhama', 26, 2, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2206, 'Pobra do Brollón, A', 27, 8, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2207, 'Collado Villalba', 28, 4, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2208, 'Cuevas Bajas', 29, 7, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2209, 'Bargota', 31, 8, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2210, 'Merca, A', 32, 3, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2211, 'Peñamellera Baja', 33, 9, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2212, 'Carrión de los Condes', 34, 4, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2213, 'Rodeiro', 36, 0, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2214, 'Beleña', 37, 6, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2215, 'Tijarafe', 38, 2, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2216, 'Noja', 39, 5, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2217, 'Castro de Fuentidueña', 40, 9, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2218, 'Gines', 41, 6, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2219, 'Constantí', 43, 7, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2220, 'Burbáguena', 44, 2, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2221, 'Cedillo del Condado', 45, 5, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2222, 'Bèlgida', 46, 8, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2223, 'Castroverde de Cerrato', 47, 4, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2224, 'Gizaburuaga', 48, 0, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2225, 'Cerecinos del Carrizal', 49, 3, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2226, 'Berdejo', 50, 6, 47);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2227, 'Minaya', 2, 5, 48);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2228, 'Callosa d''En Sarrià', 3, 1, 48);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2229, 'Gallardos, Los', 4, 6, 48);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2230, 'Cantiveros', 5, 9, 48);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2231, 'Esparragosa de Lares', 6, 2, 48);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2232, 'Sant Josep de sa Talaia', 7, 8, 48);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2233, 'Carme', 8, 4, 48);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2234, 'Belorado', 9, 7, 48);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2235, 'Carrascalejo', 10, 1, 48);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2236, 'Cortes de Arenoso', 12, 3, 48);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2237, 'Hinojosas de Calatrava', 13, 9, 48);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2238, 'Palenciana', 14, 4, 48);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2239, 'Miño', 15, 7, 48);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2240, 'Cañamares', 16, 0, 48);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2241, 'Castell-Platja d''Aro', 17, 6, 48);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2242, 'Cijuela', 18, 2, 48);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2243, 'Baños de Tajo', 19, 5, 48);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2244, 'Larraul', 20, 9, 48);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2245, 'Marines, Los', 21, 6, 48);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2246, 'Barbastro', 22, 1, 48);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2247, 'Iznatoraf', 23, 7, 48);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2248, 'Bell-lloc d''Urgell', 25, 5, 48);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2249, 'Cidamón', 26, 8, 48);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2250, 'Pontenova, A', 27, 4, 48);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2251, 'Corpa', 28, 0, 48);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2252, 'Cuevas del Becerro', 29, 3, 48);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2253, 'Barillas', 31, 4, 48);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2254, 'Mezquita, A', 32, 9, 48);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2255, 'Pesoz', 33, 5, 48);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2256, 'Castil de Vela', 34, 0, 48);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2257, 'Rosal, O', 36, 6, 48);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2258, 'Valverde', 38, 8, 48);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2259, 'Penagos', 39, 1, 48);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2260, 'Castrojimeno', 40, 5, 48);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2261, 'Guadalcanal', 41, 2, 48);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2262, 'Caltojar', 42, 7, 48);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2263, 'Corbera d''Ebre', 43, 3, 48);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2264, 'Cabra de Mora', 44, 8, 48);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2265, 'Cerralbos, Los', 45, 1, 48);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2266, 'Bellreguard', 46, 4, 48);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2267, 'Ceinos de Campos', 47, 0, 48);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2268, 'Ibarrangelu', 48, 6, 48);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2269, 'Cernadilla', 49, 9, 48);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2270, 'Berrueco', 50, 2, 48);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2271, 'Añana', 1, 3, 49);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2272, 'Molinicos', 2, 8, 49);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2273, 'Callosa de Segura', 3, 4, 49);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2274, 'Garrucha', 4, 9, 49);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2275, 'Cardeñosa', 5, 2, 49);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2276, 'Feria', 6, 5, 49);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2277, 'Sant Joan', 7, 1, 49);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2278, 'Casserres', 8, 7, 49);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2279, 'Casar de Cáceres', 10, 4, 49);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2280, 'Costur', 12, 6, 49);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2281, 'Horcajo de los Montes', 13, 2, 49);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2282, 'Palma del Río', 14, 7, 49);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2283, 'Moeche', 15, 0, 49);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2284, 'Cañavate, El', 16, 3, 49);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2285, 'Celrà', 17, 9, 49);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2286, 'Cogollos de Guadix', 18, 5, 49);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2287, 'Bañuelos', 19, 8, 49);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2288, 'Lazkao', 20, 2, 49);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2289, 'Minas de Riotinto', 21, 9, 49);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2290, 'Barbués', 22, 4, 49);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2291, 'Jabalquinto', 23, 0, 49);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2292, 'Castropodame', 24, 5, 49);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2293, 'Bellmunt d''Urgell', 25, 8, 49);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2294, 'Cihuri', 26, 1, 49);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2295, 'Portomarín', 27, 7, 49);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2296, 'Coslada', 28, 3, 49);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2297, 'Cuevas de San Marcos', 29, 6, 49);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2298, 'Basaburua', 31, 7, 49);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2299, 'Montederramo', 32, 2, 49);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2300, 'Piloña', 33, 8, 49);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2301, 'Castrejón de la Peña', 34, 3, 49);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2302, 'Salceda de Caselas', 36, 9, 49);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2303, 'Bermellar', 37, 5, 49);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2304, 'Valle Gran Rey', 38, 1, 49);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2305, 'Peñarrubia', 39, 4, 49);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2306, 'Castroserna de Abajo', 40, 8, 49);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2307, 'Guillena', 41, 5, 49);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2308, 'Candilichera', 42, 0, 49);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2309, 'Cornudella de Montsant', 43, 6, 49);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2310, 'Calaceite', 44, 1, 49);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2311, 'Cervera de los Montes', 45, 4, 49);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2312, 'Bellús', 46, 7, 49);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2313, 'Cervillego de la Cruz', 47, 3, 49);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2314, 'Ispaster', 48, 9, 49);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2315, 'Montalvos', 2, 1, 50);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2316, 'Campello, el', 3, 7, 50);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2317, 'Gérgal', 4, 2, 50);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2318, 'Fregenal de la Sierra', 6, 8, 50);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2319, 'Sant Joan de Labritja', 7, 4, 50);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2320, 'Castellar del Riu', 8, 0, 50);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2321, 'Berberana', 9, 3, 50);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2322, 'Casar de Palomero', 10, 7, 50);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2323, 'Coves de Vinromà, les', 12, 9, 50);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2324, 'Labores, Las', 13, 5, 50);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2325, 'Pedro Abad', 14, 0, 50);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2326, 'Monfero', 15, 3, 50);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2327, 'Cañaveras', 16, 6, 50);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2328, 'Cervià de Ter', 17, 2, 50);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2329, 'Cogollos de la Vega', 18, 8, 50);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2330, 'Barriopedro', 19, 1, 50);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2331, 'Leaburu', 20, 5, 50);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2332, 'Moguer', 21, 2, 50);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2333, 'Barbuñales', 22, 7, 50);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2334, 'Jaén', 23, 3, 50);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2335, 'Castrotierra de Valmadrigal', 24, 8, 50);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2336, 'Bellpuig', 25, 1, 50);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2337, 'Cirueña', 26, 4, 50);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2338, 'Quiroga', 27, 0, 50);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2339, 'Cubas de la Sagra', 28, 6, 50);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2340, 'Cútar', 29, 9, 50);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2341, 'Baztan', 31, 0, 50);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2342, 'Monterrei', 32, 5, 50);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2343, 'Ponga', 33, 1, 50);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2344, 'Castrillo de Don Juan', 34, 6, 50);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2345, 'Salvaterra de Miño', 36, 2, 50);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2346, 'Berrocal de Huebra', 37, 8, 50);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2347, 'Vallehermoso', 38, 4, 50);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2348, 'Pesaguero', 39, 7, 50);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2349, 'Herrera', 41, 8, 50);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2350, 'Cañamaque', 42, 3, 50);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2351, 'Creixell', 43, 9, 50);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2352, 'Calamocha', 44, 4, 50);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2353, 'Ciruelos', 45, 7, 50);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2354, 'Benagéber', 46, 0, 50);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2355, 'Cigales', 47, 6, 50);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2356, 'Izurtza', 48, 2, 50);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2357, 'Cobreros', 49, 5, 50);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2358, 'Bijuesca', 50, 8, 50);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2359, 'Salvatierra/Agurain', 1, 3, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2360, 'Montealegre del Castillo', 2, 8, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2361, 'Campo de Mirra/Camp de Mirra, el', 3, 4, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2362, 'Huécija', 4, 9, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2363, 'Carrera, La', 5, 2, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2364, 'Fuenlabrada de los Montes', 6, 5, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2365, 'Sant Llorenç des Cardassar', 7, 1, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2366, 'Castellar del Vallès', 8, 7, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2367, 'Berlangas de Roa', 9, 0, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2368, 'Casares de las Hurdes', 10, 4, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2369, 'Culla', 12, 6, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2370, 'Luciana', 13, 2, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2371, 'Pedroche', 14, 7, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2372, 'Mugardos', 15, 0, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2373, 'Cañaveruelas', 16, 3, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2374, 'Cistella', 17, 9, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2375, 'Colomera', 18, 5, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2376, 'Berninches', 19, 8, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2377, 'Legazpi', 20, 2, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2378, 'Nava, La', 21, 9, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2379, 'Bárcabo', 22, 4, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2380, 'Jamilena', 23, 0, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2381, 'Cea', 24, 5, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2382, 'Bellver de Cerdanya', 25, 8, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2383, 'Clavijo', 26, 1, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2384, 'Ribadeo', 27, 7, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2385, 'Chapinería', 28, 3, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2386, 'Estepona', 29, 6, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2387, 'Beire', 31, 7, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2388, 'Muíños', 32, 2, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2389, 'Pravia', 33, 8, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2390, 'Castrillo de Onielo', 34, 3, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2391, 'Sanxenxo', 36, 9, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2392, 'Berrocal de Salvatierra', 37, 5, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2393, 'Victoria de Acentejo, La', 38, 1, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2394, 'Pesquera', 39, 4, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2395, 'Castroserracín', 40, 8, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2396, 'Huévar del Aljarafe', 41, 5, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2397, 'Carabantes', 42, 0, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2398, 'Cunit', 43, 6, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2399, 'Calanda', 44, 1, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2400, 'Cobeja', 45, 4, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2401, 'Benaguasil', 46, 7, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2402, 'Ciguñuela', 47, 3, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2403, 'Lanestosa', 48, 9, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2404, 'Biota', 50, 5, 51);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2405, 'Samaniego', 1, 8, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2406, 'Motilleja', 2, 3, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2407, 'Cañada', 3, 9, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2408, 'Huércal de Almería', 4, 4, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2409, 'Casas del Puerto', 5, 7, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2410, 'Fuente de Cantos', 6, 0, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2411, 'Sant Lluís', 7, 6, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2412, 'Castellar de n''Hug', 8, 2, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2413, 'Berzosa de Bureba', 9, 5, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2414, 'Casas de Don Antonio', 10, 9, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2415, 'Chert/Xert', 12, 1, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2416, 'Malagón', 13, 7, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2417, 'Peñarroya-Pueblonuevo', 14, 2, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2418, 'Muxía', 15, 5, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2419, 'Cañete', 16, 8, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2420, 'Siurana', 17, 4, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2421, 'Bodera, La', 19, 3, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2422, 'Legorreta', 20, 7, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2423, 'Nerva', 21, 4, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2424, 'Belver de Cinca', 22, 9, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2425, 'Jimena', 23, 5, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2426, 'Cebanico', 24, 0, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2427, 'Bellvís', 25, 3, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2428, 'Cordovín', 26, 6, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2429, 'Ribas de Sil', 27, 2, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2430, 'Chinchón', 28, 8, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2431, 'Faraján', 29, 1, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2432, 'Belascoáin', 31, 2, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2433, 'Nogueira de Ramuín', 32, 7, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2434, 'Proaza', 33, 3, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2435, 'Castrillo de Villavega', 34, 8, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2436, 'Silleda', 36, 4, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2437, 'Boada', 37, 0, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2438, 'Vilaflor', 38, 6, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2439, 'Piélagos', 39, 9, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2440, 'Cedillo de la Torre', 40, 3, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2441, 'Lantejuela, La', 41, 0, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2442, 'Caracena', 42, 5, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2443, 'Xerta', 43, 1, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2444, 'Calomarde', 44, 6, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2445, 'Cobisa', 45, 9, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2446, 'Benavites', 46, 2, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2447, 'Cistérniga', 47, 8, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2448, 'Larrabetzu', 48, 4, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2449, 'Coomonte', 49, 7, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2450, 'Bisimbre', 50, 0, 52);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2451, 'San Millán/Donemiliaga', 1, 4, 53);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2452, 'Munera', 2, 9, 53);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2453, 'Castalla', 3, 5, 53);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2454, 'Huércal-Overa', 4, 0, 53);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2455, 'Casasola', 5, 3, 53);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2456, 'Fuente del Arco', 6, 6, 53);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2457, 'Santa Eugènia', 7, 2, 53);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2458, 'Castellbell i el Vilar', 8, 8, 53);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2459, 'Casas de Don Gómez', 10, 5, 53);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2460, 'Chilches/Xilxes', 12, 7, 53);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2461, 'Manzanares', 13, 3, 53);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2462, 'Posadas', 14, 8, 53);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2463, 'Muros', 15, 1, 53);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2464, 'Cañizares', 16, 4, 53);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2465, 'Cortes de Baza', 18, 6, 53);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2466, 'Brihuega', 19, 9, 53);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2467, 'Lezo', 20, 3, 53);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2468, 'Niebla', 21, 0, 53);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2469, 'Benabarre', 22, 5, 53);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2470, 'Jódar', 23, 1, 53);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2471, 'Cebrones del Río', 24, 6, 53);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2472, 'Benavent de Segrià', 25, 9, 53);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2473, 'Corera', 26, 2, 53);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2474, 'Ribeira de Piquín', 27, 8, 53);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2475, 'Daganzo de Arriba', 28, 4, 53);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2476, 'Frigiliana', 29, 7, 53);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2477, 'Berbinzana', 31, 8, 53);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2478, 'Oímbra', 32, 3, 53);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2479, 'Quirós', 33, 9, 53);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2480, 'Castromocho', 34, 4, 53);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2481, 'Soutomaior', 36, 0, 53);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2482, 'Villa de Mazo', 38, 2, 53);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2483, 'Polaciones', 39, 5, 53);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2484, 'Cerezo de Abajo', 40, 9, 53);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2485, 'Lebrija', 41, 6, 53);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2486, 'Carrascosa de Abajo', 42, 1, 53);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2487, 'Duesaigües', 43, 7, 53);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2488, 'Camañas', 44, 2, 53);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2489, 'Consuegra', 45, 5, 53);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2490, 'Beneixida', 46, 8, 53);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2491, 'Cogeces de Íscar', 47, 4, 53);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2492, 'Laukiz', 48, 0, 53);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2493, 'Coreses', 49, 3, 53);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2494, 'Boquiñeni', 50, 6, 53);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2495, 'Urkabustaiz', 1, 9, 54);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2496, 'Navas de Jorquera', 2, 4, 54);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2497, 'Castell de Castells', 3, 0, 54);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2498, 'Illar', 4, 5, 54);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2499, 'Casavieja', 5, 8, 54);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2500, 'Fuente del Maestre', 6, 1, 54);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2501, 'Santa Eulalia del Río', 7, 7, 54);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2502, 'Castellbisbal', 8, 3, 54);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2503, 'Bozoó', 9, 6, 54);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2504, 'Casas del Castañar', 10, 0, 54);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2505, 'Membrilla', 13, 8, 54);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2506, 'Pozoblanco', 14, 3, 54);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2507, 'Narón', 15, 6, 54);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2508, 'Colera', 17, 5, 54);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2509, 'Cortes y Graena', 18, 1, 54);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2510, 'Budia', 19, 4, 54);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2511, 'Lizartza', 20, 8, 54);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2512, 'Palma del Condado, La', 21, 5, 54);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2513, 'Benasque', 22, 0, 54);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2514, 'Larva', 23, 6, 54);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2515, 'Cimanes de la Vega', 24, 1, 54);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2516, 'Cornago', 26, 7, 54);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2517, 'Riotorto', 27, 3, 54);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2518, 'Escorial, El', 28, 9, 54);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2519, 'Fuengirola', 29, 2, 54);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2520, 'Bertizarana', 31, 3, 54);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2521, 'Ourense', 32, 8, 54);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2522, 'Regueras, Las', 33, 4, 54);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2523, 'Tomiño', 36, 5, 54);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2524, 'Bodón, El', 37, 1, 54);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2525, 'Polanco', 39, 0, 54);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2526, 'Cerezo de Arriba', 40, 4, 54);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2527, 'Lora de Estepa', 41, 1, 54);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2528, 'Carrascosa de la Sierra', 42, 6, 54);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2529, 'Espluga de Francolí, L''', 43, 2, 54);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2530, 'Camarena de la Sierra', 44, 7, 54);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2531, 'Corral de Almaguer', 45, 0, 54);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2532, 'Benetússer', 46, 3, 54);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2533, 'Cogeces del Monte', 47, 9, 54);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2534, 'Leioa', 48, 5, 54);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2535, 'Corrales del Vino', 49, 8, 54);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2536, 'Bordalba', 50, 1, 54);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2537, 'Valdegovía/Gaubea', 1, 2, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2538, 'Nerpio', 2, 7, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2539, 'Catral', 3, 3, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2540, 'Instinción', 4, 8, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2541, 'Casillas', 5, 1, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2542, 'Fuentes de León', 6, 4, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2543, 'Santa Margalida', 7, 0, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2544, 'Castellcir', 8, 6, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2545, 'Brazacorta', 9, 9, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2546, 'Casas del Monte', 10, 3, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2547, 'Chodos/Xodos', 12, 5, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2548, 'Mestanza', 13, 1, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2549, 'Priego de Córdoba', 14, 6, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2550, 'Neda', 15, 9, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2551, 'Carboneras de Guadazaón', 16, 2, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2552, 'Colomers', 17, 8, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2553, 'Bujalaro', 19, 7, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2554, 'Arrasate/Mondragón', 20, 1, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2555, 'Palos de la Frontera', 21, 8, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2556, 'Berbegal', 22, 3, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2557, 'Linares', 23, 9, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2558, 'Cimanes del Tejar', 24, 4, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2559, 'Biosca', 25, 7, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2560, 'Corporales', 26, 0, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2561, 'Samos', 27, 6, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2562, 'Estremera', 28, 2, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2563, 'Fuente de Piedra', 29, 5, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2564, 'Betelu', 31, 6, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2565, 'Paderne de Allariz', 32, 1, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2566, 'Ribadedeva', 33, 7, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2567, 'Cervatos de la Cueza', 34, 2, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2568, 'Tui', 36, 8, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2569, 'Bogajo', 37, 4, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2570, 'Potes', 39, 3, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2571, 'Cilleruelo de San Mamés', 40, 7, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2572, 'Lora del Río', 41, 4, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2573, 'Casarejos', 42, 9, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2574, 'Falset', 43, 5, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2575, 'Camarillas', 44, 0, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2576, 'Cuerva', 45, 3, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2577, 'Beniarjó', 46, 6, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2578, 'Corcos', 47, 2, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2579, 'Lemoa', 48, 8, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2580, 'Cotanes del Monte', 49, 1, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2581, 'Borja', 50, 4, 55);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2582, 'Harana/Valle de Arana', 1, 5, 56);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2583, 'Ontur', 2, 0, 56);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2584, 'Cocentaina', 3, 6, 56);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2585, 'Laroya', 4, 1, 56);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2586, 'Castellanos de Zapardiel', 5, 4, 56);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2587, 'Garbayuela', 6, 7, 56);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2588, 'Santa María del Camí', 7, 3, 56);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2589, 'Castelldefels', 8, 9, 56);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2590, 'Briviesca', 9, 2, 56);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2591, 'Casas de Millán', 10, 6, 56);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2592, 'Chóvar', 12, 8, 56);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2593, 'Miguelturra', 13, 4, 56);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2594, 'Puente Genil', 14, 9, 56);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2595, 'Negreira', 15, 2, 56);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2596, 'Cardenete', 16, 5, 56);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2597, 'Cornellà del Terri', 17, 1, 56);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2598, 'Cúllar', 18, 7, 56);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2599, 'Mutriku', 20, 4, 56);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2600, 'Paterna del Campo', 21, 1, 56);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2601, 'Lopera', 23, 2, 56);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2602, 'Cistierna', 24, 7, 56);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2603, 'Bovera', 25, 0, 56);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2604, 'Cuzcurrita de Río Tirón', 26, 3, 56);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2605, 'Rábade', 27, 9, 56);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2606, 'Fresnedillas de la Oliva', 28, 5, 56);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2607, 'Gaucín', 29, 8, 56);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2608, 'Biurrun-Olcoz', 31, 9, 56);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2609, 'Padrenda', 32, 4, 56);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2610, 'Ribadesella', 33, 0, 56);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2611, 'Cervera de Pisuerga', 34, 5, 56);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2612, 'Valga', 36, 1, 56);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2613, 'Bouza, La', 37, 7, 56);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2614, 'Puente Viesgo', 39, 6, 56);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2615, 'Cobos de Fuentidueña', 40, 0, 56);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2616, 'Luisiana, La', 41, 7, 56);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2617, 'Castilfrío de la Sierra', 42, 2, 56);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2618, 'Fatarella, La', 43, 8, 56);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2619, 'Caminreal', 44, 3, 56);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2620, 'Chozas de Canales', 45, 6, 56);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2621, 'Beniatjar', 46, 9, 56);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2622, 'Corrales de Duero', 47, 5, 56);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2623, 'Lemoiz', 48, 1, 56);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2624, 'Cubillos', 49, 4, 56);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2625, 'Botorrita', 50, 7, 56);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2626, 'Villabuena de Álava/Eskuernaga', 1, 1, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2627, 'Ossa de Montiel', 2, 6, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2628, 'Confrides', 3, 2, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2629, 'Láujar de Andarax', 4, 7, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2630, 'Cebreros', 5, 0, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2631, 'Garlitos', 6, 3, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2632, 'Santanyí', 7, 9, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2633, 'Castell de l''Areny', 8, 5, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2634, 'Bugedo', 9, 8, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2635, 'Casas de Miravete', 10, 2, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2636, 'Eslida', 12, 4, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2637, 'Montiel', 13, 0, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2638, 'Rambla, La', 14, 5, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2639, 'Noia', 15, 8, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2640, 'Carrascosa', 16, 1, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2641, 'Corçà', 17, 7, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2642, 'Cúllar Vega', 18, 3, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2643, 'Bustares', 19, 6, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2644, 'Mutiloa', 20, 0, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2645, 'Paymogo', 21, 7, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2646, 'Bielsa', 22, 2, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2647, 'Lupión', 23, 8, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2648, 'Congosto', 24, 3, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2649, 'Bòrdes, Es', 25, 6, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2650, 'Daroca de Rioja', 26, 9, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2651, 'Sarria', 27, 5, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2652, 'Fresno de Torote', 28, 1, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2653, 'Genalguacil', 29, 4, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2654, 'Buñuel', 31, 5, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2655, 'Parada de Sil', 32, 0, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2656, 'Ribera de Arriba', 33, 6, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2657, 'Cevico de la Torre', 34, 1, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2658, 'Vigo', 36, 7, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2659, 'Bóveda del Río Almar', 37, 3, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2660, 'Ramales de la Victoria', 39, 2, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2661, 'Coca', 40, 6, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2662, 'Madroño, El', 41, 3, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2663, 'Castilruiz', 42, 8, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2664, 'Febró, La', 43, 4, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2665, 'Chueca', 45, 2, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2666, 'Benicolet', 46, 5, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2667, 'Cubillas de Santa Marta', 47, 1, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2668, 'Lekeitio', 48, 7, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2669, 'Cubo de Benavente', 49, 0, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2670, 'Brea de Aragón', 50, 3, 57);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2671, 'Legutio', 1, 7, 58);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2672, 'Paterna del Madera', 2, 2, 58);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2673, 'Cox', 3, 8, 58);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2674, 'Líjar', 4, 3, 58);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2675, 'Cepeda la Mora', 5, 6, 58);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2676, 'Garrovilla, La', 6, 9, 58);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2677, 'Selva', 7, 5, 58);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2678, 'Castellet i la Gornal', 8, 1, 58);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2679, 'Buniel', 9, 4, 58);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2680, 'Casatejada', 10, 8, 58);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2681, 'Espadilla', 12, 0, 58);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2682, 'Moral de Calatrava', 13, 6, 58);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2683, 'Rute', 14, 1, 58);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2684, 'Oleiros', 15, 4, 58);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2685, 'Carrascosa de Haro', 16, 7, 58);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2686, 'Crespià', 17, 3, 58);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2687, 'Cabanillas del Campo', 19, 2, 58);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2688, 'Olaberria', 20, 6, 58);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2689, 'Puebla de Guzmán', 21, 3, 58);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2690, 'Bierge', 22, 8, 58);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2691, 'Mancha Real', 23, 4, 58);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2692, 'Corbillos de los Oteros', 24, 9, 58);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2693, 'Borges Blanques, Les', 25, 2, 58);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2694, 'Enciso', 26, 5, 58);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2695, 'Saviñao, O', 27, 1, 58);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2696, 'Fuenlabrada', 28, 7, 58);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2697, 'Guaro', 29, 0, 58);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2698, 'Auritz/Burguete', 31, 1, 58);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2699, 'Pereiro de Aguiar, O', 32, 6, 58);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2700, 'Riosa', 33, 2, 58);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2701, 'Cevico Navero', 34, 7, 58);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2702, 'Vilaboa', 36, 3, 58);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2703, 'Brincones', 37, 9, 58);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2704, 'Rasines', 39, 8, 58);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2705, 'Codorniz', 40, 2, 58);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2706, 'Mairena del Alcor', 41, 9, 58);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2707, 'Castillejo de Robledo', 42, 4, 58);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2708, 'Figuera, La', 43, 0, 58);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2709, 'Domingo Pérez', 45, 8, 58);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2710, 'Benifairó de les Valls', 46, 1, 58);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2711, 'Cuenca de Campos', 47, 7, 58);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2712, 'Mallabia', 48, 3, 58);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2713, 'Cubo de Tierra del Vino, El', 49, 6, 58);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2714, 'Bubierca', 50, 9, 58);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2715, 'Vitoria-Gasteiz', 1, 0, 59);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2716, 'Peñascosa', 2, 5, 59);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2717, 'Crevillent', 3, 1, 59);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2718, 'Lubrín', 4, 6, 59);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2719, 'Cillán', 5, 9, 59);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2720, 'Granja de Torrehermosa', 6, 2, 59);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2721, 'Salines, Ses', 7, 8, 59);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2722, 'Castellfollit del Boix', 8, 4, 59);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2723, 'Burgos', 9, 7, 59);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2724, 'Casillas de Coria', 10, 1, 59);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2725, 'Fanzara', 12, 3, 59);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2726, 'Navalpino', 13, 9, 59);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2727, 'San Sebastián de los Ballesteros', 14, 4, 59);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2728, 'Ordes', 15, 7, 59);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2729, 'Chauchina', 18, 2, 59);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2730, 'Campillo de Dueñas', 19, 5, 59);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2731, 'Oñati', 20, 9, 59);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2732, 'Puerto Moral', 21, 6, 59);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2733, 'Biescas', 22, 1, 59);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2734, 'Marmolejo', 23, 7, 59);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2735, 'Corullón', 24, 2, 59);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2736, 'Bossòst', 25, 5, 59);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2737, 'Entrena', 26, 8, 59);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2738, 'Sober', 27, 4, 59);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2739, 'Fuente el Saz de Jarama', 28, 0, 59);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2740, 'Humilladero', 29, 3, 59);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2741, 'Burgui/Burgi', 31, 4, 59);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2742, 'Peroxa, A', 32, 9, 59);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2743, 'Salas', 33, 5, 59);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2744, 'Cisneros', 34, 0, 59);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2745, 'Vila de Cruces', 36, 6, 59);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2746, 'Buenamadre', 37, 2, 59);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2747, 'Reinosa', 39, 1, 59);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2748, 'Collado Hermoso', 40, 5, 59);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2749, 'Mairena del Aljarafe', 41, 2, 59);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2750, 'Centenera de Andaluz', 42, 7, 59);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2751, 'Figuerola del Camp', 43, 3, 59);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2752, 'Cantavieja', 44, 8, 59);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2753, 'Dosbarrios', 45, 1, 59);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2754, 'Benifairó de la Valldigna', 46, 4, 59);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2755, 'Curiel de Duero', 47, 0, 59);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2756, 'Mañaria', 48, 6, 59);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2757, 'Cuelgamures', 49, 9, 59);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2758, 'Bujaraloz', 50, 2, 59);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2759, 'Yécora/Iekora', 1, 4, 60);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2760, 'Peñas de San Pedro', 2, 9, 60);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2761, 'Quatretondeta', 3, 5, 60);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2762, 'Lucainena de las Torres', 4, 0, 60);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2763, 'Cisla', 5, 3, 60);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2764, 'Guareña', 6, 6, 60);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2765, 'Sineu', 7, 2, 60);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2766, 'Castellfollit de Riubregós', 8, 8, 60);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2767, 'Busto de Bureba', 9, 1, 60);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2768, 'Castañar de Ibor', 10, 5, 60);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2769, 'Figueroles', 12, 7, 60);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2770, 'Navas de Estena', 13, 3, 60);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2771, 'Santaella', 14, 8, 60);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2772, 'Oroso', 15, 1, 60);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2773, 'Casas de Benítez', 16, 4, 60);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2774, 'Darnius', 17, 0, 60);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2775, 'Campillo de Ranas', 19, 9, 60);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2776, 'Orexa', 20, 3, 60);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2777, 'Punta Umbría', 21, 0, 60);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2778, 'Binaced', 22, 5, 60);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2779, 'Martos', 23, 1, 60);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2780, 'Crémenes', 24, 6, 60);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2781, 'Cabanabona', 25, 9, 60);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2782, 'Estollo', 26, 2, 60);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2783, 'Taboada', 27, 8, 60);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2784, 'Fuentidueña de Tajo', 28, 4, 60);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2785, 'Igualeja', 29, 7, 60);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2786, 'Burlada/Burlata', 31, 8, 60);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2787, 'Petín', 32, 3, 60);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2788, 'San Martín del Rey Aurelio', 33, 9, 60);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2789, 'Cobos de Cerrato', 34, 4, 60);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2790, 'Vilagarcía de Arousa', 36, 0, 60);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2791, 'Buenavista', 37, 6, 60);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2792, 'Reocín', 39, 5, 60);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2793, 'Condado de Castilnovo', 40, 9, 60);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2794, 'Marchena', 41, 6, 60);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2795, 'Cerbón', 42, 1, 60);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2796, 'Flix', 43, 7, 60);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2797, 'Cañada de Benatanduz', 44, 2, 60);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2798, 'Erustes', 45, 5, 60);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2799, 'Benifaió', 46, 8, 60);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2800, 'Encinas de Esgueva', 47, 4, 60);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2801, 'Markina-Xemein', 48, 0, 60);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2802, 'Bulbuente', 50, 6, 60);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2803, 'Zalduondo', 1, 1, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2804, 'Pétrola', 2, 6, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2805, 'Daya Nueva', 3, 2, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2806, 'Lúcar', 4, 7, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2807, 'Colilla, La', 5, 0, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2808, 'Haba, La', 6, 3, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2809, 'Sóller', 7, 9, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2810, 'Castellgalí', 8, 5, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2811, 'Cabañes de Esgueva', 9, 8, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2812, 'Ceclavín', 10, 2, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2813, 'Forcall', 12, 4, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2814, 'Pedro Muñoz', 13, 0, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2815, 'Santa Eufemia', 14, 5, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2816, 'Ortigueira', 15, 8, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2817, 'Casas de Fernando Alonso', 16, 1, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2818, 'Das', 17, 7, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2819, 'Chimeneas', 18, 3, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2820, 'Campisábalos', 19, 6, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2821, 'Orio', 20, 0, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2822, 'Rociana del Condado', 21, 7, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2823, 'Binéfar', 22, 2, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2824, 'Mengíbar', 23, 8, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2825, 'Cuadros', 24, 3, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2826, 'Cabó', 25, 6, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2827, 'Ezcaray', 26, 9, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2828, 'Trabada', 27, 5, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2829, 'Galapagar', 28, 1, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2830, 'Istán', 29, 4, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2831, 'Busto, El', 31, 5, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2832, 'Piñor', 32, 0, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2833, 'San Martín de Oscos', 33, 6, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2834, 'Collazos de Boedo', 34, 1, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2835, 'Vilanova de Arousa', 36, 7, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2836, 'Cabaco, El', 37, 3, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2837, 'Ribamontán al Mar', 39, 2, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2838, 'Corral de Ayllón', 40, 6, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2839, 'Marinaleda', 41, 3, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2840, 'Cidones', 42, 8, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2841, 'Forès', 43, 4, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2842, 'Cañada de Verich, La', 44, 9, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2843, 'Escalona', 45, 2, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2844, 'Beniflá', 46, 5, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2845, 'Esguevillas de Esgueva', 47, 1, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2846, 'Maruri-Jatabe', 48, 7, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2847, 'Entrala', 49, 0, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2848, 'Bureta', 50, 3, 61);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2849, 'Zambrana', 1, 6, 62);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2850, 'Povedilla', 2, 1, 62);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2851, 'Daya Vieja', 3, 7, 62);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2852, 'Macael', 4, 2, 62);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2853, 'Collado de Contreras', 5, 5, 62);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2854, 'Helechosa de los Montes', 6, 8, 62);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2855, 'Son Servera', 7, 4, 62);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2856, 'Castellnou de Bages', 8, 0, 62);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2857, 'Cabezón de la Sierra', 9, 3, 62);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2858, 'Cedillo', 10, 7, 62);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2859, 'Picón', 13, 5, 62);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2860, 'Torrecampo', 14, 0, 62);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2861, 'Outes', 15, 3, 62);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2862, 'Casas de Garcimolina', 16, 6, 62);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2863, 'Escala, L''', 17, 2, 62);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2864, 'Churriana de la Vega', 18, 8, 62);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2865, 'Ormaiztegi', 20, 5, 62);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2866, 'Rosal de la Frontera', 21, 2, 62);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2867, 'Bisaurri', 22, 7, 62);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2868, 'Montizón', 23, 3, 62);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2869, 'Cubillas de los Oteros', 24, 8, 62);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2870, 'Camarasa', 25, 1, 62);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2871, 'Foncea', 26, 4, 62);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2872, 'Triacastela', 27, 0, 62);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2873, 'Garganta de los Montes', 28, 6, 62);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2874, 'Iznate', 29, 9, 62);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2875, 'Cabanillas', 31, 0, 62);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2876, 'Porqueira', 32, 5, 62);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2877, 'Santa Eulalia de Oscos', 33, 1, 62);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2878, 'Congosto de Valdavia', 34, 6, 62);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2879, 'Cabezabellosa de la Calzada', 37, 8, 62);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2880, 'Ribamontán al Monte', 39, 7, 62);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2881, 'Cubillo', 40, 1, 62);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2882, 'Martín de la Jara', 41, 8, 62);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2883, 'Cigudosa', 42, 3, 62);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2884, 'Freginals', 43, 9, 62);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2885, 'Cañada Vellida', 44, 4, 62);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2886, 'Escalonilla', 45, 7, 62);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2887, 'Benigánim', 46, 0, 62);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2888, 'Fombellida', 47, 6, 62);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2889, 'Mendata', 48, 2, 62);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2890, 'Espadañedo', 49, 5, 62);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2891, 'Burgo de Ebro, El', 50, 8, 62);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2892, 'Zuia', 1, 2, 63);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2893, 'Pozohondo', 2, 7, 63);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2894, 'Dénia', 3, 3, 63);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2895, 'María', 4, 8, 63);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2896, 'Collado del Mirón', 5, 1, 63);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2897, 'Herrera del Duque', 6, 4, 63);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2898, 'Valldemossa', 7, 0, 63);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2899, 'Castellolí', 8, 6, 63);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2900, 'Cavia', 9, 9, 63);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2901, 'Cerezo', 10, 3, 63);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2902, 'Fuente la Reina', 12, 5, 63);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2903, 'Piedrabuena', 13, 1, 63);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2904, 'Valenzuela', 14, 6, 63);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2905, 'Oza dos Ríos', 15, 9, 63);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2906, 'Casas de Guijarro', 16, 2, 63);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2907, 'Espinelves', 17, 8, 63);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2908, 'Darro', 18, 4, 63);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2909, 'Oiartzun', 20, 1, 63);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2910, 'San Bartolomé de la Torre', 21, 8, 63);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2911, 'Biscarrués', 22, 3, 63);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2912, 'Navas de San Juan', 23, 9, 63);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2913, 'Cubillas de Rueda', 24, 4, 63);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2914, 'Canejan', 25, 7, 63);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2915, 'Fonzaleche', 26, 0, 63);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2916, 'Valadouro, O', 27, 6, 63);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2917, 'Gargantilla del Lozoya y Pinilla de Buitrago', 28, 2, 63);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2918, 'Jimera de Líbar', 29, 5, 63);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2919, 'Cabredo', 31, 6, 63);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2920, 'Pobra de Trives, A', 32, 1, 63);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2921, 'San Tirso de Abres', 33, 7, 63);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2922, 'Cordovilla la Real', 34, 2, 63);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2923, 'Cabeza de Béjar, La', 37, 4, 63);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2924, 'Rionansa', 39, 3, 63);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2925, 'Cuéllar', 40, 7, 63);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2926, 'Molares, Los', 41, 4, 63);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2927, 'Cihuela', 42, 9, 63);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2928, 'Galera, La', 43, 5, 63);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2929, 'Cañizar del Olivar', 44, 0, 63);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2930, 'Espinoso del Rey', 45, 3, 63);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2931, 'Benimodo', 46, 6, 63);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2932, 'Fompedraza', 47, 2, 63);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2933, 'Mendexa', 48, 8, 63);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2934, 'Faramontanos de Tábara', 49, 1, 63);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2935, 'Buste, El', 50, 4, 63);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2936, 'Pozo-Lorente', 2, 2, 64);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2937, 'Dolores', 3, 8, 64);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2938, 'Mojácar', 4, 3, 64);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2939, 'Constanzana', 5, 6, 64);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2940, 'Higuera de la Serena', 6, 9, 64);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2941, 'Castell, Es', 7, 5, 64);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2942, 'Castellterçol', 8, 1, 64);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2943, 'Caleruega', 9, 4, 64);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2944, 'Cilleros', 10, 8, 64);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2945, 'Fuentes de Ayódar', 12, 0, 64);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2946, 'Poblete', 13, 6, 64);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2947, 'Valsequillo', 14, 1, 64);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2948, 'Paderne', 15, 4, 64);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2949, 'Casas de Haro', 16, 7, 64);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2950, 'Espolla', 17, 3, 64);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2951, 'Dehesas de Guadix', 18, 9, 64);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2952, 'Canredondo', 19, 2, 64);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2953, 'Pasaia', 20, 6, 64);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2954, 'San Juan del Puerto', 21, 3, 64);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2955, 'Blecua y Torres', 22, 8, 64);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2956, 'Noalejo', 23, 4, 64);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2957, 'Cubillos del Sil', 24, 9, 64);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2958, 'Castellar de la Ribera', 25, 2, 64);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2959, 'Fuenmayor', 26, 5, 64);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2960, 'Vicedo, O', 27, 1, 64);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2961, 'Gascones', 28, 7, 64);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2962, 'Jubrique', 29, 0, 64);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2963, 'Cadreita', 31, 1, 64);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2964, 'Pontedeva', 32, 6, 64);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2965, 'Santo Adriano', 33, 2, 64);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2966, 'Riotuerto', 39, 8, 64);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2967, 'Montellano', 41, 9, 64);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2968, 'Ciria', 42, 4, 64);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2969, 'Gandesa', 43, 0, 64);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2970, 'Cascante del Río', 44, 5, 64);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2971, 'Esquivias', 45, 8, 64);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2972, 'Benimuslem', 46, 1, 64);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2973, 'Fontihoyuelo', 47, 7, 64);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2974, 'Meñaka', 48, 3, 64);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2975, 'Fariza', 49, 6, 64);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2976, 'Cabañas de Ebro', 50, 9, 64);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2977, 'Pozuelo', 2, 5, 65);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2978, 'Elche/Elx', 3, 1, 65);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2979, 'Nacimiento', 4, 6, 65);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2980, 'Crespos', 5, 9, 65);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2981, 'Higuera de Llerena', 6, 2, 65);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2982, 'Vilafranca de Bonany', 7, 8, 65);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2983, 'Castellví de la Marca', 8, 4, 65);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2984, 'Campillo de Aranda', 9, 7, 65);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2985, 'Collado', 10, 1, 65);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2986, 'Gaibiel', 12, 3, 65);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2987, 'Porzuna', 13, 9, 65);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2988, 'Victoria, La', 14, 4, 65);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2989, 'Padrón', 15, 7, 65);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2990, 'Casas de los Pinos', 16, 0, 65);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2991, 'Esponellà', 17, 6, 65);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2992, 'Cantalojas', 19, 5, 65);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2993, 'Soraluze/Placencia de las Armas', 20, 9, 65);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2994, 'Sanlúcar de Guadiana', 21, 6, 65);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2995, 'Orcera', 23, 7, 65);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2996, 'Chozas de Abajo', 24, 2, 65);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2997, 'Galbárruli', 26, 8, 65);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2998, 'Vilalba', 27, 4, 65);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (2999, 'Getafe', 28, 0, 65);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3000, 'Júzcar', 29, 3, 65);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3001, 'Caparroso', 31, 4, 65);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3002, 'Punxín', 32, 9, 65);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3003, 'Sariego', 33, 5, 65);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3004, 'Cabeza del Caballo', 37, 2, 65);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3005, 'Rozas de Valdearroyo, Las', 39, 1, 65);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3006, 'Chañe', 40, 5, 65);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3007, 'Morón de la Frontera', 41, 2, 65);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3008, 'Cirujales del Río', 42, 7, 65);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3009, 'Garcia', 43, 3, 65);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3010, 'Castejón de Tornos', 44, 8, 65);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3011, 'Estrella, La', 45, 1, 65);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3012, 'Beniparrell', 46, 4, 65);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3013, 'Fresno el Viejo', 47, 0, 65);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3014, 'Ugao-Miraballes', 48, 6, 65);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3015, 'Fermoselle', 49, 9, 65);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3016, 'Cabolafuente', 50, 2, 65);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3017, 'Recueja, La', 2, 8, 66);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3018, 'Elda', 3, 4, 66);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3019, 'Níjar', 4, 9, 66);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3020, 'Cuevas del Valle', 5, 2, 66);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3021, 'Higuera de Vargas', 6, 5, 66);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3022, 'Castellví de Rosanes', 8, 7, 66);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3023, 'Campolara', 9, 0, 66);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3024, 'Conquista de la Sierra', 10, 4, 66);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3025, 'Pozuelo de Calatrava', 13, 2, 66);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3026, 'Villa del Río', 14, 7, 66);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3027, 'Pino, O', 15, 0, 66);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3028, 'Casasimarro', 16, 3, 66);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3029, 'Figueres', 17, 9, 66);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3030, 'Deifontes', 18, 5, 66);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3031, 'Cañizar', 19, 8, 66);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3032, 'Errezil', 20, 2, 66);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3033, 'San Silvestre de Guzmán', 21, 9, 66);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3034, 'Boltaña', 22, 4, 66);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3035, 'Peal de Becerro', 23, 0, 66);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3036, 'Destriana', 24, 5, 66);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3037, 'Galilea', 26, 1, 66);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3038, 'Viveiro', 27, 7, 66);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3039, 'Griñón', 28, 3, 66);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3040, 'Macharaviaya', 29, 6, 66);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3041, 'Cárcar', 31, 7, 66);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3042, 'Quintela de Leirado', 32, 2, 66);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3043, 'Siero', 33, 8, 66);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3044, 'Cubillas de Cerrato', 34, 3, 66);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3045, 'Ruente', 39, 4, 66);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3046, 'Navas de la Concepción, Las', 41, 5, 66);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3047, 'Garidells, Els', 43, 6, 66);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3048, 'Castel de Cabra', 44, 1, 66);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3049, 'Fuensalida', 45, 4, 66);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3050, 'Benirredrà', 46, 7, 66);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3051, 'Fuensaldaña', 47, 3, 66);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3052, 'Morga', 48, 9, 66);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3053, 'Ferreras de Abajo', 49, 2, 66);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3054, 'Cadrete', 50, 5, 66);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3055, 'Riópar', 2, 4, 67);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3056, 'Facheca', 3, 0, 67);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3057, 'Ohanes', 4, 5, 67);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3058, 'Chamartín', 5, 8, 67);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3059, 'Higuera la Real', 6, 1, 67);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3060, 'Centelles', 8, 3, 67);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3061, 'Canicosa de la Sierra', 9, 6, 67);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3062, 'Coria', 10, 0, 67);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3063, 'Geldo', 12, 2, 67);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3064, 'Pozuelos de Calatrava, Los', 13, 8, 67);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3065, 'Villafranca de Córdoba', 14, 3, 67);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3066, 'Pobra do Caramiñal, A', 15, 6, 67);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3067, 'Castejón', 16, 9, 67);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3068, 'Flaçà', 17, 5, 67);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3069, 'Diezma', 18, 1, 67);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3070, 'Cardoso de la Sierra, El', 19, 4, 67);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3071, 'Errenteria', 20, 8, 67);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3072, 'Santa Ana la Real', 21, 5, 67);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3073, 'Bonansa', 22, 0, 67);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3074, 'Pegalajar', 23, 6, 67);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3075, 'Encinedo', 24, 1, 67);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3076, 'Castelldans', 25, 4, 67);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3077, 'Gallinero de Cameros', 26, 7, 67);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3078, 'Guadalix de la Sierra', 28, 9, 67);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3079, 'Málaga', 29, 2, 67);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3080, 'Carcastillo', 31, 3, 67);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3081, 'Rairiz de Veiga', 32, 8, 67);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3082, 'Sobrescobio', 33, 4, 67);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3083, 'Dehesa de Montejo', 34, 9, 67);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3084, 'Cabrerizos', 37, 1, 67);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3085, 'Ruesga', 39, 0, 67);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3086, 'Olivares', 41, 1, 67);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3087, 'Ginestar', 43, 2, 67);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3088, 'Castelnou', 44, 7, 67);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3089, 'Gálvez', 45, 0, 67);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3090, 'Benisanó', 46, 3, 67);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3091, 'Fuente el Sol', 47, 9, 67);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3092, 'Muxika', 48, 5, 67);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3093, 'Ferreras de Arriba', 49, 8, 67);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3094, 'Calatayud', 50, 1, 67);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3095, 'Robledo', 2, 0, 68);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3096, 'Famorca', 3, 6, 68);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3097, 'Olula de Castro', 4, 1, 68);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3098, 'Hinojosa del Valle', 6, 7, 68);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3099, 'Cervelló', 8, 9, 68);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3100, 'Cantabrana', 9, 2, 68);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3101, 'Cuacos de Yuste', 10, 6, 68);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3102, 'Herbés', 12, 8, 68);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3103, 'Puebla de Don Rodrigo', 13, 4, 68);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3104, 'Villaharta', 14, 9, 68);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3105, 'Ponteceso', 15, 2, 68);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3106, 'Castillejo de Iniesta', 16, 5, 68);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3107, 'Foixà', 17, 1, 68);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3108, 'Dílar', 18, 7, 68);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3109, 'Leintz-Gatzaga', 20, 4, 68);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3110, 'Santa Bárbara de Casa', 21, 1, 68);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3111, 'Borau', 22, 6, 68);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3112, 'Ercina, La', 24, 7, 68);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3113, 'Castellnou de Seana', 25, 0, 68);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3114, 'Gimileo', 26, 3, 68);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3115, 'Guadarrama', 28, 5, 68);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3116, 'Manilva', 29, 8, 68);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3117, 'Cascante', 31, 9, 68);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3118, 'Ramirás', 32, 4, 68);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3119, 'Somiedo', 33, 0, 68);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3120, 'Dehesa de Romanos', 34, 5, 68);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3121, 'Cabrillas', 37, 7, 68);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3122, 'Ruiloba', 39, 6, 68);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3123, 'Domingo García', 40, 0, 68);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3124, 'Osuna', 41, 7, 68);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3125, 'Coscurita', 42, 2, 68);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3126, 'Godall', 43, 8, 68);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3127, 'Castelserás', 44, 3, 68);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3128, 'Garciotum', 45, 6, 68);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3129, 'Benissoda', 46, 9, 68);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3130, 'Fuente-Olmedo', 47, 5, 68);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3131, 'Mundaka', 48, 1, 68);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3132, 'Ferreruela', 49, 4, 68);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3133, 'Calatorao', 50, 7, 68);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3134, 'Roda, La', 2, 3, 69);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3135, 'Finestrat', 3, 9, 69);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3136, 'Olula del Río', 4, 4, 69);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3137, 'Donjimeno', 5, 7, 69);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3138, 'Hornachos', 6, 0, 69);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3139, 'Collbató', 8, 2, 69);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3140, 'Cumbre, La', 10, 9, 69);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3141, 'Higueras', 12, 1, 69);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3142, 'Puebla del Príncipe', 13, 7, 69);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3143, 'Villanueva de Córdoba', 14, 2, 69);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3144, 'Pontedeume', 15, 5, 69);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3145, 'Fontanals de Cerdanya', 17, 4, 69);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3146, 'Dólar', 18, 0, 69);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3147, 'Donostia-San Sebastián', 20, 7, 69);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3148, 'Santa Olalla del Cala', 21, 4, 69);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3149, 'Broto', 22, 9, 69);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3150, 'Porcuna', 23, 5, 69);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3151, 'Escobar de Campos', 24, 0, 69);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3152, 'Castelló de Farfanya', 25, 3, 69);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3153, 'Grañón', 26, 6, 69);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3154, 'Hiruela, La', 28, 8, 69);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3155, 'Marbella', 29, 1, 69);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3156, 'Cáseda', 31, 2, 69);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3157, 'Ribadavia', 32, 7, 69);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3158, 'Soto del Barco', 33, 3, 69);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3159, 'Dueñas', 34, 8, 69);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3160, 'Calvarrasa de Abajo', 37, 0, 69);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3161, 'San Felices de Buelna', 39, 9, 69);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3162, 'Donhierro', 40, 3, 69);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3163, 'Palacios y Villafranca, Los', 41, 0, 69);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3164, 'Covaleda', 42, 5, 69);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3165, 'Gratallops', 43, 1, 69);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3166, 'Gerindote', 45, 9, 69);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3167, 'Benisuera', 46, 2, 69);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3168, 'Gallegos de Hornija', 47, 8, 69);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3169, 'Mungia', 48, 4, 69);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3170, 'Figueruela de Arriba', 49, 7, 69);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3171, 'Calcena', 50, 0, 69);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3172, 'Salobre', 2, 7, 70);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3173, 'Formentera del Segura', 3, 3, 70);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3174, 'Oria', 4, 8, 70);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3175, 'Donvidas', 5, 1, 70);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3176, 'Jerez de los Caballeros', 6, 4, 70);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3177, 'Collsuspina', 8, 6, 70);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3178, 'Carazo', 9, 9, 70);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3179, 'Deleitosa', 10, 3, 70);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3180, 'Jana, la', 12, 5, 70);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3181, 'Puerto Lápice', 13, 1, 70);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3182, 'Villanueva del Duque', 14, 6, 70);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3183, 'Pontes de García Rodríguez, As', 15, 9, 70);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3184, 'Castillejo-Sierra', 16, 2, 70);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3185, 'Fontanilles', 17, 8, 70);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3186, 'Dúdar', 18, 4, 70);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3187, 'Casa de Uceda', 19, 7, 70);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3188, 'Segura', 20, 1, 70);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3189, 'Trigueros', 21, 8, 70);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3190, 'Pozo Alcón', 23, 9, 70);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3191, 'Fabero', 24, 4, 70);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3192, 'Castellserà', 25, 7, 70);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3193, 'Grávalos', 26, 0, 70);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3194, 'Horcajo de la Sierra-Aoslos', 28, 2, 70);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3195, 'Mijas', 29, 5, 70);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3196, 'Castejón', 31, 6, 70);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3197, 'San Xoán de Río', 32, 1, 70);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3198, 'Tapia de Casariego', 33, 7, 70);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3199, 'Espinosa de Cerrato', 34, 2, 70);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3200, 'Calvarrasa de Arriba', 37, 4, 70);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3201, 'San Miguel de Aguayo', 39, 3, 70);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3202, 'Duruelo', 40, 7, 70);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3203, 'Palomares del Río', 41, 4, 70);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3204, 'Cubilla', 42, 9, 70);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3205, 'Guiamets, Els', 43, 5, 70);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3206, 'Castellar, El', 44, 0, 70);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3207, 'Guadamur', 45, 3, 70);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3208, 'Bétera', 46, 6, 70);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3209, 'Gatón de Campos', 47, 2, 70);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3210, 'Aulesti', 48, 8, 70);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3211, 'Calmarza', 50, 4, 70);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3212, 'San Pedro', 2, 4, 71);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3213, 'Gata de Gorgos', 3, 0, 71);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3214, 'Padules', 4, 5, 71);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3215, 'Lapa, La', 6, 1, 71);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3216, 'Copons', 8, 3, 71);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3217, 'Carcedo de Bureba', 9, 6, 71);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3218, 'Descargamaría', 10, 0, 71);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3219, 'Jérica', 12, 2, 71);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3220, 'Puertollano', 13, 8, 71);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3221, 'Villanueva del Rey', 14, 3, 71);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3222, 'Porto do Son', 15, 6, 71);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3223, 'Castillo-Albaráñez', 16, 9, 71);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3224, 'Fontcoberta', 17, 5, 71);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3225, 'Dúrcal', 18, 1, 71);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3226, 'Casar, El', 19, 4, 71);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3227, 'Tolosa', 20, 8, 71);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3228, 'Valdelarco', 21, 5, 71);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3229, 'Puente de Génave', 23, 6, 71);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3230, 'Folgoso de la Ribera', 24, 1, 71);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3231, 'Cava', 25, 4, 71);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3232, 'Haro', 26, 7, 71);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3233, 'Horcajuelo de la Sierra', 28, 9, 71);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3234, 'Moclinejo', 29, 2, 71);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3235, 'Castillonuevo', 31, 3, 71);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3236, 'Riós', 32, 8, 71);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3237, 'Taramundi', 33, 4, 71);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3238, 'Espinosa de Villagonzalo', 34, 9, 71);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3239, 'Calzada de Béjar, La', 37, 1, 71);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3240, 'San Pedro del Romeral', 39, 0, 71);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3241, 'Encinas', 40, 4, 71);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3242, 'Paradas', 41, 1, 71);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3243, 'Cubo de la Solana', 42, 6, 71);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3244, 'Horta de Sant Joan', 43, 2, 71);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3245, 'Castellote', 44, 7, 71);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3246, 'Guardia, La', 45, 0, 71);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3247, 'Bicorp', 46, 3, 71);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3248, 'Geria', 47, 9, 71);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3249, 'Muskiz', 48, 5, 71);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3250, 'Fonfría', 49, 8, 71);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3251, 'Campillo de Aragón', 50, 1, 71);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3252, 'Socovos', 2, 9, 72);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3253, 'Gaianes', 3, 5, 72);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3254, 'Partaloa', 4, 0, 72);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3255, 'Espinosa de los Caballeros', 5, 3, 72);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3256, 'Lobón', 6, 6, 72);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3257, 'Corbera de Llobregat', 8, 8, 72);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3258, 'Carcedo de Burgos', 9, 1, 72);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3259, 'Eljas', 10, 5, 72);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3260, 'Lucena del Cid', 12, 7, 72);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3261, 'Retuerta del Bullaque', 13, 3, 72);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3262, 'Villaralto', 14, 8, 72);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3263, 'Rianxo', 15, 1, 72);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3264, 'Castillo de Garcimuñoz', 16, 4, 72);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3265, 'Escúzar', 18, 6, 72);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3266, 'Urnieta', 20, 3, 72);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3267, 'Valverde del Camino', 21, 0, 72);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3268, 'Caldearenas', 22, 5, 72);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3269, 'Puerta de Segura, La', 23, 1, 72);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3270, 'Cervera', 25, 9, 72);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3271, 'Herce', 26, 2, 72);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3272, 'Hoyo de Manzanares', 28, 4, 72);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3273, 'Mollina', 29, 7, 72);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3274, 'Cintruénigo', 31, 8, 72);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3275, 'Rúa, A', 32, 3, 72);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3276, 'Teverga', 33, 9, 72);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3277, 'Frechilla', 34, 4, 72);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3278, 'Calzada de Don Diego', 37, 6, 72);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3279, 'San Roque de Riomiera', 39, 5, 72);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3280, 'Encinillas', 40, 9, 72);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3281, 'Pedrera', 41, 6, 72);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3282, 'Lloar, El', 43, 7, 72);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3283, 'Herencias, Las', 45, 5, 72);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3284, 'Bocairent', 46, 8, 72);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3285, 'Otxandio', 48, 0, 72);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3286, 'Carenas', 50, 6, 72);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3287, 'Tarazona de la Mancha', 2, 5, 73);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3288, 'Gorga', 3, 1, 73);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3289, 'Paterna del Río', 4, 6, 73);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3290, 'Flores de Ávila', 5, 9, 73);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3291, 'Llera', 6, 2, 73);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3292, 'Cornellà de Llobregat', 8, 4, 73);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3293, 'Cardeñadijo', 9, 7, 73);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3294, 'Escurial', 10, 1, 73);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3295, 'Ludiente', 12, 3, 73);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3296, 'Saceruela', 13, 9, 73);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3297, 'Villaviciosa de Córdoba', 14, 4, 73);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3298, 'Ribeira', 15, 7, 73);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3299, 'Cervera del Llano', 16, 0, 73);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3300, 'Fornells de la Selva', 17, 6, 73);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3301, 'Casas de San Galindo', 19, 5, 73);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3302, 'Usurbil', 20, 9, 73);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3303, 'Villablanca', 21, 6, 73);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3304, 'Quesada', 23, 7, 73);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3305, 'Fresno de la Vega', 24, 2, 73);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3306, 'Cervià de les Garrigues', 25, 5, 73);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3307, 'Herramélluri', 26, 8, 73);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3308, 'Humanes de Madrid', 28, 0, 73);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3309, 'Monda', 29, 3, 73);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3310, 'Ziordia', 31, 4, 73);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3311, 'Rubiá', 32, 9, 73);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3312, 'Tineo', 33, 5, 73);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3313, 'Fresno del Río', 34, 0, 73);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3314, 'Calzada de Valdunciel', 37, 2, 73);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3315, 'Santa Cruz de Bezana', 39, 1, 73);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3316, 'Escalona del Prado', 40, 5, 73);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3317, 'Pedroso, El', 41, 2, 73);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3318, 'Cueva de Ágreda', 42, 7, 73);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3319, 'Llorac', 43, 3, 73);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3320, 'Herreruela de Oropesa', 45, 1, 73);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3321, 'Bolbaite', 46, 4, 73);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3322, 'Herrín de Campos', 47, 0, 73);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3323, 'Ondarroa', 48, 6, 73);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3324, 'Cariñena', 50, 2, 73);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3325, 'Tobarra', 2, 0, 74);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3326, 'Granja de Rocamora', 3, 6, 74);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3327, 'Pechina', 4, 1, 74);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3328, 'Fontiveros', 5, 4, 74);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3329, 'Llerena', 6, 7, 74);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3330, 'Cubelles', 8, 9, 74);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3331, 'Cardeñajimeno', 9, 2, 74);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3332, 'Llosa, la', 12, 8, 74);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3333, 'San Carlos del Valle', 13, 4, 74);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3334, 'Viso, El', 14, 9, 74);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3335, 'Rois', 15, 2, 74);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3336, 'Cierva, La', 16, 5, 74);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3337, 'Fortià', 17, 1, 74);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3338, 'Ferreira', 18, 7, 74);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3339, 'Caspueñas', 19, 0, 74);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3340, 'Bergara', 20, 4, 74);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3341, 'Villalba del Alcor', 21, 1, 74);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3342, 'Campo', 22, 6, 74);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3343, 'Rus', 23, 2, 74);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3344, 'Fuentes de Carbajal', 24, 7, 74);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3345, 'Ciutadilla', 25, 0, 74);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3346, 'Hervías', 26, 3, 74);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3347, 'Leganés', 28, 5, 74);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3348, 'Montejaque', 29, 8, 74);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3349, 'Cirauqui/Zirauki', 31, 9, 74);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3350, 'San Amaro', 32, 4, 74);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3351, 'Vegadeo', 33, 0, 74);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3352, 'Frómista', 34, 5, 74);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3353, 'Campillo de Azaba', 37, 7, 74);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3354, 'Santa María de Cayón', 39, 6, 74);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3355, 'Escarabajosa de Cabezas', 40, 0, 74);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3356, 'Peñaflor', 41, 7, 74);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3357, 'Llorenç del Penedès', 43, 8, 74);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3358, 'Cedrillas', 44, 3, 74);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3359, 'Hinojosa de San Vicente', 45, 6, 74);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3360, 'Bonrepòs i Mirambell', 46, 9, 74);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3361, 'Hornillos de Eresma', 47, 5, 74);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3362, 'Urduña/Orduña', 48, 1, 74);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3363, 'Caspe', 50, 7, 74);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3364, 'Valdeganga', 2, 3, 75);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3365, 'Castell de Guadalest, el', 3, 9, 75);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3366, 'Pulpí', 4, 4, 75);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3367, 'Fresnedilla', 5, 7, 75);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3368, 'Magacela', 6, 0, 75);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3369, 'Dosrius', 8, 2, 75);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3370, 'Cardeñuela Riopico', 9, 5, 75);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3371, 'Fresnedoso de Ibor', 10, 9, 75);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3372, 'Mata de Morella, la', 12, 1, 75);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3373, 'San Lorenzo de Calatrava', 13, 7, 75);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3374, 'Zuheros', 14, 2, 75);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3375, 'Sada', 15, 5, 75);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3376, 'Garrigàs', 17, 4, 75);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3377, 'Castejón de Henares', 19, 3, 75);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3378, 'Villabona', 20, 7, 75);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3379, 'Villanueva de las Cruces', 21, 4, 75);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3380, 'Camporrélls', 22, 9, 75);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3381, 'Sabiote', 23, 5, 75);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3382, 'Clariana de Cardener', 25, 3, 75);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3383, 'Hormilla', 26, 6, 75);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3384, 'Loeches', 28, 8, 75);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3385, 'Nerja', 29, 1, 75);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3386, 'Ciriza/Ziritza', 31, 2, 75);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3387, 'San Cibrao das Viñas', 32, 7, 75);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3388, 'Villanueva de Oscos', 33, 3, 75);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3389, 'Santander', 39, 9, 75);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3390, 'Escobar de Polendos', 40, 3, 75);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3391, 'Pilas', 41, 0, 75);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3392, 'Dévanos', 42, 5, 75);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3393, 'Margalef', 43, 1, 75);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3394, 'Celadas', 44, 6, 75);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3395, 'Hontanar', 45, 9, 75);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3396, 'Bufali', 46, 2, 75);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3397, 'Íscar', 47, 8, 75);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3398, 'Orozko', 48, 4, 75);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3399, 'Fresno de la Polvorosa', 49, 7, 75);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3400, 'Castejón de Alarba', 50, 0, 75);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3401, 'Vianos', 2, 6, 76);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3402, 'Guardamar del Segura', 3, 2, 76);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3403, 'Purchena', 4, 7, 76);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3404, 'Fresno, El', 5, 0, 76);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3405, 'Maguilla', 6, 3, 76);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3406, 'Esparreguera', 8, 5, 76);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3407, 'Carrias', 9, 8, 76);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3408, 'Galisteo', 10, 2, 76);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3409, 'Matet', 12, 4, 76);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3410, 'Santa Cruz de los Cáñamos', 13, 0, 76);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3411, 'San Sadurniño', 15, 8, 76);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3412, 'Garrigoles', 17, 7, 76);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3413, 'Fonelas', 18, 3, 76);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3414, 'Castellar de la Muela', 19, 6, 76);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3415, 'Ordizia', 20, 0, 76);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3416, 'Villanueva de los Castillejos', 21, 7, 76);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3417, 'Canal de Berdún', 22, 2, 76);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3418, 'Santa Elena', 23, 8, 76);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3419, 'Garrafe de Torío', 24, 3, 76);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3420, 'Cogul, El', 25, 6, 76);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3421, 'Hormilleja', 26, 9, 76);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3422, 'Lozoya', 28, 1, 76);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3423, 'Ojén', 29, 4, 76);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3424, 'Cizur', 31, 5, 76);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3425, 'San Cristovo de Cea', 32, 0, 76);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3426, 'Villaviciosa', 33, 6, 76);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3427, 'Fuentes de Nava', 34, 1, 76);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3428, 'Santillana del Mar', 39, 2, 76);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3429, 'Espinar, El', 40, 6, 76);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3430, 'Pruna', 41, 3, 76);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3431, 'Deza', 42, 8, 76);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3432, 'Marçà', 43, 4, 76);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3433, 'Cella', 44, 9, 76);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3434, 'Hormigos', 45, 2, 76);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3435, 'Bugarra', 46, 5, 76);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3436, 'Laguna de Duero', 47, 1, 76);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3437, 'Sukarrieta', 48, 7, 76);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3438, 'Fresno de la Ribera', 49, 0, 76);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3439, 'Castejón de las Armas', 50, 3, 76);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3440, 'Villa de Ves', 2, 2, 77);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3441, 'Fondó de les Neus, el/Hondón de las Nieves', 3, 8, 77);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3442, 'Rágol', 4, 3, 77);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3443, 'Fuente el Saúz', 5, 6, 77);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3444, 'Malcocinado', 6, 9, 77);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3445, 'Esplugues de Llobregat', 8, 1, 77);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3446, 'Cascajares de Bureba', 9, 4, 77);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3447, 'Garciaz', 10, 8, 77);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3448, 'Moncofa', 12, 0, 77);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3449, 'Santa Cruz de Mudela', 13, 6, 77);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3450, 'Santa Comba', 15, 4, 77);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3451, 'Garriguella', 17, 3, 77);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3452, 'Urretxu', 20, 6, 77);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3453, 'Villarrasa', 21, 3, 77);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3454, 'Candasnos', 22, 8, 77);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3455, 'Santiago de Calatrava', 23, 4, 77);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3456, 'Gordaliza del Pino', 24, 9, 77);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3457, 'Coll de Nargó', 25, 2, 77);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3458, 'Hornillos de Cameros', 26, 5, 77);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3459, 'Parauta', 29, 0, 77);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3460, 'Corella', 31, 1, 77);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3461, 'Sandiás', 32, 6, 77);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3462, 'Villayón', 33, 2, 77);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3463, 'Fuentes de Valdepero', 34, 7, 77);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3464, 'Campo de Peñaranda, El', 37, 9, 77);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3465, 'Santiurde de Reinosa', 39, 8, 77);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3466, 'Espirdo', 40, 2, 77);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3467, 'Puebla de Cazalla, La', 41, 9, 77);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3468, 'Mas de Barberans', 43, 0, 77);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3469, 'Cerollera, La', 44, 5, 77);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3470, 'Huecas', 45, 8, 77);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3471, 'Buñol', 46, 1, 77);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3472, 'Langayo', 47, 7, 77);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3473, 'Plentzia', 48, 3, 77);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3474, 'Fresno de Sayago', 49, 6, 77);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3475, 'Castejón de Valdejasa', 50, 9, 77);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3476, 'Villalgordo del Júcar', 2, 8, 78);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3477, 'Hondón de los Frailes', 3, 4, 78);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3478, 'Rioja', 4, 9, 78);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3479, 'Fuentes de Año', 5, 2, 78);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3480, 'Malpartida de la Serena', 6, 5, 78);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3481, 'Espunyola, L''', 8, 7, 78);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3482, 'Cascajares de la Sierra', 9, 0, 78);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3483, 'Garganta, La', 10, 4, 78);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3484, 'Montán', 12, 6, 78);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3485, 'Socuéllamos', 13, 2, 78);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3486, 'Santiago de Compostela', 15, 0, 78);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3487, 'Cuenca', 16, 3, 78);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3488, 'Ger', 17, 9, 78);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3489, 'Freila', 18, 5, 78);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3490, 'Castilforte', 19, 8, 78);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3491, 'Zaldibia', 20, 2, 78);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3492, 'Zalamea la Real', 21, 9, 78);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3493, 'Canfranc', 22, 4, 78);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3494, 'Gordoncillo', 24, 5, 78);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3495, 'Corbins', 25, 8, 78);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3496, 'Hornos de Moncalvillo', 26, 1, 78);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3497, 'Madarcos', 28, 3, 78);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3498, 'Cortes', 31, 7, 78);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3499, 'Sarreaus', 32, 2, 78);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3500, 'Yernes y Tameza', 33, 8, 78);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3501, 'Candelario', 37, 5, 78);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3502, 'Santiurde de Toranzo', 39, 4, 78);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3503, 'Fresneda de Cuéllar', 40, 8, 78);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3504, 'Puebla de los Infantes, La', 41, 5, 78);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3505, 'Duruelo de la Sierra', 42, 0, 78);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3506, 'Masdenverge', 43, 6, 78);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3507, 'Huerta de Valdecarábanos', 45, 4, 78);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3508, 'Burjassot', 46, 7, 78);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3509, 'Lomoviejo', 47, 3, 78);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3510, 'Portugalete', 48, 9, 78);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3511, 'Friera de Valverde', 49, 2, 78);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3512, 'Castiliscar', 50, 5, 78);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3513, 'Villamalea', 2, 1, 79);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3514, 'Ibi', 3, 7, 79);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3515, 'Roquetas de Mar', 4, 2, 79);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3516, 'Gallegos de Altamiros', 5, 5, 79);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3517, 'Manchita', 6, 8, 79);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3518, 'Estany, L''', 8, 0, 79);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3519, 'Castellanos de Castro', 9, 3, 79);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3520, 'Garganta la Olla', 10, 7, 79);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3521, 'Montanejos', 12, 9, 79);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3522, 'Solana, La', 13, 5, 79);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3523, 'Santiso', 15, 3, 79);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3524, 'Cueva del Hierro', 16, 6, 79);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3525, 'Girona', 17, 2, 79);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3526, 'Fuente Vaqueros', 18, 8, 79);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3527, 'Castilnuevo', 19, 1, 79);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3528, 'Zarautz', 20, 5, 79);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3529, 'Zufre', 21, 2, 79);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3530, 'Capdesaso', 22, 7, 79);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3531, 'Santisteban del Puerto', 23, 3, 79);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3532, 'Gradefes', 24, 8, 79);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3533, 'Cubells', 25, 1, 79);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3534, 'Huércanos', 26, 4, 79);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3535, 'Madrid', 28, 6, 79);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3536, 'Periana', 29, 9, 79);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3537, 'Desojo', 31, 0, 79);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3538, 'Taboadela', 32, 5, 79);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3539, 'Grijota', 34, 6, 79);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3540, 'Canillas de Abajo', 37, 8, 79);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3541, 'Santoña', 39, 7, 79);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3542, 'Fresno de Cantespino', 40, 1, 79);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3543, 'Puebla del Río, La', 41, 8, 79);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3544, 'Escobosa de Almazán', 42, 3, 79);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3545, 'Masllorenç', 43, 9, 79);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3546, 'Iglesuela, La', 45, 7, 79);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3547, 'Calles', 46, 0, 79);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3548, 'Llano de Olmedo', 47, 6, 79);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3549, 'Errigoiti', 48, 2, 79);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3550, 'Fuente Encalada', 49, 5, 79);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3551, 'Cervera de la Cañada', 50, 8, 79);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3552, 'Villapalacios', 2, 5, 80);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3553, 'Jacarilla', 3, 1, 80);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3554, 'Santa Cruz de Marchena', 4, 6, 80);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3555, 'Gallegos de Sobrinos', 5, 9, 80);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3556, 'Medellín', 6, 2, 80);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3557, 'Fígols', 8, 4, 80);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3558, 'Gargantilla', 10, 1, 80);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3559, 'Morella', 12, 3, 80);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3560, 'Solana del Pino', 13, 9, 80);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3561, 'Sobrado', 15, 7, 80);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3562, 'Gombrèn', 17, 6, 80);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3563, 'Cendejas de Enmedio', 19, 5, 80);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3564, 'Zumarraga', 20, 9, 80);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3565, 'Capella', 22, 1, 80);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3566, 'Santo Tomé', 23, 7, 80);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3567, 'Grajal de Campos', 24, 2, 80);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3568, 'Igea', 26, 8, 80);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3569, 'Majadahonda', 28, 0, 80);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3570, 'Pizarra', 29, 3, 80);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3571, 'Dicastillo', 31, 4, 80);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3572, 'Teixeira, A', 32, 9, 80);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3573, 'Guardo', 34, 0, 80);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3574, 'Cantagallo', 37, 2, 80);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3575, 'San Vicente de la Barquera', 39, 1, 80);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3576, 'Fresno de la Fuente', 40, 5, 80);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3577, 'Real de la Jara, El', 41, 2, 80);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3578, 'Espeja de San Marcelino', 42, 7, 80);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3579, 'Masó, La', 43, 3, 80);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3580, 'Codoñera, La', 44, 8, 80);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3581, 'Illán de Vacas', 45, 1, 80);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3582, 'Camporrobles', 46, 4, 80);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3583, 'Manzanillo', 47, 0, 80);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3584, 'Valle de Trápaga-Trapagaran', 48, 6, 80);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3585, 'Fuentelapeña', 49, 9, 80);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3586, 'Cerveruela', 50, 2, 80);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3587, 'Villarrobledo', 2, 2, 81);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3588, 'Xaló', 3, 8, 81);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3589, 'Santa Fe de Mondújar', 4, 3, 81);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3590, 'Garganta del Villar', 5, 6, 81);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3591, 'Medina de las Torres', 6, 9, 81);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3592, 'Fogars de Montclús', 8, 1, 81);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3593, 'Gargüera', 10, 8, 81);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3594, 'Navajas', 12, 0, 81);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3595, 'Terrinches', 13, 6, 81);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3596, 'Somozas, As', 15, 4, 81);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3597, 'Chumillas', 16, 7, 81);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3598, 'Gualta', 17, 3, 81);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3599, 'Cendejas de la Torre', 19, 2, 81);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3600, 'Zumaia', 20, 6, 81);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3601, 'Casbas de Huesca', 22, 8, 81);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3602, 'Segura de la Sierra', 23, 4, 81);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3603, 'Gusendos de los Oteros', 24, 9, 81);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3604, 'Espluga Calba, L''', 25, 2, 81);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3605, 'Jalón de Cameros', 26, 5, 81);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3606, 'Pujerra', 29, 0, 81);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3607, 'Donamaria', 31, 1, 81);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3608, 'Toén', 32, 6, 81);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3609, 'Guaza de Campos', 34, 7, 81);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3610, 'Cantalapiedra', 37, 9, 81);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3611, 'Saro', 39, 8, 81);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3612, 'Frumales', 40, 2, 81);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3613, 'Rinconada, La', 41, 9, 81);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3614, 'Espejón', 42, 4, 81);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3615, 'Maspujols', 43, 0, 81);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3616, 'Illescas', 45, 8, 81);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3617, 'Canals', 46, 1, 81);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3618, 'Marzales', 47, 7, 81);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3619, 'Lezama', 48, 3, 81);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3620, 'Fuentesaúco', 49, 6, 81);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3621, 'Cetina', 50, 9, 81);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3622, 'Villatoya', 2, 7, 82);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3623, 'Jávea/Xàbia', 3, 3, 82);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3624, 'Senés', 4, 8, 82);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3625, 'Gavilanes', 5, 1, 82);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3626, 'Mengabril', 6, 4, 82);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3627, 'Fogars de la Selva', 8, 6, 82);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3628, 'Castildelgado', 9, 9, 82);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3629, 'Garrovillas de Alconétar', 10, 3, 82);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3630, 'Nules', 12, 5, 82);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3631, 'Tomelloso', 13, 1, 82);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3632, 'Teo', 15, 9, 82);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3633, 'Enguídanos', 16, 2, 82);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3634, 'Guils de Cerdanya', 17, 8, 82);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3635, 'Galera', 18, 4, 82);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3636, 'Centenera', 19, 7, 82);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3637, 'Castejón del Puente', 22, 3, 82);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3638, 'Siles', 23, 9, 82);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3639, 'Hospital de Órbigo', 24, 4, 82);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3640, 'Espot', 25, 7, 82);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3641, 'Laguna de Cameros', 26, 0, 82);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3642, 'Manzanares el Real', 28, 2, 82);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3643, 'Rincón de la Victoria', 29, 5, 82);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3644, 'Etxalar', 31, 6, 82);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3645, 'Trasmiras', 32, 1, 82);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3646, 'Hérmedes de Cerrato', 34, 2, 82);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3647, 'Cantalpino', 37, 4, 82);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3648, 'Selaya', 39, 3, 82);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3649, 'Fuente de Santa Cruz', 40, 7, 82);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3650, 'Roda de Andalucía, La', 41, 4, 82);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3651, 'Estepa de San Juan', 42, 9, 82);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3652, 'Masroig, El', 43, 5, 82);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3653, 'Corbalán', 44, 0, 82);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3654, 'Lagartera', 45, 3, 82);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3655, 'Canet d''En Berenguer', 46, 6, 82);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3656, 'Matapozuelos', 47, 2, 82);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3657, 'Santurtzi', 48, 8, 82);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3658, 'Fuentes de Ropel', 49, 1, 82);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3659, 'Cimballa', 50, 4, 82);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3660, 'Villavaliente', 2, 3, 83);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3661, 'Jijona/Xixona', 3, 9, 83);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3662, 'Serón', 4, 4, 83);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3663, 'Gemuño', 5, 7, 83);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3664, 'Mérida', 6, 0, 83);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3665, 'Folgueroles', 8, 2, 83);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3666, 'Castil de Peones', 9, 5, 83);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3667, 'Garvín', 10, 9, 83);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3668, 'Olocau del Rey', 12, 1, 83);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3669, 'Torralba de Calatrava', 13, 7, 83);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3670, 'Toques', 15, 5, 83);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3671, 'Fresneda de Altarejos', 16, 8, 83);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3672, 'Hostalric', 17, 4, 83);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3673, 'Gobernador', 18, 0, 83);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3674, 'Castejón de Monegros', 22, 9, 83);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3675, 'Igüeña', 24, 0, 83);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3676, 'Lagunilla del Jubera', 26, 6, 83);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3677, 'Meco', 28, 8, 83);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3678, 'Riogordo', 29, 1, 83);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3679, 'Echarri', 31, 2, 83);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3680, 'Veiga, A', 32, 7, 83);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3681, 'Herrera de Pisuerga', 34, 8, 83);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3682, 'Cantaracillo', 37, 0, 83);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3683, 'Soba', 39, 9, 83);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3684, 'Fuente el Olmo de Fuentidueña', 40, 3, 83);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3685, 'Ronquillo, El', 41, 0, 83);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3686, 'Frechilla de Almazán', 42, 5, 83);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3687, 'Milà, El', 43, 1, 83);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3688, 'Layos', 45, 9, 83);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3689, 'Carcaixent', 46, 2, 83);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3690, 'Matilla de los Caños', 47, 8, 83);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3691, 'Ortuella', 48, 4, 83);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3692, 'Fuentesecas', 49, 7, 83);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3693, 'Cinco Olivas', 50, 0, 83);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3694, 'Villaverde de Guadalimar', 2, 8, 84);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3695, 'Lorcha/Orxa, l''', 3, 4, 84);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3696, 'Sierro', 4, 9, 84);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3697, 'Gilbuena', 5, 2, 84);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3698, 'Mirandilla', 6, 5, 84);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3699, 'Fonollosa', 8, 7, 84);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3700, 'Castrillo de la Reina', 9, 0, 84);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3701, 'Gata', 10, 4, 84);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3702, 'Onda', 12, 6, 84);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3703, 'Torre de Juan Abad', 13, 2, 84);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3704, 'Tordoia', 15, 0, 84);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3705, 'Fresneda de la Sierra', 16, 3, 84);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3706, 'Isòvol', 17, 9, 84);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3707, 'Gójar', 18, 5, 84);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3708, 'Castejón de Sos', 22, 4, 84);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3709, 'Sorihuela del Guadalimar', 23, 0, 84);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3710, 'Izagre', 24, 5, 84);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3711, 'Lardero', 26, 1, 84);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3712, 'Mejorada del Campo', 28, 3, 84);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3713, 'Ronda', 29, 6, 84);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3714, 'Etxarri-Aranatz', 31, 7, 84);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3715, 'Verea', 32, 2, 84);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3716, 'Herrera de Valdecañas', 34, 3, 84);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3717, 'Solórzano', 39, 4, 84);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3718, 'Fuente el Olmo de Íscar', 40, 8, 84);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3719, 'Rubio, El', 41, 5, 84);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3720, 'Fresno de Caracena', 42, 0, 84);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3721, 'Miravet', 43, 6, 84);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3722, 'Cortes de Aragón', 44, 1, 84);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3723, 'Lillo', 45, 4, 84);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3724, 'Càrcer', 46, 7, 84);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3725, 'Mayorga', 47, 3, 84);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3726, 'Sestao', 48, 9, 84);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3727, 'Fuentespreadas', 49, 2, 84);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3728, 'Clarés de Ribota', 50, 5, 84);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3729, 'Viveros', 2, 1, 85);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3730, 'Llíber', 3, 7, 85);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3731, 'Somontín', 4, 2, 85);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3732, 'Gil García', 5, 5, 85);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3733, 'Monesterio', 6, 8, 85);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3734, 'Font-rubí', 8, 0, 85);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3735, 'Castrillo de la Vega', 9, 3, 85);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3736, 'Gordo, El', 10, 7, 85);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3737, 'Oropesa del Mar/Orpesa', 12, 9, 85);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3738, 'Torrenueva', 13, 5, 85);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3739, 'Touro', 15, 3, 85);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3740, 'Frontera, La', 16, 6, 85);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3741, 'Jafre', 17, 2, 85);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3742, 'Gor', 18, 8, 85);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3743, 'Castelflorite', 22, 7, 85);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3744, 'Torreblascopedro', 23, 3, 85);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3745, 'Estaràs', 25, 1, 85);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3746, 'Miraflores de la Sierra', 28, 6, 85);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3747, 'Salares', 29, 9, 85);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3748, 'Etxauri', 31, 0, 85);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3749, 'Verín', 32, 5, 85);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3750, 'Carbajosa de la Sagrada', 37, 8, 85);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3751, 'Suances', 39, 7, 85);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3752, 'Salteras', 41, 8, 85);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3753, 'Fuentearmegil', 42, 3, 85);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3754, 'Molar, El', 43, 9, 85);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3755, 'Cosa', 44, 4, 85);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3756, 'Lominchar', 45, 7, 85);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3757, 'Carlet', 46, 0, 85);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3758, 'Medina del Campo', 47, 6, 85);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3759, 'Sopelana', 48, 2, 85);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3760, 'Galende', 49, 5, 85);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3761, 'Codo', 50, 8, 85);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3762, 'Yeste', 2, 4, 86);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3763, 'Millena', 3, 0, 86);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3764, 'Sorbas', 4, 5, 86);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3765, 'Gimialcón', 5, 8, 86);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3766, 'Montemolín', 6, 1, 86);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3767, 'Franqueses del Vallès, Les', 8, 3, 86);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3768, 'Castrillo del Val', 9, 6, 86);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3769, 'Granja, La', 10, 0, 86);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3770, 'Valdemanco del Esteras', 13, 8, 86);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3771, 'Trazo', 15, 6, 86);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3772, 'Fuente de Pedro Naharro', 16, 9, 86);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3773, 'Jonquera, La', 17, 5, 86);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3774, 'Gorafe', 18, 1, 86);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3775, 'Cifuentes', 19, 4, 86);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3776, 'Castiello de Jaca', 22, 0, 86);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3777, 'Torre del Campo', 23, 6, 86);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3778, 'Joarilla de las Matas', 24, 1, 86);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3779, 'Esterri d''Àneu', 25, 4, 86);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3780, 'Ledesma de la Cogolla', 26, 7, 86);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3781, 'Molar, El', 28, 9, 86);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3782, 'Sayalonga', 29, 2, 86);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3783, 'Egüés', 31, 3, 86);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3784, 'Viana do Bolo', 32, 8, 86);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3785, 'Hontoria de Cerrato', 34, 9, 86);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3786, 'Carpio de Azaba', 37, 1, 86);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3787, 'Tojos, Los', 39, 0, 86);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3788, 'Fuentepelayo', 40, 4, 86);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3789, 'San Juan de Aznalfarache', 41, 1, 86);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3790, 'Fuentecambrón', 42, 6, 86);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3791, 'Montblanc', 43, 2, 86);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3792, 'Cretas', 44, 7, 86);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3793, 'Lucillos', 45, 0, 86);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3794, 'Carrícola', 46, 3, 86);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3795, 'Medina de Rioseco', 47, 9, 86);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3796, 'Sopuerta', 48, 5, 86);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3797, 'Gallegos del Pan', 49, 8, 86);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3798, 'Codos', 50, 1, 86);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3799, 'Suflí', 4, 1, 87);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3800, 'Gotarrendura', 5, 4, 87);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3801, 'Monterrubio de la Serena', 6, 7, 87);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3802, 'Gallifa', 8, 9, 87);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3803, 'Guadalupe', 10, 6, 87);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3804, 'Palanques', 12, 8, 87);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3805, 'Valdepeñas', 13, 4, 87);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3806, 'Valdoviño', 15, 2, 87);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3807, 'Fuentelespino de Haro', 16, 5, 87);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3808, 'Juià', 17, 1, 87);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3809, 'Granada', 18, 7, 87);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3810, 'Cincovillas', 19, 0, 87);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3811, 'Castigaleu', 22, 6, 87);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3812, 'Torredonjimeno', 23, 2, 87);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3813, 'Laguna Dalga', 24, 7, 87);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3814, 'Esterri de Cardós', 25, 0, 87);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3815, 'Leiva', 26, 3, 87);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3816, 'Molinos, Los', 28, 5, 87);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3817, 'Sedella', 29, 8, 87);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3818, 'Elgorriaga', 31, 9, 87);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3819, 'Vilamarín', 32, 4, 87);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3820, 'Hornillos de Cerrato', 34, 5, 87);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3821, 'Carrascal de Barregas', 37, 7, 87);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3822, 'Torrelavega', 39, 6, 87);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3823, 'Fuentepiñel', 40, 0, 87);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3824, 'Sanlúcar la Mayor', 41, 7, 87);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3825, 'Fuentecantos', 42, 2, 87);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3826, 'Crivillén', 44, 3, 87);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3827, 'Madridejos', 45, 6, 87);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3828, 'Casas Altas', 46, 9, 87);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3829, 'Megeces', 47, 5, 87);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3830, 'Trucios-Turtzioz', 48, 1, 87);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3831, 'Gallegos del Río', 49, 4, 87);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3832, 'Contamina', 50, 7, 87);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3833, 'Monforte del Cid', 3, 2, 88);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3834, 'Tabernas', 4, 7, 88);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3835, 'Grandes y San Martín', 5, 0, 88);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3836, 'Montijo', 6, 3, 88);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3837, 'Garriga, La', 8, 5, 88);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3838, 'Castrillo de Riopisuerga', 9, 8, 88);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3839, 'Guijo de Coria', 10, 2, 88);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3840, 'Pavías', 12, 4, 88);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3841, 'Valenzuela de Calatrava', 13, 0, 88);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3842, 'Val do Dubra', 15, 8, 88);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3843, 'Fuentelespino de Moya', 16, 1, 88);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3844, 'Lladó', 17, 7, 88);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3845, 'Guadahortuna', 18, 3, 88);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3846, 'Ciruelas', 19, 6, 88);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3847, 'Castillazuelo', 22, 2, 88);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3848, 'Torreperogil', 23, 8, 88);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3849, 'Laguna de Negrillos', 24, 3, 88);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3850, 'Estamariu', 25, 6, 88);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3851, 'Leza de Río Leza', 26, 9, 88);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3852, 'Montejo de la Sierra', 28, 1, 88);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3853, 'Sierra de Yeguas', 29, 4, 88);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3854, 'Noáin (Valle de Elorz)/Noain (Elortzibar)', 31, 5, 88);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3855, 'Vilamartín de Valdeorras', 32, 0, 88);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3856, 'Husillos', 34, 1, 88);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3857, 'Carrascal del Obispo', 37, 3, 88);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3858, 'Tresviso', 39, 2, 88);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3859, 'Fuenterrebollo', 40, 6, 88);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3860, 'San Nicolás del Puerto', 41, 3, 88);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3861, 'Fuentelmonge', 42, 8, 88);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3862, 'Montbrió del Camp', 43, 4, 88);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3863, 'Cuba, La', 44, 9, 88);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3864, 'Magán', 45, 2, 88);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3865, 'Casas Bajas', 46, 5, 88);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3866, 'Melgar de Abajo', 47, 1, 88);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3867, 'Ubide', 48, 7, 88);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3868, 'Gamones', 49, 0, 88);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3869, 'Cosuenda', 50, 3, 88);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3870, 'Monóvar/Monòver', 3, 5, 89);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3871, 'Taberno', 4, 0, 89);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3872, 'Guisando', 5, 3, 89);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3873, 'Morera, La', 6, 6, 89);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3874, 'Gavà', 8, 8, 89);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3875, 'Guijo de Galisteo', 10, 5, 89);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3876, 'Peníscola/Peñíscola', 12, 7, 89);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3877, 'Villahermosa', 13, 3, 89);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3878, 'Vedra', 15, 1, 89);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3879, 'Fuentes', 16, 4, 89);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3880, 'Llagostera', 17, 0, 89);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3881, 'Guadix', 18, 6, 89);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3882, 'Ciruelos del Pinar', 19, 9, 89);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3883, 'Castillonroy', 22, 5, 89);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3884, 'León', 24, 6, 89);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3885, 'Farrera', 25, 9, 89);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3886, 'Logroño', 26, 2, 89);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3887, 'Moraleja de Enmedio', 28, 4, 89);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3888, 'Teba', 29, 7, 89);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3889, 'Enériz/Eneritz', 31, 8, 89);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3890, 'Vilar de Barrio', 32, 3, 89);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3891, 'Itero de la Vega', 34, 4, 89);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3892, 'Casafranca', 37, 6, 89);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3893, 'Tudanca', 39, 5, 89);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3894, 'Fuentesaúco de Fuentidueña', 40, 9, 89);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3895, 'Santiponce', 41, 6, 89);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3896, 'Fuentelsaz de Soria', 42, 1, 89);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3897, 'Montferri', 43, 7, 89);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3898, 'Cubla', 44, 2, 89);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3899, 'Malpica de Tajo', 45, 5, 89);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3900, 'Casinos', 46, 8, 89);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3901, 'Melgar de Arriba', 47, 4, 89);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3902, 'Urduliz', 48, 0, 89);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3903, 'Cuarte de Huerva', 50, 6, 89);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3904, 'Mutxamel', 3, 9, 90);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3905, 'Tahal', 4, 4, 90);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3906, 'Gutierre-Muñoz', 5, 7, 90);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3907, 'Nava de Santiago, La', 6, 0, 90);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3908, 'Gaià', 8, 2, 90);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3909, 'Castrillo Matajudíos', 9, 5, 90);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3910, 'Guijo de Granadilla', 10, 9, 90);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3911, 'Pina de Montalgrao', 12, 1, 90);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3912, 'Villamanrique', 13, 7, 90);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3913, 'Vilasantar', 15, 5, 90);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3914, 'Llambilles', 17, 4, 90);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3915, 'Cobeta', 19, 3, 90);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3916, 'Colungo', 22, 9, 90);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3917, 'Torres', 23, 5, 90);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3918, 'Lucillo', 24, 0, 90);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3919, 'Moralzarzal', 28, 8, 90);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3920, 'Tolox', 29, 1, 90);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3921, 'Eratsun', 31, 2, 90);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3922, 'Vilar de Santos', 32, 7, 90);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3923, 'Casas del Conde, Las', 37, 0, 90);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3924, 'Udías', 39, 9, 90);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3925, 'Saucejo, El', 41, 0, 90);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3926, 'Fuentepinilla', 42, 5, 90);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3927, 'Montmell, El', 43, 1, 90);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3928, 'Cucalón', 44, 6, 90);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3929, 'Manzaneque', 45, 9, 90);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3930, 'Castelló de Rugat', 46, 2, 90);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3931, 'Mojados', 47, 8, 90);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3932, 'Balmaseda', 48, 4, 90);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3933, 'Gema', 49, 7, 90);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3934, 'Cubel', 50, 0, 90);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3935, 'Murla', 3, 6, 91);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3936, 'Terque', 4, 1, 91);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3937, 'Navalvillar de Pela', 6, 7, 91);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3938, 'Gelida', 8, 9, 91);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3939, 'Castrojeriz', 9, 2, 91);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3940, 'Guijo de Santa Bárbara', 10, 6, 91);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3941, 'Portell de Morella', 12, 8, 91);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3942, 'Villamayor de Calatrava', 13, 4, 91);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3943, 'Vilarmaior', 15, 2, 91);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3944, 'Fuertescusa', 16, 5, 91);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3945, 'Llanars', 17, 1, 91);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3946, 'Cogollor', 19, 0, 91);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3947, 'Torres de Albánchez', 23, 2, 91);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3948, 'Luyego', 24, 7, 91);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3949, 'Lumbreras', 26, 3, 91);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3950, 'Morata de Tajuña', 28, 5, 91);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3951, 'Torrox', 29, 8, 91);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3952, 'Ergoiena', 31, 9, 91);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3953, 'Vilardevós', 32, 4, 91);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3954, 'Lagartos', 34, 5, 91);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3955, 'Casillas de Flores', 37, 7, 91);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3956, 'Valdáliga', 39, 6, 91);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3957, 'Fuentesoto', 40, 0, 91);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3958, 'Sevilla', 41, 7, 91);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3959, 'Mont-ral', 43, 8, 91);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3960, 'Maqueda', 45, 6, 91);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3961, 'Castellonet de la Conquesta', 46, 9, 91);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3962, 'Monasterio de Vega', 47, 5, 91);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3963, 'Atxondo', 48, 1, 91);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3964, 'Granja de Moreruela', 49, 4, 91);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3965, 'Cuerlas, Las', 50, 7, 91);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3966, 'Muro de Alcoy', 3, 1, 92);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3967, 'Tíjola', 4, 6, 92);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3968, 'Hernansancho', 5, 9, 92);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3969, 'Nogales', 6, 2, 92);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3970, 'Gironella', 8, 4, 92);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3971, 'Herguijuela', 10, 1, 92);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3972, 'Puebla de Arenoso', 12, 3, 92);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3973, 'Villanueva de la Fuente', 13, 9, 92);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3974, 'Vimianzo', 15, 7, 92);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3975, 'Gabaldón', 16, 0, 92);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3976, 'Llançà', 17, 6, 92);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3977, 'Cogolludo', 19, 5, 92);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3978, 'Úbeda', 23, 7, 92);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3979, 'Llamas de la Ribera', 24, 2, 92);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3980, 'Floresta, La', 25, 5, 92);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3981, 'Manjarrés', 26, 8, 92);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3982, 'Móstoles', 28, 0, 92);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3983, 'Totalán', 29, 3, 92);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3984, 'Erro', 31, 4, 92);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3985, 'Vilariño de Conso', 32, 9, 92);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3986, 'Lantadilla', 34, 0, 92);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3987, 'Castellanos de Moriscos', 37, 2, 92);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3988, 'Valdeolea', 39, 1, 92);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3989, 'Fuentidueña', 40, 5, 92);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3990, 'Tocina', 41, 2, 92);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3991, 'Fuentes de Magaña', 42, 7, 92);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3992, 'Mont-roig del Camp', 43, 3, 92);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3993, 'Cuervo, El', 44, 8, 92);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3994, 'Marjaliza', 45, 1, 92);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3995, 'Castielfabib', 46, 4, 92);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3996, 'Montealegre de Campos', 47, 0, 92);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3997, 'Bedia', 48, 6, 92);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3998, 'Granucillo', 49, 9, 92);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (3999, 'Chiprana', 50, 2, 92);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4000, 'Novelda', 3, 7, 93);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4001, 'Turre', 4, 2, 93);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4002, 'Herradón de Pinares', 5, 5, 93);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4003, 'Oliva de la Frontera', 6, 8, 93);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4004, 'Gisclareny', 8, 0, 93);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4005, 'Cayuela', 9, 3, 93);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4006, 'Hernán-Pérez', 10, 7, 93);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4007, 'Pobla de Benifassà, la', 12, 9, 93);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4008, 'Villanueva de los Infantes', 13, 5, 93);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4009, 'Zas', 15, 3, 93);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4010, 'Garaballa', 16, 6, 93);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4011, 'Llers', 17, 2, 93);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4012, 'Gualchos', 18, 8, 93);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4013, 'Valdepeñas de Jaén', 23, 3, 93);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4014, 'Magaz de Cepeda', 24, 8, 93);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4015, 'Fondarella', 25, 1, 93);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4016, 'Mansilla de la Sierra', 26, 4, 93);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4017, 'Navacerrada', 28, 6, 93);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4018, 'Valle de Abdalajís', 29, 9, 93);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4019, 'Ezcároz/Ezkaroze', 31, 0, 93);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4020, 'Vid de Ojeda, La', 34, 6, 93);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4021, 'Valdeprado del Río', 39, 7, 93);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4022, 'Gallegos', 40, 1, 93);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4023, 'Tomares', 41, 8, 93);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4024, 'Fuentestrún', 42, 3, 93);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4025, 'Móra d''Ebre', 43, 9, 93);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4026, 'Cuevas de Almudén', 44, 4, 93);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4027, 'Marrupe', 45, 7, 93);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4028, 'Catadau', 46, 0, 93);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4029, 'Montemayor de Pililla', 47, 6, 93);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4030, 'Areatza', 48, 2, 93);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4031, 'Guarrate', 49, 5, 93);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4032, 'Chodes', 50, 8, 93);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4033, 'Nucia, la', 3, 2, 94);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4034, 'Turrillas', 4, 7, 94);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4035, 'Herreros de Suso', 5, 0, 94);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4036, 'Oliva de Mérida', 6, 3, 94);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4037, 'Granada, La', 8, 5, 94);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4038, 'Cebrecos', 9, 8, 94);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4039, 'Herrera de Alcántara', 10, 2, 94);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4040, 'Pobla Tornesa, la', 12, 4, 94);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4041, 'Villanueva de San Carlos', 13, 0, 94);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4042, 'Gascueña', 16, 1, 94);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4043, 'Llívia', 17, 7, 94);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4044, 'Güejar Sierra', 18, 3, 94);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4045, 'Chalamera', 22, 2, 94);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4046, 'Vilches', 23, 8, 94);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4047, 'Mansilla de las Mulas', 24, 3, 94);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4048, 'Foradada', 25, 6, 94);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4049, 'Manzanares de Rioja', 26, 9, 94);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4050, 'Navalafuente', 28, 1, 94);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4051, 'Vélez-Málaga', 29, 4, 94);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4052, 'Eslava', 31, 5, 94);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4053, 'Ledigos', 34, 1, 94);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4054, 'Valderredible', 39, 2, 94);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4055, 'Garcillán', 40, 6, 94);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4056, 'Umbrete', 41, 3, 94);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4057, 'Garray', 42, 8, 94);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4058, 'Móra la Nova', 43, 4, 94);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4059, 'Cuevas Labradas', 44, 9, 94);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4060, 'Mascaraque', 45, 2, 94);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4061, 'Catarroja', 46, 5, 94);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4062, 'Moral de la Reina', 47, 1, 94);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4063, 'Igorre', 48, 7, 94);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4064, 'Hermisende', 49, 0, 94);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4065, 'Daroca', 50, 3, 94);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4066, 'Ondara', 3, 5, 95);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4067, 'Uleila del Campo', 4, 0, 95);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4068, 'Higuera de las Dueñas', 5, 3, 95);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4069, 'Olivenza', 6, 6, 95);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4070, 'Granera', 8, 8, 95);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4071, 'Celada del Camino', 9, 1, 95);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4072, 'Herreruela', 10, 5, 95);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4073, 'Ribesalbes', 12, 7, 95);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4074, 'Villar del Pozo', 13, 3, 95);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4075, 'Graja de Campalbo', 16, 4, 95);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4076, 'Lloret de Mar', 17, 0, 95);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4077, 'Güevéjar', 18, 6, 95);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4078, 'Condemios de Abajo', 19, 9, 95);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4079, 'Chía', 22, 5, 95);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4080, 'Villacarrillo', 23, 1, 95);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4081, 'Mansilla Mayor', 24, 6, 95);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4082, 'Matute', 26, 2, 95);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4083, 'Navalagamella', 28, 4, 95);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4084, 'Villanueva de Algaidas', 29, 7, 95);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4085, 'Esparza de Salazar/Espartza Zaraitzu', 31, 8, 95);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4086, 'Val de San Vicente', 39, 5, 95);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4087, 'Gomezserracín', 40, 9, 95);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4088, 'Utrera', 41, 6, 95);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4089, 'Golmayo', 42, 1, 95);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4090, 'Morell, El', 43, 7, 95);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4091, 'Mata, La', 45, 5, 95);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4092, 'Caudete de las Fuentes', 46, 8, 95);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4093, 'Moraleja de las Panaderas', 47, 4, 95);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4094, 'Zaldibar', 48, 0, 95);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4095, 'Hiniesta, La', 49, 3, 95);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4096, 'Ejea de los Caballeros', 50, 6, 95);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4097, 'Onil', 3, 8, 96);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4098, 'Urrácal', 4, 3, 96);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4099, 'Hija de Dios, La', 5, 6, 96);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4100, 'Orellana de la Sierra', 6, 9, 96);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4101, 'Granollers', 8, 1, 96);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4102, 'Hervás', 10, 8, 96);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4103, 'Rossell', 12, 0, 96);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4104, 'Villarrubia de los Ojos', 13, 6, 96);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4105, 'Graja de Iniesta', 16, 7, 96);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4106, 'Llosses, Les', 17, 3, 96);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4107, 'Huélago', 18, 9, 96);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4108, 'Condemios de Arriba', 19, 2, 96);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4109, 'Chimillas', 22, 8, 96);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4110, 'Villanueva de la Reina', 23, 4, 96);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4111, 'Maraña', 24, 9, 96);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4112, 'Fuliola, La', 25, 2, 96);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4113, 'Medrano', 26, 5, 96);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4114, 'Navalcarnero', 28, 7, 96);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4115, 'Villanueva del Rosario', 29, 0, 96);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4116, 'Espronceda', 31, 1, 96);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4117, 'Lomas', 34, 7, 96);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4118, 'Castillejo de Martín Viejo', 37, 9, 96);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4119, 'Vega de Liébana', 39, 8, 96);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4120, 'Valencina de la Concepción', 41, 9, 96);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4121, 'Gómara', 42, 4, 96);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4122, 'Morera de Montsant, La', 43, 0, 96);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4123, 'Ejulve', 44, 5, 96);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4124, 'Mazarambroz', 45, 8, 96);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4125, 'Cerdà', 46, 1, 96);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4126, 'Morales de Campos', 47, 7, 96);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4127, 'Zalla', 48, 3, 96);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4128, 'Jambrina', 49, 6, 96);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4129, 'Embid de Ariza', 50, 9, 96);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4130, 'Orba', 3, 4, 97);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4131, 'Velefique', 4, 9, 97);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4132, 'Horcajada, La', 5, 2, 97);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4133, 'Orellana la Vieja', 6, 5, 97);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4134, 'Gualba', 8, 7, 97);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4135, 'Higuera', 10, 4, 97);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4136, 'Sacañet', 12, 6, 97);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4137, 'Villarta de San Juan', 13, 2, 97);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4138, 'Henarejos', 16, 3, 97);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4139, 'Madremanya', 17, 9, 97);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4140, 'Huéneja', 18, 5, 97);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4141, 'Congostrina', 19, 8, 97);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4142, 'Villanueva del Arzobispo', 23, 0, 97);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4143, 'Matadeón de los Oteros', 24, 5, 97);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4144, 'Fulleda', 25, 8, 97);\n";
    public static String INSERTS_DB_7 = "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4145, 'Navarredonda y San Mamés', 28, 3, 97);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4146, 'Villanueva del Trabuco', 29, 6, 97);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4147, 'Estella-Lizarra', 31, 7, 97);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4148, 'Castraz', 37, 5, 97);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4149, 'Vega de Pas', 39, 4, 97);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4150, 'Grajera', 40, 8, 97);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4151, 'Villamanrique de la Condesa', 41, 5, 97);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4152, 'Gormaz', 42, 0, 97);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4153, 'Nou de Gaià, La', 43, 6, 97);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4154, 'Escorihuela', 44, 1, 97);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4155, 'Mejorada', 45, 4, 97);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4156, 'Cofrentes', 46, 7, 97);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4157, 'Mota del Marqués', 47, 3, 97);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4158, 'Zaratamo', 48, 9, 97);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4159, 'Justel', 49, 2, 97);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4160, 'Orxeta', 3, 0, 98);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4161, 'Vélez-Blanco', 4, 5, 98);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4162, 'Palomas', 6, 1, 98);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4163, 'Sant Salvador de Guardiola', 8, 3, 98);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4164, 'Cerezo de Río Tirón', 9, 6, 98);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4165, 'Hinojal', 10, 0, 98);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4166, 'Salzadella, la', 12, 2, 98);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4167, 'Viso del Marqués', 13, 8, 98);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4168, 'Herrumblar, El', 16, 9, 98);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4169, 'Maià de Montcal', 17, 5, 98);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4170, 'Huéscar', 18, 1, 98);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4171, 'Copernal', 19, 4, 98);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4172, 'Villardompardo', 23, 6, 98);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4173, 'Matallana de Torío', 24, 1, 98);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4174, 'Gavet de la Conca', 25, 4, 98);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4175, 'Munilla', 26, 7, 98);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4176, 'Villanueva de Tapia', 29, 2, 98);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4177, 'Esteribar', 31, 3, 98);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4178, 'Magaz de Pisuerga', 34, 9, 98);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4179, 'Cepeda', 37, 1, 98);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4180, 'Villacarriedo', 39, 0, 98);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4181, 'Villanueva del Ariscal', 41, 1, 98);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4182, 'Herrera de Soria', 42, 6, 98);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4183, 'Nulles', 43, 2, 98);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4184, 'Menasalbas', 45, 0, 98);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4185, 'Corbera', 46, 3, 98);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4186, 'Mucientes', 47, 9, 98);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4187, 'Losacino', 49, 8, 98);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4188, 'Encinacorba', 50, 1, 98);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4189, 'Orihuela', 3, 3, 99);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4190, 'Vélez-Rubio', 4, 8, 99);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4191, 'Horcajo de las Torres', 5, 1, 99);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4192, 'Parra, La', 6, 4, 99);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4193, 'Guardiola de Berguedà', 8, 6, 99);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4194, 'Holguera', 10, 3, 99);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4195, 'Sant Jordi/San Jorge', 12, 5, 99);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4196, 'Hinojosa, La', 16, 2, 99);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4197, 'Meranges', 17, 8, 99);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4198, 'Huétor de Santillán', 18, 4, 99);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4199, 'Corduente', 19, 7, 99);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4200, 'Esplús', 22, 3, 99);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4201, 'Villares, Los', 23, 9, 99);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4202, 'Matanza', 24, 4, 99);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4203, 'Golmés', 25, 7, 99);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4204, 'Murillo de Río Leza', 26, 0, 99);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4205, 'Navas del Rey', 28, 2, 99);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4206, 'Viñuela', 29, 5, 99);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4207, 'Etayo', 31, 6, 99);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4208, 'Manquillos', 34, 2, 99);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4209, 'Cereceda de la Sierra', 37, 4, 99);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4210, 'Villaescusa', 39, 3, 99);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4211, 'Honrubia de la Cuesta', 40, 7, 99);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4212, 'Villanueva del Río y Minas', 41, 4, 99);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4213, 'Palma d''Ebre, La', 43, 5, 99);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4214, 'Escucha', 44, 0, 99);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4215, 'Méntrida', 45, 3, 99);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4216, 'Cortes de Pallás', 46, 6, 99);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4217, 'Mudarra, La', 47, 2, 99);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4218, 'Losacio', 49, 1, 99);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4219, 'Épila', 50, 4, 99);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4220, 'Parcent', 3, 7, 100);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4221, 'Vera', 4, 2, 100);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4222, 'Hornillo, El', 5, 5, 100);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4223, 'Peñalsordo', 6, 8, 100);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4224, 'Gurb', 8, 0, 100);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4225, 'Cerratón de Juarros', 9, 3, 100);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4226, 'Hoyos', 10, 7, 100);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4227, 'Sant Mateu', 12, 9, 100);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4228, 'Hinojosos, Los', 16, 6, 100);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4229, 'Masarac', 17, 2, 100);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4230, 'Huétor Tájar', 18, 8, 100);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4231, 'Molinaseca', 24, 8, 100);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4232, 'Gósol', 25, 1, 100);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4233, 'Muro de Aguas', 26, 4, 100);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4234, 'Nuevo Baztán', 28, 6, 100);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4235, 'Yunquera', 29, 9, 100);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4236, 'Eulate', 31, 0, 100);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4237, 'Mantinos', 34, 6, 100);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4238, 'Cerezal de Peñahorcada', 37, 8, 100);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4239, 'Villafufre', 39, 7, 100);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4240, 'Hontalbilla', 40, 1, 100);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4241, 'Villanueva de San Juan', 41, 8, 100);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4242, 'Hinojosa del Campo', 42, 3, 100);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4243, 'Pallaresos, Els', 43, 9, 100);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4244, 'Estercuel', 44, 4, 100);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4245, 'Mesegar de Tajo', 45, 7, 100);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4246, 'Cotes', 46, 0, 100);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4247, 'Muriel', 47, 6, 100);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4248, 'Lubián', 49, 5, 100);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4249, 'Erla', 50, 8, 100);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4250, 'Pedreguer', 3, 4, 101);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4251, 'Viator', 4, 9, 101);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4252, 'Hoyocasero', 5, 2, 101);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4253, 'Peraleda del Zaucejo', 6, 5, 101);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4254, 'Hospitalet de Llobregat, L''', 8, 7, 101);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4255, 'Ciadoncha', 9, 0, 101);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4256, 'Huélaga', 10, 4, 101);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4257, 'San Rafael del Río', 12, 6, 101);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4258, 'Hito, El', 16, 3, 101);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4259, 'Massanes', 17, 9, 101);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4260, 'Huétor Vega', 18, 5, 101);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4261, 'Villarrodrigo', 23, 0, 101);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4262, 'Murias de Paredes', 24, 5, 101);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4263, 'Granadella, La', 25, 8, 101);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4264, 'Muro en Cameros', 26, 1, 101);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4265, 'Olmeda de las Fuentes', 28, 3, 101);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4266, 'Ezcabarte', 31, 7, 101);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4267, 'Marcilla de Campos', 34, 3, 101);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4268, 'Cerralbo', 37, 5, 101);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4269, 'Valle de Villaverde', 39, 4, 101);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4270, 'Hontanares de Eresma', 40, 8, 101);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4271, 'Villaverde del Río', 41, 5, 101);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4272, 'Passanant i Belltall', 43, 6, 101);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4273, 'Ferreruela de Huerva', 44, 1, 101);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4274, 'Miguel Esteban', 45, 4, 101);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4275, 'Quart de les Valls', 46, 7, 101);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4276, 'Nava del Rey', 47, 3, 101);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4277, 'Luelmo', 49, 2, 101);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4278, 'Escatrón', 50, 5, 101);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4279, 'Pego', 3, 9, 102);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4280, 'Vícar', 4, 4, 102);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4281, 'Hoyo de Pinares, El', 5, 7, 102);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4282, 'Puebla de Alcocer', 6, 0, 102);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4283, 'Igualada', 8, 2, 102);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4284, 'Cillaperlata', 9, 5, 102);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4285, 'Ibahernando', 10, 9, 102);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4286, 'Santa Magdalena de Pulpis', 12, 1, 102);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4287, 'Honrubia', 16, 8, 102);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4288, 'Maçanet de Cabrenys', 17, 4, 102);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4289, 'Illora', 18, 0, 102);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4290, 'Cubillo de Uceda, El', 19, 3, 102);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4291, 'Estada', 22, 9, 102);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4292, 'Noceda del Bierzo', 24, 0, 102);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4293, 'Granja d''Escarp, La', 25, 3, 102);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4294, 'Nájera', 26, 6, 102);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4295, 'Orusco de Tajuña', 28, 8, 102);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4296, 'Ezkurra', 31, 2, 102);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4297, 'Mazariegos', 34, 8, 102);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4298, 'Cerro, El', 37, 0, 102);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4299, 'Voto', 39, 9, 102);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4300, 'Viso del Alcor, El', 41, 0, 102);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4301, 'Paüls', 43, 1, 102);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4302, 'Fonfría', 44, 6, 102);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4303, 'Mocejón', 45, 9, 102);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4304, 'Quart de Poblet', 46, 2, 102);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4305, 'Nueva Villa de las Torres', 47, 8, 102);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4306, 'Maderal, El', 49, 7, 102);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4307, 'Fabara', 50, 0, 102);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4308, 'Penàguila', 3, 5, 103);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4309, 'Zurgena', 4, 0, 103);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4310, 'Hoyorredondo', 5, 3, 103);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4311, 'Puebla de la Calzada', 6, 6, 103);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4312, 'Jorba', 8, 8, 103);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4313, 'Cilleruelo de Abajo', 9, 1, 103);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4314, 'Jaraicejo', 10, 5, 103);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4315, 'Sarratella', 12, 7, 103);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4316, 'Hontanaya', 16, 4, 103);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4317, 'Maçanet de la Selva', 17, 0, 103);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4318, 'Itrabo', 18, 6, 103);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4319, 'Checa', 19, 9, 103);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4320, 'Estadilla', 22, 5, 103);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4321, 'Oencia', 24, 6, 103);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4322, 'Granyanella', 25, 9, 103);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4323, 'Nalda', 26, 2, 103);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4324, 'Ezprogui', 31, 8, 103);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4325, 'Mazuecos de Valdeginate', 34, 4, 103);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4326, 'Cespedosa de Tormes', 37, 6, 103);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4327, 'Huertos, Los', 40, 9, 103);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4328, 'Langa de Duero', 42, 1, 103);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4329, 'Perafort', 43, 7, 103);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4330, 'Formiche Alto', 44, 2, 103);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4331, 'Mohedas de la Jara', 45, 5, 103);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4332, 'Quartell', 46, 8, 103);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4333, 'Olivares de Duero', 47, 4, 103);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4334, 'Madridanos', 49, 3, 103);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4335, 'Petrer', 3, 0, 104);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4336, 'Hoyos del Collado', 5, 8, 104);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4337, 'Puebla de la Reina', 6, 1, 104);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4338, 'Llacuna, La', 8, 3, 104);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4339, 'Cilleruelo de Arriba', 9, 6, 104);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4340, 'Jaraíz de la Vera', 10, 0, 104);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4341, 'Segorbe', 12, 2, 104);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4342, 'Hontecillas', 16, 9, 104);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4343, 'Chequilla', 19, 4, 104);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4344, 'Omañas, Las', 24, 1, 104);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4345, 'Granyena de Segarra', 25, 4, 104);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4346, 'Navajún', 26, 7, 104);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4347, 'Paracuellos de Jarama', 28, 9, 104);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4348, 'Falces', 31, 3, 104);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4349, 'Melgar de Yuso', 34, 9, 104);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4350, 'Cilleros de la Bastida', 37, 1, 104);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4351, 'Ituero y Lama', 40, 4, 104);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4352, 'Perelló, El', 43, 2, 104);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4353, 'Montearagón', 45, 0, 104);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4354, 'Quatretonda', 46, 3, 104);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4355, 'Olmedo', 47, 9, 104);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4356, 'Mahide', 49, 8, 104);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4357, 'Farlete', 50, 1, 104);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4358, 'Pinós, el/Pinoso', 3, 3, 105);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4359, 'Hoyos del Espino', 5, 1, 105);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4360, 'Puebla del Maestre', 6, 4, 105);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4361, 'Llagosta, La', 8, 6, 105);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4362, 'Ciruelos de Cervera', 9, 9, 105);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4363, 'Jarandilla de la Vera', 10, 3, 105);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4364, 'Sierra Engarcerán', 12, 5, 105);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4365, 'Mieres', 17, 8, 105);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4366, 'Iznalloz', 18, 4, 105);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4367, 'Chiloeches', 19, 7, 105);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4368, 'Estopiñán del Castillo', 22, 3, 105);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4369, 'Onzonilla', 24, 4, 105);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4370, 'Granyena de les Garrigues', 25, 7, 105);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4371, 'Navarrete', 26, 0, 105);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4372, 'Fitero', 31, 6, 105);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4373, 'Juarros de Riomoros', 40, 7, 105);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4374, 'Liceras', 42, 9, 105);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4375, 'Piles, Les', 43, 5, 105);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4376, 'Fórnoles', 44, 0, 105);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4377, 'Montesclaros', 45, 3, 105);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4378, 'Cullera', 46, 6, 105);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4379, 'Olmos de Esgueva', 47, 2, 105);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4380, 'Maire de Castroponce', 49, 1, 105);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4381, 'Fayón', 50, 4, 105);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4382, 'Planes', 3, 6, 106);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4383, 'Hoyos de Miguel Muñoz', 5, 4, 106);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4384, 'Puebla del Prior', 6, 7, 106);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4385, 'Llinars del Vallès', 8, 9, 106);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4386, 'Jarilla', 10, 6, 106);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4387, 'Soneja', 12, 8, 106);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4388, 'Horcajo de Santiago', 16, 5, 106);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4389, 'Mollet de Peralada', 17, 1, 106);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4390, 'Chillarón del Rey', 19, 0, 106);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4391, 'Fago', 22, 6, 106);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4392, 'Oseja de Sajambre', 24, 7, 106);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4393, 'Nestares', 26, 3, 106);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4394, 'Parla', 28, 5, 106);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4395, 'Fontellas', 31, 9, 106);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4396, 'Meneses de Campos', 34, 5, 106);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4397, 'Cipérez', 37, 7, 106);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4398, 'Juarros de Voltoya', 40, 0, 106);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4399, 'Losilla, La', 42, 2, 106);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4400, 'Pinell de Brai, El', 43, 8, 106);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4401, 'Fortanete', 44, 3, 106);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4402, 'Mora', 45, 6, 106);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4403, 'Chelva', 46, 9, 106);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4404, 'Olmos de Peñafiel', 47, 5, 106);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4405, 'Fayos, Los', 50, 7, 106);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4406, 'Polop', 3, 2, 107);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4407, 'Hurtumpascual', 5, 0, 107);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4408, 'Puebla de Obando', 6, 3, 107);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4409, 'Lliçà d''Amunt', 8, 5, 107);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4410, 'Jerte', 10, 2, 107);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4411, 'Sot de Ferrer', 12, 4, 107);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4412, 'Huélamo', 16, 1, 107);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4413, 'Molló', 17, 7, 107);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4414, 'Jayena', 18, 3, 107);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4415, 'Driebes', 19, 6, 107);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4416, 'Fanlo', 22, 2, 107);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4417, 'Pajares de los Oteros', 24, 3, 107);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4418, 'Nieva de Cameros', 26, 9, 107);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4419, 'Patones', 28, 1, 107);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4420, 'Funes', 31, 5, 107);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4421, 'Micieces de Ojeda', 34, 1, 107);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4422, 'Ciudad Rodrigo', 37, 3, 107);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4423, 'Labajos', 40, 6, 107);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4424, 'Magaña', 42, 8, 107);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4425, 'Pira', 43, 4, 107);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4426, 'Foz-Calanda', 44, 9, 107);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4427, 'Nambroca', 45, 2, 107);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4428, 'Chella', 46, 5, 107);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4429, 'Malva', 49, 0, 107);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4430, 'Figueruelas', 50, 3, 107);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4431, 'Junciana', 5, 6, 108);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4432, 'Puebla de Sancho Pérez', 6, 9, 108);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4433, 'Lliçà de Vall', 8, 1, 108);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4434, 'Cogollos', 9, 4, 108);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4435, 'Ladrillar', 10, 8, 108);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4436, 'Sueras/Suera', 12, 0, 108);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4437, 'Huelves', 16, 7, 108);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4438, 'Jerez del Marquesado', 18, 9, 108);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4439, 'Durón', 19, 2, 108);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4440, 'Palacios de la Valduerna', 24, 9, 108);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4441, 'Ocón', 26, 5, 108);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4442, 'Pedrezuela', 28, 7, 108);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4443, 'Fustiñana', 31, 1, 108);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4444, 'Monzón de Campos', 34, 7, 108);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4445, 'Coca de Alba', 37, 9, 108);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4446, 'Laguna de Contreras', 40, 2, 108);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4447, 'Maján', 42, 4, 108);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4448, 'Pla de Santa Maria, El', 43, 0, 108);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4449, 'Fresneda, La', 44, 5, 108);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4450, 'Nava de Ricomalillo, La', 45, 8, 108);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4451, 'Chera', 46, 1, 108);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4452, 'Manganeses de la Lampreana', 49, 6, 108);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4453, 'Fombuena', 50, 9, 108);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4454, 'Rafal', 3, 1, 109);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4455, 'Langa', 5, 9, 109);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4456, 'Quintana de la Serena', 6, 2, 109);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4457, 'Lluçà', 8, 4, 109);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4458, 'Condado de Treviño', 9, 7, 109);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4459, 'Logrosán', 10, 1, 109);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4460, 'Tales', 12, 3, 109);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4461, 'Huérguina', 16, 0, 109);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4462, 'Montagut i Oix', 17, 6, 109);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4463, 'Jete', 18, 2, 109);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4464, 'Embid', 19, 5, 109);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4465, 'Fiscal', 22, 1, 109);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4466, 'Palacios del Sil', 24, 2, 109);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4467, 'Guimerà', 25, 5, 109);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4468, 'Ochánduri', 26, 8, 109);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4469, 'Pelayos de la Presa', 28, 0, 109);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4470, 'Galar', 31, 4, 109);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4471, 'Moratinos', 34, 0, 109);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4472, 'Colmenar de Montemayor', 37, 2, 109);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4473, 'Languilla', 40, 5, 109);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4474, 'Pobla de Mafumet, La', 43, 3, 109);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4475, 'Frías de Albarracín', 44, 8, 109);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4476, 'Navahermosa', 45, 1, 109);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4477, 'Cheste', 46, 4, 109);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4478, 'Palazuelo de Vedija', 47, 0, 109);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4479, 'Manganeses de la Polvorosa', 49, 9, 109);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4480, 'Frago, El', 50, 2, 109);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4481, 'Ràfol d''Almúnia, El', 3, 5, 110);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4482, 'Lanzahíta', 5, 3, 110);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4483, 'Reina', 6, 6, 110);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4484, 'Malgrat de Mar', 8, 8, 110);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4485, 'Contreras', 9, 1, 110);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4486, 'Losar de la Vera', 10, 5, 110);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4487, 'Teresa', 12, 7, 110);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4488, 'Huerta de la Obispalía', 16, 4, 110);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4489, 'Mont-ras', 17, 0, 110);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4490, 'Escamilla', 19, 9, 110);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4491, 'Fonz', 22, 5, 110);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4492, 'Páramo del Sil', 24, 6, 110);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4493, 'Guissona', 25, 9, 110);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4494, 'Ojacastro', 26, 2, 110);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4495, 'Perales de Tajuña', 28, 4, 110);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4496, 'Gallipienzo/Galipentzu', 31, 8, 110);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4497, 'Mudá', 34, 4, 110);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4498, 'Cordovilla', 37, 6, 110);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4499, 'Lastras de Cuéllar', 40, 9, 110);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4500, 'Matalebreras', 42, 1, 110);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4501, 'Pobla de Massaluca, La', 43, 7, 110);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4502, 'Fuenferrada', 44, 2, 110);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4503, 'Navalcán', 45, 5, 110);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4504, 'Xirivella', 46, 8, 110);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4505, 'Parrilla, La', 47, 4, 110);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4506, 'Manzanal de Arriba', 49, 3, 110);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4507, 'Frasno, El', 50, 6, 110);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4508, 'Redován', 3, 2, 111);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4509, 'Rena', 6, 3, 111);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4510, 'Malla', 8, 5, 111);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4511, 'Madrigal de la Vera', 10, 2, 111);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4512, 'Tírig', 12, 4, 111);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4513, 'Huerta del Marquesado', 16, 1, 111);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4514, 'Navata', 17, 7, 111);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4515, 'Jun', 18, 3, 111);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4516, 'Escariche', 19, 6, 111);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4517, 'Foradada del Toscar', 22, 2, 111);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4518, 'Guixers', 25, 6, 111);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4519, 'Ollauri', 26, 9, 111);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4520, 'Pezuela de las Torres', 28, 1, 111);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4521, 'Gallués/Galoze', 31, 5, 111);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4522, 'Lastras del Pozo', 40, 6, 111);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4523, 'Matamala de Almazán', 42, 8, 111);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4524, 'Pobla de Montornès, La', 43, 4, 111);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4525, 'Fuentes Calientes', 44, 9, 111);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4526, 'Navalmoralejo', 45, 2, 111);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4527, 'Chiva', 46, 5, 111);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4528, 'Pedraja de Portillo, La', 47, 1, 111);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4529, 'Manzanal del Barco', 49, 0, 111);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4530, 'Fréscano', 50, 3, 111);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4531, 'Relleu', 3, 7, 112);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4532, 'Losar del Barco, El', 5, 5, 112);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4533, 'Retamal de Llerena', 6, 8, 112);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4534, 'Manlleu', 8, 0, 112);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4535, 'Coruña del Conde', 9, 3, 112);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4536, 'Madrigalejo', 10, 7, 112);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4537, 'Todolella', 12, 9, 112);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4538, 'Huete', 16, 6, 112);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4539, 'Ogassa', 17, 2, 112);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4540, 'Juviles', 18, 8, 112);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4541, 'Escopete', 19, 1, 112);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4542, 'Fraga', 22, 7, 112);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4543, 'Peranzanes', 24, 8, 112);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4544, 'Ivars de Noguera', 25, 1, 112);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4545, 'Ortigosa de Cameros', 26, 4, 112);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4546, 'Pinilla del Valle', 28, 6, 112);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4547, 'Garaioa', 31, 0, 112);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4548, 'Nogal de las Huertas', 34, 6, 112);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4549, 'Cristóbal', 37, 8, 112);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4550, 'Lastrilla, La', 40, 1, 112);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4551, 'Poboleda', 43, 9, 112);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4552, 'Fuentes Claras', 44, 4, 112);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4553, 'Navalmorales, Los', 45, 7, 112);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4554, 'Chulilla', 46, 0, 112);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4555, 'Pedrajas de San Esteban', 47, 6, 112);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4556, 'Manzanal de los Infantes', 49, 5, 112);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4557, 'Rojales', 3, 3, 113);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4558, 'Llanos de Tormes, Los', 5, 1, 113);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4559, 'Ribera del Fresno', 6, 4, 113);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4560, 'Manresa', 8, 6, 113);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4561, 'Covarrubias', 9, 9, 113);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4562, 'Madroñera', 10, 3, 113);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4563, 'Toga', 12, 5, 113);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4564, 'Iniesta', 16, 2, 113);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4565, 'Espinosa de Henares', 19, 7, 113);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4566, 'Fueva, La', 22, 3, 113);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4567, 'Pobladura de Pelayo García', 24, 4, 113);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4568, 'Ivars d''Urgell', 25, 7, 113);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4569, 'Pazuengos', 26, 0, 113);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4570, 'Pinto', 28, 2, 113);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4571, 'Garde', 31, 6, 113);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4572, 'Olea de Boedo', 34, 2, 113);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4573, 'Cubo de Don Sancho, El', 37, 4, 113);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4574, 'Losa, La', 40, 7, 113);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4575, 'Medinaceli', 42, 9, 113);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4576, 'Pont d''Armentera, El', 43, 5, 113);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4577, 'Fuentes de Rubielos', 44, 0, 113);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4578, 'Navalucillos, Los', 45, 3, 113);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4579, 'Daimús', 46, 6, 113);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4580, 'Pedrosa del Rey', 47, 2, 113);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4581, 'Matilla de Arzón', 49, 1, 113);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4582, 'Fuendejalón', 50, 4, 113);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4583, 'Romana, la', 3, 8, 114);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4584, 'Madrigal de las Altas Torres', 5, 6, 114);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4585, 'Risco', 6, 9, 114);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4586, 'Martorell', 8, 1, 114);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4587, 'Cubillo del Campo', 9, 4, 114);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4588, 'Majadas', 10, 8, 114);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4589, 'Torás', 12, 0, 114);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4590, 'Olot', 17, 3, 114);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4591, 'Calahorra, La', 18, 9, 114);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4592, 'Esplegares', 19, 2, 114);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4593, 'Gistaín', 22, 8, 114);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4594, 'Pola de Gordón, La', 24, 9, 114);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4595, 'Ivorra', 25, 2, 114);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4596, 'Pedroso', 26, 5, 114);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4597, 'Piñuécar-Gandullas', 28, 7, 114);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4598, 'Garínoain', 31, 1, 114);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4599, 'Olmos de Ojeda', 34, 7, 114);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4600, 'Chagarcía Medianero', 37, 9, 114);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4601, 'Porrera', 43, 0, 114);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4602, 'Fuentespalda', 44, 5, 114);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4603, 'Navamorcuende', 45, 8, 114);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4604, 'Domeño', 46, 1, 114);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4605, 'Peñafiel', 47, 7, 114);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4606, 'Matilla la Seca', 49, 6, 114);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4607, 'Fuendetodos', 50, 9, 114);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4608, 'Sagra', 3, 1, 115);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4609, 'Maello', 5, 9, 115);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4610, 'Roca de la Sierra, La', 6, 2, 115);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4611, 'Martorelles', 8, 4, 115);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4612, 'Cubo de Bureba', 9, 7, 115);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4613, 'Malpartida de Cáceres', 10, 1, 115);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4614, 'Toro, El', 12, 3, 115);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4615, 'Laguna del Marquesado', 16, 0, 115);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4616, 'Ordis', 17, 6, 115);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4617, 'Láchar', 18, 2, 115);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4618, 'Establés', 19, 5, 115);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4619, 'Grado, El', 22, 1, 115);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4620, 'Ponferrada', 24, 2, 115);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4621, 'Isona i Conca Dellà', 25, 5, 115);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4622, 'Pinillos', 26, 8, 115);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4623, 'Pozuelo de Alarcón', 28, 0, 115);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4624, 'Garralda', 31, 4, 115);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4625, 'Dios le Guarde', 37, 2, 115);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4626, 'Maderuelo', 40, 5, 115);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4627, 'Miño de Medinaceli', 42, 7, 115);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4628, 'Pradell de la Teixeta', 43, 3, 115);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4629, 'Galve', 44, 8, 115);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4630, 'Noblejas', 45, 1, 115);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4631, 'Dos Aguas', 46, 4, 115);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4632, 'Peñaflor de Hornija', 47, 0, 115);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4633, 'Mayalde', 49, 9, 115);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4634, 'Fuentes de Ebro', 50, 2, 115);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4635, 'Salinas', 3, 4, 116);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4636, 'Malpartida de Corneja', 5, 2, 116);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4637, 'Salvaleón', 6, 5, 116);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4638, 'Masies de Roda, Les', 8, 7, 116);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4639, 'Malpartida de Plasencia', 10, 4, 116);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4640, 'Torralba del Pinar', 12, 6, 116);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4641, 'Lagunaseca', 16, 3, 116);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4642, 'Osor', 17, 9, 116);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4643, 'Lanjarón', 18, 5, 116);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4644, 'Estriégana', 19, 8, 116);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4645, 'Grañén', 22, 4, 116);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4646, 'Posada de Valdeón', 24, 5, 116);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4647, 'Pozuelo del Rey', 28, 3, 116);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4648, 'Genevilla', 31, 7, 116);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4649, 'Osornillo', 34, 3, 116);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4650, 'Doñinos de Ledesma', 37, 5, 116);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4651, 'Miño de San Esteban', 42, 0, 116);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4652, 'Prades', 43, 6, 116);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4653, 'Gargallo', 44, 1, 116);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4654, 'Noez', 45, 4, 116);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4655, 'Eliana, l''', 46, 7, 116);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4656, 'Pesquera de Duero', 47, 3, 116);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4657, 'Melgar de Tera', 49, 2, 116);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4658, 'Fuentes de Jiloca', 50, 5, 116);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4659, 'Sanet y Negrals', 3, 0, 117);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4660, 'Mamblas', 5, 8, 117);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4661, 'Salvatierra de los Barros', 6, 1, 117);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4662, 'Masies de Voltregà, Les', 8, 3, 117);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4663, 'Cueva de Roa, La', 9, 6, 117);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4664, 'Marchagaz', 10, 0, 117);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4665, 'Torreblanca', 12, 2, 117);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4666, 'Landete', 16, 9, 117);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4667, 'Palafrugell', 17, 5, 117);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4668, 'Lanteira', 18, 1, 117);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4669, 'Fontanar', 19, 4, 117);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4670, 'Graus', 22, 0, 117);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4671, 'Pozuelo del Páramo', 24, 1, 117);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4672, 'Pradejón', 26, 7, 117);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4673, 'Prádena del Rincón', 28, 9, 117);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4674, 'Goizueta', 31, 3, 117);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4675, 'Doñinos de Salamanca', 37, 1, 117);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4676, 'Molinos de Duero', 42, 6, 117);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4677, 'Prat de Comte', 43, 2, 117);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4678, 'Gea de Albarracín', 44, 7, 117);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4679, 'Nombela', 45, 0, 117);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4680, 'Emperador', 46, 3, 117);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4681, 'Piña de Esgueva', 47, 9, 117);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4682, 'Micereces de Tera', 49, 8, 117);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4683, 'Gallocanta', 50, 1, 117);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4684, 'San Fulgencio', 3, 6, 118);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4685, 'Mancera de Arriba', 5, 4, 118);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4686, 'Sancti-Spíritus', 6, 7, 118);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4687, 'Masnou, El', 8, 9, 118);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4688, 'Mata de Alcántara', 10, 6, 118);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4689, 'Torrechiva', 12, 8, 118);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4690, 'Ledaña', 16, 5, 118);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4691, 'Palamós', 17, 1, 118);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4692, 'Fuembellida', 19, 0, 118);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4693, 'Prado de la Guzpeña', 24, 7, 118);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4694, 'Juncosa', 25, 0, 118);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4695, 'Pradillo', 26, 3, 118);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4696, 'Puebla de la Sierra', 28, 5, 118);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4697, 'Goñi', 31, 9, 118);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4698, 'Ejeme', 37, 7, 118);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4699, 'Marazuela', 40, 0, 118);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4700, 'Momblona', 42, 2, 118);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4701, 'Pratdip', 43, 8, 118);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4702, 'Ginebrosa, La', 44, 3, 118);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4703, 'Novés', 45, 6, 118);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4704, 'Enguera', 46, 9, 118);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4705, 'Piñel de Abajo', 47, 5, 118);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4706, 'Milles de la Polvorosa', 49, 4, 118);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4707, 'Gallur', 50, 7, 118);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4708, 'Sant Joan d''Alacant', 3, 9, 119);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4709, 'Manjabálago', 5, 7, 119);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4710, 'San Pedro de Mérida', 6, 0, 119);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4711, 'Masquefa', 8, 2, 119);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4712, 'Cuevas de San Clemente', 9, 5, 119);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4713, 'Membrío', 10, 9, 119);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4714, 'Torre d''En Besora, la', 12, 1, 119);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4715, 'Leganiel', 16, 8, 119);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4716, 'Palau de Santa Eulàlia', 17, 4, 119);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4717, 'Lecrín', 18, 0, 119);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4718, 'Fuencemillán', 19, 3, 119);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4719, 'Gurrea de Gállego', 22, 9, 119);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4720, 'Priaranza del Bierzo', 24, 0, 119);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4721, 'Juneda', 25, 3, 119);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4722, 'Préjano', 26, 6, 119);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4723, 'Quijorna', 28, 8, 119);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4724, 'Güesa/Gorza', 31, 2, 119);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4725, 'Encina, La', 37, 0, 119);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4726, 'Martín Miguel', 40, 3, 119);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4727, 'Monteagudo de las Vicarías', 42, 5, 119);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4728, 'Puigpelat', 43, 1, 119);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4729, 'Griegos', 44, 6, 119);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4730, 'Numancia de la Sagra', 45, 9, 119);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4731, 'Ènova, l''', 46, 2, 119);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4732, 'Piñel de Arriba', 47, 8, 119);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4733, 'Molacillos', 49, 7, 119);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4734, 'Gelsa', 50, 0, 119);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4735, 'San Miguel de Salinas', 3, 3, 120);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4736, 'Marlín', 5, 1, 120);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4737, 'Santa Amalia', 6, 4, 120);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4738, 'Matadepera', 8, 6, 120);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4739, 'Encío', 9, 9, 120);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4740, 'Mesas de Ibor', 10, 3, 120);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4741, 'Torre d''en Doménec, la', 12, 5, 120);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4742, 'Palau-saverdera', 17, 8, 120);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4743, 'Lentegí', 18, 4, 120);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4744, 'Fuentelahiguera de Albatages', 19, 7, 120);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4745, 'Prioro', 24, 4, 120);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4746, 'Lleida', 25, 7, 120);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4747, 'Quel', 26, 0, 120);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4748, 'Rascafría', 28, 2, 120);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4749, 'Guesálaz/Gesalatz', 31, 6, 120);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4750, 'Palencia', 34, 2, 120);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4751, 'Encina de San Silvestre', 37, 4, 120);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4752, 'Martín Muñoz de la Dehesa', 40, 7, 120);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4753, 'Montejo de Tiermes', 42, 9, 120);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4754, 'Querol', 43, 5, 120);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4755, 'Guadalaviar', 44, 0, 120);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4756, 'Nuño Gómez', 45, 3, 120);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4757, 'Estivella', 46, 6, 120);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4758, 'Molezuelas de la Carballeda', 49, 1, 120);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4759, 'Godojos', 50, 4, 120);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4760, 'Santa Pola', 3, 0, 121);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4761, 'Martiherrero', 5, 8, 121);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4762, 'Santa Marta', 6, 1, 121);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4763, 'Mataró', 8, 3, 121);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4764, 'Miajadas', 10, 0, 121);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4765, 'Traiguera', 12, 2, 121);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4766, 'Majadas, Las', 16, 9, 121);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4767, 'Palau-sator', 17, 5, 121);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4768, 'Lobras', 18, 1, 121);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4769, 'Fuentelencina', 19, 4, 121);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4770, 'Puebla de Lillo', 24, 1, 121);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4771, 'Les', 25, 4, 121);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4772, 'Rabanera', 26, 7, 121);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4773, 'Redueña', 28, 9, 121);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4774, 'Guirguillano', 31, 3, 121);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4775, 'Palenzuela', 34, 9, 121);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4776, 'Encinas de Abajo', 37, 1, 121);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4777, 'Martín Muñoz de las Posadas', 40, 4, 121);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4778, 'Montenegro de Cameros', 42, 6, 121);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4779, 'Rasquera', 43, 2, 121);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4780, 'Gúdar', 44, 7, 121);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4781, 'Ocaña', 45, 0, 121);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4782, 'Estubeny', 46, 3, 121);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4783, 'Pollos', 47, 9, 121);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4784, 'Mombuey', 49, 8, 121);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4785, 'Gotor', 50, 1, 121);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4786, 'San Vicente del Raspeig/Sant Vicent del Raspeig', 3, 5, 122);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4787, 'Martínez', 5, 3, 122);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4788, 'Santos de Maimona, Los', 6, 6, 122);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4789, 'Mediona', 8, 8, 122);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4790, 'Espinosa de Cervera', 9, 1, 122);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4791, 'Millanes', 10, 5, 122);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4792, 'Useras/Useres, les', 12, 7, 122);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4793, 'Mariana', 16, 4, 122);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4794, 'Loja', 18, 6, 122);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4795, 'Fuentelsaz', 19, 9, 122);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4796, 'Hoz de Jaca', 22, 5, 122);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4797, 'Puente de Domingo Flórez', 24, 6, 122);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4798, 'Linyola', 25, 9, 122);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4799, 'Rasillo de Cameros, El', 26, 2, 122);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4800, 'Ribatejada', 28, 4, 122);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4801, 'Huarte/Uharte', 31, 8, 122);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4802, 'Páramo de Boedo', 34, 4, 122);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4803, 'Encinas de Arriba', 37, 6, 122);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4804, 'Marugán', 40, 9, 122);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4805, 'Renau', 43, 7, 122);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4806, 'Híjar', 44, 2, 122);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4807, 'Olías del Rey', 45, 5, 122);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4808, 'Faura', 46, 8, 122);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4809, 'Portillo', 47, 4, 122);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4810, 'Monfarracinos', 49, 3, 122);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4811, 'Grisel', 50, 6, 122);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4812, 'Sax', 3, 1, 123);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4813, 'Mediana de Voltoya', 5, 9, 123);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4814, 'San Vicente de Alcántara', 6, 2, 123);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4815, 'Molins de Rei', 8, 4, 123);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4816, 'Espinosa del Camino', 9, 7, 123);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4817, 'Mirabel', 10, 1, 123);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4818, 'Vallat', 12, 3, 123);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4819, 'Masegosa', 16, 0, 123);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4820, 'Palol de Revardit', 17, 6, 123);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4821, 'Lugros', 18, 2, 123);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4822, 'Fuentelviejo', 19, 5, 123);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4823, 'Quintana del Castillo', 24, 2, 123);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4824, 'Lladorre', 25, 5, 123);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4825, 'Redal, El', 26, 8, 123);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4826, 'Rivas-Vaciamadrid', 28, 0, 123);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4827, 'Uharte-Arakil', 31, 4, 123);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4828, 'Paredes de Nava', 34, 0, 123);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4829, 'Encinasola de los Comendadores', 37, 2, 123);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4830, 'Matabuena', 40, 5, 123);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4831, 'Morón de Almazán', 42, 7, 123);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4832, 'Reus', 43, 3, 123);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4833, 'Hinojosa de Jarque', 44, 8, 123);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4834, 'Ontígola', 45, 1, 123);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4835, 'Favara', 46, 4, 123);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4836, 'Pozal de Gallinas', 47, 0, 123);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4837, 'Montamarta', 49, 9, 123);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4838, 'Grisén', 50, 2, 123);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4839, 'Sella', 3, 6, 124);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4840, 'Medinilla', 5, 4, 124);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4841, 'Segura de León', 6, 7, 124);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4842, 'Mollet del Vallès', 8, 9, 124);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4843, 'Espinosa de los Monteros', 9, 2, 124);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4844, 'Mohedas de Granadilla', 10, 6, 124);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4845, 'Vall d''Alba', 12, 8, 124);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4846, 'Mesas, Las', 16, 5, 124);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4847, 'Pals', 17, 1, 124);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4848, 'Lújar', 18, 7, 124);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4849, 'Fuentenovilla', 19, 0, 124);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4850, 'Huerto', 22, 6, 124);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4851, 'Quintana del Marco', 24, 7, 124);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4852, 'Lladurs', 25, 0, 124);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4853, 'Ribafrecha', 26, 3, 124);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4854, 'Robledillo de la Jara', 28, 5, 124);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4855, 'Ibargoiti', 31, 9, 124);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4856, 'Payo de Ojeda', 34, 5, 124);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4857, 'Endrinal', 37, 7, 124);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4858, 'Mata de Cuéllar', 40, 0, 124);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4859, 'Muriel de la Fuente', 42, 2, 124);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4860, 'Riba, La', 43, 8, 124);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4861, 'Hoz de la Vieja, La', 44, 3, 124);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4862, 'Orgaz', 45, 6, 124);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4863, 'Fontanars dels Alforins', 46, 9, 124);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4864, 'Pozaldez', 47, 5, 124);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4865, 'Moral de Sayago', 49, 4, 124);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4866, 'Herrera de los Navarros', 50, 7, 124);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4867, 'Senija', 3, 9, 125);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4868, 'Mengamuñoz', 5, 7, 125);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4869, 'Siruela', 6, 0, 125);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4870, 'Montcada i Reixac', 8, 2, 125);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4871, 'Estépar', 9, 5, 125);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4872, 'Monroy', 10, 9, 125);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4873, 'Vall de Almonacid', 12, 1, 125);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4874, 'Minglanilla', 16, 8, 125);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4875, 'Pardines', 17, 4, 125);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4876, 'Gajanejos', 19, 3, 125);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4877, 'Huesca', 22, 9, 125);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4878, 'Quintana y Congosto', 24, 0, 125);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4879, 'Llardecans', 25, 3, 125);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4880, 'Rincón de Soto', 26, 6, 125);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4881, 'Robledo de Chavela', 28, 8, 125);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4882, 'Igúzquiza', 31, 2, 125);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4883, 'Pedraza de Campos', 34, 8, 125);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4884, 'Escurial de la Sierra', 37, 0, 125);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4885, 'Matilla, La', 40, 3, 125);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4886, 'Muriel Viejo', 42, 5, 125);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4887, 'Riba-roja d''Ebre', 43, 1, 125);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4888, 'Huesa del Común', 44, 6, 125);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4889, 'Oropesa', 45, 9, 125);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4890, 'Fortaleny', 46, 2, 125);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4891, 'Pozuelo de la Orden', 47, 8, 125);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4892, 'Moraleja del Vino', 49, 7, 125);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4893, 'Ibdes', 50, 0, 125);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4894, 'Mesegar de Corneja', 5, 0, 126);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4895, 'Solana de los Barros', 6, 3, 126);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4896, 'Montgat', 8, 5, 126);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4897, 'Montánchez', 10, 2, 126);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4898, 'Vall d''Uixó, la', 12, 4, 126);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4899, 'Mira', 16, 1, 126);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4900, 'Parlavà', 17, 7, 126);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4901, 'Malahá, La', 18, 3, 126);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4902, 'Galápagos', 19, 6, 126);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4903, 'Ibieca', 22, 2, 126);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4904, 'Llavorsí', 25, 6, 126);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4905, 'Robres del Castillo', 26, 9, 126);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4906, 'Robregordo', 28, 1, 126);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4907, 'Imotz', 31, 5, 126);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4908, 'Pedrosa de la Vega', 34, 1, 126);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4909, 'Espadaña', 37, 3, 126);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4910, 'Melque de Cercos', 40, 6, 126);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4911, 'Riera de Gaià, La', 43, 4, 126);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4912, 'Iglesuela del Cid, La', 44, 9, 126);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4913, 'Otero', 45, 2, 126);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4914, 'Foios', 46, 5, 126);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4915, 'Puras', 47, 1, 126);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4916, 'Moraleja de Sayago', 49, 0, 126);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4917, 'Illueca', 50, 3, 126);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4918, 'Tàrbena', 3, 8, 127);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4919, 'Mijares', 5, 6, 127);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4920, 'Talarrubias', 6, 9, 127);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4921, 'Monistrol de Montserrat', 8, 1, 127);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4922, 'Fontioso', 9, 4, 127);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4923, 'Montehermoso', 10, 8, 127);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4924, 'Vallibona', 12, 0, 127);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4925, 'Maracena', 18, 9, 127);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4926, 'Galve de Sorbe', 19, 2, 127);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4927, 'Igriés', 22, 8, 127);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4928, 'Regueras de Arriba', 24, 9, 127);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4929, 'Lles de Cerdanya', 25, 2, 127);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4930, 'Rodezno', 26, 5, 127);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4931, 'Rozas de Madrid, Las', 28, 7, 127);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4932, 'Irañeta', 31, 1, 127);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4933, 'Perales', 34, 7, 127);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4934, 'Espeja', 37, 9, 127);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4935, 'Membibre de la Hoz', 40, 2, 127);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4936, 'Nafría de Ucero', 42, 4, 127);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4937, 'Riudecanyes', 43, 0, 127);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4938, 'Jabaloyas', 44, 5, 127);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4939, 'Palomeque', 45, 8, 127);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4940, 'Font d''En Carròs, la', 46, 1, 127);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4941, 'Quintanilla de Arriba', 47, 7, 127);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4942, 'Morales del Vino', 49, 6, 127);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4943, 'Teulada', 3, 4, 128);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4944, 'Mingorría', 5, 2, 128);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4945, 'Talavera la Real', 6, 5, 128);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4946, 'Monistrol de Calders', 8, 7, 128);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4947, 'Frandovínez', 9, 0, 128);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4948, 'Moraleja', 10, 4, 128);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4949, 'Vilafamés', 12, 6, 128);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4950, 'Monreal del Llano', 16, 3, 128);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4951, 'Pau', 17, 9, 128);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4952, 'Marchal', 18, 5, 128);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4953, 'Ilche', 22, 4, 128);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4954, 'Llimiana', 25, 8, 128);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4955, 'Sajazarra', 26, 1, 128);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4956, 'Rozas de Puerto Real', 28, 3, 128);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4957, 'Isaba/Izaba', 31, 7, 128);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4958, 'Espino de la Orbada', 37, 5, 128);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4959, 'Migueláñez', 40, 8, 128);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4960, 'Narros', 42, 0, 128);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4961, 'Riudecols', 43, 6, 128);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4962, 'Jarque de la Val', 44, 1, 128);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4963, 'Pantoja', 45, 4, 128);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4964, 'Font de la Figuera, la', 46, 7, 128);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4965, 'Quintanilla del Molar', 47, 3, 128);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4966, 'Morales de Rey', 49, 2, 128);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4967, 'Isuerre', 50, 5, 128);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4968, 'Tibi', 3, 7, 129);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4969, 'Mirón, El', 5, 5, 129);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4970, 'Táliga', 6, 8, 129);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4971, 'Muntanyola', 8, 0, 129);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4972, 'Fresneda de la Sierra Tirón', 9, 3, 129);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4973, 'Morcillo', 10, 7, 129);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4974, 'Villafranca del Cid/Vilafranca', 12, 9, 129);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4975, 'Montalbanejo', 16, 6, 129);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4976, 'Pedret i Marzà', 17, 2, 129);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4977, 'Gascueña de Bornova', 19, 1, 129);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4978, 'Isábena', 22, 7, 129);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4979, 'Reyero', 24, 8, 129);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4980, 'Llobera', 25, 1, 129);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4981, 'San Asensio', 26, 4, 129);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4982, 'San Agustín del Guadalix', 28, 6, 129);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4983, 'Ituren', 31, 0, 129);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4984, 'Pino del Río', 34, 6, 129);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4985, 'Florida de Liébana', 37, 8, 129);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4986, 'Montejo de Arévalo', 40, 1, 129);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4987, 'Navaleno', 42, 3, 129);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4988, 'Riudoms', 43, 9, 129);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4989, 'Jatiel', 44, 4, 129);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4990, 'Paredes de Escalona', 45, 7, 129);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4991, 'Fuenterrobles', 46, 0, 129);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4992, 'Quintanilla de Onésimo', 47, 6, 129);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4993, 'Morales de Toro', 49, 5, 129);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4994, 'Jaraba', 50, 8, 129);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4995, 'Tollos', 3, 1, 130);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4996, 'Mironcillo', 5, 9, 130);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4997, 'Tamurejo', 6, 2, 130);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4998, 'Montclar', 8, 4, 130);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (4999, 'Fresneña', 9, 7, 130);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5000, 'Navaconcejo', 10, 1, 130);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5001, 'Villahermosa del Río', 12, 3, 130);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5002, 'Montalbo', 16, 0, 130);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5003, 'Pera, La', 17, 6, 130);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5004, 'Guadalajara', 19, 5, 130);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5005, 'Jaca', 22, 1, 130);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5006, 'Riaño', 24, 2, 130);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5007, 'Maldà', 25, 5, 130);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5008, 'San Millán de la Cogolla', 26, 8, 130);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5009, 'San Fernando de Henares', 28, 0, 130);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5010, 'Iturmendi', 31, 4, 130);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5011, 'Piña de Campos', 34, 0, 130);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5012, 'Forfoleda', 37, 2, 130);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5013, 'Montejo de la Vega de la Serrezuela', 40, 5, 130);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5014, 'Nepas', 42, 7, 130);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5015, 'Rocafort de Queralt', 43, 3, 130);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5016, 'Jorcas', 44, 8, 130);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5017, 'Parrillas', 45, 1, 130);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5018, 'Gavarda', 46, 4, 130);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5019, 'Quintanilla de Trigueros', 47, 0, 130);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5020, 'Morales de Valverde', 49, 9, 130);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5021, 'Jarque', 50, 2, 130);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5022, 'Tormos', 3, 8, 131);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5023, 'Mirueña de los Infanzones', 5, 6, 131);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5024, 'Torre de Miguel Sesmero', 6, 9, 131);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5025, 'Montesquiu', 8, 1, 131);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5026, 'Fresnillo de las Dueñas', 9, 4, 131);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5027, 'Navalmoral de la Mata', 10, 8, 131);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5028, 'Villamalur', 12, 0, 131);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5029, 'Monteagudo de las Salinas', 16, 7, 131);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5030, 'Jasa', 22, 8, 131);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5031, 'Riego de la Vega', 24, 9, 131);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5032, 'Massalcoreig', 25, 2, 131);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5033, 'San Millán de Yécora', 26, 5, 131);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5034, 'San Lorenzo de El Escorial', 28, 7, 131);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5035, 'Iza/Itza', 31, 1, 131);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5036, 'Población de Arroyo', 34, 7, 131);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5037, 'Frades de la Sierra', 37, 9, 131);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5038, 'Monterrubio', 40, 2, 131);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5039, 'Nolay', 42, 4, 131);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5040, 'Roda de Barà', 43, 0, 131);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5041, 'Josa', 44, 5, 131);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5042, 'Pelahustán', 45, 8, 131);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5043, 'Gandia', 46, 1, 131);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5044, 'Rábano', 47, 7, 131);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5045, 'Moralina', 49, 6, 131);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5046, 'Jaulín', 50, 9, 131);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5047, 'Torremanzanas/Torre de les Maçanes, la', 3, 3, 132);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5048, 'Mombeltrán', 5, 1, 132);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5049, 'Torremayor', 6, 4, 132);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5050, 'Montmajor', 8, 6, 132);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5051, 'Fresno de Río Tirón', 9, 9, 132);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5052, 'Navalvillar de Ibor', 10, 3, 132);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5053, 'Vilanova d''Alcolea', 12, 5, 132);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5054, 'Mota de Altarejos', 16, 2, 132);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5055, 'Peralada', 17, 8, 132);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5056, 'Moclín', 18, 4, 132);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5057, 'Henche', 19, 7, 132);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5058, 'Riello', 24, 4, 132);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5059, 'Massoteres', 25, 7, 132);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5060, 'San Román de Cameros', 26, 0, 132);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5061, 'San Martín de la Vega', 28, 2, 132);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5062, 'Izagaondoa', 31, 6, 132);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5063, 'Población de Campos', 34, 2, 132);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5064, 'Fregeneda, La', 37, 4, 132);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5065, 'Moral de Hornuez', 40, 7, 132);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5066, 'Noviercas', 42, 9, 132);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5067, 'Rodonyà', 43, 5, 132);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5068, 'Lagueruela', 44, 0, 132);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5069, 'Pepino', 45, 3, 132);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5070, 'Genovés', 46, 6, 132);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5071, 'Ramiro', 47, 2, 132);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5072, 'Moreruela de los Infanzones', 49, 1, 132);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5073, 'Joyosa, La', 50, 4, 132);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5074, 'Torrevieja', 3, 9, 133);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5075, 'Monsalupe', 5, 7, 133);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5076, 'Torremejía', 6, 0, 133);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5077, 'Montmaneu', 8, 2, 133);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5078, 'Fresno de Rodilla', 9, 5, 133);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5079, 'Navas del Madroño', 10, 9, 133);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5080, 'Villanueva de Viver', 12, 1, 133);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5081, 'Mota del Cuervo', 16, 8, 133);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5082, 'Planes d''Hostoles, Les', 17, 4, 133);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5083, 'Molvízar', 18, 0, 133);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5084, 'Heras de Ayuso', 19, 3, 133);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5085, 'Labuerda', 22, 9, 133);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5086, 'Rioseco de Tapia', 24, 0, 133);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5087, 'Maials', 25, 3, 133);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5088, 'San Martín de Valdeiglesias', 28, 8, 133);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5089, 'Izalzu/Itzaltzu', 31, 2, 133);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5090, 'Población de Cerrato', 34, 8, 133);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5091, 'Fresnedoso', 37, 0, 133);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5092, 'Roquetes', 43, 1, 133);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5093, 'Lanzuela', 44, 6, 133);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5094, 'Polán', 45, 9, 133);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5095, 'Gestalgar', 46, 2, 133);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5096, 'Renedo de Esgueva', 47, 8, 133);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5097, 'Moreruela de Tábara', 49, 7, 133);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5098, 'Lagata', 50, 0, 133);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5099, 'Vall d''Alcalà, la', 3, 4, 134);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5100, 'Moraleja de Matacabras', 5, 2, 134);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5101, 'Trasierra', 6, 5, 134);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5102, 'Figaró-Montmany', 8, 7, 134);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5103, 'Frías', 9, 0, 134);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5104, 'Navezuelas', 10, 4, 134);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5105, 'Vilar de Canes', 12, 6, 134);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5106, 'Motilla del Palancar', 16, 3, 134);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5107, 'Planoles', 17, 9, 134);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5108, 'Monachil', 18, 5, 134);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5109, 'Herrería', 19, 8, 134);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5110, 'Robla, La', 24, 5, 134);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5111, 'Menàrguens', 25, 8, 134);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5112, 'Santa Coloma', 26, 1, 134);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5113, 'San Sebastián de los Reyes', 28, 3, 134);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5114, 'Jaurrieta', 31, 7, 134);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5115, 'Polentinos', 34, 3, 134);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5116, 'Fresno Alhándiga', 37, 5, 134);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5117, 'Mozoncillo', 40, 8, 134);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5118, 'Ólvega', 42, 0, 134);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5119, 'Rourell, El', 43, 6, 134);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5120, 'Portillo de Toledo', 45, 4, 134);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5121, 'Gilet', 46, 7, 134);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5122, 'Roales de Campos', 47, 3, 134);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5123, 'Muelas de los Caballeros', 49, 2, 134);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5124, 'Langa del Castillo', 50, 5, 134);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5125, 'Vall d''Ebo, la', 3, 7, 135);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5126, 'Muñana', 5, 5, 135);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5127, 'Trujillanos', 6, 8, 135);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5128, 'Montmeló', 8, 0, 135);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5129, 'Fuentebureba', 9, 3, 135);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5130, 'Nuñomoral', 10, 7, 135);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5131, 'Vila-real', 12, 9, 135);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5132, 'Moya', 16, 6, 135);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5133, 'Pont de Molins', 17, 2, 135);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5134, 'Montefrío', 18, 8, 135);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5135, 'Hiendelaencina', 19, 1, 135);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5136, 'Laluenga', 22, 7, 135);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5137, 'Miralcamp', 25, 1, 135);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5138, 'Santa Engracia del Jubera', 26, 4, 135);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5139, 'Santa María de la Alameda', 28, 6, 135);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5140, 'Javier', 31, 0, 135);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5141, 'Pomar de Valdivia', 34, 6, 135);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5142, 'Fuente de San Esteban, La', 37, 8, 135);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5143, 'Muñopedro', 40, 1, 135);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5144, 'Oncala', 42, 3, 135);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5145, 'Salomó', 43, 9, 135);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5146, 'Libros', 44, 4, 135);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5147, 'Puebla de Almoradiel, La', 45, 7, 135);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5148, 'Godella', 46, 0, 135);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5149, 'Robladillo', 47, 6, 135);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5150, 'Muelas del Pan', 49, 5, 135);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5151, 'Layana', 50, 8, 135);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5152, 'Vall de Gallinera', 3, 0, 136);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5153, 'Muñico', 5, 8, 136);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5154, 'Usagre', 6, 1, 136);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5155, 'Montornès del Vallès', 8, 3, 136);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5156, 'Fuentecén', 9, 6, 136);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5157, 'Oliva de Plasencia', 10, 0, 136);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5158, 'Vilavella, la', 12, 2, 136);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5159, 'Pontós', 17, 5, 136);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5160, 'Montejícar', 18, 1, 136);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5161, 'Hijes', 19, 4, 136);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5162, 'Lalueza', 22, 0, 136);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5163, 'Roperuelos del Páramo', 24, 1, 136);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5164, 'Molsosa, La', 25, 4, 136);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5165, 'Santa Eulalia Bajera', 26, 7, 136);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5166, 'Santorcaz', 28, 9, 136);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5167, 'Juslapeña', 31, 3, 136);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5168, 'Poza de la Vega', 34, 9, 136);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5169, 'Fuenteguinaldo', 37, 1, 136);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5170, 'Muñoveros', 40, 4, 136);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5171, 'Sant Carles de la Ràpita', 43, 2, 136);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5172, 'Lidón', 44, 7, 136);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5173, 'Puebla de Montalbán, La', 45, 0, 136);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5174, 'Godelleta', 46, 3, 136);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5175, 'Muga de Sayago', 49, 8, 136);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5176, 'Lécera', 50, 1, 136);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5177, 'Vall de Laguar, la', 3, 6, 137);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5178, 'Valdecaballeros', 6, 7, 137);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5179, 'Montseny', 8, 9, 137);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5180, 'Fuentelcésped', 9, 2, 137);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5181, 'Palomero', 10, 6, 137);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5182, 'Villores', 12, 8, 137);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5183, 'Narboneta', 16, 5, 137);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5184, 'Porqueres', 17, 1, 137);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5185, 'Montillana', 18, 7, 137);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5186, 'Lanaja', 22, 6, 137);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5187, 'Sabero', 24, 7, 137);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5188, 'Mollerussa', 25, 0, 137);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5189, 'Santos de la Humosa, Los', 28, 5, 137);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5190, 'Beintza-Labaien', 31, 9, 137);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5191, 'Pozo de Urama', 34, 5, 137);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5192, 'Fuenteliante', 37, 7, 137);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5193, 'Sant Jaume dels Domenys', 43, 8, 137);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5194, 'Linares de Mora', 44, 3, 137);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5195, 'Pueblanueva, La', 45, 6, 137);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5196, 'Granja de la Costera, la', 46, 9, 137);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5197, 'Roturas', 47, 5, 137);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5198, 'Navianos de Valverde', 49, 4, 137);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5199, 'Leciñena', 50, 7, 137);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5200, 'Verger, el', 3, 2, 138);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5201, 'Muñogalindo', 5, 0, 138);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5202, 'Valdetorres', 6, 3, 138);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5203, 'Moià', 8, 5, 138);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5204, 'Fuentelisendo', 9, 8, 138);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5205, 'Pasarón de la Vera', 10, 2, 138);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5206, 'Vinaròs', 12, 4, 138);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5207, 'Portbou', 17, 7, 138);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5208, 'Moraleda de Zafayona', 18, 3, 138);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5209, 'Hita', 19, 6, 138);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5210, 'Montgai', 25, 6, 138);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5211, 'Santo Domingo de la Calzada', 26, 9, 138);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5212, 'Serna del Monte, La', 28, 1, 138);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5213, 'Lakuntza', 31, 5, 138);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5214, 'Fuenterroble de Salvatierra', 37, 3, 138);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5215, 'Nava de la Asunción', 40, 6, 138);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5216, 'Santa Bàrbara', 43, 4, 138);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5217, 'Loscos', 44, 9, 138);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5218, 'Puente del Arzobispo, El', 45, 2, 138);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5219, 'Guadasséquies', 46, 5, 138);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5220, 'Rubí de Bracamonte', 47, 1, 138);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5221, 'Olmillos de Castro', 49, 0, 138);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5222, 'Lechón', 50, 3, 138);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5223, 'Villajoyosa/Vila Joiosa, la', 3, 5, 139);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5224, 'Muñogrande', 5, 3, 139);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5225, 'Valencia de las Torres', 6, 6, 139);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5226, 'Mura', 8, 8, 139);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5227, 'Fuentemolinos', 9, 1, 139);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5228, 'Pedroso de Acim', 10, 5, 139);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5229, 'Vistabella del Maestrazgo', 12, 7, 139);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5230, 'Olivares de Júcar', 16, 4, 139);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5231, 'Preses, Les', 17, 0, 139);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5232, 'Hombrados', 19, 9, 139);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5233, 'Laperdiguera', 22, 5, 139);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5234, 'Sahagún', 24, 6, 139);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5235, 'Montellà i Martinet', 25, 9, 139);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5236, 'San Torcuato', 26, 2, 139);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5237, 'Lana', 31, 8, 139);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5238, 'Prádanos de Ojeda', 34, 4, 139);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5239, 'Fuentes de Béjar', 37, 6, 139);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5240, 'Navafría', 40, 9, 139);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5241, 'Pinilla del Campo', 42, 1, 139);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5242, 'Santa Coloma de Queralt', 43, 7, 139);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5243, 'Puerto de San Vicente', 45, 5, 139);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5244, 'Guadassuar', 46, 8, 139);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5245, 'Rueda', 47, 4, 139);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5246, 'Otero de Bodas', 49, 3, 139);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5247, 'Letux', 50, 6, 139);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5248, 'Villena', 3, 9, 140);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5249, 'Muñomer del Peco', 5, 7, 140);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5250, 'Valencia del Mombuey', 6, 0, 140);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5251, 'Navarcles', 8, 2, 140);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5252, 'Fuentenebro', 9, 5, 140);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5253, 'Peraleda de la Mata', 10, 9, 140);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5254, 'Viver', 12, 1, 140);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5255, 'Olmeda de la Cuesta', 16, 8, 140);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5256, 'Port de la Selva, El', 17, 4, 140);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5257, 'Motril', 18, 0, 140);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5258, 'Montferrer i Castellbò', 25, 3, 140);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5259, 'Santurde de Rioja', 26, 6, 140);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5260, 'Serranillos del Valle', 28, 8, 140);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5261, 'Lantz', 31, 2, 140);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5262, 'Puebla de Valdavia, La', 34, 8, 140);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5263, 'Fuentes de Oñoro', 37, 0, 140);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5264, 'Navalilla', 40, 3, 140);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5265, 'Portillo de Soria', 42, 5, 140);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5266, 'Santa Oliva', 43, 1, 140);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5267, 'Pulgar', 45, 9, 140);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5268, 'Guardamar de la Safor', 46, 2, 140);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5269, 'Saelices de Mayorga', 47, 8, 140);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5270, 'Litago', 50, 0, 140);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5271, 'Muñopepe', 5, 4, 141);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5272, 'Valencia del Ventoso', 6, 7, 141);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5273, 'Navàs', 8, 9, 141);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5274, 'Fuentespina', 9, 2, 141);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5275, 'Peraleda de San Román', 10, 6, 141);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5276, 'Zorita del Maestrazgo', 12, 8, 141);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5277, 'Olmeda del Rey', 16, 5, 141);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5278, 'Puigcerdà', 17, 1, 141);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5279, 'Murtas', 18, 7, 141);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5280, 'Lascellas-Ponzano', 22, 6, 141);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5281, 'San Adrián del Valle', 24, 7, 141);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5282, 'Montoliu de Segarra', 25, 0, 141);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5283, 'Santurdejo', 26, 3, 141);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5284, 'Sevilla la Nueva', 28, 5, 141);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5285, 'Lapoblación', 31, 9, 141);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5286, 'Quintana del Puente', 34, 5, 141);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5287, 'Gajates', 37, 7, 141);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5288, 'Navalmanzano', 40, 0, 141);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5289, 'Póveda de Soria, La', 42, 2, 141);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5290, 'Pontils', 43, 8, 141);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5291, 'Lledó', 44, 3, 141);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5292, 'Quero', 45, 6, 141);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5293, 'Higueruelas', 46, 9, 141);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5294, 'Salvador de Zapardiel', 47, 5, 141);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5295, 'Pajares de la Lampreana', 49, 4, 141);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5296, 'Lituénigo', 50, 7, 141);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5297, 'Muñosancho', 5, 9, 142);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5298, 'Valverde de Burguillos', 6, 2, 142);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5299, 'Nou de Berguedà, La', 8, 4, 142);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5300, 'Perales del Puerto', 10, 1, 142);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5301, 'Zucaina', 12, 3, 142);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5302, 'Olmedilla de Alarcón', 16, 0, 142);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5303, 'Quart', 17, 6, 142);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5304, 'Hontoba', 19, 5, 142);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5305, 'Lascuarre', 22, 1, 142);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5306, 'San Andrés del Rabanedo', 24, 2, 142);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5307, 'Montoliu de Lleida', 25, 5, 142);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5308, 'San Vicente de la Sonsierra', 26, 8, 142);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5309, 'Larraga', 31, 4, 142);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5310, 'Galindo y Perahuy', 37, 2, 142);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5311, 'Navares de Ayuso', 40, 5, 142);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5312, 'Pozalmuro', 42, 7, 142);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5313, 'Sarral', 43, 3, 142);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5314, 'Maicas', 44, 8, 142);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5315, 'Quintanar de la Orden', 45, 1, 142);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5316, 'Jalance', 46, 4, 142);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5317, 'San Cebrián de Mazote', 47, 0, 142);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5318, 'Palacios del Pan', 49, 9, 142);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5319, 'Lobera de Onsella', 50, 2, 142);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5320, 'Muñotello', 5, 5, 143);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5321, 'Valverde de Leganés', 6, 8, 143);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5322, 'Òdena', 8, 0, 143);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5323, 'Galbarros', 9, 3, 143);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5324, 'Pescueza', 10, 7, 143);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5325, 'Olmedilla de Eliz', 16, 6, 143);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5326, 'Rabós', 17, 2, 143);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5327, 'Nigüelas', 18, 8, 143);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5328, 'Horche', 19, 1, 143);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5329, 'Laspaúles', 22, 7, 143);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5330, 'Sancedo', 24, 8, 143);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5331, 'Montornès de Segarra', 25, 1, 143);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5332, 'Sojuela', 26, 4, 143);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5333, 'Somosierra', 28, 6, 143);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5334, 'Larraona', 31, 0, 143);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5335, 'Quintanilla de Onsoña', 34, 6, 143);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5336, 'Galinduste', 37, 8, 143);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5337, 'Navares de Enmedio', 40, 1, 143);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5338, 'Savallà del Comtat', 43, 9, 143);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5339, 'Manzanera', 44, 4, 143);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5340, 'Quismondo', 45, 7, 143);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5341, 'Xeraco', 46, 0, 143);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5342, 'San Llorente', 47, 6, 143);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5343, 'Palacios de Sanabria', 49, 5, 143);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5344, 'Longares', 50, 8, 143);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5345, 'Narrillos del Álamo', 5, 0, 144);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5346, 'Valverde de Llerena', 6, 3, 144);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5347, 'Olvan', 8, 5, 144);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5348, 'Gallega, La', 9, 8, 144);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5349, 'Pesga, La', 10, 2, 144);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5350, 'Regencós', 17, 7, 144);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5351, 'Nívar', 18, 3, 144);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5352, 'Laspuña', 22, 2, 144);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5353, 'San Cristóbal de la Polantera', 24, 3, 144);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5354, 'Sorzano', 26, 9, 144);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5355, 'Soto del Real', 28, 1, 144);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5356, 'Larraun', 31, 5, 144);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5357, 'Galisancho', 37, 3, 144);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5358, 'Navares de las Cuevas', 40, 6, 144);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5359, 'Quintana Redonda', 42, 8, 144);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5360, 'Secuita, La', 43, 4, 144);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5361, 'Martín del Río', 44, 9, 144);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5362, 'Real de San Vicente, El', 45, 2, 144);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5363, 'Jarafuel', 46, 5, 144);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5364, 'San Martín de Valvení', 47, 1, 144);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5365, 'Longás', 50, 3, 144);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5366, 'Narrillos del Rebollar', 5, 3, 145);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5367, 'Valverde de Mérida', 6, 6, 145);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5368, 'Olèrdola', 8, 8, 145);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5369, 'Piedras Albas', 10, 5, 145);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5370, 'Osa de la Vega', 16, 4, 145);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5371, 'Ribes de Freser', 17, 0, 145);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5372, 'Ogíjares', 18, 6, 145);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5373, 'Hortezuela de Océn', 19, 9, 145);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5374, 'San Emiliano', 24, 6, 145);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5375, 'Nalec', 25, 9, 145);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5376, 'Sotés', 26, 2, 145);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5377, 'Talamanca de Jarama', 28, 4, 145);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5378, 'Lazagurría', 31, 8, 145);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5379, 'Gallegos de Argañán', 37, 6, 145);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5380, 'Navas de Oro', 40, 9, 145);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5381, 'Quintanas de Gormaz', 42, 1, 145);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5382, 'Selva del Camp, La', 43, 7, 145);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5383, 'Mas de las Matas', 44, 2, 145);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5384, 'Recas', 45, 5, 145);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5385, 'Xàtiva', 46, 8, 145);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5386, 'San Miguel del Arroyo', 47, 4, 145);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5387, 'Pedralba de la Pradería', 49, 3, 145);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5388, 'Valle de la Serena', 6, 9, 146);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5389, 'Olesa de Bonesvalls', 8, 1, 146);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5390, 'Pinofranqueado', 10, 8, 146);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5391, 'Pajarón', 16, 7, 146);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5392, 'Riells i Viabrea', 17, 3, 146);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5393, 'Orce', 18, 9, 146);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5394, 'Huerce, La', 19, 2, 146);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5395, 'San Esteban de Nogales', 24, 9, 146);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5396, 'Navès', 25, 2, 146);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5397, 'Soto en Cameros', 26, 5, 146);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5398, 'Tielmes', 28, 7, 146);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5399, 'Leache', 31, 1, 146);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5400, 'Reinoso de Cerrato', 34, 7, 146);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5401, 'Gallegos de Solmirón', 37, 9, 146);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5402, 'Navas de San Antonio', 40, 2, 146);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5403, 'Senan', 43, 0, 146);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5404, 'Mata de los Olmos, La', 44, 5, 146);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5405, 'Retamoso de la Jara', 45, 8, 146);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5406, 'Xeresa', 46, 1, 146);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5407, 'San Miguel del Pino', 47, 7, 146);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5408, 'Pego, El', 49, 6, 146);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5409, 'Lucena de Jalón', 50, 9, 146);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5410, 'Narros del Castillo', 5, 2, 147);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5411, 'Valle de Matamoros', 6, 5, 147);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5412, 'Olesa de Montserrat', 8, 7, 147);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5413, 'Piornal', 10, 4, 147);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5414, 'Pajaroncillo', 16, 3, 147);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5415, 'Ripoll', 17, 9, 147);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5416, 'Órgiva', 18, 5, 147);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5417, 'Huérmeces del Cerro', 19, 8, 147);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5418, 'Terroba', 26, 1, 147);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5419, 'Titulcia', 28, 3, 147);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5420, 'Legarda', 31, 7, 147);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5421, 'Renedo de la Vega', 34, 3, 147);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5422, 'Garcibuey', 37, 5, 147);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5423, 'Solivella', 43, 6, 147);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5424, 'Mazaleón', 44, 1, 147);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5425, 'Rielves', 45, 4, 147);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5426, 'Llíria', 46, 7, 147);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5427, 'San Pablo de la Moraleja', 47, 3, 147);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5428, 'Peleagonzalo', 49, 2, 147);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5429, 'Luceni', 50, 5, 147);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5430, 'Narros del Puerto', 5, 8, 148);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5431, 'Valle de Santa Ana', 6, 1, 148);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5432, 'Olivella', 8, 3, 148);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5433, 'Grijalba', 9, 6, 148);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5434, 'Plasencia', 10, 0, 148);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5435, 'Palomares del Campo', 16, 9, 148);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5436, 'Riudarenes', 17, 5, 148);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5437, 'Otívar', 18, 1, 148);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5438, 'Huertahernando', 19, 4, 148);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5439, 'San Justo de la Vega', 24, 1, 148);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5440, 'Odèn', 25, 4, 148);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5441, 'Tirgo', 26, 7, 148);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5442, 'Torrejón de Ardoz', 28, 9, 148);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5443, 'Legaria', 31, 3, 148);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5444, 'Garcihernández', 37, 1, 148);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5445, 'Nieva', 40, 4, 148);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5446, 'Quiñonería', 42, 6, 148);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5447, 'Tarragona', 43, 2, 148);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5448, 'Mezquita de Jarque', 44, 7, 148);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5449, 'Robledo del Mazo', 45, 0, 148);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5450, 'Loriguilla', 46, 3, 148);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5451, 'San Pedro de Latarce', 47, 9, 148);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5452, 'Peleas de Abajo', 49, 8, 148);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5453, 'Luesia', 50, 1, 148);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5454, 'Narros de Saldueña', 5, 1, 149);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5455, 'Villafranca de los Barros', 6, 4, 149);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5456, 'Olost', 8, 6, 149);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5457, 'Grisaleña', 9, 9, 149);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5458, 'Plasenzuela', 10, 3, 149);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5459, 'Palomera', 16, 2, 149);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5460, 'Riudaura', 17, 8, 149);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5461, 'Otura', 18, 4, 149);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5462, 'Loarre', 22, 3, 149);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5463, 'San Millán de los Caballeros', 24, 4, 149);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5464, 'Oliana', 25, 7, 149);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5465, 'Tobía', 26, 0, 149);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5466, 'Torrejón de la Calzada', 28, 2, 149);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5467, 'Leitza', 31, 6, 149);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5468, 'Requena de Campos', 34, 2, 149);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5469, 'Garcirrey', 37, 4, 149);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5470, 'Olombrada', 40, 7, 149);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5471, 'Rábanos, Los', 42, 9, 149);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5472, 'Tivenys', 43, 5, 149);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5473, 'Mirambel', 44, 0, 149);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5474, 'Romeral, El', 45, 3, 149);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5475, 'Losa del Obispo', 46, 6, 149);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5476, 'San Pelayo', 47, 2, 149);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5477, 'Peñausende', 49, 1, 149);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5478, 'Luesma', 50, 4, 149);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5479, 'Villagarcía de la Torre', 6, 7, 150);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5480, 'Orís', 8, 9, 150);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5481, 'Portaje', 10, 6, 150);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5482, 'Paracuellos', 16, 5, 150);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5483, 'Riudellots de la Selva', 17, 1, 150);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5484, 'Padul', 18, 7, 150);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5485, 'Hueva', 19, 0, 150);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5486, 'Loporzano', 22, 6, 150);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5487, 'San Pedro Bercianos', 24, 7, 150);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5488, 'Oliola', 25, 0, 150);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5489, 'Tormantos', 26, 3, 150);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5490, 'Torrejón de Velasco', 28, 5, 150);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5491, 'Leoz/Leotz', 31, 9, 150);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5492, 'Gejuelo del Barro', 37, 7, 150);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5493, 'Orejana', 40, 0, 150);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5494, 'Tivissa', 43, 8, 150);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5495, 'Miravete de la Sierra', 44, 3, 150);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5496, 'San Bartolomé de las Abiertas', 45, 6, 150);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5497, 'Llutxent', 46, 9, 150);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5498, 'San Román de Hornija', 47, 5, 150);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5499, 'Peque', 49, 4, 150);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5500, 'Lumpiaque', 50, 7, 150);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5501, 'Navacepedilla de Corneja', 5, 1, 151);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5502, 'Villagonzalo', 6, 4, 151);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5503, 'Oristà', 8, 6, 151);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5504, 'Gumiel de Izán', 9, 9, 151);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5505, 'Portezuelo', 10, 3, 151);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5506, 'Paredes', 16, 2, 151);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5507, 'Riumors', 17, 8, 151);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5508, 'Pampaneira', 18, 4, 151);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5509, 'Humanes', 19, 7, 151);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5510, 'Loscorrales', 22, 3, 151);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5511, 'Santa Colomba de Curueño', 24, 4, 151);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5512, 'Olius', 25, 7, 151);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5513, 'Torrecilla en Cameros', 26, 0, 151);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5514, 'Torrelaguna', 28, 2, 151);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5515, 'Lerga', 31, 6, 151);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5516, 'Respenda de la Peña', 34, 2, 151);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5517, 'Golpejas', 37, 4, 151);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5518, 'Ortigosa de Pestaño', 40, 7, 151);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5519, 'Rebollar', 42, 9, 151);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5520, 'Torre de Fontaubella, La', 43, 5, 151);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5521, 'Molinos', 44, 0, 151);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5522, 'San Martín de Montalbán', 45, 3, 151);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5523, 'Llocnou d''En Fenollet', 46, 6, 151);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5524, 'San Salvador', 47, 2, 151);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5525, 'Perdigón, El', 49, 1, 151);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5526, 'Luna', 50, 4, 151);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5527, 'Nava de Arévalo', 5, 6, 152);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5528, 'Villalba de los Barros', 6, 9, 152);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5529, 'Orpí', 8, 1, 152);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5530, 'Gumiel de Mercado', 9, 4, 152);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5531, 'Pozuelo de Zarzón', 10, 8, 152);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5532, 'Parra de las Vegas, La', 16, 7, 152);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5533, 'Roses', 17, 3, 152);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5534, 'Pedro Martínez', 18, 9, 152);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5535, 'Illana', 19, 2, 152);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5536, 'Santa Colomba de Somoza', 24, 9, 152);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5537, 'Oluges, Les', 25, 2, 152);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5538, 'Torrecilla sobre Alesanco', 26, 5, 152);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5539, 'Torrelodones', 28, 7, 152);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5540, 'Lerín', 31, 1, 152);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5541, 'Revenga de Campos', 34, 7, 152);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5542, 'Gomecello', 37, 9, 152);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5543, 'Otero de Herreros', 40, 2, 152);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5544, 'Recuerda', 42, 4, 152);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5545, 'Torre de l''Espanyol, La', 43, 0, 152);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5546, 'Monforte de Moyuela', 44, 5, 152);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5547, 'San Martín de Pusa', 45, 8, 152);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5548, 'Llocnou de la Corona', 46, 1, 152);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5549, 'Santa Eufemia del Arroyo', 47, 7, 152);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5550, 'Pereruela', 49, 6, 152);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5551, 'Maella', 50, 9, 152);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5552, 'Nava del Barco', 5, 2, 153);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5553, 'Villanueva de la Serena', 6, 5, 153);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5554, 'Òrrius', 8, 7, 153);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5555, 'Puerto de Santa Cruz', 10, 4, 153);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5556, 'Pedernoso, El', 16, 3, 153);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5557, 'Rupià', 17, 9, 153);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5558, 'Peligros', 18, 5, 153);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5559, 'Iniéstola', 19, 8, 153);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5560, 'Santa Cristina de Valmadrigal', 24, 5, 153);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5561, 'Omellons, Els', 25, 8, 153);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5562, 'Torre en Cameros', 26, 1, 153);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5563, 'Torremocha de Jarama', 28, 3, 153);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5564, 'Lesaka', 31, 7, 153);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5565, 'Rello', 42, 0, 153);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5566, 'Torredembarra', 43, 6, 153);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5567, 'Monreal del Campo', 44, 1, 153);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5568, 'San Pablo de los Montes', 45, 4, 153);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5569, 'Llocnou de Sant Jeroni', 46, 7, 153);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5570, 'Santervás de Campos', 47, 3, 153);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5571, 'Perilla de Castro', 49, 2, 153);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5572, 'Magallón', 50, 5, 153);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5573, 'Navadijos', 5, 7, 154);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5574, 'Villanueva del Fresno', 6, 0, 154);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5575, 'Pacs del Penedès', 8, 2, 154);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5576, 'Hacinas', 9, 5, 154);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5577, 'Rebollar', 10, 9, 154);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5578, 'Pedroñeras, Las', 16, 8, 154);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5579, 'Sales de Llierca', 17, 4, 154);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5580, 'Peza, La', 18, 0, 154);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5581, 'Inviernas, Las', 19, 3, 154);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5582, 'Santa Elena de Jamuz', 24, 0, 154);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5583, 'Omells de na Gaia, Els', 25, 3, 154);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5584, 'Torremontalbo', 26, 6, 154);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5585, 'Torres de la Alameda', 28, 8, 154);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5586, 'Lezáun', 31, 2, 154);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5587, 'Revilla de Collazos', 34, 8, 154);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5588, 'Guadramiro', 37, 0, 154);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5589, 'Pajarejos', 40, 3, 154);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5590, 'Renieblas', 42, 5, 154);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5591, 'Torroja del Priorat', 43, 1, 154);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5592, 'Monroyo', 44, 6, 154);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5593, 'San Román de los Montes', 45, 9, 154);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5594, 'Llanera de Ranes', 46, 2, 154);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5595, 'Santibáñez de Valcorba', 47, 8, 154);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5596, 'Pías', 49, 7, 154);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5597, 'Mainar', 50, 0, 154);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5598, 'Navaescurial', 5, 0, 155);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5599, 'Villar del Rey', 6, 3, 155);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5600, 'Palafolls', 8, 5, 155);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5601, 'Haza', 9, 8, 155);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5602, 'Riolobos', 10, 2, 155);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5603, 'Peral, El', 16, 1, 155);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5604, 'Salt', 17, 7, 155);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5605, 'Irueste', 19, 6, 155);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5606, 'Monesma y Cajigar', 22, 2, 155);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5607, 'Santa María de la Isla', 24, 3, 155);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5608, 'Organyà', 25, 6, 155);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5609, 'Treviana', 26, 9, 155);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5610, 'Valdaracete', 28, 1, 155);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5611, 'Liédena', 31, 5, 155);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5612, 'Ribas de Campos', 34, 1, 155);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5613, 'Guijo de Ávila', 37, 3, 155);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5614, 'Palazuelos de Eresma', 40, 6, 155);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5615, 'Retortillo de Soria', 42, 8, 155);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5616, 'Tortosa', 43, 4, 155);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5617, 'Montalbán', 44, 9, 155);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5618, 'Santa Ana de Pusa', 45, 2, 155);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5619, 'Llaurí', 46, 5, 155);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5620, 'Santovenia de Pisuerga', 47, 1, 155);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5621, 'Piedrahita de Castro', 49, 0, 155);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5622, 'Malanquilla', 50, 3, 155);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5623, 'Navahondilla', 5, 3, 156);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5624, 'Villar de Rena', 6, 6, 156);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5625, 'Palau-solità i Plegamans', 8, 8, 156);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5626, 'Robledillo de Gata', 10, 5, 156);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5627, 'Peraleja, La', 16, 4, 156);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5628, 'Jadraque', 19, 9, 156);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5629, 'Monflorite-Lascasas', 22, 5, 156);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5630, 'Santa María del Monte de Cea', 24, 6, 156);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5631, 'Os de Balaguer', 25, 9, 156);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5632, 'Valdeavero', 28, 4, 156);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5633, 'Lizoáin-Arriasgoiti', 31, 8, 156);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5634, 'Riberos de la Cueza', 34, 4, 156);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5635, 'Guijuelo', 37, 6, 156);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5636, 'Pedraza', 40, 9, 156);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5637, 'Reznos', 42, 1, 156);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5638, 'Ulldecona', 43, 7, 156);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5639, 'Monteagudo del Castillo', 44, 2, 156);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5640, 'Santa Cruz de la Zarza', 45, 5, 156);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5641, 'Llombai', 46, 8, 156);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5642, 'San Vicente del Palacio', 47, 4, 156);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5643, 'Pinilla de Toro', 49, 3, 156);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5644, 'Maleján', 50, 6, 156);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5645, 'Navalacruz', 5, 9, 157);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5646, 'Villarta de los Montes', 6, 2, 157);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5647, 'Pallejà', 8, 4, 157);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5648, 'Robledillo de la Vera', 10, 1, 157);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5649, 'Pesquera, La', 16, 0, 157);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5650, 'Sant Andreu Salou', 17, 6, 157);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5651, 'Pinos Genil', 18, 2, 157);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5652, 'Jirueque', 19, 5, 157);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5653, 'Montanuy', 22, 1, 157);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5654, 'Santa María del Páramo', 24, 2, 157);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5655, 'Ossó de Sió', 25, 5, 157);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5656, 'Tricio', 26, 8, 157);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5657, 'Valdelaguna', 28, 0, 157);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5658, 'Lodosa', 31, 4, 157);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5659, 'Saldaña', 34, 0, 157);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5660, 'Herguijuela de Ciudad Rodrigo', 37, 2, 157);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5661, 'Pelayos del Arroyo', 40, 5, 157);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5662, 'Riba de Escalote, La', 42, 7, 157);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5663, 'Ulldemolins', 43, 3, 157);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5664, 'Monterde de Albarracín', 44, 8, 157);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5665, 'Santa Cruz del Retamar', 45, 1, 157);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5666, 'Llosa de Ranes, la', 46, 4, 157);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5667, 'Sardón de Duero', 47, 0, 157);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5668, 'Pino del Oro', 49, 9, 157);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5669, 'Malón', 50, 2, 157);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5670, 'Navalmoral', 5, 5, 158);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5671, 'Zafra', 6, 8, 158);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5672, 'Papiol, El', 8, 0, 158);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5673, 'Robledillo de Trujillo', 10, 7, 158);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5674, 'Picazo, El', 16, 6, 158);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5675, 'Sant Climent Sescebes', 17, 2, 158);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5676, 'Pinos Puente', 18, 8, 158);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5677, 'Monzón', 22, 7, 158);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5678, 'Santa María de Ordás', 24, 8, 158);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5679, 'Palau d''Anglesola, El', 25, 1, 158);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5680, 'Tudelilla', 26, 4, 158);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5681, 'Valdemanco', 28, 6, 158);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5682, 'Lónguida/Longida', 31, 0, 158);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5683, 'Salinas de Pisuerga', 34, 6, 158);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5684, 'Herguijuela de la Sierra', 37, 8, 158);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5685, 'Perosillo', 40, 1, 158);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5686, 'Rioseco de Soria', 42, 3, 158);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5687, 'Vallclara', 43, 9, 158);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5688, 'Mora de Rubielos', 44, 4, 158);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5689, 'Santa Olalla', 45, 7, 158);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5690, 'Macastre', 46, 0, 158);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5691, 'Seca, La', 47, 6, 158);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5692, 'Piñero, El', 49, 5, 158);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5693, 'Navalonguilla', 5, 8, 159);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5694, 'Zahínos', 6, 1, 159);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5695, 'Parets del Vallès', 8, 3, 159);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5696, 'Hontanas', 9, 6, 159);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5697, 'Robledollano', 10, 0, 159);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5698, 'Pinarejo', 16, 9, 159);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5699, 'Sant Feliu de Buixalleu', 17, 5, 159);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5700, 'Píñar', 18, 1, 159);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5701, 'Ledanca', 19, 4, 159);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5702, 'Santa Marina del Rey', 24, 1, 159);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5703, 'Valdemaqueda', 28, 9, 159);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5704, 'Lumbier', 31, 3, 159);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5705, 'San Cebrián de Campos', 34, 9, 159);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5706, 'Herguijuela del Campo', 37, 1, 159);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5707, 'Pinarejos', 40, 4, 159);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5708, 'Rollamienta', 42, 6, 159);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5709, 'Vallfogona de Riucorb', 43, 2, 159);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5710, 'Moscardón', 44, 7, 159);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5711, 'Sartajada', 45, 0, 159);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5712, 'Manises', 46, 3, 159);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5713, 'Serrada', 47, 9, 159);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5714, 'Pobladura del Valle', 49, 8, 159);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5715, 'Maluenda', 50, 1, 159);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5716, 'Navalosa', 5, 2, 160);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5717, 'Zalamea de la Serena', 6, 5, 160);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5718, 'Perafita', 8, 7, 160);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5719, 'Hontangas', 9, 0, 160);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5720, 'Romangordo', 10, 4, 160);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5721, 'Pineda de Gigüela', 16, 3, 160);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5722, 'Sant Feliu de Guíxols', 17, 9, 160);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5723, 'Loranca de Tajuña', 19, 8, 160);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5724, 'Naval', 22, 4, 160);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5725, 'Santas Martas', 24, 5, 160);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5726, 'Uruñuela', 26, 1, 160);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5727, 'Valdemorillo', 28, 3, 160);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5728, 'Luquin', 31, 7, 160);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5729, 'San Cebrián de Mudá', 34, 3, 160);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5730, 'Hinojosa de Duero', 37, 5, 160);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5731, 'Pinarnegrillo', 40, 8, 160);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5732, 'Royo, El', 42, 0, 160);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5733, 'Vallmoll', 43, 6, 160);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5734, 'Mosqueruela', 44, 1, 160);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5735, 'Segurilla', 45, 4, 160);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5736, 'Manuel', 46, 7, 160);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5737, 'Siete Iglesias de Trabancos', 47, 3, 160);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5738, 'Pobladura de Valderaduey', 49, 2, 160);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5739, 'Mallén', 50, 5, 160);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5740, 'Navalperal de Pinares', 5, 9, 161);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5741, 'Zarza-Capilla', 6, 2, 161);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5742, 'Piera', 8, 4, 161);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5743, 'Ruanes', 10, 1, 161);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5744, 'Piqueras del Castillo', 16, 0, 161);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5745, 'Sant Feliu de Pallerols', 17, 6, 161);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5746, 'Polícar', 18, 2, 161);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5747, 'Lupiana', 19, 5, 161);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5748, 'Santiago Millas', 24, 2, 161);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5749, 'Conca de Dalt', 25, 5, 161);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5750, 'Valdemadera', 26, 8, 161);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5751, 'Valdemoro', 28, 0, 161);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5752, 'Mañeru', 31, 4, 161);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5753, 'San Cristóbal de Boedo', 34, 0, 161);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5754, 'Horcajo de Montemayor', 37, 2, 161);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5755, 'Pradales', 40, 5, 161);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5756, 'Salduero', 42, 7, 161);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5757, 'Valls', 43, 3, 161);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5758, 'Muniesa', 44, 8, 161);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5759, 'Seseña', 45, 1, 161);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5760, 'Marines', 46, 4, 161);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5761, 'Simancas', 47, 0, 161);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5762, 'Manchones', 50, 2, 161);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5763, 'Navalperal de Tormes', 5, 4, 162);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5764, 'Zarza, La', 6, 7, 162);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5765, 'Hostalets de Pierola, Els', 8, 9, 162);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5766, 'Hontoria de la Cantera', 9, 2, 162);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5767, 'Salorino', 10, 6, 162);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5768, 'Portalrubio de Guadamejud', 16, 5, 162);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5769, 'Sant Ferriol', 17, 1, 162);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5770, 'Polopos', 18, 7, 162);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5771, 'Luzaga', 19, 0, 162);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5772, 'Novales', 22, 6, 162);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5773, 'Santovenia de la Valdoncina', 24, 7, 162);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5774, 'Valgañón', 26, 3, 162);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5775, 'Valdeolmos-Alalpardo', 28, 5, 162);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5776, 'Marañón', 31, 9, 162);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5777, 'Horcajo Medianero', 37, 7, 162);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5778, 'Prádena', 40, 0, 162);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5779, 'San Esteban de Gormaz', 42, 2, 162);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5780, 'Vandellòs i l''Hospitalet de l''Infant', 43, 8, 162);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5781, 'Sevilleja de la Jara', 45, 6, 162);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5782, 'Massalavés', 46, 9, 162);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5783, 'Tamariz de Campos', 47, 5, 162);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5784, 'Porto', 49, 4, 162);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5785, 'Mara', 50, 7, 162);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5786, 'Navaluenga', 5, 0, 163);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5787, 'Pineda de Mar', 8, 5, 163);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5788, 'Hontoria del Pinar', 9, 8, 163);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5789, 'Salvatierra de Santiago', 10, 2, 163);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5790, 'Portilla', 16, 1, 163);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5791, 'Sant Gregori', 17, 7, 163);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5792, 'Pórtugos', 18, 3, 163);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5793, 'Luzón', 19, 6, 163);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5794, 'Nueno', 22, 2, 163);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5795, 'Sariegos', 24, 3, 163);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5796, 'Coma i la Pedra, La', 25, 6, 163);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5797, 'Ventosa', 26, 9, 163);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5798, 'Valdepiélagos', 28, 1, 163);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5799, 'Marcilla', 31, 5, 163);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5800, 'San Mamés de Campos', 34, 1, 163);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5801, 'Hoya, La', 37, 3, 163);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5802, 'Puebla de Pedraza', 40, 6, 163);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5803, 'San Felices', 42, 8, 163);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5804, 'Vendrell, El', 43, 4, 163);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5805, 'Noguera de Albarracín', 44, 9, 163);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5806, 'Sonseca', 45, 2, 163);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5807, 'Massalfassar', 46, 5, 163);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5808, 'Tiedra', 47, 1, 163);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5809, 'Pozoantiguo', 49, 0, 163);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5810, 'María de Huerva', 50, 3, 163);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5811, 'Navaquesera', 5, 5, 164);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5812, 'Pla del Penedès, El', 8, 0, 164);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5813, 'Hontoria de Valdearados', 9, 3, 164);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5814, 'San Martín de Trevejo', 10, 7, 164);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5815, 'Sant Hilari Sacalm', 17, 2, 164);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5816, 'Puebla de Don Fadrique', 18, 8, 164);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5817, 'Olvena', 22, 7, 164);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5818, 'Sena de Luna', 24, 8, 164);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5819, 'Penelles', 25, 1, 164);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5820, 'Ventrosa', 26, 4, 164);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5821, 'Valdetorres de Jarama', 28, 6, 164);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5822, 'Mélida', 31, 0, 164);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5823, 'Huerta', 37, 8, 164);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5824, 'Rapariegos', 40, 1, 164);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5825, 'San Leonardo de Yagüe', 42, 3, 164);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5826, 'Vespella de Gaià', 43, 9, 164);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5827, 'Nogueras', 44, 4, 164);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5828, 'Sotillo de las Palomas', 45, 7, 164);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5829, 'Massamagrell', 46, 0, 164);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5830, 'Tordehumos', 47, 6, 164);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5831, 'Pozuelo de Tábara', 49, 5, 164);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5832, 'Mediana de Aragón', 50, 8, 164);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5833, 'Navarredonda de Gredos', 5, 8, 165);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5834, 'Pobla de Claramunt, La', 8, 3, 165);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5835, 'Santa Ana', 10, 0, 165);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5836, 'Poyatos', 16, 9, 165);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5837, 'Sant Jaume de Llierca', 17, 5, 165);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5838, 'Pulianas', 18, 1, 165);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5839, 'Majaelrayo', 19, 4, 165);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5840, 'Ontiñena', 22, 0, 165);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5841, 'Sobrado', 24, 1, 165);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5842, 'Peramola', 25, 4, 165);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5843, 'Viguera', 26, 7, 165);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5844, 'Valdilecha', 28, 9, 165);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5845, 'Mendavia', 31, 3, 165);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5846, 'San Román de la Cuba', 34, 9, 165);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5847, 'Iruelos', 37, 1, 165);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5848, 'Rebollo', 40, 4, 165);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5849, 'San Pedro Manrique', 42, 6, 165);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5850, 'Vilabella', 43, 2, 165);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5851, 'Nogueruelas', 44, 7, 165);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5852, 'Talavera de la Reina', 45, 0, 165);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5853, 'Massanassa', 46, 3, 165);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5854, 'Tordesillas', 47, 9, 165);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5855, 'Prado', 49, 8, 165);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5856, 'Mequinenza', 50, 1, 165);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5857, 'Navarredondilla', 5, 1, 166);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5858, 'Pobla de Lillet, La', 8, 6, 166);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5859, 'Hormazas, Las', 9, 9, 166);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5860, 'Santa Cruz de la Sierra', 10, 3, 166);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5861, 'Pozoamargo', 16, 2, 166);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5862, 'Sant Jordi Desvalls', 17, 8, 166);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5863, 'Málaga del Fresno', 19, 7, 166);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5864, 'Soto de la Vega', 24, 4, 166);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5865, 'Pinell de Solsonès', 25, 7, 166);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5866, 'Villalba de Rioja', 26, 0, 166);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5867, 'Valverde de Alcalá', 28, 2, 166);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5868, 'Mendaza', 31, 6, 166);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5869, 'Ituero de Azaba', 37, 4, 166);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5870, 'Remondo', 40, 7, 166);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5871, 'Santa Cruz de Yanguas', 42, 9, 166);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5872, 'Vilallonga del Camp', 43, 5, 166);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5873, 'Tembleque', 45, 3, 166);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5874, 'Meliana', 46, 6, 166);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5875, 'Torrecilla de la Abadesa', 47, 2, 166);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5876, 'Puebla de Sanabria', 49, 1, 166);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5877, 'Mesones de Isuela', 50, 4, 166);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5878, 'Navarrevisca', 5, 7, 167);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5879, 'Polinyà', 8, 2, 167);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5880, 'Hornillos del Camino', 9, 5, 167);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5881, 'Santa Cruz de Paniagua', 10, 9, 167);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5882, 'Pozorrubio', 16, 8, 167);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5883, 'Sant Joan de les Abadesses', 17, 4, 167);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5884, 'Purullena', 18, 0, 167);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5885, 'Malaguilla', 19, 3, 167);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5886, 'Osso de Cinca', 22, 9, 167);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5887, 'Soto y Amío', 24, 0, 167);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5888, 'Pinós', 25, 3, 167);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5889, 'Villalobar de Rioja', 26, 6, 167);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5890, 'Velilla de San Antonio', 28, 8, 167);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5891, 'Mendigorría', 31, 2, 167);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5892, 'Santa Cecilia del Alcor', 34, 8, 167);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5893, 'Juzbado', 37, 0, 167);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5894, 'Santa María de Huerta', 42, 5, 167);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5895, 'Vilanova d''Escornalbou', 43, 1, 167);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5896, 'Obón', 44, 6, 167);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5897, 'Toboso, El', 45, 9, 167);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5898, 'Millares', 46, 2, 167);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5899, 'Torrecilla de la Orden', 47, 8, 167);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5900, 'Pueblica de Valverde', 49, 7, 167);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5901, 'Mezalocha', 50, 0, 167);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5902, 'Navas del Marqués, Las', 5, 3, 168);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5903, 'Pontons', 8, 8, 168);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5904, 'Horra, La', 9, 1, 168);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5905, 'Santa Marta de Magasca', 10, 5, 168);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5906, 'Sant Joan de Mollet', 17, 0, 168);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5907, 'Quéntar', 18, 6, 168);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5908, 'Mandayona', 19, 9, 168);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5909, 'Palo', 22, 5, 168);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5910, 'Toral de los Guzmanes', 24, 6, 168);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5911, 'Poal, El', 25, 9, 168);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5912, 'Villamediana de Iregua', 26, 2, 168);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5913, 'Vellón, El', 28, 4, 168);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5914, 'Metauten', 31, 8, 168);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5915, 'Santa Cruz de Boedo', 34, 4, 168);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5916, 'Lagunilla', 37, 6, 168);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5917, 'Riaguas de San Bartolomé', 40, 9, 168);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5918, 'Santa María de las Hoyas', 42, 1, 168);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5919, 'Vilanova de Prades', 43, 7, 168);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5920, 'Odón', 44, 2, 168);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5921, 'Toledo', 45, 5, 168);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5922, 'Miramar', 46, 8, 168);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5923, 'Torrecilla de la Torre', 47, 4, 168);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5924, 'Quintanilla del Monte', 49, 3, 168);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5925, 'Mianos', 50, 6, 168);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5926, 'Navatalgordo', 5, 6, 169);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5927, 'Prat de Llobregat, El', 8, 1, 169);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5928, 'Hortigüela', 9, 4, 169);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5929, 'Santiago de Alcántara', 10, 8, 169);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5930, 'Pozuelo, El', 16, 7, 169);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5931, 'Sant Julià de Ramis', 17, 3, 169);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5932, 'Mantiel', 19, 2, 169);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5933, 'Toreno', 24, 9, 169);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5934, 'Pobla de Cérvoles, La', 25, 2, 169);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5935, 'Villanueva de Cameros', 26, 5, 169);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5936, 'Venturada', 28, 7, 169);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5937, 'Milagro', 31, 1, 169);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5938, 'Santervás de la Vega', 34, 7, 169);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5939, 'Larrodrigo', 37, 9, 169);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5940, 'Vilaplana', 43, 0, 169);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5941, 'Ojos Negros', 44, 5, 169);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5942, 'Torralba de Oropesa', 45, 8, 169);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5943, 'Mislata', 46, 1, 169);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5944, 'Torre de Esgueva', 47, 7, 169);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5945, 'Quintanilla del Olmo', 49, 6, 169);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5946, 'Miedes de Aragón', 50, 9, 169);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5947, 'Navatejares', 5, 0, 170);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5948, 'Prats de Rei, Els', 8, 5, 170);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5949, 'Hoyales de Roa', 9, 8, 170);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5950, 'Santiago del Campo', 10, 2, 170);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5951, 'Priego', 16, 1, 170);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5952, 'Vallfogona de Ripollès', 17, 7, 170);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5953, 'Rubite', 18, 3, 170);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5954, 'Maranchón', 19, 6, 170);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5955, 'Panticosa', 22, 2, 170);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5956, 'Torre del Bierzo', 24, 3, 170);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5957, 'Bellaguarda', 25, 6, 170);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5958, 'Villar de Arnedo, El', 26, 9, 170);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5959, 'Villaconejos', 28, 1, 170);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5960, 'Mirafuentes', 31, 5, 170);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5961, 'Santibáñez de Ecla', 34, 1, 170);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5962, 'Ledesma', 37, 3, 170);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5963, 'Riaza', 40, 6, 170);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5964, 'Vila-rodona', 43, 4, 170);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5965, 'Torrecilla de la Jara', 45, 2, 170);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5966, 'Mogente/Moixent', 46, 5, 170);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5967, 'Torre de Peñafiel', 47, 1, 170);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5968, 'Quintanilla de Urz', 49, 0, 170);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5969, 'Monegrillo', 50, 3, 170);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5970, 'Neila de San Miguel', 5, 7, 171);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5971, 'Prats de Lluçanès', 8, 2, 171);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5972, 'Santibáñez el Alto', 10, 9, 171);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5973, 'Provencio, El', 16, 8, 171);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5974, 'Sant Llorenç de la Muga', 17, 4, 171);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5975, 'Salar', 18, 0, 171);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5976, 'Marchamalo', 19, 3, 171);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5977, 'Trabadelo', 24, 0, 171);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5978, 'Pobla de Segur, La', 25, 3, 171);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5979, 'Villar de Torre', 26, 6, 171);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5980, 'Villa del Prado', 28, 8, 171);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5981, 'Miranda de Arga', 31, 2, 171);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5982, 'Santibáñez de la Peña', 34, 8, 171);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5983, 'Ledrada', 37, 0, 171);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5984, 'Ribota', 40, 3, 171);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5985, 'Serón de Nágima', 42, 5, 171);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5986, 'Vila-seca', 43, 1, 171);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5987, 'Olba', 44, 6, 171);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5988, 'Torre de Esteban Hambrán, La', 45, 9, 171);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5989, 'Moncada', 46, 2, 171);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5990, 'Torrelobatón', 47, 8, 171);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5991, 'Quiruelas de Vidriales', 49, 7, 171);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5992, 'Moneva', 50, 0, 171);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5993, 'Niharra', 5, 2, 172);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5994, 'Premià de Mar', 8, 7, 172);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5995, 'Huérmeces', 9, 0, 172);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5996, 'Santibáñez el Bajo', 10, 4, 172);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5997, 'Puebla de Almenara', 16, 3, 172);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5998, 'Sant Martí de Llémena', 17, 9, 172);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (5999, 'Masegoso de Tajuña', 19, 8, 172);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6000, 'Peñalba', 22, 4, 172);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6001, 'Truchas', 24, 5, 172);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6002, 'Ponts', 25, 8, 172);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6003, 'Villarejo', 26, 1, 172);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6004, 'Villalbilla', 28, 3, 172);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6005, 'Monreal/Elo', 31, 7, 172);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6006, 'Linares de Riofrío', 37, 5, 172);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6007, 'Riofrío de Riaza', 40, 8, 172);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6008, 'Soliedra', 42, 0, 172);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6009, 'Vilaverd', 43, 6, 172);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6010, 'Oliete', 44, 1, 172);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6011, 'Torrico', 45, 4, 172);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6012, 'Montserrat', 46, 7, 172);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6013, 'Torrescárcela', 47, 3, 172);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6014, 'Rabanales', 49, 2, 172);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6015, 'Monreal de Ariza', 50, 5, 172);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6016, 'Ojos-Albos', 5, 8, 173);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6017, 'Huerta de Arriba', 9, 6, 173);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6018, 'Saucedilla', 10, 0, 173);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6019, 'Valle de Altomira, El', 16, 9, 173);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6020, 'Sant Martí Vell', 17, 5, 173);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6021, 'Salobreña', 18, 1, 173);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6022, 'Matarrubia', 19, 4, 173);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6023, 'Peñas de Riglos, Las', 22, 0, 173);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6024, 'Turcia', 24, 1, 173);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6025, 'Pont de Suert, El', 25, 4, 173);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6026, 'Villarroya', 26, 7, 173);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6027, 'Villamanrique de Tajo', 28, 9, 173);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6028, 'Monteagudo', 31, 3, 173);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6029, 'Lumbrales', 37, 1, 173);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6030, 'Roda de Eresma', 40, 4, 173);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6031, 'Soria', 42, 6, 173);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6032, 'Vilella Alta, La', 43, 2, 173);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6033, 'Olmos, Los', 44, 7, 173);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6034, 'Torrijos', 45, 0, 173);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6035, 'Montaverner', 46, 3, 173);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6036, 'Traspinedo', 47, 9, 173);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6037, 'Rábano de Aliste', 49, 8, 173);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6038, 'Monterde', 50, 1, 173);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6039, 'Orbita', 5, 3, 174);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6040, 'Puigdàlber', 8, 8, 174);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6041, 'Huerta de Rey', 9, 1, 174);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6042, 'Segura de Toro', 10, 5, 174);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6043, 'Puebla del Salvador', 16, 4, 174);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6044, 'Sant Miquel de Campmajor', 17, 0, 174);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6045, 'Santa Cruz del Comercio', 18, 6, 174);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6046, 'Matillas', 19, 9, 174);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6047, 'Peralta de Alcofea', 22, 5, 174);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6048, 'Urdiales del Páramo', 24, 6, 174);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6049, 'Portella, La', 25, 9, 174);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6050, 'Villarta-Quintana', 26, 2, 174);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6051, 'Villamanta', 28, 4, 174);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6052, 'Morentin', 31, 8, 174);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6053, 'Santoyo', 34, 4, 174);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6054, 'Macotera', 37, 6, 174);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6055, 'Sacramenia', 40, 9, 174);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6056, 'Sotillo del Rincón', 42, 1, 174);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6057, 'Vilella Baixa, La', 43, 7, 174);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6058, 'Orihuela del Tremedal', 44, 2, 174);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6059, 'Totanés', 45, 5, 174);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6060, 'Montesa', 46, 8, 174);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6061, 'Trigueros del Valle', 47, 4, 174);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6062, 'Requejo', 49, 3, 174);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6063, 'Montón', 50, 6, 174);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6064, 'Oso, El', 5, 6, 175);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6065, 'Puig-reig', 8, 1, 175);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6066, 'Humada', 9, 4, 175);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6067, 'Serradilla', 10, 8, 175);\n";
    public static String INSERTS_DB_8 = "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6068, 'Quintanar del Rey', 16, 7, 175);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6069, 'Sant Miquel de Fluvià', 17, 3, 175);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6070, 'Santa Fe', 18, 9, 175);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6071, 'Mazarete', 19, 2, 175);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6072, 'Peralta de Calasanz', 22, 8, 175);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6073, 'Valdefresno', 24, 9, 175);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6074, 'Prats i Sansor', 25, 2, 175);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6075, 'Villavelayo', 26, 5, 175);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6076, 'Villamantilla', 28, 7, 175);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6077, 'Mues', 31, 1, 175);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6078, 'Serna, La', 34, 7, 175);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6079, 'Machacón', 37, 9, 175);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6080, 'Suellacabras', 42, 4, 175);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6081, 'Vilalba dels Arcs', 43, 0, 175);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6082, 'Orrios', 44, 5, 175);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6083, 'Turleque', 45, 8, 175);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6084, 'Montitxelvo/Montichelvo', 46, 1, 175);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6085, 'Tudela de Duero', 47, 7, 175);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6086, 'Revellinos', 49, 6, 175);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6087, 'Morata de Jalón', 50, 9, 175);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6088, 'Padiernos', 5, 9, 176);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6089, 'Pujalt', 8, 4, 176);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6090, 'Hurones', 9, 7, 176);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6091, 'Serrejón', 10, 1, 176);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6092, 'Rada de Haro', 16, 0, 176);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6093, 'Sant Mori', 17, 6, 176);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6094, 'Soportújar', 18, 2, 176);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6095, 'Mazuecos', 19, 5, 176);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6096, 'Peraltilla', 22, 1, 176);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6097, 'Valdefuentes del Páramo', 24, 2, 176);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6098, 'Preixana', 25, 5, 176);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6099, 'Villaverde de Rioja', 26, 8, 176);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6100, 'Villanueva de la Cañada', 28, 0, 176);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6101, 'Murchante', 31, 4, 176);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6102, 'Sotobañado y Priorato', 34, 0, 176);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6103, 'Madroñal', 37, 2, 176);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6104, 'Samboal', 40, 5, 176);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6105, 'Tajahuerce', 42, 7, 176);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6106, 'Vimbodí i Poblet', 43, 3, 176);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6107, 'Palomar de Arroyos', 44, 8, 176);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6108, 'Ugena', 45, 1, 176);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6109, 'Montroy', 46, 4, 176);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6110, 'Unión de Campos, La', 47, 0, 176);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6111, 'Riofrío de Aliste', 49, 9, 176);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6112, 'Morata de Jiloca', 50, 2, 176);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6113, 'Pajares de Adaja', 5, 5, 177);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6114, 'Quar, La', 8, 0, 177);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6115, 'Ibeas de Juarros', 9, 3, 177);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6116, 'Sierra de Fuentes', 10, 7, 177);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6117, 'Reíllo', 16, 6, 177);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6118, 'Sant Pau de Segúries', 17, 2, 177);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6119, 'Sorvilán', 18, 8, 177);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6120, 'Medranda', 19, 1, 177);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6121, 'Perarrúa', 22, 7, 177);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6122, 'Valdelugueros', 24, 8, 177);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6123, 'Preixens', 25, 1, 177);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6124, 'Villoslada de Cameros', 26, 4, 177);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6125, 'Villanueva del Pardillo', 28, 6, 177);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6126, 'Murieta', 31, 0, 177);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6127, 'Soto de Cerrato', 34, 6, 177);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6128, 'Maíllo, El', 37, 8, 177);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6129, 'San Cristóbal de Cuéllar', 40, 1, 177);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6130, 'Tajueco', 42, 3, 177);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6131, 'Vinebre', 43, 9, 177);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6132, 'Pancrudo', 44, 4, 177);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6133, 'Urda', 45, 7, 177);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6134, 'Museros', 46, 0, 177);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6135, 'Urones de Castroponce', 47, 6, 177);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6136, 'Rionegro del Puente', 49, 5, 177);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6137, 'Morés', 50, 8, 177);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6138, 'Palacios de Goda', 5, 1, 178);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6139, 'Rajadell', 8, 6, 178);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6140, 'Ibrillos', 9, 9, 178);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6141, 'Talaván', 10, 3, 178);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6142, 'Sant Pere Pescador', 17, 8, 178);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6143, 'Torre-Cardela', 18, 4, 178);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6144, 'Megina', 19, 7, 178);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6145, 'Pertusa', 22, 3, 178);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6146, 'Valdemora', 24, 4, 178);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6147, 'Viniegra de Abajo', 26, 0, 178);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6148, 'Villanueva de Perales', 28, 2, 178);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6149, 'Murillo el Cuende', 31, 6, 178);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6150, 'Tabanera de Cerrato', 34, 2, 178);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6151, 'Malpartida', 37, 4, 178);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6152, 'San Cristóbal de la Vega', 40, 7, 178);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6153, 'Talveila', 42, 9, 178);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6154, 'Vinyols i els Arcs', 43, 5, 178);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6155, 'Parras de Castellote, Las', 44, 0, 178);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6156, 'Náquera', 46, 6, 178);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6157, 'Urueña', 47, 2, 178);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6158, 'Roales', 49, 1, 178);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6159, 'Moros', 50, 4, 178);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6160, 'Papatrigo', 5, 4, 179);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6161, 'Rellinars', 8, 9, 179);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6162, 'Iglesiarrubia', 9, 2, 179);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6163, 'Talaveruela de la Vera', 10, 6, 179);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6164, 'Torvizcón', 18, 7, 179);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6165, 'Membrillera', 19, 0, 179);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6166, 'Valdepiélago', 24, 7, 179);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6167, 'Prullans', 25, 0, 179);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6168, 'Viniegra de Arriba', 26, 3, 179);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6169, 'Villar del Olmo', 28, 5, 179);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6170, 'Murillo el Fruto', 31, 9, 179);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6171, 'Tabanera de Valdavia', 34, 5, 179);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6172, 'Mancera de Abajo', 37, 7, 179);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6173, 'Sanchonuño', 40, 0, 179);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6174, 'Peñarroya de Tastavins', 44, 3, 179);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6175, 'Valdeverdeja', 45, 6, 179);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6176, 'Navarrés', 46, 9, 179);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6177, 'Valbuena de Duero', 47, 5, 179);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6178, 'Robleda-Cervantes', 49, 4, 179);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6179, 'Moyuela', 50, 7, 179);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6180, 'Parral, El', 5, 8, 180);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6181, 'Ripollet', 8, 3, 180);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6182, 'Iglesias', 9, 6, 180);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6183, 'Talayuela', 10, 0, 180);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6184, 'Santa Coloma de Farners', 17, 5, 180);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6185, 'Trevélez', 18, 1, 180);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6186, 'Valdepolo', 24, 1, 180);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6187, 'Puiggròs', 25, 4, 180);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6188, 'Zarratón', 26, 7, 180);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6189, 'Villarejo de Salvanés', 28, 9, 180);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6190, 'Muruzábal', 31, 3, 180);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6191, 'Támara de Campos', 34, 9, 180);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6192, 'Manzano, El', 37, 1, 180);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6193, 'Sangarcía', 40, 4, 180);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6194, 'Peracense', 44, 7, 180);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6195, 'Valmojado', 45, 0, 180);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6196, 'Novelé/Novetlè', 46, 3, 180);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6197, 'Valdearcos de la Vega', 47, 9, 180);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6198, 'Roelos de Sayago', 49, 8, 180);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6199, 'Mozota', 50, 1, 180);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6200, 'Pascualcobo', 5, 5, 181);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6201, 'Roca del Vallès, La', 8, 0, 181);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6202, 'Isar', 9, 3, 181);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6203, 'Tejeda de Tiétar', 10, 7, 181);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6204, 'Rozalén del Monte', 16, 6, 181);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6205, 'Santa Cristina d''Aro', 17, 2, 181);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6206, 'Turón', 18, 8, 181);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6207, 'Miedes de Atienza', 19, 1, 181);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6208, 'Piracés', 22, 7, 181);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6209, 'Valderas', 24, 8, 181);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6210, 'Puigverd d''Agramunt', 25, 1, 181);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6211, 'Zarzosa', 26, 4, 181);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6212, 'Villaviciosa de Odón', 28, 6, 181);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6213, 'Navascués/Nabaskoze', 31, 0, 181);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6214, 'Tariego de Cerrato', 34, 6, 181);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6215, 'Martiago', 37, 8, 181);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6216, 'Real Sitio de San Ildefonso', 40, 1, 181);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6217, 'Tardelcuende', 42, 3, 181);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6218, 'Peralejos', 44, 4, 181);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6219, 'Velada', 45, 7, 181);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6220, 'Oliva', 46, 0, 181);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6221, 'Valdenebro de los Valles', 47, 6, 181);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6222, 'Rosinos de la Requejada', 49, 5, 181);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6223, 'Muel', 50, 8, 181);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6224, 'Pedro Bernardo', 5, 0, 182);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6225, 'Pont de Vilomara i Rocafort, El', 8, 5, 182);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6226, 'Itero del Castillo', 9, 8, 182);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6227, 'Toril', 10, 2, 182);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6228, 'Santa Llogaia d''Àlguema', 17, 7, 182);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6229, 'Ugíjar', 18, 3, 182);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6230, 'Mierla, La', 19, 6, 182);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6231, 'Plan', 22, 2, 182);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6232, 'Valderrey', 24, 3, 182);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6233, 'Puigverd de Lleida', 25, 6, 182);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6234, 'Villavieja del Lozoya', 28, 1, 182);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6235, 'Nazar', 31, 5, 182);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6236, 'Torquemada', 34, 1, 182);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6237, 'Martinamor', 37, 3, 182);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6238, 'San Martín y Mudrián', 40, 6, 182);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6239, 'Taroda', 42, 8, 182);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6240, 'Perales del Alfambra', 44, 9, 182);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6241, 'Ventas con Peña Aguilera, Las', 45, 2, 182);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6242, 'Olocau', 46, 5, 182);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6243, 'Valdestillas', 47, 1, 182);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6244, 'Muela, La', 50, 3, 182);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6245, 'Pedro-Rodríguez', 5, 6, 183);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6246, 'Roda de Ter', 8, 1, 183);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6247, 'Jaramillo de la Fuente', 9, 4, 183);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6248, 'Tornavacas', 10, 8, 183);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6249, 'Sant Aniol de Finestres', 17, 3, 183);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6250, 'Válor', 18, 9, 183);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6251, 'Milmarcos', 19, 2, 183);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6252, 'Valderrueda', 24, 9, 183);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6253, 'Rialp', 25, 2, 183);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6254, 'Zorraquín', 26, 5, 183);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6255, 'Zarzalejo', 28, 7, 183);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6256, 'Obanos', 31, 1, 183);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6257, 'Martín de Yeltes', 37, 9, 183);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6258, 'San Miguel de Bernuy', 40, 2, 183);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6259, 'Tejado', 42, 4, 183);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6260, 'Pitarque', 44, 5, 183);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6261, 'Ventas de Retamosa, Las', 45, 8, 183);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6262, 'Olleria, l''', 46, 1, 183);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6263, 'Valdunquillo', 47, 7, 183);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6264, 'Salce', 49, 6, 183);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6265, 'Munébrega', 50, 9, 183);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6266, 'Peguerinos', 5, 1, 184);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6267, 'Rubí', 8, 6, 184);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6268, 'Jaramillo Quemado', 9, 9, 184);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6269, 'Torno, El', 10, 3, 184);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6270, 'Santa Pau', 17, 8, 184);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6271, 'Vélez de Benaudalla', 18, 4, 184);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6272, 'Millana', 19, 7, 184);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6273, 'Poleñino', 22, 3, 184);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6274, 'Valdesamario', 24, 4, 184);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6275, 'Oco', 31, 6, 184);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6276, 'Torremormojón', 34, 2, 184);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6277, 'Masueco', 37, 4, 184);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6278, 'San Pedro de Gaíllos', 40, 7, 184);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6279, 'Torlengua', 42, 9, 184);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6280, 'Plou', 44, 0, 184);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6281, 'Ventas de San Julián, Las', 45, 3, 184);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6282, 'Ontinyent', 46, 6, 184);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6283, 'Valoria la Buena', 47, 2, 184);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6284, 'Samir de los Caños', 49, 1, 184);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6285, 'Murero', 50, 4, 184);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6286, 'Peñalba de Ávila', 5, 4, 185);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6287, 'Rubió', 8, 9, 185);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6288, 'Torrecilla de los Ángeles', 10, 6, 185);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6289, 'Saceda-Trasierra', 16, 5, 185);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6290, 'Sant Joan les Fonts', 17, 1, 185);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6291, 'Ventas de Huelma', 18, 7, 185);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6292, 'Miñosa, La', 19, 0, 185);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6293, 'Val de San Lorenzo', 24, 7, 185);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6294, 'Ribera d''Urgellet', 25, 0, 185);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6295, 'Ochagavía/Otsagabia', 31, 9, 185);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6296, 'Triollo', 34, 5, 185);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6297, 'Castellanos de Villiquera', 37, 7, 185);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6298, 'Santa María la Real de Nieva', 40, 0, 185);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6299, 'Torreblacos', 42, 2, 185);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6300, 'Pobo, El', 44, 3, 185);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6301, 'Villacañas', 45, 6, 185);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6302, 'Otos', 46, 9, 185);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6303, 'Valverde de Campos', 47, 5, 185);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6304, 'San Agustín del Pozo', 49, 4, 185);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6305, 'Murillo de Gállego', 50, 7, 185);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6306, 'Piedrahíta', 5, 7, 186);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6307, 'Torrecillas de la Tiesa', 10, 9, 186);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6308, 'Saelices', 16, 8, 186);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6309, 'Sarrià de Ter', 17, 4, 186);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6310, 'Mirabueno', 19, 3, 186);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6311, 'Pozán de Vero', 22, 9, 186);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6312, 'Riner', 25, 3, 186);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6313, 'Odieta', 31, 2, 186);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6314, 'Valbuena de Pisuerga', 34, 8, 186);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6315, 'Mata de Ledesma, La', 37, 0, 186);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6316, 'Santa Marta del Cerro', 40, 3, 186);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6317, 'Villa de Don Fadrique, La', 45, 9, 186);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6318, 'Paiporta', 46, 2, 186);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6319, 'Valladolid', 47, 8, 186);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6320, 'San Cebrián de Castro', 49, 7, 186);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6321, 'Navardún', 50, 0, 186);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6322, 'Piedralaves', 5, 3, 187);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6323, 'Sabadell', 8, 8, 187);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6324, 'Torre de Don Miguel', 10, 5, 187);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6325, 'Salinas del Manzano', 16, 4, 187);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6326, 'Saus,  Camallera i Llampaies', 17, 0, 187);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6327, 'Villanueva de las Torres', 18, 6, 187);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6328, 'Miralrío', 19, 9, 187);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6329, 'Puebla de Castro, La', 22, 5, 187);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6330, 'Valdevimbre', 24, 6, 187);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6331, 'Oitz', 31, 8, 187);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6332, 'Matilla de los Caños del Río', 37, 6, 187);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6333, 'Torrubia de Soria', 42, 1, 187);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6334, 'Portellada, La', 44, 2, 187);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6335, 'Villafranca de los Caballeros', 45, 5, 187);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6336, 'Palma de Gandía', 46, 8, 187);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6337, 'Vega de Ruiponce', 47, 4, 187);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6338, 'San Cristóbal de Entreviñas', 49, 3, 187);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6339, 'Nigüella', 50, 6, 187);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6340, 'Poveda', 5, 9, 188);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6341, 'Sagàs', 8, 4, 188);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6342, 'Torre de Santa María', 10, 1, 188);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6343, 'Salmeroncillos', 16, 0, 188);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6344, 'Selva de Mar, La', 17, 6, 188);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6345, 'Villanueva Mesía', 18, 2, 188);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6346, 'Mochales', 19, 5, 188);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6347, 'Puente de Montañana', 22, 1, 188);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6348, 'Valencia de Don Juan', 24, 2, 188);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6349, 'Olaibar', 31, 4, 188);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6350, 'Maya, La', 37, 2, 188);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6351, 'Santiuste de Pedraza', 40, 5, 188);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6352, 'Trévago', 42, 7, 188);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6353, 'Villaluenga de la Sagra', 45, 1, 188);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6354, 'Palmera', 46, 4, 188);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6355, 'Vega de Valdetronco', 47, 0, 188);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6356, 'San Esteban del Molar', 49, 9, 188);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6357, 'Nombrevilla', 50, 2, 188);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6358, 'Poyales del Hoyo', 5, 2, 189);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6359, 'Sant Pere Sallavinera', 8, 7, 189);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6360, 'Junta de Traslaloma', 9, 0, 189);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6361, 'Torrejoncillo', 10, 4, 189);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6362, 'Salvacañete', 16, 3, 189);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6363, 'Cellera de Ter, La', 17, 9, 189);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6364, 'Víznar', 18, 5, 189);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6365, 'Mohernando', 19, 8, 189);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6366, 'Puértolas', 22, 4, 189);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6367, 'Valverde de la Virgen', 24, 5, 189);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6368, 'Rosselló', 25, 8, 189);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6369, 'Olazti/Olazagutía', 31, 7, 189);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6370, 'Valdeolmillos', 34, 3, 189);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6371, 'Membribe de la Sierra', 37, 5, 189);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6372, 'Santiuste de San Juan Bautista', 40, 8, 189);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6373, 'Ucero', 42, 0, 189);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6374, 'Pozondón', 44, 1, 189);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6375, 'Villamiel de Toledo', 45, 4, 189);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6376, 'Palomar, el', 46, 7, 189);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6377, 'Velascálvaro', 47, 3, 189);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6378, 'San Justo', 49, 2, 189);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6379, 'Nonaspe', 50, 5, 189);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6380, 'Pozanco', 5, 6, 190);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6381, 'Saldes', 8, 1, 190);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6382, 'Junta de Villalba de Losa', 9, 4, 190);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6383, 'Torrejón el Rubio', 10, 8, 190);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6384, 'San Clemente', 16, 7, 190);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6385, 'Serinyà', 17, 3, 190);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6386, 'Molina de Aragón', 19, 2, 190);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6387, 'Pueyo de Araguás, El', 22, 8, 190);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6388, 'Valverde-Enrique', 24, 9, 190);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6389, 'Salàs de Pallars', 25, 2, 190);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6390, 'Olejua', 31, 1, 190);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6391, 'Valderrábano', 34, 7, 190);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6392, 'Mieza', 37, 9, 190);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6393, 'Santo Domingo de Pirón', 40, 2, 190);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6394, 'Vadillo', 42, 4, 190);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6395, 'Pozuel del Campo', 44, 5, 190);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6396, 'Villaminaya', 45, 8, 190);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6397, 'Paterna', 46, 1, 190);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6398, 'Velilla', 47, 7, 190);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6399, 'San Martín de Valderaduey', 49, 6, 190);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6400, 'Novallas', 50, 9, 190);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6401, 'Pradosegar', 5, 3, 191);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6402, 'Sallent', 8, 8, 191);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6403, 'Jurisdicción de Lara', 9, 1, 191);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6404, 'Torremenga', 10, 5, 191);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6405, 'San Lorenzo de la Parrilla', 16, 4, 191);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6406, 'Serra de Daró', 17, 0, 191);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6407, 'Monasterio', 19, 9, 191);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6408, 'Vallecillo', 24, 6, 191);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6409, 'Sanaüja', 25, 9, 191);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6410, 'Olite/Erriberri', 31, 8, 191);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6411, 'Milano, El', 37, 6, 191);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6412, 'Santo Tomé del Puerto', 40, 9, 191);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6413, 'Valdeavellano de Tera', 42, 1, 191);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6414, 'Puebla de Híjar, La', 44, 2, 191);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6415, 'Villamuelas', 45, 5, 191);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6416, 'Pedralba', 46, 8, 191);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6417, 'Velliza', 47, 4, 191);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6418, 'San Miguel de la Ribera', 49, 3, 191);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6419, 'Novillas', 50, 6, 191);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6420, 'Puerto Castilla', 5, 8, 192);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6421, 'Santpedor', 8, 3, 192);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6422, 'Jurisdicción de San Zadornil', 9, 6, 192);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6423, 'Torremocha', 10, 0, 192);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6424, 'San Martín de Boniches', 16, 9, 192);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6425, 'Setcases', 17, 5, 192);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6426, 'Zafarraya', 18, 1, 192);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6427, 'Mondéjar', 19, 4, 192);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6428, 'Sant Guim de Freixenet', 25, 4, 192);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6429, 'Olóriz/Oloritz', 31, 3, 192);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6430, 'Valde-Ucieza', 34, 9, 192);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6431, 'Miranda de Azán', 37, 1, 192);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6432, 'Sauquillo de Cabezas', 40, 4, 192);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6433, 'Valdegeña', 42, 6, 192);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6434, 'Puebla de Valverde, La', 44, 7, 192);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6435, 'Villanueva de Alcardete', 45, 0, 192);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6436, 'Petrés', 46, 3, 192);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6437, 'Ventosa de la Cuesta', 47, 9, 192);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6438, 'San Miguel del Valle', 49, 8, 192);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6439, 'Nuévalos', 50, 1, 192);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6440, 'Rasueros', 5, 4, 193);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6441, 'Sant Iscle de Vallalta', 8, 9, 193);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6442, 'Torreorgaz', 10, 6, 193);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6443, 'San Pedro Palmiches', 16, 5, 193);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6444, 'Sils', 17, 1, 193);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6445, 'Zubia, La', 18, 7, 193);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6446, 'Montarrón', 19, 0, 193);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6447, 'Pueyo de Santa Cruz', 22, 6, 193);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6448, 'Vecilla, La', 24, 7, 193);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6449, 'Sant Llorenç de Morunys', 25, 0, 193);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6450, 'Cendea de Olza/Oltza Zendea', 31, 9, 193);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6451, 'Miranda del Castañar', 37, 7, 193);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6452, 'Sebúlcor', 40, 0, 193);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6453, 'Valdelagua del Cerro', 42, 2, 193);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6454, 'Puertomingalvo', 44, 3, 193);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6455, 'Villanueva de Bogas', 45, 6, 193);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6456, 'Picanya', 46, 9, 193);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6457, 'Viana de Cega', 47, 5, 193);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6458, 'San Pedro de Ceque', 49, 4, 193);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6459, 'Nuez de Ebro', 50, 7, 193);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6460, 'Riocabado', 5, 9, 194);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6461, 'Sant Adrià de Besòs', 8, 4, 194);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6462, 'Lerma', 9, 7, 194);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6463, 'Torrequemada', 10, 1, 194);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6464, 'Santa Cruz de Moya', 16, 0, 194);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6465, 'Susqueda', 17, 6, 194);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6466, 'Zújar', 18, 2, 194);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6467, 'Moratilla de los Meleros', 19, 5, 194);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6468, 'Vegacervera', 24, 2, 194);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6469, 'Sant Ramon', 25, 5, 194);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6470, 'Ollo', 31, 4, 194);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6471, 'Mogarraz', 37, 2, 194);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6472, 'Segovia', 40, 5, 194);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6473, 'Valdemaluque', 42, 7, 194);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6474, 'Ráfales', 44, 8, 194);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6475, 'Villarejo de Montalbán', 45, 1, 194);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6476, 'Picassent', 46, 4, 194);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6477, 'Viloria', 47, 0, 194);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6478, 'San Pedro de la Nave-Almendra', 49, 9, 194);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6479, 'Olvés', 50, 2, 194);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6480, 'Riofrío', 5, 2, 195);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6481, 'Sant Agustí de Lluçanès', 8, 7, 195);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6482, 'Llano de Bureba', 9, 0, 195);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6483, 'Trujillo', 10, 4, 195);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6484, 'Santa María del Campo Rus', 16, 3, 195);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6485, 'Tallada d''Empordà, La', 17, 9, 195);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6486, 'Morenilla', 19, 8, 195);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6487, 'Quicena', 22, 4, 195);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6488, 'Orbaizeta', 31, 7, 195);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6489, 'Molinillo', 37, 5, 195);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6490, 'Sepúlveda', 40, 8, 195);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6491, 'Valdenebro', 42, 0, 195);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6492, 'Rillo', 44, 1, 195);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6493, 'Villarrubia de Santiago', 45, 4, 195);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6494, 'Piles', 46, 7, 195);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6495, 'Villabáñez', 47, 3, 195);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6496, 'Orcajo', 50, 5, 195);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6497, 'Rivilla de Barajas', 5, 5, 196);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6498, 'Sant Andreu de la Barca', 8, 0, 196);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6499, 'Madrigal del Monte', 9, 3, 196);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6500, 'Valdastillas', 10, 7, 196);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6501, 'Santa María de los Llanos', 16, 6, 196);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6502, 'Terrades', 17, 2, 196);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6503, 'Muduex', 19, 1, 196);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6504, 'Vega de Espinareda', 24, 8, 196);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6505, 'Sant Esteve de la Sarga', 25, 1, 196);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6506, 'Orbara', 31, 0, 196);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6507, 'Valle de Cerrato', 34, 6, 196);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6508, 'Monforte de la Sierra', 37, 8, 196);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6509, 'Sequera de Fresno', 40, 1, 196);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6510, 'Valdeprado', 42, 3, 196);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6511, 'Riodeva', 44, 4, 196);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6512, 'Villaseca de la Sagra', 45, 7, 196);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6513, 'Pinet', 46, 0, 196);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6514, 'Villabaruz de Campos', 47, 6, 196);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6515, 'Orera', 50, 8, 196);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6516, 'Salobral', 5, 1, 197);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6517, 'Sant Andreu de Llavaneres', 8, 6, 197);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6518, 'Madrigalejo del Monte', 9, 9, 197);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6519, 'Valdecañas de Tajo', 10, 3, 197);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6520, 'Santa María del Val', 16, 2, 197);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6521, 'Torrent', 17, 8, 197);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6522, 'Navas de Jadraque, Las', 19, 7, 197);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6523, 'Robres', 22, 3, 197);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6524, 'Vega de Infanzones', 24, 4, 197);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6525, 'Sant Guim de la Plana', 25, 7, 197);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6526, 'Orísoain', 31, 6, 197);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6527, 'Monleón', 37, 4, 197);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6528, 'Valderrodilla', 42, 9, 197);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6529, 'Ródenas', 44, 0, 197);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6530, 'Villasequilla', 45, 3, 197);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6531, 'Polinyà de Xúquer', 46, 6, 197);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6532, 'Villabrágima', 47, 2, 197);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6533, 'Santa Clara de Avedillo', 49, 1, 197);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6534, 'Orés', 50, 4, 197);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6535, 'Salvadiós', 5, 7, 198);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6536, 'Sant Antoni de Vilamajor', 8, 2, 198);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6537, 'Mahamud', 9, 5, 198);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6538, 'Valdefuentes', 10, 9, 198);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6539, 'Sisante', 16, 8, 198);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6540, 'Torroella de Fluvià', 17, 4, 198);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6541, 'Negredo', 19, 3, 198);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6542, 'Vega de Valcarce', 24, 0, 198);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6543, 'Oronz/Orontze', 31, 2, 198);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6544, 'Monleras', 37, 0, 198);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6545, 'Sotillo', 40, 3, 198);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6546, 'Valtajeros', 42, 5, 198);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6547, 'Royuela', 44, 6, 198);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6548, 'Villatobas', 45, 9, 198);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6549, 'Potríes', 46, 2, 198);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6550, 'Villacarralón', 47, 8, 198);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6551, 'Oseja', 50, 0, 198);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6552, 'San Bartolomé de Béjar', 5, 0, 199);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6553, 'Sant Bartomeu del Grau', 8, 5, 199);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6554, 'Mambrilla de Castrejón', 9, 8, 199);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6555, 'Valdehúncar', 10, 2, 199);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6556, 'Solera de Gabaldón', 16, 1, 199);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6557, 'Torroella de Montgrí', 17, 7, 199);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6558, 'Ocentejo', 19, 6, 199);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6559, 'Sabiñánigo', 22, 2, 199);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6560, 'Vegaquemada', 24, 3, 199);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6561, 'Oroz-Betelu/Orotz-Betelu', 31, 5, 199);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6562, 'Velilla del Río Carrión', 34, 1, 199);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6563, 'Monsagro', 37, 3, 199);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6564, 'Sotosalbos', 40, 6, 199);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6565, 'Rubiales', 44, 9, 199);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6566, 'Viso de San Juan, El', 45, 2, 199);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6567, 'Pobla de Farnals, la', 46, 5, 199);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6568, 'Villacid de Campos', 47, 1, 199);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6569, 'Santa Colomba de las Monjas', 49, 0, 199);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6570, 'Osera de Ebro', 50, 3, 199);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6571, 'San Bartolomé de Corneja', 5, 4, 200);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6572, 'Sant Boi de Llobregat', 8, 9, 200);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6573, 'Mambrillas de Lara', 9, 2, 200);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6574, 'Valdelacasa de Tajo', 10, 6, 200);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6575, 'Tortellà', 17, 1, 200);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6576, 'Olivar, El', 19, 0, 200);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6577, 'Sahún', 22, 6, 200);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6578, 'Sarroca de Lleida', 25, 0, 200);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6579, 'Oteiza', 31, 9, 200);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6580, 'Montejo', 37, 7, 200);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6581, 'Tabanera la Luenga', 40, 0, 200);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6582, 'Velamazán', 42, 2, 200);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6583, 'Rubielos de la Cérida', 44, 3, 200);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6584, 'Yébenes, Los', 45, 6, 200);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6585, 'Pobla del Duc, la', 46, 9, 200);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6586, 'Villaco', 47, 5, 200);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6587, 'Santa Cristina de la Polvorosa', 49, 4, 200);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6588, 'Paniza', 50, 7, 200);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6589, 'San Bartolomé de Pinares', 5, 1, 201);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6590, 'Sant Boi de Lluçanès', 8, 6, 201);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6591, 'Mamolar', 9, 9, 201);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6592, 'Valdemorales', 10, 3, 201);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6593, 'Toses', 17, 8, 201);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6594, 'Olmeda de Cobeta', 19, 7, 201);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6595, 'Salas Altas', 22, 3, 201);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6596, 'Vegas del Condado', 24, 4, 201);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6597, 'Sarroca de Bellera', 25, 7, 201);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6598, 'Pamplona/Iruña', 31, 6, 201);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6599, 'Vertavillo', 34, 2, 201);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6600, 'Montemayor del Río', 37, 4, 201);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6601, 'Tolocirio', 40, 7, 201);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6602, 'Velilla de la Sierra', 42, 9, 201);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6603, 'Rubielos de Mora', 44, 0, 201);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6604, 'Yeles', 45, 3, 201);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6605, 'Puebla de San Miguel', 46, 6, 201);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6606, 'Santa Croya de Tera', 49, 1, 201);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6607, 'Paracuellos de Jiloca', 50, 4, 201);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6608, 'Sant Celoni', 8, 1, 202);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6609, 'Manciles', 9, 4, 202);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6610, 'Valdeobispo', 10, 8, 202);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6611, 'Talayuelas', 16, 7, 202);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6612, 'Tossa de Mar', 17, 3, 202);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6613, 'Olmeda de Jadraque, La', 19, 2, 202);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6614, 'Salas Bajas', 22, 8, 202);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6615, 'Villablino', 24, 9, 202);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6616, 'Senterada', 25, 2, 202);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6617, 'Peralta/Azkoien', 31, 1, 202);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6618, 'Villabasta de Valdavia', 34, 7, 202);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6619, 'Monterrubio de Armuña', 37, 9, 202);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6620, 'Torreadrada', 40, 2, 202);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6621, 'Velilla de los Ajos', 42, 4, 202);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6622, 'Yepes', 45, 8, 202);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6623, 'Pobla de Vallbona, la', 46, 1, 202);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6624, 'Santa Eufemia del Barco', 49, 6, 202);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6625, 'Paracuellos de la Ribera', 50, 9, 202);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6626, 'Sant Cebrià de Vallalta', 8, 7, 203);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6627, 'Valencia de Alcántara', 10, 4, 203);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6628, 'Tarancón', 16, 3, 203);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6629, 'Ultramort', 17, 9, 203);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6630, 'Ordial, El', 19, 8, 203);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6631, 'Salillas', 22, 4, 203);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6632, 'Villabraz', 24, 5, 203);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6633, 'Seu d''Urgell, La', 25, 8, 203);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6634, 'Petilla de Aragón', 31, 7, 203);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6635, 'Monterrubio de la Sierra', 37, 5, 203);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6636, 'Torrecaballeros', 40, 8, 203);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6637, 'Salcedillo', 44, 1, 203);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6638, 'Yuncler', 45, 4, 203);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6639, 'Pobla Llarga, la', 46, 7, 203);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6640, 'Villafrades de Campos', 47, 3, 203);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6641, 'Santa María de la Vega', 49, 2, 203);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6642, 'Pastriz', 50, 5, 203);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6643, 'Sanchidrián', 5, 7, 204);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6644, 'Sant Climent de Llobregat', 8, 2, 204);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6645, 'Valverde de la Vera', 10, 9, 204);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6646, 'Tébar', 16, 8, 204);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6647, 'Ullà', 17, 4, 204);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6648, 'Orea', 19, 3, 204);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6649, 'Sallent de Gállego', 22, 9, 204);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6650, 'Seròs', 25, 3, 204);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6651, 'Piedramillera', 31, 2, 204);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6652, 'Villacidaler', 34, 8, 204);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6653, 'Morasverdes', 37, 0, 204);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6654, 'Torrecilla del Pinar', 40, 3, 204);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6655, 'Viana de Duero', 42, 5, 204);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6656, 'Saldón', 44, 6, 204);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6657, 'Yunclillos', 45, 9, 204);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6658, 'Puig', 46, 2, 204);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6659, 'Villafranca de Duero', 47, 8, 204);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6660, 'Santa María de Valverde', 49, 7, 204);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6661, 'Pedrola', 50, 0, 204);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6662, 'Sanchorreja', 5, 0, 205);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6663, 'Sant Cugat del Vallès', 8, 5, 205);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6664, 'Valverde del Fresno', 10, 2, 205);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6665, 'Tejadillos', 16, 1, 205);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6666, 'Ullastret', 17, 7, 205);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6667, 'San Esteban de Litera', 22, 2, 205);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6668, 'Villadangos del Páramo', 24, 3, 205);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6669, 'Sidamon', 25, 6, 205);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6670, 'Pitillas', 31, 5, 205);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6671, 'Villaconancio', 34, 1, 205);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6672, 'Morille', 37, 3, 205);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6673, 'Torreiglesias', 40, 6, 205);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6674, 'Villaciervos', 42, 8, 205);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6675, 'Samper de Calanda', 44, 9, 205);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6676, 'Yuncos', 45, 2, 205);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6677, 'Puçol', 46, 5, 205);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6678, 'Villafrechós', 47, 1, 205);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6679, 'Santibáñez de Tera', 49, 0, 205);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6680, 'Pedrosas, Las', 50, 3, 205);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6681, 'San Esteban de los Patos', 5, 3, 206);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6682, 'Sant Cugat Sesgarrigues', 8, 8, 206);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6683, 'Mazuela', 9, 1, 206);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6684, 'Viandar de la Vera', 10, 5, 206);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6685, 'Tinajas', 16, 4, 206);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6686, 'Urús', 17, 0, 206);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6687, 'Sangarrén', 22, 5, 206);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6688, 'Toral de los Vados', 24, 6, 206);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6689, 'Soleràs, El', 25, 9, 206);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6690, 'Puente la Reina/Gares', 31, 8, 206);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6691, 'Villada', 34, 4, 206);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6692, 'Moríñigo', 37, 6, 206);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6693, 'Torre Val de San Pedro', 40, 9, 206);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6694, 'Villanueva de Gormaz', 42, 1, 206);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6695, 'San Agustín', 44, 2, 206);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6696, 'Quesa', 46, 8, 206);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6697, 'Villafuerte', 47, 4, 206);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6698, 'Santibáñez de Vidriales', 49, 3, 206);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6699, 'Perdiguera', 50, 6, 206);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6700, 'San Esteban del Valle', 5, 9, 207);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6701, 'Sant Esteve de Palautordera', 8, 4, 207);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6702, 'Villa del Campo', 10, 1, 207);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6703, 'Vall d''en Bas, La', 17, 6, 207);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6704, 'San Juan de Plan', 22, 1, 207);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6705, 'Villademor de la Vega', 24, 2, 207);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6706, 'Solsona', 25, 5, 207);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6707, 'Pueyo', 31, 4, 207);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6708, 'Moriscos', 37, 2, 207);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6709, 'Trescasas', 40, 5, 207);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6710, 'Villar del Ala', 42, 7, 207);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6711, 'San Martín del Río', 44, 8, 207);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6712, 'Rafelbuñol/Rafelbunyol', 46, 4, 207);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6713, 'Villagarcía de Campos', 47, 0, 207);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6714, 'Santovenia', 49, 9, 207);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6715, 'Piedratajada', 50, 2, 207);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6716, 'San Esteban de Zapardiel', 5, 5, 208);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6717, 'Sant Esteve Sesrovires', 8, 0, 208);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6718, 'Mecerreyes', 9, 3, 208);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6719, 'Villa del Rey', 10, 7, 208);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6720, 'Vall de Bianya, La', 17, 2, 208);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6721, 'Pálmaces de Jadraque', 19, 1, 208);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6722, 'Santa Cilia', 22, 7, 208);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6723, 'Soriguera', 25, 1, 208);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6724, 'Ribaforada', 31, 0, 208);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6725, 'Villaeles de Valdavia', 34, 6, 208);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6726, 'Moronta', 37, 8, 208);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6727, 'Turégano', 40, 1, 208);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6728, 'Villar del Campo', 42, 3, 208);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6729, 'Santa Cruz de Nogueras', 44, 4, 208);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6730, 'Rafelcofer', 46, 0, 208);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6731, 'Villagómez la Nueva', 47, 6, 208);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6732, 'San Vicente de la Cabeza', 49, 5, 208);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6733, 'Pina de Ebro', 50, 8, 208);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6734, 'San García de Ingelmos', 5, 8, 209);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6735, 'Sant Fost de Campsentelles', 8, 3, 209);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6736, 'Medina de Pomar', 9, 6, 209);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6737, 'Villamesías', 10, 0, 209);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6738, 'Torralba', 16, 9, 209);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6739, 'Vall-llobrega', 17, 5, 209);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6740, 'Pardos', 19, 4, 209);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6741, 'Santa Cruz de la Serós', 22, 0, 209);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6742, 'Villafranca del Bierzo', 24, 1, 209);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6743, 'Sort', 25, 4, 209);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6744, 'Romanzado', 31, 3, 209);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6745, 'Mozárbez', 37, 1, 209);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6746, 'Villar del Río', 42, 6, 209);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6747, 'Santa Eulalia', 44, 7, 209);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6748, 'Rafelguaraf', 46, 3, 209);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6749, 'Villalán de Campos', 47, 9, 209);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6750, 'San Vitero', 49, 8, 209);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6751, 'Pinseque', 50, 1, 209);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6752, 'San Juan de la Encinilla', 5, 2, 210);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6753, 'Sant Feliu de Codines', 8, 7, 210);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6754, 'Villamiel', 10, 4, 210);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6755, 'Ventalló', 17, 9, 210);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6756, 'Paredes de Sigüenza', 19, 8, 210);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6757, 'Villagatón', 24, 5, 210);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6758, 'Soses', 25, 8, 210);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6759, 'Roncal/Erronkari', 31, 7, 210);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6760, 'Villahán', 34, 3, 210);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6761, 'Urueñas', 40, 8, 210);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6762, 'Sarrión', 44, 1, 210);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6763, 'Ráfol de Salem', 46, 7, 210);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6764, 'Villalar de los Comuneros', 47, 3, 210);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6765, 'Sanzoles', 49, 2, 210);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6766, 'Pintanos, Los', 50, 5, 210);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6767, 'San Juan de la Nava', 5, 9, 211);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6768, 'Sant Feliu de Llobregat', 8, 4, 211);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6769, 'Melgar de Fernamental', 9, 7, 211);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6770, 'Villanueva de la Sierra', 10, 1, 211);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6771, 'Torrejoncillo del Rey', 16, 0, 211);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6772, 'Verges', 17, 6, 211);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6773, 'Pareja', 19, 5, 211);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6774, 'Villamandos', 24, 2, 211);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6775, 'Sudanell', 25, 5, 211);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6776, 'Orreaga/Roncesvalles', 31, 4, 211);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6777, 'Villaherreros', 34, 0, 211);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6778, 'Narros de Matalayegua', 37, 2, 211);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6779, 'Valdeprados', 40, 5, 211);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6780, 'Villares de Soria, Los', 42, 7, 211);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6781, 'Segura de los Baños', 44, 8, 211);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6782, 'Real de Gandía', 46, 4, 211);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6783, 'Villalba de la Loma', 47, 0, 211);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6784, 'Plasencia de Jalón', 50, 2, 211);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6785, 'San Juan del Molinillo', 5, 4, 212);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6786, 'Sant Feliu Sasserra', 8, 9, 212);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6787, 'Villanueva de la Vera', 10, 6, 212);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6788, 'Torrubia del Campo', 16, 5, 212);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6789, 'Vidrà', 17, 1, 212);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6790, 'Pastrana', 19, 0, 212);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6791, 'Santaliestra y San Quílez', 22, 6, 212);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6792, 'Villamañán', 24, 7, 212);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6793, 'Sunyer', 25, 0, 212);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6794, 'Sada', 31, 9, 212);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6795, 'Navacarros', 37, 7, 212);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6796, 'Valdevacas de Montejo', 40, 0, 212);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6797, 'Villasayas', 42, 2, 212);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6798, 'Seno', 44, 3, 212);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6799, 'Real', 46, 9, 212);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6800, 'Villalba de los Alcores', 47, 5, 212);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6801, 'Pleitas', 50, 7, 212);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6802, 'San Juan del Olmo', 5, 0, 213);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6803, 'Sant Fruitós de Bages', 8, 5, 213);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6804, 'Merindad de Cuesta-Urria', 9, 8, 213);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6805, 'Villar del Pedroso', 10, 2, 213);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6806, 'Torrubia del Castillo', 16, 1, 213);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6807, 'Vidreres', 17, 7, 213);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6808, 'Pedregal, El', 19, 6, 213);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6809, 'Sariñena', 22, 2, 213);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6810, 'Villamartín de Don Sancho', 24, 3, 213);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6811, 'Saldías', 31, 5, 213);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6812, 'Villalaco', 34, 1, 213);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6813, 'Nava de Béjar', 37, 3, 213);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6814, 'Valdevacas y Guijar', 40, 6, 213);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6815, 'Villaseca de Arciel', 42, 8, 213);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6816, 'Singra', 44, 9, 213);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6817, 'Requena', 46, 5, 213);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6818, 'Villalbarba', 47, 1, 213);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6819, 'Plenas', 50, 3, 213);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6820, 'San Lorenzo de Tormes', 5, 5, 214);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6821, 'Vilassar de Dalt', 8, 0, 214);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6822, 'Merindad de Montija', 9, 3, 214);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6823, 'Villar de Plasencia', 10, 7, 214);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6824, 'Vilabertran', 17, 2, 214);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6825, 'Peñalén', 19, 1, 214);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6826, 'Secastilla', 22, 7, 214);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6827, 'Villamejil', 24, 8, 214);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6828, 'Salinas de Oro/Jaitz', 31, 0, 214);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6829, 'Villalba de Guardo', 34, 6, 214);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6830, 'Nava de Francia', 37, 8, 214);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6831, 'Valseca', 40, 1, 214);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6832, 'Riba-roja de Túria', 46, 0, 214);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6833, 'Villalón de Campos', 47, 6, 214);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6834, 'Tábara', 49, 5, 214);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6835, 'Pomer', 50, 8, 214);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6836, 'San Martín de la Vega del Alberche', 5, 8, 215);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6837, 'Sant Hipòlit de Voltregà', 8, 3, 215);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6838, 'Merindad de Sotoscueva', 9, 6, 215);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6839, 'Villasbuenas de Gata', 10, 0, 215);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6840, 'Tragacete', 16, 9, 215);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6841, 'Vilablareix', 17, 5, 215);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6842, 'Peñalver', 19, 4, 215);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6843, 'Seira', 22, 0, 215);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6844, 'Villamol', 24, 1, 215);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6845, 'Talarn', 25, 4, 215);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6846, 'San Adrián', 31, 3, 215);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6847, 'Villalcázar de Sirga', 34, 9, 215);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6848, 'Nava de Sotrobal', 37, 1, 215);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6849, 'Valtiendas', 40, 4, 215);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6850, 'Vinuesa', 42, 6, 215);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6851, 'Terriente', 44, 7, 215);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6852, 'Riola', 46, 3, 215);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6853, 'Villamuriel de Campos', 47, 9, 215);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6854, 'Pozuel de Ariza', 50, 1, 215);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6855, 'San Martín del Pimpollar', 5, 1, 216);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6856, 'Sant Jaume de Frontanyà', 8, 6, 216);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6857, 'Merindad de Valdeporres', 9, 9, 216);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6858, 'Zarza de Granadilla', 10, 3, 216);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6859, 'Tresjuncos', 16, 2, 216);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6860, 'Viladasens', 17, 8, 216);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6861, 'Peralejos de las Truchas', 19, 7, 216);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6862, 'Villamontán de la Valduerna', 24, 4, 216);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6863, 'Talavera', 25, 7, 216);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6864, 'Sangüesa/Zangoza', 31, 6, 216);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6865, 'Villalcón', 34, 2, 216);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6866, 'Navales', 37, 4, 216);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6867, 'Valverde del Majano', 40, 7, 216);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6868, 'Vizmanos', 42, 9, 216);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6869, 'Teruel', 44, 0, 216);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6870, 'Rocafort', 46, 6, 216);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6871, 'Villán de Tordesillas', 47, 2, 216);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6872, 'Tapioles', 49, 1, 216);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6873, 'Pozuelo de Aragón', 50, 4, 216);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6874, 'San Miguel de Corneja', 5, 7, 217);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6875, 'Sant Joan Despí', 8, 2, 217);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6876, 'Merindad de Valdivielso', 9, 5, 217);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6877, 'Zarza de Montánchez', 10, 9, 217);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6878, 'Tribaldos', 16, 8, 217);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6879, 'Viladamat', 17, 4, 217);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6880, 'Peralveche', 19, 3, 217);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6881, 'Sena', 22, 9, 217);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6882, 'Villamoratiel de las Matas', 24, 0, 217);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6883, 'Tàrrega', 25, 3, 217);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6884, 'San Martín de Unx', 31, 2, 217);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6885, 'Villalobón', 34, 8, 217);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6886, 'Navalmoral de Béjar', 37, 0, 217);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6887, 'Vozmediano', 42, 5, 217);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6888, 'Toril y Masegoso', 44, 6, 217);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6889, 'Rotglà i Corberà', 46, 2, 217);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6890, 'Villanubla', 47, 8, 217);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6891, 'Pradilla de Ebro', 50, 0, 217);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6892, 'San Miguel de Serrezuela', 5, 3, 218);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6893, 'Sant Joan de Vilatorrada', 8, 8, 218);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6894, 'Milagros', 9, 1, 218);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6895, 'Zarza la Mayor', 10, 5, 218);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6896, 'Uclés', 16, 4, 218);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6897, 'Vilademuls', 17, 0, 218);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6898, 'Pinilla de Jadraque', 19, 9, 218);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6899, 'Senés de Alcubierre', 22, 5, 218);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6900, 'Villanueva de las Manzanas', 24, 6, 218);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6901, 'Tarrés', 25, 9, 218);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6902, 'Villaluenga de la Vega', 34, 4, 218);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6903, 'Navamorales', 37, 6, 218);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6904, 'Valle de Tabladillo', 40, 9, 218);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6905, 'Yanguas', 42, 1, 218);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6906, 'Tormón', 44, 2, 218);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6907, 'Rótova', 46, 8, 218);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6908, 'Villanueva de Duero', 47, 4, 218);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6909, 'Puebla de Albortón', 50, 6, 218);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6910, 'San Pascual', 5, 6, 219);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6911, 'Vilassar de Mar', 8, 1, 219);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6912, 'Miranda de Ebro', 9, 4, 219);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6913, 'Zorita', 10, 8, 219);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6914, 'Uña', 16, 7, 219);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6915, 'Pinilla de Molina', 19, 2, 219);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6916, 'Villaobispo de Otero', 24, 9, 219);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6917, 'Tarroja de Segarra', 25, 2, 219);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6918, 'Sansol', 31, 1, 219);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6919, 'Navarredonda de la Rinconada', 37, 9, 219);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6920, 'Vallelado', 40, 2, 219);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6921, 'Yelo', 42, 4, 219);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6922, 'Tornos', 44, 5, 219);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6923, 'Rugat', 46, 1, 219);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6924, 'Villanueva de la Condesa', 47, 7, 219);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6925, 'Toro', 49, 6, 219);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6926, 'Puebla de Alfindén, La', 50, 9, 219);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6927, 'San Pedro del Arroyo', 5, 0, 220);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6928, 'Sant Julià de Vilatorta', 8, 5, 220);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6929, 'Miraveche', 9, 8, 220);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6930, 'Viladrau', 17, 7, 220);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6931, 'Pioz', 19, 6, 220);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6932, 'Sesa', 22, 2, 220);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6933, 'Térmens', 25, 6, 220);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6934, 'Santacara', 31, 5, 220);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6935, 'Villamartín de Campos', 34, 1, 220);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6936, 'Valleruela de Pedraza', 40, 6, 220);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6937, 'Torralba de los Sisones', 44, 9, 220);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6938, 'Sagunto/Sagunt', 46, 5, 220);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6939, 'Villanueva de los Caballeros', 47, 1, 220);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6940, 'Torre del Valle, La', 49, 0, 220);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6941, 'Puendeluna', 50, 3, 220);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6942, 'Santa Cruz del Valle', 5, 7, 221);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6943, 'Sant Just Desvern', 8, 2, 221);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6944, 'Modúbar de la Emparedada', 9, 5, 221);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6945, 'Vilafant', 17, 4, 221);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6946, 'Piqueras', 19, 3, 221);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6947, 'Sesué', 22, 9, 221);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6948, 'Villaquejida', 24, 0, 221);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6949, 'Tírvia', 25, 3, 221);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6950, 'Doneztebe/Santesteban', 31, 2, 221);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6951, 'Villamediana', 34, 8, 221);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6952, 'Navasfrías', 37, 0, 221);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6953, 'Valleruela de Sepúlveda', 40, 3, 221);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6954, 'Torrecilla de Alcañiz', 44, 6, 221);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6955, 'Salem', 46, 2, 221);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6956, 'Villanueva de los Infantes', 47, 8, 221);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6957, 'Torregamones', 49, 7, 221);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6958, 'Purujosa', 50, 0, 221);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6959, 'Santa Cruz de Pinares', 5, 2, 222);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6960, 'Sant Llorenç d''Hortons', 8, 7, 222);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6961, 'Vilaür', 17, 9, 222);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6962, 'Pobo de Dueñas, El', 19, 8, 222);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6963, 'Siétamo', 22, 4, 222);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6964, 'Villaquilambre', 24, 5, 222);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6965, 'Tiurana', 25, 8, 222);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6966, 'Sarriés/Sartze', 31, 7, 222);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6967, 'Villameriel', 34, 3, 222);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6968, 'Negrilla de Palencia', 37, 5, 222);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6969, 'Veganzones', 40, 8, 222);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6970, 'Torrecilla del Rebollar', 44, 1, 222);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6971, 'Sant Joanet', 46, 7, 222);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6972, 'Villanueva de San Mancio', 47, 3, 222);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6973, 'Torres del Carrizal', 49, 2, 222);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6974, 'Quinto', 50, 5, 222);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6975, 'Sant Llorenç Savall', 8, 3, 223);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6976, 'Monasterio de la Sierra', 9, 6, 223);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6977, 'Vilajuïga', 17, 5, 223);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6978, 'Poveda de la Sierra', 19, 4, 223);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6979, 'Sopeira', 22, 0, 223);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6980, 'Villarejo de Órbigo', 24, 1, 223);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6981, 'Torà', 25, 4, 223);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6982, 'Sartaguda', 31, 3, 223);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6983, 'Villamoronta', 34, 9, 223);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6984, 'Olmedo de Camaces', 37, 1, 223);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6985, 'Vegas de Matute', 40, 4, 223);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6986, 'Torre de Arcas', 44, 7, 223);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6987, 'Sedaví', 46, 3, 223);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6988, 'Villardefrades', 47, 9, 223);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6989, 'Trabazos', 49, 8, 223);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6990, 'Remolinos', 50, 1, 223);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6991, 'Santa María del Arroyo', 5, 3, 224);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6992, 'Sant Martí de Centelles', 8, 8, 224);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6993, 'Monasterio de Rodilla', 9, 1, 224);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6994, 'Valdemeca', 16, 4, 224);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6995, 'Vilallonga de Ter', 17, 0, 224);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6996, 'Pozo de Almoguera', 19, 9, 224);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6997, 'Villares de Órbigo', 24, 6, 224);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6998, 'Torms, Els', 25, 9, 224);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (6999, 'Sesma', 31, 8, 224);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7000, 'Villamuera de la Cueza', 34, 4, 224);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7001, 'Orbada, La', 37, 6, 224);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7002, 'Ventosilla y Tejadilla', 40, 9, 224);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7003, 'Torre de las Arcas', 44, 2, 224);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7004, 'Segart', 46, 8, 224);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7005, 'Villarmentero de Esgueva', 47, 4, 224);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7006, 'Trefacio', 49, 3, 224);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7007, 'Retascón', 50, 6, 224);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7008, 'Santa María del Berrocal', 5, 6, 225);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7009, 'Sant Martí d''Albars', 8, 1, 225);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7010, 'Moncalvillo', 9, 4, 225);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7011, 'Valdemorillo de la Sierra', 16, 7, 225);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7012, 'Vilamacolum', 17, 3, 225);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7013, 'Pozo de Guadalajara', 19, 2, 225);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7014, 'Tamarite de Litera', 22, 8, 225);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7015, 'Villasabariego', 24, 9, 225);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7016, 'Tornabous', 25, 2, 225);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7017, 'Sorlada', 31, 1, 225);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7018, 'Villamuriel de Cerrato', 34, 7, 225);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7019, 'Pajares de la Laguna', 37, 9, 225);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7020, 'Villacastín', 40, 2, 225);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7021, 'Torre del Compte', 44, 5, 225);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7022, 'Sellent', 46, 1, 225);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7023, 'Villasexmir', 47, 7, 225);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7024, 'Uña de Quintana', 49, 6, 225);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7025, 'Ricla', 50, 9, 225);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7026, 'Santa María de los Caballeros', 5, 9, 226);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7027, 'Sant Martí de Tous', 8, 4, 226);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7028, 'Monterrubio de la Demanda', 9, 7, 226);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7029, 'Vilamalla', 17, 6, 226);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7030, 'Prádena de Atienza', 19, 5, 226);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7031, 'Tardienta', 22, 1, 226);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7032, 'Villaselán', 24, 2, 226);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7033, 'Torrebesses', 25, 5, 226);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7034, 'Sunbilla', 31, 4, 226);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7035, 'Palacios del Arzobispo', 37, 2, 226);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7036, 'Torrelacárcel', 44, 8, 226);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7037, 'Sempere', 46, 4, 226);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7038, 'Villavaquerín', 47, 0, 226);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7039, 'Vadillo de la Guareña', 49, 9, 226);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7040, 'Santa María del Tiétar', 5, 5, 227);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7041, 'Sant Martí Sarroca', 8, 0, 227);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7042, 'Montorio', 9, 3, 227);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7043, 'Valdemoro-Sierra', 16, 6, 227);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7044, 'Vilamaniscle', 17, 2, 227);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7045, 'Prados Redondos', 19, 1, 227);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7046, 'Tella-Sin', 22, 7, 227);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7047, 'Villaturiel', 24, 8, 227);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7048, 'Torre de Cabdella, La', 25, 1, 227);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7049, 'Tafalla', 31, 0, 227);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7050, 'Villanueva del Rebollar', 34, 6, 227);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7051, 'Torre los Negros', 44, 4, 227);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7052, 'Senyera', 46, 0, 227);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7053, 'Villavellid', 47, 6, 227);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7054, 'Valcabado', 49, 5, 227);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7055, 'Romanos', 50, 8, 227);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7056, 'Santiago del Collado', 5, 1, 228);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7057, 'Sant Martí Sesgueioles', 8, 6, 228);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7058, 'Moradillo de Roa', 9, 9, 228);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7059, 'Valdeolivas', 16, 2, 228);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7060, 'Vilanant', 17, 8, 228);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7061, 'Puebla de Beleña', 19, 7, 228);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7062, 'Tierz', 22, 3, 228);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7063, 'Villazala', 24, 4, 228);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7064, 'Torrefarrera', 25, 7, 228);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7065, 'Tiebas-Muruarte de Reta', 31, 6, 228);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7066, 'Villanuño de Valdavia', 34, 2, 228);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7067, 'Palaciosrubios', 37, 4, 228);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7068, 'Villaverde de Íscar', 40, 7, 228);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7069, 'Torremocha de Jiloca', 44, 0, 228);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7070, 'Serra', 46, 6, 228);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7071, 'Villaverde de Medina', 47, 2, 228);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7072, 'Valdefinjas', 49, 1, 228);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7073, 'Rueda de Jalón', 50, 4, 228);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7074, 'Santo Domingo de las Posadas', 5, 4, 229);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7075, 'Sant Mateu de Bages', 8, 9, 229);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7076, 'Nava de Roa', 9, 2, 229);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7077, 'Puebla de Valles', 19, 0, 229);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7078, 'Tolva', 22, 6, 229);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7079, 'Villazanzo de Valderaduey', 24, 7, 229);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7080, 'Tirapu', 31, 9, 229);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7081, 'Villaprovedo', 34, 5, 229);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7082, 'Palencia de Negrilla', 37, 7, 229);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7083, 'Villaverde de Montejo', 40, 0, 229);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7084, 'Torres de Albarracín', 44, 3, 229);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7085, 'Siete Aguas', 46, 9, 229);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7086, 'Villavicencio de los Caballeros', 47, 5, 229);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7087, 'Valdescorriel', 49, 4, 229);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7088, 'Ruesca', 50, 7, 229);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7089, 'Santo Tomé de Zabarcos', 5, 8, 230);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7090, 'Premià de Dalt', 8, 3, 230);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7091, 'Navas de Bureba', 9, 6, 230);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7092, 'Vila-sacra', 17, 5, 230);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7093, 'Quer', 19, 4, 230);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7094, 'Torla', 22, 0, 230);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7095, 'Zotes del Páramo', 24, 1, 230);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7096, 'Torregrossa', 25, 4, 230);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7097, 'Torralba del Río', 31, 3, 230);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7098, 'Villarmentero de Campos', 34, 9, 230);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7099, 'Parada de Arriba', 37, 1, 230);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7100, 'Villeguillo', 40, 4, 230);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7101, 'Torrevelilla', 44, 7, 230);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7102, 'Silla', 46, 3, 230);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7103, 'Wamba', 47, 9, 230);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7104, 'Vallesa de la Guareña', 49, 8, 230);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7105, 'Sádaba', 50, 1, 230);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7106, 'San Vicente de Arévalo', 5, 5, 231);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7107, 'Sant Pere de Ribes', 8, 0, 231);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7108, 'Nebreda', 9, 3, 231);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7109, 'Valhermoso de la Fuente', 16, 6, 231);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7110, 'Rebollosa de Jadraque', 19, 1, 231);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7111, 'Torrelameu', 25, 1, 231);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7112, 'Torres del Río', 31, 0, 231);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7113, 'Villarrabé', 34, 6, 231);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7114, 'Parada de Rubiales', 37, 8, 231);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7115, 'Yanguas de Eresma', 40, 1, 231);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7116, 'Torrijas', 44, 4, 231);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7117, 'Simat de la Valldigna', 46, 0, 231);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7118, 'Zaratán', 47, 6, 231);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7119, 'Vega de Tera', 49, 5, 231);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7120, 'Salillas de Jalón', 50, 8, 231);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7121, 'Serrada, La', 5, 0, 232);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7122, 'Sant Pere de Riudebitlles', 8, 5, 232);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7123, 'Neila', 9, 8, 232);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7124, 'Vilopriu', 17, 7, 232);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7125, 'Recuenco, El', 19, 6, 232);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7126, 'Torralba de Aragón', 22, 2, 232);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7127, 'Torres de Segre', 25, 6, 232);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7128, 'Tudela', 31, 5, 232);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7129, 'Villarramiel', 34, 1, 232);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7130, 'Paradinas de San Juan', 37, 3, 232);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7131, 'Torrijo del Campo', 44, 9, 232);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7132, 'Sinarcas', 46, 5, 232);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7133, 'Zarza, La', 47, 1, 232);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7134, 'Vega de Villalobos', 49, 0, 232);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7135, 'Salvatierra de Esca', 50, 3, 232);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7136, 'Serranillos', 5, 6, 233);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7137, 'Sant Pere de Torelló', 8, 1, 233);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7138, 'Vilobí d''Onyar', 17, 3, 233);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7139, 'Renera', 19, 2, 233);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7140, 'Torre la Ribera', 22, 8, 233);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7141, 'Torre-serona', 25, 2, 233);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7142, 'Tulebras', 31, 1, 233);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7143, 'Villasarracino', 34, 7, 233);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7144, 'Pastores', 37, 9, 233);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7145, 'Zarzuela del Monte', 40, 2, 233);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7146, 'Sollana', 46, 1, 233);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7147, 'Vegalatrave', 49, 6, 233);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7148, 'Samper del Salz', 50, 9, 233);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7149, 'Sigeres', 5, 1, 234);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7150, 'Sant Pere de Vilamajor', 8, 6, 234);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7151, 'Valsalobre', 16, 2, 234);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7152, 'Biure', 17, 8, 234);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7153, 'Retiendas', 19, 7, 234);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7154, 'Torrente de Cinca', 22, 3, 234);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7155, 'Tremp', 25, 7, 234);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7156, 'Ucar', 31, 6, 234);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7157, 'Villasila de Valdavia', 34, 2, 234);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7158, 'Payo, El', 37, 4, 234);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7159, 'Zarzuela del Pinar', 40, 7, 234);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7160, 'Tramacastiel', 44, 0, 234);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7161, 'Sot de Chera', 46, 6, 234);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7162, 'Venialbo', 49, 1, 234);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7163, 'San Martín de la Virgen de Moncayo', 50, 4, 234);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7164, 'Sinlabajos', 5, 4, 235);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7165, 'Sant Pol de Mar', 8, 9, 235);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7166, 'Olmedillo de Roa', 9, 2, 235);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7167, 'Riba de Saelices', 19, 0, 235);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7168, 'Torres de Alcanadre', 22, 6, 235);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7169, 'Ujué', 31, 9, 235);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7170, 'Pedraza de Alba', 37, 7, 235);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7171, 'Tramacastilla', 44, 3, 235);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7172, 'Sueca', 46, 9, 235);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7173, 'Vezdemarbán', 49, 4, 235);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7174, 'San Mateo de Gállego', 50, 7, 235);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7175, 'Solana de Ávila', 5, 7, 236);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7176, 'Sant Quintí de Mediona', 8, 2, 236);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7177, 'Olmillos de Muñó', 9, 5, 236);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7178, 'Valverde de Júcar', 16, 8, 236);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7179, 'Torres de Barbués', 22, 9, 236);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7180, 'Ultzama', 31, 2, 236);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7181, 'Villaturde', 34, 8, 236);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7182, 'Pedrosillo de Alba', 37, 0, 236);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7183, 'Tronchón', 44, 6, 236);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7184, 'Sumacàrcer', 46, 2, 236);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7185, 'Vidayanes', 49, 7, 236);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7186, 'Santa Cruz de Grío', 50, 0, 236);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7187, 'Solana de Rioalmar', 5, 3, 237);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7188, 'Sant Quirze de Besora', 8, 8, 237);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7189, 'Valverdejo', 16, 4, 237);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7190, 'Rillo de Gallo', 19, 9, 237);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7191, 'Unciti', 31, 8, 237);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7192, 'Villaumbrales', 34, 4, 237);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7193, 'Pedrosillo de los Aires', 37, 6, 237);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7194, 'Urrea de Gaén', 44, 2, 237);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7195, 'Tavernes Blanques', 46, 8, 237);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7196, 'Videmala', 49, 3, 237);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7197, 'Santa Cruz de Moncayo', 50, 6, 237);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7198, 'Solosancho', 5, 9, 238);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7199, 'Sant Quirze del Vallès', 8, 4, 238);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7200, 'Oña', 9, 7, 238);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7201, 'Vara de Rey', 16, 0, 238);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7202, 'Riofrío del Llano', 19, 5, 238);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7203, 'Vallbona de les Monges', 25, 5, 238);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7204, 'Unzué/Untzue', 31, 4, 238);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7205, 'Villaviudas', 34, 0, 238);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7206, 'Pedrosillo el Ralo', 37, 2, 238);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7207, 'Utrillas', 44, 8, 238);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7208, 'Tavernes de la Valldigna', 46, 4, 238);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7209, 'Villabrázaro', 49, 9, 238);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7210, 'Santa Eulalia de Gállego', 50, 2, 238);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7211, 'Sotalbo', 5, 2, 239);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7212, 'Sant Quirze Safaja', 8, 7, 239);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7213, 'Oquillas', 9, 0, 239);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7214, 'Vega del Codorno', 16, 3, 239);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7215, 'Robledillo de Mohernando', 19, 8, 239);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7216, 'Tramaced', 22, 4, 239);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7217, 'Valls de Valira, Les', 25, 8, 239);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7218, 'Urdazubi/Urdax', 31, 7, 239);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7219, 'Pedroso de la Armuña, El', 37, 5, 239);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7220, 'Valacloche', 44, 1, 239);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7221, 'Teresa de Cofrentes', 46, 7, 239);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7222, 'Villabuena del Puente', 49, 2, 239);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7223, 'Santed', 50, 5, 239);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7224, 'Sotillo de la Adrada', 5, 6, 240);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7225, 'Sant Sadurní d''Anoia', 8, 1, 240);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7226, 'Vellisca', 16, 7, 240);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7227, 'Robledo de Corpes', 19, 2, 240);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7228, 'Vallfogona de Balaguer', 25, 2, 240);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7229, 'Urdiain', 31, 1, 240);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7230, 'Villerías de Campos', 34, 7, 240);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7231, 'Pelabravo', 37, 9, 240);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7232, 'Valbona', 44, 5, 240);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7233, 'Terrateig', 46, 1, 240);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7234, 'Villadepera', 49, 6, 240);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7235, 'Sástago', 50, 9, 240);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7236, 'Tiemblo, El', 5, 3, 241);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7237, 'Sant Sadurní d''Osormort', 8, 8, 241);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7238, 'Orbaneja Riopico', 9, 1, 241);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7239, 'Romanillos de Atienza', 19, 9, 241);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7240, 'Urraul Alto', 31, 8, 241);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7241, 'Villodre', 34, 4, 241);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7242, 'Pelarrodríguez', 37, 6, 241);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7243, 'Valdealgorfa', 44, 2, 241);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7244, 'Titaguas', 46, 8, 241);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7245, 'Villaescusa', 49, 3, 241);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7246, 'Sabiñán', 50, 6, 241);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7247, 'Tiñosillos', 5, 8, 242);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7248, 'Marganell', 8, 3, 242);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7249, 'Padilla de Abajo', 9, 6, 242);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7250, 'Villaconejos de Trabaque', 16, 9, 242);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7251, 'Romanones', 19, 4, 242);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7252, 'Valfarta', 22, 0, 242);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7253, 'Verdú', 25, 4, 242);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7254, 'Urraul Bajo', 31, 3, 242);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7255, 'Villodrigo', 34, 9, 242);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7256, 'Pelayos', 37, 1, 242);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7257, 'Torrebaja', 46, 3, 242);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7258, 'Villafáfila', 49, 8, 242);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7259, 'Sediles', 50, 1, 242);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7260, 'Tolbaños', 5, 4, 243);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7261, 'Santa Cecília de Voltregà', 8, 9, 243);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7262, 'Padilla de Arriba', 9, 2, 243);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7263, 'Villaescusa de Haro', 16, 5, 243);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7264, 'Rueda de la Sierra', 19, 0, 243);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7265, 'Valle de Bardají', 22, 6, 243);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7266, 'Vielha e Mijaran', 25, 0, 243);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7267, 'Urroz-Villa', 31, 9, 243);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7268, 'Villoldo', 34, 5, 243);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7269, 'Peña, La', 37, 7, 243);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7270, 'Valdecuenca', 44, 3, 243);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7271, 'Torrella', 46, 9, 243);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7272, 'Villaferrueña', 49, 4, 243);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7273, 'Sestrica', 50, 7, 243);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7274, 'Tormellas', 5, 9, 244);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7275, 'Santa Coloma de Cervelló', 8, 4, 244);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7276, 'Padrones de Bureba', 9, 7, 244);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7277, 'Villagarcía del Llano', 16, 0, 244);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7278, 'Sacecorbo', 19, 5, 244);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7279, 'Valle de Lierp', 22, 1, 244);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7280, 'Vilagrassa', 25, 5, 244);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7281, 'Urrotz', 31, 4, 244);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7282, 'Peñacaballera', 37, 2, 244);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7283, 'Valdelinares', 44, 8, 244);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7284, 'Torrent', 46, 4, 244);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7285, 'Villageriz', 49, 9, 244);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7286, 'Sierra de Luna', 50, 2, 244);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7287, 'Tornadizos de Ávila', 5, 2, 245);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7288, 'Santa Coloma de Gramenet', 8, 7, 245);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7289, 'Villalba de la Sierra', 16, 3, 245);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7290, 'Sacedón', 19, 8, 245);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7291, 'Velilla de Cinca', 22, 4, 245);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7292, 'Vilaller', 25, 8, 245);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7293, 'Urzainqui/Urzainki', 31, 7, 245);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7294, 'Villota del Páramo', 34, 3, 245);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7295, 'Peñaparda', 37, 5, 245);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7296, 'Valdeltormo', 44, 1, 245);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7297, 'Torres Torres', 46, 7, 245);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7298, 'Villalazán', 49, 2, 245);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7299, 'Sigüés', 50, 5, 245);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7300, 'Tórtoles', 5, 5, 246);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7301, 'Santa Eugènia de Berga', 8, 0, 246);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7302, 'Palacios de la Sierra', 9, 3, 246);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7303, 'Villalba del Rey', 16, 6, 246);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7304, 'Saelices de la Sal', 19, 1, 246);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7305, 'Beranuy', 22, 7, 246);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7306, 'Uterga', 31, 0, 246);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7307, 'Villovieco', 34, 6, 246);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7308, 'Peñaranda de Bracamonte', 37, 8, 246);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7309, 'Valderrobres', 44, 4, 246);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7310, 'Tous', 46, 0, 246);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7311, 'Villalba de la Lampreana', 49, 5, 246);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7312, 'Sisamón', 50, 8, 246);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7313, 'Torre, La', 5, 1, 247);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7314, 'Santa Eulàlia de Riuprimer', 8, 6, 247);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7315, 'Palacios de Riopisuerga', 9, 9, 247);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7316, 'Villalgordo del Marquesado', 16, 2, 247);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7317, 'Salmerón', 19, 7, 247);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7318, 'Viacamp y Litera', 22, 3, 247);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7319, 'Vilamòs', 25, 7, 247);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7320, 'Uztárroz/Uztarroze', 31, 6, 247);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7321, 'Peñarandilla', 37, 4, 247);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7322, 'Valjunquera', 44, 0, 247);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7323, 'Tuéjar', 46, 6, 247);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7324, 'Villalcampo', 49, 1, 247);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7325, 'Sobradiel', 50, 4, 247);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7326, 'Santa Eulàlia de Ronçana', 8, 2, 248);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7327, 'Palazuelos de la Sierra', 9, 5, 248);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7328, 'Villalpardo', 16, 8, 248);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7329, 'San Andrés del Congosto', 19, 3, 248);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7330, 'Vicién', 22, 9, 248);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7331, 'Vilanova de Bellpuig', 25, 3, 248);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7332, 'Luzaide/Valcarlos', 31, 2, 248);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7333, 'Peralejos de Abajo', 37, 0, 248);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7334, 'Turís', 46, 2, 248);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7335, 'Villalobos', 49, 7, 248);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7336, 'Sos del Rey Católico', 50, 0, 248);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7337, 'Umbrías', 5, 0, 249);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7338, 'Santa Fe del Penedès', 8, 5, 249);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7339, 'Palazuelos de Muñó', 9, 8, 249);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7340, 'Villamayor de Santiago', 16, 1, 249);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7341, 'San Andrés del Rey', 19, 6, 249);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7342, 'Villanova', 22, 2, 249);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7343, 'Vilanova de l''Aguda', 25, 6, 249);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7344, 'Valtierra', 31, 5, 249);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7345, 'Peralejos de Arriba', 37, 3, 249);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7346, 'Vallecillo, El', 44, 9, 249);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7347, 'Utiel', 46, 5, 249);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7348, 'Villalonso', 49, 0, 249);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7349, 'Tabuenca', 50, 3, 249);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7350, 'Santa Margarida de Montbui', 8, 8, 250);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7351, 'Pampliega', 9, 1, 250);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7352, 'Villanueva de Guadamejud', 16, 4, 250);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7353, 'Santiuste', 19, 9, 250);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7354, 'Villanúa', 22, 5, 250);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7355, 'Vilanova de Meià', 25, 9, 250);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7356, 'Bera', 31, 8, 250);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7357, 'Pereña de la Ribera', 37, 6, 250);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7358, 'Veguillas de la Sierra', 44, 2, 250);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7359, 'Valencia', 46, 8, 250);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7360, 'Villalpando', 49, 3, 250);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7361, 'Talamantes', 50, 6, 250);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7362, 'Vadillo de la Sierra', 5, 0, 251);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7363, 'Santa Margarida i els Monjos', 8, 5, 251);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7364, 'Pancorbo', 9, 8, 251);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7365, 'Villanueva de la Jara', 16, 1, 251);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7366, 'Saúca', 19, 6, 251);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7367, 'Villanueva de Sigena', 22, 2, 251);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7368, 'Vilanova de Segrià', 25, 6, 251);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7369, 'Viana', 31, 5, 251);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7370, 'Peromingo', 37, 3, 251);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7371, 'Villafranca del Campo', 44, 9, 251);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7372, 'Vallada', 46, 5, 251);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7373, 'Villalube', 49, 0, 251);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7374, 'Tarazona', 50, 3, 251);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7375, 'Valdecasa', 5, 5, 252);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7376, 'Barberà del Vallès', 8, 0, 252);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7377, 'Sayatón', 19, 1, 252);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7378, 'Yebra de Basa', 22, 7, 252);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7379, 'Vila-sana', 25, 1, 252);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7380, 'Vidángoz/Bidankoze', 31, 0, 252);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7381, 'Pinedas', 37, 8, 252);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7382, 'Villahermosa del Campo', 44, 4, 252);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7383, 'Vallanca', 46, 0, 252);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7384, 'Villamayor de Campos', 49, 5, 252);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7385, 'Tauste', 50, 8, 252);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7386, 'Vega de Santa María', 5, 1, 253);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7387, 'Santa Maria de Besora', 8, 6, 253);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7388, 'Pardilla', 9, 9, 253);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7389, 'Villar de Cañas', 16, 2, 253);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7390, 'Yésero', 22, 3, 253);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7391, 'Vilosell, El', 25, 7, 253);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7392, 'Bidaurreta', 31, 6, 253);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7393, 'Pino de Tormes, El', 37, 4, 253);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7394, 'Vallés', 46, 6, 253);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7395, 'Terrer', 50, 4, 253);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7396, 'Velayos', 5, 6, 254);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7397, 'Santa Maria de Corcó', 8, 1, 254);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7398, 'Villar de Domingo García', 16, 7, 254);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7399, 'Selas', 19, 2, 254);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7400, 'Zaidín', 22, 8, 254);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7401, 'Vilanova de la Barca', 25, 2, 254);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7402, 'Villafranca', 31, 1, 254);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7403, 'Pitiegua', 37, 9, 254);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7404, 'Venta del Moro', 46, 1, 254);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7405, 'Tierga', 50, 9, 254);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7406, 'Santa Maria de Merlès', 8, 4, 255);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7407, 'Partido de la Sierra en Tobalina', 9, 7, 255);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7408, 'Villar de la Encina', 16, 0, 255);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7409, 'Setiles', 19, 5, 255);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7410, 'Vinaixa', 25, 5, 255);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7411, 'Villamayor de Monjardín', 31, 4, 255);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7412, 'Pizarral', 37, 2, 255);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7413, 'Villalonga', 46, 4, 255);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7414, 'Villamor de los Escuderos', 49, 9, 255);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7415, 'Tobed', 50, 2, 255);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7416, 'Villaflor', 5, 2, 256);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7417, 'Santa Maria de Martorelles', 8, 7, 256);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7418, 'Pedrosa de Duero', 9, 0, 256);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7419, 'Sienes', 19, 8, 256);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7420, 'Hiriberri/Villanueva de Aezkoa', 31, 7, 256);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7421, 'Poveda de las Cintas', 37, 5, 256);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7422, 'Villanueva del Rebollar de la Sierra', 44, 1, 256);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7423, 'Vilamarxant', 46, 7, 256);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7424, 'Villanázar', 49, 2, 256);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7425, 'Torralba de los Frailes', 50, 5, 256);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7426, 'Villafranca de la Sierra', 5, 8, 257);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7427, 'Santa Maria de Miralles', 8, 3, 257);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7428, 'Pedrosa del Páramo', 9, 6, 257);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7429, 'Sigüenza', 19, 4, 257);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7430, 'Villatuerta', 31, 3, 257);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7431, 'Pozos de Hinojo', 37, 1, 257);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7432, 'Villar del Cobo', 44, 7, 257);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7433, 'Villanueva de Castellón', 46, 3, 257);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7434, 'Villanueva de Azoague', 49, 8, 257);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7435, 'Torralba de Ribota', 50, 1, 257);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7436, 'Villanueva de Gómez', 5, 4, 258);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7437, 'Santa Maria d''Oló', 8, 9, 258);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7438, 'Pedrosa del Príncipe', 9, 2, 258);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7439, 'Villar del Humo', 16, 5, 258);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7440, 'Solanillos del Extremo', 19, 0, 258);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7441, 'Villava/Atarrabia', 31, 9, 258);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7442, 'Puebla de Azaba', 37, 7, 258);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7443, 'Villar del Salz', 44, 3, 258);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7444, 'Villar del Arzobispo', 46, 9, 258);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7445, 'Villanueva de Campeán', 49, 4, 258);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7446, 'Torralbilla', 50, 7, 258);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7447, 'Villanueva del Aceral', 5, 7, 259);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7448, 'Santa Maria de Palautordera', 8, 2, 259);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7449, 'Pedrosa de Río Úrbel', 9, 5, 259);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7450, 'Villar del Infantado', 16, 8, 259);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7451, 'Somolinos', 19, 3, 259);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7452, 'Igantzi', 31, 2, 259);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7453, 'Puebla de San Medel', 37, 0, 259);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7454, 'Villargordo del Cabriel', 46, 2, 259);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7455, 'Villanueva de las Peras', 49, 7, 259);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7456, 'Torrehermosa', 50, 0, 259);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7457, 'Villanueva del Campillo', 5, 1, 260);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7458, 'Santa Perpètua de Mogoda', 8, 6, 260);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7459, 'Sotillo, El', 19, 7, 260);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7460, 'Valle de Yerri/Deierri', 31, 6, 260);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7461, 'Puebla de Yeltes', 37, 4, 260);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7462, 'Villarluengo', 44, 0, 260);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7463, 'Vinalesa', 46, 6, 260);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7464, 'Villanueva del Campo', 49, 1, 260);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7465, 'Torrelapaja', 50, 4, 260);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7466, 'Villar de Corneja', 5, 8, 261);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7467, 'Santa Susanna', 8, 3, 261);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7468, 'Peñaranda de Duero', 9, 6, 261);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7469, 'Sotodosos', 19, 4, 261);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7470, 'Yesa', 31, 3, 261);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7471, 'Puente del Congosto', 37, 1, 261);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7472, 'Villarquemado', 44, 7, 261);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7473, 'Yátova', 46, 3, 261);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7474, 'Villaralbo', 49, 8, 261);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7475, 'Torrellas', 50, 1, 261);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7476, 'Villarejo del Valle', 5, 3, 262);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7477, 'Sant Vicenç de Castellet', 8, 8, 262);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7478, 'Peral de Arlanza', 9, 1, 262);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7479, 'Tamajón', 19, 9, 262);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7480, 'Zabalza/Zabaltza', 31, 8, 262);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7481, 'Puertas', 37, 6, 262);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7482, 'Villarroya de los Pinares', 44, 2, 262);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7483, 'Yesa, La', 46, 8, 262);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7484, 'Villardeciervos', 49, 3, 262);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7485, 'Torres de Berrellén', 50, 6, 262);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7486, 'Villatoro', 5, 9, 263);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7487, 'Sant Vicenç dels Horts', 8, 4, 263);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7488, 'Villar de Olalla', 16, 0, 263);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7489, 'Taragudo', 19, 5, 263);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7490, 'Zubieta', 31, 4, 263);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7491, 'Puerto de Béjar', 37, 2, 263);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7492, 'Villastar', 44, 8, 263);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7493, 'Zarra', 46, 4, 263);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7494, 'Villar de Fallaves', 49, 9, 263);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7495, 'Torrijo de la Cañada', 50, 2, 263);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7496, 'Viñegra de Moraña', 5, 4, 264);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7497, 'Sant Vicenç de Montalt', 8, 9, 264);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7498, 'Villarejo de Fuentes', 16, 5, 264);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7499, 'Taravilla', 19, 0, 264);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7500, 'Zugarramurdi', 31, 9, 264);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7501, 'Puerto Seguro', 37, 7, 264);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7502, 'Villel', 44, 3, 264);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7503, 'Villar del Buey', 49, 4, 264);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7504, 'Tosos', 50, 7, 264);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7505, 'Vita', 5, 7, 265);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7506, 'Sant Vicenç de Torelló', 8, 2, 265);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7507, 'Piérnigas', 9, 5, 265);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7508, 'Villarejo de la Peñuela', 16, 8, 265);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7509, 'Tartanedo', 19, 3, 265);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7510, 'Zúñiga', 31, 2, 265);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7511, 'Rágama', 37, 0, 265);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7512, 'Vinaceite', 44, 6, 265);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7513, 'Villardiegua de la Ribera', 49, 7, 265);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7514, 'Trasmoz', 50, 0, 265);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7515, 'Zapardiel de la Cañada', 5, 0, 266);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7516, 'Cerdanyola del Vallès', 8, 5, 266);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7517, 'Pineda de la Sierra', 9, 8, 266);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7518, 'Villarejo-Periesteban', 16, 1, 266);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7519, 'Tendilla', 19, 6, 266);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7520, 'Redonda, La', 37, 3, 266);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7521, 'Visiedo', 44, 9, 266);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7522, 'Villárdiga', 49, 0, 266);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7523, 'Trasobares', 50, 3, 266);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7524, 'Zapardiel de la Ribera', 5, 6, 267);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7525, 'Sentmenat', 8, 1, 267);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7526, 'Pineda Trasmonte', 9, 4, 267);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7527, 'Terzaga', 19, 2, 267);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7528, 'Retortillo', 37, 9, 267);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7529, 'Vivel del Río Martín', 44, 5, 267);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7530, 'Villardondiego', 49, 6, 267);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7531, 'Uncastillo', 50, 9, 267);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7532, 'Cercs', 8, 7, 268);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7533, 'Pinilla de los Barruecos', 9, 0, 268);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7534, 'Tierzo', 19, 8, 268);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7535, 'Rinconada de la Sierra, La', 37, 5, 268);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7536, 'Zoma, La', 44, 1, 268);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7537, 'Villarrín de Campos', 49, 2, 268);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7538, 'Undués de Lerda', 50, 5, 268);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7539, 'Seva', 8, 0, 269);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7540, 'Pinilla de los Moros', 9, 3, 269);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7541, 'Villares del Saz', 16, 6, 269);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7542, 'Toba, La', 19, 1, 269);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7543, 'Robleda', 37, 8, 269);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7544, 'Villaseco del Pan', 49, 5, 269);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7545, 'Urrea de Jalón', 50, 8, 269);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7546, 'Sitges', 8, 4, 270);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7547, 'Pinilla Trasmonte', 9, 7, 270);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7548, 'Villarrubio', 16, 0, 270);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7549, 'Tordelrábano', 19, 5, 270);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7550, 'Robliza de Cojos', 37, 2, 270);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7551, 'Villavendimio', 49, 9, 270);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7552, 'Urriés', 50, 2, 270);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7553, 'Sobremunt', 8, 1, 271);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7554, 'Villarta', 16, 7, 271);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7555, 'Tordellego', 19, 2, 271);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7556, 'Rollán', 37, 9, 271);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7557, 'Villaveza del Agua', 49, 6, 271);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7558, 'Used', 50, 9, 271);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7559, 'Sora', 8, 6, 272);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7560, 'Poza de la Sal', 9, 9, 272);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7561, 'Villas de la Ventosa', 16, 2, 272);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7562, 'Tordesilos', 19, 7, 272);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7563, 'Saelices el Chico', 37, 4, 272);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7564, 'Villaveza de Valverde', 49, 1, 272);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7565, 'Utebo', 50, 4, 272);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7566, 'Subirats', 8, 2, 273);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7567, 'Prádanos de Bureba', 9, 5, 273);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7568, 'Villaverde y Pasaconsol', 16, 8, 273);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7569, 'Sagrada, La', 37, 0, 273);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7570, 'Viñas', 49, 7, 273);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7571, 'Valdehorna', 50, 0, 273);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7572, 'Súria', 8, 7, 274);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7573, 'Pradoluengo', 9, 0, 274);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7574, 'Víllora', 16, 3, 274);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7575, 'Torija', 19, 8, 274);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7576, 'Salamanca', 37, 5, 274);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7577, 'Val de San Martín', 50, 5, 274);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7578, 'Tavèrnoles', 8, 0, 275);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7579, 'Presencio', 9, 3, 275);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7580, 'Vindel', 16, 6, 275);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7581, 'Saldeana', 37, 8, 275);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7582, 'Zamora', 49, 5, 275);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7583, 'Valmadrid', 50, 8, 275);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7584, 'Tagamanent', 8, 3, 276);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7585, 'Puebla de Arganzón, La', 9, 6, 276);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7586, 'Yémeda', 16, 9, 276);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7587, 'Salmoral', 37, 1, 276);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7588, 'Valpalmas', 50, 1, 276);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7589, 'Talamanca', 8, 9, 277);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7590, 'Puentedura', 9, 2, 277);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7591, 'Zafra de Záncara', 16, 5, 277);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7592, 'Torrecuadrada de Molina', 19, 0, 277);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7593, 'Salvatierra de Tormes', 37, 7, 277);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7594, 'Valtorres', 50, 7, 277);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7595, 'Taradell', 8, 5, 278);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7596, 'Zafrilla', 16, 1, 278);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7597, 'Torrecuadradilla', 19, 6, 278);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7598, 'San Cristóbal de la Cuesta', 37, 3, 278);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7599, 'Velilla de Ebro', 50, 3, 278);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7600, 'Terrassa', 8, 8, 279);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7601, 'Quemada', 9, 1, 279);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7602, 'Zarza de Tajo', 16, 4, 279);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7603, 'Torre del Burgo', 19, 9, 279);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7604, 'Sancti-Spíritus', 37, 6, 279);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7605, 'Velilla de Jiloca', 50, 6, 279);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7606, 'Tavertet', 8, 2, 280);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7607, 'Quintanabureba', 9, 5, 280);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7608, 'Zarzuela', 16, 8, 280);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7609, 'Torrejón del Rey', 19, 3, 280);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7610, 'Sanchón de la Ribera', 37, 0, 280);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7611, 'Vera de Moncayo', 50, 0, 280);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7612, 'Teià', 8, 9, 281);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7613, 'Quintana del Pidio', 9, 2, 281);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7614, 'Torremocha de Jadraque', 19, 0, 281);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7615, 'Sanchón de la Sagrada', 37, 7, 281);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7616, 'Vierlas', 50, 7, 281);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7617, 'Tiana', 8, 4, 282);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7618, 'Torremocha del Campo', 19, 5, 282);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7619, 'Sanchotello', 37, 2, 282);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7620, 'Vilueña, La', 50, 2, 282);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7621, 'Tona', 8, 0, 283);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7622, 'Quintanaélez', 9, 3, 283);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7623, 'Torremocha del Pinar', 19, 1, 283);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7624, 'Sando', 37, 8, 283);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7625, 'Villadoz', 50, 8, 283);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7626, 'Tordera', 8, 5, 284);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7627, 'Torremochuela', 19, 6, 284);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7628, 'San Esteban de la Sierra', 37, 3, 284);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7629, 'Villafeliche', 50, 3, 284);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7630, 'Torelló', 8, 8, 285);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7631, 'Torrubia', 19, 9, 285);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7632, 'San Felices de los Gallegos', 37, 6, 285);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7633, 'Villafranca de Ebro', 50, 6, 285);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7634, 'Torre de Claramunt, La', 8, 1, 286);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7635, 'Tórtola de Henares', 19, 2, 286);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7636, 'San Martín del Castañar', 37, 9, 286);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7637, 'Villalba de Perejil', 50, 9, 286);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7638, 'Torrelavit', 8, 7, 287);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7639, 'Quintanaortuño', 9, 0, 287);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7640, 'Tortuera', 19, 8, 287);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7641, 'San Miguel de Valero', 37, 5, 287);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7642, 'Villalengua', 50, 5, 287);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7643, 'Torrelles de Foix', 8, 3, 288);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7644, 'Quintanapalla', 9, 6, 288);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7645, 'Tortuero', 19, 4, 288);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7646, 'San Morales', 37, 1, 288);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7647, 'Villanueva de Gállego', 50, 1, 288);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7648, 'Torrelles de Llobregat', 8, 6, 289);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7649, 'Quintanar de la Sierra', 9, 9, 289);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7650, 'Traíd', 19, 7, 289);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7651, 'San Muñoz', 37, 4, 289);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7652, 'Villanueva de Jiloca', 50, 4, 289);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7653, 'Ullastrell', 8, 0, 290);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7654, 'Trijueque', 19, 1, 290);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7655, 'San Pedro del Valle', 37, 8, 290);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7656, 'Villanueva de Huerva', 50, 8, 290);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7657, 'Vacarisses', 8, 7, 291);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7658, 'Trillo', 19, 8, 291);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7659, 'San Pedro de Rozados', 37, 5, 291);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7660, 'Villar de los Navarros', 50, 5, 291);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7661, 'Vallbona d''Anoia', 8, 2, 292);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7662, 'Quintanavides', 9, 5, 292);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7663, 'San Pelayo de Guareña', 37, 0, 292);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7664, 'Villarreal de Huerva', 50, 0, 292);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7665, 'Vallcebre', 8, 8, 293);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7666, 'Uceda', 19, 9, 293);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7667, 'Santa María de Sando', 37, 6, 293);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7668, 'Villarroya de la Sierra', 50, 6, 293);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7669, 'Vallgorguina', 8, 3, 294);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7670, 'Quintanilla de la Mata', 9, 6, 294);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7671, 'Ujados', 19, 4, 294);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7672, 'Santa Marta de Tormes', 37, 1, 294);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7673, 'Villarroya del Campo', 50, 1, 294);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7674, 'Vallirana', 8, 6, 295);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7675, 'Quintanilla del Coco', 9, 9, 295);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7676, 'Vistabella', 50, 4, 295);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7677, 'Vallromanes', 8, 9, 296);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7678, 'Utande', 19, 0, 296);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7679, 'Santiago de la Puebla', 37, 7, 296);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7680, 'Zaida, La', 50, 7, 296);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7681, 'Veciana', 8, 5, 297);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7682, 'Quintanillas, Las', 9, 8, 297);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7683, 'Valdarachas', 19, 6, 297);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7684, 'Santibáñez de Béjar', 37, 3, 297);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7685, 'Zaragoza', 50, 3, 297);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7686, 'Vic', 8, 1, 298);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7687, 'Quintanilla San García', 9, 4, 298);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7688, 'Valdearenas', 19, 2, 298);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7689, 'Santibáñez de la Sierra', 37, 9, 298);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7690, 'Zuera', 50, 9, 298);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7691, 'Vilada', 8, 4, 299);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7692, 'Valdeavellano', 19, 5, 299);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7693, 'Santiz', 37, 2, 299);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7694, 'Viladecavalls', 8, 8, 300);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7695, 'Valdeaveruelo', 19, 9, 300);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7696, 'Santos, Los', 37, 6, 300);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7697, 'Viladecans', 8, 5, 301);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7698, 'Quintanilla Vivar', 9, 8, 301);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7699, 'Valdeconcha', 19, 6, 301);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7700, 'Sardón de los Frailes', 37, 3, 301);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7701, 'Vilanova del Camí', 8, 0, 302);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7702, 'Rabanera del Pinar', 9, 3, 302);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7703, 'Valdegrudas', 19, 1, 302);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7704, 'Saucelle', 37, 8, 302);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7705, 'Vilanova de Sau', 8, 6, 303);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7706, 'Rábanos', 9, 9, 303);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7707, 'Valdelcubo', 19, 7, 303);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7708, 'Sahugo, El', 37, 4, 303);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7709, 'Vilobí del Penedès', 8, 1, 304);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7710, 'Rabé de las Calzadas', 9, 4, 304);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7711, 'Valdenuño Fernández', 19, 2, 304);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7712, 'Sepulcro-Hilario', 37, 9, 304);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7713, 'Vilafranca del Penedès', 8, 4, 305);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7714, 'Valdepeñas de la Sierra', 19, 5, 305);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7715, 'Sequeros', 37, 2, 305);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7716, 'Vilalba Sasserra', 8, 7, 306);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7717, 'Rebolledo de la Torre', 9, 0, 306);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7718, 'Valderrebollo', 19, 8, 306);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7719, 'Serradilla del Arroyo', 37, 5, 306);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7720, 'Vilanova i la Geltrú', 8, 3, 307);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7721, 'Redecilla del Camino', 9, 6, 307);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7722, 'Valdesotos', 19, 4, 307);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7723, 'Serradilla del Llano', 37, 1, 307);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7724, 'Viver i Serrateix', 8, 9, 308);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7725, 'Redecilla del Campo', 9, 2, 308);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7726, 'Valfermoso de Tajuña', 19, 0, 308);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7727, 'Regumiel de la Sierra', 9, 5, 309);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7728, 'Valhermoso', 19, 3, 309);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7729, 'Sierpe, La', 37, 0, 309);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7730, 'Reinoso', 9, 9, 310);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7731, 'Valtablado del Río', 19, 7, 310);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7732, 'Sieteiglesias de Tormes', 37, 4, 310);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7733, 'Retuerta', 9, 6, 311);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7734, 'Valverde de los Arroyos', 19, 4, 311);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7735, 'Sobradillo', 37, 1, 311);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7736, 'Revilla y Ahedo, La', 9, 1, 312);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7737, 'Sorihuela', 37, 6, 312);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7738, 'Sotoserrano', 37, 2, 313);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7739, 'Revilla del Campo', 9, 2, 314);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7740, 'Viana de Jadraque', 19, 0, 314);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7741, 'Tabera de Abajo', 37, 7, 314);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7742, 'Revillarruz', 9, 5, 315);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7743, 'Tala, La', 37, 0, 315);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7744, 'Revilla Vallejera', 9, 8, 316);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7745, 'Tamames', 37, 3, 316);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7746, 'Rezmondo', 9, 4, 317);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7747, 'Villanueva de Alcorón', 19, 2, 317);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7748, 'Tarazona de Guareña', 37, 9, 317);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7749, 'Riocavado de la Sierra', 9, 0, 318);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7750, 'Villanueva de Argecilla', 19, 8, 318);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7751, 'Tardáguila', 37, 5, 318);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7752, 'Villanueva de la Torre', 19, 1, 319);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7753, 'Tejado, El', 37, 8, 319);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7754, 'Tejeda y Segoyuela', 37, 2, 320);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7755, 'Roa', 9, 4, 321);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7756, 'Villares de Jadraque', 19, 2, 321);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7757, 'Tenebrón', 37, 9, 321);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7758, 'Villaseca de Henares', 19, 7, 322);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7759, 'Terradillos', 37, 4, 322);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7760, 'Rojas', 9, 5, 323);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7761, 'Villaseca de Uceda', 19, 3, 323);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7762, 'Topas', 37, 0, 323);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7763, 'Villel de Mesa', 19, 8, 324);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7764, 'Tordillos', 37, 5, 324);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7765, 'Royuela de Río Franco', 9, 3, 325);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7766, 'Viñuelas', 19, 1, 325);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7767, 'Tornadizo, El', 37, 8, 325);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7768, 'Rubena', 9, 6, 326);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7769, 'Yebes', 19, 4, 326);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7770, 'Rublacedo de Abajo', 9, 2, 327);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7771, 'Yebra', 19, 0, 327);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7772, 'Torresmenudas', 37, 7, 327);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7773, 'Rucandio', 9, 8, 328);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7774, 'Trabanca', 37, 3, 328);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7775, 'Salas de Bureba', 9, 1, 329);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7776, 'Yélamos de Abajo', 19, 9, 329);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7777, 'Tremedal de Tormes', 37, 6, 329);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7778, 'Salas de los Infantes', 9, 5, 330);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7779, 'Yélamos de Arriba', 19, 3, 330);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7780, 'Valdecarros', 37, 0, 330);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7781, 'Yunquera de Henares', 19, 0, 331);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7782, 'Valdefuentes de Sangusín', 37, 7, 331);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7783, 'Saldaña de Burgos', 9, 7, 332);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7784, 'Yunta, La', 19, 5, 332);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7785, 'Valdehijaderos', 37, 2, 332);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7786, 'Zaorejas', 19, 1, 333);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7787, 'Valdelacasa', 37, 8, 333);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7788, 'Salinillas de Bureba', 9, 8, 334);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7789, 'Zarzuela de Jadraque', 19, 6, 334);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7790, 'Valdelageve', 37, 3, 334);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7791, 'San Adrián de Juarros', 9, 1, 335);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7792, 'Zorita de los Canes', 19, 9, 335);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7793, 'Valdelosa', 37, 6, 335);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7794, 'Valdemierque', 37, 9, 336);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7795, 'San Juan del Monte', 9, 0, 337);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7796, 'Valderrodrigo', 37, 5, 337);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7797, 'San Mamés de Burgos', 9, 6, 338);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7798, 'Valdunciel', 37, 1, 338);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7799, 'San Martín de Rubiales', 9, 9, 339);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7800, 'Valero', 37, 4, 339);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7801, 'San Millán de Lara', 9, 3, 340);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7802, 'Valsalabroso', 37, 8, 340);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7803, 'Valverde de Valdelacasa', 37, 5, 341);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7804, 'Valverdón', 37, 0, 342);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7805, 'Santa Cecilia', 9, 1, 343);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7806, 'Vallejera de Riofrío', 37, 6, 343);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7807, 'Vecinos', 37, 1, 344);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7808, 'Santa Cruz de la Salceda', 9, 9, 345);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7809, 'Vega de Tirados', 37, 4, 345);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7810, 'Santa Cruz del Valle Urbión', 9, 2, 346);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7811, 'Veguillas, Las', 37, 7, 346);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7812, 'Santa Gadea del Cid', 9, 8, 347);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7813, 'Vellés, La', 37, 3, 347);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7814, 'Santa Inés', 9, 4, 348);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7815, 'Ventosa del Río Almar', 37, 9, 348);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7816, 'Vídola, La', 37, 2, 349);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7817, 'Santa María del Campo', 9, 0, 350);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7818, 'Vilvestre', 37, 5, 350);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7819, 'Santa María del Invierno', 9, 7, 351);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7820, 'Villaflores', 37, 2, 351);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7821, 'Santa María del Mercadillo', 9, 2, 352);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7822, 'Villagonzalo de Tormes', 37, 7, 352);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7823, 'Santa María Rivarredonda', 9, 8, 353);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7824, 'Villalba de los Llanos', 37, 3, 353);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7825, 'Santa Olalla de Bureba', 9, 3, 354);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7826, 'Villamayor', 37, 8, 354);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7827, 'Santibáñez de Esgueva', 9, 6, 355);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7828, 'Villanueva del Conde', 37, 1, 355);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7829, 'Santibáñez del Val', 9, 9, 356);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7830, 'Villar de Argañán', 37, 4, 356);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7831, 'Villar de Ciervo', 37, 0, 357);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7832, 'Santo Domingo de Silos', 9, 1, 358);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7833, 'Villar de Gallimazo', 37, 6, 358);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7834, 'Villar de la Yegua', 37, 9, 359);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7835, 'San Vicente del Valle', 9, 8, 360);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7836, 'Villar de Peralonso', 37, 3, 360);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7837, 'Sargentes de la Lora', 9, 5, 361);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7838, 'Villar de Samaniego', 37, 0, 361);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7839, 'Sarracín', 9, 0, 362);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7840, 'Villares de la Reina', 37, 5, 362);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7841, 'Sasamón', 9, 6, 363);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7842, 'Villares de Yeltes', 37, 1, 363);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7843, 'Villarino de los Aires', 37, 6, 364);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7844, 'Sequera de Haza, La', 9, 4, 365);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7845, 'Villarmayor', 37, 9, 365);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7846, 'Solarana', 9, 7, 366);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7847, 'Villarmuerto', 37, 2, 366);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7848, 'Villasbuenas', 37, 8, 367);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7849, 'Sordillos', 9, 9, 368);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7850, 'Villasdardo', 37, 4, 368);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7851, 'Sotillo de la Ribera', 9, 2, 369);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7852, 'Villaseco de los Gamitos', 37, 7, 369);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7853, 'Villaseco de los Reyes', 37, 1, 370);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7854, 'Villasrubias', 37, 8, 371);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7855, 'Sotragero', 9, 8, 372);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7856, 'Villaverde de Guareña', 37, 3, 372);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7857, 'Sotresgudo', 9, 4, 373);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7858, 'Villavieja de Yeltes', 37, 9, 373);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7859, 'Susinos del Páramo', 9, 9, 374);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7860, 'Villoria', 37, 4, 374);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7861, 'Tamarón', 9, 2, 375);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7862, 'Villoruela', 37, 7, 375);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7863, 'Vitigudino', 37, 0, 376);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7864, 'Tardajos', 9, 1, 377);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7865, 'Yecla de Yeltes', 37, 6, 377);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7866, 'Tejada', 9, 7, 378);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7867, 'Zamarra', 37, 2, 378);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7868, 'Zamayón', 37, 5, 379);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7869, 'Terradillos de Esgueva', 9, 4, 380);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7870, 'Zarapicos', 37, 9, 380);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7871, 'Tinieblas de la Sierra', 9, 1, 381);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7872, 'Zarza de Pumareda, La', 37, 6, 381);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7873, 'Tobar', 9, 6, 382);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7874, 'Zorita de la Frontera', 37, 1, 382);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7875, 'Tordómar', 9, 7, 384);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7876, 'Torrecilla del Monte', 9, 3, 386);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7877, 'Torregalindo', 9, 9, 387);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7878, 'Torrelara', 9, 5, 388);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7879, 'Torrepadre', 9, 8, 389);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7880, 'Torresandino', 9, 2, 390);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7881, 'Tórtoles de Esgueva', 9, 9, 391);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7882, 'Tosantos', 9, 4, 392);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7883, 'Trespaderne', 9, 5, 394);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7884, 'Tubilla del Agua', 9, 8, 395);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7885, 'Tubilla del Lago', 9, 1, 396);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7886, 'Úrbel del Castillo', 9, 3, 398);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7887, 'Vadocondes', 9, 0, 400);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7888, 'Valdeande', 9, 8, 403);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7889, 'Valdezate', 9, 6, 405);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7890, 'Valdorros', 9, 9, 406);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7891, 'Valmala', 9, 5, 407);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7892, 'Vallarta de Bureba', 9, 1, 408);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7893, 'Valle de Manzanedo', 9, 4, 409);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7894, 'Valle de Mena', 9, 8, 410);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7895, 'Valle de Oca', 9, 5, 411);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7896, 'Valle de Tobalina', 9, 0, 412);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7897, 'Valle de Valdebezana', 9, 6, 413);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7898, 'Valle de Valdelaguna', 9, 1, 414);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7899, 'Valle de Valdelucio', 9, 4, 415);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7900, 'Valle de Zamanzas', 9, 7, 416);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7901, 'Vallejera', 9, 3, 417);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7902, 'Valles de Palenzuela', 9, 9, 418);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7903, 'Valluércanes', 9, 2, 419);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7904, 'Vid y Barrios, La', 9, 3, 421);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7905, 'Vid de Bureba, La', 9, 8, 422);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7906, 'Vileña', 9, 4, 423);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7907, 'Viloria de Rioja', 9, 9, 424);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7908, 'Vilviestre del Pinar', 9, 2, 425);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7909, 'Villadiego', 9, 1, 427);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7910, 'Villaescusa de Roa', 9, 7, 428);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7911, 'Villaescusa la Sombría', 9, 0, 429);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7912, 'Villaespasa', 9, 4, 430);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7913, 'Villafranca Montes de Oca', 9, 1, 431);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7914, 'Villafruela', 9, 6, 432);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7915, 'Villagalijo', 9, 2, 433);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7916, 'Villagonzalo Pedernales', 9, 7, 434);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7917, 'Villahoz', 9, 9, 437);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7918, 'Villalba de Duero', 9, 5, 438);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7919, 'Villalbilla de Burgos', 9, 8, 439);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7920, 'Villalbilla de Gumiel', 9, 2, 440);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7921, 'Villaldemiro', 9, 9, 441);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7922, 'Villalmanzo', 9, 4, 442);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7923, 'Villamayor de los Montes', 9, 0, 443);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7924, 'Villamayor de Treviño', 9, 5, 444);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7925, 'Villambistia', 9, 8, 445);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7926, 'Villamedianilla', 9, 1, 446);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7927, 'Villamiel de la Sierra', 9, 7, 447);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7928, 'Villangómez', 9, 3, 448);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7929, 'Villanueva de Argaño', 9, 6, 449);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7930, 'Villanueva de Carazo', 9, 9, 450);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7931, 'Villanueva de Gumiel', 9, 6, 451);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7932, 'Villanueva de Teba', 9, 2, 454);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7933, 'Villaquirán de la Puebla', 9, 5, 455);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7934, 'Villaquirán de los Infantes', 9, 8, 456);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7935, 'Villariezo', 9, 0, 458);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7936, 'Villasandino', 9, 7, 460);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7937, 'Villasur de Herreros', 9, 5, 463);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7938, 'Villatuelda', 9, 0, 464);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7939, 'Villaverde del Monte', 9, 6, 466);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7940, 'Villaverde-Mogina', 9, 2, 467);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7941, 'Villayerno Morquillas', 9, 2, 471);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7942, 'Villazopeque', 9, 7, 472);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7943, 'Villegas', 9, 3, 473);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7944, 'Villoruebo', 9, 4, 476);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7945, 'Vizcaínos', 9, 6, 478);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7946, 'Zael', 9, 3, 480);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7947, 'Zarzosa de Río Pisuerga', 9, 5, 482);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7948, 'Zazuar', 9, 1, 483);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7949, 'Zuñeda', 9, 9, 485);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7950, 'Iruña Oka/Iruña de Oca', 1, 5, 901);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7951, 'Pozo Cañada', 2, 0, 901);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7952, 'Poblets, els', 3, 6, 901);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7953, 'Tres Villas, Las', 4, 1, 901);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7954, 'San Juan de Gredos', 5, 4, 901);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7955, 'Valdelacalzada', 6, 7, 901);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7956, 'Ariany', 7, 3, 901);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7957, 'Rupit i Pruit', 8, 9, 901);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7958, 'Quintanilla del Agua y Tordueles', 9, 2, 901);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7959, 'Rosalejo', 10, 6, 901);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7960, 'Benalup-Casas Viejas', 11, 3, 901);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7961, 'Alquerías del Niño Perdido', 12, 8, 901);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7962, 'Robledo, El', 13, 4, 901);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7963, 'Cariño', 15, 2, 901);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7964, 'Campos del Paraíso', 16, 5, 901);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7965, 'Cruïlles,  Monells i Sant Sadurní de l''Heura', 17, 1, 901);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7966, 'Taha, La', 18, 7, 901);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7967, 'Semillas', 19, 0, 901);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7968, 'Mendaro', 20, 4, 901);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7969, 'Valle de Hecho', 22, 6, 901);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7970, 'Cárcheles', 23, 2, 901);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7971, 'Villamanín', 24, 7, 901);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7972, 'Vall de Cardós', 25, 0, 901);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7973, 'Baralla', 27, 9, 901);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7974, 'Lozoyuela-Navas-Sieteiglesias', 28, 5, 901);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7975, 'Torremolinos', 29, 8, 901);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7976, 'Santomera', 30, 2, 901);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7977, 'Barañain', 31, 9, 901);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7978, 'Osorno la Mayor', 34, 5, 901);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7979, 'Illa de Arousa, A', 36, 1, 901);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7980, 'Pinar de El Hierro, El', 38, 3, 901);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7981, 'Ortigosa del Monte', 40, 0, 901);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7982, 'Cañada Rosal', 41, 7, 901);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7983, 'Deltebre', 43, 8, 901);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7984, 'Santo Domingo-Caudilla', 45, 6, 901);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7985, 'Derio', 48, 1, 901);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7986, 'Biel', 50, 7, 901);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7987, 'Lantarón', 1, 0, 902);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7988, 'Pilar de la Horadada', 3, 1, 902);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7989, 'Ejido, El', 4, 6, 902);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7990, 'Santa María del Cubillo', 5, 9, 902);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7991, 'Pueblonuevo del Guadiana', 6, 2, 902);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7992, 'Migjorn Gran, Es', 7, 8, 902);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7993, 'Vilanova del Vallès', 8, 4, 902);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7994, 'Valle de Santibáñez', 9, 7, 902);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7995, 'Vegaviana', 10, 1, 902);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7996, 'San José del Valle', 11, 8, 902);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7997, 'Sant Joan de Moró', 12, 3, 902);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7998, 'Ruidera', 13, 9, 902);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (7999, 'Valdetórtola', 16, 0, 902);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8000, 'Forallac', 17, 6, 902);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8001, 'Valle, El', 18, 2, 902);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8002, 'Lasarte-Oria', 20, 9, 902);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8003, 'Puente la Reina de Jaca', 22, 1, 902);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8004, 'Bedmar y Garcíez', 23, 7, 902);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8005, 'Villaornate y Castro', 24, 2, 902);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8006, 'Sant Martí de Riucorb', 25, 5, 902);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8007, 'Burela', 27, 4, 902);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8008, 'Puentes Viejas', 28, 0, 902);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8009, 'Villanueva de la Concepción', 29, 3, 902);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8010, 'Alcázares, Los', 30, 7, 902);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8011, 'Berrioplano/Berriobeiti', 31, 4, 902);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8012, 'Valle del Retortillo', 34, 0, 902);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8013, 'Cozuelos de Fuentidueña', 40, 5, 902);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8014, 'Isla Mayor', 41, 2, 902);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8015, 'Sant Jaume d''Enveja', 43, 3, 902);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8016, 'Gátova', 46, 4, 902);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8017, 'Erandio', 48, 6, 902);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8018, 'Marracos', 50, 2, 902);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8019, 'Montesinos, Los', 3, 7, 903);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8020, 'Mojonera, La', 4, 2, 903);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8021, 'Diego del Carpio', 5, 5, 903);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8022, 'Sant Julià de Cerdanyola', 8, 0, 903);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8023, 'Villarcayo de Merindad de Castilla la Vieja', 9, 3, 903);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8024, 'Alagón del Río', 10, 7, 903);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8025, 'Arenales de San Gregorio', 13, 5, 903);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8026, 'Valeras, Las', 16, 6, 903);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8027, 'Sant Julià del Llor i Bonmatí', 17, 2, 903);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8028, 'Nevada', 18, 8, 903);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8029, 'Astigarraga', 20, 5, 903);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8030, 'San Miguel del Cinca', 22, 7, 903);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8031, 'Villatorres', 23, 3, 903);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8032, 'Guingueta d''Àneu, La', 25, 1, 903);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8033, 'Tres Cantos', 28, 6, 903);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8034, 'Berriozar', 31, 0, 903);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8035, 'Loma de Ucieza', 34, 6, 903);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8036, 'Marazoleja', 40, 1, 903);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8037, 'Cuervo de Sevilla, El', 41, 8, 903);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8038, 'Camarles', 43, 9, 903);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8039, 'San Antonio de Benagéber', 46, 0, 903);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8040, 'Loiu', 48, 2, 903);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8041, 'Villamayor de Gállego', 50, 8, 903);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8042, 'San Isidro', 3, 2, 904);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8043, 'Santiago del Tormes', 5, 0, 904);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8044, 'Badia del Vallès', 8, 5, 904);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8045, 'Valle de las Navas', 9, 8, 904);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8046, 'Llanos del Caudillo', 13, 0, 904);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8047, 'Fuentenava de Jábaga', 16, 1, 904);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8048, 'Alpujarra de la Sierra', 18, 3, 904);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8049, 'Baliarrain', 20, 0, 904);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8050, 'Sotonera, La', 22, 2, 904);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8051, 'Santiago-Pontones', 23, 8, 904);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8052, 'Castell de Mur', 25, 6, 904);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8053, 'Irurtzun', 31, 5, 904);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8054, 'Pernía, La', 34, 1, 904);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8055, 'Navas de Riofrío', 40, 6, 904);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8056, 'Aldea, L''', 43, 4, 904);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8057, 'Benicull de Xúquer', 46, 5, 904);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8058, 'Sondika', 48, 7, 904);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8059, 'Villanueva de Ávila', 5, 3, 905);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8060, 'Palma de Cervelló, La', 8, 8, 905);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8061, 'Valle de Sedano', 9, 1, 905);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8062, 'Arcas del Villar', 16, 4, 905);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8063, 'Gabias, Las', 18, 6, 905);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8064, 'Orendain', 20, 3, 905);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8065, 'Lupiñén-Ortilla', 22, 5, 905);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8066, 'Arroyo del Ojanco', 23, 1, 905);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8067, 'Ribera d''Ondara', 25, 9, 905);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8068, 'Beriáin', 31, 8, 905);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8069, 'Cuevas de Provanco', 40, 9, 905);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8070, 'Salou', 43, 7, 905);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8071, 'Zamudio', 48, 0, 905);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8072, 'Merindad de Río Ubierna', 9, 4, 906);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8073, 'Valdecolmenas, Los', 16, 7, 906);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8074, 'Guajares, Los', 18, 9, 906);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8075, 'Altzaga', 20, 6, 906);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8076, 'Santa María de Dulcis', 22, 8, 906);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8077, 'Valls d''Aguilar, Les', 25, 2, 906);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8078, 'Orkoien', 31, 1, 906);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8079, 'San Cristóbal de Segovia', 40, 2, 906);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8080, 'Ampolla, L''', 43, 0, 906);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8081, 'Forua', 48, 3, 906);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8082, 'Alfoz de Quintanadueñas', 9, 0, 907);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8083, 'Valle del Zalabí', 18, 5, 907);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8084, 'Gaztelu', 20, 2, 907);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8085, 'Aínsa-Sobrarbe', 22, 4, 907);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8086, 'Torrefeta i Florejacs', 25, 8, 907);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8087, 'Zizur Mayor/Zizur Nagusia', 31, 7, 907);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8088, 'Canonja, La', 43, 6, 907);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8089, 'Kortezubi', 48, 9, 907);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8090, 'Valle de Losa', 9, 6, 908);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8091, 'Pozorrubielos de la Mancha', 16, 9, 908);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8092, 'Villamena', 18, 1, 908);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8093, 'Hoz y Costean', 22, 0, 908);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8094, 'Fígols i Alinyà', 25, 4, 908);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8095, 'Lekunberri', 31, 3, 908);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8096, 'Murueta', 48, 5, 908);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8097, 'Sotorribas', 16, 2, 909);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8098, 'Morelábor', 18, 4, 909);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8099, 'Vencillón', 22, 3, 909);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8100, 'Vansa i Fórnols, La', 25, 7, 909);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8101, 'Nabarniz', 48, 8, 909);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8102, 'Villar y Velasco', 16, 6, 910);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8103, 'Pinar, El', 18, 8, 910);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8104, 'Josa i Tuixén', 25, 1, 910);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8105, 'Iurreta', 48, 2, 910);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8106, 'Vegas del Genil', 18, 5, 911);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8107, 'Plans de Sió, Els', 25, 8, 911);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8108, 'Ajangiz', 48, 9, 911);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8109, 'Cuevas del Campo', 18, 0, 912);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8110, 'Gimenells i el Pla de la Font', 25, 3, 912);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8111, 'Alonsotegi', 48, 4, 912);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8112, 'Zagra', 18, 6, 913);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8113, 'Riu de Cerdanya', 25, 9, 913);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8114, 'Zierbena', 48, 0, 913);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8115, 'Arratzu', 48, 5, 914);\n" +
            "INSERT INTO town(ID, NAME, PROVINCE_ID, DC, COD_MUNUCIPIO) VALUES (8116, 'Ziortza-Bolibar', 48, 8, 915);";
    */
}
