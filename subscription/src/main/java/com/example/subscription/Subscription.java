package com.example.subscription;
import java.time.LocalDate;

public class Subscription {
	
	private int id;
	private String serviceName;
	private int price;
	private String billingCycle;
	private LocalDate nextRenewalDate;
	
	public Subscription (int id,String serviceName, int price,
			String billingCycle, LocalDate nextRenewalDate) {
		
		this.id = id;
		this.serviceName = serviceName;
		this.price = price;
		this.billingCycle = billingCycle;
		this.nextRenewalDate = nextRenewalDate;
	}
	
	public String getServiceName() {
		return serviceName;
	}
	
	public int getPrice() {
		return price;
	}
	
	public String getBillingCycle() {
		return billingCycle;
	}
	
	public LocalDate getNextRenewalDate() {
		return nextRenewalDate;
	}
	
	public int getId() {
		return id;
	}
	
	public void setServiceName(String servicename) {
		this.serviceName = serviceName;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public void setBillingCycle(String billingCycle) {
		this.billingCycle = billingCycle;
	}
	
	public void setNextRenewalDate(LocalDate nextRenewalDate) {
		this.nextRenewalDate = nextRenewalDate;
	}

}
