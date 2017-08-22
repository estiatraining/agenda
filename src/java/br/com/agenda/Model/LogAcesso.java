/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.Model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Destroyer
 */
@Entity
@Table(name = "logacesso")
@NamedQueries({
    @NamedQuery(name = "LogAcesso.findAll", query = "SELECT l FROM LogAcesso l")})
public class LogAcesso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "logacesso_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer logacessoId;
    @Basic(optional = false)
    @Column(name = "logacesso_ip")
    private String logacessoIp;
    @Basic(optional = false)
    @Column(name = "logacesso_data", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date logacessoData;
    @Basic(optional = false)
    @Column(name = "logacesso_hora", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date logacessoHora;    
    @JoinColumn(name = "logacesso_usr_id", referencedColumnName = "usr_id")
    @ManyToOne
    private Usuario logacessoUsrId;

    public LogAcesso() {
    }

    public LogAcesso(Integer logacessoId) {
        this.logacessoId = logacessoId;
    }

    public LogAcesso(Integer logacessoId, Date logacessoData, Date logacessoHora, String logacessoIp) {
        this.logacessoId = logacessoId;
        this.logacessoData = logacessoData;
        this.logacessoHora = logacessoHora;
        this.logacessoIp = logacessoIp;
    }

    public Integer getLogacessoId() {
        return logacessoId;
    }

    public void setLogacessoId(Integer logacessoId) {
        this.logacessoId = logacessoId;
    }

    public Date getLogacessoData() {
        return logacessoData;
    }

    public void setLogacessoData(Date logacessoData) {
        this.logacessoData = logacessoData;
    }

    public Date getLogacessoHora() {
        return logacessoHora;
    }

    public void setLogacessoHora(Date logacessoHora) {
        this.logacessoHora = logacessoHora;
    }

    public String getLogacessoIp() {
        return logacessoIp;
    }

    public void setLogacessoIp(String logacessoIp) {
        this.logacessoIp = logacessoIp;
    }

    public Usuario getLogacessoUsrId() {
        return logacessoUsrId;
    }

    public void setLogacessoUsrId(Usuario logacessoUsrId) {
        this.logacessoUsrId = logacessoUsrId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (logacessoId != null ? logacessoId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LogAcesso)) {
            return false;
        }
        LogAcesso other = (LogAcesso) object;
        if ((this.logacessoId == null && other.logacessoId != null) || (this.logacessoId != null && !this.logacessoId.equals(other.logacessoId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.agenda.Model.LogAcesso[ logacessoId=" + logacessoId + " ]";
    }
    
}
