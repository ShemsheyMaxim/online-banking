package com.springboot.onlinebanking.repository;

import com.springboot.onlinebanking.model.TypeOperation;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TypeOperationRepository extends JpaRepository<TypeOperation, Long> {
    Optional<TypeOperation> getTypeOperationByOperationName(
            TypeOperation.TypeOperationName operationName);
}
