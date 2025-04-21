package com.galactice.Galactics.dtos.responsedto;


import java.time.LocalDate;
import java.util.List;

public record SatelliteResponseDto(
        Long id,
        String name,
        LocalDate launchDate,
        String orbitType
) {}
