/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.Dao;

import br.com.agenda.Crud.CrudDaoImp;
import br.com.agenda.Model.Menu;
import java.util.List;

/**
 *
 * @author Destroyer
 */
public class MenuDao extends CrudDaoImp<Menu, Menu>{

    @Override
    public Menu report(Menu obj) throws Exception {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
    public List<Menu> retornaMenus(Menu obj, int nivel) throws Exception {
        if (nivel == 0) {
            return super.list(Menu.class, "FROM br.com.agenda.Model.Menu WHERE menuMenuId = ? ORDER BY menuOrdem", 0);
        } else {
            return super.list(Menu.class, "FROM br.com.agenda.Model.Menu WHERE menuMenuId = ? AND menuSts = ? ORDER BY menuOrdem", obj.getMenuId(), true);
        }
    }

    public List<Menu> list() throws Exception {
        return super.list(Menu.class, "FROM br.com.agenda.Model.Menu ORDER BY menuId");
    }    
}
