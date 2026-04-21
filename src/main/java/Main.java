
import entities.Recinto;
import org.hibernate.Session;
import utils.HibernateUtil;

public class Main {

    static void main() {

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Recinto r1 = new Recinto(null, "Palacio de Deportes", "Madrid", 15000, true);
        session.persist(r1); //Persistir en la base de datos, lo graba en bbdd

        session.getTransaction().commit(); //Termina la transacción y confirma los datoszº
        session.close();
    }
}
