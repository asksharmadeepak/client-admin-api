package com.example.demo.repository;

import com.example.demo.entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by dsm2061 on 11/23/18.
 */
@Repository
public interface ClientAdminRepository extends JpaRepository<Client, Long> {

}
