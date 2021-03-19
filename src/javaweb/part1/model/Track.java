package javaweb.part1.model;
public class Track {

    private long id;
    private String name;
    
    public Track() {
    	super();
    	this.id = 0;
    	this.name = null;
    }
    public Track(long id, String name) {
        super();
    	this.setId(id);
        this.setName(name);
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	@Override
	public String toString() {
		return id + name;
	}
}

