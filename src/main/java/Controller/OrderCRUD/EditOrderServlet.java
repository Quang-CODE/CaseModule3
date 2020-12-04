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

@WebServlet(name = "EditOrderServlet",urlPatterns = "/editOrder")
public class EditOrderServlet extends HttpServlet {
    OrderService orderService = new OrderService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        editOrder(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        showEditForm(request,response);
    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        Order order = orderService.findOrder(id);
        request.setAttribute("order",order);
        try {
            request.getRequestDispatcher("/jsp/editOrder.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void editOrder(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        int orderNumber = Integer.parseInt(request.getParameter("orderNumber"));
        Order order = new Order(id,customerId,orderNumber);
        orderService.updateOrder(order);
        try {
            request.getRequestDispatcher("/order").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
