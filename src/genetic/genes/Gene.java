package genetic.genes;

import java.util.Random;

public class Gene {
    private Random random = new Random();
    private Integer value;
    private Integer capasity;
    
    //TODO: посмотреть как работает мутация для отрицательных чисел
    public void mutate(double probability) {        
        for(int i = 0; i < capasity; i++)
            if(Math.random() < probability)
                value ^= (int) Math.pow(2, i);        
    }//mutate

    public Gene() {
    }

    public Gene(int max) {
        value = random.nextInt(max);
        capasity = 1;
        int pointer = Math.abs(value);
        while(pointer >= 2) {
            pointer /= 2;
            capasity++;
        }        
    }

    public Integer getValue() {
        return value;
    }
    

}
