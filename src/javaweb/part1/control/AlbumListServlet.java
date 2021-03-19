package javaweb.part1.control;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaweb.part1.dao.AlbumDao;
import javaweb.part1.model.Album;

@WebServlet("/albumlist")
public class AlbumListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		AlbumDao albumDao = new AlbumDao();	
		
		List<Album> albumList = albumDao.findAllAlbums();
		
		request.setAttribute("albumList", albumList);
		
		String jsp = "/WEB-INF/views/album.jsp";
		RequestDispatcher dispather = getServletContext().getRequestDispatcher(jsp);
		dispather.forward(request, response);
	}
}