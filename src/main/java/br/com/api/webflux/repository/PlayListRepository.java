package br.com.api.webflux.repository;

import br.com.api.webflux.document.PlayList;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface PlayListRepository extends ReactiveMongoRepository<PlayList, String> {
}
