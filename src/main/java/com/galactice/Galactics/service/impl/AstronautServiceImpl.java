package com.galactice.Galactics.service.impl;

import com.galactice.Galactics.dtos.requestdto.AstronautRequestDto;
import com.galactice.Galactics.dtos.responsedto.AstronautResponseDto;
import com.galactice.Galactics.mapper.AstronautMapper;
import com.galactice.Galactics.model.Astronaut;
import com.galactice.Galactics.model.Satellite;
import com.galactice.Galactics.repository.AstronautRepository;
import com.galactice.Galactics.repository.SatelliteRepository;
import com.galactice.Galactics.service.AstronautService;
import com.galactice.Galactics.exception.SatelliteNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AstronautServiceImpl implements AstronautService {

    private final AstronautRepository astronautRepository;
    private final SatelliteRepository satelliteRepository;
    private final AstronautMapper astronautMapper;

    @Override
    public AstronautResponseDto createAstronaut(AstronautRequestDto dto) {
        List<Satellite> satellites = satelliteRepository.findAllById(dto.satelliteIds());
        if (satellites.size() != dto.satelliteIds().size()) {
            throw new SatelliteNotFoundException("One or more satellite IDs are invalid");
        }
        Astronaut astronaut = new Astronaut();
        astronaut.setFirstName(dto.firstName());
        astronaut.setLastName(dto.lastName());
        astronaut.setExperienceYears(dto.experienceYears());
        astronaut.setSatellites(satellites);

        return astronautMapper.astronautToAstronautResponseDto(astronautRepository.save(astronaut));
    }

    @Override
    public List<AstronautResponseDto> getAllAstronauts(String sortBy, String order) {
        Sort.Direction direction = Sort.Direction.fromString(order);
        List<Astronaut> astronauts = astronautRepository.findAll(Sort.by(direction, sortBy));
        return astronautMapper.astronautToAstronautResponseDto(astronauts);
    }
}


