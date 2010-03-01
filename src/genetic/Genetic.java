package genetic;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Genetic {
    private double mutation = 0.1;
    private int limit;
    private ArrayList<Chromosome> chromosomes = new ArrayList();

    public void mutate() {
        for (Iterator<Chromosome> it = chromosomes.iterator(); it.hasNext();)
            it.next().mutate(mutation);
    }//mutate

    public void cross() {

    }

    public void select() {
        limit = (int) (0.5 * chromosomes.size()) + 1;
        Collections.sort(chromosomes, new ChromosomesComparator());
        for(int i = limit; i < chromosomes.size(); i++)
            chromosomes.remove(i);
    }//select

    public void setFitnesses(IGetFitnessObject getFitnessObject) {
        for (Iterator<Chromosome> it = chromosomes.iterator(); it.hasNext();) {
            Chromosome chromosome = it.next();
            chromosome.setFitness(getFitnessObject
                    .getFitness(chromosome.getValues()));
        }//for
    }//getFitnesses

    public Genetic(int chromosomes, int genes) {
        for (int i = 0; i < chromosomes; i++)
            this.chromosomes.add(new Chromosome(genes));
    }//constructor

    public Genetic(int chromosomes, int genes, int maxGeneValue) {
        for (int i = 0; i < chromosomes; i++)
            this.chromosomes.add(new Chromosome(genes, maxGeneValue));
    }//constructor

}
