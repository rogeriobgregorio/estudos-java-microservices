package com.rogeriogregorio.human_resources_payroll.feignclients;

import com.rogeriogregorio.human_resources_payroll.entities.Worker;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class WorkerFeignClientFallback implements WorkerFeignClient {
    @Override
    public ResponseEntity<Worker> getById(Long id) {
        Worker fallbackWorker = new Worker(id, "Fallback Worker", 0.0);

        return ResponseEntity.status(HttpStatus.SERVICE_UNAVAILABLE).body(fallbackWorker);
    }
}
