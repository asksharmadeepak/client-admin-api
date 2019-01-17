package com.example.demo.controllers;

import com.example.demo.entity.Client;
import com.example.demo.handler.ClientNotFoundException;
import com.example.demo.services.ClientAdminService;
import com.example.demo.utils.EndPoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

/**
 * Created by dsm2061 on 11/23/18.
 */

@Controller
public class ClientAdminController {

    @Autowired
    ClientAdminService clientAdminService;


    @GetMapping(EndPoints.HOME)
    public String welcome(Model model) {
        model.addAttribute("client", new Client());
        return "home";
    }

    @PostMapping(path = EndPoints.CLIENT)
    @ResponseBody
    public String createClient(@ModelAttribute Client client){
        Client savedClient = clientAdminService.createClient(client);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedClient.getClientId()).toUri();
        return location.toString();
    }

    @GetMapping(EndPoints.CLIENT+"/{id}")
    @ResponseBody
    public Client retrieveClient(@PathVariable long id) {
        Optional<Client> client = clientAdminService.findById(id);
        if (!client.isPresent())
            throw new ClientNotFoundException("id-" + id);
        return client.get();
    }

    @DeleteMapping(path = EndPoints.CLIENT+"/{id}", produces =  MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public void deleteClient(@PathVariable long id) {
        clientAdminService.deleteById(id);
    }

    @PutMapping(EndPoints.CLIENT+"/{id}")
    @ResponseBody
    public String updateClient(@ModelAttribute Client client, @PathVariable long id) {
        Optional<Client> clientOptional = clientAdminService.findById(id);
        if (!clientOptional.isPresent())
            return ResponseEntity.notFound().build().toString();
        client.setClientId(id);
        clientAdminService.createClient(client);
        return client.getClientId().toString();
    }


    @GetMapping(path = EndPoints.CLIENTS, produces =  MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    public List<Client> retrieveAllClient() {
        List<Client> clients= clientAdminService.findAll();
        return clients;
    }


}
