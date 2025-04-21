package com.galactice.Galactics.mapper;

import com.galactice.Galactics.dtos.requestdto.SatelliteRequestDto;
import com.galactice.Galactics.dtos.responsedto.SatelliteResponseDto;
import com.galactice.Galactics.model.Satellite;
import org.mapstruct.Mapper;
import org.mapstruct.MappingConstants;

import java.util.List;



@Mapper(componentModel = "spring")
public interface SatelliteMapper {
    Satellite satelliteRequestDtoToSatellite(SatelliteRequestDto dto);
    SatelliteResponseDto satelliteToSatelliteResponseDto(Satellite satellite);
    List<SatelliteResponseDto> satelliteToSatelliteResponseDto(List<Satellite> satellite);
}



