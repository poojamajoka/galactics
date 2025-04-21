package com.galactice.Galactics;

import com.galactice.Galactics.dtos.requestdto.AstronautRequestDto;
import com.galactice.Galactics.dtos.requestdto.SatelliteRequestDto;
import com.galactice.Galactics.dtos.responsedto.SatelliteResponseDto;
import com.galactice.Galactics.model.Astronaut;
import com.galactice.Galactics.model.Satellite;
import com.galactice.Galactics.repository.AstronautRepository;
import com.galactice.Galactics.repository.SatelliteRepository;
import com.galactice.Galactics.service.AstronautService;
import com.galactice.Galactics.service.SatelliteService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@RequiredArgsConstructor
@SpringBootApplication
public class GalacticsApplication {
	private final SatelliteService satelliteService;
	private final AstronautService astronautService;
	public static void main(String[] args) {
		SpringApplication.run(GalacticsApplication.class, args);
	}


	@Bean
	CommandLineRunner runner() {
		return args -> {
			// Create satellites
			SatelliteRequestDto hubbleDto = new SatelliteRequestDto("Hubble", LocalDate.of(1990, 4, 24), "LEO");
			SatelliteRequestDto starlink17Dto = new SatelliteRequestDto("Starlink-17", LocalDate.of(2023, 8, 14), "MEO");
			SatelliteRequestDto sentinel6Dto = new SatelliteRequestDto("Sentinel-6", LocalDate.of(2020, 11, 21), "LEO");

			SatelliteResponseDto hubble = satelliteService.createSatellite(hubbleDto);
			SatelliteResponseDto starlink17 = satelliteService.createSatellite(starlink17Dto);
			SatelliteResponseDto sentinel6 = satelliteService.createSatellite(sentinel6Dto);

			// Add decommissioned manually (assuming response DTO has no flag to set it)
			satelliteService.markDecommissioned(sentinel6.id());

			// Create astronauts with satellite IDs
			AstronautRequestDto neilDto = new AstronautRequestDto("Neil", "Armstrong", 12, List.of(hubble.id()));
			AstronautRequestDto sallyDto = new AstronautRequestDto("Sally", "Ride", 8, List.of(starlink17.id()));
			AstronautRequestDto chrisDto = new AstronautRequestDto("Chris", "Hadfield", 15, List.of(hubble.id(), sentinel6.id()));

			astronautService.createAstronaut(neilDto);
			astronautService.createAstronaut(sallyDto);
			astronautService.createAstronaut(chrisDto);
		};
	}
}

