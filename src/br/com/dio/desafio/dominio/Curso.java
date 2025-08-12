package br.com.dio.desafio.dominio;

public class Curso extends Conteudo {

    private int cargaHoraria;
    
    public int getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @Override
    public double calcularXp() {
        return XP_PADRAO * cargaHoraria;
    }

    // Representação do curso como string
    @Override
    public String toString() {
        return String.format("\nTítulo: %s. Descricao: %s. Carga Horária: %s", getTitulo(), getDescricao(), cargaHoraria);
        //return "\nCurso {titulo=" + getTitulo() + ", descricao=" + getDescricao() + ", cargaHoraria=" + cargaHoraria + "}\n";
    }   
}
