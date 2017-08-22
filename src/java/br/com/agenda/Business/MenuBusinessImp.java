/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.Business;

import br.com.agenda.Crud.CrudBusinessImp;
import br.com.agenda.Crud.CrudDao;
import br.com.agenda.Dao.AcessoDao;
import br.com.agenda.Dao.MenuDao;
import br.com.agenda.Exceptions.AgendaException;
import br.com.agenda.Model.Acesso;
import br.com.agenda.Model.Menu;
import br.com.agenda.Model.Usuario;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import javax.faces.model.DataModel;
import org.primefaces.component.menuitem.MenuItem;
import org.primefaces.component.submenu.Submenu;
import org.primefaces.model.DefaultMenuModel;
import org.primefaces.model.MenuModel;

/**
 *
 * @author Destroyer
 */
public class MenuBusinessImp extends CrudBusinessImp<Menu> implements MenuBusiness, Serializable {

    private Menu model = new Menu();
    private Usuario usr;
    private DataModel tabModel;
    private MenuModel modelo;

    @Override
    public CrudDao<Menu> getDao() throws Exception {
        return new MenuDao();
    }

    @Override
    public MenuModel menusSistema() throws Exception {
        try {
            Submenu submenu;
            Menu aux = new Menu();
            getDao().setUsuario(this.getUsuario());
            aux.setMenuTipo(this.getUsuario().getUsrTipo());
            this.modelo = new DefaultMenuModel();
            if (!getDao().select().isEmpty()) {
                String valida = "off";
                for (Menu obj : ((MenuDao) getDao()).retornaMenus(aux, 0)) {
                    submenu = new Submenu();
                    valida = "off";
                    if ("A".equalsIgnoreCase(this.getUsuario().getUsrTipo())) {
                        submenu.setLabel(obj.getMenuNome());
                        submenu.setId(  obj.getMenuNome().replaceAll("\\ ", "_") );
                    } else if ("G".equalsIgnoreCase(this.getUsuario().getUsrTipo())) {
                        if ("G".equalsIgnoreCase(obj.getMenuTipo()) || "F".equalsIgnoreCase(obj.getMenuTipo())) {
                            submenu.setLabel(obj.getMenuNome());
                            submenu.setId(obj.getMenuNome().replaceAll("\\ ", "_"));
                        }
                    } else if ("F".equalsIgnoreCase(this.getUsuario().getUsrTipo())) {
                        if ("F".equalsIgnoreCase(obj.getMenuTipo())) {
                            submenu.setLabel(obj.getMenuNome());
                            submenu.setId(obj.getMenuNome().replaceAll("\\ ", "_"));
                        }
                    }
                    for (Menu o : ((MenuDao) getDao()).retornaMenus(obj, 1)) {
                        valida = "on";
                        MenuItem item = new MenuItem();
                        if ("A".equalsIgnoreCase(this.getUsuario().getUsrTipo())) {
                            item.setValue(o.getMenuNome());
                            item.setUrl(o.getMenuLink());
                        } else if ("G".equalsIgnoreCase(this.getUsuario().getUsrTipo())) {
                            if ("G".equalsIgnoreCase(obj.getMenuTipo()) || "F".equalsIgnoreCase(obj.getMenuTipo())) {
                                item.setValue(o.getMenuNome());
                                item.setUrl(o.getMenuLink());
                            }
                        } else if ("F".equalsIgnoreCase(this.getUsuario().getUsrTipo())) {
                            if ("F".equalsIgnoreCase(obj.getMenuTipo())) {
                                item.setValue(o.getMenuNome());
                                item.setUrl(o.getMenuLink());
                            }
                        }
                        submenu.getChildren().add(item);
                    }
                    if ("off".equalsIgnoreCase(valida)) {
                        MenuItem item = new MenuItem();
                        if ("A".equalsIgnoreCase(this.getUsuario().getUsrTipo())) {
                            item.setValue(obj.getMenuNome());
                            item.setUrl(obj.getMenuLink());
                        } else if ("G".equalsIgnoreCase(this.getUsuario().getUsrTipo())) {
                            if ("G".equalsIgnoreCase(obj.getMenuTipo()) || "F".equalsIgnoreCase(obj.getMenuTipo())) {
                                item.setValue(obj.getMenuNome().replaceAll("\\ ", "_"));
                                item.setUrl(obj.getMenuLink());
                            }
                        } else if ("F".equalsIgnoreCase(this.getUsuario().getUsrTipo())) {
                            if ("F".equalsIgnoreCase(obj.getMenuTipo())) {
                                item.setValue(obj.getMenuNome());
                                item.setUrl(obj.getMenuLink());
                            }
                        }
                        submenu.getChildren().add(item);
                    }
                    this.modelo.addSubmenu(submenu);
                }
                return this.modelo;
            } else {
                addMenusSistema();
                for (Menu obj : ((MenuDao) getDao()).retornaMenus(aux, 0)) {
                    submenu = new Submenu();
                    submenu.setLabel(obj.getMenuNome());
                    submenu.setId(obj.getMenuNome());
                    for (Menu o : ((MenuDao) getDao()).retornaMenus(obj, 1)) {
                        MenuItem item = new MenuItem();
                        item.setValue(o.getMenuNome());
                        item.setUrl(o.getMenuLink());
                        submenu.getChildren().add(item);
                    }
                    this.modelo.addSubmenu(submenu);
                }
                return this.modelo;
            }
        } catch (Exception e) {
            throw new AgendaException(e, this.getUsuario());
            //return this.modelo;
        }
    }

