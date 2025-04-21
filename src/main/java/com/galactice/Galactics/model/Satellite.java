package com.galactice.Galactics.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "satellites")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Satellite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @NotBlank
    private String name;

    @Past
    private LocalDate launchDate;

    @Pattern(regexp = "LEO|MEO|GEO")
    private String orbitType;

    private boolean decommissioned;
}


