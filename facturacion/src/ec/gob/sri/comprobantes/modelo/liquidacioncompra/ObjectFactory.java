/*     */ package ec.gob.sri.comprobantes.modelo.liquidacioncompra;

/*     */
/*     */ import ec.gob.sri.comprobantes.modelo.InfoTributaria;
import ec.gob.sri.comprobantes.modelo.liquidacioncompra.LiquidacionCompras.Detalles.Detalle.Impuestos;

/*     */ import javax.xml.bind.annotation.XmlRegistry;

/*     */
/*     */ @XmlRegistry
/*     */ public class ObjectFactory
/*     */ {
	public LiquidacionCompras.Detalles.Detalle.DetallesAdicionales createFacturaDetallesDetalleDetallesAdicionales() {
		  return new LiquidacionCompras.Detalles.Detalle.DetallesAdicionales();
	}

	public LiquidacionCompras.Detalles.Detalle.DetallesAdicionales.DetAdicional createFacturaDetallesDetalleDetallesAdicionalesDetAdicional() {
		  return new LiquidacionCompras.Detalles.Detalle.DetallesAdicionales.DetAdicional();
	}

	public LiquidacionCompras.Detalles createFacturaDetalles() {
		  return new LiquidacionCompras.Detalles();
	}

	public LiquidacionCompras.Detalles.Detalle createFacturaDetallesDetalle() {
		 return new LiquidacionCompras.Detalles.Detalle();
	}

	public LiquidacionCompras.InfoLiquidacionCompra createFacturaInfoFactura() {
		  return new LiquidacionCompras.InfoLiquidacionCompra();
	}

	public LiquidacionCompras.InfoAdicional createFacturaInfoAdicional() {
		  return new LiquidacionCompras.InfoAdicional();
	}

	public Impuestos createImpuesto() {
		  return new Impuestos();
	}

	public InfoTributaria createInfoTributaria() {
		  return new InfoTributaria();
	}

	public LiquidacionCompras createFactura() {
		  return new LiquidacionCompras();
	}

	public LiquidacionCompras.InfoAdicional.CampoAdicional createFacturaInfoAdicionalCampoAdicional() {
		/* 117 */ return new LiquidacionCompras.InfoAdicional.CampoAdicional();
	}

	public LiquidacionCompras.InfoLiquidacionCompra.TotalConImpuestos createFacturaInfoFacturaTotalConImpuestos() {
		/* 125 */ return new LiquidacionCompras.InfoLiquidacionCompra.TotalConImpuestos();
	}

	public LiquidacionCompras.Detalles.Detalle.Impuestos createFacturaDetallesDetalleImpuestos() {
		/* 133 */ return new LiquidacionCompras.Detalles.Detalle.Impuestos();
	}

	public LiquidacionCompras.InfoLiquidacionCompra.TotalConImpuestos.TotalImpuesto createFacturaInfoFacturaTotalConImpuestosTotalImpuesto() {
		return new LiquidacionCompras.InfoLiquidacionCompra.TotalConImpuestos.TotalImpuesto();
	}

	public LiquidacionCompras.InfoLiquidacionCompra.Pagos.Pago createFacturaInfoFacturaPagosPago() {
		return new LiquidacionCompras.InfoLiquidacionCompra.Pagos.Pago();
	}

}
