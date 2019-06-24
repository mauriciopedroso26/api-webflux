package br.com.api.webflux;

import br.com.api.webflux.document.PlayList;
import br.com.api.webflux.repository.PlayListRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.util.UUID;

@Component
public class DummyData implements CommandLineRunner {

    private final PlayListRepository playListRepository;

    public DummyData(PlayListRepository playListRepository) {
        this.playListRepository = playListRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        playListRepository.deleteAll()
                .thenMany(Flux.just("API REST Spring Boot", "Deploy de uma aplicação java no IBM Cloud", "Java 8", "Github",
                        "Spring Security", "web Service RESTFULL", "Bean no Spring Framework")
                        .map(nome -> new PlayList(UUID.randomUUID().toString(), nome))
                        .flatMap(playListRepository::save))
                .subscribe(System.out::println);
    }
}
