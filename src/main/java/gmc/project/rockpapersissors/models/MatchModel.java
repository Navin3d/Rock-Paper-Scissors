package gmc.project.rockpapersissors.models;

import java.io.Serializable;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import gmc.project.rockpapersissors.entities.RoomEntity;
import lombok.Data;

@Data
public class MatchModel implements Serializable {
	
	private static final long serialVersionUID = -6314707010024034145L;
	
	private String matchId;

	private Options player1Option;

	private Options player2Option;
	
	private Set<String> players;
	
	private Boolean isPlayer1Won;
	
	private Integer waitingTime;
	
	private Boolean isWaiting = true;
	
	private Boolean isMatchCancelled = false;
	
	private RoomEntity room;
	
	private Timestamp startedAt;
	
	private Timestamp finishedAt;
	
	public MatchModel() {
		this.room = new RoomEntity();
		this.players = new HashSet<>();
		this.startedAt = Timestamp.from(Instant.now());
	}

}
