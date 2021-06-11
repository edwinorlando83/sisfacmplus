package ec.gob.sri.comprobantes.modelo.liquidacioncompra;

import ec.gob.sri.comprobantes.modelo.InfoTributaria;
import ec.gob.sri.comprobantes.modelo.factura.Impuesto;
import ec.gob.sri.comprobantes.modelo.liquidacioncompra.LiquidacionCompras.InfoLiquidacionCompra.TotalConImpuestos.TotalImpuesto;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = { "infoTributaria", "infoLiquidacionCompra", "detalles", "infoAdicional" })
@XmlRootElement(name = "liquidacionCompra")
public class LiquidacionCompras {

	public String getIvaPorcentaje() {
		String ivaporcentaje = "0";
		for (TotalImpuesto totalimpuesto : getInfoLiquidacionCompra().getTotalConImpuestos().getTotalImpuesto()) {

			if (totalimpuesto.getCodigoPorcentaje().trim().equals("2")) {
				ivaporcentaje = "12";
			}
			if (totalimpuesto.getCodigoPorcentaje().trim().equals("3")) {
				ivaporcentaje = "14";
			}
		}
		return ivaporcentaje;
	}

	@XmlElement(required = true)
	protected InfoTributaria infoTributaria;

	@XmlElement(required = true)
	protected InfoLiquidacionCompra infoLiquidacionCompra;

	@XmlElement(required = true)
	protected Detalles detalles;
	protected InfoAdicional infoAdicional;
	
 
	@XmlAttribute
	protected String id;

	@XmlAttribute
	@XmlSchemaType(name = "anySimpleType")
	protected String version;

	public InfoTributaria getInfoTributaria() {
		  return this.infoTributaria;
	}

	public void setInfoTributaria(InfoTributaria value) {
		  this.infoTributaria = value;
	}

	public InfoLiquidacionCompra getInfoLiquidacionCompra() {
	  return this.infoLiquidacionCompra;
	}

	public void setInfoFactura(InfoLiquidacionCompra value) {
		  this.infoLiquidacionCompra = value;
	}

	public Detalles getDetalles() {
	 return this.detalles;
	}

	public void setDetalles(Detalles value) {
	  this.detalles = value;
	}

	

	public InfoAdicional getInfoAdicional() {
	  return this.infoAdicional;
	}

	public void setInfoAdicional(InfoAdicional value) {
		  this.infoAdicional = value;
	}

	public String getId() {
	  return this.id;
	}

	public void setId(String value) {
		  this.id = value;
	}

	public String getVersion() {
		  return this.version;
	}

