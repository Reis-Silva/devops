package com.infnet.projeto.devops.service;

import com.infnet.projeto.devops.dao.Impl.UsuarioDAOImpl;
import com.infnet.projeto.devops.entity.Usuario;
import com.infnet.projeto.devops.vo.IMC;
import com.infnet.projeto.devops.vo.UsuarioVO;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/usuario")
public class UsuarioService {

    private final Logger log = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UsuarioDAOImpl usuarioDAOImpl;

    @Operation(summary = "Cadastrar Usuário")
    @PostMapping(value = "/cadastrar")
    public ResponseEntity<Usuario> cadastrar(@RequestBody UsuarioVO usuarioVO) {
        Usuario usuario = usuarioDAOImpl.salvar(usuarioVO);
        log.info("Salvando Usuário: " + usuario);

        return ResponseEntity.ok().body(usuario);
    }

    @Operation(summary = "Listar Usuários")
    @GetMapping(value = "/listar")
    public ResponseEntity<List<Usuario>> listar() {
        List<Usuario> usuario = usuarioDAOImpl.listar();
        log.info("Lista de Usuários: " + usuario);

        return ResponseEntity.ok().body(usuario);
    }

    @Operation(summary = "Deletar Usuário Por Id")
    @DeleteMapping(value = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public ResponseEntity remover(@PathVariable("id") Long id) {
        usuarioDAOImpl.remover(id);
        log.info("Removendo Usuário Por Id: " + id);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Alterar Usuário")
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> atualizar(@PathVariable("id") Long id, @RequestBody UsuarioVO usuarioVO) {
        Usuario usuario = usuarioDAOImpl.atualizar(id, usuarioVO);
        log.info("Atualizando Usuário: " + usuario);

        return ResponseEntity.ok().body(usuario);
    }

    @Operation(summary = "Calcular Índice de Massa Corporal do Usuário Por Id")
    @GetMapping(value = "imc/{id}")
    public ResponseEntity<IMC> calcularImcPorId(@PathVariable("id") Long id) {
        IMC imc = new IMC();

        imc.calcularImc(usuarioDAOImpl.buscarPorId(id));
        log.info("Calculando IMC: " + imc);

        return ResponseEntity.ok().body(imc);
    }
}
