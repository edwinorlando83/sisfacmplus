package ec.com.mfac.modeloSybase;

public class Tbl_pagos     {
    
   
    private int filas;
 private String formapago;
 private double total;
 private String claveacceso;
    
    public Tbl_pagos()
	{
            
	}
    

    public String  getFormapago(){
        return formapago;
    }

    public void  setFormapago(  String formapago   ){
      this.formapago = formapago;
    }

    public double  getTotal(){
        return total;
    }

    public void  setTotal(  double total   ){
      this.total = total;
    }

    public String  getClaveacceso(){
        return claveacceso;
    }

// IsForeignKeyMember 
    public void  setClaveacceso(  String claveacceso   ){
      this.claveacceso = claveacceso;
    }

	
    public int getFilas() {
		return filas;
	}


	public void setFilas(int filas) {
		this.filas = filas;
	}
    
}


