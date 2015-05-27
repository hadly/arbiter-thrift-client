/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaisquare.test;

import com.kaisquare.arbiter.thrift.ArbiterManagementService;
import com.kaisquare.arbiter.thrift.ServerDetails;
import com.kaisquare.util.*;
import java.util.Scanner;
import org.apache.log4j.Logger;
import org.apache.thrift.TException;

/**
 *
 * @author lizhinian
 */
public class ArbiterServerTest {

    private static final Logger log = Logger.getLogger(ArbiterServerTest.class.getSimpleName());
    public static String host = "";
    public static int timeout = 10000;
    public static int numTries = 1;
    public static int delay = 5000;
    public static final int JUMP_TO_PARENT_DIR = 0;
    public static final int EXIT = 0;
    public static Scanner input = new Scanner(System.in);
    //--------service name definition
    private static final int ARBITER_MANAGEMENT_SERVER = 1;
    private static final int STREAM_CONTROL_SERVER = 2;
    private static final int DEVICE_CONTROL_SERVER = 3;
    private static final int DEVICE_MANAGEMENT_SERVER = 4;
    private static final int DATA_SERVER = 5;
    private static final int CONFIG_CONTROL_SERVER = 6;
    private static final int NODE_CONTROL_SERVER = 7;
    //--------service name definition
    //########service port definition
    public static final int ARBITER_MANAGEMENT_SERVER_PORT = 10771;
    public static final int STREAM_CONTROL_SERVER_PORT = 10600;
    public static final int DEVICE_CONTROL_SERVER_PORT = 10604;
    public static final int DEVICE_MANAGEMENT_SERVER_PORT = 10889;
    public static final int DATA_SERVER_PORT = 10888;
    public static final int CONFIG_CONTROL_SERVER_PORT = 10887;
    public static final int NODE_CONTROL_SERVER_PORT = 18001;
    //########service port definition

    private static void processArbiterManagement() {
	ArbiterManagementServerTest server = new ArbiterManagementServerTest();
	server.process();
    }

    private static void processStreamControl() {
	StreamControlServerTest server = new StreamControlServerTest();
	server.process();
    }
    
    private static void processConfigControl(){
	ConfigControlServerTest server = new ConfigControlServerTest();
	server.process();
    }

    public void process() {
	log.debug("this is the process function in ArbiterServerTest.");
    }

    //for general purpose of adding device or update device,execute the below function
    public static void main(String[] args) throws Exception {
	Log4jUtil.loadLog4jProperties();
	log.debug("please input the destination host:");
	host = input.next();

	boolean exit = false;
	while (true) {
	    log.debug("select the service:");
	    System.out.println("ArbiterManagementServer - " + ARBITER_MANAGEMENT_SERVER);
	    System.out.println("StreamControlServer - " + STREAM_CONTROL_SERVER);
//	    System.out.println("DeviceControlServer - " + DEVICE_CONTROL_SERVER);
//	    System.out.println("DeviceManagementServer - " + DEVICE_MANAGEMENT_SERVER);
//	    System.out.println("DataServer - " + DATA_SERVER);
	    System.out.println("ConfigControlServer - " + CONFIG_CONTROL_SERVER);
//	    System.out.println("NodeControlServer - " + NODE_CONTROL_SERVER);
	    System.out.println("exit - 0");
	    try {
		int number = Integer.parseInt(input.next());
		switch (number) {
		    case ARBITER_MANAGEMENT_SERVER:
			processArbiterManagement();
			break;
		    case STREAM_CONTROL_SERVER:
			processStreamControl();
			break;
		    case DEVICE_CONTROL_SERVER:
//			processDeviceControl();
			break;
		    case DEVICE_MANAGEMENT_SERVER:
//			processDeviceMngServer();
			break;
		    case DATA_SERVER:
//			processDataServer();
			break;
		    case CONFIG_CONTROL_SERVER:
			processConfigControl();
			break;
		    case NODE_CONTROL_SERVER:
//			processNodeControl();
			break;
		    case EXIT:
			exit = true;
			log.debug("exit the program.");
			break;
		}//switch
		if (exit) {
		    break;
		}
	    } catch (Exception e) {
		log.error("", e);
	    }
	}










//	ThriftUtil.Client<ArbiterManagementService.Iface> client = null;
//	try {
////	    client = ThriftUtil.newServiceClient(ArbiterManagementService.Iface.class, ArbiterManagementService.Client.class, host, port, timeout, numTries, delay);
//	} catch (Exception ex) {
//	    log.error("", ex);
//	}
//	ArbiterManagementService.Iface iface = client.getIface();
//	try {
//	    // 1.register
////	    register(iface);
//	    // 2.deregister
////	    deRegister(iface);
//	    // 3.sendTaskData
////	    sendTaskData(iface);
//	    // 4.sendEventData
////	    sendEventData(iface);
//	} catch (Exception e) {
//	    log.error("", e);
//	} finally {
//	    if (null != client) {
//		client.close();
//	    }
//	}
    }

