package com.taso.polovniautomobili.files;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.taso.polovniautomobili.users.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.lang.Nullable;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "file")
public class File{
     @Id
     @GeneratedValue(strategy = GenerationType.AUTO)
     @Column(name = "fil_id")
     private long id;
     @Column(name = "fil_name")
     private String name;
     @Column(name = "fil_data")
     private byte[] data;
     @Column(name = "fil_size")
     private long size;
     @Column(name = "fil_contenttype")
     private String contentType;
     @Nullable
     @JsonIgnore
     private Long ads_id;
     @ManyToOne
     @JoinColumn(name = "usr_id")
     @Nullable
     @JsonIgnore
     private User user;



     public File(String name, byte[] data, long size,
                 String contentType, Long ads_id,
                 User user) {
          this.name = name;
          this.data = data;
          this.size = size;
          this.contentType = contentType;
          this.ads_id = ads_id;
          this.user = user;
     }

}
