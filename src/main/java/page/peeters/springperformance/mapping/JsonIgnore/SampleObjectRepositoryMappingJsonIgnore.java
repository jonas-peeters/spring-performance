package page.peeters.springperformance.mapping.JsonIgnore;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface SampleObjectRepositoryMappingJsonIgnore extends CrudRepository<SampleObjectMappingJsonIgnore, Long> {
	List<SampleObjectMappingJsonIgnore> findByLocationProviderIdAndTimestampBetween(Long locationProviderId, OffsetDateTime startTime, OffsetDateTime endTime);
}
