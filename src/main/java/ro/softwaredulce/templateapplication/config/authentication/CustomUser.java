package ro.softwaredulce.templateapplication.config.authentication;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ro.softwaredulce.templateapplication.domain.User;

import java.time.Instant;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

public class CustomUser implements UserDetails {
    private String username;
    private String password;
    private boolean enabled;
    private boolean locked;
    private Instant accountExpiryDate;
    private Instant credentialsExpiryDate;
    private Set<String> roles;

    public CustomUser() {
    }

    public CustomUser(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.enabled = user.isEnabled();
        this.locked = user.isLocked();
        this.accountExpiryDate = user.getAccountExpiryDate();
        this.credentialsExpiryDate = user.getCredentialsExpiryDate();
        this.roles = user.getRoles();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roles.stream()
                .map(SimpleGrantedAuthority::new)
                .collect(Collectors.toSet());
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return accountExpiryDate == null || accountExpiryDate.isAfter(Instant.now());
    }

    @Override
    public boolean isAccountNonLocked() {
        return !locked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return credentialsExpiryDate == null || credentialsExpiryDate.isAfter(Instant.now());
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }
}
