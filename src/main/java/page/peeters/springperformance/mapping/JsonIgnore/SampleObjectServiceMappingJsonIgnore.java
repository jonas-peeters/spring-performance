package page.peeters.springperformance.mapping.JsonIgnore;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;

@Service
@CommonsLog
public class SampleObjectServiceMappingJsonIgnore {

	private final SampleObjectRepositoryMappingJsonIgnore repository;

	public SampleObjectServiceMappingJsonIgnore(SampleObjectRepositoryMappingJsonIgnore repository) {
		this.repository = repository;
	}

	public List<SampleObjectMappingJsonIgnore> getEntriesForTimeRange(Long locationProviderId, OffsetDateTime startTime, OffsetDateTime endTime) {
		return repository.findByLocationProviderIdAndTimestampBetween(locationProviderId, startTime, endTime);
	}
}
