package genetic.genes;

import java.util.Random;

public class Gene {
    private Random random = new Random();
    private Integer value;

    //TODO: починиить мутацию
    public void mutate(double probability) {
        /*
        System.out.print(this.getValue());
        if(Math.random() < probability) 
            if(Math.random() < 0.5) {
                value += random.nextInt(Math.abs(value)+1);
            } else {
                value -= random.nextInt(Math.abs(value)+1);
            }//else if
        System.out.println(" "+this.getValue());
         */
    }//mutate

    public Gene() {
        value = random.nextInt();
    }

    public Gene(int max) {
        value = random.nextInt(max);
    }

    public Integer getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return value.toString();
    }

}
