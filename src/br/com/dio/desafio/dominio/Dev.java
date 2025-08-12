package br.com.dio.desafio.dominio;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;


public class Dev {
    private String nome;
    // Set para evitar acoplamento, linked para manter a ordem de inserção e hash para evitar duplicatas 
    private Set<Conteudo> conteudosInscritos = new LinkedHashSet<>();
    private Set<Conteudo> conteudosConcluidos = new LinkedHashSet<>();

    // método para inscrever o Dev em um Bootcamp
    public void inscreverBootcamp(Bootcamp bootcamp) {
        // inscreve o Dev em todos os conteúdos do Bootcamp
        this.conteudosInscritos.addAll(bootcamp.getConteudos());
        // adiciona o Dev à lista de inscritos do Bootcamp
        bootcamp.getDevsInscritos().add(this);
    }

    // método para concluir um conteúdo em que o Dev está inscrito
    public void progredir() {
        // só progride se tiver conteúdo inscrito
        if (!conteudosInscritos.isEmpty()) {
            //Optional para evitar null pointer exception
            //Define uma variável conteudo que recebe o primeiro conteúdo dos conteúdos inscritos
            Optional<Conteudo> conteudo = this.conteudosInscritos.stream().findFirst();
            if (conteudo.isPresent()) {
                conteudosConcluidos.add(conteudo.get());
                conteudosInscritos.remove(conteudo.get());
            } else {
                System.err.println("Você não está matriculado em nenhum conteúdo!");
            }
        }
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Set<Conteudo> getConteudosInscritos() {
        return conteudosInscritos;
    }

    public Set<Conteudo> getConteudosConcluidos() {
        return conteudosConcluidos;
    }

    // soma o XP de todos os conteúdos concluídos e retorna o total
    public double calcularTotalXp() {
        return conteudosConcluidos
                .stream()
                // Transforma a lista de conteúdos em uma lista de double para somar depois
                // o mesmo que conteudo -> conteudo.calcularXp(), calculando o XP de cada conteúdo
                .mapToDouble(Conteudo::calcularXp)
                .sum();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dev)) return false;
        Dev dev = (Dev) o;
        return nome != null ? nome.equals(dev.nome) : dev.nome == null;
    }

    @Override
    public int hashCode() {
        return nome != null ? nome.hashCode() : 0;
    }
}