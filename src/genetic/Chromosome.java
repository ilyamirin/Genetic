package genetic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Chromosome {
    private Random randomizator;
    private List<Gene> gens;

    private Chromosome(){
    }

    public Chromosome(int genNum){
        //TODO: сделать задаваемый диапазон значений
        randomizator = new Random();

        gens = new ArrayList<Gene>();

        while(genNum > 0){
            gens.add(new Gene(randomizator.nextInt(100)));
            genNum--;

        }//while

    }//constructor

    @Override
    public String toString(){
        //TODO: написать метод, печатающий в консоли гены 
        return null;
    }

}
