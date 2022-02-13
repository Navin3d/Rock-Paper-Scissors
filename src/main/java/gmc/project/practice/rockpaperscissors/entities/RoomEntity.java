package gmc.project.practice.rockpaperscissors.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "match_rooms")
@EqualsAndHashCode(exclude = {"players"})
public class RoomEntity implements Serializable {
	
	private static final long serialVersionUID = 2278480705377592863L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "room_id", unique = true)
	private String roomId;
	
	@OneToMany(mappedBy = "matchRoom", cascade = CascadeType.ALL)
	private Set<PlayerEntity> players;
	
	@Column(name = "is_waiting_for_players")
	private Boolean isWaitingForPlayer;
	
	@Column(name = "is_active")
	private Boolean isActive;

	public RoomEntity() {
		super();
		this.roomId = UUID.randomUUID().toString();
		this.players = new HashSet<>();
		this.isWaitingForPlayer = true;
		this.isActive = true;
	}

}
