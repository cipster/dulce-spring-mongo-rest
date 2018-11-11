package ro.softwaredulce.templateapplication.domain;

import org.springframework.data.rest.core.annotation.RestResource;

import java.util.Optional;

@RestResource(rel = User.PATH, path = User.PATH)
public interface UserRepository extends BaseRepository<User> {

    @RestResource(exported = false)
    Optional<User> findByUsername(String username);
}