    private void addMenusSistema() throws Exception {
        try {
            Acesso modelAcesso = new Acesso();
            AcessoDao daoAcesso = new AcessoDao();
            getDao().setUsuario(this.getUsuario());
            daoAcesso.setUsuario(this.getUsuario());
            Collection<Menu> pai = menusPai();
            String[] nomePai = new String[10];
            Integer[] idPai = new Integer[10];
            int i = 0;
            for (Menu model : pai) {
                Menu beanRetorno = getDao().save(model);
                nomePai[i] = beanRetorno.getMenuNome();
                idPai[i] = beanRetorno.getMenuId();
                modelAcesso.setAcessMenuId(beanRetorno);
                modelAcesso.setAcessUsrId(this.getUsuario());
                modelAcesso.setAcessAlt(true);
                modelAcesso.setAcessExcl(true);
                modelAcesso.setAcessIncl(true);
                modelAcesso.setAcessPesq(true);
                modelAcesso.setAcessSts(true);
                daoAcesso.save(modelAcesso);
                i++;
            }
            Map<String, Collection<Menu>> filho = menusFilho(nomePai, idPai);
            if (!filho.isEmpty()) {
                Collection<Collection<Menu>> dadosFilhog = filho.values();
                for (Collection<Menu> model : dadosFilhog) {
                    for (Menu model2 : model) {
                        getDao().save(model2);
                        modelAcesso.setAcessMenuId(model2);
                        modelAcesso.setAcessUsrId(this.getUsuario());
                        modelAcesso.setAcessAlt(true);
                        modelAcesso.setAcessExcl(true);
                        modelAcesso.setAcessIncl(true);
                        modelAcesso.setAcessPesq(true);
                        modelAcesso.setAcessSts(true);
                        daoAcesso.save(modelAcesso);
                    }
                }
            }
        } catch (Exception e) {
            throw new AgendaException(e, this.getUsuario());
        }
    }

    private Collection<Menu> menusPai() throws Exception {
        try {
            String[] nome = {"Agenda", "Lembrete", "Ligações", "Pessoa", "Datas", "Nota Técnica", "Demandas", "Gráficos", "Configurações", "Ajuda"};
            String[] cadastrosDesc = {"", "Cadastro/alteração dos Lembretes", "Cadastro/alteração de Ligações", "Cadastro/alteração de Pessoas", "Cadastro/alteração das Datas", "Cadastro/alteração de Notas Técnicas", "Cadastro/alteração de Demandas", "Cadastro/alteração de Gráficos", "", ""};
            String[] cadastrosLink = {"#", "/pages/lembrete/lembrete.xhtml", "/pages/ligacoes/ligacoes.xhtml", "/pages/pessoa/pessoa.xhtml", "/pages/data/data.xhtml", "/pages/notaTecnica/notaTecnica.xhtml", "/pages/demanda/demanda.xhtml", "/pages/grafico/grafico.xhtml", "#", "#"};
            String[] cadastrosTipo = {"G", "G", "G", "F", "F", "G", "G", "G", "A", "F"};
            Collection<Menu> dados = new ArrayList<Menu>();
            for (int i = 0; i < nome.length; i++) {
                this.model = new Menu();
                this.model.setMenuNome(nome[i]);
                this.model.setMenuOrdem(i);
                this.model.setMenuSts(true);
                this.model.setMenuDescr(cadastrosDesc[i]);
                this.model.setMenuTipo(cadastrosTipo[i]);
                this.model.setMenuLink(cadastrosLink[i]);
                this.model.setMenuMenuId(0);
                dados.add(this.model);
            }
            return dados;
        } catch (Exception e) {
            throw new AgendaException(e, this.getUsuario());
        }
    }

