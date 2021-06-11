package ec.com.mfac.modeloSybase;
 
import java.util.Date;

public class Tbl_detalle_retencion  {
 
    private int filas;
 private String codigo;
 private String codigoretencion;
 private double baseimponible;
 private double porcentajeretener;
 private double valorretenido;
 private String coddocsustento;
 private String numdocsustento;
 private Date fechaemisiondocsustento;
 private String claveacceso;
    
    public Tbl_detalle_retencion()
	{
            
	}
    

    public String  getCodigo(){
        return codigo;
    }

    public void  setCodigo(  String codigo   ){
      this.codigo = codigo;
    }

    public String  getCodigoretencion(){
        return codigoretencion;
    }

    public void  setCodigoretencion(  String codigoretencion   ){
      this.codigoretencion = codigoretencion;
    }

    public double  getBaseimponible(){
        return baseimponible;
    }

    public void  setBaseimponible(  double baseimponible   ){
      this.baseimponible = baseimponible;
    }

    public double  getPorcentajeretener(){
        return porcentajeretener;
    }

    public void  setPorcentajeretener(  double porcentajeretener   ){
      this.porcentajeretener = porcentajeretener;
    }

    public double  getValorretenido(){
        return valorretenido;
    }

    public void  setValorretenido(  double valorretenido   ){
      this.valorretenido = valorretenido;
    }

    public String  getCoddocsustento(){
        return coddocsustento;
    }

    public void  setCoddocsustento(  String coddocsustento   ){
      this.coddocsustento = coddocsustento;
    }

    public String  getNumdocsustento(){
        return numdocsustento;
    }

    public void  setNumdocsustento(  String numdocsustento   ){
      this.numdocsustento = numdocsustento;
    }

    public Date  getFechaemisiondocsustento(){
        return fechaemisiondocsustento;
    }

    public void  setFechaemisiondocsustento(  Date fechaemisiondocsustento   ){
      this.fechaemisiondocsustento = fechaemisiondocsustento;
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


