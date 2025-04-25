package edu.com.transferienciaapi.controller;

import edu.com.transferienciaapi.dto.ClientRequestTrasnferDTO;
import edu.com.transferienciaapi.entity.Clientel;
import edu.com.transferienciaapi.repo.IClientRepository;
import edu.com.transferienciaapi.service.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/clientes")
@RequiredArgsConstructor
public class ClientelController {

    private final IClientService clientService;
    private final IClientRepository clientRepository;

    @PostMapping("/addDefaultClients")
    public String addDefaultClients() {
        // Crear cliente 1
        Clientel client1 = new Clientel();
        client1.setTelephone("123456789");
        client1.setBalance(new BigDecimal("1000.00"));
        client1.setName("Cliente Uno");

        // Crear cliente 2
        Clientel client2 = new Clientel();
        client2.setTelephone("987654321");
        client2.setBalance(new BigDecimal("2000.00"));
        client2.setName("Cliente Dos");

        // Guardar los clientes en la base de datos
        clientRepository.save(client1);
        clientRepository.save(client2);

        return "Clientes agregados correctamente";
    }

    @PostMapping("/trasferir")
    public ResponseEntity<Clientel> trasferir(
            @RequestParam String senderTelephone,
            @RequestParam String addresseeTelephone,
            @RequestParam BigDecimal amount
    ) {
        return ResponseEntity.ok(clientService.TransferMoney(senderTelephone, addresseeTelephone, amount));
    }

    @PostMapping("/trasferir2")
    public ResponseEntity<Clientel> trasferir2(@RequestBody ClientRequestTrasnferDTO clientRequestTrasnferDTO) {
        return ResponseEntity.ok(clientService.TransferMoney2(clientRequestTrasnferDTO));
    }

}
