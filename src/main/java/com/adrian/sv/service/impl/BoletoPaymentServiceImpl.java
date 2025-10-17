package com.adrian.sv.service.impl;

import com.adrian.sv.dto.request.boletopayment.CreateBoletoPaymentRequest;
import com.adrian.sv.dto.request.boletopayment.UpdateBoletoPaymentRequest;
import com.adrian.sv.dto.response.BoletoPaymentResponse;
import com.adrian.sv.model.entity.PagamentoBoleto;
import com.adrian.sv.model.mapper.BoletoPaymentMapper;
import com.adrian.sv.repository.BoletoPaymentRepository;
import com.adrian.sv.service.BoletoPaymentService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.coyote.BadRequestException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class BoletoPaymentServiceImpl implements BoletoPaymentService {

    private final BoletoPaymentRepository boletoPaymentRepository;
    private final BoletoPaymentMapper boletoPaymentMapper;

    @Override
    public BoletoPaymentResponse create(CreateBoletoPaymentRequest request) {
        try {
            PagamentoBoleto boletoPayment = this.boletoPaymentMapper.toEntity(request);
            PagamentoBoleto savedBoletoPayment = this.boletoPaymentRepository.save(boletoPayment);
            return this.boletoPaymentMapper.toResponseDTO(savedBoletoPayment);
        } catch (Exception e) {
            log.error("Falha ao criar pagamento de boleto. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao criar pagamento de boleto.");
        }
    }

    @Override
    public List<BoletoPaymentResponse> findAll() {
        try {
            List<PagamentoBoleto> boletoPayments = this.boletoPaymentRepository.findAll();
            return boletoPayments.stream().map(this.boletoPaymentMapper::toResponseDTO).toList();
        } catch (Exception e) {
            log.error("Falha ao listar pagamentos de boleto. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao listar pagamentos de boleto.");
        }
    }

    @Override
    public BoletoPaymentResponse findById(Long id) {
        try {
            PagamentoBoleto boletoPayment = this.boletoPaymentRepository.findById(id).orElseThrow(
                    () -> new BadRequestException("Pagamento de boleto não encontrado!"));
            return this.boletoPaymentMapper.toResponseDTO(boletoPayment);
        } catch (Exception e) {
            log.error("Falha ao buscar pagamento de boleto. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao buscar pagamento de boleto.");
        }
    }

    @Override
    public BoletoPaymentResponse update(Long id, UpdateBoletoPaymentRequest request) {
        try {
            PagamentoBoleto boletoPayment = this.boletoPaymentRepository.findById(id).orElseThrow(
                    () -> new BadRequestException("Pagamento de boleto não encontrado!"));
            this.boletoPaymentMapper.updateEntity(request, boletoPayment);
            PagamentoBoleto updatedBoletoPayment = this.boletoPaymentRepository.save(boletoPayment);
            return this.boletoPaymentMapper.toResponseDTO(updatedBoletoPayment);
        } catch (Exception e) {
            log.error("Falha ao atualizar pagamento de boleto. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao atualizar pagamento de boleto.");
        }
    }

    @Override
    public void delete(Long id) {
        try {
            PagamentoBoleto boletoPayment = this.boletoPaymentRepository.findById(id).orElseThrow(
                    () -> new BadRequestException("Pagamento de boleto não encontrado!"));
            this.boletoPaymentRepository.delete(boletoPayment);
        } catch (Exception e) {
            log.error("Falha ao remover pagamento de boleto. {}", String.valueOf(e));
            throw new RuntimeException("Falha ao remover pagamento de boleto.");
        }
    }
}
