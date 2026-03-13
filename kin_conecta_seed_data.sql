-- Seed de prueba para kin_conecta
-- Inserta 3 registros por endpoint/base table para que GET devuelva datos.
USE `kcv2`;

INSERT IGNORE INTO `languages` (`language_code`, `name`) VALUES
('es', 'Español'),
('en', 'English'),
('fr', 'Français');

SELECT * FROM languages;

INSERT IGNORE INTO `interests` (`interest_id`, `name`) VALUES
(1, 'Gastronomía'),
(2, 'Naturaleza'),
(3, 'Historia');
INSERT IGNORE INTO `interests` (`interest_id`, `name`) VALUES
(4,'Arte'),
(5,'Aventura');

SELECT * FROM interests;

INSERT IGNORE INTO `guide_expertise_areas` (`expertise_id`, `name`) VALUES
(1, 'Food Tours'),
(2, 'Nature Trails'),
(3, 'Historic Walks');

SELECT * FROM guide_expertise_areas;

INSERT IGNORE INTO `tour_categories` (`category_id`, `name`) VALUES
(1, 'Gastronómico'),
(2, 'Aventura'),
(3, 'Cultural');

SELECT * FROM tour_categories;

INSERT IGNORE INTO `destinations` (`destination_id`, `city`, `state`, `country`, `description`, `image_url`, `is_featured`) VALUES
(1, 'Guadalajara', 'Jalisco', 'México', 'Centro histórico y mercados tradicionales.', 'https://example.com/destinations/guadalajara.jpg', 1),
(2, 'Puerto Vallarta', 'Jalisco', 'México', 'Playas, malecón y experiencias locales.', 'https://example.com/destinations/puerto-vallarta.jpg', 1),
(3, 'Querétaro', 'Querétaro', 'México', 'Arquitectura colonial y viñedos cercanos.', 'https://example.com/destinations/queretaro.jpg', 0);

