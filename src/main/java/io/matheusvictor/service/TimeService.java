package io.matheusvictor.service;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

@RegisterRestClient(baseUri = "http://worldtimeapi.org/api/timezone/America/Sao_Paulo")
public interface TimeService {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    String getTime();
}
