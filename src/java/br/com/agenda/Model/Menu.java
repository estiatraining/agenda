/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.Model;

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
@Table(name = "menu")
@NamedQueries({
    @NamedQuery(name = "Menu.findAll", query = "SELECT m FROM Menu m")})
public class Menu implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "menu_id")
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Integer menuId;
    @Basic(optional = false)
    @Column(name = "menu_nome")
    private String menuNome;
    @Basic(optional = false)
    @Column(name = "menu_link")
    private String menuLink;
    @Basic(optional = false)
    @Column(name = "menu_sts")
    private boolean menuSts;
    @Basic(optional = false)
    @Column(name = "menu_tipo")
    private String menuTipo;
    @Column(name = "menu_descr", length = 256)
    private String menuDescr;
    @Basic(optional = false)
    @Column(name = "menu_ordem", nullable = false)
    private int menuOrdem;
    @Basic(optional = false)
    @Column(name = "menu_menu_id", nullable = false)
    private int menuMenuId;    
    @OneToMany(mappedBy = "acessMenuId")
    private Collection<Acesso> acessoCollection;

    public Menu() {
    }

    public Menu(Integer menuId) {
        this.menuId = menuId;
    }

    public Menu(Integer menuId, String menuNome, String menuLink, boolean menuSts, String menuTipo) {
        this.menuId = menuId;
        this.menuNome = menuNome;
        this.menuLink = menuLink;
        this.menuSts = menuSts;
        this.menuTipo = menuTipo;
    }

    public Integer getMenuId() {
        return menuId;
    }

    public void setMenuId(Integer menuId) {
        this.menuId = menuId;
    }

    public String getMenuNome() {
        return menuNome;
    }

    public void setMenuNome(String menuNome) {
        this.menuNome = menuNome;
    }

    public String getMenuLink() {
        return menuLink;
    }

    public void setMenuLink(String menuLink) {
        this.menuLink = menuLink;
    }

    public boolean getMenuSts() {
        return menuSts;
    }

    public void setMenuSts(boolean menuSts) {
        this.menuSts = menuSts;
    }

    public String getMenuTipo() {
        return menuTipo;
    }

    public void setMenuTipo(String menuTipo) {
        this.menuTipo = menuTipo;
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
        hash += (menuId != null ? menuId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Menu)) {
            return false;
        }
        Menu other = (Menu) object;
        if ((this.menuId == null && other.menuId != null) || (this.menuId != null && !this.menuId.equals(other.menuId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.agenda.Model.Menu[ menuId=" + menuId + " ]";
    }

    public String getMenuDescr() {
        return menuDescr;
    }

    public void setMenuDescr(String menuDescr) {
        this.menuDescr = menuDescr;
    }

    public int getMenuOrdem() {
        return menuOrdem;
    }

    public void setMenuOrdem(int menuOrdem) {
        this.menuOrdem = menuOrdem;
    }

    public int getMenuMenuId() {
        return menuMenuId;
    }

    public void setMenuMenuId(int menuMenuId) {
        this.menuMenuId = menuMenuId;
    }
    
}
