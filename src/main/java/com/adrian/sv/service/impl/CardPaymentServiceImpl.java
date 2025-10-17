package com.adrian.sv.service.impl;

import com.adrian.sv.dto.request.cardpayment.CreateCardPaymentRequest;
import com.adrian.sv.dto.request.cardpayment.UpdateCardPaymentRequest;
import com.adrian.sv.dto.response.CardPaymentResponse;
import com.adrian.sv.model.entity.PagamentoBoleto;
import com.adrian.sv.model.entity.PagamentoCartao;
import com.adrian.sv.model.mapper.CardPaymentMapper;
import com.adrian.sv.repository.CardPaymentRepository;
import com.adrian.sv.service.CardPaymentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class CardPaymentServiceImpl implements CardPaymentService {

    private final CardPaymentRepository cardPaymentRepository;
    private final CardPaymentMapper cardPaymentMapper;

    @Override
    public CardPaymentResponse create(CreateCardPaymentRequest request) {
        try {
            PagamentoCartao cardPayment = this.cardPaymentMapper.toEntity(request);
            PagamentoCartao savedCardPayment = this.cardPaymentRepository.save(cardPayment);
            return this.cardPaymentMapper.toResponseDTO(savedCardPayment);
        } catch (Exception e) {
            log.error("Falha ao criar pagamento de cartao. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao criar pagamento de cartao.");
        }
    }

    @Override
    public List<CardPaymentResponse> findAll() {
        try {
            List<PagamentoCartao> cardPayments = this.cardPaymentRepository.findAll();
            return cardPayments.stream().map(this.cardPaymentMapper::toResponseDTO).toList();
        } catch (Exception e) {
            log.error("Falha ao listar pagamentos de cartao. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao listar pagamentos de cartao.");
        }
    }

    @Override
    public CardPaymentResponse findById(Long id) {
        try {
            PagamentoCartao cardPayment = this.cardPaymentRepository.findById(id).orElseThrow(
                    () -> new BadRequestException("Pagamento de cartão não encontrado!"));
            return this.cardPaymentMapper.toResponseDTO(cardPayment);
        } catch (Exception e) {
            log.error("Falha ao buscar pagamento de cartao. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao buscar pagamento de cartao.");
        }
    }

    @Override
    public CardPaymentResponse update(Long id, UpdateCardPaymentRequest request) {
        try {
            PagamentoCartao cardPayment = this.cardPaymentRepository.findById(id).orElseThrow(
                    () -> new BadRequestException("Pagamento de cartão não encontrado!"));
            this.cardPaymentMapper.updateEntity(request, cardPayment);
            PagamentoCartao updatedCardPayment = this.cardPaymentRepository.save(cardPayment);
            return this.cardPaymentMapper.toResponseDTO(updatedCardPayment);
        } catch (Exception e) {
            log.error("Falha ao atualizar pagamento de boleto. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao atualizar pagamento de boleto.");
        }
    }

    @Override
    public void delete(Long id) {
        try {
            PagamentoCartao cardPayment = this.cardPaymentRepository.findById(id).orElseThrow(
                    () -> new BadRequestException("Pagamento de cartão não encontrado!"));
            this.cardPaymentRepository.delete(cardPayment);
        } catch (Exception e) {
            log.error("Falha ao remover pagamento de boleto. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao remover pagamento de boleto.");
        }
    }
}
