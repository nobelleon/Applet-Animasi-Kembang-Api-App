/**
 * @(#)KembangApi.java
 *
 * KembangApi Applet application
 *
 * @author nObeLLeon
 * @version 1.00 2020/6/6
 *********************************************   Program Successful  **********************************************************************
 */
 
import java.awt.*;
import java.applet.*;
import java.awt.geom.*;

public class KembangApi extends Applet implements Runnable{
	
	Thread lari;
	private Image Buffer;
	private Graphics gBuffer;
	
	int p1=0, p2=1, p3=0, p4=0, p5=0, p6=0, p7=1, p8=0, p9=0, p10=0,
		p11=0, p12=1, p13=0, p14=0, p15=0;
	
	int merah, hijau, biru, merah1, hijau1, biru1, merah2, hijau2, biru2;
	float strip[] = {10.0f};
	BasicStroke stroke = new BasicStroke(3.0f, 1, 2, 1.0f, strip, 0.0f);
	Graphics2D g2d;
	
	
	
	public void init() { 
		
		// Membuat grafik buffer dengan ukuran sebesar applet
		Buffer = createImage(size().width, size().height);
		gBuffer = Buffer.getGraphics();
	}
	
	public void start(){
		
		if(lari == null){
			lari = new Thread(this); 
			lari.start();
		}
	}
	
	public void stop(){
		
		if(lari != null){
			lari.stop();
			lari = null;
		}
	}
	
	public void run(){
		
		while(true){
			// Waktu tunda thread sebesar 20 miliseconds
			try{
				lari.sleep(20);
			}
			catch(Exception e){}
			// Membuat latar belakang berwarna hitam
			gBuffer.setColor(Color.black);
			gBuffer.fillRect(0, 0, size().width, size().height);
			
			repaint();
		}
	}
	
	// Untuk mencegah terlihatnya penghapusan latar belakang oleh Java

	public void update(Graphics g){
		
		g2d = (Graphics2D) g;
		paint(g2d);
	}
	
	public void paint(Graphics g) {
		
		g2d = (Graphics2D) g;
		g2d.drawImage(Buffer, 0, 0, this);
		
		// Memberi warna hitam sebagai latar belakang
		setBackground(Color.black);
		if(p1 == 0){							// p1						
			merah = (int)(Math.random()*256);
			hijau = (int)(Math.random()*256);
			biru = (int)(Math.random()*256);
			p4 = (int)(Math.random()*300);
			p5 = (int)(Math.random()*300);
		}
		
		if(p6 == 0){							// p6
			merah1 = (int)(Math.random()*256);
			hijau1 = (int)(Math.random()*256);
			biru1 = (int)(Math.random()*256);
			p9 = (int)(Math.random()*300);      // p9
			p10 = (int)(Math.random()*300);
		}
		
		if(p11 == 0){                           // p11
			merah2 = (int)(Math.random()*256);
			hijau2 = (int)(Math.random()*256);
			biru2= (int)(Math.random()*256);
			p14 = (int)(Math.random()*300);     // p14
			p15 = (int)(Math.random()*300);
		}
		
		g2d.setPaint(new Color(merah, hijau, biru));
		if(p1 >= 0 && p1 < p2){
			
			if(p3 == 0)
				p1++;
			else if(p3 == 1)
				p1 += 2;
			else if(p3 == 2)
				p1 += 3;
			if(p1 == 1){
				p2 = (int)(Math.random()*50)+30;
				p3 = (int)(Math.random()*2);
			}
			
			// Membuat garis yang dikombinasikan dengan pola garis
			g2d.setStroke(stroke);
			for(int i=0; i<=43; i++)
				g2d.draw(new Line2D.Double(p4, p5, p4 + ((int)p1*Math.cos(i)), 
															p5 + ((int)p1*Math.sin(i))));
		}
		else if(p1 >= p2){
			
			p1 = 0;
		}
		g2d.setPaint(new Color(merah1, hijau1, biru1));
		
		if(p6>=0  &&  p6<p7){
			
			if(p8 == 0)
				p6++;
			else if(p8 == 1)
				p6+=2;
			else if(p8 == 2)
				p6+=3;
			if(p6 == 1){
				p7 = (int)(Math.random()*50)+30;
				p8 = (int)(Math.random()*2);
			}
			
			// Membuat garis yang dikombinasikan dengan pola garis
			g2d.setStroke(stroke);
			for(int i=0; i<43; i++)
				g2d.draw(new Line2D.Double(p9, p10, p9 + ((int)p6*Math.cos(i)), 
															p10 + ((int)p6*Math.sin(i))));
			
			// Membuat kembang api seolah-olah berkedip
			g2d.setPaint(Color.black);
			g2d.setStroke(stroke);
			for(int i=0; i<=43; i++)
				g2d.draw(new Line2D.Double(p9, p10, p9 + ((int)p6*Math.cos(i)), 
															p10 + ((int)p6*Math.sin(i))));
		}
		else if(p6 >= p7){
			p6 = 0;
		}
		g2d.setPaint(new Color(merah2, hijau2, biru2));
		if(p11>=0  &&  p11<p12){
			
			if(p13 == 0)
				p11++;
			else if(p13 == 1)
				p11 += 2;
			else if(p13 == 2)
				p11 += 3;
			if(p11 == 1){
				p12 = (int)(Math.random()*50)+30;
				p13 = (int)(Math.random()*2);
			}
			
			// Membuat garis yang dikombinasikan dengan pola garis 
			g2d.setStroke(stroke);
			for(int i=0; i<=43; i++)
				g2d.draw(new Line2D.Double(p14, p15, p14 + ((int)p11*Math.cos(i)), 
																p15 + ((int)p11*Math.sin(i))));
																
			// Membuat kembang api seolah-olah berkedip
			g2d.setPaint(Color.black);
			g2d.setStroke(stroke);
			for(int i=0; i<=43; i++)
				g2d.draw(new Line2D.Double(p14, p15, p14 + ((int)p11*Math.cos(i)),
																p15 + ((int)p11*Math.sin(i))));
		}
		else if(p11 >= p12){
			
			p11 = 0;
		}
		
	}
}