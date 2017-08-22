/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.Crud;

/**
 *
 * @author Destroyer
 */
public interface CrudController <MODEL>{
    /**
     * 
     * @throws Exception
     */
    public void save()throws Exception;
    /**
     * 
     * @throws Exception
     */
    public void delete()throws Exception;
    /**
     * 
     * @throws Exception
     */
    public void update()throws Exception;
    /**
     * 
     * @throws Exception
     */
    public void restore()throws Exception;
    /**
     * 
     * @throws Exception
     */
    public void clear()throws Exception;
    /**
     * 
     * @throws Exception
     */
    public void report()throws Exception;
    
    public MODEL getBean() throws Exception; 
            
}
