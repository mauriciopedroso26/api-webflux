package br.com.api.webflux.rest;

import br.com.api.webflux.document.PlayList;
import br.com.api.webflux.service.PlayListService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.util.function.Tuple2;

import java.time.Duration;

@RestController
@RequestMapping("/playlist")
public class PlayListRest {

    private final PlayListService playListService;

    public PlayListRest(PlayListService playListService) {
        this.playListService = playListService;
    }

    @GetMapping
    public Flux<PlayList> findAll() {
        return playListService.findAll();
    }

    @GetMapping("/{id}")
    public Mono<PlayList> findById(@PathVariable String id) {
        return playListService.findById(id);
    }

    @PostMapping
    public Mono<PlayList> save(@RequestBody PlayList playList) {
        return playListService.save(playList);
    }

    @GetMapping(value = "/events", produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Tuple2<Long, PlayList>> getPlayListByEvents() {
        Flux<Long> interval = Flux.interval(Duration.ofSeconds(10));
        Flux<PlayList> events = playListService.findAll();
        System.out.println("Passou aqui events");
        return Flux.zip(interval, events);
    }
}
