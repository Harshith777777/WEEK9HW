import java.util.*;

abstract class Appliance {
    double hours;
    double power;

    Appliance(double hours, double power) {
        this.hours = hours;
        this.power = power;
    }

    double getUnits() {
        return power * hours / 1000;
    }

    double getCost() {
        return getUnits() * 8;
    }

    boolean supportsSaver() {
        return false;
    }

    double getSaverUnits() {
        return getUnits() * 0.75;
    }

    abstract String getName();
}

class Fridge extends Appliance {
    Fridge(double hours) {
        super(hours, 150);
    }

    String getName() {
        return "FRIDGE";
    }
}

class AC extends Appliance {
    AC(double hours) {
        super(hours, 1500);
    }

    boolean supportsSaver() {
        return true;
    }

    String getName() {
        return "AC";
    }
}

class TV extends Appliance {
    TV(double hours) {
        super(hours, 100);
    }

    String getName() {
        return "TV";
    }
}

class Washer extends Appliance {
    Washer(double hours) {
        super(hours, 500);
    }

    boolean supportsSaver() {
        return true;
    }

    String getName() {
        return "WASHER";
    }
}

public class week9q5hw {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double hours = sc.nextDouble();

            boolean saver = false;

            if (sc.hasNext()) {
                String next = sc.nextLine().trim();
                if (next.equals("SAVER")) {
                    saver = true;
                }
            }

            Appliance appliance;

            if (type.equals("FRIDGE")) {
                appliance = new Fridge(hours);
            } else if (type.equals("AC")) {
                appliance = new AC(hours);
            } else if (type.equals("TV")) {
                appliance = new TV(hours);
            } else {
                appliance = new Washer(hours);
            }

            if (saver && !appliance.supportsSaver()) {
                System.out.println(type + ": saver mode not supported");
            } else {
                double units;

                if (saver) {
                    units = appliance.getSaverUnits();
                } else {
                    units = appliance.getUnits();
                }

                double cost = units * 8;

                System.out.printf("%s: Units=%.2f Cost=%.2f%n",
                        type, units, cost);

                total += cost;
            }
        }

        System.out.printf("Total Cost: %.2f%n", total);
    }
}