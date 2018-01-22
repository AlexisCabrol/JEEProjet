/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

import beans.Bitcoin;
import java.sql.*;
import static models.DAOUtilitaire.*;

/**
 *
 * @author Alexis
 */
public class BitcoinDAOImpl implements BitcoinDAO {
    private DAO dao;
    
    BitcoinDAOImpl(DAO dao) {
        this.dao = dao;
    }

    @Override
    public Bitcoin getWalletsBTC(String email) throws DAOException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Bitcoin btc = new Bitcoin();
        String query = "select adresse_wallet, nombre, unit from btc b join users u on b.adresse_wallet = u.wallets_btc where email = ?";
        
        try {
            conn = dao.getConnection();
            ps = iniRequest(conn,query,false,email);
            rs = ps.executeQuery();
            if(rs.next()) {
                btc = map(rs);
            }
        } catch(SQLException e) {
            throw new DAOException(e);
        } finally {
            fermeturesSilencieuses(rs,ps,conn);
        }
        return btc;
        
    }
    
    
    private static Bitcoin map(ResultSet rs) throws SQLException {
        Bitcoin btc = new Bitcoin();
        btc.setWallets(rs.getString("adresse_wallet"));
        btc.setNombre(rs.getFloat("nombre"));
        btc.setUnit(rs.getFloat("unit"));
        return btc;
    }

}
