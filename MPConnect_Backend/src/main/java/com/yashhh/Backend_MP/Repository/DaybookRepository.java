public interface DaybookRepository extends JpaRepository<Daybook, UUID> {
    List<Daybook> findByPaIdAndDaybookDate(UUID paId, LocalDate date);
}
