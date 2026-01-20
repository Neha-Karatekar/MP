package com.yashhh.Backend_MP.Entity;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
@Entity
@Table(name = "tour_packages")
public class TourPackage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Display title
    @Column(nullable = false)
    private String title;

    // Internal unique code/name
    @Column(nullable = false, unique = true)
    private String packageName;

    @Column(length = 1000)
    private String description;

    private LocalDate startDate;
    private LocalDate endDate;

    @Enumerated(EnumType.STRING)
    private TourPackageStatus status; // PLANNED, ACTIVE, COMPLETED

    // Owner
    private String createdBy; // MP / PA / Staff ID

    // Dashboard & Reports
    private Boolean published;
    private Boolean includedInReports;

    @OneToMany(mappedBy = "tourPackage", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Tour> tours;

    // ===== Audit =====
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Boolean isActive;

    // Getters & Setters
}