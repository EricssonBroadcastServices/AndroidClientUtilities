package net.ericsson.emovs.utilities.security;

import android.os.Build;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;

/**
 * Created by Frederico Duarte on 2018-08-21.
 */
public class CustomSSLSocketFactory extends SSLSocketFactory {

    private SSLSocketFactory mDelegateSSLSocketFactory;

    private final String TLS_PROTOCOL = "TLS";
    private final String[] TLS_SUPPORTED_PROTOCOLS = { "TLSv1.1" , "TLSv1.2" };

    public static CustomSSLSocketFactory createSSLSocketFactory()
            throws KeyManagementException, NoSuchAlgorithmException {
        return new CustomSSLSocketFactory();
    }

    private CustomSSLSocketFactory() throws KeyManagementException, NoSuchAlgorithmException {
        SSLContext sslContext = SSLContext.getInstance(TLS_PROTOCOL);

        sslContext.init(null, null, null);

        mDelegateSSLSocketFactory = sslContext.getSocketFactory();
    }

    @Override
    public String[] getDefaultCipherSuites() {
        return mDelegateSSLSocketFactory.getDefaultCipherSuites();
    }

    @Override
    public String[] getSupportedCipherSuites() {
        return mDelegateSSLSocketFactory.getSupportedCipherSuites();
    }

    @Override
    public Socket createSocket() throws IOException {
        return enableTlsOnSocket(mDelegateSSLSocketFactory.createSocket());
    }

    @Override
    public Socket createSocket(Socket socket, String host,
                               int port, boolean autoClose) throws IOException {
        return enableTlsOnSocket(mDelegateSSLSocketFactory.createSocket(socket, host,
                                                                        port, autoClose));
    }

    @Override
    public Socket createSocket(String host, int port) throws IOException {
        return enableTlsOnSocket(mDelegateSSLSocketFactory.createSocket(host, port));
    }

    @Override
    public Socket createSocket(String host, int port,
                               InetAddress localHost, int localPort) throws IOException {
        return enableTlsOnSocket(mDelegateSSLSocketFactory.createSocket(host, port,
                                                                        localHost, localPort));
    }

    @Override
    public Socket createSocket(InetAddress host, int port) throws IOException {
        return enableTlsOnSocket(mDelegateSSLSocketFactory.createSocket(host, port));
    }

    @Override
    public Socket createSocket(InetAddress address, int port,
                               InetAddress localAddress, int localPort) throws IOException {
        return enableTlsOnSocket(mDelegateSSLSocketFactory.createSocket(address, port,
                                                                        localAddress, localPort));
    }

    private Socket enableTlsOnSocket(Socket socket) {
        if ((Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT)
            && (Build.VERSION.SDK_INT <= Build.VERSION_CODES.KITKAT_WATCH)) {
            if ((socket != null)) {
                if (socket instanceof SSLSocket) {
                    ((SSLSocket) socket).setEnabledProtocols(TLS_SUPPORTED_PROTOCOLS);
                }
            }
        }

        return socket;
    }
}
