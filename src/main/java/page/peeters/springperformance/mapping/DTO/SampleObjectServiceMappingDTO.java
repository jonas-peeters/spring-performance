package page.peeters.springperformance.mapping.DTO;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@CommonsLog
public class SampleObjectServiceMappingDTO {

	private final SampleObjectRepositoryMappingDTO repository;

	public SampleObjectServiceMappingDTO(SampleObjectRepositoryMappingDTO repository) {
		this.repository = repository;
	}

	public List<SampleObjectDTOMappingDTO> getEntriesForTimeRange(Long locationProviderId, OffsetDateTime startTime, OffsetDateTime endTime) {
		return repository.findByLocationProviderIdAndTimestampBetween(locationProviderId, startTime, endTime);
	}
}
