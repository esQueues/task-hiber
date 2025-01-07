package project1.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Generated;

import java.util.List;

@Entity
@Table(name = "director")
public class Director {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "director")
    private List<Movie> movies;

    public Director(String name) {
        this.name = name;
    }

    public Director() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public Director(String name, List<Movie> movies) {
        this.name = name;
        this.movies = movies;
    }
}
