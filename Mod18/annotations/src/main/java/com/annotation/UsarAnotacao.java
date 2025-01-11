package com.annotation;

import java.lang.reflect.Field;

@Tabela(nome = "Tabela")
public class UsarAnotacao {
    @Tabela(nome = "Tabela5")
    public String nome;

    public String getNome() {
        return nome;
    }

    public void Printar() {
        for (Field f : UsarAnotacao.class.getFields()) {
            Tabela tabela = f.getAnnotation(Tabela.class);
            if (tabela != null)
                System.out.println(tabela.nome());
        }
    }

}
