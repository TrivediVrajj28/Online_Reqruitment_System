package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.pojo.jobs;
import com.pojo.jobseeker;

public class jobseekerdao {

	public static Connection myconnection() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("Driver class not registerd");
		}
		Connection cn = null;
		try {
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaweb", "root", "");
		} catch (SQLException e) {
			System.out.println("Connection not found");
		}

		return cn;
	}

	// insert

	public static int datainsert(jobseeker j) {
		int status = 0;
		Connection cn = myconnection();

		String INSERT = "INSERT INTO jobseeker(name,email,password)VALUE(?,?,?)";

		try {
			PreparedStatement ps = cn.prepareStatement(INSERT);
			ps.setString(1, j.getName());
			ps.setString(2, j.getEmail());
			ps.setString(3, j.getPassword());

			status = ps.executeUpdate();
			if (status > 0) {
				System.out.println("data inserted");
			}

		} catch (SQLException e) {
			System.out.println("not insert");
		}

		return status;
	}

	// fetch all

	public static List<jobseeker> getalljobseeker() {

		List<jobseeker> al = new ArrayList<jobseeker>();

		Connection cn = myconnection();

		String SELECT = "SELECT * FROM jobseeker";

		try {
			PreparedStatement ps = cn.prepareStatement(SELECT);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				jobseeker j = new jobseeker();
				j.setId(rs.getInt("id"));
				j.setName(rs.getString("name"));
				j.setEmail(rs.getString("email"));
				j.setPassword(rs.getString("password"));
				al.add(j);
			}

		} catch (SQLException e) {
			System.out.println("data not fetched");
		}
		return al;
	}

//login

	public static jobseeker checkLogin(String email, String password) {
		jobseeker j = null;
		Connection cn = myconnection();

		String login = "SELECT * FROM jobseeker WHERE email = ? AND password = ?";

		try {
			PreparedStatement ps = cn.prepareStatement(login);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				j = new jobseeker();
				j.setId(rs.getInt("id"));
				j.setName(rs.getString("name"));
				j.setEmail(rs.getString("email"));
				j.setPassword(rs.getString("password"));

			}
		} catch (SQLException e) {
			System.out.println("Login error: " + e.getMessage());
		}
		return j;
	}

	// fetch by id

	public static jobseeker getJobseekerById(int id) {
		jobseeker js = null;

		Connection cn = myconnection();

		String SELECT = "SELECT * FROM jobseeker WHERE id=?";

		try {
			PreparedStatement ps = cn.prepareStatement(SELECT);

			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				js = new jobseeker();
				js.setId(rs.getInt("id"));
				js.setName(rs.getString("name"));
				js.setEmail(rs.getString("email"));
				js.setPassword(rs.getString("password"));
			}

		} catch (SQLException e) {
			System.out.println("not fetch record by id !");
		}

		return js;

	}

	// update

	public static int jobseekerupdate(jobseeker js) {
		int status = 0;
		Connection cn = myconnection();

		String UPDATE = "UPDATE jobseeker SET name = ? ,email = ?, password = ? WHERE id = ?";

		try {
			PreparedStatement ps = cn.prepareStatement(UPDATE);
			ps.setString(1, js.getName());
			ps.setString(2, js.getEmail());
			ps.setString(3, js.getPassword());
			ps.setInt(4, js.getId());

			status = ps.executeUpdate();
			if (status > 0) {
				System.out.println("record sucessfully updated !");
			}

		} catch (SQLException e) {
			System.out.println("jobseeker record not updated !");
		}
		return status;

	}
	// Delete

	public static int DeleteJobseeker(int id) {
		int status = 0;

		Connection cn = myconnection();

		String DELETE = "DELETE FROM jobseeker WHERE id = ?";

		try {
			PreparedStatement ps = cn.prepareStatement(DELETE);

			ps.setInt(1, id);

			status = ps.executeUpdate();

			if (status > 0) {
				System.out.println("record sucessfully delete !");
			}
		} catch (SQLException e) {
			System.out.println("record not deleted");
		}

		return status;
	}

	// fetch all

	public static List<jobs> searchJobs(String keyword) {

		List<jobs> al = new ArrayList<jobs>();

		Connection cn = myconnection();

		String SELECT = "SELECT * FROM jobs WHERE title LIKE ? OR company LIKE ?";

		try {
			PreparedStatement ps = cn.prepareStatement(SELECT);

			ps.setString(1, "%" + keyword + "%");// match before-after char(%)
			ps.setString(2, "%" + keyword + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				jobs j = new jobs();
				j.setId(rs.getInt("id"));
				j.setTitle(rs.getString("title"));
				j.setCompany(rs.getString("company"));
				j.setLocation(rs.getString("location"));
				al.add(j);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return al;
	}

}
