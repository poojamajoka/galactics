package com.galactice.Galactics.dtos.requestdto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;

import java.time.LocalDate;

public record SatelliteRequestDto(
        @NotBlank String name,
        @Past LocalDate launchDate,
        @Pattern(regexp = "LEO|MEO|GEO") String orbitType
) {}