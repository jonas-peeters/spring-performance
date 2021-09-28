package page.peeters.springperformance.timestamp;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@CommonsLog
public class SampleObjectServiceTimestamp {

	private final SampleObjectRepositoryTimestamp repository;
	private final SampleObjectMapperTimestamp mapper;

	public SampleObjectServiceTimestamp(SampleObjectRepositoryTimestamp repository, SampleObjectMapperTimestamp mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	public List<SampleObjectDTOTimestamp> getEntriesForTimeRange(Long locationProviderId, Long startTime, Long endTime) {
		return repository.findByLocationProviderIdAndTimestampBetween(locationProviderId, startTime, endTime)
				.stream()
				.map(mapper::mapEntityToDTO)
				.collect(Collectors.toList());
	}
}
