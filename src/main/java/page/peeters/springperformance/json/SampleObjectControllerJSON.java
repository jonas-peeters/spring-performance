package page.peeters.springperformance.json;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.StreamingResponseBody;

import java.time.OffsetDateTime;

@RestController
@RequestMapping("/json")
public class SampleObjectControllerJSON {

	private final SampleObjectServiceJSON sampleObjectService;
	private final ObjectWriter objectWriter;

	public SampleObjectControllerJSON(SampleObjectServiceJSON sampleObjectService, ObjectMapper jsonMapper) {
		this.sampleObjectService = sampleObjectService;
		this.objectWriter = jsonMapper.writer();
	}

	@GetMapping(value = "/{locationProviderId}")
	public ResponseEntity<StreamingResponseBody> getAllEntries(
			@PathVariable Long locationProviderId,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) String startTime,
			@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) String endTime) {
		StreamingResponseBody stream = out -> {
			objectWriter.writeValue(out,
					sampleObjectService.getEntriesForTimeRange(
							locationProviderId,
							OffsetDateTime.parse(startTime),
							OffsetDateTime.parse(endTime))
			);
			out.flush();
		};
		return ResponseEntity.ok()
				.contentType(MediaType.APPLICATION_JSON)
				.body(stream);
	}
}
