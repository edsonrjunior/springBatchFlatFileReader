package br.com.edsonrjunior.SpringBatchDelimitedFileReader.domain;

import lombok.Data;

import java.util.Arrays;
import java.util.List;

@Data
public class Cliente {

    private int id;
    private String agencia;
    private String conta;
    private String dac;


    public List<String> getClienteAttributes() {
        return Arrays.asList("id", "agencia", "conta", "dac");
    }

}
