package org.cs.basic.weixin.common;

import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import javax.net.ssl.X509TrustManager;

/**
 * 验证远端的安全套接字
 * @author xuxile
 *
 */
public class TrustAnyTrustManager implements X509TrustManager{

	public void checkClientTrusted(X509Certificate[] chain, String authType)
			throws CertificateException {
		
	}

	public void checkServerTrusted(X509Certificate[] chain, String authType)
			throws CertificateException {
		
	}

	public X509Certificate[] getAcceptedIssuers() {
		return null;
	}

}
