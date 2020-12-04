package Controller;

import DAO.ProductDAO;
import Model.Product;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductServlet", urlPatterns = "/products")
public class ProductServlet extends HttpServlet {


    ArrayList<Product> productCart = new ArrayList<>();

    private static final long serialVersionUID = 1L;
    private ProductDAO productDAO;

    public void init() {
        productDAO = new ProductDAO();
    }

//    private final IProductService productService  = new ProductService();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch(action){
            case "create":
                try {
                    createProduct(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "edit":
                try {
                    editProduct(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "remove":
                try {
                    removeProduct(request, response);
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
                break;
            case "removeCartProduct":
                removeCartProduct(request, response);
                break;
            case "processPayment":
                processPayment(request, response);
                break;
            default:
                listProducts(request, response);
                break;

        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if(action == null){
            action = "";
        }
        switch(action){
            case "addToCart":
                addToCart(request, response);
                break;
            case "create":
                showCreateForm(request, response);
                break;
            case "edit":
                showEditForm(request, response);
                break;
            case "remove":
                showRemoveForm(request, response);
                break;
            case "showCart":
                showCart(request, response);
                break;
            case "removeCartProduct":
                removeCartProduct(request, response);
                break;
            case "showPayment":
                showPaymentForm(request, response);
                break;

            default:
                listProducts(request, response);
                break;

        }
    }

    private void processPayment(HttpServletRequest request, HttpServletResponse response){
        try {
            response.sendRedirect("/createOrder");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showPaymentForm(HttpServletRequest request, HttpServletResponse response){
        HttpSession cartSession = request.getSession();
//        ArrayList<Product> productCart = (ArrayList<Product>) cartSession.getAttribute("productCart");
        cartSession.getAttribute("productCart");
        RequestDispatcher dispatcher;
        request.setAttribute("productCart", productCart);
        dispatcher = request.getRequestDispatcher("product/payment.jsp");
        try{
            dispatcher.forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void removeCartProduct(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        productCart.remove(checkCartProductIndex(id));
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/cart.jsp");

        request.setAttribute("productCart", productCart);
        try{
            dispatcher.forward(request,response);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
    private int checkCartProductIndex(int id){
        Product temp = null;
        for (Product product: productCart) {
            if(product.getId() == id){
                temp = product;
            }
        }
        return productCart.indexOf(temp);
    }

    private void addToCart(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productDAO.selectProduct(id);
        productCart.add(product);
        HttpSession cartSession = request.getSession();
        cartSession.setAttribute("productCart", productCart);
        response.sendRedirect("/products");
    }

    private void removeProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        int id = Integer.parseInt(request.getParameter("id"));
        productDAO.deleteProduct(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/remove.jsp");
        request.setAttribute("message", "delete successfully");
        try{
            dispatcher.forward(request, response);
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    private void showCart(HttpServletRequest request, HttpServletResponse response){
        HttpSession cartSession = request.getSession();
        ArrayList<Product> productCart = (ArrayList<Product>) cartSession.getAttribute("productCart");
        RequestDispatcher dispatcher;
        request.setAttribute("productCart", productCart);
        dispatcher = request.getRequestDispatcher("product/cart.jsp");
        try{
            dispatcher.forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void showRemoveForm(HttpServletRequest request, HttpServletResponse response){
        int productId = Integer.parseInt(request.getParameter("productId"));
        Product product = productDAO.selectProduct(productId);

        RequestDispatcher dispatcher;
        request.setAttribute("product", product);
        dispatcher = request.getRequestDispatcher("product/remove.jsp");
        try{
            dispatcher.forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
        }
    }





    private void editProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String productName = request.getParameter("productName");
        String productDescription = request.getParameter("productDescription");
        int category = Integer.parseInt(request.getParameter("category"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String image = request.getParameter("image");
        int price = Integer.parseInt(request.getParameter("price"));

        Product product = new Product(productName, productDescription, category, quantity, image, price);
        productDAO.updateProduct(product);

        RequestDispatcher dispatcher = request.getRequestDispatcher("product/edit.jsp");
        request.setAttribute("message", "edited successfully");
        try{
            dispatcher.forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
        }

//        if(product == null){
//            dispatcher = request.getRequestDispatcher("error-404.jsp");
//        } else {
//            product.setId(id);
//            product.setProductName(productName);
//            product.setProductDescription(productDescription);
//            product.setCategory(category);
//            product.setQuantity(quantity);
//            product.setImage(image);
//
//            productDAO.updateProduct(product);
//            request.setAttribute("message", "created successfully");
//            request.setAttribute("product", product);
//            dispatcher = request.getRequestDispatcher("product/edit.jsp");
//        }
//        try{
//            dispatcher.forward(request, response);
//        }catch(Exception e){
//            e.printStackTrace();
//        }

    }

    private void createProduct(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        String productName = request.getParameter("productName");
        String productDescription = request.getParameter("productDescription");
        int category = Integer.parseInt(request.getParameter("category"));
        int quantity = Integer.parseInt(request.getParameter("quantity"));
        String image = request.getParameter("image");
        int price = Integer.parseInt(request.getParameter("price"));

        Product newProduct = new Product(productName, productDescription, category, quantity, image, price);
        productDAO.insertProduct(newProduct);

        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        request.setAttribute("message", "created successfully");
        try{
            dispatcher.forward(request, response);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private void showCreateForm(HttpServletRequest request, HttpServletResponse response){
        RequestDispatcher dispatcher = request.getRequestDispatcher("product/create.jsp");
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listProducts(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Product> products = productDAO.selectAllProducts();
        request.setAttribute("products", products);

        RequestDispatcher dispatcher = request.getRequestDispatcher("product/list.jsp");
        dispatcher.forward(request, response);
    }

    private void showEditForm(HttpServletRequest request, HttpServletResponse response){
        int id = Integer.parseInt(request.getParameter("id"));
        Product product = productDAO.selectProduct(id);
        RequestDispatcher dispatcher;
        if(product == null){
            dispatcher = request.getRequestDispatcher("error-404.jsp");
        } else {
            request.setAttribute("product", product);
            dispatcher =request.getRequestDispatcher("product/edit.jsp");
        }
        try {
            dispatcher.forward(request, response);
        } catch (ServletException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }




}
