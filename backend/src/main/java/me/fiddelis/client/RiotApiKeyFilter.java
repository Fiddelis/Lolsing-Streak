package me.fiddelis.client;

import jakarta.inject.Inject;
import jakarta.ws.rs.client.ClientRequestContext;
import jakarta.ws.rs.client.ClientRequestFilter;
import jakarta.ws.rs.ext.Provider;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.io.IOException;

@Provider
public class RiotApiKeyFilter implements ClientRequestFilter {

    @Inject
    @ConfigProperty(name = "riot.api.key")
    String apiKey;

    @Override
    public void filter(ClientRequestContext requestContext) throws IOException {
        var uri = requestContext.getUri();
        var newUri = uriBuilderWithApiKey(uri.toString());
        requestContext.setUri(newUri);
    }

    private java.net.URI uriBuilderWithApiKey(String originalUri) {
        return java.net.URI.create(
                originalUri.contains("?")
                        ? originalUri + "&api_key=" + apiKey
                        : originalUri + "?api_key=" + apiKey
        );
    }
}
