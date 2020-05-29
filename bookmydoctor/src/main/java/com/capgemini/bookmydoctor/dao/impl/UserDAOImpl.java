package com.capgemini.bookmydoctor.dao.impl;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import com.capgemini.bookmydoctor.dao.UserDAO;
//import com.capgemini.bookmydoctor.controller.UserController;
import com.capgemini.bookmydoctor.dto.UserInfoDto;

public class UserDAOImpl implements UserDAO{

	@Override
	public void insertUser(UserInfoDto userInfo) {
		Connection conn = null;
		PreparedStatement pstmt = null;


		try {
			System.out.println("try started");

			System.out.println("In jdbc");
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			FileInputStream input = new FileInputStream("Database.properties");
			Properties pro = new Properties();
			pro.load(input);
			String dburl = "jdbc:mysql://localhost:3306/bookmydoctor_db";
			conn = DriverManager.getConnection(dburl, pro);
			String query = "insert into user_info values(?, ?, ?, ?, ?, ?)";

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, userInfo.getUserId());
			pstmt.setString(2, userInfo.getUserType());
			pstmt.setString(3, userInfo.getPassword());
			pstmt.setLong(4, userInfo.getPrimaryPhoneNo());
			pstmt.setString(5, userInfo.getEmailId());
			pstmt.setString(6, userInfo.getGender());
			pstmt.executeUpdate();


		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void updateUser(String password, int userId) {
		Connection conn = null;
		PreparedStatement pstmt = null;


		try {
			System.out.println("try started");

			System.out.println("In jdbc");
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			FileInputStream input = new FileInputStream("Database.properties");
			Properties pro = new Properties();
			pro.load(input);
			String dburl = "jdbc:mysql://localhost:3306/bookmydoctor_db";
			conn = DriverManager.getConnection(dburl, pro);


			String query = "update user_info set password = ? where userId = ?";

			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, password);
			pstmt.setInt(2, userId);

			pstmt.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public UserInfoDto getUser(int id) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserInfoDto userInfo = null;


		try {
			System.out.println("try started");

			System.out.println("In jdbc");
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			FileInputStream input = new FileInputStream("Database.properties");
			Properties pro = new Properties();
			pro.load(input);
			String dburl = "jdbc:mysql://localhost:3306/bookmydoctor_db";
			conn = DriverManager.getConnection(dburl, pro);


			String query = "select * from user_info where userId = ?";

			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				 userInfo = new UserInfoDto();

				userInfo.setUserId(rs.getInt("userId"));
				userInfo.setPassword(rs.getString("password"));
			}

		} catch (Exception e) {

			e.printStackTrace();
		} finally {
			try {
				if (conn != null) {
					conn.close();
				}
				if (pstmt != null) {
					pstmt.close();
				}
				if (rs != null) {
					rs.close();
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return userInfo;
	}
	}