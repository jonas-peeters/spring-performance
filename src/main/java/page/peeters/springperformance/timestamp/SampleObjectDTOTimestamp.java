package page.peeters.springperformance.timestamp;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SampleObjectDTOTimestamp {
	private Long timestamp;

	private Double longitude;

	private Double latitude;

	private Double pressure;

	private Double temperature;

	private Double speed;
}
