package com.mind.server;

import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.server.Server;


public class JettyServer {

    public static void main(String[] args) throws Exception {

        System.out.println("yes, you are right.");

        Server server = new Server(8030);

        ServletContextHandler context = new ServletContextHandler(ServletContextHandler.SESSIONS);
        context.setContextPath("/");
        server.setHandler(context);

        // http://localhost:8030/hello
        context.addServlet(new ServletHolder(new FirstServlet()), "/hello");
        // http://localhost:8030/hello/web
        context.addServlet(new ServletHolder(new FirstServlet("this is my web")), "/hello/web");

        try {
            server.start();
            server.join();
        } finally {
            server.destroy();
        }
    }
}