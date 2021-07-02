package br.com.nzesportes.api.nzapi.domains;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "numbers")
public class Numbers {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String name;
    private boolean active;
    @ManyToOne
    @JoinColumn(name = "customers_id")
    @JsonIgnore
    private Customer customer;

}
