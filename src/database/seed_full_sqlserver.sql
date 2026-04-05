-- SQL Server full seed converted from MySQL initTables.sql
USE java_nuochoa;
GO

SET XACT_ABORT ON;
BEGIN TRAN;

EXEC sp_MSforeachtable 'ALTER TABLE ? NOCHECK CONSTRAINT ALL';

DELETE FROM invoicedetail;
DELETE FROM importreceiptdetail;
DELETE FROM perfume_notes;
DELETE FROM perfume_volume;
DELETE FROM invoice;
DELETE FROM importreceipt;
DELETE FROM role_rolegroup;
DELETE FROM employee;
DELETE FROM perfume;
DELETE FROM customer;
DELETE FROM supplier;
DELETE FROM notes;
DELETE FROM promotion;
DELETE FROM brand;
DELETE FROM volume;
DELETE FROM rolegroup;
DELETE FROM [role];

SET IDENTITY_INSERT brand ON;
INSERT INTO brand (id, name, is_deleted) VALUES
(1, 'Chanel', 0),
                                                     (2, 'Dior', 0),
                                                     (3, 'Gucci', 0),
                                                     (4, 'Yves Saint Laurent', 0),
                                                     (5, 'Versace', 0),
                                                     (6, 'Tom Ford', 0),
                                                     (7, 'Burberry', 0),
                                                     (8, 'Calvin Klein', 0),
                                                     (9, 'Givenchy', 0),
                                                     (10, 'Hugo Boss', 0),
                                                     (11, 'Lelabo', 0),
                                                     (12, 'Dolge & Gabana', 0);
SET IDENTITY_INSERT brand OFF;

SET IDENTITY_INSERT customer ON;
INSERT INTO customer (id, name, phone, email, is_deleted) VALUES
(1, N'Nguyễn Văn An', '0905123456', 'annguyen@example.com', 0),
                                                                          (2, N'Trần Thị Bích', '0916234567', 'bichtran@example.com', 0),
                                                                          (3, N'Lê Hữu Cường', '0927345678', 'cuongle@example.com', 0),
                                                                          (4, N'Phạm Thị Dung', '0938456789', 'dungpham@example.com', 0),
                                                                          (5, N'Hoàng Văn Đông', '0949567890', 'donghoang@example.com', 0),
                                                                          (6, N'Đặng Thị Hoa', '0951678901', 'hoadang@example.com', 0),
                                                                          (7, N'Võ Minh Khang', '0962789012', 'khangvo@example.com', 0),
                                                                          (8, N'Bùi Thị Lan', '0973890123', 'lanbui@example.com', 0),
                                                                          (9, N'Dương Thành Nam', '0984901234', 'namduong@example.com', 0),
                                                                          (10, N'Lý Thị Oanh', '0995012345', 'oanhly@example.com', 0),
                                                                          (11, N'Phan Văn Phúc', '0906123456', 'phucphan@example.com', 0),
                                                                          (12, N'Tạ Thị Quỳnh', '0917234567', 'quynhta@example.com', 0),
                                                                          (13, N'Ngô Hoàng Sơn', '0928345678', 'sonngo@example.com', 0),
                                                                          (14, N'Hồ Thị Thanh', '0939456789', 'thanhho@example.com', 0),
                                                                          (15, N'Lâm Chí Vĩnh', '0940567890', 'vinhlam@example.com', 0),
                                                                          (16, N'Phạm Tường Vy', '0564337862', 'vy123@gmail.com', 0),
                                                                          (17, N'Lê Lý Lan Hương', '0933467531', 'huonglele@gmail.com', 0),
                                                                          (18, N'Nguyễn Thị Hồng', '0909837632', 'longthihe@gmail.com', 0);
SET IDENTITY_INSERT customer OFF;

SET IDENTITY_INSERT employee ON;
INSERT INTO employee (id, rolegroup_id, name, username, password, status, is_deleted) VALUES
(1, 1, N'Nguyễn Văn An', 'annguyen', 'an123', 1, 0),
                                                                                                          (2, 2, N'Trần Thị Bích', 'bichtran', 'bich456', 1, 0),
                                                                                                          (3, 2, N'Lê Hoàng Nam', 'namle', 'nam789', 1, 0),
                                                                                                          (4, 2, N'Phạm Hữu Phúc', 'phucpham', 'phuc321', 0, 0),
                                                                                                          (5, 2, N'Đỗ Thanh Tâm', 'tamdo', 'tam654', 1, 0),
                                                                                                          (6, 2, N'Lê Huỳnh Thái Vy', 'vyvymoon', 'vyh135', 0, 0);
