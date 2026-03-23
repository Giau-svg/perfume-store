package DTO;

public class ChiTietPhieuNhapDTO {

    private int importReceiptId;
    private int perfumeId;
    private int volumeId;
    private int quantity;
    private double cost;

    private String perfumeName;
    private String volumeSize;
    private String sex;
    private String concentration;
    private String brand;

    public ChiTietPhieuNhapDTO(int importReceiptId, int perfumeId, int volumeId, int quantity, double cost,
            String perfumeName, String volumeSize, String sex, String concentration, String brand) {
        this.importReceiptId = importReceiptId;
        this.perfumeId = perfumeId;
        this.volumeId = volumeId;
        this.quantity = quantity;
        this.cost = cost;
        this.perfumeName = perfumeName;
        this.volumeSize = volumeSize;
        this.sex = sex;
        this.concentration = concentration;
        this.brand = brand;
    }

    public ChiTietPhieuNhapDTO(int importReceiptId, int perfumeId, int quantity, double cost,
            String perfumeName, String sex, String brand) {
        this.importReceiptId = importReceiptId;
        this.perfumeId = perfumeId;
        this.quantity = quantity;
        this.cost = cost;
        this.perfumeName = perfumeName;
        this.sex = sex;
        this.brand = brand;
    }

    public int getImportReceiptId() {
        return importReceiptId;
    }

    public void setImportReceiptId(int importReceiptId) {
        this.importReceiptId = importReceiptId;
    }

    public int getPerfumeId() {
        return perfumeId;
    }

    public void setPerfumeId(int perfumeId) {
        this.perfumeId = perfumeId;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getPerfumeName() {
        return perfumeName;
    }

    public void setPerfumeName(String perfumeName) {
        this.perfumeName = perfumeName;
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
}
