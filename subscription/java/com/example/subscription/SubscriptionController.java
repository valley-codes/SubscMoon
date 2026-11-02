package com.example.subscription;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class SubscriptionController {
	
	private List<Subscription> subscriptions = new ArrayList<>();
	private int nextId = 1;
	
	//サブスク一覧
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

//サブスク登録画面
@GetMapping("/subscriptions/new")
public String subscription() {
	return "subscription-new";
	}

//サブスク登録
@PostMapping("/subscriptions")
public String createSubscription(
		@RequestParam String serviceName,
		@RequestParam int price,
		@RequestParam String billingCycle,
		@RequestParam LocalDate nextRenewalDate) {
	
	Subscription subscription = new Subscription(
			 nextId,serviceName, price, billingCycle, nextRenewalDate
			);
	
	subscriptions.add(subscription);
	nextId++;
	
	
	return "redirect:/subscriptions";
}

//サブスク編集画面
@GetMapping("/subscriptions/{id}/edit")
public String editSubscription(
		@PathVariable("id") int id,
		Model model) {
for(Subscription subscription : subscriptions) {
	if (subscription.getId() == id) {
		model.addAttribute("subscription" , subscription);
		break;
	}
}
return "subscription-edit";
}

//サブスク更新
@PostMapping("/subscriptions/{id}/edit")
public String updateSubscription(
		@PathVariable("id") int id,
		@RequestParam String serviceName,
		@RequestParam int price,
		@RequestParam String billingCycle,
		@RequestParam LocalDate nextRenewalDate) {
	
	for(Subscription subscription : subscriptions) {
		if(subscription.getId() == id) {
			subscription.setServiceName(serviceName);
			subscription.setPrice(price);
			subscription.setBillingCycle(billingCycle);
			subscription.setNextRenewalDate(nextRenewalDate);
			break;
		}
	}

	
	return "redirect:/subscriptions";
}
		

//サブスク削除
@PostMapping("/subscriptions/{id}/delete")
public String deleteSubscription(@PathVariable int id) {
	
	Subscription deleteSubscription = null;
	
	for(Subscription subscription : subscriptions) {
		
		if(subscription.getId() == id) {
			deleteSubscription = subscription;
			break;
		}
	}
	
	if(deleteSubscription != null) {
		subscriptions.remove(deleteSubscription);
	}
	
	return"redirect:/subscriptions";
	}
}

