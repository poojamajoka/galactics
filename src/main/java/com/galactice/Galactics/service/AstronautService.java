package com.galactice.Galactics.service;

import com.galactice.Galactics.dtos.requestdto.AstronautRequestDto;
import com.galactice.Galactics.dtos.responsedto.AstronautResponseDto;

import java.util.List;

public interface AstronautService {
        AstronautResponseDto createAstronaut(AstronautRequestDto dto);
        List<AstronautResponseDto> getAllAstronauts(String sortBy, String order);
}

