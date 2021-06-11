/*     */ package ec.gob.sri.comprobantes.ws.aut;
/*     */ 
/*     */ import javax.xml.bind.JAXBElement;
/*     */ import javax.xml.bind.annotation.XmlElementDecl;
/*     */ import javax.xml.bind.annotation.XmlRegistry;
/*     */ import javax.xml.namespace.QName;
/*     */ 
/*     */ @XmlRegistry
/*     */ public class ObjectFactory
/*     */ {
/*  27 */   private static final QName _AutorizacionComprobanteLote_QNAME = new QName("http://ec.gob.sri.ws.autorizacion", "autorizacionComprobanteLote");
/*  28 */   private static final QName _RespuestaAutorizacion_QNAME = new QName("http://ec.gob.sri.ws.autorizacion", "RespuestaAutorizacion");
/*  29 */   private static final QName _AutorizacionComprobanteResponse_QNAME = new QName("http://ec.gob.sri.ws.autorizacion", "autorizacionComprobanteResponse");
/*  30 */   private static final QName _AutorizacionComprobanteLoteResponse_QNAME = new QName("http://ec.gob.sri.ws.autorizacion", "autorizacionComprobanteLoteResponse");
/*  31 */   private static final QName _AutorizacionComprobante_QNAME = new QName("http://ec.gob.sri.ws.autorizacion", "autorizacionComprobante");
/*  32 */   private static final QName _Autorizacion_QNAME = new QName("http://ec.gob.sri.ws.autorizacion", "autorizacion");
/*  33 */   private static final QName _Mensaje_QNAME = new QName("http://ec.gob.sri.ws.autorizacion", "mensaje");
/*     */ 
/*     */   public Autorizacion createAutorizacion()
/*     */   {
/*  47 */     return new Autorizacion();
/*     */   }
/*     */ 
/*     */   public RespuestaLote createRespuestaLote()
/*     */   {
/*  55 */     return new RespuestaLote();
/*     */   }
/*     */ 
/*     */   public Autorizacion.Mensajes createAutorizacionMensajes()
/*     */   {
/*  63 */     return new Autorizacion.Mensajes();
/*     */   }
/*     */ 
/*     */   public RespuestaLote.Autorizaciones createRespuestaLoteAutorizaciones()
/*     */   {
/*  71 */     return new RespuestaLote.Autorizaciones();
/*     */   }
/*     */ 
/*     */   public Mensaje createMensaje()
/*     */   {
/*  79 */     return new Mensaje();
/*     */   }
/*     */ 
/*     */   public AutorizacionComprobanteLote createAutorizacionComprobanteLote()
/*     */   {
/*  87 */     return new AutorizacionComprobanteLote();
/*     */   }
/*     */ 
/*     */   public RespuestaComprobante createRespuestaComprobante()
/*     */   {
/*  95 */     return new RespuestaComprobante();
/*     */   }
/*     */ 
/*     */   public AutorizacionComprobanteResponse createAutorizacionComprobanteResponse()
/*     */   {
/* 103 */     return new AutorizacionComprobanteResponse();
/*     */   }
/*     */ 
/*     */   public AutorizacionComprobante createAutorizacionComprobante()
/*     */   {
/* 111 */     return new AutorizacionComprobante();
/*     */   }
/*     */ 
/*     */   public RespuestaComprobante.Autorizaciones createRespuestaComprobanteAutorizaciones()
/*     */   {
/* 119 */     return new RespuestaComprobante.Autorizaciones();
/*     */   }
/*     */ 
/*     */   public AutorizacionComprobanteLoteResponse createAutorizacionComprobanteLoteResponse()
/*     */   {
/* 127 */     return new AutorizacionComprobanteLoteResponse();
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="http://ec.gob.sri.ws.autorizacion", name="autorizacionComprobanteLote")
/*     */   public JAXBElement<AutorizacionComprobanteLote> createAutorizacionComprobanteLote(AutorizacionComprobanteLote value)
/*     */   {
/* 136 */     return new JAXBElement<AutorizacionComprobanteLote>(_AutorizacionComprobanteLote_QNAME, AutorizacionComprobanteLote.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="http://ec.gob.sri.ws.autorizacion", name="RespuestaAutorizacion")
/*     */   public JAXBElement<Object> createRespuestaAutorizacion(Object value)
/*     */   {
/* 145 */     return new JAXBElement<Object>(_RespuestaAutorizacion_QNAME, Object.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="http://ec.gob.sri.ws.autorizacion", name="autorizacionComprobanteResponse")
/*     */   public JAXBElement<AutorizacionComprobanteResponse> createAutorizacionComprobanteResponse(AutorizacionComprobanteResponse value)
/*     */   {
/* 154 */     return new JAXBElement<AutorizacionComprobanteResponse>(_AutorizacionComprobanteResponse_QNAME, AutorizacionComprobanteResponse.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="http://ec.gob.sri.ws.autorizacion", name="autorizacionComprobanteLoteResponse")
/*     */   public JAXBElement<AutorizacionComprobanteLoteResponse> createAutorizacionComprobanteLoteResponse(AutorizacionComprobanteLoteResponse value)
/*     */   {
/* 163 */     return new JAXBElement<AutorizacionComprobanteLoteResponse>(_AutorizacionComprobanteLoteResponse_QNAME, AutorizacionComprobanteLoteResponse.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="http://ec.gob.sri.ws.autorizacion", name="autorizacionComprobante")
/*     */   public JAXBElement<AutorizacionComprobante> createAutorizacionComprobante(AutorizacionComprobante value)
/*     */   {
/* 172 */     return new JAXBElement<AutorizacionComprobante>(_AutorizacionComprobante_QNAME, AutorizacionComprobante.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="http://ec.gob.sri.ws.autorizacion", name="autorizacion")
/*     */   public JAXBElement<Autorizacion> createAutorizacion(Autorizacion value)
/*     */   {
/* 181 */     return new JAXBElement<Autorizacion>(_Autorizacion_QNAME, Autorizacion.class, null, value);
/*     */   }
/*     */ 
/*     */   @XmlElementDecl(namespace="http://ec.gob.sri.ws.autorizacion", name="mensaje")
/*     */   public JAXBElement<Mensaje> createMensaje(Mensaje value)
/*     */   {
/* 190 */     return new JAXBElement<Mensaje>(_Mensaje_QNAME, Mensaje.class, null, value);
/*     */   }
/*     */ }

/* Location:           C:\componentes-1.1.7-with-deps\componentes-1.1.7\deps\cliente-file-ws.jar
 * Qualified Name:     ec.gob.sri.comprobantes.ws.aut.ObjectFactory
 * JD-Core Version:    0.6.2
 */