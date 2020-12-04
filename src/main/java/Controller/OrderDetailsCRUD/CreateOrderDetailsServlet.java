package Controller.OrderDetailsCRUD;

import Model.Order;
import Model.OrderDetails;
import services.OrderDetailsServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateOrderDetailsServlet",urlPatterns = "/createOrderDetails")
public class CreateOrderDetailsServlet extends HttpServlet {
    OrderDetailsServices orderDetailsServices = new OrderDetailsServices();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        createOrderDetails(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        showCreateForm(request,response);
    }
    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/jsp/createOrderDetails.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void createOrderDetails(HttpServletRequest request, HttpServletResponse response){
        int Id = Integer.parseInt(request.getParameter("id"));
        int OrderId = Integer.parseInt(request.getParameter("orderId"));
        int ProductId = Integer.parseInt(request.getParameter("productId"));
        int orderNumber = Integer.parseInt(request.getParameter("orderNumber"));
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String shipAddress = request.getParameter("shipAddress");
        OrderDetails orderDetails1 = new OrderDetails(Id,OrderId,ProductId,orderNumber,price,quantity,shipAddress);
        orderDetailsServices.addOrderDetails(orderDetails1);
        try {
            request.getRequestDispatcher("/orderDetails").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
