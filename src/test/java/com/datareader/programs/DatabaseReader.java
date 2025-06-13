package com.datareader.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DatabaseReader {

	public static void main(String[] args) {

		Object[][] data = retrieveData();
		System.out.println(Arrays.toString(data[0]));
		System.out.println(Arrays.toString(data[1]));
		System.out.println(Arrays.toString(data[2]));
		

	}

	public static Object[][] retrieveData() {
		Object[][] data = null;
		Connection conn = null;
		try {
			conn = getDBConnection();
			if (conn == null) {
				System.out.println("Connection Not Establised");
			} else
				System.out.println("Connection Establised");

			String dataQuery = "SELECT * FROM workflow_vapt.issues";
			String countQuery = "SELECT count(*) FROM workflow_vapt.issues";

			// to execute SQL Statement
			Statement st = conn.createStatement();

			// To get total number of Rows/Records
			ResultSet rowCount = st.executeQuery(countQuery);
			int rows = 0;
			while (rowCount.next()) // to bring the point into first data
				rows = rowCount.getInt(1); //INDEX STARTS WITH 1
			System.out.println("rows of the table: " + rows);
			// create an data object of size = number of rows in DB and 1 col
			data = new Object[rows][1];
			int dataIndex = 0;

			// To get Result from DB for data Query
			ResultSet rst = st.executeQuery(dataQuery);
            //rst.getMetaData().getColumnCount(); 
			//rst.getMetaData().getColumnLabel(0);
			// get total number of Columns
			ResultSetMetaData rsmd = rst.getMetaData();
			int col = rsmd.getColumnCount();
			System.out.println("Total number of col: " + col);
			List<String> dbColNames = new ArrayList<String>();
			for (int i = 1; i <= col; i++) {
				String colLabel = rsmd.getColumnLabel(i);
				// String colType =rsmd.getColumnTypeName(i);
				dbColNames.add(colLabel);
			}

			// System.out.println(dbColNames);
			// create Map object to store records in key-value pair
			Map<String, String> mapOfRecord = null;
			while (rst.next()) {
				mapOfRecord = new HashMap<String, String>();
				for (int j = 0; j < col; j++) {
					String colName = dbColNames.get(j);
					// System.out.println(colName+"--> "+rst.getObject(colName).toString());
					String colVal = rst.getObject(colName) == null ? "" : (rst.getObject(colName).toString());
					mapOfRecord.put(colName, colVal);
				}
				/*
				 * System.out.println("----------Printing Table Record-------------");
				 * 
				 * for (String key : mapOfRecord.keySet()) { System.out.print(key + " "); }
				 * System.out.println(); for (String key : mapOfRecord.keySet()) {
				 * System.out.print(mapOfRecord.get(key) + " "); } System.out.println();
				 */

				data[dataIndex][0] = mapOfRecord;
				dataIndex++;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			closeConnection(getDBConnection());
			return data;
		}

	}

	public static void closeConnection(Connection conn) {
		try {
			if (conn != null) {
				conn.close();
				System.out.println("Connection is closed");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static Connection getDBConnection() {
		Connection conn = null;
		try {
			// initialize JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/workflow_vapt", "root", "password");
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		} finally {
			return conn;
		}
	}

}
