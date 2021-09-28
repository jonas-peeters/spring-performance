package page.peeters.springperformance.optimised;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;


@RestController
@RequestMapping("/optimised")
public class SampleObjectControllerOptimised {

	private final SampleObjectServiceOptimised sampleObjectService;
	private final ObjectWriter objectWriter;

	public SampleObjectControllerOptimised(SampleObjectServiceOptimised sampleObjectService, ObjectMapper jsonMapper) {
		this.sampleObjectService = sampleObjectService;
		this.objectWriter = jsonMapper.writer();
	}

	@GetMapping(value = "/{locationProviderId}")
	public ResponseEntity<StreamingResponseBody> getAllEntries(@PathVariable Long locationProviderId, @RequestParam Long startTime, @RequestParam Long endTime) {

		StreamingResponseBody stream = out -> {
			objectWriter.writeValue(out, sampleObjectService.getEntriesForTimeRange(locationProviderId, startTime, endTime));
			out.flush();
		};

		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(stream);
	}
}
