
import entities.EstadoEvento;
import entities.Evento;
import entities.Recinto;
import org.hibernate.Session;
import services.EventosDAO;
import services.RecintosDAO;
import utils.HibernateUtil;

import java.time.LocalDate;
import java.util.ArrayList;

public class Main {

    static void main() {

        /*
        Session sesion = HibernateUtil.getSessionFactory().openSession();

        sesion.beginTransaction();

        Recinto r1 = new Recinto(null, "Estadio Nueva Condomina",
                "Murcia", 35000, false);

        sesion.persist(r1); //Persistir en la base de datos, lo graba en bbdd
        r1.setAforo(12000); //Esto va a generar un UPDATE en BBDD


        sesion.getTransaction().commit(); //Termina la transacción y confirma los datoszº
        sesion.close();

        //Aquí podemos tocar r1 que no afecta a BBDD, ya se cerró la sesión
        r1.setAforo(19000);
        */

//        Recinto r1 = RecintosDAO.findById(5L);
//        if (r1 != null) {
//            System.out.println("Recinto encontrado: " + r1.getNombre());
//        } else {
//            System.out.println("Recinto no encontrado.");
//        }
//
//        RecintosDAO.findAll().forEach(System.out::println);

//        Recinto r2 = new Recinto(null, "Sala BSide",
//                "Murcia", 500, true, new ArrayList<>());
//        RecintosDAO.create(r2);
//
//        r2.setAforo(1000);
//        RecintosDAO.update(r2);

        //RecintosDAO.delete(3L);

        Recinto r2 = RecintosDAO.findById(6L);

        //Evento ev1 = new Evento(null, "Concierto Rosalia", "Concierto", LocalDate.of(2026, 5, 5), 120.0, EstadoEvento.PROGRAMADO, r2);
        //EventosDAO.create(ev1);

        //Evento ev2 = new Evento(null, "Obra de teatro Hamlet", "Teatro",   LocalDate.of(2026,6,10), 50.0, EstadoEvento.PROGRAMADO, r2);
        //EventosDAO.create(ev2);

        IO.println(r2);
        r2.getEventos().forEach(System.out::println);

        EventosDAO.findByEstadoProgramado().forEach(System.out::println);
        EventosDAO.findOrderByFecha().forEach(System.out::println);
        EventosDAO.findByCategory("Teatro").forEach(System.out::println);
        EventosDAO.getEventoByCiudadRecinto("Murcia").forEach(System.out::println);



    }
}
