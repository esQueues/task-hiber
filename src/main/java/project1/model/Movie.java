package project1.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "movie")
public class Movie {
    @Column(name = "movie_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "title")
    private String title;

    @ManyToOne
    @JoinColumn(name = "director_id",referencedColumnName = "id")
    private Director director;

    public Movie(String title, Director director) {
        this.title = title;
        this.director = director;
    }

    public Movie() {

    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }




}
