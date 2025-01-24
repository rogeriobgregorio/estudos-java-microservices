package com.rogeriogregorio.human_resources_payroll.feignclients;

import com.rogeriogregorio.human_resources_payroll.entities.Worker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class WorkerFeignClientFallback implements WorkerFeignClient {
    @Override
    public ResponseEntity<Worker> getById(Long id) {
        // Criando um Worker de fallback
        Worker fallbackWorker = new Worker(id, "Fallback Worker", 0.0);

        // Retornando um ResponseEntity com o Worker de fallback e um status 503 (Service Unavailable)
        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(fallbackWorker);
    }
}
