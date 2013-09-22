package coding;

public class TheArithmeticProgression {
    public double minimumChange(int a, int b, int c) {
        double d1=Math.abs(2*b-a-c);
         d1/=2;
        return d1;
    }
}
