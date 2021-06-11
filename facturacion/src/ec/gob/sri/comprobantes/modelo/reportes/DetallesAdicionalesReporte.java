/*     */ package ec.gob.sri.comprobantes.modelo.reportes;
/*     */ 
/*     */ import java.util.List;
/*     */ 
/*     */ public class DetallesAdicionalesReporte
/*     */ {
/*     */   private String codigoPrincipal;
/*     */   private String codigoAuxiliar;
/*     */   private String cantidad;
/*     */   private String descripcion;
/*     */   private String precioUnitario;
/*     */   private String precioTotalSinImpuesto;
/*     */   private String descuento;
/*     */   private String numeroComprobante;
/*     */   private String nombreComprobante;
/*     */   private String detalle1;
/*     */   private String detalle2;
/*     */   private String detalle3;
/*     */   private String fechaEmisionCcompModificado;
/*     */   private List<InformacionAdicional> infoAdicional;
/*     */   private String razonModificacion;
/*     */   private String valorModificacion;
/*     */   private String baseImponible;
/*     */   private String nombreImpuesto;
/*     */   private String porcentajeRetener;
/*     */   private String valorRetenido;

private String subsidio;

private String precioSinSubsidio;

/*     */ 
/*     */   public String getCodigoPrincipal()
/*     */   {
/*  47 */     return this.codigoPrincipal;
/*     */   }
/*     */ 
/*     */   public void setCodigoPrincipal(String codigoPrincipal)
/*     */   {
/*  54 */     this.codigoPrincipal = codigoPrincipal;
/*     */   }
/*     */ 
/*     */   public String getCodigoAuxiliar()
/*     */   {
/*  61 */     return this.codigoAuxiliar;
/*     */   }
/*     */ 
/*     */   public void setCodigoAuxiliar(String codigoAuxiliar)
/*     */   {
/*  68 */     this.codigoAuxiliar = codigoAuxiliar;
/*     */   }
/*     */ 
/*     */   public String getCantidad()
/*     */   {
/*  75 */     return this.cantidad;
/*     */   }
/*     */ 
/*     */   public void setCantidad(String cantidad)
/*     */   {
/*  82 */     this.cantidad = cantidad;
/*     */   }
/*     */ 
/*     */   public String getDescripcion()
/*     */   {
/*  89 */     return this.descripcion;
/*     */   }
/*     */ 
/*     */   public void setDescripcion(String descripcion)
/*     */   {
/*  96 */     this.descripcion = descripcion;
/*     */   }
/*     */ 
/*     */   public String getPrecioUnitario()
/*     */   {
/* 103 */     return this.precioUnitario;
/*     */   }
/*     */ 
/*     */   public void setPrecioUnitario(String precioUnitario)
/*     */   {
/* 110 */     this.precioUnitario = precioUnitario;
/*     */   }
/*     */ 
/*     */   public String getPrecioTotalSinImpuesto()
/*     */   {
/* 117 */     return this.precioTotalSinImpuesto;
/*     */   }
/*     */ 
/*     */   public void setPrecioTotalSinImpuesto(String precioTotalSinImpuesto)
/*     */   {
/* 124 */     this.precioTotalSinImpuesto = precioTotalSinImpuesto;
/*     */   }
/*     */ 
/*     */    public String getDetalle1()
/*     */    {
/* 131 */     return this.detalle1;
/*     */    }
/*     */ 
/*     */    public void setDetalle1(String detalle1)
/*     */   {
/* 138 */     this.detalle1 = detalle1;
/*     */   }
/*     */ 
/*     */   public String getDetalle2()
/*     */   {
/* 145 */    return this.detalle2;
/*     */   }
/*     */ 
/*     */   public void setDetalle2(String detalle2)
/*     */   {
/* 152 */    this.detalle2 = detalle2;
/*     */   }
/*     */ 
/*     */   public String getDetalle3()
/*     */  {
/* 159 */    return this.detalle3;
/*     */  }
/*     */ 
/*     */   public void setDetalle3(String detalle3)
/*     */   {
/* 166 */    this.detalle3 = detalle3;
/*     */   }
/*     */ 
/*     */   public List<InformacionAdicional> getInfoAdicional()
/*     */   {
/* 173 */     return this.infoAdicional;
/*     */   }
/*     */ 
/*     */   public void setInfoAdicional(List<InformacionAdicional> infoAdicional)
/*     */   {
/* 180 */     this.infoAdicional = infoAdicional;
/*     */   }
/*     */ 
/*     */   public String getRazonModificacion()
/*     */   {
/* 187 */     return this.razonModificacion;
/*     */   }
/*     */ 
/*     */   public void setRazonModificacion(String razonModificacion)
/*     */   {
/* 194 */     this.razonModificacion = razonModificacion;
/*     */   }
/*     */ 
/*     */   public String getValorModificacion()
/*     */   {
/* 201 */     return this.valorModificacion;
/*     */   }
/*     */ 
/*     */   public void setValorModificacion(String valorModificacion)
/*     */   {
/* 208 */     this.valorModificacion = valorModificacion;
/*     */   }
/*     */ 
/*     */   public String getBaseImponible()
/*     */   {
/* 215 */     return this.baseImponible;
/*     */   }
/*     */ 
/*     */   public void setBaseImponible(String baseImponible)
/*     */   {
/* 222 */     this.baseImponible = baseImponible;
/*     */   }
/*     */ 
/*     */   public String getNombreImpuesto()
/*     */   {
/* 229 */     return this.nombreImpuesto;
/*     */   }
/*     */ 
/*     */   public void setNombreImpuesto(String nombreImpuesto)
/*     */   {
/* 236 */     this.nombreImpuesto = nombreImpuesto;
/*     */   }
/*     */ 
/*     */   public String getPorcentajeRetener()
/*     */   {
/* 243 */     return this.porcentajeRetener;
/*     */   }
/*     */ 
/*     */   public void setPorcentajeRetener(String porcentajeRetener)
/*     */   {
/* 250 */     this.porcentajeRetener = porcentajeRetener;
/*     */   }
/*     */ 
/*     */   public String getValorRetenido()
/*     */   {
/* 257 */     return this.valorRetenido;
/*     */   }
/*     */ 
/*     */   public void setValorRetenido(String valorRetenido)
/*     */   {
/* 264 */     this.valorRetenido = valorRetenido;
/*     */   }
/*     */ 
/*     */   public String getDescuento()
/*     */   {
/* 271 */     return this.descuento;
/*     */   }
/*     */ 
/*     */   public void setDescuento(String descuento)
/*     */   {
/* 278 */     this.descuento = descuento;
/*     */   }
/*     */ 
/*     */   public String getNumeroComprobante()
/*     */   {
/* 285 */     return this.numeroComprobante;
/*     */   }
/*     */ 
/*     */   public void setNumeroComprobante(String numeroComprobante)
/*     */   {
/* 292 */     this.numeroComprobante = numeroComprobante;
/*     */   }
/*     */ 
/*     */   public String getNombreComprobante()
/*     */   {
/* 299 */     return this.nombreComprobante;
/*     */   }
/*     */ 
/*     */   public void setNombreComprobante(String nombreComprobante)
/*     */   {
/* 306 */     this.nombreComprobante = nombreComprobante;
/*     */   }
/*     */ 
/*     */   public String getFechaEmisionCcompModificado()
/*     */   {
/* 313 */     return this.fechaEmisionCcompModificado;
/*     */   }
/*     */ 
/*     */   public void setFechaEmisionCcompModificado(String fechaEmisionCcompModificado)
/*     */   {
/* 320 */     this.fechaEmisionCcompModificado = fechaEmisionCcompModificado;
/*     */   }
/*     */
public String getSubsidio() {
	return subsidio;
}
public void setSubsidio(String subsidio) {
	this.subsidio = subsidio;
}
public String getPrecioSinSubsidio() {
	return precioSinSubsidio;
}
public void setPrecioSinSubsidio(String precioSinSubsidio) {
	this.precioSinSubsidio = precioSinSubsidio;
}
 }

 