package com.backend.onlinecvproject.repositories;

import com.backend.onlinecvproject.entities.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
}