SELECT * FROM destinations;
-- --------- Posponer
INSERT IGNORE INTO `users` (`user_id`, `role`, `full_name`, `date_of_birth`, `email`, `password_hash`, `country_code`, `phone_number`, `phone_e164`, `preferred_language_code`, `account_status`, `email_verified_at`, `last_login_at`) VALUES
(1, 'TOURIST', 'Ana Torres', '1997-05-14', 'ana.torres@example.com', 'hash_ana_123', 'MX', '3311111111', '+523311111111', 'es', 'ACTIVE', '2026-03-01 09:00:00', '2026-03-05 08:10:00'),
(2, 'TOURIST', 'David Miller', '1993-11-02', 'david.miller@example.com', 'hash_david_123', 'US', '2065550102', '+12065550102', 'en', 'ACTIVE', '2026-03-01 10:00:00', '2026-03-05 08:30:00'),
(3, 'TOURIST', 'Claire Dubois', '1991-08-21', 'claire.dubois@example.com', 'hash_claire_123', 'FR', '612345678', '+33612345678', 'fr', 'ACTIVE', '2026-03-01 11:00:00', '2026-03-05 08:50:00'),
(7,'TOURIST','Maria Ortega','1995-03-11','maria.ortega@example.com','hash_maria_123','ES','611111111','+34611111111','es','ACTIVE','2026-03-01 10:00:00','2026-03-05 08:00:00'),
(8,'TOURIST','James Walker','1992-08-21','james.walker@example.com','hash_james_123','CA','6041111111','+16041111111','en','ACTIVE','2026-03-01 10:10:00','2026-03-05 08:05:00'),
(9,'TOURIST','Lucia Fernandez','1996-04-09','lucia.fernandez@example.com','hash_lucia_123','AR','1111111111','+541111111111','es','ACTIVE','2026-03-01 10:20:00','2026-03-05 08:10:00'),
(10,'TOURIST','Felix Schneider','1993-12-02','felix.schneider@example.com','hash_felix_123','DE','1511111111','+491511111111','en','ACTIVE','2026-03-01 10:30:00','2026-03-05 08:15:00'),
(11,'TOURIST','Raul Garza','1991-07-13','raul.garza@example.com','hash_raul_123','MX','3312222222','+523312222222','es','ACTIVE','2026-03-01 10:40:00','2026-03-05 08:20:00'),
(12,'TOURIST','Pedro Alves','1990-11-29','pedro.alves@example.com','hash_pedro_123','PT','911111111','+351911111111','en','ACTIVE','2026-03-01 10:50:00','2026-03-05 08:25:00'),
(13,'TOURIST','Mark Johnson','1994-01-18','mark.johnson@example.com','hash_mark_123','US','3121111111','+13121111111','en','ACTIVE','2026-03-01 11:00:00','2026-03-05 08:30:00'),
(14,'TOURIST','Amelie Laurent','1997-06-04','amelie.laurent@example.com','hash_amelie_123','FR','611222222','+33611222222','fr','ACTIVE','2026-03-01 11:10:00','2026-03-05 08:35:00'),
(15,'TOURIST','Carlos Herrera','1992-09-16','carlos.herrera@example.com','hash_carlos_123','CO','3011111111','+573011111111','es','ACTIVE','2026-03-01 11:20:00','2026-03-05 08:40:00'),
(16,'TOURIST','Lucas Martin','1993-10-05','lucas.martin@example.com','hash_lucas_123','CA','7781111111','+17781111111','en','ACTIVE','2026-03-01 11:30:00','2026-03-05 08:45:00'),
(4, 'GUIDE', 'Luis Ramírez', '1988-02-19', 'luis.ramirez@example.com', 'hash_luis_123', 'MX', '3322222222', '+523322222222', 'es', 'ACTIVE', '2026-03-01 12:00:00', '2026-03-05 09:00:00'),
(5, 'GUIDE', 'Sofía Herrera', '1990-07-07', 'sofia.herrera@example.com', 'hash_sofia_123', 'MX', '3333333333', '+523333333333', 'en', 'ACTIVE', '2026-03-01 12:30:00', '2026-03-05 09:10:00'),
(6, 'GUIDE', 'Miguel Ortega', '1985-12-03', 'miguel.ortega@example.com', 'hash_miguel_123', 'MX', '3344444444', '+523344444444', 'es', 'ACTIVE', '2026-03-01 13:00:00', '2026-03-05 09:20:00'),
(17,'GUIDE','Carlos Mendoza','1987-03-14','carlos.mendoza@example.com','hash_carlosg_123','MX','3313333333','+523313333333','es','ACTIVE','2026-03-01 12:10:00','2026-03-05 09:10:00'),
(18,'GUIDE','Ana Castillo','1989-07-01','ana.castillo@example.com','hash_ana_g_123','MX','3314444444','+523314444444','es','ACTIVE','2026-03-01 12:20:00','2026-03-05 09:15:00'),
(19,'GUIDE','Pablo Rivera','1985-04-25','pablo.rivera@example.com','hash_pablo_123','MX','3315555555','+523315555555','es','ACTIVE','2026-03-01 12:30:00','2026-03-05 09:20:00'),
(20,'GUIDE','Roberto Jimenez','1986-01-10','roberto.jimenez@example.com','hash_roberto_123','MX','3316666666','+523316666666','es','ACTIVE','2026-03-01 12:40:00','2026-03-05 09:25:00'),
(21,'GUIDE','Sofia Vega','1990-02-17','sofia.vega@example.com','hash_sofia_123','MX','3317777777','+523317777777','en','ACTIVE','2026-03-01 12:50:00','2026-03-05 09:30:00'),
(22,'GUIDE','Lina Campos','1988-09-08','lina.campos@example.com','hash_lina_123','MX','3318888888','+523318888888','es','ACTIVE','2026-03-01 13:00:00','2026-03-05 09:35:00'),
(23,'GUIDE','Diego Flores','1984-05-22','diego.flores@example.com','hash_diego_123','MX','3319999999','+523319999999','es','ACTIVE','2026-03-01 13:10:00','2026-03-05 09:40:00'),
(24,'GUIDE','Julia Castro','1991-12-11','julia.castro@example.com','hash_julia_123','MX','3320000000','+523320000000','en','ACTIVE','2026-03-01 13:20:00','2026-03-05 09:45:00'),
(25,'GUIDE','Mario Salazar','1987-08-03','mario.salazar@example.com','hash_mario_123','MX','3321111111','+523321111111','es','ACTIVE','2026-03-01 13:30:00','2026-03-05 09:50:00'),
(26,'GUIDE','Valeria Soto','1992-06-28','valeria.soto@example.com','hash_valeria_123','MX','3322223333','+523322223333','es','ACTIVE','2026-03-01 13:40:00','2026-03-05 09:55:00');

