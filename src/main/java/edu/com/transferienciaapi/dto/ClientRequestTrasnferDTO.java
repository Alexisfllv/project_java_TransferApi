package edu.com.transferienciaapi.dto;

import java.math.BigDecimal;

public record ClientRequestTrasnferDTO(
        String senderTelephone,
        BigDecimal amount,
        String addresseeTelephone
) {
}
