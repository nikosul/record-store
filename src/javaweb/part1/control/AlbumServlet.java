package javaweb.part1.control;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javaweb.part1.dao.AlbumDao;
import javaweb.part1.dao.TrackDao;
import javaweb.part1.model.Track;

@WebServlet("/album")
public class AlbumServlet<Album> extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	AlbumDao albumDao = new AlbumDao();
	TrackDao trackDao = new TrackDao();
	
	String stringId = request.getParameter("id");
	long id = Long.parseLong(stringId);
	
	List<Track> track = null;

	try {
	javaweb.part1.model.Album album = albumDao.findAlbum(id);
	track = trackDao.findTracksByAlbum(album);
	} catch (ClassNotFoundException | NumberFormatException | SQLException e){
		e.printStackTrace();
	}

	request.setAttribute("tracks", track);
	String jsp = "/WEB-INF/views/tracksfromalbum.jsp";
	RequestDispatcher dispatcher = request.getServletContext().getRequestDispatcher(jsp);
	dispatcher.include(request, response);
		}
	}
