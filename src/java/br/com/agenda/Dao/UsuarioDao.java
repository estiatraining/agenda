/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.Dao;

import br.com.agenda.Crud.CrudDaoImp;
import br.com.agenda.Exceptions.AgendaException;
import br.com.agenda.Model.Usuario;

/**
 *
 * @author Destroyer
 */
public class UsuarioDao  extends CrudDaoImp<Usuario, Usuario>{

    @Override
    public Usuario report(Usuario obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public Usuario validarUsuario(Usuario obj) throws AgendaException, Exception {
        try {
            Usuario bean = (Usuario) super.getPurePojo("FROM br.com.agenda.Model.Usuario WHERE usrLogin = ? AND usrSenha = ?", obj.getUsrLogin(), obj.getUsrSenha());
            return bean;
        } catch (Exception e) {
            throw new AgendaException(e, getUsuario());
        }
    }    
}
