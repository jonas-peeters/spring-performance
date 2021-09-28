package page.peeters.springperformance.optimised;

import lombok.extern.apachecommons.CommonsLog;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CommonsLog
public class SampleObjectServiceOptimised {

    private final SampleObjectRepositoryOptimised repository;

    public SampleObjectServiceOptimised(SampleObjectRepositoryOptimised repository) {
        this.repository = repository;
    }

    public List<SampleObjectDTOOptimised> getEntriesForTimeRange(Long locationProviderId, Long startTime, Long endTime) {
        return repository.findByLocationProviderIdAndTimestampBetween(locationProviderId, startTime, endTime);
    }
}
