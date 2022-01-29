package gmc.project.rockpapersissors.models;

import java.io.Serializable;

import lombok.Data;

@Data
public class ChangeOption implements Serializable {

	private static final long serialVersionUID = 1910367692970801374L;
	
	private String roomId;
	private Options option;

}
