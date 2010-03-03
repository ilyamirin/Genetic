package genetic.selection;

import genetic.chromosomes.Chromosome;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TurnirStrategy implements ISelectionStrategy {

    //TODO: оптимизировать
    public void select(List<Chromosome> chromosomes, int limit) {
        Collections.shuffle(chromosomes);
        List<Chromosome> result = new ArrayList<Chromosome>();
        for(int i = 0; i < limit; i += 2) {
            switch(chromosomes.get(i).compare(chromosomes.get(i+1))) {
                case 1:
                    result.add(chromosomes.get(i));
                    break;
                case 0:
                    result.add(chromosomes.get(i));
                    break;
                case -1:
                    result.add(chromosomes.get(i+1));
                    break;
            }//switch
        }//for
        chromosomes = result;
    }//select

}
