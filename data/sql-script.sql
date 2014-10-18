CREATE TABLE `todos` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` text,
  PRIMARY KEY (`id`)
);

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` text,
  PRIMARY KEY (`id`)
);

ALTER TABLE todos ADD user_id int(11) NOT NULL;
ALTER TABLE todos ADD CONSTRAINT fk_user_id FOREIGN KEY (user_id) references users(id);