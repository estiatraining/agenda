/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.Business;

import br.com.agenda.Crud.CrudBusiness;
import br.com.agenda.Model.Menu;
import org.primefaces.model.MenuModel;

/**
 *
 * @author Destroyer
 */
public interface MenuBusiness extends CrudBusiness<Menu> {
    public MenuModel menusSistema() throws Exception ;
}
