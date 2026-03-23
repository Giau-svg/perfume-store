package DTO;

public class KhachHangDTO {
    private int id;
    private String name, phone, email;

    public KhachHangDTO() {
        this (-1, null, null, null);
    }

    public KhachHangDTO(int id, String name, String phone, String email) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return String.format("{MaKhachHang: %d, TenKhachHang: %s, Phone: %s, Email: %s}", id, name, phone, email);
    }
}
