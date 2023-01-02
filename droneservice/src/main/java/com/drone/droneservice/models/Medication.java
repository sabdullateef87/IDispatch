package com.drone.droneservice.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name="medications")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Medication {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name="name")
  private String name;

  @Column(name="weight", precision = 2, scale = 4)
  private double weight;

  @Column(name="code")
  private String code;

  @Column(name="image_url")
  private String url;

//  @Column(name = "droneId")
//  private int droneId;

  @ManyToOne(fetch = FetchType.LAZY , targetEntity = Drone.class, cascade = CascadeType.ALL)
  @JoinColumn(name="drone_id", nullable = false)
  @JsonIgnore
  @ToString.Exclude
  private Drone drone;
}
