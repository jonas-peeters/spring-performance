package page.peeters.springperformance.timestamp;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SampleObjectRepositoryTimestamp extends CrudRepository<SampleObjectTimestamp, Long> {
	List<SampleObjectTimestamp> findByLocationProviderIdAndTimestampBetween(Long locationProviderId, Long startTime, Long endTime);
}
