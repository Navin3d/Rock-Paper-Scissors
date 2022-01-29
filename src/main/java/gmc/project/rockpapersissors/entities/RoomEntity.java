package gmc.project.rockpapersissors.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name = "game_rooms")
public class RoomEntity implements Serializable {

	private static final long serialVersionUID = -7934843672977308617L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "room_id", unique = true)
	@Lob
	private String roomId;
	
	@Column(name = "room_filled")
	private Boolean roomFilled = false;
	
	@OneToOne(mappedBy = "room", targetEntity = MatchEntity.class)
	private MatchEntity matches = new MatchEntity();

}
