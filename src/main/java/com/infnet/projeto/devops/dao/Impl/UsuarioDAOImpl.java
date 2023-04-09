package com.infnet.projeto.devops.dao.Impl;

import com.infnet.projeto.devops.dao.UsuarioDAO;
import com.infnet.projeto.devops.entity.Usuario;
import com.infnet.projeto.devops.vo.UsuarioVO;
import org.hibernate.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service
public class UsuarioDAOImpl {

    @Autowired
    UsuarioDAO usuarioDAO;

    public Usuario salvar(UsuarioVO usuarioVO) {
        return usuarioDAO.save(new Usuario(usuarioVO));
    }

    public Usuario buscarPorId(Long id){
        return usuarioDAO.findById(id)
                .orElseThrow(() -> new ObjectNotFoundException("Usuario Não Encontrado", Usuario.class.getName()));
    }

    public List<Usuario> listar() {
        return usuarioDAO.findAll();
    }

    public void remover(Long id) {
        Usuario usuarioTemp = buscarPorId(id);
        usuarioDAO.deleteById(usuarioTemp.getId());
    }

    public Usuario atualizar(Long id, UsuarioVO usuario) {
        Usuario usuarioTemp = buscarPorId(id);
        usuarioTemp.setAltura(usuario.getAltura());
        usuarioTemp.setPeso(usuario.getPeso());
        usuarioTemp.setIdade(usuario.getIdade());

        return usuarioDAO.save(usuarioTemp);
    }

}
