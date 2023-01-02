package com.drone.droneservice.models;

import com.drone.droneservice.utils.Constants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="drones")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Drone {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "drone_id", nullable = false)
  private Long drone_id;

  @Column(name = "serial_number", unique = true, columnDefinition = "varchar(100)")
  private String serialNumber;

  @Column(name = "model")
  @Enumerated(EnumType.STRING)
  private Constants.Model model;

  @Column(name="weight_limit")
  private long weightLimit;

  @Column(name="battery_percentage", precision = 2, scale = 4)
  private double batteryPercentage;

  @Column(name = "state")
  @Enumerated(EnumType.STRING)
  private Constants.State state;

  @OneToMany(mappedBy="drone" , fetch=FetchType.LAZY, cascade = CascadeType.ALL)
  @ToString.Exclude
  private List<Medication> medications = new ArrayList<>();
}
