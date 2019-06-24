package br.com.api.webflux.service;

import br.com.api.webflux.document.PlayList;
import br.com.api.webflux.repository.PlayListRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class PlayListServiceImpl implements PlayListService {

    private final PlayListRepository playListRepository;

    public PlayListServiceImpl(PlayListRepository playListRepository) {
        this.playListRepository = playListRepository;
    }

    @Override
    public Flux<PlayList> findAll() {
        return playListRepository.findAll();
    }

    @Override
    public Mono<PlayList> findById(String id) {
        return playListRepository.findById(id);
    }

    @Override
    public Mono<PlayList> save(PlayList playList) {
        return playListRepository.save(playList);
    }
}
