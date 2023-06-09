package com.example.Solarsystemmicroservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class GalaxyDTO {
    private String name;
    private String dimension;
    private List<PlanetDTO> planets;

}
