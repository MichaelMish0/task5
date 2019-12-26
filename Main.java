package Task5;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        int starCount;
        int planetCount;


        boolean running = true;

        Scanner input = new Scanner(System.in);
        System.out.print("How Many Stars Do You Want To Create? ");
        starCount = input.nextInt();

        Star stars[] = new Star[starCount];

        for (int i = 0; i < starCount; i++) {
            stars[i] = new Star();

            System.out.print("Input Star " + (i + 1) + " Name: ");
            stars[i].name = input.next();

            System.out.print("Input Star " + stars[i].name + "'s Diameter: ");
            stars[i].diameter = input.nextDouble();

            System.out.print("Input Star " + stars[i].name + "'sTemperature: ");
            stars[i].temperature = input.nextDouble();
            System.out.println("\n");
        }

        System.out.print("How Many Planets Do You Want To Create? ");
        planetCount = input.nextInt();

        Planet planets[] = new Planet[planetCount];

        for (int i = 0; i < planetCount; i++) {
            planets[i] = new Planet();

            System.out.print("Input Planet " + (i + 1) + " Name: ");
            planets[i].name = input.next();

            System.out.print("Input Planet " + planets[i].name + "'s Star Name: ");
            planets[i].starName = input.next();

            System.out.print("Input " + planets[i].name + "'s Distance From Star: ");
            planets[i].distance = input.nextDouble();

            System.out.print("Input " + planets[i].name + "'s Speed: ");
            planets[i].speed = input.nextDouble();
        }

        while(running) {
            String search;

            System.out.println("\nSearch For Planet Information By It's Name\n" +
                    "(For Full Information Of Galaxy Input 'f' 'q' To Quit): ");
            search = input.next();

            if (search.equals("q")) {
                running = false;
            }
            else if (search.equals("f")) {

                for(int i = 0; i < starCount; i ++) {
                    stars[i].getInfo();

                    for (int j = 0; j < planetCount; j++) {
                        if (planets[j].starName.equals(stars[i].name)) {
                            planets[j].getInfo();
                            System.out.println("Time Needed For Full Cycle: " + getTime(planets[j].distance, planets[j].speed));
                        }
                    }
                }
            }
            else {
                int is = 0;
                for (int i = 0; i < planetCount; i++) {
                    if (planets[i].name.equals(search)) {
                        planets[i].getInfo();
                        System.out.println("Time Needed For Full Cycle: " + getTime(planets[i].distance, planets[i].speed));
                        is++;
                    }
                }
                if (is == 0) {
                    System.out.println("The Planet You Searched For Is Not In This Galaxy");
                }
            }
        }
    }

    public static double getTime(double distance, double speed) {
        double c = 2 * distance * 3.14;
        double time = c / speed;

        return time;
    }
}
