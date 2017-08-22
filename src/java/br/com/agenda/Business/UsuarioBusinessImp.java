/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.Business;

import br.com.agenda.Crud.CrudBusinessImp;
import br.com.agenda.Crud.CrudDao;
import br.com.agenda.Dao.UsuarioDao;
import br.com.agenda.Exceptions.AgendaException;
import br.com.agenda.Model.Usuario;
import java.util.List;

/**
 *
 * @author Destroyer
 */
public class UsuarioBusinessImp extends CrudBusinessImp<Usuario> implements UsuarioBusiness{

    @Override
    public CrudDao<Usuario> getDao() throws Exception {
        return new UsuarioDao();
    }

    @Override
    public Usuario validarUsuario(Usuario objUsuario) throws Exception {
        try {
            List<Usuario> dados = getDao().select();
            if (dados != null) {
                if (dados.isEmpty()) {
                    if ("admin".equals(objUsuario.getUsrLogin()) && "202cb962ac59075b964b07152d234b70".equalsIgnoreCase(objUsuario.getUsrSenha())) {
                        objUsuario = addUsuarioDefault();
                        if (objUsuario.getUsrId() != null) {
                            return objUsuario;
                        } else {
                            return null;
                        }
                    } else {
                        return null;
                    }
                } else {
                    Usuario obj = ((UsuarioDao)getDao()).validarUsuario(objUsuario);
                    if (obj != null) {
                        return obj;
                    } else {
                        return null;
                    }
                }
            }
        } catch (Exception ex) {
            throw new AgendaException(ex, this.getUsuario());
        }
        return null;
    }
    
    public Usuario addUsuarioDefault() throws Exception {
        Usuario objUsuario = new Usuario();
        objUsuario.setUsrLogin("admin");
        objUsuario.setUsrNome("Administrador");
        objUsuario.setUsrSenha("123");
        objUsuario.setUsrSts(true);
        objUsuario.setUsrTipo("A");
        return (Usuario) super.save(objUsuario);
    }    
    
}
