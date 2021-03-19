package javaweb.part1.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javaweb.part1.model.Artist;

public class ArtistDao extends ChinookDatabase{

    public Artist findArtist(long id) throws ClassNotFoundException, SQLException {
    	
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Artist artist = null;
        try {
            connection = connect();
            String sql = ("SELECT * FROM Artist WHERE ArtistId = ?");
        	ps = connection.prepareStatement(sql);
        	
        	ps.setLong(1, id);
            rs = ps.executeQuery();
            
           	while (rs.next()) {
           		artist = getArtist(rs);           		
           	}
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        finally {
            close(ps, rs, connection);
        }
        return artist;
    }
    public List<Artist> findAllArtists() {
    	
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
    	List<Artist>allArtists = new ArrayList<>();
    	try {
    		connection = connect();
    		String sql = ("SELECT * FROM Artist ORDER BY Name ASC");
    		ps = connection.prepareStatement(sql);
    		rs = ps.executeQuery();
    		
    		while (rs.next()) {
    			long id = rs.getLong("ArtistId");
    			String name = rs.getString("Name");
    			
    			Artist a = new Artist(id, name);
    			allArtists.add(a);
    		}	
    	}
    	catch (Exception e) {
    		throw new RuntimeException(e);
    	}
    	finally {
    		close(ps, rs, connection);
    	}
    	return allArtists;
    }
    
    public Artist findArtistsByName(String artistName) throws SQLException, ClassNotFoundException {
    	
        Connection connection = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
    	Artist artist = null;
    	try {
    		connection = connect();
    		String sql = ("SELECT * FROM Artist WHERE Name = ?");

    		ps = connection.prepareStatement(sql);    	

    		ps.setString(1,  artistName);
    		rs = ps.executeQuery();
    	
    	if (rs.next()) {
			artist = getArtist(rs);
    	}
    	} 
    	catch (SQLException e) {
    		throw new RuntimeException(e);
    	}
    	finally {
    		
    	close(ps, rs, connection);
    	}
    	return artist;
    }
    
	public void SaveArtist(Artist artist) throws ClassNotFoundException {
		
        Connection connection = null;
        PreparedStatement ps = null;
		ResultSet generatedKeys = null;
		try {
			connection = connect();
			ps = connection.prepareStatement(
					"INSERT INTO Artist (Name) VALUES(?)", Statement.RETURN_GENERATED_KEYS);
			
			ps.setString(1,  artist.getName());
			ps.executeUpdate();
			
			generatedKeys = ps.getGeneratedKeys();
			if (generatedKeys.next()) {
				long id = generatedKeys.getLong(1);
				artist.setId(id);
			}
		}
		catch (SQLException e) {
			throw new RuntimeException(e);
		}
		finally {
			close(ps, generatedKeys, connection);
		}
	}   
	public void delete (String artistName) throws SQLException{
		
        Connection connection = null;
        PreparedStatement ps = null;
        
        try {
        	connection = connect();
        	String deleteSql = ("DELETE FROM Artist WHERE Name = ?");
        	ps = connection.prepareStatement(deleteSql);
        	ps.setString(1, artistName);
        	ps.executeUpdate();
        }
        catch (SQLException e) {
			throw new RuntimeException(e); 
        }
		finally {
		close(ps, connection);
		}
}
	public Artist getArtist(ResultSet result) throws ClassNotFoundException {
		try {
			Artist artist = new Artist();
			artist.setId(result.getLong("ArtistId"));
			artist.setName(result.getString("Name"));
			return artist;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
