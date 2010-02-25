package genetic;

import java.util.ArrayList;
import java.util.Iterator;

public class Chromosome {
    private Integer fitness = 0;
    private ArrayList<Gene> genes = new ArrayList<Gene>();

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> result = new ArrayList<Integer>();
        for (Iterator<Gene> it = genes.iterator(); it.hasNext();)
            result.add(it.next().getValue());
        return result;
    }//getvalues

    public void mutate(double probability) {
        for (Iterator<Gene> it = genes.iterator(); it.hasNext();)
            it.next().mutate(probability);
    }//mutate

    public Chromosome(int genes) {
        for (int i = 0; i < genes; i++)
            this.genes.add(new Gene());
    }

    public Chromosome(int gens, int maxGeneValue) {
        for (int i = 0; i < gens; i++)
            this.genes.add(new Gene(maxGeneValue));
    }

    public Gene getGene(int geneNumber) {
        return genes.get(geneNumber);
    }

    public void setGene(int geneNumber, Gene gene) {
        genes.add(geneNumber, gene);
    }

    public Integer getFitness() {
        return fitness;
    }

    public void setFitness(Integer fitness) {
        this.fitness = fitness;
    }

    public void print(){
        for (Iterator<Gene> it = genes.iterator(); it.hasNext();)
            System.out.println(it.next().toString());
    }//print

}
