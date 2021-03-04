import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

interface Temperature{
    public double getCelsius();
    public double getFahrenheit();
    public void setCelsius(double celsius);
    public void setFahrenheit(double fahrenheit);
}
public class Main implements Temperature{
    double c;
    double f;

    final static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    final static StringTokenizer st = null;

    public static void main(String[] args) throws IOException {

        String input = br.readLine();
        int N = Integer.parseInt(input);
        for(int i=0;i<N;i++){
            Main m1 = new Main();
            input = br.readLine();
            String[] inputList = input.split(" ");
            if(inputList[1].equals("C")){
                m1.setCelsius(Double.parseDouble(inputList[0]));
                System.out.println(m1.getFahrenheit());
            }else if(inputList[1].equals("F")){
                m1.setFahrenheit(Double.parseDouble(inputList[0]));
                System.out.println(m1.getCelsius());
            }
        }
    }

    @Override
    public double getCelsius() {
        return this.c;
    }

    @Override
    public double getFahrenheit() {
        return this.f;
    }

    @Override
    public void setCelsius(double celsius) {
        double c = celsius;
        this.f = Math.round(((c*9)/5+32)*100)/100.0;
        //c -> f
    }

    @Override
    public void setFahrenheit(double fahrenheit) {
        double f = fahrenheit;
        this.c = Math.round(((f-32)*5/9)*100)/100.0;
    }
}
