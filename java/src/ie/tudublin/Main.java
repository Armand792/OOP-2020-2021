package ie.tudublin;

public class Main
{
    public static void main(String[] args)
    {
 
        Cat ginger = new Cat ("Ginger");

        
        ginger.setLives(9);
        ginger.kill();

        for (int i = 0; i < 8; i++) {
            ginger.kill();
          }
          
    }

} 