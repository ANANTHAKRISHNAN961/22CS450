package com.Project.SpringAngular.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "customer")
public class Customer {
    @Id
    @Column(name = "customer_id", length = 50)
    @GeneratedValue(strategy = GenerationType.AUTO) //auto increment
    private int customerid;
    @Column(name = "customer_name", length = 50)
    private String customername;
    @Column(name = "mobile", length = 12)
    private int mobile;
    @Column(name = "customer_address", length = 60)
    private String customeraddress;

//    public Customer(String customername, String customeraddress, int mobile) {
//    }


    public Customer(String customername, int mobile, String customeraddress) {
        this.customername = customername;
        this.mobile = mobile;
        this.customeraddress = customeraddress;
    }

    public Customer(int customerid, String customername, int mobile, String customeraddress) {
        this.customerid = customerid;
        this.customername = customername;
        this.mobile = mobile;
        this.customeraddress = customeraddress;
    }

    public Customer() {

    }

    public int getCustomerid() {
        return customerid;
    }

    public void setCustomerid(int customerid) {
        this.customerid = customerid;
    }

    public String getCustomername() {
        return customername;
    }

    public void setCustomername(String customername) {
        this.customername = customername;
    }

    public int getMobile() {
        return mobile;
    }

    public void setMobile(int mobile) {
        this.mobile = mobile;
    }

    public String getCustomeraddress() {
        return customeraddress;
    }

    public void setCustomeraddress(String customeraddress) {
        this.customeraddress = customeraddress;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerid=" + customerid +
                ", customername='" + customername + '\'' +
                ", mobile=" + mobile +
                ", customeraddress='" + customeraddress + '\'' +
                '}';
    }
}
