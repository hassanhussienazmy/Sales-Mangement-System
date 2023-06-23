import java.text.NumberFormat;

public class SoccerBall extends FootballShop
{
    private int ballType;

    //?Constructors
    public SoccerBall() {}
    public SoccerBall(String brand , double price , int quantity , int ballType)
    {
        super(brand , price , quantity);
        this.ballType = ballType;
    }

    @Override
    public void display()
    {
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        NotBallTypeException problem = new NotBallTypeException(ballType + " Not a valid soccer ball type, Changing the soccer ball type to training ball\n");
        System.out.println("SOCCER BALL" + "\nBrand: " + getBrand());
        try
        {
            if(ballType < 1 || ballType > 4)
            {
                throw problem;
            }

            setPrice( ballType == 1 ? 200 : ballType == 2 ? 80 : ballType == 3 ? 50 : 20 );
            System.out.println( "Type: " + (ballType == 1 ? "Professional Match" : ballType == 2 ? "Match" : ballType == 3 ? "Training" : "Recreational")
                + "\nPrice: " + fmt.format(getPrice()) + "\nNo Discount!" + "\nQuantity: " + getQuantity() + "\nSubtotal: " + fmt.format(calcPrice()) + "\n" );
        }
        catch(NotBallTypeException nbte)
        {
            System.out.println(problem.getMessage());
            ballType = 3;
            display();
        }
    }

    @Override
    public double calcPrice()
    {
        return getPrice() * getQuantity();
    }
}
