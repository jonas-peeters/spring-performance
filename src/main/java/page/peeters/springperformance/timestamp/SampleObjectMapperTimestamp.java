package page.peeters.springperformance.timestamp;

import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface SampleObjectMapperTimestamp {
	SampleObjectDTOTimestamp mapEntityToDTO(SampleObjectTimestamp sampleObject);
}
