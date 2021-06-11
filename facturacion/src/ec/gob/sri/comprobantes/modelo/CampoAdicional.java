/*    */ package ec.gob.sri.comprobantes.modelo;
/*    */ 
/*    */ public class CampoAdicional
/*    */ {
/*    */   private String nombre;
/*    */   private String valor;
/*    */ 
/*    */   public CampoAdicional()
/*    */   {
/*    */   }
/*    */ 
/*    */   public CampoAdicional(String nombre, String valor)
/*    */   {
/* 23 */     this.nombre = nombre;
/* 24 */     this.valor = valor;
/*    */   }
/*    */ 
/*    */   public String getNombre() {
/* 28 */     return this.nombre;
/*    */   }
/*    */ 
/*    */   public void setNombre(String nombre) {
/* 32 */     this.nombre = nombre;
/*    */   }
/*    */ 
/*    */   public String getValor() {
/* 36 */     return this.valor;
/*    */   }
/*    */ 
/*    */   public void setValor(String valor) {
/* 40 */     this.valor = valor;
/*    */   }
/*    */ }

/* Location:           C:\prolan\ce\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.modelo.CampoAdicional
 * JD-Core Version:    0.6.2
 */