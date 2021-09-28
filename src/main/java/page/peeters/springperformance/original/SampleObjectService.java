package page.peeters.springperformance.original;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@CommonsLog
public class SampleObjectService {

	private final SampleObjectRepository repository;
	private final SampleObjectMapper mapper;

	public SampleObjectService(SampleObjectRepository repository, SampleObjectMapper mapper) {
		this.repository = repository;
		this.mapper = mapper;
	}

	public List<SampleObjectDTO> getEntriesForTimeRange(Long locationProviderId, OffsetDateTime startTime, OffsetDateTime endTime) {
		return repository.findByLocationProviderIdAndTimestampBetween(locationProviderId, startTime, endTime)
				.stream()
				.map(mapper::mapEntityToDTO)
				.collect(Collectors.toList());
	}
}