	public void setVersion(String value) {
	  this.version = value;
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "fechaEmision", "dirEstablecimiento", "contribuyenteEspecial",
			"obligadoContabilidad", "tipoIdentificacionProveedor", "guiaRemision", "razonSocialProveedor",
			"identificacionProveedor", "totalSinImpuestos", "totalSubsidio","totalDescuento", "totalConImpuestos", "propina",
			"importeTotal", "moneda" ,"pagos"})
	public static class InfoLiquidacionCompra {

		@XmlElement(required = true)
		protected String fechaEmision;

		@XmlElement(required = true)
		protected String dirEstablecimiento;
		protected String contribuyenteEspecial;
		protected String obligadoContabilidad;

		@XmlElement(required = true)
		protected String tipoIdentificacionProveedor;
		protected String guiaRemision;

		@XmlElement(required = true)
		protected String razonSocialProveedor;

		@XmlElement(required = true)
		protected String identificacionProveedor;

		@XmlElement(required = true)
		protected BigDecimal totalSinImpuestos;

		@XmlElement(required = true)
		protected BigDecimal totalDescuento;

		@XmlElement(required = true)
		protected TotalConImpuestos totalConImpuestos;
		 
		@XmlElement(required = true)
		protected BigDecimal propina;

		@XmlElement(required = true)
		protected BigDecimal importeTotal;
		protected String moneda;
		
		
		@XmlElement(required = false)
		protected BigDecimal totalSubsidio;
	 
		
		
		

		public BigDecimal getTotalSubsidio() {
			return totalSubsidio;
		}

		public void setTotalSubsidio(BigDecimal totalSubsidio) {
			this.totalSubsidio = totalSubsidio;
		}


		@XmlElement(required = true)
		protected Pagos pagos;
		
		public String getFechaEmision() {
			/* 1281 */ return this.fechaEmision;
		}

		public void setFechaEmision(String value) {
			/* 1293 */ this.fechaEmision = value;
		}

		public String getDirEstablecimiento() {
			/* 1305 */ return this.dirEstablecimiento;
		}

		public void setDirEstablecimiento(String value) {
			/* 1317 */ this.dirEstablecimiento = value;
		}

		public String getContribuyenteEspecial() {
			/* 1329 */ return this.contribuyenteEspecial;
		}

		public void setContribuyenteEspecial(String value) {
			/* 1341 */ this.contribuyenteEspecial = value;
		}

		public String getObligadoContabilidad() {
			/* 1353 */ return this.obligadoContabilidad;
		}

		public void setObligadoContabilidad(String value) {
			/* 1365 */ this.obligadoContabilidad = value;
		}

		public String getTipoIdentificacionProveedor () {
			/* 1377 */ return this.tipoIdentificacionProveedor;
		}

		public void setTipoIdentificacionProveedor (String value) {
			/* 1389 */ this.tipoIdentificacionProveedor = value;
		}

		public String getGuiaRemision() {
			/* 1401 */ return this.guiaRemision;
		}

		public void setGuiaRemision(String value) {
			/* 1413 */ this.guiaRemision = value;
		}

		public String getRazonSocialProveedor() {
			/* 1425 */ return this.razonSocialProveedor;
		}

		public void setRazonSocialProveedor(String value) {
			/* 1437 */ this.razonSocialProveedor = value;
		}

		public String getIdentificacionProveedor () {
			/* 1449 */ return this.identificacionProveedor;
		}

		public void setIdentificacionProveedor (String value) {
			/* 1461 */ this.identificacionProveedor = value;
		}

		public BigDecimal getTotalSinImpuestos() {
			/* 1473 */ return this.totalSinImpuestos;
		}

		public void setTotalSinImpuestos(BigDecimal value) {
			/* 1485 */ this.totalSinImpuestos = value;
		}

		public BigDecimal getTotalDescuento() {
			/* 1497 */ return this.totalDescuento;
		}

		public void setTotalDescuento(BigDecimal value) {
			/* 1509 */ this.totalDescuento = value;
		}

		public TotalConImpuestos getTotalConImpuestos() {
			/* 1521 */ return this.totalConImpuestos;
		}

		public void setTotalConImpuestos(TotalConImpuestos value) {
			/* 1533 */ this.totalConImpuestos = value;
		}

		public BigDecimal getPropina() {
			/* 1545 */ return this.propina;
		}

		public void setPropina(BigDecimal value) {
			/* 1557 */ this.propina = value;
		}

		public BigDecimal getImporteTotal() {
			/* 1569 */ return this.importeTotal;
		}

		public void setImporteTotal(BigDecimal value) {
			/* 1581 */ this.importeTotal = value;
		}

		public String getMoneda() {
			/* 1593 */ return this.moneda;
		}

		public void setMoneda(String value) {
			/* 1605 */ this.moneda = value;
		}

       public Pagos getPagos() {
		 return this.pagos;
		}

		public void setPagos(Pagos value) {
		  this.pagos = value;
		}
		 
		
		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "totalImpuesto" })
		public static class TotalConImpuestos {

			@XmlElement(required = true)
			protected List<TotalImpuesto> totalImpuesto;

			public List<TotalImpuesto> getTotalImpuesto() {
				/* 1674 */ if (this.totalImpuesto == null) {
					/* 1675 */ this.totalImpuesto = new ArrayList<TotalImpuesto> ();
				}
				/* 1677 */ return this.totalImpuesto;
			}

			@XmlAccessorType(XmlAccessType.FIELD)
			@XmlType(name = "", propOrder = { "codigo", "codigoPorcentaje", "baseImponible", "tarifa", "valor" })
			public static class TotalImpuesto {

				@XmlElement(required = true)
				protected String codigo;

				@XmlElement(required = true)
				protected String codigoPorcentaje;

				@XmlElement(required = true)
				protected BigDecimal baseImponible;
				protected BigDecimal tarifa;

				@XmlElement(required = true)
				protected BigDecimal valor;

				public String getCodigo() {
					/* 1733 */ return this.codigo;
				}

				public void setCodigo(String value) {
					/* 1745 */ this.codigo = value;
				}

				public String getCodigoPorcentaje() {
					/* 1757 */ return this.codigoPorcentaje;
				}

				public void setCodigoPorcentaje(String value) {
					/* 1769 */ this.codigoPorcentaje = value;
				}

				public BigDecimal getBaseImponible() {
					/* 1781 */ return this.baseImponible;
				}

				public void setBaseImponible(BigDecimal value) {
					/* 1793 */ this.baseImponible = value;
				}

				public BigDecimal getTarifa() {
					/* 1805 */ return this.tarifa;
				}

				public void setTarifa(BigDecimal value) {
					/* 1817 */ this.tarifa = value;
				}

				public BigDecimal getValor() {
					/* 1829 */ return this.valor;
				}

				public void setValor(BigDecimal value) {
					/* 1841 */ this.valor = value;
				}
			}
		}
			
		
		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "pago" })
		public static class Pagos {

			@XmlElement(required = true)
			protected List<Pago> pago;
			public List<Pago> getPago() {
				  if (this.pago == null) {
					  this.pago = new ArrayList<Pago> ();
				}
			  return this.pago;
			}

			@XmlAccessorType(XmlAccessType.FIELD)
			@XmlType(name = "", propOrder = { "formaPago", "total"  })
			public static class Pago {

				@XmlElement(required = true)
				protected String formaPago; 
				
				@XmlElement(required = true)		 
				protected BigDecimal total; 
				
				public String getFormaPago() {
					  return this.formaPago;
				}
				public void setFormaPago(String value) {
					    this.formaPago =value;
				}
				public BigDecimal getTotal() {
					  return this.total;
				}
				public  void setTotal(BigDecimal value) {
					    this.total =value;
				}
				 
			}
		}
		
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "campoAdicional" })
	public static class InfoAdicional {

		@XmlElement(required = true)
		protected List<CampoAdicional> campoAdicional;

		public List<CampoAdicional> getCampoAdicional() {
			/* 1084 */ if (this.campoAdicional == null) {
				/* 1085 */ this.campoAdicional = new ArrayList<CampoAdicional>();
			}
			/* 1087 */ return this.campoAdicional;
		}

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "value" })
		public static class CampoAdicional {

			@XmlValue
			protected String value;

			@XmlAttribute
			protected String nombre;

			public String getValue() {
			  return this.value;
			}

			public void setValue(String value) {
				  this.value = value;
			}

			public String getNombre() {
				  return this.nombre;
			}

			public void setNombre(String value) {
				  this.nombre = value;
			}
		}
	}

	@XmlAccessorType(XmlAccessType.FIELD)
	@XmlType(name = "", propOrder = { "detalle" })
	public static class Detalles {
 
		@XmlElement(required = true)
		protected List<Detalle> detalle;

		public List<Detalle> getDetalle() {
			/* 467 */ if (this.detalle == null) {
				/* 468 */ this.detalle = new ArrayList<Detalle>();
			}
			/* 470 */ return this.detalle;
		}

		@XmlAccessorType(XmlAccessType.FIELD)
		@XmlType(name = "", propOrder = { "codigoPrincipal", "codigoAuxiliar", "descripcion", "cantidad",
				"precioUnitario","precioSinSubsidio" ,"descuento", "precioTotalSinImpuesto", "detallesAdicionales", "impuestos" })
		public static class Detalle {

			@XmlElement(required = true)
			protected String codigoPrincipal;
			protected String codigoAuxiliar;

			@XmlElement(required = true)
			protected String descripcion;

			@XmlElement(required = true)
			protected BigDecimal cantidad;

			@XmlElement(required = true)
			protected BigDecimal precioUnitario;
			
			@XmlElement(required = false)
			protected BigDecimal precioSinSubsidio;
			
			

			public BigDecimal getPrecioSinSubsidio() {
				return precioSinSubsidio;
			}

			public void setPrecioSinSubsidio(BigDecimal precioSinSubsidio) {
				this.precioSinSubsidio = precioSinSubsidio;
			}

			@XmlElement(required = true)
			protected BigDecimal descuento;

			@XmlElement(required = true)
			protected BigDecimal precioTotalSinImpuesto;
			protected DetallesAdicionales detallesAdicionales;

			@XmlElement(required = true)
			protected Impuestos impuestos;

			public String getCodigoPrincipal() {
				/* 582 */ return this.codigoPrincipal;
			}

			public void setCodigoPrincipal(String value) {
				/* 594 */ this.codigoPrincipal = value;
			}

			public String getCodigoAuxiliar() {
				/* 606 */ return this.codigoAuxiliar;
			}

			public void setCodigoAuxiliar(String value) {
				/* 618 */ this.codigoAuxiliar = value;
			}

			public String getDescripcion() {
				/* 630 */ return this.descripcion;
			}

			public void setDescripcion(String value) {
				/* 642 */ this.descripcion = value;
			}

			public BigDecimal getCantidad() {
				/* 654 */ return this.cantidad;
			}

			public void setCantidad(BigDecimal value) {
				/* 666 */ this.cantidad = value;
			}

			public BigDecimal getPrecioUnitario() {
				/* 678 */ return this.precioUnitario;
			}

			public void setPrecioUnitario(BigDecimal value) {
				/* 690 */ this.precioUnitario = value;
			}

			public BigDecimal getDescuento() {
				/* 702 */ return this.descuento;
			}

			public void setDescuento(BigDecimal value) {
				/* 714 */ this.descuento = value;
			}

			public BigDecimal getPrecioTotalSinImpuesto() {
				/* 726 */ return this.precioTotalSinImpuesto;
			}

			public void setPrecioTotalSinImpuesto(BigDecimal value) {
				/* 738 */ this.precioTotalSinImpuesto = value;
			}

			public DetallesAdicionales getDetallesAdicionales() {
				/* 750 */ return this.detallesAdicionales;
			}

			public void setDetallesAdicionales(DetallesAdicionales value) {
				/* 762 */ this.detallesAdicionales = value;
			}

			public Impuestos getImpuestos() {
				/* 774 */ return this.impuestos;
			}

			public void setImpuestos(Impuestos value) {
				/* 786 */ this.impuestos = value;
			}

			@XmlAccessorType(XmlAccessType.FIELD)
			@XmlType(name = "", propOrder = { "impuesto" })
			public static class Impuestos {

				@XmlElement(required = true)
				protected List<Impuesto> impuesto;

				public List<Impuesto> getImpuesto() {
					/* 1012 */ if (this.impuesto == null) {
						/* 1013 */ this.impuesto = new ArrayList<Impuesto>();
					}
					/* 1015 */ return this.impuesto;
				}
			}

			@XmlAccessorType(XmlAccessType.FIELD)
			@XmlType(name = "", propOrder = { "detAdicional" })
			public static class DetallesAdicionales {

				@XmlElement(required = true)
				protected List<DetAdicional> detAdicional;

				public List<DetAdicional> getDetAdicional() {
					/* 862 */ if (this.detAdicional == null) {
						/* 863 */ this.detAdicional = new ArrayList<DetAdicional>();
					}
					/* 865 */ return this.detAdicional;
				}

				@XmlAccessorType(XmlAccessType.FIELD)
				@XmlType(name = "")
				public static class DetAdicional {

					@XmlAttribute
					protected String nombre;

					@XmlAttribute
					protected String valor;

					public String getNombre() {
						/* 917 */ return this.nombre;
					}

					public void setNombre(String value) {
						/* 929 */ this.nombre = value;
					}

					public String getValor() {
						/* 941 */ return this.valor;
					}

					public void setValor(String value) {
						/* 953 */ this.valor = value;
					}
				}
			}
		}
	}
	
	
	
}
 