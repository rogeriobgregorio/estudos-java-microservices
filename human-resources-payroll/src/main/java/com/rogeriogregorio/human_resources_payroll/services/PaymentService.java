package com.rogeriogregorio.human_resources_payroll.services;

import com.rogeriogregorio.human_resources_payroll.entities.Payment;
import com.rogeriogregorio.human_resources_payroll.entities.Worker;
import com.rogeriogregorio.human_resources_payroll.feignclients.WorkerFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class PaymentService {

    private final WorkerFeignClient workerFeignClient;

    @Autowired
    public PaymentService(WorkerFeignClient workerFeignClient) {
        this.workerFeignClient = workerFeignClient;
    }

    public Payment getPayment(long workerId, int days) {

        Worker worker = workerFeignClient.getById(workerId).getBody();
        return new Payment(Objects.requireNonNull(worker).getName(), worker.getDailyIncome(), days);
    }
}
