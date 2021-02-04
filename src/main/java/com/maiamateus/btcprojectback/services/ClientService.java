package com.maiamateus.btcprojectback.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.maiamateus.btcprojectback.domain.Client;
import com.maiamateus.btcprojectback.dto.ClientDTO;
import com.maiamateus.btcprojectback.repository.ClientRepository;
import com.maiamateus.btcprojectback.services.exception.ObjectNotFoundException;


@Service
public class ClientService {

	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private ClientRepository repo;

	public List<Client> findAll(){
		return repo.findAll();
	}
	
	public Client findById(Integer id) {
		Client client = repo.findById(id).orElse(null);
		if(client == null) {
			throw new ObjectNotFoundException("Objeto não encontrado");
		}
		return client;
	}
	
	public Client insert(Client obj) {
		return repo.insert(obj);
	}
	
	public void delete(Integer id) {
		findById(id);
		repo.deleteById(id);
	}
	
	public Client fromDTO(ClientDTO objDto) {
		return new Client(objDto.getId(), objDto.getName(), objDto.getEmail(), pe.encode(objDto.getPassword()));
	}
}
