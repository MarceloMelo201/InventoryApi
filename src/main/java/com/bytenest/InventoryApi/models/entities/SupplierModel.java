package com.bytenest.InventoryApi.models.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "TB_SUPPLIERS")
public class SupplierModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idSupplier;

    private String name;
    private String cnpj;
    private String email;
    private String phone;

    @OneToMany(mappedBy = "supplier")
    private List<PartModel> parts;


    public UUID getIdSupplier() {
        return idSupplier;
    }

    public SupplierModel setIdSupplier(UUID idSupplier) {
        this.idSupplier = idSupplier;
        return this;
    }

    public String getName() {
        return name;
    }

    public SupplierModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getCnpj() {
        return cnpj;
    }

    public SupplierModel setCnpj(String cnpj) {
        this.cnpj = cnpj;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public SupplierModel setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SupplierModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public List<PartModel> getParts() {
        return parts;
    }

    public SupplierModel setParts(List<PartModel> parts) {
        this.parts = parts;
        return this;
    }

}
