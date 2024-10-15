package com.example.lastproject.repository;

import com.example.lastproject.DTO.FilmDTO;
import com.example.lastproject.models.Films;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FilmRepos extends JpaRepository<Films, Long> {

    List<Films> findAll();

    Optional<Films> findByFilmName(String name);

    Optional<Films> findById(Long id);

    Optional<Films> findByFilmId(Long id);

    List<Films> findByYear(Integer year);

    List<Films> findByRating(Double rating);

    //ну я так чисто, всё влепил
}
