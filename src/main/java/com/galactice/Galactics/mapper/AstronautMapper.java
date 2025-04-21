package com.galactice.Galactics.mapper;


import com.galactice.Galactics.dtos.requestdto.AstronautRequestDto;
import com.galactice.Galactics.dtos.responsedto.AstronautResponseDto;
import com.galactice.Galactics.model.Astronaut;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;

import java.util.List;

@Mapper(componentModel = "spring", uses = SatelliteMapper.class)
public interface AstronautMapper {
    AstronautResponseDto astronautToAstronautResponseDto(Astronaut astronaut);
    List<AstronautResponseDto> astronautToAstronautResponseDto(List<Astronaut> astronauts);
}