package com.rogeriogregorio.human_resources_payroll.services;

import com.rogeriogregorio.human_resources_payroll.entities.Payment;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    public Payment getPayment(long workerId, int days) {
        return new Payment("Bob", 200.0, days);
    }
}
