package DTO;

import java.util.List;

public class SanPhamDTO {

    private int id;
    private String name;
    private String sex;
    private String images;
    private String concentration;
    private int brandId;
    private String brandName;
    private int promotionId;
    private int volumeId;
    private int volumeSize;
    private int stock;
    private double cost;
    private double price;
    private List<String> topNotes;
    private List<String> heartNotes;
    private List<String> baseNotes;
    private int oldVolumeId;

    public SanPhamDTO() {
        // Constructor mặc định để sử dụng khi gọi new SanPhamDTO()
    }

    public SanPhamDTO(int id, String name, String sex, String images, String concentration, int brandId, String brandName, int promotionId,
            int volumeId, int volumeSize, int stock, double cost, double price,
            List<String> topNotes, List<String> heartNotes, List<String> baseNotes) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.images = images;
        this.concentration = concentration;
        this.brandId = brandId;
        this.brandName = brandName;
        this.promotionId = promotionId;
        this.volumeId = volumeId;
        this.volumeSize = volumeSize;
        this.stock = stock;
        this.cost = cost;
        this.price = price;
        this.topNotes = topNotes;
        this.heartNotes = heartNotes;
        this.baseNotes = baseNotes;
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

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getConcentration() {
        return concentration;
    }

    public void setConcentration(String concentration) {
        this.concentration = concentration;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getPromotionId() {
        return promotionId;
    }

    public void setPromotionId(int promotionId) {
        this.promotionId = promotionId;
    }

    public int getVolumeId() {
        return volumeId;
    }

    public void setVolumeId(int volumeId) {
        this.volumeId = volumeId;
    }

    public int getVolumeSize() {
        return volumeSize;
    }

    public void setVolumeSize(int volumeSize) {
        this.volumeSize = volumeSize;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public List<String> getTopNotes() {
        return topNotes;
    }

    public void setTopNotes(List<String> topNotes) {
        this.topNotes = topNotes;
    }

    public List<String> getHeartNotes() {
        return heartNotes;
    }

    public void setHeartNotes(List<String> heartNotes) {
        this.heartNotes = heartNotes;
    }

    public List<String> getBaseNotes() {
        return baseNotes;
    }

    public void setBaseNotes(List<String> baseNotes) {
        this.baseNotes = baseNotes;
    }

    public int getOldVolumeId() {
        return oldVolumeId;
    }

    public void setOldVolumeId(int oldVolumeId) {
        this.oldVolumeId = oldVolumeId;
    }

}
