package ro.softwaredulce.templateapplication.domain;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Version;
import ro.softwaredulce.templateapplication.config.authentication.CustomUser;

import java.io.Serializable;
import java.time.Instant;

@Data
abstract class BaseEntity implements Serializable {

    @Id
    private String id;
    @Version
    private Long version;

    private boolean deleted;

    @CreatedDate
    private Instant createdDate;
    @CreatedBy
    private CustomUser createdBy;
    @LastModifiedDate
    private Instant lastModifiedDate;
    @LastModifiedBy
    private CustomUser lastModifiedBy;
}
