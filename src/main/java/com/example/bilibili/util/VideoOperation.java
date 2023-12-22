package com.example.bilibili.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class VideoOperation {

    public static void transcodeVideo(String inputFilePath, String outputFilePath) throws IOException {
        String ffmpegCommand = "ffmpeg";
        List<String> command = Arrays.asList(
                ffmpegCommand, "-i", inputFilePath, "-codec:v", "libx264", "-codec:a", "aac", outputFilePath
        );

        System.out.println(command);
        ProcessBuilder processBuilder = new ProcessBuilder();
        processBuilder.command(command);
        processBuilder.redirectErrorStream(true); // 合并标准输出和错误输出

        try {
            Process process = processBuilder.start();
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                // 在这里处理 FFmpeg 输出的信息，例如打印日志等
                System.out.println(line);
            }

            // 等待进程完成
            int exitCode = process.waitFor();
            System.out.println("FFmpeg process exited with code " + exitCode);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
            throw new IOException("视频转码失败");
        }
    }
    public static int getVideoDuration(String filePath) {
        String ffprobeCommand = "ffprobe";
        String[] command = {
                ffprobeCommand, "-v", "error", "-show_entries", "format=duration",
                "-of", "default=noprint_wrappers=1:nokey=1", filePath
        };

        try {
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            Process process = processBuilder.start();

            // 读取输出信息
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line;
            if ((line = reader.readLine()) != null) {
                double durationInSeconds = Double.parseDouble(line.trim());
                return (int) Math.round(durationInSeconds);
            }
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return -1; // 返回 -1 表示获取时长失败
    }



}
//ffmpeg -i E:\VIDEO\petal_20231221_220111.mp4 -codec:v libx264 -codec:a aac E:\VIDEO\output\petal_20231221_220111.mp4