package javaweb.part1.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javaweb.part1.model.Album;
import javaweb.part1.model.Artist;

public class AlbumDao extends ChinookDatabase{

    public Album findAlbum(long id) throws ClassNotFoundException, SQLException {
        
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Album album = null;
        try {
        connection = connect();
        String sql = ("SELECT * FROM Album WHERE AlbumId = ?");
        ps = connection.prepareStatement(sql);
            
        ps.setLong(1, id);
        rs = ps.executeQuery();

            while (rs.next()) {
           		album = getAlbum(rs);           		
           	}
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            close(ps, rs, connection);
        }
        return album;
    }
    public List<Album> findAllAlbums() {
    	
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
    	List<Album>  allAlbums = new ArrayList<>();
    	try {
    	connection = connect();
    	String sql = ("SELECT * FROM Album ORDER BY Title ASC");
    	ps = connection.prepareStatement(sql);
    	rs = ps.executeQuery();
    		
    	while (rs.next()) {
    		long id = rs.getLong("AlbumId");
    		String title = rs.getString("Title");
    			
    		Album s = new Album(id, title);
    		allAlbums.add(s);
    		}	
    	}
    	catch (Exception e) {
    		throw new RuntimeException(e);
    	}
    	finally {
    		close(ps, rs, connection);
    	}
    	return allAlbums;
    	}
    
    public List<Album> findAlbumByArtist(Artist artist) throws SQLException, ClassNotFoundException {
    	
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
    	List<Album> albumByArtist = new ArrayList<>();
    	Album album = null;
        try {
        connection = connect();
    	String sql = ("SELECT * FROM Album WHERE ArtistId = ?");
    	
    	ps = connection.prepareStatement(sql);    	
    	
    	ps.setLong(1, artist.getId());
        rs = ps.executeQuery();

        while (rs.next()) {
       		album = getAlbum(rs);    
       		albumByArtist.add(album);
       	}
        } catch (SQLException e) {
        throw new RuntimeException(e);
        }
        finally {
        close(ps, rs, connection);
        }
        return albumByArtist;
    	}
 public Album findaAlbumByName(String Title) throws SQLException, ClassNotFoundException {
    	
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
    	Album album = null;
    	try {
    		connection = connect();
    		String sql = ("SELECT * FROM Album WHERE Title = ?");

    		ps = connection.prepareStatement(sql);    	

    		ps.setString(1,  Title);
    		rs = ps.executeQuery();
    	
    	if (rs.next()) {
			album = getAlbum(rs);
    	}
    	} 
    	catch (SQLException e) {
    		throw new RuntimeException(e);
    	}
    	finally {
    		
    	close(ps, rs, connection);
    	}
    	return album;
 }
    public List<Album> findAlbumByTitle(String title) throws SQLException, ClassNotFoundException {
        
    	Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
    	List<Album> albumByTitle = new ArrayList<>();
    	try {
        connection = connect();
    	String sql = ("SELECT * FROM Album WHERE AlbumId = (SELECT AlbumId FROM WHERE Title = ?");
    	ps = connection.prepareStatement(sql);    	

    	ps.setString(1,  title);
    	rs = ps.executeQuery();
    	
    	while (rs.next()) {
    		long id = rs.getLong("AlbumId");
    		title = rs.getString("Title");
    		
            Album a = new Album(id, title);
            albumByTitle.add(a);
    	}  
    	}
    	finally {
    		close(ps, rs, connection);
    	}
	    return albumByTitle;
    }   
	public Album getAlbum(ResultSet result) throws ClassNotFoundException {
		try {
			Album album = new Album();
			album.setId(result.getLong("AlbumId"));
			album.setName(result.getString("Title"));
			return album;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}