package com.galactice.Galactics.dtos.responsedto;


import java.util.List;

public record AstronautResponseDto(
        Long id,
        String firstName,
        String lastName,
        int experienceYears,
        List<SatelliteResponseDto> satellites
) {}
