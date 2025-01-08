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

            Movie movie1 = new Movie("New movie task 3", director);
            director.getMovies().add(movie1);
            session.save(movie1);
            System.out.println("task 3 added new movie");




            ////////4
            Director director1=new Director("new dir");

            session.save(director1);

            Movie movie2=new Movie("task 4 new mov",director1);
            movie2.setDirector(director1);

            session.save(movie2);
            System.out.println("new dir with new movie added task 4");

            ////////5
            Movie movie3= session.get(Movie.class,2);
            movie3.setDirector(director1);
            System.out.println("task 5 changed movie 2 to new");


            /////6
            Director director2=session.get(Director.class,3);
            Movie movie4=director2.getMovies().get(1);
            director2.getMovies().remove(1);
            movie4.setDirector(null);


            System.out.println(" task 6 remove film of the 3 rt dir");

            session.getTransaction().commit();
        }
        finally {
            sessionFactory.close();
        }

    }
}
