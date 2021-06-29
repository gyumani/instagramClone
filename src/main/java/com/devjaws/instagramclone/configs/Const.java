package com.devjaws.instagramclone.configs;

import java.nio.file.Paths;

public class Const {
    static String absolutePath= Paths.get("").toAbsolutePath().toString()+"/src/main/resources";

    public static String PATH_PROFILEPICTURE=absolutePath+"/data/ProfilePicture";
}
