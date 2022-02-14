package gmc.project.practice.rockpaperscissors.models;

import java.io.Serializable;

import lombok.Data;

@Data
public class PlayerModel implements Serializable {

	private static final long serialVersionUID = -2123047988608618598L;
	
	private String playerId;
	
	private Options playerSelection;
	
	private Integer playerScore;
		
	private Boolean played;
	
}
