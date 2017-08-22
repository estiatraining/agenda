/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.Business;

import br.com.agenda.Crud.CrudBusinessImp;
import br.com.agenda.Crud.CrudDao;
import br.com.agenda.Dao.AuditoriaDao;
import br.com.agenda.Model.Auditoria;
import br.com.agenda.Model.Usuario;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Destroyer
 */
public class AuditoriaBusinessImp extends CrudBusinessImp<Auditoria> implements AuditoriaBusiness{
    
    private Auditoria auditoria = new Auditoria();

    @Override
    public CrudDao<Auditoria> getDao() throws Exception {
        return new AuditoriaDao();
    }
    
    public AuditoriaBusinessImp(String audAcao, String audTabela, String audIdacao, Usuario audUsrId){
        auditoria.setAuditoriaData(new Date());
        auditoria.setAuditoriaHora(new Date());
        auditoria.setAuditoriaAcao(audAcao);
        auditoria.setAuditoriaIdTabela(audIdacao);
        auditoria.setAuditoriaTabela(audTabela);
        auditoria.setAuditoriaUsrId(audUsrId);
    }  

    @Override
    public void run() {
        try {
            super.setUsuario(auditoria.getAuditoriaUsrId());
            super.save(auditoria);
        } catch (Exception ex) {
            Logger.getLogger(AuditoriaBusinessImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
