import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("userid");
        String pass = req.getParameter("pass");

        PrintWriter out = resp.getWriter();

        if(id.equals("userid") && pass.equals("pass")){

            resp.sendRedirect("successful.html");

            out.println("Welcome:"+id);
            out.println("<a href='MessageServlet'>Next</a>");
        }else{
            resp.sendRedirect("unsuccessful.html");
        }
    }
}
