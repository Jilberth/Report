package com.acsele.report.entity;

public class PrimaPoliza {

    private Long codBank;

    private String name;

    private String telephone;

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
