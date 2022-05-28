package com.prova.tech4music.service;

import java.util.List;

import com.prova.tech4music.Shared.MusicDto;

public interface MusicService {
    
    List<MusicDto> obterTodasAsMusicas();
    MusicDto obterPorId(String id);
    MusicDto obterPorTitulo(String titulo);
    MusicDto cadastrarMusica(MusicDto musica);
    MusicDto alterarMusica(String id, MusicDto musica);
    void deletarMusica(String id);
}