INSERT IGNORE INTO `tourist_profiles` (`user_id`, `location`, `bio`, `member_since`, `badge`, `travel_style`, `trip_type`, `pace_and_company`, `activity_level`, `group_preference`, `dietary_preferences`, `planning_level`, `amenities`, `transport`, `photo_preference`, `accessibility`, `additional_notes`, `avatar_url`, `cover_url`) VALUES
(1, 'Guadalajara, México', 'Viajera foodie que disfruta mercados y talleres locales.', '2025-01-10', 'Exploradora local', 'Cultural, Foodie', 'Pareja', 'Relajado en grupos pequeños', 'MODERADO', 'Pequeño', 'Vegetariana', 'INTERMEDIO', 'WiFi, baños cercanos', 'Caminando y transporte público', 'Fotografía urbana', 'Sin requerimientos especiales', 'Le interesan experiencias auténticas y seguras.', 'https://example.com/avatars/ana.jpg', 'https://example.com/covers/ana.jpg'),
(2, 'Seattle, USA', 'Traveler who likes nature and well-organized plans.', '2025-02-01', 'Adventure seeker', 'Adventure, Nature', 'Solo', 'Dynamic solo traveler', 'ALTO', 'Flexible', 'No restrictions', 'ALTO', 'Parking, bottled water', 'Private transport', 'Landscape', 'No special needs', 'Prefers English-speaking guides.', 'https://example.com/avatars/david.jpg', 'https://example.com/covers/david.jpg'),
(3, 'Lyon, France', 'Ama la historia, el arte y las rutas tranquilas.', '2025-02-15', 'Culture lover', 'Cultural, Slow travel', 'Amigos', 'Calm with close friends', 'BAJO', 'Privado', 'Sin gluten', 'BAJO', 'Accesos sencillos', 'Caminando', 'Arquitectura', 'Evitar recorridos con muchas escaleras', 'Busca recorridos bilingües.', 'https://example.com/avatars/claire.jpg', 'https://example.com/covers/claire.jpg'),
(7,'Madrid, España','Le gusta descubrir arte urbano y cafés locales.','2025-02-20','City explorer','Cultural, Urban','Solo','Relajado en solitario','MODERADO','Flexible','Sin restricciones','INTERMEDIO','WiFi','Caminando','Street photography','Sin requerimientos','Prefiere guías con historias locales.','https://example.com/avatars/maria.jpg','https://example.com/covers/maria.jpg'),
(8,'Toronto, Canada','Fan de experiencias gastronómicas y mercados.','2025-02-18','Food lover','Foodie, Cultural','Pareja','Tranquilo en pareja','BAJO','Pequeño','Vegetariano','BAJO','Baños cercanos','Uber y walking','Food photography','Sin requerimientos','Busca tours gastronómicos locales.','https://example.com/avatars/james.jpg','https://example.com/covers/james.jpg'),
(9,'Buenos Aires, Argentina','Apasionada por historia y arquitectura.','2025-02-10','History fan','Cultural, Historic','Amigos','Calmado con amigos','BAJO','Privado','Sin restricciones','BAJO','Accesos sencillos','Walking tour','Arquitectura','Evitar pendientes largas','Prefiere recorridos narrativos.','https://example.com/avatars/lucia.jpg','https://example.com/covers/lucia.jpg'),
(10,'Berlin, Germany','Adventure traveler exploring outdoor routes.','2025-01-29','Adventure spirit','Adventure, Nature','Solo','Dinámico solo','ALTO','Flexible','No restrictions','ALTO','Parking','Car rental','Landscape','None','Interested in eco routes.','https://example.com/avatars/felix.jpg','https://example.com/covers/felix.jpg'),
(11,'Monterrey, México','Le gusta hiking y experiencias naturales.','2025-02-03','Mountain explorer','Nature, Adventure','Amigos','Activo con amigos','ALTO','Grupo','Sin restricciones','INTERMEDIO','Agua incluida','Auto','Nature','Sin requerimientos','Prefiere guías certificados.','https://example.com/avatars/raul.jpg','https://example.com/covers/raul.jpg'),
(12,'Lisboa, Portugal','Slow traveler que disfruta cultura local.','2025-02-14','Slow traveler','Cultural','Pareja','Relajado','BAJO','Pequeño','Sin restricciones','BAJO','Baños cercanos','Walking','Architecture','Evitar escaleras largas','Le gustan tours pequeños.','https://example.com/avatars/pedro.jpg','https://example.com/covers/pedro.jpg'),
(13,'Chicago, USA','Traveler focused on photography tours.','2025-02-21','Photo hunter','Urban, Photography','Solo','Dinámico','MODERADO','Flexible','No restrictions','INTERMEDIO','WiFi','Public transport','Urban photography','None','Prefers sunset tours.','https://example.com/avatars/mark.jpg','https://example.com/covers/mark.jpg'),
(14,'Paris, France','Loves museums and art galleries.','2025-01-12','Art lover','Art, Cultural','Pareja','Tranquilo','BAJO','Privado','Sin gluten','INTERMEDIO','Accesos sencillos','Walking','Art','Avoid crowded areas','Prefers bilingual guides.','https://example.com/avatars/amelie.jpg','https://example.com/covers/amelie.jpg'),
(15,'Bogotá, Colombia','Busca experiencias auténticas locales.','2025-02-05','Local seeker','Cultural','Solo','Relajado','MODERADO','Flexible','Sin restricciones','INTERMEDIO','WiFi','Walking','Urban','None','Interested in street culture.','https://example.com/avatars/carlos.jpg','https://example.com/covers/carlos.jpg'),
(16,'Vancouver, Canada','Outdoor enthusiast exploring mountains.','2025-02-16','Nature explorer','Adventure, Nature','Solo','Activo','ALTO','Flexible','No restrictions','ALTO','Water','Hiking','Landscape','None','Prefers eco guides.','https://example.com/avatars/lucas.jpg','https://example.com/covers/lucas.jpg');


