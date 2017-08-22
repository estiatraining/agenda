/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.Utils;

import br.com.agenda.Exceptions.AgendaException;
import br.com.agenda.Model.Usuario;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;

/**
 *
 * @author Destroyer
 */
public class SessionUtils implements PhaseListener {

    private Usuario usr = new Usuario();

    /**
     * 
     * @param event
     */
    @Override
    public void afterPhase(PhaseEvent event) {
        FacesContext context = event.getFacesContext();
        String currentPage = context.getViewRoot().getViewId();
        boolean verifyCurrentPage = (currentPage.lastIndexOf("index.xhtml") > -1);
        try {
            Usuario usrX = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usrSession");
            if (!verifyCurrentPage) {
                boolean auth = usrX != null;
                if (!auth) {
                    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("usrSession");
                    FacesContext.getCurrentInstance().addMessage("msgLogic", new FacesMessage(FacesMessage.SEVERITY_INFO, "Atenção", "Você não tem acesso a esta página!"));
                    FacesContext.getCurrentInstance().getExternalContext().redirect("/agenda/index.xhtml");
                }else{
                    System.out.println(currentPage);
                }
            }
        } catch (Exception e) {
            try {
                throw new AgendaException(e, usr);
            } catch (Exception ex) {
            }
        }
    }

    /**
     * 
     * @return
     */
    public Usuario getUsuarioSessions() {
        usr = (Usuario) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("usrSession");
        return usr;
    }

    /**
     * 
     * @param event
     */
    @Override
    public void beforePhase(PhaseEvent event) {
    }

    /**
     * 
     * @return
     */
    public String getData() {
        Date data = new Date();
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");
        return formatador.format(data);
    }

    /**
     * 
     * @return
     */
    @Override
    public PhaseId getPhaseId() {
        return PhaseId.RESTORE_VIEW;
    }
}
