package example;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/servlet", name = "Servlet")
public class Servlet extends HttpServlet {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        try {
            Object o = new InitialContext().lookup("corbaname::localhost:2809/NameService#applications/query/querybean/Query!com.ibm.websphere.ejbquery.QueryHome");
            out.println(o);
        } catch (NamingException e) {
            out.println("Caught naming exception " + e);
            out.println("Explanation: " + e.getExplanation());
            out.println("Resolved name: " + e.getResolvedName());
            out.println("Remaining name: " + e.getRemainingName());
            e.printStackTrace(out);
        }
  }
}
