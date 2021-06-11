/*    */ package ec.gob.sri.comprobantes.util.key;
/*    */ 
/*    */ import java.io.IOException;
/*    */ import java.security.KeyStore;
/*    */ import java.security.KeyStoreException;
/*    */ import java.security.NoSuchAlgorithmException;
/*    */ import java.security.NoSuchProviderException;
/*    */ import java.security.cert.CertificateException;
/*    */ 
/*    */ public class AppleKeyStoreProvider
/*    */   implements KeyStoreProvider
/*    */ {
/*    */     static final String APPLE_PROVIDER_TYPE = "KeychainStore";
/*    */     static final String APPLE_PROVIDER_NAME = "Apple";
/*    */ 
/*    */   public KeyStore getKeystore(char[] password)
/*    */     throws KeyStoreException
/*    */   {
/*    */     try
/*    */     {
/* 33 */       KeyStore keyStore = KeyStore.getInstance("KeychainStore", "Apple");
/* 34 */       keyStore.load(null, null);
/* 35 */       return keyStore;
/*    */     } catch (NoSuchProviderException e) {
/* 37 */       throw new KeyStoreException(e);
/*    */     } catch (NoSuchAlgorithmException e) {
/* 39 */       throw new KeyStoreException(e);
/*    */     } catch (CertificateException e) {
/* 41 */       throw new KeyStoreException(e);
/*    */     } catch (IOException e) {
/* 43 */       throw new KeyStoreException(e);
/*    */     }
/*    */   }
/*    */ }

/* Location:           C:\prolan\ce\ComprobantesDesktop.jar
 * Qualified Name:     ec.gob.sri.comprobantes.util.key.AppleKeyStoreProvider
 * JD-Core Version:    0.6.2
 */