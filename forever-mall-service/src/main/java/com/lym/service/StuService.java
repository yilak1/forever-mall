package com.lym.service;

import com.lym.pojo.Stu;
import org.springframework.stereotype.Service;

@Service
public interface StuService {
    public Stu getStuInfo(int id);

    public void saveStu();

    public void updateStu(int id);

    public void deleteStu(int id);

    public void saveParent();
    public void saveChildren();
}
