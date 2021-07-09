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

    @Autowired
    private CustomerService customerService;

    public Numbers getById(UUID id) {
        return repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(ResponseErrorEnum.PRO001));
    }

    public List<Numbers> getAll() {
        return repository.findAll();
    }

    public List<Numbers> getAllByCustomer(UUID id) {
        return repository.findAllByCustomer_Id(id);
    }

    public Numbers buyNumber(UUID idNumber, UUID idCustomer) {
        Numbers n = repository.findById(idNumber).orElseThrow(() -> new ResourceNotFoundException(ResponseErrorEnum.PRO001));
        Customer c = customerService.getById(idCustomer);
        n.setActive(false);
        n.setCustomer(c);
        return repository.save(n);
    }

    public Numbers removeCustomer(UUID idNumber) {
        Numbers n = repository.findById(idNumber).orElseThrow(() -> new ResourceNotFoundException(ResponseErrorEnum.PRO001));
        n.setCustomer(null);
        n.setActive(true);
        return repository.save(n);
    }
}
