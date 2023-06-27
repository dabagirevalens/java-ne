package rw.rca.next.models;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "reports")
public class Report {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long no;
    private String customName;
    private LocalDate date;
    private Long productId;
    private String productName;
    private Long quantity;
    private Double unityPrice;
    private Double totalPrice;

    public Report() {
    }

    public Report(Long no, String customName, LocalDate date, Long productId, String productName, Long quantity, Double unityPrice, Double totalPrice) {
        this.no = no;
        this.customName = customName;
        this.date = date;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.unityPrice = unityPrice;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public String getCustomName() {
        return customName;
    }

    public LocalDate getDate() {
        return date;
    }

    public Long getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public Long getQuantity() {
        return quantity;
    }

    public Double getUnityPrice() {
        return unityPrice;
    }

    public Double getTotalPrice() {
        return totalPrice;
    }

    public Long getNo() {
        return no;
    }

    public void setNo(Long no) {
        this.no = no;
    }
}
