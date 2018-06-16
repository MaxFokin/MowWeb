package com.MowWeb.services.rest;

import com.sun.net.httpserver.HttpServer;
import java.net.URI;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.UnrecoverableKeyException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import javax.ws.rs.core.UriBuilder;
import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
import org.glassfish.jersey.server.ResourceConfig;

public final class RSPublisher {
	
	private final int port = 8080;
	private final String host="https://localhost/";
	ResourceConfig config = new Application();
	 
	public void run() {
		URI baseUri = UriBuilder.fromUri(host).port(port).build();
		
		// Create a trust manager that does not validate certificate chains
		TrustManager[] trustAllCerts = new TrustManager[]{new X509TrustManager(){
		    public X509Certificate[] getAcceptedIssuers(){return null;}
		    public void checkClientTrusted(X509Certificate[] certs, String authType){}
		    public void checkServerTrusted(X509Certificate[] certs, String authType){}
		}};

		SSLContext sc = null;
		// Install the all-trusting trust manager
		try {
		    sc = SSLContext.getInstance("TLS");
		    sc.init(null, trustAllCerts, new SecureRandom());
		    HttpsURLConnection.setDefaultSSLSocketFactory(sc.getSocketFactory());
		} catch (Exception e) {
		    ;
		}
		
		HttpServer server = JdkHttpServerFactory.createHttpServer(baseUri, config, sc);
		
		System.out.println("*** RESTful Service Has Started ***\n\t@ " +
							baseUri + "rest/");
	}
}