package com.acsele.report.entity;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BANK")
public class Bank {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "CODBANK")
    private Long codBank;

    @Column(name = "NAME")
    private String name;

    @Column(name = "TELEPHONE")
    private String telephone;

    @Column(name = "ADDRESS")
    private String address;

    public Long getCodBank() {
        return codBank;
    }

    public void setCodBank(Long codBank) {
        this.codBank = codBank;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
