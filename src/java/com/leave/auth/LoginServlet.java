/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leave.auth;

/**
 *
 * @author suweg
 */

import java.io.IOException;
import java.sql.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String email = request.getParameter("email");
        String password = request.getParameter("password");

        try {
            // 1. Connect to DB
            Connection conn = DriverManager.getConnection(
                "jdbc:derby://localhost:1527/LeaveDB",
                "app",
                "app"
            );

            // 2. SQL check
            String sql = "SELECT employee_id, name, role FROM employee WHERE email=? AND password=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                // 3. Login success → create session
                int employeeId = rs.getInt("employee_id");
                String name = rs.getString("name");
                String role = rs.getString("role");

                HttpSession session = request.getSession();
                session.setAttribute("employeeId", employeeId);
                session.setAttribute("name", name);
                session.setAttribute("role", role);

                conn.close();

                // 4. Redirect by role
                switch (role) {
                    case "STAFF":
                        response.sendRedirect("<%= request.getContextPath()%>/StaffDashboardServlet");
                        break;

                    case "ADMIN":
                        response.sendRedirect("AdminDashboardServlet");
                        break;

                    case "HOD":
                        response.sendRedirect("HodDashboardServlet");
                        break;

                    case "CEO":
                        response.sendRedirect("CeoDashboardServlet");
                        break;

                    default:
                        response.sendRedirect("login.jsp?error=role");
                }

            } else {
                // Login failed
                conn.close();
                response.sendRedirect("login.jsp?error=invalid");
            }

        } catch (SQLException e) {
            e.printStackTrace();
            response.sendRedirect("login.jsp?error=db");
        }
    }
}

