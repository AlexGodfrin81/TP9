/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.sql.DataSource;

/**
 *
 * @author pedago
 */
public class DAO {
    protected final DataSource myDataSource;

	/**
	 *
	 * @param dataSource la source de données à utiliser
	 */
	public DAO(DataSource dataSource) {
		this.myDataSource = dataSource;
	}
        
        public int add(String s, float f) throws Exception {

		String sql = "INSERT INTO DISCOUNT_CODE VALUES (?,?)";
                
		try (   Connection connection = myDataSource.getConnection(); // Ouvrir une connexion
			PreparedStatement stmt = connection.prepareStatement(sql); // On crée un statement pour exécuter une requête
			
                    ) {
                    
                    stmt.setString(1,s);
                    stmt.setFloat(2,f);
                    
                    return stmt.executeUpdate();
                    
		} catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new Exception(ex.getMessage());
		}
	}
        
        public int delete(String s) throws Exception {

		String sql = "DELETE FROM DISCOUNT_CODE WHERE DISCOUNT_CODE = ?";
                
		try (   Connection connection = myDataSource.getConnection(); // Ouvrir une connexion
			PreparedStatement stmt = connection.prepareStatement(sql); // On crée un statement pour exécuter une requête
			
                    ) {
                    
                    stmt.setString(1,s);
                    
                    
                    return stmt.executeUpdate();
                    
		} catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			return 0;
		}
	}
        
        public List<DiscountCodeENtity> GetListCode() throws Exception {
                List<DiscountCodeENtity> list = new ArrayList<>();
                
		String sql = "SELECT * FROM DISCOUNT_CODE";
                
		try (   Connection connection = myDataSource.getConnection(); // Ouvrir une connexion
			Statement stmt = connection.createStatement(); // On crée un statement pour exécuter une requête
			ResultSet rs = stmt.executeQuery(sql);
                    ) {
                    
                    while ( rs.next() ){
                        list.add(new DiscountCodeENtity(rs.getString("DISCOUNT_CODE"),rs.getFloat("RATE")));
                    }
                    
                    return list;
                    
		} catch (SQLException ex) {
			Logger.getLogger("DAO").log(Level.SEVERE, null, ex);
			throw new Exception(ex.getMessage());
		}
	}
        
}
