package com.maiamateus.btcprojectback.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.maiamateus.btcprojectback.domain.Client;
import com.maiamateus.btcprojectback.repository.ClientRepository;

@Configuration
public class Instantiation implements CommandLineRunner{

	@Autowired
	private BCryptPasswordEncoder pe;
	
	@Autowired
	private ClientRepository clientRepository;
	
	@Override
	public void run(String... args) throws Exception {
		clientRepository.deleteAll();
		
		/* Instanciação para fins de testes */
		Client maria = new Client(0001, "Maria Brown", "maria@gmail.com", pe.encode("123456"));
		Client alex = new Client(0002, "Alex Green", "alex@gmail.com", pe.encode("55555555"));
		Client bob = new Client(0003, "Bob Grey", "bob@gmail.com", pe.encode("222222222222"));
		
		clientRepository.saveAll(Arrays.asList(maria, alex, bob));
	}
}
