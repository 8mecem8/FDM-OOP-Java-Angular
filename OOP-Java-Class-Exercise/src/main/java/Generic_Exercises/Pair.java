package Generic_Exercises;

public class Pair<T1, T2> 
{
    private T1 first;
    private T2 second;

    
    public Pair(T1 first, T2 second) //Constructor 
    {
        this.first = first;
        this.second = second;
    }

    public T1 getFirst() {return first;}
    public void setFirst(T1 first) {this.first = first;}

    public T2 getSecond() {return second;}
    public void setSecond(T2 second) {this.second = second;}

    @Override
    public String toString() {return "Pair{" +"first=" + first +", second=" + second +'}';}

    public static void main(String[] args) 
    {
        Pair<String, Integer> pair = new Pair<>("Age", 30);
        
        System.out.println(pair); // Output: Pair{first=Age, second=30}

        pair.setFirst("Height");pair.setSecond(180);
        System.out.println(pair); // Output: Pair{first=Height, second=180}
    }
}
