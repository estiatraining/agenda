/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.Model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Destroyer
 */
@Entity
@Table(name = "parametro")
@NamedQueries({
    @NamedQuery(name = "Parametro.findAll", query = "SELECT p FROM Parametro p")})
public class Parametro implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "param_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer paramId;
    @Basic(optional = false)
    @Column(name = "param_campo")
    private String paramCampo;
    @Basic(optional = false)
    @Column(name = "param_valor")
    private String paramValor;
    @Basic(optional = false)
    @Column(name = "param_sts")
    private boolean paramSts;

    public Parametro() {
    }

    public Parametro(Integer paramId) {
        this.paramId = paramId;
    }

    public Parametro(Integer paramId, String paramCampo, String paramValor, boolean paramSts) {
        this.paramId = paramId;
        this.paramCampo = paramCampo;
        this.paramValor = paramValor;
        this.paramSts = paramSts;
    }

    public Integer getParamId() {
        return paramId;
    }

    public void setParamId(Integer paramId) {
        this.paramId = paramId;
    }

    public String getParamCampo() {
        return paramCampo;
    }

    public void setParamCampo(String paramCampo) {
        this.paramCampo = paramCampo;
    }

    public String getParamValor() {
        return paramValor;
    }

    public void setParamValor(String paramValor) {
        this.paramValor = paramValor;
    }

    public boolean getParamSts() {
        return paramSts;
    }

    public void setParamSts(boolean paramSts) {
        this.paramSts = paramSts;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (paramId != null ? paramId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Parametro)) {
            return false;
        }
        Parametro other = (Parametro) object;
        if ((this.paramId == null && other.paramId != null) || (this.paramId != null && !this.paramId.equals(other.paramId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.agenda.Model.Parametro[ paramId=" + paramId + " ]";
    }
    
}
