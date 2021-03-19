package javaweb.part1.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaweb.part1.dao.ArtistDao;
import javaweb.part1.model.Artist;

@WebServlet("/searchartist")
public class SearchArtist extends HttpServlet {
	private static final long serialVersionUID = 1L;

 

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/searchartist.jsp");
		dispatcher.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArtistDao artistDao = new ArtistDao();
		
		String artistName = request.getParameter("artistName");
		String artistNamee = new String (artistName);
		
		Artist artist = null;
		try {
			artist = artistDao.findArtistsByName(artistNamee);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("artist", artist);
		
		response.sendRedirect("/RecordStore/artist?id=" + artist.getId());
		
		
		
	}
}