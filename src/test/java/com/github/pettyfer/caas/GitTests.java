package com.github.pettyfer.caas;

import lombok.SneakyThrows;
import org.eclipse.jgit.api.Git;
import org.junit.jupiter.api.Test;

import java.io.File;

public class GitTests {

    @Test
    @SneakyThrows
    public void gitCloneTest() {
        File file = new File("D:/CAAS/workspace/demo");
        // 清理目录
        if(file.exists()){
            deleteFolder(file);
        }
        Git git = Git.cloneRepository()
                .setURI("http://gitlab.ggjs.sinobest.cn/liuyang03813/auto-build-examples.git")
                .setBranch("master")
                .setDirectory(file)
                .call();
    }


    public static void deleteFolder(File file){
        if(file.isFile() || file.list().length==0){
            file.delete();
        }else{
            File[] files = file.listFiles();
            for(int i=0;i<files.length;i++){
                deleteFolder(files[i]);
                files[i].delete();
            }
        }
    }


}
