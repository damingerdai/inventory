-- --------------------------------------------------------
-- 主机:                           127.0.0.1
-- 服务器版本:                        8.0.11 - MySQL Community Server - GPL
-- 服务器操作系统:                      Win64
-- HeidiSQL 版本:                  9.5.0.5249
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

-- 正在导出表  gift_store.gift 的数据：~2 rows (大约)
/*!40000 ALTER TABLE `gift` DISABLE KEYS */;
INSERT INTO `gift` (`id`, `code`, `name`, `num`, `create_date`, `create_user`, `update_date`, `update_user`) VALUES
	(1, '1', '熊本熊', 100, '2018-07-10 21:00:36', 'system', '2018-07-10 21:00:42', 'system'),
	(2, '2', '哈士奇', 120, '2018-07-11 21:38:02', 'system', '2018-07-11 21:38:09', 'system');
/*!40000 ALTER TABLE `gift` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
