package com.example.Solarsystemmicroservice.controller;

import com.example.Solarsystemmicroservice.dto.GalaxyDTO;
import com.example.Solarsystemmicroservice.service.GalaxyService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class GalaxyController {

    private final GalaxyService galaxyService;

    @GetMapping("/all-galaxies")
    public ResponseEntity<List<GalaxyDTO>> getAllGalaxies(){
        return new ResponseEntity<>(galaxyService.getAllGalaxies(), HttpStatus.OK);
    }

    @GetMapping("/galaxy/{id}")
    public ResponseEntity<GalaxyDTO> getGalaxyById(@PathVariable("id") Long id){
        return ResponseEntity.ok().body(galaxyService.getGalaxyById(id));
    }

    @PostMapping("/create-galaxy")
    public ResponseEntity<String> createGalaxy (@RequestBody GalaxyDTO galaxyDTO){
        return new  ResponseEntity<>( galaxyService.createGalaxy(galaxyDTO),HttpStatus.CREATED);
    }
}
