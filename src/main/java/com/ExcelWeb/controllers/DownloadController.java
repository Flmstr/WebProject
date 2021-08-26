package com.ExcelWeb.controllers;

//import com.sun.org.apache.xpath.internal.operations.Mod;

import com.ExcelWeb.dao.UsersDao;
import com.ExcelWeb.models.Position;
import com.ExcelWeb.models.RecordArray;
import com.ExcelWeb.service.PositionService;
import com.ExcelWeb.service.RecordArrayService;

import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class DownloadController {

    @GetMapping("/download")
    public ResponseEntity<Resource> download(String param) throws IOException {

        Path path = Paths.get("src/main/java/com/ExcelWeb/files/test.7z");
        MediaType mediaType = MediaType.parseMediaType("application/zip");
        File file = new File(path.toString());
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        HttpHeaders headers = new HttpHeaders();
//        headers.set("test","Value-ResponseEntityBuilderWithHttpHeaders");
        headers.setContentType(mediaType);

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(mediaType)
                .body(resource);
    }
}