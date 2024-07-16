package com.taxi.framework.dispatch.dao;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "dispatch")
public class DispatchDao {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dispatch_id;

    private long userId;
    private float user_longitude;
    private float user_latitude;
    private float destLongitude;
    private float destLatitude;
    private long driverId;
    @Id
    private Long id;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
