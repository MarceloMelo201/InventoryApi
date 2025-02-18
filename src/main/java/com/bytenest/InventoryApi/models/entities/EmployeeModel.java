package com.bytenest.InventoryApi.models.entities;

import com.bytenest.InventoryApi.models.enums.DepartmentEnum;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_EMPLOYEE")
public class EmployeeModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idEmployee;

    private String name;

    @Column(unique = true, nullable = false)
    private String cpf;

    private String position;
    private String phone;

    private String email;
    private Boolean isActive;

    public UUID getIdEmployee() {
        return idEmployee;
    }

    public EmployeeModel setIdEmployee(UUID idEmployee) {
        this.idEmployee = idEmployee;
        return this;
    }

    public String getName() {
        return name;
    }

    public EmployeeModel setName(String name) {
        this.name = name;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public EmployeeModel setCpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    public String getPosition() {
        return position;
    }

    public EmployeeModel setPosition(String position) {
        this.position = position;
        return this;
    }

    public String getPhone() {
        return phone;
    }

    public EmployeeModel setPhone(String phone) {
        this.phone = phone;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public EmployeeModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public Boolean getActive() {
        return isActive;
    }

    public EmployeeModel setActive(Boolean active) {
        isActive = active;
        return this;
    }
}
