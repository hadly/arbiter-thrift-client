/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaisquare.test;

import com.kaisquare.core.thrift.ConfigControlService;
import com.kaisquare.core.thrift.CoreException;
import com.kaisquare.util.ThriftUtil;
import org.apache.log4j.Logger;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransportException;

/**
 *
 * @author lizhinian
 */
public class ConfigControlServerTest extends ArbiterServerTest {

    private static final Logger log = Logger.getLogger(ConfigControlServerTest.class.getSimpleName());

    @Override
    public void process() {
	boolean jumpToParentDir = false;
	while (true) {
	    final int setStreamStorageLimit = 1;
	    final int setStorageKeepDays = 2;
	    final int setChunkSize = 3;
	    final int setReservedSpace = 4;
	    final int setCloudServer = 5;
	    log.debug("select the function:");
	    System.out.println("setStreamStorageLimit - " + setStreamStorageLimit);
	    System.out.println("setStorageKeepDays - " + setStorageKeepDays);
	    System.out.println("setChunkSize - " + setChunkSize);
	    System.out.println("setReservedSpace - " + setReservedSpace);
	    System.out.println("setCloudServer - " + setCloudServer);
	    System.out.println("back - " + back);
	    try {
		int number = Integer.parseInt(input.next());
		switch (number) {
		    case setStreamStorageLimit:
			setStreamStorageLimit();
			break;
		    case setStorageKeepDays:
			setStorageKeepDays();
			break;
		    case setChunkSize:
			setChunkSize();
			break;
		    case setReservedSpace:
			setReservedSpace();
			break;
		    case setCloudServer:
			setCloudServer();
			break;
		    case back:
			log.debug("jump to the parent directory.");
			jumpToParentDir = true;
			break;
		}
	    } catch (Exception e) {
		log.error("", e);
	    }

	    if (jumpToParentDir) {
		break;
	    }
	}//while    
    }

    private void setStreamStorageLimit() throws TTransportException, TException, CoreException {
	System.out.println("setStreamStorageLimit(String deviceId, String channelId, long storageLimit)");
	System.out.println("E.g., - 29 0 102400 ");
	String deviceId = input.next();
	String channel = input.next();
	long storageLimit = input.nextLong();
	ThriftUtil.Client<ConfigControlService.Iface> client = null;
	try {
	    client = getThriftClient();
	    boolean result = getThriftClient().getIface().setStreamStorageLimit(deviceId, channel, storageLimit);
	    log.debug("result=" + result);
	} finally {
	    if (null != client) {
		client.close();
	    }
	}
    }

    private void setStorageKeepDays() throws TTransportException, TException, CoreException {
	System.out.println("setStorageKeepDays(String deviceId, String channelId, long keepDays)");
	System.out.println("E.g., - 29 0 30 ");
	String deviceId = input.next();
	String channel = input.next();
	long keepDays = input.nextLong();
	ThriftUtil.Client<ConfigControlService.Iface> client = null;
	try {
	    client = getThriftClient();
	    boolean result = getThriftClient().getIface().setStorageKeepDays(deviceId, channel, keepDays);
	    log.debug("result=" + result);
	} finally {
	    if (null != client) {
		client.close();
	    }
	}
    }

    private void setChunkSize() throws TTransportException, TException, CoreException {
	System.out.println("setChunkSize(long chunkSize)");
	System.out.println("E.g., - 15 ");
	long chunkSize = input.nextLong();
	ThriftUtil.Client<ConfigControlService.Iface> client = null;
	try {
	    client = getThriftClient();
	    boolean result = getThriftClient().getIface().setChunkSize(chunkSize);
	    log.debug("result=" + result);
	} finally {
	    if (null != client) {
		client.close();
	    }
	}
    }

    private void setReservedSpace() throws TTransportException, TException, CoreException {
	System.out.println("setReservedSpace(long reservedSpace)");
	System.out.println("E.g., - 5120 ");
	long reservedSpace = input.nextLong();
	ThriftUtil.Client<ConfigControlService.Iface> client = null;
	try {
	    client = getThriftClient();
	    boolean result = getThriftClient().getIface().setReservedSpace(reservedSpace);
	    log.debug("result=" + result);
	} finally {
	    if (null != client) {
		client.close();
	    }
	}
    }

    private void setCloudServer() throws TTransportException, TException, CoreException {
	System.out.println("setCloudServer(String cloudServerHost)");
	System.out.println("E.g., - 10.101.0.10 ");
	String cloudServerHost = input.next();
	ThriftUtil.Client<ConfigControlService.Iface> client = null;
	try {
	    client = getThriftClient();
	    boolean result = getThriftClient().getIface().setCloudServer(cloudServerHost);
	    log.debug("result=" + result);
	} finally {
	    if (null != client) {
		client.close();
	    }
	}
    }

    private ThriftUtil.Client<ConfigControlService.Iface> getThriftClient() throws TTransportException {
	ThriftUtil.Client<ConfigControlService.Iface> client = null;
	client = ThriftUtil.newServiceClient(
		ConfigControlService.Iface.class, ConfigControlService.Client.class,
		host, CONFIG_CONTROL_SERVER_PORT, timeout);
	return client;
    }
}
