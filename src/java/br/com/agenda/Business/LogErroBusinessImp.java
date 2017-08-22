/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.Business;

import br.com.agenda.Crud.CrudBusinessImp;
import br.com.agenda.Crud.CrudDao;
import br.com.agenda.Dao.LogErroDao;
import br.com.agenda.Model.LogErro;
import br.com.agenda.Model.Usuario;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Destroyer
 */
public class LogErroBusinessImp extends CrudBusinessImp<LogErro> implements LogErroBusiness{
    
    private LogErro erro = new LogErro();

    @Override
    public CrudDao getDao() throws Exception {
        return new LogErroDao();
    }
    
    public LogErroBusinessImp(String logerroDesc, Usuario logerroUsrId){
        erro.setLogerroData(new Date());
        erro.setLogerroHora(new Date());
        erro.setLogerroUsrId(logerroUsrId);
        erro.setLogerroDesc(logerroDesc);        
    }    

    @Override
    public void run() {
        try {
            super.setUsuario(erro.getLogerroUsrId());
            super.save(erro);
        } catch (Exception ex) {
            Logger.getLogger(LogErroBusinessImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
