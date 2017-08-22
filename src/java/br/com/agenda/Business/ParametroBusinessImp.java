/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.agenda.Business;

import br.com.agenda.Crud.CrudBusinessImp;
import br.com.agenda.Crud.CrudDao;
import br.com.agenda.Dao.ParametroDao;
import br.com.agenda.Model.Parametro;

/**
 *
 * @author Destroyer
 */
public class ParametroBusinessImp extends CrudBusinessImp<Parametro> implements ParametroBusiness{

    @Override
    public CrudDao<Parametro> getDao() throws Exception {
        return new ParametroDao();
    }
    
}
