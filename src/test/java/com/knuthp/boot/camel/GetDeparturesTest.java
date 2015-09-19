package com.knuthp.boot.camel;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

import org.junit.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

public class GetDeparturesTest {
	private static String JSON = "[\n"
			+ "  {\n"
			+ "    \"RecordedAtTime\": \"2015-09-19T21:56:46.188+02:00\",\n"
			+ "    \"MonitoringRef\": \"3010013\",\n"
			+ "    \"MonitoredVehicleJourney\": {\n"
			+ "      \"LineRef\": \"54\",\n"
			+ "      \"DirectionRef\": \"1\",\n"
			+ "      \"FramedVehicleJourneyRef\": {\n"
			+ "        \"DataFrameRef\": \"2015-09-19\",\n"
			+ "        \"DatedVehicleJourneyRef\": \"365107\"\n"
			+ "      },\n"
			+ "      \"PublishedLineName\": \"54\",\n"
			+ "      \"DirectionName\": \"1\",\n"
			+ "      \"OperatorRef\": \"Unibuss\",\n"
			+ "      \"OriginName\": \"Kjelsås stasjon [buss]\",\n"
			+ "      \"OriginRef\": \"3012161\",\n"
			+ "      \"DestinationRef\": 3010090,\n"
			+ "      \"DestinationName\": \"Aker brygge\",\n"
			+ "      \"OriginAimedDepartureTime\": \"0001-01-01T00:00:00\",\n"
			+ "      \"DestinationAimedArrivalTime\": \"0001-01-01T00:00:00\",\n"
			+ "      \"Monitored\": true,\n"
			+ "      \"InCongestion\": false,\n"
			+ "      \"Delay\": \"PT0S\",\n"
			+ "      \"TrainBlockPart\": null,\n"
			+ "      \"BlockRef\": \"5405\",\n"
			+ "      \"VehicleRef\": \"101030\",\n"
			+ "      \"VehicleMode\": 0,\n"
			+ "      \"VehicleJourneyName\": \"45139\",\n"
			+ "      \"MonitoredCall\": {\n"
			+ "        \"VisitNumber\": 24,\n"
			+ "        \"VehicleAtStop\": false,\n"
			+ "        \"DestinationDisplay\": \"Aker brygge\",\n"
			+ "        \"AimedArrivalTime\": \"2015-09-19T21:57:00+02:00\",\n"
			+ "        \"ExpectedArrivalTime\": \"2015-09-19T21:56:31+02:00\",\n"
			+ "        \"AimedDepartureTime\": \"2015-09-19T21:57:00+02:00\",\n"
			+ "        \"ExpectedDepartureTime\": \"2015-09-19T21:57:00+02:00\",\n"
			+ "        \"DeparturePlatformName\": \"A\"\n"
			+ "      },\n"
			+ "      \"VehicleFeatureRef\": null\n"
			+ "    },\n"
			+ "    \"Extensions\": {\n"
			+ "      \"IsHub\": true,\n"
			+ "      \"OccupancyData\": {\n"
			+ "        \"OccupancyAvailable\": true,\n"
			+ "        \"OccupancyPercentage\": 20\n"
			+ "      },\n"
			+ "      \"Deviations\": [],\n"
			+ "      \"LineColour\": \"E60000\"\n"
			+ "    }\n"
			+ "  },\n"
			+ "  {\n"
			+ "    \"RecordedAtTime\": \"2015-09-19T21:56:46.188+02:00\",\n"
			+ "    \"MonitoringRef\": \"3010013\",\n"
			+ "    \"MonitoredVehicleJourney\": {\n"
			+ "      \"LineRef\": \"31\",\n"
			+ "      \"DirectionRef\": \"1\",\n"
			+ "      \"FramedVehicleJourneyRef\": {\n"
			+ "        \"DataFrameRef\": \"2015-09-19\",\n"
			+ "        \"DatedVehicleJourneyRef\": \"81708\"\n"
			+ "      },\n"
			+ "      \"PublishedLineName\": \"31\",\n"
			+ "      \"DirectionName\": \"1\",\n"
			+ "      \"OperatorRef\": \"Nobina\",\n"
			+ "      \"OriginName\": \"Snarøya\",\n"
			+ "      \"OriginRef\": \"2190030\",\n"
			+ "      \"DestinationRef\": 3011941,\n"
			+ "      \"DestinationName\": \"Grorud T\",\n"
			+ "      \"OriginAimedDepartureTime\": \"0001-01-01T00:00:00\",\n"
			+ "      \"DestinationAimedArrivalTime\": \"0001-01-01T00:00:00\",\n"
			+ "      \"Monitored\": true,\n"
			+ "      \"InCongestion\": false,\n"
			+ "      \"Delay\": \"PT294S\",\n"
			+ "      \"TrainBlockPart\": null,\n"
			+ "      \"BlockRef\": \"3122\",\n"
			+ "      \"VehicleRef\": \"741269\",\n"
			+ "      \"VehicleMode\": 0,\n"
			+ "      \"VehicleJourneyName\": \"\",\n"
			+ "      \"MonitoredCall\": {\n"
			+ "        \"VisitNumber\": 22,\n"
			+ "        \"VehicleAtStop\": false,\n"
			+ "        \"DestinationDisplay\": \"Grorud T\",\n"
			+ "        \"AimedArrivalTime\": \"2015-09-19T21:53:00+02:00\",\n"
			+ "        \"ExpectedArrivalTime\": \"2015-09-19T21:57:54+02:00\",\n"
			+ "        \"AimedDepartureTime\": \"2015-09-19T21:53:00+02:00\",\n"
			+ "        \"ExpectedDepartureTime\": \"2015-09-19T21:57:54+02:00\",\n"
			+ "        \"DeparturePlatformName\": \"D\"\n" + "      },\n"
			+ "      \"VehicleFeatureRef\": null\n" + "    },\n"
			+ "    \"Extensions\": {\n" + "      \"IsHub\": true,\n"
			+ "      \"OccupancyData\": {\n"
			+ "        \"OccupancyAvailable\": false,\n"
			+ "        \"OccupancyPercentage\": 0\n" + "      },\n"
			+ "      \"Deviations\": [],\n"
			+ "      \"LineColour\": \"E60000\"\n" + "    }\n" + "  }" + "]";

	@Test
	public void test() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();

		GetDepartures[] departures = objectMapper.readValue(JSON,
				GetDepartures[].class);

		assertThat(departures[0].getRecordedAtTime(),
				equalTo("2015-09-19T21:56:46.188+02:00"));
	}

}
