import java.util.*;

public class TestaAlunos {
    public static void main(String[] args) {
        Set<String> alunos = new HashSet<>();
        alunos.add("Diego Silva");
        alunos.add("Ana Caroline");
        alunos.add("Nico Steppat");
        alunos.add("Sammy Winchester");
        alunos.add("Edson Lobo");
        alunos.add("Antonio Marcos");

        boolean diegoEstaMatriculado = alunos.contains("Diego Silva");
        alunos.remove("Edson Lobo");
        System.out.println(diegoEstaMatriculado);

        System.out.println(alunos.size());

        for (String aluno : alunos) {
            System.out.println(aluno);
        }

        alunos.forEach(aluno -> {
            System.out.println(aluno);
        });

        System.out.println(alunos);

        List<String> alunosEmLista = new ArrayList<>(alunos);
        System.out.println(alunos);
    }
}
