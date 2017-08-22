/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.Controller;

import br.com.agenda.Business.MenuBusiness;
import br.com.agenda.Business.MenuBusinessImp;
import br.com.agenda.Crud.CrudBusiness;
import br.com.agenda.Crud.CrudControllerImp;
import br.com.agenda.Model.Menu;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.model.DataModel;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;

/**
 *
 * @author Destroyer
 */
@ManagedBean(name = "cMenu")
@RequestScoped
public class MenuController extends CrudControllerImp<Menu> {

    private Menu objMenu;
    private MenuModel modelo;
    private DataModel tabModel, tabModelPesq;
    private Menu rowSelect;

    public MenuController() throws Exception {
        MenuBusiness business = (MenuBusiness) getBusiness();
        business.setUsuario(getUsuarioSessions());
        this.objMenu = new Menu();
        this.modelo = new DefaultMenuModel();
        this.modelo = business.menusSistema();        
    }

    @Override
    public Integer getId() {
        return this.getObjMenu().getMenuId();
    }

    @Override
    public CrudBusiness<Menu> getBusiness() throws Exception {
        MenuBusiness business = new MenuBusinessImp();        
        return business;
    }

    @Override
    public void clear() throws Exception {
        this.setObjMenu(new Menu());
    }

    @Override
    public Menu getBean() throws Exception {
        return getObjMenu();
    }

    /**
     * @return the objMenu
     */
    public Menu getObjMenu() {
        return objMenu;
    }

    /**
     * @param objMenu the objMenu to set
     */
    public void setObjMenu(Menu objMenu) {
        this.objMenu = objMenu;
    }

    /**
     * @return the modelo
     */
    public MenuModel getModelo() {
        return modelo;
    }

    /**
     * @param modelo the modelo to set
     */
    public void setModelo(MenuModel modelo) {
        this.modelo = modelo;
    }

    /**
     * @return the tabModel
     */
    public DataModel getTabModel() {
        return tabModel;
    }

    /**
     * @param tabModel the tabModel to set
     */
    public void setTabModel(DataModel tabModel) {
        this.tabModel = tabModel;
    }

    /**
     * @return the tabModelPesq
     */
    public DataModel getTabModelPesq() {
        return tabModelPesq;
    }

    /**
     * @param tabModelPesq the tabModelPesq to set
     */
    public void setTabModelPesq(DataModel tabModelPesq) {
        this.tabModelPesq = tabModelPesq;
    }

    /**
     * @return the rowSelect
     */
    public Menu getRowSelect() {
        return rowSelect;
    }

    /**
     * @param rowSelect the rowSelect to set
     */
    public void setRowSelect(Menu rowSelect) {
        this.rowSelect = rowSelect;
    }
}
