package org.example;

import jakarta.persistence.EntityManager;
import org.example.model.Xogador;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        System.out.println("Creando EntityManager");
        EntityManager em=JPAUtil.getEntityManager();

        Xogador xogador1=new Xogador("Cristiano Ronaldo",7);

        em.getTransaction().begin();
        em.persist(xogador1);
        em.getTransaction().commit();
    }
}