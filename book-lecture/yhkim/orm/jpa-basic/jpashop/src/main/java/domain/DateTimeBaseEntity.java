package domain;

import java.time.LocalDateTime;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class DateTimeBaseEntity {

	private String createBy;
	private LocalDateTime createDate;

	private String lastModified;
	private LocalDateTime lastModifiedDate;

}
