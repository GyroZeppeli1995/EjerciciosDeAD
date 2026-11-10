package app;

import bibliotecah.JPAUtil;
import bibliotecah.Libros;
import bibliotecah.LibrosJpaController;
import java.util.List;
import jakarta.persistence.EntityManagerFactory;

public class JPABiblio1d {

    public static void verLibrosFind(LibrosJpaController dao) {
        System.out.println("Mostrando todos los libros:");

        List<Libros> lista = dao.findLibrosEntities();
        for (Libros libro : lista) {
            System.out.println(libro.getId() + ": " + libro.getTitulo()
                    + ", de " + libro.getAutor());
        }
    }
    public static void main(String[] args) {
        EntityManagerFactory emf = JPAUtil.getEntityManagerFactory();
        LibrosJpaController dao = new LibrosJpaController(emf);    

        verLibrosFind(dao);        
        
        emf.close();
    }
}
