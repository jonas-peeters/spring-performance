package page.peeters.springperformance.optimised;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SampleObjectDTOOptimised {
	private Long timestamp;
	private Double longitude;
	private Double latitude;
	private Double pressure;
	private Double temperature;
	private Double speed;
}
