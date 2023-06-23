import java.text.NumberFormat;

public class Boots extends FootballShop implements DiscConsiderable
{
    public int size;

    //? Constructors
    public Boots() {}
    public Boots(String brand , double price , int quantity , int size)
    {
        super(brand , price , quantity);
        this.size = size;
    }

    @Override
    public void display()
    {
        NumberFormat f = NumberFormat.getPercentInstance();
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        System.out.println( "SOCCER BOOTS" + "\nBrand: " + getBrand() + "\nprice: " + fmt.format(getPrice()) + " for size " + size
                + "\nDiscount: " + f.format(RATE) + "\nQuantity: " + getQuantity() + "\nSubtotal: " + fmt.format(calcPrice()) + "\n" );
    }

    @Override
    public double calcPrice()
    {
        return calcDisc() * getQuantity();
    }

    @Override
    public double calcDisc()
    {
        return getPrice() * (1 - RATE);
    }
}
