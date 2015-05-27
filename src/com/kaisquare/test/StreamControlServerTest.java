/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaisquare.test;

import com.kaisquare.core.thrift.CoreException;
import com.kaisquare.core.thrift.RecordedMediaInfo;
import com.kaisquare.core.thrift.StreamControlService;
import com.kaisquare.util.ThriftUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;
import org.apache.thrift.TException;
import org.apache.thrift.transport.TTransportException;

/**
 *
 * @author lizhinian
 */
public class StreamControlServerTest extends ArbiterServerTest {

    private static final Logger log = Logger.getLogger(StreamControlServerTest.class.getSimpleName());

    @Override
    public void process() {
	boolean jumpToParentDir = false;
	while (true) {
	    final int beginStreamSession = 1;
	    final int keepStreamSessionAlive = 2;
	    final int endStreamSession = 3;
	    final int getActiveOutboundStreamList = 4;
	    final int getRecordedMediaList = 5;
	    final int getStorageStatus = 6;
	    final int requestStreamForPlayback = 7;
	    final int cancelStreamForPlayback = 8;
	    final int getRequestedStreamStatus = 9;
	    log.debug("select the function:");
	    System.out.println("beginStreamSession - " + beginStreamSession);
	    System.out.println("keepStreamSessionAlive - " + keepStreamSessionAlive);
	    System.out.println("endStreamSession - " + endStreamSession);
	    System.out.println("getActiveOutboundStreamList - " + getActiveOutboundStreamList);
	    System.out.println("getRecordedMediaList - " + getRecordedMediaList);
	    System.out.println("getStorageStatus - " + getStorageStatus);
	    System.out.println("requestStreamForPlayback - " + requestStreamForPlayback);
	    System.out.println("cancelStreamForPlayback - " + cancelStreamForPlayback);
	    System.out.println("getRequestedStreamStatus - " + getRequestedStreamStatus);
	    System.out.println("jump to the parent directory - " + JUMP_TO_PARENT_DIR);
	    try {
		int number = Integer.parseInt(input.next());
		switch (number) {
		    case beginStreamSession:
			beginStreamSession();
			break;
		    case keepStreamSessionAlive:
			keepStreamSessionAlive();
			break;
		    case endStreamSession:
			endStreamSession();
			break;
		    case getActiveOutboundStreamList:
			getActiveOutboundStreamList();
			break;
		    case getRecordedMediaList:
			getRecordedMediaList();
			break;
		    case getStorageStatus:
			getStorageStatus();
			break;
		    case requestStreamForPlayback:
			requestStreamForPlayback();
			break;
		    case cancelStreamForPlayback:
			cancelStreamForPlayback();
			break;
		    case getRequestedStreamStatus:
			getRequestedStreamStatus();
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

    private void beginStreamSession() throws TException, CoreException {
	System.out.println("beginStreamSession(String sessionId, long ttl, String type, List<String> allowedClientIpList, String deviceId, String channelId, String startTime, String endTime)");
	System.out.println("E.g., - session1 300 rtmp/h264 allowedClientIpList 29 0 27052012135700 27052012145700");
	String sessionId = input.next();
	long ttl = input.nextLong();
	String type = input.next();
	String allowedClientIpListFake = input.next();
	String deviceId = input.next();
	String channel = input.next();
	String startTime = input.next();
	String endTime = input.next();
	//TODO: Construct allowedClientIpList
	List<String> allowedClientIpList = new ArrayList<String>();
	System.out.println("allowedClientIpList=" + allowedClientIpList);
	ThriftUtil.Client<StreamControlService.Iface> client = null;
	try {
	    client = getThriftClient();
	    List<String> result = getThriftClient().getIface().beginStreamSession(sessionId, ttl, type,
		    allowedClientIpList, deviceId, channel, startTime, endTime);
	    log.debug("result=" + result);
	} finally {
	    if (null != client) {
		client.close();
	    }
	}
    }

    private void keepStreamSessionAlive() throws TTransportException, CoreException, TException {
	System.out.println("keepStreamSessionAlive(String sessionId, long ttl, List<String> allowedClientIpAddresses)");
	System.out.println("E.g., - session1 300 allowedClientIpList");
	String sessionId = input.next();
	long ttl = input.nextLong();
	String allowedClientIpListFake = input.next();
	//TODO: Construct allowedClientIpList
	List<String> allowedClientIpList = new ArrayList<String>();
	System.out.println("allowedClientIpList=" + allowedClientIpList);
	ThriftUtil.Client<StreamControlService.Iface> client = null;
	try {
	    client = getThriftClient();
	    boolean result = getThriftClient().getIface().keepStreamSessionAlive(sessionId, ttl, allowedClientIpList);
	    log.debug("result=" + result);
	} finally {
	    if (null != client) {
		client.close();
	    }
	}
    }

    private void endStreamSession() throws TTransportException, CoreException, TException {
	System.out.println("endStreamSession(String sessionId)");
	System.out.println("E.g., - session1");
	String sessionId = input.next();
	ThriftUtil.Client<StreamControlService.Iface> client = null;
	try {
	    client = getThriftClient();
	    boolean result = getThriftClient().getIface().endStreamSession(sessionId);
	    log.debug("result=" + result);
	} finally {
	    if (null != client) {
		client.close();
	    }
	}
    }

    private void getActiveOutboundStreamList() throws TTransportException, CoreException, TException {
	System.out.println("getActiveOutboundStreamList()");
	ThriftUtil.Client<StreamControlService.Iface> client = null;
	try {
	    client = getThriftClient();
	    List<com.kaisquare.core.thrift.StreamInfo> result = getThriftClient().getIface().getActiveOutboundStreamList();
	    log.debug("result=" + result);
	} finally {
	    if (null != client) {
		client.close();
	    }
	}
    }

    private void getRecordedMediaList() throws TTransportException, CoreException, TException {
	System.out.println("getRecordedMediaList(String deviceId, String channelId, String mediaType, String startTimestamp, String endTimestamp)");
	System.out.println("E.g., - 29 0 video 27052012135700 27052012145700");
	String deviceId = input.next();
	String channel = input.next();
	String type = input.next();
	String startTime = input.next();
	String endTime = input.next();
	ThriftUtil.Client<StreamControlService.Iface> client = null;
	try {
	    client = getThriftClient();
	    List<RecordedMediaInfo> result = getThriftClient().getIface().getRecordedMediaList(deviceId, channel, type, startTime, endTime);
	    log.debug("result=" + result);
	} finally {
	    if (null != client) {
		client.close();
	    }
	}
    }

    private void getStorageStatus() throws TTransportException, CoreException, TException {
	System.out.println("getStorageStatus()");
	ThriftUtil.Client<StreamControlService.Iface> client = null;
	try {
	    client = getThriftClient();
	    List<com.kaisquare.core.thrift.StorageInfo> result = getThriftClient().getIface().getStorageStatus();
	    log.debug("result=" + result);
	} finally {
	    if (null != client) {
		client.close();
	    }
	}
    }

    private void requestStreamForPlayback() throws TTransportException, CoreException, TException {
	System.out.println("requestStreamForPlayback(String sessionId, String deviceId, String channelId, String mediaType, String startTime, String endTime)");
	System.out.println("E.g., - session1 29 0 video 27052012135700 27052012145700");
	String sessionId = input.next();
	String deviceId = input.next();
	String channel = input.next();
	String type = input.next();
	String startTime = input.next();
	String endTime = input.next();
	ThriftUtil.Client<StreamControlService.Iface> client = null;
	try {
	    client = getThriftClient();
	    boolean result = getThriftClient().getIface().requestStreamForPlayback(sessionId, deviceId, channel, type, startTime, endTime);
	    log.debug("result=" + result);
	} finally {
	    if (null != client) {
		client.close();
	    }
	}
    }

    private void getRequestedStreamStatus() throws TTransportException, CoreException, TException {
	System.out.println("getRequestedStreamStatus(String sessionId, String deviceId, String channelId, String mediaType, String action, String startTime, String endTime)");
	System.out.println("E.g., - session1 29 0 video play 27052012135700 27052012145700");
	String sessionId = input.next();
	String deviceId = input.next();
	String channel = input.next();
	String type = input.next();
	String action = input.next();
	String startTime = input.next();
	String endTime = input.next();
	ThriftUtil.Client<StreamControlService.Iface> client = null;
	try {
	    client = getThriftClient();
	    List<com.kaisquare.core.thrift.StreamFileDetails> result = client.getIface().getRequestedStreamStatus(
		    sessionId, deviceId, channel, type, action, startTime, endTime);
	    log.debug("result=" + result);
	} finally {
	    if (null != client) {
		client.close();
	    }
	}
    }

    private void cancelStreamForPlayback() throws TTransportException, CoreException, TException {
	System.out.println("cancelStreamForPlayback(String sessionId, String deviceId, String channelId, String mediaType, List<String> fileTime)");
	System.out.println("E.g., - session1 29 0 video 27052012145700:27052012145800:27052012145900");
	String sessionId = input.next();
	String deviceId = input.next();
	String channel = input.next();
	String type = input.next();
	String fileTimeString = input.next();
	List<String> fileTimeList = new ArrayList<String>();
	fileTimeList = getFileTimeList(fileTimeString);
	System.out.println("fileTimeList=" + fileTimeList);
	ThriftUtil.Client<StreamControlService.Iface> client = null;
	try {
	    client = getThriftClient();
	    boolean result = getThriftClient().getIface().cancelStreamForPlayback(sessionId, deviceId, channel, type, fileTimeList);
	    log.debug("result=" + result);
	} finally {
	    if (null != client) {
		client.close();
	    }
	}
    }

    private List<String> getFileTimeList(String fileTimeString) {
	List<String> fileTimeList = new ArrayList<String>();
	if (null == fileTimeString || fileTimeString.isEmpty()) {
	    return fileTimeList;
	}
	String[] timeList = fileTimeString.split(":");
	fileTimeList.addAll(Arrays.asList(timeList));
	return fileTimeList;
    }

    private ThriftUtil.Client<StreamControlService.Iface> getThriftClient() throws TTransportException {
	ThriftUtil.Client<StreamControlService.Iface> client = null;
	client = ThriftUtil.newServiceClient(
		StreamControlService.Iface.class, StreamControlService.Client.class,
		host, STREAM_CONTROL_SERVER_PORT, timeout);
	return client;
    }
}
