package edu.com.transferienciaapi.dto;

import java.math.BigDecimal;

public record clientResponseTrasnferDTO(
        String senderTelephone,
        BigDecimal amount,
        String addresseeTelephone
) {
}
