/*    */ package ec.gob.sri.comprobantes.util.xml;
/*    */ import java.text.ParseException;
/*    */ import java.util.Date;
/*    */ import java.util.GregorianCalendar;
/*    */ import java.util.logging.Level;
/*    */ import java.util.logging.Logger;

/*    */ 
/*    */ import com.sun.org.apache.xerces.internal.jaxp.datatype.XMLGregorianCalendarImpl;
/*    */ import com.thoughtworks.xstream.converters.Converter;
/*    */ import com.thoughtworks.xstream.converters.MarshallingContext;
/*    */ import com.thoughtworks.xstream.converters.UnmarshallingContext;
/*    */ import com.thoughtworks.xstream.io.HierarchicalStreamReader;
/*    */ import com.thoughtworks.xstream.io.HierarchicalStreamWriter;

/*    */ import ec.gob.sri.comprobantes.util.Constantes;
/*    */ 
/*    */ public class RespuestaDateConverter
/*    */   implements Converter
/*    */ {
/*    */   @SuppressWarnings("rawtypes")
public boolean canConvert(Class clazz)
/*    */   {
/* 30 */     return clazz.equals(XMLGregorianCalendarImpl.class);
/*    */   }
/*    */ 
/*    */   public void marshal(Object o, HierarchicalStreamWriter writer, MarshallingContext mc) {
/* 34 */     XMLGregorianCalendarImpl i = (XMLGregorianCalendarImpl)o;
/* 35 */     writer.setValue(Constantes.dateTimeFormat.format(i.toGregorianCalendar().getTime()));
/*    */   }
/*    */ 
/*    */   public Object unmarshal(HierarchicalStreamReader reader, UnmarshallingContext uc)
/*    */   {
/* 40 */     Date date = null;
/*    */     try {
/* 42 */       date = Constantes.dateTimeFormat.parse(reader.getValue());
/*    */     } catch (ParseException ex) {
/* 44 */       Logger.getLogger(RespuestaDateConverter.class.getName()).log(Level.SEVERE, null, ex);
/*    */     }
/* 46 */     GregorianCalendar cal = new GregorianCalendar();
/* 47 */     cal.setTime(date);
/* 48 */     XMLGregorianCalendarImpl item = new XMLGregorianCalendarImpl(cal);
/*    */ 
/* 50 */     return item;
/*    */   }
/*    */ }

/* Location:           C:\prolan\ce\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.xml.RespuestaDateConverter
 * JD-Core Version:    0.6.2
 */