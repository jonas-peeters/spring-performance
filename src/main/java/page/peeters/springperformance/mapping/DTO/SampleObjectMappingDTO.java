package page.peeters.springperformance.mapping.DTO;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Getter
@Setter
@Table(indexes = @Index(name = "timestampmappingdto", columnList = "TIMESTAMP"))
@Entity
@ToString
@Immutable
public class SampleObjectMappingDTO {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Long id;

	@Column
	private Long locationProviderId;

	@Column
	private OffsetDateTime timestamp;

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
