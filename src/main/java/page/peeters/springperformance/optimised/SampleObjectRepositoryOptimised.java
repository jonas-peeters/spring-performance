package page.peeters.springperformance.optimised;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SampleObjectRepositoryOptimised extends CrudRepository<SampleObjectOptimised, Long> {
	@Query("SELECT new page.peeters.springperformance.optimised.SampleObjectDTOOptimised(s.timestamp, s.longitude, s.latitude, s.pressure, s.temperature, s.speed) FROM SampleObjectOptimised s WHERE s.locationProviderId = :locationProviderId AND s.timestamp >= :startTime AND s.timestamp <= :endTime")
	List<SampleObjectDTOOptimised> findByLocationProviderIdAndTimestampBetween(@Param("locationProviderId") Long locationProviderId, @Param("startTime") Long startTime, @Param("endTime") Long endTime);
}
