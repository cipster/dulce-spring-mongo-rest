package ro.softwaredulce.templateapplication.config.authentication;

import java.util.EnumSet;
import java.util.Set;
import java.util.stream.Collectors;

public enum UserRole {
    ROLE_USER,
    ROLE_ADMIN;

    public static Set<String> all() {
        return EnumSet.allOf(UserRole.class)
                .stream()
                .map(UserRole::toString)
                .collect(Collectors.toSet());
    }
}
