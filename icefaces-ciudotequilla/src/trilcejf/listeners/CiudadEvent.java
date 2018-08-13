package trilcejf.listeners;

import java.util.EventObject;

import trilcejf.vo.Ciudad;


public class CiudadEvent extends EventObject{
  //data members
private Ciudad ciudad;
private String SQLmessage;


  public CiudadEvent(Object source, Ciudad newCiudad, String msg){
		super(source);
		ciudad = newCiudad;
		SQLmessage = msg;
  }


	public Ciudad getCiudad(){
		return ciudad;
	}
	public String getMessage(){
		return SQLmessage;
	}

}
