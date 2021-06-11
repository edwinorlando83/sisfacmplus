/*    */ package ec.gob.sri.comprobantes.util.xml;
/*    */ 
/*    */ import com.thoughtworks.xstream.converters.Converter;
/*    */ import com.thoughtworks.xstream.converters.MarshallingContext;
/*    */ import com.thoughtworks.xstream.converters.UnmarshallingContext;
/*    */ import com.thoughtworks.xstream.io.HierarchicalStreamReader;
/*    */ import com.thoughtworks.xstream.io.HierarchicalStreamWriter;
/*    */ import ec.gob.sri.comprobantes.modelo.ComprobanteXml;
/*    */ 
/*    */ public class ComprobanteXmlConverter
/*    */   implements Converter
/*    */ {
	@SuppressWarnings("rawtypes")
/*    */   public boolean canConvert(Class clazz)
/*    */   {
/* 24 */     return clazz.equals(ComprobanteXml.class);
/*    */   }
/*    */ 
/*    */   public void marshal(Object o, HierarchicalStreamWriter writer, MarshallingContext mc) {
/* 28 */     ComprobanteXml i = (ComprobanteXml)o;
/*    */ 
/* 32 */     writer.setValue(i.getFileXML());
/*    */   }
/*    */ 
/*    */   public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext uc) {
/* 36 */     ComprobanteXml item = new ComprobanteXml();
/* 37 */     item.setTipo(reader.getAttribute("tipo"));
/* 38 */     item.setVersion(reader.getAttribute("version"));
/* 39 */     item.setFileXML(reader.getValue());
/*    */ 
/* 41 */     return item;
/*    */   }
/*    */ }

/* Location:           C:\prolan\ce\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.xml.ComprobanteXmlConverter
 * JD-Core Version:    0.6.2
 */