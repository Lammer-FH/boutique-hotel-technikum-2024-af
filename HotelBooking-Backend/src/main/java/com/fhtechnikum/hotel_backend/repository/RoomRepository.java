package com.fhtechnikum.hotel_backend.repository;

import com.fhtechnikum.hotel_backend.model.Room;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface RoomRepository extends CrudRepository<Room, Integer> {
	@Query("SELECT ROOM_ID, ROOM_TITLE, ROOM_DESCRIPTION FROM ROOM ORDER BY ROOM_ID")
	Iterable<Room> findAllRooms();
}
