package com.bytenest.InventoryApi.models.entities;

import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.UUID;

@Entity
@Table(name = "TB_USER")
public class UserModel implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID idUser;

    private String username;
    private String password;
    private String email;
    private Boolean isActive;

    @OneToOne
    @JoinColumn(name = "cpf", referencedColumnName = "cpf")
    private EmployeeModel employee;

    public UUID getIdUser() {
        return idUser;
    }

    public UserModel setIdUser(UUID idUser) {
        this.idUser = idUser;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserModel setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserModel setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public Boolean getActive() {
        return isActive;
    }

    public UserModel setActive(Boolean active) {
        isActive = active;
        return this;
    }

    public EmployeeModel getEmployee() {
        return employee;
    }

    public UserModel setEmployee(EmployeeModel employee) {
        this.employee = employee;
        return this;
    }
}
