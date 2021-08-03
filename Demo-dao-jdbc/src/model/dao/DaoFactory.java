package model.dao;

/* Classe auxiliar responsável por instanciar os DAOs */

import model.dao.impl.SellerDaoJDBC;

public class DaoFactory {

    public static SellerDao createSellerDao() {
        return new SellerDaoJDBC();
    } //
}
