import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;




@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello-world")
public class HelloWorldServlet extends HttpServlet {

    private int hitCount;

    public void init() {
        // Reset hit counter.
        hitCount = 0;
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        String name = request.getParameter("Name");
        out.println("<div align = \"center\" bgcolor = \"black\" color = \"grey\"><FORM METHOD=\"POST\" ACTION='/hello-world'>");
        out.println("<HTML>");
        out.println("<HEAD><TITLE>Hello, " + name + "</TITLE></HEAD>");
        out.println("<BODY>");
        out.println("</BODY></HTML>");
        out.println("<form method=\"GET\" action=\"/hello-world\">\n" +
                "<label for=\"Name\">Name:</label>\n" +
                "<input id=\"Name\" name=\"Name\" placeholder=\"Enter your Name\" />\n" +
                "<INPUT TYPE=SUBMIT>"+
                "</form></div>");

        if (request.getParameter("Name")==null){
            out.println("<h1 align = \"center\">\"Hello, World!</h1>");
        }
        else{
            out.println("<H1 align = \"center\">\"Hello, " + name + "\"<H1>");
        }



        hitCount++;
        String title = "Total Number of Hits";
        String docType = "<!doctype html public \"-//w3c//dtd html 4.0 " + "transitional//en\">\n";
        out.println(docType +
                "<html>\n" +
                "<head><title>" + title + "</title></head>\n" +
                "<body bgcolor = \"blue\">\n" +
                "<h1 align = \"center\">" + title + "</h1>\n" +
                "<h2 align = \"center\">" + hitCount + "</h2>\n" +
                "</body>" +
                "</html>");
    }
    public void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        doGet(req, res);

    }
}

