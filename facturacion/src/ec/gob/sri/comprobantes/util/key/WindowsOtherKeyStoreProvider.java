/*    */ package ec.gob.sri.comprobantes.util.key;
/*    */ 
/*    */ public class WindowsOtherKeyStoreProvider extends PKCS11KeyStoreProvider
/*    */ {
private static Object sb;
/* 32 */   private static final String config = sb.toString();
/*    */ 
/*    */   public String getConfig()
/*    */   {
/* 37 */     return config;
/*    */   }
/*    */ 
/*    */   static
/*    */   {
/* 28 */     StringBuffer sb = new StringBuffer();
/* 29 */     sb.append("name=Safenetikey2032\n");
/* 30 */     sb.append("library=C:\\WINDOWS\\SYSTEM32\\dkck201.dll\n");
/* 31 */     sb.append("disabledMechanisms={ CKM_SHA1_RSA_PKCS }");
/*    */   }
/*    */ }

/* Location:           C:\prolan\ce\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.key.WindowsOtherKeyStoreProvider
 * JD-Core Version:    0.6.2
 */