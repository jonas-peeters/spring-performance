package page.peeters.springperformance.original;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface SampleObjectRepository extends CrudRepository<SampleObject, Long> {
	List<SampleObject> findByLocationProviderIdAndTimestampBetween(Long locationProviderId, OffsetDateTime startTime, OffsetDateTime endTime);
}
