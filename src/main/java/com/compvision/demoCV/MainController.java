package com.compvision.demoCV;


import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.opencv.objdetect.CascadeClassifier;

import java.util.ArrayList;
import java.util.List;

public class MainController {

    public static void testFunctionality(){
        System.loadLibrary(Core.NATIVE_LIBRARY_NAME);

        Mat image = Imgcodecs.imread("D:/TestOpenCV/Test1.jpg");
        Mat grayImage = new Mat();
        Imgproc.cvtColor(image, grayImage, Imgproc.COLOR_BGR2GRAY);

        CascadeClassifier faceCascade = new CascadeClassifier("src/haarcascades/haarcascade_frontalface_alt.xml");
        MatOfRect faces = new MatOfRect();
        faceCascade.detectMultiScale(grayImage, faces);

        List<Rect> faceList = new ArrayList<>(faces.toList());
        for (Rect face : faceList) {
            Imgproc.rectangle(image, face, new Scalar(0, 255, 0), 3);
//            Rect rectCrop = new Rect(face.x, face.y, face.width, face.height);
//            Mat image_roi = new Mat(image,rectCrop);
//            Imgcodecs.imwrite("D:/TestOpenCV/detected_faces1.jpg", image_roi);
        }

        Imgcodecs.imwrite("D:/TestOpenCV/detected_faces.jpg", image);
    }

}
