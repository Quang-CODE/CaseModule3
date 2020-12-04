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

@WebServlet(name = "EditOrderDetailsServlet",urlPatterns = "/editOrderDetails")
public class EditOrderDetailsServlet extends HttpServlet {
    OrderDetailsServices orderDetailsServices = new OrderDetailsServices();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        editOrderDetails(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        showEditForm(request,response);
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        OrderDetails orderDetails = orderDetailsServices.findOrderDetails(id);
        request.setAttribute("orderDetails",orderDetails);
        try {
            request.getRequestDispatcher("/jsp/editOrderDetails.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void editOrderDetails(HttpServletRequest request, HttpServletResponse response){
        int Id = Integer.parseInt(request.getParameter("id"));
        int OrderId = Integer.parseInt(request.getParameter("orderId"));
        int ProductId = Integer.parseInt(request.getParameter("productId"));
        int orderNumber = Integer.parseInt(request.getParameter("orderNumber"));
        int price = Integer.parseInt(request.getParameter("price"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String shipAddress = request.getParameter("shipAddress");
        OrderDetails orderDetails1 = new OrderDetails(Id,OrderId,ProductId,orderNumber,price,quantity,shipAddress);
        orderDetailsServices.updateOrderDetails(orderDetails1);
        try {
            request.getRequestDispatcher("/orderDetails").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
