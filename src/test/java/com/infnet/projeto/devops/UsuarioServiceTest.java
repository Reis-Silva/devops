package com.infnet.projeto.devops;

import com.infnet.projeto.devops.dao.Impl.UsuarioDAOImpl;
import com.infnet.projeto.devops.entity.Usuario;
import com.infnet.projeto.devops.service.UsuarioService;
import com.infnet.projeto.devops.vo.UsuarioVO;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UsuarioServiceTest {

    @Mock
    UsuarioDAOImpl usuarioDAOImpl;
    @InjectMocks
    UsuarioService usuarioService;

    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    void save() {
        UsuarioVO usuarioVO = new UsuarioVO("Julio César", 1.74, 90.5, 31);
        Usuario usuario = new Usuario(1L, usuarioVO.getNome(), usuarioVO.getAltura(), usuarioVO.getPeso(), usuarioVO.getIdade());
        Mockito.when(usuarioDAOImpl.salvar(usuarioVO)).thenReturn(usuario);

        Usuario usuarioTeste = usuarioService.cadastrar(usuarioVO).getBody();

        assertEquals(usuarioTeste.getId(), usuario.getId());
        assertEquals(usuarioTeste.getNome(), usuarioVO.getNome());
        assertEquals(usuarioTeste.getAltura(), usuarioVO.getAltura());
        assertEquals(usuarioTeste.getPeso(), usuarioVO.getPeso());
        assertEquals(usuarioTeste.getIdade(), usuarioVO.getIdade());
    }

    @Test
    void update(){
        UsuarioVO usuarioVO = new UsuarioVO("Julio César", 1.74, 90.5, 31);
        UsuarioVO usuarioVO2 = new UsuarioVO("Julio Silva", 1.74, 90.5, 31);

        Usuario usuario = new Usuario(1L, usuarioVO.getNome(), usuarioVO.getAltura(), usuarioVO.getPeso(), usuarioVO.getIdade());
        Usuario usuario2 = new Usuario(1L, usuarioVO2.getNome(), usuarioVO2.getAltura(), usuarioVO2.getPeso(), usuarioVO2.getIdade());

        Mockito.when(usuarioDAOImpl.salvar(usuarioVO)).thenReturn(usuario);
        Usuario usuarioTeste = usuarioService.cadastrar(usuarioVO).getBody();

        Mockito.when(usuarioDAOImpl.atualizar(1L, usuarioVO2)).thenReturn(usuario2);
        Usuario usuarioTeste2 = usuarioService.atualizar(1L, usuarioVO2).getBody();

        assertEquals(usuarioTeste.getId(), usuarioTeste2.getId());
    }

    @Test
    void findAll() {
        Mockito.when(usuarioDAOImpl.listar()).thenReturn(usuarios());

        List<Usuario> list = usuarioService.listar().getBody();

        assertEquals(4, list.size());
    }

    private List<Usuario> usuarios(){
        UsuarioVO usuarioVO1 = new UsuarioVO("Julio César", 1.74, 90.5, 31);
        UsuarioVO usuarioVO2 = new UsuarioVO("Julio César", 1.74, 90.5, 31);
        UsuarioVO usuarioVO3 = new UsuarioVO("Julio César", 1.74, 90.5, 31);
        UsuarioVO usuarioVO4 = new UsuarioVO("Julio César", 1.74, 90.5, 31);

        List<Usuario> usuarios = new ArrayList<>();
        usuarios.add(new Usuario(usuarioVO1));
        usuarios.add(new Usuario(usuarioVO2));
        usuarios.add(new Usuario(usuarioVO3));
        usuarios.add(new Usuario(usuarioVO4));

        return usuarios;
    }

    @Test
    void delete() {
        Usuario usuario = new Usuario(1L,"Julio César", 1.74, 90.5, 31);
        Mockito.when(usuarioDAOImpl.buscarPorId(1L)).thenReturn(usuario);
        usuarioService.remover(1L);
        Mockito.verify(usuarioDAOImpl).remover(1L);
    }

    @Test
    void imc(){
        Usuario usuario = new Usuario(1L,"Julio César", 1.74, 90.5, 31);
        Mockito.when(usuarioDAOImpl.buscarPorId(1L)).thenReturn(usuario);
        usuarioService.calcularImcPorId(1L);
    }
}
