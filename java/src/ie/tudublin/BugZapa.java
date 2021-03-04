package ie.tudublin;

import processing.core.PApplet;

public class BugZapa extends PApplet{

	public void settings()
	{

		size(500, 500);
	}

    
    float playerX = width/2;;
    float playerY = height + 350;
    float playerWidth = 50;
   
	// These are fields in the class now and can be used in 
	// any of the methods in the HelloProcessing2 class 

	float x = 300;
	int i;
	String s;
    boolean b;

	

    public void drawPlayer(float x, float y, float w){
        float h = w /2;
   
        line(x, y + h, x + w, y + h);
        line(x, y + h, x, y + h * 0.5f);
        line(x + w, y + h, x + w, y + h * 0.5f);
        line(x, y + h * 0.5f, x + w * 0.2f, y + h * 0.3f);
        line(x + w, y + h * 0.5f, x + w * 0.8f, y + h * 0.3f);
        line(x + w * 0.2f, y + h * 0.3f, x + w * 0.8f, y + h * 0.3f);
        line(x + w * 0.5f, y, x + w * 0.5f, y + h * 0.3f); 
        stroke(255);
    }

    public void draw()
    {	
        background(0);     
        drawPlayer(playerX, playerY, playerWidth);
        keyPressed();
    }


    public void keyPressed()
	{
		if (keyCode == LEFT)
		{
            playerX --;
		}
		if (keyCode == RIGHT)
		{
            playerX ++;
		}
		if (key == ' ')
		{
			System.out.println("SPACE key pressed");
		}
	}	
}
