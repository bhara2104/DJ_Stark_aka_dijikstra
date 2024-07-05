package com.application.dijikstra;

import java.io.*;

import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

@WebServlet(name = "dijikstraservlet", value = "/djservlet/*")
public class DijikstraServlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        String pathInfo = request.getPathInfo();
        System.out.println(pathInfo);
        PrintWriter out = response.getWriter();
        if(pathInfo.equals("/getPath")){
            int source = Integer.parseInt(request.getParameter("source_point"));
            int destination = Integer.parseInt(request.getParameter("end_point"));
            String path = RunDijikstraService.shortestPathFromVertices(source,destination);
            out.println(path);
        }else{
            int source = Integer.parseInt(request.getParameter("source_location"));
            int shortestLocation = RunDijikstraService.run(source);
            out.println("The Shortest Location is From: "+  shortestLocation);
        }
    }
}