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

import java.util.UUID;

@RestController
@RequestMapping("/customers")
@CrossOrigin("${nz.allowed.origin}")
public class CustomersController {
    @Autowired
    private CustomerService service;

    @GetMapping("/{id}")
    ResponseEntity<Customer> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }


}
