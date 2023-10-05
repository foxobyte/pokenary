package com.foxobyte.pokenary.service;

import com.foxobyte.pokenary.dao.misc.PokemonSprite;
import com.foxobyte.pokenary.repo.PokemonSpriteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Optional;

@Service
public class PokemonSpriteService {
    @Autowired
    PokemonSpriteRepository repository;

    @Transactional
    public PokemonSprite getPokemonSprite(Integer id) {
        Optional<PokemonSprite> sprite = repository.findById(id);

        return sprite.get();
    }

    @Transactional
    public PokemonSprite getPokemonSprites(Integer pokemonId) {
        Optional<PokemonSprite> pokemonSprite = repository.findByPokemonId(pokemonId);

        return pokemonSprite.get();
    }

    public boolean uploadImage(MultipartFile file, Integer pokemonId) throws IOException {
        // ToDo: Duplicate Check
        repository.save(PokemonSprite.builder()
                .fileName(file.getName())
                .fileType(file.getContentType())
                .image(file.getBytes())
                .pokemonId(pokemonId).build());

        return true;
    }
}
