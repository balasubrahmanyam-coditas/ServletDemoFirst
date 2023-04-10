import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class CalServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        int x,y;
        String str="";
        x=Integer.parseInt(req.getParameter("textfno"));
        y=Integer.parseInt(req.getParameter("textsno"));
        str = req.getParameter("operation");
        if(str.equals("add")){
            out.println("<h1>Result of addition is:"+(x+y)+"</h1>");
        } else if (str.equals("sub")) {
            out.println("<h1>Result of subtraction is:"+(x-y)+"</h1>");
        }else if (str.equals("mul")) {
            out.println("<h1>Result of multiplication is:"+(x*y)+"</h1>");
        }else if (str.equals("div")) {
            out.println("<h1>Result of division is:"+(x/y)+"</h1>");
        }else{
            out.println("<h1>Result of modulus is:"+(x%y)+"</h1>");
        }

    }
}
