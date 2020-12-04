package Controller.UserCRUD;

import Model.User;
import services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterNewUserServlet",urlPatterns = "/registerNewUser")
public class RegisterNewUserServlet extends HttpServlet {
    UserServices userServices = new UserServices();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        registerUser(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        showCreateForm(request,response);
    }
    private void showCreateForm(HttpServletRequest request, HttpServletResponse response) {
        try {
            request.getRequestDispatcher("/jsp/registerNewUser.jsp").forward(request,response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void registerUser(HttpServletRequest request, HttpServletResponse response){
//        int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String shipAddress = request.getParameter("shipAddress");
        int role = Integer.parseInt(request.getParameter("role"));
        User user = new User(firstName,lastName,address,email,shipAddress,role);
        userServices.addUser(user);
        try {
            request.getRequestDispatcher("/home").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
