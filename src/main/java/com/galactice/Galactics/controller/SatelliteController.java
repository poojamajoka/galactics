package com.galactice.Galactics.controller;


import com.galactice.Galactics.dtos.requestdto.SatelliteRequestDto;
import com.galactice.Galactics.dtos.responsedto.SatelliteResponseDto;
import com.galactice.Galactics.service.SatelliteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/satellites")
@RequiredArgsConstructor
public class SatelliteController {

    private final SatelliteService satelliteService;


    @PutMapping("/{id}")
    public ResponseEntity<SatelliteResponseDto> updateSatellite(
            @PathVariable Long id,
            @Valid @RequestBody SatelliteRequestDto dto
    ) {
        return ResponseEntity.ok(satelliteService.updateSatellite(id, dto));
    }
}
