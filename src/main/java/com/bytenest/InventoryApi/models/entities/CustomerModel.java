package com.bytenest.InventoryApi.models.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_CUSTOMER")
public class CustomerModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idCustomer;

    private String name;
    private String cpf;
    private String phone;
    private String adress;

    public UUID getIdCustomer() {
        return idCustomer;
    }

    public CustomerModel setIdCustomer(UUID idCustomer) {
        this.idCustomer = idCustomer;
        return this;
    }

    public String getName() {
        return name;
    }

    public CustomerModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public CustomerModel setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public CustomerModel setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getAdress() {
        return adress;
    }

    public CustomerModel setAdress(String adress) {
        this.adress = adress;
        return this;
    }
}
