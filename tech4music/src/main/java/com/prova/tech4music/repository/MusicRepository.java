package com.prova.tech4music.repository;

import com.prova.tech4music.model.Music;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MusicRepository extends MongoRepository<Music, String>{
    
    Music findByTitulo(String titulo);
    
}
