import java.text.NumberFormat;

public class Customer
{
    private String custName;
    private FootballShop[] itemList = new FootballShop[1];
    private int numOfItems;
    private double totalPay;

    //? Constructor
    public Customer(String custName)
    {
        this.custName = custName;
    }

    //? Getters
    public String getName()
    {
        return custName;
    }
    public double getTotalPay()
    {
        return totalPay;
    }
    public int getNumOfItems()
    {
        return numOfItems;
    }

    public void buy(FootballShop item)
    {
        itemList[numOfItems] = item;
        numOfItems++;

        //? Update number of football items' in the arrayList
        FootballShop[] temp = new FootballShop[itemList.length + 1];
        for(int i=0 ; i<itemList.length ; i++)
        {
            temp[i] = itemList[i];
        }
        itemList = temp;

        System.out.println("Item " + getNumOfItems());
        item.display();

        totalPay += item.calcPrice();
    }
    public String toString()
    {
        return "Welcome " + getName() + "\n\n" + "List of Football Items Bought\n";
    }
    public void print()
    {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        System.out.println("Total = " + fmt.format(getTotalPay()));
    }
}
