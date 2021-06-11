package ec.com.mfac.modeloSybase;

public class Tbl_detalle   {
    
 
    private int filas;
 private Integer pk_detalle;
 private String codigoprincipal;
 private String codigoauxiliar;
 private String descripcion;
 private double cantidad;
 private double preciounitario;
 private double descuento;
 private double preciototalsinimpuesto;
 private String claveacceso;
    
    public Tbl_detalle()
	{
            
	}
    

    public Integer  getPk_detalle(){
        return pk_detalle;
    }

    public void  setPk_detalle(  Integer pk_detalle   ){
      this.pk_detalle = pk_detalle;
    }

    public String  getCodigoprincipal(){
        return codigoprincipal;
    }

    public void  setCodigoprincipal(  String codigoprincipal   ){
      this.codigoprincipal = codigoprincipal;
    }

    public String  getCodigoauxiliar(){
        return codigoauxiliar;
    }

    public void  setCodigoauxiliar(  String codigoauxiliar   ){
      this.codigoauxiliar = codigoauxiliar;
    }

    public String  getDescripcion(){
        return descripcion;
    }

    public void  setDescripcion(  String descripcion   ){
      this.descripcion = descripcion;
    }

    public double  getCantidad(){
        return cantidad;
    }

    public void  setCantidad(  double cantidad   ){
      this.cantidad = cantidad;
    }

    public double  getPreciounitario(){
        return preciounitario;
    }

    public void  setPreciounitario(  double preciounitario   ){
      this.preciounitario = preciounitario;
    }

    public double  getDescuento(){
        return descuento;
    }

    public void  setDescuento(  double descuento   ){
      this.descuento = descuento;
    }

    public double  getPreciototalsinimpuesto(){
        return preciototalsinimpuesto;
    }

    public void  setPreciototalsinimpuesto(  double preciototalsinimpuesto   ){
      this.preciototalsinimpuesto = preciototalsinimpuesto;
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