    private Map<String, Collection<Menu>> menusFilho(String[] pai, Integer[] idPai) throws Exception {
        Map<String, Collection<Menu>> dados = new HashMap<String, Collection<Menu>>();
        try {
            for (int i = 0; i < pai.length; i++) {
                if ("Agenda".equalsIgnoreCase(pai[i])) {
                    String[] cadastrosNome = {"Cadastro/Alteração", "Agenda Mensal", "Agenda Dinâmica"};
                    String[] cadastrosDesc = {"Cadastro/alteração da Agenda", "Visualização Agenda Mensal", "Visualização Agenda Mensal"};
                    String[] cadastrosLink = {"/pages/agenda/agenda.xhtml", "/pages/agendaMensal/agendaMensal.xhtml", "/pages/agendaDinamica/agendaDinamica.xhtml"};
                    //G de gerente e F de funcionario e A de administrador
                    String[] cadastrosTipo = {"G", "F", "F"};
                    Collection<Menu> dadosCadastros = new ArrayList<Menu>();
                    for (int j = 0; j < cadastrosNome.length; j++) {
                        this.model = new Menu();
                        this.model.setMenuNome(cadastrosNome[j]);
                        this.model.setMenuOrdem(j);
                        this.model.setMenuSts(true);
                        this.model.setMenuTipo(cadastrosTipo[j]);
                        this.model.setMenuDescr(cadastrosDesc[j]);
                        this.model.setMenuLink(cadastrosLink[j]);
                        this.model.setMenuMenuId(idPai[i]);
                        dadosCadastros.add(this.model);
                    }
                    dados.put("Agenda", dadosCadastros);
                } else if ("Configurações".equalsIgnoreCase(pai[i])) {
                    String[] configuracoesNome = {"Menus", "Parametros", "Acessos", "Usuários"};
                    String[] configuracoesDesc = {"Cadastro/alteração de Menus do Sistema", "Cadastro/alteração de Parametros", "Cadastro/alteração de Acessos dos Usuários", "Cadastro/alteração de Usuários"};
                    String[] configuracoesLink = {"/pages/menu/menu.xhtml", "/pages/parametro/parametro.xhtml", "/pages/acesso/acesso.xhtml", "/pages/usuario/usuario.xhtml"};
                    //G de gerente e F de funcionario e A de administrador
                    String[] configuracoesTipo = {"A", "A", "A", "A"};
                    Collection<Menu> dadosConfiguracoes = new ArrayList<Menu>();
                    for (int j = 0; j < configuracoesNome.length; j++) {
                        this.model = new Menu();
                        this.model.setMenuNome(configuracoesNome[j]);
                        this.model.setMenuOrdem(j);
                        this.model.setMenuSts(true);
                        this.model.setMenuTipo(configuracoesTipo[j]);
                        this.model.setMenuDescr(configuracoesDesc[j]);
                        this.model.setMenuLink(configuracoesLink[j]);
                        this.model.setMenuMenuId(idPai[i]);
                        dadosConfiguracoes.add(this.model);
                    }
                    dados.put("Configurações", dadosConfiguracoes);
                } else if ("Ajuda".equalsIgnoreCase(pai[i])) {
                    String[] ajudaNome = {"Alterar senha", "Help", "Sobre", "Email contato Central IT"};
                    String[] ajudaDesc = {"Alterar a senha de usuário", "Ajuda sobre o sistema", "Sobre o sistema", "Entrar em contato com a equipe da Central IT"};
                    String[] ajudaLink = {"/pages/altsenha/altsenha.xhtml", "/pages/help/help.xhtml", "/pages/sobre/sobre.xhtml", "/pages/emailContato/emailcontato.xhtml"};
                    //G de gerente e F de funcionario e A de administrador
                    String[] ajudaTipo = {"F", "F", "F", "F"};
                    Collection<Menu> dadosAjuda = new ArrayList<Menu>();
                    for (int j = 0; j < ajudaNome.length; j++) {
                        this.model = new Menu();
                        this.model.setMenuNome(ajudaNome[j]);
                        this.model.setMenuOrdem(j);
                        this.model.setMenuSts(true);
                        this.model.setMenuTipo(ajudaTipo[j]);
                        this.model.setMenuDescr(ajudaDesc[j]);
                        this.model.setMenuLink(ajudaLink[j]);
                        this.model.setMenuMenuId(idPai[i]);
                        dadosAjuda.add(this.model);
                    }
                    dados.put("Ajuda", dadosAjuda);
                }
            }
            return dados;
        } catch (Exception e) {
            throw new AgendaException(e, this.getUsuario());
        }
    }

    public Usuario getUsr() {
        return usr;
    }

    public void setUsr(Usuario usr) {
        this.usr = usr;
    }
}
