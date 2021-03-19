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

import javaweb.part1.dao.TrackDao;
import javaweb.part1.model.Track;

@WebServlet("/tracklist")
public class TrackListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			TrackDao trackDao = new TrackDao();		
			List<Track> trackList = null;
			try {
				trackList = trackDao.getAllTracks();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			request.setAttribute("trackList", trackList);
			
			String jsp = "/WEB-INF/views/track.jsp";
			RequestDispatcher dispather = getServletContext().getRequestDispatcher(jsp);
			dispather.forward(request, response);
	}
}
