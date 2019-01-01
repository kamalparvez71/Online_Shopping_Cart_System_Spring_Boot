package com.idb.evedience.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer_table")
public class Customers {

    @Id
    private int cid;
    private String cname;
    private String cphone;

    public Customers() {
    }

    public Customers(int cid, String cname, String phone) {
        this.cid = cid;
        this.cname = cname;
        this.cphone = phone;
    }

    public int getCid() {
        return cid;
    }

    public void setCid(int cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getPhone() {
        return cphone;
    }

    public void setPhone(String phone) {
        this.cphone = phone;
    }

    @Override
    public String toString() {
        return "Customers{" + "cid=" + cid + ", cname=" + cname + ", phone=" + cphone + '}';
    }

}
