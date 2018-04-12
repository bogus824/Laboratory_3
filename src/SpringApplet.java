import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.awt.Color;
import java.awt.Graphics;


/**
 * Inherited class whose aim is to declare and display drawings on the surface of the applet 
 * @author bogus
 *
 */

public class SpringApplet extends JApplet{

	public int wdth,hgth;
	
	/**
	 * Overriden Method which is initialized at the moment of running the program
	 * 
	 */
	public void init()
	{
		// Setting the size of the window 
		setSize(1000,1000);
		
		//Declaring all required vectors
		Vector2D VectorA = new Vector2D(21,13);
		Vector2D VectorB = new Vector2D(8,32);
		
		Vector2D VectorSum = VectorA.AddVectors(VectorB);
		
		Vector2D VectorSub = VectorA.SubtractVectors(VectorB);
		
		Vector2D VectorMul1 = VectorA.MultipleVectors(3);
		Vector2D VectorMul2 = VectorB.MultipleVectors(3);
		
		
		//Showing Info about the vectors
		VectorA.Show_Info();
		System.out.print("\n");
		VectorB.Show_Info();
		
		System.out.print("\n");
		System.out.println("New vector which is a sum of Vectors A and B is [" + VectorSum.getX() + "," + VectorSum.getY() + "]");
		System.out.print("\n");
		System.out.println("New vector which is a subtraction of Vectors A and B is [" + VectorSub.getX() + "," + VectorSub.getY() + "]");		
		System.out.print("\n");
		System.out.println("New vector which is a multiplication of Vectors A by constance " + VectorA.getCnst() + " is [" + VectorMul1.getX() + "," + VectorMul1.getY() + "]");
		System.out.print("\n");
		System.out.println("New vector which is a multiplication of Vectors B by constance " +VectorB.getCnst() + " is [" + VectorMul2.getX() + "," + VectorMul2.getY() + "]");
	}
	
