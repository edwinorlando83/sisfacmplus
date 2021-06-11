/*     */ package ec.gob.sri.comprobantes.util.xml;
/*     */ 
/*     */ import ec.gob.sri.comprobantes.modelo.factura.Factura;
/*     */ import ec.gob.sri.comprobantes.modelo.guia.GuiaRemision;
/*     */ import ec.gob.sri.comprobantes.modelo.notacredito.NotaCredito;
/*     */ import ec.gob.sri.comprobantes.modelo.notadebito.NotaDebito;
/*     */ import ec.gob.sri.comprobantes.modelo.rentencion.ComprobanteRetencion;
/*     */ import ec.gob.sri.comprobantes.ws.RespuestaSolicitud;
/*     */ import java.io.FileOutputStream;
/*     */ import java.io.OutputStreamWriter;
/*     */ import java.util.logging.Level;
/*     */ import java.util.logging.Logger;
/*     */ import javax.xml.bind.JAXBContext;
/*     */ import javax.xml.bind.Marshaller;
/*     */ 
/*     */ public class Java2XML
/*     */ {
/*     */   public static String marshalFactura(Factura comprobante, String pathArchivoSalida)
/*     */   {
/*  30 */     String respuesta = null;
/*     */     try
/*     */     {
/*  33 */       JAXBContext context = JAXBContext.newInstance(new Class[] { Factura.class });
/*  34 */       Marshaller marshaller = context.createMarshaller();
/*  35 */       marshaller.setProperty("jaxb.encoding", "UTF-8");
/*  36 */       marshaller.setProperty("jaxb.formatted.output", Boolean.valueOf(true));
/*  37 */       OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(pathArchivoSalida), "UTF-8");
/*  38 */       marshaller.marshal(comprobante, out);
/*     */     }
/*     */     catch (Exception ex) {
/*  41 */       Logger.getLogger(Java2XML.class.getName()).log(Level.SEVERE, null, ex);
/*  42 */       return ex.getMessage();
/*     */     }
/*  44 */     return respuesta;
/*     */   }
/*     */ 
/*     */   public static String marshalNotaDeDebito(NotaDebito comprobante, String pathArchivoSalida) {
/*  48 */     String respuesta = null;
/*     */     try
/*     */     {
/*  51 */       JAXBContext context = JAXBContext.newInstance(new Class[] { NotaDebito.class });
/*  52 */       Marshaller marshaller = context.createMarshaller();
/*  53 */       marshaller.setProperty("jaxb.encoding", "UTF-8");
/*  54 */       marshaller.setProperty("jaxb.formatted.output", Boolean.valueOf(true));
/*  55 */       OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(pathArchivoSalida), "UTF-8");
/*  56 */       marshaller.marshal(comprobante, out);
/*     */     } catch (Exception ex) {
/*  58 */       Logger.getLogger(Java2XML.class.getName()).log(Level.SEVERE, null, ex);
/*  59 */       return ex.getMessage();
/*     */     }
/*  61 */     return respuesta;
/*     */   }
/*     */ 
/*     */   public static String marshalNotaDeCredito(NotaCredito comprobante, String pathArchivoSalida) {
/*  65 */     String respuesta = null;
/*     */     try
/*     */     {
/*  68 */       JAXBContext context = JAXBContext.newInstance(new Class[] { NotaCredito.class });
/*  69 */       Marshaller marshaller = context.createMarshaller();
/*  70 */       marshaller.setProperty("jaxb.encoding", "UTF-8");
/*  71 */       marshaller.setProperty("jaxb.formatted.output", Boolean.valueOf(true));
/*  72 */       OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(pathArchivoSalida), "UTF-8");
/*  73 */       marshaller.marshal(comprobante, out);
/*     */     } catch (Exception ex) {
/*  75 */       Logger.getLogger(Java2XML.class.getName()).log(Level.SEVERE, null, ex);
/*  76 */       return ex.getMessage();
/*     */     }
/*  78 */     return respuesta;
/*     */   }
/*     */ 
/*     */   public static String marshalComprobanteRetencion(ComprobanteRetencion comprobante, String pathArchivoSalida) {
/*  82 */     String respuesta = null;
/*     */     try
/*     */     {
/*  85 */       JAXBContext context = JAXBContext.newInstance(new Class[] { ComprobanteRetencion.class });
/*  86 */       Marshaller marshaller = context.createMarshaller();
/*  87 */       marshaller.setProperty("jaxb.encoding", "UTF-8");
/*  88 */       marshaller.setProperty("jaxb.formatted.output", Boolean.valueOf(true));
/*  89 */       OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(pathArchivoSalida), "UTF-8");
/*  90 */       marshaller.marshal(comprobante, out);
/*     */     } catch (Exception ex) {
/*  92 */       Logger.getLogger(Java2XML.class.getName()).log(Level.SEVERE, null, ex);
/*  93 */       return ex.getMessage();
/*     */     }
/*  95 */     return respuesta;
/*     */   }
/*     */ 
/*     */   public static String marshalGuiaRemision(GuiaRemision comprobante, String pathArchivoSalida) {
/*  99 */     String respuesta = null;
/*     */     try
/*     */     {
/* 102 */       JAXBContext context = JAXBContext.newInstance(new Class[] { GuiaRemision.class });
/* 103 */       Marshaller marshaller = context.createMarshaller();
/* 104 */       marshaller.setProperty("jaxb.encoding", "UTF-8");
/* 105 */       marshaller.setProperty("jaxb.formatted.output", Boolean.valueOf(true));
/* 106 */       OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(pathArchivoSalida), "UTF-8");
/* 107 */       marshaller.marshal(comprobante, out);
/*     */     } catch (Exception ex) {
/* 109 */       Logger.getLogger(Java2XML.class.getName()).log(Level.SEVERE, null, ex);
/* 110 */       return ex.getMessage();
/*     */     }
/* 112 */     return respuesta;
/*     */   }
/*     */ 
/*     */   public static String marshalRespuestaSolicitud(RespuestaSolicitud respuesta, String pathArchivoSalida)
/*     */   {
/*     */     try
/*     */     {
/* 119 */       JAXBContext context = JAXBContext.newInstance(new Class[] { RespuestaSolicitud.class });
/* 120 */       Marshaller marshaller = context.createMarshaller();
/* 121 */       marshaller.setProperty("jaxb.encoding", "UTF-8");
/* 122 */       marshaller.setProperty("jaxb.formatted.output", Boolean.valueOf(true));
/* 123 */       OutputStreamWriter out = new OutputStreamWriter(new FileOutputStream(pathArchivoSalida), "UTF-8");
/* 124 */       marshaller.marshal(respuesta, out);
/*     */     } catch (Exception ex) {
/* 126 */       Logger.getLogger(Java2XML.class.getName()).log(Level.SEVERE, null, ex);
/* 127 */       return ex.getMessage();
/*     */     }
/* 129 */     return null;
/*     */   }
/*     */ }

/* Location:           C:\prolan\ce\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.xml.Java2XML
 * JD-Core Version:    0.6.2
 */