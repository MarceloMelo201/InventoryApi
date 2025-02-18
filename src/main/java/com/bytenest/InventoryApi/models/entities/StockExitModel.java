package com.bytenest.InventoryApi.models.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "TB_EXITS")
public class StockExitModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idExit;

    private LocalDate exitDate;
    private LocalDate returnDate;
    private LocalDate maximumReturnDate;
    private Integer quantity;
    private String exitReason;

    @ManyToOne
    @JoinColumn(name = "part_id")
    private PartModel part;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private CustomerModel customer;

    @ManyToOne
    @JoinColumn(name = "order_id")
    private OrderServiceModel orderService;

    public UUID getIdExit() {
        return idExit;
    }

    public StockExitModel setIdExit(UUID idExit) {
        this.idExit = idExit;
        return this;
    }

    public LocalDate getParseDate(String date){
        return LocalDate.parse(date);
    }

    public LocalDate getExitDate() {
        return exitDate;
    }

    public StockExitModel setExitDate(String exitDate) {
        this.exitDate = getParseDate(exitDate);
        this.maximumReturnDate = getExitDate().plusDays(10);
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public StockExitModel setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public String getExitReason() {
        return exitReason;
    }

    public StockExitModel setExitReason(String exitReason) {
        this.exitReason = exitReason;
        return this;
    }

    public PartModel getPart() {
        return part;
    }

    public StockExitModel setPart(PartModel part) {
        this.part = part;
        return this;
    }

    public CustomerModel getCustomer() {
        return customer;
    }

    public StockExitModel setCustomer(CustomerModel customer) {
        this.customer = customer;
        return this;
    }

    public OrderServiceModel getOrderService() {
        return orderService;
    }

    public StockExitModel setOrderService(OrderServiceModel orderService) {
        this.orderService = orderService;
        return this;
    }

    public BigDecimal getTotalValue() {
        return totalValue;
    }

    public StockExitModel setTotalValue(BigDecimal totalValue) {
        this.totalValue = totalValue;
        return this;
    }

    public LocalDate getMaximumReturnDate() {
        return maximumReturnDate;
    }


    public LocalDate getReturnDate() {
        return returnDate;
    }

    public StockExitModel setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
        return this;
    }
}
