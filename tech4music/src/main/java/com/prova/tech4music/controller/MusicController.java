package com.prova.tech4music.controller;

import java.util.List;

import com.prova.tech4music.Shared.MusicDto;
import com.prova.tech4music.service.MusicService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/musicas")
public class MusicController {
    
    @Autowired
    private MusicService service;


    @GetMapping
    public List<MusicDto> obterMusicas(){
        return service.obterTodasAsMusicas();
    }

    @GetMapping("/{id}")
    public MusicDto obterMusicaPorId(@PathVariable String id){
        return service.obterPorId(id);
    }

    @GetMapping("/titulo/{titulo}")
    public MusicDto obterPorTitulo(@PathVariable String titulo){
       return service.obterPorTitulo(titulo);
    }

    @PostMapping
    public MusicDto cadastrarMusica(@RequestBody MusicDto musica){
        return service.cadastrarMusica(musica);
    }

    @PutMapping("/{id}")
    public MusicDto alterarMusica(@PathVariable String id, @RequestBody MusicDto musicaAlterar){
        return service.alterarMusica(id, musicaAlterar);
    }

    @DeleteMapping("/{id}")
    public void deletarMusica(@PathVariable String id){
        service.deletarMusica(id);
    }
}
