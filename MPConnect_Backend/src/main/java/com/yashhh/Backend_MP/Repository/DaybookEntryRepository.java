public interface DaybookEntryRepository extends JpaRepository<DaybookEntry, UUID> {
    List<DaybookEntry> findByAssignedTo(UUID staffId);
    List<DaybookEntry> findByStatus(TaskStatus status);
}
