package ec.com.mfac.modeloSybase;

public class Tbl_impuestos_detalle    {
    
  
    private int filas;
 private String codigo;
 private String codigoporcentaje;
 private double tarifa;
 private double baseimponible;
 private double valor;
 private Integer pk_detalle;
    
    public Tbl_impuestos_detalle()
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

    public double  getTarifa(){
        return tarifa;
    }

    public void  setTarifa(  double tarifa   ){
      this.tarifa = tarifa;
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

    public Integer  getPk_detalle(){
        return pk_detalle;
    }

// IsForeignKeyMember 
    public void  setPk_detalle(  Integer pk_detalle   ){
      this.pk_detalle = pk_detalle;
    }

	
    public int getFilas() {
		return filas;
	}


	public void setFilas(int filas) {
		this.filas = filas;
	}
    
}


