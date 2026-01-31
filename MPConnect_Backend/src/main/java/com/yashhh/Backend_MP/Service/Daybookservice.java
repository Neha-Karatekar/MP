@Service
public class DaybookService {

    @Autowired
    private DaybookRepository daybookRepository;

    @Autowired
    private DaybookEntryRepository entryRepository;

    public Daybook createDaybook(UUID paId, LocalDate date) {
        Daybook daybook = new Daybook();
        daybook.setPaId(paId);
        daybook.setDaybookDate(date);
        return daybookRepository.save(daybook);
    }

    public DaybookEntry addEntry(UUID daybookId, DaybookEntry entry) {
        Daybook daybook = daybookRepository.findById(daybookId)
                .orElseThrow(() -> new RuntimeException("Daybook not found"));

        entry.setDaybook(daybook);
        return entryRepository.save(entry);
    }

    public DaybookEntry updateStatus(UUID entryId, TaskStatus status) {
        DaybookEntry entry = entryRepository.findById(entryId)
                .orElseThrow(() -> new RuntimeException("Entry not found"));

        entry.setStatus(status);
        return entryRepository.save(entry);
    }
}
