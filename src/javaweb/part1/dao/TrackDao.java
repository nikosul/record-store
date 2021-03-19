package javaweb.part1.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javaweb.part1.model.Album;
import javaweb.part1.model.Track;

public class TrackDao extends ChinookDatabase{

    public List<Track> getAllTracks() throws ClassNotFoundException, SQLException {
    	
    	Connection connection = null;
    	PreparedStatement ps = null;
    	ResultSet rs = null;
        List<Track> trackList = new ArrayList<Track>();
        try {
        connection = connect();
        String sql = ("SELECT * FROM Track ORDER BY Name ASC");
        ps = connection.prepareStatement(sql);
        rs = ps.executeQuery();

        while (rs.next()) {
		
        long id = rs.getLong("TrackId");
		String name = rs.getString("Name");
               
		Track a = new Track(id, name);
		trackList.add(a);
        }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } 
        finally {
            close(ps, rs, connection);
        }
        return trackList;
    }
    
    public List<Track> findTracksByAlbum(Album album) throws SQLException, ClassNotFoundException {
    	
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
    	List<Track> trackByAlbum = new ArrayList<>();
    	Track track = null;
        try {
        connection = connect();
    	String sql = ("SELECT * FROM Track WHERE AlbumId = ?");
    	
    	ps = connection.prepareStatement(sql);    	
    	
    	ps.setLong(1, album.getId());
        rs = ps.executeQuery();

        while (rs.next()) {
       		track = getTrack(rs);    
       		trackByAlbum.add(track);
    	}  
    	}
    	finally {
    		close(ps, rs, connection);
    	}
	    return trackByAlbum;
    }   
    public Track findTrack(long id) throws ClassNotFoundException, SQLException {
        
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Track track = null;
        try {
        connection = connect();
        String sql = ("SELECT * FROM Track WHERE TrackId = ?");
        ps = connection.prepareStatement(sql);
            
        ps.setLong(1, id);
        rs = ps.executeQuery();

            while (rs.next()) {
           		track = getTrack(rs);           		
           	}
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            close(ps, rs, connection);
        }
        return track;
    }
	public Track getTrack(ResultSet result) throws SQLException, ClassNotFoundException {
		try {
			Track track = new Track();
			track.setId(result.getLong("TrackId"));
			track.setName(result.getString("Name"));
			return track;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}