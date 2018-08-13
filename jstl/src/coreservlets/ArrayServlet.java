package coreservlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ArrayServlet extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    String[] words = { "foo", "bar", "baz"};
    request.setAttribute("words", words);
    String address = "/WEB-INF/results/array-loop.jsp";
    RequestDispatcher dispatcher = 
      request.getRequestDispatcher(address);
    dispatcher.forward(request, response);
  }
}