INSERT IGNORE INTO `guide_profiles` (`user_id`, `summary`, `story`, `status_text`, `hourly_rate`, `currency`, `rating_avg`, `reviews_count`, `location_label`, `experience_level`, `style`, `group_size`, `tour_intensity`, `transport_offered`, `photo_style`, `additional_notes`, `avatar_url`, `cover_url`, `post_text`, `post_image_url`, `post_caption`, `post_published_at`) VALUES
(4, 'Guía gastronómico en Guadalajara.', 'Más de 8 años compartiendo la cocina tapatía.', 'Disponible esta semana', 650.0, 'MXN', 4.8, 18, 'Guadalajara Centro', 'Senior', 'Cercano, dinámico y cultural', '1-8 personas', 'MODERADO', 'Walking tour', 'Street food', 'Incluye recomendaciones personalizadas.', 'https://example.com/guides/luis.jpg', 'https://example.com/guides/luis-cover.jpg', 'Nuevas rutas en mercados locales.', 'https://example.com/posts/luis.jpg', 'Sabores de la semana', '2026-03-03 12:00:00'),
(5, 'Nature guide for coastal and outdoor experiences.', 'Certified guide for eco-routes and soft adventure.', 'Open for weekend bookings', 900.0, 'MXN', 4.9, 24, 'Puerto Vallarta', 'Expert', 'Active, safe and upbeat', '2-10 personas', 'ALTO', 'Van + hiking', 'Nature and action', 'Great for international travelers.', 'https://example.com/guides/sofia.jpg', 'https://example.com/guides/sofia-cover.jpg', 'Sunrise hike spots available.', 'https://example.com/posts/sofia.jpg', 'Morning adventure', '2026-03-04 07:00:00'),
(6, 'Especialista en recorridos históricos y arquitectura.', 'Historiador con recorridos narrativos en Querétaro.', 'Reservas abiertas', 700.0, 'MXN', 4.7, 12, 'Querétaro Centro', 'Mid-Senior', 'Calmado, profundo y didáctico', '1-6 personas', 'BAJO', 'Walking tour', 'Architecture and details', 'Ideal para visitantes culturales.', 'https://example.com/guides/miguel.jpg', 'https://example.com/guides/miguel-cover.jpg', 'Tour de leyendas y conventos.', 'https://example.com/posts/miguel.jpg', 'Historia viva', '2026-03-02 18:00:00'),
(17,'Guía cultural en Ciudad de México.','10 años guiando tours históricos.','Disponible',750,'MXN',4.8,30,'CDMX Centro','Senior','Cultural y narrativo','1-10 personas','MODERADO','Walking','Architecture','Tours educativos.','https://example.com/guides/carlos.jpg','https://example.com/guides/carlos-cover.jpg','Nuevo tour de murales.','https://example.com/posts/carlos.jpg','Arte urbano','2026-03-01 10:00:00'),
(18,'Adventure guide in Baja California.','Especialista en rutas off-road.','Open','950','MXN',4.9,21,'Baja California','Expert','Active and fun','2-8 personas','ALTO','Jeep','Adventure','Perfect for thrill seekers.','https://example.com/guides/ana.jpg','https://example.com/guides/ana-cover.jpg','Exploring desert routes.','https://example.com/posts/ana.jpg','Adventure time','2026-03-02 08:00:00'),
(19,'Guía de museos en Guadalajara.','Historiador apasionado.','Disponible','600','MXN',4.7,15,'Guadalajara','Mid','Calm and educational','1-6 personas','BAJO','Walking','Art','Tours tranquilos.','https://example.com/guides/pablo.jpg','https://example.com/guides/pablo-cover.jpg','Nuevo recorrido cultural.','https://example.com/posts/pablo.jpg','Arte local','2026-03-04 15:00:00'),
(20,'Food tour expert in Oaxaca.','Chef convertido en guía local.','Available','800','MXN',4.9,28,'Oaxaca','Expert','Food focused','2-8 personas','MODERADO','Walking','Food','Authentic cuisine tours.','https://example.com/guides/roberto.jpg','https://example.com/guides/roberto-cover.jpg','Street food tour.','https://example.com/posts/roberto.jpg','Sabores','2026-03-05 13:00:00'),
(21,'Nature guide in Chiapas.','Eco tourism specialist.','Available','850','MXN',4.8,19,'Chiapas','Expert','Eco friendly','2-6 personas','MODERADO','Van','Nature','Eco experiences.','https://example.com/guides/sofia2.jpg','https://example.com/guides/sofia2-cover.jpg','Selva adventures.','https://example.com/posts/sofia2.jpg','Selva','2026-03-03 09:00:00'),
(22,'Urban photographer guide.','Photographer sharing best spots.','Open','700','MXN',4.6,14,'Monterrey','Mid','Creative and relaxed','1-5 personas','MODERADO','Walking','Photography','Great for content creators.','https://example.com/guides/lina.jpg','https://example.com/guides/lina-cover.jpg','Sunset photo tour.','https://example.com/posts/lina.jpg','Golden hour','2026-03-05 18:00:00'),
(23,'Cultural storyteller guide.','Storytelling tours in Puebla.','Available','680','MXN',4.7,17,'Puebla','Mid','Narrative and calm','1-7 personas','BAJO','Walking','Historic','Legends and stories.','https://example.com/guides/diego.jpg','https://example.com/guides/diego-cover.jpg','Night legends tour.','https://example.com/posts/diego.jpg','Leyendas','2026-03-04 20:00:00'),
(24,'Adventure hiking guide.','Mountain climber and guide.','Open','900','MXN',4.9,22,'Nevado de Toluca','Expert','Energetic','2-6 personas','ALTO','Hiking','Nature','Safety focused tours.','https://example.com/guides/julia.jpg','https://example.com/guides/julia-cover.jpg','Climbing season.','https://example.com/posts/julia.jpg','Cumbre','2026-03-02 06:00:00'),
(25,'City culture guide in Mérida.','Local historian sharing Yucatán culture.','Available','720','MXN',4.8,16,'Mérida','Senior','Friendly and cultural','1-8 personas','MODERADO','Walking','Architecture','Yucatán heritage tours.','https://example.com/guides/mario.jpg','https://example.com/guides/mario-cover.jpg','Colonial city tour.','https://example.com/posts/mario.jpg','Historia','2026-03-01 17:00:00'),
(26,'Beach experience guide.','Water sports and beach tours.','Open','880','MXN',4.7,20,'Cancún','Expert','Active','2-10 personas','ALTO','Boat','Beach','Water adventures.','https://example.com/guides/valeria.jpg','https://example.com/guides/valeria-cover.jpg','Snorkel routes.','https://example.com/posts/valeria.jpg','Ocean','2026-03-03 11:00:00');

