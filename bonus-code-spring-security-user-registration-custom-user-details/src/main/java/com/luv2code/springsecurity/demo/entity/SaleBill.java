package com.luv2code.springsecurity.demo.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="salebill")
public class SaleBill {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="svoucherid")
    private Long id;
    
    @Column(name="currdate")
    @Temporal(TemporalType.DATE)
    @NotNull(message = "is required")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @Column(name="cost")
    private Double cost;
    @NotNull(message = "is required")
    @Column(name="supplierid")
    private Long accountId;
    @Column(name="description")
    private String description;
    @Column(name="suppliername")
    private String accountName;
    @Column(name="trucknumber")
    private String trucknumber;
    public String getTrucknumber() {
        return trucknumber;
    }

    public void setTrucknumber(String trucknumber) {
        this.trucknumber = trucknumber;
    }

    @NotNull(message = "is required")
    @Column(name="username_id")
    @Size(min = 1, message = "is required")
    private String userName;
    
    @OneToMany(mappedBy="saleBill",
            cascade= {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private List<SaleBillTransactions>saleBillTransactions;

    public List<SaleBillTransactions> getSaleBillTransactions() {
        return saleBillTransactions;
    }

    public void setSaleBillTransactions(List<SaleBillTransactions> saleBillTransactions) {
        this.saleBillTransactions = saleBillTransactions;
    }


    public void addSaleitem(SaleBillTransactions tempPurchase)
    {
        if(saleBillTransactions==null)
        {
            saleBillTransactions = new ArrayList<>();
        }
        saleBillTransactions.add(tempPurchase);
        tempPurchase.setSaleBill(this);
    }

    

    
    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }



    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public Long getId() {
        return id;
    }

    @Override
    public String toString() {
        return "PurchaseBillVoucher [id=" + id + ", date=" + date + ", cost=" + cost + ", accountId=" + accountId
                + ", description=" + description + ", accountName=" + accountName + ", trucknumber=" + trucknumber
                + ", userName=" + userName + ", saleBillTransactions=" + saleBillTransactions + "]";
    }
    
    
}