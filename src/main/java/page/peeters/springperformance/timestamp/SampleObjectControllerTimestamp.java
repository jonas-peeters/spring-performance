package page.peeters.springperformance.timestamp;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/timestamp")
public class SampleObjectControllerTimestamp {

	private final SampleObjectServiceTimestamp sampleObjectService;

	public SampleObjectControllerTimestamp(SampleObjectServiceTimestamp sampleObjectService) {
		this.sampleObjectService = sampleObjectService;
	}

	@GetMapping(value = "/{locationProviderId}")
	public ResponseEntity<List<SampleObjectDTOTimestamp>> getAllEntries(@PathVariable Long locationProviderId, @RequestParam Long startTime, @RequestParam Long endTime) {
		return ResponseEntity.ok(sampleObjectService.getEntriesForTimeRange(locationProviderId, startTime, endTime));
	}
}
