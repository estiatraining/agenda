/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.Model;

import br.com.agenda.Utils.Utils;
import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Destroyer
 */
@Entity
@Table(name = "usuario")
@NamedQueries({
    @NamedQuery(name = "Usuario.findAll", query = "SELECT u FROM Usuario u")})
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "usr_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer usrId;
    @Basic(optional = false)
    @Column(name = "usr_nome")
    private String usrNome;
    @Basic(optional = false)
    @Column(name = "usr_login")
    private String usrLogin;
    @Basic(optional = false)
    @Column(name = "usr_senha")
    private String usrSenha;
    @Basic(optional = false)
    @Column(name = "usr_sts")
    private boolean usrSts;
    @Basic(optional = false)
    @Column(name = "usr_tipo")
    private String usrTipo;
    @OneToMany(mappedBy = "logerroUsrId")
    private Collection<LogErro> logErroCollection;
    @OneToMany(mappedBy = "auditoriaUsrId")
    private Collection<Auditoria> auditoriaCollection;
    @OneToMany(mappedBy = "logacessoUsrId")
    private Collection<LogAcesso> logAcessoCollection;
    @OneToMany(mappedBy = "acessUsrId")
    private Collection<Acesso> acessoCollection;

    public Usuario() {
    }

    public Usuario(Integer usrId) {
        this.usrId = usrId;
    }

    public Usuario(Integer usrId, String usrNome, String usrLogin, String usrSenha, boolean usrSts, String usrTipo) {
        this.usrId = usrId;
        this.usrNome = usrNome;
        this.usrLogin = usrLogin;
        this.usrSenha = usrSenha;
        this.usrSts = usrSts;
        this.usrTipo = usrTipo;
    }

    public Integer getUsrId() {
        return usrId;
    }

    public void setUsrId(Integer usrId) {
        this.usrId = usrId;
    }

    public String getUsrNome() {
        return usrNome;
    }

    public void setUsrNome(String usrNome) {
        this.usrNome = usrNome;
    }

    public String getUsrLogin() {
        return usrLogin;
    }

    public void setUsrLogin(String usrLogin) {
        this.usrLogin = usrLogin;
    }

    public String getUsrSenha() {
        return usrSenha;
    }

    public void setUsrSenha(String usrSenha) {
        this.usrSenha = new Utils().gerarMD5(usrSenha);
    }

    public boolean getUsrSts() {
        return usrSts;
    }

    public void setUsrSts(boolean usrSts) {
        this.usrSts = usrSts;
    }

    public Collection<LogErro> getLogErroCollection() {
        return logErroCollection;
    }

    public void setLogErroCollection(Collection<LogErro> logErroCollection) {
        this.logErroCollection = logErroCollection;
    }

    public Collection<Auditoria> getAuditoriaCollection() {
        return auditoriaCollection;
    }

    public void setAuditoriaCollection(Collection<Auditoria> auditoriaCollection) {
        this.auditoriaCollection = auditoriaCollection;
    }

    public Collection<LogAcesso> getLogAcessoCollection() {
        return logAcessoCollection;
    }

    public void setLogAcessoCollection(Collection<LogAcesso> logAcessoCollection) {
        this.logAcessoCollection = logAcessoCollection;
    }

    public Collection<Acesso> getAcessoCollection() {
        return acessoCollection;
    }

    public void setAcessoCollection(Collection<Acesso> acessoCollection) {
        this.acessoCollection = acessoCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usrId != null ? usrId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Usuario)) {
            return false;
        }
        Usuario other = (Usuario) object;
        if ((this.usrId == null && other.usrId != null) || (this.usrId != null && !this.usrId.equals(other.usrId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.agenda.Model.Usuario[ usrId=" + usrId + " ]";
    }

    /**
     * @return the usrTipo
     */
    public String getUsrTipo() {
        return usrTipo;
    }

    /**
     * @param usrTipo the usrTipo to set
     */
    public void setUsrTipo(String usrTipo) {
        this.usrTipo = usrTipo;
    }
}
