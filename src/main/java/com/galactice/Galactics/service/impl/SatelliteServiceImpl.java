package com.galactice.Galactics.service.impl;

import com.galactice.Galactics.dtos.requestdto.SatelliteRequestDto;
import com.galactice.Galactics.dtos.responsedto.SatelliteResponseDto;
import com.galactice.Galactics.mapper.SatelliteMapper;
import com.galactice.Galactics.model.Satellite;
import com.galactice.Galactics.repository.SatelliteRepository;
import com.galactice.Galactics.service.SatelliteService;
import com.galactice.Galactics.exception.DuplicateSatelliteException;
import com.galactice.Galactics.exception.SatelliteNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SatelliteServiceImpl implements SatelliteService {

    private final SatelliteRepository satelliteRepository;
    private final SatelliteMapper satelliteMapper;

    @Override
    public SatelliteResponseDto updateSatellite(Long id, SatelliteRequestDto dto) {
        Satellite satellite = satelliteRepository.findById(id)
                .orElseThrow(() -> new SatelliteNotFoundException("Satellite with ID " + id + " not found"));

        if (satellite.isDecommissioned()) {
            throw new IllegalStateException("Cannot update a decommissioned satellite");
        }

        satellite.setName(dto.name());
        satellite.setLaunchDate(dto.launchDate());
        satellite.setOrbitType(dto.orbitType());

        return satelliteMapper.satelliteToSatelliteResponseDto(satelliteRepository.save(satellite));
    }

    @Override
    public SatelliteResponseDto createSatellite(SatelliteRequestDto dto) {
        if (satelliteRepository.findByName(dto.name()).isPresent()) {
            throw new DuplicateSatelliteException("Satellite name already exists");
        }
        Satellite satellite = satelliteMapper.satelliteRequestDtoToSatellite(dto);
        satellite.setDecommissioned(false); // default on creation
        Satellite saved = satelliteRepository.save(satellite);
        return satelliteMapper.satelliteToSatelliteResponseDto(saved);
    }
    @Override
    public void markDecommissioned(Long id) {
        Satellite satellite = satelliteRepository.findById(id)
                .orElseThrow(() -> new SatelliteNotFoundException("Satellite with ID " + id + " not found"));
        satellite.setDecommissioned(true);
        satelliteRepository.save(satellite);
    }
}