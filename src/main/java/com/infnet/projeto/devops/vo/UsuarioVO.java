package com.infnet.projeto.devops.vo;

import com.infnet.projeto.devops.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.collections4.Transformer;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UsuarioVO implements Serializable {

    private String nome;

    private Double altura;

    private Double peso;

    private Integer idade;

    public UsuarioVO(Usuario usuario) {
        this.nome = usuario.getNome();
        this.altura = usuario.getAltura();
        this.idade = usuario.getIdade();
        this.peso = usuario.getPeso();
    }

    public static List<UsuarioVO> valueOf(List<Usuario> usuarios) {
        return (List<UsuarioVO>) CollectionUtils.collect(usuarios, new Transformer<Usuario, UsuarioVO>() {
            @Override
            public UsuarioVO transform(Usuario usuario) {
                return new UsuarioVO(usuario);
            }
        });
    }
}
