package com.example.lastproject.models;


import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "films")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Films {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "filmid")
    int filmId;


    @NotEmpty(message = "Filmname should not be Empty")
    @Column(name = "filmname")
    @NotEmpty(message = "FilmName should not be Empty")
    String filmName;

    @Column(name = "year")
    @Min(value = 0, message = "Age should be greated thah 0")
    int year;

    @Column(name = "rating")
    @Min(0)
    @Max(10)
    double rating;

    @Column(name = "description")
    String description;

    @Override
    public String toString() {
        return "Films{" +
                "id=" + id +
                ", filmId=" + filmId +
                ", filmName='" + filmName + '\'' +
                ", year=" + year +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                '}';
    }
}
