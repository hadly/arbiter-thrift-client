/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaisquare.test;

import com.kaisquare.core.thrift.CoreException;
import com.kaisquare.core.thrift.DeviceControlService;
import com.kaisquare.util.ThriftUtil;
import org.apache.log4j.Logger;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransportException;

/**
 *
 * @author lizhinian
 */
public class DeviceControlServerTest extends ArbiterServerTest {

    private static final Logger log = Logger.getLogger(DeviceControlServerTest.class.getSimpleName());

    @Override
    public void process() {
	boolean jumpToParentDir = false;
	while (true) {
	    final int getDeviceStatus = 1;
//	    final int getGPIO = 2;
//	    final int setGPIO = 3;
//	    final int startPanDevice = 4;
//	    final int stopPanDevice = 5;
//	    final int startTiltDevice = 6;
//	    final int stopTiltDevice = 7;
//	    final int startZoomDevice = 8;
//	    final int stopZoomDevice = 9;
//	    final int writeData = 10;
//	    final int readData = 11;
	    log.debug("select the function:");
	    System.out.println("getDeviceStatus - " + getDeviceStatus);
	    System.out.println("back - " + back);
	    try {
		int number = Integer.parseInt(input.next());
		switch (number) {
		    case getDeviceStatus:
			getDeviceStatus();
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

    private void getDeviceStatus() throws TTransportException, TException, CoreException {
	System.out.println("getDeviceStatus(String deviceId)");
	System.out.println("E.g., - 29");
	String deviceId = input.next();
	ThriftUtil.Client<DeviceControlService.Iface> client = null;
	try {
	    client = getThriftClient();
	    String result = getThriftClient().getIface().getDeviceStatus(deviceId);
	    log.debug("result=" + result);
	} finally {
	    if (null != client) {
		client.close();
	    }
	}
    }

    private ThriftUtil.Client<DeviceControlService.Iface> getThriftClient() throws TTransportException {
	ThriftUtil.Client<DeviceControlService.Iface> client = null;
	client = ThriftUtil.newServiceClient(
		DeviceControlService.Iface.class, DeviceControlService.Client.class,
		host, DEVICE_CONTROL_SERVER_PORT, timeout);
	return client;
    }
}
