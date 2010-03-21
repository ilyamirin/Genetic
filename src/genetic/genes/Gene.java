package genetic.genes;

import java.util.Random;

public class Gene {
    private Random random = new Random();
    private Integer value;
    private Integer capasity;

    //TODO: починиить мутацию
    //TODO: посмотреть как работает мутация для отрицательных чисел
    public void mutate(double probability) {
        //System.out.print(value+" ");
        for(int i = 0; i < capasity; i++)
            if(Math.random() < probability)
                value ^= (int) Math.pow(2, i);
        //System.out.println(value);
    }//mutate

    public Gene() {
        value = null;
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
    
    @Override
    public String toString() {
        return value.toString();
    }

}
