package br.com.nzesportes.api.nzapi.services;


import br.com.nzesportes.api.nzapi.domains.Customer;
import br.com.nzesportes.api.nzapi.domains.Numbers;
import br.com.nzesportes.api.nzapi.errors.ResourceNotFoundException;
import br.com.nzesportes.api.nzapi.errors.ResponseErrorEnum;
import br.com.nzesportes.api.nzapi.repositories.CustomersRepository;
import br.com.nzesportes.api.nzapi.repositories.NumbersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class NumbersService {

    @Autowired
    private NumbersRepository repository;


    public Numbers getById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ResponseErrorEnum.PRO001));
    }

    public List<Numbers> getAll() {
        return repository.findAll();
    }
}
