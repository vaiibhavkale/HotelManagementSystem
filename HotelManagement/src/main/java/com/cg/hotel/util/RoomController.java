/**
 * 
 */
package com.cg.hotel.util;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.hotel.model.Room;
import com.cg.hotel.service.RoomService;

/**
 * @author HBMS
 * RoomController.java
 * May 8, 2020
 */

@RestController
public class RoomController {
	
	@Autowired
	private RoomService service;
	
	@GetMapping("/rooms")
	public List<Room> findAll(){
		return service.findAll();
	}
	
	@PostMapping("/room/add")
	public void createRoom(@RequestBody Room room) {
		service.createRoom(room);
	}
	
	@DeleteMapping("/room/delete/{roomId}")
	public void deleteRoom(@PathVariable Long roomId) {
		service.deleteRoom(roomId);
	}
	
	@PutMapping("/room/update")
	public void updateRoom(@RequestBody Room room) {
		service.updateRoom(room);
	}
	
}