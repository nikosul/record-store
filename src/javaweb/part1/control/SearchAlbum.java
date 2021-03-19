package javaweb.part1.control;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaweb.part1.dao.AlbumDao;
import javaweb.part1.model.Album;


@WebServlet("/searchalbum")
public class SearchAlbum extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/views/searchalbum.jsp");
		dispatcher.include(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AlbumDao albumDao = new AlbumDao();
		
		String albumName = request.getParameter("Title");
		String albumNamee = new String (albumName);
		
		Album album = null;
		try {
			album = albumDao.findaAlbumByName(albumNamee);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		request.setAttribute("album", album);
		
		response.sendRedirect("/RecordStore/album?id=" + album.getId());
		
		
		
	}
}