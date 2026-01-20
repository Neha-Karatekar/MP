package com.yashhh.Backend_MP.Entity;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "tour_destinations")
public class TourDestination {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // ===== Relationships =====
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tour_id", nullable = false)
    private Tour tour;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "destination_id", nullable = false)
    private Destination destination;

    // ===== Visit Details =====
    @Column(name = "visit_order")
    private Integer visitOrder;

    @Column(length = 1000)
    private String remarks;

    // ===== Media =====
    @Column(name = "photo_url")
    private String photoUrl;

    @Column(name = "document_url")
    private String documentUrl;

    // ===== Dashboard Flags =====
    @Column(name = "complaint_received")
    private Boolean complaintReceived;

    @Column(name = "action_required")
    private Boolean actionRequired;

    // ===== Audit =====
    @Column(name = "created_at", nullable = false)
    private LocalDateTime createdAt;

    // ===== Constructors =====
    public TourDestination() {
    }

    // ===== Auto Timestamp =====
    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }

    // ===== Getters & Setters =====
    public Long getId() {
        return id;
    }

    public Tour getTour() {
        return tour;
    }

    public void setTour(Tour tour) {
        this.tour = tour;
    }

    public Destination getDestination() {
        return destination;
    }

    public void setDestination(Destination destination) {
        this.destination = destination;
    }

    public Integer getVisitOrder() {
        return visitOrder;
    }

    public void setVisitOrder(Integer visitOrder) {
        this.visitOrder = visitOrder;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    public String getDocumentUrl() {
        return documentUrl;
    }

    public void setDocumentUrl(String documentUrl) {
        this.documentUrl = documentUrl;
    }

    public Boolean getComplaintReceived() {
        return complaintReceived;
    }

    public void setComplaintReceived(Boolean complaintReceived) {
        this.complaintReceived = complaintReceived;
    }

    public Boolean getActionRequired() {
        return actionRequired;
    }

    public void setActionRequired(Boolean actionRequired) {
        this.actionRequired = actionRequired;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
