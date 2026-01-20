package com.yashhh.Backend_MP.Entity;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tours")
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Tour heading
    @Column(nullable = false)
    private String title;

    @Column(length = 1000)
    private String purpose;

    private LocalDate tourDate;

    private String conductedBy; // MP / Representative

    @Enumerated(EnumType.STRING)
    private TourStatus status;

    // Media
    private String coverImageUrl;
    private String photoGalleryUrl;
    private String documentUrl;

    // Reporting
    private Boolean includedInReport;
    private Boolean mediaPublished;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tour_package_id")
    private TourPackage tourPackage;

    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TourDestination> tourDestinations;

    // ===== Audit =====
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Boolean isActive;

    // Getters & Setters
}