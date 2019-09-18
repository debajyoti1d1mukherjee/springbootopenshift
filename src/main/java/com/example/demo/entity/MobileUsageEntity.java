package com.example.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "mobileusage")
public class MobileUsageEntity {

	@Id
	@Column(name = "id")
	public int id;
	@Column(name = "customername ")
	public String custName;
	@Column(name = "datausage")
	public String dataUsage;
	@Column(name = "billingmonth")
	public String billingMonth;

	public MobileUsageEntity() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCustName() {
		return custName;
	}

	public void setCustName(String custName) {
		this.custName = custName;
	}

	public String getDataUsage() {
		return dataUsage;
	}

	public void setDataUsage(String dataUsage) {
		this.dataUsage = dataUsage;
	}

	public String getBillingMonth() {
		return billingMonth;
	}

	public void setBillingMonth(String billingMonth) {
		this.billingMonth = billingMonth;
	}

}
