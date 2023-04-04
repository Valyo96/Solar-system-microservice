package com.example.Solarsystemmicroservice.client;

import com.example.Solarsystemmicroservice.dto.PlanetDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient (name = "planet-app")
public interface PlanetClient {
    @GetMapping("/planet/{id}")
    public ResponseEntity<PlanetDTO> getPlanetById(@PathVariable("id")Long id);
    @GetMapping("planets/{id}")
    public ResponseEntity<List<PlanetDTO>> getPlanetsByGalaxyId(@PathVariable("id")Long id);
}
