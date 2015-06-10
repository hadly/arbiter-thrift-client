/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kaisquare.test;

import com.kaisquare.util.ThriftUtil;
import com.kaisquare.waterway.thrift.CruiseRecord;
import com.kaisquare.waterway.thrift.CuriseMeasureData;
import com.kaisquare.waterway.thrift.GPSData;
import com.kaisquare.waterway.thrift.WaterwayCruiseService;
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
public class WaterwayCruiseServerTest extends ArbiterServerTest {

    private static final Logger log = Logger.getLogger(WaterwayCruiseServerTest.class.getSimpleName());

    @Override
    public void process() {
	boolean jumpToParentDir = false;
	while (true) {
	    final int startCruisePlan = 1;
	    final int pauseCruisePlan = 2;
	    final int resumeCruisePlan = 3;
	    final int stopCruisePlan = 4;
	    final int setSegmentPositions = 5;
	    final int deleteSegmentPositions = 6;
	    final int getCurrentLocation = 7;
	    final int getCurrentMileage = 8;
	    final int getMeasureResult = 9;
	    final int getCruiseSnapshotUrl = 10;
	    final int triggerCruiseEvent = 11;
	    final int getCruiseEventPlaybackVideoUrl = 12;
	    final int getCruisePlaybackItem = 13;
	    final int exportCruiseData = 14;
	    final int importCruiseData = 15;
	    final int deleteCruisePlan = 16;
	    final int getCruiseProgress = 17;

	    log.debug("select the function:");
	    System.out.println("startCruisePlan - " + startCruisePlan);
	    System.out.println("pauseCruisePlan - " + pauseCruisePlan);
	    System.out.println("resumeCruisePlan - " + resumeCruisePlan);
	    System.out.println("stopCruisePlan - " + stopCruisePlan);
	    System.out.println("setSegmentPositions - " + setSegmentPositions);
	    System.out.println("deleteSegmentPositions - " + deleteSegmentPositions);
	    System.out.println("getCurrentLocation - " + getCurrentLocation);
	    System.out.println("getCurrentMileage - " + getCurrentMileage);
	    System.out.println("getMeasureResult - " + getMeasureResult);
	    System.out.println("getCruiseSnapshotUrl - " + getCruiseSnapshotUrl);
	    System.out.println("triggerCruiseEvent - " + triggerCruiseEvent);
	    System.out.println("getCruiseEventPlaybackVideoUrl - " + getCruiseEventPlaybackVideoUrl);
	    System.out.println("getCruisePlaybackItem - " + getCruisePlaybackItem);
	    System.out.println("exportCruiseData - " + exportCruiseData);
	    System.out.println("importCruiseData - " + importCruiseData);
	    System.out.println("deleteCruisePlan - " + deleteCruisePlan);
	    System.out.println("getCruiseProgress - " + getCruiseProgress);
	    System.out.println("back - " + back);
	    try {
		int number = Integer.parseInt(input.next());
		switch (number) {
		    case startCruisePlan:
			startCruisePlan();
			break;
		    case pauseCruisePlan:
			pauseCruisePlan();
			break;
		    case resumeCruisePlan:
			resumeCruisePlan();
			break;
		    case stopCruisePlan:
			stopCruisePlan();
			break;
		    case setSegmentPositions:
			setSegmentPositions();
			break;
		    case deleteSegmentPositions:
			deleteSegmentPositions();
			break;
		    case getCurrentLocation:
			getCurrentLocation();
			break;
		    case getCurrentMileage:
			getCurrentMileage();
			break;
		    case getMeasureResult:
			getMeasureResult();
			break;
		    case getCruiseSnapshotUrl:
			getCruiseSnapshotUrl();
			break;
		    case triggerCruiseEvent:
			triggerCruiseEvent();
			break;
		    case getCruiseEventPlaybackVideoUrl:
			getCruiseEventPlaybackVideoUrl();
			break;
		    case getCruisePlaybackItem:
			getCruisePlaybackItem();
			break;
		    case exportCruiseData:
			exportCruiseData();
			break;
		    case importCruiseData:
			importCruiseData();
			break;
		    case deleteCruisePlan:
			deleteCruisePlan();
			break;
		    case getCruiseProgress:
			getCruiseProgress();
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

    private void startCruisePlan() throws TTransportException, TException {
	System.out.println("startCruisePlan(String cruisePlanId, List<String> segmentIdList, long deviceId)");
	System.out.println("E.g., - cruise1 segment1,segment2,segment3 29 ");
	String cruiseId = input.next();
	String segmentStr = input.next();
	List<String> segmentIdList = new ArrayList<>();
	String[] segmStrings = segmentStr.split(",");
	segmentIdList.addAll(Arrays.asList(segmStrings));
	long deviceId = input.nextLong();
	log.debug("segmentIdList=" + segmentIdList);

	ThriftUtil.Client<WaterwayCruiseService.Iface> client = null;
	try {
	    client = getThriftClient();
	    boolean result = getThriftClient().getIface().startCruisePlan(cruiseId, segmentIdList, deviceId);
	    log.debug("result=" + result);
	} finally {
	    if (null != client) {
		client.close();
	    }
	}
    }

    private void stopCruisePlan() throws TTransportException, TException {
	System.out.println("stopCruisePlan(String cruisePlanId)");
	System.out.println("E.g., - cruise1");
	String cruiseId = input.next();

	ThriftUtil.Client<WaterwayCruiseService.Iface> client = null;
	try {
	    client = getThriftClient();
	    boolean result = getThriftClient().getIface().stopCruisePlan(cruiseId);
	    log.debug("result=" + result);
	} finally {
	    if (null != client) {
		client.close();
	    }
	}
    }

    private void pauseCruisePlan() throws TTransportException, TException {
	System.out.println("pauseCruisePlan(String cruisePlanId)");
	System.out.println("E.g., - cruise1");
	String cruiseId = input.next();

	ThriftUtil.Client<WaterwayCruiseService.Iface> client = null;
	try {
	    client = getThriftClient();
	    boolean result = getThriftClient().getIface().pauseCruisePlan(cruiseId);
	    log.debug("result=" + result);
	} finally {
	    if (null != client) {
		client.close();
	    }
	}
    }

    private void resumeCruisePlan() throws TTransportException, TException {
	System.out.println("resumeCruisePlan(String cruisePlanId)");
	System.out.println("E.g., - cruise1");
	String cruiseId = input.next();

	ThriftUtil.Client<WaterwayCruiseService.Iface> client = null;
	try {
	    client = getThriftClient();
	    boolean result = getThriftClient().getIface().resumeCruisePlan(cruiseId);
	    log.debug("result=" + result);
	} finally {
	    if (null != client) {
		client.close();
	    }
	}
    }

    private void setSegmentPositions() throws TTransportException, TException {
	System.out.println("setSegmentPositions(String segmentId, List<GPSData> positionList)");
	System.out.println("E.g., - segment1 lng1,lat1;lng2,lat2;lng3,lat3");
	System.out.println("Note: The gps data list must be in order.");
	String cruiseId = input.next();
	String gpsDataStr = input.next();

	List<GPSData> positionList = new ArrayList<>();
	String[] gpsdataArray = gpsDataStr.split(";");
	for (String gpsdataString : gpsdataArray) {
	    String[] lngLatArray = gpsdataString.split(",");
	    double lng = Double.parseDouble(lngLatArray[0]);
	    double lat = Double.parseDouble(lngLatArray[1]);
	    positionList.add(new GPSData(lng, lat, 0, 0));
	}
	log.debug("positionList=" + positionList);

	ThriftUtil.Client<WaterwayCruiseService.Iface> client = null;
	try {
	    client = getThriftClient();
	    boolean result = getThriftClient().getIface().setSegmentPositions(cruiseId, positionList);
	    log.debug("result=" + result);
	} finally {
	    if (null != client) {
		client.close();
	    }
	}
    }

    private void deleteSegmentPositions() throws TTransportException, TException {
	System.out.println("deleteSegmentPositions(String segmentId)");
	System.out.println("E.g., - segmentId");
	String cruiseId = input.next();

	ThriftUtil.Client<WaterwayCruiseService.Iface> client = null;
	try {
	    client = getThriftClient();
	    boolean result = getThriftClient().getIface().deleteSegmentPositions(cruiseId);
	    log.debug("result=" + result);
	} finally {
	    if (null != client) {
		client.close();
	    }
	}
    }

    private void getCurrentLocation() throws TTransportException, TException {
	System.out.println("getCurrentLocation()");

	ThriftUtil.Client<WaterwayCruiseService.Iface> client = null;
	try {
	    client = getThriftClient();
	    GPSData result = getThriftClient().getIface().getCurrentLocation();
	    log.debug("result=" + result);
	} finally {
	    if (null != client) {
		client.close();
	    }
	}
    }

    private void getCurrentMileage() throws TTransportException, TException {
	System.out.println("getCurrentMileage()");

	ThriftUtil.Client<WaterwayCruiseService.Iface> client = null;
	try {
	    client = getThriftClient();
	    double result = getThriftClient().getIface().getCurrentMileage();
	    log.debug("result=" + result);
	} finally {
	    if (null != client) {
		client.close();
	    }
	}
    }

    private void getMeasureResult() throws TTransportException, TException {
	System.out.println("getMeasureResult(long deviceId)");
	System.out.println("E.g., - 29");
	long deviceId = input.nextLong();

	ThriftUtil.Client<WaterwayCruiseService.Iface> client = null;
	try {
	    client = getThriftClient();
	    CuriseMeasureData result = getThriftClient().getIface().getMeasureResult(deviceId);
	    log.debug("result=" + result);
	} finally {
	    if (null != client) {
		client.close();
	    }
	}
    }

    private void getCruiseSnapshotUrl() throws TTransportException, TException {
	System.out.println("getCruiseSnapshotUrl(String cruisePlanId)");
	System.out.println("E.g., - cruiseId");
	String cruiseId = input.next();

	ThriftUtil.Client<WaterwayCruiseService.Iface> client = null;
	try {
	    client = getThriftClient();
	    String result = getThriftClient().getIface().getCruiseSnapshotUrl(cruiseId);
	    log.debug("result=" + result);
	} finally {
	    if (null != client) {
		client.close();
	    }
	}
    }

    private void deleteCruisePlan() throws TTransportException, TException {
	System.out.println("deleteCruisePlan(String cruisePlanId)");
	System.out.println("E.g., - cruiseId");
	String cruiseId = input.next();

	ThriftUtil.Client<WaterwayCruiseService.Iface> client = null;
	try {
	    client = getThriftClient();
	    boolean result = getThriftClient().getIface().deleteCruisePlan(cruiseId);
	    log.debug("result=" + result);
	} finally {
	    if (null != client) {
		client.close();
	    }
	}
    }

    private void getCruiseProgress() throws TTransportException, TException {
	System.out.println("getCruiseProgress()");

	ThriftUtil.Client<WaterwayCruiseService.Iface> client = null;
	try {
	    client = getThriftClient();
	    double result = getThriftClient().getIface().getCruiseProgress();
	    log.debug("result=" + result);
	} finally {
	    if (null != client) {
		client.close();
	    }
	}
    }

    private void exportCruiseData() throws TTransportException, TException {
	System.out.println("exportCruiseData(String cruisePlanId, List<String> segmentIdList)");
	System.out.println("E.g., - cruiseId segment1,segment2,segment3");
	String cruiseId = input.next();
	String segmentStr = input.next();
	List<String> segmentIdList = new ArrayList<>();
	String[] segments = segmentStr.split(",");
	segmentIdList = Arrays.asList(segments);
	log.debug("segmentList=" + segmentIdList);

	ThriftUtil.Client<WaterwayCruiseService.Iface> client = null;
	try {
	    client = getThriftClient();
	    String result = getThriftClient().getIface().exportCruiseData(cruiseId, segmentIdList);
	    log.debug("result=" + result);
	} finally {
	    if (null != client) {
		client.close();
	    }
	}
    }

    private void importCruiseData() throws TTransportException, TException {
	System.out.println("importCruiseData(String cruiseFilePath)");
	System.out.println("E.g., - cruiseFilePath");
	String filePath = input.next();

	ThriftUtil.Client<WaterwayCruiseService.Iface> client = null;
	try {
	    client = getThriftClient();
	    String result = getThriftClient().getIface().importCruiseData(filePath);
	    log.debug("result=" + result);
	} finally {
	    if (null != client) {
		client.close();
	    }
	}
    }

    private void triggerCruiseEvent() throws TTransportException, TException {
	System.out.println("triggerCruiseEvent(String cruisePlanId, String startTimestamp, int duration)");
	System.out.println("E.g., - cruiseId 10062015102800 20");
	String cruiseId = input.next();
	String startTime = input.next();
	int duration = input.nextInt();

	ThriftUtil.Client<WaterwayCruiseService.Iface> client = null;
	try {
	    client = getThriftClient();
	    boolean result = getThriftClient().getIface().triggerCruiseEvent(cruiseId, startTime, duration);
	    log.debug("result=" + result);
	} finally {
	    if (null != client) {
		client.close();
	    }
	}
    }

    private void getCruiseEventPlaybackVideoUrl() throws TTransportException, TException {
	System.out.println("getCruiseEventPlaybackVideoUrl(String cruisePlanId, String startTimestamp)");
	System.out.println("E.g., - cruiseId 10062015102800");
	String cruiseId = input.next();
	String startTime = input.next();

	ThriftUtil.Client<WaterwayCruiseService.Iface> client = null;
	try {
	    client = getThriftClient();
	    String result = getThriftClient().getIface().getCruiseEventPlaybackVideoUrl(cruiseId, startTime);
	    log.debug("result=" + result);
	} finally {
	    if (null != client) {
		client.close();
	    }
	}
    }

    private void getCruisePlaybackItem() throws TTransportException, TException {
	System.out.println("getCruisePlaybackItem(String cruisePlanId, int index) ");
	System.out.println("E.g., - cruiseId 1");
	String cruiseId = input.next();
	int index = input.nextInt();

	ThriftUtil.Client<WaterwayCruiseService.Iface> client = null;
	try {
	    client = getThriftClient();
	    CruiseRecord result = getThriftClient().getIface().getCruisePlaybackItem(cruiseId, index);
	    log.debug("result=" + result);
	} finally {
	    if (null != client) {
		client.close();
	    }
	}
    }

    private ThriftUtil.Client<WaterwayCruiseService.Iface> getThriftClient() throws TTransportException {
	ThriftUtil.Client<WaterwayCruiseService.Iface> client = null;
	client = ThriftUtil.newServiceClient(
		WaterwayCruiseService.Iface.class, WaterwayCruiseService.Client.class,
		host, WATERWAY_CRUISE_SERVER_PORT, timeout);
	return client;
    }
}
