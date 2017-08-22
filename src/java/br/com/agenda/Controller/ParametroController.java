/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.Controller;
import br.com.agenda.Business.ParametroBusiness;
import br.com.agenda.Business.ParametroBusinessImp;
import br.com.agenda.Crud.CrudBusiness;
import br.com.agenda.Crud.CrudControllerImp;
import br.com.agenda.Model.Parametro;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
/**
 *
 * @author Destroyer
 */
@ManagedBean(name = "cParametro")
@RequestScoped
public class ParametroController  extends CrudControllerImp<Parametro> {
    
    private Parametro objParametro;

    @Override
    public Integer getId() {
        return this.getObjParametro().getParamId();
    }

    @Override
    public CrudBusiness<Parametro> getBusiness() throws Exception {
        ParametroBusiness business = new ParametroBusinessImp();        
        return business;
    }

    @Override
    public void clear() throws Exception {
        this.setObjParametro(new Parametro());
    }

    @Override
    public Parametro getBean() throws Exception {
        return getObjParametro();
    }
    
    public Parametro getObjParametro() {
        return objParametro;
    }

    public void setObjParametro(Parametro objParametro) {
        this.objParametro = objParametro;
    }    
    
}
