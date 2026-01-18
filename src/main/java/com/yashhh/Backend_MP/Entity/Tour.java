package com.yashhh.Backend_MP.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "tour")
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tourName;

    @ManyToOne
    @JoinColumn(name = "package_id")
    private TourPackage tourPackage;

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTourName() {
        return tourName;
    }

    public void setTourName(String tourName) {
        this.tourName = tourName;
    }

    public TourPackage getTourPackage() {
        return tourPackage;
    }

    public void setTourPackage(TourPackage tourPackage) {
        this.tourPackage = tourPackage;
    }
}

