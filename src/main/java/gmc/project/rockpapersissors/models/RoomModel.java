package gmc.project.rockpapersissors.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import gmc.project.rockpapersissors.entities.MatchEntity;
import lombok.Data;

@Data
public class RoomModel implements Serializable {

	private static final long serialVersionUID = -8276278399750701854L;
	
	private String roomId;
	
	private Set<MatchEntity> matches;
	
	private Boolean roomFilled;
	
	public RoomModel() {
		this.matches = new HashSet<>();
	}

}
