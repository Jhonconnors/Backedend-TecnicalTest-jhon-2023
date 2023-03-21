package com.example.service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.model.UserModel;
import com.example.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	//Here the Repository is Injected
	@Autowired
	private UserRepository userRepository;
	
	//Here the Save method is implemented
	@Override
	 public UserModel saveUser(UserModel user) throws Exception {
		 if (Objects.isNull(user.getNombre())
		            || Objects.isNull(user.getApellido())
		            || Objects.isNull(user.getTelefono())
		            || Objects.isNull(user.getComuna())) {
            throw new Exception("Error en Los campos enviados -> "+user.toString());
        }
        return userRepository.save(user);
    }

	//Here the Find all method is implemented
	@Override
	public List<UserModel> getAllUsers() {
		return userRepository.findAll();
	}

	//Here the Search User by Id method is implemented
	@Override
	public Optional<UserModel> getUserById(long id) throws Exception {
		Optional<UserModel> getUser = userRepository.findById(id);
   	 if(getUser.isEmpty()){
   		 
   		throw new Exception("Error ID No encontrado");
        }
       return userRepository.findById(id);
   }

	//Here the Update User by Id method is implemented
	@Override
	public UserModel updateUser(UserModel updatedUser) throws Exception {
		if (Objects.isNull(updatedUser.getNombre())
	            || Objects.isNull(updatedUser.getApellido())
	            || Objects.isNull(updatedUser.getTelefono())
	            || Objects.isNull(updatedUser.getComuna())) {
        throw new Exception("Error en Los campos enviados -> "+updatedUser.toString());
    }
		Optional<UserModel> editUser = userRepository.findById(updatedUser.getId());
    	if(editUser.isEmpty()){
    		throw new Exception("Error Id No encontrado para Actualizar");
        }
    	
        return userRepository.save(updatedUser);
    }

	//Here the Delete User by Id method is implemented
	@Override
	public void deleteUser(long id) throws Exception {
		Optional<UserModel> getUser = userRepository.findById(id);
   	 	if(getUser.isEmpty()){
   	 	throw new Exception("Error ID No encontrado para Eliminar");
        }
        userRepository.deleteById(id);
    }

}
