package ro.softwaredulce.templateapplication.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Set;

@EqualsAndHashCode(callSuper = true)
@Data
@Document
public class User extends BaseEntity {
    public static final String PATH = "users";

    private String username;
    private String name;
    @JsonIgnore
    private String password;
    private boolean enabled;
    private boolean locked;
    private Instant accountExpiryDate;
    private Instant credentialsExpiryDate;
    private Set<String> roles;

}
