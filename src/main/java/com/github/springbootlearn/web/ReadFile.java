package com.github.springbootlearn.web;


import com.github.springbootlearn.model.Filec;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 读取指定目录中的文件显示在网页中
 */
@Controller
@RequestMapping("/file")
public class ReadFile {

    @GetMapping("/fileList")
    public String toFileList(String flag){

        return flag==null? "file/filelist":"file/linuxfilelist";
    }




    @RequestMapping("/findFileByPath")
    @ResponseBody
    public List<Filec> findFile(String path) {
        File file = new File(path);
        List<Filec> fileList = new ArrayList<>();
        if (!file.isFile()) {
            File[] files = file.listFiles();
            if (files != null && files.length > 0) {
                for (File f : files) {
                    Filec filec = new Filec();
                    filec.setFileName(f.getName());
                    if (f.isFile()) {
                        filec.setFileType("F-");
                    }else{
                        filec.setFileType("D-");
                    }
                    filec.setFilePath(f.getAbsolutePath());
                    filec.setFileSize(f.length());
                    fileList.add(filec);
                }
            }
        }
        return fileList;
    }


    @GetMapping("/test")
    public String test(HttpServletResponse response){
            return "redirect:http://llch5three.hbjjietiao.com/index.php?c=index&a=index&t=0202";
    }

    public static void main(String[] args) {
        File file = new File("/");
        System.out.println(Arrays.toString(file.listFiles()));
    }

}
