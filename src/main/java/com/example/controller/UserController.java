package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.feing.client.ComunaClient;
import com.example.model.ComunaModel;
import com.example.model.UserModel;
import com.example.service.UserService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/v1")
@CrossOrigin(origins = "${app.web.url}")
public class UserController {
	
	private final ComunaClient client;
	
	@GetMapping("/comunas")
    public List<ComunaModel> getNombresComunas() {
        return client.getComunas();
    }
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/all")
	public List<UserModel> getAll(){
		List<UserModel> response = userService.getAllUsers();
		return response;
	}
	
	
	@PostMapping("/create")
	public ResponseEntity<String> save(@RequestBody UserModel userModel) throws Exception {
		 try {
			 userService.saveUser(userModel);
		     return ResponseEntity.status(HttpStatus.CREATED)
		    		 .body("Usuario "+userModel.getNombre()+" creado!!");
		    } catch (Exception e) {
		        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		    }
		}
	@GetMapping("/{id}")
    public ResponseEntity<?> getUserById
    (@PathVariable("id") long userId)throws Exception{
		try {
			Optional<UserModel> user = userService.getUserById(userId);
			return ResponseEntity.status(HttpStatus.OK).body(user);
		} catch (Exception e) {
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}  
    }
	
	@PutMapping("/update")
    public ResponseEntity<?> editUser
    (@RequestBody UserModel userUpdate)throws Exception{
		try {
			UserModel user = userService.updateUser(userUpdate);
			return ResponseEntity.status(HttpStatus.OK).body(user);
		} catch (Exception e) {
			 return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}  
    }
	
	 @DeleteMapping("/delete/{id}")
	 public ResponseEntity<String> deleteEmployee(@PathVariable("id") long UserId) throws Exception{ 
	    try {
	    	userService.deleteUser(UserId);
	    	return new ResponseEntity<String>("Usuario Eliminado!.", HttpStatus.OK);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}
	
}
