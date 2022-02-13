package gmc.project.practice.rockpaperscissors.models;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import lombok.Data;

@Data
public class RoomModel implements Serializable {

	private static final long serialVersionUID = -5783238395974998122L;
	
	private String roomId;
	
	private Set<PlayerModel> players;
	
	private Boolean isWaitingForPlayer;
	
	private Boolean isActive;

	public RoomModel() {
		super();
		this.players = new HashSet<>();
	}

}
