package Controller;

import ConnectToDB.ConnectMySQLDb;
import Model.User;
import services.UserServices;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;

@WebServlet(name = "LoginServlet",urlPatterns = "/Login")
public class LoginServlet extends HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String user = request.getParameter("user");
        String password = request.getParameter("password");
        HttpSession httpSession = request.getSession();


        Connection connection = ConnectMySQLDb.getConnection();
        User user1 = UserServices.userLogin(user,password,connection);

        if(user1 == null){
            response.sendRedirect("/Login");
        }else if(user1.getRole() == 0){
            httpSession.setAttribute("user",user1);
            request.getRequestDispatcher("/jsp/home.jsp").forward(request,response);
        }else if(user1.getRole() == 1){
            httpSession.setAttribute("admin",user1);
            request.getRequestDispatcher("/admin").forward(request,response);
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        request.getRequestDispatcher("login/login.jsp").forward(request,response);
    }
}
