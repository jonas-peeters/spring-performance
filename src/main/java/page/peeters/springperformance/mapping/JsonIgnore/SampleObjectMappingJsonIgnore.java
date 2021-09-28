package page.peeters.springperformance.mapping.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.time.OffsetDateTime;

@Getter
@Setter
@Table(indexes = @Index(name = "timestampmappingjsonignore", columnList = "TIMESTAMP"))
@Entity
@ToString
@Immutable
public class SampleObjectMappingJsonIgnore {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	@JsonIgnore
	private Long id;

	@Column
	@JsonIgnore
	private Long locationProviderId;

	@Column
	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'hh:MM:ss.XXX'Z'")
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
