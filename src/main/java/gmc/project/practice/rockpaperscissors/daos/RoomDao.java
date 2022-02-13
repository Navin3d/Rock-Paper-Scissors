package gmc.project.practice.rockpaperscissors.daos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import gmc.project.practice.rockpaperscissors.entities.RoomEntity;

public interface RoomDao extends JpaRepository<RoomEntity, Long> {
	Optional<RoomEntity> findByRoomId(String roomId);
}
