/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.Exceptions;

import br.com.agenda.Business.LogAcessoBusinessImp;
import br.com.agenda.Business.LogErroBusiness;
import br.com.agenda.Business.LogErroBusinessImp;
import br.com.agenda.Constants.Constants;
import br.com.agenda.Model.Usuario;
import br.com.agenda.Utils.EnviaEmail;
import br.com.agenda.Utils.Utils;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

/**
 *
 * @author Destroyer
 */
public class AgendaException extends Exception{
    
   public AgendaException(Exception e, Usuario usr) throws Exception{
               StringWriter sw = new StringWriter();
        PrintWriter pw = new PrintWriter(sw);
        e.printStackTrace(pw);
        Logger.getLogger(AgendaException.class.getName()).log(Level.SEVERE, null, e);
        System.out.println(e);
        System.err.println(e);
        if (e instanceof LogicException) {
            FacesContext.getCurrentInstance().addMessage("msgLogic", new FacesMessage(FacesMessage.SEVERITY_INFO, e.getMessage(), ""));
        } else {
            String nomeClasse = "";
            String nomeFile = "";
            String nomeMetodo = "";
            Integer linha = 0;
            String causaErro = "";
            String mensagemErro = "";
            try{
                String dados = "<font color='blue' style='font-size: 14px;' ><b>Erro Sistema " + Constants.NOME_SISTEMA + " Data: " + Utils.getDataAtual() + " Hora: " + Utils.getHoraAtual() + "</b></font><br /><br />";
                if (e.getStackTrace().length > 1) {
                    for (int i = 0; i < e.getStackTrace().length; i++) {
                        nomeClasse = "<font color='blue' style='font-size: 14px;'><b>Classe: </b></font>" + e.getStackTrace()[i].getClassName() + "<br />";
                        nomeFile = "<font color='blue' style='font-size: 14px;'><b>Arquivo: </b></font>" + e.getStackTrace()[i].getFileName() + "<br />";
                        nomeMetodo = "<font color='blue' style='font-size: 14px;'><b>Método: </b></font>" + e.getStackTrace()[i].getMethodName() + "<br />";
                        linha = new Integer(e.getStackTrace()[i].getLineNumber());
                        causaErro = "<font color='blue' style='font-size: 14px;'><b>Causa Erro: </b></font>" + e.getCause() + "<br />";
                        mensagemErro = "<font color='blue' style='font-size: 14px;'><b>Mensagem: </b></font>" + e.getStackTrace()[i] + "<br /><br />";
                        dados = dados + nomeClasse + nomeFile + nomeMetodo + "<font color='blue' style='font-size: 14px;'><b>Linha: </b></font>" + linha.toString() + "<br />" + causaErro + mensagemErro;
                    }
                } else {
                    causaErro = "<font color='blue' style='font-size: 14px;'><b>Causa Erro: </b></font>" + e.getCause() + "<br />";
                    mensagemErro = "<font color='blue' style='font-size: 14px;'><b>Mensagem: </b></font>" + e.getStackTrace() + "<br />";
                    dados = dados + nomeClasse + nomeFile + nomeMetodo + linha.toString() + causaErro + mensagemErro;
                }  
                if (usr != null) {
                    LogErroBusiness erro = new LogErroBusinessImp(dados, usr);
                    erro.setUsuario(usr);
                    new Thread(erro).start();
                    if ("true".equalsIgnoreCase(Constants.ENVIA_EMAIL_DESENVOLVEDORES)) {
                        EnviaEmail enviar = new EnviaEmail("Erro sistema " + Constants.NOME_SISTEMA + " " + Utils.getDataAtual() + " " + Utils.getHoraAtual(), dados + "<br /><b>Mensagem Enviada automaticamente pelo sistema " + Constants.NOME_SISTEMA + ".</b><br /><br />");
                        new Thread(enviar).start();
                    }                    
                }else {
                    if ("true".equalsIgnoreCase(Constants.ENVIA_EMAIL_DESENVOLVEDORES)) {
                        EnviaEmail enviar = new EnviaEmail("Erro sistema " + Constants.NOME_SISTEMA + " " + Utils.getDataAtual() + " " + Utils.getHoraAtual(), dados + "<br /><b>Mensagem Enviada automaticamente pelo sistema " + Constants.NOME_SISTEMA + ".</b><br /><br />");
                        new Thread(enviar).start();
                    }                    
                }
            }catch(Exception ex){
                System.err.println("Erro ao gerar log de erro!\n\n" + ex);
            }
        }
   }
}
