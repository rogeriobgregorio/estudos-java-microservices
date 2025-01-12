package com.rogeriogregorio.human_resources_worker.repositories;

import com.rogeriogregorio.human_resources_worker.entities.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkerRepository extends JpaRepository<Worker, Long> {
}
