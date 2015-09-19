package com.knuthp.boot.camel;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.google.common.base.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class GetDepartures {
	private String recordedAtTime;

	@JsonCreator
	public GetDepartures(@JsonProperty("RecordedAtTime") String recordedAtTime) {
		this.recordedAtTime = recordedAtTime;
	}

	public String getRecordedAtTime() {
		return recordedAtTime;
	}

	// public void setRecordedAtTime(String recordedAtTime) {
	// this.recordedAtTime = recordedAtTime;
	// }

	@Override
	public String toString() {
		return Objects.toStringHelper(this)
				.add("recordedAtTime", getRecordedAtTime()).toString();
	}

}
