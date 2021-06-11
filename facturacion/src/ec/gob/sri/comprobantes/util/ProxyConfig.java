  package ec.gob.sri.comprobantes.util;
  
  import java.net.Authenticator;
import java.net.InetSocketAddress;
import java.net.PasswordAuthentication;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.URI;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
  
  public class ProxyConfig
  {
      static String host;
      static int port;
      static Proxy proxy;
  
    public static void init(String uri)
    {
/* 31 */     System.setProperty("java.net.useSystemProxies", "true");
/* 32 */     System.setProperty("javax.net.ssl.trustStore", "resources/jssecacerts");
/* 33 */     System.setProperty("javax.net.ssl.trustStorePassword", "changeit");
  
/* 35 */     proxy = getProxy(uri);
/* 36 */     if ((proxy != null) && (!proxy.type().toString().equals("DIRECT"))) {
/* 37 */       InetSocketAddress addr = (InetSocketAddress)proxy.address();
/* 38 */       host = addr.getHostName();
/* 39 */       port = addr.getPort();
      }
      else
      {
/* 56 */       System.setProperty("java.net.useSystemProxies", "true");
      }
    }
  
    private static Proxy getProxy(String uri)
    {
/* 63 */     List<Proxy> l = null;
      try {
/* 65 */       ProxySelector def = ProxySelector.getDefault();
  
/* 68 */       l = def.select(new URI("http://proxy/test"));
/* 69 */       ProxySelector.setDefault(ProxySelector.getDefault());
      } catch (Exception e) {
/* 71 */       Logger.getLogger(ProxyConfig.class.getName()).log(Level.SEVERE, null, e);
      }
/* 73 */     if (l != null) {
/* 74 */       Iterator<Proxy> iter = l.iterator(); if (iter.hasNext()) {
/* 75 */         Proxy proxy = (Proxy)iter.next();
/* 76 */         return proxy;
        }
      }
/* 79 */     return null;
    }
    public static class ProxyAuthenticator extends Authenticator {
      private String userName;
      private String password;
  
      protected PasswordAuthentication getPasswordAuthentication() {
/* 87 */       return new PasswordAuthentication(this.userName, this.password.toCharArray());
      }
  
      public ProxyAuthenticator(String userName, String password) {
/* 91 */       this.userName = userName;
/* 92 */       this.password = password;
      }
    }
  }

 