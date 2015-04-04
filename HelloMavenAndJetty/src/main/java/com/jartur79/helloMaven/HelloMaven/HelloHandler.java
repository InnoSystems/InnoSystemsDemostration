package com.jartur79.helloMaven.HelloMaven;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.AbstractHandler;

public class HelloHandler extends AbstractHandler {

	public void handle(String target, Request baseRequest,
			HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {

		response.setContentType("text/html;charset=utf-8");
		response.setStatus(HttpServletResponse.SC_OK);
		baseRequest.setHandled(true);
		response.getWriter().println("<h1>Hello World</h1>");
		Date date = new Date();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(
				"dd.MM.YYYY HH:mm:ss");
		response.getWriter().println(
				"<h3>" + simpleDateFormat.format(date) + "</h3");
	}

	/**
	 * To Run it: Open a browser and go to http://localhost:8080/
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {

		Server server = new Server(8080);
		server.setHandler(new HelloHandler());

		server.start();
		server.join();
	}

}
