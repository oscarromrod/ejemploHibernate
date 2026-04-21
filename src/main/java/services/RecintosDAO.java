package services;

import entities.Recinto;
import org.hibernate.Session;
import utils.HibernateUtil;

import java.util.List;

public class RecintosDAO {

    //CREATE (RECINTO) --------------------------------------
    public static void create (Recinto recinto){
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            session.beginTransaction();
            session.persist(recinto);
            session.getTransaction().commit();
            System.out.println("✅ Recinto guardado con id: " + recinto.getId());
        } catch (Exception e) {
            System.err.println("❌ Error al guardar recinto: " + e.getMessage());
            if (session.getTransaction() != null){
                session.getTransaction().rollback();
            }
        } finally {
            session.close();
        }
    }

    //READ (POR ID) --------------------------------------
    public static Recinto findById(Long id) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // session.find devuelve null si no encuentra el objeto
            return session.find(Recinto.class, id);
        }
    }

    //READ (TODOS) ---------------------------------------
    public static List<Recinto> findAll() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            // HQL: FROM NombreClase (no FROM nombre_tabla)
            return session.createQuery("FROM Recinto", Recinto.class).list();
        }
    }
}
