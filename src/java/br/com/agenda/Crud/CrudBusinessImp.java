/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.Crud;

import br.com.agenda.Exceptions.AgendaException;
import br.com.agenda.Model.Usuario;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Destroyer
 */
public abstract class CrudBusinessImp<MODEL extends Serializable> implements CrudBusiness<MODEL> {

    private Usuario usr = null;

    @Override
    public MODEL save(MODEL obj) throws Exception {
        CrudDao<MODEL> dao = getDao();
        dao.setUsuario(getUsuario());
        try {
            return (MODEL) dao.save(obj);
        }catch (Exception ex) {
            throw new AgendaException(ex, getUsuario());
        }
    }

    @Override
    public void delete(MODEL obj) throws Exception {
        CrudDao<MODEL> dao = getDao();
        dao.setUsuario(getUsuario());
        try {
            dao.delete(obj);
        }catch (Exception ex) {
            throw new AgendaException(ex, getUsuario());
        }
    }

    @Override
    public Boolean update(MODEL obj) throws Exception {
        CrudDao<MODEL> dao = getDao();
        dao.setUsuario(getUsuario());
        try {
            return (Boolean)dao.update(obj);
        }catch (Exception ex) {
            throw new AgendaException(ex, getUsuario());
        }
    }

    @Override
    public List<MODEL> select() throws Exception {
        CrudDao<MODEL> dao = getDao();
        dao.setUsuario(getUsuario());
        try {
            return dao.select();
        }catch (Exception ex) {
            throw new AgendaException(ex, getUsuario());
        }
    }

    @Override
    public MODEL restore(Integer obj) throws Exception {
        CrudDao<MODEL> dao = getDao();
        dao.setUsuario(getUsuario());
        try {
            return (MODEL)dao.restore(obj);
        }catch (Exception ex) {
            throw new AgendaException(ex, getUsuario());
        }
    }
    
    @Override
    public MODEL report(MODEL obj) throws Exception {
        CrudDao<MODEL> dao = getDao();
        dao.setUsuario(getUsuario());
        try {
            return (MODEL) dao.report(obj);
        } catch (Exception ex) {
            throw new AgendaException(ex, getUsuario());
        }
    }    

    @Override
    public Usuario getUsuario() {
        return this.usr;
    }
    
    @Override
    public void setUsuario(Usuario usr) {
        this.usr = usr;
    }    
}
