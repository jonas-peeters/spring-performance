package page.peeters.springperformance.query;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.OffsetDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SampleObjectDTOQuery {
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'hh:MM:ss.XXX'Z'")
	private OffsetDateTime timestamp;

	private Double longitude;

	private Double latitude;

	private Double pressure;

	private Double temperature;

	private Double speed;
}
