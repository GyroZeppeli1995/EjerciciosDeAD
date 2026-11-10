
package bdseries;

import bdseries.Series;
import bdseries.SeriesJpaController;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;


public class JPAVista {
 
    // ******************************************
    // verLibros usando NamedQuery
    // ******************************************
    public static List<Series> findSeriesNamedQuery(SeriesJpaController dao) {
        EntityManager em = null;
        try {
            em = dao.getEntityManager();

            TypedQuery<Series> tQuery
                    = em.createNamedQuery("Series.findAll", Series.class);

            return tQuery.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public static void verSeriesNamedQuery(SeriesJpaController dao) {
        System.out.println();
        System.out.println("Mostrando todas las Series (NamedQuery):");
        
        System.out.println("+----+----------------------+------------+----------+");
        System.out.println("| ID | Título               | TV         | Duración |");
        System.out.println("+----+----------------------+------------+----------+");

        List<Series> lista = findSeriesNamedQuery(dao);
        for (Series serie : lista) {
            
            System.out.printf("| %2d | %-20s | %-10s | %8d |", serie.getCodigo(), serie.getTitulo(), serie.getTv(), serie.getDuracion());
            System.out.println("");
        }
        System.out.println("+----+----------------------+------------+----------+");
    }    
    


        
    
    
}