SET IDENTITY_INSERT employee OFF;

SET IDENTITY_INSERT importreceipt ON;
INSERT INTO importreceipt (id, supplier_id, import_date, total_cost, is_deleted) VALUES
(1, 1, '2025-04-01 08:00:00', 33500000, 0),
                                                                                                 (2, 2, '2025-04-02 09:00:00', 44000000, 0),
                                                                                                 (3, 3, '2025-04-03 10:15:00', 33000000, 0),
                                                                                                 (4, 4, '2025-04-04 11:30:00', 44400000, 0),
                                                                                                 (5, 5, '2025-04-05 14:45:00', 33400000, 0),
                                                                                                 (6, 1, '2025-05-07 10:36:56', 147400000, 0),
                                                                                                 (7, 1, '2025-11-02 09:13:17', 125000000, 0),
                                                                                                 (8, 5, '2025-11-06 07:05:56', 7000000, 0);
SET IDENTITY_INSERT importreceipt OFF;

INSERT INTO importreceiptdetail (import_receipt_id, perfume_id, quantity, volume_id) VALUES
(1, 1, 10, 6),
                                                                                                   (1, 2, 5, 6),
                                                                                                   (2, 3, 8, 6),
                                                                                                   (8, 3, 2, 6),
                                                                                                   (2, 4, 4, 6),
                                                                                                   (3, 5, 15, 6),
                                                                                                   (6, 5, 67, 6),
                                                                                                   (4, 6, 6, 6),
                                                                                                   (4, 7, 10, 6),
                                                                                                   (5, 8, 5, 6),
                                                                                                   (5, 9, 3, 6),
                                                                                                   (5, 10, 2, 6),
                                                                                                   (7, 11, 50, 5);

SET IDENTITY_INSERT invoice ON;
INSERT INTO invoice (id, customer_id, employee_id, total, issue_date) VALUES
(1, 1, 1, 10000000, '2025-04-01 10:00:00'),
                                                                                      (2, 2, 2, 7600000, '2025-04-02 11:30:00'),
                                                                                      (3, 3, 3, 8100000, '2025-04-03 09:45:00'),
                                                                                      (4, 4, 5, 10000000, '2025-04-04 14:20:00'),
                                                                                      (5, 5, 1, 10450000, '2025-04-05 16:15:00'),
                                                                                      (6, 1, 1, 8800000, '2025-05-07 10:34:10'),
                                                                                      (7, 14, 1, 27000000, '2025-11-01 11:00:15'),
                                                                                      (8, 2, 1, 3250000, '2025-11-02 09:38:45'),
                                                                                      (9, 3, 1, 10000000, '2025-11-02 09:48:51'),
                                                                                      (10, 4, 1, 8800000, '2025-11-06 06:45:15');
SET IDENTITY_INSERT invoice OFF;

INSERT INTO invoicedetail (invoice_id, perfume_id, quantity, volume_id) VALUES
(1, 1, 2, 6),
                                                                                      (2, 2, 1, 6),
                                                                                      (1, 3, 1, 6),
                                                                                      (9, 3, 2, 6),
                                                                                      (2, 4, 1, 6),
                                                                                      (6, 4, 2, 6),
                                                                                      (10, 4, 2, 6),
                                                                                      (3, 5, 3, 6),
                                                                                      (7, 5, 10, 6),
                                                                                      (4, 6, 1, 6),
                                                                                      (4, 7, 2, 6),
                                                                                      (5, 8, 2, 6),
                                                                                      (5, 10, 1, 6),
                                                                                      (8, 10, 1, 6);

