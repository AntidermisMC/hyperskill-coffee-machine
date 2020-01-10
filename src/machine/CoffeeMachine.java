package machine;

import java.util.Scanner;

public class CoffeeMachine {

    static void MakeCoffee(){
        System.out.println("Starting to make a coffee\n" +
                "Grinding coffee beans\n" +
                "Boiling water\n" +
                "Mixing boiled water with crushed coffee beans\n" +
                "Pouring coffee into the cup\n" +
                "Pouring some milk into the cup\n" +
                "Coffee is ready!");
    }

    static int GetMilkRequired(int n){
        return 50 * n;
    }

    static int GetWaterRequired(int n){
        return 200 * n;
    }

    static int GetCoffeeRequired(int n){
        return 15 * n;
    }

    static void PrintAmounts(int n){
        System.out.println(GetWaterRequired(n) + " ml of water");
        System.out.println(GetMilkRequired(n) + " ml of milk");
        System.out.println(GetCoffeeRequired(n) + " g of coffee beans");
    }

    static void CalculateQuantities(Scanner scanner){
        System.out.println("Write how many cups of coffee you will need:");
        int n = scanner.nextInt();
        PrintAmounts(n);
    }

    static int GetAvailableWater(Scanner scanner){
        System.out.println("Write how many ml of water the coffee machine has:");
        return scanner.nextInt();
    }

    static int GetAvailableMilk(Scanner scanner){
        System.out.println("Write how many ml of milk the coffee machine has:");
        return scanner.nextInt();
    }

    static int GetAvailableCoffee(Scanner scanner){
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        return scanner.nextInt();
    }

    static int GetCoffeesNeeded(Scanner scanner){
        System.out.println("Write how many cups of coffee you will need:");
        return scanner.nextInt();
    }

    static void CheckAvailability(Scanner scanner){
        int water = GetAvailableWater(scanner);
        int milk = GetAvailableMilk(scanner);
        int coffee = GetAvailableCoffee(scanner);
        int cups = GetCoffeesNeeded(scanner);
        int maxCups = Math.min(water / 200, Math.min(milk / 50, coffee / 15));
        if (cups > maxCups){
            System.out.println("No, I can make only " + maxCups + " cup(s) of coffee");
        }
        else {
            System.out.print("Yes, I can make that amount of coffee");
            if (maxCups > cups){
                System.out.println(" (and even " + (maxCups - cups) + " more than that)");
            }
        }
    }

    static Scanner scanner = new Scanner(System.in);
    static int money = 550;
    static int water = 400;
    static int milk = 540;
    static int coffee = 120;
    static int cups = 9;

    static void PrintStats(){
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffee + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println("$" + money + " of money");
    }

    static void Buy(){
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String s = scanner.next();
        if (cups == 0){
            System.out.println("Sorry, not enough cups!");
        }
        switch (s){
            case "1":
                if (water < 250){
                    System.out.println("Sorry, not enough water!");
                    return;
                }
                if (coffee < 16){
                    System.out.println("Sorry, not enough coffee!");
                    return;
                }
                water -= 250;
                coffee -= 16;
                money += 4;
                break;
            case "2":
                if (water < 350){
                    System.out.println("Sorry, not enough water!");
                    return;
                }
                if (milk < 75){
                    System.out.println("Sorry, not enough milk!");
                }
                if (coffee < 20){
                    System.out.println("Sorry, not enough coffee!");
                    return;
                }
                water -= 350;
                milk -= 75;
                coffee -= 20;
                money += 7;
                break;
            case "3":
                if (water < 200){
                    System.out.println("Sorry, not enough water!");
                    return;
                }
                if (milk < 100){
                    System.out.println("Sorry, not enough milk!");
                }
                if (coffee < 12){
                    System.out.println("Sorry, not enough coffee!");
                    return;
                }
                water -= 200;
                milk -= 100;
                coffee -= 12;
                money += 6;
                break;
            case "back":
                return;
        }
        cups--;
        System.out.println("I have enough resources, making you a coffee!");
    }

    static void Fill(){
        System.out.println("Write how many ml of water do you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        coffee += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add:");
        cups += scanner.nextInt();
    }

    static void Take(){
        System.out.println("I gave you $" + money);
        money = 0;
    }

    static boolean GetAction(){
        System.out.println("\nWrite action (buy, fill, take, remaining, exit):");
        String s = scanner.next();
        System.out.println();
        switch (s){
            case "buy":
                Buy();
                break;
            case "fill":
                Fill();
                break;
            case "take":
                Take();
                break;
            case "exit":
                return true;
            default:
                break;
        }
        PrintStats();
        return false;
    }

    public static void main(String[] args) {
        boolean exit;
        do {
            exit = GetAction();
        } while (!exit);
    }
}
