@Entity
@Table(name = "daybooks")
public class Daybook {

    @Id
    @GeneratedValue
    private UUID daybookId;

    @Column(nullable = false)
    private UUID paId;   // Personal Assistant ID

    @Column(nullable = false)
    private LocalDate daybookDate;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    private Boolean isDeleted = false;

    @OneToMany(mappedBy = "daybook", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<DaybookEntry> entries;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}