SET IDENTITY_INSERT notes ON;
INSERT INTO notes (id, note_name, is_deleted) VALUES
(1, N'Hoa Hồng', 0),
                                                          (2, N'Hoa Nhài', 0),
                                                          (3, N'Hoa Oải Hương', 0),
                                                          (4, N'Hoa Ly', 0),
                                                          (5, N'Hoa Violet', 0),
                                                          (6, N'Hoa Mẫu Đơn', 0),
                                                          (7, N'Hoa Lan', 0),
                                                          (8, N'Hoa Dành Dành', 0),
                                                          (9, N'Hoa Mộc Lan', 0),
                                                          (10, N'Hoa Lan Nam Phi', 0),
                                                          (11, N'Táo', 0),
                                                          (12, N'Lê', 0),
                                                          (13, N'Đào', 0),
                                                          (14, N'Mâm Xôi Đen', 0),
                                                          (15, N'Mâm Xôi Đỏ', 0),
                                                          (16, N'Dâu Tây', 0),
                                                          (17, N'Anh Đào', 0),
                                                          (18, N'Dứa', 0),
                                                          (19, N'Dừa', 0),
                                                          (20, N'Dưa Gang', 0),
                                                          (21, N'Chanh', 0),
                                                          (22, N'Cam', 0),
                                                          (23, N'Cam Bergamot', 0),
                                                          (24, N'Bưởi', 0),
                                                          (25, N'Quýt', 0),
                                                          (26, N'Gỗ Đàn Hương', 0),
                                                          (27, N'Gỗ Tuyết Tùng', 0),
                                                          (28, N'Hoắc Hương', 0),
                                                          (29, N'Cỏ Hương Bài', 0),
                                                          (30, N'Trầm Hương', 0),
                                                          (31, N'Quế', 0),
                                                          (32, N'Đinh Hương', 0),
                                                          (33, N'Bạch Đậu Khấu', 0),
                                                          (34, N'Gừng', 0),
                                                          (35, N'Nhục Đậu Khấu', 0),
                                                          (36, N'Vani', 0),
                                                          (37, N'Đậu Tonka', 0),
                                                          (38, N'Muối Biển', 0),
                                                          (39, N'Hương Biển', 0),
                                                          (40, N'Hương Ozone', 0),
                                                          (41, N'Hương Aldehyde', 0),
                                                          (42, N'Xạ Hương', 0),
                                                          (43, N'Long Diên Hương', 0),
                                                          (44, N'Cầy Hương', 0),
                                                          (45, N'Da Thuộc', 0),
                                                          (46, N'Rêu Sồi', 0),
                                                          (47, N'Húng Quế', 0),
                                                          (48, N'Xô Thơm', 0),
                                                          (49, N'Cỏ Xạ Hương', 0),
                                                          (50, N'Bạc Hà', 0);
SET IDENTITY_INSERT notes OFF;

SET IDENTITY_INSERT perfume ON;
INSERT INTO perfume (id, name, sex, images, concentration, brand_id, promotion_id) VALUES
(1, 'Chanel No. 5', 'Female', 'chanel_no_5.jpg', 'Parfum', 1, 1),
                                                                                                       (2, 'Dior Sauvage', 'Male', 'dior-sauvage.jpg', 'EDP', 2, 2),
                                                                                                       (3, 'Gucci Bloom', 'Female', 'gucci_bloom.jpg', 'EDT', 3, 3),
                                                                                                       (4, 'Tom Ford Black Orchid', 'Female', 'tom_ford_black_orchid.jpg', 'Parfum', 6, 4),
                                                                                                       (5, 'Versace Eros', 'Male', 'versace_eros.jpg', 'EDP', 5, 5),
                                                                                                       (6, 'Yves Saint Laurent Libre', 'Female', 'ysl_libre.jpg', 'EDP', 4, 5),
                                                                                                       (7, 'Burberry London', 'Male', 'burberry_london.jpg', 'EDP', 7, 5),
                                                                                                       (8, 'Calvin Klein CK One', 'Unisex', 'ck_one.jpg', 'EDT', 8, 5),
                                                                                                       (9, 'Givenchy Gentleman', 'Male', 'givenchy_gentleman.jpg', 'EDP', 9, 5),
                                                                                                       (10, 'Hugo Boss Bottled', 'Male', 'hugo_boss_bottled.jpg', 'EDT', 10, 10),
                                                                                                       (11, 'Neroli', 'Male', 'neroli-portofino.jpg', 'Parfum', 1, 1);
