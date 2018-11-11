package ro.softwaredulce.templateapplication.config.audit;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import ro.softwaredulce.templateapplication.config.authentication.CustomUser;

import java.util.Optional;

public class SpringSecurityAuditorAware implements AuditorAware<CustomUser> {

    @Override
    public Optional<CustomUser> getCurrentAuditor() {
        return Optional.ofNullable(SecurityContextHolder.getContext())
                .map(SecurityContext::getAuthentication)
                .filter(Authentication::isAuthenticated)
                .map(Authentication::getPrincipal)
                .map(CustomUser.class::cast);
    }
}