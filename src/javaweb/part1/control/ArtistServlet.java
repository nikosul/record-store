package javaweb.part1.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaweb.part1.dao.AlbumDao;
import javaweb.part1.dao.ArtistDao;
import javaweb.part1.model.Album;
import javaweb.part1.model.Artist;

@WebServlet("/artist")
public class ArtistServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private ArtistDao artistDao = new ArtistDao(); 
	private AlbumDao albumDao = new AlbumDao();
	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		
		long id = Long.parseLong(request.getParameter("id"));
		
		Artist artist = null;
		try {
			artist = artistDao.findArtist(id);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Album> albums = null;
		try {
			albums = albumDao.findAlbumByArtist(artist);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("artist", artist);
		request.setAttribute("albums", albums);
		
		request.getRequestDispatcher("/WEB-INF/views/albumsbyartist.jsp").include(request, response);
	}
}