package DTO;

public class ThongKeDTO {
    private String date;
    private double capital;
    private double revenue;
    private double profit;
    private int id;
    private String name;
    private int quantity;
    private double totalAmount;

    // Constructor for doanh thu
    public ThongKeDTO(String date, double capital, double revenue, double profit) {
        this.date = date;
        this.capital = capital;
        this.revenue = revenue;
        this.profit = profit;
    }

    // Constructor for KH/NCC
    public ThongKeDTO(int id, String name, int quantity, double totalAmount) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.totalAmount = totalAmount;
    }

    // Getter/Setter
    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public double getCapital() { return capital; }
    public void setCapital(double capital) { this.capital = capital; }

    public double getRevenue() { return revenue; }
    public void setRevenue(double revenue) { this.revenue = revenue; }

    public double getProfit() { return profit; }
    public void setProfit(double profit) { this.profit = profit; }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public int getQuantity() { return quantity; }
    public void setQuantity(int quantity) { this.quantity = quantity; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }
}