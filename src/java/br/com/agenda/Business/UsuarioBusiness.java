/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.Business;

import br.com.agenda.Crud.CrudBusiness;
import br.com.agenda.Model.Usuario;

/**
 *
 * @author Destroyer
 */
public interface UsuarioBusiness extends CrudBusiness<Usuario>{
    public Usuario validarUsuario(Usuario objUsuario) throws Exception ;
}
