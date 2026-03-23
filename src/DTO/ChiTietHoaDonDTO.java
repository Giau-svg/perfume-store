package DTO;

public class ChiTietHoaDonDTO {

    private int invoiceId;
    private int perfumeId;
    private String perfumeName;
    private int volumeId;
    private String volumeSize;
    private String sex;
    private String concentration;
    private String brand;
    private double price;
    private int quantity;

    public ChiTietHoaDonDTO(int invoiceId, int perfumeId, String perfumeName, int volumeId, String volumeSize, String sex, String concentration, String brand, double price, int quantity) {
        this.invoiceId = invoiceId;
        this.perfumeId = perfumeId;
        this.perfumeName = perfumeName;
        this.volumeId = volumeId;
        this.volumeSize = volumeSize;
        this.sex = sex;
        this.concentration = concentration;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
    }

    public ChiTietHoaDonDTO(int invoiceId, int perfumeId, String perfumeName, String volumeSize, String sex,
            String concentration, String brand, double price, int quantity) {
        this.invoiceId = invoiceId;
        this.perfumeId = perfumeId;
        this.perfumeName = perfumeName;
        this.volumeSize = volumeSize;
        this.sex = sex;
        this.concentration = concentration;
        this.brand = brand;
        this.price = price;
        this.quantity = quantity;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getPerfumeId() {
        return perfumeId;
    }

    public void setPerfumeId(int perfumeId) {
        this.perfumeId = perfumeId;
    }

    public String getPerfumeName() {
        return perfumeName;
    }

    public void setPerfumeName(String perfumeName) {
        this.perfumeName = perfumeName;
    }

    public int getVolumeId() {
        return volumeId;
    }

    public void setVolumeId(int volumeId) {
        this.volumeId = volumeId;
    }

    public String getVolumeSize() {
        return volumeSize;
    }

    public void setVolumeSize(String volumeSize) {
        this.volumeSize = volumeSize;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getConcentration() {
        return concentration;
    }

    public void setConcentration(String concentration) {
        this.concentration = concentration;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
