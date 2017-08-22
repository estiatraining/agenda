/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.Crud;

import br.com.agenda.Exceptions.AgendaException;
import br.com.agenda.Utils.SessionUtils;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Destroyer
 */
public abstract class CrudControllerImp<MODEL extends Serializable> extends SessionUtils implements CrudController<MODEL> {
    
    public abstract Integer getId();

    public abstract CrudBusiness<MODEL> getBusiness() throws Exception;
    
    @Override
    public void save()throws Exception {
        CrudBusiness<MODEL> Business = getBusiness();
        Business.setUsuario(getUsuarioSessions());
        MODEL model = (MODEL) getBean();
        try{
            Business.save(model);
            FacesContext.getCurrentInstance().addMessage("msgRetorno", new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro inserido com sucesso!", ""));
            clear();
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage("msgRetorno", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Não foi possivel incluir registro!", ""));
            throw new AgendaException(e, getUsuarioSessions());            
        }
    }
    
   /**
     * 
     * @throws Exception
     */
    @Override
    public void delete()throws Exception {
        CrudBusiness<MODEL> Business = getBusiness();
        Business.setUsuario(getUsuarioSessions());
        MODEL model = (MODEL) getBean();   
        try{
            Business.delete(model);
            FacesContext.getCurrentInstance().addMessage("msgRetorno", new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro deletado com sucesso!", ""));
            clear();
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage("msgRetorno", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Não foi possivel deletar registro!", ""));
            throw new AgendaException(e, getUsuarioSessions()); 
        }        
    }

    /**
     * 
     * @throws Exception
     */
    @Override
    public void update() throws Exception{
        CrudBusiness<MODEL> Business = getBusiness();
        Business.setUsuario(getUsuarioSessions());
        MODEL model = (MODEL) getBean();  
        try{
            Business.update(model);
            FacesContext.getCurrentInstance().addMessage("msgRetorno", new FacesMessage(FacesMessage.SEVERITY_INFO, "Registro atualizado com sucesso!", ""));
            clear();
        }catch(Exception e){
            FacesContext.getCurrentInstance().addMessage("msgRetorno", new FacesMessage(FacesMessage.SEVERITY_ERROR, "Não foi atualizar registro!", ""));
            throw new AgendaException(e, getUsuarioSessions()); 
        }        
    }

    /**
     * 
     * @throws Exception
     */
    @Override
    public void restore()throws Exception {
        CrudBusiness<MODEL> Business = getBusiness();
        Business.setUsuario(getUsuarioSessions());
        MODEL model = (MODEL) getBean(); 
        try{
            Business.restore(getId());
        }catch(Exception e){
            throw new AgendaException(e, getUsuarioSessions()); 
        }        
    }

    /**
     * 
     * @throws Exception
     */
    @Override
    public void report() throws Exception{
        CrudBusiness<MODEL> Business = getBusiness();
        Business.setUsuario(getUsuarioSessions());
        MODEL model = (MODEL) getBean();   
        try{
            Business.report(model);
        }catch(Exception e){
            throw new AgendaException(e, getUsuarioSessions());  
        }        
    }    
}
