package page.peeters.springperformance.query;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
@RequestMapping("/query")
public class SampleObjectControllerQuery {

	private final SampleObjectServiceQuery sampleObjectService;

	public SampleObjectControllerQuery(SampleObjectServiceQuery sampleObjectService) {
		this.sampleObjectService = sampleObjectService;
	}

	@GetMapping(value = "/{locationProviderId}")
	public ResponseEntity<List<SampleObjectDTOQuery>> getAllEntries(@PathVariable Long locationProviderId, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) String startTime, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) String endTime) {
		return ResponseEntity.ok(sampleObjectService.getEntriesForTimeRange(locationProviderId, OffsetDateTime.parse(startTime), OffsetDateTime.parse(endTime)));
	}
}
