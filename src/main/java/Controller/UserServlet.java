package Controller;

import Model.User;
import services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@WebServlet(name = "UserServlet",urlPatterns = "/users")
public class  UserServlet extends HttpServlet {
    UserServices userServices = new UserServices();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users =  new ArrayList<User>(userServices.getUserList());
        request.setAttribute("users",users);
        request.getRequestDispatcher("/jsp/listUser.jsp").forward(request,response);
    }

}
