use yiibai;

-- user
INSERT INTO `user` VALUES ('1', 'yiibai', '100', '2015-09-23 20:11:23');

-- post
INSERT INTO `post` VALUES ('1', '1', 'MyBatis關聯數據查詢', '在實際項目中，經常使用關聯表的查詢，比如：多對一，一對多等。這些查詢是如何處理的呢，這一講就講這個問題。我們首先創建一個 post 表，並初始化數據.', '2015-09-23 21:40:17');
INSERT INTO `post` VALUES ('2', '1', 'MyBatis開發環境搭建', '為了方便學習，這裡直接建立java 工程，但一般都是開發 Web 項目。', '2015-09-23 21:42:14');
INSERT INTO `post` VALUES ('3', '2', '這個是別人發的', 'content,內容...', '0000-00-00 00:00:00');