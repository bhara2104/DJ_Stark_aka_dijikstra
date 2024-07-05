package com.application.dijikstra;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class DijikstraServlet extends HttpServlet {
    private String message;

    public void init() {
        message = "Hello World!";
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        int source = Integer.parseInt(request.getParameter("source_location"));
        int shortestLocation = RunDijikstraService.run(source);
        out.println("The Shortest Location is From: "+  shortestLocation);
    }

    public void destroy() {
    }
}