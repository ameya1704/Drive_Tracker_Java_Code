package Main_Code;

import java.io.BufferedReader;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/CreateDrive")

public class CreateDrive extends HttpServlet
{
	private static final long serialVersionUID = 1L;
    
    public CreateDrive()
    {
        super();
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		//doGet(request, response);
		System.out.println("in post");
		
		//BufferedReader br=request.getReader();
		String s =request.getReader().readLine();
		System.out.println("Angular data = "+s);
		
		CderivePojo p=(CderivePojo) ObjectMep.getObject(s,CderivePojo.class);
		
		@SuppressWarnings("unused")
		Map<String,String> map = null;
		try
		{
			map=DaoLayer.saveData(p);
		}
		catch(ClassNotFoundException | SQLException e)
		{
			e.printStackTrace();
		}
		
		/*String responsedata = (String) ObjectMep.getJSONFromObject(map);
		
		response.getWriter().write(responsedata);
		
		response.flushBuffer();*/
	}
}