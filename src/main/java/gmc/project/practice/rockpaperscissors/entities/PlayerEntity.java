package gmc.project.practice.rockpaperscissors.entities;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import gmc.project.practice.rockpaperscissors.models.Options;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "players")
@EqualsAndHashCode(exclude = {"matchRoom"})
public class PlayerEntity implements Serializable {

	private static final long serialVersionUID = 5867500774599805087L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "player_id", unique = true)
	private String playerId;
	
	@Column(name = "player_selection")
	@Enumerated(value = EnumType.STRING)
	private Options playerSelection;
	
	@Column(name = "player_score")
	private Integer playerScore;
	
	@ManyToOne
	private RoomEntity matchRoom;
	
	@Column(name = "played")
	private Boolean played;

	public PlayerEntity() {
		super();
		this.playerId = UUID.randomUUID().toString();
		this.playerScore = 0;
		this.matchRoom = new RoomEntity();
		this.played = false;
	}

}
