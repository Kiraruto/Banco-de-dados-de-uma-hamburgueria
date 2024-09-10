package br.gustavo.hemburguer.entity.table_pedido.service;

import br.gustavo.hemburguer.entity.repository.PagamentoRepository;
import br.gustavo.hemburguer.entity.repository.PedidoRepository;
import br.gustavo.hemburguer.entity.table_pedido.Pagamento;
import br.gustavo.hemburguer.entity.table_pedido.Pedido;
import br.gustavo.hemburguer.entity.table_pedido.dto.DTOPagamento;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PagamentoService {

    @Autowired
    private PagamentoRepository pagamentoRepository;

    @Autowired
    private PedidoRepository pedidoRepository;

    @Transactional
    public ResponseEntity save(@Valid DTOPagamento dtoPagamento) {

        if (dtoPagamento.pedido_id() == null) {
            return ResponseEntity.badRequest().body("Id nulo");
        }

        Optional<Pedido> usuarioOptional = pedidoRepository.findById(dtoPagamento.pedido_id());

        if (usuarioOptional.isPresent()) {
            Pagamento pagamento = new Pagamento(dtoPagamento);

            pagamentoRepository.save(pagamento);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }

    public ResponseEntity salvarTruePagamento(Long id) {

        Optional<Pagamento> pagamentoOptional = pagamentoRepository.findById(id);

        if (!pagamentoOptional.isPresent()) {
            return ResponseEntity.badRequest().body("Id nulo");
        }

        Optional<Pagamento> pagamentoOptionalStatus = pagamentoRepository.findStatusById(id);

        var savePagamento = pagamentoOptionalStatus.get();
        savePagamento.statusTrue();

        return ResponseEntity.ok().build();
    }
}
