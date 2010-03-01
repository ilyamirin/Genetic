package genetic;

import java.util.Random;

public class Gene {
    private Random random = new Random();
    private Integer value;

    //TODO: проангализировать статистически распределение случайных мутаций генов
    public void mutate(double probability) {
        if(Math.random() < probability) 
            if(random.nextBoolean()) {
                value += random.nextInt(Math.abs(value)+1);
            } else {
                value -= random.nextInt(Math.abs(value)+1);
            }//else if
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
