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
public interface CrudDao<MODEL extends Serializable> {
    public MODEL save(MODEL Object) throws Exception;
    public void delete(MODEL Object) throws Exception;
    public Boolean update(MODEL obj) throws Exception;
    public MODEL find(Class classToSearch, Serializable key) throws Exception;
    public List<MODEL> select() throws Exception;
    public MODEL restore(Integer id) throws Exception;
    public List<MODEL> findBySqlQuery(String query) throws Exception;
    public List<MODEL> list(Class classToCast, String query, Object... params) throws Exception;
    public Serializable getPurePojo(String query, Object... params) throws Exception;
    public MODEL report(MODEL obj) throws Exception;
    public Usuario getUsuario();
    public void setUsuario(Usuario usr);    
}
