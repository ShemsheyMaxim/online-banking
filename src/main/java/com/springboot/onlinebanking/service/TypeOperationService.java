package com.springboot.onlinebanking.service;

import com.springboot.onlinebanking.model.TypeOperation;

public interface TypeOperationService {
    TypeOperation save(TypeOperation typeOperation);

    TypeOperation getTypeOperationByTypeOperationName(String operationName);
}
