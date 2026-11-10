
package bibliotecah2;

import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


public class JPAVista {
 
    // ******************************************
    // verLibros usando NamedQuery
    // ******************************************
    public static List<Libros> findLibrosNamedQuery(LibrosJpaController dao) {
        EntityManager em = null;
        try {
            em = dao.getEntityManager();

            TypedQuery<Libros> tQuery
                    = em.createNamedQuery("Libros.findAll", Libros.class);

            return tQuery.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
//    public static void verLibrosNamedQuery(LibrosJpaController dao) {
//        System.out.println();
//        System.out.println("Mostrando todos los libros (NamedQuery):");
//
//        List<Libros> lista = findLibrosNamedQuery(dao);
//        for (Libros libro : lista) {
//            System.out.println(libro.getId() + ": " + libro.getTitulo()
//                    + ", de " + libro.getAutor());
//        }
//    }


    public static void verLibrosFind(LibrosJpaController dao) {
        System.out.println("Mostrando todos los libros:");
        System.out.println("===========================");
        List<Libros> lista = dao.findLibrosEntities();
        for (Libros libro : lista) {
            System.out.println(libro.getId() + ": " + libro.getTitulo()
                    + ", de " + libro.getCodautor().getNombre());
        }
    }
    
    public static void verAutores(AutoresJpaController dao) {
        System.out.println("Mostrando todos los autores y sus libros:");
        System.out.println("=========================================");
        List<Autores> lista = dao.findAutoresEntities();
        for (Autores autor : lista) {
            System.out.println(autor.getNombre()
                    + " (" + autor.getCod() + "). Libros: ");
            for (Libros lib : autor.getLibrosCollection()) {
                System.out.println(" => " + lib.getTitulo());
            }
        }
    }
    


        
    
    
}
