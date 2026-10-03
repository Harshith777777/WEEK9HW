import java.util.*;

abstract class Parcel {
    double weight;
    double declaredValue;

    Parcel(double weight, double declaredValue) {
        this.weight = weight;
        this.declaredValue = declaredValue;
    }

    abstract double getCharge();

    double getInsurance() {
        return 0;
    }

    abstract String getType();

    double getTotal() {
        return getCharge() + getInsurance();
    }
}

class Standard extends Parcel {
    Standard(double weight, double value) {
        super(weight, value);
    }

    double getCharge() {
        return 40 + 10 * weight;
    }

    String getType() {
        return "STANDARD";
    }
}

class Express extends Parcel {
    Express(double weight, double value) {
        super(weight, value);
    }

    double getCharge() {
        return 80 + 15 * weight;
    }

    double getInsurance() {
        return declaredValue * 0.02;
    }

    String getType() {
        return "EXPRESS";
    }
}

class Fragile extends Parcel {
    Fragile(double weight, double value) {
        super(weight, value);
    }

    double getCharge() {
        return 40 + 10 * weight + 50;
    }

    double getInsurance() {
        return declaredValue * 0.02;
    }

    String getType() {
        return "FRAGILE";
    }
}

public class week9q2hw {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Parcel[] parcels = new Parcel[n];

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();

            if (type.equals("STANDARD")) {
                parcels[i] = new Standard(weight, value);
            } else if (type.equals("EXPRESS")) {
                parcels[i] = new Express(weight, value);
            } else {
                parcels[i] = new Fragile(weight, value);
            }
        }

        double grandTotal = 0;

        for (Parcel p : parcels) {
            double charge = p.getCharge();
            double insurance = p.getInsurance();
            double total = p.getTotal();

            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    p.getType(), charge, insurance, total);

            grandTotal += total;
        }

        System.out.printf("Grand Total: %.2f%n", grandTotal);
    }
}