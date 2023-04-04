package com.example.Solarsystemmicroservice.service;

import com.example.Solarsystemmicroservice.client.PlanetClient;
import com.example.Solarsystemmicroservice.dto.GalaxyDTO;
import com.example.Solarsystemmicroservice.dto.PlanetDTO;
import com.example.Solarsystemmicroservice.model.Galaxy;
import com.example.Solarsystemmicroservice.repository.GalaxyRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class GalaxyService {

    private final GalaxyRepository galaxyRepository;

    private final GalaxyBuilder galaxyBuilder;

    private final PlanetClient planetClient;

    public List<GalaxyDTO> getAllGalaxies(){
        return galaxyRepository.findAll().stream()
                .map(galaxy -> {
                    List<PlanetDTO> planets = planetClient.getPlanetsByGalaxyId(galaxy.getId()).getBody();
                    return galaxyBuilder.buildGalaxyDTO(galaxy, planets);
                })
                .collect(Collectors.toList());

    }

    public GalaxyDTO getGalaxyById(Long id){
        List<PlanetDTO> planets = planetClient.getPlanetsByGalaxyId(id).getBody();
        return galaxyBuilder.buildGalaxyDTO(galaxyRepository.findById(id).orElseThrow(()-> new RuntimeException("Galaxy with "+id+" id not found")) , planets);
    }

    public String createGalaxy(GalaxyDTO galaxyDTO){
        Galaxy galaxy = galaxyBuilder.build(galaxyDTO);
        galaxyRepository.save(galaxy);
        return "You successfully created a new galaxy";
    }
}
