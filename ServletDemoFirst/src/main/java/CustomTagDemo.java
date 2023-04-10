import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import java.io.IOException;

public class CustomTagDemo {
    @Override
    public void doTag() throws JspException, IOException{
        super.doTag();
        JspWriter out = getJspContext().getOut();
        out.println("<b><h3 style='color:yellow;background-color:blue'>HEllo Java World....we are learning JSP custom tag</h3></br>");
    }
}
