package page.peeters.springperformance.timestamp;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Getter
@Setter
@Table(indexes = @Index(name = "timestamptimestamp", columnList = "TIMESTAMP"))
@Entity
@ToString
@Immutable
public class SampleObjectTimestamp {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column
	private Long locationProviderId;

	@Column
	private Long timestamp;

	@Column
	private Double longitude;

	@Column
	private Double latitude;

	@Column
	private Double pressure;

	@Column
	private Double temperature;

	@Column
	private Double speed;
}
