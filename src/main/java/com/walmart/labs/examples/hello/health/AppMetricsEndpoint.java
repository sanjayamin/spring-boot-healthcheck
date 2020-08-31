package com.walmart.labs.examples.hello.health;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Map;
import java.util.SortedMap;

import org.apache.juli.logging.Log;
import org.apache.tomcat.util.net.AbstractEndpoint;
import org.apache.tomcat.util.net.SSLHostConfig;
import org.apache.tomcat.util.net.SocketEvent;
import org.apache.tomcat.util.net.SocketProcessorBase;
import org.apache.tomcat.util.net.SocketWrapperBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.MetricsEndpoint;
import org.springframework.stereotype.Component;

@Component
public class AppMetricsEndpoint extends AbstractEndpoint<String, Object> {

    private MetricsEndpoint metricsEndpoint;

    @Autowired
    public AppMetricsEndpoint(MetricsEndpoint metricsEndpoint) {
        super();
        this.metricsEndpoint = metricsEndpoint;
    }

   // public Map<String, Object> invoke() {
   //     SortedMap<String, Object> metricsMap =
   //             new TreeMap<String, Object>(this.metricsEndpoint.metric(requiredMetricName, tag));
   //     return metricsMap;
   // }

	@Override
	public void bind() throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	protected void createSSLContext(SSLHostConfig arg0) throws Exception {
		// TODO Auto-generated method stub
	}

	@Override
	protected SocketProcessorBase<String> createSocketProcessor(SocketWrapperBase<String> arg0, SocketEvent arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected void destroySocket(Object arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void doCloseServerSocket() throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected boolean getDeferAccept() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected InetSocketAddress getLocalAddress() throws IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected Log getLog() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isAlpnSupported() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	protected Object serverSocketAccept() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected boolean setSocketOptions(Object arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void startInternal() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void stopInternal() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void unbind() throws Exception {
		// TODO Auto-generated method stub
		
	}

}
