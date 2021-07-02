package br.com.nzesportes.api.nzapi.domains;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "customers")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private String phone;
    private String email;


    public Customer(UUID id, String name, String email, String phone) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public Customer() {
    }
}
