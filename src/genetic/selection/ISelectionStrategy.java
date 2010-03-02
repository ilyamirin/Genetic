package genetic.selection;

import genetic.chromosomes.Chromosome;
import java.util.List;

public interface ISelectionStrategy {
    public void select(List<Chromosome> chromosomes, int limit);
}
