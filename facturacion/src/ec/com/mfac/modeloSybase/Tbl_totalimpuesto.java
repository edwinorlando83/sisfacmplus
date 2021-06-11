package ec.com.mfac.modeloSybase;

public class Tbl_totalimpuesto    {
    
 
  private int filas;
 private String codigo;
 private String codigoporcentaje;
 private double baseimponible;
 private double valor;
 private String claveacceso;
    
    public Tbl_totalimpuesto()
	{
            
	}
    

    public String  getCodigo(){
        return codigo;
    }

    public void  setCodigo(  String codigo   ){
      this.codigo = codigo;
    }

    public String  getCodigoporcentaje(){
        return codigoporcentaje;
    }

    public void  setCodigoporcentaje(  String codigoporcentaje   ){
      this.codigoporcentaje = codigoporcentaje;
    }

    public double  getBaseimponible(){
        return baseimponible;
    }

    public void  setBaseimponible(  double baseimponible   ){
      this.baseimponible = baseimponible;
    }

    public double  getValor(){
        return valor;
    }

    public void  setValor(  double valor   ){
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


