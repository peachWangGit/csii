package com.csii.demo.utils.id;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author From: https://github.com/twitter/snowflake 
 * 64bit
 * 0 - 00000000 00000000 00000000 00000000 00000000 0 - 00000000 00 - 00000000 0000
 * - - 41bit timestamp - 10bit worker - 12bit seq
 * 
 * 
 */
public class IdWorker {

	protected static final Logger LOG = LoggerFactory.getLogger(IdWorker.class);

	private long workerId;
	private long sequence = 0L;
	//"2016-01-01 00:00:00:000"
	private long twepoch = 1451577600000L;
						   
	private long workerIdBits = 10L;
	private long maxWorkerId = -1L ^ (-1L << workerIdBits);
	private long sequenceBits = 12L;

	private long workerIdShift = sequenceBits;
	private long timestampLeftShift = sequenceBits + workerIdBits;
	private long sequenceMask = -1L ^ (-1L << sequenceBits);

	private long lastTimestamp = -1L;

	public IdWorker(long workerId) {
		// sanity check for workerId
		if (workerId > maxWorkerId || workerId < 0) {
			throw new IllegalArgumentException(
					String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
		}
		this.workerId = workerId;
		LOG.info(String.format(
				"worker starting. timestamp left shift %d, worker id bits %d, sequence bits %d, workerid %d",
				timestampLeftShift, workerIdBits, sequenceBits, workerId));
	}

	public synchronized long nextId() {
		long timestamp = timeGen();

		if (timestamp < lastTimestamp) {
			LOG.error(String.format("clock is moving backwards.  Rejecting requests until %d.", lastTimestamp));
			throw new RuntimeException(String.format(
					"Clock moved backwards.  Refusing to generate id for %d milliseconds", lastTimestamp - timestamp));
		}

		if (lastTimestamp == timestamp) {
			sequence = (sequence + 1) & sequenceMask;
			if (sequence == 0) {
				timestamp = tilNextMillis(lastTimestamp);
			}
		} else {
			sequence = 0L;
		}

		lastTimestamp = timestamp;

		return ((timestamp - twepoch) << timestampLeftShift) | (workerId << workerIdShift) | sequence;
	}

	protected long tilNextMillis(long lastTimestamp) {
		long timestamp = timeGen();
		while (timestamp <= lastTimestamp) {
			timestamp = timeGen();
		}
		return timestamp;
	}

	protected long timeGen() {
		return System.currentTimeMillis();
	}
}