package com.idb.evedience.entity;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="product_table")
public class Products {

    @Id
    private int pid;
    private String pname;
    private double pprice;
    private double pquantity;

    private String pimage;

    // For sort.
    private Date pcreateDate;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public double getPprice() {
        return pprice;
    }

    public void setPprice(double pprice) {
        this.pprice = pprice;
    }

    public double getPquantity() {
        return pquantity;
    }

    public void setPquantity(double pquantity) {
        this.pquantity = pquantity;
    }

    public String getPimage() {
        return pimage;
    }

    public void setPimage(String pimage) {
        this.pimage = pimage;
    }

    public Date getPcreateDate() {
        return pcreateDate;
    }

    public void setPcreateDate(Date pcreateDate) {
        this.pcreateDate = pcreateDate;
    }

    @Override
    public String toString() {
        return "Product{" + "pid=" + pid + ", pname=" + pname + ", pprice=" + pprice + ", pquantity=" + pquantity + ", pimage=" + pimage + ", pcreateDate=" + pcreateDate + '}';
    }
    
    

}
