package genetic.selection;

import genetic.chromosomes.Chromosome;
import genetic.chromosomes.ChromosomesComparator;
import java.util.Collections;
import java.util.List;

public class RangeStrategy implements ISelectionStrategy {

    public void select(List<Chromosome> chromosomes, int limit) {        
        Collections.sort(chromosomes, new ChromosomesComparator());
        for(int i = 0; i < limit; i++)
            chromosomes.remove(i);        
    }//selectAndCross

}
