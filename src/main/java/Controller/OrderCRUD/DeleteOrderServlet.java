package Controller.OrderCRUD;

import Model.Order;
import Model.User;
import services.OrderService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteOrderServlet",urlPatterns = "/deleteOrder")
public class DeleteOrderServlet extends HttpServlet {
    OrderService orderService = new OrderService();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        deleteOrder(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        showDeleteForm(request,response);
    }
    public void showDeleteForm(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        Order order = orderService.findOrder(id);
        request.setAttribute("order",order);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("/jsp/removeOrder.jsp");
        try {
            requestDispatcher.forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void deleteOrder(HttpServletRequest request,HttpServletResponse response){
        System.out.println(request.getParameter("id"));
        int id = Integer.parseInt(request.getParameter("id"));
        orderService.deleteOrder(id);
        try {
            request.getRequestDispatcher("/order").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
