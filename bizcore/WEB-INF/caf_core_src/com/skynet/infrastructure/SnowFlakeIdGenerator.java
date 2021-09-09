package com.skynet.infrastructure;

/**
 * SnowFlake structure:<br>
 * 0 - 0000000000 0000000000 0000000000 0000000000 0 - 00000 - 00000 - 000000000000 <br>
 * The first bit is sign，0 is positive, 1 is negative<br>
 * The second part is a 41 bits timestamp in milliseconds, it's (current timestamp - startEpoch). 41 bits can be used for 69 years，T = (1L << 41) / (1000L * 60 * 60 * 24 * 365) = 69<br>
 * The third part is a 10 bit instance identity, it includes 5 bits datacenterId and 5 bits workerId. That means the id generator can be used in at most 1024 workers<br>
 * The last 12 bits is the sequence，which is a counting in a millisecond. 12 bits sequence supports at most 4096 IDs in a millisecond for a worker.<br>
 * <p>
 * Created by gaopeng on 2018/4/2.
 */
public class SnowFlakeIdGenerator {

    private long workerId;
    private long dataCenterId;
    private long sequence = 0;

    // the start timestamp in milliseconds (2018-01-01 00:00:00)
    private long startEpoch = 1514736000000L;

    private long workerIdBits = 5L;
    private long dataCenterIdBits = 5L;
    private long maxWorkerId = -1L ^ (-1L << workerIdBits);
    private long maxDataCenterId = -1L ^ (-1L << dataCenterIdBits);
    private long sequenceBits = 12L;

    private long workerIdShift = sequenceBits;
    private long dataCenterIdShift = sequenceBits + workerIdBits;
    private long timestampLeftShift = sequenceBits + workerIdBits + dataCenterIdBits;
    private long sequenceMask = -1L ^ (-1L << sequenceBits);

    private long lastTimestamp = -1L;

    public SnowFlakeIdGenerator(long workerId, long dataCenterId) {
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("Worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        if (dataCenterId > maxDataCenterId || dataCenterId < 0) {
            throw new IllegalArgumentException(String.format("Data center Id can't be greater than %d or less than 0", maxDataCenterId));
        }
        this.workerId = workerId;
        this.dataCenterId = dataCenterId;
    }

    private long blockUtilNextMillis() {
        long timestamp = System.currentTimeMillis();
        while (timestamp <= lastTimestamp) {
            timestamp = System.currentTimeMillis();
        }
        return timestamp;
    }

    public long nextId() {
        long timestamp = System.currentTimeMillis();

        if (timestamp < lastTimestamp) {
            throw new IllegalStateException(String.format("Clock moved backwards. Refusing to generate id for %d milliseconds",
                    lastTimestamp - timestamp));
        }

        if (lastTimestamp == timestamp) {
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0) {
                // the sequence is overflowed
                timestamp = blockUtilNextMillis();
            }
        }

        lastTimestamp = timestamp;
        return ((timestamp - startEpoch) << timestampLeftShift) |
                (dataCenterId << dataCenterIdShift) |
                (workerId << workerIdShift) |
                sequence;
    }
}
