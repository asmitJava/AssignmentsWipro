package Day15.NIO;



import java.io.IOException;
import java.nio.channels.FileChannel;
import java.nio.channels.ReadableByteChannel;
import java.nio.channels.WritableByteChannel;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class NIO {
    public static void main(String[] args) throws IOException {
        // Define the source and destination file paths
        String sourceFilePath = "c\\Desktop\\source.txt";
        String destinationFilePath = "c\\Deskto\\destination.txt";

        // Open the source file for reading
        ReadableByteChannel sourceChannel = FileChannel.open(Paths.get(sourceFilePath), StandardOpenOption.READ);

        // Open the destination file for writing
        WritableByteChannel destinationChannel = FileChannel.open(Paths.get(destinationFilePath), StandardOpenOption.CREATE, StandardOpenOption.WRITE);

        // Create a buffer to hold the data
        java.nio.ByteBuffer buffer = java.nio.ByteBuffer.allocate(1024);

        // Read from the source file and write to the destination file
        while (sourceChannel.read(buffer) != -1) {
            buffer.flip();
            destinationChannel.write(buffer);
            buffer.clear();
        }

        // Close the channels
        sourceChannel.close();
        destinationChannel.close();
    }
}