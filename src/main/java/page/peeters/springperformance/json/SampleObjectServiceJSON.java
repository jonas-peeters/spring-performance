package page.peeters.springperformance.json;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@CommonsLog
public class SampleObjectServiceJSON {

	private final SampleObjectRepositoryJSON repository;
	private final SampleObjectMapperJSON mapper;

	public SampleObjectServiceJSON(SampleObjectRepositoryJSON repository, SampleObjectMapperJSON mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	public List<SampleObjectDTOJSON> getEntriesForTimeRange(Long locationProviderId, OffsetDateTime startTime, OffsetDateTime endTime) {
		return repository.findByLocationProviderIdAndTimestampBetween(locationProviderId, startTime, endTime)
				.stream()
				.map(mapper::mapEntityToDTO)
				.collect(Collectors.toList());
	}
}
