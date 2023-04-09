package com.infnet.projeto.devops.entity;

import com.infnet.projeto.devops.vo.UsuarioVO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "altura", nullable = false)
    private Double altura;

    @Column(name = "peso", nullable = false)
    private Double peso;

    @Column(name = "idade", nullable = false)
    private Integer idade;

    public Usuario(UsuarioVO usuarioVO){
        this.altura = usuarioVO.getAltura();
        this.idade = usuarioVO.getIdade();
        this.peso = usuarioVO.getPeso();
        this.nome = usuarioVO.getNome();
    }
}
