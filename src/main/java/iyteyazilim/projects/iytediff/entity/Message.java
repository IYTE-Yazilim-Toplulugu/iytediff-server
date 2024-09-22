package iyteyazilim.projects.iytediff.entity;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


}
