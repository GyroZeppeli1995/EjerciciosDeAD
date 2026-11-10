
package bdagenda;

import bdagenda.Tareas;
import bdagenda.TareasJpaController;
import java.util.List;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import packUtils.Utilidad;


public class JPAVista {
 
    // ******************************************
    // verLibros usando NamedQuery
    // ******************************************
    public static List<Tareas> findSeriesNamedQuery(TareasJpaController dao) {
        EntityManager em = null;
        try {
            em = dao.getEntityManager();

            TypedQuery<Tareas> tQuery
                    = em.createNamedQuery("Tareas.findAll", Tareas.class);

            return tQuery.getResultList();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public static void verSeriesNamedQuery(TareasJpaController dao) {
        System.out.println();
        System.out.println("Mostrando todas las Tareas (NamedQuery):");
        
        System.out.println("+----+------------+------------------------------------------+------------+");
        System.out.println("| ID | Fecha      | Descripción                              | Completada |");
        System.out.println("+----+------------+------------------------------------------+------------+");

        List<Tareas> lista = findSeriesNamedQuery(dao);
        for (Tareas tarea : lista) {
            
            System.out.printf("| %2d | %-10s | %-40s | %-10s |", tarea.getCodigo(), Utilidad.CambiarFecha(tarea.getFecha().toString()), tarea.getDescripcion(), (tarea.getCompletada()) ? "SI": "NO");
            System.out.println("");
        }
        System.out.println("+----+------------+------------------------------------------+------------+");
    }    
    


        
    
    
}
