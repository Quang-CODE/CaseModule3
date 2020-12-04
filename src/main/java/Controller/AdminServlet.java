package Controller;

import Model.Order;
import Model.OrderDetails;
import Model.User;
import services.OrderDetailsServices;
import services.OrderService;
import services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "AdminServlet",urlPatterns = "/admin")
public class AdminServlet extends HttpServlet {
    UserServices userServices = new UserServices();
    OrderService orderService = new OrderService();
    OrderDetailsServices orderDetailsServices = new OrderDetailsServices();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> userList = userServices.getUserList();
        List<Order> orderList = orderService.getOrderList();
        List<OrderDetails> orderDetailsList = orderDetailsServices.getOrderDetailsList();
        request.setAttribute("users",userList);
        request.setAttribute("orders",orderList);
        request.setAttribute("orderDetails",orderDetailsList);
        request.getRequestDispatcher("/jsp/admin.jsp").forward(request,response);
    }
}
