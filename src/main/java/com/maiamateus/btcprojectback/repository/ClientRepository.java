package com.maiamateus.btcprojectback.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.maiamateus.btcprojectback.domain.Client;

@Repository
public interface ClientRepository extends MongoRepository<Client, Integer>{

}
