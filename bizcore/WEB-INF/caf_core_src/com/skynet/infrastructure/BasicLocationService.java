package com.skynet.infrastructure;

import java.io.File;
import java.util.Date;

import com.github.jarod.qqwry.IPZone;
import com.github.jarod.qqwry.QQWry;
import com.terapico.utils.*;

public class BasicLocationService implements LocationService{
    protected static final int STATE_UNAVAILABLE = 0;
    protected static final int STATE_MASTER = 1;
    protected static final int STATE_LOADING = 1;
    protected static class IpToLocationWorker {
        Date updatedTime;
        String dataFile;
        QQWry qqwry;
        int state = STATE_UNAVAILABLE;

        public LocationInfo getLocationInfoByIP(String ipAddress) {
            IPZone ipZone = qqwry.findIP(ipAddress);
            LocationInfo  result = new LocationInfo();
            result.setIpAddress(ipAddress);
            result.setMainInfo(ipZone.getMainInfo());
            result.setSubInfo(ipZone.getSubInfo());
            return result;
        }
    }

    protected IpToLocationWorker worker1;
    protected IpToLocationWorker worker2;
    protected String qqwryDataFile;

    public String getQqwryDataFile() {
        return qqwryDataFile;
    }

    public void setQqwryDataFile(String qqwryDataFile) {
        this.qqwryDataFile = qqwryDataFile;
    }

    protected synchronized IpToLocationWorker getIpToLocationWorker() {
        if (worker1 != null  && worker1.state == STATE_MASTER) {
            return worker1;
        }
        if (worker2 != null  && worker2.state == STATE_MASTER) {
            return worker2;
        }
        return null;
    }

    @Override
    public LocationInfo ipToLocation(String ipAddress) throws Exception {
        IpToLocationWorker worker = getIpToLocationWorker();
        if (worker == null) {
            ensureIpToLocationWorker();
        }
        worker = getIpToLocationWorker();

        if (worker == null) {
            LocationInfo result = new LocationInfo();
            result.setSubInfo("未知");
            result.setMainInfo("未知");
            result.setIpAddress(ipAddress);
            return result;
        }
        LocationInfo result = worker.getLocationInfoByIP(ipAddress);
        System.out.println(result);
        return result;
    }

    protected synchronized void ensureIpToLocationWorker() throws Exception {
        if (worker1 != null) {
            return;
        }
        worker1 = initIpToLocationWorker();
        ensureIpToLocationWorkerHotSwapTask();
    }

    private IpToLocationWorker initIpToLocationWorker() throws Exception {
        IpToLocationWorker worker = new IpToLocationWorker();
        worker.state = STATE_LOADING;
        worker.dataFile = EnvUtil.getValueFromEnv(this.getQqwryDataFile(), "QQWRY_DATA_FILE", null);
        if (worker.dataFile == null) {
            worker.qqwry = new QQWry();
        }else{
            File dataFile = new File(worker.dataFile);
            byte[] binContent = FileUtils.readFileAsBytes(dataFile);
            worker.qqwry = new QQWry(binContent);
        }
        worker.state = STATE_MASTER;
        worker.updatedTime = new Date();
        return worker;
    }

    protected void ensureIpToLocationWorkerHotSwapTask() {
        TaskUtil.addScheduleTask("ipToLocationWorkerHotSwapTask", 10 * DateTimeUtil.SECOND_IN_MS,
                () -> {
                    try {
                        checkQqwryFileChanged();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                });
    }

    protected void checkQqwryFileChanged() throws Exception {
        IpToLocationWorker worker = getIpToLocationWorker();
        if (worker == null){
            worker1 = initIpToLocationWorker();
            return;
        }
        String newDataFile = EnvUtil.getValueFromEnv(this.getQqwryDataFile(), "QQWRY_DATA_FILE", null);
        String curDataFile = worker.dataFile;
        if (newDataFile == null && curDataFile == null) {
            return; // 两个都是null, 表示都是从jar内获取数据,肯定没变化
        }

        boolean fileChanged = !TextUtil.isEqualsWhenMayNull(newDataFile, curDataFile);
        boolean fileContentChanged = fileChanged || checkFileRefreshed(worker.dataFile, worker.updatedTime);
        if (!fileContentChanged) {
            return;
        }
        // 内容,或者指向的目标文件改变了
        if (worker1 == worker) {
            System.out.println(new Date() + "reload qqwry data to worker2");
            worker2 = initIpToLocationWorker();
            worker1.state = STATE_UNAVAILABLE;
            System.out.println(new Date() + "worker1 released");
            return;
        }
        System.out.println(new Date() + "reload qqwry data to worker1");
        worker1 = initIpToLocationWorker();
        worker2.state = STATE_UNAVAILABLE;
        System.out.println(new Date() + "worker2 released");
    }

    private boolean checkFileRefreshed(String dataFile, Date recordTime) {
        if (dataFile == null) {
            return true;
        }
        File file = new File(dataFile);
        return file.lastModified() > recordTime.getTime();
    }

    public static void main(String[] args) throws Exception {
        BasicLocationService testee = new BasicLocationService();
        DebugUtil.dumpAsJson(testee.ipToLocation("222.212.130.169"), true);
        System.setProperty("QQWRY_DATA_FILE", "/works/jobs/optical_v1/qqwry_lastest.dat");
        Thread.sleep(12000);
        DebugUtil.dumpAsJson(testee.ipToLocation("222.212.130.169"), true);
        String t = TaskUtil.removeScheduleTask("ipToLocationWorkerHotSwapTask");
        System.out.print(t);
    }
}
