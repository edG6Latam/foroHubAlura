package com.foroAlura.foroAlura.domain.repository;

import com.foroAlura.foroAlura.domain.model.topico.Topico;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RepositoryTopico extends JpaRepository<Topico, Long> {
}
