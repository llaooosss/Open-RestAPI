package com.example.lastproject.DTO;

import com.example.lastproject.models.Films;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FilmDTO {

    private int id; // Уникальный идентификатор фильма
    private String name; // Название фильма
    private int year; // Год выпуска
    private double rating;

}
