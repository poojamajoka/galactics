package com.galactice.Galactics.service;

import com.galactice.Galactics.dtos.requestdto.SatelliteRequestDto;
import com.galactice.Galactics.dtos.responsedto.SatelliteResponseDto;

public interface SatelliteService {
    SatelliteResponseDto updateSatellite(Long id, SatelliteRequestDto dto);
    SatelliteResponseDto createSatellite(SatelliteRequestDto dto);

    void markDecommissioned(Long id);
}

