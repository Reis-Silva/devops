package com.infnet.projeto.devops.vo;

import com.infnet.projeto.devops.Enum.CategoriaPesoEnum;
import com.infnet.projeto.devops.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class IMC {

    private Double imc;

    private String categoria;

    public void calcularImc(Usuario usuario){
        this.imc = usuario.getPeso()/(usuario.getAltura() * usuario.getAltura());

        if (this.imc < 18.4){
            this.categoria = CategoriaPesoEnum.ABAIXO_PESO.toString();
        } else if (this.imc > 18.4 && this.imc <= 24.9){
            this.categoria = CategoriaPesoEnum.PESO_NORMAL.toString();
        } else if (this.imc > 24.9 && this.imc <= 29.9){
            this.categoria = CategoriaPesoEnum.SOBRE_PESO.toString();
        } else if (this.imc > 29.9 && this.imc <= 34.9){
            this.categoria = CategoriaPesoEnum.OBESIDADE_GRAU_UM.toString();
        } else if (this.imc > 34.9 && this.imc <= 39.9){
            this.categoria = CategoriaPesoEnum.OBESIDADE_GRAU_DOIS.toString();
        } else if (this.imc > 39.9){
            this.categoria = CategoriaPesoEnum.OBESIDADE_GRAU_TRES.toString();
        }
    }

}
