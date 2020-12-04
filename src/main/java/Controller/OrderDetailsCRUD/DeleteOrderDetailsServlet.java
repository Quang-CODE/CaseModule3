package Controller.OrderDetailsCRUD;

import Model.Order;
import Model.OrderDetails;
import services.OrderDetailsServices;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteOrderDetailsServlet",urlPatterns = "/deleteOrderDetails")
public class DeleteOrderDetailsServlet extends HttpServlet {
    OrderDetailsServices orderDetailsServices = new OrderDetailsServices();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        deleteOrderDetails(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        showDeleteForm(request,response);
    }
    public void showDeleteForm(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        OrderDetails orderDetails1 = orderDetailsServices.findOrderDetails(id);
        request.setAttribute("orderDetails",orderDetails1);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/removeOrderDetails.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void deleteOrderDetails(HttpServletRequest request,HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        orderDetailsServices.deleteOrderDetails(id);
        try {
            request.getRequestDispatcher("/orderDetails").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
