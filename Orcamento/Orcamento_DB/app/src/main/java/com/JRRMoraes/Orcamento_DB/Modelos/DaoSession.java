package com.JoaoMoraes.Modelos;

import android.database.sqlite.SQLiteDatabase;

import java.util.Map;

import de.greenrobot.dao.AbstractDao;
import de.greenrobot.dao.AbstractDaoSession;
import de.greenrobot.dao.identityscope.IdentityScopeType;
import de.greenrobot.dao.internal.DaoConfig;

import com.JoaoMoraes.Modelos.Orcamento;
import com.JoaoMoraes.Modelos.Cliente;

import com.JoaoMoraes.Modelos.OrcamentoDao;
import com.JoaoMoraes.Modelos.ClienteDao;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.

/**
 * {@inheritDoc}
 * 
 * @see de.greenrobot.dao.AbstractDaoSession
 */
public class DaoSession extends AbstractDaoSession {

    private final DaoConfig orcamentoDaoConfig;
    private final DaoConfig clienteDaoConfig;

    private final OrcamentoDao orcamentoDao;
    private final ClienteDao clienteDao;

    public DaoSession(SQLiteDatabase db, IdentityScopeType type, Map<Class<? extends AbstractDao<?, ?>>, DaoConfig>
            daoConfigMap) {
        super(db);

        orcamentoDaoConfig = daoConfigMap.get(OrcamentoDao.class).clone();
        orcamentoDaoConfig.initIdentityScope(type);

        clienteDaoConfig = daoConfigMap.get(ClienteDao.class).clone();
        clienteDaoConfig.initIdentityScope(type);

        orcamentoDao = new OrcamentoDao(orcamentoDaoConfig, this);
        clienteDao = new ClienteDao(clienteDaoConfig, this);

        registerDao(Orcamento.class, orcamentoDao);
        registerDao(Cliente.class, clienteDao);
    }
    
    public void clear() {
        orcamentoDaoConfig.getIdentityScope().clear();
        clienteDaoConfig.getIdentityScope().clear();
    }

    public OrcamentoDao getOrcamentoDao() {
        return orcamentoDao;
    }

    public ClienteDao getClienteDao() {
        return clienteDao;
    }

}