SET IDENTITY_INSERT perfume OFF;

INSERT INTO perfume_notes (perfume_id, note_id, type) VALUES
(1, 1, 'heart'),
                                                                  (1, 2, 'heart'),
                                                                  (1, 3, 'heart'),
                                                                  (1, 21, 'top'),
                                                                  (1, 23, 'top'),
                                                                  (1, 26, 'base'),
                                                                  (1, 30, 'base'),
                                                                  (1, 36, 'base'),
                                                                  (1, 41, 'top'),
                                                                  (2, 3, 'heart'),
                                                                  (2, 23, 'top'),
                                                                  (2, 26, 'base'),
                                                                  (2, 27, 'base'),
                                                                  (2, 32, 'top'),
                                                                  (2, 34, 'heart'),
                                                                  (3, 1, 'Heart'),
                                                                  (3, 2, 'Top'),
                                                                  (3, 3, 'Top'),
                                                                  (3, 4, 'Heart'),
                                                                  (3, 5, 'Base'),
                                                                  (3, 6, 'Base'),
                                                                  (4, 10, 'Heart'),
                                                                  (4, 23, 'Top'),
                                                                  (4, 30, 'Base'),
                                                                  (4, 32, 'Top'),
                                                                  (4, 36, 'Base'),
                                                                  (4, 43, 'Heart'),
                                                                  (5, 11, 'Top'),
                                                                  (5, 17, 'Heart'),
                                                                  (5, 21, 'Top'),
                                                                  (5, 27, 'Base'),
                                                                  (5, 36, 'Base'),
                                                                  (5, 37, 'Heart'),
                                                                  (6, 1, 'Heart'),
                                                                  (6, 2, 'Heart'),
                                                                  (6, 3, 'Top'),
                                                                  (6, 23, 'Top'),
                                                                  (6, 27, 'Base'),
                                                                  (6, 36, 'Base'),
                                                                  (7, 26, 'Base'),
                                                                  (7, 28, 'Heart'),
                                                                  (7, 29, 'Heart'),
                                                                  (7, 30, 'Base'),
                                                                  (7, 31, 'Top'),
                                                                  (7, 32, 'Top'),
                                                                  (8, 11, 'Top'),
                                                                  (8, 12, 'Base'),
                                                                  (8, 13, 'Top'),
                                                                  (8, 16, 'Heart'),
                                                                  (8, 17, 'Heart'),
                                                                  (8, 18, 'Base'),
                                                                  (9, 1, 'Top'),
                                                                  (9, 2, 'Top'),
                                                                  (9, 3, 'Heart'),
                                                                  (9, 4, 'Heart'),
                                                                  (9, 26, 'Base'),
                                                                  (9, 30, 'Base'),
                                                                  (10, 1, 'heart'),
                                                                  (10, 2, 'heart'),
                                                                  (10, 11, 'top'),
                                                                  (10, 12, 'top'),
                                                                  (10, 26, 'base'),
                                                                  (10, 30, 'base'),
                                                                  (11, 5, 'base'),
                                                                  (11, 9, 'top'),
                                                                  (11, 12, 'heart');

INSERT INTO perfume_volume (perfume_id, volume_id, price, stock, cost) VALUES
(1, 6, 2500000, 0, 2000000),
                                                                                       (2, 6, 3200000, 0, 2700000),
                                                                                       (3, 6, 5000000, 50, 3500000),
                                                                                       (4, 6, 4400000, 46, 4000000),
                                                                                       (5, 6, 2700000, 107, 2200000),
                                                                                       (6, 6, 2800000, 50, 2400000),
                                                                                       (7, 6, 3600000, 50, 3000000),
                                                                                       (8, 6, 3600000, 50, 2800000),
                                                                                       (9, 6, 5510000, 50, 4600000),
                                                                                       (10, 6, 3250000, 49, 2800000),
                                                                                       (11, 5, 3700000, 0, 1500000);

