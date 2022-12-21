package com.ead.authuser.dtos;

import com.ead.authuser.enums.UnidadeFederacao;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.Builder;
import lombok.Data;
import java.io.Serializable;

import java.util.UUID;

@Data
@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class StablishmentDto implements Serializable {
    private UUID id;
    private String nome;
    private String telefone;
    private String latitude;
    private String longitude;
    private String cep;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String urlDaImagemDeExibicao;
    private UnidadeFederacao estado;
}