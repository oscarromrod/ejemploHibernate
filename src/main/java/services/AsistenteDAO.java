package services;

import entities.Asistente;
import entities.Evento;
import org.hibernate.Session;
import utils.HibernateUtil;

import java.util.List;

public class AsistenteDAO {

    //CREATE (EVENTO) --------------------------------------
    public static void create(Asistente asistente) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.persist(asistente);
            session.getTransaction().commit();
            System.out.println("✅ Asistente guardado con id: " + asistente.getId());
        } catch (Exception e) {
            System.err.println("❌ Error al guardar asistente: " + e.getMessage());
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
    }

    //READ (POR ID) --------------------------------------
    public static Asistente findById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // session.find devuelve null si no encuentra el objeto
            return session.find(Asistente.class, id);
        }
    }

    //READ (TODOS) ---------------------------------------
    public static List<Asistente> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // HQL: FROM NombreClase (no FROM nombre_tabla)
            return session.createQuery("FROM Asistente ", Asistente.class).list();
        }
    }

    //UPDATE (RECINTO) --------------------------------------
    public static void update(Asistente asistente) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.merge(asistente);
            session.getTransaction().commit();
            System.out.println("✅ Asistente actualizado con id: " + asistente.getId());
        } catch (Exception e) {
            System.err.println("❌ Error al actualizar asistente: " + e.getMessage());
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
    }

    //DELETE (Long id) --------------------------------------
    public static void delete(Long id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            //Buscar el objeto por id para eliminarlo
            Asistente asistente = session.find(Asistente.class, id);
            if (asistente == null) {
                System.out.println("⚠ No se encontró asistente con id: " + id);
            } else {
                session.beginTransaction();
                session.remove(asistente); // remove elimina el objeto con el id de ese objeto
                session.getTransaction().commit();
                System.out.println("✅ Asistente eliminado con id: " + asistente.getId());
            }
        } catch (Exception e) {
            System.err.println("❌ Error al eliminar el asistente: " + e.getMessage());
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
    }

    //CONSULTAS EAGER --------------------------------------

}
