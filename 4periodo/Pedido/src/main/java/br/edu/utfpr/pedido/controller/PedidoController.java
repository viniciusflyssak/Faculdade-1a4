package br.edu.utfpr.pedido.controller;
import br.edu.utfpr.pedido.dto.PedidoDto;
import br.edu.utfpr.pedido.dto.StatusDto;
import br.edu.utfpr.pedido.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pedido")
public class PedidoController {
    @Autowired
    private PedidoService service;

    @GetMapping
    public List<PedidoDto> listar() {
        return service.buscaTodos();
    }

    @PostMapping
    public ResponseEntity<PedidoDto> realizaPedido(@RequestBody @Valid PedidoDto dto, UriComponentsBuilder uri) {
        PedidoDto pedidoDto = service.criarPedido(dto);
        URI endereco = uri.path("/pedido/{id}").buildAndExpand(pedidoDto.getId()).toUri();
        return ResponseEntity.created(endereco).body(pedidoDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<PedidoDto> buscar(@PathVariable Long id) {
        PedidoDto dto = service.obterId(id);
        return ResponseEntity.ok(dto);
    }

    @PutMapping
    public ResponseEntity<PedidoDto> atualizarStatus(@PathVariable Long id, StatusDto  statusDto) {
        PedidoDto dto = service.atualizarStatus(id, statusDto);
        return ResponseEntity.ok(dto);
    }

}
