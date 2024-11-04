package com.example.demo7.controllers;

import com.example.demo7.configuration.IntegrConfig;
import com.example.demo7.models.Notes;
import com.example.demo7.services.Messaging;
import com.example.demo7.util.CustomFileWriter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping
public class NoteController {
//    public final CustomFileWriter customFileWriter = new CustomFileWriter();
    private final Messaging messaging;

    @PostMapping
    public ResponseEntity<Notes> addNote(@RequestBody Notes notes) {
        notes.setTime(LocalDateTime.now());
        messaging.writeDown(notes.getTitle() + ".txt", notes.toString());
//        customFileWriter.createFile(notes.getTitle());
//        customFileWriter.saveAll(notes.getId() + "\n"
//                + notes.getTitle() + "\n" + notes.getText() + notes.getTime(), notes.getTitle());
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