INSERT IGNORE INTO `tourist_profile_languages` (`user_id`, `language_code`) VALUES
(1, 'es'),
(2, 'en'),
(3, 'fr');

INSERT IGNORE INTO `guide_profile_languages` (`user_id`, `language_code`) VALUES
(4, 'es'),
(5, 'en'),
(6, 'es');

INSERT IGNORE INTO `tourist_profile_interests` (`user_id`, `interest_id`) VALUES
(1, 1),
(2, 2),
(3, 3);

INSERT IGNORE INTO `guide_profile_expertise` (`user_id`, `expertise_id`) VALUES
(4, 1),
(5, 2),
(6, 3);

INSERT IGNORE INTO `guide_locations` (`guide_location_id`, `user_id`, `location_name`) VALUES
(1, 4, 'Mercado Libertad'),
(2, 5, 'Los Arcos de Mismaloya'),
(3, 6, 'Centro Histórico de Querétaro');

INSERT IGNORE INTO `guide_certifications` (`certification_id`, `user_id`, `name`) VALUES
(1, 4, 'Certificación en Turismo Gastronómico'),
(2, 5, 'First Aid Outdoor Guide'),
(3, 6, 'Guía de Patrimonio Cultural');

INSERT IGNORE INTO `guide_adaptations` (`adaptation_id`, `user_id`, `name`) VALUES
(1, 4, 'Opciones vegetarianas'),
(2, 5, 'Rutas de baja dificultad'),
(3, 6, 'Recorridos con descansos frecuentes');

INSERT IGNORE INTO `compatibility_profiles` (`compatibility_profile_id`, `user_id`, `role`, `name`, `img_url`, `description`, `email`, `date_of_birth`, `phone_country_code`, `phone_number`, `phone_e164`) VALUES
(1, 1, 'TRAVELER', 'Ana Torres', 'https://example.com/compat/ana.jpg', 'Busca experiencias culinarias y culturales.', 'ana.torres@example.com', '1997-05-14', 'MX', '3311111111', '+523311111111'),
(2, 2, 'TRAVELER', 'David Miller', 'https://example.com/compat/david.jpg', 'Le gustan naturaleza y actividad física.', 'david.miller@example.com', '1993-11-02', 'US', '2065550102', '+12065550102'),
(3, 4, 'GUIDE', 'Luis Ramírez', 'https://example.com/compat/luis.jpg', 'Guía foodie en Guadalajara.', 'luis.ramirez@example.com', '1988-02-19', 'MX', '3322222222', '+523322222222');

INSERT IGNORE INTO `compatibility_answers` (`answer_id`, `compatibility_profile_id`, `question_key`, `value_text`, `value_number`, `value_json`) VALUES
(1, 1, 'travel_style', 'Cultural, Foodie', NULL, '["cultural", "foodie"]'),
(2, 2, 'activity_level', 'ALTO', 9.0, '{"scale": 10, "value": 9}'),
(3, 3, 'guide_style', 'Cercano y cultural', NULL, '["food", "local"]');

