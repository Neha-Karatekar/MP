package com.yashhh.Backend_MP.Entity;
<<<<<<< HEAD
import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "tours")
=======

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "tours")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
>>>>>>> b40288fcfd3a6c67f02b1e936cbc650cb583ae0d
public class Tour {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Tour heading
    @Column(nullable = false)
    private String title;

<<<<<<< HEAD
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
=======
    @Column(length = 2000)
    private String description;

    private String location;

    private LocalDate tourDate;

    // MP / PA / STAFF who created it
    @ManyToOne
    @JoinColumn(name = "created_by")
    private User createdBy;

    @OneToMany(mappedBy = "tour", cascade = CascadeType.ALL)
    private List<TourMedia> media;
}
>>>>>>> b40288fcfd3a6c67f02b1e936cbc650cb583ae0d
