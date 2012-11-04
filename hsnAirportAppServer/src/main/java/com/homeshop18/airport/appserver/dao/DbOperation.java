/**
 * 
 */
package com.homeshop18.airport.appserver.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.homeshop18.airport.appserver.configuration.ConfigurationObject;

/**
 * @author Vinay.Mehta
 * 
 */
public class DbOperation {

	private static DataSource _ds = null;
	private static DbOperation _singleton;
	//private static final String DATA_SOURCE = "java:comp/env/jdbc/dboperator";

	public static synchronized DbOperation getInstance() {
		if (null == _singleton) {
			_singleton = new DbOperation();
		}
		return _singleton;
	}

	private DbOperation() {
		Context initCtx;
		try {

			initCtx = (Context) new InitialContext();
			_ds = (DataSource) initCtx.lookup(ConfigurationObject.dataSource);

		} catch (Exception e) {
			System.out.println("Exception" + e);
		}
	}

	public Connection getConnection() throws SQLException {
		Connection conn = null;
		try {

			conn = _ds.getConnection();

		} catch (Exception ex1) {
			System.out.println("Exception" + ex1);
		}
		return conn;
	}

	public static void cleanDBResource(Connection conn, Statement st,
			ResultSet rset) {
		if (rset != null) {
			try {
				rset.close();
			} catch (SQLException e) {
				// ignore
			}
		}
		if (st != null) {
			try {
				st.close();
			} catch (SQLException e) {
				// ignore
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				// ignore
			}
		}
	}
}
