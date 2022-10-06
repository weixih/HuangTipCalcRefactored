import java.util.Scanner;
import java.text.DecimalFormat;

public class TipCalculatorRunner {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DecimalFormat formatter = new DecimalFormat("#.##");

        System.out.println("Welcome to a tip calculator");

        //getting info
        System.out.print("Enter amount of people: ");
        int people = scan.nextInt();
        scan.nextLine();

        System.out.print("Enter the tip percentage without the percent sign: ");
        int percentage = scan.nextInt();
        scan.nextLine();
        //no negative tip percentage
        while (percentage < 0) {
            System.out.println("A tip percentage can not be negative.");
            System.out.print("Enter the tip percentage without the percent sign: ");
            percentage = scan.nextInt();
            scan.nextLine();
        }

        TipCalculator tipCalc = new TipCalculator(people, percentage);

        //adding the costs
        double adding = 0;
        while (adding != -1) {
            tipCalc.addMeal(adding);
            System.out.print("Enter a cost in dollars and cents (-1 to end): ");
            adding = scan.nextDouble();
            scan.nextLine();
            //no negative costs
            if((adding <0) && (adding != -1)) {
                System.out.println("The costs can not be negative.");
                System.out.print("Enter a cost in dollars and cents (-1 to end): ");
                adding = scan.nextDouble();
                scan.nextLine();
            }

        }

        //math
        double billBeforeTip = tipCalc.getTotalBillBeforeTip();
        double tip = tipCalc.tipAmount();
        double totalBill = tipCalc.totalBill();
        double costPerPerson = tipCalc.perPersonCostBeforeTIp();
        double tipPerPerson = tipCalc.perPersonTipAmount();
        double totalCostPerPerson = tipCalc.perPersonTotalCost();



        //print
        System.out.println("------------------------------------");
        System.out.println("Total bill before tip: $" + formatter.format(billBeforeTip));
        System.out.println("Tip percentage: "+ tipCalc.getTipPercentage()+"%");
        System.out.println("Total tip: $" + formatter.format (tip));
        System.out.println("Total bill with tip: $"+formatter.format(totalBill));
        System.out.println("Per person cost before tip: $"+formatter.format(costPerPerson));
        System.out.println("Tip per person: $"+formatter.format(tipPerPerson));
        System.out.println("Total cost per person: $"+formatter.format(totalCostPerPerson));

    }

}