-- -----------------------------------------------------
-- Schema hackathon07
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `hackathon07` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci ;
USE `hackathon07` ;

-- -----------------------------------------------------
-- Table `hackathon07`.`ubication`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hackathon07`.`ubication` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `description` TEXT NULL DEFAULT NULL,
  `image` VARCHAR(255) NULL DEFAULT NULL,
  `latitude` DOUBLE NOT NULL,
  `link` VARCHAR(255) NULL DEFAULT NULL,
  `longitude` DOUBLE NOT NULL,
  `name` VARCHAR(255) NULL DEFAULT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 10
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;


-- -----------------------------------------------------
-- Table `hackathon07`.`noise_data`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `hackathon07`.`noise_data` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `d_bs` DOUBLE NOT NULL,
  `date` DATETIME(6) NULL DEFAULT NULL,
  `hour` INT NOT NULL,
  `noise_level` INT NOT NULL,
  `ubication_id` BIGINT NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `FKih7c5n9sna78pvk5aequtbfe8` (`ubication_id` ASC) VISIBLE,
  CONSTRAINT `FKih7c5n9sna78pvk5aequtbfe8`
    FOREIGN KEY (`ubication_id`)
    REFERENCES `hackathon07`.`ubication` (`id`))
ENGINE = InnoDB
AUTO_INCREMENT = 30001
DEFAULT CHARACTER SET = utf8mb4
COLLATE = utf8mb4_0900_ai_ci;

INSERT INTO ubication(id, description, image, latitude, link, longitude, name) VALUES
(1, "La plaza de Joanic, de las pocas que conservan el aspecto terroso de la arena, recibe el nombre de quien se encargó de urbanizarla, Esteve Joanich, nieto de los propietarios.", "https://upload.wikimedia.org/wikipedia/commons/5/54/Pla%C3%A7a_de_Joanic.JPG", 2.162636, "https://www.meet.barcelona/es/visitala-y-amala/puntos-de-interes-de-la-ciudad/la-placa-d-en-joanic-99400477411", 41.406, "Plaça de Joanic" ),
(2, "El Mercat de San Antoni, es uno de los mercados más grandes e importantes de Barcelona. Lo constituyen tres mercados: el de frescos, es decir alimentos; el de ropa, también conocido como els Encants; y el Dominical que es de libros", "https://upload.wikimedia.org/wikipedia/commons/e/ed/Mercat_de_Sant_Antoni_Reformat.jpg", 2.160936, "https://www.mercatdesantantoni.com/", 41.378803, "Mercat de Sant Antoni"),
(3, "El Templo Expiatorio de la Sagrada Familia, conocido simplemente como la Sagrada Familia, es una basílica católica de Barcelona, diseñada por el arquitecto Antoni Gaudí.", "https://upload.wikimedia.org/wikipedia/commons/6/60/Sagrada_Familia_20-7-24_edited.jpg", 2.174691, "https://sagradafamilia.org/es/home", 41.404484, "Sagrada Familia"),
(4, "Inaugurado en 1876, el antiguo mercado del Born fue el primer gran edificio de la arquitectura del hierro que se proyectó en Barcelona. Durante 95 años mantuvo su función como mercado, dividida en dos etapas: una inicial, durante la cual fue el mercado del barrio de la Ribera, y otra, a partir de 1921, actuando como mercado central de fruta y verdura de Barcelona.", "https://upload.wikimedia.org/wikipedia/commons/e/ef/Mercat_del_Born_BCN.jpg", 41.387076, "https://elbornculturaimemoria.barcelona.cat/es/explora/el-mercado/", 2.180426, "Mercat del Born"),
(5, "Inaugurado a finales del siglo XIX, El Molino es uno de los teatros con más historia de la avenida del Paral·lel. Reformado a principios del siglo XXI y reabierto en el 2010 recuperando su antiguo esplendor, las características aspas rojas de la fachada se iluminan cada noche para ofrecer espectáculo, diversión, copas y una buena comida a todos los que quieran disfrutar de una noche diferente.", "https://upload.wikimedia.org/wikipedia/commons/7/7a/Rojo_galeria.jpg", 41.37485,"https://www.barcelona.cat/es/coneixbcn/pics/el-molino-99400179259", 2.166773 ,"El Molino"),
(6, "Muchos vecinos todavía la llaman plaza de Sant Joan, por la iglesia que se construyó en 1884. En ella confluyen las calles de Astúries, Torrijos, la Església y la Santa Creu, y continúa siendo una plaza tranquila, ideal para tomar el aperitivo en alguna de sus terrazas.", "https://upload.wikimedia.org/wikipedia/commons/e/e6/Barcelona_Gr%C3%A0cia_135_%288277969638%29.jpg", 41.405117, "https://www.barcelona.cat/es/conocebcn/pics/la-plaza-de-la-virreina-99400391115", 2.157312,"Plaça de la Virreina"),
(7, "No hay nadie en el mundo que no se quede fascinado por la vida de La Rambla. En poco más de un kilómetro se despliega toda la esencia de la ciudad. Desde la plaza de Catalunya hasta el monumento de Colón, La Rambla cambia a cada paso.", "https://upload.wikimedia.org/wikipedia/commons/f/f2/15-10-27-Vista_des_de_l%27est%C3%A0tua_de_Colom_a_Barcelona-WMA_2791.jpg", 41.378242, "https://www.barcelona.cat/es/conocebcn/pics/la-rambla-99400356278", 2.175112,"Rambla"),
(8, "La plaza de la Vila de Gràcia siempre está llena de terrazas, de niños, de turistas y de vecinos de toda la vida. Castellers, cabezudos, gigantes, sardanas, bodas, conciertos y actos reivindicativos que tienen lugar durante todo el año animan una plaza que es el corazón y la esencia misma del barrio.", "https://upload.wikimedia.org/wikipedia/commons/6/61/Barcelona_Gr%C3%A0cia_094_%288276893775%29.jpg", 41.400471, "https://www.barcelona.cat/es/conocebcn/pics/la-plaza-de-la-vila-de-gracia-99400387399", 2.157441,"Plaça de la Vila de Gracia"),
(9, "La Torre Glòries, anteriormente denominada Torre Agbar, es un moderno edificio de oficinas situado en la entrada del 22@ (el distrito tecnológico de Barcelona), modifica desde 2005 el skyline de la ciudad. Es obra del arquitecto francés Jean Nouvel, que se inspira en las imágenes de un géiser, de la arquitectura de Gaudí y de la montaña de Montserrat", "https://upload.wikimedia.org/wikipedia/commons/e/e6/Torre_Agbar_-_Barcelona%2C_Spain_-_Jan_2007.jpg", 41.402124, "https://patrimoni.gencat.cat/es/coleccion/torre-glories", 2.184799,"Torre Agbar");



