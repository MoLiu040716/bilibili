package com.example.bilibili.util;

import java.io.File;
import java.io.IOException;
public class VideoOperation {

    public static void transcodeVideo(String inputFilePath, String outputFilePath) throws IOException {
        // 使用FFmpeg进行视频转码
        String ffmpegCommand = "ffmpeg -i " + inputFilePath + " -codec:v libx264 -codec:a aac " + outputFilePath + ".mp4";

        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command("bash", "-c", ffmpegCommand);

        try {
            Process process = processBuilder.start();
            process.waitFor();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            throw new IOException("视频转码失败");
        }
    }
}
