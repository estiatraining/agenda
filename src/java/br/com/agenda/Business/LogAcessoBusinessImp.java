/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.Business;

import br.com.agenda.Crud.CrudBusinessImp;
import br.com.agenda.Crud.CrudDao;
import br.com.agenda.Dao.LogAcessoDao;
import br.com.agenda.Model.LogAcesso;
import br.com.agenda.Model.Usuario;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Destroyer
 */
public class LogAcessoBusinessImp extends CrudBusinessImp<LogAcesso> implements LogAcessoBusiness{

    private LogAcesso logAcesso = new LogAcesso();
    
    @Override
    public CrudDao<LogAcesso> getDao() throws Exception {
        return new LogAcessoDao();
    }
    
    public LogAcessoBusinessImp(String logacessIp, Usuario logacessUsrId) {        
        this.logAcesso.setLogacessoData(new Date());
        this.logAcesso.setLogacessoHora(new Date());
        this.logAcesso.setLogacessoIp(logacessIp);
        this.logAcesso.setLogacessoUsrId(logacessUsrId);
    }    

    @Override
    public void run() {
        try {
            super.setUsuario(logAcesso.getLogacessoUsrId());
            super.save(logAcesso);
        } catch (Exception ex) {
            Logger.getLogger(LogAcessoBusinessImp.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
