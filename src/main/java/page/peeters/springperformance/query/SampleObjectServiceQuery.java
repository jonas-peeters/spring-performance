package page.peeters.springperformance.query;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@CommonsLog
public class SampleObjectServiceQuery {

	private final SampleObjectRepositoryQuery repository;
	private final SampleObjectMapperQuery mapper;

	public SampleObjectServiceQuery(SampleObjectRepositoryQuery repository, SampleObjectMapperQuery mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	public List<SampleObjectDTOQuery> getEntriesForTimeRange(Long locationProviderId, OffsetDateTime startTime, OffsetDateTime endTime) {
		return repository.findByLocationProviderIdAndTimestampBetween(locationProviderId, startTime, endTime)
				.stream()
				.map(mapper::mapEntityToDTO)
				.collect(Collectors.toList());
	}
}
