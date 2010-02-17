package genetic;

public class Gene {
    //value storing in Gray code, translated to int as binmary
    private int value;

    public void setValue(int value){
        this.value = (value >> 1) ^ value;
    }

    public int getValue(){
        return this.value;
    }

    private Gene(){
    }

    public Gene(int value){
        setValue(value);
    }

}
