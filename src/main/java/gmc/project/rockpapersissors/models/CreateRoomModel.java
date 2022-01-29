package gmc.project.rockpapersissors.models;

import java.io.Serializable;

import lombok.Data;

@Data
public class CreateRoomModel implements Serializable {

	private static final long serialVersionUID = 660548007458894465L;
	
	private String roomId;
	
	private String player1Id;

}
