package com.rogeriogregorio.human_resources_payroll.controllers;

import com.rogeriogregorio.human_resources_payroll.entities.Payment;
import com.rogeriogregorio.human_resources_payroll.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/payments")
public class PaymentController {

    private final PaymentService paymentService;

    @Autowired
    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping(value = "/{workerId}/days/{days}")
    public ResponseEntity<Payment> getPayment(
            @PathVariable Long workerId,
            @PathVariable Integer days) {

        Payment payment = paymentService.getPayment(workerId, days);
        return ResponseEntity.ok(payment);
    }
}
