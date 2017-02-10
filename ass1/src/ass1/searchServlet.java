package ass1;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.*;

import jdk.internal.org.xml.sax.helpers.DefaultHandler;



/**
 * Servlet implementation class searchServlet
 */
@WebServlet("/searchServlet")
public class searchServlet extends HttpServlet {
	final Logger logger = Logger.getLogger(this.getClass().getName());
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public searchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		//ServletContext servletContext = getServletContext();
		//java.io.InputStream openStream = servletContext.getResourceAsStream("WebContent/sample.xml");
		
		ServletContext context = getServletContext();
		InputSource xmlFile = new InputSource(context.getResourceAsStream("/WEB-INF/input.xml"));
		
		
		
		//String finalURL = this.getServletContext().getRealPath("/WebContent/sample.xml");
		
		
		try {	
	         /*SAXParserFactory factory = SAXParserFactory.newInstance();
	         javax.xml.parsers.SAXParser saxParser = factory.newSAXParser();
	         UserHandler userhandler = new UserHandler();
	         saxParser.parse(xmlFile, userhandler);    */

	         SAXParserFactory spf = SAXParserFactory.newInstance();
	         spf.setNamespaceAware(true);
	         javax.xml.parsers.SAXParser saxParser = spf.newSAXParser();
	         
	         XMLReader xmlReader = saxParser.getXMLReader();
	         //xmlReader.setContentHandler(new ContentHandler());
	         xmlReader.parse(xmlFile);
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }

		//parser.setContentHandler(null);
		//BufferedReader reader = new BufferedReader(new InputStreamReader(request.getSession().getServletContext().getResourceAsStream("/json/sampleJson.json")));
		//File sample = new File(searchServlet.class.getClassLoader().getResource("ass1/WebContent/sample.xml").getPath());
		//DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
		
		try {
			//DocumentBuilder db = dbf.newDocumentBuilder();
			//org.w3c.dom.Document input = db.parse(finalURL);
			//String test = input.getElementsByTagName("Year").item(0).getTextContent();
			
			logger.info(getServletName()+" invoked");
			response.setContentType("text/html"); 
			PrintWriter out = response.getWriter();
			out.println("<HTML>"); 
			out.println("<HEAD>");
			out.println("<TITLE>Search Results</TITLE>");
			out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
			out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
			out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css\" integrity=\"sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp\" crossorigin=\"anonymous\">");
			out.println("</HEAD>"); 
			out.println("<BODY>");
			
			
			out.println("</BODY>");
			out.println("</HTML>");
			out.close();
			

			
		} catch (Exception e) {
			e.printStackTrace();
		}

		/*
		
		String publication = request.getParameter("Publication");
	    String author = request.getParameter("Author");
	    String venue = request.getParameter("Venue");
	    
	    ServletContext context = getServletContext();
		InputSource sampleFile = new InputSource(context.getResourceAsStream("/WEB-INF/sample.xml"));
	    
	    logger.info(getServletName()+" invoked");
		response.setContentType("text/html"); 
	    PrintWriter out = response.getWriter();
		out.println("<HTML>"); 
		out.println("<HEAD>");
		out.println("<TITLE>Search Results</TITLE>");
		out.println("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">");
		out.println("<link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css\" integrity=\"sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp\" crossorigin=\"anonymous\">");
		out.println("</HEAD>"); 
		out.println("<BODY>");
		out.println(publication);
		out.println(author);
		out.println(venue);
		out.println(sampleFile);
		out.println("</BODY>");
		out.println("</HTML>");
		out.close();

		 * 
		 */
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	protected void performAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		//SAXParser parser = new SAXParser();
		/*parser.setContentHandler(AskScanner); // Might have to mke AServlet.AskScanner
		parser.setErrorHandler(AskScanner);
		String url = {filepath_to_xml}
		parser.parse(url);*/

	}
	

}

class UserHandler extends DefaultHandler {

	   boolean bFirstName = false;
	   boolean bLastName = false;
	   boolean bNickName = false;
	   boolean bMarks = false;

	   public void startElement(String uri, 
	      String localName, String qName, Attributes attributes)
	         throws SAXException {
	      if (qName.equalsIgnoreCase("student")) {
	         String rollNo = attributes.getValue("rollno");
	         System.out.println("Roll No : " + rollNo);
	      } else if (qName.equalsIgnoreCase("firstname")) {
	         bFirstName = true;
	      } else if (qName.equalsIgnoreCase("lastname")) {
	         bLastName = true;
	      } else if (qName.equalsIgnoreCase("nickname")) {
	         bNickName = true;
	      }
	      else if (qName.equalsIgnoreCase("marks")) {
	         bMarks = true;
	      }
	   }

	   public void endElement(String uri, 
	      String localName, String qName) {
	      if (qName.equalsIgnoreCase("student")) {
	         System.out.println("End Element :" + qName);
	      }
	   }

	   public void characters(char ch[], 
	      int start, int length) {
	      if (bFirstName) {
	         System.out.println("First Name: " 
	         + new String(ch, start, length));
	         bFirstName = false;
	      } else if (bLastName) {
	         System.out.println("Last Name: " 
	         + new String(ch, start, length));
	         bLastName = false;
	      } else if (bNickName) {
	         System.out.println("Nick Name: " 
	         + new String(ch, start, length));
	         bNickName = false;
	      } else if (bMarks) {
	         System.out.println("Marks: " 
	         + new String(ch, start, length));
	         bMarks = false;
	      }
	   }
}
