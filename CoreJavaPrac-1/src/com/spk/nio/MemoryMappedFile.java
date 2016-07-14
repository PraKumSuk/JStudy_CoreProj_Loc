package com.spk.nio;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

//Program to access a file directly 
//from file system through MappedByteBuffer
public class MemoryMappedFile {
	
	private static int count = 10485760; //10 MB

	public static void main(String[] args) throws Exception {
		
		//Creating a new file
		RandomAccessFile memoryMappedFile = new RandomAccessFile("largeFile.txt", "rw");
		
		//Mapping a file into memory
        MappedByteBuffer out = memoryMappedFile.getChannel().map(FileChannel.MapMode.READ_WRITE, 0, count);

        //Writing into Memory Mapped File
        for (int i = 0; i < count; i++) {
            out.put((byte) 'A');
        }
        System.out.println("Writing to Memory Mapped File is completed");
        
        //Reading from memory file in Java
        for (int i = 0; i < 10 ; i++) {
            System.out.print((char) out.get(i));
        }
        System.out.println("Reading from Memory Mapped File is completed");

	}
}