INSERT IGNORE INTO `tours` (`tour_id`, `guide_id`, `category_id`, `title`, `description`, `price`, `currency`, `duration_hours`, `max_group_size`, `meeting_point`, `status`, `cover_image_url`, `image_class`, `rating_avg`, `bookings_count`) VALUES
(1, 4, 1, 'Sabores del Centro de Guadalajara', 'Recorrido gastronómico por mercados y fondas icónicas.', 1200.0, 'MXN', 3.5, 8, 'Rotonda de los Jaliscienses Ilustres', 'ACTIVE', 'https://example.com/tours/sabores-gdl.jpg', 'food-tour', 4.8, 15),
(2, 5, 2, 'Aventura Costera en Puerto Vallarta', 'Ruta suave de senderismo con vistas y parada fotográfica.', 1800.0, 'MXN', 4.0, 10, 'Malecón de Puerto Vallarta', 'ACTIVE', 'https://example.com/tours/pv-aventura.jpg', 'nature-tour', 4.9, 20),
(3, 6, 3, 'Historia y Leyendas de Querétaro', 'Tour narrativo por plazas, templos y calles coloniales.', 950.0, 'MXN', 2.5, 6, 'Plaza de Armas', 'ACTIVE', 'https://example.com/tours/qro-historia.jpg', 'culture-tour', 4.7, 11);

INSERT IGNORE INTO `tour_included_items` (`item_id`, `tour_id`, `item_text`, `sort_order`) VALUES
(1, 1, '3 degustaciones locales', 1),
(2, 2, 'Agua embotellada y snack', 1),
(3, 3, 'Mapa impreso del centro histórico', 1);

INSERT IGNORE INTO `tour_destinations` (`tour_id`, `destination_id`) VALUES
(1, 1),
(2, 2),
(3, 3);

INSERT IGNORE INTO `trip_bookings` (`trip_id`, `tour_id`, `tourist_id`, `guide_id`, `start_datetime`, `end_datetime`, `status`, `cancel_reason`, `notes`) VALUES
(1, 1, 1, 4, '2026-03-10 10:00:00', '2026-03-10 13:30:00', 'CONFIRMED', NULL, 'Aniversario de pareja.'),
(2, 2, 2, 5, '2026-03-12 07:00:00', '2026-03-12 11:00:00', 'PENDING', NULL, 'Prefiere guía en inglés.'),
(3, 3, 3, 6, '2026-03-14 16:00:00', '2026-03-14 18:30:00', 'COMPLETED', NULL, 'Interesada en arquitectura religiosa.');

INSERT IGNORE INTO `trip_status_history` (`history_id`, `trip_id`, `old_status`, `new_status`, `reason`, `changed_by_user_id`, `changed_at`) VALUES
(1, 1, 'PENDING', 'CONFIRMED', 'Pago validado', 4, '2026-03-06 10:00:00'),
(2, 2, NULL, 'PENDING', 'Reserva creada', 2, '2026-03-06 10:15:00'),
(3, 3, 'CONFIRMED', 'COMPLETED', 'Tour finalizado', 6, '2026-03-06 10:30:00');

INSERT IGNORE INTO `guide_calendar_events` (`event_id`, `guide_id`, `trip_id`, `event_type`, `title`, `start_datetime`, `end_datetime`, `organizer_name`, `source`, `status`) VALUES
(1, 4, 1, 'BOOKED', 'Tour Sabores GDL - Ana', '2026-03-10 10:00:00', '2026-03-10 13:30:00', 'Luis Ramírez', 'TRIP', 'ACTIVE'),
(2, 5, 2, 'BOOKED', 'Coastal Adventure - David', '2026-03-12 07:00:00', '2026-03-12 11:00:00', 'Sofía Herrera', 'TRIP', 'ACTIVE'),
(3, 6, NULL, 'BLOCKED', 'Bloqueo por evento privado', '2026-03-15 09:00:00', '2026-03-15 12:00:00', 'Miguel Ortega', 'MANUAL', 'ACTIVE');

INSERT IGNORE INTO `favorite_guides` (`tourist_id`, `guide_id`, `created_at`) VALUES
(1, 4, '2026-03-05 12:00:00'),
(2, 5, '2026-03-05 12:05:00'),
(3, 6, '2026-03-05 12:10:00');

INSERT IGNORE INTO `favorite_tours` (`tourist_id`, `tour_id`, `created_at`) VALUES
(1, 1, '2026-03-05 12:20:00'),
(2, 2, '2026-03-05 12:25:00'),
(3, 3, '2026-03-05 12:30:00');

