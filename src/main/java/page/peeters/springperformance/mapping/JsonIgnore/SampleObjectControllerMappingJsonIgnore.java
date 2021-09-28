package page.peeters.springperformance.mapping.JsonIgnore;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
@RequestMapping("/mapping/jsonignore")
public class SampleObjectControllerMappingJsonIgnore {

	private final SampleObjectServiceMappingJsonIgnore sampleObjectService;

	public SampleObjectControllerMappingJsonIgnore(SampleObjectServiceMappingJsonIgnore sampleObjectService) {
		this.sampleObjectService = sampleObjectService;
	}

	@GetMapping(value = "/{locationProviderId}")
	public ResponseEntity<List<SampleObjectMappingJsonIgnore>> getAllEntries(@PathVariable Long locationProviderId, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) String startTime, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) String endTime) {
		return ResponseEntity.ok(sampleObjectService.getEntriesForTimeRange(locationProviderId, OffsetDateTime.parse(startTime), OffsetDateTime.parse(endTime)));
	}
}
