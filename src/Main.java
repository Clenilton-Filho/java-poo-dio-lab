import br.com.dio.desafio.dominio.*;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) throws Exception {

        // Criando instâncias de Curso, Mentoria e Bootcamp
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso Java");
        curso1.setDescricao("Descrição do curso Java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso JavaScript");
        curso2.setDescricao("Descrição do curso JavaScript");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria de Java");
        mentoria.setDescricao("Descrição da mentoria de Java");
        mentoria.setData(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição do Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        // Criando um Dev e inscrevendo no Bootcamp
        Dev devNeo = new Dev();
        devNeo.setNome("Neo");
        devNeo.inscreverBootcamp(bootcamp);

        // Exibindo informações do Dev e seus conteúdos inscritos
        System.out.println("--- DevNeo ---");
        System.out.printf("Conteúdos inscritos de %s: %s\n", devNeo.getNome(), getConteudosInscritos(devNeo));
        System.out.println("\nXP de " + devNeo.getNome() + " : " + devNeo.calcularTotalXp());

        // Progredindo no Bootcamp
        System.out.println("\nProgredindo devNeo...\n");
        devNeo.progredir();
        
        // Exibindo informações após progresso
        System.out.printf("Conteúdos inscritos de %s após progresso: %s\n", devNeo.getNome(), getConteudosInscritos(devNeo));
        System.out.printf("\nConteúdos concluídos de %s após progresso: %s\n", devNeo.getNome(), getConteudosConcluidos(devNeo));
        System.out.println("\nXP de " + devNeo.getNome() + " após progresso: " + devNeo.calcularTotalXp());


        // Criando outro Dev para testar o Bootcamp
        Dev devTrinity = new Dev();
        devTrinity.setNome("Trinity");
        devTrinity.inscreverBootcamp(bootcamp);

        System.out.println("\n--- DevTrinity ---");
        System.out.printf("Conteúdos inscritos de %s: %s\n", devTrinity.getNome(), getConteudosInscritos(devTrinity));
        System.out.println("\nXP de " + devTrinity.getNome() + " : " + devTrinity.calcularTotalXp());

        // Progredindo no Bootcamp a primeira vez
        System.out.println("\nProgredindo devTrinity...\n");
        devTrinity.progredir();

        System.out.printf("Conteúdos inscritos de %s após progresso: %s\n", devTrinity.getNome(), getConteudosInscritos(devTrinity));
        System.out.printf("\nConteúdos concluídos de %s após progresso: %s\n", devTrinity.getNome(), getConteudosConcluidos(devTrinity));
        System.out.println("\nXP de " + devTrinity.getNome() + " após progresso: " + devTrinity.calcularTotalXp());

        // Progredindo novamente no Bootcamp
        System.out.println("\nProgredindo devTrinity novamente...\n");
        devTrinity.progredir();

        System.out.printf("Conteúdos inscritos de %s após segundo progresso: %s\n", devTrinity.getNome(), getConteudosInscritos(devTrinity));
        System.out.printf("\nConteúdos concluídos de %s após segundo progresso: %s\n", devTrinity.getNome(), getConteudosConcluidos(devTrinity));
        System.out.println("\nXP de " + devTrinity.getNome() + " após segundo progresso: " + devTrinity.calcularTotalXp());

    }

    // Métodos auxiliares para exibir conteúdos inscritos e concluídos
    public static String getConteudosInscritos(Dev dev) {
        var conteudos =  dev.getConteudosInscritos().toString();
        return conteudos.replace(",","").replace("[", "").replace("]", "").replace("-", "/");
    }

    public static String getConteudosConcluidos(Dev dev) {
        var conteudos =  dev.getConteudosConcluidos().toString();
        return conteudos.replace(",","").replace("[", "").replace("]", "").replace("-", "/");
    }

}
