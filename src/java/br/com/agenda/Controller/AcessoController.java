/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.Controller;
import br.com.agenda.Business.AcessoBusiness;
import br.com.agenda.Business.AcessoBusinessImp;
import br.com.agenda.Crud.CrudBusiness;
import br.com.agenda.Crud.CrudControllerImp;
import br.com.agenda.Model.Acesso;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
/**
 *
 * @author Destroyer
 */
@ManagedBean(name = "cAcesso")
@RequestScoped
public class AcessoController extends CrudControllerImp<Acesso>{
    private Acesso objAcesso;

    @Override
    public Integer getId() {
        return this.getObjAcesso().getAcessId();
    }

    @Override
    public CrudBusiness<Acesso> getBusiness() throws Exception {
        AcessoBusiness business = new AcessoBusinessImp();        
        return business;
    }

    @Override
    public void clear() throws Exception {
        this.setObjAcesso(new Acesso());
    }

    @Override
    public Acesso getBean() throws Exception {
        return getObjAcesso();
    }
    
    public Acesso getObjAcesso() {
        return objAcesso;
    }

    public void setObjAcesso(Acesso objAcesso) {
        this.objAcesso = objAcesso;
    }     
}