SET IDENTITY_INSERT promotion ON;
INSERT INTO promotion (id, name, discount_percent, start_date, end_date, is_deleted) VALUES
(1, N'Giảm giá mùa hè', 15, '2025-06-01 00:00:00', '2025-06-30 23:59:59', 0),
                                                                                                       (2, N'Khuyến mãi ngày Quốc tế Phụ nữ', 20, '2025-03-08 00:00:00', '2025-03-08 23:59:59', 0),
                                                                                                       (3, N'Giảm giá Black Friday', 50, '2025-11-27 00:00:00', '2025-11-27 23:59:59', 0),
                                                                                                       (4, N'Khuyến mãi sinh nhật cửa hàng', 10, '2025-05-01 00:00:00', '2025-05-10 23:59:59', 0),
                                                                                                       (5, N'Giảm giá lễ Tết Nguyên Đán', 25, '2025-01-01 00:00:00', '2025-01-15 23:59:59', 0),
                                                                                                       (10, N'Christmas', 15, '2025-04-08 00:00:00', '2025-04-10 23:59:59', 0),
                                                                                                       (11, N'Quốc tế thiếu nhi', 5, '2025-11-05 00:00:00', '2025-11-08 23:59:59', 0);
SET IDENTITY_INSERT promotion OFF;

SET IDENTITY_INSERT [role] ON;
INSERT INTO [role] (id, name) VALUES
(1, N'Quản lý sản phẩm'),
                                      (2, N'Quản lý hóa đơn'),
                                      (3, N'Quản lý khách hàng'),
                                      (4, N'Quản lý nhân viên'),
                                      (5, N'Quản lý nhập hàng'),
                                      (6, N'Quản lý thuộc tính'),
                                      (7, N'Quản lý nhà cung cấp'),
                                      (8, N'Quản lý thống kê'),
                                      (9, N'Quản lý nhóm quyền');
SET IDENTITY_INSERT [role] OFF;

SET IDENTITY_INSERT rolegroup ON;
INSERT INTO rolegroup (id, name) VALUES
(1, N'Admin'),
                                           (2, N'Nhân viên bán hàng');
SET IDENTITY_INSERT rolegroup OFF;

INSERT INTO role_rolegroup (role_id, rolegroup_id, status) VALUES
(1, 1, 1),
                                                                       (2, 1, 1),
                                                                       (3, 1, 1),
                                                                       (4, 1, 1),
                                                                       (5, 1, 1),
                                                                       (6, 1, 1),
                                                                       (7, 1, 1),
                                                                       (8, 1, 1),
                                                                       (9, 1, 1),
                                                                       (1, 2, 0),
                                                                       (2, 2, 1),
                                                                       (3, 2, 0),
                                                                       (4, 2, 0),
                                                                       (5, 2, 1),
                                                                       (6, 2, 0),
                                                                       (7, 2, 0),
                                                                       (8, 2, 0),
                                                                       (9, 2, 0);

SET IDENTITY_INSERT supplier ON;
INSERT INTO supplier (id, name, phone, email, is_deleted) VALUES
(1, 'Luxury Fragrance Co.', '0901234567', 'contact@luxuryfragrance.com', 0),
                                                                          (2, 'Elite Perfume Distributors', '0912345678', 'info@eliteperfume.com', 0),
                                                                          (3, 'Prestige Aroma', '0923456789', 'support@prestigearoma.com', 0),
                                                                          (4, 'Exclusive Scents Ltd.', '0934567890', 'service@exclusivescents.com', 0),
                                                                          (5, 'Premium Essence Supply', '0945678901', 'sales@premiumessence.com', 0),
                                                                          (6, 'NCC D', '093334567', 'a@gmail.com', 1);
SET IDENTITY_INSERT supplier OFF;

SET IDENTITY_INSERT volume ON;
INSERT INTO volume (id, size) VALUES
(1, 5),
                                        (2, 10),
                                        (3, 15),
                                        (4, 20),
                                        (5, 30),
                                        (6, 50),
                                        (7, 75),
                                        (8, 90),
                                        (9, 100),
                                        (10, 125),
                                        (11, 150),
                                        (12, 200);
SET IDENTITY_INSERT volume OFF;

EXEC sp_MSforeachtable 'ALTER TABLE ? WITH CHECK CHECK CONSTRAINT ALL';
COMMIT TRAN;
GO