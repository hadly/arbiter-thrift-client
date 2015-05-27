/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaisquare.test;

import com.kaisquare.arbiter.thrift.ArbiterManagementService;
import com.kaisquare.arbiter.thrift.ServerDetails;
import com.kaisquare.util.ThriftUtil;
import java.nio.ByteBuffer;
import org.apache.log4j.Logger;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransportException;

/**
 *
 * @author lizhinian
 */
public class ArbiterManagementServerTest extends ArbiterServerTest {

    private static final Logger log = Logger.getLogger(ArbiterManagementServerTest.class.getSimpleName());

    @Override
    public void process() {
	boolean jumpToParentDir = false;
	while (true) {
	    final int registerServer = 1;
	    final int deregisterServer = 2;
	    final int sendTaskData = 3;
	    final int sendEventData = 4;
	    final int getDeviceServer = 5;
	    log.debug("select the function:");
	    System.out.println("registerServer - " + registerServer);
	    System.out.println("deregisterServer - " + deregisterServer);
	    System.out.println("sendTaskData - " + sendTaskData);
	    System.out.println("sendEventData - " + sendEventData);
	    System.out.println("getDeviceServer - " + getDeviceServer);
	    System.out.println("jump to the parent directory - " + JUMP_TO_PARENT_DIR);
	    try {
		int number = Integer.parseInt(input.next());
		switch (number) {
		    case registerServer:
			registerServer();
			break;
		    case deregisterServer:
			deregisterServer();
			break;
		    case sendTaskData:
			sendTaskData();
			break;
		    case sendEventData:
			sendEventData();
			break;
		    case getDeviceServer:
			getDeviceServer();
			break;
		    case JUMP_TO_PARENT_DIR:
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

    private void registerServer() throws TException {
	System.out.println("registerServer(long serverId, String serverType, ServerDetails serverDetails)");
	System.out.println("E.g., - 34589933820397 streaming-server serverDetails");
	long serverId = Long.parseLong(input.next());
	String serverType = input.next();
	String serverDetailsFake = input.next();
	//TODO: Construct the server details
	ServerDetails serverDetails = new ServerDetails();
	serverDetails.setServerHost("localhost");
	serverDetails.setServerPort(-1);
	System.out.println("serverDetails=" + serverDetails);
	ThriftUtil.Client<ArbiterManagementService.Iface> client = null;
	try {
	    client = getThriftClient();
	    boolean result = client.getIface().registerServer(serverId, serverType, serverDetails);
	    log.debug("result=" + result);
	} finally {
	    if (null != client) {
		client.close();
	    }
	}
    }

    private void deregisterServer() throws TException {
	System.out.println("deregisterServer(long serverId, String serverType)");
	System.out.println("E.g., - 34589933820397 streaming-server ");
	long serverId = Long.parseLong(input.next());
	String serverType = input.next();
	ThriftUtil.Client<ArbiterManagementService.Iface> client = null;
	try {
	    client = getThriftClient();
	    boolean result = getThriftClient().getIface().deregisterServer(serverId, serverType);
	    log.debug("result=" + result);
	} finally {
	    if (null != client) {
		client.close();
	    }
	}
    }

    private void sendTaskData() throws TTransportException, TException {
	System.out.println("sendTaskData(long deviceId, int channel, String taskType, String stringData, ByteBuffer binaryData)");
	System.out.println("E.g., - 29 0 cleanup-local-storage {\"type\":\"image\",\"time\":\"20120525111248\"} binaryData");
	long serverId = Long.parseLong(input.next());
	int channel = input.nextInt();
	String taskType = input.next();
	String stringData = input.next();
	String binaryDataFake = input.next();
	ByteBuffer binaryData = ByteBuffer.allocate(0);
	System.out.println("binaryData=" + binaryData);
	ThriftUtil.Client<ArbiterManagementService.Iface> client = null;
	try {
	    client = getThriftClient();
	    boolean result = getThriftClient().getIface().sendTaskData(serverId, channel, taskType, stringData, binaryData);
	    log.debug("result=" + result);
	} finally {
	    if (null != client) {
		client.close();
	    }
	}
    }

    private void sendEventData() throws TTransportException, TException {
	System.out.println("sendEventData(long deviceId, int channel, String eventType, long eventTime, String stringData, ByteBuffer binaryData)");
	System.out.println("E.g., - 29 0 event-connected 1333601613000 {\"time\":1333601613000\"} binaryData");
	long deviceId = Long.parseLong(input.next());
	int channel = input.nextInt();
	String eventType = input.next();
	long eventTime = input.nextLong();
	String stringData = input.next();
	String binaryDataFake = input.next();
	ByteBuffer binaryData = ByteBuffer.allocate(0);
	System.out.println("binaryData=" + binaryData);
	ThriftUtil.Client<ArbiterManagementService.Iface> client = null;
	try {
	    client = getThriftClient();
	    boolean result = getThriftClient().getIface().sendEventData(deviceId, channel, eventType, eventTime, stringData, binaryData);
	    log.debug("result=" + result);
	} finally {
	    if (null != client) {
		client.close();
	    }
	}
    }

    private void getDeviceServer() throws TTransportException, TException {
	System.out.println("getDeviceServer(String deviceInfo)");
	System.out.println("E.g., - {\"device-key\":\"50:e5:49:b4:e3:21\"} or {\"device-id\":170} ");
	String str = input.next();
	ThriftUtil.Client<ArbiterManagementService.Iface> client = null;
	try {
	    client = getThriftClient();
	    String result = getThriftClient().getIface().getDeviceServer(str);
	    log.debug("result=" + result);
	} finally {
	    if (null != client) {
		client.close();
	    }
	}
    }

    private ThriftUtil.Client<ArbiterManagementService.Iface> getThriftClient() throws TTransportException {
	ThriftUtil.Client<ArbiterManagementService.Iface> client = null;
	client = ThriftUtil.newServiceClient(
		ArbiterManagementService.Iface.class, ArbiterManagementService.Client.class,
		host, ARBITER_MANAGEMENT_SERVER_PORT, timeout);
	return client;
    }
}
