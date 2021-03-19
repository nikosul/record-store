package javaweb.part1.control;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaweb.part1.dao.ArtistDao;
import javaweb.part1.model.Artist;

@WebServlet("/artist/new")
public class CreateArtistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ArtistDao artistDao = new ArtistDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/new_artist.jsp");
		dispatcher.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		String artistName = request.getParameter("artistName");
		if (artistName == null || "".equals(artistName)) {
			request.setAttribute("error", "No name given");
		doGet(request, response);
		}
		else {
			Artist artist = new Artist(1, artistName);
			try {
				artistDao.SaveArtist(artist);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			response.sendRedirect("/RecordStore/artist?id=" + artist.getId());
		}
}
}