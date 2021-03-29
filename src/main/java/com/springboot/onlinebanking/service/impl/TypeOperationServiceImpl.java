package com.springboot.onlinebanking.service.impl;

import com.springboot.onlinebanking.exception.DataProcessingException;
import com.springboot.onlinebanking.model.TypeOperation;
import com.springboot.onlinebanking.repository.TypeOperationRepository;
import com.springboot.onlinebanking.service.TypeOperationService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TypeOperationServiceImpl implements TypeOperationService {
    private final TypeOperationRepository typeOperationRepository;

    @Override
    public TypeOperation save(TypeOperation typeOperation) {
        return typeOperationRepository.save(typeOperation);
    }

    @Override
    public TypeOperation getTypeOperationByTypeOperationName(String operationName) {
        return typeOperationRepository.getTypeOperationByOperationName(TypeOperation
                .TypeOperationName.valueOf(operationName)).orElseThrow(() ->
                new DataProcessingException("Can't find type operation by name " + operationName));
    }
}
