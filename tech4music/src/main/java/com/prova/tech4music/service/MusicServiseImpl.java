package com.prova.tech4music.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.prova.tech4music.Shared.MusicDto;
import com.prova.tech4music.model.Music;
import com.prova.tech4music.repository.MusicRepository;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MusicServiseImpl implements MusicService{
    
    @Autowired
    private MusicRepository repository;
    private ModelMapper mapper = new ModelMapper();
    
    
    @Override
    public List<MusicDto> obterTodasAsMusicas() {
        List<Music> musicas = repository.findAll();

        return musicas.stream()
                .map(m -> mapper.map(m, MusicDto.class))
                .collect(Collectors.toList());
    }
    
    @Override
    public MusicDto obterPorId(String id) {
        Optional<Music> musica = repository.findById(id);

        if (musica.isPresent()) {
          return mapper.map(musica, MusicDto.class);
        }

        return null;
    }  
    
    @Override
  public MusicDto obterPorTitulo(String titulo) {
    Music musica = repository.findByTitulo(titulo);

    return mapper.map(musica, MusicDto.class);
  }

    @Override
    public MusicDto cadastrarMusica(MusicDto musica) {
        Music musicaSalvar = mapper.map(musica, Music.class);
        repository.save(musicaSalvar);
        return mapper.map(musicaSalvar, MusicDto.class);
    }
    
    @Override
    public MusicDto alterarMusica(String id, MusicDto musica) {
        Optional<Music> musicaVerificar = repository.findById(id);

        if (musicaVerificar.isPresent()) {
            Music musicaAlterar = mapper.map(musica, Music.class);
            musicaAlterar.setId(id);
            musicaAlterar = repository.save(musicaAlterar);
            return mapper.map(musicaAlterar, MusicDto.class);
        }
    
        return null;
    }
    
    @Override
    public void deletarMusica(String id) {
        repository.deleteById(id);
    }
}
