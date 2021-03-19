package javaweb.part1.control;

import java.io.IOException;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaweb.part1.dao.TrackDao;
import javaweb.part1.model.Track;

@WebServlet("/track")
public class TrackServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
		
		protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			TrackDao trackDao = new TrackDao();

		    
			String StringId = request.getParameter("id");
			long id = Long.parseLong(StringId);
			
			Track track = null;
			try {
				
				track = trackDao.findTrack(id);
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			request.setAttribute("tracks", track);

			String jsp = "/WEB-INF/views/tracksfromalbum.jsp";
			RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(jsp);
			dispatcher.include(request, response);
			}
		}
