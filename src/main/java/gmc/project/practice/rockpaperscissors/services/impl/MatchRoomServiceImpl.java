package gmc.project.practice.rockpaperscissors.services.impl;

import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.stereotype.Service;

import gmc.project.practice.rockpaperscissors.daos.RoomDao;
import gmc.project.practice.rockpaperscissors.entities.RoomEntity;
import gmc.project.practice.rockpaperscissors.exceptions.RoomNotFoundException;
import gmc.project.practice.rockpaperscissors.models.RoomModel;
import gmc.project.practice.rockpaperscissors.services.MatchRoomService;
import gmc.project.practice.rockpaperscissors.services.PlayersService;

@Service
public class MatchRoomServiceImpl implements MatchRoomService {
	
	private final RoomDao roomDao;
	private final PlayersService playersService;
	
	public MatchRoomServiceImpl(RoomDao roomDao, PlayersService playersService) {
		super();
		this.roomDao = roomDao;
		this.playersService = playersService;
	}
	
	@Override
	public RoomEntity findOne(String roomId) {
		Optional<RoomEntity> foundRoom = roomDao.findByRoomId(roomId);
		
		if(foundRoom.isEmpty()) throw new RoomNotFoundException(roomId);
		
		return foundRoom.get();
	}
	
	@Override
	public RoomModel getRoom(String roomId) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		RoomEntity foundRoom = findOne(roomId);
		RoomModel returnValue = modelMapper.map(foundRoom, RoomModel.class);
		
		return returnValue;
	}
	
	@Override
	public RoomModel createRoom(String roomId) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		RoomEntity createdRoom = new RoomEntity();
		createdRoom.setRoomId(roomId);
		RoomEntity savedRoom = roomDao.save(createdRoom);
		playersService.createPlayer(savedRoom.getRoomId());
		
		RoomEntity foundRoom = findOne(roomId);
		RoomModel returnValue = modelMapper.map(foundRoom, RoomModel.class);
		
		return returnValue;
	}

	@Override
	public RoomModel joinRoom(String roomId) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		
		playersService.createPlayer(roomId);
		
		RoomEntity foundRoom = findOne(roomId);
		foundRoom.setIsWaitingForPlayer(false);
		
		RoomEntity savedRoom = roomDao.save(foundRoom);
		RoomModel returnValue = modelMapper.map(savedRoom, RoomModel.class);
		
		return returnValue;
	}

	@Override
	public void deleteRoom(String roomId) {
		RoomEntity foundRoom = findOne(roomId);
		roomDao.delete(foundRoom);
	}

}
