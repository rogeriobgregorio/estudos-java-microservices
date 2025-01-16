package com.rogeriogregorio.human_resources_payroll.services;

import com.rogeriogregorio.human_resources_payroll.entities.Payment;
import com.rogeriogregorio.human_resources_payroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class PaymentService {

    @Value("${human-resources-worker.host}")
    private String workerMicroserviceHost;
    private final RestTemplate restTemplate;

    @Autowired
    public PaymentService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Payment getPayment(long workerId, int days) {

        Map<String, String> uriVariables = new HashMap<>();
        uriVariables.put("id", String.valueOf(workerId));
        String url = workerMicroserviceHost + "/workers/{id}";

        Worker worker = restTemplate.getForObject(url, Worker.class, uriVariables);
        return new Payment(Objects.requireNonNull(worker).getName(), worker.getDailyIncome(), days);
    }
}
