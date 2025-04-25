package edu.com.transferienciaapi.repo;

import ch.qos.logback.core.net.server.Client;
import edu.com.transferienciaapi.entity.Clientel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClientRepository extends JpaRepository<Clientel, Integer> {

    Clientel findByTelephone(String telephone);
}
