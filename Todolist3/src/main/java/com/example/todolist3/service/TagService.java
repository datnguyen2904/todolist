package com.example.todolist3.service;

import com.example.todolist3.model.Phancong;
import com.example.todolist3.model.Tag;
import com.example.todolist3.repository.dbcontext.DBcontext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TagService implements ITag{
    @Autowired
    private DBcontext dBcontext;

    @Autowired
    private PhanCongService phanCongService;

    @Override
    public List<Tag> getAllTag() {
//        List<Tag> tags =  dBcontext.tagRepo.findAll();
//        List<Phancong> phancongs =  phanCongService.getAll();
//        for (int i = 0; i< tags.size();i++){
//            int taskID = tags.get(i).getTagId();
//            tags.get(i).setPhancongs(phancongs.stream().filter(x->x.getTaskId() == taskID).toList());
//        }
//        return tags;
        return  dBcontext.tagRepo.findAll();

    }
}
