package coreservlets;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class ArrayServlet2 extends HttpServlet {
  public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
      throws ServletException, IOException {
    Name[] names = 
      { new Name("Bill", "Gates"), new Name("Larry", "Ellison"),
        new Name("Sam", "Palmisano"), new Name("Scott", "McNealy"),
        new Name("Eric", "Schmidt"), new Name("Jeff", "Bezos") };
    request.setAttribute("names", names);
    String[][] sales = 
      { {"2005", "12,459", "15,622"},
        {"2006", "18,123", "17,789"},
        {"2007", "21,444", "23,555"} };
    request.setAttribute("sales", sales);
    String address = "/WEB-INF/results/array-loop2.jsp";
    RequestDispatcher dispatcher = 
      request.getRequestDispatcher(address);
    dispatcher.forward(request, response);
  }
}
