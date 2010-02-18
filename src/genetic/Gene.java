package genetic;

import java.util.Random;

public class Gene {
    //TODO: сделать обработку отрицательных значений
    
    private Random randomizer;
    private int value;//value in Gray code store in int as binmary

    public void setValue(int value) {
        this.value = (value >> 1) ^ value;
    }

    public int getValue() {
        return (this.value >> 1) ^ this.value ;
    }

    //TODO: сделать возможность подключения разных стратегий мутации
    public void mutate(double possibility) {
        this.value >>= 1;
        //if( Math.random() < possibility ) this.value = randomizer.nextInt();
    }

    public Gene(int value) {
        setValue(value);
    }

    public Gene() {
        randomizer = new Random(10);
        this.value = randomizer.nextInt();
    }

}
