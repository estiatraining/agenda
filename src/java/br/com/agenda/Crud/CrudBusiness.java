/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.Crud;

import br.com.agenda.Model.Usuario;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Destroyer
 */
public interface CrudBusiness<MODEL extends Serializable> {
    /**
     * 
     * @param obj
     * @return
     * @throws Exception
     */
    public MODEL save(MODEL obj)throws Exception;
    /**
     * 
     * @param obj
     * @throws Exception
     */
    public void delete(MODEL obj)throws Exception;
    /**
     * 
     * @param obj
     * @return
     * @throws Exception
     */
    public Boolean update(MODEL obj)throws Exception;
    /**
     * 
     * @return
     * @throws Exception
     */
    public List<MODEL> select() throws Exception;
    /**
     * 
     * @param obj
     * @return
     * @throws Exception
     */
    public MODEL restore(Integer obj)throws Exception;
    /**
     * 
     * @param obj
     * @return
     * @throws Exception
     */
    public MODEL report(MODEL obj)throws Exception;  
    /**
     * 
     * @return
     */
    public Usuario getUsuario();
    /**
     * 
     * @param usr
     */
    public void setUsuario(Usuario usr);  
    
        /**
     * 
     * @return
     * @throws Exception
     */
    public CrudDao<MODEL> getDao() throws Exception;
}
