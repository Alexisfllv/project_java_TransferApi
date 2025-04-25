package edu.com.transferienciaapi.service.Impl;

import edu.com.transferienciaapi.dto.ClientRequestTrasnferDTO;
import edu.com.transferienciaapi.entity.Clientel;
import edu.com.transferienciaapi.repo.IClientRepository;
import edu.com.transferienciaapi.service.IClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
@RequiredArgsConstructor
public class ClientServiceImpl implements IClientService {

    private final IClientRepository clientRepository;


    @Override
    public Clientel TransferMoney(String senderTelephone, String addresseeTelephone, BigDecimal amount) {


        //validar cliente
        Clientel clientt = clientRepository.findByTelephone(senderTelephone);
        if (clientt == null) {
            throw new RuntimeException("no existe el numero");
        }

        //
        Clientel clientt2 = clientRepository.findByTelephone(addresseeTelephone);
        if (clientt2 == null) {
            throw new RuntimeException("no existe el numero destinatario");
        }

        //
        if (clientt.getBalance().compareTo(amount) < 0) {
            throw new RuntimeException("el monto excede al presupuesto");
        }

        // enviar dinero al clientt 2
        clientt.setBalance(clientt.getBalance().subtract(amount));
        clientt2.setBalance(clientt2.getBalance().add(amount));

        clientRepository.save(clientt);

        clientRepository.save(clientt2);
        return clientt;

    }

    @Override
    public Clientel TransferMoney2(ClientRequestTrasnferDTO clientRequestTrasnferDTO) {
        //validar cliente

        Clientel clientt = clientRepository.findByTelephone(clientRequestTrasnferDTO.senderTelephone());
        if (clientt == null) {
            throw new RuntimeException("no existe el numero");
        }

        //
        Clientel clientt2 = clientRepository.findByTelephone(clientRequestTrasnferDTO.addresseeTelephone());
        if (clientt2 == null) {
            throw new RuntimeException("no existe el numero destinatario");
        }

        //
        if (clientt.getBalance().compareTo(clientRequestTrasnferDTO.amount()) < 0) {
            throw new RuntimeException("el monto excede al presupuesto");
        }

        // enviar dinero al clientt 2
        clientt.setBalance(clientt.getBalance().subtract(clientRequestTrasnferDTO.amount()));
        clientt2.setBalance(clientt2.getBalance().add(clientRequestTrasnferDTO.amount()));

        clientRepository.save(clientt);

        clientRepository.save(clientt2);
        return clientt;
    }
}
