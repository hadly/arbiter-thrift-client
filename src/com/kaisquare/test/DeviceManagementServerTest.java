/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaisquare.test;

import com.kaisquare.core.thrift.CoreException;
import com.kaisquare.core.thrift.DeviceDetails;
import com.kaisquare.core.thrift.DeviceManagementService;
import com.kaisquare.core.thrift.DeviceModel;
import com.kaisquare.util.ThriftUtil;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransportException;

/**
 *
 * @author lizhinian
 */
public class DeviceManagementServerTest extends ArbiterServerTest {

    private static final Logger log = Logger.getLogger(DeviceManagementServerTest.class.getSimpleName());

    @Override
    public void process() {
	boolean jumpToParentDir = false;
	while (true) {
	    final int listModels = 1;
	    final int addDevice = 2;
	    final int updateDevice = 3;
	    final int deleteDevice = 4;
	    log.debug("select the function:");
	    System.out.println("listModels - " + listModels);
	    System.out.println("addDevice - " + addDevice);
	    System.out.println("updateDevice - " + updateDevice);
	    System.out.println("deleteDevice - " + deleteDevice);
	    System.out.println("back - " + back);
	    try {
		int number = Integer.parseInt(input.next());
		switch (number) {
		    case listModels:
			listModels();
			break;
		    case addDevice:
			addDevice();
			break;
		    case updateDevice:
			updateDevice();
			break;
		    case deleteDevice:
			deleteDevice();
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

    private void listModels() throws TTransportException, CoreException, TException {
	ThriftUtil.Client<DeviceManagementService.Iface> client = null;
	try {
	    client = getThriftClient();
	    List<DeviceModel> result = client.getIface().listModels();
	    log.debug("result=" + result);
	} finally {
	    if (null != client) {
		client.close();
	    }
	}
    }

    private void addDevice() throws TException, CoreException {
	System.out.println("addDevice(DeviceDetails device)");
	DeviceDetails device = new DeviceDetails();

	// Use line break as the delimiter, otherwise, it is not easy to input empty string
	input.useDelimiter("\n");

	System.out.print("id[input carriage return if not needed]=");
	String id = input.next();
	device.setId(id);

	System.out.print("name=");
	String name = input.next();
	device.setName(name);

	System.out.print("device_key=");
	String device_key = input.next();
	device.setKey(device_key);

	System.out.print("host=");
	String deviceHost = input.next();
	device.setHost(deviceHost);

	System.out.print("port=");
	String port = input.next();
	device.setPort(port);

	System.out.print("username=");
	String username = input.next();
	device.setLogin(username);

	System.out.print("password=");
	String password = input.next();
	device.setPassword(password);

	System.out.print("address=");
	String address = input.next();
	device.setAddress(address);

	System.out.print("lat=");
	String lat = input.next();
	device.setLat(lat);

	System.out.print("lng=");
	String lng = input.next();
	device.setLng(lng);

	System.out.print("modelId=");
	String modelId = input.next();
	device.setModelId(modelId);

	System.out.print("snapshotRecordingEnabled[true or false]=");
	String snapshotRecordingEnabled = input.next();
	device.setSnapshotRecordingEnabled(snapshotRecordingEnabled);

	System.out.print("snapshotRecordingInterval=");
	String snapshotRecordingInterval = input.next();
	device.setSnapshotRecordingInterval(snapshotRecordingInterval);

	System.out.print("cloudRecordingEnabled[true or false]=");
	String cloudRecordingEnabled = input.next();
	device.setCloudRecordingEnabled(cloudRecordingEnabled);
	System.out.println("device=" + device);
	
	input.reset();
	
	ThriftUtil.Client<DeviceManagementService.Iface> client = null;
	try {
	    client = getThriftClient();
	    String result = client.getIface().addDevice(device);
	    log.debug("result=" + result);
	} finally {
	    if (null != client) {
		client.close();
	    }
	}
    }

    private void updateDevice() throws TException, CoreException {
	System.out.println("updateDevice(DeviceDetails device)");
	DeviceDetails device = new DeviceDetails();

	// Use line break as the delimiter, otherwise, it is not easy to input empty string
	input.useDelimiter("\n");

	System.out.print("id[input carriage return if not needed]=");
	String id = input.next();
	device.setId(id);

	System.out.print("name=");
	String name = input.next();
	device.setName(name);

	System.out.print("device_key=");
	String device_key = input.next();
	device.setKey(device_key);

	System.out.print("host=");
	String deviceHost = input.next();
	device.setHost(deviceHost);

	System.out.print("port=");
	String port = input.next();
	device.setPort(port);

	System.out.print("username=");
	String username = input.next();
	device.setLogin(username);

	System.out.print("password=");
	String password = input.next();
	device.setPassword(password);

	System.out.print("address=");
	String address = input.next();
	device.setAddress(address);

	System.out.print("lat=");
	String lat = input.next();
	device.setLat(lat);

	System.out.print("lng=");
	String lng = input.next();
	device.setLng(lng);

	System.out.print("modelId=");
	String modelId = input.next();
	device.setModelId(modelId);

	System.out.print("snapshotRecordingEnabled[true or false]=");
	String snapshotRecordingEnabled = input.next();
	device.setSnapshotRecordingEnabled(snapshotRecordingEnabled);

	System.out.print("snapshotRecordingInterval=");
	String snapshotRecordingInterval = input.next();
	device.setSnapshotRecordingInterval(snapshotRecordingInterval);

	System.out.print("cloudRecordingEnabled[true or false]=");
	String cloudRecordingEnabled = input.next();
	device.setCloudRecordingEnabled(cloudRecordingEnabled);
	System.out.println("device=" + device);
	
	input.reset();
	
	ThriftUtil.Client<DeviceManagementService.Iface> client = null;
	try {
	    client = getThriftClient();
	    boolean result = client.getIface().updateDevice(device);
	    log.debug("result=" + result);
	} finally {
	    if (null != client) {
		client.close();
	    }
	}
    }

    private void deleteDevice() throws TTransportException, CoreException, TException {
	System.out.println("deleteDevice(String deviceId)");
	System.out.println("E.g., - 100 ");
	String deviceId = input.next();
	ThriftUtil.Client<DeviceManagementService.Iface> client = null;
	try {
	    client = getThriftClient();
	    boolean result = client.getIface().deleteDevice(deviceId);
	    log.debug("result=" + result);
	} finally {
	    if (null != client) {
		client.close();
	    }
	}
    }

    private ThriftUtil.Client<DeviceManagementService.Iface> getThriftClient() throws TTransportException {
	ThriftUtil.Client<DeviceManagementService.Iface> client = null;
	client = ThriftUtil.newServiceClient(
		DeviceManagementService.Iface.class, DeviceManagementService.Client.class,
		host, DEVICE_MANAGEMENT_SERVER_PORT, timeout);
	return client;
    }
}
