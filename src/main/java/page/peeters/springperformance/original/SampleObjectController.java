package page.peeters.springperformance.original;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
@RequestMapping("/original")
public class SampleObjectController {

	private final SampleObjectService sampleObjectService;

	public SampleObjectController(SampleObjectService sampleObjectService) {
		this.sampleObjectService = sampleObjectService;
	}

	@GetMapping(value = "/{locationProviderId}")
	public ResponseEntity<List<SampleObjectDTO>> getAllEntries(@PathVariable Long locationProviderId, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) String startTime, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) String endTime) {
		return ResponseEntity.ok(sampleObjectService.getEntriesForTimeRange(locationProviderId, OffsetDateTime.parse(startTime), OffsetDateTime.parse(endTime)));
	}
}
