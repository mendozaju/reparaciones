package com.amp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;

import com.amp.domain.Client;
import com.amp.repository.PostRepository;
import com.apm.entities.Post;

public class ClientServiceImpl implements ClientService {

	List<Client> clients;
	
	@Autowired
	PostRepository repostitory;

	public ClientServiceImpl() {
		clients = new ArrayList<Client>();

		clients.add(new Client(1, "Maxi"));
		clients.add(new Client(2, "Jose"));

	}

	public List<Client> getClients() {
		return clients;
	}

	public Client getClientById(int id) {
		return clients.get(id - 1);
	}
	
	public void addClient(Client client) {
		int id = clients.get(clients.size() - 1).getId() + 1;
		client.setId(id); 
		clients.add(client);
	}
	
	public void pruebaJpa(){
		
		Post miPost = new Post();
		miPost.setTitle("Un Titulo");
		
		repostitory.save(miPost);
		
		Post postDB = repostitory.findOne(miPost.getPostId());
		
		System.out.println("XXXXX - XXXXX El ID es" + postDB.getTitle() );
		
	}

}
