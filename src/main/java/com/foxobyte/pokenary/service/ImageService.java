package com.foxobyte.pokenary.service;

import com.foxobyte.pokenary.dao.Image;
import com.foxobyte.pokenary.dao.Pokemon;
import com.foxobyte.pokenary.repo.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.transaction.Transactional;
import java.io.IOException;
import java.util.Optional;

@Service
public class ImageService {
    @Autowired
    ImageRepository repository;

    public boolean uploadImage(MultipartFile file, Integer pokemonId, String category) throws IOException {
        repository.save(Image.builder()
                .name(file.getName())
                .type(file.getContentType())
                .data(file.getBytes())
                .pokemonId(pokemonId)
                .category(category).build());

        return true;
    }

    @Transactional
    public Image getImage(Integer pokemonId) {
        Optional<Image> dbImage = repository.findByPokemonId(pokemonId);
        return dbImage.get();
    }
}
