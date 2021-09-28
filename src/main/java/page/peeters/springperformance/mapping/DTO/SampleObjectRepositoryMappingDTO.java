package page.peeters.springperformance.mapping.DTO;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.time.OffsetDateTime;
import java.util.List;

@Repository
public interface SampleObjectRepositoryMappingDTO extends CrudRepository<SampleObjectMappingDTO, Long> {
	@Query("SELECT new page.peeters.springperformance.mapping.DTO.SampleObjectDTOMappingDTO(s.timestamp, s.longitude, s.latitude, s.pressure, s.temperature, s.speed) FROM SampleObjectMappingDTO s " +
			"WHERE s.locationProviderId = :locationProviderId " +
			"AND s.timestamp >= :startTime " +
			"AND s.timestamp <= :endTime")
	List<SampleObjectDTOMappingDTO> findByLocationProviderIdAndTimestampBetween(Long locationProviderId, OffsetDateTime startTime, OffsetDateTime endTime);
}
