package com.example.Solarsystemmicroservice.service;

import com.example.Solarsystemmicroservice.dto.GalaxyDTO;
import com.example.Solarsystemmicroservice.dto.PlanetDTO;
import com.example.Solarsystemmicroservice.model.Galaxy;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GalaxyBuilder {

    public GalaxyDTO buildGalaxyDTO(Galaxy galaxy , List<PlanetDTO> planetDTOS){
        return GalaxyDTO.builder()
                .name(galaxy.getName())
                .dimension(galaxy.getDimension())
                .planets(planetDTOS)
                .build();
    }

    public Galaxy build(GalaxyDTO galaxyDTO){
        return Galaxy.builder().name(galaxyDTO.getName()).dimension(galaxyDTO.getDimension()).build();
    }
}
