import java.awt.*;
import java.applet.*;
class Imagen extends Canvas {
	boolean tapada;
	Image imag;
	String mostrar,cara,reverso="reverso.jpeg";
	String nombre;
	public Imagen(String foto){
	    tapada=true;
		cara=foto;
		nombre=foto;
		mostrar=reverso;
		} 
		
    public void paint( Graphics g ) {

		imag = getToolkit().getImage(mostrar);
		g.drawImage(imag, 0, 0, this.getSize().width , this.getSize().height , this);
		
        }
	boolean getTapada(){
		 return tapada;
		}
	String getCara(){
		 return cara;
		}
	void verCara(){
		 mostrar=cara;
		 tapada=false;
		}
	void verReverso(){
		mostrar=reverso;
		tapada=true;
		}
	public String getNombre(){
	return nombre;
}
     }
