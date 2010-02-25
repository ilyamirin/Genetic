package genetic;

import java.util.Random;

public class Gene {
    private Random random = new Random();
    private Integer value;
    
    public void mutate(double probability) {
        if(Math.random() < probability)
            if(random.nextBoolean()) {
                value += random.nextInt(value);
            } else {
                value -= random.nextInt(value);
            }//if else                    
    }//mutate

    public Gene() {
        value = random.nextInt();
    }

    public Gene(Integer n) {
        value = random.nextInt(n);
    }

    public Integer getValue() {
        return value;
    }
    
    @Override
    public String toString() {
        return value.toString();
    }

}
