@RestController
@RequestMapping("/api/daybook")
public class DaybookController {

    @Autowired
    private DaybookService daybookService;

    @PostMapping("/create")
    public Daybook createDaybook(
            @RequestParam UUID paId,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) {
        return daybookService.createDaybook(paId, date);
    }

    @PostMapping("/{daybookId}/entry")
    public DaybookEntry addEntry(
            @PathVariable UUID daybookId,
            @RequestBody DaybookEntry entry) {
        return daybookService.addEntry(daybookId, entry);
    }

    @PutMapping("/entry/{entryId}/status")
    public DaybookEntry updateStatus(
            @PathVariable UUID entryId,
            @RequestParam TaskStatus status) {
        return daybookService.updateStatus(entryId, status);
    }
}
