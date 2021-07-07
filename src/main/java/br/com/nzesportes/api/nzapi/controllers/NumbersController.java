package br.com.nzesportes.api.nzapi.controllers;

import br.com.nzesportes.api.nzapi.domains.Numbers;
import br.com.nzesportes.api.nzapi.services.NumbersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/numbers")
@CrossOrigin("${nz.allowed.origin}")
public class NumbersController {
    @Autowired
    private NumbersService service;

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<Numbers> getById(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getById(id));
    }

    @GetMapping()
    ResponseEntity<List<Numbers>> getAll() {
        return ResponseEntity.ok(service.getAll());
    }

    @GetMapping("/customer/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<List<Numbers>> getByCustomer(@PathVariable UUID id) {
        return ResponseEntity.ok(service.getAllByCustomer(id));
    }

    @PutMapping("/buy/{idNumber}/customer/{idCustomer}")
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<Numbers> buyNumber(@PathVariable UUID idNumber, @PathVariable UUID idCustomer) {
        return ResponseEntity.ok(service.buyNumber(idNumber, idCustomer));
    }
    @PutMapping("/remove/{idNumber}/customer/{idCustomer}")
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<Numbers> removeCustomer(@PathVariable UUID idNumber, @PathVariable UUID idCustomer) {
        return ResponseEntity.ok(service.removeCustomer(idNumber));
    }
}
