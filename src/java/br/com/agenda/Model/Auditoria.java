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
@Table(name = "auditoria")
@NamedQueries({
    @NamedQuery(name = "Auditoria.findAll", query = "SELECT a FROM Auditoria a")})
public class Auditoria implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "auditoria_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer auditoriaId;
    @Basic(optional = false)
    @Column(name = "auditoria_acao")
    private String auditoriaAcao;
    @Basic(optional = false)
    @Column(name = "auditoria_tabela")
    private String auditoriaTabela;
    @Basic(optional = false)
    @Column(name = "auditoria_id_tabela")
    private String auditoriaIdTabela;
    @Basic(optional = false)
    @Column(name = "auditoria_data", nullable = false)
    @Temporal(TemporalType.DATE)
    private Date auditoriaData;
    @Basic(optional = false)
    @Column(name = "auditoria_hora", nullable = false)
    @Temporal(TemporalType.TIME)
    private Date auditoriaHora;    
    @JoinColumn(name = "auditoria_usr_id", referencedColumnName = "usr_id")
    @ManyToOne
    private Usuario auditoriaUsrId;

    public Auditoria() {
    }

    public Auditoria(Integer auditoriaId) {
        this.auditoriaId = auditoriaId;
    }

    public Auditoria(Integer auditoriaId, String auditoriaAcao, Date auditoriaData, Date auditoriaHora, String auditoriaTabela, String auditoriaIdTabela) {
        this.auditoriaId = auditoriaId;
        this.auditoriaAcao = auditoriaAcao;
        this.auditoriaData = auditoriaData;
        this.auditoriaHora = auditoriaHora;
        this.auditoriaTabela = auditoriaTabela;
        this.auditoriaIdTabela = auditoriaIdTabela;
    }

    public Integer getAuditoriaId() {
        return auditoriaId;
    }

    public void setAuditoriaId(Integer auditoriaId) {
        this.auditoriaId = auditoriaId;
    }

    public String getAuditoriaAcao() {
        return auditoriaAcao;
    }

    public void setAuditoriaAcao(String auditoriaAcao) {
        this.auditoriaAcao = auditoriaAcao;
    }

    public Date getAuditoriaData() {
        return auditoriaData;
    }

    public void setAuditoriaData(Date auditoriaData) {
        this.auditoriaData = auditoriaData;
    }

    public Date getAuditoriaHora() {
        return auditoriaHora;
    }

    public void setAuditoriaHora(Date auditoriaHora) {
        this.auditoriaHora = auditoriaHora;
    }

    public String getAuditoriaTabela() {
        return auditoriaTabela;
    }

    public void setAuditoriaTabela(String auditoriaTabela) {
        this.auditoriaTabela = auditoriaTabela;
    }

    public String getAuditoriaIdTabela() {
        return auditoriaIdTabela;
    }

    public void setAuditoriaIdTabela(String auditoriaIdTabela) {
        this.auditoriaIdTabela = auditoriaIdTabela;
    }

    public Usuario getAuditoriaUsrId() {
        return auditoriaUsrId;
    }

    public void setAuditoriaUsrId(Usuario auditoriaUsrId) {
        this.auditoriaUsrId = auditoriaUsrId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (auditoriaId != null ? auditoriaId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Auditoria)) {
            return false;
        }
        Auditoria other = (Auditoria) object;
        if ((this.auditoriaId == null && other.auditoriaId != null) || (this.auditoriaId != null && !this.auditoriaId.equals(other.auditoriaId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.agenda.Model.Auditoria[ auditoriaId=" + auditoriaId + " ]";
    }
    
}
