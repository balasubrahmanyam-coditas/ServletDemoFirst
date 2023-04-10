import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/LoginForm")

public class LoginForm extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Connection con=null;
        Statement stmt=null;
        ResultSet rs=null;
        String n="",p="";
        int cnt=0;
        n=req.getParameter("txtuname");
        p=req.getParameter("txtupass");
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con= DriverManager.getConnection("jdbc:mysql://localhost/userdb","root","root");
            stmt=con.createStatement();
            rs=stmt.executeQuery("select * from user");
            ResultSet resultSet = stmt.executeQuery(n);
            out.println("<table><caption>userdb</caption><th>ID</th><th>Name</th><th>Marks</th>");
            while(rs.next()){
                out.println("<td>"+resultSet.getString(1)+"</td>"+"<td>"+resultSet.getString(2)+
                        "</td>"+"<td>"+resultSet.getString(3)+"</td>");
//                String un=rs.getString(1);
//                String up=rs.getString(2);
//                if(n.equals(un) && p.equals(up)){
//                    out.println("<h1>Welcome!!!"+un+"</h1>");
//                    cnt++;
//                    break;
//                }
            }
            if(cnt==0){
                out.println("<h1>Sorry!!!Try Again!!</h1>");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {

            throw new RuntimeException(e);
        }
    }
//        resp.setContentType("LoginForm");
//        PrintWriter out = resp.getWriter();
//        out.println("Heloo from servlet");
//
//        ServletConfig servletConfig = getServletConfig();
//        String LoginForm = servletConfig.getInitParameter("LoginForm");
//        out.println("<h1><center>"+LoginForm+"ov v  2 w");
}