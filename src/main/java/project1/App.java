package project1;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import project1.model.Director;
import project1.model.Movie;

import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        Configuration configuration= new Configuration().addAnnotatedClass(Director.class).addAnnotatedClass(Movie.class);
        SessionFactory sessionFactory= configuration.buildSessionFactory();

        Session session= sessionFactory.getCurrentSession();

        try {
            session.beginTransaction();

            ///////1
            Director director=session.get(Director.class,1);
            List<Movie> movieList= director.getMovies();

            for(Movie movie:movieList){
                System.out.println(movie.getTitle());
            }

            ////////2
            Movie movie=session.get(Movie.class,1);
            System.out.println(movie.getDirector().getName());


            ////////3
            Movie movie1=new Movie("New movie",director);


            ////////4
            Director director1=new Director("new dir");
            Movie movie2=new Movie("newset",director1);
            director1.getMovies().add(movie2);

            session.save(movie2);

            ////////5
            Movie movie3= session.get(Movie.class,2);
            movie3.setDirector(director1);


            /////6
            Director director2=session.get(Director.class,3);
            director2.getMovies().remove(1);

            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }

    }
}