INSERT IGNORE INTO `reviews` (`review_id`, `trip_id`, `tour_id`, `guide_id`, `tourist_id`, `rating`, `comment`, `likes_count`, `replies_count`, `created_at`, `updated_at`, `deleted_at`) VALUES
(1, 1, 1, 4, 1, 5, 'Excelente tour gastronómico y muy auténtico.', 4, 1, '2026-03-11 18:00:00', '2026-03-11 18:00:00', NULL),
(2, 2, 2, 5, 2, 4, 'Muy buena energía y rutas seguras.', 2, 0, '2026-03-12 19:00:00', '2026-03-12 19:00:00', NULL),
(3, 3, 3, 6, 3, 5, 'Narrativa impecable y ritmo muy agradable.', 3, 1, '2026-03-14 20:00:00', '2026-03-14 20:00:00', NULL);

INSERT IGNORE INTO `review_replies` (`reply_id`, `review_id`, `guide_id`, `message`, `created_at`, `updated_at`) VALUES
(1, 1, 4, '¡Gracias por acompañarme en el recorrido!', '2026-03-11 19:00:00', '2026-03-11 19:00:00'),
(2, 2, 5, 'Thanks for trusting the route and the team.', '2026-03-12 20:00:00', '2026-03-12 20:00:00'),
(3, 3, 6, 'Fue un placer compartir la historia de la ciudad.', '2026-03-14 21:00:00', '2026-03-14 21:00:00');

INSERT IGNORE INTO `chat_threads` (`thread_id`, `trip_id`, `tourist_id`, `guide_id`, `last_message_at`, `status`, `created_at`) VALUES
(1, 1, 1, 4, '2026-03-09 21:00:00', 'ACTIVE', '2026-03-08 09:00:00'),
(2, 2, 2, 5, '2026-03-11 15:30:00', 'ACTIVE', '2026-03-10 08:00:00'),
(3, 3, 3, 6, '2026-03-13 17:45:00', 'ACTIVE', '2026-03-12 10:00:00');

INSERT IGNORE INTO `chat_messages` (`message_id`, `thread_id`, `sender_user_id`, `body`, `message_type`, `sent_at`, `read_at`) VALUES
(1, 1, 1, 'Hola Luis, ¿hay opciones vegetarianas?', 'TEXT', '2026-03-09 20:50:00', '2026-03-09 20:55:00'),
(2, 2, 5, 'Hi David, bring comfortable shoes please.', 'TEXT', '2026-03-11 15:25:00', '2026-03-11 15:26:00'),
(3, 3, 3, '¿Podemos hacer una parada extra para fotos?', 'TEXT', '2026-03-13 17:40:00', '2026-03-13 17:42:00');

INSERT IGNORE INTO `notifications` (`notification_id`, `user_id`, `type`, `title`, `body`, `related_entity_type`, `related_entity_id`, `is_read`, `created_at`, `read_at`) VALUES
(1, 1, 'BOOKING_CONFIRMED', 'Reserva confirmada', 'Tu tour en Guadalajara fue confirmado.', 'trip_booking', 1, 0, '2026-03-06 11:00:00', NULL),
(2, 5, 'NEW_MESSAGE', 'Nuevo mensaje', 'Tienes un nuevo mensaje de David.', 'chat_thread', 2, 1, '2026-03-11 15:30:00', '2026-03-11 15:31:00'),
(3, 3, 'REVIEW_REPLY', 'Respuesta a tu reseña', 'Miguel respondió a tu comentario.', 'review', 3, 0, '2026-03-14 21:10:00', NULL);

INSERT IGNORE INTO `support_tickets` (`ticket_id`, `user_id`, `role_context`, `full_name`, `email`, `subject`, `category`, `message`, `status`, `created_at`, `updated_at`) VALUES
(1, 1, 'TOURIST', 'Ana Torres', 'ana.torres@example.com', 'Cambio de horario', 'RESERVAS_VIAJES', '¿Puedo mover el tour una hora después?', 'OPEN', '2026-03-06 12:00:00', '2026-03-06 12:00:00'),
(2, 5, 'GUIDE', 'Sofía Herrera', 'sofia.herrera@example.com', 'Duda de pagos', 'PAGOS_FACTURACION', 'Necesito revisar un depósito pendiente.', 'IN_PROGRESS', '2026-03-06 12:10:00', '2026-03-06 13:00:00'),
(3, NULL, 'GUEST', 'Carlos Gómez', 'carlos.gomez@example.com', 'Consulta general', 'GENERAL', 'Quiero saber cómo registrarme como guía.', 'OPEN', '2026-03-06 12:20:00', '2026-03-06 12:20:00');

INSERT IGNORE INTO `support_ticket_attachments` (`attachment_id`, `ticket_id`, `file_url`, `file_name`, `mime_type`, `file_size_bytes`, `uploaded_at`) VALUES
(1, 1, 'https://example.com/files/ticket1-comprobante.pdf', 'comprobante.pdf', 'application/pdf', 245000, '2026-03-06 12:05:00'),
(2, 2, 'https://example.com/files/ticket2-estado.png', 'estado.png', 'image/png', 540000, '2026-03-06 12:15:00'),
(3, 3, 'https://example.com/files/ticket3-pregunta.txt', 'pregunta.txt', 'text/plain', 1200, '2026-03-06 12:25:00');

