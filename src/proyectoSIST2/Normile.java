package proyectoSIST2;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Normile {
	  public static void main(String args[]) throws Exception {
	       
		 int[][] caca = read(new File ("imgEdit2.pgm"));
		 //346 x839  
		 System.out.println("uno "+caca[0][1] + " lenght "+caca.length +" lenght 2 "+caca[0].length);
		 
		
			    try {
			        BufferedWriter bw = new BufferedWriter(new FileWriter("caca.txt"));

			        for (int i = 0; i < caca.length; i++) {
			            for (int j = 0; j < caca[i].length; j++) {
			                    bw.write(caca[i][j] + ",");
			            }
			            bw.newLine();
			        }
			        bw.flush();
			    } catch (IOException e) {}
		
		 
//		 for (int i = 0; i < caca.length; i++) {
//			for (int j = 0; j < caca[0].length; j++) {
//				System.out.print(""+caca[i][j]+" ");
//				if (j%16==0) {
//					System.out.println();
//				}
//			}
//		}
		 
	    }
	    /**
	     * Magic number representing the binary PGM file type.
	     */
	    private static final String MAGIC = "P5";
	    /**
	     * Character indicating a comment.
	     */
	    private static final char COMMENT = '#';
	    /**
	     * The maximum gray value.
	     */
	    private static final int MAXVAL = 255;
	    public static int[][] read(final File file) throws IOException {
	        final BufferedInputStream stream = new BufferedInputStream(new FileInputStream(file));
	        try {
	            if (!next(stream).equals(MAGIC))
	                throw new IOException("File " + file + " is not a binary PGM image.");
	            final int col = Integer.parseInt(next(stream));
	            final int row = Integer.parseInt(next(stream));
	            final int max = Integer.parseInt(next(stream));
	            if (max < 0 || max > MAXVAL)
	                throw new IOException("The image's maximum gray value must be in range [0, " + MAXVAL + "].");
	            final int[][] image = new int[row][col];
	            for (int i = 0; i < row; ++i) {
	                for (int j = 0; j < col; ++j) {
	                    final int p = stream.read();
	                    if (p == -1)
	                        throw new IOException("Reached end-of-file prematurely.");
	                    else if (p < 0 || p > max)
	                        throw new IOException("Pixel value " + p + " outside of range [0, " + max + "].");
	                    image[i][j] = p;
	                }
	            }
	            return image;
	        } finally {
	            stream.close();
	        }
	    }
	    private static String next(final InputStream stream) throws IOException {
	        final List<Byte> bytes = new ArrayList<Byte>();
	        while (true) {
	            final int b = stream.read();

	            if (b != -1) {

	                final char c = (char) b;
	                if (c == COMMENT) {
	                    int d;
	                    do {
	                        d = stream.read();
	                    } while (d != -1 && d != '\n' && d != '\r');
	                } else if (!Character.isWhitespace(c)) {
	                    bytes.add((byte) b);
	                } else if (bytes.size() > 0) {
	                    break;
	                }

	            } else {
	                break;
	            }

	        }
	        final byte[] bytesArray = new byte[bytes.size()];
	        for (int i = 0; i < bytesArray.length; ++i)
	            bytesArray[i] = bytes.get(i);
	        return new String(bytesArray);
	    }
}
