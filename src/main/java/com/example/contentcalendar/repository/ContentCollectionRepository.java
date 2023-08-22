package com.example.contentcalendar.repository;

import com.example.contentcalendar.model.Content;
import com.example.contentcalendar.model.Status;
import com.example.contentcalendar.model.Type;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ContentCollectionRepository {

    private final List<Content> contentList = new ArrayList<>();

    public ContentCollectionRepository(){

    }

    public List<Content> findAll() {
        return contentList;
    }

    public Optional<Content> findById(Integer id) {
        return contentList.stream().filter(c -> c.id().equals(id)).findFirst();
    }

    public void save(Content content) {
        contentList.add(content);
    }

    @PostConstruct
    private void init() {
        Content content1 = new Content(1,
                "My First Blog Post",
                "My first blog post",
                Status.IDEA,
                Type.ARTICLE,
                LocalDateTime.now(),
                null,
                "");
        Content content2 = new Content(2,
                "My Secong Blog Post",
                "My second blog post",
                Status.IN_PROGRESS,
                Type.CONFERENCE_TALK,
                LocalDateTime.now(),
                null,
                "");
        Content content3 = new Content(3,
                "My Third Blog Post",
                "My third blog post",
                Status.COMPLETED,
                Type.COURSE,
                LocalDateTime.now(),
                null,
                "");
        Content content4 = new Content(4,
                "My Forth Blog Post",
                "My forth blog post",
                Status.PUBLISHED,
                Type.VIDEO,
                LocalDateTime.now(),
                null,
                "");

        contentList.add(content1);
        contentList.add(content2);
        contentList.add(content3);
        contentList.add(content4);
    }
}
