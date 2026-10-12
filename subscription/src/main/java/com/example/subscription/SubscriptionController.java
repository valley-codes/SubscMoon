package com.example.subscription;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class SubscriptionController {
	
	private List<Subscription> subscriptions = new ArrayList<>();
	
	
	@GetMapping("/subscriptions")
	public String subscriptions(Model model) {
		
		int totalPrice = 0;
		
		for  (Subscription subscription : subscriptions) {
			totalPrice += subscription.getPrice();
		}
		
		model.addAttribute("subscriptions" , subscriptions);
		model.addAttribute("totalPrice", totalPrice);
		
		return "subscriptions";	
		}


@GetMapping("/subscriptions/new")
public String subscription() {
	return "subscription-new";
	}

@PostMapping("/subscriptions")
public String createSubscription(
		@RequestParam String serviceName,
		@RequestParam int price,
		@RequestParam String billingCycle,
		@RequestParam LocalDate nextRenewalDate) {
	
	Subscription subscription = new Subscription(
			serviceName, price, billingCycle, nextRenewalDate
			);
	
	subscriptions.add(subscription);
	
	
	return "redirect:/subscriptions";
}
}
