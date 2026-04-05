IF DB_ID('java_nuochoa') IS NULL
BEGIN
    CREATE DATABASE java_nuochoa;
END
GO

USE java_nuochoa;
GO

CREATE TABLE brand (
    id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    name NVARCHAR(255) NULL,
    is_deleted BIT NULL DEFAULT 0
);

CREATE TABLE customer (
    id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    name NVARCHAR(255) NULL,
    phone VARCHAR(20) NULL,
    email VARCHAR(255) NULL,
    is_deleted BIT NULL DEFAULT 0
);

CREATE TABLE rolegroup (
    id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    name NVARCHAR(255) NULL
);

CREATE TABLE employee (
    id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    rolegroup_id INT NULL,
    name NVARCHAR(255) NULL,
    username VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    status BIT NULL,
    is_deleted BIT NULL DEFAULT 0
);

CREATE TABLE supplier (
    id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    name NVARCHAR(255) NULL,
    phone VARCHAR(20) NULL,
    email VARCHAR(255) NULL,
    is_deleted BIT NULL DEFAULT 0
);

CREATE TABLE importreceipt (
    id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    supplier_id INT NULL,
    import_date DATETIME NULL,
    total_cost FLOAT NULL,
    is_deleted BIT NULL DEFAULT 0
);

CREATE TABLE invoice (
    id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    customer_id INT NULL,
    employee_id INT NULL,
    total FLOAT NULL,
    issue_date DATETIME NULL
);

CREATE TABLE notes (
    id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    note_name NVARCHAR(50) NULL,
    is_deleted BIT NULL DEFAULT 0
);

CREATE TABLE promotion (
    id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    name NVARCHAR(255) NULL,
    discount_percent FLOAT NULL,
    start_date DATETIME NULL,
    end_date DATETIME NULL,
    is_deleted BIT NULL DEFAULT 0
);

CREATE TABLE role (
    id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    name NVARCHAR(255) NULL
);

CREATE TABLE role_rolegroup (
    role_id INT NULL,
    rolegroup_id INT NULL,
    status BIT NULL,
    CONSTRAINT Role_RoleGroup_index_2 UNIQUE (role_id, rolegroup_id)
);

CREATE TABLE volume (
    id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    size INT NULL
);

CREATE TABLE perfume (
    id INT IDENTITY(1,1) NOT NULL PRIMARY KEY,
    name NVARCHAR(255) NULL,
    sex VARCHAR(255) NULL,
    images VARCHAR(255) NULL,
    concentration VARCHAR(50) NULL,
    brand_id INT NULL,
    promotion_id INT NULL
);

CREATE TABLE perfume_volume (
    perfume_id INT NOT NULL,
    volume_id INT NOT NULL,
    price FLOAT NULL,
    stock INT NULL DEFAULT 0,
    cost FLOAT NULL DEFAULT 0,
    CONSTRAINT PK_perfume_volume PRIMARY KEY (perfume_id, volume_id)
);

CREATE TABLE perfume_notes (
    perfume_id INT NOT NULL,
    note_id INT NOT NULL,
    type VARCHAR(10) NULL,
    CONSTRAINT PK_perfume_notes PRIMARY KEY (perfume_id, note_id)
);

CREATE TABLE importreceiptdetail (
    import_receipt_id INT NOT NULL,
    perfume_id INT NOT NULL,
    quantity INT NULL,
    volume_id INT NOT NULL,
    CONSTRAINT PK_importreceiptdetail PRIMARY KEY (perfume_id, volume_id, import_receipt_id)
);

CREATE TABLE invoicedetail (
    invoice_id INT NOT NULL,
    perfume_id INT NOT NULL,
    quantity INT NULL,
    volume_id INT NOT NULL,
    CONSTRAINT PK_invoicedetail PRIMARY KEY (perfume_id, volume_id, invoice_id)
);

ALTER TABLE employee
    ADD CONSTRAINT FK_employee_rolegroup FOREIGN KEY (rolegroup_id) REFERENCES rolegroup(id);

ALTER TABLE importreceipt
    ADD CONSTRAINT FK_importreceipt_supplier FOREIGN KEY (supplier_id) REFERENCES supplier(id);

ALTER TABLE invoice
    ADD CONSTRAINT FK_invoice_customer FOREIGN KEY (customer_id) REFERENCES customer(id),
    CONSTRAINT FK_invoice_employee FOREIGN KEY (employee_id) REFERENCES employee(id);

ALTER TABLE perfume
    ADD CONSTRAINT FK_perfume_brand FOREIGN KEY (brand_id) REFERENCES brand(id),
    CONSTRAINT FK_perfume_promotion FOREIGN KEY (promotion_id) REFERENCES promotion(id);

