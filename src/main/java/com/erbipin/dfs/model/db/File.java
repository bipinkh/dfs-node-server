package com.erbipin.dfs.model.db;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * @author bipin khatiwada
 * github.com/bipinkh
 */
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class File {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JsonBackReference
    @PrimaryKeyJoinColumn
    User user;

    private String fileName;        // file name

    private String fileExtension;   // file extension

    private String fileHash;        // file hash

    private double fileSize;        // file size

    private String storedLocation;  // location to local container or database of file

    private Timestamp uploadedDate;

}
