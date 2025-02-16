package com.bytenest.InventoryApi.models.entities;

import jakarta.persistence.*;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "TB_PARTS")
public class PartModel extends RepresentationModel<PartModel> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idPart;
    private String name;
    private BigDecimal value;

    @Column(nullable = false, unique = true)
    private String codeSku;

    private String description;
    private Integer quantity;


    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate entryDate;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate maximumReturnDate;

    private String supplier;

    public UUID getIdPart() {
        return idPart;
    }

    public PartModel setIdPart(UUID idPart) {
        this.idPart = idPart;
        return this;
    }

    public String getName() {
        return name;
    }

    public PartModel setName(String name) {
        this.name = name;
        return this;
    }

    public BigDecimal getValue() {
        return value;
    }

    public PartModel setValue(BigDecimal value) {
        this.value = value;
        return this;
    }

    public String getCodeSku() {
        return codeSku;
    }

    public PartModel setCodeSku(String codeSku) {
        this.codeSku = codeSku;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public PartModel setDescription(String description) {
        this.description = description;
        return this;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public PartModel setQuantity(Integer quantity) {
        this.quantity = quantity;
        return this;
    }

    public LocalDate getEntryDate() {
        return entryDate;
    }

    public PartModel setEntryDate(String entryDate) {
        this.entryDate = getParseDate(entryDate);
        this.maximumReturnDate = getEntryDate().plusDays(10);
        return this;
    }

    public LocalDate getParseDate(String date){
        return LocalDate.parse(date);
    }

    public String getSupplier() {
        return supplier;
    }

    public PartModel setSupplier(String supplier) {
        this.supplier = supplier;
        return this;
    }

    public LocalDate getMaximumReturnDate() {
        return maximumReturnDate;
    }

}
