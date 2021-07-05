package br.com.nzesportes.api.nzapi.controllers;

import br.com.nzesportes.api.nzapi.domains.Customer;
import br.com.nzesportes.api.nzapi.domains.Numbers;
import br.com.nzesportes.api.nzapi.services.CustomerService;
import br.com.nzesportes.api.nzapi.services.NumbersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customers")
@CrossOrigin("${nz.allowed.origin}")
public class NumbersController {
    @Autowired
    private NumbersService service;

    @GetMapping("/{id}")
    ResponseEntity<Numbers> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping()
    ResponseEntity<List<Numbers>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

}
