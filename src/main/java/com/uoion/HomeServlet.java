package com.uoion;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.*;
import javax.servlet.http.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.URI;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@WebServlet("/")
public class HomeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        request.setAttribute("hostname", getHostname());
        request.setAttribute("privateIp", getPrivateIP());
        request.setAttribute("instanceId", getMetadata("instance-id"));
        request.setAttribute("availabilityZone", getMetadata("placement/availability-zone"));
        request.setAttribute("amiId", getMetadata("ami-id"));
        request.setAttribute("instanceType", getMetadata("instance-type"));

        request.setAttribute("version", "v1.0.0");

        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

        request.setAttribute("time",
                LocalDateTime.now().format(formatter));

        request.getRequestDispatcher("/index.jsp")
                .forward(request, response);
    }

    private String getHostname() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (Exception e) {
            return "Unknown";
        }
    }

    private String getPrivateIP() {
        try {
            return InetAddress.getLocalHost().getHostAddress();
        } catch (Exception e) {
            return "Unknown";
        }
    }

    private String getMetadata(String path) {

        try {

            String token = getToken();

            URL url = URI.create(
                    "http://169.254.169.254/latest/meta-data/" + path)
                    .toURL();

            var connection = (java.net.HttpURLConnection) url.openConnection();

            connection.setRequestProperty(
                    "X-aws-ec2-metadata-token", token);

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(connection.getInputStream()));

            return reader.readLine();

        } catch (Exception e) {
            return "Unavailable";
        }
    }

    private String getToken() {

        try {

            URL url = URI.create(
                    "http://169.254.169.254/latest/api/token")
                    .toURL();

            var connection = (java.net.HttpURLConnection) url.openConnection();

            connection.setRequestMethod("PUT");

            connection.setRequestProperty(
                    "X-aws-ec2-metadata-token-ttl-seconds", "21600");

            BufferedReader reader =
                    new BufferedReader(
                            new InputStreamReader(connection.getInputStream()));

            return reader.readLine();

        } catch (Exception e) {
            return "";
        }
    }
}
