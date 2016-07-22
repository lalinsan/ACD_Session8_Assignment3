/*
* Student: Eduardo Aguirre
* Session 8
* Assignment 3
* Servlet that validates user credentials and returns the session information. 
*/


package com.acadgild.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.GregorianCalendar;

/**
 * Servlet implementation class SessionTracking
 */
@WebServlet("/SessionTracking")
@SuppressWarnings("unused")
public class SessionTracking extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int visitCount=0; //Set variable count and initializes to 0

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		String userName = request.getParameter("userName"); //Assign User Name to userName variable
		String password = request.getParameter("password"); //Assign Password to Password variable
		
		
		if(userName.equalsIgnoreCase("Eduardo") && password.equalsIgnoreCase("Ed123")) //Validates user credentials
		{
			HttpSession session = request.getSession(true); //Set session
			session.setAttribute("userName", userName); //Set User Name Attribute
			session.setAttribute("id", session.getId()); //Set Session ID Name Attribute
			String userID = new String ("ED001");  //Assign User ID to user ID Variable
			session.setAttribute("userID", userID); //Set User ID Attribute 
			session.setAttribute("visitCountKey",  visitCount++); //Increments the visit Count by 1 every time it is visti
			
		    long createTime = session.getCreationTime(); //Set Session Creation Time 
			long lastAccessTime = session.getLastAccessedTime(); //Set Session Last Access Time
			
		    session.setAttribute("lastAccessTime", lastAccessTime); //Set Session Last Access Time Attribute
			
		    
			Date d = new Date(); // Creates an instance of the Date Object
			SimpleDateFormat f = new SimpleDateFormat("MMM/dd/yyyy H:mm:a"); //Store format example: JUL/09/2016
			d.setTime(createTime); //Apply format to createTime 

			System.out.println(f.format(d));
			session.setAttribute("createTime", f.format(d)); //Set create time attribute with new format 
			
			d.setTime(lastAccessTime);
			session.setAttribute("lastAccessTime", f.format(d));//Set last access attribute with new format 
			response.sendRedirect("welcome.jsp");  //redirects to welcome page
		}
		else  // when credentials are wrong
		{
			request.setAttribute("error", "Invalid credentials: Access Denied"); //Displays error
			RequestDispatcher reqdis = request.getRequestDispatcher("index.jsp"); //redirects to Index
			reqdis.forward(request, response);
		}
		
	}

}


