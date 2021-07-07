package br.com.nzesportes.api.nzapi.controllers;

import br.com.nzesportes.api.nzapi.domains.Customer;
import br.com.nzesportes.api.nzapi.dtos.CustomerUpdateTO;
import br.com.nzesportes.api.nzapi.security.services.UserDetailsImpl;
import br.com.nzesportes.api.nzapi.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customers")
@CrossOrigin("${nz.allowed.origin}")
public class CustomersController {
    @Autowired
    private CustomerService service;

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<Customer> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @PostMapping()
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<Customer> save(@RequestBody Customer customer) {
        return ResponseEntity.ok(service.save(customer));
    }

    @PutMapping()
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<Customer> update(@RequestBody Customer customer) {
        return ResponseEntity.ok(service.update(customer));
    }

    @GetMapping()
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<List<Customer>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }
}
