package com.binarybuilders.bynb_user_service.messaging;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.ZonedDateTime;

@Getter
@Setter
public class DangerMessage implements Serializable {
    private String name;
    private double accuracy;
    private DangerType dangerType;
    private ZonedDateTime timeCreated;
    private ZonedDateTime duration;
    private Long userId;
    private GeoLocation dangerLocation;
    private Double dangerLevel;
    private String description;
    private String additionalInformation;
}
