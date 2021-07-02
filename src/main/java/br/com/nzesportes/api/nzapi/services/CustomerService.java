package br.com.nzesportes.api.nzapi.services;



import br.com.nzesportes.api.nzapi.domains.Customer;
import br.com.nzesportes.api.nzapi.domains.User;
import br.com.nzesportes.api.nzapi.dtos.CustomerUpdateTO;
import br.com.nzesportes.api.nzapi.errors.ResourceConflictException;
import br.com.nzesportes.api.nzapi.errors.ResourceNotFoundException;
import br.com.nzesportes.api.nzapi.errors.ResponseErrorEnum;
import br.com.nzesportes.api.nzapi.repositories.CustomersRepository;
import br.com.nzesportes.api.nzapi.security.services.UserDetailsImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

import static org.springframework.beans.BeanUtils.copyProperties;

@Service
public class CustomerService {

    @Autowired
    private CustomersRepository repository;


    public Customer getById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ResponseErrorEnum.PRO001));
    }
}
