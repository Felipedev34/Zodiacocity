import java.awt.*;
    class Mensaje extends Dialog {
   
        public Mensaje(String tit_vent, String condicion) {
            super( new Frame(),tit_vent,true );
            this.setResizable( false );
            setBackground( Color.gray );
            Panel p1 = new Panel();
            Panel p2 = new Panel();
            p1.add( new Button( "Aceptar" ) );
            p2.add(new Label(condicion));
		    
		setLayout( new BorderLayout() );
        add( "South",p1);
        add( "Center",p2 );
			
			
			resize( 200,85 );
            }

 public boolean handleEvent( Event evt ) {
        switch( evt.id ) {
            case Event.WINDOW_DESTROY:
                {
                setVisible(false);
                return true;
                }
            case Event.ACTION_EVENT:
                    {
                    if( "Aceptar".equals( evt.arg ) ) 
                        {
                        hide();
                        return true;
						}
					}
			
			default:
                return false;
            }
                            
     }       

        }
