package javaweb.part1.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaweb.part1.dao.ArtistDao;
import javaweb.part1.model.Artist;

@WebServlet("/artistlist")
public class ArtistListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArtistDao artistDao = new ArtistDao();
		
		List<Artist> artistList = artistDao.findAllArtists();

		request.setAttribute("artistList", artistList);
		
		String jsp = "/WEB-INF/views/artist.jsp";
		RequestDispatcher dispather = getServletContext().getRequestDispatcher(jsp);
		dispather.forward(request, response);

	}
}