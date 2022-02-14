package gmc.project.practice.rockpaperscissors.models;

import java.io.Serializable;

import lombok.Data;

@Data
public class PlayerEditModel implements Serializable {

	private static final long serialVersionUID = -5986505532960467303L;
		
	private String playerId;
	
	private Integer playerScore;
		
	private Boolean played;

	public PlayerEditModel(String playerId, Integer playerScore, Boolean played) {
		super();
		this.playerId = playerId;
		this.playerScore = playerScore;
		this.played = played;
	}

}
