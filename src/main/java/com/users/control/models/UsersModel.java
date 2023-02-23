package com.users.control.models;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

// Class model utilizada para realizar a criação no banco de dados.
@Entity
@Table(name = "TB_USERS")
public class UsersModel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    @NotNull
    @Size(min = 3)
    @Column(nullable = false, length = 10)
    private String Name;

    @NotNull
    @Column(nullable = false, length = 20)
    private String Address;
    @NotNull
    @Column(nullable = false)
    private Date Birth;


    @NotNull
    @Column(nullable = false, length = 5)
    private String Number;


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String Name) {
        this.Name = Name;
    }


    public String getAddress() {
        return Address;
    }

    public void setAddress(String Address) {
        this.Address = Address;
    }


    public Date getBirth() {
        return Birth;
    }

    public void setBirth(Date Birth) {
        this.Birth = Birth;
    }

    public String getNumber() {
        return Number;
    }

    public void setNumber(String Number) {
        this.Number = Number;
    }


}
