/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.Utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

/**
 *
 * @author Destroyer
 */
public class HibernateUtils {
    private static final SessionFactory sessionFactory;

    static {
        try {
            sessionFactory = new AnnotationConfiguration().configure().buildSessionFactory();
        } catch (Throwable ex) {
            // Log the exception. 
            System.err.println("Erro ao criar a sessão do hibernate." + ex);
            throw new ExceptionInInitializerError(ex);
        }
    }

    /**
     * 
     * @return
     */
    public static SessionFactory getSessionFactory() {
        return sessionFactory;
    }    
}