	/**
	 * Overriden Method which is responsible for drawing on the surface of the applet 
	 */
	public void paint(Graphics g)
	{
		int width = this.getWidth();
		int hgth = this.getHeight();
		
		//Creating X Y Axis 
		
		//Construction responsible for setting the color of the line on the basis of the RGB scale
		Color myColor1 = new Color(0,0,0);
		g.setColor(myColor1);
		
		g.drawLine(width/2,hgth,width/2,0);
		g.drawLine(width/2,0,width/2+7,0+15);
		g.drawLine(width/2,0,width/2-7,+15);
		
		g.drawLine(width,hgth/2,0,hgth/2);
		g.drawLine(width,hgth/2,width-15,(hgth/2)+7);
		g.drawLine(width,hgth/2,width-15,(hgth/2)-7);
		
		/*
		//Creating the scale of the axis 
		for(int i=1;i<20;i++)
		{
			g.drawLine((width/2)-10,(int)Math.round(hgth-i*hgth/20),10+width/2,(int)Math.round(hgth-i*hgth/20));
			g.drawLine(0+i*width/20,(hgth/2)-10,0+i*width/20,(hgth/2)+10);
			if(i == 11)
			{
			g.drawString("10",(int)Math.round(0.1*width)+(i-2)*width/20,(hgth/2)+25);	
			g.drawString("10",width/2 + 10,(hgth/2)-45);	
			}
			if(i == 9)
			{
			g.drawString("-10",(int)Math.round(0.1*width)+(i-2)*width/20,(hgth/2)+25);	
			g.drawString("-10",width/2 + 10,(hgth/2)+60);	
			}
		}
		*/	
		
		//Creating vectors needed to be drawn
		Vector2D VectorA = new Vector2D(21,13);
		Vector2D VectorB = new Vector2D(8,32);
		
		Vector2D VectorSum = VectorA.AddVectors(VectorB);
		
		Vector2D VectorSub = VectorA.SubtractVectors(VectorB);
		
		Vector2D VectorMul1 = VectorA.MultipleVectors(3);
		Vector2D VectorMul2 = VectorB.MultipleVectors(3);
		
		Vector2D VectorANorm = VectorA.NormalVector();
		Vector2D VectorBNorm = VectorB.NormalVector();
		/*
		//Basic Vectors drawing section
		Color myColor00 = new Color(200,13,178);
		g.setColor(myColor00);
		
		g.drawLine(width/2,hgth/2,5*(int)Math.round(VectorA.getX())+width/2,(hgth/2)-5*(int)Math.round(VectorA.getY()));
		g.drawString("Vector A ["+VectorA.getX() +" , " + VectorA.getY() + "]"	,5*(int)Math.round(VectorA.getX())+width/2,(hgth/2)-5*(int)Math.round(VectorA.getY())+30);
		g.drawLine(5*(int)Math.round(VectorA.getX())+width/2,(hgth/2)-5*(int)Math.round(VectorA.getY()),5*(int)Math.round(VectorA.getX())+width/2-12,(hgth/2)-5*(int)Math.round(VectorA.getY())-2);
		g.drawLine(5*(int)Math.round(VectorA.getX())+width/2,(hgth/2)-5*(int)Math.round(VectorA.getY()),5*(int)Math.round(VectorA.getX())+width/2-6,(hgth/2)-5*(int)Math.round(VectorA.getY())+11);
		
		Color myColor01 = new Color(122,133,50);
		g.setColor(myColor01);
	
		g.drawLine(width/2,hgth/2,5*(int)Math.round(VectorB.getX())+width/2,(hgth/2)-5*(int)Math.round(VectorB.getY()));
		g.drawString("Vector B ["+VectorB.getX() +" , " + VectorB.getY() + "]"	,5*(int)Math.round(VectorB.getX())+width/2,(hgth/2)-5*(int)Math.round(VectorB.getY())+30);
		g.drawLine(5*(int)Math.round(VectorB.getX())+width/2,(hgth/2)-5*(int)Math.round(VectorB.getY()),5*(int)Math.round(VectorB.getX())+width/2-10,(hgth/2)-5*(int)Math.round(VectorB.getY())+13);
		g.drawLine(5*(int)Math.round(VectorB.getX())+width/2,(hgth/2)-5*(int)Math.round(VectorB.getY()),5*(int)Math.round(VectorB.getX())+width/2+4,(hgth/2)-5*(int)Math.round(VectorB.getY())+13);
		*/
		
		
		// Vectors Addition drawing section
		
		/*
		Color myColor2 = new Color(122,33,100);
		g.setColor(myColor2);
		g.drawLine(width/2,hgth/2,5*(int)Math.round(VectorA.getX())+width/2,(hgth/2)-5*(int)Math.round(VectorA.getY()));
		g.drawString("Vector A ["+VectorA.getX() +" , " + VectorA.getY() + "]"	,5*(int)Math.round(VectorA.getX())+width/2,(hgth/2)-5*(int)Math.round(VectorA.getY())+30);
		g.drawLine(5*(int)Math.round(VectorA.getX())+width/2,(hgth/2)-5*(int)Math.round(VectorA.getY()),5*(int)Math.round(VectorA.getX())+width/2-12,(hgth/2)-5*(int)Math.round(VectorA.getY())-2);
		g.drawLine(5*(int)Math.round(VectorA.getX())+width/2,(hgth/2)-5*(int)Math.round(VectorA.getY()),5*(int)Math.round(VectorA.getX())+width/2-6,(hgth/2)-5*(int)Math.round(VectorA.getY())+11);
		
		Color myColor3 = new Color(44,10,200);
		g.setColor(myColor3);
		g.drawLine(5*(int)Math.round(VectorA.getX())+(width/2),(hgth/2)-5*(int)Math.round(VectorA.getY()),5*(int)Math.round(VectorA.getX())+(width/2)+5*(int)Math.round(VectorB.getX()),(hgth/2)-5*(int)Math.round(VectorA.getY())-5*(int)Math.round(VectorB.getY()));
		g.drawString("Vector B ["+VectorB.getX() +" , " + VectorB.getY() + "]"	,5*(int)Math.round(VectorA.getX())+(width/2)+5*(int)Math.round(VectorB.getX()),(hgth/2)-5*(int)Math.round(VectorA.getY())-5*(int)Math.round(VectorB.getY()));
		g.drawLine(5*(int)Math.round(VectorA.getX())+(width/2)+5*(int)Math.round(VectorB.getX()),(hgth/2)-5*(int)Math.round(VectorA.getY())-5*(int)Math.round(VectorB.getY()),5*(int)Math.round(VectorA.getX())+(width/2)+5*(int)Math.round(VectorB.getX())-6,(hgth/2)-5*(int)Math.round(VectorA.getY())-5*(int)Math.round(VectorB.getY())+3);
		g.drawLine(5*(int)Math.round(VectorA.getX())+(width/2)+5*(int)Math.round(VectorB.getX()),(hgth/2)-5*(int)Math.round(VectorA.getY())-5*(int)Math.round(VectorB.getY()),5*(int)Math.round(VectorA.getX())+(width/2)+5*(int)Math.round(VectorB.getX())+2,(hgth/2)-5*(int)Math.round(VectorA.getY())-5*(int)Math.round(VectorB.getY())+11);
		
		
		Color myColor4 = new Color(244,1,1);
		g.setColor(myColor4);
		g.drawLine(width/2,hgth/2,5*(int)Math.round(VectorSum.getX())+width/2,(hgth/2)-5*(int)Math.round(VectorSum.getY()));
		g.drawString("Vector A+B ["+VectorSum.getX() +" , " + VectorSum.getY() + "]"	,-60+ 2*(int)Math.round(VectorSum.getX())+width/2,(hgth/2)-3*(int)Math.round(VectorSum.getY()));
		g.drawLine(5*(int)Math.round(VectorSum.getX())+width/2,(hgth/2)-5*(int)Math.round(VectorSum.getY()),5*(int)Math.round(VectorSum.getX())+width/2 - 14,(hgth/2)-5*(int)Math.round(VectorSum.getY())+7);
		g.drawLine(5*(int)Math.round(VectorSum.getX())+width/2,(hgth/2)-5*(int)Math.round(VectorSum.getY()),5*(int)Math.round(VectorSum.getX())+width/2 - 3,(hgth/2)-5*(int)Math.round(VectorSum.getY())+14);
		*/
		
		// Vectors Subtraction drawing section
		
		/*
		Color myColor5 = new Color(122,33,50);
		g.setColor(myColor5);
		g.drawLine(width/2,hgth/2,5*(int)Math.round(VectorA.getX())+width/2,(hgth/2)-5*(int)Math.round(VectorA.getY()));
		g.drawLine(5*(int)Math.round(VectorA.getX())+width/2,(hgth/2)-5*(int)Math.round(VectorA.getY()),5*(int)Math.round(VectorA.getX())+width/2-12,(hgth/2)-5*(int)Math.round(VectorA.getY())+2);
		g.drawLine(5*(int)Math.round(VectorA.getX())+width/2,(hgth/2)-5*(int)Math.round(VectorA.getY()),5*(int)Math.round(VectorA.getX())+width/2-3,(hgth/2)-5*(int)Math.round(VectorA.getY())+8);
		g.drawString("Vector A ["+VectorA.getX() +" , " + VectorA.getY() + "]"	,10+(int)Math.round(VectorA.getX())+width/2,(hgth/2)-(int)Math.round(VectorA.getY())-60);
		
		
		Color myColor6 = new Color(44,10,200);
		g.setColor(myColor6);
		g.drawLine(5*(int)Math.round(VectorA.getX())+(width/2),(hgth/2)-5*(int)Math.round(VectorA.getY()),5*(int)Math.round(VectorA.getX())+(width/2)-5*(int)Math.round(VectorB.getX()),(hgth/2)-5*(int)Math.round(VectorA.getY())+5*(int)Math.round(VectorB.getY()));
		g.drawString("Vector B [" + VectorB.getX() +" , " + VectorB.getY() + "]"	,((int)Math.round(VectorA.getX())+(width/2)-6*(int)Math.round(VectorB.getX())+130),(hgth/2)+(int)Math.round(VectorA.getY())-2*(int)Math.round(VectorB.getY())+30);
		g.drawLine(5*(int)Math.round(VectorA.getX())+(width/2)-5*(int)Math.round(VectorB.getX()),(hgth/2)-5*(int)Math.round(VectorA.getY())+5*(int)Math.round(VectorB.getY()),5*(int)Math.round(VectorA.getX())+(width/2)-5*(int)Math.round(VectorB.getX())-4,(hgth/2)-5*(int)Math.round(VectorA.getY())+5*(int)Math.round(VectorB.getY())-11);
		g.drawLine(5*(int)Math.round(VectorA.getX())+(width/2)-5*(int)Math.round(VectorB.getX()),(hgth/2)-5*(int)Math.round(VectorA.getY())+5*(int)Math.round(VectorB.getY()),5*(int)Math.round(VectorA.getX())+(width/2)-5*(int)Math.round(VectorB.getX())+8,(hgth/2)-5*(int)Math.round(VectorA.getY())+5*(int)Math.round(VectorB.getY())-11);
		
		
		
		Color myColor7 = new Color(244,1,1);
		g.setColor(myColor7);
		g.drawLine((width/2)+5*(int)Math.round(VectorSub.getX()),(hgth/2)-5*(int)Math.round(VectorSub.getY()),width/2,hgth/2);
		g.drawLine(width/2,hgth/2,(width/2)+4,hgth/2+12);
		g.drawLine(width/2,hgth/2,width/2+10,hgth/2+7);
		g.drawString("Vector A-B ["+VectorSub.getX() +" , " + VectorSub.getY() + "]"	, 2*(int)Math.round(VectorSub.getX())+width/2-190,(hgth/2)-3*(int)Math.round(VectorSub.getY()));
		*/
		
		// Vectors Multiplication drawing section
		
		/*
		Color myColor8= new Color(122,33,200);
		g.setColor(myColor8);
		g.drawString("Vector A multiplied by " + VectorA.getCnst() + " ["+ VectorMul1.getX() + "," + VectorMul1.getY() + "]" ,5*(int)Math.round(VectorA.getX())+width/2+100,(hgth/2)-5*(int)Math.round(VectorA.getY()));
		g.drawLine(width/2,hgth/2,5*(int)Math.round(VectorMul1.getX())+width/2,(hgth/2)-5*(int)Math.round(VectorMul1.getY()));
		g.drawLine(5*(int)Math.round(VectorMul1.getX())+width/2,(hgth/2)-5*(int)Math.round(VectorMul1.getY()),5*(int)Math.round(VectorMul1.getX())+width/2-6,(hgth/2)-5*(int)Math.round(VectorMul1.getY())+16);
		g.drawLine(5*(int)Math.round(VectorMul1.getX())+width/2,(hgth/2)-5*(int)Math.round(VectorMul1.getY()),5*(int)Math.round(VectorMul1.getX())+width/2-16,(hgth/2)-5*(int)Math.round(VectorMul1.getY())+2);
		
		Color myColor9= new Color(12,213,220);
		g.setColor(myColor9);
		g.drawString("Vector B multiplied by " + VectorB.getCnst() + " ["+ VectorMul2.getX() + "," + VectorMul2.getY() + "]" ,5*(int)Math.round(VectorB.getX())+width/2+120,(hgth/2)-5*(int)Math.round(VectorB.getY())-300);
		g.drawLine(width/2,hgth/2,5*(int)Math.round(VectorMul2.getX())+width/2,(hgth/2)-5*(int)Math.round(VectorMul2.getY()));
		g.drawLine(5*(int)Math.round(VectorMul2.getX())+width/2,(hgth/2)-5*(int)Math.round(VectorMul2.getY()),5*(int)Math.round(VectorMul2.getX())+width/2-10,(hgth/2)-5*(int)Math.round(VectorMul2.getY())+16);
		g.drawLine(5*(int)Math.round(VectorMul2.getX())+width/2,(hgth/2)-5*(int)Math.round(VectorMul2.getY()),5*(int)Math.round(VectorMul2.getX())+width/2+6,(hgth/2)-5*(int)Math.round(VectorMul2.getY())+16);
		*/
		
		// Vector Normalized drawing section
		
	
		//Creating the scale for the normalized vector to show their length and coordinates much better
		
		for(int i=1;i<20;i++)
		{
			g.drawLine((width/2)-10,(int)Math.round(hgth-i*hgth/20),10+width/2,(int)Math.round(hgth-i*hgth/20));
			g.drawLine(0+i*width/20,(hgth/2)-10,0+i*width/20,(hgth/2)+10);
			if(i == 11)
			{
			g.drawString("0.1",(int)Math.round(0.1*width)+(i-2)*width/20,(hgth/2)+25);	
			g.drawString("0.1",width/2 + 10,(hgth/2)-45);	
			}
			if(i == 9)
			{
			g.drawString("-0.1",(int)Math.round(0.1*width)+(i-2)*width/20,(hgth/2)+25);	
			g.drawString("-0.1",width/2 + 10,(hgth/2)+60);	
			}
		}
		
		Color myColor10= new Color(12,213,220);
		g.setColor(myColor10);
		
		g.drawString("Vector A normalized ["+ VectorANorm.getX() + "," + VectorANorm.getY() + "]" ,50*(int)Math.round(VectorANorm.getX())+width/2+80,(hgth/2)-50*(int)Math.round(VectorANorm.getY()));
		g.drawLine(width/2,hgth/2,425*(int)Math.round(VectorANorm.getX())+width/2,(hgth/2)-275*(int)Math.round(VectorANorm.getY()));
		g.drawLine(425*(int)Math.round(VectorANorm.getX())+width/2,(hgth/2)-275*(int)Math.round(VectorANorm.getY()),425*(int)Math.round(VectorANorm.getX())+width/2-14,(hgth/2)-275*(int)Math.round(VectorANorm.getY())+1);
		g.drawLine(425*(int)Math.round(VectorANorm.getX())+width/2,(hgth/2)-275*(int)Math.round(VectorANorm.getY()),425*(int)Math.round(VectorANorm.getX())+width/2-8,(hgth/2)-275*(int)Math.round(VectorANorm.getY())+13);
		
		
		
		Color myColor11= new Color(122,12,220);
		g.setColor(myColor11);
		
		g.drawString("Vector B normalized ["+ VectorBNorm.getnormalX() + "," + VectorBNorm.getnormalY() + "]" ,60*(int)Math.round(VectorBNorm.getX())+width/2+40,(hgth/2)-350*(int)Math.round(VectorBNorm.getY())+40);
		g.drawLine(width/2,hgth/2,width/2+480*(int)Math.round(100*VectorBNorm.getnormalX())/100,(hgth/2)-485*(int)Math.round(VectorBNorm.getY()));
		g.drawLine(width/2+480*(int)Math.round(100*VectorBNorm.getnormalX())/100,(hgth/2)-485*(int)Math.round(VectorBNorm.getY()),width/2+480*(int)Math.round(100*VectorBNorm.getnormalX())/100-13,(hgth/2)-485*(int)Math.round(VectorBNorm.getY())+9);
		g.drawLine(width/2+480*(int)Math.round(100*VectorBNorm.getnormalX())/100,(hgth/2)-485*(int)Math.round(VectorBNorm.getY()),width/2+480*(int)Math.round(100*VectorBNorm.getnormalX())/100+7,(hgth/2)-485*(int)Math.round(VectorBNorm.getY())+11);
		
	}


}

	        