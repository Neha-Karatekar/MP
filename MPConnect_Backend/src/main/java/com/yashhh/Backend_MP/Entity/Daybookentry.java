@Entity
@Table(name = "daybook_entries")
public class DaybookEntry {

    @Id
    @GeneratedValue
    private UUID entryId;

    @ManyToOne
    @JoinColumn(name = "daybook_id")
    private Daybook daybook;

    @Column(nullable = false)
    private String taskTitle;

    @Column(columnDefinition = "TEXT")
    private String taskDescription;

    @Enumerated(EnumType.STRING)
    private TaskType taskType; 
    // MEETING, TASK, EVENT, REMINDER

    private LocalDate scheduledDate;
    private LocalTime scheduledTime;

    private Integer duration; // in minutes

    @Column(columnDefinition = "TEXT")
    private String purpose;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;
    // PENDING, IN_PROGRESS, COMPLETED, CANCELLED

    @Enumerated(EnumType.STRING)
    private Priority priority;
    // HIGH, MEDIUM, LOW

    private UUID assignedTo; // Office Staff ID

    @Column(columnDefinition = "TEXT")
    private String completionNotes;

    /* Voice Note Metadata */
    private String voiceFilePath;
    private String voiceTextTranscript;

    /* Reminder Configuration */
    @ElementCollection
    private List<String> reminders; 
    // 15_MIN, 30_MIN, 1_HOUR, 1_DAY, CUSTOM

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    @PrePersist
    protected void onCreate() {
        createdAt = LocalDateTime.now();
        updatedAt = LocalDateTime.now();
        status = TaskStatus.PENDING;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedAt = LocalDateTime.now();
    }
}