package genetic.selection;

import genetic.chromosomes.Chromosome;
import genetic.chromosomes.ChromosomesComparator;
import java.util.Collections;
import java.util.List;

public class RangeStrategy implements ISelectionStrategy {

    public void select(List<Chromosome> chromosomes, int limit) {
        limit = (int) (0.5 * chromosomes.size());
        Collections.sort(chromosomes, new ChromosomesComparator());
        for(int i = limit; i < chromosomes.size(); i++)
            chromosomes.remove(i);
    }//selectAndCross

}
