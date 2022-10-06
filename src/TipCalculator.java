public class TipCalculator {
    private int numPeople;
    private int tipPercentage;
    private double totalBillBeforeTip;

    //constructor
    public TipCalculator (int numPeople, int tipPercentage){
        this.numPeople = numPeople;
        this.tipPercentage = tipPercentage;
        totalBillBeforeTip = 0.0;
    }

    //methods
    public double getTotalBillBeforeTip(){
        return totalBillBeforeTip;
    }
    public int getTipPercentage(){
        return tipPercentage;
    }
    public void addMeal(double cost){
        totalBillBeforeTip += cost;
    }
    public double tipAmount(){
        return totalBillBeforeTip * tipPercentage/100.0;
    }
    public double totalBill(){
        return tipAmount() + totalBillBeforeTip;
    }
    public double perPersonCostBeforeTIp(){
        return totalBillBeforeTip/numPeople;
    }
    public double perPersonTipAmount(){
        return tipAmount()/numPeople;
    }
    public double perPersonTotalCost(){
        return totalBill()/numPeople;
    }
}