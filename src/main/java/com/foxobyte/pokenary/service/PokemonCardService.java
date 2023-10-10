package com.foxobyte.pokenary.service;

import com.foxobyte.pokenary.dao.pokemon.PokemonCard;
import com.foxobyte.pokenary.repo.PokemonCardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;

@Service
public class PokemonCardService {
    @Autowired
    PokemonCardRepository repository;

//    @Transactional
//    public PokemonCard getPokemonCard(Integer id) {
//        Optional<PokemonCard> dbImage = repository.findById(id);
//
//        return dbImage.get();
//    }

    @Transactional
    public PokemonCard getPokemonCard(Integer pokemonId) {
        PokemonCard pokemonCard = repository.findByPokemonId(pokemonId).get();

        return pokemonCard;
    }

    public boolean uploadImage(MultipartFile file, Integer pokemonId) throws IOException {
        // ToDo: Duplicate Check
        repository.save(PokemonCard.builder()
                .fileName(file.getName())
                .fileType(file.getContentType())
                .image(file.getBytes())
                .pokemonId(pokemonId).build());

        return true;
    }
}
