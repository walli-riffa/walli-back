package br.com.nzesportes.api.nzapi.dtos;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class CustomerUpdateTO {
    public String name;
    public String lastName;
    public String instagram;
    public String phone;
    public LocalDate birthDate;
}
