package Controller.OrderCRUD;

import Model.Order;
import Model.User;
import services.OrderService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateOrderServlet",urlPatterns = "/createOrder")
public class CreateOrderServlet extends HttpServlet {
    OrderService orderService = new OrderService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        createOrder(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        showCreateForm(request,response);
    }
    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/jsp/createOrder.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void createOrder(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        int orderNumber = Integer.parseInt(request.getParameter("orderNumber"));
        Order order = new Order(id,customerId,orderNumber);
        orderService.addOrder(order);
        try {
            request.getRequestDispatcher("/order").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
