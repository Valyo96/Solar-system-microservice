package com.example.Solarsystemmicroservice.repository;

import com.example.Solarsystemmicroservice.model.Galaxy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GalaxyRepository extends JpaRepository<Galaxy , Long> {
}
