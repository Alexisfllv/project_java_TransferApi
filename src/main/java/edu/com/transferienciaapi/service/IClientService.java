package edu.com.transferienciaapi.service;

import edu.com.transferienciaapi.dto.ClientRequestTrasnferDTO;
import edu.com.transferienciaapi.entity.Clientel;

import java.math.BigDecimal;

public interface IClientService {

    //
    Clientel TransferMoney(String senderTelephone, String addresseeTelephone, BigDecimal amount);

    Clientel TransferMoney2(ClientRequestTrasnferDTO clientRequestTrasnferDTO);

}
