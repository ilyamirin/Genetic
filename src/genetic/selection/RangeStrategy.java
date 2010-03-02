package genetic.selection;

import genetic.chromosomes.Chromosome;
import genetic.chromosomes.ChromosomesComparator;
import java.util.Collections;
import java.util.List;

public class RangeStrategy implements ISelectionStrategy {

    public void selectAndCross(List<Chromosome> chromosomes, int limit) {
        limit = (int) (0.5 * chromosomes.size());
        Collections.sort(chromosomes, new ChromosomesComparator());
        for(int i = limit; i < chromosomes.size(); i++)
            chromosomes.remove(i);
        Collections.shuffle(chromosomes);
        for(int i = 0; i < limit; i++) 
            chromosomes.add(chromosomes.get(i).cross(chromosomes.get(i+1)));        
        chromosomes.add(chromosomes.get(limit).cross(chromosomes.get(0)));
    }//selectAndCross

}
