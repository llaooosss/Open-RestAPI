package com.example.lastproject.conroller;

import com.example.lastproject.DTO.FilmDTO;
import com.example.lastproject.models.Films;
import com.example.lastproject.service.FilmService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v2/films")
public class FilmController {

    private final FilmService filmService;
    private final FilmDTO filmDTO;

    @GetMapping("/all")
    public ResponseEntity<List<Films>> getAllFilms() {
        List<Films> films = filmService.findAll();
        return ResponseEntity.ok(films);
    }


    //Ещё нет, сейчас хочу затестить
    // Чтобы потом выводить статут запроса
    //Короче ошибку выводит грубо говоря.
    //А как лучше сделать?
    // Я думаю ты создавал класс отдельный под ошибки exteдил от RuntimeException
    // Слушай, давай просто перепешу тогда без респонс
    // Можно пример реализации такой?



    @GetMapping("/name/{name}")
    public ResponseEntity<Films> getFilmsByName(@PathVariable String name) {
        Optional<Films> films = filmService.findByFilmsName(name);
        return films.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Films> getFilmById(@PathVariable Long id) {
        Optional<Films> film = filmService.findByFilmId(id);
        return film.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/rating/{rating}")
    public ResponseEntity<List<Films>> getFilmsByRating(@PathVariable Double rating) {
        Optional<List<Films>> films = filmService.findByRating(rating);
        return films.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @GetMapping("/year/{year}")
    public ResponseEntity<List<Films>> getFilmsByYear(@PathVariable Integer year) {
        Optional<List<Films>> films = filmService.findByYear(year);
        return films.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/add")
    public ResponseEntity<FilmDTO> createFilm(@RequestBody FilmDTO filmDto) {
        FilmDTO savedFilm = filmService.saveFilm(filmDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedFilm);
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilmDTO> updateFilm(@PathVariable Long id, @RequestBody FilmDTO filmDto) {
        FilmDTO updatedFilm = filmService.updateFilm(id, filmDto);
        return ResponseEntity.ok(updatedFilm);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteFilm(@PathVariable Long id) {
        filmService.deleteFilm(id);
        return ResponseEntity.noContent().build();
    }
}
