import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

interface Temperature {
    public double getCelsius();
    public double getFahrenheit();
    public void setCelsius(double celsius);
    public void setFahrenheit(double fahrenheit);
}

class Thermometer implements Temperature{
    double celcius, farenhiet;

    @Override
    public double getCelsius() {
        return Math.round(this.celcius * 100) / 100.0;
    }

    @Override
    public double getFahrenheit() {
        return Math.round(this.farenhiet * 100) / 100.0;
    }

    @Override
    public void setCelsius(double celsius) {
        this.celcius = celsius;
        this.farenhiet = celsius * 1.8 + 32;
    }

    @Override
    public void setFahrenheit(double fahrenheit) {
        this.farenhiet = fahrenheit;
        this.celcius = (fahrenheit - 32) / 1.8;
    }
}

public class celcius_to_farenheit{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n;
        n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine(), " ");

            double temperture = Double.parseDouble(st.nextToken());
            String temp = st.nextToken();

            Thermometer thermometer = new Thermometer();
            if (temp.equals("C")){
                thermometer.setCelsius(temperture);
                System.out.println(thermometer.getFahrenheit());
            }else {
                thermometer.setFahrenheit(temperture);
                System.out.println(thermometer.getCelsius());
            }
        }
    }
}
