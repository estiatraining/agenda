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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Destroyer
 */
@Entity
@Table(name = "acesso")
@NamedQueries({
    @NamedQuery(name = "Acesso.findAll", query = "SELECT a FROM Acesso a")})
public class Acesso implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "acess_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer acessId;
    @Basic(optional = false)
    @Column(name = "acess_alt")
    private boolean acessAlt;
    @Basic(optional = false)
    @Column(name = "acess_pesq")
    private boolean acessPesq;
    @Basic(optional = false)
    @Column(name = "acess_excl")
    private boolean acessExcl;
    @Basic(optional = false)
    @Column(name = "acess_incl")
    private boolean acessIncl;
    @Basic(optional = false)
    @Column(name = "acess_sts")
    private boolean acessSts;
    @JoinColumn(name = "acess_usr_id", referencedColumnName = "usr_id")
    @ManyToOne
    private Usuario acessUsrId;
    @JoinColumn(name = "acess_menu_id", referencedColumnName = "menu_id")
    @ManyToOne
    private Menu acessMenuId;

    public Acesso() {
    }

    public Acesso(Integer acessId) {
        this.acessId = acessId;
    }

    public Acesso(Integer acessId, boolean acessAlt, boolean acessPesq, boolean acessExcl, boolean acessIncl, boolean acessSts) {
        this.acessId = acessId;
        this.acessAlt = acessAlt;
        this.acessPesq = acessPesq;
        this.acessExcl = acessExcl;
        this.acessIncl = acessIncl;
        this.acessSts = acessSts;
    }

    public Integer getAcessId() {
        return acessId;
    }

    public void setAcessId(Integer acessId) {
        this.acessId = acessId;
    }

    public boolean getAcessAlt() {
        return acessAlt;
    }

    public void setAcessAlt(boolean acessAlt) {
        this.acessAlt = acessAlt;
    }

    public boolean getAcessPesq() {
        return acessPesq;
    }

    public void setAcessPesq(boolean acessPesq) {
        this.acessPesq = acessPesq;
    }

    public boolean getAcessExcl() {
        return acessExcl;
    }

    public void setAcessExcl(boolean acessExcl) {
        this.acessExcl = acessExcl;
    }

    public boolean getAcessIncl() {
        return acessIncl;
    }

    public void setAcessIncl(boolean acessIncl) {
        this.acessIncl = acessIncl;
    }

    public boolean getAcessSts() {
        return acessSts;
    }

    public void setAcessSts(boolean acessSts) {
        this.acessSts = acessSts;
    }

    public Usuario getAcessUsrId() {
        return acessUsrId;
    }

    public void setAcessUsrId(Usuario acessUsrId) {
        this.acessUsrId = acessUsrId;
    }

    public Menu getAcessMenuId() {
        return acessMenuId;
    }

    public void setAcessMenuId(Menu acessMenuId) {
        this.acessMenuId = acessMenuId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (acessId != null ? acessId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Acesso)) {
            return false;
        }
        Acesso other = (Acesso) object;
        if ((this.acessId == null && other.acessId != null) || (this.acessId != null && !this.acessId.equals(other.acessId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.agenda.Model.Acesso[ acessId=" + acessId + " ]";
    }
    
}
