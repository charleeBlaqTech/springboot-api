package com.boot.springWebApp.repository;

import com.boot.springWebApp.models.RegisterModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegisterRepository extends JpaRepository<RegisterModel, Long> {
}
