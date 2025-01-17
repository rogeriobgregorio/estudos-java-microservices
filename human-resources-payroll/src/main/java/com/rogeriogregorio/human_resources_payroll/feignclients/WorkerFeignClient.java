package com.rogeriogregorio.human_resources_payroll.feignclients;

import com.rogeriogregorio.human_resources_payroll.entities.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(name = "human-resources-worker", url = "localhost:8001", path = "/workers")
public interface WorkerFeignClient {

    @GetMapping(value = "/{id}")
    ResponseEntity<Worker> getById(@PathVariable Long id);
}
