import java.util.*;

abstract class Cab {
    double km;

    Cab(double km) {
        this.km = km;
    }

    abstract double getRate();

    boolean hasNightService() {
        return false;
    }

    double getFare() {
        double fare = km * getRate();

        if (fare < 100) {
            fare = 100;
        }

        return fare;
    }

    double getNightFare() {
        return getFare() * 1.20;
    }

    abstract String getCabType();
}

class Mini extends Cab {
    Mini(double km) {
        super(km);
    }

    double getRate() {
        return 10;
    }

    String getCabType() {
        return "MINI";
    }
}

class Sedan extends Cab {
    Sedan(double km) {
        super(km);
    }

    double getRate() {
        return 14;
    }

    boolean hasNightService() {
        return true;
    }

    String getCabType() {
        return "SEDAN";
    }
}

class SUV extends Cab {
    SUV(double km) {
        super(km);
    }

    double getRate() {
        return 18;
    }

    boolean hasNightService() {
        return true;
    }

    String getCabType() {
        return "SUV";
    }
}

public class week9q4hw {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab cab;

            if (type.equals("MINI")) {
                cab = new Mini(km);
            } else if (type.equals("SEDAN")) {
                cab = new Sedan(km);
            } else {
                cab = new SUV(km);
            }

            if (time.equals("NIGHT") && !cab.hasNightService()) {
                System.out.println(type + ": night service not available");
            } else {
                double fare;

                if (time.equals("NIGHT")) {
                    fare = cab.getNightFare();
                } else {
                    fare = cab.getFare();
                }

                System.out.printf("%s: %.2f%n", type, fare);
                total += fare;
            }
        }

        System.out.printf("Total: %.2f%n", total);
    }
}