package br.com.dio.desafio.dominio;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Mentoria extends Conteudo {

    private DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private LocalDate data = LocalDate.now();

    private String dataString = data.format(formatter);

    public LocalDate getData() {
        return data;
    }
    public void setData(LocalDate data) {
        this.data = data;
    }

    @Override
    public double calcularXp() {
        return XP_PADRAO + 20d; // Mentoria tem um XP adicional
    }

    @Override
    public String toString() {
        return String.format("\nTítulo: %s. Descricao: %s. Data: %s", getTitulo(), getDescricao(), dataString);
    }


}
