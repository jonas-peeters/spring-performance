package page.peeters.springperformance.json;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface SampleObjectRepositoryJSON extends CrudRepository<SampleObjectJSON, Long> {
	List<SampleObjectJSON> findByLocationProviderIdAndTimestampBetween(Long locationProviderId, OffsetDateTime startTime, OffsetDateTime endTime);
}