    private static void register(ArbiterManagementService.Iface iface) {
	String ds = "device-server";
	String rs = "recording-server";
	String ss = "streaming-server";
	ServerDetails details = new ServerDetails("localhost", 30001, 23, 20, 300, 300, 5, 5);
	try {
	    boolean result = iface.registerServer(10001, ds, details);
	    log.info("result=" + result);
	} catch (TException ex) {
	    log.error("", ex);
	}
    }

    private static void deRegister(ArbiterManagementService.Iface iface) {
	String ds = "device-server";
	String rs = "recording-server";
	String ss = "streaming-server";
	ServerDetails details = new ServerDetails("localhost", 30001, 23, 20, 300, 300, 5, 5);
	try {
	    boolean result = iface.deregisterServer(10001, ds);
	    log.info("result=" + result);
	} catch (TException ex) {
	    log.error("", ex);
	}
    }

    private static void sendEventData(ArbiterManagementService.Iface iface) throws TException {
	long deviceId = 1;
	int channel = 0;
	String eventType = "";
	long eventTime = 0L;
	String stringData = "";
	boolean result = iface.sendEventData(deviceId, channel, eventType, eventTime, stringData, null);
	log.info("result=" + result);
    }

//    private static void sendTaskData(ArbiterManagementService.Iface iface) throws TException {
//	long deviceId = 3;
//	int channel = 0;
//	String taskType = TaskTypes.UPDATE_MEDIA_DETAILS;
//	Map<String, Object> map = new HashMap<String, Object>();
//	map.put(MediaInfo.MEDIA_TYPE, "video");
////	map.put(MediaInfo.FROM, "20141222141707");
//
//
////	{
////	    //Clean up local media - 838715166
////	    taskType = TaskTypes.CLEANUP_LOCAL_STORAGE;
////	    map.put(JSONConstants.TIME, "20150506143000");
////	}
//
//	{
//	    //Clean up local media - 838715166
//	    taskType = TaskTypes.CLEANUP_CLOUD_STORAGE;
//	    map.put(MediaInfo.MEDIA_TYPE, "video");
//	    map.put(JSONConstants.TIME, "20150507114200");
//	    map.put(MediaInfo.SIZE, "43832");
//	}
//
//
////	//TaskTypes.UPDATE_MEDIA_DETAILS
////	map.put(MediaInfo.TO, "20141222142000");
////	map.put(MediaInfo.SIZE, 90466905);
////	map.put(MediaInfo.KEEP_DAYS, 30);
//
//
////	//TaskTypes.UPDATE_MEDIA_GROUP
////	map.put(StorageKey.GROUP, "group1");
//
//
////	{
////	    //TaskTypes.UPDATE_MEDIA_PATH
////	    map.put(MediaInfo.CLOUD_PATH, "../RS/video/");
////	    map.put(MediaInfo.CREATE_TIME, "20141010180800");
////	}
//
//
////	{
////	//TaskTypes.UPDATE_MEDIA_PROGRESS
////	map.put(StorageKey.PROGRESS, 14);
////	map.put(StorageKey.STATUS, "uploading");
////	}
//
//
//	String stringData = JSONUtil.writeJSON(map);
//	boolean result = iface.sendTaskData(deviceId, channel, taskType, stringData, null);
//	log.info("result=" + result);
//    }
}
