package Controller.UserCRUD;

import Model.User;
import services.UserServices;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EditUserServlet",urlPatterns = "/editUser")
public class EditUserServlet extends HttpServlet {
    UserServices userServices = new UserServices();
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        editUser(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        showEditForm(request,response);


    }
    private void showEditForm(HttpServletRequest request, HttpServletResponse response) {
        int id = Integer.parseInt(request.getParameter("id"));
        User user = userServices.findUser(id);
        System.out.println(user.getLastName());
        request.setAttribute("user",user);
        try {
            request.getRequestDispatcher("/jsp/editUser.jsp").forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private void editUser(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String address = request.getParameter("address");
        String email = request.getParameter("email");
        String shipAddress = request.getParameter("shipAddress");
        int role = Integer.parseInt(request.getParameter("role"));
        User user = new User(id,firstName,lastName,address,email,shipAddress,role);
        System.out.println(user.toString());
        userServices.updateUser(user);
        try {
            request.getRequestDispatcher("/users").forward(request,response);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
