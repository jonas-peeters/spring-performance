package page.peeters.springperformance.query;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface SampleObjectRepositoryQuery extends CrudRepository<SampleObjectQuery, Long> {
	@Query("SELECT s FROM SampleObjectQuery s " +
			"WHERE s.locationProviderId = :locationProviderId " +
			"AND s.timestamp >= :startTime " +
			"AND s.timestamp <= :endTime")
	List<SampleObjectQuery> findByLocationProviderIdAndTimestampBetween(
			@Param("locationProviderId") Long locationProviderId,
			@Param("startTime") OffsetDateTime startTime,
			@Param("endTime") OffsetDateTime endTime);
}
