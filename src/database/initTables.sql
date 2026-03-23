-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th10 06, 2025 lúc 01:10 AM
-- Phiên bản máy phục vụ: 12.0.2-MariaDB
-- Phiên bản PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `java_nuochoa`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `brand`
--

CREATE TABLE `brand` (
                         `id` int(11) NOT NULL,
                         `name` varchar(255) DEFAULT NULL,
                         `is_deleted` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `brand`
--

INSERT INTO `brand` (`id`, `name`, `is_deleted`) VALUES
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

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `customer`
--

CREATE TABLE `customer` (
                            `id` int(11) NOT NULL,
                            `name` varchar(255) DEFAULT NULL,
                            `phone` varchar(20) DEFAULT NULL,
                            `email` varchar(255) DEFAULT NULL,
                            `is_deleted` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `customer`
--

INSERT INTO `customer` (`id`, `name`, `phone`, `email`, `is_deleted`) VALUES
                                                                          (1, 'Nguyễn Văn An', '0905123456', 'annguyen@example.com', 0),
                                                                          (2, 'Trần Thị Bích', '0916234567', 'bichtran@example.com', 0),
                                                                          (3, 'Lê Hữu Cường', '0927345678', 'cuongle@example.com', 0),
                                                                          (4, 'Phạm Thị Dung', '0938456789', 'dungpham@example.com', 0),
                                                                          (5, 'Hoàng Văn Đông', '0949567890', 'donghoang@example.com', 0),
                                                                          (6, 'Đặng Thị Hoa', '0951678901', 'hoadang@example.com', 0),
                                                                          (7, 'Võ Minh Khang', '0962789012', 'khangvo@example.com', 0),
                                                                          (8, 'Bùi Thị Lan', '0973890123', 'lanbui@example.com', 0),
                                                                          (9, 'Dương Thành Nam', '0984901234', 'namduong@example.com', 0),
                                                                          (10, 'Lý Thị Oanh', '0995012345', 'oanhly@example.com', 0),
                                                                          (11, 'Phan Văn Phúc', '0906123456', 'phucphan@example.com', 0),
                                                                          (12, 'Tạ Thị Quỳnh', '0917234567', 'quynhta@example.com', 0),
                                                                          (13, 'Ngô Hoàng Sơn', '0928345678', 'sonngo@example.com', 0),
                                                                          (14, 'Hồ Thị Thanh', '0939456789', 'thanhho@example.com', 0),
                                                                          (15, 'Lâm Chí Vĩnh', '0940567890', 'vinhlam@example.com', 0),
                                                                          (16, 'Phạm Tường Vy', '0564337862', 'vy123@gmail.com', 0),
                                                                          (17, 'Lê Lý Lan Hương', '0933467531', 'huonglele@gmail.com', 0),
                                                                          (18, 'Nguyễn Thị Hồng', '0909837632', 'longthihe@gmail.com', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `employee`
--

CREATE TABLE `employee` (
                            `id` int(11) NOT NULL,
                            `rolegroup_id` int(11) DEFAULT NULL,
                            `name` varchar(255) DEFAULT NULL,
                            `username` varchar(255) DEFAULT NULL,
                            `password` varchar(255) DEFAULT NULL,
                            `status` tinyint(1) DEFAULT NULL,
                            `is_deleted` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `employee`
--

INSERT INTO `employee` (`id`, `rolegroup_id`, `name`, `username`, `password`, `status`, `is_deleted`) VALUES
                                                                                                          (1, 1, 'Nguyễn Văn An', 'annguyen', 'an123', 1, 0),
                                                                                                          (2, 2, 'Trần Thị Bích', 'bichtran', 'bich456', 1, 0),
                                                                                                          (3, 2, 'Lê Hoàng Nam', 'namle', 'nam789', 1, 0),
                                                                                                          (4, 2, 'Phạm Hữu Phúc', 'phucpham', 'phuc321', 0, 0),
                                                                                                          (5, 2, 'Đỗ Thanh Tâm', 'tamdo', 'tam654', 1, 0),
                                                                                                          (6, 2, 'Lê Huỳnh Thái Vy', 'vyvymoon', 'vyh135', 0, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `importreceipt`
--

CREATE TABLE `importreceipt` (
                                 `id` int(11) NOT NULL,
                                 `supplier_id` int(11) DEFAULT NULL,
                                 `import_date` datetime DEFAULT NULL,
                                 `total_cost` double DEFAULT NULL,
                                 `is_deleted` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `importreceipt`
--

INSERT INTO `importreceipt` (`id`, `supplier_id`, `import_date`, `total_cost`, `is_deleted`) VALUES
                                                                                                 (1, 1, '2025-04-01 08:00:00', 33500000, 0),
                                                                                                 (2, 2, '2025-04-02 09:00:00', 44000000, 0),
                                                                                                 (3, 3, '2025-04-03 10:15:00', 33000000, 0),
                                                                                                 (4, 4, '2025-04-04 11:30:00', 44400000, 0),
                                                                                                 (5, 5, '2025-04-05 14:45:00', 33400000, 0),
                                                                                                 (6, 1, '2025-05-07 10:36:56', 147400000, 0),
                                                                                                 (7, 1, '2025-11-02 09:13:17', 125000000, 0),
                                                                                                 (8, 5, '2025-11-06 07:05:56', 7000000, 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `importreceiptdetail`
--

CREATE TABLE `importreceiptdetail` (
                                       `import_receipt_id` int(11) NOT NULL,
                                       `perfume_id` int(11) NOT NULL,
                                       `quantity` int(11) DEFAULT NULL,
                                       `volume_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `importreceiptdetail`
--

INSERT INTO `importreceiptdetail` (`import_receipt_id`, `perfume_id`, `quantity`, `volume_id`) VALUES
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

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `invoice`
--

CREATE TABLE `invoice` (
                           `id` int(11) NOT NULL,
                           `customer_id` int(11) DEFAULT NULL,
                           `employee_id` int(11) DEFAULT NULL,
                           `total` double DEFAULT NULL,
                           `issue_date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `invoice`
--

INSERT INTO `invoice` (`id`, `customer_id`, `employee_id`, `total`, `issue_date`) VALUES
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

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `invoicedetail`
--

CREATE TABLE `invoicedetail` (
                                 `invoice_id` int(11) NOT NULL,
                                 `perfume_id` int(11) NOT NULL,
                                 `quantity` int(11) DEFAULT NULL,
                                 `volume_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `invoicedetail`
--

INSERT INTO `invoicedetail` (`invoice_id`, `perfume_id`, `quantity`, `volume_id`) VALUES
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

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `notes`
--

CREATE TABLE `notes` (
                         `id` int(11) NOT NULL,
                         `note_name` varchar(50) DEFAULT NULL,
                         `is_deleted` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `notes`
--

INSERT INTO `notes` (`id`, `note_name`, `is_deleted`) VALUES
                                                          (1, 'Hoa Hồng', 0),
                                                          (2, 'Hoa Nhài', 0),
                                                          (3, 'Hoa Oải Hương', 0),
                                                          (4, 'Hoa Ly', 0),
                                                          (5, 'Hoa Violet', 0),
                                                          (6, 'Hoa Mẫu Đơn', 0),
                                                          (7, 'Hoa Lan', 0),
                                                          (8, 'Hoa Dành Dành', 0),
                                                          (9, 'Hoa Mộc Lan', 0),
                                                          (10, 'Hoa Lan Nam Phi', 0),
                                                          (11, 'Táo', 0),
                                                          (12, 'Lê', 0),
                                                          (13, 'Đào', 0),
                                                          (14, 'Mâm Xôi Đen', 0),
                                                          (15, 'Mâm Xôi Đỏ', 0),
                                                          (16, 'Dâu Tây', 0),
                                                          (17, 'Anh Đào', 0),
                                                          (18, 'Dứa', 0),
                                                          (19, 'Dừa', 0),
                                                          (20, 'Dưa Gang', 0),
                                                          (21, 'Chanh', 0),
                                                          (22, 'Cam', 0),
                                                          (23, 'Cam Bergamot', 0),
                                                          (24, 'Bưởi', 0),
                                                          (25, 'Quýt', 0),
                                                          (26, 'Gỗ Đàn Hương', 0),
                                                          (27, 'Gỗ Tuyết Tùng', 0),
                                                          (28, 'Hoắc Hương', 0),
                                                          (29, 'Cỏ Hương Bài', 0),
                                                          (30, 'Trầm Hương', 0),
                                                          (31, 'Quế', 0),
                                                          (32, 'Đinh Hương', 0),
                                                          (33, 'Bạch Đậu Khấu', 0),
                                                          (34, 'Gừng', 0),
                                                          (35, 'Nhục Đậu Khấu', 0),
                                                          (36, 'Vani', 0),
                                                          (37, 'Đậu Tonka', 0),
                                                          (38, 'Muối Biển', 0),
                                                          (39, 'Hương Biển', 0),
                                                          (40, 'Hương Ozone', 0),
                                                          (41, 'Hương Aldehyde', 0),
                                                          (42, 'Xạ Hương', 0),
                                                          (43, 'Long Diên Hương', 0),
                                                          (44, 'Cầy Hương', 0),
                                                          (45, 'Da Thuộc', 0),
                                                          (46, 'Rêu Sồi', 0),
                                                          (47, 'Húng Quế', 0),
                                                          (48, 'Xô Thơm', 0),
                                                          (49, 'Cỏ Xạ Hương', 0),
                                                          (50, 'Bạc Hà', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `perfume`
--

CREATE TABLE `perfume` (
                           `id` int(11) NOT NULL,
                           `name` varchar(255) DEFAULT NULL,
                           `sex` varchar(255) DEFAULT NULL,
                           `images` varchar(255) DEFAULT NULL,
                           `concentration` varchar(50) DEFAULT NULL,
                           `brand_id` int(11) DEFAULT NULL,
                           `promotion_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `perfume`
--

INSERT INTO `perfume` (`id`, `name`, `sex`, `images`, `concentration`, `brand_id`, `promotion_id`) VALUES
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

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `perfume_notes`
--

CREATE TABLE `perfume_notes` (
                                 `perfume_id` int(11) NOT NULL,
                                 `note_id` int(11) NOT NULL,
                                 `type` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `perfume_notes`
--

INSERT INTO `perfume_notes` (`perfume_id`, `note_id`, `type`) VALUES
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

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `perfume_volume`
--

CREATE TABLE `perfume_volume` (
                                  `perfume_id` int(11) NOT NULL,
                                  `volume_id` int(11) NOT NULL,
                                  `price` double DEFAULT NULL,
                                  `stock` int(11) DEFAULT 0,
                                  `cost` double DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `perfume_volume`
--

INSERT INTO `perfume_volume` (`perfume_id`, `volume_id`, `price`, `stock`, `cost`) VALUES
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

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `promotion`
--

CREATE TABLE `promotion` (
                             `id` int(11) NOT NULL,
                             `name` varchar(255) DEFAULT NULL,
                             `discount_percent` double DEFAULT NULL,
                             `start_date` datetime DEFAULT NULL,
                             `end_date` datetime DEFAULT NULL,
                             `is_deleted` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `promotion`
--

INSERT INTO `promotion` (`id`, `name`, `discount_percent`, `start_date`, `end_date`, `is_deleted`) VALUES
                                                                                                       (1, 'Giảm giá mùa hè', 15, '2025-06-01 00:00:00', '2025-06-30 23:59:59', 0),
                                                                                                       (2, 'Khuyến mãi ngày Quốc tế Phụ nữ', 20, '2025-03-08 00:00:00', '2025-03-08 23:59:59', 0),
                                                                                                       (3, 'Giảm giá Black Friday', 50, '2025-11-27 00:00:00', '2025-11-27 23:59:59', 0),
                                                                                                       (4, 'Khuyến mãi sinh nhật cửa hàng', 10, '2025-05-01 00:00:00', '2025-05-10 23:59:59', 0),
                                                                                                       (5, 'Giảm giá lễ Tết Nguyên Đán', 25, '2025-01-01 00:00:00', '2025-01-15 23:59:59', 0),
                                                                                                       (10, 'Christmas', 15, '2025-04-08 00:00:00', '2025-04-10 23:59:59', 0),
                                                                                                       (11, 'Quốc tế thiếu nhi', 5, '2025-11-05 00:00:00', '2025-11-08 23:59:59', 0);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `role`
--

CREATE TABLE `role` (
                        `id` int(11) NOT NULL,
                        `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `role`
--

INSERT INTO `role` (`id`, `name`) VALUES
                                      (1, 'Quản lý sản phẩm'),
                                      (2, 'Quản lý hóa đơn'),
                                      (3, 'Quản lý khách hàng'),
                                      (4, 'Quản lý nhân viên'),
                                      (5, 'Quản lý nhập hàng'),
                                      (6, 'Quản lý thuộc tính'),
                                      (7, 'Quản lý nhà cung cấp'),
                                      (8, 'Quản lý thống kê'),
                                      (9, 'Quản lý nhóm quyền');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `rolegroup`
--

CREATE TABLE `rolegroup` (
                             `id` int(11) NOT NULL,
                             `name` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `rolegroup`
--

INSERT INTO `rolegroup` (`id`, `name`) VALUES
                                           (1, 'Admin'),
                                           (2, 'Nhân viên bán hàng');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `role_rolegroup`
--

CREATE TABLE `role_rolegroup` (
                                  `role_id` int(11) DEFAULT NULL,
                                  `rolegroup_id` int(11) DEFAULT NULL,
                                  `status` tinyint(1) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `role_rolegroup`
--

INSERT INTO `role_rolegroup` (`role_id`, `rolegroup_id`, `status`) VALUES
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

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `supplier`
--

CREATE TABLE `supplier` (
                            `id` int(11) NOT NULL,
                            `name` varchar(255) DEFAULT NULL,
                            `phone` varchar(20) DEFAULT NULL,
                            `email` varchar(255) DEFAULT NULL,
                            `is_deleted` tinyint(1) DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `supplier`
--

INSERT INTO `supplier` (`id`, `name`, `phone`, `email`, `is_deleted`) VALUES
                                                                          (1, 'Luxury Fragrance Co.', '0901234567', 'contact@luxuryfragrance.com', 0),
                                                                          (2, 'Elite Perfume Distributors', '0912345678', 'info@eliteperfume.com', 0),
                                                                          (3, 'Prestige Aroma', '0923456789', 'support@prestigearoma.com', 0),
                                                                          (4, 'Exclusive Scents Ltd.', '0934567890', 'service@exclusivescents.com', 0),
                                                                          (5, 'Premium Essence Supply', '0945678901', 'sales@premiumessence.com', 0),
                                                                          (6, 'NCC D', '093334567', 'a@gmail.com', 1);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `volume`
--

CREATE TABLE `volume` (
                          `id` int(11) NOT NULL,
                          `size` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Đang đổ dữ liệu cho bảng `volume`
--

INSERT INTO `volume` (`id`, `size`) VALUES
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

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `brand`
--
ALTER TABLE `brand`
    ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `customer`
--
ALTER TABLE `customer`
    ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `employee`
--
ALTER TABLE `employee`
    ADD PRIMARY KEY (`id`),
  ADD KEY `rolegroup_id` (`rolegroup_id`);

--
-- Chỉ mục cho bảng `importreceipt`
--
ALTER TABLE `importreceipt`
    ADD PRIMARY KEY (`id`),
  ADD KEY `supplier_id` (`supplier_id`);

--
-- Chỉ mục cho bảng `importreceiptdetail`
--
ALTER TABLE `importreceiptdetail`
    ADD PRIMARY KEY (`perfume_id`,`volume_id`,`import_receipt_id`),
  ADD KEY `import_receipt_id` (`import_receipt_id`);

--
-- Chỉ mục cho bảng `invoice`
--
ALTER TABLE `invoice`
    ADD PRIMARY KEY (`id`),
  ADD KEY `customer_id` (`customer_id`),
  ADD KEY `employee_id` (`employee_id`);

--
-- Chỉ mục cho bảng `invoicedetail`
--
ALTER TABLE `invoicedetail`
    ADD PRIMARY KEY (`perfume_id`,`volume_id`,`invoice_id`),
  ADD KEY `invoice_id` (`invoice_id`);

--
-- Chỉ mục cho bảng `notes`
--
ALTER TABLE `notes`
    ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `perfume`
--
ALTER TABLE `perfume`
    ADD PRIMARY KEY (`id`),
  ADD KEY `brand_id` (`brand_id`),
  ADD KEY `promotion_id` (`promotion_id`);

--
-- Chỉ mục cho bảng `perfume_notes`
--
ALTER TABLE `perfume_notes`
    ADD PRIMARY KEY (`perfume_id`,`note_id`),
  ADD KEY `note_id` (`note_id`);

--
-- Chỉ mục cho bảng `perfume_volume`
--
ALTER TABLE `perfume_volume`
    ADD PRIMARY KEY (`perfume_id`,`volume_id`),
  ADD KEY `volume_id` (`volume_id`);

--
-- Chỉ mục cho bảng `promotion`
--
ALTER TABLE `promotion`
    ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `role`
--
ALTER TABLE `role`
    ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `rolegroup`
--
ALTER TABLE `rolegroup`
    ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `role_rolegroup`
--
ALTER TABLE `role_rolegroup`
    ADD UNIQUE KEY `Role_RoleGroup_index_2` (`role_id`,`rolegroup_id`),
    ADD KEY `rolegroup_id` (`rolegroup_id`);

--
-- Chỉ mục cho bảng `supplier`
--
ALTER TABLE `supplier`
    ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `volume`
--
ALTER TABLE `volume`
    ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `brand`
--
ALTER TABLE `brand`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;

--
-- AUTO_INCREMENT cho bảng `customer`
--
ALTER TABLE `customer`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;

--
-- AUTO_INCREMENT cho bảng `employee`
--
ALTER TABLE `employee`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT cho bảng `importreceipt`
--
ALTER TABLE `importreceipt`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT cho bảng `notes`
--
ALTER TABLE `notes`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=54;

--
-- AUTO_INCREMENT cho bảng `perfume`
--
ALTER TABLE `perfume`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;

--
-- AUTO_INCREMENT cho bảng `promotion`
--
ALTER TABLE `promotion`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;

--
-- AUTO_INCREMENT cho bảng `supplier`
--
ALTER TABLE `supplier`
    MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Các ràng buộc cho các bảng đã đổ
--

--
-- Các ràng buộc cho bảng `employee`
--
ALTER TABLE `employee`
    ADD CONSTRAINT `employee_ibfk_1` FOREIGN KEY (`rolegroup_id`) REFERENCES `rolegroup` (`id`);

--
-- Các ràng buộc cho bảng `importreceipt`
--
ALTER TABLE `importreceipt`
    ADD CONSTRAINT `importreceipt_ibfk_1` FOREIGN KEY (`supplier_id`) REFERENCES `supplier` (`id`);

--
-- Các ràng buộc cho bảng `importreceiptdetail`
--
ALTER TABLE `importreceiptdetail`
    ADD CONSTRAINT `importreceiptdetail_ibfk_1` FOREIGN KEY (`perfume_id`,`volume_id`) REFERENCES `perfume_volume` (`perfume_id`, `volume_id`),
  ADD CONSTRAINT `importreceiptdetail_ibfk_2` FOREIGN KEY (`import_receipt_id`) REFERENCES `importreceipt` (`id`);

--
-- Các ràng buộc cho bảng `invoice`
--
ALTER TABLE `invoice`
    ADD CONSTRAINT `invoice_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `customer` (`id`),
  ADD CONSTRAINT `invoice_ibfk_2` FOREIGN KEY (`employee_id`) REFERENCES `employee` (`id`);

--
-- Các ràng buộc cho bảng `invoicedetail`
--
ALTER TABLE `invoicedetail`
    ADD CONSTRAINT `invoicedetail_ibfk_1` FOREIGN KEY (`invoice_id`) REFERENCES `invoice` (`id`),
  ADD CONSTRAINT `invoicedetail_ibfk_2` FOREIGN KEY (`perfume_id`,`volume_id`) REFERENCES `perfume_volume` (`perfume_id`, `volume_id`);

--
-- Các ràng buộc cho bảng `perfume`
--
ALTER TABLE `perfume`
    ADD CONSTRAINT `perfume_ibfk_1` FOREIGN KEY (`brand_id`) REFERENCES `brand` (`id`),
  ADD CONSTRAINT `perfume_ibfk_3` FOREIGN KEY (`promotion_id`) REFERENCES `promotion` (`id`);

--
-- Các ràng buộc cho bảng `perfume_notes`
--
ALTER TABLE `perfume_notes`
    ADD CONSTRAINT `perfume_notes_ibfk_1` FOREIGN KEY (`perfume_id`) REFERENCES `perfume` (`id`),
  ADD CONSTRAINT `perfume_notes_ibfk_2` FOREIGN KEY (`note_id`) REFERENCES `notes` (`id`);

--
-- Các ràng buộc cho bảng `perfume_volume`
--
ALTER TABLE `perfume_volume`
    ADD CONSTRAINT `perfume_volume_ibfk_1` FOREIGN KEY (`perfume_id`) REFERENCES `perfume` (`id`),
  ADD CONSTRAINT `perfume_volume_ibfk_2` FOREIGN KEY (`volume_id`) REFERENCES `volume` (`id`);

--
-- Các ràng buộc cho bảng `role_rolegroup`
--
ALTER TABLE `role_rolegroup`
    ADD CONSTRAINT `role_rolegroup_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `role` (`id`),
  ADD CONSTRAINT `role_rolegroup_ibfk_2` FOREIGN KEY (`rolegroup_id`) REFERENCES `rolegroup` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
