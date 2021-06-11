/*    */ package ec.gob.sri.comprobantes.util;
/*    */ 
/*    */ import java.util.StringTokenizer;
/*    */ 
/*    */ public class X500NameGeneral
/*    */ {
/*  8 */   private String CN = null;
/*  9 */   private String OU = null;
/* 10 */   private String O = null;
/* 11 */   private String L = null;
/* 12 */   private String ST = null;
/* 13 */   private String C = null;
/*    */ 
/*    */   public X500NameGeneral(String name) {
/* 16 */     StringTokenizer st = new StringTokenizer(name, ",");
/*    */ 
/* 18 */     while (st.hasMoreTokens()) {
/* 19 */       String token = st.nextToken().trim();
/* 20 */       int idx = token.indexOf("=");
/* 21 */       if (idx >= 0) {
/* 22 */         String label = token.substring(0, idx);
/* 23 */         String value = token.substring(idx + 1);
/*    */ 
/* 25 */         if ("CN".equals(label))
/* 26 */           this.CN = value;
/* 27 */         else if ("OU".equals(label))
/* 28 */           this.OU = value;
/* 29 */         else if ("O".equals(label))
/* 30 */           this.O = value;
/* 31 */         else if ("C".equals(label))
/* 32 */           this.C = value;
/* 33 */         else if ("L".equals(label))
/* 34 */           this.L = value;
/* 35 */         else if ("ST".equals(label))
/* 36 */           this.ST = value;
/*    */       }
/*    */     }
/*    */   }
/*    */ 
/*    */   public String getC()
/*    */   {
/* 45 */     return this.C;
/*    */   }
/*    */ 
/*    */   public String getCN()
/*    */   {
/* 51 */     return this.CN;
/*    */   }
/*    */ 
/*    */   public String getL()
/*    */   {
/* 57 */     return this.L;
/*    */   }
/*    */ 
/*    */   public String getO()
/*    */   {
/* 63 */     return this.O;
/*    */   }
/*    */ 
/*    */   public String getOU()
/*    */   {
/* 69 */     return this.OU;
/*    */   }
/*    */ 
/*    */   public String getST()
/*    */   {
/* 75 */     return this.ST;
/*    */   }
/*    */ }

/* Location:           C:\prolan\ce\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.X500NameGeneral
 * JD-Core Version:    0.6.2
 */