package com.Project.SpringAngular.DTO;

public class CustomerSaveDTO {

 //   private int customerid;  --auto increment
    private String customername;
    private int mobile;
    private String customeraddress;

    public CustomerSaveDTO(String customername, int mobile, String customeraddress) {

      //  this.customerid = customerid;
        this.customername = customername;
        this.mobile = mobile;
        this.customeraddress = customeraddress;
    }

    public CustomerSaveDTO() {
    }

//    public int getCustomerid() {
//        return customerid;
//    }

//    public void setCustomerid(int customerid) {
//        this.customerid = customerid;
//    }

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

    @Override
    public String toString() {
        return "CustomerDTO{" +
         //       "customerid=" + customerid +
                ", customername='" + customername + '\'' +
                ", mobile=" + mobile +
                ", customeraddress='" + customeraddress + '\'' +
                '}';
    }

    public void setCustomeraddress(String customeraddress) {
        this.customeraddress = customeraddress;
    }
}
