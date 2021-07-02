package br.com.nzesportes.api.nzapi.repositories;


import br.com.nzesportes.api.nzapi.domains.Numbers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface NumbersRepository extends JpaRepository<Numbers, UUID> {
}
