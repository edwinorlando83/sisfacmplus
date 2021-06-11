package ec.com.mfac.modeloSybase;

public class Tbl_infoadicional   {
    
 
    private int filas;
 private Integer pk_infodicional;
 private String campo;
 private String valor;
 private String claveacceso;
    
    public Tbl_infoadicional()
	{
            
	}
    

    public Integer  getPk_infodicional(){
        return pk_infodicional;
    }

    public void  setPk_infodicional(  Integer pk_infodicional   ){
      this.pk_infodicional = pk_infodicional;
    }

    public String  getCampo(){
        return campo;
    }

    public void  setCampo(  String campo   ){
      this.campo = campo;
    }

    public String  getValor(){
        return valor;
    }

    public void  setValor(  String valor   ){
      this.valor = valor;
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


