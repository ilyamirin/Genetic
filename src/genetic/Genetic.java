package genetic;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import genetic.chromosomes.Chromosome;
import genetic.selection.ISelectionStrategy;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

//TODO: добавить печать генетики в формате XML
public class Genetic {

    @XStreamAsAttribute
    private double mutation = 0.01;

    @XStreamAsAttribute
    private int limit;
    @XStreamAsAttribute
    private int population;

    private ArrayList<Chromosome> chromosomes = new ArrayList();

    @XStreamAsAttribute
    private ISelectionStrategy selectionStrategy;

    public void mutate() {
        for (Iterator<Chromosome> it = chromosomes.iterator(); it.hasNext();)
            it.next().mutate(mutation);
    }//mutate

    public void cross () {
        Collections.shuffle(chromosomes);
        for(int i = 0; chromosomes.size() < population; i++)
            chromosomes.add(chromosomes.get(i).cross(chromosomes.get(i+1)));
        //chromosomes.add(chromosomes.get(limit).cross(chromosomes.get(0)));
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
    
    public Chromosome getBest() {
        Chromosome theBest = chromosomes.get(0);
        for (Iterator<Chromosome> it = chromosomes.iterator(); it.hasNext();) {
            Chromosome chromosome = it.next();
            if(theBest.compare(chromosome) == -1) theBest = chromosome; 
        }
        return theBest;
    }
    
    public Chromosome run(IGetFitnessObject getFitnessObject,
            int steps) {
        setFitnesses(getFitnessObject);
        for (int i = 0; i < steps; i++) {                        
            select();
            cross();
            mutate();            
            setFitnesses(getFitnessObject);
            Chromosome best = getBest();
            if(best.getFitness() == Integer.MAX_VALUE) return best;
        }
        return getBest();
    }

    public Genetic() {
    }

    public Genetic(int chromosomes, int genes, int maxGeneValue,
            int populationLimit, ISelectionStrategy selectionStrategy) {
        for (int i = 0; i < chromosomes; i++)
            this.chromosomes.add(new Chromosome(genes, maxGeneValue));
        this.selectionStrategy = selectionStrategy;
        this.population = chromosomes;
        this.limit = populationLimit;
    }//constructor

    public ISelectionStrategy getSelectionStrategy() {
        return selectionStrategy;
    }

    public void setSelectionStrategy(ISelectionStrategy selectionStrategy) {
        this.selectionStrategy = selectionStrategy;
    }

    @Override
    public String toString() {
        XStream xstream = new XStream();
        xstream.autodetectAnnotations(true);
        return xstream.toXML(this);
    }
}
