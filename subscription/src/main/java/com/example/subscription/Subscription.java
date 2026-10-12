package com.example.subscription;
import java.time.LocalDate;

public class Subscription {
	
	private String serviceName;
	private int price;
	private String billingCycle;
	private LocalDate nextRenewalDate;
	
	public Subscription (String serviceName, int price,
			String billingCycle, LocalDate nextRenewalDate) {
		
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

}
