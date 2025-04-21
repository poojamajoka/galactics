package com.galactice.Galactics.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "astronauts")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Astronaut {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 20)
    @Size(min = 2, max = 20)
    private String firstName;

    @Column(nullable = false, length = 20)
    @Size(min = 2, max = 20)
    private String lastName;

    @Min(0)
    @Max(50)
    private int experienceYears;


    @ManyToMany
    @JoinTable(
            name = "astronaut_satellites", // Join table name
            joinColumns = @JoinColumn(name = "astronaut_id"), // Foreign key for Astronaut
            inverseJoinColumns = @JoinColumn(name = "satellite_id") // Foreign key for Satellite
    )
    private List<Satellite> satellites;
}

