package br.com.api.webflux.rest;

import br.com.api.webflux.document.PlayList;
import br.com.api.webflux.service.PlayListService;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/play-list")
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
}
