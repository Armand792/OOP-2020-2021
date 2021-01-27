package ie.tudublin;

import javax.lang.model.util.ElementScanner14;

public class Cat extends Animal
{
    public Cat(String name)
    {
        super(name);
    }

    private int numLives;


    public void setLives(int numLives)
    {
        this.numLives = numLives;
    }

    public void kill() {

        numLives = numLives - 1;
    
        if (numLives>0){
            System.out.println("OUCH!");
        }
        else{
            System.out.println("Dead");
        }
    }

}