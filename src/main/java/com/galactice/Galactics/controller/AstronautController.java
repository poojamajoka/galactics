package com.galactice.Galactics.controller;

import com.galactice.Galactics.dtos.requestdto.AstronautRequestDto;
import com.galactice.Galactics.dtos.responsedto.AstronautResponseDto;
import com.galactice.Galactics.service.AstronautService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/astronauts")
@RequiredArgsConstructor
public class AstronautController {

    private final AstronautService astronautService;

    @PostMapping
    public ResponseEntity<AstronautResponseDto> createAstronaut(@Valid @RequestBody AstronautRequestDto dto) {
        return ResponseEntity.status(HttpStatus.CREATED).body(astronautService.createAstronaut(dto));
    }

    @GetMapping
    public ResponseEntity<List<AstronautResponseDto>> getAllAstronauts(
            @RequestParam(defaultValue = "experienceYears") String sort,
            @RequestParam(defaultValue = "asc") String order
    ) {
        return ResponseEntity.ok(astronautService.getAllAstronauts(sort, order));
    }
}

