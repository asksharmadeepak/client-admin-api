package com.example.demo.services;

import com.example.demo.entity.Client;
import com.example.demo.repository.ClientAdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by dsm2061 on 11/23/18.
 */
@Service
public class ClientAdminService {

    @Autowired
    ClientAdminRepository clientAdminRepository;

    public Client createClient(Client client) {
        return clientAdminRepository.save(client);
    }

    public Optional<Client> findById(long id) {
        return clientAdminRepository.findById(id);
    }


    public void deleteById(long id) {
        clientAdminRepository.deleteById(id);
    }

    public List<Client> findAll() {
        return clientAdminRepository.findAll();
    }
}
