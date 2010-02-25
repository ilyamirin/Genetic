package genetic;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class Chromosome {
    private List<Gene> gens = new ArrayList<Gene>();
    private Random random = new Random();

    public List<Integer> getvalues() {
        List<Integer> result = new ArrayList<Integer>();
        for (Iterator<Gene> it = gens.iterator(); it.hasNext();) 
            result.add(it.next().getValue());
        return result;
    }//getvalues

    private void mutate(double propability) {
        for (Iterator<Gene> it = gens.iterator(); it.hasNext();) 
            it.next().mutate(propability);
    }//mutate

    public Chromosome(int gens) {
        for (int i = 0; i < gens; i++)
            this.gens.add(new Gene());
    }

    public Chromosome(int gens, int maxGeneValue) {
        for (int i = 0; i < gens; i++)
            this.gens.add(new Gene(maxGeneValue));
    }
    
    public void print(){
        for (Iterator<Gene> it = gens.iterator(); it.hasNext();)
            System.out.println(it.next().toString());
    }//print

}
