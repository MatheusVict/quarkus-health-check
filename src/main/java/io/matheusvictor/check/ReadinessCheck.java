package io.matheusvictor.check;

import io.matheusvictor.service.TimeService;
import jakarta.inject.Inject;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Readiness
public class ReadinessCheck implements HealthCheck {

    @Inject
    @RestClient
    TimeService timeService;

    @Override
    public HealthCheckResponse call() {
        if(timeService.getTime().isEmpty()) {
            return HealthCheckResponse.down("I'm not ready!");
        }
        return HealthCheckResponse.up("I'm ready!");
    }
}