ALTER TABLE perfume_volume
    ADD CONSTRAINT FK_perfume_volume_perfume FOREIGN KEY (perfume_id) REFERENCES perfume(id),
    CONSTRAINT FK_perfume_volume_volume FOREIGN KEY (volume_id) REFERENCES volume(id);

ALTER TABLE perfume_notes
    ADD CONSTRAINT FK_perfume_notes_perfume FOREIGN KEY (perfume_id) REFERENCES perfume(id),
    CONSTRAINT FK_perfume_notes_note FOREIGN KEY (note_id) REFERENCES notes(id);

ALTER TABLE importreceiptdetail
    ADD CONSTRAINT FK_importreceiptdetail_perfume_volume FOREIGN KEY (perfume_id, volume_id) REFERENCES perfume_volume(perfume_id, volume_id),
    CONSTRAINT FK_importreceiptdetail_receipt FOREIGN KEY (import_receipt_id) REFERENCES importreceipt(id);

ALTER TABLE invoicedetail
    ADD CONSTRAINT FK_invoicedetail_invoice FOREIGN KEY (invoice_id) REFERENCES invoice(id),
    CONSTRAINT FK_invoicedetail_perfume_volume FOREIGN KEY (perfume_id, volume_id) REFERENCES perfume_volume(perfume_id, volume_id);

ALTER TABLE role_rolegroup
    ADD CONSTRAINT FK_role_rolegroup_role FOREIGN KEY (role_id) REFERENCES role(id),
    CONSTRAINT FK_role_rolegroup_rolegroup FOREIGN KEY (rolegroup_id) REFERENCES rolegroup(id);

SET IDENTITY_INSERT rolegroup ON;
INSERT INTO rolegroup (id, name) VALUES
    (1, N'Admin'),
    (2, N'Nhân viên bán hàng');
SET IDENTITY_INSERT rolegroup OFF;

SET IDENTITY_INSERT role ON;
INSERT INTO role (id, name) VALUES
    (1, N'Quản lý sản phẩm'),
    (2, N'Quản lý hóa đơn'),
    (3, N'Quản lý khách hàng'),
    (4, N'Quản lý nhân viên'),
    (5, N'Quản lý nhập hàng'),
    (6, N'Quản lý thuộc tính'),
    (7, N'Quản lý nhà cung cấp'),
    (8, N'Quản lý thống kê'),
    (9, N'Quản lý nhóm quyền');
SET IDENTITY_INSERT role OFF;

INSERT INTO role_rolegroup (role_id, rolegroup_id, status) VALUES
    (1, 1, 1), (2, 1, 1), (3, 1, 1), (4, 1, 1), (5, 1, 1),
    (6, 1, 1), (7, 1, 1), (8, 1, 1), (9, 1, 1),
    (1, 2, 0), (2, 2, 1), (3, 2, 0), (4, 2, 0), (5, 2, 1),
    (6, 2, 0), (7, 2, 0), (8, 2, 0), (9, 2, 0);

SET IDENTITY_INSERT employee ON;
INSERT INTO employee (id, rolegroup_id, name, username, password, status, is_deleted) VALUES
    (1, 1, N'Nguyễn Văn An', 'annguyen', 'an123', 1, 0),
    (2, 2, N'Trần Thị Bích', 'bichtran', 'bich456', 1, 0);
SET IDENTITY_INSERT employee OFF;

SET IDENTITY_INSERT brand ON;
INSERT INTO brand (id, name, is_deleted) VALUES
    (1, N'Chanel', 0),
    (2, N'Dior', 0);
SET IDENTITY_INSERT brand OFF;

SET IDENTITY_INSERT promotion ON;
INSERT INTO promotion (id, name, discount_percent, start_date, end_date, is_deleted) VALUES
    (1, N'Giảm giá mùa hè', 15, '2025-06-01 00:00:00', '2025-06-30 23:59:59', 0);
SET IDENTITY_INSERT promotion OFF;

SET IDENTITY_INSERT volume ON;
INSERT INTO volume (id, size) VALUES
    (5, 30),
    (6, 50);
SET IDENTITY_INSERT volume OFF;

SET IDENTITY_INSERT perfume ON;
INSERT INTO perfume (id, name, sex, images, concentration, brand_id, promotion_id) VALUES
    (1, N'Chanel No. 5', 'Female', 'chanel_no_5.jpg', 'Parfum', 1, 1),
    (2, N'Dior Sauvage', 'Male', 'dior-sauvage.jpg', 'EDP', 2, 1);
SET IDENTITY_INSERT perfume OFF;

INSERT INTO perfume_volume (perfume_id, volume_id, price, stock, cost) VALUES
    (1, 6, 2500000, 10, 2000000),
    (2, 6, 3200000, 10, 2700000);
