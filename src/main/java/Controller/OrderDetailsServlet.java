package Controller;

import Model.Order;
import Model.OrderDetails;
import services.OrderDetailsServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "OrderDetailsServlet",urlPatterns = "/orderDetails")
public class OrderDetailsServlet extends HttpServlet {
    OrderDetailsServices orderDetailsServices = new OrderDetailsServices();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<OrderDetails> orderDetails =  new ArrayList<OrderDetails>(orderDetailsServices.getOrderDetailsList());
        request.setAttribute("orderDetails",orderDetails);
        request.getRequestDispatcher("/jsp/listOrderDetails.jsp").forward(request,response);
    }
}
