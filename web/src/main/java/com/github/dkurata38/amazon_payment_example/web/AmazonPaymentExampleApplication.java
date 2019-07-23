package com.github.dkurata38.amazon_payment_example.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScans;

@SpringBootApplication(scanBasePackages = {"com.github.dkurata38.amazon_payment_example.*"})
public class AmazonPaymentExampleApplication {
	public static void main(String[] args) {
		SpringApplication.run(AmazonPaymentExampleApplication.class, args);
	}

}
