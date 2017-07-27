--
-- База данных: `statrix`
--

-- --------------------------------------------------------

--
-- Структура таблицы `sx_users`
--

CREATE TABLE `sx_users` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(128) NOT NULL,
  `email` VARCHAR(128) NOT NULL,
  `password` VARCHAR(128),
  `admin_id` INT(11),
  `subscription_id` INT (11),
  `is_root` TINYINT DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `sx_chargings`
--

CREATE TABLE `sx_chargings` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `title` VARCHAR(128) NOT NULL,
  `sites_count` SMALLINT UNSIGNED,
  `persons_count` SMALLINT UNSIGNED,
  `users_count` SMALLINT UNSIGNED,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `sx_subscriptions`
--

CREATE TABLE `sx_subscriptions` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `charging_id` INT(11) NOT NULL,
  `start_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `end_date` DATETIME NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `sx_keywords`
--

CREATE TABLE `sx_keywords` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `person_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `sx_pages`
--

CREATE TABLE `sx_pages` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `url` VARCHAR(2048) NOT NULL,
  `site_id` INT(11) NOT NULL,
  `founded_date_time` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_scan_date` DATETIME NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `sx_person_page_rank`
--

CREATE TABLE `sx_person_page_rank` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `person_Id` INT(11) NOT NULL,
  `page_id` INT(11) NOT NULL,
  `rank` INT(11) UNSIGNED NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `sx_persons`
--

CREATE TABLE `sx_persons` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `is_default` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `sx_sites`
--

CREATE TABLE `sx_sites` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(255) NOT NULL,
  `url` VARCHAR(255) NOT NULL,
  `is_default` TINYINT NOT NULL DEFAULT 0,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `sx_subscriptions_sites`
--

CREATE TABLE `sx_subscriptions_sites` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `subscription_id` INT(11) NOT NULL,
  `site_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- --------------------------------------------------------

--
-- Структура таблицы `sx_subscriptions_persons`
--

CREATE TABLE `sx_subscriptions_persons` (
  `id` INT(11) NOT NULL AUTO_INCREMENT,
  `subscription_id` INT(11) NOT NULL,
  `person_id` INT(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


--
-- Индексы таблицы `sx_users`
--
ALTER TABLE `sx_users`
  ADD UNIQUE KEY `unique_email` (`email`),
  ADD KEY `key_subscription_id` (`subscription_id`),
  ADD KEY `key_admin_id` (`admin_id`);

--
-- Индексы таблицы `sx_keywords`
--
ALTER TABLE `sx_keywords`
  ADD UNIQUE KEY `unique_keywords` (`name`,`person_id`);

--
-- Индексы таблицы `sx_pages`
--
ALTER TABLE `sx_pages`
  ADD KEY `key_site_id` (`site_id`);

--
-- Индексы таблицы `sx_person_page_rank`
--
ALTER TABLE `sx_person_page_rank`
  ADD KEY `key_person_id` (`person_id`),
  ADD KEY `key_page_id` (`page_id`);

--
-- Индексы таблицы `sx_persons`
--
ALTER TABLE `sx_persons`
  ADD UNIQUE KEY `unique_persons` (`name`);

--
-- Индексы таблицы `sx_sites`
--
ALTER TABLE `sx_sites`
  ADD UNIQUE KEY `unique_sites` (`url`);

--
-- Индексы таблицы `sx_charging`
--
ALTER TABLE `sx_chargings`
  ADD UNIQUE KEY `sxu_unique_charging_title` (`title`);

--
-- Индексы таблицы `sx_subscriptions_sites`
--
ALTER TABLE `sx_subscriptions_sites`
  ADD UNIQUE KEY `sxu_unique_subscriptions_sites` (`subscription_id`,`site_id`);

--
-- Индексы таблицы `sx_subscriptions_persons`
--
ALTER TABLE `sx_subscriptions_persons`
  ADD UNIQUE KEY `sxu_unique_subscriptions_persons` (`subscription_id`,`person_id`);

--
-- Ограничения внешнего ключа сохраненных таблиц
--

--
-- Ограничения внешнего ключа таблицы `sx_users`
--
ALTER TABLE `sx_users`
  ADD CONSTRAINT `sxc_users_admin` FOREIGN KEY (`admin_id`) REFERENCES `sx_users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `sxc_users_subscription` FOREIGN KEY (`subscription_id`) REFERENCES `sx_subscriptions` (`id`) ON DELETE SET NULL ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `sx_subscriptions`
--
ALTER TABLE `sx_subscriptions`
  ADD CONSTRAINT `sx_subscriptions_charging` FOREIGN KEY (`charging_id`) REFERENCES `sx_chargings` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `sx_pages`
--
ALTER TABLE `sx_pages`
  ADD CONSTRAINT `sxc_pages_sites` FOREIGN KEY (`site_id`) REFERENCES `sx_sites` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `sx_person_page_rank`
--
ALTER TABLE `sx_person_page_rank`
  ADD CONSTRAINT `sxc_person_page_rank_page` FOREIGN KEY (`page_id`) REFERENCES `sx_pages` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `sxc_person_page_rank_person` FOREIGN KEY (`person_id`) REFERENCES `sx_persons` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `sx_subscriptions_sites`
--
ALTER TABLE `sx_subscriptions_sites`
  ADD CONSTRAINT `sxc_subscriptions_sites_site` FOREIGN KEY (`site_id`) REFERENCES `sx_sites` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `sxc_subscriptions_sites_subscription` FOREIGN KEY (`subscription_id`) REFERENCES `sx_subscriptions` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `sx_subscriptions_persons`
--
ALTER TABLE `sx_subscriptions_persons`
  ADD CONSTRAINT `sxc_subscriptions_persons_person` FOREIGN KEY (`person_id`) REFERENCES `sx_persons` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `sxc_subscriptions_persons_subscription` FOREIGN KEY (`subscription_id`) REFERENCES `sx_subscriptions` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Ограничения внешнего ключа таблицы `sx_keywords`
--
ALTER TABLE `sx_keywords`
  ADD CONSTRAINT `sxc_keywords_person` FOREIGN KEY (`person_id`) REFERENCES `sx_persons` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
