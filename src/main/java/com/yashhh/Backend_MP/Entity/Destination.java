package com.yashhh.Backend_MP.Entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "destinations")
public class Destination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // Village / Ward / City

    private String constituency;
    private String mandal;
    private String district;
    private String state;

    private Double latitude;
    private Double longitude;

    @Column(length = 1000)
    private String description;

    // Media
    private String locationImageUrl;

    @OneToMany(mappedBy = "destination", cascade = CascadeType.ALL)
    private List<TourDestination> tourDestinations;

    // ===== Audit =====
    private LocalDateTime createdAt;
    private Boolean isActive;

    // Getters & Setters
}