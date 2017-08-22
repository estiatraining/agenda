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
@Table(name = "logerro")
@NamedQueries({
    @NamedQuery(name = "LogErro.findAll", query = "SELECT l FROM LogErro l")})
public class LogErro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "logerro_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer logerroId;
    @Basic(optional = false)
    @Column(name = "logerro_desc")
    private String logerroDesc;
    @Basic(optional = false)
    @Column(name = "logerro_data", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date logerroData;
    @Basic(optional = false)
    @Column(name = "logerro_hora", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date logerroHora;    
    @JoinColumn(name = "logerro_usr_id", referencedColumnName = "usr_id")
    @ManyToOne
    private Usuario logerroUsrId;

    public LogErro() {
    }

    public LogErro(Integer logerroId) {
        this.logerroId = logerroId;
    }

    public LogErro(Integer logerroId, String logerroDesc, Date logerroData, Date logerroHora) {
        this.logerroId = logerroId;
        this.logerroDesc = logerroDesc;
        this.logerroData = logerroData;
        this.logerroHora = logerroHora;
    }

    public Integer getLogerroId() {
        return logerroId;
    }

    public void setLogerroId(Integer logerroId) {
        this.logerroId = logerroId;
    }

    public String getLogerroDesc() {
        return logerroDesc;
    }

    public void setLogerroDesc(String logerroDesc) {
        this.logerroDesc = logerroDesc;
    }

    public Date getLogerroData() {
        return logerroData;
    }

    public void setLogerroData(Date logerroData) {
        this.logerroData = logerroData;
    }

    public Date getLogerroHora() {
        return logerroHora;
    }

    public void setLogerroHora(Date logerroHora) {
        this.logerroHora = logerroHora;
    }

    public Usuario getLogerroUsrId() {
        return logerroUsrId;
    }

    public void setLogerroUsrId(Usuario logerroUsrId) {
        this.logerroUsrId = logerroUsrId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (logerroId != null ? logerroId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LogErro)) {
            return false;
        }
        LogErro other = (LogErro) object;
        if ((this.logerroId == null && other.logerroId != null) || (this.logerroId != null && !this.logerroId.equals(other.logerroId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.agenda.Model.LogErro[ logerroId=" + logerroId + " ]";
    }
    
}
