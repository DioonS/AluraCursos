import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Curso {
    private String nome;
    private String instrutor;
    private List<Aula> aulas = new ArrayList<Aula>();

    public Curso(String nome) {
        this.nome = nome;
        this.instrutor = instrutor;
        this.aulas = aulas;
    }

    public List<Aula> getAulas() {
        return Collections.unmodifiableList(aulas);
    }

    public String getNome() {
        return nome;
    }

    public String getInstrutor() {
        return instrutor;
    }

    public void adiciona (Aula aula) {
        this.aulas.add(aula);
    }

    /*public int getTempoTotal() {
        int tempoTotal = 0;
        for (Aula aula: aulas) {
            tempoTotal += aula.getTempo();
        }
        return tempoTotal;
    }*/

    public int getTempoTotal() {
        return this.aulas.stream().mapToInt(Aula::getTempo).sum();
    }

    @Override
    public String toString() {
        return "[Curso:"+ this.getNome()+",tempo total:"+ this.getTempoTotal()+ ", aulas: ["+ this.aulas+"] ]";
    }
}
