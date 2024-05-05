package br.edu.utfpr.pedido.service;

import br.edu.utfpr.pedido.dto.PedidoDto;
import br.edu.utfpr.pedido.dto.StatusDto;
import br.edu.utfpr.pedido.model.Pedido;
import br.edu.utfpr.pedido.model.Status;
import br.edu.utfpr.pedido.repository.PedidoRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PedidoService
{
    @Autowired
    private PedidoRepository repository;

    @Autowired
    private ModelMapper modelMapper;

    public List<PedidoDto> buscaTodos(){
        return repository.findAll().stream().map(
                p -> modelMapper.map(p, PedidoDto.class))
                .collect(Collectors.toList());
    }

    public PedidoDto obterId(Long id){
        Pedido pedido = repository.findById(id).
                orElseThrow(() -> new RuntimeException());
        return modelMapper.map(pedido, PedidoDto.class);
    }

    public PedidoDto criarPedido(PedidoDto dto){
        Pedido pedido = modelMapper.map(dto, Pedido.class);
        pedido.setStatus(Status.REALIZADO);
        pedido.setDatahora(LocalDateTime.now());
        pedido.getItens().forEach(item -> item.setPedido((pedido)));
        repository.save(pedido);
        return modelMapper.map(pedido, PedidoDto.class);
    }

    public PedidoDto atualizarStatus(Long id, StatusDto dto){
        Pedido pedido = repository.buscaIdComItem(id);
        if (pedido == null){
            throw new RuntimeException();
        }
        pedido.setStatus(dto.getStatus());
        repository.atualizaStatus(dto.getStatus(), pedido);

        return modelMapper.map(pedido, PedidoDto.class);
    }

    public void aprovarPagamentoPedido(Long id){
        Pedido pedido = repository.buscaIdComItem(id);
        if(pedido == null){
            throw new RuntimeException();
        }
        pedido.setStatus(Status.PAGO);
        repository.save(pedido);
    }
}