-- INSERT IGNORE INTO `newsletter_subscriptions` (`subscription_id`, `email`, `source_page`, `is_active`, `created_at`, `unsubscribed_at`) VALUES
-- (1, 'newsletter.ana@example.com', 'home', 1, '2026-03-05 09:00:00', NULL),
-- (2, 'newsletter.david@example.com', 'blog', 1, '2026-03-05 09:05:00', NULL),
-- (3, 'newsletter.claire@example.com', 'landing-guides', 0, '2026-03-05 09:10:00', '2026-03-05 10:00:00');

INSERT IGNORE INTO `contact_messages` (`contact_message_id`, `name`, `email`, `subject`, `message`, `source_page`, `status`, `created_at`) VALUES
(1, 'Andrea López', 'andrea.lopez@example.com', 'Colaboración', 'Quisiera colaborar con experiencias gastronómicas.', 'contact', 'NEW', '2026-03-05 10:00:00'),
(2, 'John Parker', 'john.parker@example.com', 'Media inquiry', 'We are interested in featuring your platform.', 'press', 'READ', '2026-03-05 10:10:00'),
(3, 'Lucía Pérez', 'lucia.perez@example.com', 'Soporte', 'No pude completar mi registro.', 'help-center', 'ARCHIVED', '2026-03-05 10:20:00');

INSERT IGNORE INTO `auth_sessions` (`session_id`, `user_id`, `token_hash`, `expires_at`, `revoked_at`, `ip`, `user_agent`, `created_at`) VALUES
(1, 1, 'aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa', '2026-03-15 23:59:59', NULL, '189.203.1.10', 'PostmanRuntime/7.43.0', '2026-03-05 08:00:00'),
(2, 4, 'bbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbbb', '2026-03-15 23:59:59', NULL, '189.203.1.11', 'Mozilla/5.0', '2026-03-05 08:05:00'),
(3, 5, 'cccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccccc', '2026-03-15 23:59:59', '2026-03-06 18:00:00', '189.203.1.12', 'PostmanRuntime/7.43.0', '2026-03-05 08:10:00');

-- INSERT IGNORE INTO `income_transactions` (`transaction_id`, `guide_id`, `trip_id`, `tour_id`, `txn_type`, `amount`, `sign`, `status`, `description`, `occurred_at`, `created_at`) VALUES
-- (1, 4, 1, 1, 'BOOKING_INCOME', 1200.0, 'CREDIT', 'COMPLETED', 'Ingreso por tour gastronómico', '2026-03-10 14:00:00', '2026-03-10 14:00:00'),
-- (2, 5, 2, 2, 'BOOKING_INCOME', 1800.0, 'CREDIT', 'PENDING', 'Ingreso por tour de aventura', '2026-03-12 11:30:00', '2026-03-12 11:30:00'),
-- (3, 6, 3, 3, 'ADJUSTMENT', 150.0, 'CREDIT', 'COMPLETED', 'Ajuste manual por servicio extra', '2026-03-14 19:00:00', '2026-03-14 19:00:00');

-- INSERT IGNORE INTO `withdrawal_requests` (`withdrawal_id`, `guide_id`, `requested_amount`, `status`, `bank_reference`, `notes`, `requested_at`, `processed_at`, `processed_by_user_id`) VALUES
-- (1, 4, 800.0, 'PENDING', NULL, 'Retiro semanal', '2026-03-11 09:00:00', NULL, NULL),
-- (2, 5, 1500.0, 'APPROVED', 'APR-20260312-01', 'Pago parcial de servicios', '2026-03-12 09:00:00', '2026-03-12 14:00:00', 4),
-- (3, 6, 700.0, 'PAID', 'PAY-20260314-07', 'Transferencia completada', '2026-03-14 09:00:00', '2026-03-14 16:00:00', 5);

INSERT IGNORE INTO `faq_categories` (`faq_category_id`, `name`, `role_scope`, `sort_order`) VALUES
(1, 'Reservas', 'TOURIST', 1),
(2, 'Pagos', 'GUIDE', 2),
(3, 'Cuenta', 'BOTH', 3);

INSERT IGNORE INTO `faq_items` (`faq_item_id`, `faq_category_id`, `question`, `answer`, `is_active`, `sort_order`) VALUES
(1, 1, '¿Cómo confirmo mi reserva?', 'Recibirás una notificación cuando el guía acepte tu solicitud.', 1, 1),
(2, 2, '¿Cuándo recibo mis pagos?', 'Los pagos se procesan según el estado del tour y las políticas internas.', 1, 1),
(3, 3, '¿Cómo cambio mi contraseña?', 'Puedes actualizarla desde el perfil cuando esa funcionalidad esté habilitada.', 1, 1);