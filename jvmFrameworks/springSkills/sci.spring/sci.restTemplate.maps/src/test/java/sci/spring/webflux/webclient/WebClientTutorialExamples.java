package sci.spring.webflux.webclient;

import org.springframework.web.reactive.function.client.ClientResponse;
import org.springframework.web.reactive.function.client.WebClient;
import org.testng.Assert;
import org.testng.annotations.Test;
import reactor.core.publisher.Mono;

//@Test
/**
 * https://hellokoding.com/spring-webclient-tutorial-with-examples/
 */
public class WebClientTutorialExamples {
    public void retrieve() {
        WebClient webClient = WebClient.create("http://localhost:8080");

        Mono<String> result = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/hello")
                        .queryParam("name", "Koding")
                        .build())
                .retrieve()
                .bodyToMono(String.class);

        Assert.assertEquals(result.block(),"Hello, Koding!");
    }
    public void exchange() {
        WebClient webClient = WebClient.create("http://localhost:8080");

        Mono<ClientResponse> result = webClient.get()
                .uri(uriBuilder -> uriBuilder
                        .path("/hello")
                        .queryParam("name", "Koding")
                        .build())
                .exchange();

        Assert.assertEquals(result.flatMap(res -> res.bodyToMono(String.class)).block(),"Hello, Koding!");
    }
}
