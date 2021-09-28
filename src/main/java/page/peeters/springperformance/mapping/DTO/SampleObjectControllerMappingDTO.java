package page.peeters.springperformance.mapping.DTO;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.OffsetDateTime;
import java.util.List;

@RestController
@RequestMapping("/mapping/dto")
public class SampleObjectControllerMappingDTO {

	private final SampleObjectServiceMappingDTO sampleObjectService;

	public SampleObjectControllerMappingDTO(SampleObjectServiceMappingDTO sampleObjectService) {
		this.sampleObjectService = sampleObjectService;
	}

	@GetMapping(value = "/{locationProviderId}")
	public ResponseEntity<List<SampleObjectDTOMappingDTO>> getAllEntries(@PathVariable Long locationProviderId, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) String startTime, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) String endTime) {
		return ResponseEntity.ok(sampleObjectService.getEntriesForTimeRange(locationProviderId, OffsetDateTime.parse(startTime), OffsetDateTime.parse(endTime)));
	}
}
