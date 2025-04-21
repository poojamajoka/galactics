package com.galactice.Galactics.repository;

import com.galactice.Galactics.model.Astronaut;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AstronautRepository extends JpaRepository<Astronaut, Long> {
}
