package gmc.project.rockpapersissors.daos;

import org.springframework.data.jpa.repository.JpaRepository;

import gmc.project.rockpapersissors.entities.RoomEntity;

public interface RoomDao extends JpaRepository<RoomEntity, Long> {
	RoomEntity findByRoomId(String roomId);
}
