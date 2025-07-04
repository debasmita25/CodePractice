package com.datareader.programs;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.lang3.StringUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CompareDBResults {

	@Test
	public static void main(String[] args) {
		Connection conn = getConnection();

		try {
			Statement st1 = conn.createStatement();
			Statement st2 = conn.createStatement();
			String sql1 = "select inventory_id,inventory_in_stock(inventory_id) from inventory;";
			String sql2 = "select outerQ.inventory_id,case when outerQ.inventory_id in ( select inventory.inventory_id\r\n"
					+ "FROM inventory JOIN rental USING(inventory_id)\r\n"
					+ "WHERE  outerQ.inventory_id=rental.inventory_id and rental.return_date IS NULL) then '0' else '1' end \r\n"
					+ "as inventory_in_stock from inventory outerQ;";
			ResultSet rst1 = st1.executeQuery(sql1);
			ResultSet rst2 = st2.executeQuery(sql2);
			if(compareResultSets(rst1, rst2).equals(true))  {
				System.out.println("Assert successful");
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		closeConnection(conn);
	}

	public static Boolean compareResultSets(ResultSet rs1, ResultSet rs2) {
		try {
			if (rs1.getMetaData().getColumnCount() != rs2.getMetaData().getColumnCount())
				return false;
			else {
				while (rs1.next()) {
					rs2.next();
					int count = rs1.getMetaData().getColumnCount();
					for (int i = 1; i <= count; i++) {
						if (!StringUtils.equals(rs1.getString(i), rs2.getString(i))) {
							return false;
						}
					}
				}

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}

	public static Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Connection conn = null;
		try {
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "password");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;

	}

	public static void closeConnection(Connection conn) {
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}

}
