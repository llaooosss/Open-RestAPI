package com.example.lastproject.service;

import com.example.lastproject.DTO.FilmDTO;
import com.example.lastproject.models.Films;
import com.example.lastproject.repository.FilmRepos;
import jakarta.persistence.EntityNotFoundException;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class FilmService {

    private final FilmRepos filmRepos;
    private final ModelMapper mapper;

    // мапит дто и фильмы

    // Аля на получение всех фильмов

    public List<Films> findAll() {
        return filmRepos.findAll();
    }

    public Optional<Films> findByFilmsName(String name) {
        return filmRepos.findByFilmName(name);
    }

    public Optional<Films> findById(Long id) {
        return filmRepos.findById(id);
    }

    public Optional<Films> findByFilmId(Long id) {
        return filmRepos.findByFilmId(id);
    }

    public Optional<List<Films>> findByYear(Integer year) {
        return Optional.of(filmRepos.findByYear(year));
    }

    public Optional<List<Films>> findByRating(Double rating) {
        return Optional.of(filmRepos.findByRating(rating));
    }

    //сохранение фильма
    public FilmDTO saveFilm(FilmDTO filmDto) {
        Films film = mapper.map(filmDto, Films.class);
        Films savedFilm = filmRepos.save(film);
        return mapper.map(savedFilm, FilmDTO.class);
    }

    //Обновление фильма
    public FilmDTO updateFilm(Long id, FilmDTO filmDto) {
        Films existingFilm = filmRepos.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Film not found with id: " + id));
        existingFilm.setFilmName(filmDto.getName());
        existingFilm.setYear(filmDto.getYear());
        existingFilm.setRating(filmDto.getRating());
        Films updatedFilm = filmRepos.save(existingFilm);
        return mapper.map(updatedFilm, FilmDTO.class);
    }


    //удаление фильма
    public void deleteFilm(Long id) {
        if (!filmRepos.existsById(id)) {
            throw new EntityNotFoundException("Film not found with id: " + id);
        }
        filmRepos.deleteById(id);
    }

}
