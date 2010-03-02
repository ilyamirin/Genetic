package genetic;

import genetic.chromosomes.Chromosome;
import genetic.selection.ISelectionStrategy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

//TODO: добавить печать генетики в формате XML
public class Genetic {
    private double mutation = 0.1;
    private int limit;
    private ArrayList<Chromosome> chromosomes = new ArrayList();
    private ISelectionStrategy selectionStrategy;

    public void mutate() {
        for (Iterator<Chromosome> it = chromosomes.iterator(); it.hasNext();)
            it.next().mutate(mutation);
    }//mutate

    public void cross () {
        Collections.shuffle(chromosomes);
        for(int i = 0; i < limit; i++)
            chromosomes.add(chromosomes.get(i).cross(chromosomes.get(i+1)));
        chromosomes.add(chromosomes.get(limit).cross(chromosomes.get(0)));
    }//cross

    public void select() {
        selectionStrategy.select(chromosomes, limit);
    }//select

    public void setFitnesses(IGetFitnessObject getFitnessObject) {
        for (Iterator<Chromosome> it = chromosomes.iterator(); it.hasNext();) {
            Chromosome chromosome = it.next();
            chromosome.setFitness(getFitnessObject
                    .getFitness(chromosome.getValues()));
        }//for
    }//getFitnesses

    public Genetic(int chromosomes, int genes,
            ISelectionStrategy selectionStrategy) {
        for (int i = 0; i < chromosomes; i++)
            this.chromosomes.add(new Chromosome(genes));
        this.selectionStrategy = selectionStrategy;
    }//constructor

    public Genetic(int chromosomes, int genes, int maxGeneValue,
            ISelectionStrategy selectionStrategy) {
        for (int i = 0; i < chromosomes; i++)
            this.chromosomes.add(new Chromosome(genes, maxGeneValue));
        this.selectionStrategy = selectionStrategy;
    }//constructor

    public ISelectionStrategy getSelectionStrategy() {
        return selectionStrategy;
    }

    public void setSelectionStrategy(ISelectionStrategy selectionStrategy) {
        this.selectionStrategy = selectionStrategy;
    }

}
