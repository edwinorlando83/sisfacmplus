/*     */ package ec.gob.sri.comprobantes.ws;
/*     */ 
/*     */ import javax.xml.bind.JAXBElement;
/*     */ import javax.xml.bind.annotation.XmlElementDecl;
/*     */ import javax.xml.bind.annotation.XmlRegistry;
/*     */ import javax.xml.namespace.QName;
/*     */ 
/*     */ @XmlRegistry
/*     */ public class ObjectFactory
/*     */ {
/*  27 */   private static final QName _ValidarComprobante_QNAME = new QName("http://ec.gob.sri.ws.recepcion", "validarComprobante");
/*  28 */   private static final QName _ValidarComprobanteResponse_QNAME = new QName("http://ec.gob.sri.ws.recepcion", "validarComprobanteResponse");
/*  29 */   private static final QName _Mensaje_QNAME = new QName("http://ec.gob.sri.ws.recepcion", "mensaje");
/*  30 */   private static final QName _RespuestaSolicitud_QNAME = new QName("http://ec.gob.sri.ws.recepcion", "RespuestaSolicitud");
/*  31 */   private static final QName _Comprobante_QNAME = new QName("http://ec.gob.sri.ws.recepcion", "comprobante");
/*     */ 
/*     */   public Comprobante.Mensajes createComprobanteMensajes()
/*     */   {
/*  45 */     return new Comprobante.Mensajes();
/*     */   }
/*     */ 
/*     */   public ValidarComprobante createValidarComprobante()
/*     */   {
/*  53 */     return new ValidarComprobante();
/*     */   }
/*     */ 
/*     */   public RespuestaSolicitud createRespuestaSolicitud()
/*     */   {
/*  61 */     return new RespuestaSolicitud();
/*     */   }
/*     */ 
/*     */   public Comprobante createComprobante()
/*     */   {
/*  69 */     return new Comprobante();
/*     */   }
/*     */ 
/*     */   public ValidarComprobanteResponse createValidarComprobanteResponse()
/*     */   {
/*  77 */     return new ValidarComprobanteResponse();
/*     */   }
/*     */ 
/*     */   public Mensaje createMensaje()
/*     */   {
/*  85 */     return new Mensaje();
/*     */   }
/*     */ 
/*     */   public RespuestaSolicitud.Comprobantes createRespuestaSolicitudComprobantes()
/*     */   {
/*  93 */     return new RespuestaSolicitud.Comprobantes();
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="http://ec.gob.sri.ws.recepcion", name="validarComprobante")
/*     */   public JAXBElement<ValidarComprobante> createValidarComprobante(ValidarComprobante value)
/*     */   {
/* 102 */     return new JAXBElement<ValidarComprobante>(_ValidarComprobante_QNAME, ValidarComprobante.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="http://ec.gob.sri.ws.recepcion", name="validarComprobanteResponse")
/*     */   public JAXBElement<ValidarComprobanteResponse> createValidarComprobanteResponse(ValidarComprobanteResponse value)
/*     */   {
/* 111 */     return new JAXBElement<ValidarComprobanteResponse>(_ValidarComprobanteResponse_QNAME, ValidarComprobanteResponse.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="http://ec.gob.sri.ws.recepcion", name="mensaje")
/*     */   public JAXBElement<Mensaje> createMensaje(Mensaje value)
/*     */   {
/* 120 */     return new JAXBElement<Mensaje>(_Mensaje_QNAME, Mensaje.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="http://ec.gob.sri.ws.recepcion", name="RespuestaSolicitud")
/*     */   public JAXBElement<RespuestaSolicitud> createRespuestaSolicitud(RespuestaSolicitud value)
/*     */   {
/* 129 */     return new JAXBElement<RespuestaSolicitud>(_RespuestaSolicitud_QNAME, RespuestaSolicitud.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="http://ec.gob.sri.ws.recepcion", name="comprobante")
/*     */   public JAXBElement<Comprobante> createComprobante(Comprobante value)
/*     */   {
/* 138 */     return new JAXBElement<Comprobante>(_Comprobante_QNAME, Comprobante.class, null, value);
/*     */   }
/*     */ }

/* Location:           C:\componentes-1.1.7-with-deps\componentes-1.1.7\deps\cliente-file-ws.jar
 * Qualified Name:     ec.gob.sri.comprobantes.ws.ObjectFactory
 * JD-Core Version:    0.6.2
 */