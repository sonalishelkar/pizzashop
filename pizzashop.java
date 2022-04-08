import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class pizzashop extends Frame implements ItemListener,ActionListener
{
	String msg="";
	Label L1,L2,L3,L4,L5,L6,L7,L8,L9,L10,L11,L12;
	TextField T1,T2,T3,T4,T5;
	Button B1,B2;
	Panel p1,p2,p3,p4,p5,p6,p7,p8,p9;
	Checkbox Onion,Cheese,Tomato,Babycorn;
	Checkbox pp,sc,r;
	CheckboxGroup cbg;
	//Color C1;
	double O,C,T,B,pr,dis,bill;
	String x1,x2,x3,x4,x5,x6,x7;
		
	public pizzashop(String title)
	{
		super (title);
		cbg=new CheckboxGroup();
		setLayout(new GridLayout(8,2));
		
		p1=new Panel(); p2=new Panel(); p3=new Panel(); 
		p4=new Panel(); p5=new Panel(); p6=new Panel(); 
		p7=new Panel(); p8=new Panel(); p9=new Panel();
		
		p1.setLayout(new GridLayout(1,4));
		p2.setLayout(new GridLayout(1,4));
		p3.setLayout(new GridLayout(1,4));
		p4.setLayout(new GridLayout(1,2));
		p5.setLayout(new GridLayout(4,1));
		p6.setLayout(new GridLayout(5,1));
		p7.setLayout(new GridLayout(1,2));
		p8.setLayout(new GridLayout(1,2));
		p9.setLayout(new GridLayout(1,1));
		
		//C1=new Color(255,229,206);
		setBackground(Color.LIGHT_GRAY);
		setForeground(Color.BLACK);
		L1=new Label("Order no.");
		L2=new Label("Price");
		L3=new Label("Customer Name");
		L4=new Label("discount");
		L5=new Label("qty");
		L6=new Label("Cost of Topping");
		L7=new Label("*****");
		L8=new Label("Amount");
		L9=new Label("******");
		L10=new Label("Pizza type");
		L11=new Label("Topping");
		L12=new Label("****");
		
		T1=new TextField(8);
		T2=new TextField(8);
		T3=new TextField(8);
		T4=new TextField(8);
		T5=new TextField(8);
		
		Onion=new Checkbox("Onion");
		Cheese=new Checkbox("Cheese");
		Tomato=new Checkbox("Tomato");
		Babycorn=new Checkbox("Baby Corn");
		
		cbg=new CheckboxGroup();
		pp=new Checkbox("Pan Pizza",cbg,true);
		sc=new Checkbox("Staffed Crust",cbg,false);
		r=new Checkbox("Regular",cbg,false);
		
		B1=new Button("bill");
		B2=new Button("clear");
		
		p1.add(L1); p1.add(T1); p1.add(L2); p1.add(T2);
		p2.add(L3); p2.add(T3); p2.add(L4); p2.add(T4);
		p3.add(L5); p3.add(T5); p3.add(L6); p3.add(L7);
		p4.add(L8); p4.add(L9);
		p5.add(L10);p5.add(pp);p5.add(sc);p5.add(r); 
		p6.add(L11); p6.add(Onion); p6.add(Cheese); p6.add(Tomato); p6.add(Babycorn);
		p8.add(B1); p8.add(B2);
		p9.add(L12);
				
		add(p1); add(p2); add(p3); add(p4); p7.add(p5); p7.add(p6); add(p7); add(p8); add(p9);
		
		
		
		B1.addActionListener(this);
		B2.addActionListener(this);
		
		Onion.addItemListener(this);
		Cheese.addItemListener(this);
		Tomato.addItemListener(this);
		Babycorn.addItemListener(this);
		
		pp.addItemListener(this);
		sc.addItemListener(this);
		r.addItemListener(this);
	}


public void itemStateChanged(ItemEvent ie)
{

 if (Onion.getState())
	   	O=40;
	  else
	  	O=0;
	  	
	  if (Cheese.getState())
	  	C=80;
	  else
	  	C=0;	
	  
	  if(Tomato.getState())
	   	T=30;
	  else
	  	T=0; 	
	  
	  if(Babycorn.getState())
	  	B=60;
	  else
	  	B=0;
	  	
	 L7.setText(""+(O+C+T+B)); 		  	
	  
	 Checkbox x=cbg.getSelectedCheckbox();
	 if(x==pp)
	 	pr=250;
	 else if(x==sc)	
	 	pr=300;
	 else 
	 	pr=180;
	 	
	 	T2.setText(""+pr);
}
	public void actionPerformed(ActionEvent ae)
	{
	  if (ae.getSource()==B1)
	  {
	  	
		x1=T1.getText();
	  	x2=L9.getText();
	  	x3=T3.getText();
	  	
	  	L12.setText("Order no:    "+x1+"    Customer Name:    "+x3+"     Amounnt:  "+x2);
	  	
	  	Double qty=Double.parseDouble(T5.getText());
		Double price=Double.parseDouble(T2.getText());
	  	bill=qty*price+O+C+T+B;
	  	L9.setText(" "+bill);
	  	dis=Double.parseDouble(T4.getText());
	  	dis=bill*dis/100.0;
	  	L9.setText(""+dis);
	    bill=bill-dis;
	  	L9.setText(""+bill);
	 }
	   else
	  {
	  	T1.setText(""); T2.setText(""); T3.setText(""); T4.setText(""); T5.setText(""); 
	  	Onion.setState(false); Cheese.setState(false); Tomato.setState(false); Babycorn.setState(false); pp.setState(true);
	  }
	}	
	 public static void main (String args[])
	 {
	 	Frame f=new pizzashop("Bill");
	 	f.setVisible(true);
	 	f.setSize(900,800);
	 }
	 
	
}	
	

