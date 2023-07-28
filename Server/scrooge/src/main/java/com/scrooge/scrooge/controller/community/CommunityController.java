package com.scrooge.scrooge.controller.community;

import com.scrooge.scrooge.dto.SuccessResp;
import com.scrooge.scrooge.dto.communityDto.ArticleDto;
import com.scrooge.scrooge.service.community.CommunityService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;


@Tag(name="Community", description = "커뮤니티 API")
@RestController
@RequestMapping("/community")
@RequiredArgsConstructor
public class CommunityController {


    private final CommunityService communityService;

    @PostMapping(consumes="multipart/form-data")
    public ResponseEntity<?> createArticle(@RequestBody ArticleDto articleDto, @RequestParam MultipartFile img) {
         communityService.createArticle(articleDto, img);

        SuccessResp successResp = new SuccessResp(1);
        return new ResponseEntity<>(successResp, HttpStatus.OK);
    }

}
