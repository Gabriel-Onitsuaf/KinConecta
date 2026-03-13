INSERT INTO users (user_id, role, full_name, email, password_hash, preferred_language_code)
VALUES
(111,'TOURIST','Carlos Rivera','carlos@test.com','hash','es'),
(112,'TOURIST','Anna Müller','anna@test.com','hash','en'),
(113,'TOURIST','Luis Gómez','luis@test.com','hash','es'),
(114,'TOURIST','Emily Clark','emily@test.com','hash','en'),
(115,'TOURIST','Sofia Torres','sofia@test.com','hash','es'),
(116,'TOURIST','Marc Dubois','marc@test.com','hash','fr'),
(117,'TOURIST','Laura Díaz','laura@test.com','hash','es'),
(118,'TOURIST','Daniel Smith','daniel@test.com','hash','en'),
(119,'TOURIST','Isabel Vega','isabel@test.com','hash','es'),
(110,'TOURIST','Tom Johnson','tom@test.com','hash','en');

INSERT INTO users (user_id, role, full_name, email, password_hash, preferred_language_code)
VALUES
(211,'GUIDE','Miguel Hernández','miguel@test.com','hash','es'),
(212,'GUIDE','Juan Martínez','juan@test.com','hash','es'),
(213,'GUIDE','Pedro López','pedro@test.com','hash','es'),
(214,'GUIDE','Andrea Rossi','andrea@test.com','hash','en'),
(215,'GUIDE','David Brown','david@test.com','hash','en'),
(216,'GUIDE','Luc Martin','luc@test.com','hash','fr'),
(217,'GUIDE','Paula Jiménez','paula@test.com','hash','es'),
(218,'GUIDE','Ricardo León','ricardo@test.com','hash','es'),
(219,'GUIDE','Chris Walker','chris@test.com','hash','en'),
(220,'GUIDE','Fernando Ruiz','fernando@test.com','hash','es');

INSERT INTO tourist_profiles (user_id, location, travel_style, trip_type, activity_level)
VALUES
(111,'Guadalajara','Cultural','Solo','MODERADO'),
(112,'Berlin','Adventure','Friends','ALTO'),
(113,'CDMX','Cultural','Couple','BAJO'),
(114,'New York','Nature','Solo','ALTO'),
(115,'Madrid','Food','Couple','MODERADO'),
(116,'Paris','History','Solo','BAJO'),
(117,'Monterrey','Adventure','Friends','ALTO'),
(118,'Chicago','City','Solo','MODERADO'),
(119,'Valencia','Culture','Couple','BAJO'),
(110,'Toronto','Nature','Friends','MODERADO');

INSERT INTO guide_profiles (user_id, summary, hourly_rate, rating_avg, experience_level)
VALUES
(211,'Guía gastronómico en Guadalajara',30,4.8,'Experto'),
(212,'Tours históricos en CDMX',25,4.7,'Experto'),
(213,'Aventura en montaña',35,4.9,'Avanzado'),
(214,'City tours en inglés',28,4.6,'Intermedio'),
(215,'Food tours internacionales',40,4.9,'Experto'),
(216,'Historia de Europa',32,4.5,'Avanzado'),
(217,'Tours culturales en museos',20,4.6,'Intermedio'),
(218,'Experiencias naturales',30,4.7,'Avanzado'),
(219,'Urban explorer',26,4.4,'Intermedio'),
(220,'Experiencias mexicanas auténticas',33,4.8,'Experto');

-- INSERT INTO languages (language_code,name)
-- VALUES
-- ('es','Español'),
-- ('en','English'),
-- ('fr','Français');

INSERT INTO tourist_profile_languages VALUES
(111,'es'),
(112,'en'),
(113,'es'),
(114,'en'),
(115,'es'),
(116,'fr'),
(117,'es'),
(118,'en'),
(119,'es'),
(110,'en');

INSERT INTO guide_profile_languages VALUES
(211,'es'),
(212,'es'),
(213,'es'),
(214,'en'),
(215,'en'),
(216,'fr'),
(217,'es'),
(218,'es'),
(219,'en'),
(220,'es');

INSERT INTO interests (interest_id,name)
VALUES
(1,'Gastronomía'),
(2,'Naturaleza'),
(3,'Historia'),
(4,'Arte'),
(5,'Aventura');

INSERT IGNORE INTO `tourist_profile_interests` (`user_id`, `interest_id`)  VALUES
(111,1),
(111,3),
(112,5),
(112,2),
(113,3),
(114,2),
(115,1),
(116,3),
(117,5),
(118,4),
(119,3),
(110,2);

-- INSERT INTO guide_expertise_areas (expertise_id,name)
-- VALUES
-- (1,'Food Tours'),
-- (2,'Nature Trails'),
-- (3,'Historic Walks'),
-- (4,'Museum Tours'),
-- (5,'Adventure Trips');

INSERT INTO guide_profile_expertise VALUES
(211,1),
(212,3),
(213,5),
(214,4),
(215,1),
(216,3),
(217,4),
(218,2),
(219,4),
(220,1);

INSERT INTO guide_locations (user_id,location_name)
VALUES
(211,'Guadalajara'),
(212,'CDMX'),
(213,'Monterrey'),
(214,'New York'),
(215,'Madrid'),
(216,'Paris'),
(217,'Guadalajara'),
(218,'Puerto Vallarta'),
(219,'Chicago'),
(220,'CDMX');

