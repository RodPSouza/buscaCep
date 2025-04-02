package br.com.rsouza8891.buscaCep.repository;

import br.com.rsouza8891.buscaCep.model.CepLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CepLogRepository extends JpaRepository<CepLog,Long> {
}
