package genetic;

import java.util.Comparator;

public class ChromosomesComparator implements Comparator<Chromosome> {
    public int compare(Chromosome ch1, Chromosome ch2) {
        return ch1.getFitness().compareTo(ch2.getFitness());
    }
}
